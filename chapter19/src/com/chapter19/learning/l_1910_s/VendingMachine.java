package com.chapter19.learning.l_1910_s;

import static com.chapter19.learning.l_1910_s.Input.ABORT_TRANSACTION;
import static com.chapter19.learning.l_1910_s.Input.CHIPS;
import static com.chapter19.learning.l_1910_s.Input.DIME;
import static com.chapter19.learning.l_1910_s.Input.DOLLAR;
import static com.chapter19.learning.l_1910_s.Input.NICKEL;
import static com.chapter19.learning.l_1910_s.Input.QUARTER;
import static com.chapter19.learning.l_1910_s.Input.SOAP;
import static com.chapter19.learning.l_1910_s.Input.SODA;
import static com.chapter19.learning.l_1910_s.Input.STOP;
import static com.chapter19.learning.l_1910_s.Input.TOOTHPASTE;

import java.util.EnumMap;

enum Category{
	MONEY(NICKEL,DIME,QUARTER,DOLLAR),
	ITEM_SELECTION(TOOTHPASTE,CHIPS,SODA,SOAP),
	QUIT_TRANSACTION(ABORT_TRANSACTION),
	SHUT_DOWN(STOP);
	private Input[] values;
	Category(Input...types){
		values=types;
	}
	private static EnumMap<Input,Category> categories=new EnumMap<Input,Category>(Input.class);
	static{
		for(Category c:Category.class.getEnumConstants()){
			for(Input type:c.values){
				categories.put(type, c);
			}
		}
	}
	public static Category categories(Input input){
		return categories.get(input);
	}
}

public class VendingMachine {
	private static State state=State.RESTING;
	private static int amount=0;
	private static Input selection=null;
	enum StateDuration{TRANSIENT};
	enum State{
		RESTING{
			void next(Input input){
				switch(Category.categories(input)){
				case MONEY:
					amount+=input.amount();
					state=ADDING_MONEY;
					break;
				case SHUT_DOWN:
					state=TERMINAL;
				default:
				}
			}
		},
		ADDING_MONEY{
			void next(Input input){
				switch(Category.categories(input)){
				case MONEY:
					amount+=input.amount();
					break;
				case ITEM_SELECTION:
					selection=input;
					if(amount<selection.amount()){
						System.out.println("Insufficient money for "+selection);
					}else{
						state=DISPENSING;
					}
					break;
				case QUIT_TRANSACTION:
					state=GIVING_CHANGE;
					break;
				case SHUT_DOWN:
					state=TERMINAL;
					break;
				}
			}
		},
		DISPENSING{
			void next(Input input){
				System.out.println("here is your "+selection);
				amount-=selection.amount();
				state=GIVING_CHANGE;
			}
		},
		GIVING_CHANGE{
			void next(Input input){
				if(amount>0){
					System.out.println("Your change:"+amount);
					amount=0;
				}
				state=RESTING;
			}
		},
		TERMINAL{
			void output(){
				System.out.println("Halted:");
			}
		}
		;
		private boolean isTransient=false;
		State(){}
		State(StateDuration trans){
			isTransient=true;
		}
		void next(Input input){
			throw new RuntimeException("Only call next(Input input) for non-transisent states");
		}
		void next(){
			throw new RuntimeException("Only call next(Input input) for transisent states");
		}
		void output(){
			System.out.println("output:"+amount);
		}
	}
	
	static void run(Generator<Input> gen){
		while(state!=State.TERMINAL){
			Input input=gen.next();
			System.out.println("state:"+state+" input:"+input);
			state.next(input);
			while(state.isTransient){
				state.next();
			}
			state.output();
		}
	}
	
	public static void main(String[] args) {
		Generator<Input> gen=new RandomInputGenerator();
		run(gen);
	}

}

interface Generator<T>{
	T next();
}

class RandomInputGenerator implements Generator<Input>{

	@Override
	public Input next() {
		return Input.randomSelection();
	}
	
}
