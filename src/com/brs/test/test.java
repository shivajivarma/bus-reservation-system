package com.brs.test;


import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class test {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
	     
		while(N==1){
			@SuppressWarnings("resource")
			ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
			
			//Triangle t1 = (Triangle) context.getBean("try-alias");
			//Triangle t2 = (Triangle) context.getBean("try-alias");
			
			//t1.draw();
			
			//System.out.println(t1==t2);
			
			N = in.nextInt();
		}
		in.close();
	}

}
