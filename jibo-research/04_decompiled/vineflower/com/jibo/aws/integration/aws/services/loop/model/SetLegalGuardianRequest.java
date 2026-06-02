package com.jibo.aws.integration.aws.services.loop.model;

import com.google.gson.annotations.Expose;

public class SetLegalGuardianRequest extends JiboLoopRequest {
   @Expose
   private String childId;
   @Expose
   private String parentId;

   public SetLegalGuardianRequest(String var1, String var2, String var3) {
      super(var1);
      this.childId = var2;
      this.parentId = var3;
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
            if (var1 instanceof SetLegalGuardianRequest) {
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

                  if (var1.getChildId() == null) {
                     var2 = true;
                  } else {
                     var2 = false;
                  }

                  if (this.getChildId() == null) {
                     var3 = true;
                  } else {
                     var3 = false;
                  }

                  var4 = var5;
                  if (!(var2 ^ var3)) {
                     if (var1.getChildId() != null) {
                        var4 = var5;
                        if (!var1.getChildId().equals(this.getChildId())) {
                           return var4;
                        }
                     }

                     if (var1.getParentId() == null) {
                        var2 = true;
                     } else {
                        var2 = false;
                     }

                     if (this.getParentId() == null) {
                        var3 = true;
                     } else {
                        var3 = false;
                     }

                     var4 = var5;
                     if (!(var2 ^ var3)) {
                        if (var1.getParentId() != null) {
                           var4 = var5;
                           if (!var1.getParentId().equals(this.getParentId())) {
                              return var4;
                           }
                        }

                        if (var1.getParentId() != null) {
                           var4 = var5;
                           if (!var1.getParentId().equals(this.getParentId())) {
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

   public String getChildId() {
      return this.childId;
   }

   public String getParentId() {
      return this.parentId;
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
      if (this.getChildId() == null) {
         var2 = 0;
      } else {
         var2 = this.getChildId().hashCode();
      }

      if (this.getParentId() != null) {
         var3 = this.getParentId().hashCode();
      }

      return (var2 + (var1 + 31) * 31) * 31 + var3;
   }

   public void setChildId(String var1) {
      this.childId = var1;
   }

   public void setParentId(String var1) {
      this.parentId = var1;
   }

   @Override
   public String toString() {
      return "SetLegalGuardianRequest {loopId='" + this.loopId + '\'' + ", childId='" + this.childId + '\'' + ", parentId='" + this.parentId + '\'' + '}';
   }
}
