package com.alansf.apidiariodebordo.enums;

public enum ReadPeriod {

    EARLY_MORNING(1),
    MORNING(2),
    AFTER_LUNCH(3),
    AFTERNOON(4),
    NIGHT(5);

    private final int code;

    ReadPeriod(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ReadPeriod valueOf(int code) {
        for(ReadPeriod value : ReadPeriod.values()) {
            if(code == value.getCode()) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid ReadPeriod code!");
    }
}
