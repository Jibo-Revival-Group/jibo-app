package com.jibo.ui.fragment.account;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.login.widget.LoginButton;
import com.jibo.ui.fragment.AvatarBaseFragment_ViewBinding;

public class AccountSettingsDetailsFragment_ViewBinding extends AvatarBaseFragment_ViewBinding {
   private AccountSettingsDetailsFragment b;
   private View c;
   private View d;
   private View e;
   private View f;
   private View g;
   private View h;
   private View i;
   private View j;
   private View k;
   private View l;

   public AccountSettingsDetailsFragment_ViewBinding(AccountSettingsDetailsFragment var1, View var2) {
      super(var1, var2);
      this.b = var1;
      var1.mName = Utils.b(var2, 2131296898, "field 'mName'", TextView.class);
      var1.mGender = Utils.b(var2, 2131296894, "field 'mGender'", TextView.class);
      var1.mEmail = Utils.b(var2, 2131296890, "field 'mEmail'", TextView.class);
      var1.mBirthday = Utils.b(var2, 2131296888, "field 'mBirthday'", TextView.class);
      var1.mSettingPhoneNumberTitle = Utils.b(var2, 2131296901, "field 'mSettingPhoneNumberTitle'", TextView.class);
      var1.mPhoneNumber = Utils.b(var2, 2131296900, "field 'mPhoneNumber'", TextView.class);
      View var3 = Utils.a(var2, 2131296904, "field 'receiveMessagesSwitch' and method 'onReceiveMessagesClick'");
      var1.receiveMessagesSwitch = Utils.c(var3, 2131296904, "field 'receiveMessagesSwitch'", Switch.class);
      this.c = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final AccountSettingsDetailsFragment b;
         final AccountSettingsDetailsFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.onReceiveMessagesClick(var1);
         }
      });
      var1.avatarEditButton = Utils.b(var2, 2131296331, "field 'avatarEditButton'", ImageView.class);
      var1.mFacebook = Utils.b(var2, 2131296892, "field 'mFacebook'", TextView.class);
      var1.facebookLoginButton = Utils.b(var2, 2131296713, "field 'facebookLoginButton'", LoginButton.class);
      var1.mFacebookLoggedInIcon = Utils.b(var2, 2131296558, "field 'mFacebookLoggedInIcon'", ImageView.class);
      var3 = Utils.a(var2, 2131296897, "method 'nameClick'");
      this.d = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final AccountSettingsDetailsFragment b;
         final AccountSettingsDetailsFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.nameClick();
         }
      });
      var3 = Utils.a(var2, 2131296893, "method 'genderClick'");
      this.e = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final AccountSettingsDetailsFragment b;
         final AccountSettingsDetailsFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.genderClick();
         }
      });
      var3 = Utils.a(var2, 2131296887, "method 'birthdayClick'");
      this.f = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final AccountSettingsDetailsFragment b;
         final AccountSettingsDetailsFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.birthdayClick();
         }
      });
      var3 = Utils.a(var2, 2131296899, "method 'onPhoneNumberClick'");
      this.g = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final AccountSettingsDetailsFragment b;
         final AccountSettingsDetailsFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.onPhoneNumberClick();
         }
      });
      var3 = Utils.a(var2, 2131296903, "method 'onReceiveMessagesClick'");
      this.h = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final AccountSettingsDetailsFragment b;
         final AccountSettingsDetailsFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.onReceiveMessagesClick(var1);
         }
      });
      var3 = Utils.a(var2, 2131296891, "method 'facebookClick'");
      this.i = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final AccountSettingsDetailsFragment b;
         final AccountSettingsDetailsFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.facebookClick();
         }
      });
      var3 = Utils.a(var2, 2131296450, "method 'changePasswordClick'");
      this.j = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final AccountSettingsDetailsFragment b;
         final AccountSettingsDetailsFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.changePasswordClick();
         }
      });
      var3 = Utils.a(var2, 2131296907, "method 'changeEmailClick'");
      this.k = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final AccountSettingsDetailsFragment b;
         final AccountSettingsDetailsFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.changeEmailClick();
         }
      });
      var2 = Utils.a(var2, 2131296352, "method 'onDevSettings'");
      this.l = var2;
      var2.setOnLongClickListener(new OnLongClickListener(this, var1) {
         final AccountSettingsDetailsFragment a;
         final AccountSettingsDetailsFragment_ViewBinding b;

         {
            this.b = var1;
            this.a = var2;
         }

         public boolean onLongClick(View var1) {
            return this.a.onDevSettings(var1);
         }
      });
   }

   @Override
   public void unbind() {
      AccountSettingsDetailsFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.mName = null;
      var1.mGender = null;
      var1.mEmail = null;
      var1.mBirthday = null;
      var1.mSettingPhoneNumberTitle = null;
      var1.mPhoneNumber = null;
      var1.receiveMessagesSwitch = null;
      var1.avatarEditButton = null;
      var1.mFacebook = null;
      var1.facebookLoginButton = null;
      var1.mFacebookLoggedInIcon = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
      this.e.setOnClickListener(null);
      this.e = null;
      this.f.setOnClickListener(null);
      this.f = null;
      this.g.setOnClickListener(null);
      this.g = null;
      this.h.setOnClickListener(null);
      this.h = null;
      this.i.setOnClickListener(null);
      this.i = null;
      this.j.setOnClickListener(null);
      this.j = null;
      this.k.setOnClickListener(null);
      this.k = null;
      this.l.setOnLongClickListener(null);
      this.l = null;
      super.unbind();
   }
}
