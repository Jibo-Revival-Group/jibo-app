package com.jibo.aws.integration.aws.services.person.model;

import com.google.gson.JsonObject;

public class SetLoopPropertyRequest extends JiboPersonRequest {
   private String key;
   private String loopId;
   private JsonObject value;

   public SetLoopPropertyRequest(String var1, String var2, JsonObject var3) {
      this.loopId = var1;
      this.key = var2;
      this.value = var3;
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
            if (var1 instanceof SetLoopPropertyRequest) {
               var1 = var1;
               boolean var2;
               if (var1.getLoopId() == null) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               boolean var3;
               if (this.getLoopId() == null) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               var4 = var5;
               if (!(var2 ^ var3)) {
                  if (var1.getLoopId() != null) {
                     var4 = var5;
                     if (!var1.getLoopId().equals(this.getLoopId())) {
                        return var4;
                     }
                  }

                  if (var1.getKey() == null) {
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
      }

      return var4;
   }

   public String getKey() {
      return this.key;
   }

   public String getLoopId() {
      return this.loopId;
   }

   public JsonObject getValue() {
      return this.value;
   }

   @Override
   public int hashCode() {
      int var3 = 0;
      int var1;
      if (this.getLoopId() == null) {
         var1 = 0;
      } else {
         var1 = this.getLoopId().hashCode();
      }

      int var2;
      if (this.getKey() == null) {
         var2 = 0;
      } else {
         var2 = this.getKey().hashCode();
      }

      if (this.getValue() != null) {
         var3 = this.getValue().hashCode();
      }

      return (var2 + (var1 + 31) * 31) * 31 + var3;
   }

   @Override
   public String toString() {
      return this.getClass().getSimpleName() + " {key=" + this.key + ", value=" + this.value.toString() + ", loopId=" + this.loopId + "'}";
   }
}
