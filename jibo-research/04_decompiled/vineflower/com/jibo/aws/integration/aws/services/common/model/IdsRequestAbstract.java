package com.jibo.aws.integration.aws.services.common.model;

import com.google.gson.annotations.Expose;
import java.util.List;

public abstract class IdsRequestAbstract extends JiboRequestAbstract {
   @Expose
   private List<String> ids;

   public IdsRequestAbstract(List<String> var1) {
      this.ids = var1;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var5 = false;
      boolean var4;
      if (this == var1) {
         var4 = true;
      } else {
         var4 = var5;
         if (var1 != null) {
            var4 = var5;
            if (var1 instanceof IdsRequestAbstract) {
               var1 = var1;
               boolean var2;
               if (var1.getIds() == null) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               boolean var3;
               if (this.getIds() == null) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               var4 = var5;
               if (!(var2 ^ var3)) {
                  if (var1.getIds() != null) {
                     var4 = var5;
                     if (!var1.getIds().equals(this.getIds())) {
                        return var4;
                     }
                  }

                  var4 = true;
               }
            }
         }
      }

      return var4;
   }

   public List<String> getIds() {
      return this.ids;
   }

   @Override
   public int hashCode() {
      int var1;
      if (this.getIds() == null) {
         var1 = 0;
      } else {
         var1 = this.getIds().hashCode();
      }

      return var1 + 31;
   }

   public void setIds(List<String> var1) {
      this.ids = var1;
   }

   @Override
   public String toString() {
      return "IdsRequest {ids='" + this.ids.toString() + '\'' + '}';
   }
}
