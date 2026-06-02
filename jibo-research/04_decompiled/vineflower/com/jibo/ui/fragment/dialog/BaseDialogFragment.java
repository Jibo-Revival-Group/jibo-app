package com.jibo.ui.fragment.dialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import com.crashlytics.android.Crashlytics;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.utils.ErrorHelper;
import com.jibo.utils.UIUtils;

public class BaseDialogFragment extends DialogFragment {
   public static final String a = BaseDialogFragment.class.getSimpleName();
   protected View b;
   protected Loop c;

   protected int a() {
      return 2131165363;
   }

   public void a(Bundle var1) {
      if (var1.containsKey(Loop.class.getSimpleName())) {
         this.c = (Loop)var1.getParcelable(Loop.class.getSimpleName());
      }
   }

   protected void a(Exception var1, String var2, boolean var3) {
      Crashlytics.a(var1);
      this.getActivity().runOnUiThread(new Runnable(this, var1, var3) {
         final Exception a;
         final boolean b;
         final BaseDialogFragment c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3x;
         }

         @Override
         public void run() {
            if (!ErrorHelper.a(null, this.c, this.a) && this.b && this.c.b != null) {
               UIUtils.a(this.c.b, this.a);
            }
         }
      });
   }

   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      if (var1 != null) {
         this.a(var1);
      } else if (this.getArguments() != null) {
         this.a(this.getArguments());
      }
   }

   @Override
   public void onDismiss(DialogInterface var1) {
      super.onDismiss(var1);
      if (this.getTargetFragment() != null && this.getTargetFragment() instanceof OnDismissListener) {
         ((OnDismissListener)this.getTargetFragment()).onDismiss(var1);
      }
   }

   @Override
   public void onResume() {
      super.onResume();
      int var1 = this.getResources().getDimensionPixelSize(this.a());
      this.getDialog().getWindow().setLayout(var1, -2);
   }

   @Override
   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      if (this.c != null) {
         var1.putParcelable(Loop.class.getSimpleName(), this.c);
      }
   }
}
