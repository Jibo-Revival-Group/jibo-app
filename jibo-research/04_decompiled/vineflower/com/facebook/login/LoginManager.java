package com.facebook.login;

import android.app.Activity;
import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookActivity;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.Validate;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class LoginManager {
   private static final String MANAGE_PERMISSION_PREFIX = "manage";
   private static final Set<String> OTHER_PUBLISH_PERMISSIONS = getOtherPublishPermissions();
   private static final String PUBLISH_PERMISSION_PREFIX = "publish";
   private static volatile LoginManager instance;
   private DefaultAudience defaultAudience;
   private LoginBehavior loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;

   LoginManager() {
      this.defaultAudience = DefaultAudience.FRIENDS;
      Validate.sdkInitialized();
   }

   static LoginResult computeLoginResult(LoginClient.Request var0, AccessToken var1) {
      Set var3 = var0.getPermissions();
      HashSet var2 = new HashSet<>(var1.getPermissions());
      if (var0.isRerequest()) {
         var2.retainAll(var3);
      }

      HashSet var4 = new HashSet(var3);
      var4.removeAll(var2);
      return new LoginResult(var1, var2, var4);
   }

   private LoginClient.Request createLoginRequestFromResponse(GraphResponse var1) {
      Validate.notNull(var1, "response");
      AccessToken var2 = var1.getRequest().getAccessToken();
      Set var3;
      if (var2 != null) {
         var3 = var2.getPermissions();
      } else {
         var3 = null;
      }

      return this.createLoginRequest(var3);
   }

   private void finishLogin(AccessToken var1, LoginClient.Request var2, FacebookException var3, boolean var4, FacebookCallback<LoginResult> var5) {
      if (var1 != null) {
         AccessToken.setCurrentAccessToken(var1);
         Profile.fetchProfileForCurrentAccessToken();
      }

      if (var5 != null) {
         LoginResult var6;
         if (var1 != null) {
            var6 = computeLoginResult(var2, var1);
         } else {
            var6 = null;
         }

         if (!var4 && (var6 == null || var6.getRecentlyGrantedPermissions().size() != 0)) {
            if (var3 != null) {
               var5.onError(var3);
            } else if (var1 != null) {
               var5.onSuccess(var6);
            }
         } else {
            var5.onCancel();
         }
      }
   }

   public static LoginManager getInstance() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: getstatic com/facebook/login/LoginManager.instance Lcom/facebook/login/LoginManager;
      // 03: ifnonnull 1e
      // 06: ldc com/facebook/login/LoginManager
      // 08: monitorenter
      // 09: getstatic com/facebook/login/LoginManager.instance Lcom/facebook/login/LoginManager;
      // 0c: ifnonnull 1b
      // 0f: new com/facebook/login/LoginManager
      // 12: astore 0
      // 13: aload 0
      // 14: invokespecial com/facebook/login/LoginManager.<init> ()V
      // 17: aload 0
      // 18: putstatic com/facebook/login/LoginManager.instance Lcom/facebook/login/LoginManager;
      // 1b: ldc com/facebook/login/LoginManager
      // 1d: monitorexit
      // 1e: getstatic com/facebook/login/LoginManager.instance Lcom/facebook/login/LoginManager;
      // 21: areturn
      // 22: astore 0
      // 23: ldc com/facebook/login/LoginManager
      // 25: monitorexit
      // 26: aload 0
      // 27: athrow
      // try (4 -> 12): 16 null
      // try (12 -> 14): 16 null
      // try (17 -> 19): 16 null
   }

   private static Set<String> getOtherPublishPermissions() {
      return Collections.unmodifiableSet(new HashSet<String>() {
         {
            this.add("ads_management");
            this.add("create_event");
            this.add("rsvp_event");
         }
      });
   }

   static boolean isPublishPermission(String var0) {
      boolean var1;
      if (var0 == null || !var0.startsWith("publish") && !var0.startsWith("manage") && !OTHER_PUBLISH_PERMISSIONS.contains(var0)) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   private void logCompleteLogin(Context var1, LoginClient.Result.Code var2, Map<String, String> var3, Exception var4, boolean var5, LoginClient.Request var6) {
      LoginLogger var8 = LoginManager.LoginLoggerHolder.getLogger(var1);
      if (var8 != null) {
         if (var6 == null) {
            var8.logUnexpectedError("fb_mobile_login_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.");
         } else {
            HashMap var7 = new HashMap();
            String var9;
            if (var5) {
               var9 = "1";
            } else {
               var9 = "0";
            }

            var7.put("try_login_activity", var9);
            var8.logCompleteLogin(var6.getAuthId(), var7, var2, var3, var4);
         }
      }
   }

   private void logInWithPublishPermissions(FragmentWrapper var1, Collection<String> var2) {
      this.validatePublishPermissions(var2);
      LoginClient.Request var3 = this.createLoginRequest(var2);
      this.startLogin(new LoginManager.FragmentStartActivityDelegate(var1), var3);
   }

   private void logInWithReadPermissions(FragmentWrapper var1, Collection<String> var2) {
      this.validateReadPermissions(var2);
      LoginClient.Request var3 = this.createLoginRequest(var2);
      this.startLogin(new LoginManager.FragmentStartActivityDelegate(var1), var3);
   }

   private void logStartLogin(Context var1, LoginClient.Request var2) {
      LoginLogger var3 = LoginManager.LoginLoggerHolder.getLogger(var1);
      if (var3 != null && var2 != null) {
         var3.logStartLogin(var2);
      }
   }

   private void resolveError(FragmentWrapper var1, GraphResponse var2) {
      this.startLogin(new LoginManager.FragmentStartActivityDelegate(var1), this.createLoginRequestFromResponse(var2));
   }

   private boolean resolveIntent(Intent var1) {
      boolean var2 = false;
      if (FacebookSdk.getApplicationContext().getPackageManager().resolveActivity(var1, 0) != null) {
         var2 = true;
      }

      return var2;
   }

   private void startLogin(StartActivityDelegate var1, LoginClient.Request var2) throws FacebookException {
      this.logStartLogin(var1.getActivityContext(), var2);
      CallbackManagerImpl.registerStaticCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode(), new CallbackManagerImpl.Callback(this) {
         final LoginManager this$0;

         {
            this.this$0 = var1;
         }

         @Override
         public boolean onActivityResult(int var1, Intent var2x) {
            return this.this$0.onActivityResult(var1, var2x);
         }
      });
      if (!this.tryFacebookActivity(var1, var2)) {
         FacebookException var3 = new FacebookException(
            "Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest."
         );
         this.logCompleteLogin(var1.getActivityContext(), LoginClient.Result.Code.ERROR, null, var3, false, var2);
         throw var3;
      }
   }

   private boolean tryFacebookActivity(StartActivityDelegate var1, LoginClient.Request var2) {
      boolean var3 = false;
      Intent var5 = this.getFacebookActivityIntent(var2);
      if (this.resolveIntent(var5)) {
         try {
            var1.startActivityForResult(var5, LoginClient.getLoginRequestCode());
         } catch (ActivityNotFoundException var4) {
            return var3;
         }

         var3 = true;
      }

      return var3;
   }

   private void validatePublishPermissions(Collection<String> var1) {
      if (var1 != null) {
         for (String var3 : var1) {
            if (!isPublishPermission(var3)) {
               throw new FacebookException(String.format("Cannot pass a read permission (%s) to a request for publish authorization", var3));
            }
         }
      }
   }

   private void validateReadPermissions(Collection<String> var1) {
      if (var1 != null) {
         for (String var3 : var1) {
            if (isPublishPermission(var3)) {
               throw new FacebookException(String.format("Cannot pass a publish or manage permission (%s) to a request for read authorization", var3));
            }
         }
      }
   }

   protected LoginClient.Request createLoginRequest(Collection<String> var1) {
      LoginBehavior var3 = this.loginBehavior;
      if (var1 != null) {
         var1 = new HashSet(var1);
      } else {
         var1 = new HashSet();
      }

      LoginClient.Request var5 = new LoginClient.Request(
         var3, Collections.unmodifiableSet(var1), this.defaultAudience, FacebookSdk.getApplicationId(), UUID.randomUUID().toString()
      );
      boolean var2;
      if (AccessToken.getCurrentAccessToken() != null) {
         var2 = true;
      } else {
         var2 = false;
      }

      var5.setRerequest(var2);
      return var5;
   }

   public DefaultAudience getDefaultAudience() {
      return this.defaultAudience;
   }

   protected Intent getFacebookActivityIntent(LoginClient.Request var1) {
      Intent var2 = new Intent();
      var2.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
      var2.setAction(var1.getLoginBehavior().toString());
      Bundle var3 = new Bundle();
      var3.putParcelable("request", var1);
      var2.putExtra("com.facebook.LoginFragment:Request", var3);
      return var2;
   }

   public LoginBehavior getLoginBehavior() {
      return this.loginBehavior;
   }

   public void logInWithPublishPermissions(Activity var1, Collection<String> var2) {
      this.validatePublishPermissions(var2);
      LoginClient.Request var3 = this.createLoginRequest(var2);
      this.startLogin(new LoginManager.ActivityStartActivityDelegate(var1), var3);
   }

   public void logInWithPublishPermissions(Fragment var1, Collection<String> var2) {
      this.logInWithPublishPermissions(new FragmentWrapper(var1), var2);
   }

   public void logInWithPublishPermissions(android.support.v4.app.Fragment var1, Collection<String> var2) {
      this.logInWithPublishPermissions(new FragmentWrapper(var1), var2);
   }

   public void logInWithReadPermissions(Activity var1, Collection<String> var2) {
      this.validateReadPermissions(var2);
      LoginClient.Request var3 = this.createLoginRequest(var2);
      this.startLogin(new LoginManager.ActivityStartActivityDelegate(var1), var3);
   }

   public void logInWithReadPermissions(Fragment var1, Collection<String> var2) {
      this.logInWithReadPermissions(new FragmentWrapper(var1), var2);
   }

   public void logInWithReadPermissions(android.support.v4.app.Fragment var1, Collection<String> var2) {
      this.logInWithReadPermissions(new FragmentWrapper(var1), var2);
   }

   public void logOut() {
      AccessToken.setCurrentAccessToken(null);
      Profile.setCurrentProfile(null);
   }

   boolean onActivityResult(int var1, Intent var2) {
      return this.onActivityResult(var1, var2, null);
   }

   boolean onActivityResult(int var1, Intent var2, FacebookCallback<LoginResult> var3) {
      Map var7 = null;
      AccessToken var9 = null;
      LoginClient.Result.Code var6 = LoginClient.Result.Code.ERROR;
      boolean var5 = false;
      boolean var4 = false;
      FacebookAuthorizationException var15;
      LoginClient.Request var20;
      if (var2 != null) {
         LoginClient.Result var11 = (LoginClient.Result)var2.getParcelableExtra("com.facebook.LoginFragment:Result");
         Map var14;
         FacebookAuthorizationException var17;
         AccessToken var19;
         LoginClient.Request var22;
         if (var11 != null) {
            LoginClient.Request var10 = var11.request;
            LoginClient.Result.Code var8 = var11.code;
            FacebookAuthorizationException var12;
            AccessToken var16;
            if (var1 == -1) {
               if (var11.code == LoginClient.Result.Code.SUCCESS) {
                  var16 = var11.token;
                  var12 = var7;
               } else {
                  var12 = new FacebookAuthorizationException(var11.errorMessage);
                  var16 = var9;
               }
            } else {
               var16 = var9;
               var12 = var7;
               if (var1 == 0) {
                  var4 = true;
                  var16 = var9;
                  var12 = var7;
               }
            }

            Map var21 = var11.loggingExtras;
            var17 = var12;
            LoginClient.Result.Code var13 = var8;
            var19 = var16;
            var6 = var13;
            var14 = var21;
            var22 = var10;
         } else {
            var22 = null;
            var19 = null;
            var14 = null;
            var17 = null;
            var4 = var5;
         }

         LoginClient.Request var24 = var22;
         Map var26 = var14;
         var9 = var19;
         var20 = var24;
         var15 = var17;
         var7 = var26;
      } else if (var1 == 0) {
         var6 = LoginClient.Result.Code.CANCEL;
         var4 = true;
         var9 = null;
         var20 = null;
         var15 = null;
         var7 = null;
      } else {
         var4 = false;
         var9 = null;
         var20 = null;
         var15 = null;
         var7 = null;
      }

      FacebookException var25 = var15;
      if (var15 == null) {
         var25 = var15;
         if (var9 == null) {
            var25 = var15;
            if (!var4) {
               var25 = new FacebookException("Unexpected call to LoginManager.onActivityResult");
            }
         }
      }

      this.logCompleteLogin(null, var6, var7, var25, true, var20);
      this.finishLogin(var9, var20, var25, var4, var3);
      return true;
   }

   public void registerCallback(CallbackManager var1, FacebookCallback<LoginResult> var2) {
      if (!(var1 instanceof CallbackManagerImpl)) {
         throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
      }

      ((CallbackManagerImpl)var1).registerCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode(), new CallbackManagerImpl.Callback(this, var2) {
         final LoginManager this$0;
         final FacebookCallback val$callback;

         {
            this.this$0 = var1;
            this.val$callback = var2x;
         }

         @Override
         public boolean onActivityResult(int var1, Intent var2x) {
            return this.this$0.onActivityResult(var1, var2x, this.val$callback);
         }
      });
   }

   public void resolveError(Activity var1, GraphResponse var2) {
      this.startLogin(new LoginManager.ActivityStartActivityDelegate(var1), this.createLoginRequestFromResponse(var2));
   }

   public void resolveError(Fragment var1, GraphResponse var2) {
      this.resolveError(new FragmentWrapper(var1), var2);
   }

   public void resolveError(android.support.v4.app.Fragment var1, GraphResponse var2) {
      this.resolveError(new FragmentWrapper(var1), var2);
   }

   public LoginManager setDefaultAudience(DefaultAudience var1) {
      this.defaultAudience = var1;
      return this;
   }

   public LoginManager setLoginBehavior(LoginBehavior var1) {
      this.loginBehavior = var1;
      return this;
   }

   private static class ActivityStartActivityDelegate implements StartActivityDelegate {
      private final Activity activity;

      ActivityStartActivityDelegate(Activity var1) {
         Validate.notNull(var1, "activity");
         this.activity = var1;
      }

      @Override
      public Activity getActivityContext() {
         return this.activity;
      }

      @Override
      public void startActivityForResult(Intent var1, int var2) {
         this.activity.startActivityForResult(var1, var2);
      }
   }

   private static class FragmentStartActivityDelegate implements StartActivityDelegate {
      private final FragmentWrapper fragment;

      FragmentStartActivityDelegate(FragmentWrapper var1) {
         Validate.notNull(var1, "fragment");
         this.fragment = var1;
      }

      @Override
      public Activity getActivityContext() {
         return this.fragment.getActivity();
      }

      @Override
      public void startActivityForResult(Intent var1, int var2) {
         this.fragment.startActivityForResult(var1, var2);
      }
   }

   private static class LoginLoggerHolder {
      private static volatile LoginLogger logger;

      private static LoginLogger getLogger(Context param0) {
         // $VF: Couldn't be decompiled
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
         //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
         //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
         //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
         //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
         //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
         //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1065)
         //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:566)
         //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
         //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
         //
         // Bytecode:
         // 00: ldc com/facebook/login/LoginManager$LoginLoggerHolder
         // 02: monitorenter
         // 03: aload 0
         // 04: ifnull 12
         // 07: aload 0
         // 08: ifnonnull 19
         // 0b: aconst_null
         // 0c: astore 0
         // 0d: ldc com/facebook/login/LoginManager$LoginLoggerHolder
         // 0f: monitorexit
         // 10: aload 0
         // 11: areturn
         // 12: invokestatic com/facebook/FacebookSdk.getApplicationContext ()Landroid/content/Context;
         // 15: astore 0
         // 16: goto 07
         // 19: getstatic com/facebook/login/LoginManager$LoginLoggerHolder.logger Lcom/facebook/login/LoginLogger;
         // 1c: ifnonnull 2f
         // 1f: new com/facebook/login/LoginLogger
         // 22: astore 1
         // 23: aload 1
         // 24: aload 0
         // 25: invokestatic com/facebook/FacebookSdk.getApplicationId ()Ljava/lang/String;
         // 28: invokespecial com/facebook/login/LoginLogger.<init> (Landroid/content/Context;Ljava/lang/String;)V
         // 2b: aload 1
         // 2c: putstatic com/facebook/login/LoginManager$LoginLoggerHolder.logger Lcom/facebook/login/LoginLogger;
         // 2f: getstatic com/facebook/login/LoginManager$LoginLoggerHolder.logger Lcom/facebook/login/LoginLogger;
         // 32: astore 0
         // 33: goto 0d
         // 36: astore 0
         // 37: ldc com/facebook/login/LoginManager$LoginLoggerHolder
         // 39: monitorexit
         // 3a: aload 0
         // 3b: athrow
         // try (12 -> 14): 28 null
         // try (15 -> 25): 28 null
         // try (25 -> 27): 28 null
      }
   }
}
