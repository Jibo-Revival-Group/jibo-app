package com.jibo.ui.fragment.account;

import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnLongClick;
import com.amazonaws.handlers.AsyncHandler;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.account.model.FacebookMobileConnectRequest;
import com.jibo.aws.integration.aws.services.account.model.TokenContainer;
import com.jibo.aws.integration.aws.services.account.model.UpdateRequest;
import com.jibo.aws.integration.util.DateTimeUtils;
import com.jibo.db.EntityData;
import com.jibo.ui.activity.BaseActivity;
import com.jibo.ui.activity.SingleFragmentActivity;
import com.jibo.ui.activity.TabbedActivity;
import com.jibo.ui.fragment.AvatarBaseFragment;
import com.jibo.ui.fragment.dialog.DialogUtils;
import com.jibo.ui.fragment.dialog.MaterialDatePickerDialogFragment;
import com.jibo.ui.fragment.phone.PhoneEditFragment;
import com.jibo.ui.fragment.phone.PhoneFillFragment;
import com.jibo.ui.fragment.settings.ChangeEmailConfirmPasswordFragment;
import com.jibo.ui.fragment.settings.ConfirmPasswordFragment;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.UIUtils;
import java.util.Calendar;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

public class AccountSettingsDetailsFragment extends AvatarBaseFragment implements MaterialDatePickerDialogFragment.OnDateChosenListener {
   public static final String n = AccountSettingsDetailsFragment.class.getSimpleName();
   @BindView
   ImageView avatarEditButton;
   @BindView
   LoginButton facebookLoginButton;
   @BindView
   TextView mBirthday;
   @BindView
   TextView mEmail;
   @BindView
   TextView mFacebook;
   @BindView
   ImageView mFacebookLoggedInIcon;
   @BindView
   TextView mGender;
   @BindView
   TextView mName;
   @BindView
   TextView mPhoneNumber;
   @BindView
   TextView mSettingPhoneNumberTitle;
   CallbackManager o;
   String p;
   AsyncHandler q = new AsyncHandler<FacebookMobileConnectRequest, TokenContainer>(this) {
      final AccountSettingsDetailsFragment a;

      {
         this.a = var1;
      }

      public void a(FacebookMobileConnectRequest var1, TokenContainer var2) {
      }

      @Override
      public void onError(Exception var1) {
         this.a.a(var1, "facebook mobile connect", true);
      }
   };
   @BindView
   Switch receiveMessagesSwitch;

   private void a(AccessToken var1) {
      GraphRequest var2 = GraphRequest.newMeRequest(var1, new GraphRequest.GraphJSONObjectCallback(this) {
         final AccountSettingsDetailsFragment a;

         {
            this.a = var1;
         }

         @Override
         public void onCompleted(JSONObject var1, GraphResponse var2x) {
            Log.v("LoginActivity", var2x.toString());

            try {
               if (this.a.mFacebook != null) {
                  this.a.mFacebook.setText(var1.getString("name"));
               }
            } catch (JSONException var3) {
            }
         }
      });
      Bundle var3 = new Bundle();
      var3.putString("fields", "id,name,email,gender,birthday");
      var2.setParameters(var3);
      var2.executeAsync();
   }

   private void u() {
      this.f();
      EntityData.a(this.getActivity()).a(this.e, false, new AsyncHandler<UpdateRequest, Account>(this) {
         final AccountSettingsDetailsFragment a;

         {
            this.a = var1;
         }

         public void a(UpdateRequest var1, Account var2) {
            this.a.g();
            this.a.a(new Runnable(this, var2) {
               final Account a;
               final <unrepresentable> b;

               {
                  this.b = var1;
                  this.a = var2x;
               }

               @Override
               public void run() {
                  this.b.a.e = EntityData.a(this.b.a.getActivity()).i();
                  this.b.a.t();
                  if (this.b.a.getActivity() instanceof SingleFragmentActivity) {
                     ((SingleFragmentActivity)this.b.a.getActivity()).q().putExtra(Account.class.getSimpleName(), this.a);
                  }

                  this.b.a.getActivity().setResult(-1);
               }
            });
         }

         @Override
         public void onError(Exception var1) {
            this.a.a(var1, "update account", true);
            this.a.a(new Runnable(this) {
               final <unrepresentable> a;

               {
                  this.a = var1;
               }

               @Override
               public void run() {
                  this.a.a.e = EntityData.a(this.a.a.getActivity()).i();
                  this.a.a.t();
               }
            });
         }
      });
   }

