package com.jibo.aws.integration.aws.services.key.model;

import com.jibo.aws.integration.aws.services.common.model.IdRequest;

public class GetRequest extends IdRequest {
   public GetRequest(String var1) {
      super(var1);
   }

   @Override
   public String getServiceAbbr() {
      return "key";
   }

   @Override
   public String getServiceMethodName() {
      return "GetRequest";
   }

   @Override
   public String getServicePrefix() {
      return "Key_20160201.";
   }

   @Override
   public String toString() {
      return "GetRequest {id='" + this.getId() + '\'' + '}';
   }
}
