package com.burak.demo;

import org.junit.jupiter.api.Test;
import java.net.HttpURLConnection;
import java.net.URL;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebsiteAccessTest {
    @Test
    public void testUrlAccess() {
        try {
            // Kontrol edilecek adres
            URL url = new URL("https://example.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.connect();

            int code = connection.getResponseCode();
            System.out.println("Site Durum Kodu: " + code);

            // Eğer 200 değilse test FAIL olur
            assertEquals(200, code, "Siteye erişilemedi!");

        } catch (Exception e) {
            // Bağlantı hatası olursa testi FAIL yap
            org.junit.jupiter.api.Assertions.fail("Bağlantı hatası: " + e.getMessage());
        }
    }
}