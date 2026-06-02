package okhttp3.internal.platform;

import android.util.Log;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okhttp3.internal.Util;
import okhttp3.internal.tls.CertificateChainCleaner;

class AndroidPlatform extends Platform {
   private final Class<?> a;
   private final OptionalMethod<Socket> b;
   private final OptionalMethod<Socket> c;
   private final OptionalMethod<Socket> d;
   private final OptionalMethod<Socket> e;
   private final AndroidPlatform.CloseGuard f = AndroidPlatform.CloseGuard.a();

   AndroidPlatform(Class<?> var1, OptionalMethod<Socket> var2, OptionalMethod<Socket> var3, OptionalMethod<Socket> var4, OptionalMethod<Socket> var5) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static Platform a() {
      Class var1;
      try {
         var1 = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
      } catch (ClassNotFoundException var11) {
         try {
            var1 = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
         } catch (ClassNotFoundException var10) {
            return null;
         }
      }

      OptionalMethod var4;
      OptionalMethod var5;
      try {
         var4 = new OptionalMethod(null, "setUseSessionTickets", boolean.class);
         var5 = new OptionalMethod(null, "setHostname", String.class);
      } catch (ClassNotFoundException var9) {
         return null;
      }

      OptionalMethod var2;
      OptionalMethod var13;
      label39: {
         OptionalMethod var14;
         label38: {
            label37: {
               try {
                  Class.forName("android.net.Network");
                  var13 = new OptionalMethod(byte[].class, "getAlpnSelectedProtocol");
               } catch (ClassNotFoundException var8) {
                  var13 = null;
                  break label37;
               }

               try {
                  var14 = new OptionalMethod(null, "setAlpnProtocols", byte[].class);
                  break label38;
               } catch (ClassNotFoundException var7) {
               }
            }

            var14 = null;
            var2 = var13;
            var13 = var14;
            break label39;
         }

         var2 = var13;
         var13 = var14;
      }

      AndroidPlatform var15;
      try {
         var15 = new AndroidPlatform(var1, var4, var5, var2, var13);
      } catch (ClassNotFoundException var6) {
         return null;
      }

      return var15;
   }

   @Override
   public Object a(String var1) {
      return this.f.a(var1);
   }

   @Override
   public String a(SSLSocket var1) {
      String var2 = null;
      if (this.d != null && this.d.a(var1)) {
         byte[] var3 = (byte[])this.d.d(var1);
         String var4;
         if (var3 != null) {
            var4 = new String(var3, Util.e);
         } else {
            var4 = null;
         }

         var2 = var4;
      }

      return var2;
   }

   @Override
   public X509TrustManager a(SSLSocketFactory var1) {
      Object var2 = a(var1, this.a, "sslParameters");
      Object var5;
      if (var2 == null) {
         try {
            var2 = a(var1, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, var1.getClass().getClassLoader()), "sslParameters");
         } catch (ClassNotFoundException var3) {
            return super.a(var1);
         }

         var5 = (X509TrustManager)var2;
      } else {
         var5 = (X509TrustManager)var2;
      }

      var2 = a(var5, X509TrustManager.class, "x509TrustManager");
      if (var2 != null) {
         var5 = (X509TrustManager)var2;
      } else {
         var5 = a(var5, X509TrustManager.class, "trustManager");
      }

