package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.util.Beta;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

@Beta
public class OAuth2Utils {
   private static final int COMPUTE_PING_CONNECTION_TIMEOUT_MS = 500;
   private static final String DEFAULT_METADATA_SERVER_URL = "http://169.254.169.254";
   private static final Logger LOGGER = Logger.getLogger(OAuth2Utils.class.getName());
   private static final int MAX_COMPUTE_PING_TRIES = 3;
   static final Charset UTF_8 = Charset.forName("UTF-8");

   static <T extends Throwable> T exceptionWithCause(T var0, Throwable var1) {
      var0.initCause(var1);
      return (T)var0;
   }

   public static String getMetadataServerUrl() {
      return getMetadataServerUrl(SystemEnvironmentProvider.INSTANCE);
   }

   static String getMetadataServerUrl(SystemEnvironmentProvider var0) {
      String var1 = var0.getEnv("GCE_METADATA_HOST");
      String var3;
      if (var1 != null) {
         String var2 = String.valueOf(var1);
         if (var2.length() != 0) {
            var3 = "http://".concat(var2);
         } else {
            var3 = new String("http://");
         }
      } else {
         var3 = "http://169.254.169.254";
      }

      return var3;
   }

   static boolean headersContainValue(HttpHeaders var0, String var1, String var2) {
      Object var4 = var0.get(var1);
      if (var4 instanceof Collection) {
         for (Object var6 : (Collection)var4) {
            if (var6 instanceof String && ((String)var6).equals(var2)) {
               return true;
            }
         }
      }

      return false;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   static boolean runningOnComputeEngine(HttpTransport var0, SystemEnvironmentProvider var1) {
      boolean var4 = false;
      boolean var3;
      if (Boolean.parseBoolean(var1.getEnv("NO_GCE_CHECK"))) {
         var3 = var4;
      } else {
         GenericUrl var19 = new GenericUrl(getMetadataServerUrl(var1));
         int var2 = 1;

         while (true) {
            var3 = var4;
            if (var2 > 3) {
               break;
            }

            label61: {
               HttpResponse var6;
               try {
                  HttpRequest var5 = var0.createRequestFactory().buildGetRequest(var19);
                  var5.setConnectTimeout(500);
                  var6 = var5.execute();
               } catch (SocketTimeoutException var17) {
                  break label61;
               } catch (IOException var18) {
                  LOGGER.log(Level.WARNING, "Failed to detect whether we are running on Google Compute Engine.", var18);
                  break label61;
               }

               try {
                  var3 = headersContainValue(var6.getHeaders(), "Metadata-Flavor", "Google");
                  break;
               } finally {
                  label52:
                  try {
                     var6.disconnect();
                  } catch (SocketTimeoutException var14) {
                     break label52;
                  } catch (IOException var15) {
                     LOGGER.log(Level.WARNING, "Failed to detect whether we are running on Google Compute Engine.", var15);
                     break label52;
                  }
               }
            }

            var2++;
         }
      }

      return var3;
   }
}
