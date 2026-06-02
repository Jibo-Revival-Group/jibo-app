package android.support.v4.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import java.util.ArrayList;

public class FragmentTabHost extends TabHost implements OnTabChangeListener {
   private final ArrayList<FragmentTabHost.TabInfo> a = new ArrayList<>();
   private Context b;
   private FragmentManager c;
   private int d;
   private OnTabChangeListener e;
   private FragmentTabHost.TabInfo f;
   private boolean g;

   public FragmentTabHost(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.a(var1, var2);
   }

   private FragmentTabHost.TabInfo a(String var1) {
      int var3 = this.a.size();
      int var2 = 0;

      while (true) {
         if (var2 >= var3) {
            var5 = null;
            break;
         }

         FragmentTabHost.TabInfo var4 = this.a.get(var2);
         if (var4.a.equals(var1)) {
            var5 = var4;
            break;
         }

         var2++;
      }

      return var5;
   }

   private FragmentTransaction a(String var1, FragmentTransaction var2) {
      FragmentTabHost.TabInfo var3 = this.a(var1);
      FragmentTransaction var4 = var2;
      if (this.f != var3) {
         var4 = var2;
         if (var2 == null) {
            var4 = this.c.a();
         }

         if (this.f != null && this.f.d != null) {
            var4.b(this.f.d);
         }

         if (var3 != null) {
            if (var3.d == null) {
               var3.d = Fragment.instantiate(this.b, var3.b.getName(), var3.c);
               var4.a(this.d, var3.d, var3.a);
            } else {
               var4.c(var3.d);
            }
         }

         this.f = var3;
      }

      return var4;
   }

   private void a(Context var1, AttributeSet var2) {
      TypedArray var3 = var1.obtainStyledAttributes(var2, new int[]{16842995}, 0, 0);
      this.d = var3.getResourceId(0, 0);
      var3.recycle();
      super.setOnTabChangedListener(this);
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      String var5 = this.getCurrentTabTag();
      FragmentTransaction var3 = null;
      int var2 = this.a.size();
      int var1 = 0;

      while (var1 < var2) {
         FragmentTabHost.TabInfo var6 = this.a.get(var1);
         var6.d = this.c.a(var6.a);
         FragmentTransaction var4 = var3;
         if (var6.d != null) {
            var4 = var3;
            if (!var6.d.isDetached()) {
               if (var6.a.equals(var5)) {
                  this.f = var6;
                  var4 = var3;
               } else {
                  var4 = var3;
                  if (var3 == null) {
                     var4 = this.c.a();
                  }

                  var4.b(var6.d);
               }
            }
         }

         var1++;
         var3 = var4;
      }

      this.g = true;
      var3 = this.a(var5, var3);
      if (var3 != null) {
         var3.d();
         this.c.b();
      }
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.g = false;
   }

   protected void onRestoreInstanceState(Parcelable var1) {
      if (!(var1 instanceof FragmentTabHost.SavedState)) {
         super.onRestoreInstanceState(var1);
      } else {
         FragmentTabHost.SavedState var2 = (FragmentTabHost.SavedState)var1;
         super.onRestoreInstanceState(var2.getSuperState());
         this.setCurrentTabByTag(var2.a);
      }
   }

   protected Parcelable onSaveInstanceState() {
      FragmentTabHost.SavedState var1 = new FragmentTabHost.SavedState(super.onSaveInstanceState());
      var1.a = this.getCurrentTabTag();
      return var1;
   }

   public void onTabChanged(String var1) {
      if (this.g) {
         FragmentTransaction var2 = this.a(var1, null);
         if (var2 != null) {
            var2.d();
         }
      }

      if (this.e != null) {
         this.e.onTabChanged(var1);
      }
   }

   public void setOnTabChangedListener(OnTabChangeListener var1) {
      this.e = var1;
   }

   @Deprecated
   public void setup() {
      throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
   }

   static class SavedState extends BaseSavedState {
      public static final Creator<FragmentTabHost.SavedState> CREATOR = new Creator<FragmentTabHost.SavedState>() {
         public FragmentTabHost.SavedState a(Parcel var1) {
            return new FragmentTabHost.SavedState(var1);
         }

         public FragmentTabHost.SavedState[] a(int var1) {
            return new FragmentTabHost.SavedState[var1];
         }
      };
      String a;

      SavedState(Parcel var1) {
         super(var1);
         this.a = var1.readString();
      }

      SavedState(Parcelable var1) {
         super(var1);
      }

      public String toString() {
         return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.a + "}";
      }

      public void writeToParcel(Parcel var1, int var2) {
         super.writeToParcel(var1, var2);
         var1.writeString(this.a);
      }
   }

   static final class TabInfo {
      final String a;
      final Class<?> b;
      final Bundle c;
      Fragment d;
   }
}
