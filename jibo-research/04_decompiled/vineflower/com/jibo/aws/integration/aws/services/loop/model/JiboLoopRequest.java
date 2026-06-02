package com.jibo.aws.integration.aws.services.loop.model;

import com.google.gson.annotations.Expose;
import com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract;

public class JiboLoopRequest extends JiboRequestAbstract {
   @Expose
   protected String loopId;

   public JiboLoopRequest(String var1) {
      this.loopId = var1;
   }

   public String getLoopId() {
      return this.loopId;
   }

   @Override
   public String getServiceAbbr() {
      return "loop";
   }

   @Override
   public String getServicePrefix() {
      return "Loop_20160324.";
   }

   public void setLoopId(String var1) {
      this.loopId = var1;
   }

   @Override
   public String toString() {
      return "LoopIdRequest {loopId='" + this.loopId + '\'' + '}';
   }
}
