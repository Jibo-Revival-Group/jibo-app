package com.jibo.ui.fragment.invite;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class PreferredNameFragment_ViewBinding implements Unbinder {
   private PreferredNameFragment b;
   private View c;
   private View d;
   private View e;

   public PreferredNameFragment_ViewBinding(PreferredNameFragment var1, View var2) {
      this.b = var1;
      var1.nickname = Utils.b(var2, 2131296751, "field 'nickname'", EditText.class);
      View var3 = Utils.a(var2, 2131296752, "field 'nicknameSkip' and method 'nicknameSkip'");
      var1.nicknameSkip = Utils.c(var3, 2131296752, "field 'nicknameSkip'", TextView.class);
      this.c = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final PreferredNameFragment b;
         final PreferredNameFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.nicknameSkip(var1);
         }
      });
      var3 = Utils.a(var2, 2131297062, "field 'mViewLoopMembers' and method 'viewLoopMembers'");
      var1.mViewLoopMembers = var3;
      this.d = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final PreferredNameFragment b;
         final PreferredNameFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.viewLoopMembers(var1);
         }
      });
      var3 = Utils.a(var2, 2131296449, "field 'mChangePronunciationName' and method 'changePronunciationName'");
      var1.mChangePronunciationName = var3;
      this.e = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final PreferredNameFragment b;
         final PreferredNameFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.changePronunciationName(var1);
         }
      });
      var1.mPreferredNameTip = Utils.b(var2, 2131296799, "field 'mPreferredNameTip'", TextView.class);
   }

   @Override
   public void unbind() {
      PreferredNameFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.nickname = null;
      var1.nicknameSkip = null;
      var1.mViewLoopMembers = null;
      var1.mChangePronunciationName = null;
      var1.mPreferredNameTip = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
      this.e.setOnClickListener(null);
      this.e = null;
   }
}
