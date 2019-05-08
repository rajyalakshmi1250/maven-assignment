package com.capgemini.spring.provider;
public class HelloWorldMessageProvider implements MessageProvider {
 @Override
 public String getMessage() {
 return "Hello World!";
 }
}