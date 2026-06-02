package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.appcompat.R;
import android.support.v7.view.ActionMode;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class AppCompatDialog extends Dialog implements AppCompatCallback {
   private AppCompatDelegate a;

   public AppCompatDialog(Context var1, int var2) {
      super(var1, a(var1, var2));
      this.b().a((Bundle)null);
      this.b().j();
   }

   private static int a(Context var0, int var1) {
      int var2 = var1;
      if (var1 == 0) {
         TypedValue var3 = new TypedValue();
         var0.getTheme().resolveAttribute(R.attr.dialogTheme, var3, true);
         var2 = var3.resourceId;
      }

      return var2;
   }

   public void addContentView(View var1, LayoutParams var2) {
      this.b().b(var1, var2);
   }

   public AppCompatDelegate b() {
      if (this.a == null) {
         this.a = AppCompatDelegate.a(this, this);
      }

      return this.a;
   }

   public boolean b(int var1) {
      return this.b().c(var1);
   }

   public <T extends View> T findViewById(int var1) {
      return this.b().a(var1);
   }

   public void invalidateOptionsMenu() {
      this.b().f();
   }

   protected void onCreate(Bundle var1) {
      this.b().i();
      super.onCreate(var1);
      this.b().a(var1);
   }

   protected void onStop() {
      super.onStop();
      this.b().d();
   }

   @Override
   public void onSupportActionModeFinished(ActionMode var1) {
   }

   @Override
   public void onSupportActionModeStarted(ActionMode var1) {
   }

   @Override
   public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback var1) {
      return null;
   }

   public void setContentView(int var1) {
      this.b().b(var1);
   }

   public void setContentView(View var1) {
      this.b().a(var1);
   }

   public void setContentView(View var1, LayoutParams var2) {
      this.b().a(var1, var2);
   }

   public void setTitle(int var1) {
      super.setTitle(var1);
      this.b().a(this.getContext().getString(var1));
   }

   public void setTitle(CharSequence var1) {
      super.setTitle(var1);
      this.b().a(var1);
   }
}
