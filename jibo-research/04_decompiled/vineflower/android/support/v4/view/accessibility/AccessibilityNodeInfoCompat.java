package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;

public class AccessibilityNodeInfoCompat {
   public int a = -1;
   private final AccessibilityNodeInfo b;

   private AccessibilityNodeInfoCompat(AccessibilityNodeInfo var1) {
      this.b = var1;
   }

   public static AccessibilityNodeInfoCompat a(AccessibilityNodeInfoCompat var0) {
      return a(AccessibilityNodeInfo.obtain(var0.b));
   }

   public static AccessibilityNodeInfoCompat a(AccessibilityNodeInfo var0) {
      return new AccessibilityNodeInfoCompat(var0);
   }

   private static String c(int var0) {
      String var1;
      switch (var0) {
         case 1:
            var1 = "ACTION_FOCUS";
            break;
         case 2:
            var1 = "ACTION_CLEAR_FOCUS";
            break;
         case 4:
            var1 = "ACTION_SELECT";
            break;
         case 8:
            var1 = "ACTION_CLEAR_SELECTION";
            break;
         case 16:
            var1 = "ACTION_CLICK";
            break;
         case 32:
            var1 = "ACTION_LONG_CLICK";
            break;
         case 64:
            var1 = "ACTION_ACCESSIBILITY_FOCUS";
            break;
         case 128:
            var1 = "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            break;
         case 256:
            var1 = "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            break;
         case 512:
            var1 = "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            break;
         case 1024:
            var1 = "ACTION_NEXT_HTML_ELEMENT";
            break;
         case 2048:
            var1 = "ACTION_PREVIOUS_HTML_ELEMENT";
            break;
         case 4096:
            var1 = "ACTION_SCROLL_FORWARD";
            break;
         case 8192:
            var1 = "ACTION_SCROLL_BACKWARD";
            break;
         case 16384:
            var1 = "ACTION_COPY";
            break;
         case 32768:
            var1 = "ACTION_PASTE";
            break;
         case 65536:
            var1 = "ACTION_CUT";
            break;
         case 131072:
            var1 = "ACTION_SET_SELECTION";
            break;
         default:
            var1 = "ACTION_UNKNOWN";
      }

      return var1;
   }

   public AccessibilityNodeInfo a() {
      return this.b;
   }

   public void a(int var1) {
      this.b.addAction(var1);
   }

   public void a(Rect var1) {
      this.b.getBoundsInParent(var1);
   }

   public void a(View var1) {
      this.b.setSource(var1);
   }

   public void a(CharSequence var1) {
      this.b.setPackageName(var1);
   }

   public void a(Object var1) {
      if (VERSION.SDK_INT >= 19) {
         this.b.setCollectionInfo((CollectionInfo)((AccessibilityNodeInfoCompat.CollectionInfoCompat)var1).a);
      }
   }

   public void a(boolean var1) {
      this.b.setCheckable(var1);
   }

   public boolean a(AccessibilityNodeInfoCompat.AccessibilityActionCompat var1) {
      boolean var2;
      if (VERSION.SDK_INT >= 21) {
         var2 = this.b.removeAction((AccessibilityAction)var1.E);
      } else {
         var2 = false;
      }

      return var2;
   }

   public int b() {
      return this.b.getActions();
   }

   public void b(int var1) {
      if (VERSION.SDK_INT >= 16) {
         this.b.setMovementGranularities(var1);
      }
   }

   public void b(Rect var1) {
      this.b.setBoundsInParent(var1);
   }

   public void b(View var1) {
      this.b.addChild(var1);
   }

   public void b(CharSequence var1) {
      this.b.setClassName(var1);
   }

   public void b(Object var1) {
      if (VERSION.SDK_INT >= 19) {
         this.b.setCollectionItemInfo((CollectionItemInfo)((AccessibilityNodeInfoCompat.CollectionItemInfoCompat)var1).a);
      }
   }

   public void b(boolean var1) {
      this.b.setChecked(var1);
   }

   public int c() {
      int var1;
      if (VERSION.SDK_INT >= 16) {
         var1 = this.b.getMovementGranularities();
      } else {
         var1 = 0;
      }

      return var1;
   }

   public void c(Rect var1) {
      this.b.getBoundsInScreen(var1);
   }

   public void c(View var1) {
      this.b.setParent(var1);
   }

   public void c(CharSequence var1) {
      this.b.setText(var1);
   }

   public void c(boolean var1) {
      this.b.setFocusable(var1);
   }

   public void d(Rect var1) {
      this.b.setBoundsInScreen(var1);
   }

   public void d(View var1) {
      if (VERSION.SDK_INT >= 17) {
         this.b.setLabelFor(var1);
      }
   }

   public void d(CharSequence var1) {
      this.b.setContentDescription(var1);
   }

