package com.mixpanel.android.viewcrawler;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.AccessibilityDelegate;
import android.widget.TextView;
import android.widget.RelativeLayout.LayoutParams;
import com.mixpanel.android.util.MPLog;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;
import java.util.Map.Entry;

@TargetApi(16)
abstract class ViewVisitor implements Pathfinder.Accumulator {
   private final List<Pathfinder.PathElement> a;
   private final Pathfinder b;

   protected ViewVisitor(List<Pathfinder.PathElement> var1) {
      this.a = var1;
      this.b = new Pathfinder();
   }

   public abstract void a();

   protected List<Pathfinder.PathElement> b() {
      return this.a;
   }

   public void b(View var1) {
      this.b.a(var1, this.a, this);
   }

   protected Pathfinder c() {
      return this.b;
   }

   public static class AddAccessibilityEventVisitor extends ViewVisitor.EventTriggeringVisitor {
      private final int a;
      private final WeakHashMap<View, ViewVisitor.AddAccessibilityEventVisitor.TrackingAccessibilityDelegate> b;

      public AddAccessibilityEventVisitor(List<Pathfinder.PathElement> var1, int var2, String var3, ViewVisitor.OnEventListener var4) {
         super(var1, var3, var4, false);
         this.a = var2;
         this.b = new WeakHashMap<>();
      }

      private AccessibilityDelegate d(View var1) {
         try {
            var5 = (AccessibilityDelegate)var1.getClass().getMethod("getAccessibilityDelegate").invoke(var1);
         } catch (NoSuchMethodException var2) {
            var5 = null;
         } catch (IllegalAccessException var3) {
            var5 = null;
         } catch (InvocationTargetException var4) {
            MPLog.d("MixpanelAPI.ViewVisitor", "getAccessibilityDelegate threw an exception when called.", var4);
            var5 = null;
         }

         return var5;
      }

      @Override
      public void a() {
         for (Entry var3 : this.b.entrySet()) {
            View var2 = (View)var3.getKey();
            ViewVisitor.AddAccessibilityEventVisitor.TrackingAccessibilityDelegate var4 = (ViewVisitor.AddAccessibilityEventVisitor.TrackingAccessibilityDelegate)var3.getValue();
            AccessibilityDelegate var5 = this.d(var2);
            if (var5 == var4) {
               var2.setAccessibilityDelegate(var4.a());
            } else if (var5 instanceof ViewVisitor.AddAccessibilityEventVisitor.TrackingAccessibilityDelegate) {
               ((ViewVisitor.AddAccessibilityEventVisitor.TrackingAccessibilityDelegate)var5).a(var4);
            }
         }

         this.b.clear();
      }

      @Override
      public void a(View var1) {
         AccessibilityDelegate var2 = this.d(var1);
         if (!(var2 instanceof ViewVisitor.AddAccessibilityEventVisitor.TrackingAccessibilityDelegate)
            || !((ViewVisitor.AddAccessibilityEventVisitor.TrackingAccessibilityDelegate)var2).a(this.d())) {
            ViewVisitor.AddAccessibilityEventVisitor.TrackingAccessibilityDelegate var3 = new ViewVisitor.AddAccessibilityEventVisitor.TrackingAccessibilityDelegate(
               this, var2
            );
            var1.setAccessibilityDelegate(var3);
            this.b.put(var1, var3);
         }
      }

      private class TrackingAccessibilityDelegate extends AccessibilityDelegate {
         final ViewVisitor.AddAccessibilityEventVisitor a;
         private AccessibilityDelegate b;

         public TrackingAccessibilityDelegate(ViewVisitor.AddAccessibilityEventVisitor var1, AccessibilityDelegate var2) {
            this.a = var1;
            this.b = var2;
         }

         public AccessibilityDelegate a() {
            return this.b;
         }

         public void a(ViewVisitor.AddAccessibilityEventVisitor.TrackingAccessibilityDelegate var1) {
            if (this.b == var1) {
               this.b = var1.a();
            } else if (this.b instanceof ViewVisitor.AddAccessibilityEventVisitor.TrackingAccessibilityDelegate) {
               ((ViewVisitor.AddAccessibilityEventVisitor.TrackingAccessibilityDelegate)this.b).a(var1);
            }
         }

         public boolean a(String var1) {
            boolean var2;
            if (this.a.d() == var1) {
               var2 = true;
            } else if (this.b instanceof ViewVisitor.AddAccessibilityEventVisitor.TrackingAccessibilityDelegate) {
               var2 = ((ViewVisitor.AddAccessibilityEventVisitor.TrackingAccessibilityDelegate)this.b).a(var1);
            } else {
               var2 = false;
            }

            return var2;
         }

         public void sendAccessibilityEvent(View var1, int var2) {
            if (var2 == this.a.a) {
               this.a.c(var1);
            }

            if (this.b != null) {
               this.b.sendAccessibilityEvent(var1, var2);
            }
         }
      }
   }

   public static class AddTextChangeListener extends ViewVisitor.EventTriggeringVisitor {
      private final Map<TextView, TextWatcher> a = new HashMap<>();

