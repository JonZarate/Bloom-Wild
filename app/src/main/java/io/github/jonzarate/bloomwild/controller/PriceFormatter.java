package io.github.jonzarate.bloomwild.controller;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class PriceFormatter {

    private DecimalFormat format = new DecimalFormat("0.##");

    public PriceFormatter () {
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
        symbols.setDecimalSeparator('.');
        format.setDecimalFormatSymbols(symbols);
    }

    public String formatPrice(int pricePennies, String currency){
        float priceConversion = pricePennies / 100F;
        String price = format.format(priceConversion);

        String fullPrice = price + " " + currency;
        if (currency.equalsIgnoreCase("GBP"))
            fullPrice = "£" + price;
        else if (currency.equalsIgnoreCase("EUR"))
            fullPrice = price + "€";
        else if (currency.equalsIgnoreCase("USD"))
            fullPrice = price + "$";

        return fullPrice;
    }

}
