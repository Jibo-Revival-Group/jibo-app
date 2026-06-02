package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;
import okhttp3.ConnectionSpec;
import okhttp3.internal.Internal;

public final class ConnectionSpecSelector {
   private final List<ConnectionSpec> a;
   private int b = 0;
   private boolean c;
   private boolean d;

   public ConnectionSpecSelector(List<ConnectionSpec> var1) {
      this.a = var1;
   }

   private boolean b(SSLSocket var1) {
      int var2 = this.b;

      boolean var3;
      while (true) {
         if (var2 >= this.a.size()) {
            var3 = false;
            break;
         }

         if (this.a.get(var2).a(var1)) {
            var3 = true;
            break;
         }

         var2++;
      }

      return var3;
   }

   public ConnectionSpec a(SSLSocket var1) throws IOException {
      int var2 = this.b;
      int var3 = this.a.size();

      ConnectionSpec var4;
      while (true) {
         if (var2 >= var3) {
            var4 = null;
            break;
         }

         var4 = this.a.get(var2);
         if (var4.a(var1)) {
            this.b = var2 + 1;
            break;
         }

         var2++;
      }

      if (var4 == null) {
         throw new UnknownServiceException(
            "Unable to find acceptable protocols. isFallback="
               + this.d
               + ", modes="
               + this.a
               + ", supported protocols="
               + Arrays.toString(var1.getEnabledProtocols())
         );
      }

      this.c = this.b(var1);
      Internal.a.a(var4, var1, this.d);
      return var4;
   }

   public boolean a(IOException var1) {
      boolean var3 = false;
      this.d = true;
      boolean var2;
      if (!this.c) {
         var2 = var3;
      } else {
         var2 = var3;
         if (!(var1 instanceof ProtocolException)) {
            var2 = var3;
            if (!(var1 instanceof InterruptedIOException)) {
               if (var1 instanceof SSLHandshakeException) {
                  var2 = var3;
                  if (var1.getCause() instanceof CertificateException) {
                     return var2;
                  }
               }

               var2 = var3;
               if (!(var1 instanceof SSLPeerUnverifiedException)) {
                  if (!(var1 instanceof SSLHandshakeException)) {
                     var2 = var3;
                     if (!(var1 instanceof SSLProtocolException)) {
                        return var2;
                     }
                  }

                  var2 = true;
               }
            }
         }
      }

      return var2;
   }
}