      public AddTextChangeListener(List<Pathfinder.PathElement> var1, String var2, ViewVisitor.OnEventListener var3) {
         super(var1, var2, var3, true);
      }

      @Override
      public void a() {
         for (Entry var2 : this.a.entrySet()) {
            ((TextView)var2.getKey()).removeTextChangedListener((TextWatcher)var2.getValue());
         }

         this.a.clear();
      }

      @Override
      public void a(View var1) {
         if (var1 instanceof TextView) {
            TextView var4 = (TextView)var1;
            ViewVisitor.AddTextChangeListener.TrackingTextWatcher var2 = new ViewVisitor.AddTextChangeListener.TrackingTextWatcher(this, var4);
            TextWatcher var3 = this.a.get(var4);
            if (var3 != null) {
               var4.removeTextChangedListener(var3);
            }

            var4.addTextChangedListener(var2);
            this.a.put(var4, var2);
         }
      }

      private class TrackingTextWatcher implements TextWatcher {
         final ViewVisitor.AddTextChangeListener a;
         private final View b;

         public TrackingTextWatcher(ViewVisitor.AddTextChangeListener var1, View var2) {
            this.a = var1;
            this.b = var2;
         }

         public void afterTextChanged(Editable var1) {
            this.a.c(this.b);
         }

         public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
         }

