package com.hackerrank.sample.model.ENUM;

public enum Stock {
    NO(0, "Sin Stock"),
    SI(1, "Con Stock");

    private final Integer id;
    private final String productStock;

    Stock(Integer id, String productStock) {
        this.id = id;
        this.productStock = productStock;
    }

    public static String fromId(Integer id) {
        for (Stock type : Stock.values()) {
            if (type.id.equals(id)) {
                return type.productStock;
            }
        }
        throw new IllegalArgumentException("ID de condición no válido: " + id);
    }
}
