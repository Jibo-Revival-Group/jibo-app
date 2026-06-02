package com.jibo.aws.integration.aws.services.push.model;

import com.google.gson.annotations.Expose;
import com.jibo.aws.integration.aws.services.common.model.Device;

public class CreateDeviceRequest extends JiboPushRequest {
   @Expose
   private String name;
   @Expose
   private String pushToken;
   @Expose
   private Device.Type type;

   public CreateDeviceRequest(Device var1) {
      this.name = var1.getName();
      this.pushToken = var1.getPushToken();
      this.type = var1.getType();
   }

   public String getName() {
      return this.name;
   }

   public String getPushToken() {
      return this.pushToken;
   }

   public Device.Type getType() {
      return this.type;
   }

   public void setName(String var1) {
      this.name = var1;
   }

   public void setPushToken(String var1) {
      this.pushToken = var1;
   }

   public void setType(Device.Type var1) {
      this.type = var1;
   }
}
