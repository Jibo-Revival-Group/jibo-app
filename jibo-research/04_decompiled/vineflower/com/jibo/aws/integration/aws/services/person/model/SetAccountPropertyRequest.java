package com.jibo.aws.integration.aws.services.person.model;

import com.google.gson.JsonObject;

public class SetAccountPropertyRequest extends JiboPersonRequest {
   private String key;
   private JsonObject value;

   public SetAccountPropertyRequest(String var1, JsonObject var2) {
      this.key = var1;
      this.value = var2;
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
            if (var1 instanceof SetAccountPropertyRequest) {
               var1 = var1;
               boolean var2;
               if (var1.getKey() == null) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               boolean var3;
               if (this.getKey() == null) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               var4 = var5;
               if (!(var2 ^ var3)) {
                  if (var1.getKey() != null) {
                     var4 = var5;
                     if (!var1.getKey().equals(this.getKey())) {
                        return var4;
                     }
                  }

                  if (var1.getValue() == null) {
                     var2 = true;
                  } else {
                     var2 = false;
                  }

                  if (this.getKey() == null) {
                     var3 = true;
                  } else {
                     var3 = false;
                  }

                  var4 = var5;
                  if (!(var2 ^ var3)) {
                     if (var1.getValue() != null) {
                        var4 = var5;
                        if (!var1.getValue().equals(this.getValue())) {
                           return var4;
                        }
                     }

                     var4 = true;
                  }
               }
            }
         }
      }

      return var4;
   }

   public String getKey() {
      return this.key;
   }

   public JsonObject getValue() {
      return this.value;
   }

   @Override
   public int hashCode() {
      int var2 = 0;
      int var1;
      if (this.getKey() == null) {
         var1 = 0;
      } else {
         var1 = this.getKey().hashCode();
      }

      if (this.getValue() != null) {
         var2 = this.getValue().hashCode();
      }

      return (var1 + 31) * 31 + var2;
   }

   @Override
   public String toString() {
      return this.getClass().getSimpleName() + " {key=" + this.key + ", value=" + this.value.toString() + "'}";
   }
}
