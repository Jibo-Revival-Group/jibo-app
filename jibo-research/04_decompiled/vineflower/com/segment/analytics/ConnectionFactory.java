package com.segment.analytics;

import android.util.Base64;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class ConnectionFactory {
   private static final int DEFAULT_CONNECT_TIMEOUT_MILLIS = 15000;
   private static final int DEFAULT_READ_TIMEOUT_MILLIS = 20000;

   private String authorizationHeader(String var1) {
      return "Basic " + Base64.encodeToString((var1 + ":").getBytes(), 2);
   }

   public HttpURLConnection attribution(String var1) throws IOException {
      HttpURLConnection var2 = this.openConnection("https://mobile-service.segment.com/v1/attribution");
      var2.setRequestProperty("Authorization", this.authorizationHeader(var1));
      var2.setRequestMethod("POST");
      var2.setDoOutput(true);
      return var2;
   }

   protected HttpURLConnection openConnection(String var1) throws IOException {
      HttpURLConnection var2 = (HttpURLConnection)((URLConnection)FirebasePerfUrlConnection.instrument(new URL(var1).openConnection()));
      var2.setConnectTimeout(15000);
      var2.setReadTimeout(20000);
      var2.setRequestProperty("Content-Type", "application/json");
      var2.setDoInput(true);
      return var2;
   }

   public HttpURLConnection projectSettings(String var1) throws IOException {
      return this.openConnection("https://cdn-settings.segment.com/v1/projects/" + var1 + "/settings");
   }

   public HttpURLConnection upload(String var1) throws IOException {
      HttpURLConnection var2 = this.openConnection("https://api.segment.io/v1/import");
      var2.setRequestProperty("Authorization", this.authorizationHeader(var1));
      var2.setRequestProperty("Content-Encoding", "gzip");
      var2.setDoOutput(true);
      var2.setChunkedStreamingMode(0);
      return var2;
   }
}
