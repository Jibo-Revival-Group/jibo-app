package com.google.common.base;

import java.util.Arrays;

public abstract class CharMatcher {
   @Deprecated
   public static final CharMatcher a = c();
   @Deprecated
   public static final CharMatcher b = d();
   @Deprecated
   public static final CharMatcher c = e();
   @Deprecated
   public static final CharMatcher d = f();
   @Deprecated
   public static final CharMatcher e = g();
   @Deprecated
   public static final CharMatcher f = h();
   @Deprecated
   public static final CharMatcher g = i();
   @Deprecated
   public static final CharMatcher h = j();
   @Deprecated
   public static final CharMatcher i = k();
   @Deprecated
   public static final CharMatcher j = l();
   @Deprecated
   public static final CharMatcher k = m();
   @Deprecated
   public static final CharMatcher l = n();
   @Deprecated
   public static final CharMatcher m = a();
   @Deprecated
   public static final CharMatcher n = b();

   protected CharMatcher() {
   }

   public static CharMatcher a() {
      return CharMatcher.Any.o;
   }

   public static CharMatcher a(char var0) {
      return new CharMatcher.Is(var0);
   }

   public static CharMatcher b() {
      return CharMatcher.None.o;
   }

   public static CharMatcher c() {
      return CharMatcher.Whitespace.p;
   }

   public static CharMatcher d() {
      return CharMatcher.BreakingWhitespace.o;
   }

   private static String d(char var0) {
      char[] var3 = new char[]{'\\', 'u', '\u0000', '\u0000', '\u0000', '\u0000'};
      byte var2 = 0;
      char var1 = var0;

      for (int var4 = var2; var4 < 4; var4++) {
         var3[5 - var4] = "0123456789ABCDEF".charAt(var1 & 15);
         var1 = (char)(var1 >> 4);
      }

      return String.copyValueOf(var3);
   }

   public static CharMatcher e() {
      return CharMatcher.Ascii.o;
   }

   public static CharMatcher f() {
      return CharMatcher.Digit.o;
   }

   public static CharMatcher g() {
      return CharMatcher.JavaDigit.o;
   }

   public static CharMatcher h() {
      return CharMatcher.JavaLetter.o;
   }

   public static CharMatcher i() {
      return CharMatcher.JavaLetterOrDigit.o;
   }

   public static CharMatcher j() {
      return CharMatcher.JavaUpperCase.o;
   }

   public static CharMatcher k() {
      return CharMatcher.JavaLowerCase.o;
   }

   public static CharMatcher l() {
      return CharMatcher.JavaIsoControl.o;
   }

   public static CharMatcher m() {
      return CharMatcher.Invisible.o;
   }

   public static CharMatcher n() {
      return CharMatcher.SingleWidth.o;
   }

   public int a(CharSequence var1, int var2) {
      int var3 = var1.length();
      Preconditions.a(var2, var3);

      while (true) {
         if (var2 >= var3) {
            var2 = -1;
            break;
         }

         if (this.b(var1.charAt(var2))) {
            break;
         }

         var2++;
      }

      return var2;
   }

   public abstract boolean b(char var1);

   @Override
   public String toString() {
      return super.toString();
   }

   private static final class Any extends CharMatcher.NamedFastMatcher {
      static final CharMatcher.Any o = new CharMatcher.Any();

      private Any() {
         super("CharMatcher.any()");
      }

      @Override
      public int a(CharSequence var1, int var2) {
         int var4 = var1.length();
         Preconditions.a(var2, var4);
         int var3 = var2;
         if (var2 == var4) {
            var3 = -1;
         }

         return var3;
      }

      @Override
      public boolean b(char var1) {
         return true;
      }
   }

   private static final class Ascii extends CharMatcher.NamedFastMatcher {
      static final CharMatcher.Ascii o = new CharMatcher.Ascii();

      Ascii() {
         super("CharMatcher.ascii()");
      }

