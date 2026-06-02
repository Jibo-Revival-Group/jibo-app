package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.CollapsibleActionView;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.SubMenuBuilder;
import android.text.Layout;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
   private static final String TAG = "Toolbar";
   private MenuPresenter.Callback mActionMenuPresenterCallback;
   int mButtonGravity;
   ImageButton mCollapseButtonView;
   private CharSequence mCollapseDescription;
   private Drawable mCollapseIcon;
   private boolean mCollapsible;
   private int mContentInsetEndWithActions;
   private int mContentInsetStartWithNavigation;
   private RtlSpacingHelper mContentInsets;
   private boolean mEatingHover;
   private boolean mEatingTouch;
   View mExpandedActionView;
   private Toolbar.ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
   private int mGravity = 8388627;
   private final ArrayList<View> mHiddenViews;
   private ImageView mLogoView;
   private int mMaxButtonHeight;
   private MenuBuilder.Callback mMenuBuilderCallback;
   private ActionMenuView mMenuView;
   private final ActionMenuView.OnMenuItemClickListener mMenuViewItemClickListener;
   private ImageButton mNavButtonView;
   Toolbar.OnMenuItemClickListener mOnMenuItemClickListener;
   private ActionMenuPresenter mOuterActionMenuPresenter;
   private Context mPopupContext;
   private int mPopupTheme;
   private final Runnable mShowOverflowMenuRunnable;
   private CharSequence mSubtitleText;
   private int mSubtitleTextAppearance;
   private int mSubtitleTextColor;
   private TextView mSubtitleTextView;
   private final int[] mTempMargins;
   private final ArrayList<View> mTempViews = new ArrayList<>();
   private int mTitleMarginBottom;
   private int mTitleMarginEnd;
   private int mTitleMarginStart;
   private int mTitleMarginTop;
   private CharSequence mTitleText;
   private int mTitleTextAppearance;
   private int mTitleTextColor;
   private TextView mTitleTextView;
   private ToolbarWidgetWrapper mWrapper;

   public Toolbar(Context var1) {
      this(var1, null);
   }

   public Toolbar(Context var1, AttributeSet var2) {
      this(var1, var2, R.attr.toolbarStyle);
   }

   public Toolbar(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.mHiddenViews = new ArrayList<>();
      this.mTempMargins = new int[2];
      this.mMenuViewItemClickListener = new ActionMenuView.OnMenuItemClickListener(this) {
         final Toolbar a;

         {
            this.a = var1;
         }

         @Override
         public boolean a(MenuItem var1) {
            boolean var2x;
            if (this.a.mOnMenuItemClickListener != null) {
               var2x = this.a.mOnMenuItemClickListener.a(var1);
            } else {
               var2x = false;
            }

            return var2x;
         }
      };
      this.mShowOverflowMenuRunnable = new Runnable(this) {
         final Toolbar a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            this.a.showOverflowMenu();
         }
      };
      TintTypedArray var7 = TintTypedArray.a(this.getContext(), var2, R.styleable.Toolbar, var3, 0);
      this.mTitleTextAppearance = var7.g(R.styleable.Toolbar_titleTextAppearance, 0);
      this.mSubtitleTextAppearance = var7.g(R.styleable.Toolbar_subtitleTextAppearance, 0);
      this.mGravity = var7.c(R.styleable.Toolbar_android_gravity, this.mGravity);
      this.mButtonGravity = var7.c(R.styleable.Toolbar_buttonGravity, 48);
      int var4 = var7.d(R.styleable.Toolbar_titleMargin, 0);
      var3 = var4;
      if (var7.g(R.styleable.Toolbar_titleMargins)) {
         var3 = var7.d(R.styleable.Toolbar_titleMargins, var4);
      }

      this.mTitleMarginBottom = var3;
      this.mTitleMarginTop = var3;
      this.mTitleMarginEnd = var3;
      this.mTitleMarginStart = var3;
      var3 = var7.d(R.styleable.Toolbar_titleMarginStart, -1);
      if (var3 >= 0) {
         this.mTitleMarginStart = var3;
      }

      var3 = var7.d(R.styleable.Toolbar_titleMarginEnd, -1);
      if (var3 >= 0) {
         this.mTitleMarginEnd = var3;
      }

      var3 = var7.d(R.styleable.Toolbar_titleMarginTop, -1);
      if (var3 >= 0) {
         this.mTitleMarginTop = var3;
      }

      var3 = var7.d(R.styleable.Toolbar_titleMarginBottom, -1);
      if (var3 >= 0) {
         this.mTitleMarginBottom = var3;
      }

      this.mMaxButtonHeight = var7.e(R.styleable.Toolbar_maxButtonHeight, -1);
      var3 = var7.d(R.styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
      int var5 = var7.d(R.styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
      var4 = var7.e(R.styleable.Toolbar_contentInsetLeft, 0);
      int var6 = var7.e(R.styleable.Toolbar_contentInsetRight, 0);
      this.ensureContentInsets();
      this.mContentInsets.b(var4, var6);
      if (var3 != Integer.MIN_VALUE || var5 != Integer.MIN_VALUE) {
         this.mContentInsets.a(var3, var5);
      }

      this.mContentInsetStartWithNavigation = var7.d(R.styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
      this.mContentInsetEndWithActions = var7.d(R.styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
      this.mCollapseIcon = var7.a(R.styleable.Toolbar_collapseIcon);
      this.mCollapseDescription = var7.c(R.styleable.Toolbar_collapseContentDescription);
      CharSequence var8 = var7.c(R.styleable.Toolbar_title);
      if (!TextUtils.isEmpty(var8)) {
         this.setTitle(var8);
      }

      CharSequence var9 = var7.c(R.styleable.Toolbar_subtitle);
      if (!TextUtils.isEmpty(var9)) {
         this.setSubtitle(var9);
      }

      this.mPopupContext = this.getContext();
      this.setPopupTheme(var7.g(R.styleable.Toolbar_popupTheme, 0));
      Drawable var10 = var7.a(R.styleable.Toolbar_navigationIcon);
      if (var10 != null) {
         this.setNavigationIcon(var10);
      }

      CharSequence var11 = var7.c(R.styleable.Toolbar_navigationContentDescription);
      if (!TextUtils.isEmpty(var11)) {
         this.setNavigationContentDescription(var11);
      }

      Drawable var12 = var7.a(R.styleable.Toolbar_logo);
      if (var12 != null) {
         this.setLogo(var12);
      }

      CharSequence var13 = var7.c(R.styleable.Toolbar_logoDescription);
      if (!TextUtils.isEmpty(var13)) {
         this.setLogoDescription(var13);
      }

      if (var7.g(R.styleable.Toolbar_titleTextColor)) {
         this.setTitleTextColor(var7.b(R.styleable.Toolbar_titleTextColor, -1));
      }

      if (var7.g(R.styleable.Toolbar_subtitleTextColor)) {
         this.setSubtitleTextColor(var7.b(R.styleable.Toolbar_subtitleTextColor, -1));
      }

      var7.a();
   }

   private void addCustomViewsWithGravity(List<View> var1, int var2) {
      boolean var3 = true;
      byte var4 = 0;
      if (ViewCompat.e(this) != 1) {
         var3 = false;
      }

      int var6 = this.getChildCount();
      int var5 = GravityCompat.a(var2, ViewCompat.e(this));
      var1.clear();
      var2 = var4;
      if (var3) {
         for (int var10 = var6 - 1; var10 >= 0; var10--) {
            View var11 = this.getChildAt(var10);
            Toolbar.LayoutParams var12 = (Toolbar.LayoutParams)var11.getLayoutParams();
            if (var12.b == 0 && this.shouldLayout(var11) && this.getChildHorizontalGravity(var12.a) == var5) {
               var1.add(var11);
            }
         }
      } else {
         for (; var2 < var6; var2++) {
            View var7 = this.getChildAt(var2);
            Toolbar.LayoutParams var8 = (Toolbar.LayoutParams)var7.getLayoutParams();
            if (var8.b == 0 && this.shouldLayout(var7) && this.getChildHorizontalGravity(var8.a) == var5) {
               var1.add(var7);
            }
         }
      }
   }

   private void addSystemView(View var1, boolean var2) {
      android.view.ViewGroup.LayoutParams var3 = var1.getLayoutParams();
      Toolbar.LayoutParams var4;
      if (var3 == null) {
         var4 = this.generateDefaultLayoutParams();
      } else if (!this.checkLayoutParams(var3)) {
         var4 = this.generateLayoutParams(var3);
      } else {
         var4 = (Toolbar.LayoutParams)var3;
      }

      var4.b = 1;
      if (var2 && this.mExpandedActionView != null) {
         var1.setLayoutParams(var4);
         this.mHiddenViews.add(var1);
      } else {
         this.addView(var1, var4);
      }
   }

   private void ensureContentInsets() {
      if (this.mContentInsets == null) {
         this.mContentInsets = new RtlSpacingHelper();
      }
   }

   private void ensureLogoView() {
      if (this.mLogoView == null) {
         this.mLogoView = new AppCompatImageView(this.getContext());
      }
   }

   private void ensureMenu() {
      this.ensureMenuView();
      if (this.mMenuView.d() == null) {
         MenuBuilder var1 = (MenuBuilder)this.mMenuView.getMenu();
         if (this.mExpandedMenuPresenter == null) {
            this.mExpandedMenuPresenter = new Toolbar.ExpandedActionViewMenuPresenter(this);
         }

         this.mMenuView.setExpandedActionViewsExclusive(true);
         var1.a(this.mExpandedMenuPresenter, this.mPopupContext);
      }
   }

   private void ensureMenuView() {
      if (this.mMenuView == null) {
         this.mMenuView = new ActionMenuView(this.getContext());
         this.mMenuView.setPopupTheme(this.mPopupTheme);
         this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
         this.mMenuView.a(this.mActionMenuPresenterCallback, this.mMenuBuilderCallback);
         Toolbar.LayoutParams var1 = this.generateDefaultLayoutParams();
         var1.a = 8388613 | this.mButtonGravity & 112;
         this.mMenuView.setLayoutParams(var1);
         this.addSystemView(this.mMenuView, false);
      }
   }

   private void ensureNavButtonView() {
      if (this.mNavButtonView == null) {
         this.mNavButtonView = new AppCompatImageButton(this.getContext(), null, R.attr.toolbarNavigationButtonStyle);
         Toolbar.LayoutParams var1 = this.generateDefaultLayoutParams();
         var1.a = 8388611 | this.mButtonGravity & 112;
         this.mNavButtonView.setLayoutParams(var1);
      }
   }

   private int getChildHorizontalGravity(int var1) {
      int var3 = ViewCompat.e(this);
      int var2 = GravityCompat.a(var1, var3) & 7;
      var1 = var2;
      switch (var2) {
         case 2:
         case 4:
         default:
            if (var3 == 1) {
               var1 = 5;
            } else {
               var1 = 3;
            }
         case 1:
         case 3:
         case 5:
            return var1;
      }
   }

   private int getChildTop(View var1, int var2) {
      Toolbar.LayoutParams var7 = (Toolbar.LayoutParams)var1.getLayoutParams();
      int var4 = var1.getMeasuredHeight();
      if (var2 > 0) {
         var2 = (var4 - var2) / 2;
      } else {
         var2 = 0;
      }

      switch (this.getChildVerticalGravity(var7.a)) {
         case 48:
            var2 = this.getPaddingTop() - var2;
            break;
         case 80:
            var2 = this.getHeight() - this.getPaddingBottom() - var4 - var7.bottomMargin - var2;
            break;
         default:
            int var3 = this.getPaddingTop();
            int var5 = this.getPaddingBottom();
            int var6 = this.getHeight();
            var2 = (var6 - var3 - var5 - var4) / 2;
            if (var2 < var7.topMargin) {
               var2 = var7.topMargin;
            } else {
               var4 = var6 - var5 - var4 - var2 - var3;
               if (var4 < var7.bottomMargin) {
                  var2 = Math.max(0, var2 - (var7.bottomMargin - var4));
               }
            }

            var2 += var3;
      }

      return var2;
   }

   private int getChildVerticalGravity(int var1) {
      int var2 = var1 & 112;
      var1 = var2;
      switch (var2) {
         default:
            var1 = this.mGravity & 112;
         case 16:
         case 48:
         case 80:
            return var1;
      }
   }

   private int getHorizontalMargins(View var1) {
      MarginLayoutParams var3 = (MarginLayoutParams)var1.getLayoutParams();
      int var2 = MarginLayoutParamsCompat.a(var3);
      return MarginLayoutParamsCompat.b(var3) + var2;
   }

   private MenuInflater getMenuInflater() {
      return new SupportMenuInflater(this.getContext());
   }

   private int getVerticalMargins(View var1) {
      MarginLayoutParams var3 = (MarginLayoutParams)var1.getLayoutParams();
      int var2 = var3.topMargin;
      return var3.bottomMargin + var2;
   }

   private int getViewListMeasuredWidth(List<View> var1, int[] var2) {
      int var6 = var2[0];
      int var5 = var2[1];
      int var7 = var1.size();
      int var4 = 0;
      int var3 = 0;

      while (var4 < var7) {
         View var12 = (View)var1.get(var4);
         Toolbar.LayoutParams var11 = (Toolbar.LayoutParams)var12.getLayoutParams();
         var6 = var11.leftMargin - var6;
         var5 = var11.rightMargin - var5;
         int var8 = Math.max(0, var6);
         int var9 = Math.max(0, var5);
         var6 = Math.max(0, -var6);
         var5 = Math.max(0, -var5);
         int var10 = var12.getMeasuredWidth();
         var4++;
         var3 += var10 + var8 + var9;
      }

      return var3;
   }

   private boolean isChildOrHidden(View var1) {
      boolean var2;
      if (var1.getParent() != this && !this.mHiddenViews.contains(var1)) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   private static boolean isCustomView(View var0) {
      boolean var1;
      if (((Toolbar.LayoutParams)var0.getLayoutParams()).b == 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private int layoutChildLeft(View var1, int var2, int[] var3, int var4) {
      Toolbar.LayoutParams var6 = (Toolbar.LayoutParams)var1.getLayoutParams();
      int var5 = var6.leftMargin - var3[0];
      var2 = Math.max(0, var5) + var2;
      var3[0] = Math.max(0, -var5);
      var5 = this.getChildTop(var1, var4);
      var4 = var1.getMeasuredWidth();
      var1.layout(var2, var5, var2 + var4, var1.getMeasuredHeight() + var5);
      return var6.rightMargin + var4 + var2;
   }

   private int layoutChildRight(View var1, int var2, int[] var3, int var4) {
      Toolbar.LayoutParams var6 = (Toolbar.LayoutParams)var1.getLayoutParams();
      int var5 = var6.rightMargin - var3[1];
      var2 -= Math.max(0, var5);
      var3[1] = Math.max(0, -var5);
      var4 = this.getChildTop(var1, var4);
      var5 = var1.getMeasuredWidth();
      var1.layout(var2 - var5, var4, var2, var1.getMeasuredHeight() + var4);
      return var2 - (var6.leftMargin + var5);
   }

   private int measureChildCollapseMargins(View var1, int var2, int var3, int var4, int var5, int[] var6) {
      MarginLayoutParams var10 = (MarginLayoutParams)var1.getLayoutParams();
      int var8 = var10.leftMargin - var6[0];
      int var7 = var10.rightMargin - var6[1];
      int var9 = Math.max(0, var8) + Math.max(0, var7);
      var6[0] = Math.max(0, -var8);
      var6[1] = Math.max(0, -var7);
      var1.measure(
         getChildMeasureSpec(var2, this.getPaddingLeft() + this.getPaddingRight() + var9 + var3, var10.width),
         getChildMeasureSpec(var4, this.getPaddingTop() + this.getPaddingBottom() + var10.topMargin + var10.bottomMargin + var5, var10.height)
      );
      return var1.getMeasuredWidth() + var9;
   }

   private void measureChildConstrained(View var1, int var2, int var3, int var4, int var5, int var6) {
      MarginLayoutParams var8 = (MarginLayoutParams)var1.getLayoutParams();
      int var7 = getChildMeasureSpec(var2, this.getPaddingLeft() + this.getPaddingRight() + var8.leftMargin + var8.rightMargin + var3, var8.width);
      var3 = getChildMeasureSpec(var4, this.getPaddingTop() + this.getPaddingBottom() + var8.topMargin + var8.bottomMargin + var5, var8.height);
      var4 = MeasureSpec.getMode(var3);
      var2 = var3;
      if (var4 != 1073741824) {
         var2 = var3;
         if (var6 >= 0) {
            var2 = var6;
            if (var4 != 0) {
               var2 = Math.min(MeasureSpec.getSize(var3), var6);
            }

            var2 = MeasureSpec.makeMeasureSpec(var2, 1073741824);
         }
      }

      var1.measure(var7, var2);
   }

   private void postShowOverflowMenu() {
      this.removeCallbacks(this.mShowOverflowMenuRunnable);
      this.post(this.mShowOverflowMenuRunnable);
   }

   private boolean shouldCollapse() {
      boolean var4 = false;
      boolean var3;
      if (!this.mCollapsible) {
         var3 = var4;
      } else {
         int var2 = this.getChildCount();
         int var1 = 0;

         while (true) {
            if (var1 >= var2) {
               var3 = true;
               break;
            }

            View var5 = this.getChildAt(var1);
            if (this.shouldLayout(var5) && var5.getMeasuredWidth() > 0) {
               var3 = var4;
               if (var5.getMeasuredHeight() > 0) {
                  break;
               }
            }

            var1++;
         }
      }

      return var3;
   }

   private boolean shouldLayout(View var1) {
      boolean var2;
      if (var1 != null && var1.getParent() == this && var1.getVisibility() != 8) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   void addChildrenForExpandedActionView() {
      for (int var1 = this.mHiddenViews.size() - 1; var1 >= 0; var1--) {
         this.addView(this.mHiddenViews.get(var1));
      }

      this.mHiddenViews.clear();
   }

   public boolean canShowOverflowMenu() {
      boolean var1;
      if (this.getVisibility() == 0 && this.mMenuView != null && this.mMenuView.a()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      boolean var2;
      if (super.checkLayoutParams(var1) && var1 instanceof Toolbar.LayoutParams) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public void collapseActionView() {
      MenuItemImpl var1;
      if (this.mExpandedMenuPresenter == null) {
         var1 = null;
      } else {
         var1 = this.mExpandedMenuPresenter.b;
      }

      if (var1 != null) {
         var1.collapseActionView();
      }
   }

   public void dismissPopupMenus() {
      if (this.mMenuView != null) {
         this.mMenuView.i();
      }
   }

   void ensureCollapseButtonView() {
      if (this.mCollapseButtonView == null) {
         this.mCollapseButtonView = new AppCompatImageButton(this.getContext(), null, R.attr.toolbarNavigationButtonStyle);
         this.mCollapseButtonView.setImageDrawable(this.mCollapseIcon);
         this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
         Toolbar.LayoutParams var1 = this.generateDefaultLayoutParams();
         var1.a = 8388611 | this.mButtonGravity & 112;
         var1.b = 2;
         this.mCollapseButtonView.setLayoutParams(var1);
         this.mCollapseButtonView.setOnClickListener(new OnClickListener(this) {
            final Toolbar a;

            {
               this.a = var1;
            }

            public void onClick(View var1) {
               this.a.collapseActionView();
            }
         });
      }
   }

   protected Toolbar.LayoutParams generateDefaultLayoutParams() {
      return new Toolbar.LayoutParams(-2, -2);
   }

   public Toolbar.LayoutParams generateLayoutParams(AttributeSet var1) {
      return new Toolbar.LayoutParams(this.getContext(), var1);
   }

   protected Toolbar.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      Toolbar.LayoutParams var2;
      if (var1 instanceof Toolbar.LayoutParams) {
         var2 = new Toolbar.LayoutParams((Toolbar.LayoutParams)var1);
      } else if (var1 instanceof ActionBar.LayoutParams) {
         var2 = new Toolbar.LayoutParams((ActionBar.LayoutParams)var1);
      } else if (var1 instanceof MarginLayoutParams) {
         var2 = new Toolbar.LayoutParams((MarginLayoutParams)var1);
      } else {
         var2 = new Toolbar.LayoutParams(var1);
      }

      return var2;
   }

   public int getContentInsetEnd() {
      int var1;
      if (this.mContentInsets != null) {
         var1 = this.mContentInsets.d();
      } else {
         var1 = 0;
      }

      return var1;
   }

   public int getContentInsetEndWithActions() {
      int var1;
      if (this.mContentInsetEndWithActions != Integer.MIN_VALUE) {
         var1 = this.mContentInsetEndWithActions;
      } else {
         var1 = this.getContentInsetEnd();
      }

      return var1;
   }

   public int getContentInsetLeft() {
      int var1;
      if (this.mContentInsets != null) {
         var1 = this.mContentInsets.a();
      } else {
         var1 = 0;
      }

      return var1;
   }

   public int getContentInsetRight() {
      int var1;
      if (this.mContentInsets != null) {
         var1 = this.mContentInsets.b();
      } else {
         var1 = 0;
      }

      return var1;
   }

   public int getContentInsetStart() {
      int var1;
      if (this.mContentInsets != null) {
         var1 = this.mContentInsets.c();
      } else {
         var1 = 0;
      }

      return var1;
   }

   public int getContentInsetStartWithNavigation() {
      int var1;
      if (this.mContentInsetStartWithNavigation != Integer.MIN_VALUE) {
         var1 = this.mContentInsetStartWithNavigation;
      } else {
         var1 = this.getContentInsetStart();
      }

      return var1;
   }

   public int getCurrentContentInsetEnd() {
      boolean var1;
      if (this.mMenuView != null) {
         MenuBuilder var2 = this.mMenuView.d();
         if (var2 != null && var2.hasVisibleItems()) {
            var1 = 1;
         } else {
            var1 = 0;
         }
      } else {
         var1 = 0;
      }

      if (var1) {
         var1 = Math.max(this.getContentInsetEnd(), Math.max(this.mContentInsetEndWithActions, 0));
      } else {
         var1 = this.getContentInsetEnd();
      }

      return var1;
   }

   public int getCurrentContentInsetLeft() {
      int var1;
      if (ViewCompat.e(this) == 1) {
         var1 = this.getCurrentContentInsetEnd();
      } else {
         var1 = this.getCurrentContentInsetStart();
      }

      return var1;
   }

   public int getCurrentContentInsetRight() {
      int var1;
      if (ViewCompat.e(this) == 1) {
         var1 = this.getCurrentContentInsetStart();
      } else {
         var1 = this.getCurrentContentInsetEnd();
      }

      return var1;
   }

   public int getCurrentContentInsetStart() {
      int var1;
      if (this.getNavigationIcon() != null) {
         var1 = Math.max(this.getContentInsetStart(), Math.max(this.mContentInsetStartWithNavigation, 0));
      } else {
         var1 = this.getContentInsetStart();
      }

      return var1;
   }

   public Drawable getLogo() {
      Drawable var1;
      if (this.mLogoView != null) {
         var1 = this.mLogoView.getDrawable();
      } else {
         var1 = null;
      }

      return var1;
   }

   public CharSequence getLogoDescription() {
      CharSequence var1;
      if (this.mLogoView != null) {
         var1 = this.mLogoView.getContentDescription();
      } else {
         var1 = null;
      }

      return var1;
   }

   public Menu getMenu() {
      this.ensureMenu();
      return this.mMenuView.getMenu();
   }

   public CharSequence getNavigationContentDescription() {
      CharSequence var1;
      if (this.mNavButtonView != null) {
         var1 = this.mNavButtonView.getContentDescription();
      } else {
         var1 = null;
      }

      return var1;
   }

   public Drawable getNavigationIcon() {
      Drawable var1;
      if (this.mNavButtonView != null) {
         var1 = this.mNavButtonView.getDrawable();
      } else {
         var1 = null;
      }

      return var1;
   }

   ActionMenuPresenter getOuterActionMenuPresenter() {
      return this.mOuterActionMenuPresenter;
   }

   public Drawable getOverflowIcon() {
      this.ensureMenu();
      return this.mMenuView.getOverflowIcon();
   }

   Context getPopupContext() {
      return this.mPopupContext;
   }

   public int getPopupTheme() {
      return this.mPopupTheme;
   }

   public CharSequence getSubtitle() {
      return this.mSubtitleText;
   }

   public CharSequence getTitle() {
      return this.mTitleText;
   }

   public int getTitleMarginBottom() {
      return this.mTitleMarginBottom;
   }

   public int getTitleMarginEnd() {
      return this.mTitleMarginEnd;
   }

   public int getTitleMarginStart() {
      return this.mTitleMarginStart;
   }

   public int getTitleMarginTop() {
      return this.mTitleMarginTop;
   }

   public DecorToolbar getWrapper() {
      if (this.mWrapper == null) {
         this.mWrapper = new ToolbarWidgetWrapper(this, true);
      }

      return this.mWrapper;
   }

   public boolean hasExpandedActionView() {
      boolean var1;
      if (this.mExpandedMenuPresenter != null && this.mExpandedMenuPresenter.b != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean hideOverflowMenu() {
      boolean var1;
      if (this.mMenuView != null && this.mMenuView.f()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public void inflateMenu(int var1) {
      this.getMenuInflater().inflate(var1, this.getMenu());
   }

   public boolean isOverflowMenuShowPending() {
      boolean var1;
      if (this.mMenuView != null && this.mMenuView.h()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean isOverflowMenuShowing() {
      boolean var1;
      if (this.mMenuView != null && this.mMenuView.g()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean isTitleTruncated() {
      boolean var4 = false;
      boolean var3;
      if (this.mTitleTextView == null) {
         var3 = var4;
      } else {
         Layout var5 = this.mTitleTextView.getLayout();
         var3 = var4;
         if (var5 != null) {
            int var2 = var5.getLineCount();
            int var1 = 0;

            while (true) {
               var3 = var4;
               if (var1 >= var2) {
                  break;
               }

               if (var5.getEllipsisCount(var1) > 0) {
                  var3 = true;
                  break;
               }

               var1++;
            }
         }
      }

      return var3;
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.removeCallbacks(this.mShowOverflowMenuRunnable);
   }

   public boolean onHoverEvent(MotionEvent var1) {
      int var2 = var1.getActionMasked();
      if (var2 == 9) {
         this.mEatingHover = false;
      }

      if (!this.mEatingHover) {
         boolean var3 = super.onHoverEvent(var1);
         if (var2 == 9 && !var3) {
            this.mEatingHover = true;
         }
      }

      if (var2 == 10 || var2 == 3) {
         this.mEatingHover = false;
      }

      return true;
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      boolean var8;
      if (ViewCompat.e(this) == 1) {
         var8 = 1;
      } else {
         var8 = 0;
      }

      int var11 = this.getWidth();
      int var15 = this.getHeight();
      int var7 = this.getPaddingLeft();
      int var12 = this.getPaddingRight();
      int var13 = this.getPaddingTop();
      int var14 = this.getPaddingBottom();
      var2 = var11 - var12;
      int[] var19 = this.mTempMargins;
      var19[1] = 0;
      var19[0] = 0;
      var4 = ViewCompat.k(this);
      int var6;
      if (var4 >= 0) {
         var6 = Math.min(var4, var5 - var3);
      } else {
         var6 = 0;
      }

      if (this.shouldLayout(this.mNavButtonView)) {
         if (var8) {
            var2 = this.layoutChildRight(this.mNavButtonView, var2, var19, var6);
            var3 = var7;
         } else {
            var3 = this.layoutChildLeft(this.mNavButtonView, var7, var19, var6);
         }
      } else {
         var3 = var7;
      }

      var4 = var2;
      var5 = var3;
      if (this.shouldLayout(this.mCollapseButtonView)) {
         if (var8) {
            var4 = this.layoutChildRight(this.mCollapseButtonView, var2, var19, var6);
            var5 = var3;
         } else {
            var5 = this.layoutChildLeft(this.mCollapseButtonView, var3, var19, var6);
            var4 = var2;
         }
      }

      var2 = var4;
      var3 = var5;
      if (this.shouldLayout(this.mMenuView)) {
         if (var8) {
            var3 = this.layoutChildLeft(this.mMenuView, var5, var19, var6);
            var2 = var4;
         } else {
            var2 = this.layoutChildRight(this.mMenuView, var4, var19, var6);
            var3 = var5;
         }
      }

      var4 = this.getCurrentContentInsetLeft();
      var5 = this.getCurrentContentInsetRight();
      var19[0] = Math.max(0, var4 - var3);
      var19[1] = Math.max(0, var5 - (var11 - var12 - var2));
      var4 = Math.max(var3, var4);
      var5 = Math.min(var2, var11 - var12 - var5);
      var3 = var5;
      var2 = var4;
      if (this.shouldLayout(this.mExpandedActionView)) {
         if (var8) {
            var3 = this.layoutChildRight(this.mExpandedActionView, var5, var19, var6);
            var2 = var4;
         } else {
            var2 = this.layoutChildLeft(this.mExpandedActionView, var4, var19, var6);
            var3 = var5;
         }
      }

      if (this.shouldLayout(this.mLogoView)) {
         if (var8) {
            var4 = this.layoutChildRight(this.mLogoView, var3, var19, var6);
            var3 = var2;
         } else {
            var2 = this.layoutChildLeft(this.mLogoView, var2, var19, var6);
            var4 = var3;
            var3 = var2;
         }
      } else {
         var4 = var3;
         var3 = var2;
      }

      var1 = this.shouldLayout(this.mTitleTextView);
      boolean var16 = this.shouldLayout(this.mSubtitleTextView);
      var2 = 0;
      if (var1) {
         Toolbar.LayoutParams var17 = (Toolbar.LayoutParams)this.mTitleTextView.getLayoutParams();
         var2 = var17.topMargin;
         var5 = this.mTitleTextView.getMeasuredHeight();
         var2 = 0 + var17.bottomMargin + var2 + var5;
      }

      int var10;
      if (var16) {
         Toolbar.LayoutParams var87 = (Toolbar.LayoutParams)this.mSubtitleTextView.getLayoutParams();
         var5 = var87.topMargin;
         int var9 = this.mSubtitleTextView.getMeasuredHeight();
         var10 = var87.bottomMargin + var5 + var9 + var2;
      } else {
         var10 = var2;
      }

      label189: {
         if (!var1) {
            var5 = var4;
            var2 = var3;
            if (!var16) {
               break label189;
            }
         }

         TextView var88;
         if (var1) {
            var88 = this.mTitleTextView;
         } else {
            var88 = this.mSubtitleTextView;
         }

         TextView var18;
         if (var16) {
            var18 = this.mSubtitleTextView;
         } else {
            var18 = this.mTitleTextView;
         }

         Toolbar.LayoutParams var89 = (Toolbar.LayoutParams)var88.getLayoutParams();
         Toolbar.LayoutParams var94 = (Toolbar.LayoutParams)var18.getLayoutParams();
         boolean var80;
         if ((!var1 || this.mTitleTextView.getMeasuredWidth() <= 0) && (!var16 || this.mSubtitleTextView.getMeasuredWidth() <= 0)) {
            var80 = false;
         } else {
            var80 = true;
         }

         switch (this.mGravity & 112) {
            case 48:
               var2 = this.getPaddingTop();
               var2 = var89.topMargin + var2 + this.mTitleMarginTop;
               break;
            case 80:
               var2 = var15 - var14 - var94.bottomMargin - this.mTitleMarginBottom - var10;
               break;
            default:
               var2 = (var15 - var13 - var14 - var10) / 2;
               if (var2 < var89.topMargin + this.mTitleMarginTop) {
                  var2 = var89.topMargin + this.mTitleMarginTop;
               } else {
                  var5 = var15 - var14 - var10 - var2 - var13;
                  if (var5 < var89.bottomMargin + this.mTitleMarginBottom) {
                     var2 = Math.max(0, var2 - (var94.bottomMargin + this.mTitleMarginBottom - var5));
                  }
               }

               var2 = var13 + var2;
         }

         if (var8) {
            if (var80) {
               var5 = this.mTitleMarginStart;
            } else {
               var5 = 0;
            }

            var5 -= var19[1];
            var4 -= Math.max(0, var5);
            var19[1] = Math.max(0, -var5);
            if (var1) {
               Toolbar.LayoutParams var90 = (Toolbar.LayoutParams)this.mTitleTextView.getLayoutParams();
               var5 = var4 - this.mTitleTextView.getMeasuredWidth();
               var8 = this.mTitleTextView.getMeasuredHeight() + var2;
               this.mTitleTextView.layout(var5, var2, var4, var8);
               var10 = this.mTitleMarginEnd;
               var2 = var8 + var90.bottomMargin;
               var5 -= var10;
            } else {
               var5 = var4;
            }

            if (var16) {
               Toolbar.LayoutParams var91 = (Toolbar.LayoutParams)this.mSubtitleTextView.getLayoutParams();
               var8 = var91.topMargin + var2;
               var10 = this.mSubtitleTextView.getMeasuredWidth();
               var2 = this.mSubtitleTextView.getMeasuredHeight() + var8;
               this.mSubtitleTextView.layout(var4 - var10, var8, var4, var2);
               var8 = this.mTitleMarginEnd;
               var2 = var91.bottomMargin;
               var2 = var4 - var8;
            } else {
               var2 = var4;
            }

            if (var80) {
               var2 = Math.min(var5, var2);
            } else {
               var2 = var4;
            }

            var5 = var2;
            var2 = var3;
         } else {
            if (var80) {
               var5 = this.mTitleMarginStart;
            } else {
               var5 = 0;
            }

            var5 -= var19[0];
            var3 += Math.max(0, var5);
            var19[0] = Math.max(0, -var5);
            if (var1) {
               Toolbar.LayoutParams var92 = (Toolbar.LayoutParams)this.mTitleTextView.getLayoutParams();
               var8 = this.mTitleTextView.getMeasuredWidth() + var3;
               var5 = this.mTitleTextView.getMeasuredHeight() + var2;
               this.mTitleTextView.layout(var3, var2, var8, var5);
               var10 = this.mTitleMarginEnd;
               var2 = var92.bottomMargin;
               var8 += var10;
               var2 += var5;
            } else {
               var8 = var3;
            }

            if (var16) {
               Toolbar.LayoutParams var93 = (Toolbar.LayoutParams)this.mSubtitleTextView.getLayoutParams();
               var10 = var2 + var93.topMargin;
               var2 = this.mSubtitleTextView.getMeasuredWidth() + var3;
               var5 = this.mSubtitleTextView.getMeasuredHeight() + var10;
               this.mSubtitleTextView.layout(var3, var10, var2, var5);
               var10 = this.mTitleMarginEnd;
               var5 = var93.bottomMargin;
               var10 += var2;
            } else {
               var10 = var3;
            }

            var5 = var4;
            var2 = var3;
            if (var80) {
               var2 = Math.max(var8, var10);
               var5 = var4;
            }
         }
      }

      this.addCustomViewsWithGravity(this.mTempViews, 3);
      var4 = this.mTempViews.size();

      for (int var43 = 0; var43 < var4; var43++) {
         var2 = this.layoutChildLeft(this.mTempViews.get(var43), var2, var19, var6);
      }

      this.addCustomViewsWithGravity(this.mTempViews, 5);
      var4 = this.mTempViews.size();

      for (int var44 = 0; var44 < var4; var44++) {
         var5 = this.layoutChildRight(this.mTempViews.get(var44), var5, var19, var6);
      }

      this.addCustomViewsWithGravity(this.mTempViews, 1);
      var4 = this.getViewListMeasuredWidth(this.mTempViews, var19);
      var3 = (var11 - var7 - var12) / 2 + var7 - var4 / 2;
      var4 += var3;
      if (var3 >= var2) {
         var2 = var3;
         if (var4 > var5) {
            var2 = var3 - (var4 - var5);
         }
      }

      var5 = this.mTempViews.size();
      byte var57 = 0;
      var3 = var2;

      for (int var37 = var57; var37 < var5; var37++) {
         var3 = this.layoutChildLeft(this.mTempViews.get(var37), var3, var19, var6);
      }

      this.mTempViews.clear();
   }

   protected void onMeasure(int var1, int var2) {
      int var6 = 0;
      int var5 = 0;
      int[] var13 = this.mTempMargins;
      byte var7;
      byte var8;
      if (ViewUtils.a(this)) {
         var7 = 0;
         var8 = 1;
      } else {
         var7 = 1;
         var8 = 0;
      }

      int var3 = 0;
      if (this.shouldLayout(this.mNavButtonView)) {
         this.measureChildConstrained(this.mNavButtonView, var1, 0, var2, 0, this.mMaxButtonHeight);
         var3 = this.mNavButtonView.getMeasuredWidth() + this.getHorizontalMargins(this.mNavButtonView);
         var6 = Math.max(0, this.mNavButtonView.getMeasuredHeight() + this.getVerticalMargins(this.mNavButtonView));
         var5 = View.combineMeasuredStates(0, this.mNavButtonView.getMeasuredState());
      }

      int var9 = var3;
      var3 = var5;
      int var4 = var6;
      if (this.shouldLayout(this.mCollapseButtonView)) {
         this.measureChildConstrained(this.mCollapseButtonView, var1, 0, var2, 0, this.mMaxButtonHeight);
         var9 = this.mCollapseButtonView.getMeasuredWidth() + this.getHorizontalMargins(this.mCollapseButtonView);
         var4 = Math.max(var6, this.mCollapseButtonView.getMeasuredHeight() + this.getVerticalMargins(this.mCollapseButtonView));
         var3 = View.combineMeasuredStates(var5, this.mCollapseButtonView.getMeasuredState());
      }

      var5 = this.getCurrentContentInsetStart();
      int var10 = 0 + Math.max(var5, var9);
      var13[var8] = Math.max(0, var5 - var9);
      var8 = 0;
      var6 = var3;
      var5 = var4;
      if (this.shouldLayout(this.mMenuView)) {
         this.measureChildConstrained(this.mMenuView, var1, var10, var2, 0, this.mMaxButtonHeight);
         var8 = this.mMenuView.getMeasuredWidth() + this.getHorizontalMargins(this.mMenuView);
         var5 = Math.max(var4, this.mMenuView.getMeasuredHeight() + this.getVerticalMargins(this.mMenuView));
         var6 = View.combineMeasuredStates(var3, this.mMenuView.getMeasuredState());
      }

      var3 = this.getCurrentContentInsetEnd();
      var9 = var10 + Math.max(var3, var8);
      var13[var7] = Math.max(0, var3 - var8);
      var8 = var9;
      var3 = var6;
      var4 = var5;
      if (this.shouldLayout(this.mExpandedActionView)) {
         var8 = var9 + this.measureChildCollapseMargins(this.mExpandedActionView, var1, var9, var2, 0, var13);
         var4 = Math.max(var5, this.mExpandedActionView.getMeasuredHeight() + this.getVerticalMargins(this.mExpandedActionView));
         var3 = View.combineMeasuredStates(var6, this.mExpandedActionView.getMeasuredState());
      }

      var5 = var8;
      var6 = var3;
      var7 = var4;
      if (this.shouldLayout(this.mLogoView)) {
         var5 = var8 + this.measureChildCollapseMargins(this.mLogoView, var1, var8, var2, 0, var13);
         var7 = Math.max(var4, this.mLogoView.getMeasuredHeight() + this.getVerticalMargins(this.mLogoView));
         var6 = View.combineMeasuredStates(var3, this.mLogoView.getMeasuredState());
      }

      var9 = this.getChildCount();
      int var47 = 0;
      var4 = var7;
      var3 = var6;
      var6 = var47;
      var47 = var5;

      while (var6 < var9) {
         View var14 = this.getChildAt(var6);
         if (((Toolbar.LayoutParams)var14.getLayoutParams()).b == 0) {
            if (!this.shouldLayout(var14)) {
               var5 = var3;
               var3 = var4;
               var4 = var5;
            } else {
               var47 += this.measureChildCollapseMargins(var14, var1, var47, var2, 0, var13);
               var5 = Math.max(var4, var14.getMeasuredHeight() + this.getVerticalMargins(var14));
               var4 = View.combineMeasuredStates(var3, var14.getMeasuredState());
               var3 = var5;
            }
         } else {
            var5 = var4;
            var4 = var3;
            var3 = var5;
         }

         var6++;
         var5 = var3;
         var3 = var4;
         var4 = var5;
      }

      var7 = 0;
      var6 = 0;
      int var11 = this.mTitleMarginTop + this.mTitleMarginBottom;
      int var12 = this.mTitleMarginStart + this.mTitleMarginEnd;
      var5 = var3;
      if (this.shouldLayout(this.mTitleTextView)) {
         this.measureChildCollapseMargins(this.mTitleTextView, var1, var47 + var12, var2, var11, var13);
         var5 = this.mTitleTextView.getMeasuredWidth();
         var7 = this.getHorizontalMargins(this.mTitleTextView) + var5;
         var6 = this.mTitleTextView.getMeasuredHeight() + this.getVerticalMargins(this.mTitleTextView);
         var5 = View.combineMeasuredStates(var3, this.mTitleTextView.getMeasuredState());
      }

      var10 = var6;
      var9 = var7;
      var3 = var5;
      if (this.shouldLayout(this.mSubtitleTextView)) {
         var9 = Math.max(var7, this.measureChildCollapseMargins(this.mSubtitleTextView, var1, var47 + var12, var2, var11 + var6, var13));
         var10 = var6 + this.mSubtitleTextView.getMeasuredHeight() + this.getVerticalMargins(this.mSubtitleTextView);
         var3 = View.combineMeasuredStates(var5, this.mSubtitleTextView.getMeasuredState());
      }

      var6 = Math.max(var4, var10);
      var7 = this.getPaddingLeft();
      var10 = this.getPaddingRight();
      var4 = this.getPaddingTop();
      var5 = this.getPaddingBottom();
      var7 = View.resolveSizeAndState(Math.max(var9 + var47 + var7 + var10, this.getSuggestedMinimumWidth()), var1, 0xFF000000 & var3);
      var1 = View.resolveSizeAndState(Math.max(var6 + var4 + var5, this.getSuggestedMinimumHeight()), var2, var3 << 16);
      if (this.shouldCollapse()) {
         var1 = 0;
      }

      this.setMeasuredDimension(var7, var1);
   }

   protected void onRestoreInstanceState(Parcelable var1) {
      if (!(var1 instanceof Toolbar.SavedState)) {
         super.onRestoreInstanceState(var1);
      } else {
         Toolbar.SavedState var2 = (Toolbar.SavedState)var1;
         super.onRestoreInstanceState(var2.a());
         MenuBuilder var3;
         if (this.mMenuView != null) {
            var3 = this.mMenuView.d();
         } else {
            var3 = null;
         }

         if (var2.a != 0 && this.mExpandedMenuPresenter != null && var3 != null) {
            MenuItem var4 = var3.findItem(var2.a);
            if (var4 != null) {
               var4.expandActionView();
            }
         }

         if (var2.b) {
            this.postShowOverflowMenu();
         }
      }
   }

   public void onRtlPropertiesChanged(int var1) {
      boolean var2 = true;
      if (VERSION.SDK_INT >= 17) {
         super.onRtlPropertiesChanged(var1);
      }

      this.ensureContentInsets();
      RtlSpacingHelper var3 = this.mContentInsets;
      if (var1 != 1) {
         var2 = false;
      }

      var3.a(var2);
   }

   protected Parcelable onSaveInstanceState() {
      Toolbar.SavedState var1 = new Toolbar.SavedState(super.onSaveInstanceState());
      if (this.mExpandedMenuPresenter != null && this.mExpandedMenuPresenter.b != null) {
         var1.a = this.mExpandedMenuPresenter.b.getItemId();
      }

      var1.b = this.isOverflowMenuShowing();
      return var1;
   }

   public boolean onTouchEvent(MotionEvent var1) {
      int var2 = var1.getActionMasked();
      if (var2 == 0) {
         this.mEatingTouch = false;
      }

      if (!this.mEatingTouch) {
         boolean var3 = super.onTouchEvent(var1);
         if (var2 == 0 && !var3) {
            this.mEatingTouch = true;
         }
      }

      if (var2 == 1 || var2 == 3) {
         this.mEatingTouch = false;
      }

      return true;
   }

   void removeChildrenForExpandedActionView() {
      for (int var1 = this.getChildCount() - 1; var1 >= 0; var1--) {
         View var2 = this.getChildAt(var1);
         if (((Toolbar.LayoutParams)var2.getLayoutParams()).b != 2 && var2 != this.mMenuView) {
            this.removeViewAt(var1);
            this.mHiddenViews.add(var2);
         }
      }
   }

   public void setCollapsible(boolean var1) {
      this.mCollapsible = var1;
      this.requestLayout();
   }

   public void setContentInsetEndWithActions(int var1) {
      int var2 = var1;
      if (var1 < 0) {
         var2 = Integer.MIN_VALUE;
      }

      if (var2 != this.mContentInsetEndWithActions) {
         this.mContentInsetEndWithActions = var2;
         if (this.getNavigationIcon() != null) {
            this.requestLayout();
         }
      }
   }

   public void setContentInsetStartWithNavigation(int var1) {
      int var2 = var1;
      if (var1 < 0) {
         var2 = Integer.MIN_VALUE;
      }

      if (var2 != this.mContentInsetStartWithNavigation) {
         this.mContentInsetStartWithNavigation = var2;
         if (this.getNavigationIcon() != null) {
            this.requestLayout();
         }
      }
   }

   public void setContentInsetsAbsolute(int var1, int var2) {
      this.ensureContentInsets();
      this.mContentInsets.b(var1, var2);
   }

   public void setContentInsetsRelative(int var1, int var2) {
      this.ensureContentInsets();
      this.mContentInsets.a(var1, var2);
   }

   public void setLogo(int var1) {
      this.setLogo(AppCompatResources.b(this.getContext(), var1));
   }

   public void setLogo(Drawable var1) {
      if (var1 != null) {
         this.ensureLogoView();
         if (!this.isChildOrHidden(this.mLogoView)) {
            this.addSystemView(this.mLogoView, true);
         }
      } else if (this.mLogoView != null && this.isChildOrHidden(this.mLogoView)) {
         this.removeView(this.mLogoView);
         this.mHiddenViews.remove(this.mLogoView);
      }

      if (this.mLogoView != null) {
         this.mLogoView.setImageDrawable(var1);
      }
   }

   public void setLogoDescription(int var1) {
      this.setLogoDescription(this.getContext().getText(var1));
   }

   public void setLogoDescription(CharSequence var1) {
      if (!TextUtils.isEmpty(var1)) {
         this.ensureLogoView();
      }

      if (this.mLogoView != null) {
         this.mLogoView.setContentDescription(var1);
      }
   }

   public void setMenu(MenuBuilder var1, ActionMenuPresenter var2) {
      if (var1 != null || this.mMenuView != null) {
         this.ensureMenuView();
         MenuBuilder var3 = this.mMenuView.d();
         if (var3 != var1) {
            if (var3 != null) {
               var3.b(this.mOuterActionMenuPresenter);
               var3.b(this.mExpandedMenuPresenter);
            }

            if (this.mExpandedMenuPresenter == null) {
               this.mExpandedMenuPresenter = new Toolbar.ExpandedActionViewMenuPresenter(this);
            }

            var2.d(true);
            if (var1 != null) {
               var1.a(var2, this.mPopupContext);
               var1.a(this.mExpandedMenuPresenter, this.mPopupContext);
            } else {
               var2.a(this.mPopupContext, null);
               this.mExpandedMenuPresenter.a(this.mPopupContext, null);
               var2.a(true);
               this.mExpandedMenuPresenter.a(true);
            }

            this.mMenuView.setPopupTheme(this.mPopupTheme);
            this.mMenuView.setPresenter(var2);
            this.mOuterActionMenuPresenter = var2;
         }
      }
   }

   public void setMenuCallbacks(MenuPresenter.Callback var1, MenuBuilder.Callback var2) {
      this.mActionMenuPresenterCallback = var1;
      this.mMenuBuilderCallback = var2;
      if (this.mMenuView != null) {
         this.mMenuView.a(var1, var2);
      }
   }

   public void setNavigationContentDescription(int var1) {
      CharSequence var2;
      if (var1 != 0) {
         var2 = this.getContext().getText(var1);
      } else {
         var2 = null;
      }

      this.setNavigationContentDescription(var2);
   }

   public void setNavigationContentDescription(CharSequence var1) {
      if (!TextUtils.isEmpty(var1)) {
         this.ensureNavButtonView();
      }

      if (this.mNavButtonView != null) {
         this.mNavButtonView.setContentDescription(var1);
      }
   }

   public void setNavigationIcon(int var1) {
      this.setNavigationIcon(AppCompatResources.b(this.getContext(), var1));
   }

   public void setNavigationIcon(Drawable var1) {
      if (var1 != null) {
         this.ensureNavButtonView();
         if (!this.isChildOrHidden(this.mNavButtonView)) {
            this.addSystemView(this.mNavButtonView, true);
         }
      } else if (this.mNavButtonView != null && this.isChildOrHidden(this.mNavButtonView)) {
         this.removeView(this.mNavButtonView);
         this.mHiddenViews.remove(this.mNavButtonView);
      }

      if (this.mNavButtonView != null) {
         this.mNavButtonView.setImageDrawable(var1);
      }
   }

   public void setNavigationOnClickListener(OnClickListener var1) {
      this.ensureNavButtonView();
      this.mNavButtonView.setOnClickListener(var1);
   }

   public void setOnMenuItemClickListener(Toolbar.OnMenuItemClickListener var1) {
      this.mOnMenuItemClickListener = var1;
   }

   public void setOverflowIcon(Drawable var1) {
      this.ensureMenu();
      this.mMenuView.setOverflowIcon(var1);
   }

   public void setPopupTheme(int var1) {
      if (this.mPopupTheme != var1) {
         this.mPopupTheme = var1;
         if (var1 == 0) {
            this.mPopupContext = this.getContext();
         } else {
            this.mPopupContext = new ContextThemeWrapper(this.getContext(), var1);
         }
      }
   }

   public void setSubtitle(int var1) {
      this.setSubtitle(this.getContext().getText(var1));
   }

   public void setSubtitle(CharSequence var1) {
      if (!TextUtils.isEmpty(var1)) {
         if (this.mSubtitleTextView == null) {
            Context var2 = this.getContext();
            this.mSubtitleTextView = new AppCompatTextView(var2);
            this.mSubtitleTextView.setSingleLine();
            this.mSubtitleTextView.setEllipsize(TruncateAt.END);
            if (this.mSubtitleTextAppearance != 0) {
               this.mSubtitleTextView.setTextAppearance(var2, this.mSubtitleTextAppearance);
            }

            if (this.mSubtitleTextColor != 0) {
               this.mSubtitleTextView.setTextColor(this.mSubtitleTextColor);
            }
         }

         if (!this.isChildOrHidden(this.mSubtitleTextView)) {
            this.addSystemView(this.mSubtitleTextView, true);
         }
      } else if (this.mSubtitleTextView != null && this.isChildOrHidden(this.mSubtitleTextView)) {
         this.removeView(this.mSubtitleTextView);
         this.mHiddenViews.remove(this.mSubtitleTextView);
      }

      if (this.mSubtitleTextView != null) {
         this.mSubtitleTextView.setText(var1);
      }

      this.mSubtitleText = var1;
   }

   public void setSubtitleTextAppearance(Context var1, int var2) {
      this.mSubtitleTextAppearance = var2;
      if (this.mSubtitleTextView != null) {
         this.mSubtitleTextView.setTextAppearance(var1, var2);
      }
   }

   public void setSubtitleTextColor(int var1) {
      this.mSubtitleTextColor = var1;
      if (this.mSubtitleTextView != null) {
         this.mSubtitleTextView.setTextColor(var1);
      }
   }

   public void setTitle(int var1) {
      this.setTitle(this.getContext().getText(var1));
   }

   public void setTitle(CharSequence var1) {
      if (!TextUtils.isEmpty(var1)) {
         if (this.mTitleTextView == null) {
            Context var2 = this.getContext();
            this.mTitleTextView = new AppCompatTextView(var2);
            this.mTitleTextView.setSingleLine();
            this.mTitleTextView.setEllipsize(TruncateAt.END);
            if (this.mTitleTextAppearance != 0) {
               this.mTitleTextView.setTextAppearance(var2, this.mTitleTextAppearance);
            }

            if (this.mTitleTextColor != 0) {
               this.mTitleTextView.setTextColor(this.mTitleTextColor);
            }
         }

         if (!this.isChildOrHidden(this.mTitleTextView)) {
            this.addSystemView(this.mTitleTextView, true);
         }
      } else if (this.mTitleTextView != null && this.isChildOrHidden(this.mTitleTextView)) {
         this.removeView(this.mTitleTextView);
         this.mHiddenViews.remove(this.mTitleTextView);
      }

      if (this.mTitleTextView != null) {
         this.mTitleTextView.setText(var1);
      }

      this.mTitleText = var1;
   }

   public void setTitleMargin(int var1, int var2, int var3, int var4) {
      this.mTitleMarginStart = var1;
      this.mTitleMarginTop = var2;
      this.mTitleMarginEnd = var3;
      this.mTitleMarginBottom = var4;
      this.requestLayout();
   }

   public void setTitleMarginBottom(int var1) {
      this.mTitleMarginBottom = var1;
      this.requestLayout();
   }

   public void setTitleMarginEnd(int var1) {
      this.mTitleMarginEnd = var1;
      this.requestLayout();
   }

   public void setTitleMarginStart(int var1) {
      this.mTitleMarginStart = var1;
      this.requestLayout();
   }

   public void setTitleMarginTop(int var1) {
      this.mTitleMarginTop = var1;
      this.requestLayout();
   }

   public void setTitleTextAppearance(Context var1, int var2) {
      this.mTitleTextAppearance = var2;
      if (this.mTitleTextView != null) {
         this.mTitleTextView.setTextAppearance(var1, var2);
      }
   }

   public void setTitleTextColor(int var1) {
      this.mTitleTextColor = var1;
      if (this.mTitleTextView != null) {
         this.mTitleTextView.setTextColor(var1);
      }
   }

   public boolean showOverflowMenu() {
      boolean var1;
      if (this.mMenuView != null && this.mMenuView.e()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private class ExpandedActionViewMenuPresenter implements MenuPresenter {
      MenuBuilder a;
      MenuItemImpl b;
      final Toolbar c;

      ExpandedActionViewMenuPresenter(Toolbar var1) {
         this.c = var1;
      }

      @Override
      public void a(Context var1, MenuBuilder var2) {
         if (this.a != null && this.b != null) {
            this.a.d(this.b);
         }

         this.a = var2;
      }

      @Override
      public void a(Parcelable var1) {
      }

      @Override
      public void a(MenuBuilder var1, boolean var2) {
      }

      @Override
      public void a(MenuPresenter.Callback var1) {
      }

      @Override
      public void a(boolean var1) {
         boolean var4 = false;
         if (this.b != null) {
            boolean var2 = var4;
            if (this.a != null) {
               int var5 = this.a.size();
               int var3 = 0;

               while (true) {
                  var2 = var4;
                  if (var3 >= var5) {
                     break;
                  }

                  if (this.a.getItem(var3) == this.b) {
                     var2 = true;
                     break;
                  }

                  var3++;
               }
            }

            if (!var2) {
               this.b(this.a, this.b);
            }
         }
      }

      @Override
      public boolean a() {
         return false;
      }

      @Override
      public boolean a(MenuBuilder var1, MenuItemImpl var2) {
         this.c.ensureCollapseButtonView();
         ViewParent var3 = this.c.mCollapseButtonView.getParent();
         if (var3 != this.c) {
            if (var3 instanceof ViewGroup) {
               ((ViewGroup)var3).removeView(this.c.mCollapseButtonView);
            }

            this.c.addView(this.c.mCollapseButtonView);
         }

         this.c.mExpandedActionView = var2.getActionView();
         this.b = var2;
         ViewParent var4 = this.c.mExpandedActionView.getParent();
         if (var4 != this.c) {
            if (var4 instanceof ViewGroup) {
               ((ViewGroup)var4).removeView(this.c.mExpandedActionView);
            }

            Toolbar.LayoutParams var5 = this.c.generateDefaultLayoutParams();
            var5.a = 8388611 | this.c.mButtonGravity & 112;
            var5.b = 2;
            this.c.mExpandedActionView.setLayoutParams(var5);
            this.c.addView(this.c.mExpandedActionView);
         }

         this.c.removeChildrenForExpandedActionView();
         this.c.requestLayout();
         var2.e(true);
         if (this.c.mExpandedActionView instanceof CollapsibleActionView) {
            ((CollapsibleActionView)this.c.mExpandedActionView).a();
         }

         return true;
      }

      @Override
      public boolean a(SubMenuBuilder var1) {
         return false;
      }

      @Override
      public int b() {
         return 0;
      }

      @Override
      public boolean b(MenuBuilder var1, MenuItemImpl var2) {
         if (this.c.mExpandedActionView instanceof CollapsibleActionView) {
            ((CollapsibleActionView)this.c.mExpandedActionView).b();
         }

         this.c.removeView(this.c.mExpandedActionView);
         this.c.removeView(this.c.mCollapseButtonView);
         this.c.mExpandedActionView = null;
         this.c.addChildrenForExpandedActionView();
         this.b = null;
         this.c.requestLayout();
         var2.e(false);
         return true;
      }

      @Override
      public Parcelable c() {
         return null;
      }
   }

   public static class LayoutParams extends ActionBar.LayoutParams {
      int b = 0;

      public LayoutParams(int var1, int var2) {
         super(var1, var2);
         this.a = 8388627;
      }

      public LayoutParams(int var1, int var2, int var3) {
         super(var1, var2);
         this.a = var3;
      }

      public LayoutParams(Context var1, AttributeSet var2) {
         super(var1, var2);
      }

      public LayoutParams(ActionBar.LayoutParams var1) {
         super(var1);
      }

      public LayoutParams(Toolbar.LayoutParams var1) {
         super(var1);
         this.b = var1.b;
      }

      public LayoutParams(android.view.ViewGroup.LayoutParams var1) {
         super(var1);
      }

      public LayoutParams(MarginLayoutParams var1) {
         super(var1);
         this.a(var1);
      }

      void a(MarginLayoutParams var1) {
         this.leftMargin = var1.leftMargin;
         this.topMargin = var1.topMargin;
         this.rightMargin = var1.rightMargin;
         this.bottomMargin = var1.bottomMargin;
      }
   }

   public interface OnMenuItemClickListener {
      boolean a(MenuItem var1);
   }

   public static class SavedState extends AbsSavedState {
      public static final Creator<Toolbar.SavedState> CREATOR = new ClassLoaderCreator<Toolbar.SavedState>() {
         public Toolbar.SavedState a(Parcel var1) {
            return new Toolbar.SavedState(var1, null);
         }

         public Toolbar.SavedState a(Parcel var1, ClassLoader var2) {
            return new Toolbar.SavedState(var1, var2);
         }

         public Toolbar.SavedState[] a(int var1) {
            return new Toolbar.SavedState[var1];
         }
      };
      int a;
      boolean b;

      public SavedState(Parcel var1, ClassLoader var2) {
         super(var1, var2);
         this.a = var1.readInt();
         boolean var3;
         if (var1.readInt() != 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         this.b = var3;
      }

      public SavedState(Parcelable var1) {
         super(var1);
      }

      @Override
      public void writeToParcel(Parcel var1, int var2) {
         super.writeToParcel(var1, var2);
         var1.writeInt(this.a);
         byte var3;
         if (this.b) {
            var3 = 1;
         } else {
            var3 = 0;
         }

         var1.writeInt(var3);
      }
   }
}
