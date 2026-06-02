package android.support.v7.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.ShowableListMenu;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.View.AccessibilityDelegate;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow.OnDismissListener;

public class ActivityChooserView extends ViewGroup {
   final ActivityChooserView.ActivityChooserViewAdapter a;
   final FrameLayout b;
   final FrameLayout c;
   ActionProvider d;
   final DataSetObserver e = new DataSetObserver(this) {
      final ActivityChooserView a;

      {
         this.a = var1;
      }

      public void onChanged() {
         super.onChanged();
         this.a.a.notifyDataSetChanged();
      }

      public void onInvalidated() {
         super.onInvalidated();
         this.a.a.notifyDataSetInvalidated();
      }
   };
   OnDismissListener f;
   boolean g;
   int h;
   private final ActivityChooserView.Callbacks i;
   private final LinearLayoutCompat j;
   private final Drawable k;
   private final ImageView l;
   private final ImageView m;
   private final int n;
   private final OnGlobalLayoutListener o = new OnGlobalLayoutListener(this) {
      final ActivityChooserView a;

      {
         this.a = var1;
      }

      public void onGlobalLayout() {
         if (this.a.c()) {
            if (!this.a.isShown()) {
               this.a.getListPopupWindow().e();
            } else {
               this.a.getListPopupWindow().d();
               if (this.a.d != null) {
                  this.a.d.a(true);
               }
            }
         }
      }
   };
   private ListPopupWindow p;
   private boolean q;
   private int r;

