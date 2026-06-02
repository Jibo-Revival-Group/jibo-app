package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.Beta;
import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import com.google.api.client.repackaged.com.google.common.annotations.GwtIncompatible;
import java.util.Arrays;
import java.util.BitSet;

@Beta
@GwtCompatible(emulated = true)
public abstract class CharMatcher implements Predicate<Character> {
   public static final CharMatcher ANY;
   public static final CharMatcher ASCII = inRange('\u0000', '\u007f', "CharMatcher.ASCII");
   public static final CharMatcher BREAKING_WHITESPACE = new CharMatcher() {
      @Override
      public boolean matches(char var1) {
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
         return "CharMatcher.BREAKING_WHITESPACE";
      }
   };
   public static final CharMatcher DIGIT;
   private static final int DISTINCT_CHARS = 65536;
   public static final CharMatcher INVISIBLE;
   public static final CharMatcher JAVA_DIGIT;
   public static final CharMatcher JAVA_ISO_CONTROL;
   public static final CharMatcher JAVA_LETTER;
   public static final CharMatcher JAVA_LETTER_OR_DIGIT;
   public static final CharMatcher JAVA_LOWER_CASE;
   public static final CharMatcher JAVA_UPPER_CASE;
   private static final String NINES;
   public static final CharMatcher NONE;
   public static final CharMatcher SINGLE_WIDTH;
   public static final CharMatcher WHITESPACE;
   static final int WHITESPACE_MULTIPLIER = 1682554634;
   static final int WHITESPACE_SHIFT;
   static final String WHITESPACE_TABLE = " 　\r\u0085   　\u2029\u000b　   　 \t     \f 　 　　\u2028\n 　";
   private static final String ZEROES = "0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０";
   final String description;

