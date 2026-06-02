package com.jibo.aws.integration.aws.services.account;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.http.HttpClient;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.jibo.aws.integration.aws.services.AbstractJiboClient;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.account.model.AccountRequest;
import com.jibo.aws.integration.aws.services.account.model.ActivateByCodeRequest;
import com.jibo.aws.integration.aws.services.account.model.ActivateByIdRequest;
import com.jibo.aws.integration.aws.services.account.model.ChangeEmailRequest;
import com.jibo.aws.integration.aws.services.account.model.ChangePasswordRequest;
import com.jibo.aws.integration.aws.services.account.model.CreateAccessTokenRequest;
import com.jibo.aws.integration.aws.services.account.model.FacebookConnectRequest;
import com.jibo.aws.integration.aws.services.account.model.FacebookMobileConnectRequest;
import com.jibo.aws.integration.aws.services.account.model.FacebookPrepareLogin;
import com.jibo.aws.integration.aws.services.account.model.FacebookPrepareLoginRequest;
import com.jibo.aws.integration.aws.services.account.model.GetRequest;
import com.jibo.aws.integration.aws.services.account.model.PasswordResetByCodeRequest;
import com.jibo.aws.integration.aws.services.account.model.RemovePhotoRequest;
import com.jibo.aws.integration.aws.services.account.model.RemoveRequest;
import com.jibo.aws.integration.aws.services.account.model.ResendActivationCodeRequest;
import com.jibo.aws.integration.aws.services.account.model.ResetKeysRequest;
import com.jibo.aws.integration.aws.services.account.model.SearchRequest;
import com.jibo.aws.integration.aws.services.account.model.SendPasswordResetRequest;
import com.jibo.aws.integration.aws.services.account.model.SendPhoneVerificationCodeRequest;
import com.jibo.aws.integration.aws.services.account.model.TokenContainer;
import com.jibo.aws.integration.aws.services.account.model.UpdatePhotoRequest;
import com.jibo.aws.integration.aws.services.account.model.UpdateRequest;
import com.jibo.aws.integration.aws.services.account.model.VerifyPhoneByCodeRequest;
import com.jibo.aws.integration.aws.services.account.model.a.b;
import com.jibo.aws.integration.aws.services.account.model.a.e;
import com.jibo.aws.integration.aws.services.common.model.IdResponse;
import com.jibo.aws.integration.aws.services.common.model.a.c;
import com.jibo.aws.integration.aws.services.common.model.a.d;
import com.jibo.aws.integration.util.a;
import java.io.File;
import java.util.List;
import java.util.Map;

public class JiboAccountClient extends AbstractJiboClient {
   public static final String TAG = com.jibo.aws.integration.util.a.a(JiboAccountClient.class);

   public JiboAccountClient(AWSCredentials var1) {
      super(var1);
   }

