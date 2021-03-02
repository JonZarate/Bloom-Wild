package io.github.jonzarate.bloomwild.controller;

import org.junit.Test;

import static org.junit.Assert.*;

public class PriceFormatterTest {

    @Test
    public void roundPriceHasNoDecimals(){
        int pricePennies = 1000;
        String currency = "GBP";

        String expected = "£10";

        String outcome = new PriceFormatter().formatPrice(pricePennies, currency);

        assertEquals(expected, outcome);
    }

    @Test
    public void priceHasDecimals(){
        int pricePennies = 1234;
        String currency = "GBP";

        String expected = "£12.34";

        String outcome = new PriceFormatter().formatPrice(pricePennies, currency);

        assertEquals(expected, outcome);
    }

    @Test
    public void poundCurrencyHasCorrectSymbol(){
        int pricePennies = 1000;
        String currency = "GBP";

        String expected = "£10";

        String outcome = new PriceFormatter().formatPrice(pricePennies, currency);

        assertEquals(expected, outcome);
    }

    @Test
    public void euroCurrencyHasCorrectSymbol(){
        int pricePennies = 1000;
        String currency = "EUR";

        String expected = "10€";

        String outcome = new PriceFormatter().formatPrice(pricePennies, currency);

        assertEquals(expected, outcome);
    }

    @Test
    public void usdCurrencyHasCorrectSymbol(){
        int pricePennies = 1000;
        String currency = "USD";

        String expected = "10$";

        String outcome = new PriceFormatter().formatPrice(pricePennies, currency);

        assertEquals(expected, outcome);
    }

    @Test
    public void unknownPriceIsAppended(){
        int pricePennies = 1000;
        String currency = "XYZ";

        String expected = "10 XYZ";

        String outcome = new PriceFormatter().formatPrice(pricePennies, currency);

        assertEquals(expected, outcome);
    }

}