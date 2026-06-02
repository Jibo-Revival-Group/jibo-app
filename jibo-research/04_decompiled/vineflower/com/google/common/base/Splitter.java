package com.google.common.base;

import java.util.Iterator;

public final class Splitter {
   private final CharMatcher a;
   private final boolean b;
   private final Splitter.Strategy c;
   private final int d;

   private Splitter(Splitter.Strategy var1) {
      this(var1, false, CharMatcher.b(), Integer.MAX_VALUE);
   }

   private Splitter(Splitter.Strategy var1, boolean var2, CharMatcher var3, int var4) {
      this.c = var1;
      this.b = var2;
      this.a = var3;
      this.d = var4;
   }

   public static Splitter a(char var0) {
      return a(CharMatcher.a(var0));
   }

   public static Splitter a(CharMatcher var0) {
      Preconditions.a(var0);
      return new Splitter(new Splitter.Strategy(var0) {
         final CharMatcher a;

         {
            this.a = var1;
         }

         public Splitter.SplittingIterator a(Splitter var1, CharSequence var2) {
            return new Splitter.SplittingIterator(this, var1, var2) {
               final <unrepresentable> a;

               {
                  this.a = var1;
               }

               @Override
               int a(int var1) {
                  return this.a.a.a(this.b, var1);
               }

               @Override
               int b(int var1) {
                  return var1 + 1;
               }
            };
         }
      });
   }

   private Iterator<String> b(CharSequence var1) {
      return this.c.b(this, var1);
   }

   public Iterable<String> a(CharSequence var1) {
      Preconditions.a(var1);
      return new Iterable<String>(this, var1) {
         final CharSequence a;
         final Splitter b;

         {
            this.b = var1;
            this.a = var2;
         }

         @Override
         public Iterator<String> iterator() {
            return this.b.b(this.a);
         }

         @Override
         public String toString() {
            return Joiner.a(", ").a(new StringBuilder().append('['), this).append(']').toString();
         }
      };
   }

   private abstract static class SplittingIterator extends AbstractIterator<String> {
      final CharSequence b;
      final CharMatcher c;
      final boolean d;
      int e = 0;
      int f;

      protected SplittingIterator(Splitter var1, CharSequence var2) {
         this.c = var1.a;
         this.d = var1.b;
         this.f = var1.d;
         this.b = var2;
      }

      abstract int a(int var1);

      abstract int b(int var1);

      protected String c() {
         int var2 = this.e;

         String var4;
         while (true) {
            if (this.e == -1) {
               var4 = this.b();
               break;
            }

            int var1 = this.a(this.e);
            if (var1 == -1) {
               var1 = this.b.length();
               this.e = -1;
            } else {
               this.e = this.b(var1);
            }

            if (this.e == var2) {
               this.e++;
               if (this.e > this.b.length()) {
                  this.e = -1;
               }
            } else {
               while (var2 < var1 && this.c.b(this.b.charAt(var2))) {
                  var2++;
               }

               while (var1 > var2 && this.c.b(this.b.charAt(var1 - 1))) {
                  var1--;
               }

               if (!this.d || var2 != var1) {
                  int var3;
                  if (this.f == 1) {
                     var1 = this.b.length();
                     this.e = -1;

                     while (true) {
                        var3 = var1;
                        if (var1 <= var2) {
                           break;
                        }

                        var3 = var1;
                        if (!this.c.b(this.b.charAt(var1 - 1))) {
                           break;
                        }

                        var1--;
                     }
                  } else {
                     this.f--;
                     var3 = var1;
                  }

                  var4 = this.b.subSequence(var2, var3).toString();
                  break;
               }

               var2 = this.e;
            }
         }

         return var4;
      }
   }

   private interface Strategy {
      Iterator<String> b(Splitter var1, CharSequence var2);
   }
}
