package com.example.sfgdi.services;




public class PrimaryGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello world --- Primary";
    }
}
