package com.jibo.aws.integration.aws.services.person.model;

import com.google.gson.annotations.Expose;
import java.util.List;

public class GetAccountPropertiesRequest extends JiboPersonRequest {
   @Expose
   private List<String> keys;

   public GetAccountPropertiesRequest(List<String> var1) {
      this.keys = var1;
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
            if (var1 instanceof GetAccountPropertiesRequest) {
               var1 = var1;
               boolean var2;
               if (var1.getKeys() == null) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               boolean var3;
               if (this.getKeys() == null) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               var4 = var5;
               if (!(var2 ^ var3)) {
                  if (var1.getKeys() != null) {
                     var4 = var5;
                     if (!var1.getKeys().equals(this.getKeys())) {
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

   public List<String> getKeys() {
      return this.keys;
   }

   @Override
   public int hashCode() {
      int var1;
      if (this.getKeys() == null) {
         var1 = 0;
      } else {
         var1 = this.getKeys().hashCode();
      }

      return var1 + 31;
   }

   @Override
   public String toString() {
      return this.getClass().getSimpleName() + " {" + "keys='" + this.keys + '\'' + '}';
   }
}
