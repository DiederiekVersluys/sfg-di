package com.example.sfgdi;

import com.example.sfgdi.config.ConstructorConfig;
import com.example.sfgdi.config.SfgConfiguration;
import com.example.sfgdi.controllers.*;
import com.example.sfgdi.datasource.FakeDataSource;
import com.example.sfgdi.services.PrototypeBean;
import com.example.sfgdi.services.SingletonBean;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;


//@ComponentScan(basePackages = {"com.example.sfgdi", "com.didericus.pets"})

@SpringBootApplication
public class SfgDiApplication {

    public static void main(String[] args) {
        ApplicationContext ctx =
        SpringApplication.run(SfgDiApplication.class, args);


        PetController petController = ctx.getBean("petController", PetController.class);
        System.out.println("--- The Best Pet is ---");
        System.out.println(petController.whichPetIsTheBest());


        I18nController i18nController = (I18nController) ctx.getBean("i18nController");
        System.out.println("------ Spanish Profile -----");
        System.out.println(i18nController.sayHello());


        MyController myController = (MyController) ctx.getBean("myController");



        System.out.println("-------Primary------");

        System.out.println(myController.sayHello());

        System.out.println("--------Property--------");
        PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
        System.out.println(propertyInjectedController.getGreeting());

        System.out.println("------Setter-------");
        SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
        System.out.println(setterInjectedController.getGreeting());

        System.out.println("-----Constructor------");
        ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
        System.out.println(constructorInjectedController.getGreeting());

        System.out.println("------Bean Scopes------");
        SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
        System.out.println(singletonBean1.getMyScope());
        SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
        System.out.println(singletonBean2.getMyScope());

        PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
        System.out.println(prototypeBean1.getMyScope());
        PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
        System.out.println(prototypeBean2.getMyScope());

        System.out.println("-------Fake Data Output----------");

        FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
        System.out.println(fakeDataSource.getUserName());
        System.out.println(fakeDataSource.getPassword());
        System.out.println(fakeDataSource.getJbdcurl());

        System.out.println("---------Config Props Bean---------");

        SfgConfiguration sfgConfiguration = ctx.getBean(SfgConfiguration.class);
        System.out.println(sfgConfiguration.getUserName());
        System.out.println(sfgConfiguration.getPassword());
        System.out.println(sfgConfiguration.getJbdcurl());


        System.out.println("--------------");
        ConstructorConfig constructorConfig = ctx.getBean(ConstructorConfig.class);
        System.out.println(constructorConfig.getUserName());
        System.out.println(constructorConfig.getPassword());
        System.out.println(constructorConfig.getJdbcurl());
        
    }

}
