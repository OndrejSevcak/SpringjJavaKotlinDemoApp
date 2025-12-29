package com.services.impl;

import com.services.BluePrinter;
import com.services.ColourPrinter;
import com.services.RedPrinter;

public class ColourPrinterService implements ColourPrinter {

    private final BluePrinter bluePrinter;
    private final RedPrinter redPrinter;

    //no DI
    /*public ColourPrinterService() {
        this.bluePrinter = new EnglishBluePrinter();
        this.redPrinter = new EnglishRedPrinter();
    }*/

    //using DI and configured Beans
    public ColourPrinterService(BluePrinter bluePrinter, RedPrinter redPrinter){
        this.bluePrinter = bluePrinter;
        this.redPrinter = redPrinter;
    }

    @Override
    public String printColour() {
        return String.join(",", bluePrinter.print(), redPrinter.print());
    }
}
