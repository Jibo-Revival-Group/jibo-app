package android.support.v4.view;

import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

public class AccessibilityDelegateCompat {
   private static final AccessibilityDelegateCompat.AccessibilityDelegateBaseImpl a;
   private static final AccessibilityDelegate c;
   final AccessibilityDelegate b;

   static {
      if (VERSION.SDK_INT >= 16) {
         a = new AccessibilityDelegateCompat.AccessibilityDelegateApi16Impl();
      } else {
         a = new AccessibilityDelegateCompat.AccessibilityDelegateBaseImpl();
      }

      c = new AccessibilityDelegate();
   }

   public AccessibilityDelegateCompat() {
      this.b = a.a(this);
   }

   public AccessibilityNodeProviderCompat a(View var1) {
      return a.a(c, var1);
   }

   AccessibilityDelegate a() {
      return this.b;
   }

   public void a(View var1, int var2) {
      c.sendAccessibilityEvent(var1, var2);
   }

   public void a(View var1, AccessibilityNodeInfoCompat var2) {
      c.onInitializeAccessibilityNodeInfo(var1, var2.a());
   }

   public void a(View var1, AccessibilityEvent var2) {
      c.onInitializeAccessibilityEvent(var1, var2);
   }

   public boolean a(View var1, int var2, Bundle var3) {
      return a.a(c, var1, var2, var3);
   }

   public boolean a(ViewGroup var1, View var2, AccessibilityEvent var3) {
      return c.onRequestSendAccessibilityEvent(var1, var2, var3);
   }

   public void b(View var1, AccessibilityEvent var2) {
      c.onPopulateAccessibilityEvent(var1, var2);
   }

   public void c(View var1, AccessibilityEvent var2) {
      c.sendAccessibilityEventUnchecked(var1, var2);
   }

   public boolean d(View var1, AccessibilityEvent var2) {
      return c.dispatchPopulateAccessibilityEvent(var1, var2);
   }

   static class AccessibilityDelegateApi16Impl extends AccessibilityDelegateCompat.AccessibilityDelegateBaseImpl {
      @Override
      public AccessibilityNodeProviderCompat a(AccessibilityDelegate var1, View var2) {
         AccessibilityNodeProvider var3 = var1.getAccessibilityNodeProvider(var2);
         AccessibilityNodeProviderCompat var4;
         if (var3 != null) {
            var4 = new AccessibilityNodeProviderCompat(var3);
         } else {
            var4 = null;
         }

         return var4;
      }

      @Override
      public AccessibilityDelegate a(AccessibilityDelegateCompat var1) {
         return new AccessibilityDelegate(this, var1) {
            final AccessibilityDelegateCompat a;
            final AccessibilityDelegateCompat.AccessibilityDelegateApi16Impl b;

            {
               this.b = var1;
               this.a = var2;
            }

            public boolean dispatchPopulateAccessibilityEvent(View var1, AccessibilityEvent var2) {
               return this.a.d(var1, var2);
            }

            public AccessibilityNodeProvider getAccessibilityNodeProvider(View var1) {
               AccessibilityNodeProviderCompat var2 = this.a.a(var1);
               AccessibilityNodeProvider var3;
               if (var2 != null) {
                  var3 = (AccessibilityNodeProvider)var2.a();
               } else {
                  var3 = null;
               }

               return var3;
            }

            public void onInitializeAccessibilityEvent(View var1, AccessibilityEvent var2) {
               this.a.a(var1, var2);
            }

            public void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfo var2) {
               this.a.a(var1, AccessibilityNodeInfoCompat.a(var2));
            }

            public void onPopulateAccessibilityEvent(View var1, AccessibilityEvent var2) {
               this.a.b(var1, var2);
            }

            public boolean onRequestSendAccessibilityEvent(ViewGroup var1, View var2, AccessibilityEvent var3) {
               return this.a.a(var1, var2, var3);
            }

            public boolean performAccessibilityAction(View var1, int var2, Bundle var3) {
               return this.a.a(var1, var2, var3);
            }

            public void sendAccessibilityEvent(View var1, int var2) {
               this.a.a(var1, var2);
            }

            public void sendAccessibilityEventUnchecked(View var1, AccessibilityEvent var2) {
               this.a.c(var1, var2);
            }
         };
      }

      @Override
      public boolean a(AccessibilityDelegate var1, View var2, int var3, Bundle var4) {
         return var1.performAccessibilityAction(var2, var3, var4);
      }
   }

   static class AccessibilityDelegateBaseImpl {
      public AccessibilityNodeProviderCompat a(AccessibilityDelegate var1, View var2) {
         return null;
      }

      public AccessibilityDelegate a(AccessibilityDelegateCompat var1) {
         return new AccessibilityDelegate(this, var1) {
            final AccessibilityDelegateCompat a;
            final AccessibilityDelegateCompat.AccessibilityDelegateBaseImpl b;

            {
               this.b = var1;
               this.a = var2;
            }

            public boolean dispatchPopulateAccessibilityEvent(View var1, AccessibilityEvent var2) {
               return this.a.d(var1, var2);
            }

            public void onInitializeAccessibilityEvent(View var1, AccessibilityEvent var2) {
               this.a.a(var1, var2);
            }

            public void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfo var2) {
               this.a.a(var1, AccessibilityNodeInfoCompat.a(var2));
            }

            public void onPopulateAccessibilityEvent(View var1, AccessibilityEvent var2) {
               this.a.b(var1, var2);
            }

            public boolean onRequestSendAccessibilityEvent(ViewGroup var1, View var2, AccessibilityEvent var3) {
               return this.a.a(var1, var2, var3);
            }

            public void sendAccessibilityEvent(View var1, int var2) {
               this.a.a(var1, var2);
            }

            public void sendAccessibilityEventUnchecked(View var1, AccessibilityEvent var2) {
               this.a.c(var1, var2);
            }
         };
      }

      public boolean a(AccessibilityDelegate var1, View var2, int var3, Bundle var4) {
         return false;
      }
   }
}
