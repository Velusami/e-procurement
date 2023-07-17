package com.iz.pr01.service;

import java.util.Base64;

public class EncryptDecrypt {

    public static void main(String[] args) {
        /***** Decoding Base64 Image In Java ******/

        /***** Encoding And Decoding Base64 In Java ******/

        String str = "Highlight";

        Base64.Encoder encoder = Base64.getEncoder();
        String encodedString = encoder.encodeToString(str.getBytes());
        System.out.println(encodedString); // Outputs: "SGlnaGxpZ2h0"

        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decodedByte = decoder.decode("SW50ZWxAMjE=");
        String decodedString = new String(decodedByte);
        System.out.println(decodedString);  // Outputs: "Highlight"
    }
}
