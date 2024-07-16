package com.alura.literalura.config;

public class CadenaConfig {
    public static String limitarLong(String cadena, int longitudMax) {
        if (cadena.length() <= longitudMax) {
            return cadena;
        } else {
            return cadena.substring(0, longitudMax);
        }
    }
}
