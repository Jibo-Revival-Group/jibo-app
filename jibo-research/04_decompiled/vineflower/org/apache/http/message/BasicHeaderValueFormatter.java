package org.apache.http.message;

import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@Immutable
public class BasicHeaderValueFormatter implements HeaderValueFormatter {
   @Deprecated
   public static final BasicHeaderValueFormatter DEFAULT = new BasicHeaderValueFormatter();
   public static final BasicHeaderValueFormatter INSTANCE = new BasicHeaderValueFormatter();
   public static final String SEPARATORS = " ;,:@()<>\\\"/[]?={}\t";
   public static final String UNSAFE_CHARS = "\"\\";

   public static String formatElements(HeaderElement[] var0, boolean var1, HeaderValueFormatter var2) {
      if (var2 == null) {
         var2 = INSTANCE;
      }

      return var2.formatElements(null, var0, var1).toString();
   }

   public static String formatHeaderElement(HeaderElement var0, boolean var1, HeaderValueFormatter var2) {
      if (var2 == null) {
         var2 = INSTANCE;
      }

      return var2.formatHeaderElement(null, var0, var1).toString();
   }

   public static String formatNameValuePair(NameValuePair var0, boolean var1, HeaderValueFormatter var2) {
      if (var2 == null) {
         var2 = INSTANCE;
      }

      return var2.formatNameValuePair(null, var0, var1).toString();
   }

   public static String formatParameters(NameValuePair[] var0, boolean var1, HeaderValueFormatter var2) {
      if (var2 == null) {
         var2 = INSTANCE;
      }

      return var2.formatParameters(null, var0, var1).toString();
   }

   protected void doFormatValue(CharArrayBuffer var1, String var2, boolean var3) {
      byte var6 = 0;
      boolean var7 = var3;
      if (!var3) {
         int var5 = 0;

         while (true) {
            var7 = var3;
            if (var5 >= var2.length()) {
               break;
            }

            var7 = var3;
            if (var3) {
               break;
            }

            var3 = this.isSeparator(var2.charAt(var5));
            var5++;
         }
      }

      int var8 = var6;
      if (var7) {
         var1.append('"');
         var8 = var6;
      }

      while (var8 < var2.length()) {
         char var4 = var2.charAt(var8);
         if (this.isUnsafe(var4)) {
            var1.append('\\');
         }

         var1.append(var4);
         var8++;
      }

      if (var7) {
         var1.append('"');
      }
   }

   protected int estimateElementsLen(HeaderElement[] var1) {
      int var2 = 0;
      int var4 = var2;
      if (var1 != null) {
         if (var1.length < 1) {
            var4 = var2;
         } else {
            var2 = var1.length;
            int var5 = var1.length;
            var2 = (var2 - 1) * 2;
            int var3 = 0;

            while (true) {
               var4 = var2;
               if (var3 >= var5) {
                  break;
               }

               var4 = this.estimateHeaderElementLen(var1[var3]);
               var3++;
               var2 += var4;
            }
         }
      }

      return var4;
   }

   protected int estimateHeaderElementLen(HeaderElement var1) {
      int var4 = 0;
      int var3;
      if (var1 == null) {
         var3 = 0;
      } else {
         var3 = var1.getName().length();
         String var6 = var1.getValue();
         int var2 = var3;
         if (var6 != null) {
            var2 = var3 + var6.length() + 3;
         }

         int var5 = var1.getParameterCount();
         var3 = var2;
         if (var5 > 0) {
            while (true) {
               var3 = var2;
               if (var4 >= var5) {
                  break;
               }

               var2 += this.estimateNameValuePairLen(var1.getParameter(var4)) + 2;
               var4++;
            }
         }
      }

      return var3;
   }

   protected int estimateNameValuePairLen(NameValuePair var1) {
      int var2;
      if (var1 == null) {
         var2 = 0;
      } else {
         int var3 = var1.getName().length();
         String var4 = var1.getValue();
         var2 = var3;
         if (var4 != null) {
            var2 = var3 + var4.length() + 3;
         }
      }

      return var2;
   }

   protected int estimateParametersLen(NameValuePair[] var1) {
      int var2 = 0;
      int var4 = var2;
      if (var1 != null) {
         if (var1.length < 1) {
            var4 = var2;
         } else {
            var2 = var1.length;
            int var5 = var1.length;
            var2 = (var2 - 1) * 2;
            int var3 = 0;

            while (true) {
               var4 = var2;
               if (var3 >= var5) {
                  break;
               }

               var4 = this.estimateNameValuePairLen(var1[var3]);
               var3++;
               var2 += var4;
            }
         }
      }

      return var4;
   }

   @Override
   public CharArrayBuffer formatElements(CharArrayBuffer var1, HeaderElement[] var2, boolean var3) {
      Args.notNull(var2, "Header element array");
      int var4 = this.estimateElementsLen(var2);
      if (var1 == null) {
         var1 = new CharArrayBuffer(var4);
      } else {
         var1.ensureCapacity(var4);
      }

      for (int var5 = 0; var5 < var2.length; var5++) {
         if (var5 > 0) {
            var1.append(", ");
         }

         this.formatHeaderElement(var1, var2[var5], var3);
      }

      return var1;
   }

   @Override
   public CharArrayBuffer formatHeaderElement(CharArrayBuffer var1, HeaderElement var2, boolean var3) {
      Args.notNull(var2, "Header element");
      int var4 = this.estimateHeaderElementLen(var2);
      if (var1 == null) {
         var1 = new CharArrayBuffer(var4);
      } else {
         var1.ensureCapacity(var4);
      }

      var1.append(var2.getName());
      String var6 = var2.getValue();
      if (var6 != null) {
         var1.append('=');
         this.doFormatValue(var1, var6, var3);
      }

      int var5 = var2.getParameterCount();
      if (var5 > 0) {
         for (int var7 = 0; var7 < var5; var7++) {
            var1.append("; ");
            this.formatNameValuePair(var1, var2.getParameter(var7), var3);
         }
      }

      return var1;
   }

   @Override
   public CharArrayBuffer formatNameValuePair(CharArrayBuffer var1, NameValuePair var2, boolean var3) {
      Args.notNull(var2, "Name / value pair");
      int var4 = this.estimateNameValuePairLen(var2);
      if (var1 == null) {
         var1 = new CharArrayBuffer(var4);
      } else {
         var1.ensureCapacity(var4);
      }

      var1.append(var2.getName());
      String var5 = var2.getValue();
      if (var5 != null) {
         var1.append('=');
         this.doFormatValue(var1, var5, var3);
      }

      return var1;
   }

   @Override
   public CharArrayBuffer formatParameters(CharArrayBuffer var1, NameValuePair[] var2, boolean var3) {
      Args.notNull(var2, "Header parameter array");
      int var4 = this.estimateParametersLen(var2);
      if (var1 == null) {
         var1 = new CharArrayBuffer(var4);
      } else {
         var1.ensureCapacity(var4);
      }

      for (int var5 = 0; var5 < var2.length; var5++) {
         if (var5 > 0) {
            var1.append("; ");
         }

         this.formatNameValuePair(var1, var2[var5], var3);
      }

      return var1;
   }

   protected boolean isSeparator(char var1) {
      boolean var2;
      if (" ;,:@()<>\\\"/[]?={}\t".indexOf(var1) >= 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   protected boolean isUnsafe(char var1) {
      boolean var2;
      if ("\"\\".indexOf(var1) >= 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }
}
