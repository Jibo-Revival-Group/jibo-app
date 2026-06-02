package com.jibo.aws.integration.aws.services.loop.model;

import com.google.gson.annotations.Expose;
import com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract;
import java.util.List;

public class ListMembersRequest extends JiboRequestAbstract {
   @Expose
   private List<String> statusList;
   @Expose
   private List<String> typeList;

   public ListMembersRequest(List<String> var1, List<String> var2) {
      this.statusList = var1;
      this.typeList = var2;
   }

   @Override
   public String getServiceAbbr() {
      return "loop";
   }

   @Override
   public String getServiceMethodName() {
      return "ListLoopMembers";
   }

   @Override
   public String getServicePrefix() {
      return "Loop_20160324.";
   }

   public List<String> getStatusList() {
      return this.statusList;
   }

   public List<String> getTypeList() {
      return this.typeList;
   }

   public void setStatusList(List<String> var1) {
      this.statusList = var1;
   }

   public void setTypeList(List<String> var1) {
      this.typeList = var1;
   }
}
