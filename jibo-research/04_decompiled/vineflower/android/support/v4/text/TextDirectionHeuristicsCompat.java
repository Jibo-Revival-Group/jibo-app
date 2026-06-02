package android.support.v4.text;

import java.util.Locale;

public final class TextDirectionHeuristicsCompat {
   public static final TextDirectionHeuristicCompat a = new TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal(null, false);
   public static final TextDirectionHeuristicCompat b = new TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal(null, true);
   public static final TextDirectionHeuristicCompat c = new TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal(
      TextDirectionHeuristicsCompat.FirstStrong.a, false
   );
   public static final TextDirectionHeuristicCompat d = new TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal(
      TextDirectionHeuristicsCompat.FirstStrong.a, true
   );
   public static final TextDirectionHeuristicCompat e = new TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal(
      TextDirectionHeuristicsCompat.AnyStrong.a, false
   );
   public static final TextDirectionHeuristicCompat f = TextDirectionHeuristicsCompat.TextDirectionHeuristicLocale.a;

   static int a(int var0) {
      byte var1;
      switch (var0) {
         case 0:
            var1 = 1;
            break;
         case 1:
         case 2:
            var1 = 0;
            break;
         default:
            var1 = 2;
      }

      return var1;
   }

   static int b(int var0) {
      byte var1;
      switch (var0) {
         case 0:
         case 14:
         case 15:
            var1 = 1;
            break;
         case 1:
         case 2:
         case 16:
         case 17:
            var1 = 0;
            break;
         default:
            var1 = 2;
      }

      return var1;
   }

   private static class AnyStrong implements TextDirectionHeuristicsCompat.TextDirectionAlgorithm {
      static final TextDirectionHeuristicsCompat.AnyStrong a = new TextDirectionHeuristicsCompat.AnyStrong(true);
      static final TextDirectionHeuristicsCompat.AnyStrong b = new TextDirectionHeuristicsCompat.AnyStrong(false);
      private final boolean c;

      private AnyStrong(boolean var1) {
         this.c = var1;
      }

      @Override
      public int a(CharSequence var1, int var2, int var3) {
         byte var6 = 1;
         boolean var5 = false;
         int var4 = var2;

         while (true) {
            int var7 = var4;
            if (var7 >= var2 + var3) {
               if (var5) {
                  var12 = var6;
                  if (!this.c) {
                     var12 = 0;
                  }
               } else {
                  var12 = 2;
               }
               break;
            }

            boolean var8;
            switch (TextDirectionHeuristicsCompat.a(Character.getDirectionality(var1.charAt(var7)))) {
               case 0:
                  if (this.c) {
                     var8 = 0;
                     return var8;
                  }

                  var8 = 1;
                  break;
               case 1:
                  var8 = var6;
                  if (!this.c) {
                     return var8;
                  }

                  var8 = 1;
                  break;
               default:
                  var8 = var5;
            }

            var7++;
            var5 = (boolean)var8;
            var4 = var7;
         }

         return var12;
      }
   }

   private static class FirstStrong implements TextDirectionHeuristicsCompat.TextDirectionAlgorithm {
      static final TextDirectionHeuristicsCompat.FirstStrong a = new TextDirectionHeuristicsCompat.FirstStrong();

      @Override
      public int a(CharSequence var1, int var2, int var3) {
         int var5 = 2;

         for (int var4 = var2; var4 < var2 + var3 && var5 == 2; var4++) {
            var5 = TextDirectionHeuristicsCompat.b(Character.getDirectionality(var1.charAt(var4)));
         }

         return var5;
      }
   }

   private interface TextDirectionAlgorithm {
      int a(CharSequence var1, int var2, int var3);
   }

   private abstract static class TextDirectionHeuristicImpl implements TextDirectionHeuristicCompat {
      private final TextDirectionHeuristicsCompat.TextDirectionAlgorithm a;

      TextDirectionHeuristicImpl(TextDirectionHeuristicsCompat.TextDirectionAlgorithm var1) {
         this.a = var1;
      }

      private boolean b(CharSequence var1, int var2, int var3) {
         boolean var4;
         switch (this.a.a(var1, var2, var3)) {
            case 0:
               var4 = true;
               break;
            case 1:
               var4 = false;
               break;
            default:
               var4 = this.a();
         }

         return var4;
      }

      protected abstract boolean a();

      @Override
      public boolean a(CharSequence var1, int var2, int var3) {
         if (var1 != null && var2 >= 0 && var3 >= 0 && var1.length() - var3 >= var2) {
            boolean var4;
            if (this.a == null) {
               var4 = this.a();
            } else {
               var4 = this.b(var1, var2, var3);
            }

            return var4;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   private static class TextDirectionHeuristicInternal extends TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl {
      private final boolean a;

      TextDirectionHeuristicInternal(TextDirectionHeuristicsCompat.TextDirectionAlgorithm var1, boolean var2) {
         super(var1);
         this.a = var2;
      }

      @Override
      protected boolean a() {
         return this.a;
      }
   }

   private static class TextDirectionHeuristicLocale extends TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl {
      static final TextDirectionHeuristicsCompat.TextDirectionHeuristicLocale a = new TextDirectionHeuristicsCompat.TextDirectionHeuristicLocale();

      TextDirectionHeuristicLocale() {
         super(null);
      }

      @Override
      protected boolean a() {
         boolean var1 = true;
         if (TextUtilsCompat.a(Locale.getDefault()) != 1) {
            var1 = false;
         }

         return var1;
      }
   }
}
