package com.jibo.aws.integration.aws.services.loop.model;

import com.google.gson.annotations.Expose;

public class RobotRequest extends JiboLoopRequest {
   @Expose
   private String robotId;

   public RobotRequest(String var1, String var2) {
      super(var1);
      this.robotId = var2;
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
            if (var1 instanceof RobotRequest) {
               var1 = var1;
               boolean var2;
               if (var1.getRobotId() == null) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               boolean var3;
               if (this.getRobotId() == null) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               var4 = var5;
               if (!(var2 ^ var3)) {
                  if (var1.getRobotId() != null) {
                     var4 = var5;
                     if (!var1.getRobotId().equals(this.getRobotId())) {
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

   @Override
   public String getLoopId() {
      return this.loopId;
   }

   public String getRobotId() {
      return this.robotId;
   }

   @Override
   public int hashCode() {
      int var2 = 0;
      int var1;
      if (this.getRobotId() == null) {
         var1 = 0;
      } else {
         var1 = this.getRobotId().hashCode();
      }

      if (this.getLoopId() != null) {
         var2 = this.getLoopId().hashCode();
      }

      return (var1 + 31) * 31 + var2;
   }

   @Override
   public void setLoopId(String var1) {
      this.loopId = var1;
   }

   public void setRobotId(String var1) {
      this.robotId = var1;
   }

   @Override
   public String toString() {
      return "RobotRequest {robotId='" + this.robotId + '\'' + "loopId='" + this.loopId + '\'' + '}';
   }
}
