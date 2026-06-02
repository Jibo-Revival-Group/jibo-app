package com.jibo.ui.fragment.profile;

import android.view.View;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.ui.fragment.AvatarBaseFragment_ViewBinding;

public class EditProfileFragment_ViewBinding extends AvatarBaseFragment_ViewBinding {
   private EditProfileFragment b;
   private View c;
   private View d;
   private View e;
   private View f;
   private View g;
   private View h;
   private View i;

   public EditProfileFragment_ViewBinding(EditProfileFragment var1, View var2) {
      super(var1, var2);
      this.b = var1;
      var1.memberName = Utils.b(var2, 2131297043, "field 'memberName'", TextView.class);
      View var3 = Utils.a(var2, 2131296902, "field 'settingPrefferedName' and method 'nicknameClickEdit'");
      var1.settingPrefferedName = var3;
      this.c = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final EditProfileFragment b;
         final EditProfileFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.nicknameClickEdit();
         }
      });
      var1.preferredName = Utils.b(var2, 2131296898, "field 'preferredName'", TextView.class);
      var1.gender = Utils.b(var2, 2131296894, "field 'gender'", TextView.class);
      var1.email = Utils.b(var2, 2131296890, "field 'email'", TextView.class);
      var1.birthday = Utils.b(var2, 2131296888, "field 'birthday'", TextView.class);
      var1.avatarEdit = Utils.a(var2, 2131296331, "field 'avatarEdit'");
      var3 = Utils.a(var2, 2131296887, "field 'settingBirthday' and method 'birthdayClick'");
      var1.settingBirthday = var3;
      this.d = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final EditProfileFragment b;
         final EditProfileFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.birthdayClick();
         }
      });
      var3 = Utils.a(var2, 2131296893, "field 'settingGender' and method 'genderClick'");
      var1.settingGender = var3;
      this.e = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final EditProfileFragment b;
         final EditProfileFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.genderClick();
         }
      });
      var1.settingEmail = Utils.a(var2, 2131296889, "field 'settingEmail'");
      var3 = Utils.a(var2, 2131296389, "field 'btnResendInvite' and method 'resendInviteClick'");
      var1.btnResendInvite = var3;
      this.f = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final EditProfileFragment b;
         final EditProfileFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.resendInviteClick();
         }
      });
      var1.setEmailInfo = Utils.b(var2, 2131296884, "field 'setEmailInfo'", TextView.class);
      var3 = Utils.a(var2, 2131296886, "field 'settingAddPrefName' and method 'nicknameClick'");
      var1.settingAddPrefName = var3;
      this.g = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final EditProfileFragment b;
         final EditProfileFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.nicknameClick();
         }
      });
      var3 = Utils.a(var2, 2131296905, "field 'settingSetEmail' and method 'setEmailClick'");
      var1.settingSetEmail = var3;
      this.h = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final EditProfileFragment b;
         final EditProfileFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.setEmailClick();
         }
      });
      var1.settingLegalGuardianName = Utils.a(var2, 2131296896, "field 'settingLegalGuardianName'");
      var1.legalGuardianName = Utils.b(var2, 2131296695, "field 'legalGuardianName'", TextView.class);
      var1.settingLegalGuardianEmail = Utils.a(var2, 2131296895, "field 'settingLegalGuardianEmail'");
      var1.legalGuardianEmail = Utils.b(var2, 2131296693, "field 'legalGuardianEmail'", TextView.class);
      var1.settingSetPhone = Utils.a(var2, 2131296906, "field 'settingSetPhone'");
      var2 = Utils.a(var2, 2131296387, "method 'removeFromLoopClick'");
      this.i = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final EditProfileFragment b;
         final EditProfileFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.removeFromLoopClick();
         }
      });
   }

   @Override
   public void unbind() {
      EditProfileFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.memberName = null;
      var1.settingPrefferedName = null;
      var1.preferredName = null;
      var1.gender = null;
      var1.email = null;
      var1.birthday = null;
      var1.avatarEdit = null;
      var1.settingBirthday = null;
      var1.settingGender = null;
      var1.settingEmail = null;
      var1.btnResendInvite = null;
      var1.setEmailInfo = null;
      var1.settingAddPrefName = null;
      var1.settingSetEmail = null;
      var1.settingLegalGuardianName = null;
      var1.legalGuardianName = null;
      var1.settingLegalGuardianEmail = null;
      var1.legalGuardianEmail = null;
      var1.settingSetPhone = null;
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
      super.unbind();
   }
}
