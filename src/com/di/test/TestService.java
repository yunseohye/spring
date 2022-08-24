package com.di.test;

public class TestService {

	//오버로딩 생성자로 인한 의존성 주입이 생김
	private Test test;
	
	public TestService() { //기본생성자
	}
	
	//Dependency Injection(DI : 의존성 주입)
	public TestService(Test test) { //오버로딩 생성자
		//생성자 의존성 주입
		this.test = test;
	}
	
	public void setTest(Test test) { //setter라는 method를 사용함
		//메소드 의존성 주입
		this.test = test;
	}
	
	public String getValue() {
		return test.result();
	}
}
