package com.jibo.aws.integration.aws.services.person.model;

import com.google.gson.annotations.Expose;
import java.util.List;

public class GetLoopPropertiesRequest extends JiboPersonRequest {
   @Expose
   private List<String> keys;
   @Expose
   private String loopId;

   public GetLoopPropertiesRequest(String var1, List<String> var2) {
      this.loopId = var1;
      this.keys = var2;
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
            if (var1 instanceof GetLoopPropertiesRequest) {
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
                  var4 = var5;
                  if (var1.getLoopId() != null) {
                     var4 = var5;
                     if (var1.getLoopId().equals(this.getLoopId())) {
                        if (var1.getKeys() == null) {
                           var2 = true;
                        } else {
                           var2 = false;
                        }

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
            }
         }
      }

      return var4;
   }

   public List<String> getKeys() {
      return this.keys;
   }

   public String getLoopId() {
      return this.loopId;
   }

   @Override
   public int hashCode() {
      int var2 = 0;
      int var1;
      if (this.getLoopId() == null) {
         var1 = 0;
      } else {
         var1 = this.getLoopId().hashCode();
      }

      if (this.getKeys() != null) {
         var2 = this.getKeys().hashCode();
      }

      return (var1 + 31) * 31 + var2;
   }

   @Override
   public String toString() {
      return this.getClass().getSimpleName() + " {" + "loopId='" + this.loopId + '\'' + "keys='" + this.keys + '\'' + '}';
   }
}
