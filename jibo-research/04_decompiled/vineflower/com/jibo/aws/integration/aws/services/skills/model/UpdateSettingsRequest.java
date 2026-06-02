package com.jibo.aws.integration.aws.services.skills.model;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.UUID;

public class UpdateSettingsRequest extends JiboSkillsRequest {
   private JsonObject data;
   private String loopId;
   private String transId;

   public UpdateSettingsRequest(String var1, UpdateSettingsRequest.UpdateSettingData var2) {
      this.loopId = var1;
      this.data = new JsonObject();
      this.transId = UUID.randomUUID().toString();
      this.data.a(var2.key, new Gson().a(var2.value));
   }

   public UpdateSettingsRequest(String var1, String var2, String var3, String var4, JsonElement var5) {
      this(var1, new UpdateSettingsRequest.UpdateSettingData(var2, var3, var4, var5));
   }

   @Override
   public boolean equals(Object var1) {
      boolean var5 = false;
      boolean var4;
      if (this == var1) {
         var4 = true;
      } else {
         var4 = var5;
         if (var1 != null) {
            var4 = var5;
            if (var1 instanceof UpdateSettingsRequest) {
               var1 = var1;
               boolean var2;
               if (var1.getTransId() == null) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               boolean var3;
               if (this.getTransId() == null) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               var4 = var5;
               if (!(var2 ^ var3)) {
                  if (var1.getTransId() != null) {
                     var4 = var5;
                     if (!var1.getTransId().equals(this.getTransId())) {
                        return var4;
                     }
                  }

                  if (var1.getLoopId() == null) {
                     var2 = true;
                  } else {
                     var2 = false;
                  }

                  if (this.getLoopId() == null) {
                     var3 = true;
                  } else {
                     var3 = false;
                  }

                  var4 = var5;
                  if (!(var2 ^ var3)) {
                     if (var1.getLoopId() != null) {
                        var4 = var5;
                        if (!var1.getLoopId().equals(this.getLoopId())) {
                           return var4;
                        }
                     }

                     if (var1.getData() == null) {
                        var2 = true;
                     } else {
                        var2 = false;
                     }

                     if (this.getLoopId() == null) {
                        var3 = true;
                     } else {
                        var3 = false;
                     }

                     var4 = var5;
                     if (!(var2 ^ var3)) {
                        if (var1.getData() != null) {
                           var4 = var5;
                           if (!var1.getData().equals(this.getData())) {
                              return var4;
                           }
                        }

                        var4 = true;
                     }
                  }
               }
            }
         }
      }

      return var4;
   }

   public JsonObject getData() {
      return this.data;
   }

   public String getLoopId() {
      return this.loopId;
   }

   public String getTransId() {
      return this.transId;
   }

   @Override
   public int hashCode() {
      int var3 = 0;
      int var1;
      if (this.getTransId() == null) {
         var1 = 0;
      } else {
         var1 = this.getTransId().hashCode();
      }

      int var2;
      if (this.getLoopId() == null) {
         var2 = 0;
      } else {
         var2 = this.getLoopId().hashCode();
      }

      if (this.getData() != null) {
         var3 = this.getData().hashCode();
      }

      return (var2 + (var1 + 31) * 31) * 31 + var3;
   }

   public void setLoopId(String var1) {
      this.loopId = var1;
   }

   @Override
   public String toString() {
      return "UpdateSettingsRequest {getTransId=" + this.getTransId() + "," + "loopId='" + this.loopId + "'}";
   }

   public static class UpdateSettingData {
      public String key;
      public UpdateSettingsRequest.UpdateSettingData.UpdateSettingValue value;

      public UpdateSettingData(String var1, UpdateSettingsRequest.UpdateSettingData.UpdateSettingValue var2) {
         this.key = var1;
         this.value = var2;
      }

      public UpdateSettingData(String var1, String var2, String var3, JsonElement var4) {
         this.key = var1;
         this.value = new UpdateSettingsRequest.UpdateSettingData.UpdateSettingValue(var2, var3, var4);
      }

      public static class UpdateSettingValue {
         public String dataService;
         public String skillId;
         public JsonElement value;

         public UpdateSettingValue(String var1, String var2, JsonElement var3) {
            this.skillId = var1;
            this.dataService = var2;
            this.value = var3;
         }
      }
   }
}
