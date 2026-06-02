package android.support.v7.app;

import android.app.UiModeManager;
import android.content.Context;
import android.view.ActionMode;
import android.view.Window;
import android.view.Window.Callback;

class AppCompatDelegateImplV23 extends AppCompatDelegateImplV14 {
   private final UiModeManager t;

   AppCompatDelegateImplV23(Context var1, Window var2, AppCompatCallback var3) {
      super(var1, var2, var3);
      this.t = (UiModeManager)var1.getSystemService("uimode");
   }

   @Override
   Callback a(Callback var1) {
      return new AppCompatDelegateImplV23.AppCompatWindowCallbackV23(this, var1);
   }

   @Override
   int d(int var1) {
      if (var1 == 0 && this.t.getNightMode() == 0) {
         var1 = -1;
      } else {
         var1 = super.d(var1);
      }

      return var1;
   }

   class AppCompatWindowCallbackV23 extends AppCompatDelegateImplV14.AppCompatWindowCallbackV14 {
      final AppCompatDelegateImplV23 d;

      AppCompatWindowCallbackV23(AppCompatDelegateImplV23 var1, Callback var2) {
         super(var1, var2);
         this.d = var1;
      }

      @Override
      public ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback var1) {
         return null;
      }

      @Override
      public ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback var1, int var2) {
         if (this.d.p()) {
            switch (var2) {
               case 0:
                  return this.a(var1);
            }
         }

         return super.onWindowStartingActionMode(var1, var2);
      }
   }
}
