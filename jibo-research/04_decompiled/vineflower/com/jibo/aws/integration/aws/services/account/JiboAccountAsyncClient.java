package com.jibo.aws.integration.aws.services.account;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.AbstractJiboAsyncClient;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.account.model.AccountRequest;
import com.jibo.aws.integration.aws.services.account.model.ActivateByCodeRequest;
import com.jibo.aws.integration.aws.services.account.model.ActivateByIdRequest;
import com.jibo.aws.integration.aws.services.account.model.ChangeEmailRequest;
import com.jibo.aws.integration.aws.services.account.model.ChangePasswordRequest;
import com.jibo.aws.integration.aws.services.account.model.CreateAccessTokenRequest;
import com.jibo.aws.integration.aws.services.account.model.EmailRequest;
import com.jibo.aws.integration.aws.services.account.model.FacebookConnectRequest;
import com.jibo.aws.integration.aws.services.account.model.FacebookMobileConnectRequest;
import com.jibo.aws.integration.aws.services.account.model.FacebookPrepareLogin;
import com.jibo.aws.integration.aws.services.account.model.FacebookPrepareLoginRequest;
import com.jibo.aws.integration.aws.services.account.model.GetRequest;
import com.jibo.aws.integration.aws.services.account.model.PasswordResetByCodeRequest;
import com.jibo.aws.integration.aws.services.account.model.RemovePhotoRequest;
import com.jibo.aws.integration.aws.services.account.model.RemoveRequest;
import com.jibo.aws.integration.aws.services.account.model.ResetKeysRequest;
import com.jibo.aws.integration.aws.services.account.model.SearchRequest;
import com.jibo.aws.integration.aws.services.account.model.SendPasswordResetRequest;
import com.jibo.aws.integration.aws.services.account.model.SendPhoneVerificationCodeRequest;
import com.jibo.aws.integration.aws.services.account.model.TokenContainer;
import com.jibo.aws.integration.aws.services.account.model.UpdatePhotoRequest;
import com.jibo.aws.integration.aws.services.account.model.UpdateRequest;
import com.jibo.aws.integration.aws.services.account.model.VerifyPhoneByCodeRequest;
import com.jibo.aws.integration.aws.services.common.model.IdResponse;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class JiboAccountAsyncClient extends AbstractJiboAsyncClient {
   public JiboAccountAsyncClient() {
   }

   public JiboAccountAsyncClient(AWSCredentials var1) {
      super(var1);
   }

   public JiboAccountAsyncClient(AWSCredentials var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboAccountAsyncClient(AWSCredentialsProvider var1) {
      super(var1);
   }

   public JiboAccountAsyncClient(AWSCredentialsProvider var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public Account activateByCode(String var1) {
      return this.getJiboClient().activateByCode(var1);
   }

   public Future<Account> activateByCode(String var1, AsyncHandler<ActivateByCodeRequest, Account> var2) {
      return this.c().submit(new Callable<Account>(this, var1, var2) {
         final String a;
         final AsyncHandler b;
         final JiboAccountAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public Account a() {
            Account var1x;
            try {
               var1x = this.c.activateByCode(this.a);
            } catch (Exception var2x) {
               if (this.b != null) {
                  this.b.onError(var2x);
               }

               throw var2x;
            }

            if (this.b != null) {
               this.b.onSuccess(new ActivateByCodeRequest(this.a), var1x);
            }

            return var1x;
         }
      });
   }

   public Account activateById(String var1) {
      return this.getJiboClient().activateById(var1);
   }

   public Future<Account> activateById(String var1, AsyncHandler<ActivateByIdRequest, Account> var2) {
      return this.c().submit(new Callable<Account>(this, var1, var2) {
         final String a;
         final AsyncHandler b;
         final JiboAccountAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public Account a() {
            Account var1x;
            try {
               var1x = this.c.activateById(this.a);
            } catch (Exception var2x) {
               if (this.b != null) {
                  this.b.onError(var2x);
               }

               throw var2x;
            }

            if (this.b != null) {
               this.b.onSuccess(new ActivateByIdRequest(this.a), var1x);
            }

            return var1x;
         }
      });
   }

   public IdResponse changeEmail(String var1, String var2) {
      return this.getJiboClient().changeEmail(var1, var2);
   }

   public Future<IdResponse> changeEmail(String var1, String var2, AsyncHandler<ChangeEmailRequest, IdResponse> var3) {
      return this.c().submit(new Callable<IdResponse>(this, var1, var2, var3) {
         final String a;
         final String b;
         final AsyncHandler c;
         final JiboAccountAsyncClient d;

         {
            this.d = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4;
         }

         public IdResponse a() {
            IdResponse var1x;
            try {
               var1x = this.d.changeEmail(this.a, this.b);
            } catch (Exception var2x) {
               if (this.c != null) {
                  this.c.onError(var2x);
               }

               throw var2x;
            }

            if (this.c != null) {
               this.c.onSuccess(new ChangeEmailRequest(this.a, this.b), var1x);
            }

            return var1x;
         }
      });
   }

   public Account changePassword(String var1, String var2) {
      return this.getJiboClient().changePassword(var1, var2);
   }

   public Future<Account> changePassword(String var1, String var2, AsyncHandler<ChangePasswordRequest, Account> var3) {
      return this.c().submit(new Callable<Account>(this, var1, var2, var3) {
         final String a;
         final String b;
         final AsyncHandler c;
         final JiboAccountAsyncClient d;

         {
            this.d = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4;
         }

         public Account a() {
            Account var1x;
            try {
               var1x = this.d.changePassword(this.a, this.b);
            } catch (Exception var2x) {
               if (this.c != null) {
                  this.c.onError(var2x);
               }

               throw var2x;
            }

            if (this.c != null) {
               this.c.onSuccess(new ChangePasswordRequest(this.a, this.b), var1x);
            }

            return var1x;
         }
      });
   }

   public Account create(String var1, String var2, String var3) {
      return this.getJiboClient().create(var1, var2, var3);
   }

   public Future<Account> create(String var1, String var2, String var3, AsyncHandler<AccountRequest, Account> var4) {
      return this.c().submit(new Callable<Account>(this, var1, var2, var3, var4) {
         final String a;
         final String b;
         final String c;
         final AsyncHandler d;
         final JiboAccountAsyncClient e;

         {
            this.e = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4x;
            this.d = var5;
         }

         public Account a() {
            Account var1x;
            try {
               var1x = this.e.create(this.a, this.b, this.c);
            } catch (Exception var2x) {
               if (this.d != null) {
                  this.d.onError(var2x);
               }

               throw var2x;
            }

            if (this.d != null) {
               this.d.onSuccess(new AccountRequest(this.a, this.b, "Create"), var1x);
            }

            return var1x;
         }
      });
   }

   public TokenContainer createAccessToken() {
      return this.getJiboClient().createAccessToken();
   }

   public Future<TokenContainer> createAccessToken(AsyncHandler<CreateAccessTokenRequest, TokenContainer> var1) {
      return this.c().submit(new Callable<TokenContainer>(this, var1) {
         final AsyncHandler a;
         final JiboAccountAsyncClient b;

         {
            this.b = var1;
            this.a = var2;
         }

         public TokenContainer a() {
            TokenContainer var1x;
            try {
               var1x = this.b.createAccessToken();
            } catch (Exception var2) {
               if (this.a != null) {
                  this.a.onError(var2);
               }

               throw var2;
            }

            if (this.a != null) {
               this.a.onSuccess(new CreateAccessTokenRequest(), var1x);
            }

            return var1x;
         }
      });
   }

   public Account facebookConnect(String var1, String var2) {
      return this.getJiboClient().facebookConnect(var1, var2);
   }

   public Future<Account> facebookConnect(String var1, String var2, AsyncHandler<FacebookConnectRequest, Account> var3) {
      return this.c().submit(new Callable<Account>(this, var1, var2, var3) {
         final String a;
         final String b;
         final AsyncHandler c;
         final JiboAccountAsyncClient d;

         {
            this.d = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4;
         }

         public Account a() {
            Account var1x;
            try {
               var1x = this.d.facebookConnect(this.a, this.b);
            } catch (Exception var2x) {
               if (this.c != null) {
                  this.c.onError(var2x);
               }

               throw var2x;
            }

            if (this.c != null) {
               this.c.onSuccess(new FacebookConnectRequest(this.a, this.b), var1x);
            }

            return var1x;
         }
      });
   }

   public TokenContainer facebookMobileConnect(String var1) {
      return this.getJiboClient().facebookMobileConnect(var1);
   }

   public Future<TokenContainer> facebookMobileConnect(String var1, AsyncHandler<FacebookMobileConnectRequest, TokenContainer> var2) {
      return this.c().submit(new Callable<TokenContainer>(this, var1, var2) {
         final String a;
         final AsyncHandler b;
         final JiboAccountAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public TokenContainer a() {
            TokenContainer var1x;
            try {
               var1x = this.c.facebookMobileConnect(this.a);
            } catch (Exception var2x) {
               if (this.b != null) {
                  this.b.onError(var2x);
               }

               throw var2x;
            }

            if (this.b != null) {
               this.b.onSuccess(new FacebookMobileConnectRequest(this.a), var1x);
            }

            return var1x;
         }
      });
   }

   public FacebookPrepareLogin facebookPrepareLogin() {
      return this.getJiboClient().facebookPrepareLogin();
   }

   public Future<FacebookPrepareLogin> facebookPrepareLogin(AsyncHandler<FacebookPrepareLoginRequest, FacebookPrepareLogin> var1) {
      return this.c().submit(new Callable<FacebookPrepareLogin>(this, var1) {
         final AsyncHandler a;
         final JiboAccountAsyncClient b;

         {
            this.b = var1;
            this.a = var2;
         }

         public FacebookPrepareLogin a() {
            FacebookPrepareLogin var1x;
            try {
               var1x = this.b.facebookPrepareLogin();
            } catch (Exception var2) {
               if (this.a != null) {
                  this.a.onError(var2);
               }

               throw var2;
            }

            if (this.a != null) {
               this.a.onSuccess(new FacebookPrepareLoginRequest(), var1x);
            }

            return var1x;
         }
      });
   }

   public List<Account> get(List<String> var1) {
      return this.getJiboClient().get(var1);
   }

   public Future<List<Account>> get(List<String> var1, AsyncHandler<GetRequest, List<Account>> var2) {
      return this.c().submit(new Callable<List<Account>>(this, var1, var2) {
         final List a;
         final AsyncHandler b;
         final JiboAccountAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public List<Account> a() {
            List var1x;
            try {
               var1x = this.c.get(this.a);
            } catch (Exception var2x) {
               if (this.b != null) {
                  this.b.onError(var2x);
               }

               throw var2x;
            }

            if (this.b != null) {
               this.b.onSuccess(new GetRequest(this.a), var1x);
            }

            return var1x;
         }
      });
   }

   public JiboAccountClient getJiboClient() {
      return (JiboAccountClient)super.getJiboClient();
   }

   public Account login(String var1, String var2) {
      return this.getJiboClient().login(var1, var2);
   }

   public Future<Account> login(String var1, String var2, AsyncHandler<AccountRequest, Account> var3) {
      return this.c().submit(new Callable<Account>(this, var1, var2, var3) {
         final String a;
         final String b;
         final AsyncHandler c;
         final JiboAccountAsyncClient d;

         {
            this.d = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4;
         }

         public Account a() {
            Account var1x;
            try {
               var1x = this.d.login(this.a, this.b);
            } catch (Exception var2x) {
               if (this.c != null) {
                  this.c.onError(var2x);
               }

               throw var2x;
            }

            if (this.c != null) {
               this.c.onSuccess(new AccountRequest(this.a, this.b, "login"), var1x);
            }

            return var1x;
         }
      });
   }

   public void logout() {
      this.getJiboClient().logout();
   }

   public Account passwordResetByCode(String var1, String var2) {
      return this.getJiboClient().passwordResetByCode(var1, var2);
   }

   public Future<Account> passwordResetByCode(String var1, String var2, AsyncHandler<PasswordResetByCodeRequest, Account> var3) {
      return this.c().submit(new Callable<Account>(this, var1, var2, var3) {
         final String a;
         final String b;
         final AsyncHandler c;
         final JiboAccountAsyncClient d;

         {
            this.d = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4;
         }

         public Account a() {
            Account var1x;
            try {
               var1x = this.d.passwordResetByCode(this.a, this.b);
            } catch (Exception var2x) {
               if (this.c != null) {
                  this.c.onError(var2x);
               }

               throw var2x;
            }

            if (this.c != null) {
               this.c.onSuccess(new PasswordResetByCodeRequest(this.a, this.b), var1x);
            }

            return var1x;
         }
      });
   }

   public Account remove() {
      return this.getJiboClient().remove();
   }

   public Future<Account> remove(AsyncHandler<RemoveRequest, Account> var1) {
      return this.c().submit(new Callable<Account>(this, var1) {
         final AsyncHandler a;
         final JiboAccountAsyncClient b;

         {
            this.b = var1;
            this.a = var2;
         }

         public Account a() {
            Account var1x;
            try {
               var1x = this.b.remove();
            } catch (Exception var2) {
               if (this.a != null) {
                  this.a.onError(var2);
               }

               throw var2;
            }

            if (this.a != null) {
               this.a.onSuccess(new RemoveRequest(), var1x);
            }

            return var1x;
         }
      });
   }

   public Account removePhoto() {
      return this.getJiboClient().removePhoto();
   }

   public Future<Account> removePhoto(AsyncHandler<RemovePhotoRequest, Account> var1) {
      return this.c().submit(new Callable<Account>(this, var1) {
         final AsyncHandler a;
         final JiboAccountAsyncClient b;

         {
            this.b = var1;
            this.a = var2;
         }

         public Account a() {
            Account var1x;
            try {
               var1x = this.b.removePhoto();
            } catch (Exception var2) {
               if (this.a != null) {
                  this.a.onError(var2);
               }

               throw var2;
            }

            if (this.a != null) {
               this.a.onSuccess(new RemovePhotoRequest(), var1x);
            }

            return var1x;
         }
      });
   }

   public Account resendActivationCode(String var1) {
      return this.getJiboClient().resendActivationCode(var1);
   }

   public Future<Account> resendActivationCode(String var1, AsyncHandler<EmailRequest, Account> var2) {
      return this.c().submit(new Callable<Account>(this, var1, var2) {
         final String a;
         final AsyncHandler b;
         final JiboAccountAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public Account a() {
            Account var1x;
            try {
               var1x = this.c.resendActivationCode(this.a);
            } catch (Exception var2x) {
               if (this.b != null) {
                  this.b.onError(var2x);
               }

               throw var2x;
            }

            if (this.b != null) {
               this.b.onSuccess(new EmailRequest(this.a), var1x);
            }

            return var1x;
         }
      });
   }

   public Account resetKeys() {
      return this.getJiboClient().resetKeys();
   }

   public Future<Account> resetKeys(AsyncHandler<ResetKeysRequest, Account> var1) {
      return this.c().submit(new Callable<Account>(this, var1) {
         final AsyncHandler a;
         final JiboAccountAsyncClient b;

         {
            this.b = var1;
            this.a = var2;
         }

         public Account a() {
            Account var1x;
            try {
               var1x = this.b.resetKeys();
            } catch (Exception var2) {
               if (this.a != null) {
                  this.a.onError(var2);
               }

               throw var2;
            }

            if (this.a != null) {
               this.a.onSuccess(new ResetKeysRequest(), var1x);
            }

            return var1x;
         }
      });
   }

   public List<Account> search(String var1) {
      return this.getJiboClient().search(var1);
   }

   public Future<List<Account>> search(String var1, AsyncHandler<SearchRequest, List<Account>> var2) {
      return this.c().submit(new Callable<List<Account>>(this, var1, var2) {
         final String a;
         final AsyncHandler b;
         final JiboAccountAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public List<Account> a() {
            List var1x;
            try {
               var1x = this.c.search(this.a);
            } catch (Exception var2x) {
               if (this.b != null) {
                  this.b.onError(var2x);
               }

               throw var2x;
            }

            if (this.b != null) {
               this.b.onSuccess(new SearchRequest(this.a), var1x);
            }

            return var1x;
         }
      });
   }

   public Account sendPasswordReset(String var1) {
      return this.getJiboClient().sendPasswordReset(var1);
   }

   public Future<Account> sendPasswordReset(String var1, AsyncHandler<SendPasswordResetRequest, Account> var2) {
      return this.c().submit(new Callable<Account>(this, var1, var2) {
         final String a;
         final AsyncHandler b;
         final JiboAccountAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public Account a() {
            Account var1x;
            try {
               var1x = this.c.sendPasswordReset(this.a);
            } catch (Exception var2x) {
               if (this.b != null) {
                  this.b.onError(var2x);
               }

               throw var2x;
            }

            if (this.b != null) {
               this.b.onSuccess(new SendPasswordResetRequest(this.a), var1x);
            }

            return var1x;
         }
      });
   }

   public IdResponse sendPhoneVerificationCode(String var1) {
      return this.getJiboClient().sendPhoneVerificationCode(var1);
   }

   public Future<IdResponse> sendPhoneVerificationCode(String var1, AsyncHandler<SendPhoneVerificationCodeRequest, IdResponse> var2) {
      return this.c().submit(new Callable<IdResponse>(this, var1, var2) {
         final String a;
         final AsyncHandler b;
         final JiboAccountAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public IdResponse a() {
            IdResponse var1x;
            try {
               var1x = this.c.sendPhoneVerificationCode(this.a);
            } catch (Exception var2x) {
               if (this.b != null) {
                  this.b.onError(var2x);
               }

               throw var2x;
            }

            if (this.b != null) {
               this.b.onSuccess(new SendPhoneVerificationCodeRequest(this.a), var1x);
            }

            return var1x;
         }
      });
   }

   public Account update(UpdateRequest var1) {
      return this.getJiboClient().update(var1);
   }

   public Future<Account> update(UpdateRequest var1, AsyncHandler<UpdateRequest, Account> var2) {
      return this.c().submit(new Callable<Account>(this, var1, var2) {
         final UpdateRequest a;
         final AsyncHandler b;
         final JiboAccountAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public Account a() {
            Account var1x;
            try {
               var1x = this.c.update(this.a);
            } catch (Exception var2x) {
               if (this.b != null) {
                  this.b.onError(var2x);
               }

               throw var2x;
            }

            if (this.b != null) {
               this.b.onSuccess(this.a, var1x);
            }

            return var1x;
         }
      });
   }

   public Account updatePhoto(File var1, Map<String, String> var2) {
      return this.getJiboClient().updatePhoto(var1, var2);
   }

   public Future<Account> updatePhoto(File var1, Map<String, String> var2, AsyncHandler<UpdatePhotoRequest, Account> var3) {
      return this.c().submit(new Callable<Account>(this, var1, var2, var3) {
         final File a;
         final Map b;
         final AsyncHandler c;
         final JiboAccountAsyncClient d;

         {
            this.d = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4;
         }

         public Account a() {
            Account var1x;
            try {
               var1x = this.d.updatePhoto(this.a, this.b);
            } catch (Exception var2x) {
               if (this.c != null) {
                  this.c.onError(var2x);
               }

               throw var2x;
            }

            if (this.c != null) {
               this.c.onSuccess(new UpdatePhotoRequest(this.a, this.b), var1x);
            }

            return var1x;
         }
      });
   }

   public Account verifyPhoneByCode(String var1) {
      return this.getJiboClient().verifyPhoneByCode(var1);
   }

   public Future<Account> verifyPhoneByCode(String var1, AsyncHandler<VerifyPhoneByCodeRequest, Account> var2) {
      return this.c().submit(new Callable<Account>(this, var1, var2) {
         final String a;
         final AsyncHandler b;
         final JiboAccountAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public Account a() {
            Account var1x;
            try {
               var1x = this.c.verifyPhoneByCode(this.a);
            } catch (Exception var2x) {
               if (this.b != null) {
                  this.b.onError(var2x);
               }

               throw var2x;
            }

            if (this.b != null) {
               this.b.onSuccess(new VerifyPhoneByCodeRequest(this.a), var1x);
            }

            return var1x;
         }
      });
   }
}
