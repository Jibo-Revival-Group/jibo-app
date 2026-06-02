package com.google.api.client.http.javanet;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class DefaultConnectionFactory implements ConnectionFactory {
   private final Proxy proxy;

   public DefaultConnectionFactory() {
      this(null);
   }

   public DefaultConnectionFactory(Proxy var1) {
      this.proxy = var1;
   }

   @Override
   public HttpURLConnection openConnection(URL var1) throws IOException {
      URLConnection var2;
      if (this.proxy == null) {
         var2 = (URLConnection)FirebasePerfUrlConnection.instrument(var1.openConnection());
      } else {
         var2 = (URLConnection)FirebasePerfUrlConnection.instrument(var1.openConnection(this.proxy));
      }

      return (HttpURLConnection)var2;
   }
}
