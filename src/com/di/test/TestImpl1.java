package com.di.test;

public class TestImpl1 implements Test {

	private int su1;
	private int su2;
	
	public TestImpl1() { //기본생성자
		this.su1 = 10;
		this.su2 = 20;
	}

	public TestImpl1(int su1, int su2) { //생성자 오버로딩
		this.su1 = su1;
		this.su2 = su2;
	}
	
	@Override
	public String result() {
		String str = String.format("%d+%d=%d", su1,su2,su1+su2);
		return str;
	}

	
	
}
