package com.hackerrank.sample.model.ENUM;


public enum Condition {
    NUEVO(1, "Nuevo"),
    USADO(2, "Usado"),
    REACONDICIONADO(3, "Reacondicionado");

    private final Integer id;
    private final String status;

    Condition(Integer id, String status) {
        this.id = id;
        this.status = status;
    }

    public static String fromId(Integer id) {
        for (Condition type : Condition.values()) {
            if (type.id.equals(id)) {
                return type.status;
            }
        }
        throw new IllegalArgumentException("ID de condición no válido: " + id);
    }
}
