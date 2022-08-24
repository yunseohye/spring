package com.di.test;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ResultMain {

	public static void main(String[] args) {
		
		String path = "com/di/test/applicationContext.xml";
		
		Resource res = new ClassPathResource(path);
		
		//spring의 container를 생성한다.
		//스프링의 언어를 번역할 수 있도록 하는 것임
		BeanFactory factory = new XmlBeanFactory(res);
		
		//spring의 container에서 bean 객체를 호출함
		//bean을 담기위한 그릇
		TestService ob = (TestService)factory.getBean("testService");
		
		System.out.println(ob.getValue());
		
		/* 이전에 하던 방식
		Test ob1 = new TestImpl1();
		Test ob2 = new TestImpl2();
		
		System.out.println(ob1.result()); 
		System.out.println(ob2.result()); 
		
		or
		
		Test ob;
		ob = new TestImpl1();
		System.out.println(ob.result()); 
		
		ob = new TestImpl2();
		System.out.println(ob.result()); 
		*/
		
	}

}
