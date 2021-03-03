package io.github.jonzarate.bloomwild.model.data;

import com.google.gson.annotations.SerializedName;

public class ProductsResponse {

    public ProductsResponse(ProductInfo[] data){
        this.data = data;
    }

    @SerializedName("data")
    public ProductInfo[] data;

}
