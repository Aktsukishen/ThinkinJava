package com.chapter05.learning.l_0509_s;

public class Burrito {

	Speciness degree;

	public Burrito(Speciness degree) {
		this.degree = degree;
	}

	public void describe() {
		System.out.print("This burrito is ");
		switch (degree) {
		case NOT://��Ȼ����ֱ��ʹ��NOT,������ҪSpeciness��NOT
			System.out.println("not spicy at all.");
			break;
		case MILD:
		case MEDIUM:
			System.out.println("a little hot.");
			break;
		case FLAMING:
		default:
			System.out.println("maybe too hot.");
		}
	}

	public static void main(String[] args) {
		Burrito plain=new Burrito(Speciness.NOT);
		plain.describe();
	}

}