   public ActivityChooserView(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public ActivityChooserView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.h = 4;
      TypedArray var4 = var1.obtainStyledAttributes(var2, R.styleable.ActivityChooserView, var3, 0);
      this.h = var4.getInt(R.styleable.ActivityChooserView_initialActivityCount, 4);
      Drawable var6 = var4.getDrawable(R.styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
      var4.recycle();
      LayoutInflater.from(this.getContext()).inflate(R.layout.abc_activity_chooser_view, this, true);
      this.i = new ActivityChooserView.Callbacks(this);
      this.j = (LinearLayoutCompat)this.findViewById(R.id.activity_chooser_view_content);
      this.k = this.j.getBackground();
      this.c = (FrameLayout)this.findViewById(R.id.default_activity_button);
      this.c.setOnClickListener(this.i);
      this.c.setOnLongClickListener(this.i);
      this.m = (ImageView)this.c.findViewById(R.id.image);
      FrameLayout var7 = (FrameLayout)this.findViewById(R.id.expand_activities_button);
      var7.setOnClickListener(this.i);
      var7.setAccessibilityDelegate(new AccessibilityDelegate(this) {
         final ActivityChooserView a;

         {
            this.a = var1;
         }

         public void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfo var2x) {
            super.onInitializeAccessibilityNodeInfo(var1, var2x);
            AccessibilityNodeInfoCompat.a(var2x).m(true);
         }
      });
      var7.setOnTouchListener(new ForwardingListener(this, var7) {
         final ActivityChooserView a;

         {
            this.a = var1;
         }

         @Override
         public ShowableListMenu a() {
            return this.a.getListPopupWindow();
         }

         @Override
         protected boolean b() {
            this.a.a();
            return true;
         }

         @Override
         protected boolean c() {
            this.a.b();
            return true;
         }
      });
      this.b = var7;
      this.l = (ImageView)var7.findViewById(R.id.image);
      this.l.setImageDrawable(var6);
      this.a = new ActivityChooserView.ActivityChooserViewAdapter(this);
      this.a.registerDataSetObserver(new DataSetObserver(this) {
         final ActivityChooserView a;

         {
            this.a = var1;
         }

         public void onChanged() {
            super.onChanged();
            this.a.d();
         }
      });
      Resources var5 = var1.getResources();
      this.n = Math.max(var5.getDisplayMetrics().widthPixels / 2, var5.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
   }

   void a(int var1) {
      if (this.a.e() == null) {
         throw new IllegalStateException("No data model. Did you call #setDataModel?");
      }

      this.getViewTreeObserver().addOnGlobalLayoutListener(this.o);
      boolean var4;
      if (this.c.getVisibility() == 0) {
         var4 = true;
      } else {
         var4 = false;
      }

      int var3 = this.a.c();
      byte var2;
      if (var4) {
         var2 = 1;
      } else {
         var2 = 0;
      }

      if (var1 != Integer.MAX_VALUE && var3 > var2 + var1) {
         this.a.a(true);
         this.a.a(var1 - 1);
      } else {
         this.a.a(false);
         this.a.a(var1);
      }

      ListPopupWindow var5 = this.getListPopupWindow();
      if (!var5.f()) {
         if (!this.g && var4) {
            this.a.a(false, false);
         } else {
            this.a.a(true, var4);
         }

         var5.g(Math.min(this.a.a(), this.n));
         var5.d();
         if (this.d != null) {
            this.d.a(true);
         }

         var5.g().setContentDescription(this.getContext().getString(R.string.abc_activitychooserview_choose_application));
         var5.g().setSelector(new ColorDrawable(0));
      }
   }

   public boolean a() {
      boolean var2 = false;
      boolean var1 = var2;
      if (!this.c()) {
         if (!this.q) {
            var1 = var2;
         } else {
            this.g = false;
            this.a(this.h);
            var1 = true;
         }
      }

      return var1;
   }

   public boolean b() {
      if (this.c()) {
         this.getListPopupWindow().e();
         ViewTreeObserver var1 = this.getViewTreeObserver();
         if (var1.isAlive()) {
            var1.removeGlobalOnLayoutListener(this.o);
         }
      }

      return true;
   }

   public boolean c() {
      return this.getListPopupWindow().f();
   }

   void d() {
      if (this.a.getCount() > 0) {
         this.b.setEnabled(true);
      } else {
         this.b.setEnabled(false);
      }

      int var1 = this.a.c();
      int var2 = this.a.d();
      if (var1 == 1 || var1 > 1 && var2 > 0) {
         this.c.setVisibility(0);
         ResolveInfo var4 = this.a.b();
         PackageManager var3 = this.getContext().getPackageManager();
         this.m.setImageDrawable(var4.loadIcon(var3));
         if (this.r != 0) {
            CharSequence var5 = var4.loadLabel(var3);
            String var6 = this.getContext().getString(this.r, new Object[]{var5});
            this.c.setContentDescription(var6);
         }
      } else {
         this.c.setVisibility(8);
      }

      if (this.c.getVisibility() == 0) {
         this.j.setBackgroundDrawable(this.k);
      } else {
         this.j.setBackgroundDrawable(null);
      }
   }

   public ActivityChooserModel getDataModel() {
      return this.a.e();
   }

   ListPopupWindow getListPopupWindow() {
      if (this.p == null) {
         this.p = new ListPopupWindow(this.getContext());
         this.p.a(this.a);
         this.p.b(this);
         this.p.a(true);
         this.p.a(this.i);
         this.p.a(this.i);
      }

      return this.p;
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      ActivityChooserModel var1 = this.a.e();
      if (var1 != null) {
         var1.registerObserver(this.e);
      }

      this.q = true;
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      ActivityChooserModel var1 = this.a.e();
      if (var1 != null) {
         var1.unregisterObserver(this.e);
      }

      ViewTreeObserver var2 = this.getViewTreeObserver();
      if (var2.isAlive()) {
         var2.removeGlobalOnLayoutListener(this.o);
      }

      if (this.c()) {
         this.b();
      }

      this.q = false;
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      this.j.layout(0, 0, var4 - var2, var5 - var3);
      if (!this.c()) {
         this.b();
      }
   }

   protected void onMeasure(int var1, int var2) {
      LinearLayoutCompat var4 = this.j;
      int var3 = var2;
      if (this.c.getVisibility() != 0) {
         var3 = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(var2), 1073741824);
      }

      this.measureChild(var4, var1, var3);
      this.setMeasuredDimension(var4.getMeasuredWidth(), var4.getMeasuredHeight());
   }

