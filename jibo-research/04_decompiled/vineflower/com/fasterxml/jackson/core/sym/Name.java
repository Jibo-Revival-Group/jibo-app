package com.fasterxml.jackson.core.sym;

public abstract class Name {
   protected final String a;
   protected final int b;

   @Override
   public boolean equals(Object var1) {
      boolean var2;
      if (var1 == this) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      return this.b;
   }

   @Override
   public String toString() {
      return this.a;
   }
}
