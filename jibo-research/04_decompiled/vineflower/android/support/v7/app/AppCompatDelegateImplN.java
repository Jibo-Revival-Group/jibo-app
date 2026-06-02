package android.support.v7.app;

import android.content.Context;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.Window;
import android.view.Window.Callback;
import java.util.List;

class AppCompatDelegateImplN extends AppCompatDelegateImplV23 {
   AppCompatDelegateImplN(Context var1, Window var2, AppCompatCallback var3) {
      super(var1, var2, var3);
   }

   @Override
   Callback a(Callback var1) {
      return new AppCompatDelegateImplN.AppCompatWindowCallbackN(this, var1);
   }

   class AppCompatWindowCallbackN extends AppCompatDelegateImplV23.AppCompatWindowCallbackV23 {
      final AppCompatDelegateImplN b;

      AppCompatWindowCallbackN(AppCompatDelegateImplN var1, Callback var2) {
         super(var1, var2);
         this.b = var1;
      }

      @Override
      public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> var1, Menu var2, int var3) {
         AppCompatDelegateImplV9.PanelFeatureState var4 = this.b.a(0, true);
         if (var4 != null && var4.j != null) {
            super.onProvideKeyboardShortcuts(var1, var4.j, var3);
         } else {
            super.onProvideKeyboardShortcuts(var1, var2, var3);
         }
      }
   }
}
