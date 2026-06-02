package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.design.R;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.app.AppCompatDialog;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

public class BottomSheetDialog extends AppCompatDialog {
   boolean a = true;
   private BottomSheetBehavior<FrameLayout> b;
   private boolean c = true;
   private boolean d;
   private BottomSheetBehavior.BottomSheetCallback e = new BottomSheetBehavior.BottomSheetCallback(this) {
      final BottomSheetDialog a;

      {
         this.a = var1;
      }

      @Override
      public void a(View var1, float var2) {
      }

      @Override
      public void a(View var1, int var2) {
         if (var2 == 5) {
            this.a.cancel();
         }
      }
   };

   public BottomSheetDialog(Context var1) {
      this(var1, 0);
   }

   public BottomSheetDialog(Context var1, int var2) {
      super(var1, a(var1, var2));
      this.b(1);
   }

   private static int a(Context var0, int var1) {
      int var2 = var1;
      if (var1 == 0) {
         TypedValue var3 = new TypedValue();
         if (var0.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, var3, true)) {
            var2 = var3.resourceId;
         } else {
            var2 = R.style.Theme_Design_Light_BottomSheetDialog;
         }
      }

      return var2;
   }

   private View a(int var1, View var2, LayoutParams var3) {
      FrameLayout var6 = (FrameLayout)View.inflate(this.getContext(), R.layout.design_bottom_sheet_dialog, null);
      CoordinatorLayout var5 = (CoordinatorLayout)var6.findViewById(R.id.coordinator);
      View var4 = var2;
      if (var1 != 0) {
         var4 = var2;
         if (var2 == null) {
            var4 = this.getLayoutInflater().inflate(var1, var5, false);
         }
      }

      var var7 = (FrameLayout & View)var5.findViewById(R.id.design_bottom_sheet);
      this.b = BottomSheetBehavior.b(var7);
      this.b.a(this.e);
      this.b.a(this.a);
      if (var3 == null) {
         var7.addView(var4);
      } else {
         var7.addView(var4, var3);
      }

      var5.findViewById(R.id.touch_outside).setOnClickListener(new OnClickListener(this) {
         final BottomSheetDialog a;

         {
            this.a = var1;
         }

         public void onClick(View var1) {
            if (this.a.a && this.a.isShowing() && this.a.a()) {
               this.a.cancel();
            }
         }
      });
      ViewCompat.a(var7, new AccessibilityDelegateCompat(this) {
         final BottomSheetDialog a;

         {
            this.a = var1;
         }

         @Override
         public void a(View var1, AccessibilityNodeInfoCompat var2x) {
            super.a(var1, var2x);
            if (this.a.a) {
               var2x.a(1048576);
               var2x.n(true);
            } else {
               var2x.n(false);
            }
         }

         @Override
         public boolean a(View var1, int var2x, Bundle var3x) {
            boolean var4x;
            if (var2x == 1048576 && this.a.a) {
               this.a.cancel();
               var4x = true;
            } else {
               var4x = super.a(var1, var2x, var3x);
            }

            return var4x;
         }
      });
      var7.setOnTouchListener(new OnTouchListener(this) {
         final BottomSheetDialog a;

         {
            this.a = var1;
         }

         public boolean onTouch(View var1, MotionEvent var2x) {
            return true;
         }
      });
      return var6;
   }

   boolean a() {
      if (!this.d) {
         if (VERSION.SDK_INT < 11) {
            this.c = true;
         } else {
            TypedArray var1 = this.getContext().obtainStyledAttributes(new int[]{16843611});
            this.c = var1.getBoolean(0, true);
            var1.recycle();
         }

         this.d = true;
      }

      return this.c;
   }

   @Override
   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      Window var2 = this.getWindow();
      if (var2 != null) {
         if (VERSION.SDK_INT >= 21) {
            var2.clearFlags(67108864);
            var2.addFlags(Integer.MIN_VALUE);
         }

         var2.setLayout(-1, -1);
      }
   }

   protected void onStart() {
      super.onStart();
      if (this.b != null) {
         this.b.b(4);
      }
   }

   public void setCancelable(boolean var1) {
      super.setCancelable(var1);
      if (this.a != var1) {
         this.a = var1;
         if (this.b != null) {
            this.b.a(var1);
         }
      }
   }

   public void setCanceledOnTouchOutside(boolean var1) {
      super.setCanceledOnTouchOutside(var1);
      if (var1 && !this.a) {
         this.a = true;
      }

      this.c = var1;
      this.d = true;
   }

   @Override
   public void setContentView(int var1) {
      super.setContentView(this.a(var1, null, null));
   }

   @Override
   public void setContentView(View var1) {
      super.setContentView(this.a(0, var1, null));
   }

   @Override
   public void setContentView(View var1, LayoutParams var2) {
      super.setContentView(this.a(0, var1, var2));
   }
}