      @Override
      public boolean b(char var1) {
         boolean var2;
         if (var1 <= 127) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }
   }

   private static final class BreakingWhitespace extends CharMatcher {
      static final CharMatcher o = new CharMatcher.BreakingWhitespace();

      @Override
      public boolean b(char var1) {
         boolean var3 = true;
         boolean var2 = var3;
         switch (var1) {
            case '\t':
            case '\n':
            case '\u000b':
            case '\f':
            case '\r':
            case ' ':
            case '\u0085':
            case ' ':
            case '\u2028':
            case '\u2029':
            case ' ':
            case '　':
               break;
            case ' ':
               var2 = false;
               break;
            default:
               if (var1 >= 8192 && var1 <= 8202) {
                  var2 = var3;
               } else {
                  var2 = false;
               }
         }

         return var2;
      }

      @Override
      public String toString() {
         return "CharMatcher.breakingWhitespace()";
      }
   }

   private static final class Digit extends CharMatcher.RangesMatcher {
      static final CharMatcher.Digit o = new CharMatcher.Digit();

      private Digit() {
         super("CharMatcher.digit()", o(), p());
      }

      private static char[] o() {
         return "0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray();
      }

      private static char[] p() {
         char[] var1 = new char["0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".length()];

         for (int var0 = 0; var0 < "0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".length(); var0++) {
            var1[var0] = (char)("0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".charAt(var0) + '\t');
         }

         return var1;
      }
   }

   abstract static class FastMatcher extends CharMatcher {
   }

   private static final class Invisible extends CharMatcher.RangesMatcher {
      static final CharMatcher.Invisible o = new CharMatcher.Invisible();

      private Invisible() {
         super(
            "CharMatcher.invisible()",
            "\u0000\u007f\u00ad\u0600\u061c\u06dd\u070f \u180e \u2028 \u2066\u2067\u2068\u2069\u206a　\ud800\ufeff\ufff9\ufffa".toCharArray(),
            "  \u00ad\u0604\u061c\u06dd\u070f \u180e\u200f \u2064\u2066\u2067\u2068\u2069\u206f　\uf8ff\ufeff\ufff9\ufffb".toCharArray()
         );
      }
   }

   private static final class Is extends CharMatcher.FastMatcher {
      private final char o;

      Is(char var1) {
         this.o = var1;
      }

      @Override
      public boolean b(char var1) {
         boolean var2;
         if (var1 == this.o) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }

      @Override
      public String toString() {
         return "CharMatcher.is('" + CharMatcher.d(this.o) + "')";
      }
   }

   private static final class JavaDigit extends CharMatcher {
      static final CharMatcher.JavaDigit o = new CharMatcher.JavaDigit();

      @Override
      public boolean b(char var1) {
         return Character.isDigit(var1);
      }

      @Override
      public String toString() {
         return "CharMatcher.javaDigit()";
      }
   }

   private static final class JavaIsoControl extends CharMatcher.NamedFastMatcher {
      static final CharMatcher.JavaIsoControl o = new CharMatcher.JavaIsoControl();

      private JavaIsoControl() {
         super("CharMatcher.javaIsoControl()");
      }

      @Override
      public boolean b(char var1) {
         boolean var2;
         if (var1 > 31 && (var1 < 127 || var1 > 159)) {
            var2 = false;
         } else {
            var2 = true;
         }

         return var2;
      }
   }

   private static final class JavaLetter extends CharMatcher {
      static final CharMatcher.JavaLetter o = new CharMatcher.JavaLetter();

      @Override
      public boolean b(char var1) {
         return Character.isLetter(var1);
      }

      @Override
      public String toString() {
         return "CharMatcher.javaLetter()";
      }
   }

   private static final class JavaLetterOrDigit extends CharMatcher {
      static final CharMatcher.JavaLetterOrDigit o = new CharMatcher.JavaLetterOrDigit();

