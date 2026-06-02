package com.facebook.share.internal;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.R;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.Validate;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceShareDialogFragment extends DialogFragment {
   private static final String DEVICE_SHARE_ENDPOINT = "device/share";
   private static final String REQUEST_STATE_KEY = "request_state";
   public static final String TAG = "DeviceShareDialogFragment";
   private static ScheduledThreadPoolExecutor backgroundExecutor;
   private volatile ScheduledFuture codeExpiredFuture;
   private TextView confirmationCode;
   private volatile DeviceShareDialogFragment.RequestState currentRequestState;
   private Dialog dialog;
   private ProgressBar progressBar;
   private ShareContent shareContent;

   private void detach() {
      if (this.isAdded()) {
         this.getFragmentManager().a().a(this).d();
      }
   }

   private void finishActivity(int var1, Intent var2) {
      DeviceRequestsHelper.cleanUpAdvertisementService(this.currentRequestState.getUserCode());
      if (this.isAdded()) {
         FragmentActivity var3 = this.getActivity();
         var3.setResult(var1, var2);
         var3.finish();
      }
   }

   private void finishActivityWithError(FacebookRequestError var1) {
      this.detach();
      Intent var2 = new Intent();
      var2.putExtra("error", var1);
      this.finishActivity(-1, var2);
   }

   private static ScheduledThreadPoolExecutor getBackgroundExecutor() {
      synchronized (DeviceShareDialogFragment.class) {
         if (backgroundExecutor == null) {
            ScheduledThreadPoolExecutor var0 = new ScheduledThreadPoolExecutor(1);
            backgroundExecutor = var0;
         }

         return backgroundExecutor;
      }
   }

   private Bundle getGraphParametersForShareContent() {
      ShareContent var1 = this.shareContent;
      Bundle var2;
      if (var1 == null) {
         var2 = null;
      } else if (var1 instanceof ShareLinkContent) {
         var2 = WebDialogParameters.create((ShareLinkContent)var1);
      } else if (var1 instanceof ShareOpenGraphContent) {
         var2 = WebDialogParameters.create((ShareOpenGraphContent)var1);
      } else {
         var2 = null;
      }

      return var2;
   }

   private void setCurrentRequestState(DeviceShareDialogFragment.RequestState var1) {
      this.currentRequestState = var1;
      this.confirmationCode.setText(var1.getUserCode());
      this.confirmationCode.setVisibility(0);
      this.progressBar.setVisibility(8);
      this.codeExpiredFuture = getBackgroundExecutor().schedule(new Runnable(this) {
         final DeviceShareDialogFragment this$0;

         {
            this.this$0 = var1;
         }

         @Override
         public void run() {
            this.this$0.dialog.dismiss();
         }
      }, var1.getExpiresIn(), TimeUnit.SECONDS);
   }

   private void startShare() {
      Bundle var1 = this.getGraphParametersForShareContent();
      if (var1 == null || var1.size() == 0) {
         this.finishActivityWithError(new FacebookRequestError(0, "", "Failed to get share content"));
      }

      var1.putString("access_token", Validate.hasAppID() + "|" + Validate.hasClientToken());
      var1.putString("device_info", DeviceRequestsHelper.getDeviceInfo());
      new GraphRequest(null, "device/share", var1, HttpMethod.POST, new GraphRequest.Callback(this) {
         final DeviceShareDialogFragment this$0;

         {
            this.this$0 = var1;
         }

         @Override
         public void onCompleted(GraphResponse var1) {
            FacebookRequestError var2 = var1.getError();
            if (var2 != null) {
               this.this$0.finishActivityWithError(var2);
            } else {
               JSONObject var4 = var1.getJSONObject();
               DeviceShareDialogFragment.RequestState var5 = new DeviceShareDialogFragment.RequestState();

               try {
                  var5.setUserCode(var4.getString("user_code"));
                  var5.setExpiresIn(var4.getLong("expires_in"));
               } catch (JSONException var3) {
                  this.this$0.finishActivityWithError(new FacebookRequestError(0, "", "Malformed server response"));
                  return;
               }

               this.this$0.setCurrentRequestState(var5);
            }
         }
      }).executeAsync();
   }

   @Override
   public Dialog onCreateDialog(Bundle var1) {
      this.dialog = new Dialog(this.getActivity(), R.style.com_facebook_auth_dialog);
      View var2 = this.getActivity().getLayoutInflater().inflate(R.layout.com_facebook_device_auth_dialog_fragment, null);
      this.progressBar = (ProgressBar)var2.findViewById(R.id.progress_bar);
      this.confirmationCode = (TextView)var2.findViewById(R.id.confirmation_code);
      ((Button)var2.findViewById(R.id.cancel_button)).setOnClickListener(new OnClickListener(this) {
         final DeviceShareDialogFragment this$0;

         {
            this.this$0 = var1;
         }

         public void onClick(View var1) {
            this.this$0.dialog.dismiss();
         }
      });
      ((TextView)var2.findViewById(R.id.com_facebook_device_auth_instructions))
         .setText(Html.fromHtml(this.getString(R.string.com_facebook_device_auth_instructions)));
      this.dialog.setContentView(var2);
      this.startShare();
      return this.dialog;
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      View var4 = super.onCreateView(var1, var2, var3);
      if (var3 != null) {
         DeviceShareDialogFragment.RequestState var5 = (DeviceShareDialogFragment.RequestState)var3.getParcelable("request_state");
         if (var5 != null) {
            this.setCurrentRequestState(var5);
         }
      }

      return var4;
   }

   @Override
   public void onDismiss(DialogInterface var1) {
      super.onDismiss(var1);
      if (this.codeExpiredFuture != null) {
         this.codeExpiredFuture.cancel(true);
      }

      this.finishActivity(-1, new Intent());
   }

   @Override
   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      if (this.currentRequestState != null) {
         var1.putParcelable("request_state", this.currentRequestState);
      }
   }

   public void setShareContent(ShareContent var1) {
      this.shareContent = var1;
   }

   private static class RequestState implements Parcelable {
      public static final Creator<DeviceShareDialogFragment.RequestState> CREATOR = new Creator<DeviceShareDialogFragment.RequestState>() {
         public DeviceShareDialogFragment.RequestState createFromParcel(Parcel var1) {
            return new DeviceShareDialogFragment.RequestState(var1);
         }

         public DeviceShareDialogFragment.RequestState[] newArray(int var1) {
            return new DeviceShareDialogFragment.RequestState[var1];
         }
      };
      private long expiresIn;
      private String userCode;

      RequestState() {
      }

      protected RequestState(Parcel var1) {
         this.userCode = var1.readString();
         this.expiresIn = var1.readLong();
      }

      public int describeContents() {
         return 0;
      }

      public long getExpiresIn() {
         return this.expiresIn;
      }

      public String getUserCode() {
         return this.userCode;
      }

      public void setExpiresIn(long var1) {
         this.expiresIn = var1;
      }

      public void setUserCode(String var1) {
         this.userCode = var1;
      }

      public void writeToParcel(Parcel var1, int var2) {
         var1.writeString(this.userCode);
         var1.writeLong(this.expiresIn);
      }
   }
}
