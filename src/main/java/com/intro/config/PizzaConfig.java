package com.intro.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "pizza")  //this prefix will be used in application.properties or application.yml (example: pizza.sauce=tomato)
public class PizzaConfig {
    private String sauce;
    private String topping;
    private String size;

    //no args constructor
    public PizzaConfig() {}

    //all args constructor
    public PizzaConfig(String sauce, String topping, String size) {
        this.sauce = sauce;
        this.topping = topping;
        this.size = size;
    }

    //getters and setters
    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
