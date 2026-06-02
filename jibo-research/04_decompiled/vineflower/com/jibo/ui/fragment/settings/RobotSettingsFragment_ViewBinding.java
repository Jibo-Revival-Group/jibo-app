package com.jibo.ui.fragment.settings;

import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class RobotSettingsFragment_ViewBinding implements Unbinder {
   private RobotSettingsFragment b;
   private View c;
   private View d;
   private View e;
   private View f;
   private View g;
   private View h;
   private View i;

   public RobotSettingsFragment_ViewBinding(RobotSettingsFragment var1, View var2) {
      this.b = var1;
      var1.txtJiboName = Utils.b(var2, 2131297040, "field 'txtJiboName'", TextView.class);
      var1.imgJiboAvatar = Utils.b(var2, 2131296608, "field 'imgJiboAvatar'", ImageView.class);
      var1.txtJiboWifi = Utils.b(var2, 2131297041, "field 'txtJiboWifi'", TextView.class);
      var1.txtJiboLocation = Utils.b(var2, 2131297039, "field 'txtJiboLocation'", TextView.class);
      View var3 = Utils.a(var2, 2131296345, "field 'btnAbout' and method 'showAbout'");
      var1.btnAbout = var3;
      this.c = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final RobotSettingsFragment b;
         final RobotSettingsFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.showAbout(var1);
         }
      });
      var1.btnPassphrase = Utils.a(var2, 2131296381, "field 'btnPassphrase'");
      var1.iconPassphrase = Utils.b(var2, 2131296593, "field 'iconPassphrase'", ImageView.class);
      var1.passphraseText = Utils.b(var2, 2131296772, "field 'passphraseText'", TextView.class);
      var1.mRemoteSwitch = Utils.b(var2, 2131296974, "field 'mRemoteSwitch'", Switch.class);
      var3 = Utils.a(var2, 2131296368, "method 'changeName'");
      this.d = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final RobotSettingsFragment b;
         final RobotSettingsFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.changeName(var1);
         }
      });
      var3 = Utils.a(var2, 2131296367, "method 'btnJiboAvatarClick'");
      this.e = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final RobotSettingsFragment b;
         final RobotSettingsFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.btnJiboAvatarClick();
         }
      });
      var3 = Utils.a(var2, 2131296412, "method 'btnWiFiSettingsClick'");
      this.f = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final RobotSettingsFragment b;
         final RobotSettingsFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.btnWiFiSettingsClick();
         }
      });
      var3 = Utils.a(var2, 2131296372, "method 'btnLocationClick'");
      this.g = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final RobotSettingsFragment b;
         final RobotSettingsFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.btnLocationClick();
         }
      });
      var3 = Utils.a(var2, 2131296357, "method 'btnEnableRemoteClick'");
      this.h = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final RobotSettingsFragment b;
         final RobotSettingsFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.btnEnableRemoteClick();
         }
      });
      var2 = Utils.a(var2, 2131296363, "method 'btnHolidaysClick'");
      this.i = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final RobotSettingsFragment b;
         final RobotSettingsFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.btnHolidaysClick();
         }
      });
   }

   @Override
   public void unbind() {
      RobotSettingsFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.txtJiboName = null;
      var1.imgJiboAvatar = null;
      var1.txtJiboWifi = null;
      var1.txtJiboLocation = null;
      var1.btnAbout = null;
      var1.btnPassphrase = null;
      var1.iconPassphrase = null;
      var1.passphraseText = null;
      var1.mRemoteSwitch = null;
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
   }
}
