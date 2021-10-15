package com.example.sfgdi.config;

import com.didericus.pets.PetService;
import com.didericus.pets.PetServiceFactory;
import com.example.sfgdi.datasource.FakeDataSource;
import com.example.sfgdi.repository.EnglishGreetingRepository;
import com.example.sfgdi.repository.EnglishGreetingRepositoryImpl;
import com.example.sfgdi.services.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.*;



@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {

    @Bean
    FakeDataSource fakeDataSource(@Value("${com.username}") String username,
                                  @Value("${com.password}")String password,
                                  @Value("${com.jdbcurl}") String jdbcurl){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUserName(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJbdcurl(jdbcurl);

        return fakeDataSource;
    }

    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("dog");

    }

    @Profile("cat")
    @Bean
    PetService catService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("cat");
    }

    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }



    @Profile({"ES", "default"})
    @Bean("i18nService")
    I18nSpanishGreetingService i18nSpanishGreetingService(){
        return new I18nSpanishGreetingService();
    }
    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile("EN")
    @Bean
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository){
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }



    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
    }

//    @Bean
//    ConstructorGreetingService constructorGreetingService(){
//        return new ConstructorGreetingService();
//    }
    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }
    @Bean
   SetterInjectedGreetingService setterInjectedGreetingService(){
        return new SetterInjectedGreetingService();
   }

}
