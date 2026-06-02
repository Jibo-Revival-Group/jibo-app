package com.jibo.aws.integration.aws.services.common.model;

public abstract class EmptyRequest extends JiboRequestAbstract {
   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (var1 == null) {
            var2 = false;
         } else if (!(var1 instanceof EmptyRequest)) {
            var2 = false;
         }
      }

      return var2;
   }

   @Override
   public int hashCode() {
      return 1;
   }

   @Override
   public String toString() {
      return "EmptyRequest {}";
   }
}
