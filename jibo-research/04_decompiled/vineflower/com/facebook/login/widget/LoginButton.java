package com.facebook.login.widget;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.os.Bundle;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookButtonBase;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.R;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.LoginAuthorizationType;
import com.facebook.internal.Utility;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LoginButton extends FacebookButtonBase {
   private static final String TAG = LoginButton.class.getName();
   private AccessTokenTracker accessTokenTracker;
   private boolean confirmLogout;
   private String loginLogoutEventName;
   private LoginManager loginManager;
   private String loginText;
   private String logoutText;
   private LoginButton.LoginButtonProperties properties = new LoginButton.LoginButtonProperties();
   private boolean toolTipChecked;
   private long toolTipDisplayTime;
   private LoginButton.ToolTipMode toolTipMode;
   private ToolTipPopup toolTipPopup;
   private ToolTipPopup.Style toolTipStyle;

   public LoginButton(Context var1) {
      super(var1, null, 0, 0, "fb_login_button_create", "fb_login_button_did_tap");
      this.loginLogoutEventName = "fb_login_view_usage";
      this.toolTipStyle = ToolTipPopup.Style.BLUE;
      this.toolTipDisplayTime = 6000L;
   }

   public LoginButton(Context var1, AttributeSet var2) {
      super(var1, var2, 0, 0, "fb_login_button_create", "fb_login_button_did_tap");
      this.loginLogoutEventName = "fb_login_view_usage";
      this.toolTipStyle = ToolTipPopup.Style.BLUE;
      this.toolTipDisplayTime = 6000L;
   }

   public LoginButton(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3, 0, "fb_login_button_create", "fb_login_button_did_tap");
      this.loginLogoutEventName = "fb_login_view_usage";
      this.toolTipStyle = ToolTipPopup.Style.BLUE;
      this.toolTipDisplayTime = 6000L;
   }

   private void checkToolTipSettings() {
      switch (<unrepresentable>.$SwitchMap$com$facebook$login$widget$LoginButton$ToolTipMode[this.toolTipMode.ordinal()]) {
         case 1:
            String var1 = Utility.getMetadataApplicationId(this.getContext());
            FacebookSdk.getExecutor().execute(new Runnable(this, var1) {
               final LoginButton this$0;
               final String val$appId;

               {
                  this.this$0 = var1;
                  this.val$appId = var2;
               }

               @Override
               public void run() {
                  FetchedAppSettings var1x = FetchedAppSettingsManager.queryAppSettings(this.val$appId, false);
                  this.this$0.getActivity().runOnUiThread(new Runnable(this, var1x) {
                     final <unrepresentable> this$1;
                     final FetchedAppSettings val$settings;

                     {
                        this.this$1 = var1;
                        this.val$settings = var2;
                     }

                     @Override
                     public void run() {
                        this.this$1.this$0.showToolTipPerSettings(this.val$settings);
                     }
                  });
               }
            });
            break;
         case 2:
            this.displayToolTip(this.getResources().getString(R.string.com_facebook_tooltip_default));
      }
   }

   private void displayToolTip(String var1) {
      this.toolTipPopup = new ToolTipPopup(var1, this);
      this.toolTipPopup.setStyle(this.toolTipStyle);
      this.toolTipPopup.setNuxDisplayTime(this.toolTipDisplayTime);
      this.toolTipPopup.show();
   }

   private int measureButtonWidth(String var1) {
      return this.measureTextWidth(var1) + this.getCompoundPaddingLeft() + this.getCompoundDrawablePadding() + this.getCompoundPaddingRight();
   }

   private void parseLoginButtonAttributes(Context var1, AttributeSet var2, int var3, int var4) {
      this.toolTipMode = LoginButton.ToolTipMode.DEFAULT;
      TypedArray var7 = var1.getTheme().obtainStyledAttributes(var2, R.styleable.com_facebook_login_view, var3, var4);

      try {
         this.confirmLogout = var7.getBoolean(R.styleable.com_facebook_login_view_com_facebook_confirm_logout, true);
         this.loginText = var7.getString(R.styleable.com_facebook_login_view_com_facebook_login_text);
         this.logoutText = var7.getString(R.styleable.com_facebook_login_view_com_facebook_logout_text);
         this.toolTipMode = LoginButton.ToolTipMode.fromInt(
            var7.getInt(R.styleable.com_facebook_login_view_com_facebook_tooltip_mode, LoginButton.ToolTipMode.DEFAULT.getValue())
         );
      } finally {
         var7.recycle();
      }
   }

   private void setButtonText() {
      Resources var4 = this.getResources();
      if (!this.isInEditMode() && AccessToken.getCurrentAccessToken() != null) {
         String var5;
         if (this.logoutText != null) {
            var5 = this.logoutText;
         } else {
            var5 = var4.getString(R.string.com_facebook_loginview_log_out_button);
         }

         this.setText(var5);
      } else if (this.loginText != null) {
         this.setText(this.loginText);
      } else {
         String var3 = var4.getString(R.string.com_facebook_loginview_log_in_button_continue);
         int var1 = this.getWidth();
         String var2 = var3;
         if (var1 != 0) {
            var2 = var3;
            if (this.measureButtonWidth(var3) > var1) {
               var2 = var4.getString(R.string.com_facebook_loginview_log_in_button);
            }
         }

         this.setText(var2);
      }
   }

   private void showToolTipPerSettings(FetchedAppSettings var1) {
      if (var1 != null && var1.getNuxEnabled() && this.getVisibility() == 0) {
         this.displayToolTip(var1.getNuxContent());
      }
   }

   public void clearPermissions() {
      this.properties.clearPermissions();
   }

   @Override
   protected void configureButton(Context var1, AttributeSet var2, int var3, int var4) {
      super.configureButton(var1, var2, var3, var4);
      this.setInternalOnClickListener(this.getNewLoginClickListener());
      this.parseLoginButtonAttributes(var1, var2, var3, var4);
      if (this.isInEditMode()) {
         this.setBackgroundColor(this.getResources().getColor(R.color.com_facebook_blue));
         this.loginText = "Continue with Facebook";
      } else {
         this.accessTokenTracker = new AccessTokenTracker(this) {
            final LoginButton this$0;

            {
               this.this$0 = var1;
            }

            @Override
            protected void onCurrentAccessTokenChanged(AccessToken var1, AccessToken var2x) {
               this.this$0.setButtonText();
            }
         };
      }

      this.setButtonText();
      this.setCompoundDrawablesWithIntrinsicBounds(AppCompatResources.b(this.getContext(), R.drawable.com_facebook_button_login_logo), null, null, null);
   }

   public void dismissToolTip() {
      if (this.toolTipPopup != null) {
         this.toolTipPopup.dismiss();
         this.toolTipPopup = null;
      }
   }

   public DefaultAudience getDefaultAudience() {
      return this.properties.getDefaultAudience();
   }

   @Override
   protected int getDefaultRequestCode() {
      return CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
   }

   @Override
   protected int getDefaultStyleResource() {
      return R.style.com_facebook_loginview_default_style;
   }

   public LoginBehavior getLoginBehavior() {
      return this.properties.getLoginBehavior();
   }

   LoginManager getLoginManager() {
      if (this.loginManager == null) {
         this.loginManager = LoginManager.getInstance();
      }

      return this.loginManager;
   }

   protected LoginButton.LoginClickListener getNewLoginClickListener() {
      return new LoginButton.LoginClickListener(this);
   }

   List<String> getPermissions() {
      return this.properties.getPermissions();
   }

   public long getToolTipDisplayTime() {
      return this.toolTipDisplayTime;
   }

   public LoginButton.ToolTipMode getToolTipMode() {
      return this.toolTipMode;
   }

   @Override
   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      if (this.accessTokenTracker != null && !this.accessTokenTracker.isTracking()) {
         this.accessTokenTracker.startTracking();
         this.setButtonText();
      }
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      if (this.accessTokenTracker != null) {
         this.accessTokenTracker.stopTracking();
      }

      this.dismissToolTip();
   }

   @Override
   protected void onDraw(Canvas var1) {
      super.onDraw(var1);
      if (!this.toolTipChecked && !this.isInEditMode()) {
         this.toolTipChecked = true;
         this.checkToolTipSettings();
      }
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      super.onLayout(var1, var2, var3, var4, var5);
      this.setButtonText();
   }

   protected void onMeasure(int var1, int var2) {
      FontMetrics var7 = this.getPaint().getFontMetrics();
      int var5 = this.getCompoundPaddingTop();
      float var3 = Math.abs(var7.top);
      int var4 = (int)Math.ceil(Math.abs(var7.bottom) + var3);
      var2 = this.getCompoundPaddingBottom();
      Resources var9 = this.getResources();
      String var8 = this.loginText;
      String var12 = var8;
      if (var8 == null) {
         var12 = var9.getString(R.string.com_facebook_loginview_log_in_button_continue);
         int var6 = this.measureButtonWidth(var12);
         if (resolveSize(var6, var1) < var6) {
            var12 = var9.getString(R.string.com_facebook_loginview_log_in_button);
         }
      }

      int var11 = this.measureButtonWidth(var12);
      var8 = this.logoutText;
      String var13 = var8;
      if (var8 == null) {
         var13 = var9.getString(R.string.com_facebook_loginview_log_out_button);
      }

      this.setMeasuredDimension(resolveSize(Math.max(var11, this.measureButtonWidth(var13)), var1), var2 + var4 + var5);
   }

   protected void onVisibilityChanged(View var1, int var2) {
      super.onVisibilityChanged(var1, var2);
      if (var2 != 0) {
         this.dismissToolTip();
      }
   }

   public void registerCallback(CallbackManager var1, FacebookCallback<LoginResult> var2) {
      this.getLoginManager().registerCallback(var1, var2);
   }

   public void setDefaultAudience(DefaultAudience var1) {
      this.properties.setDefaultAudience(var1);
   }

   public void setLoginBehavior(LoginBehavior var1) {
      this.properties.setLoginBehavior(var1);
   }

   void setLoginManager(LoginManager var1) {
      this.loginManager = var1;
   }

   void setProperties(LoginButton.LoginButtonProperties var1) {
      this.properties = var1;
   }

   public void setPublishPermissions(List<String> var1) {
      this.properties.setPublishPermissions(var1);
   }

   public void setPublishPermissions(String... var1) {
      this.properties.setPublishPermissions(Arrays.asList(var1));
   }

   public void setReadPermissions(List<String> var1) {
      this.properties.setReadPermissions(var1);
   }

   public void setReadPermissions(String... var1) {
      this.properties.setReadPermissions(Arrays.asList(var1));
   }

   public void setToolTipDisplayTime(long var1) {
      this.toolTipDisplayTime = var1;
   }

   public void setToolTipMode(LoginButton.ToolTipMode var1) {
      this.toolTipMode = var1;
   }

   public void setToolTipStyle(ToolTipPopup.Style var1) {
      this.toolTipStyle = var1;
   }

   static class LoginButtonProperties {
      private LoginAuthorizationType authorizationType;
      private DefaultAudience defaultAudience = DefaultAudience.FRIENDS;
      private LoginBehavior loginBehavior;
      private List<String> permissions = Collections.emptyList();

      LoginButtonProperties() {
         this.authorizationType = null;
         this.loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
      }

      public void clearPermissions() {
         this.permissions = null;
         this.authorizationType = null;
      }

      public DefaultAudience getDefaultAudience() {
         return this.defaultAudience;
      }

      public LoginBehavior getLoginBehavior() {
         return this.loginBehavior;
      }

      List<String> getPermissions() {
         return this.permissions;
      }

      public void setDefaultAudience(DefaultAudience var1) {
         this.defaultAudience = var1;
      }

      public void setLoginBehavior(LoginBehavior var1) {
         this.loginBehavior = var1;
      }

      public void setPublishPermissions(List<String> var1) {
         if (LoginAuthorizationType.READ.equals(this.authorizationType)) {
            throw new UnsupportedOperationException("Cannot call setPublishPermissions after setReadPermissions has been called.");
         }

         if (Utility.isNullOrEmpty(var1)) {
            throw new IllegalArgumentException("Permissions for publish actions cannot be null or empty.");
         }

         this.permissions = var1;
         this.authorizationType = LoginAuthorizationType.PUBLISH;
      }

      public void setReadPermissions(List<String> var1) {
         if (LoginAuthorizationType.PUBLISH.equals(this.authorizationType)) {
            throw new UnsupportedOperationException("Cannot call setReadPermissions after setPublishPermissions has been called.");
         }

         this.permissions = var1;
         this.authorizationType = LoginAuthorizationType.READ;
      }
   }

   protected class LoginClickListener implements OnClickListener {
      final LoginButton this$0;

      protected LoginClickListener(LoginButton var1) {
         this.this$0 = var1;
      }

      protected LoginManager getLoginManager() {
         LoginManager var1 = LoginManager.getInstance();
         var1.setDefaultAudience(this.this$0.getDefaultAudience());
         var1.setLoginBehavior(this.this$0.getLoginBehavior());
         return var1;
      }

      public void onClick(View var1) {
         this.this$0.callExternalOnClickListener(var1);
         AccessToken var4 = AccessToken.getCurrentAccessToken();
         if (var4 != null) {
            this.performLogout(this.this$0.getContext());
         } else {
            this.performLogin();
         }

         AppEventsLogger var3 = AppEventsLogger.newLogger(this.this$0.getContext());
         Bundle var5 = new Bundle();
         byte var2;
         if (var4 != null) {
            var2 = 0;
         } else {
            var2 = 1;
         }

         var5.putInt("logging_in", var2);
         var3.logSdkEvent(this.this$0.loginLogoutEventName, null, var5);
      }

      protected void performLogin() {
         LoginManager var1 = this.getLoginManager();
         if (LoginAuthorizationType.PUBLISH.equals(this.this$0.properties.authorizationType)) {
            if (this.this$0.getFragment() != null) {
               var1.logInWithPublishPermissions(this.this$0.getFragment(), this.this$0.properties.permissions);
            } else if (this.this$0.getNativeFragment() != null) {
               var1.logInWithPublishPermissions(this.this$0.getNativeFragment(), this.this$0.properties.permissions);
            } else {
               var1.logInWithPublishPermissions(this.this$0.getActivity(), this.this$0.properties.permissions);
            }
         } else if (this.this$0.getFragment() != null) {
            var1.logInWithReadPermissions(this.this$0.getFragment(), this.this$0.properties.permissions);
         } else if (this.this$0.getNativeFragment() != null) {
            var1.logInWithReadPermissions(this.this$0.getNativeFragment(), this.this$0.properties.permissions);
         } else {
            var1.logInWithReadPermissions(this.this$0.getActivity(), this.this$0.properties.permissions);
         }
      }

      protected void performLogout(Context var1) {
         LoginManager var5 = this.getLoginManager();
         if (this.this$0.confirmLogout) {
            String var3 = this.this$0.getResources().getString(R.string.com_facebook_loginview_log_out_action);
            String var4 = this.this$0.getResources().getString(R.string.com_facebook_loginview_cancel_action);
            Profile var2 = Profile.getCurrentProfile();
            String var7;
            if (var2 != null && var2.getName() != null) {
               var7 = String.format(this.this$0.getResources().getString(R.string.com_facebook_loginview_logged_in_as), var2.getName());
            } else {
               var7 = this.this$0.getResources().getString(R.string.com_facebook_loginview_logged_in_using_facebook);
            }

            Builder var6 = new Builder(var1);
            var6.setMessage(var7).setCancelable(true).setPositiveButton(var3, new android.content.DialogInterface.OnClickListener(this, var5) {
               final LoginButton.LoginClickListener this$1;
               final LoginManager val$loginManager;

               {
                  this.this$1 = var1;
                  this.val$loginManager = var2x;
               }

               public void onClick(DialogInterface var1, int var2x) {
                  this.val$loginManager.logOut();
               }
            }).setNegativeButton(var4, null);
            var6.create().show();
         } else {
            var5.logOut();
         }
      }
   }

   public enum ToolTipMode {
      AUTOMATIC("automatic", 0),
      DISPLAY_ALWAYS("display_always", 1),
      NEVER_DISPLAY("never_display", 2);

      private static final LoginButton.ToolTipMode[] $VALUES = new LoginButton.ToolTipMode[]{
         LoginButton.ToolTipMode.AUTOMATIC, LoginButton.ToolTipMode.DISPLAY_ALWAYS, LoginButton.ToolTipMode.NEVER_DISPLAY
      };
      public static LoginButton.ToolTipMode DEFAULT = AUTOMATIC;
      private int intValue;
      private String stringValue;

      ToolTipMode(String var3, int var4) {
         this.stringValue = var3;
         this.intValue = var4;
      }

      public static LoginButton.ToolTipMode fromInt(int var0) {
         LoginButton.ToolTipMode[] var4 = values();
         int var2 = var4.length;
         int var1 = 0;

         LoginButton.ToolTipMode var3;
         while (true) {
            if (var1 >= var2) {
               var3 = null;
               break;
            }

            var3 = var4[var1];
            if (var3.getValue() == var0) {
               break;
            }

            var1++;
         }

         return var3;
      }

      public int getValue() {
         return this.intValue;
      }

      @Override
      public String toString() {
         return this.stringValue;
      }
   }
}
