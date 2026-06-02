package com.jibo.aws.integration.aws.services.accountAdmin.model;

import com.google.gson.annotations.Expose;
import com.jibo.aws.integration.aws.services.common.model.IdRequestAbstract;

public class ActivateByIdRequest extends IdRequestAbstract {
   @Expose
   private String id;

   public ActivateByIdRequest(String var1) {
      super(var1);
   }

   @Override
   public String getId() {
      return this.id;
   }

   @Override
   public String getServiceAbbr() {
      return "accountadmin";
   }

   @Override
   public String getServicePrefix() {
      return "Account_20151111.";
   }

   @Override
   public void setId(String var1) {
      this.id = var1;
   }

   @Override
   public String toString() {
      return "ActivateByIdRequest {id='" + this.id + '\'' + '}';
   }
}
