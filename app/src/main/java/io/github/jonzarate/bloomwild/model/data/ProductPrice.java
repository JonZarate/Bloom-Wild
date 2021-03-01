package io.github.jonzarate.bloomwild.model.data;

import com.google.gson.annotations.SerializedName;

public class ProductPrice {

    @SerializedName("price_pennies")
    private int pricePennies;

    @SerializedName("quantity")
    private int quantity;


    public int getPricePennies() {
        return pricePennies;
    }

    public int getQuantity() {
        return quantity;
    }
}
