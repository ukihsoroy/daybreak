package com.odenktools.authserver;

import org.junit.Test;

import java.util.Arrays;
import java.util.Base64;

public class Base64EncodeTests {

    /**
     * android-client:android-client YW5kcm9pZC1jbGllbnQ6YW5kcm9pZC1jbGllbnQ=
     * server-server:server-server c2VydmVyLXNlcnZlcjpzZXJ2ZXItc2VydmVy
     */

    @Test
    public void encodeAuthTest() {
        String token = "server-server:server-server";
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] bytes = encoder.encode(token.getBytes());
        System.out.println(new String(bytes)); //YW5kcm9pZC1jbGllbnQ6YW5kcm9pZC1jbGllbnQ=
    }

    @Test
    public void decodeJwtToken() {
        String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsicmVzb3VyY2VfaWQiXSwidXNlcl9uYW1lIjoiY3VzdG9tZXJfb25lIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIiwidHJ1c3QiXSwiZXhwIjoxNjAxMzU5MDE3LCJhdXRob3JpdGllcyI6WyJST0xFX01PQklMRSIsIlVQREFURV9DT01QQU5ZIiwiUkVBRF9DT01QQU5ZIiwiUkVBRF9BUElLRVkiXSwianRpIjoiM2Q2ZDcxY2ItMmZhZi00Y2I3LTk0MjEtMTMwYTI0ZGU5Mjg3IiwiY2xpZW50X2lkIjoiYW5kcm9pZC1jbGllbnQifQ.WW9O48mngmLdIKCq3e_Tn9UxhFc4m91xoaENKvv52Me49b1BWqFrQ-n-n0ZYY78J4zMD6DgKwaoWI7D29WRCJ2wXHu0O01xTBuGHozA-v-KfiGJIWKQ2unrkDLf9oQO3MPxaaggND8RqC98m30bxCGtF30Rn_rMs50lPeyTPV_vee_-XW85UDlZnWWzJ1k0uI8uV_cyjPF7wLin6qtkHK6zHVHkwlM1JqcgZkgRK7R3kCKldEdaTXljI_6lQAkWqx9FjI-EmdxWwzJokEj2LSf_jhjOpsizBVyBPdcdABDoWwCBX6Kqo0B0RN9OKmvVfFC5ZdZEG7HgFa4QsdGdjQw";
        String[] split = token.split(".");
        Arrays.asList(split).forEach(x -> {
            Base64.Decoder decoder = Base64.getDecoder();
            byte[] decode = decoder.decode(x);
            System.out.println(new String(decode));
        });
    }
}
