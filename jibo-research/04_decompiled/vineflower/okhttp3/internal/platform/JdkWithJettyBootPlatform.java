package okhttp3.internal.platform;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;
import okhttp3.internal.Util;

class JdkWithJettyBootPlatform extends Platform {
   private final Method a;
   private final Method b;
   private final Method c;
   private final Class<?> d;
   private final Class<?> e;

   JdkWithJettyBootPlatform(Method var1, Method var2, Method var3, Class<?> var4, Class<?> var5) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
   }

   public static Platform a() {
      try {
         Class var8 = Class.forName("org.eclipse.jetty.alpn.ALPN");
         StringBuilder var1 = new StringBuilder();
         Class var3 = Class.forName(var1.append("org.eclipse.jetty.alpn.ALPN").append("$Provider").toString());
         var1 = new StringBuilder();
         Class var10 = Class.forName(var1.append("org.eclipse.jetty.alpn.ALPN").append("$ClientProvider").toString());
         StringBuilder var2 = new StringBuilder();
         Class var11 = Class.forName(var2.append("org.eclipse.jetty.alpn.ALPN").append("$ServerProvider").toString());
         Method var12 = var8.getMethod("put", SSLSocket.class, var3);
         Method var4 = var8.getMethod("get", SSLSocket.class);
         Method var5 = var8.getMethod("remove", SSLSocket.class);
         return new JdkWithJettyBootPlatform(var12, var4, var5, var10, var11);
      } catch (ClassNotFoundException var6) {
      } catch (NoSuchMethodException var7) {
      }

      return null;
   }

   @Override
   public String a(SSLSocket var1) {
      Object var2 = null;

      try {
         JdkWithJettyBootPlatform.JettyNegoProvider var5 = (JdkWithJettyBootPlatform.JettyNegoProvider)Proxy.getInvocationHandler(this.b.invoke(null, var1));
         if (!var5.a && var5.b == null) {
            Platform.b().a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", null);
            return (String)var2;
         }

         if (!var5.a) {
            return var5.b;
         }

         return null;
      } catch (InvocationTargetException var3) {
      } catch (IllegalAccessException var4) {
      }

      throw new AssertionError();
   }

   @Override
   public void a(SSLSocket var1, String var2, List<Protocol> var3) {
      List var4 = a(var3);

      try {
         ClassLoader var12 = Platform.class.getClassLoader();
         Class var10 = this.d;
         Class var5 = this.e;
         JdkWithJettyBootPlatform.JettyNegoProvider var6 = new JdkWithJettyBootPlatform.JettyNegoProvider(var4);
         Object var11 = Proxy.newProxyInstance(var12, new Class[]{var10, var5}, var6);
         this.a.invoke(null, var1, var11);
         return;
      } catch (InvocationTargetException var7) {
         var9 = var7;
      } catch (IllegalAccessException var8) {
         var9 = var8;
      }

      throw new AssertionError(var9);
   }

   @Override
   public void b(SSLSocket var1) {
      try {
         this.c.invoke(null, var1);
         return;
      } catch (IllegalAccessException var2) {
      } catch (InvocationTargetException var3) {
      }

      throw new AssertionError();
   }

   private static class JettyNegoProvider implements InvocationHandler {
      boolean a;
      String b;
      private final List<String> c;

      JettyNegoProvider(List<String> var1) {
         this.c = var1;
      }

      @Override
      public Object invoke(Object var1, Method var2, Object[] var3) throws Throwable {
         String var7 = var2.getName();
         Class var6 = var2.getReturnType();
         var1 = var3;
         if (var3 == null) {
            var1 = Util.b;
         }

         if (var7.equals("supports") && boolean.class == var6) {
            var1 = true;
         } else if (var7.equals("unsupported") && void.class == var6) {
            this.a = true;
            var1 = null;
         } else if (var7.equals("protocols") && var1.length == 0) {
            var1 = this.c;
         } else if ((var7.equals("selectProtocol") || var7.equals("select")) && String.class == var6 && var1.length == 1 && var1[0] instanceof List) {
            var1 = (List)var1[0];
            int var5 = var1.size();
            int var4 = 0;

            while (true) {
               if (var4 >= var5) {
                  var1 = this.c.get(0);
                  this.b = (String)var1;
                  break;
               }

               if (this.c.contains(var1.get(var4))) {
                  var1 = (String)var1.get(var4);
                  this.b = (String)var1;
                  break;
               }

               var4++;
            }
         } else if ((var7.equals("protocolSelected") || var7.equals("selected")) && var1.length == 1) {
            this.b = (String)var1[0];
            var1 = null;
         } else {
            var1 = var2.invoke(this, var1);
         }

         return var1;
      }
   }
}
