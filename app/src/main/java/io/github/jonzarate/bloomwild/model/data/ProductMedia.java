package io.github.jonzarate.bloomwild.model.data;

import com.google.gson.annotations.SerializedName;

public class ProductMedia {

    public ProductMedia(String url) {
        this.url = url;
    }

    @SerializedName("url")
    private String url;

    public String getUrl() {
        return url;
    }
}
