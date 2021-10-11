package com.example.sfgdi.config;

import com.example.sfgdi.services.ConstructorGreetingService;
import com.example.sfgdi.services.PropertyInjectedGreetingService;
import com.example.sfgdi.services.SetterInjectedGreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreetingServiceConfig {

    @Bean
    ConstructorGreetingService constructorGreetingService(){
        return new ConstructorGreetingService();
    }
    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }
    @Bean
   SetterInjectedGreetingService setterInjectedGreetingService(){
        return new SetterInjectedGreetingService();
   }

}