      return var5;
   }

   @Override
   public CertificateChainCleaner a(X509TrustManager var1) {
      AndroidPlatform.AndroidCertificateChainCleaner var7;
      try {
         Class var2 = Class.forName("android.net.http.X509TrustManagerExtensions");
         Object var3 = var2.getConstructor(X509TrustManager.class).newInstance(var1);
         Method var4 = var2.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class);
         var7 = new AndroidPlatform.AndroidCertificateChainCleaner(var3, var4);
      } catch (Exception var5) {
         return super.a(var1);
      }

      return var7;
   }

   @Override
   public void a(int var1, String var2, Throwable var3) {
      byte var4;
      if (var1 == 5) {
         var4 = 5;
      } else {
         var4 = 3;
      }

      String var8 = var2;
      if (var3 != null) {
         var8 = var2 + '\n' + Log.getStackTraceString(var3);
      }

      var1 = 0;
      int var6 = var8.length();

      while (var1 < var6) {
         int var5 = var8.indexOf(10, var1);
         if (var5 == -1) {
            var5 = var6;
         }

         while (true) {
            int var7 = Math.min(var5, var1 + 4000);
            Log.println(var4, "OkHttp", var8.substring(var1, var7));
            if (var7 >= var5) {
               var1 = var7 + 1;
               break;
            }

            var1 = var7;
         }
      }
   }

   @Override
   public void a(String var1, Object var2) {
      if (!this.f.a(var2)) {
         this.a(5, var1, null);
      }
   }

   @Override
   public void a(Socket var1, InetSocketAddress var2, int var3) throws IOException {
      try {
         var1.connect(var2, var3);
      } catch (AssertionError var4) {
         if (Util.a(var4)) {
            throw new IOException(var4);
         } else {
            throw var4;
         }
      } catch (SecurityException var5) {
         IOException var6 = new IOException("Exception in connect");
         var6.initCause(var5);
         throw var6;
      }
   }

   @Override
   public void a(SSLSocket var1, String var2, List<Protocol> var3) {
      if (var2 != null) {
         this.b.b(var1, true);
         this.c.b(var1, var2);
      }

      if (this.e != null && this.e.a(var1)) {
         byte[] var4 = b(var3);
         this.e.d(var1, var4);
      }
   }

   @Override
   public boolean b(String var1) {
      try {
         Class var4 = Class.forName("android.security.NetworkSecurityPolicy");
         Object var3 = var4.getMethod("getInstance").invoke(null);
         return (Boolean)var4.getMethod("isCleartextTrafficPermitted", String.class).invoke(var3, var1);
      } catch (ClassNotFoundException var5) {
      } catch (NoSuchMethodException var6) {
      } catch (IllegalAccessException var7) {
         throw new AssertionError();
      } catch (IllegalArgumentException var8) {
         throw new AssertionError();
      } catch (InvocationTargetException var9) {
         throw new AssertionError();
      }

      return super.b(var1);
   }

   static final class AndroidCertificateChainCleaner extends CertificateChainCleaner {
      private final Object a;
      private final Method b;

      AndroidCertificateChainCleaner(Object var1, Method var2) {
         this.a = var1;
         this.b = var2;
      }

      @Override
      public List<Certificate> a(List<Certificate> var1, String var2) throws SSLPeerUnverifiedException {
         try {
            X509Certificate[] var5 = var1.toArray(new X509Certificate[var1.size()]);
            return (List<Certificate>)this.b.invoke(this.a, var5, "RSA", var2);
         } catch (InvocationTargetException var3) {
            SSLPeerUnverifiedException var6 = new SSLPeerUnverifiedException(var3.getMessage());
            var6.initCause(var3);
            throw var6;
         } catch (IllegalAccessException var4) {
            throw new AssertionError(var4);
         }
      }

      @Override
      public boolean equals(Object var1) {
         return var1 instanceof AndroidPlatform.AndroidCertificateChainCleaner;
      }

      @Override
      public int hashCode() {
         return 0;
      }
   }

   static final class CloseGuard {
      private final Method a;
      private final Method b;
      private final Method c;

      CloseGuard(Method var1, Method var2, Method var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }

      static AndroidPlatform.CloseGuard a() {
         Method var0 = null;

         Method var5;
         Method var7;
         Method var8;
         try {
            Class var3 = Class.forName("dalvik.system.CloseGuard");
            var8 = var3.getMethod("get");
            var7 = var3.getMethod("open", String.class);
            var5 = var3.getMethod("warnIfOpen");
         } catch (Exception var4) {
            var7 = null;
            var8 = null;
            return new AndroidPlatform.CloseGuard(var8, var7, var0);
         }

         var0 = var5;
         return new AndroidPlatform.CloseGuard(var8, var7, var0);
      }

      Object a(String var1) {
         if (this.a != null) {
            Object var2;
            try {
               var2 = this.a.invoke(null);
               this.b.invoke(var2, var1);
            } catch (Exception var3) {
               return null;
            }

            return var2;
         } else {
            return null;
         }
      }

      boolean a(Object var1) {
         boolean var3 = false;
         boolean var2 = var3;
         if (var1 != null) {
            try {
               this.c.invoke(var1);
            } catch (Exception var4) {
               var2 = var3;
               return var2;
            }

            var2 = true;
         }

         return var2;
      }
   }
}
