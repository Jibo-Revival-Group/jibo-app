package com.jibo.aws.integration.aws.services.file.model;

import com.jibo.aws.integration.aws.services.common.model.EmptyRequest;

public class ListFilesRequest extends EmptyRequest {
   @Override
   public String getServiceAbbr() {
      return "photo";
   }

   @Override
   public String getServicePrefix() {
      return "$TARGET$.";
   }
}
