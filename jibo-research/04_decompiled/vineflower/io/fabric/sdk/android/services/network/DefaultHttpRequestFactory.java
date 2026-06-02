package io.fabric.sdk.android.services.network;

import io.fabric.sdk.android.DefaultLogger;
import io.fabric.sdk.android.Logger;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class DefaultHttpRequestFactory implements HttpRequestFactory {
   private final Logger a;
   private PinningInfoProvider b;
   private SSLSocketFactory c;
   private boolean d;

   public DefaultHttpRequestFactory() {
      this(new DefaultLogger());
   }

   public DefaultHttpRequestFactory(Logger var1) {
      this.a = var1;
   }

   private void a() {
      synchronized (this) {
         this.d = false;
         this.c = null;
      }
   }

   private boolean a(String var1) {
      boolean var2;
      if (var1 != null && var1.toLowerCase(Locale.US).startsWith("https")) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   private SSLSocketFactory b() {
      synchronized (this) {
         if (this.c == null && !this.d) {
            this.c = this.c();
         }

         return this.c;
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // $VF: Could not create synchronized statement, marking monitor enters and exits
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private SSLSocketFactory c() {
      synchronized (this){} // $VF: monitorenter 
      boolean var4 = false /* VF: Semaphore variable */;

      SSLSocketFactory var1;
      label36: {
         try {
            var4 = true;
            this.d = true;

            try {
               var1 = NetworkUtils.a(this.b);
               this.a.a("Fabric", "Custom SSL pinning enabled");
               var4 = false;
               break label36;
            } catch (Exception var5) {
               this.a.e("Fabric", "Exception while validating pinned certs", var5);
               var4 = false;
            }
         } finally {
            if (var4) {
               // $VF: monitorexit
            }
         }

         var1 = null;
      }

      // $VF: monitorexit
      return var1;
   }

   @Override
   public HttpRequest a(HttpMethod var1, String var2, Map<String, String> var3) {
      HttpRequest var4;
      switch (<unrepresentable>.a[var1.ordinal()]) {
         case 1:
            var4 = HttpRequest.a(var2, var3, true);
            break;
         case 2:
            var4 = HttpRequest.b(var2, var3, true);
            break;
         case 3:
            var4 = HttpRequest.d((CharSequence)var2);
            break;
         case 4:
            var4 = HttpRequest.e((CharSequence)var2);
            break;
         default:
            throw new IllegalArgumentException("Unsupported HTTP method!");
      }

      if (this.a(var2) && this.b != null) {
         SSLSocketFactory var5 = this.b();
         if (var5 != null) {
            ((HttpsURLConnection)var4.a()).setSSLSocketFactory(var5);
         }
      }

      return var4;
   }

   @Override
   public void a(PinningInfoProvider var1) {
      if (this.b != var1) {
         this.b = var1;
         this.a();
      }
   }
}
