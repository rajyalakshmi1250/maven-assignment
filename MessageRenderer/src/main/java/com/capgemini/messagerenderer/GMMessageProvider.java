package com.capgemini.spring.provider;
public class GMMessageProvider implements MessageProvider {

 @Override
 public String getMessage() {
 return "Good Morning!";
 }
}