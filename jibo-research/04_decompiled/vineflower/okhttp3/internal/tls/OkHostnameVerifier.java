package okhttp3.internal.tls;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import okhttp3.internal.Util;

public final class OkHostnameVerifier implements HostnameVerifier {
   public static final OkHostnameVerifier a = new OkHostnameVerifier();

   private OkHostnameVerifier() {
   }

   public static List<String> a(X509Certificate var0) {
      List var1 = a(var0, 7);
      List var3 = a(var0, 2);
      ArrayList var2 = new ArrayList(var1.size() + var3.size());
      var2.addAll(var1);
      var2.addAll(var3);
      return var2;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static List<String> a(X509Certificate var0, int var1) {
      ArrayList var2 = new ArrayList();

      try {
         var13 = var0.getSubjectAlternativeNames();
      } catch (CertificateParsingException var11) {
         return Collections.emptyList();
      }

      List var12;
      if (var13 == null) {
         try {
            var12 = Collections.emptyList();
         } catch (CertificateParsingException var5) {
            var12 = Collections.emptyList();
         }
      } else {
         try {
            var14 = var13.iterator();
         } catch (CertificateParsingException var7) {
            List var16 = Collections.emptyList();
            return var16;
         }

         while (true) {
            List var3;
            try {
               if (!var14.hasNext()) {
                  break;
               }

               var3 = (List)var14.next();
            } catch (CertificateParsingException var10) {
               List var17 = Collections.emptyList();
               return var17;
            }

            if (var3 != null) {
               Integer var4;
               try {
                  if (var3.size() < 2) {
                     continue;
                  }

                  var4 = (Integer)var3.get(0);
               } catch (CertificateParsingException var9) {
                  List var18 = Collections.emptyList();
                  return var18;
               }

               if (var4 != null) {
                  try {
                     if (var4 != var1) {
                        continue;
                     }

                     var15 = (String)var3.get(1);
                  } catch (CertificateParsingException var8) {
                     List var19 = Collections.emptyList();
                     return var19;
                  }

                  if (var15 != null) {
                     try {
                        var2.add(var15);
                     } catch (CertificateParsingException var6) {
                        List var20 = Collections.emptyList();
                        return var20;
                     }
                  }
               }
            }
         }

         var12 = var2;
      }

      return var12;
   }

   private boolean b(String var1, X509Certificate var2) {
      List var6 = a(var2, 7);
      int var4 = var6.size();
      int var3 = 0;

      boolean var5;
      while (true) {
         if (var3 >= var4) {
            var5 = false;
            break;
         }

         if (var1.equalsIgnoreCase((String)var6.get(var3))) {
            var5 = true;
            break;
         }

         var3++;
      }

      return var5;
   }

   private boolean c(String var1, X509Certificate var2) {
      var1 = var1.toLowerCase(Locale.US);
      List var7 = a(var2, 2);
      int var5 = var7.size();
      int var4 = 0;
      boolean var3 = false;

      boolean var6;
      while (true) {
         if (var4 >= var5) {
            if (!var3) {
               String var9 = new DistinguishedNameParser(var2.getSubjectX500Principal()).a("cn");
               if (var9 != null) {
                  var6 = this.a(var1, var9);
                  break;
               }
            }

            var6 = false;
            break;
         }

         if (this.a(var1, (String)var7.get(var4))) {
            var6 = true;
            break;
         }

         var4++;
         var3 = true;
      }

      return var6;
   }

   public boolean a(String var1, String var2) {
      boolean var5 = false;
      boolean var4 = var5;
      if (var1 != null) {
         var4 = var5;
         if (var1.length() != 0) {
            var4 = var5;
            if (!var1.startsWith(".")) {
               if (var1.endsWith("..")) {
                  var4 = var5;
               } else {
                  var4 = var5;
                  if (var2 != null) {
                     var4 = var5;
                     if (var2.length() != 0) {
                        var4 = var5;
                        if (!var2.startsWith(".")) {
                           var4 = var5;
                           if (!var2.endsWith("..")) {
                              String var6 = var1;
                              if (!var1.endsWith(".")) {
                                 var6 = var1 + '.';
                              }

                              var1 = var2;
                              if (!var2.endsWith(".")) {
                                 var1 = var2 + '.';
                              }

                              var1 = var1.toLowerCase(Locale.US);
                              if (!var1.contains("*")) {
                                 var4 = var6.equals(var1);
                              } else {
                                 var4 = var5;
                                 if (var1.startsWith("*.")) {
                                    var4 = var5;
                                    if (var1.indexOf(42, 1) == -1) {
                                       var4 = var5;
                                       if (var6.length() >= var1.length()) {
                                          var4 = var5;
                                          if (!"*.".equals(var1)) {
                                             var1 = var1.substring(1);
                                             var4 = var5;
                                             if (var6.endsWith(var1)) {
                                                int var3 = var6.length() - var1.length();
                                                if (var3 > 0) {
                                                   var4 = var5;
                                                   if (var6.lastIndexOf(46, var3 - 1) != -1) {
                                                      return var4;
                                                   }
                                                }

                                                var4 = true;
                                             }
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      return var4;
   }

   public boolean a(String var1, X509Certificate var2) {
      boolean var3;
      if (Util.c(var1)) {
         var3 = this.b(var1, var2);
      } else {
         var3 = this.c(var1, var2);
      }

      return var3;
   }

   @Override
   public boolean verify(String var1, SSLSession var2) {
      boolean var3;
      try {
         var3 = this.a(var1, (X509Certificate)var2.getPeerCertificates()[0]);
      } catch (SSLException var4) {
         var3 = false;
      }

      return var3;
   }
}
