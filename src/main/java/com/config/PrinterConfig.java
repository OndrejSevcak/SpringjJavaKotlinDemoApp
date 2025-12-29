package com.config;

import com.services.BluePrinter;
import com.services.ColourPrinter;
import com.services.RedPrinter;
import com.services.impl.CzechBluePrinter;
import com.services.impl.EnglishBluePrinter;
import com.services.impl.EnglishRedPrinter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrinterConfig {

    @Bean
    public BluePrinter bluePrinter() {
        return new EnglishBluePrinter();
    }

    @Bean
    public BluePrinter czechBluePrinter() {
        return new CzechBluePrinter();
    }

    @Bean
    public RedPrinter redPrinter() {
        return new EnglishRedPrinter();
    }

    @Bean
    public ColourPrinter colourPrinter(BluePrinter bluePrinter, RedPrinter redPrinter) {
        return new com.services.impl.ColourPrinterService(bluePrinter, redPrinter);
    }

    //Beans are implicitly singleton scoped
    //there are two different beans of type BluePrinter
    //when injecting BluePrinter, you need to use @Qualifier to specify which one
}
