package com.jibo.aws.integration.aws.services.skills;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.http.HttpClient;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jibo.aws.integration.aws.services.AbstractJiboClient;
import com.jibo.aws.integration.aws.services.skills.model.DeleteSettingsRequest;
import com.jibo.aws.integration.aws.services.skills.model.GetSettingsRequest;
import com.jibo.aws.integration.aws.services.skills.model.SettingsUnmarshaller;
import com.jibo.aws.integration.aws.services.skills.model.UpdateSettingsRequest;
import com.jibo.aws.integration.util.a;

public class JiboSkillsClient extends AbstractJiboClient {
   public static final String TAG = com.jibo.aws.integration.util.a.a(JiboSkillsClient.class);

   public JiboSkillsClient(AWSCredentials var1) {
      super(var1);
   }

   public JiboSkillsClient(AWSCredentials var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboSkillsClient(AWSCredentialsProvider var1) {
      super(var1);
   }

   public JiboSkillsClient(AWSCredentialsProvider var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboSkillsClient(AWSCredentialsProvider var1, ClientConfiguration var2, HttpClient var3) {
      super(var1, var2, var3);
   }

   public DeleteSettingsRequest.DeleteSettingData deleteSettings(String var1, DeleteSettingsRequest.DeleteSettingData var2) {
      JsonObject var3 = (JsonObject)new JsonParser().a(this.a(new DeleteSettingsRequest(var1, var2), null, new SettingsUnmarshaller()).getAwsResponse());
      DeleteSettingsRequest.DeleteSettingData var4;
      if (var3.b("data") && var3.e("data").b(var2.key) && var3.e("data").c(var2.key).i()) {
         var4 = new DeleteSettingsRequest.DeleteSettingData(
            var1, new Gson().a(var3.e("data").c(var2.key), DeleteSettingsRequest.DeleteSettingData.DeleteSettingValue.class)
         );
      } else {
         var4 = null;
      }

      return var4;
   }

   public String getSkillsJson(String var1) {
      return this.a(new GetSettingsRequest(var1), null, new SettingsUnmarshaller()).getAwsResponse();
   }

   public UpdateSettingsRequest.UpdateSettingData updateSkill(String var1, UpdateSettingsRequest.UpdateSettingData var2) {
      JsonObject var3 = (JsonObject)new JsonParser().a(this.a(new UpdateSettingsRequest(var1, var2), null, new SettingsUnmarshaller()).getAwsResponse());
      UpdateSettingsRequest.UpdateSettingData var4;
      if (var3.b("data") && var3.e("data").b(var2.key) && var3.e("data").c(var2.key).i()) {
         var4 = new UpdateSettingsRequest.UpdateSettingData(
            var1, new Gson().a(var3.e("data").c(var2.key), UpdateSettingsRequest.UpdateSettingData.UpdateSettingValue.class)
         );
      } else {
         var4 = null;
      }

      return var4;
   }
}
