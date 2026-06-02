package com.jibo.ui.fragment.account.skills;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnDismissListener;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import butterknife.BindView;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.handlers.AsyncHandler;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.skills.JiboSkillsAsyncClient;
import com.jibo.aws.integration.aws.services.skills.model.UpdateSettingsRequest;
import com.jibo.aws.integration.util.Commons;
import com.jibo.db.EntityData;
import com.jibo.ui.activity.OnBoardingActivity;
import com.jibo.ui.fragment.BaseFragment;
import com.jibo.ui.helpers.skills.DataItems;
import com.jibo.ui.helpers.skills.SkillsJsonParser;
import com.jibo.utils.SharedPreferencesUtil;
import java.lang.ref.WeakReference;

public class OauthFragment extends BaseFragment {
   private DataItems.ConnectableDataItem a;
   private DataItems.ConnectableDataValue b;
   private DataItems.OauthDataItem c;
   private JiboSkillsAsyncClient d;
   private OauthFragment.Type e = null;
   private boolean l = false;
   private SkillSettingsFragment.DataPublisher m = new SkillSettingsFragment.DataPublisher(this) {
      final OauthFragment a;

      {
         this.a = var1;
      }

      @Override
      public void a(DataItems.DataItem var1, DataItems.DataValue var2, Commons.AsyncCallback<DataItems.DataValue> var3) {
         if (var1 != null && var2 != null) {
            this.a.f();
            JsonElement var4 = new Gson().a(var2);
            UpdateSettingsRequest.UpdateSettingData var6 = new UpdateSettingsRequest.UpdateSettingData(
               var1.getValueDefinition().getKey(),
               new UpdateSettingsRequest.UpdateSettingData.UpdateSettingValue(
                  SkillsJsonParser.getInstance().getCurrentSkill().getSkillId(), var1.getValueDefinition().getTarget(), var4
               )
            );
            Loop var5 = SharedPreferencesUtil.f(this.a.getActivity());
            this.a.d.updateSkill(var5.getId(), var6, new AsyncHandler<UpdateSettingsRequest, UpdateSettingsRequest.UpdateSettingData>(this, var1) {
               final DataItems.DataItem a;
               final <unrepresentable> b;

               {
                  this.b = var1;
                  this.a = var2x;
               }

               public void a(UpdateSettingsRequest var1, UpdateSettingsRequest.UpdateSettingData var2x) {
                  if (var2x != null && var2x.value != null && var2x.value.value != null && var2x.value.value.l().c("credentialExists").g()) {
                     SkillsJsonParser.getInstance().updateData(this.a.getValueDefinition().getKey(), var2x.value.value);
                     this.b.a.b.setValue(true);
                     SkillsJsonParser.getInstance().updateData(this.b.a.a.getValueDefinition().getKey(), this.b.a.b);
                  }

                  SkillsJsonParser.getInstance().setItemDataValue(this.a);
                  this.b.a.g();
                  this.b.a.a(new Runnable(this) {
                     final <unrepresentable> a;

                     {
                        this.a = var1;
                     }

                     @Override
                     public void run() {
                        Snackbar.a(this.a.b.a.getView(), 2131755746, -1).c();
                        int var1x = this.a.b.a.getActivity().getSupportFragmentManager().e();
                        if (var1x - 2 > 0) {
                           var1x = this.a.b.a.getActivity().getSupportFragmentManager().b(var1x - 2).a();
                           this.a.b.a.getActivity().getSupportFragmentManager().b(var1x, 1);
                        } else {
                           this.a.b.a.getActivity().onBackPressed();
                        }
                     }
                  });
               }

               @Override
               public void onError(Exception var1) {
                  this.b.a.a(var1, "skills update skill", true);
               }
            });
         }
      }
   };
   @BindView
   WebView webview;

   private void a() {
      this.l = true;
      this.startActivity(new Intent("android.intent.action.VIEW", this.b()));
   }

