package com.jibo.aws.integration.aws.services.oobe.model;

import com.google.gson.annotations.Expose;

public class SetupRobotRequest extends JiboOobeRequest {
   @Expose
   private String id;
   @Expose
   private String token;

   public SetupRobotRequest(String var1, String var2) {
      this.id = var1;
      this.token = var2;
   }

   public String getId() {
      return this.id;
   }

   public String getToken() {
      return this.token;
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

      if (this.getToken() != null) {
         var2 = this.getToken().hashCode();
      }

      return (var1 + 31) * 31 + var2;
   }

   public void setId(String var1) {
      this.id = var1;
   }

   public void setToken(String var1) {
      this.token = var1;
   }
}
