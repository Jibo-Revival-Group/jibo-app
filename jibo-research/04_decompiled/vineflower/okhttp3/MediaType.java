package okhttp3;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MediaType {
   private static final Pattern a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
   private static final Pattern b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
   private final String c;
   private final String d;
   private final String e;
   private final String f;

   private MediaType(String var1, String var2, String var3, String var4) {
      this.c = var1;
      this.d = var2;
      this.e = var3;
      this.f = var4;
   }

   public static MediaType a(String var0) {
      Object var5 = null;
      Matcher var2 = a.matcher(var0);
      MediaType var4;
      if (!var2.lookingAt()) {
         var4 = (MediaType)var5;
      } else {
         String var6 = var2.group(1).toLowerCase(Locale.US);
         String var7 = var2.group(2).toLowerCase(Locale.US);
         Matcher var8 = b.matcher(var0);
         int var1 = var2.end();
         String var3 = null;

         while (true) {
            if (var1 >= var0.length()) {
               var4 = new MediaType(var0, var6, var7, var3);
               break;
            }

            var8.region(var1, var0.length());
            var4 = (MediaType)var5;
            if (!var8.lookingAt()) {
               break;
            }

            String var10 = var8.group(1);
            String var9 = var3;
            if (var10 != null) {
               if (!var10.equalsIgnoreCase("charset")) {
                  var9 = var3;
               } else {
                  String var11 = var8.group(2);
                  if (var11 != null) {
                     var9 = var11;
                     if (var11.startsWith("'")) {
                        var9 = var11;
                        if (var11.endsWith("'")) {
                           var9 = var11;
                           if (var11.length() > 2) {
                              var9 = var11.substring(1, var11.length() - 1);
                           }
                        }
                     }
                  } else {
                     var9 = var8.group(3);
                  }

                  if (var3 != null) {
                     var4 = (MediaType)var5;
                     if (!var9.equalsIgnoreCase(var3)) {
                        break;
                     }
                  }
               }
            }

            var1 = var8.end();
            var3 = var9;
         }
      }

      return var4;
   }

   public String a() {
      return this.d;
   }

   public Charset a(Charset var1) {
      Charset var2 = var1;

      try {
         if (this.f != null) {
            var2 = Charset.forName(this.f);
         }
      } catch (IllegalArgumentException var3) {
         var2 = var1;
      }

      return var2;
   }

   public Charset b() {
      return this.a((Charset)null);
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2;
      if (var1 instanceof MediaType && ((MediaType)var1).c.equals(this.c)) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   @Override
   public int hashCode() {
      return this.c.hashCode();
   }

   @Override
   public String toString() {
      return this.c;
   }
}
