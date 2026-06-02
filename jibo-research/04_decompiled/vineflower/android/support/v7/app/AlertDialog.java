package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.appcompat.R;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;

public class AlertDialog extends AppCompatDialog implements DialogInterface {
   final AlertController a = new AlertController(this.getContext(), this, this.getWindow());

   protected AlertDialog(Context var1, int var2) {
      super(var1, a(var1, var2));
   }

   static int a(Context var0, int var1) {
      if ((var1 >>> 24 & 0xFF) < 1) {
         TypedValue var2 = new TypedValue();
         var0.getTheme().resolveAttribute(R.attr.alertDialogTheme, var2, true);
         var1 = var2.resourceId;
      }

      return var1;
   }

   public Button a(int var1) {
      return this.a.d(var1);
   }

   @Override
   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.a.a();
   }

   public boolean onKeyDown(int var1, KeyEvent var2) {
      boolean var3;
      if (this.a.a(var1, var2)) {
         var3 = true;
      } else {
         var3 = super.onKeyDown(var1, var2);
      }

      return var3;
   }

   public boolean onKeyUp(int var1, KeyEvent var2) {
      boolean var3;
      if (this.a.b(var1, var2)) {
         var3 = true;
      } else {
         var3 = super.onKeyUp(var1, var2);
      }

      return var3;
   }

   @Override
   public void setTitle(CharSequence var1) {
      super.setTitle(var1);
      this.a.a(var1);
   }

   public static class Builder {
      private final AlertController.AlertParams a;
      private final int b;

      public Builder(Context var1) {
         this(var1, AlertDialog.a(var1, 0));
      }

      public Builder(Context var1, int var2) {
         this.a = new AlertController.AlertParams(new ContextThemeWrapper(var1, AlertDialog.a(var1, var2)));
         this.b = var2;
      }

      public Context a() {
         return this.a.a;
      }

      public AlertDialog.Builder a(int var1) {
         this.a.f = this.a.a.getText(var1);
         return this;
      }

      public AlertDialog.Builder a(int var1, OnClickListener var2) {
         this.a.i = this.a.a.getText(var1);
         this.a.k = var2;
         return this;
      }

      public AlertDialog.Builder a(OnDismissListener var1) {
         this.a.t = var1;
         return this;
      }

      public AlertDialog.Builder a(OnKeyListener var1) {
         this.a.u = var1;
         return this;
      }

      public AlertDialog.Builder a(Drawable var1) {
         this.a.d = var1;
         return this;
      }

      public AlertDialog.Builder a(View var1) {
         this.a.g = var1;
         return this;
      }

      public AlertDialog.Builder a(ListAdapter var1, int var2, OnClickListener var3) {
         this.a.w = var1;
         this.a.x = var3;
         this.a.I = var2;
         this.a.H = true;
         return this;
      }

      public AlertDialog.Builder a(ListAdapter var1, OnClickListener var2) {
         this.a.w = var1;
         this.a.x = var2;
         return this;
      }

      public AlertDialog.Builder a(CharSequence var1) {
         this.a.f = var1;
         return this;
      }

      public AlertDialog.Builder a(CharSequence var1, OnClickListener var2) {
         this.a.i = var1;
         this.a.k = var2;
         return this;
      }

      public AlertDialog.Builder a(boolean var1) {
         this.a.r = var1;
         return this;
      }

      public AlertDialog.Builder b(int var1) {
         this.a.h = this.a.a.getText(var1);
         return this;
      }

      public AlertDialog.Builder b(int var1, OnClickListener var2) {
         this.a.l = this.a.a.getText(var1);
         this.a.n = var2;
         return this;
      }

      public AlertDialog.Builder b(View var1) {
         this.a.z = var1;
         this.a.y = 0;
         this.a.E = false;
         return this;
      }

      public AlertDialog.Builder b(CharSequence var1) {
         this.a.h = var1;
         return this;
      }

      public AlertDialog.Builder b(CharSequence var1, OnClickListener var2) {
         this.a.l = var1;
         this.a.n = var2;
         return this;
      }

      public AlertDialog b() {
         AlertDialog var1 = new AlertDialog(this.a.a, this.b);
         this.a.a(var1.a);
         var1.setCancelable(this.a.r);
         if (this.a.r) {
            var1.setCanceledOnTouchOutside(true);
         }

         var1.setOnCancelListener(this.a.s);
         var1.setOnDismissListener(this.a.t);
         if (this.a.u != null) {
            var1.setOnKeyListener(this.a.u);
         }

         return var1;
      }

      public AlertDialog c() {
         AlertDialog var1 = this.b();
         var1.show();
         return var1;
      }
   }
}
