package io.github.jonzarate.bloomwild.model.data;

import com.google.gson.annotations.SerializedName;

public class ProductAttributes {
    @SerializedName("name")
    private String name;

    @SerializedName("currency")
    private String currency;

    @SerializedName("price_data")
    private ProductPrice[] prices;
    private String sanitisedPrice;

    @SerializedName("media")
    private ProductMedia[] media;
    private ProductMedia[] sanitisedMedia;

    @SerializedName("rating_average")
    private float ratingAverage;

    @SerializedName("rating_count")
    private float ratingCount;

    @SerializedName("collection_name")
    private String collectionName;


    private String processedImageUrl;

    public String getName() {
        return name;
    }

    public String getCurrency() {
        return currency;
    }

    public ProductPrice[] getPrices() {
        return prices;
    }

    public String getSanitisedPrice() {
        return sanitisedPrice;
    }

    public void setSanitisedPrice(String sanitisedPrice) {
        this.sanitisedPrice = sanitisedPrice;
    }

    public ProductMedia[] getMedia() {
        return media;
    }

    public ProductMedia[] getSanitisedMedia() {
        return sanitisedMedia;
    }

    public void setSanitisedMedia(ProductMedia[] sanitisedMedia) {
        this.sanitisedMedia = sanitisedMedia;
    }

    public float getRatingAverage() {
        return ratingAverage;
    }

    public float getRatingCount() {
        return ratingCount;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public String getProcessedImageUrl() {
        return processedImageUrl;
    }

    public void setProcessedImageUrl(String processedImageUrl) {
        this.processedImageUrl = processedImageUrl;
    }
}
