package okhttp3.internal.platform;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;
import okio.Buffer;

public class Platform {
   private static final Platform a = a();
   private static final Logger b = Logger.getLogger(OkHttpClient.class.getName());

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   static <T> T a(Object var0, Class<T> var1, String var2) {
      Class var3 = var0.getClass();

      while (true) {
         if (var3 != Object.class) {
            Field var13;
            try {
               var13 = var3.getDeclaredField(var2);
               var13.setAccessible(true);
               var13 = var13.get(var0);
            } catch (NoSuchFieldException var7) {
               var3 = var3.getSuperclass();
               continue;
            } catch (IllegalAccessException var8) {
               throw new AssertionError();
            }

            label43:
            if (var13 != null) {
               try {
                  if (!var1.isInstance(var13)) {
                     break label43;
                  }
               } catch (NoSuchFieldException var9) {
                  var3 = var3.getSuperclass();
                  continue;
               } catch (IllegalAccessException var10) {
                  throw new AssertionError();
               }

               try {
                  var13 = var1.cast(var13);
               } catch (NoSuchFieldException var5) {
                  var3 = var3.getSuperclass();
                  continue;
               } catch (IllegalAccessException var6) {
                  throw new AssertionError();
               }

               var0 = var13;
               break;
            }

            var0 = null;
            break;
         }

         if (!var2.equals("delegate")) {
            var0 = a(var0, Object.class, "delegate");
            if (var0 != null) {
               var0 = a(var0, var1, var2);
               break;
            }
         }

         var0 = null;
         break;
      }

      return (T)var0;
   }

   public static List<String> a(List<Protocol> var0) {
      ArrayList var4 = new ArrayList(var0.size());
      int var2 = var0.size();

      for (int var1 = 0; var1 < var2; var1++) {
         Protocol var3 = (Protocol)var0.get(var1);
         if (var3 != Protocol.HTTP_1_0) {
            var4.add(var3.toString());
         }
      }

      return var4;
   }

   private static Platform a() {
      Platform var0 = AndroidPlatform.a();
      if (var0 == null) {
         Jdk9Platform var1 = Jdk9Platform.a();
         var0 = var1;
         if (var1 == null) {
            var1 = JdkWithJettyBootPlatform.a();
            var0 = var1;
            if (var1 == null) {
               var0 = new Platform();
            }
         }
      }

      return var0;
   }

   public static Platform b() {
      return a;
   }

   static byte[] b(List<Protocol> var0) {
      Buffer var3 = new Buffer();
      int var2 = var0.size();

      for (int var1 = 0; var1 < var2; var1++) {
         Protocol var4 = (Protocol)var0.get(var1);
         if (var4 != Protocol.HTTP_1_0) {
            var3.b(var4.toString().length());
            var3.a(var4.toString());
         }
      }

      return var3.t();
   }

   public Object a(String var1) {
      Throwable var2;
      if (b.isLoggable(Level.FINE)) {
         var2 = new Throwable(var1);
      } else {
         var2 = null;
      }

      return var2;
   }

   public String a(SSLSocket var1) {
      return null;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public X509TrustManager a(SSLSocketFactory var1) {
      try {
         var5 = a(var1, Class.forName("sun.security.ssl.SSLContextImpl"), "context");
      } catch (ClassNotFoundException var3) {
         return null;
      }

      X509TrustManager var4;
      if (var5 == null) {
         var4 = null;
      } else {
         try {
            var4 = a(var5, X509TrustManager.class, "trustManager");
         } catch (ClassNotFoundException var2) {
            var4 = null;
         }
      }

      return var4;
   }

   public CertificateChainCleaner a(X509TrustManager var1) {
      return new BasicCertificateChainCleaner(TrustRootIndex.a(var1));
   }

   public void a(int var1, String var2, Throwable var3) {
      Level var4;
      if (var1 == 5) {
         var4 = Level.WARNING;
      } else {
         var4 = Level.INFO;
      }

      b.log(var4, var2, var3);
   }

   public void a(String var1, Object var2) {
      String var3 = var1;
      if (var2 == null) {
         var3 = var1
            + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
      }

      this.a(5, var3, (Throwable)var2);
   }

   public void a(Socket var1, InetSocketAddress var2, int var3) throws IOException {
      var1.connect(var2, var3);
   }

   public void a(SSLSocket var1, String var2, List<Protocol> var3) {
   }

   public void b(SSLSocket var1) {
   }

   public boolean b(String var1) {
      return true;
   }

   public String c() {
      return "OkHttp";
   }
}
