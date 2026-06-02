package com.jibo.aws.integration.aws.services.common.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public abstract class JiboRequestAbstract extends AmazonWebServiceRequest implements Serializable {
   public abstract String getServiceAbbr();

   public String getServiceMethodName() {
      return this.getClass().getSimpleName().replace("Request", "");
   }

   public abstract String getServicePrefix();
}
