package com.jibo.aws.integration.aws.services.oobe.model;

import com.google.gson.annotations.Expose;

public class GetStatusRequest extends JiboOobeRequest {
   @Expose
   private String token;

   public GetStatusRequest(String var1) {
      this.token = var1;
   }

   public String getToken() {
      return this.token;
   }

   @Override
   public int hashCode() {
      int var1;
      if (this.getToken() == null) {
         var1 = 0;
      } else {
         var1 = this.getToken().hashCode();
      }

      return var1 + 31;
   }

   public void setToken(String var1) {
      this.token = var1;
   }
}
