package com.proyecto.lair.constants;

public final class AuthenticationConstants {

    /**
     * Url authenticated
     */
    public static final String URL_PRIVATE_AUTHETICATION = "/lair";

    /**
     * config Url access
     */
    public static final String URL_CONFIG_PRIVATE_AUTHETICATION = "/lair/api/**";

    private AuthenticationConstants() {
        throw new IllegalStateException("Constants class");
    }
}