   public void setActivityChooserModel(ActivityChooserModel var1) {
      this.a.a(var1);
      if (this.c()) {
         this.b();
         this.a();
      }
   }

   public void setDefaultActionButtonContentDescription(int var1) {
      this.r = var1;
   }

   public void setExpandActivityOverflowButtonContentDescription(int var1) {
      String var2 = this.getContext().getString(var1);
      this.l.setContentDescription(var2);
   }

   public void setExpandActivityOverflowButtonDrawable(Drawable var1) {
      this.l.setImageDrawable(var1);
   }

   public void setInitialActivityCount(int var1) {
      this.h = var1;
   }

   public void setOnDismissListener(OnDismissListener var1) {
      this.f = var1;
   }

   public void setProvider(ActionProvider var1) {
      this.d = var1;
   }

   private class ActivityChooserViewAdapter extends BaseAdapter {
      final ActivityChooserView a;
      private ActivityChooserModel b;
      private int c;
      private boolean d;
      private boolean e;
      private boolean f;

      ActivityChooserViewAdapter(ActivityChooserView var1) {
         this.a = var1;
         this.c = 4;
      }

      public int a() {
         int var1 = 0;
         int var5 = this.c;
         this.c = Integer.MAX_VALUE;
         int var3 = MeasureSpec.makeMeasureSpec(0, 0);
         int var4 = MeasureSpec.makeMeasureSpec(0, 0);
         int var6 = this.getCount();
         View var7 = null;
         int var2 = 0;

         while (var1 < var6) {
            var7 = this.getView(var1, var7, null);
            var7.measure(var3, var4);
            var2 = Math.max(var2, var7.getMeasuredWidth());
            var1++;
         }

         this.c = var5;
         return var2;
      }

      public void a(int var1) {
         if (this.c != var1) {
            this.c = var1;
            this.notifyDataSetChanged();
         }
      }

      public void a(ActivityChooserModel var1) {
         ActivityChooserModel var2 = this.a.a.e();
         if (var2 != null && this.a.isShown()) {
            var2.unregisterObserver(this.a.e);
         }

         this.b = var1;
         if (var1 != null && this.a.isShown()) {
            var1.registerObserver(this.a.e);
         }

         this.notifyDataSetChanged();
      }

      public void a(boolean var1) {
         if (this.f != var1) {
            this.f = var1;
            this.notifyDataSetChanged();
         }
      }

      public void a(boolean var1, boolean var2) {
         if (this.d != var1 || this.e != var2) {
            this.d = var1;
            this.e = var2;
            this.notifyDataSetChanged();
         }
      }

      public ResolveInfo b() {
         return this.b.b();
      }

      public int c() {
         return this.b.a();
      }

      public int d() {
         return this.b.c();
      }

      public ActivityChooserModel e() {
         return this.b;
      }

      public boolean f() {
         return this.d;
      }

      public int getCount() {
         int var2 = this.b.a();
         int var1 = var2;
         if (!this.d) {
            var1 = var2;
            if (this.b.b() != null) {
               var1 = var2 - 1;
            }
         }

         var2 = Math.min(var1, this.c);
         var1 = var2;
         if (this.f) {
            var1 = var2 + 1;
         }

         return var1;
      }

      public Object getItem(int var1) {
         ResolveInfo var3;
         switch (this.getItemViewType(var1)) {
            case 0:
               int var2 = var1;
               if (!this.d) {
                  var2 = var1;
                  if (this.b.b() != null) {
                     var2 = var1 + 1;
                  }
               }

               var3 = this.b.a(var2);
               break;
            case 1:
               var3 = null;
               break;
            default:
               throw new IllegalArgumentException();
         }

         return var3;
      }

