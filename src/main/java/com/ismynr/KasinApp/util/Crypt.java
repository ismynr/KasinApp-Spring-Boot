package com.ismynr.KasinApp.util;

import java.util.Base64;

public class Crypt {
    public static String encrypt (String str) {
        return Base64.getEncoder().encodeToString((str.getBytes()));
    }

    public static String decrypt (String str) {
        return new String (Base64.getDecoder().decode(str));
    }
}
