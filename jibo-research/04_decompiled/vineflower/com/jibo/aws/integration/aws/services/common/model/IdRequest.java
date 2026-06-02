package com.jibo.aws.integration.aws.services.common.model;

import com.google.gson.annotations.Expose;

public abstract class IdRequest extends IdRequestAbstract {
   @Expose
   private String id;

   public IdRequest(String var1) {
      super(var1);
   }

   @Override
   public String getId() {
      return this.id;
   }

   @Override
   public void setId(String var1) {
      this.id = var1;
   }

   @Override
   public String toString() {
      return "IdRequest {id='" + this.id + '\'' + '}';
   }
}
