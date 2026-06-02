package com.jibo.aws.integration.aws.services.account.model;

import com.jibo.aws.integration.aws.services.binary.model.CreateBinaryRequest;
import java.io.File;
import java.util.Map;

public class UpdatePhotoRequest extends CreateBinaryRequest {
   public UpdatePhotoRequest(File var1, Map<String, String> var2) {
      super(null, var1, var2);
   }

   @Override
   public String getServiceAbbr() {
      return "account";
   }

   @Override
   public String getServicePrefix() {
      return "Account_20151111.";
   }

   @Override
   public String toString() {
      return "UpdatePhotoRequest {, body='" + this.body + '\'' + ", meta='" + this.meta + '\'' + '}';
   }
}
