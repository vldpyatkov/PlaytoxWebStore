package com.store.domain;

import java.util.UUID;

public class IdGenerator {

    public static String createId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
