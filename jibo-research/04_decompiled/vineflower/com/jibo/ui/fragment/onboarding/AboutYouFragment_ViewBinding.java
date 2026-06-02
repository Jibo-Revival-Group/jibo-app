package com.jibo.ui.fragment.onboarding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.ui.fragment.AvatarBaseFragment_ViewBinding;

public class AboutYouFragment_ViewBinding extends AvatarBaseFragment_ViewBinding {
   private AboutYouFragment b;
   private View c;
   private View d;
   private View e;
   private View f;

   public AboutYouFragment_ViewBinding(AboutYouFragment var1, View var2) {
      super(var1, var2);
      this.b = var1;
      var1.first_name = Utils.b(var2, 2131296567, "field 'first_name'", TextView.class);
      var1.last_name = Utils.b(var2, 2131296686, "field 'last_name'", TextView.class);
      View var3 = Utils.a(var2, 2131296893, "field 'mGender' and method 'genderClick'");
      var1.mGender = Utils.c(var3, 2131296893, "field 'mGender'", TextView.class);
      this.c = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final AboutYouFragment b;
         final AboutYouFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.genderClick();
         }
      });
      var3 = Utils.a(var2, 2131296887, "field 'mBirthday' and method 'birthdayClick'");
      var1.mBirthday = Utils.c(var3, 2131296887, "field 'mBirthday'", TextView.class);
      this.d = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final AboutYouFragment b;
         final AboutYouFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.birthdayClick();
         }
      });
      var3 = Utils.a(var2, 2131296331, "field 'avatarEditButton' and method 'changePicture'");
      var1.avatarEditButton = Utils.c(var3, 2131296331, "field 'avatarEditButton'", ImageView.class);
      this.e = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final AboutYouFragment b;
         final AboutYouFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.changePicture(var1);
         }
      });
      var2 = Utils.a(var2, 2131296330, "method 'onAvatarClick'");
      this.f = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final AboutYouFragment b;
         final AboutYouFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.onAvatarClick(var1);
         }
      });
   }

   @Override
   public void unbind() {
      AboutYouFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.first_name = null;
      var1.last_name = null;
      var1.mGender = null;
      var1.mBirthday = null;
      var1.avatarEditButton = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
      this.e.setOnClickListener(null);
      this.e = null;
      this.f.setOnClickListener(null);
      this.f = null;
      super.unbind();
   }
}
