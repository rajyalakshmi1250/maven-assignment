
package com.capgemini.spring.test;
import com.capgemini.spring.renderer.*;
import com.capgemini.spring.provider.*;


import org.springframework.context.*;
import org.springframework.context.support.*;


class Test{
 public static void main(String args[]) {
     ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
     System.out.println("wow its working");
     MessageRenderer renderer =(MessageRenderer)context.getBean("renderer");
     renderer.render();
 }
}