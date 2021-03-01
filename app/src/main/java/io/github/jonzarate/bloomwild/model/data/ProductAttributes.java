package io.github.jonzarate.bloomwild.model.data;

import com.google.gson.annotations.SerializedName;

public class ProductAttributes {
    @SerializedName("name")
    private String name;

    @SerializedName("currency")
    private String currency;

    @SerializedName("price_data")
    private ProductPrice[] prices;

    @SerializedName("rating_average")
    private float ratingAverage;

    @SerializedName("rating_count")
    private float ratingCount;


    public String getName() {
        return name;
    }

    public String getCurrency() {
        return currency;
    }

    public ProductPrice[] getPrices() {
        return prices;
    }

    public float getRatingAverage() {
        return ratingAverage;
    }

    public float getRatingCount() {
        return ratingCount;
    }
}