   private Uri b() {
      String var3 = "";
      String var2 = var3;
      if (this.c.getOauthParams().getScopes()[0] != null) {
         var2 = var3;
         if (this.c.getOauthParams().getAuthorizationUri() != null) {
            var2 = var3;
            if (this.c.getOauthParams().getIosClientId() != null) {
               var2 = var3;
               if (this.c.getOauthParams().getIosCallbackUri() != null) {
                  var2 = var3;
                  if (this.c.getValueDefinition() != null) {
                     var2 = var3;
                     if (this.c.getValueDefinition().getKey() != null) {
                        var2 = this.c.getOauthParams().getAuthorizationUri()
                           + "?client_id="
                           + this.c.getOauthParams().getServerClientId()
                           + "&redirect_uri="
                           + "https://www.jibo.com/google-oauth-callback"
                           + "&response_type=code&scope=";

                        for (int var1 = 0; var1 < this.c.getOauthParams().getScopes().length; var1++) {
                           var2 = var2 + this.c.getOauthParams().getScopes()[var1] + " ";
                        }

                        var2 = var2.substring(0, var2.length() - 1);
                        var2 = var2 + "&response_mode=query&prompt=select_account consent&access_type=offline";
                     }
                  }
               }
            }
         }
      }

      return Uri.parse(var2);
   }

   @Override
   protected void a(ActionBar var1) {
      if (this.e != OauthFragment.Type.Google) {
         super.a(var1);
      }
   }

   @Override
   public void b(Bundle var1) {
      super.b(var1);
      if (SkillsJsonParser.isCreated()) {
         this.a = new Gson().a(var1.getString(DataItems.ConnectableDataItem.class.getSimpleName()), DataItems.ConnectableDataItem.class);
         SkillsJsonParser.getInstance().setItemDataValue(this.a);
         this.b = (DataItems.ConnectableDataValue)this.a.getDataValue();
         this.c = new Gson().a(var1.getString(DataItems.OauthDataItem.class.getSimpleName()), DataItems.OauthDataItem.class);
         SkillsJsonParser.getInstance().setItemDataValue(this.c);
         if (this.c.getValueDefinition().getKey().contains("google")) {
            this.e = OauthFragment.Type.Google;
         } else {
            this.e = OauthFragment.Type.Other;
         }
      }
   }

   @Override
   protected String o() {
      String var1;
      if (this.c == null) {
         var1 = "";
      } else {
         var1 = this.c.getTitle();
      }

      return var1;
   }

   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      View var4;
      if (this.e == OauthFragment.Type.Google) {
         var4 = new View(this.getActivity());
      } else {
         var4 = var1.inflate(2131427477, null);
      }

