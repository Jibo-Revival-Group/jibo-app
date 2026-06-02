package android.support.design.widget;

import android.content.Context;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.appcompat.R;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;

public class CheckableImageButton extends AppCompatImageButton implements Checkable {
   private static final int[] a = new int[]{16842912};
   private boolean b;

   public CheckableImageButton(Context var1) {
      this(var1, null);
   }

   public CheckableImageButton(Context var1, AttributeSet var2) {
      this(var1, var2, R.attr.imageButtonStyle);
   }

   public CheckableImageButton(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      ViewCompat.a(this, new AccessibilityDelegateCompat(this) {
         final CheckableImageButton a;

         {
            this.a = var1;
         }

         @Override
         public void a(View var1, AccessibilityNodeInfoCompat var2x) {
            super.a(var1, var2x);
            var2x.a(true);
            var2x.b(this.a.isChecked());
         }

         @Override
         public void a(View var1, AccessibilityEvent var2x) {
            super.a(var1, var2x);
            var2x.setChecked(this.a.isChecked());
         }
      });
   }

   public boolean isChecked() {
      return this.b;
   }

   public int[] onCreateDrawableState(int var1) {
      int[] var2;
      if (this.b) {
         var2 = mergeDrawableStates(super.onCreateDrawableState(a.length + var1), a);
      } else {
         var2 = super.onCreateDrawableState(var1);
      }

      return var2;
   }

   public void setChecked(boolean var1) {
      if (this.b != var1) {
         this.b = var1;
         this.refreshDrawableState();
         this.sendAccessibilityEvent(2048);
      }
   }

   public void toggle() {
      boolean var1;
      if (!this.b) {
         var1 = true;
      } else {
         var1 = false;
      }

      this.setChecked(var1);
   }
}