         public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
         }
      }
   }

   private static class CycleDetector {
      private CycleDetector() {
      }

      private boolean a(TreeMap<View, List<View>> var1, View var2, List<View> var3) {
         boolean var6;
         if (var3.contains(var2)) {
            var6 = false;
         } else {
            if (var1.containsKey(var2)) {
               List var7 = (List)var1.remove(var2);
               var3.add(var2);
               int var5 = var7.size();

               for (int var4 = 0; var4 < var5; var4++) {
                  if (!this.a(var1, (View)var7.get(var4), var3)) {
                     var6 = false;
                     return var6;
                  }
               }

               var3.remove(var2);
            }

            var6 = true;
         }

         return var6;
      }

      public boolean a(TreeMap<View, List<View>> var1) {
         ArrayList var3 = new ArrayList();

         boolean var2;
         while (true) {
            if (!var1.isEmpty()) {
               if (this.a(var1, (View)var1.firstKey(), var3)) {
                  continue;
               }

               var2 = false;
               break;
            }

            var2 = true;
            break;
         }

         return var2;
      }
   }

   private abstract static class EventTriggeringVisitor extends ViewVisitor {
      private final ViewVisitor.OnEventListener a;
      private final String b;
      private final boolean c;

      public EventTriggeringVisitor(List<Pathfinder.PathElement> var1, String var2, ViewVisitor.OnEventListener var3, boolean var4) {
         super(var1);
         this.a = var3;
         this.b = var2;
         this.c = var4;
      }

      protected void c(View var1) {
         this.a.a(var1, this.b, this.c);
      }

      protected String d() {
         return this.b;
      }
   }

   public static class LayoutErrorMessage {
      private final String a;
      private final String b;

      public LayoutErrorMessage(String var1, String var2) {
         this.a = var1;
         this.b = var2;
      }

      public String a() {
         return this.a;
      }

      public String b() {
         return this.b;
      }
   }

   public static class LayoutRule {
      public final int a;
      public final int b;
      public final int c;

      public LayoutRule(int var1, int var2, int var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }
   }

   public static class LayoutUpdateVisitor extends ViewVisitor {
      private static final Set<Integer> d = new HashSet<>(Arrays.asList(0, 1, 5, 7));
      private static final Set<Integer> e = new HashSet<>(Arrays.asList(2, 3, 4, 6, 8));
      private final WeakHashMap<View, int[]> a = new WeakHashMap<>();
      private final List<ViewVisitor.LayoutRule> b;
      private final String c;
      private boolean f;
      private final ViewVisitor.OnLayoutErrorListener g;
      private final ViewVisitor.CycleDetector h;

      public LayoutUpdateVisitor(List<Pathfinder.PathElement> var1, List<ViewVisitor.LayoutRule> var2, String var3, ViewVisitor.OnLayoutErrorListener var4) {
         super(var1);
         this.b = var2;
         this.c = var3;
         this.f = true;
         this.g = var4;
         this.h = new ViewVisitor.CycleDetector();
      }

      private boolean a(Set<Integer> var1, SparseArray<View> var2) {
         TreeMap var7 = new TreeMap<>(new Comparator<View>(this) {
            final ViewVisitor.LayoutUpdateVisitor a;

            {
               this.a = var1;
            }

            public int a(View var1, View var2x) {
               int var3;
               if (var1 == var2x) {
                  var3 = 0;
               } else if (var1 == null) {
                  var3 = -1;
               } else if (var2x == null) {
                  var3 = 1;
               } else {
                  var3 = var2x.hashCode() - var1.hashCode();
               }

               return var3;
            }
         });
         int var4 = var2.size();

         for (int var3 = 0; var3 < var4; var3++) {
            View var9 = (View)var2.valueAt(var3);
            int[] var10 = ((LayoutParams)var9.getLayoutParams()).getRules();
            ArrayList var8 = new ArrayList();
            Iterator var6 = var1.iterator();

            while (var6.hasNext()) {
               int var5 = var10[var6.next()];
               if (var5 > 0 && var5 != var9.getId()) {
                  var8.add(var2.get(var5));
               }
            }

            var7.put(var9, var8);
         }

         return this.h.a(var7);
      }

      @Override
      public void a() {
         for (Entry var4 : this.a.entrySet()) {
            View var3 = (View)var4.getKey();
            int[] var6 = (int[])var4.getValue();
            LayoutParams var5 = (LayoutParams)var3.getLayoutParams();

            for (int var1 = 0; var1 < var6.length; var1++) {
               var5.addRule(var1, var6[var1]);
            }

            var3.setLayoutParams(var5);
         }

         this.f = false;
      }

      @Override
      public void a(View var1) {
         ViewGroup var9 = (ViewGroup)var1;
         SparseArray var5 = new SparseArray();
         int var3 = var9.getChildCount();

         for (int var2 = 0; var2 < var3; var2++) {
            View var6 = var9.getChildAt(var2);
            int var4 = var6.getId();
            if (var4 > 0) {
               var5.put(var4, var6);
            }
         }

         var3 = this.b.size();

         for (int var12 = 0; var12 < var3; var12++) {
            ViewVisitor.LayoutRule var8 = this.b.get(var12);
            View var14 = (View)var5.get(var8.a);
            if (var14 != null) {
               LayoutParams var7 = (LayoutParams)var14.getLayoutParams();
               int[] var10 = (int[])var7.getRules().clone();
               if (var10[var8.b] != var8.c) {
                  if (!this.a.containsKey(var14)) {
                     this.a.put(var14, var10);
                  }

                  var7.addRule(var8.b, var8.c);
                  Set var11;
                  if (d.contains(var8.b)) {
                     var11 = d;
                  } else if (e.contains(var8.b)) {
                     var11 = e;
                  } else {
                     var11 = null;
                  }

                  if (var11 != null && !this.a(var11, var5)) {
                     this.a();
                     this.g.a(new ViewVisitor.LayoutErrorMessage("circular_dependency", this.c));
                     break;
                  }

                  var14.setLayoutParams(var7);
               }
            }
         }
      }

      @Override
      public void b(View var1) {
         if (this.f) {
            this.c().a(var1, this.b(), this);
         }
      }
   }

   public interface OnEventListener {
      void a(View var1, String var2, boolean var3);
   }

   public interface OnLayoutErrorListener {
      void a(ViewVisitor.LayoutErrorMessage var1);
   }

   public static class PropertySetVisitor extends ViewVisitor {
      private final Caller a;
      private final Caller b;
      private final WeakHashMap<View, Object> c;
      private final Object[] d;

      public PropertySetVisitor(List<Pathfinder.PathElement> var1, Caller var2, Caller var3) {
         super(var1);
         this.a = var2;
         this.b = var3;
         this.d = new Object[1];
         this.c = new WeakHashMap<>();
      }

      @Override
      public void a() {
         for (Entry var3 : this.c.entrySet()) {
            View var1 = (View)var3.getKey();
            Object var4 = var3.getValue();
            if (var4 != null) {
               this.d[0] = var4;
               this.a.a(var1, this.d);
            }
         }
      }

      @Override
      public void a(View var1) {
         if (this.b != null) {
            Object[] var2 = this.a.a();
            if (1 == var2.length) {
               Object var3 = var2[0];
               Object var5 = this.b.a(var1);
               if (var3 == var5) {
                  return;
               }

               if (var3 != null) {
                  if (var3 instanceof Bitmap && var5 instanceof Bitmap) {
                     if (((Bitmap)var3).sameAs((Bitmap)var5)) {
                        return;
                     }
                  } else if (var3 instanceof BitmapDrawable && var5 instanceof BitmapDrawable) {
                     Bitmap var4 = ((BitmapDrawable)var3).getBitmap();
                     Bitmap var6 = ((BitmapDrawable)var5).getBitmap();
                     if (var4 != null && var4.sameAs(var6)) {
                        return;
                     }
                  } else if (var3.equals(var5)) {
                     return;
                  }
               }

               if (!(var5 instanceof Bitmap) && !(var5 instanceof BitmapDrawable) && !this.c.containsKey(var1)) {
                  this.d[0] = var5;
                  if (this.a.a(this.d)) {
                     this.c.put(var1, var5);
                  } else {
                     this.c.put(var1, null);
                  }
               }
            }
         }

         this.a.a(var1);
      }
   }

   public static class ViewDetectorVisitor extends ViewVisitor.EventTriggeringVisitor {
      private boolean a = false;

      public ViewDetectorVisitor(List<Pathfinder.PathElement> var1, String var2, ViewVisitor.OnEventListener var3) {
         super(var1, var2, var3, false);
      }

      @Override
      public void a() {
      }

      @Override
      public void a(View var1) {
         if (var1 != null && !this.a) {
            this.c(var1);
         }

         boolean var2;
         if (var1 != null) {
            var2 = true;
         } else {
            var2 = false;
         }

         this.a = var2;
      }
   }
}
