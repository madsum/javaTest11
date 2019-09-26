package com.ma.dev;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
	    // java 11 string
        var chant = "      BDB!!!         ";
	    System.out.println("chant.repeat(4): "+chant.repeat(4));
        System.out.println("chant.isBlank(): "+chant.isBlank());
        System.out.println("chant.strip(): "+chant.strip());
        System.out.println("chant.repeat(4): "+chant.repeat(4));

        // new lamda 11
        Consumer<BigInteger> moneyConsumer = (@Deprecated var money ) -> {
           // money = new BigDecimal("10");
            System.out.println("I got money: "+money);
        };
        moneyConsumer.accept(new BigInteger("1000"));

        // httm client mainly taken for open Apache library.

        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://www.google.com"))
                .build();

        // mainly taken for open Apache library.
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
