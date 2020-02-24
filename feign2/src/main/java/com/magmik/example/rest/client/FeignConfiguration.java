package com.magmik.example.rest.client;

import com.google.gson.Gson;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

    @Bean
    public QuotesClient quotesClient(final Gson gson) {
        return Feign.builder()
                .decoder(new GsonDecoder(gson))
                .encoder(new GsonEncoder(gson))
//                .queryMapEncoder(new BeanQueryMapEncoder()) //for @QueryMap
                .logger(new Logger.ErrorLogger())
                .logLevel(Logger.Level.BASIC)
                .target(QuotesClient.class, "https://gturnquist-quoters.cfapps.io/api");
    }
}
