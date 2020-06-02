package com.chahatg.day13.spring.xmlbased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
       MessageInterface messenger = context.getBean(MessageInterfaceImpl.class);
       messenger.printMsg("Hello World");
       
    }
}