      return var4;
   }

   @Override
   public void onPause() {
      super.onPause();
   }

   @Override
   public void onResume() {
      super.onResume();
      if (this.c == null) {
         this.getView().postDelayed(new Runnable(this) {
            final OauthFragment a;

            {
               this.a = var1;
            }

            @Override
            public void run() {
               this.a.getActivity().onBackPressed();
            }
         }, 50L);
      }

      if (OnBoardingActivity.n != null) {
         this.l = false;
         String var1 = OnBoardingActivity.n;
         OnBoardingActivity.n = null;
         if (var1.contains("https://www.jibo.com/google-oauth-callback")) {
            var1 = Uri.parse(var1).getQueryParameter("code");
            DataItems.OauthDataValue.OauthValue var3 = new DataItems.OauthDataValue.OauthValue(
               this.c.getOauthParams().getServiceAccountName(),
               this.c.getOauthParams().getServiceName(),
               var1,
               this.c.getOauthParams().getServerClientId(),
               this.c.getOauthParams().getScopes()
            );
            this.m.a(this.c, var3, null);
         }
      } else if (this.l) {
         this.l = false;
         this.getView().postDelayed(new Runnable(this) {
            final OauthFragment a;

            {
               this.a = var1;
            }

            @Override
            public void run() {
               this.a.getActivity().onBackPressed();
            }
         }, 50L);
      }
   }

   @Override
   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.putString(DataItems.ConnectableDataItem.class.getSimpleName(), new Gson().b(this.a));
      var1.putString(DataItems.OauthDataItem.class.getSimpleName(), new Gson().b(this.c));
      var1.putBoolean("ARGS_SKILL_FRAGMENT", true);
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      if (SkillsJsonParser.isCreated()) {
         if (this.e == OauthFragment.Type.Google) {
            AlertDialog.Builder var7 = new AlertDialog.Builder(var1.getContext());
            var7.b(2131755573);
            var7.a(2131755569, null);
            var7.a(new OnDismissListener(this) {
               final OauthFragment a;

               {
                  this.a = var1;
               }

               public void onDismiss(DialogInterface var1) {
                  this.a.a();
               }
            });
            var7.b().show();
         } else {
            this.webview = (WebView)var1.findViewById(2131297076);
            this.webview.getSettings().setJavaScriptEnabled(true);
            this.webview.setWebViewClient(new OauthFragment.SignInViewClient(this, this));
            String var4;
            if (this.c.getOauthParams().getScopes()[0] != null
               && this.c.getOauthParams().getAuthorizationUri() != null
               && this.c.getOauthParams().getIosClientId() != null
               && this.c.getOauthParams().getIosCallbackUri() != null
               && this.c.getValueDefinition() != null
               && this.c.getValueDefinition().getKey() != null) {
               String var5 = this.c.getOauthParams().getAuthorizationUri()
                  + "?client_id="
                  + this.c.getOauthParams().getIosClientId()
                  + "&redirect_uri="
                  + this.c.getOauthParams().getIosCallbackUri()
                  + "&response_type=code&scope=";

               for (int var3 = 0; var3 < this.c.getOauthParams().getScopes().length; var3++) {
                  var5 = var5 + this.c.getOauthParams().getScopes()[var3] + "%20";
               }

               String var6 = var5.substring(0, var5.length() - 3);
               var4 = var6 + "&response_mode=query";
            } else {
               var4 = null;
            }

            this.webview.loadUrl(var4);
         }

         Account var8 = EntityData.a(this.getActivity()).i();
         if (var8 != null) {
            JiboSkillsAsyncClient var9 = new JiboSkillsAsyncClient(new BasicAWSCredentials(var8.getAccessKeyId(), var8.getSecretAccessKey()));
            this.d = var9;
            this.a(var9);
         }
      }
   }

   private class SignInViewClient extends WebViewClient {
      final OauthFragment a;
      private final WeakReference<OauthFragment> b;

      public SignInViewClient(OauthFragment var1, OauthFragment var2) {
         this.a = var1;
         this.b = new WeakReference<>(var2);
      }

      public boolean shouldOverrideUrlLoading(WebView var1, String var2) {
         Uri var5 = Uri.parse(var2);
         OauthFragment var4 = this.b.get();
         boolean var3;
         if (var4 == null || !var4.d()) {
            var3 = true;
         } else if (var2.contains(this.a.c.getOauthParams().getIosCallbackUri())) {
            String var6 = var5.getQueryParameter("code");
            DataItems.OauthDataValue.OauthValue var7 = new DataItems.OauthDataValue.OauthValue(
               this.a.c.getOauthParams().getServiceAccountName(),
               this.a.c.getOauthParams().getServiceName(),
               var6,
               this.a.c.getOauthParams().getIosClientId(),
               this.a.c.getOauthParams().getScopes()
            );
            this.a.m.a(this.a.c, var7, null);
            var3 = true;
         } else {
            var3 = false;
         }

         return var3;
      }
   }

   private enum Type {
      Google,
      Other;

      private static final OauthFragment.Type[] $VALUES = new OauthFragment.Type[]{OauthFragment.Type.Google, OauthFragment.Type.Other};
   }
}
