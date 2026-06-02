package okhttp3.internal.platform;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;

final class Jdk9Platform extends Platform {
   final Method a;
   final Method b;

   Jdk9Platform(Method var1, Method var2) {
      this.a = var1;
      this.b = var2;
   }

   public static Jdk9Platform a() {
      Jdk9Platform var0;
      try {
         Method var1 = SSLParameters.class.getMethod("setApplicationProtocols", String[].class);
         Method var2 = SSLSocket.class.getMethod("getApplicationProtocol");
         var0 = new Jdk9Platform(var1, var2);
      } catch (NoSuchMethodException var3) {
         var0 = null;
      }

      return var0;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   public String a(SSLSocket var1) {
      try {
         var7 = (String)this.b.invoke(var1);
      } catch (IllegalAccessException var5) {
         throw new AssertionError();
      } catch (InvocationTargetException var6) {
         throw new AssertionError();
      }

      if (var7 != null) {
         boolean var2;
         try {
            var2 = var7.equals("");
         } catch (IllegalAccessException var3) {
            throw new AssertionError();
         } catch (InvocationTargetException var4) {
            throw new AssertionError();
         }

         if (!var2) {
            return var7;
         }
      }

      Object var8 = null;
      return (String)var8;
   }

   @Override
   public X509TrustManager a(SSLSocketFactory var1) {
      throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
   }

   @Override
   public void a(SSLSocket var1, String var2, List<Protocol> var3) {
      try {
         SSLParameters var6 = var1.getSSLParameters();
         var3 = a(var3);
         this.a.invoke(var6, (Object)var3.toArray(new String[var3.size()]));
         var1.setSSLParameters(var6);
         return;
      } catch (IllegalAccessException var4) {
      } catch (InvocationTargetException var5) {
      }

      throw new AssertionError();
   }
}