   @Override
   public void a(int var1, int var2, Object var3) {
      super.a(var1, var2, var3);
      if (var1 == 108) {
         if (var2 == 0) {
            this.e.setGender(Account.Gender.male);
         } else if (var2 == 1) {
            this.e.setGender(Account.Gender.female);
         } else if (var2 == 2) {
            this.e.setGender(Account.Gender.other);
         } else if (var2 == 3) {
            this.e.setGender(Account.Gender.they);
         }

         this.mGender.setText(this.getResources().getStringArray(2130903043)[this.e.getGender().ordinal()]);
         this.u();
      } else if (var1 == 114) {
         if (var3 instanceof Account) {
            this.e.setFirstName(((Account)var3).getFirstName());
            this.e.setLastName(((Account)var3).getLastName());
         }

         this.mName.setText(this.e.getFullName());
         this.u();
      } else if (var1 == 109) {
         LoginManager.getInstance().logOut();
         this.mFacebook.setText(2131755219);
         this.mFacebookLoggedInIcon.setImageDrawable(ImageUtils.a(this.getActivity(), 2131231272, 2131099771));
      }
   }

   @Override
   public void a(long var1) {
      this.e.setBirthday(var1);
      Calendar.getInstance().setTimeInMillis(var1);
      this.mBirthday.setText(DateTimeUtils.getBirthdayString(this.e.getBirthday(), DateTimeUtils.FULL_DATE_FORMAT));
      this.u();
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      var1.setDisplayHomeAsUpEnabled(true);
   }

   @Override
   protected void b(String var1) {
      super.b(var1);
      if (this.getActivity() instanceof SingleFragmentActivity) {
         ((SingleFragmentActivity)this.getActivity()).q().putExtra(Account.class.getSimpleName(), this.e);
      }

      this.getActivity().setResult(-1);
   }

   @OnClick
   public void birthdayClick() {
      MaterialDatePickerDialogFragment var3 = new MaterialDatePickerDialogFragment();
      Bundle var4 = new Bundle();
      if (this.e.getBirthday() != null) {
         long var1;
         if (this.e.getBirthday() != null && this.e.getBirthday() != -1L) {
            var1 = this.e.getBirthday();
         } else {
            var1 = System.currentTimeMillis();
         }

         var4.putLong("ARGS_DATE", var1);
      }

      var4.putString("ARGS_TITLE", this.getString(2131755768));
      var4.putString("ARGS_ERROR_TEXT", this.getString(2131755308));
      Calendar var5 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
      var5.add(1, -13);
      var4.putLong("ARGS_MAX_VALUE", var5.getTimeInMillis() - 86400000L);
      var3.setArguments(var4);
      var3.setTargetFragment(this, 0);
      var3.show(((AppCompatActivity)this.getContext()).getSupportFragmentManager(), "datePicker");
   }

   @OnClick
   public void changeEmailClick() {
      new SingleFragmentActivity.Builder(this.getActivity(), ChangeEmailConfirmPasswordFragment.class.getName()).a(999);
   }

   @OnClick
   public void changePasswordClick() {
      new SingleFragmentActivity.Builder(this.getActivity(), ConfirmPasswordFragment.class.getName()).a(999);
   }

   @OnClick
   public void facebookClick() {
      if (AccessToken.getCurrentAccessToken() != null) {
         DialogUtils.b(this, 109, this.getString(2131756093), this.getString(2131756092));
      } else {
         this.facebookLoginButton.performClick();
      }
   }

   @OnClick
   public void genderClick() {
      DialogUtils.a(this, 108, this.getString(2131755479), 2130903042, this.e.getGender().ordinal());
   }

   @OnClick
   public void nameClick() {
   }

   @Override
   protected String o() {
      return this.getString(2131756023);
   }

   @Override
   public void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      if (var2 == -1) {
         if (var1 == 69) {
            this.b();
         } else if (var1 == 1016
            && var3 != null
            && var3.getExtras() != null
            && var3.getExtras().containsKey(Account.class.getSimpleName())
            && var3.getExtras().getParcelable(Account.class.getSimpleName()) instanceof Account) {
            this.e = (Account)var3.getExtras().getParcelable(Account.class.getSimpleName());
            this.t();
         }
      }

