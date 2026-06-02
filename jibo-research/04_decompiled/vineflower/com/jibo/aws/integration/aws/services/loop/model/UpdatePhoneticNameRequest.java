package com.jibo.aws.integration.aws.services.loop.model;

import com.google.gson.annotations.Expose;

public class UpdatePhoneticNameRequest extends JiboLoopRequest {
   @Expose
   private String id;
   @Expose
   private String phoneticName;

   public UpdatePhoneticNameRequest(String var1, String var2, String var3) {
      super(var1);
      this.id = var2;
      this.phoneticName = var3;
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
            if (var1 instanceof UpdatePhoneticNameRequest) {
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

                  if (var1.getId() == null) {
                     var2 = true;
                  } else {
                     var2 = false;
                  }

                  if (this.getId() == null) {
                     var3 = true;
                  } else {
                     var3 = false;
                  }

                  var4 = var5;
                  if (!(var2 ^ var3)) {
                     if (var1.getId() != null) {
                        var4 = var5;
                        if (!var1.getId().equals(this.getId())) {
                           return var4;
                        }
                     }

                     if (var1.getPhoneticName() == null) {
                        var2 = true;
                     } else {
                        var2 = false;
                     }

                     if (this.getPhoneticName() == null) {
                        var3 = true;
                     } else {
                        var3 = false;
                     }

                     var4 = var5;
                     if (!(var2 ^ var3)) {
                        if (var1.getPhoneticName() != null) {
                           var4 = var5;
                           if (!var1.getPhoneticName().equals(this.getPhoneticName())) {
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

   public String getId() {
      return this.id;
   }

   public String getPhoneticName() {
      return this.phoneticName;
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
      if (this.getId() == null) {
         var2 = 0;
      } else {
         var2 = this.getId().hashCode();
      }

      if (this.getPhoneticName() != null) {
         var3 = this.getPhoneticName().hashCode();
      }

      return (var2 + (var1 + 31) * 31) * 31 + var3;
   }

   public void setId(String var1) {
      this.id = var1;
   }

   public void setPhoneticName(String var1) {
      this.phoneticName = var1;
   }

   @Override
   public String toString() {
      return "UpdatePhoneticNameRequest {loopId='" + this.loopId + '\'' + ", id='" + this.id + '\'' + ", phoneticName='" + this.phoneticName + '\'' + '}';
   }
}
