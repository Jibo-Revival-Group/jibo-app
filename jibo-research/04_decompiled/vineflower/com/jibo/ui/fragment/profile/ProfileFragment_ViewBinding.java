package com.jibo.ui.fragment.profile;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.ui.fragment.AvatarBaseFragment_ViewBinding;

public class ProfileFragment_ViewBinding extends AvatarBaseFragment_ViewBinding {
   private ProfileFragment b;
   private View c;

   public ProfileFragment_ViewBinding(ProfileFragment var1, View var2) {
      super(var1, var2);
      this.b = var1;
      var1.contactAdult = Utils.a(var2, 2131296488, "field 'contactAdult'");
      var1.contactChild = Utils.a(var2, 2131296489, "field 'contactChild'");
      var1.mName = Utils.b(var2, 2131296802, "field 'mName'", TextView.class);
      var1.mNickName = Utils.b(var2, 2131296803, "field 'mNickName'", TextView.class);
      var1.mLegalGuardianName = Utils.b(var2, 2131296695, "field 'mLegalGuardianName'", TextView.class);
      var1.mBirthday = Utils.b(var2, 2131296800, "field 'mBirthday'", TextView.class);
      var1.mTrained = Utils.b(var2, 2131296804, "field 'mTrained'", TextView.class);
      var1.mPersonalSettings = Utils.b(var2, 2131296776, "field 'mPersonalSettings'", TextView.class);
      View var3 = Utils.a(var2, 2131296777, "field 'mPersonalSettingsRow' and method 'personalSettingsClick'");
      var1.mPersonalSettingsRow = Utils.c(var3, 2131296777, "field 'mPersonalSettingsRow'", LinearLayout.class);
      this.c = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final ProfileFragment b;
         final ProfileFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.personalSettingsClick(var1);
         }
      });
      var1.personalSettingDivider = Utils.a(var2, 2131296775, "field 'personalSettingDivider'");
      var1.mEmail = Utils.b(var2, 2131296801, "field 'mEmail'", TextView.class);
      var1.daysLeftInfo = Utils.b(var2, 2131296517, "field 'daysLeftInfo'", TextView.class);
      var1.bottomPanel = Utils.a(var2, 2131296339, "field 'bottomPanel'");
   }

   @Override
   public void unbind() {
      ProfileFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.contactAdult = null;
      var1.contactChild = null;
      var1.mName = null;
      var1.mNickName = null;
      var1.mLegalGuardianName = null;
      var1.mBirthday = null;
      var1.mTrained = null;
      var1.mPersonalSettings = null;
      var1.mPersonalSettingsRow = null;
      var1.personalSettingDivider = null;
      var1.mEmail = null;
      var1.daysLeftInfo = null;
      var1.bottomPanel = null;
      this.c.setOnClickListener(null);
      this.c = null;
      super.unbind();
   }
}
