package com.alansf.apidiariodebordo.enums;

public enum ReadStatus {

    SUCCESS(1),
    UNSUCCESSFULLY(2),
    OK(3);

    private final int code;

    ReadStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ReadStatus valueOf(int code) {
        for(ReadStatus value : ReadStatus.values()) {
            if(code == value.getCode()) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid ReadStatus code!");
    }
}
