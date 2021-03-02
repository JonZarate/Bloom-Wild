package io.github.jonzarate.bloomwild.controller;

import java.text.MessageFormat;

public class ImageUrlProvider {

    public String generateProcessedImageUrl(int width, int height, String format, String imageUrl) {
        String urlWithPlaceholders = "https://media.bloomdev.org/v1/trim:15/{0,number,#}x{1,number,#}/smart/filters:format({2})/{3}";
        return MessageFormat.format(urlWithPlaceholders, width, height, format, imageUrl);
    }

}
