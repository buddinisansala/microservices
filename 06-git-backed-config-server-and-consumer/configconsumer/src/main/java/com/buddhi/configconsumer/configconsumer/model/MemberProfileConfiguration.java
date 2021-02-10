package com.buddhi.configconsumer.configconsumer.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class MemberProfileConfiguration {


    @Autowired
    Environment environment;


    public String getDefaultModel(){
        return environment.getProperty("book.default.type");
    }
    public String getMinBarrowPeriod(){
        return environment.getProperty("member.barrow.min");
    }

}
