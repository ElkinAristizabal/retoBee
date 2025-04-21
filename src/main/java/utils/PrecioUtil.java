package utils;

import java.math.BigDecimal;

public class PrecioUtil {

    public static BigDecimal sumarDosPrecios(String precio1, String precio2) {
        BigDecimal p1 = parsearPrecio(precio1);
        BigDecimal p2 = parsearPrecio(precio2);
        return p1.add(p2);
    }

    public static BigDecimal parsearPrecio(String precio) {
        String limpio = precio.replaceAll("[^\\d.]", "");
        return new BigDecimal(limpio);
    }
}