      if (var2 == TabbedActivity.c) {
         this.getActivity().setResult(TabbedActivity.c);
         this.getActivity().finish();
      } else {
         this.o.onActivityResult(var1, var2, var3);
      }
   }

   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      FacebookSdk.sdkInitialize(this.getActivity().getApplicationContext());
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427423, var2, false);
   }

   @OnLongClick
   public boolean onDevSettings(View var1) {
      return true;
   }

   @OnClick
   public void onPhoneNumberClick() {
      if (TextUtils.isEmpty(this.e.getPhoneNumber())) {
         new SingleFragmentActivity.Builder(this, PhoneFillFragment.class.getName()).a(1016);
      } else {
         new SingleFragmentActivity.Builder(this, PhoneEditFragment.class.getName()).a("PARAM_PHONENUMBER", this.e.getPhoneNumber()).a(1016);
      }
   }

   @OnClick
   public void onReceiveMessagesClick(View var1) {
      if (!TextUtils.isEmpty(this.e.getPhoneNumber())) {
         Account var3 = this.e;
         boolean var2;
         if (var1 instanceof CompoundButton) {
            var2 = this.receiveMessagesSwitch.isChecked();
         } else if (!this.receiveMessagesSwitch.isChecked()) {
            var2 = true;
         } else {
            var2 = false;
         }

         var3.setMessagingAllowed(var2);
         this.u();
      }
   }

   @Override
   public void onResume() {
      super.onResume();
      ((BaseActivity)this.getActivity()).h().getIndeterminateDrawable().setColorFilter(ImageUtils.b(this.getActivity(), 2131099767), Mode.SRC_IN);
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.facebookLoginButton.setFragment(this);
      this.facebookLoginButton.setPublishPermissions("publish_actions", "rsvp_event");
      this.o = CallbackManager.Factory.create();
      this.facebookLoginButton.registerCallback(this.o, new FacebookCallback<LoginResult>(this) {
         final AccountSettingsDetailsFragment a;

         {
            this.a = var1;
         }

         public void a(LoginResult var1) {
            if (var1.getRecentlyGrantedPermissions().size() > 0) {
               AccessToken var2x = var1.getAccessToken();
               this.a.p = var2x.getToken();
               this.a.mFacebookLoggedInIcon.setImageDrawable(ImageUtils.a(this.a.getActivity(), 2131231002, 2131099679));
               EntityData.a(this.a.getActivity()).a().facebookMobileConnect(this.a.p, this.a.q);
               this.a.a(var1.getAccessToken());
            }
         }

         @Override
         public void onCancel() {
            this.a.mFacebookLoggedInIcon.setImageDrawable(ImageUtils.a(this.a.getActivity(), 2131231272, 2131099771));
            this.a.mFacebook.setText(2131755219);
         }

         @Override
         public void onError(FacebookException var1) {
            UIUtils.a(this.a.facebookLoginButton, var1);
            this.a.mFacebookLoggedInIcon.setImageDrawable(ImageUtils.a(this.a.getActivity(), 2131231272, 2131099771));
            this.a.mFacebook.setText(2131755219);
         }
      });
      this.t();
   }

   protected void t() {
      this.mName.setText(this.e.getFullName());
      this.mGender.setText(this.getResources().getStringArray(2130903042)[this.e.getGender().ordinal()]);
      if (this.e.getBirthday() != null) {
         this.mBirthday.setText(DateTimeUtils.getBirthdayString(this.e.getBirthday(), DateTimeUtils.FULL_DATE_FORMAT));
      }

      this.mEmail.setText(this.e.getEmail());
      if (TextUtils.isEmpty(this.e.getPhoneNumber())) {
         this.mSettingPhoneNumberTitle.setText(2131755055);
         this.mSettingPhoneNumberTitle.setTextColor(ImageUtils.b(this.getActivity(), 2131099771));
         this.mPhoneNumber.setVisibility(8);
         this.receiveMessagesSwitch.setEnabled(false);
      } else {
         this.mSettingPhoneNumberTitle.setText(2131755593);
         this.mSettingPhoneNumberTitle.setTextColor(-16777216);
         this.mPhoneNumber.setVisibility(0);
         this.mPhoneNumber.setText(this.e.getPhoneNumber());
         this.receiveMessagesSwitch.setEnabled(true);
      }

      this.a(this.e);
      this.avatarEditButton.setVisibility(0);
      this.receiveMessagesSwitch.setChecked(this.e.isMessagingAllowed());
      AccessToken var1 = AccessToken.getCurrentAccessToken();
      if (var1 != null) {
         this.a(var1);
         this.mFacebookLoggedInIcon.setImageDrawable(ImageUtils.a(this.getActivity(), 2131231002, 2131099679));
      } else {
         this.mFacebookLoggedInIcon.setImageDrawable(ImageUtils.a(this.getActivity(), 2131231272, 2131099771));
      }
   }
}
