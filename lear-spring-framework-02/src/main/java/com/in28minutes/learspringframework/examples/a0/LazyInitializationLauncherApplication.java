package com.in28minutes.learspringframework.examples.a0;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {
	
	@Component 
	class ClassA {
		
	}
	
	@Component
	@Lazy
	class ClassB {
		private ClassA classA;
		
		public ClassB(ClassA classA) {
			System.out.println("Some Initalizaion logic");
			this.classA = classA;
		}
		
		public void doSomething() {
			System.out.println("Do something");
		}
	}
	
	public static void main(String[] args) {
		
		try(var context = 
				new AnnotationConfigApplicationContext
					(LazyInitializationLauncherApplication.class)) {
			
			System.out.println("Initalization of context is completed");
			
			context.getBean(ClassB.class).doSomething();
		}

	}

}
