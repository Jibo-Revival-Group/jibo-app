package com.jibo.aws.integration.aws.services.person.model;

import com.google.gson.annotations.Expose;

public class ListHolidaysRequest extends JiboPersonRequest {
   @Expose
   private String loopId;

   public ListHolidaysRequest() {
   }

   public ListHolidaysRequest(String var1) {
      this.loopId = var1;
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
            if (var1 instanceof ListHolidaysRequest) {
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

                  var4 = true;
               }
            }
         }
      }

      return var4;
   }

   public String getLoopId() {
      return this.loopId;
   }

   @Override
   public int hashCode() {
      int var1;
      if (this.getLoopId() == null) {
         var1 = 0;
      } else {
         var1 = this.getLoopId().hashCode();
      }

      return var1 + 31;
   }

   public void setLoopId(String var1) {
      this.loopId = var1;
   }

   @Override
   public String toString() {
      return "ListHolidaysRequest {loopId='" + this.loopId + '\'' + '}';
   }
}
