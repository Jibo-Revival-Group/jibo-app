package com.google.api.client.googleapis.extensions.android.gms.auth;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.auth.GooglePlayServicesAvailabilityException;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.android.gms.common.AccountPicker;
import com.google.api.client.googleapis.extensions.android.accounts.GoogleAccountManager;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpUnsuccessfulResponseHandler;
import com.google.api.client.util.BackOff;
import com.google.api.client.util.BackOffUtils;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Joiner;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sleeper;
import java.io.IOException;
import java.util.Collection;

@Beta
public class GoogleAccountCredential implements HttpRequestInitializer {
   private final GoogleAccountManager accountManager;
   private String accountName;
   private BackOff backOff;
   final Context context;
   final String scope;
   private Account selectedAccount;
   private Sleeper sleeper = Sleeper.DEFAULT;

   public GoogleAccountCredential(Context var1, String var2) {
      this.accountManager = new GoogleAccountManager(var1);
      this.context = var1;
      this.scope = var2;
   }

   public static GoogleAccountCredential usingAudience(Context var0, String var1) {
      boolean var2;
      if (var1.length() != 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      Preconditions.checkArgument(var2);
      var1 = String.valueOf(var1);
      if (var1.length() != 0) {
         var1 = "audience:".concat(var1);
      } else {
         var1 = new String("audience:");
      }

      return new GoogleAccountCredential(var0, var1);
   }

   public static GoogleAccountCredential usingOAuth2(Context var0, Collection<String> var1) {
      boolean var2;
      if (var1 != null && var1.iterator().hasNext()) {
         var2 = true;
      } else {
         var2 = false;
      }

      Preconditions.checkArgument(var2);
      String var3 = String.valueOf(Joiner.on(' ').join(var1));
      String var4;
      if (var3.length() != 0) {
         var4 = "oauth2: ".concat(var3);
      } else {
         var4 = new String("oauth2: ");
      }

      return new GoogleAccountCredential(var0, var4);
   }

   public final Account[] getAllAccounts() {
      return this.accountManager.getAccounts();
   }

   public BackOff getBackOff() {
      return this.backOff;
   }

   public final Context getContext() {
      return this.context;
   }

   public final GoogleAccountManager getGoogleAccountManager() {
      return this.accountManager;
   }

   public final String getScope() {
      return this.scope;
   }

   public final Account getSelectedAccount() {
      return this.selectedAccount;
   }

   public final String getSelectedAccountName() {
      return this.accountName;
   }

   public final Sleeper getSleeper() {
      return this.sleeper;
   }

   public String getToken() throws IOException, GoogleAuthException {
      if (this.backOff != null) {
         this.backOff.reset();
      }

      while (true) {
         try {
            return GoogleAuthUtil.a(this.context, this.accountName, this.scope);
         } catch (IOException var3) {
            IOException var1 = var3;

            try {
               if (this.backOff == null || !BackOffUtils.next(this.sleeper, this.backOff)) {
                  throw var1;
               }
            } catch (InterruptedException var2) {
            }
         }
      }
   }

   @Override
   public void initialize(HttpRequest var1) {
      GoogleAccountCredential.RequestHandler var2 = new GoogleAccountCredential.RequestHandler(this);
      var1.setInterceptor(var2);
      var1.setUnsuccessfulResponseHandler(var2);
   }

   public final Intent newChooseAccountIntent() {
      return AccountPicker.a(this.selectedAccount, null, new String[]{"com.google"}, true, null, null, null, null);
   }

   public GoogleAccountCredential setBackOff(BackOff var1) {
      this.backOff = var1;
      return this;
   }

   public final GoogleAccountCredential setSelectedAccount(Account var1) {
      this.selectedAccount = var1;
      String var2;
      if (var1 == null) {
         var2 = null;
      } else {
         var2 = var1.name;
      }

      this.accountName = var2;
      return this;
   }

   public final GoogleAccountCredential setSelectedAccountName(String var1) {
      this.selectedAccount = this.accountManager.getAccountByName(var1);
      if (this.selectedAccount == null) {
         var1 = null;
      }

      this.accountName = var1;
      return this;
   }

   public final GoogleAccountCredential setSleeper(Sleeper var1) {
      this.sleeper = Preconditions.checkNotNull(var1);
      return this;
   }

   @Beta
   class RequestHandler implements HttpExecuteInterceptor, HttpUnsuccessfulResponseHandler {
      boolean received401;
      final GoogleAccountCredential this$0;
      String token;

      RequestHandler(GoogleAccountCredential var1) {
         this.this$0 = var1;
      }

      @Override
      public boolean handleResponse(HttpRequest var1, HttpResponse var2, boolean var3) {
         var3 = true;
         if (var2.getStatusCode() == 401 && !this.received401) {
            this.received401 = true;
            GoogleAuthUtil.a(this.this$0.context, this.token);
         } else {
            var3 = false;
         }

         return var3;
      }

      // $VF: Duplicated exception handlers to handle obfuscated exceptions
      @Override
      public void intercept(HttpRequest var1) throws IOException {
         HttpHeaders var2;
         label39: {
            try {
               this.token = this.this$0.getToken();
               var2 = var1.getHeaders();
               String var12 = String.valueOf(this.token);
               if (var12.length() != 0) {
                  var13 = "Bearer ".concat(var12);
                  break label39;
               }
            } catch (GooglePlayServicesAvailabilityException var9) {
               throw new GooglePlayServicesAvailabilityIOException(var9);
            } catch (UserRecoverableAuthException var10) {
               throw new UserRecoverableAuthIOException(var10);
            } catch (GoogleAuthException var11) {
               throw new GoogleAuthIOException(var11);
            }

            try {
               var13 = new String("Bearer ");
            } catch (GooglePlayServicesAvailabilityException var6) {
               throw new GooglePlayServicesAvailabilityIOException(var6);
            } catch (UserRecoverableAuthException var7) {
               throw new UserRecoverableAuthIOException(var7);
            } catch (GoogleAuthException var8) {
               throw new GoogleAuthIOException(var8);
            }
         }

         try {
            var2.setAuthorization(var13);
         } catch (GooglePlayServicesAvailabilityException var3) {
            throw new GooglePlayServicesAvailabilityIOException(var3);
         } catch (UserRecoverableAuthException var4) {
            throw new UserRecoverableAuthIOException(var4);
         } catch (GoogleAuthException var5) {
            throw new GoogleAuthIOException(var5);
         }
      }
   }
}
