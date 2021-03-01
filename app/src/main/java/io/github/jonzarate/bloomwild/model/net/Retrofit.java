package io.github.jonzarate.bloomwild.model.net;

import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit {

    public static BloomWildApi createClient(String baseUrl) {
        return new retrofit2.Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(BloomWildApi.class);
    }

}
