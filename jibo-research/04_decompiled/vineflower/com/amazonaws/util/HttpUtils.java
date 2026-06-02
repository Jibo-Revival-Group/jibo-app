package com.amazonaws.util;

import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpUtils {
   private static final Pattern ENCODED_CHARACTERS_PATTERN;

   static {
      StringBuilder var0 = new StringBuilder();
      var0.append(Pattern.quote("+")).append("|").append(Pattern.quote("*")).append("|").append(Pattern.quote("%7E")).append("|").append(Pattern.quote("%2F"));
      ENCODED_CHARACTERS_PATTERN = Pattern.compile(var0.toString());
   }

   public static String appendUri(String var0, String var1) {
      return appendUri(var0, var1, false);
   }

   public static String appendUri(String var0, String var1, boolean var2) {
      if (var1 != null && var1.length() > 0) {
         String var3;
         if (var1.startsWith("/")) {
            var3 = var0;
            if (var0.endsWith("/")) {
               var3 = var0.substring(0, var0.length() - 1);
            }
         } else {
            var3 = var0;
            if (!var0.endsWith("/")) {
               var3 = var0 + "/";
            }
         }

         var1 = urlEncode(var1, true);
         var0 = var1;
         if (var2) {
            var0 = var1.replace("//", "/%2F");
         }

         var1 = var3 + var0;
      } else {
         var1 = var0;
         if (!var0.endsWith("/")) {
            var1 = var0 + "/";
         }
      }

      return var1;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static String encodeParameters(Request<?> var0) {
      String var10;
      if (var0.getParameters().isEmpty()) {
         var10 = null;
      } else {
         StringBuilder var2 = new StringBuilder();
         boolean var1 = true;

         Iterator var3;
         try {
            var3 = var0.getParameters().entrySet().iterator();
         } catch (UnsupportedEncodingException var8) {
            throw new IllegalArgumentException(var8);
         }

         while (true) {
            String var4;
            try {
               if (!var3.hasNext()) {
                  break;
               }

               Entry var11 = (Entry)var3.next();
               var4 = URLEncoder.encode((String)var11.getKey(), "UTF-8");
               var12 = (String)var11.getValue();
            } catch (UnsupportedEncodingException var9) {
               throw new IllegalArgumentException(var9);
            }

            String var13;
            if (var12 == null) {
               var13 = "";
            } else {
               try {
                  var13 = URLEncoder.encode(var12, "UTF-8");
               } catch (UnsupportedEncodingException var7) {
                  throw new IllegalArgumentException(var7);
               }
            }

            if (!var1) {
               try {
                  var2.append("&");
               } catch (UnsupportedEncodingException var6) {
                  throw new IllegalArgumentException(var6);
               }
            } else {
               var1 = false;
            }

            try {
               var2.append(var4).append("=").append(var13);
            } catch (UnsupportedEncodingException var5) {
               throw new IllegalArgumentException(var5);
            }
         }

         var10 = var2.toString();
      }

      return var10;
   }

   public static boolean isUsingNonDefaultPort(URI var0) {
      boolean var3 = false;
      String var4 = var0.getScheme().toLowerCase();
      int var1 = var0.getPort();
      boolean var2;
      if (var1 <= 0) {
         var2 = var3;
      } else {
         if (var4.equals("http")) {
            var2 = var3;
            if (var1 == 80) {
               return var2;
            }
         }

         if (var4.equals("https")) {
            var2 = var3;
            if (var1 == 443) {
               return var2;
            }
         }

         var2 = true;
      }

      return var2;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static String urlEncode(String var0, boolean var1) {
      if (var0 == null) {
         var0 = "";
      } else {
         StringBuffer var3;
         Matcher var4;
         try {
            var0 = URLEncoder.encode(var0, "UTF-8");
            var4 = ENCODED_CHARACTERS_PATTERN.matcher(var0);
            var3 = new StringBuffer(var0.length());
         } catch (UnsupportedEncodingException var7) {
            throw new RuntimeException(var7);
         }

         while (true) {
            label68: {
               label77: {
                  String var2;
                  try {
                     if (!var4.find()) {
                        break;
                     }

                     var2 = var4.group(0);
                     if ("+".equals(var2)) {
                        break label77;
                     }
                  } catch (UnsupportedEncodingException var11) {
                     throw new RuntimeException(var11);
                  }

                  label78: {
                     try {
                        if ("*".equals(var2)) {
                           break label78;
                        }
                     } catch (UnsupportedEncodingException var10) {
                        throw new RuntimeException(var10);
                     }

                     label79: {
                        try {
                           if ("%7E".equals(var2)) {
                              break label79;
                           }
                        } catch (UnsupportedEncodingException var9) {
                           throw new RuntimeException(var9);
                        }

                        var0 = var2;
                        if (!var1) {
                           break label68;
                        }

                        var0 = var2;

                        try {
                           if (!"%2F".equals(var2)) {
                              break label68;
                           }
                        } catch (UnsupportedEncodingException var8) {
                           throw new RuntimeException(var8);
                        }

                        var0 = "/";
                        break label68;
                     }

                     var0 = "~";
                     break label68;
                  }

                  var0 = "%2A";
                  break label68;
               }

               var0 = "%20";
            }

            try {
               var4.appendReplacement(var3, var0);
            } catch (UnsupportedEncodingException var6) {
               throw new RuntimeException(var6);
            }
         }

         try {
            var4.appendTail(var3);
            var0 = var3.toString();
         } catch (UnsupportedEncodingException var5) {
            throw new RuntimeException(var5);
         }
      }

      return var0;
   }

   public static boolean usePayloadForQueryParameters(Request<?> var0) {
      boolean var2 = true;
      boolean var3 = HttpMethodName.POST.equals(var0.getHttpMethod());
      boolean var1;
      if (var0.getContent() == null) {
         var1 = true;
      } else {
         var1 = false;
      }

      if (!var3 || !var1) {
         var2 = false;
      }

      return var2;
   }
}
