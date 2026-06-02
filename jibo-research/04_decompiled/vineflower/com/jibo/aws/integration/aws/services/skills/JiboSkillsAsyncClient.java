package com.jibo.aws.integration.aws.services.skills;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.AbstractJiboAsyncClient;
import com.jibo.aws.integration.aws.services.skills.model.DeleteSettingsRequest;
import com.jibo.aws.integration.aws.services.skills.model.GetSettingsRequest;
import com.jibo.aws.integration.aws.services.skills.model.UpdateSettingsRequest;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class JiboSkillsAsyncClient extends AbstractJiboAsyncClient {
   public JiboSkillsAsyncClient(AWSCredentials var1) {
      super(var1);
   }

   public JiboSkillsAsyncClient(AWSCredentials var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboSkillsAsyncClient(AWSCredentialsProvider var1) {
      super(var1);
   }

   public JiboSkillsAsyncClient(AWSCredentialsProvider var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public DeleteSettingsRequest.DeleteSettingData deleteSettings(String var1, DeleteSettingsRequest.DeleteSettingData var2) {
      return this.getJiboClient().deleteSettings(var1, var2);
   }

   public Future<DeleteSettingsRequest.DeleteSettingData> deleteSettings(
      String var1, DeleteSettingsRequest.DeleteSettingData var2, AsyncHandler<DeleteSettingsRequest, DeleteSettingsRequest.DeleteSettingData> var3
   ) {
      return this.c().submit(new Callable<DeleteSettingsRequest.DeleteSettingData>(this, var1, var2, var3) {
         final String a;
         final DeleteSettingsRequest.DeleteSettingData b;
         final AsyncHandler c;
         final JiboSkillsAsyncClient d;

         {
            this.d = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4;
         }

         // $VF: Duplicated exception handlers to handle obfuscated exceptions
         public DeleteSettingsRequest.DeleteSettingData a() {
            AmazonServiceException var1x;
            label36: {
               try {
                  var4 = this.d.deleteSettings(this.a, this.b);
               } catch (Exception var3x) {
                  var1x = var3x;
                  if (this.c == null) {
                     throw var3x;
                  }
                  break label36;
               }

               if (var4 != null) {
                  if (this.c != null) {
                     this.c.onSuccess(new DeleteSettingsRequest(this.a, this.b), var4);
                  }

                  return var4;
               }

               try {
                  var1x = new AmazonServiceException("Bad response data");
                  throw var1x;
               } catch (Exception var2x) {
                  var1x = var2x;
                  if (this.c == null) {
                     throw var2x;
                  }
               }
            }

            this.c.onError(var1x);
            throw var1x;
         }
      });
   }

   public JiboSkillsClient getJiboClient() {
      return (JiboSkillsClient)super.getJiboClient();
   }

   public String getSkillsJson(String var1) {
      return this.getJiboClient().getSkillsJson(var1);
   }

   public Future<String> getSkillsJson(String var1, AsyncHandler<GetSettingsRequest, String> var2) {
      return this.c().submit(new Callable<String>(this, var1, var2) {
         final String a;
         final AsyncHandler b;
         final JiboSkillsAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public String a() {
            String var1x;
            try {
               var1x = this.c.getSkillsJson(this.a);
            } catch (Exception var2x) {
               if (this.b != null) {
                  this.b.onError(var2x);
               }

               throw var2x;
            }

            if (this.b != null) {
               this.b.onSuccess(new GetSettingsRequest(this.a), var1x);
            }

            return var1x;
         }
      });
   }

   public UpdateSettingsRequest.UpdateSettingData updateSkill(String var1, UpdateSettingsRequest.UpdateSettingData var2) {
      return this.getJiboClient().updateSkill(var1, var2);
   }

   public Future<UpdateSettingsRequest.UpdateSettingData> updateSkill(
      String var1, UpdateSettingsRequest.UpdateSettingData var2, AsyncHandler<UpdateSettingsRequest, UpdateSettingsRequest.UpdateSettingData> var3
   ) {
      return this.c().submit(new Callable<UpdateSettingsRequest.UpdateSettingData>(this, var1, var2, var3) {
         final String a;
         final UpdateSettingsRequest.UpdateSettingData b;
         final AsyncHandler c;
         final JiboSkillsAsyncClient d;

         {
            this.d = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4;
         }

         // $VF: Duplicated exception handlers to handle obfuscated exceptions
         public UpdateSettingsRequest.UpdateSettingData a() {
            AmazonServiceException var1x;
            label36: {
               try {
                  var4 = this.d.updateSkill(this.a, this.b);
               } catch (Exception var3x) {
                  var1x = var3x;
                  if (this.c == null) {
                     throw var3x;
                  }
                  break label36;
               }

               if (var4 != null) {
                  if (this.c != null) {
                     this.c.onSuccess(new UpdateSettingsRequest(this.a, this.b), var4);
                  }

                  return var4;
               }

               try {
                  var1x = new AmazonServiceException("Bad response data");
                  throw var1x;
               } catch (Exception var2x) {
                  var1x = var2x;
                  if (this.c == null) {
                     throw var2x;
                  }
               }
            }

            this.c.onError(var1x);
            throw var1x;
         }
      });
   }
}
