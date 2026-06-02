package com.jibo.aws.integration.aws.services.skills.model;

import com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract;

public class JiboSkillsRequest extends JiboRequestAbstract {
   @Override
   public String getServiceAbbr() {
      return "skills";
   }

   @Override
   public String getServicePrefix() {
      return "Settings_20171219.";
   }

   @Override
   public String toString() {
      return "JiboSkillsRequest {}";
   }
}
