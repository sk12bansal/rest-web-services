package com.in28minutes.rest.webservices.restwebservices.helloworld;

import com.in28minutes.rest.webservices.restwebservices.helloworld.HelloWorldBean;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

//Controller
@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    //GET
    //URI - /hello-world
    //method - "Hello -World"

    //@RequestMapping(method = RequestMethod.GET,path="/hello-world")
    @GetMapping(path="/hello-world")
    public String helloWorld(){
        return "Hello-World";
    }

    //hello-world-bean
    @GetMapping(path="/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello-World");
    }

    ///hello-world/path-variable/in28minutes
    @GetMapping(path="/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello-World, %s",name));
    }

    @GetMapping(path="/hello-world-internationalized")
    public String helloWorldInternationalized(){
        return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
    }
}
