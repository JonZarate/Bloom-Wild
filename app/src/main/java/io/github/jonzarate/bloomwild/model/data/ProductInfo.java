package io.github.jonzarate.bloomwild.model.data;

import com.google.gson.annotations.SerializedName;

public class ProductInfo {

    public ProductInfo(ProductAttributes attributes) {
        this.attributes = attributes;
    }

    @SerializedName("attributes")
    private ProductAttributes attributes;

    public ProductAttributes getAttributes() {
        return attributes;
    }
}
