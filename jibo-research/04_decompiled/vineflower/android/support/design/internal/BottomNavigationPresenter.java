package android.support.design.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.SubMenuBuilder;

public class BottomNavigationPresenter implements MenuPresenter {
   private MenuBuilder a;
   private BottomNavigationMenuView b;
   private boolean c = false;
   private int d;

   public void a(int var1) {
      this.d = var1;
   }

   @Override
   public void a(Context var1, MenuBuilder var2) {
      this.b.a(this.a);
      this.a = var2;
   }

   @Override
   public void a(Parcelable var1) {
      if (var1 instanceof BottomNavigationPresenter.SavedState) {
         this.b.a(((BottomNavigationPresenter.SavedState)var1).a);
      }
   }

   public void a(BottomNavigationMenuView var1) {
      this.b = var1;
   }

   @Override
   public void a(MenuBuilder var1, boolean var2) {
   }

   @Override
   public void a(MenuPresenter.Callback var1) {
   }

   @Override
   public void a(boolean var1) {
      if (!this.c) {
         if (var1) {
            this.b.a();
         } else {
            this.b.b();
         }
      }
   }

   @Override
   public boolean a() {
      return false;
   }

   @Override
   public boolean a(MenuBuilder var1, MenuItemImpl var2) {
      return false;
   }

   @Override
   public boolean a(SubMenuBuilder var1) {
      return false;
   }

   @Override
   public int b() {
      return this.d;
   }

   public void b(boolean var1) {
      this.c = var1;
   }

   @Override
   public boolean b(MenuBuilder var1, MenuItemImpl var2) {
      return false;
   }

   @Override
   public Parcelable c() {
      BottomNavigationPresenter.SavedState var1 = new BottomNavigationPresenter.SavedState();
      var1.a = this.b.getSelectedItemId();
      return var1;
   }

   static class SavedState implements Parcelable {
      public static final Creator<BottomNavigationPresenter.SavedState> CREATOR = new Creator<BottomNavigationPresenter.SavedState>() {
         public BottomNavigationPresenter.SavedState a(Parcel var1) {
            return new BottomNavigationPresenter.SavedState(var1);
         }

         public BottomNavigationPresenter.SavedState[] a(int var1) {
            return new BottomNavigationPresenter.SavedState[var1];
         }
      };
      int a;

      SavedState() {
      }

      SavedState(Parcel var1) {
         this.a = var1.readInt();
      }

      public int describeContents() {
         return 0;
      }

      public void writeToParcel(Parcel var1, int var2) {
         var1.writeInt(this.a);
      }
   }
}
