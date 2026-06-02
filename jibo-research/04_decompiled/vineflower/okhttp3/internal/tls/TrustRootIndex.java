package okhttp3.internal.tls;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

public abstract class TrustRootIndex {
   public static TrustRootIndex a(X509TrustManager var0) {
      TrustRootIndex.AndroidTrustRootIndex var1;
      try {
         Method var2 = var0.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
         var2.setAccessible(true);
         var1 = new TrustRootIndex.AndroidTrustRootIndex(var0, var2);
      } catch (NoSuchMethodException var3) {
         return a(var0.getAcceptedIssuers());
      }

      return var1;
   }

   public static TrustRootIndex a(X509Certificate... var0) {
      return new TrustRootIndex.BasicTrustRootIndex(var0);
   }

   public abstract X509Certificate a(X509Certificate var1);

   static final class AndroidTrustRootIndex extends TrustRootIndex {
      private final X509TrustManager a;
      private final Method b;

      AndroidTrustRootIndex(X509TrustManager var1, Method var2) {
         this.b = var2;
         this.a = var1;
      }

      // $VF: Duplicated exception handlers to handle obfuscated exceptions
      @Override
      public X509Certificate a(X509Certificate var1) {
         try {
            var7 = (TrustAnchor)this.b.invoke(this.a, var1);
         } catch (IllegalAccessException var4) {
            throw new AssertionError();
         } catch (InvocationTargetException var5) {
            return null;
         }

         if (var7 != null) {
            try {
               var1 = var7.getTrustedCert();
            } catch (IllegalAccessException var2) {
               throw new AssertionError();
            } catch (InvocationTargetException var3) {
               var1 = null;
            }
         } else {
            var1 = null;
         }

         return var1;
      }

      @Override
      public boolean equals(Object var1) {
         boolean var2 = true;
         if (var1 != this) {
            if (!(var1 instanceof TrustRootIndex.AndroidTrustRootIndex)) {
               var2 = false;
            } else {
               var1 = var1;
               if (!this.a.equals(var1.a) || !this.b.equals(var1.b)) {
                  var2 = false;
               }
            }
         }

         return var2;
      }

      @Override
      public int hashCode() {
         return this.a.hashCode() + this.b.hashCode() * 31;
      }
   }

   static final class BasicTrustRootIndex extends TrustRootIndex {
      private final Map<X500Principal, Set<X509Certificate>> a = new LinkedHashMap<>();

      BasicTrustRootIndex(X509Certificate... var1) {
         for (X509Certificate var6 : var1) {
            X500Principal var7 = var6.getSubjectX500Principal();
            Set var5 = this.a.get(var7);
            Set var4 = var5;
            if (var5 == null) {
               var4 = new LinkedHashSet(1);
               this.a.put(var7, var4);
            }

            var4.add(var6);
         }
      }

      @Override
      public X509Certificate a(X509Certificate var1) {
         X500Principal var2 = var1.getIssuerX500Principal();
         Set var7 = this.a.get(var2);
         if (var7 == null) {
            var1 = null;
         } else {
            Iterator var3 = var7.iterator();

            while (true) {
               if (var3.hasNext()) {
                  X509Certificate var8 = (X509Certificate)var3.next();
                  PublicKey var4 = var8.getPublicKey();

                  try {
                     var1.verify(var4);
                  } catch (Exception var5) {
                     continue;
                  }

                  var1 = var8;
                  break;
               }

               var1 = null;
               break;
            }
         }

         return var1;
      }

      @Override
      public boolean equals(Object var1) {
         boolean var2 = true;
         if (var1 != this && (!(var1 instanceof TrustRootIndex.BasicTrustRootIndex) || !((TrustRootIndex.BasicTrustRootIndex)var1).a.equals(this.a))) {
            var2 = false;
         }

         return var2;
      }

      @Override
      public int hashCode() {
         return this.a.hashCode();
      }
   }
}
