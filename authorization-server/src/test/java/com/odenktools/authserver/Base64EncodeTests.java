package com.odenktools.authserver;

import org.junit.Test;

import java.util.Base64;

public class Base64EncodeTests {

    /**
     * android-client:android-client YW5kcm9pZC1jbGllbnQ6YW5kcm9pZC1jbGllbnQ=
     * server-server:server-server c2VydmVyLXNlcnZlcjpzZXJ2ZXItc2VydmVy
     *
     */

    @Test
    public void encodeAuthTest() {
        String token = "server-server:server-server";
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] bytes = encoder.encode(token.getBytes());
        System.out.println(new String(bytes)); //YW5kcm9pZC1jbGllbnQ6YW5kcm9pZC1jbGllbnQ=
    }
}
