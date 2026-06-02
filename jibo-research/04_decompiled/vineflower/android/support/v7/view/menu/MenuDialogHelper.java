package android.support.v7.view.menu;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.IBinder;
import android.support.v7.app.AlertDialog;
import android.support.v7.appcompat.R;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.KeyEvent.DispatcherState;
import android.view.WindowManager.LayoutParams;

class MenuDialogHelper implements OnClickListener, OnDismissListener, OnKeyListener, MenuPresenter.Callback {
   ListMenuPresenter a;
   private MenuBuilder b;
   private AlertDialog c;
   private MenuPresenter.Callback d;

   public MenuDialogHelper(MenuBuilder var1) {
      this.b = var1;
   }

   public void a() {
      if (this.c != null) {
         this.c.dismiss();
      }
   }

   public void a(IBinder var1) {
      MenuBuilder var3 = this.b;
      AlertDialog.Builder var4 = new AlertDialog.Builder(var3.e());
      this.a = new ListMenuPresenter(var4.a(), R.layout.abc_list_menu_item_layout);
      this.a.a(this);
      this.b.a(this.a);
      var4.a(this.a.d(), this);
      View var2 = var3.o();
      if (var2 != null) {
         var4.a(var2);
      } else {
         var4.a(var3.n()).a(var3.m());
      }

      var4.a(this);
      this.c = var4.b();
      this.c.setOnDismissListener(this);
      LayoutParams var5 = this.c.getWindow().getAttributes();
      var5.type = 1003;
      if (var1 != null) {
         var5.token = var1;
      }

      var5.flags |= 131072;
      this.c.show();
   }

   @Override
   public void a(MenuBuilder var1, boolean var2) {
      if (var2 || var1 == this.b) {
         this.a();
      }

      if (this.d != null) {
         this.d.a(var1, var2);
      }
   }

   @Override
   public boolean a(MenuBuilder var1) {
      boolean var2;
      if (this.d != null) {
         var2 = this.d.a(var1);
      } else {
         var2 = false;
      }

      return var2;
   }

   public void onClick(DialogInterface var1, int var2) {
      this.b.a((MenuItemImpl)this.a.d().getItem(var2), 0);
   }

   public void onDismiss(DialogInterface var1) {
      this.a.a(this.b, true);
   }

   public boolean onKey(DialogInterface var1, int var2, KeyEvent var3) {
      boolean var4 = true;
      if (var2 == 82 || var2 == 4) {
         if (var3.getAction() == 0 && var3.getRepeatCount() == 0) {
            Window var6 = this.c.getWindow();
            if (var6 != null) {
               View var7 = var6.getDecorView();
               if (var7 != null) {
                  DispatcherState var8 = var7.getKeyDispatcherState();
                  if (var8 != null) {
                     var8.startTracking(var3, this);
                     return var4;
                  }
               }
            }
         } else if (var3.getAction() == 1 && !var3.isCanceled()) {
            Window var5 = this.c.getWindow();
            if (var5 != null) {
               View var9 = var5.getDecorView();
               if (var9 != null) {
                  DispatcherState var10 = var9.getKeyDispatcherState();
                  if (var10 != null && var10.isTracking(var3)) {
                     this.b.b(true);
                     var1.dismiss();
                     return var4;
                  }
               }
            }
         }
      }

      return this.b.performShortcut(var2, var3, 0);
   }
}
