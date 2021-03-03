package io.github.jonzarate.bloomwild.model.data;

import com.google.gson.annotations.SerializedName;

public class ProductAttributes {
    @SerializedName("name")
    private String name;

    @SerializedName("collection_name")
    private String collectionName;

    @SerializedName("currency")
    private String currency;

    @SerializedName("price_data")
    private ProductPrice[] prices;
    private String sanitisedPrice;

    @SerializedName("media")
    private ProductMedia[] media;
    private String[] sanitisedMedia;

    private boolean isHighlighted;


    public String getName() {
        return name;
    }

    public String getCollectionName() {
        return collectionName;
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

    public String[] getSanitisedMedia() {
        return sanitisedMedia;
    }

    public void setSanitisedMedia(String[] sanitisedMedia) {
        this.sanitisedMedia = sanitisedMedia;
    }

    public boolean isHighlighted() {
        return isHighlighted;
    }

    public void setHighlighted(boolean highlighted) {
        this.isHighlighted = highlighted;
    }
}
