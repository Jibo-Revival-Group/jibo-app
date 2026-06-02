package com.google.common.base;

import java.io.IOException;
import java.util.Iterator;

public class Joiner {
   private final String a;

   private Joiner(String var1) {
      this.a = Preconditions.a(var1);
   }

   public static Joiner a(String var0) {
      return new Joiner(var0);
   }

   public <A extends Appendable> A a(A var1, Iterator<?> var2) throws IOException {
      Preconditions.a(var1);
      if (var2.hasNext()) {
         var1.append(this.a(var2.next()));

         while (var2.hasNext()) {
            var1.append(this.a);
            var1.append(this.a(var2.next()));
         }
      }

      return (A)var1;
   }

   CharSequence a(Object var1) {
      Preconditions.a(var1);
      if (var1 instanceof CharSequence) {
         var1 = var1;
      } else {
         var1 = var1.toString();
      }

      return var1;
   }

   public final StringBuilder a(StringBuilder var1, Iterable<?> var2) {
      return this.a(var1, var2.iterator());
   }

   public final StringBuilder a(StringBuilder var1, Iterator<?> var2) {
      try {
         this.a((StringBuilder)var1, var2);
         return var1;
      } catch (IOException var3) {
         throw new AssertionError(var3);
      }
   }
}
