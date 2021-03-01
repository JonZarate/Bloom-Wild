package io.github.jonzarate.bloomwild.model.data;

import com.google.gson.annotations.SerializedName;

public class ProductInfo {

    @SerializedName("attributes")
    private ProductAttributes attributes;

    public ProductAttributes getAttributes() {
        return attributes;
    }
}
