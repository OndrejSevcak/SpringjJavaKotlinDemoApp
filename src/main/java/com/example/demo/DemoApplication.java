package com.example.demo;

import com.services.ColourPrinter;
import com.services.impl.ColourPrinterService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import com.example.kotlin.utilityKtln;

@SpringBootApplication
public class DemoApplication {

    private final ColourPrinter printerService;

    public DemoApplication(ColourPrinter printerService) {
        this.printerService = printerService;
    }

    public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx){
        return args -> {
            System.out.println("Lets inspect the beans provided by spring framework");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames){
                System.out.println(beanName);
            }

            int numberFromKotlin = utilityKtln.Companion.getNumber();
            System.out.println("A number from KOTLIN class: " + numberFromKotlin);

            //final ColourPrinter printer = new ColourPrinterService();
            System.out.println("ColourPrinter output: " + printerService.printColour());
        };
    }


}
