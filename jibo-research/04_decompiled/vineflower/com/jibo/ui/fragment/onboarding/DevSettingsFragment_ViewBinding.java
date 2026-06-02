package com.jibo.ui.fragment.onboarding;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class DevSettingsFragment_ViewBinding implements Unbinder {
   private DevSettingsFragment b;
   private View c;
   private View d;
   private View e;
   private View f;
   private View g;
   private View h;
   private View i;
   private View j;

   public DevSettingsFragment_ViewBinding(DevSettingsFragment var1, View var2) {
      this.b = var1;
      var1.current_endpoint = Utils.b(var2, 2131296508, "field 'current_endpoint'", TextView.class);
      var1.endpointSpinner = Utils.b(var2, 2131296550, "field 'endpointSpinner'", Spinner.class);
      var1.textVersion = Utils.b(var2, 2131296991, "field 'textVersion'", TextView.class);
      var1.switchEncryption = Utils.b(var2, 2131296973, "field 'switchEncryption'", Switch.class);
      var1.loopsSpinner = Utils.b(var2, 2131296717, "field 'loopsSpinner'", Spinner.class);
      var1.loops1Spinner = Utils.b(var2, 2131296718, "field 'loops1Spinner'", Spinner.class);
      var1.gqaLoopsSpinner = Utils.b(var2, 2131296719, "field 'gqaLoopsSpinner'", Spinner.class);
      var1.ugcLoopSpinner = Utils.b(var2, 2131296720, "field 'ugcLoopSpinner'", Spinner.class);
      var1.suspensionLoopSpinner = Utils.b(var2, 2131296721, "field 'suspensionLoopSpinner'", Spinner.class);
      var1.ugcKeyText = Utils.b(var2, 2131297050, "field 'ugcKeyText'", TextView.class);
      var1.questionEdit = Utils.b(var2, 2131296817, "field 'questionEdit'", EditText.class);
      var1.responseText = Utils.b(var2, 2131296829, "field 'responseText'", TextView.class);
      var1.endpointEdit = Utils.b(var2, 2131296551, "field 'endpointEdit'", EditText.class);
      View var3 = Utils.a(var2, 2131296398, "field 'buttonSetEndpoint' and method 'setEndpoint'");
      var1.buttonSetEndpoint = Utils.c(var3, 2131296398, "field 'buttonSetEndpoint'", Button.class);
      this.c = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final DevSettingsFragment b;
         final DevSettingsFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.setEndpoint(var1);
         }
      });
      var3 = Utils.a(var2, 2131296374, "method 'logout'");
      this.d = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final DevSettingsFragment b;
         final DevSettingsFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.logout(var1);
         }
      });
      var3 = Utils.a(var2, 2131296388, "method 'onBtnRequestKeyClick'");
      this.e = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final DevSettingsFragment b;
         final DevSettingsFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.onBtnRequestKeyClick(var1);
         }
      });
      var3 = Utils.a(var2, 2131296371, "method 'onBtnListAttributions'");
      this.f = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final DevSettingsFragment b;
         final DevSettingsFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.onBtnListAttributions(var1);
         }
      });
      var3 = Utils.a(var2, 2131296396, "method 'onBtnSendQuestion'");
      this.g = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final DevSettingsFragment b;
         final DevSettingsFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.onBtnSendQuestion(var1);
         }
      });
      var3 = Utils.a(var2, 2131296360, "method 'onBtnGenerateKeyClick'");
      this.h = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final DevSettingsFragment b;
         final DevSettingsFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.onBtnGenerateKeyClick(var1);
         }
      });
      var3 = Utils.a(var2, 2131296405, "method 'onBtnSuspendLoopClick'");
      this.i = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final DevSettingsFragment b;
         final DevSettingsFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.onBtnSuspendLoopClick(var1);
         }
      });
      var2 = Utils.a(var2, 2131296529, "method 'showDevSettings'");
      this.j = var2;
      var2.setOnLongClickListener(new OnLongClickListener(this, var1) {
         final DevSettingsFragment a;
         final DevSettingsFragment_ViewBinding b;

         {
            this.b = var1;
            this.a = var2;
         }

         public boolean onLongClick(View var1) {
            return this.a.showDevSettings(var1);
         }
      });
   }

   @Override
   public void unbind() {
      DevSettingsFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.current_endpoint = null;
      var1.endpointSpinner = null;
      var1.textVersion = null;
      var1.switchEncryption = null;
      var1.loopsSpinner = null;
      var1.loops1Spinner = null;
      var1.gqaLoopsSpinner = null;
      var1.ugcLoopSpinner = null;
      var1.suspensionLoopSpinner = null;
      var1.ugcKeyText = null;
      var1.questionEdit = null;
      var1.responseText = null;
      var1.endpointEdit = null;
      var1.buttonSetEndpoint = null;
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
      this.j.setOnLongClickListener(null);
      this.j = null;
   }
}