   static {
      StringBuilder var1 = new StringBuilder("0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".length());

      for (int var0 = 0; var0 < "0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".length(); var0++) {
         var1.append((char)("0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".charAt(var0) + '\t'));
      }

      NINES = var1.toString();
      DIGIT = new CharMatcher.RangesMatcher("CharMatcher.DIGIT", "0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray(), NINES.toCharArray());
      JAVA_DIGIT = new CharMatcher("CharMatcher.JAVA_DIGIT") {
         @Override
         public boolean matches(char var1) {
            return Character.isDigit(var1);
         }
      };
      JAVA_LETTER = new CharMatcher("CharMatcher.JAVA_LETTER") {
         @Override
         public boolean matches(char var1) {
            return Character.isLetter(var1);
         }
      };
      JAVA_LETTER_OR_DIGIT = new CharMatcher("CharMatcher.JAVA_LETTER_OR_DIGIT") {
         @Override
         public boolean matches(char var1) {
            return Character.isLetterOrDigit(var1);
         }
      };
      JAVA_UPPER_CASE = new CharMatcher("CharMatcher.JAVA_UPPER_CASE") {
         @Override
         public boolean matches(char var1) {
            return Character.isUpperCase(var1);
         }
      };
      JAVA_LOWER_CASE = new CharMatcher("CharMatcher.JAVA_LOWER_CASE") {
         @Override
         public boolean matches(char var1) {
            return Character.isLowerCase(var1);
         }
      };
      JAVA_ISO_CONTROL = inRange('\u0000', '\u001f').or(inRange('\u007f', '\u009f')).withToString("CharMatcher.JAVA_ISO_CONTROL");
      INVISIBLE = new CharMatcher.RangesMatcher(
         "CharMatcher.INVISIBLE",
         "\u0000\u007f\u00ad\u0600\u061c\u06dd\u070f \u180e \u2028 \u2066\u2067\u2068\u2069\u206a　\ud800\ufeff\ufff9\ufffa".toCharArray(),
         "  \u00ad\u0604\u061c\u06dd\u070f \u180e\u200f \u2064\u2066\u2067\u2068\u2069\u206f　\uf8ff\ufeff\ufff9\ufffb".toCharArray()
      );
      SINGLE_WIDTH = new CharMatcher.RangesMatcher(
         "CharMatcher.SINGLE_WIDTH", "\u0000־א׳\u0600ݐ\u0e00Ḁ℀ﭐﹰ｡".toCharArray(), "ӹ־ת״ۿݿ\u0e7f₯℺\ufdff\ufeffￜ".toCharArray()
      );
      ANY = new CharMatcher.FastMatcher("CharMatcher.ANY") {
         @Override
         public CharMatcher and(CharMatcher var1) {
            return Preconditions.checkNotNull(var1);
         }

         @Override
         public String collapseFrom(CharSequence var1, char var2) {
            if (var1.length() == 0) {
               var1 = "";
            } else {
               var1 = String.valueOf(var2);
            }

            return var1;
         }

         @Override
         public int countIn(CharSequence var1) {
            return var1.length();
         }

         @Override
         public int indexIn(CharSequence var1) {
            byte var2;
            if (var1.length() == 0) {
               var2 = -1;
            } else {
               var2 = 0;
            }

            return var2;
         }

         @Override
         public int indexIn(CharSequence var1, int var2) {
            int var4 = var1.length();
            Preconditions.checkPositionIndex(var2, var4);
            int var3 = var2;
            if (var2 == var4) {
               var3 = -1;
            }

            return var3;
         }

         @Override
         public int lastIndexIn(CharSequence var1) {
            return var1.length() - 1;
         }

         @Override
         public boolean matches(char var1) {
            return true;
         }

         @Override
         public boolean matchesAllOf(CharSequence var1) {
            Preconditions.checkNotNull(var1);
            return true;
         }

         @Override
         public boolean matchesNoneOf(CharSequence var1) {
            boolean var2;
            if (var1.length() == 0) {
               var2 = true;
            } else {
               var2 = false;
            }

            return var2;
         }

         @Override
         public CharMatcher negate() {
            return NONE;
         }

         @Override
         public CharMatcher or(CharMatcher var1) {
            Preconditions.checkNotNull(var1);
            return this;
         }

         @Override
         public String removeFrom(CharSequence var1) {
            Preconditions.checkNotNull(var1);
            return "";
         }

         @Override
         public String replaceFrom(CharSequence var1, char var2) {
            char[] var3 = new char[var1.length()];
            Arrays.fill(var3, var2);
            return new String(var3);
         }

         @Override
         public String replaceFrom(CharSequence var1, CharSequence var2) {
            StringBuilder var4 = new StringBuilder(var1.length() * var2.length());

            for (int var3 = 0; var3 < var1.length(); var3++) {
               var4.append(var2);
            }

            return var4.toString();
         }

         @Override
         public String trimFrom(CharSequence var1) {
            Preconditions.checkNotNull(var1);
            return "";
         }
      };
      NONE = new CharMatcher.FastMatcher("CharMatcher.NONE") {
         @Override
         public CharMatcher and(CharMatcher var1) {
            Preconditions.checkNotNull(var1);
            return this;
         }

         @Override
         public String collapseFrom(CharSequence var1, char var2) {
            return var1.toString();
         }

         @Override
         public int countIn(CharSequence var1) {
            Preconditions.checkNotNull(var1);
            return 0;
         }

         @Override
         public int indexIn(CharSequence var1) {
            Preconditions.checkNotNull(var1);
            return -1;
         }

         @Override
         public int indexIn(CharSequence var1, int var2) {
            Preconditions.checkPositionIndex(var2, var1.length());
            return -1;
         }

         @Override
         public int lastIndexIn(CharSequence var1) {
            Preconditions.checkNotNull(var1);
            return -1;
         }

         @Override
         public boolean matches(char var1) {
            return false;
         }

         @Override
         public boolean matchesAllOf(CharSequence var1) {
            boolean var2;
            if (var1.length() == 0) {
               var2 = true;
            } else {
               var2 = false;
            }

            return var2;
         }

         @Override
         public boolean matchesNoneOf(CharSequence var1) {
            Preconditions.checkNotNull(var1);
            return true;
         }

         @Override
         public CharMatcher negate() {
            return ANY;
         }

         @Override
         public CharMatcher or(CharMatcher var1) {
            return Preconditions.checkNotNull(var1);
         }

         @Override
         public String removeFrom(CharSequence var1) {
            return var1.toString();
         }

         @Override
         public String replaceFrom(CharSequence var1, char var2) {
            return var1.toString();
         }

         @Override
         public String replaceFrom(CharSequence var1, CharSequence var2) {
            Preconditions.checkNotNull(var2);
            return var1.toString();
         }

         @Override
         public String trimFrom(CharSequence var1) {
            return var1.toString();
         }

         @Override
         public String trimLeadingFrom(CharSequence var1) {
            return var1.toString();
         }

         @Override
         public String trimTrailingFrom(CharSequence var1) {
            return var1.toString();
         }
      };
      WHITESPACE_SHIFT = Integer.numberOfLeadingZeros(" 　\r\u0085   　\u2029\u000b　   　 \t     \f 　 　　\u2028\n 　".length() - 1);
      WHITESPACE = new CharMatcher.FastMatcher("WHITESPACE") {
         @Override
         public boolean matches(char var1) {
            boolean var2;
            if (" 　\r\u0085   　\u2029\u000b　   　 \t     \f 　 　　\u2028\n 　".charAt(1682554634 * var1 >>> WHITESPACE_SHIFT) == var1) {
               var2 = true;
            } else {
               var2 = false;
            }

            return var2;
         }

         @GwtIncompatible("java.util.BitSet")
         @Override
         void setBits(BitSet var1) {
            for (int var2 = 0; var2 < " 　\r\u0085   　\u2029\u000b　   　 \t     \f 　 　　\u2028\n 　".length(); var2++) {
               var1.set(" 　\r\u0085   　\u2029\u000b　   　 \t     \f 　 　　\u2028\n 　".charAt(var2));
            }
         }
      };
   }

   protected CharMatcher() {
      this.description = super.toString();
   }

   CharMatcher(String var1) {
      this.description = var1;
   }

   public static CharMatcher anyOf(CharSequence var0) {
      int var1 = 0;
      CharMatcher var5;
      switch (var0.length()) {
         case 0:
            var5 = NONE;
            break;
         case 1:
            var5 = is(var0.charAt(0));
            break;
         case 2:
            var5 = isEither(var0.charAt(0), var0.charAt(1));
            break;
         default:
            char[] var4 = var0.toString().toCharArray();
            Arrays.sort(var4);
            StringBuilder var3 = new StringBuilder("CharMatcher.anyOf(\"");

            for (int var2 = var4.length; var1 < var2; var1++) {
               var3.append(showCharacter(var4[var1]));
            }

            var3.append("\")");
            var5 = new CharMatcher(var3.toString(), var4) {
               final char[] val$chars;

               {
                  this.val$chars = var2;
               }

               @Override
               public boolean matches(char var1) {
                  boolean var2;
                  if (Arrays.binarySearch(this.val$chars, var1) >= 0) {
                     var2 = true;
                  } else {
                     var2 = false;
                  }

                  return var2;
               }

               @GwtIncompatible("java.util.BitSet")
               @Override
               void setBits(BitSet var1) {
                  char[] var4x = this.val$chars;
                  int var3x = var4x.length;

                  for (int var2 = 0; var2 < var3x; var2++) {
                     var1.set(var4x[var2]);
                  }
               }
            };
      }

      return var5;
   }

   private String finishCollapseFrom(CharSequence var1, int var2, int var3, char var4, StringBuilder var5, boolean var6) {
      boolean var8 = var6;

      while (var2 < var3) {
         char var7 = var1.charAt(var2);
         if (this.matches(var7)) {
            var6 = var8;
            if (!var8) {
               var5.append(var4);
               var6 = true;
            }
         } else {
            var5.append(var7);
            var6 = false;
         }

         var2++;
         var8 = var6;
      }

      return var5.toString();
   }

   public static CharMatcher forPredicate(Predicate<? super Character> var0) {
      Preconditions.checkNotNull(var0);
      if (var0 instanceof CharMatcher) {
         var0 = var0;
      } else {
         var0 = new CharMatcher("CharMatcher.forPredicate(" + var0 + ")", var0) {
            final Predicate val$predicate;

            {
               this.val$predicate = var2;
            }

            @Override
            public boolean apply(Character var1) {
               return this.val$predicate.apply(Preconditions.checkNotNull(var1));
            }

            @Override
            public boolean matches(char var1) {
               return this.val$predicate.apply(var1);
            }
         };
      }

      return var0;
   }

   public static CharMatcher inRange(char var0, char var1) {
      boolean var2;
      if (var1 >= var0) {
         var2 = true;
      } else {
         var2 = false;
      }

      Preconditions.checkArgument(var2);
      return inRange(var0, var1, "CharMatcher.inRange('" + showCharacter(var0) + "', '" + showCharacter(var1) + "')");
   }

   static CharMatcher inRange(char var0, char var1, String var2) {
      return new CharMatcher.FastMatcher(var2, var0, var1) {
         final char val$endInclusive;
         final char val$startInclusive;

         {
            this.val$startInclusive = var2x;
            this.val$endInclusive = var3;
         }

         @Override
         public boolean matches(char var1) {
            boolean var2x;
            if (this.val$startInclusive <= var1 && var1 <= this.val$endInclusive) {
               var2x = true;
            } else {
               var2x = false;
            }

            return var2x;
         }

         @GwtIncompatible("java.util.BitSet")
         @Override
         void setBits(BitSet var1) {
            var1.set(this.val$startInclusive, this.val$endInclusive + 1);
         }
      };
   }

   public static CharMatcher is(char var0) {
      return new CharMatcher.FastMatcher("CharMatcher.is('" + showCharacter(var0) + "')", var0) {
         final char val$match;

         {
            this.val$match = var2;
         }

         @Override
         public CharMatcher and(CharMatcher var1) {
            if (var1.matches(this.val$match)) {
               var1 = this;
            } else {
               var1 = NONE;
            }

            return var1;
         }

         @Override
         public boolean matches(char var1) {
            boolean var2;
            if (var1 == this.val$match) {
               var2 = true;
            } else {
               var2 = false;
            }

            return var2;
         }

         @Override
         public CharMatcher negate() {
            return isNot(this.val$match);
         }

         @Override
         public CharMatcher or(CharMatcher var1) {
            if (!var1.matches(this.val$match)) {
               var1 = super.or(var1);
            }

            return var1;
         }

         @Override
         public String replaceFrom(CharSequence var1, char var2) {
            return var1.toString().replace(this.val$match, var2);
         }

         @GwtIncompatible("java.util.BitSet")
         @Override
         void setBits(BitSet var1) {
            var1.set(this.val$match);
         }
      };
   }

   private static CharMatcher isEither(char var0, char var1) {
      return new CharMatcher.FastMatcher("CharMatcher.anyOf(\"" + showCharacter(var0) + showCharacter(var1) + "\")", var0, var1) {
         final char val$match1;
         final char val$match2;

         {
            this.val$match1 = var2;
            this.val$match2 = var3;
         }

         @Override
         public boolean matches(char var1) {
            boolean var2;
            if (var1 != this.val$match1 && var1 != this.val$match2) {
               var2 = false;
            } else {
               var2 = true;
            }

            return var2;
         }

         @GwtIncompatible("java.util.BitSet")
         @Override
         void setBits(BitSet var1) {
            var1.set(this.val$match1);
            var1.set(this.val$match2);
         }
      };
   }

   public static CharMatcher isNot(char var0) {
      return new CharMatcher.FastMatcher("CharMatcher.isNot('" + showCharacter(var0) + "')", var0) {
         final char val$match;

         {
            this.val$match = var2;
         }

         @Override
         public CharMatcher and(CharMatcher var1) {
            CharMatcher var2 = var1;
            if (var1.matches(this.val$match)) {
               var2 = super.and(var1);
            }

            return var2;
         }

         @Override
         public boolean matches(char var1) {
            boolean var2;
            if (var1 != this.val$match) {
               var2 = true;
            } else {
               var2 = false;
            }

            return var2;
         }

         @Override
         public CharMatcher negate() {
            return is(this.val$match);
         }

         @Override
         public CharMatcher or(CharMatcher var1) {
            CharMatcher var2 = this;
            if (var1.matches(this.val$match)) {
               var2 = ANY;
            }

            return var2;
         }

         @GwtIncompatible("java.util.BitSet")
         @Override
         void setBits(BitSet var1) {
            var1.set(0, this.val$match);
            var1.set(this.val$match + 1, 65536);
         }
      };
   }

   @GwtIncompatible("SmallCharMatcher")
   private static boolean isSmall(int var0, int var1) {
      boolean var2;
      if (var0 <= 1023 && var1 > var0 * 4 * 16) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public static CharMatcher noneOf(CharSequence var0) {
      return anyOf(var0).negate();
   }

   @GwtIncompatible("java.util.BitSet")
   private static CharMatcher precomputedPositive(int var0, BitSet var1, String var2) {
      CharMatcher var4;
      switch (var0) {
         case 0:
            var4 = NONE;
            break;
         case 1:
            var4 = is((char)var1.nextSetBit(0));
            break;
         case 2:
            char var3 = (char)var1.nextSetBit(0);
            var4 = isEither(var3, (char)var1.nextSetBit(var3 + 1));
            break;
         default:
            if (isSmall(var0, var1.length())) {
               var4 = SmallCharMatcher.from(var1, var2);
            } else {
               var4 = new CharMatcher.BitSetMatcher(var1, var2);
            }
      }

      return var4;
   }

   private static String showCharacter(char var0) {
      char[] var2 = new char[]{'\\', 'u', '\u0000', '\u0000', '\u0000', '\u0000'};

      for (int var1 = 0; var1 < 4; var1++) {
         var2[5 - var1] = "0123456789ABCDEF".charAt(var0 & 15);
         var0 = (char)(var0 >> 4);
      }

      return String.copyValueOf(var2);
   }

   public CharMatcher and(CharMatcher var1) {
      return new CharMatcher.And(this, Preconditions.checkNotNull(var1));
   }

   @Deprecated
   public boolean apply(Character var1) {
      return this.matches(var1);
   }

   public String collapseFrom(CharSequence var1, char var2) {
      int var6 = var1.length();
      int var4 = 0;

      while (true) {
         if (var4 >= var6) {
            var1 = var1.toString();
            break;
         }

         char var3 = var1.charAt(var4);
         int var5 = var4;
         if (this.matches(var3)) {
            if (var3 != var2 || var4 != var6 - 1 && this.matches(var1.charAt(var4 + 1))) {
               var1 = this.finishCollapseFrom(var1, var4 + 1, var6, var2, new StringBuilder(var6).append(var1.subSequence(0, var4)).append(var2), true);
               break;
            }

            var5 = var4 + 1;
         }

         var4 = var5 + 1;
      }

      return var1;
   }

   public int countIn(CharSequence var1) {
      int var2 = 0;
      int var4 = 0;

      while (var2 < var1.length()) {
         int var3 = var4;
         if (this.matches(var1.charAt(var2))) {
            var3 = var4 + 1;
         }

         var2++;
         var4 = var3;
      }

      return var4;
   }

   public int indexIn(CharSequence var1) {
      int var3 = var1.length();
      int var2 = 0;

      while (true) {
         if (var2 >= var3) {
            var2 = -1;
            break;
         }

         if (this.matches(var1.charAt(var2))) {
            break;
         }

         var2++;
      }

      return var2;
   }

   public int indexIn(CharSequence var1, int var2) {
      int var3 = var1.length();
      Preconditions.checkPositionIndex(var2, var3);

      while (true) {
         if (var2 >= var3) {
            var2 = -1;
            break;
         }

         if (this.matches(var1.charAt(var2))) {
            break;
         }

         var2++;
      }

      return var2;
   }

   public int lastIndexIn(CharSequence var1) {
      int var2 = var1.length() - 1;

      while (true) {
         if (var2 < 0) {
            var2 = -1;
            break;
         }

         if (this.matches(var1.charAt(var2))) {
            break;
         }

         var2--;
      }

      return var2;
   }

   public abstract boolean matches(char var1);

   public boolean matchesAllOf(CharSequence var1) {
      int var2 = var1.length() - 1;

      boolean var3;
      while (true) {
         if (var2 < 0) {
            var3 = true;
            break;
         }

         if (!this.matches(var1.charAt(var2))) {
            var3 = false;
            break;
         }

         var2--;
      }

      return var3;
   }

   public boolean matchesAnyOf(CharSequence var1) {
      boolean var2;
      if (!this.matchesNoneOf(var1)) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public boolean matchesNoneOf(CharSequence var1) {
      boolean var2;
      if (this.indexIn(var1) == -1) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public CharMatcher negate() {
      return new CharMatcher.NegatedMatcher(this);
   }

   public CharMatcher or(CharMatcher var1) {
      return new CharMatcher.Or(this, Preconditions.checkNotNull(var1));
   }

   public CharMatcher precomputed() {
      return Platform.precomputeCharMatcher(this);
   }

   @GwtIncompatible("java.util.BitSet")
   CharMatcher precomputedInternal() {
      BitSet var3 = new BitSet();
      this.setBits(var3);
      int var1 = var3.cardinality();
      CharMatcher var2;
      if (var1 * 2 <= 65536) {
         var2 = precomputedPositive(var1, var3, this.description);
      } else {
         var3.flip(0, 65536);
         String var4;
         if (this.description.endsWith(".negate()")) {
            var4 = this.description.substring(0, this.description.length() - ".negate()".length());
         } else {
            var4 = this.description + ".negate()";
         }

         var2 = new CharMatcher.NegatedFastMatcher(this.toString(), precomputedPositive(65536 - var1, var3, var4));
      }

      return var2;
   }

   public String removeFrom(CharSequence var1) {
      var1 = var1.toString();
      int var2 = this.indexIn(var1);
      if (var2 != -1) {
         char[] var5 = var1.toCharArray();
         int var3 = 1;

         label22:
         while (true) {
            var2++;

            while (var2 != var5.length) {
               if (this.matches(var5[var2])) {
                  var3++;
                  continue label22;
               }

               var5[var2 - var3] = var5[var2];
               var2++;
            }

            var1 = new String(var5, 0, var2 - var3);
            break;
         }
      }

      return var1;
   }

   public String replaceFrom(CharSequence var1, char var2) {
      var1 = var1.toString();
      int var3 = this.indexIn(var1);
      if (var3 != -1) {
         char[] var5 = var1.toCharArray();
         var5[var3] = var2;
         var3++;

         for (; var3 < var5.length; var3++) {
            if (this.matches(var5[var3])) {
               var5[var3] = var2;
            }
         }

         var1 = new String(var5);
      }

      return var1;
   }

   public String replaceFrom(CharSequence var1, CharSequence var2) {
      int var4 = 0;
      int var3 = var2.length();
      if (var3 == 0) {
         var1 = this.removeFrom(var1);
      } else if (var3 == 1) {
         var1 = this.replaceFrom(var1, var2.charAt(0));
      } else {
         var1 = var1.toString();
         var3 = this.indexIn(var1);
         if (var3 != -1) {
            int var7 = var1.length();
            StringBuilder var8 = new StringBuilder(var7 * 3 / 2 + 16);

            int var5;
            int var6;
            do {
               var8.append(var1, var4, var3);
               var8.append(var2);
               var5 = var3 + 1;
               var6 = this.indexIn(var1, var5);
               var4 = var5;
               var3 = var6;
            } while (var6 != -1);

            var8.append(var1, var5, var7);
            var1 = var8.toString();
         }
      }

      return var1;
   }

   public String retainFrom(CharSequence var1) {
      return this.negate().removeFrom(var1);
   }

   @GwtIncompatible("java.util.BitSet")
   void setBits(BitSet var1) {
      for (int var2 = 65535; var2 >= 0; var2--) {
         if (this.matches((char)var2)) {
            var1.set(var2);
         }
      }
   }

   @Override
   public String toString() {
      return this.description;
   }

   public String trimAndCollapseFrom(CharSequence var1, char var2) {
      int var5 = var1.length();
      int var3 = 0;

      while (var3 < var5 && this.matches(var1.charAt(var3))) {
         var3++;
      }

      int var4 = var5 - 1;

      while (var4 > var3 && this.matches(var1.charAt(var4))) {
         var4--;
      }

      if (var3 == 0 && var4 == var5 - 1) {
         var1 = this.collapseFrom(var1, var2);
      } else {
         var1 = this.finishCollapseFrom(var1, var3, var4 + 1, var2, new StringBuilder(var4 + 1 - var3), false);
      }

      return var1;
   }

   public String trimFrom(CharSequence var1) {
      int var3 = var1.length();
      int var2 = 0;

      while (var2 < var3 && this.matches(var1.charAt(var2))) {
         var2++;
      }

      var3--;

      while (var3 > var2 && this.matches(var1.charAt(var3))) {
         var3--;
      }

      return var1.subSequence(var2, var3 + 1).toString();
   }

   public String trimLeadingFrom(CharSequence var1) {
      int var3 = var1.length();
      int var2 = 0;

      while (true) {
         if (var2 >= var3) {
            var1 = "";
            break;
         }

         if (!this.matches(var1.charAt(var2))) {
            var1 = var1.subSequence(var2, var3).toString();
            break;
         }

         var2++;
      }

      return var1;
   }

   public String trimTrailingFrom(CharSequence var1) {
      int var2 = var1.length() - 1;

      while (true) {
         if (var2 < 0) {
            var1 = "";
            break;
         }

         if (!this.matches(var1.charAt(var2))) {
            var1 = var1.subSequence(0, var2 + 1).toString();
            break;
         }

         var2--;
      }

      return var1;
   }

   CharMatcher withToString(String var1) {
      throw new UnsupportedOperationException();
   }

   private static class And extends CharMatcher {
      final CharMatcher first;
      final CharMatcher second;

      And(CharMatcher var1, CharMatcher var2) {
         this(var1, var2, "CharMatcher.and(" + var1 + ", " + var2 + ")");
      }

      And(CharMatcher var1, CharMatcher var2, String var3) {
         super(var3);
         this.first = Preconditions.checkNotNull(var1);
         this.second = Preconditions.checkNotNull(var2);
      }

      @Override
      public boolean matches(char var1) {
         boolean var2;
         if (this.first.matches(var1) && this.second.matches(var1)) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }

      @GwtIncompatible("java.util.BitSet")
      @Override
      void setBits(BitSet var1) {
         BitSet var3 = new BitSet();
         this.first.setBits(var3);
         BitSet var2 = new BitSet();
         this.second.setBits(var2);
         var3.and(var2);
         var1.or(var3);
      }

      @Override
      CharMatcher withToString(String var1) {
         return new CharMatcher.And(this.first, this.second, var1);
      }
   }

   @GwtIncompatible("java.util.BitSet")
   private static class BitSetMatcher extends CharMatcher.FastMatcher {
      private final BitSet table;

      private BitSetMatcher(BitSet var1, String var2) {
         super(var2);
         if (var1.length() + 64 < var1.size()) {
            var1 = (BitSet)var1.clone();
         }

         this.table = var1;
      }

      @Override
      public boolean matches(char var1) {
         return this.table.get(var1);
      }

      @Override
      void setBits(BitSet var1) {
         var1.or(this.table);
      }
   }

   abstract static class FastMatcher extends CharMatcher {
      FastMatcher() {
      }

      FastMatcher(String var1) {
         super(var1);
      }

      @Override
      public CharMatcher negate() {
         return new CharMatcher.NegatedFastMatcher(this);
      }

      @Override
      public final CharMatcher precomputed() {
         return this;
      }
   }

   static final class NegatedFastMatcher extends CharMatcher.NegatedMatcher {
      NegatedFastMatcher(CharMatcher var1) {
         super(var1);
      }

      NegatedFastMatcher(String var1, CharMatcher var2) {
         super(var1, var2);
      }

      @Override
      public final CharMatcher precomputed() {
         return this;
      }

      @Override
      CharMatcher withToString(String var1) {
         return new CharMatcher.NegatedFastMatcher(var1, this.original);
      }
   }

   private static class NegatedMatcher extends CharMatcher {
      final CharMatcher original;

      NegatedMatcher(CharMatcher var1) {
         this(var1 + ".negate()", var1);
      }

      NegatedMatcher(String var1, CharMatcher var2) {
         super(var1);
         this.original = var2;
      }

      @Override
      public int countIn(CharSequence var1) {
         return var1.length() - this.original.countIn(var1);
      }

      @Override
      public boolean matches(char var1) {
         boolean var2;
         if (!this.original.matches(var1)) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }

      @Override
      public boolean matchesAllOf(CharSequence var1) {
         return this.original.matchesNoneOf(var1);
      }

      @Override
      public boolean matchesNoneOf(CharSequence var1) {
         return this.original.matchesAllOf(var1);
      }

      @Override
      public CharMatcher negate() {
         return this.original;
      }

      @GwtIncompatible("java.util.BitSet")
      @Override
      void setBits(BitSet var1) {
         BitSet var2 = new BitSet();
         this.original.setBits(var2);
         var2.flip(0, 65536);
         var1.or(var2);
      }

      @Override
      CharMatcher withToString(String var1) {
         return new CharMatcher.NegatedMatcher(var1, this.original);
      }
   }

   private static class Or extends CharMatcher {
      final CharMatcher first;
      final CharMatcher second;

      Or(CharMatcher var1, CharMatcher var2) {
         this(var1, var2, "CharMatcher.or(" + var1 + ", " + var2 + ")");
      }

      Or(CharMatcher var1, CharMatcher var2, String var3) {
         super(var3);
         this.first = Preconditions.checkNotNull(var1);
         this.second = Preconditions.checkNotNull(var2);
      }

      @Override
      public boolean matches(char var1) {
         boolean var2;
         if (!this.first.matches(var1) && !this.second.matches(var1)) {
            var2 = false;
         } else {
            var2 = true;
         }

         return var2;
      }

      @GwtIncompatible("java.util.BitSet")
      @Override
      void setBits(BitSet var1) {
         this.first.setBits(var1);
         this.second.setBits(var1);
      }

      @Override
      CharMatcher withToString(String var1) {
         return new CharMatcher.Or(this.first, this.second, var1);
      }
   }

   private static class RangesMatcher extends CharMatcher {
      private final char[] rangeEnds;
      private final char[] rangeStarts;

      RangesMatcher(String var1, char[] var2, char[] var3) {
         super(var1);
         this.rangeStarts = var2;
         this.rangeEnds = var3;
         boolean var5;
         if (var2.length == var3.length) {
            var5 = true;
         } else {
            var5 = false;
         }

         Preconditions.checkArgument(var5);

         for (int var4 = 0; var4 < var2.length; var4++) {
            if (var2[var4] <= var3[var4]) {
               var5 = true;
            } else {
               var5 = false;
            }

            Preconditions.checkArgument(var5);
            if (var4 + 1 < var2.length) {
               if (var3[var4] < var2[var4 + 1]) {
                  var5 = true;
               } else {
                  var5 = false;
               }

               Preconditions.checkArgument(var5);
            }
         }
      }

      @Override
      public boolean matches(char var1) {
         boolean var3 = true;
         int var2 = Arrays.binarySearch(this.rangeStarts, var1);
         if (var2 < 0) {
            var2 = ~var2 - 1;
            if (var2 < 0 || var1 > this.rangeEnds[var2]) {
               var3 = false;
            }
         }

         return var3;
      }
   }
}
