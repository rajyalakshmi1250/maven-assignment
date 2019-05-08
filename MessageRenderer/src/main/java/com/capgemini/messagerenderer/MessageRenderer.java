package com.capgemini.spring.renderer;
import com.capgemini.spring.provider.*;

    public class MessageRenderer {

          private MessageProvider provider;
          public void  setMessageProvider(MessageProvider provider){
          this.provider = provider;
     }
     public void render(){
          
           System.out.println(provider.getMessage());
 
     }
}