   public void d(boolean var1) {
      this.b.setFocused(var1);
   }

   public boolean d() {
      return this.b.isCheckable();
   }

   public void e(CharSequence var1) {
      if (VERSION.SDK_INT >= 21) {
         this.b.setError(var1);
      }
   }

   public void e(boolean var1) {
      if (VERSION.SDK_INT >= 16) {
         this.b.setVisibleToUser(var1);
      }
   }

   public boolean e() {
      return this.b.isChecked();
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (var1 == null) {
            var2 = false;
         } else if (this.getClass() != var1.getClass()) {
            var2 = false;
         } else {
            var1 = var1;
            if (this.b == null) {
               if (var1.b != null) {
                  var2 = false;
               }
            } else if (!this.b.equals(var1.b)) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   public void f(boolean var1) {
      if (VERSION.SDK_INT >= 16) {
         this.b.setAccessibilityFocused(var1);
      }
   }

   public boolean f() {
      return this.b.isFocusable();
   }

   public void g(boolean var1) {
      this.b.setSelected(var1);
   }

   public boolean g() {
      return this.b.isFocused();
   }

   public void h(boolean var1) {
      this.b.setClickable(var1);
   }

   public boolean h() {
      boolean var1;
      if (VERSION.SDK_INT >= 16) {
         var1 = this.b.isVisibleToUser();
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public int hashCode() {
      int var1;
      if (this.b == null) {
         var1 = 0;
      } else {
         var1 = this.b.hashCode();
      }

      return var1;
   }

   public void i(boolean var1) {
      this.b.setLongClickable(var1);
   }

   public boolean i() {
      boolean var1;
      if (VERSION.SDK_INT >= 16) {
         var1 = this.b.isAccessibilityFocused();
      } else {
         var1 = false;
      }

      return var1;
   }

   public void j(boolean var1) {
      this.b.setEnabled(var1);
   }

   public boolean j() {
      return this.b.isSelected();
   }

   public void k(boolean var1) {
      this.b.setScrollable(var1);
   }

   public boolean k() {
      return this.b.isClickable();
   }

   public void l(boolean var1) {
      if (VERSION.SDK_INT >= 19) {
         this.b.setContentInvalid(var1);
      }
   }

   public boolean l() {
      return this.b.isLongClickable();
   }

   public void m(boolean var1) {
      if (VERSION.SDK_INT >= 19) {
         this.b.setCanOpenPopup(var1);
      }
   }

   public boolean m() {
      return this.b.isEnabled();
   }

   public void n(boolean var1) {
      if (VERSION.SDK_INT >= 19) {
         this.b.setDismissable(var1);
      }
   }

   public boolean n() {
      return this.b.isPassword();
   }

   public boolean o() {
      return this.b.isScrollable();
   }

   public CharSequence p() {
      return this.b.getPackageName();
   }

   public CharSequence q() {
      return this.b.getClassName();
   }

   public CharSequence r() {
      return this.b.getText();
   }

   public CharSequence s() {
      return this.b.getContentDescription();
   }

   public void t() {
      this.b.recycle();
   }

   @Override
   public String toString() {
      StringBuilder var5 = new StringBuilder();
      var5.append(super.toString());
      Rect var4 = new Rect();
      this.a(var4);
      var5.append("; boundsInParent: " + var4);
      this.c(var4);
      var5.append("; boundsInScreen: " + var4);
      var5.append("; packageName: ").append(this.p());
      var5.append("; className: ").append(this.q());
      var5.append("; text: ").append(this.r());
      var5.append("; contentDescription: ").append(this.s());
      var5.append("; viewId: ").append(this.u());
      var5.append("; checkable: ").append(this.d());
      var5.append("; checked: ").append(this.e());
      var5.append("; focusable: ").append(this.f());
      var5.append("; focused: ").append(this.g());
      var5.append("; selected: ").append(this.j());
      var5.append("; clickable: ").append(this.k());
      var5.append("; longClickable: ").append(this.l());
      var5.append("; enabled: ").append(this.m());
      var5.append("; password: ").append(this.n());
      var5.append("; scrollable: " + this.o());
      var5.append("; [");
      int var1 = this.b();

      while (var1 != 0) {
         int var3 = 1 << Integer.numberOfTrailingZeros(var1);
         int var2 = var1 & ~var3;
         var5.append(c(var3));
         var1 = var2;
         if (var2 != 0) {
            var5.append(", ");
            var1 = var2;
         }
      }

      var5.append("]");
      return var5.toString();
   }

   public String u() {
      String var1;
      if (VERSION.SDK_INT >= 18) {
         var1 = this.b.getViewIdResourceName();
      } else {
         var1 = null;
      }

      return var1;
   }

   public static class AccessibilityActionCompat {
      public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat A;
      public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat B;
      public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat C;
      public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat D;
      public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat a = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(1, null);
      public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat b = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(2, null);
      public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat c = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(4, null);
      public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat d = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(8, null);
      public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat e = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, null);
      public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat f = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32, null);
      public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat g = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(64, null);
      public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat h = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(128, null);
      public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat i = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(256, null);
      public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat j = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(512, null);
      public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat k = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(1024, null);
      public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat l = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(2048, null);
      public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat m = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(4096, null);
      public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat n = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(8192, null);
      public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat o = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16384, null);
      public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat p = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32768, null);
      public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat q = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(65536, null);
      public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat r = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(131072, null);
      public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat s = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(262144, null);
      public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat t = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(524288, null);
      public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat u = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(1048576, null);
      public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat v = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(2097152, null);
      public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat w;
      public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat x;
      public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat y;
      public static final AccessibilityNodeInfoCompat.AccessibilityActionCompat z;
      final Object E;

      static {
         Object var1 = null;
         AccessibilityAction var0;
         if (VERSION.SDK_INT >= 23) {
            var0 = AccessibilityAction.ACTION_SHOW_ON_SCREEN;
         } else {
            var0 = null;
         }

         w = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(var0);
         if (VERSION.SDK_INT >= 23) {
            var0 = AccessibilityAction.ACTION_SCROLL_TO_POSITION;
         } else {
            var0 = null;
         }

         x = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(var0);
         if (VERSION.SDK_INT >= 23) {
            var0 = AccessibilityAction.ACTION_SCROLL_UP;
         } else {
            var0 = null;
         }

         y = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(var0);
         if (VERSION.SDK_INT >= 23) {
            var0 = AccessibilityAction.ACTION_SCROLL_LEFT;
         } else {
            var0 = null;
         }

         z = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(var0);
         if (VERSION.SDK_INT >= 23) {
            var0 = AccessibilityAction.ACTION_SCROLL_DOWN;
         } else {
            var0 = null;
         }

         A = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(var0);
         if (VERSION.SDK_INT >= 23) {
            var0 = AccessibilityAction.ACTION_SCROLL_RIGHT;
         } else {
            var0 = null;
         }

         B = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(var0);
         if (VERSION.SDK_INT >= 23) {
            var0 = AccessibilityAction.ACTION_CONTEXT_CLICK;
         } else {
            var0 = null;
         }

         C = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(var0);
         var0 = (AccessibilityAction)var1;
         if (VERSION.SDK_INT >= 24) {
            var0 = AccessibilityAction.ACTION_SET_PROGRESS;
         }

         D = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(var0);
      }

      public AccessibilityActionCompat(int var1, CharSequence var2) {
         AccessibilityAction var3;
         if (VERSION.SDK_INT >= 21) {
            var3 = new AccessibilityAction(var1, var2);
         } else {
            var3 = null;
         }

         this(var3);
      }

      AccessibilityActionCompat(Object var1) {
         this.E = var1;
      }
   }

