package com.jibo.aws.integration.aws.services.loop.model;

import com.google.gson.annotations.Expose;

public class RemoveMemberRequest extends JiboLoopRequest {
   @Expose
   private String id;

   public RemoveMemberRequest(String var1, String var2) {
      super(var1);
      this.id = var2;
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
            if (var1 instanceof RemoveMemberRequest) {
               var1 = var1;
               boolean var2;
               if (var1.getId() == null) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               boolean var3;
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

                  if (var1.getLoopId() == null) {
                     var2 = true;
                  } else {
                     var2 = false;
                  }

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

                     var4 = true;
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

   @Override
   public String getServiceMethodName() {
      return "RemoveLoopMember";
   }

   @Override
   public int hashCode() {
      int var2 = 0;
      int var1;
      if (this.getId() == null) {
         var1 = 0;
      } else {
         var1 = this.getId().hashCode();
      }

      if (this.getLoopId() != null) {
         var2 = this.getLoopId().hashCode();
      }

      return (var1 + 31) * 31 + var2;
   }

   public void setId(String var1) {
      this.id = var1;
   }

   @Override
   public String toString() {
      return "RemoveMemberRequest {id='" + this.id + '\'' + "loopId='" + this.loopId + '\'' + '}';
   }
}