      public long getItemId(int var1) {
         return var1;
      }

      public int getItemViewType(int var1) {
         byte var2;
         if (this.f && var1 == this.getCount() - 1) {
            var2 = 1;
         } else {
            var2 = 0;
         }

         return var2;
      }

      public View getView(int var1, View var2, ViewGroup var3) {
         View var4;
         switch (this.getItemViewType(var1)) {
            case 0:
               label26: {
                  if (var2 != null) {
                     var4 = var2;
                     if (var2.getId() == R.id.list_item) {
                        break label26;
                     }
                  }

                  var4 = LayoutInflater.from(this.a.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, var3, false);
               }

               PackageManager var7 = this.a.getContext().getPackageManager();
               ImageView var5 = (ImageView)var4.findViewById(R.id.icon);
               ResolveInfo var6 = (ResolveInfo)this.getItem(var1);
               var5.setImageDrawable(var6.loadIcon(var7));
               ((TextView)var4.findViewById(R.id.title)).setText(var6.loadLabel(var7));
               if (this.d && var1 == 0 && this.e) {
                  var4.setActivated(true);
               } else {
                  var4.setActivated(false);
               }
               break;
            case 1:
               if (var2 != null) {
                  var4 = var2;
                  if (var2.getId() == 1) {
                     break;
                  }
               }

               var4 = LayoutInflater.from(this.a.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, var3, false);
               var4.setId(1);
               ((TextView)var4.findViewById(R.id.title)).setText(this.a.getContext().getString(R.string.abc_activity_chooser_view_see_all));
               break;
            default:
               throw new IllegalArgumentException();
         }

         return var4;
      }

      public int getViewTypeCount() {
         return 3;
      }
   }

   private class Callbacks implements OnClickListener, OnLongClickListener, OnItemClickListener, OnDismissListener {
      final ActivityChooserView a;

      Callbacks(ActivityChooserView var1) {
         this.a = var1;
      }

      private void a() {
         if (this.a.f != null) {
            this.a.f.onDismiss();
         }
      }

      public void onClick(View var1) {
         if (var1 == this.a.c) {
            this.a.b();
            ResolveInfo var3 = this.a.a.b();
            int var2 = this.a.a.e().a(var3);
            Intent var4 = this.a.a.e().b(var2);
            if (var4 != null) {
               var4.addFlags(524288);
               this.a.getContext().startActivity(var4);
            }
         } else {
            if (var1 != this.a.b) {
               throw new IllegalArgumentException();
            }

            this.a.g = false;
            this.a.a(this.a.h);
         }
      }

      public void onDismiss() {
         this.a();
         if (this.a.d != null) {
            this.a.d.a(false);
         }
      }

      public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
         switch (((ActivityChooserView.ActivityChooserViewAdapter)var1.getAdapter()).getItemViewType(var3)) {
            case 0:
               this.a.b();
               if (this.a.g) {
                  if (var3 > 0) {
                     this.a.a.e().c(var3);
                  }
               } else {
                  if (!this.a.a.f()) {
                     var3++;
                  }

                  Intent var6 = this.a.a.e().b(var3);
                  if (var6 != null) {
                     var6.addFlags(524288);
                     this.a.getContext().startActivity(var6);
                  }
               }
               break;
            case 1:
               this.a.a(Integer.MAX_VALUE);
               break;
            default:
               throw new IllegalArgumentException();
         }
      }

      public boolean onLongClick(View var1) {
         if (var1 == this.a.c) {
            if (this.a.a.getCount() > 0) {
               this.a.g = true;
               this.a.a(this.a.h);
            }

            return true;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   public static class InnerLayout extends LinearLayout {
      private static final int[] a = new int[]{16842964};

      public InnerLayout(Context var1, AttributeSet var2) {
         super(var1, var2);
         TintTypedArray var3 = TintTypedArray.a(var1, var2, a);
         this.setBackgroundDrawable(var3.a(0));
         var3.a();
      }
   }
}
