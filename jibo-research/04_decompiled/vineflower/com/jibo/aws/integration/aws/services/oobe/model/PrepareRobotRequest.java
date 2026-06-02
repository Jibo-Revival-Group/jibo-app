package com.jibo.aws.integration.aws.services.oobe.model;

import com.google.gson.annotations.Expose;

public class PrepareRobotRequest extends JiboOobeRequest {
   @Expose
   private String loopId;

   public PrepareRobotRequest(String var1) {
      this.loopId = var1;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (!(var1 instanceof PrepareRobotRequest)) {
            var2 = false;
         } else {
            var1 = var1;
            if (this.getLoopId() != null) {
               var2 = this.getLoopId().equals(var1.getLoopId());
            } else if (var1.getLoopId() != null) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   public String getLoopId() {
      return this.loopId;
   }

   @Override
   public int hashCode() {
      int var1;
      if (this.getLoopId() != null) {
         var1 = this.getLoopId().hashCode();
      } else {
         var1 = 0;
      }

      return var1;
   }

   public void setLoopId(String var1) {
      this.loopId = var1;
   }

   @Override
   public String toString() {
      return "PrepareRobotRequest{loopId='" + this.loopId + '\'' + '}';
   }
}
