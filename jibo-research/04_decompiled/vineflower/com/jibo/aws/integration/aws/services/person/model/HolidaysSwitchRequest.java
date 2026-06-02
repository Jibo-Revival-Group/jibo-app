package com.jibo.aws.integration.aws.services.person.model;

import com.google.gson.annotations.Expose;
import java.util.List;

public class HolidaysSwitchRequest extends JiboPersonRequest {
   private boolean enable;
   @Expose
   private List<String> ids;
   @Expose
   private String loopId;

   public HolidaysSwitchRequest(boolean var1, List<String> var2, String var3) {
      this.enable = var1;
      this.ids = var2;
      this.loopId = var3;
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
            if (var1 instanceof HolidaysSwitchRequest) {
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

                  if (var1.getIds() == null) {
                     var2 = true;
                  } else {
                     var2 = false;
                  }

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
      }

      return var4;
   }

   public List<String> getIds() {
      return this.ids;
   }

   public String getLoopId() {
      return this.loopId;
   }

   @Override
   public String getServiceMethodName() {
      String var1;
      if (this.enable) {
         var1 = "EnableHolidays";
      } else {
         var1 = "DisableHolidays";
      }

      return var1;
   }

   @Override
   public int hashCode() {
      int var2 = 0;
      int var1;
      if (this.getIds() == null) {
         var1 = 0;
      } else {
         var1 = this.getIds().hashCode();
      }

      if (this.getLoopId() != null) {
         var2 = this.getLoopId().hashCode();
      }

      return (var1 + 31) * 31 + var2;
   }

   public void setIds(List<String> var1) {
      this.ids = var1;
   }

   public void setLoopId(String var1) {
      this.loopId = var1;
   }

   @Override
   public String toString() {
      return this.getClass().getSimpleName() + " {" + "ids='" + this.ids + '\'' + '}';
   }
}
