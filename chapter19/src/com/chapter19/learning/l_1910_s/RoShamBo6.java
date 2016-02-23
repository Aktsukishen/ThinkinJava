package com.chapter19.learning.l_1910_s;

import static com.chapter19.learning.l_1910_s.Outcome.*;

public enum RoShamBo6 implements Competitor<RoShamBo6>{
	PAPER,SCISSOR,ROCK;
	
	private static Outcome[][] table={
			{DRAW,LOSE,WIN},//PAPER
			{WIN,DRAW,LOSE},//SCISSOR
			{LOSE,WIN,DRAW}//ROCK
	};

	@Override
	public Outcome compete(RoShamBo6 it) {
		return table[this.ordinal()][it.ordinal()];
	}

	public static void main(String[]args){
		RoShamBo.play(RoShamBo6.class, 20);
	}
}