      @Override
      public boolean b(char var1) {
         return Character.isLetterOrDigit(var1);
      }

      @Override
      public String toString() {
         return "CharMatcher.javaLetterOrDigit()";
      }
   }

   private static final class JavaLowerCase extends CharMatcher {
      static final CharMatcher.JavaLowerCase o = new CharMatcher.JavaLowerCase();

      @Override
      public boolean b(char var1) {
         return Character.isLowerCase(var1);
      }

      @Override
      public String toString() {
         return "CharMatcher.javaLowerCase()";
      }
   }

   private static final class JavaUpperCase extends CharMatcher {
      static final CharMatcher.JavaUpperCase o = new CharMatcher.JavaUpperCase();

      @Override
      public boolean b(char var1) {
         return Character.isUpperCase(var1);
      }

      @Override
      public String toString() {
         return "CharMatcher.javaUpperCase()";
      }
   }

   abstract static class NamedFastMatcher extends CharMatcher.FastMatcher {
      private final String o;

      NamedFastMatcher(String var1) {
         this.o = Preconditions.a(var1);
      }

      @Override
      public final String toString() {
         return this.o;
      }
   }

   private static final class None extends CharMatcher.NamedFastMatcher {
      static final CharMatcher.None o = new CharMatcher.None();

      private None() {
         super("CharMatcher.none()");
      }

      @Override
      public int a(CharSequence var1, int var2) {
         Preconditions.a(var2, var1.length());
         return -1;
      }

      @Override
      public boolean b(char var1) {
         return false;
      }
   }

   private static class RangesMatcher extends CharMatcher {
      private final String o;
      private final char[] p;
      private final char[] q;

      RangesMatcher(String var1, char[] var2, char[] var3) {
         this.o = var1;
         this.p = var2;
         this.q = var3;
         boolean var5;
         if (var2.length == var3.length) {
            var5 = true;
         } else {
            var5 = false;
         }

         Preconditions.a(var5);

         for (int var4 = 0; var4 < var2.length; var4++) {
            if (var2[var4] <= var3[var4]) {
               var5 = true;
            } else {
               var5 = false;
            }

            Preconditions.a(var5);
            if (var4 + 1 < var2.length) {
               if (var3[var4] < var2[var4 + 1]) {
                  var5 = true;
               } else {
                  var5 = false;
               }

               Preconditions.a(var5);
            }
         }
      }

      @Override
      public boolean b(char var1) {
         boolean var3 = true;
         int var2 = Arrays.binarySearch(this.p, var1);
         if (var2 < 0) {
            var2 = ~var2 - 1;
            if (var2 < 0 || var1 > this.q[var2]) {
               var3 = false;
            }
         }

         return var3;
      }

      @Override
      public String toString() {
         return this.o;
      }
   }

   private static final class SingleWidth extends CharMatcher.RangesMatcher {
      static final CharMatcher.SingleWidth o = new CharMatcher.SingleWidth();

      private SingleWidth() {
         super("CharMatcher.singleWidth()", "\u0000־א׳\u0600ݐ\u0e00Ḁ℀ﭐﹰ｡".toCharArray(), "ӹ־ת״ۿݿ\u0e7f₯℺\ufdff\ufeffￜ".toCharArray());
      }
   }

   static final class Whitespace extends CharMatcher.NamedFastMatcher {
      static final int o = Integer.numberOfLeadingZeros(" 　\r\u0085   　\u2029\u000b　   　 \t     \f 　 　　\u2028\n 　".length() - 1);
      static final CharMatcher.Whitespace p = new CharMatcher.Whitespace();

      Whitespace() {
         super("CharMatcher.whitespace()");
      }

      @Override
      public boolean b(char var1) {
         boolean var2;
         if (" 　\r\u0085   　\u2029\u000b　   　 \t     \f 　 　　\u2028\n 　".charAt(1682554634 * var1 >>> o) == var1) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }
   }
}
