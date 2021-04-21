package com.frontbackend.java.cryptography.rsa;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class WorkingWithRSA {

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException, IOException, InvalidKeyException,
            NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);

        KeyPair pair = generator.generateKeyPair();

        PrivateKey privateKey = pair.getPrivate();
        PublicKey publicKey = pair.getPublic();

        String str = "FrontBackend.com";

        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] secredMsg = str.getBytes(StandardCharsets.UTF_8);
        byte[] encryptedMsg = encryptCipher.doFinal(secredMsg);

        String encodedMessage = Base64.getEncoder()
                                      .encodeToString(encryptedMsg);

        Cipher decryptCipher = Cipher.getInstance("RSA");
        decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);

        byte[] decryptedMessageBytes = decryptCipher.doFinal(encryptedMsg);
        String decryptedMessage = new String(decryptedMessageBytes, StandardCharsets.UTF_8);

        System.out.println(decryptedMessage);
    }
}