   public JiboAccountClient(AWSCredentials var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboAccountClient(AWSCredentialsProvider var1) {
      super(var1);
   }

   public JiboAccountClient(AWSCredentialsProvider var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboAccountClient(AWSCredentialsProvider var1, ClientConfiguration var2, HttpClient var3) {
      super(var1, var2, var3);
   }

   public Account activateByCode(String var1) {
      String var2 = this.clientConfiguration.getSignerOverride();
      this.clientConfiguration.setSignerOverride("NoOpSignerType");
      Account var3 = this.a(new ActivateByCodeRequest(var1), null, new com.jibo.aws.integration.aws.services.account.model.a.a()).getAwsResponse();
      this.clientConfiguration.setSignerOverride(var2);
      return var3;
   }

   public Account activateById(String var1) {
      return this.a(new ActivateByIdRequest(var1), new c(), new com.jibo.aws.integration.aws.services.account.model.a.a()).getAwsResponse();
   }

   public IdResponse changeEmail(String var1, String var2) {
      return this.a(new ChangeEmailRequest(var1, var2), null, new d()).getAwsResponse();
   }

   public Account changePassword(String var1, String var2) {
      return this.a(new ChangePasswordRequest(var1, var2), null, new com.jibo.aws.integration.aws.services.account.model.a.a()).getAwsResponse();
   }

   public Account create(String var1, String var2, String var3) {
      String var4 = this.clientConfiguration.getSignerOverride();

      try {
         this.clientConfiguration.setSignerOverride("NoOpSignerType");
         AccountRequest var5 = new AccountRequest(var1, var2, var3, "Create");
         com.jibo.aws.integration.aws.services.account.model.a.a var8 = new com.jibo.aws.integration.aws.services.account.model.a.a();
         var9 = this.a(var5, null, var8).getAwsResponse();
         BasicAWSCredentials var10 = new BasicAWSCredentials(var9.getAccessKeyId(), var9.getSecretAccessKey());
         StaticCredentialsProvider var11 = new StaticCredentialsProvider(var10);
         this.b = var11;
      } finally {
         this.clientConfiguration.setSignerOverride(var4);
      }

      return var9;
   }

   public TokenContainer createAccessToken() {
      return this.a(new CreateAccessTokenRequest(), null, new com.jibo.aws.integration.aws.services.account.model.a.d()).getAwsResponse();
   }

   public Account facebookConnect(String var1, String var2) {
      return this.a(new FacebookConnectRequest(var1, var2), null, new com.jibo.aws.integration.aws.services.account.model.a.a()).getAwsResponse();
   }

   public TokenContainer facebookMobileConnect(String var1) {
      return this.a(new FacebookMobileConnectRequest(var1), null, new com.jibo.aws.integration.aws.services.account.model.a.d()).getAwsResponse();
   }

   public FacebookPrepareLogin facebookPrepareLogin() {
      return this.a(new FacebookPrepareLoginRequest(), null, new com.jibo.aws.integration.aws.services.account.model.a.c()).getAwsResponse();
   }

   public List<Account> get(List<String> var1) {
      return this.a(new GetRequest(var1), null, new b()).getAwsResponse();
   }

   public Account login(String var1, String var2) {
      String var3 = this.clientConfiguration.getSignerOverride();

      try {
         this.clientConfiguration.setSignerOverride("NoOpSignerType");
         AccountRequest var4 = new AccountRequest(var1, var2, "Login");
         com.jibo.aws.integration.aws.services.account.model.a.a var7 = new com.jibo.aws.integration.aws.services.account.model.a.a();
         var9 = this.a(var4, null, var7).getAwsResponse();
         BasicAWSCredentials var10 = new BasicAWSCredentials(var9.getAccessKeyId(), var9.getSecretAccessKey());
         StaticCredentialsProvider var8 = new StaticCredentialsProvider(var10);
         this.b = var8;
      } finally {
         this.clientConfiguration.setSignerOverride(var3);
      }

      return var9;
   }

   public void logout() {
      this.b = new StaticCredentialsProvider(new BasicAWSCredentials("", ""));
   }

   public Account passwordResetByCode(String var1, String var2) {
      String var3 = this.clientConfiguration.getSignerOverride();
      this.clientConfiguration.setSignerOverride("NoOpSignerType");
      Account var4 = this.a(new PasswordResetByCodeRequest(var1, var2), null, new com.jibo.aws.integration.aws.services.account.model.a.a()).getAwsResponse();
      this.clientConfiguration.setSignerOverride(var3);
      return var4;
   }

   public Account remove() {
      Account var1 = this.a(
            new RemoveRequest(), new com.jibo.aws.integration.aws.services.common.model.a.b(), new com.jibo.aws.integration.aws.services.account.model.a.a()
         )
         .getAwsResponse();
      this.b = new StaticCredentialsProvider(new BasicAWSCredentials("", ""));
      return var1;
   }

   public Account removePhoto() {
      return this.a(new RemovePhotoRequest(), new c(), new com.jibo.aws.integration.aws.services.account.model.a.a()).getAwsResponse();
   }

   public Account resendActivationCode(String var1) {
      String var2 = this.clientConfiguration.getSignerOverride();
      this.clientConfiguration.setSignerOverride("NoOpSignerType");
      Account var3 = this.a(new ResendActivationCodeRequest(var1), null, new com.jibo.aws.integration.aws.services.account.model.a.a()).getAwsResponse();
      this.clientConfiguration.setSignerOverride(var2);
      return var3;
   }

   public Account resetKeys() {
      Account var1 = this.a(
            new ResetKeysRequest(), new com.jibo.aws.integration.aws.services.common.model.a.b(), new com.jibo.aws.integration.aws.services.account.model.a.a()
         )
         .getAwsResponse();
      this.b = new StaticCredentialsProvider(new BasicAWSCredentials(var1.getAccessKeyId(), var1.getSecretAccessKey()));
      return var1;
   }

   public List<Account> search(String var1) {
      return this.a(new SearchRequest(var1), null, new b()).getAwsResponse();
   }

   public Account sendPasswordReset(String var1) {
      String var2 = this.clientConfiguration.getSignerOverride();
      this.clientConfiguration.setSignerOverride("NoOpSignerType");
      Account var3 = this.a(new SendPasswordResetRequest(var1), null, new com.jibo.aws.integration.aws.services.account.model.a.a()).getAwsResponse();
      this.clientConfiguration.setSignerOverride(var2);
      return var3;
   }

   public IdResponse sendPhoneVerificationCode(String var1) {
      return this.a(new SendPhoneVerificationCodeRequest(var1), null, new d()).getAwsResponse();
   }

   public Account update(UpdateRequest var1) {
      return this.a(var1, null, new com.jibo.aws.integration.aws.services.account.model.a.a()).getAwsResponse();
   }

   public Account updatePhoto(File var1, Map<String, String> var2) {
      return this.a(new UpdatePhotoRequest(var1, var2), new e(), new com.jibo.aws.integration.aws.services.account.model.a.a()).getAwsResponse();
   }

   public Account verifyPhoneByCode(String var1) {
      return this.a(new VerifyPhoneByCodeRequest(var1), null, new com.jibo.aws.integration.aws.services.account.model.a.a()).getAwsResponse();
   }
}
