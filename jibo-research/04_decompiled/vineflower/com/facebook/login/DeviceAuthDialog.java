package com.facebook.login;

import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.DialogFragment;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.R;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.SmartLoginOption;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.util.Date;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceAuthDialog extends DialogFragment {
   private static final String DEVICE_LOGIN_ENDPOINT = "device/login";
   private static final String DEVICE_LOGIN_STATUS_ENDPOINT = "device/login_status";
   private static final int LOGIN_ERROR_SUBCODE_AUTHORIZATION_DECLINED = 1349173;
   private static final int LOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING = 1349174;
   private static final int LOGIN_ERROR_SUBCODE_CODE_EXPIRED = 1349152;
   private static final int LOGIN_ERROR_SUBCODE_EXCESSIVE_POLLING = 1349172;
   private static final String REQUEST_STATE_KEY = "request_state";
   private AtomicBoolean completed = new AtomicBoolean();
   private TextView confirmationCode;
   private volatile GraphRequestAsyncTask currentGraphRequestPoll;
   private volatile DeviceAuthDialog.RequestState currentRequestState;
   private DeviceAuthMethodHandler deviceAuthMethodHandler;
   private Dialog dialog;
   private boolean isBeingDestroyed = false;
   private boolean isRetry = false;
   private LoginClient.Request mRequest = null;
   private ProgressBar progressBar;
   private volatile ScheduledFuture scheduledPoll;

   private void completeLogin(String var1, Utility.PermissionsPair var2, String var3) {
      this.deviceAuthMethodHandler
         .onSuccess(
            var3, FacebookSdk.getApplicationId(), var1, var2.getGrantedPermissions(), var2.getDeclinedPermissions(), AccessTokenSource.DEVICE_AUTH, null, null
         );
      this.dialog.dismiss();
   }

   private GraphRequest getPollRequest() {
      Bundle var1 = new Bundle();
      var1.putString("code", this.currentRequestState.getRequestCode());
      return new GraphRequest(null, "device/login_status", var1, HttpMethod.POST, new GraphRequest.Callback(this) {
         final DeviceAuthDialog this$0;

         {
            this.this$0 = var1;
         }

         @Override
         public void onCompleted(GraphResponse var1) {
            if (!this.this$0.completed.get()) {
               FacebookRequestError var2 = var1.getError();
               if (var2 != null) {
                  switch (var2.getSubErrorCode()) {
                     case 1349152:
                     case 1349173:
                        this.this$0.onCancel();
                        break;
                     case 1349172:
                     case 1349174:
                        this.this$0.schedulePoll();
                        break;
                     default:
                        this.this$0.onError(var1.getError().getException());
                  }
               } else {
                  try {
                     JSONObject var4 = var1.getJSONObject();
                     this.this$0.onSuccess(var4.getString("access_token"));
                  } catch (JSONException var3) {
                     this.this$0.onError(new FacebookException(var3));
                  }
               }
            }
         }
      });
   }

   private View initializeContentView(boolean var1) {
      LayoutInflater var2 = this.getActivity().getLayoutInflater();
      View var3;
      if (var1) {
         var3 = var2.inflate(R.layout.com_facebook_smart_device_dialog_fragment, null);
      } else {
         var3 = var2.inflate(R.layout.com_facebook_device_auth_dialog_fragment, null);
      }

      this.progressBar = (ProgressBar)var3.findViewById(R.id.progress_bar);
      this.confirmationCode = (TextView)var3.findViewById(R.id.confirmation_code);
      ((Button)var3.findViewById(R.id.cancel_button)).setOnClickListener(new OnClickListener(this) {
         final DeviceAuthDialog this$0;

         {
            this.this$0 = var1;
         }

         public void onClick(View var1) {
            this.this$0.onCancel();
         }
      });
      ((TextView)var3.findViewById(R.id.com_facebook_device_auth_instructions))
         .setText(Html.fromHtml(this.getString(R.string.com_facebook_device_auth_instructions)));
      return var3;
   }

   private void onCancel() {
      if (this.completed.compareAndSet(false, true)) {
         if (this.currentRequestState != null) {
            DeviceRequestsHelper.cleanUpAdvertisementService(this.currentRequestState.getUserCode());
         }

         if (this.deviceAuthMethodHandler != null) {
            this.deviceAuthMethodHandler.onCancel();
         }

         this.dialog.dismiss();
      }
   }

   private void onError(FacebookException var1) {
      if (this.completed.compareAndSet(false, true)) {
         if (this.currentRequestState != null) {
            DeviceRequestsHelper.cleanUpAdvertisementService(this.currentRequestState.getUserCode());
         }

         this.deviceAuthMethodHandler.onError(var1);
         this.dialog.dismiss();
      }
   }

   private void onSuccess(String var1) {
      Bundle var2 = new Bundle();
      var2.putString("fields", "id,permissions,name");
      new GraphRequest(
            new AccessToken(var1, FacebookSdk.getApplicationId(), "0", null, null, null, null, null),
            "me",
            var2,
            HttpMethod.GET,
            new GraphRequest.Callback(this, var1) {
               final DeviceAuthDialog this$0;
               final String val$accessToken;

               {
                  this.this$0 = var1;
                  this.val$accessToken = var2x;
               }

               @Override
               public void onCompleted(GraphResponse var1) {
                  if (!this.this$0.completed.get()) {
                     if (var1.getError() != null) {
                        this.this$0.onError(var1.getError().getException());
                     } else {
                        Utility.PermissionsPair var2x;
                        String var6;
                        try {
                           JSONObject var3 = var1.getJSONObject();
                           var5 = var3.getString("id");
                           var2x = Utility.handlePermissionResponse(var3);
                           var6 = var3.getString("name");
                        } catch (JSONException var4) {
                           this.this$0.onError(new FacebookException(var4));
                           return;
                        }

                        DeviceRequestsHelper.cleanUpAdvertisementService(this.this$0.currentRequestState.getUserCode());
                        if (FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId())
                              .getSmartLoginOptions()
                              .contains(SmartLoginOption.RequireConfirm)
                           && !this.this$0.isRetry) {
                           this.this$0.isRetry = true;
                           this.this$0.presentConfirmation(var5, var2x, this.val$accessToken, var6);
                        } else {
                           this.this$0.completeLogin(var5, var2x, this.val$accessToken);
                        }
                     }
                  }
               }
            }
         )
         .executeAsync();
   }

   private void poll() {
      this.currentRequestState.setLastPoll(new Date().getTime());
      this.currentGraphRequestPoll = this.getPollRequest().executeAsync();
   }

   private void presentConfirmation(String var1, Utility.PermissionsPair var2, String var3, String var4) {
      String var5 = this.getResources().getString(R.string.com_facebook_smart_login_confirmation_title);
      String var7 = this.getResources().getString(R.string.com_facebook_smart_login_confirmation_continue_as);
      String var6 = this.getResources().getString(R.string.com_facebook_smart_login_confirmation_cancel);
      var4 = String.format(var7, var4);
      Builder var9 = new Builder(this.getContext());
      var9.setMessage(var5).setCancelable(true).setNegativeButton(var4, new android.content.DialogInterface.OnClickListener(this, var1, var2, var3) {
         final DeviceAuthDialog this$0;
         final String val$accessToken;
         final Utility.PermissionsPair val$permissions;
         final String val$userId;

         {
            this.this$0 = var1;
            this.val$userId = var2x;
            this.val$permissions = var3x;
            this.val$accessToken = var4x;
         }

         public void onClick(DialogInterface var1, int var2x) {
            this.this$0.completeLogin(this.val$userId, this.val$permissions, this.val$accessToken);
         }
      }).setPositiveButton(var6, new android.content.DialogInterface.OnClickListener(this) {
         final DeviceAuthDialog this$0;

         {
            this.this$0 = var1;
         }

         public void onClick(DialogInterface var1, int var2) {
            View var3 = this.this$0.initializeContentView(false);
            this.this$0.dialog.setContentView(var3);
            this.this$0.startLogin(this.this$0.mRequest);
         }
      });
      var9.create().show();
   }

   private void schedulePoll() {
      this.scheduledPoll = DeviceAuthMethodHandler.getBackgroundExecutor().schedule(new Runnable(this) {
         final DeviceAuthDialog this$0;

         {
            this.this$0 = var1;
         }

         @Override
         public void run() {
            this.this$0.poll();
         }
      }, this.currentRequestState.getInterval(), TimeUnit.SECONDS);
   }

   private void setCurrentRequestState(DeviceAuthDialog.RequestState var1) {
      this.currentRequestState = var1;
      this.confirmationCode.setText(var1.getUserCode());
      this.confirmationCode.setVisibility(0);
      this.progressBar.setVisibility(8);
      if (!this.isRetry && DeviceRequestsHelper.startAdvertisementService(var1.getUserCode())) {
         AppEventsLogger.newLogger(this.getContext()).logSdkEvent("fb_smart_login_service", null, null);
      }

      if (var1.withinLastRefreshWindow()) {
         this.schedulePoll();
      } else {
         this.poll();
      }
   }

   @Override
   public Dialog onCreateDialog(Bundle var1) {
      this.dialog = new Dialog(this.getActivity(), R.style.com_facebook_auth_dialog);
      this.getActivity().getLayoutInflater();
      boolean var2;
      if (DeviceRequestsHelper.isAvailable() && !this.isRetry) {
         var2 = true;
      } else {
         var2 = false;
      }

      View var3 = this.initializeContentView(var2);
      this.dialog.setContentView(var3);
      return this.dialog;
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      View var4 = super.onCreateView(var1, var2, var3);
      this.deviceAuthMethodHandler = (DeviceAuthMethodHandler)((LoginFragment)((FacebookActivity)this.getActivity()).getCurrentFragment())
         .getLoginClient()
         .getCurrentHandler();
      if (var3 != null) {
         DeviceAuthDialog.RequestState var5 = (DeviceAuthDialog.RequestState)var3.getParcelable("request_state");
         if (var5 != null) {
            this.setCurrentRequestState(var5);
         }
      }

      return var4;
   }

   @Override
   public void onDestroy() {
      this.isBeingDestroyed = true;
      this.completed.set(true);
      super.onDestroy();
      if (this.currentGraphRequestPoll != null) {
         this.currentGraphRequestPoll.cancel(true);
      }

      if (this.scheduledPoll != null) {
         this.scheduledPoll.cancel(true);
      }
   }

   @Override
   public void onDismiss(DialogInterface var1) {
      super.onDismiss(var1);
      if (!this.isBeingDestroyed) {
         this.onCancel();
      }
   }

   @Override
   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      if (this.currentRequestState != null) {
         var1.putParcelable("request_state", this.currentRequestState);
      }
   }

   public void startLogin(LoginClient.Request var1) {
      this.mRequest = var1;
      Bundle var2 = new Bundle();
      var2.putString("scope", TextUtils.join(",", var1.getPermissions()));
      String var3 = var1.getDeviceRedirectUriString();
      if (var3 != null) {
         var2.putString("redirect_uri", var3);
      }

      var2.putString("access_token", Validate.hasAppID() + "|" + Validate.hasClientToken());
      var2.putString("device_info", DeviceRequestsHelper.getDeviceInfo());
      new GraphRequest(null, "device/login", var2, HttpMethod.POST, new GraphRequest.Callback(this) {
         final DeviceAuthDialog this$0;

         {
            this.this$0 = var1;
         }

         @Override
         public void onCompleted(GraphResponse var1) {
            if (!this.this$0.isBeingDestroyed) {
               if (var1.getError() != null) {
                  this.this$0.onError(var1.getError().getException());
               } else {
                  JSONObject var2x = var1.getJSONObject();
                  DeviceAuthDialog.RequestState var4 = new DeviceAuthDialog.RequestState();

                  try {
                     var4.setUserCode(var2x.getString("user_code"));
                     var4.setRequestCode(var2x.getString("code"));
                     var4.setInterval(var2x.getLong("interval"));
                  } catch (JSONException var3x) {
                     this.this$0.onError(new FacebookException(var3x));
                     return;
                  }

                  this.this$0.setCurrentRequestState(var4);
               }
            }
         }
      }).executeAsync();
   }

   private static class RequestState implements Parcelable {
      public static final Creator<DeviceAuthDialog.RequestState> CREATOR = new Creator<DeviceAuthDialog.RequestState>() {
         public DeviceAuthDialog.RequestState createFromParcel(Parcel var1) {
            return new DeviceAuthDialog.RequestState(var1);
         }

         public DeviceAuthDialog.RequestState[] newArray(int var1) {
            return new DeviceAuthDialog.RequestState[var1];
         }
      };
      private long interval;
      private long lastPoll;
      private String requestCode;
      private String userCode;

      RequestState() {
      }

      protected RequestState(Parcel var1) {
         this.userCode = var1.readString();
         this.requestCode = var1.readString();
         this.interval = var1.readLong();
         this.lastPoll = var1.readLong();
      }

      public int describeContents() {
         return 0;
      }

      public long getInterval() {
         return this.interval;
      }

      public String getRequestCode() {
         return this.requestCode;
      }

      public String getUserCode() {
         return this.userCode;
      }

      public void setInterval(long var1) {
         this.interval = var1;
      }

      public void setLastPoll(long var1) {
         this.lastPoll = var1;
      }

      public void setRequestCode(String var1) {
         this.requestCode = var1;
      }

      public void setUserCode(String var1) {
         this.userCode = var1;
      }

      public boolean withinLastRefreshWindow() {
         boolean var1 = false;
         if (this.lastPoll != 0L && new Date().getTime() - this.lastPoll - this.interval * 1000L < 0L) {
            var1 = true;
         }

         return var1;
      }

      public void writeToParcel(Parcel var1, int var2) {
         var1.writeString(this.userCode);
         var1.writeString(this.requestCode);
         var1.writeLong(this.interval);
         var1.writeLong(this.lastPoll);
      }
   }
}
