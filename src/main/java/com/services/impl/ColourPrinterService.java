package com.services.impl;

import com.services.BluePrinter;
import com.services.ColourPrinter;

public class ColourPrinterService implements ColourPrinter {

    private final BluePrinter bluePrinter;
    private final BluePrinter bluePrinterCzech;

    public ColourPrinterService() {
        this.bluePrinter = new EnglishBluePrinter();
        this.bluePrinterCzech = new CzechBluePrinter();
    }

    @Override
    public String printColour() {
        return String.join(",", bluePrinter.print(), bluePrinterCzech.print());
    }
}
