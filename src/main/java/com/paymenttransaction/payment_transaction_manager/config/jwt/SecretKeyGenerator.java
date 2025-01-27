package com.paymenttransaction.payment_transaction_manager.config.jwt;

import java.util.Base64;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class SecretKeyGenerator {
    public static void main(String[] args) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
        keyGenerator.init(256);
        SecretKey secretKey = keyGenerator.generateKey();
        String base64Key = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        System.out.println("Base64 Secret Key: " + base64Key);
    }
}