   public static class CollectionInfoCompat {
      final Object a;

      CollectionInfoCompat(Object var1) {
         this.a = var1;
      }

      public static AccessibilityNodeInfoCompat.CollectionInfoCompat a(int var0, int var1, boolean var2, int var3) {
         AccessibilityNodeInfoCompat.CollectionInfoCompat var4;
         if (VERSION.SDK_INT >= 21) {
            var4 = new AccessibilityNodeInfoCompat.CollectionInfoCompat(CollectionInfo.obtain(var0, var1, var2, var3));
         } else if (VERSION.SDK_INT >= 19) {
            var4 = new AccessibilityNodeInfoCompat.CollectionInfoCompat(CollectionInfo.obtain(var0, var1, var2));
         } else {
            var4 = new AccessibilityNodeInfoCompat.CollectionInfoCompat(null);
         }

         return var4;
      }
   }

   public static class CollectionItemInfoCompat {
      final Object a;

      CollectionItemInfoCompat(Object var1) {
         this.a = var1;
      }

      public static AccessibilityNodeInfoCompat.CollectionItemInfoCompat a(int var0, int var1, int var2, int var3, boolean var4, boolean var5) {
         AccessibilityNodeInfoCompat.CollectionItemInfoCompat var6;
         if (VERSION.SDK_INT >= 21) {
            var6 = new AccessibilityNodeInfoCompat.CollectionItemInfoCompat(CollectionItemInfo.obtain(var0, var1, var2, var3, var4, var5));
         } else if (VERSION.SDK_INT >= 19) {
            var6 = new AccessibilityNodeInfoCompat.CollectionItemInfoCompat(CollectionItemInfo.obtain(var0, var1, var2, var3, var4));
         } else {
            var6 = new AccessibilityNodeInfoCompat.CollectionItemInfoCompat(null);
         }

         return var6;
      }
   }
}
