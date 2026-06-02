package com.jibo.aws.integration.aws.services.notification.model;

import com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract;

public abstract class JiboNotificationRequest extends JiboRequestAbstract {
   @Override
   public String getServiceAbbr() {
      return "notification";
   }

   @Override
   public String getServicePrefix() {
      return "Notification_20150505.";
   }
}
