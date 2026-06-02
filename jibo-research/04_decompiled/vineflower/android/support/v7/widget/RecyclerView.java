package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Build.VERSION;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.v4.os.TraceCompat;
import android.support.v4.util.Preconditions;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingChild2;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.support.v7.recyclerview.R;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerView extends ViewGroup implements NestedScrollingChild2 {
   static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC;
   private static final boolean ALLOW_THREAD_GAP_WORK;
   private static final int[] CLIP_TO_PADDING_ATTR = new int[]{16842987};
   static final boolean DEBUG = false;
   static final int DEFAULT_ORIENTATION = 1;
   static final boolean DISPATCH_TEMP_DETACH = false;
   private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION;
   static final boolean FORCE_INVALIDATE_DISPLAY_LIST;
   static final long FOREVER_NS = Long.MAX_VALUE;
   public static final int HORIZONTAL = 0;
   private static final boolean IGNORE_DETACHED_FOCUSED_CHILD;
   private static final int INVALID_POINTER = -1;
   public static final int INVALID_TYPE = -1;
   private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
   static final int MAX_SCROLL_DURATION = 2000;
   private static final int[] NESTED_SCROLLING_ATTRS = new int[]{16843830};
   public static final long NO_ID = -1L;
   public static final int NO_POSITION = -1;
   static final boolean POST_UPDATES_ON_ANIMATION;
   public static final int SCROLL_STATE_DRAGGING = 1;
   public static final int SCROLL_STATE_IDLE = 0;
   public static final int SCROLL_STATE_SETTLING = 2;
   static final String TAG = "RecyclerView";
   public static final int TOUCH_SLOP_DEFAULT = 0;
   public static final int TOUCH_SLOP_PAGING = 1;
   static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
   static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
   private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
   static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
   private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
   private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
   static final String TRACE_PREFETCH_TAG = "RV Prefetch";
   static final String TRACE_SCROLL_TAG = "RV Scroll";
   static final boolean VERBOSE_TRACING = false;
   public static final int VERTICAL = 1;
   static final Interpolator sQuinticInterpolator;
   RecyclerViewAccessibilityDelegate mAccessibilityDelegate;
   private final AccessibilityManager mAccessibilityManager;
   private RecyclerView.OnItemTouchListener mActiveOnItemTouchListener;
   RecyclerView.Adapter mAdapter;
   AdapterHelper mAdapterHelper;
   boolean mAdapterUpdateDuringMeasure;
   private EdgeEffect mBottomGlow;
   private RecyclerView.ChildDrawingOrderCallback mChildDrawingOrderCallback;
   ChildHelper mChildHelper;
   boolean mClipToPadding;
   boolean mDataSetHasChangedAfterLayout;
   boolean mDispatchItemsChangedEvent;
   private int mDispatchScrollCounter;
   private int mEatenAccessibilityChangeFlags;
   private RecyclerView.EdgeEffectFactory mEdgeEffectFactory;
   boolean mEnableFastScroller;
   boolean mFirstLayoutComplete;
   GapWorker mGapWorker;
   boolean mHasFixedSize;
   private boolean mIgnoreMotionEventTillDown;
   private int mInitialTouchX;
   private int mInitialTouchY;
   private int mInterceptRequestLayoutDepth;
   boolean mIsAttached;
   RecyclerView.ItemAnimator mItemAnimator;
   private RecyclerView.ItemAnimator.ItemAnimatorListener mItemAnimatorListener;
   private Runnable mItemAnimatorRunner;
   final ArrayList<RecyclerView.ItemDecoration> mItemDecorations;
   boolean mItemsAddedOrRemoved;
   boolean mItemsChanged;
   private int mLastTouchX;
   private int mLastTouchY;
   RecyclerView.LayoutManager mLayout;
   boolean mLayoutFrozen;
   private int mLayoutOrScrollCounter;
   boolean mLayoutWasDefered;
   private EdgeEffect mLeftGlow;
   private final int mMaxFlingVelocity;
   private final int mMinFlingVelocity;
   private final int[] mMinMaxLayoutPositions;
   private final int[] mNestedOffsets;
   private final RecyclerView.RecyclerViewDataObserver mObserver;
   private List<RecyclerView.OnChildAttachStateChangeListener> mOnChildAttachStateListeners;
   private RecyclerView.OnFlingListener mOnFlingListener;
   private final ArrayList<RecyclerView.OnItemTouchListener> mOnItemTouchListeners;
   final List<RecyclerView.ViewHolder> mPendingAccessibilityImportanceChange;
   private RecyclerView.SavedState mPendingSavedState;
   boolean mPostedAnimatorRunner;
   GapWorker.LayoutPrefetchRegistryImpl mPrefetchRegistry;
   private boolean mPreserveFocusAfterLayout;
   final RecyclerView.Recycler mRecycler;
   RecyclerView.RecyclerListener mRecyclerListener;
   private EdgeEffect mRightGlow;
   private float mScaledHorizontalScrollFactor;
   private float mScaledVerticalScrollFactor;
   private final int[] mScrollConsumed;
   private RecyclerView.OnScrollListener mScrollListener;
   private List<RecyclerView.OnScrollListener> mScrollListeners;
   private final int[] mScrollOffset;
   private int mScrollPointerId;
   private int mScrollState;
   private NestedScrollingChildHelper mScrollingChildHelper;
   final RecyclerView.State mState;
   final Rect mTempRect;
   private final Rect mTempRect2;
   final RectF mTempRectF;
   private EdgeEffect mTopGlow;
   private int mTouchSlop;
   final Runnable mUpdateChildViewsRunnable;
   private VelocityTracker mVelocityTracker;
   final RecyclerView.ViewFlinger mViewFlinger;
   private final ViewInfoStore.ProcessCallback mViewInfoProcessCallback;
   final ViewInfoStore mViewInfoStore;

   static {
      boolean var0;
      if (VERSION.SDK_INT != 18 && VERSION.SDK_INT != 19 && VERSION.SDK_INT != 20) {
         var0 = false;
      } else {
         var0 = true;
      }

      FORCE_INVALIDATE_DISPLAY_LIST = var0;
      if (VERSION.SDK_INT >= 23) {
         var0 = true;
      } else {
         var0 = false;
      }

      ALLOW_SIZE_IN_UNSPECIFIED_SPEC = var0;
      if (VERSION.SDK_INT >= 16) {
         var0 = true;
      } else {
         var0 = false;
      }

      POST_UPDATES_ON_ANIMATION = var0;
      if (VERSION.SDK_INT >= 21) {
         var0 = true;
      } else {
         var0 = false;
      }

      ALLOW_THREAD_GAP_WORK = var0;
      if (VERSION.SDK_INT <= 15) {
         var0 = true;
      } else {
         var0 = false;
      }

      FORCE_ABS_FOCUS_SEARCH_DIRECTION = var0;
      if (VERSION.SDK_INT <= 15) {
         var0 = true;
      } else {
         var0 = false;
      }

      IGNORE_DETACHED_FOCUSED_CHILD = var0;
      LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, int.class, int.class};
      sQuinticInterpolator = new Interpolator() {
         public float getInterpolation(float var1) {
            return --var1 * (var1 * var1 * var1 * var1) + 1.0F;
         }
      };
   }

   public RecyclerView(Context var1) {
      this(var1, null);
   }

   public RecyclerView(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public RecyclerView(Context var1, AttributeSet var2, int var3) {
      boolean var5 = true;
      super(var1, var2, var3);
      this.mObserver = new RecyclerView.RecyclerViewDataObserver(this);
      this.mRecycler = new RecyclerView.Recycler(this);
      this.mViewInfoStore = new ViewInfoStore();
      this.mUpdateChildViewsRunnable = new Runnable(this) {
         final RecyclerView a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            if (this.a.mFirstLayoutComplete && !this.a.isLayoutRequested()) {
               if (!this.a.mIsAttached) {
                  this.a.requestLayout();
               } else if (this.a.mLayoutFrozen) {
                  this.a.mLayoutWasDefered = true;
               } else {
                  this.a.consumePendingUpdateOperations();
               }
            }
         }
      };
      this.mTempRect = new Rect();
      this.mTempRect2 = new Rect();
      this.mTempRectF = new RectF();
      this.mItemDecorations = new ArrayList<>();
      this.mOnItemTouchListeners = new ArrayList<>();
      this.mInterceptRequestLayoutDepth = 0;
      this.mDataSetHasChangedAfterLayout = false;
      this.mDispatchItemsChangedEvent = false;
      this.mLayoutOrScrollCounter = 0;
      this.mDispatchScrollCounter = 0;
      this.mEdgeEffectFactory = new RecyclerView.EdgeEffectFactory();
      this.mItemAnimator = new DefaultItemAnimator();
      this.mScrollState = 0;
      this.mScrollPointerId = -1;
      this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
      this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
      this.mPreserveFocusAfterLayout = true;
      this.mViewFlinger = new RecyclerView.ViewFlinger(this);
      GapWorker.LayoutPrefetchRegistryImpl var6;
      if (ALLOW_THREAD_GAP_WORK) {
         var6 = new GapWorker.LayoutPrefetchRegistryImpl();
      } else {
         var6 = null;
      }

      this.mPrefetchRegistry = var6;
      this.mState = new RecyclerView.State();
      this.mItemsAddedOrRemoved = false;
      this.mItemsChanged = false;
      this.mItemAnimatorListener = new RecyclerView.ItemAnimatorRestoreListener(this);
      this.mPostedAnimatorRunner = false;
      this.mMinMaxLayoutPositions = new int[2];
      this.mScrollOffset = new int[2];
      this.mScrollConsumed = new int[2];
      this.mNestedOffsets = new int[2];
      this.mPendingAccessibilityImportanceChange = new ArrayList<>();
      this.mItemAnimatorRunner = new Runnable(this) {
         final RecyclerView a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            if (this.a.mItemAnimator != null) {
               this.a.mItemAnimator.a();
            }

            this.a.mPostedAnimatorRunner = false;
         }
      };
      this.mViewInfoProcessCallback = new ViewInfoStore.ProcessCallback(this) {
         final RecyclerView a;

         {
            this.a = var1;
         }

         @Override
         public void a(RecyclerView.ViewHolder var1) {
            this.a.mLayout.a(var1.itemView, this.a.mRecycler);
         }

         @Override
         public void a(RecyclerView.ViewHolder var1, RecyclerView.ItemAnimator.ItemHolderInfo var2x, RecyclerView.ItemAnimator.ItemHolderInfo var3x) {
            this.a.mRecycler.c(var1);
            this.a.animateDisappearance(var1, var2x, var3x);
         }

         @Override
         public void b(RecyclerView.ViewHolder var1, RecyclerView.ItemAnimator.ItemHolderInfo var2x, RecyclerView.ItemAnimator.ItemHolderInfo var3x) {
            this.a.animateAppearance(var1, var2x, var3x);
         }

         @Override
         public void c(RecyclerView.ViewHolder var1, RecyclerView.ItemAnimator.ItemHolderInfo var2x, RecyclerView.ItemAnimator.ItemHolderInfo var3x) {
            var1.setIsRecyclable(false);
            if (this.a.mDataSetHasChangedAfterLayout) {
               if (this.a.mItemAnimator.a(var1, var1, var2x, var3x)) {
                  this.a.postAnimationRunner();
               }
            } else if (this.a.mItemAnimator.c(var1, var2x, var3x)) {
               this.a.postAnimationRunner();
            }
         }
      };
      if (var2 != null) {
         TypedArray var10 = var1.obtainStyledAttributes(var2, CLIP_TO_PADDING_ATTR, var3, 0);
         this.mClipToPadding = var10.getBoolean(0, true);
         var10.recycle();
      } else {
         this.mClipToPadding = true;
      }

      this.setScrollContainer(true);
      this.setFocusableInTouchMode(true);
      ViewConfiguration var11 = ViewConfiguration.get(var1);
      this.mTouchSlop = var11.getScaledTouchSlop();
      this.mScaledHorizontalScrollFactor = ViewConfigurationCompat.a(var11, var1);
      this.mScaledVerticalScrollFactor = ViewConfigurationCompat.b(var11, var1);
      this.mMinFlingVelocity = var11.getScaledMinimumFlingVelocity();
      this.mMaxFlingVelocity = var11.getScaledMaximumFlingVelocity();
      boolean var4;
      if (this.getOverScrollMode() == 2) {
         var4 = true;
      } else {
         var4 = false;
      }

      this.setWillNotDraw(var4);
      this.mItemAnimator.a(this.mItemAnimatorListener);
      this.initAdapterManager();
      this.initChildrenHelper();
      if (ViewCompat.d(this) == 0) {
         ViewCompat.a(this, 1);
      }

      this.mAccessibilityManager = (AccessibilityManager)this.getContext().getSystemService("accessibility");
      this.setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
      if (var2 != null) {
         TypedArray var7 = var1.obtainStyledAttributes(var2, R.styleable.RecyclerView, var3, 0);
         String var12 = var7.getString(R.styleable.RecyclerView_layoutManager);
         if (var7.getInt(R.styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
            this.setDescendantFocusability(262144);
         }

         this.mEnableFastScroller = var7.getBoolean(R.styleable.RecyclerView_fastScrollEnabled, false);
         if (this.mEnableFastScroller) {
            this.initFastScroller(
               (StateListDrawable)var7.getDrawable(R.styleable.RecyclerView_fastScrollVerticalThumbDrawable),
               var7.getDrawable(R.styleable.RecyclerView_fastScrollVerticalTrackDrawable),
               (StateListDrawable)var7.getDrawable(R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable),
               var7.getDrawable(R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable)
            );
         }

         var7.recycle();
         this.createLayoutManager(var1, var12, var2, var3, 0);
         var4 = var5;
         if (VERSION.SDK_INT >= 21) {
            TypedArray var8 = var1.obtainStyledAttributes(var2, NESTED_SCROLLING_ATTRS, var3, 0);
            var4 = var8.getBoolean(0, true);
            var8.recycle();
         }
      } else {
         this.setDescendantFocusability(262144);
         var4 = var5;
      }

      this.setNestedScrollingEnabled(var4);
   }

   private void addAnimatingView(RecyclerView.ViewHolder var1) {
      View var3 = var1.itemView;
      boolean var2;
      if (var3.getParent() == this) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.mRecycler.c(this.getChildViewHolder(var3));
      if (var1.isTmpDetached()) {
         this.mChildHelper.a(var3, -1, var3.getLayoutParams(), true);
      } else if (!var2) {
         this.mChildHelper.a(var3, true);
      } else {
         this.mChildHelper.d(var3);
      }
   }

   private void animateChange(
      RecyclerView.ViewHolder var1,
      RecyclerView.ViewHolder var2,
      RecyclerView.ItemAnimator.ItemHolderInfo var3,
      RecyclerView.ItemAnimator.ItemHolderInfo var4,
      boolean var5,
      boolean var6
   ) {
      var1.setIsRecyclable(false);
      if (var5) {
         this.addAnimatingView(var1);
      }

      if (var1 != var2) {
         if (var6) {
            this.addAnimatingView(var2);
         }

         var1.mShadowedHolder = var2;
         this.addAnimatingView(var1);
         this.mRecycler.c(var1);
         var2.setIsRecyclable(false);
         var2.mShadowingHolder = var1;
      }

      if (this.mItemAnimator.a(var1, var2, var3, var4)) {
         this.postAnimationRunner();
      }
   }

   private void cancelTouch() {
      this.resetTouch();
      this.setScrollState(0);
   }

   static void clearNestedRecyclerViewIfNotNested(RecyclerView.ViewHolder var0) {
      if (var0.mNestedRecyclerView != null) {
         View var1 = (View)var0.mNestedRecyclerView.get();

         while (true) {
            if (var1 == null) {
               var0.mNestedRecyclerView = null;
               break;
            }

            if (var1 == var0.itemView) {
               break;
            }

            ViewParent var2 = var1.getParent();
            if (var2 instanceof View) {
               var1 = (View)var2;
            } else {
               var1 = null;
            }
         }
      }
   }

   private void createLayoutManager(Context param1, String param2, AttributeSet param3, int param4, int param5) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aload 2
      // 001: ifnull 06f
      // 004: aload 2
      // 005: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 008: astore 2
      // 009: aload 2
      // 00a: invokevirtual java/lang/String.isEmpty ()Z
      // 00d: ifne 06f
      // 010: aload 0
      // 011: aload 1
      // 012: aload 2
      // 013: invokespecial android/support/v7/widget/RecyclerView.getFullClassName (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
      // 016: astore 7
      // 018: aload 0
      // 019: invokevirtual android/support/v7/widget/RecyclerView.isInEditMode ()Z
      // 01c: ifeq 070
      // 01f: aload 0
      // 020: invokevirtual java/lang/Object.getClass ()Ljava/lang/Class;
      // 023: invokevirtual java/lang/Class.getClassLoader ()Ljava/lang/ClassLoader;
      // 026: astore 2
      // 027: aload 2
      // 028: aload 7
      // 02a: invokevirtual java/lang/ClassLoader.loadClass (Ljava/lang/String;)Ljava/lang/Class;
      // 02d: ldc android/support/v7/widget/RecyclerView$LayoutManager
      // 02f: invokevirtual java/lang/Class.asSubclass (Ljava/lang/Class;)Ljava/lang/Class;
      // 032: astore 8
      // 034: aload 8
      // 036: getstatic android/support/v7/widget/RecyclerView.LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE [Ljava/lang/Class;
      // 039: invokevirtual java/lang/Class.getConstructor ([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
      // 03c: astore 6
      // 03e: bipush 4
      // 03f: anewarray 741
      // 042: astore 2
      // 043: aload 2
      // 044: bipush 0
      // 045: aload 1
      // 046: aastore
      // 047: aload 2
      // 048: bipush 1
      // 049: aload 3
      // 04a: aastore
      // 04b: aload 2
      // 04c: bipush 2
      // 04d: iload 4
      // 04f: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 052: aastore
      // 053: aload 2
      // 054: bipush 3
      // 055: iload 5
      // 057: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 05a: aastore
      // 05b: aload 6
      // 05d: astore 1
      // 05e: aload 1
      // 05f: bipush 1
      // 060: invokevirtual java/lang/reflect/Constructor.setAccessible (Z)V
      // 063: aload 0
      // 064: aload 1
      // 065: aload 2
      // 066: invokevirtual java/lang/reflect/Constructor.newInstance ([Ljava/lang/Object;)Ljava/lang/Object;
      // 069: checkcast android/support/v7/widget/RecyclerView$LayoutManager
      // 06c: invokevirtual android/support/v7/widget/RecyclerView.setLayoutManager (Landroid/support/v7/widget/RecyclerView$LayoutManager;)V
      // 06f: return
      // 070: aload 1
      // 071: invokevirtual android/content/Context.getClassLoader ()Ljava/lang/ClassLoader;
      // 074: astore 2
      // 075: goto 027
      // 078: astore 2
      // 079: aload 8
      // 07b: bipush 0
      // 07c: anewarray 328
      // 07f: invokevirtual java/lang/Class.getConstructor ([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
      // 082: astore 1
      // 083: aconst_null
      // 084: astore 2
      // 085: goto 05e
      // 088: astore 1
      // 089: aload 1
      // 08a: aload 2
      // 08b: invokevirtual java/lang/NoSuchMethodException.initCause (Ljava/lang/Throwable;)Ljava/lang/Throwable;
      // 08e: pop
      // 08f: new java/lang/IllegalStateException
      // 092: astore 2
      // 093: new java/lang/StringBuilder
      // 096: astore 6
      // 098: aload 6
      // 09a: invokespecial java/lang/StringBuilder.<init> ()V
      // 09d: aload 2
      // 09e: aload 6
      // 0a0: aload 3
      // 0a1: invokeinterface android/util/AttributeSet.getPositionDescription ()Ljava/lang/String; 1
      // 0a6: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0a9: ldc_w ": Error creating LayoutManager "
      // 0ac: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0af: aload 7
      // 0b1: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0b4: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0b7: aload 1
      // 0b8: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;Ljava/lang/Throwable;)V
      // 0bb: aload 2
      // 0bc: athrow
      // 0bd: astore 1
      // 0be: new java/lang/IllegalStateException
      // 0c1: dup
      // 0c2: new java/lang/StringBuilder
      // 0c5: dup
      // 0c6: invokespecial java/lang/StringBuilder.<init> ()V
      // 0c9: aload 3
      // 0ca: invokeinterface android/util/AttributeSet.getPositionDescription ()Ljava/lang/String; 1
      // 0cf: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0d2: ldc_w ": Unable to find LayoutManager "
      // 0d5: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0d8: aload 7
      // 0da: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0dd: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0e0: aload 1
      // 0e1: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;Ljava/lang/Throwable;)V
      // 0e4: athrow
      // 0e5: astore 1
      // 0e6: new java/lang/IllegalStateException
      // 0e9: dup
      // 0ea: new java/lang/StringBuilder
      // 0ed: dup
      // 0ee: invokespecial java/lang/StringBuilder.<init> ()V
      // 0f1: aload 3
      // 0f2: invokeinterface android/util/AttributeSet.getPositionDescription ()Ljava/lang/String; 1
      // 0f7: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0fa: ldc_w ": Could not instantiate the LayoutManager: "
      // 0fd: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 100: aload 7
      // 102: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 105: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 108: aload 1
      // 109: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;Ljava/lang/Throwable;)V
      // 10c: athrow
      // 10d: astore 1
      // 10e: new java/lang/IllegalStateException
      // 111: dup
      // 112: new java/lang/StringBuilder
      // 115: dup
      // 116: invokespecial java/lang/StringBuilder.<init> ()V
      // 119: aload 3
      // 11a: invokeinterface android/util/AttributeSet.getPositionDescription ()Ljava/lang/String; 1
      // 11f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 122: ldc_w ": Could not instantiate the LayoutManager: "
      // 125: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 128: aload 7
      // 12a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 12d: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 130: aload 1
      // 131: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;Ljava/lang/Throwable;)V
      // 134: athrow
      // 135: astore 1
      // 136: new java/lang/IllegalStateException
      // 139: dup
      // 13a: new java/lang/StringBuilder
      // 13d: dup
      // 13e: invokespecial java/lang/StringBuilder.<init> ()V
      // 141: aload 3
      // 142: invokeinterface android/util/AttributeSet.getPositionDescription ()Ljava/lang/String; 1
      // 147: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 14a: ldc_w ": Cannot access non-public constructor "
      // 14d: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 150: aload 7
      // 152: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 155: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 158: aload 1
      // 159: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;Ljava/lang/Throwable;)V
      // 15c: athrow
      // 15d: astore 1
      // 15e: new java/lang/IllegalStateException
      // 161: dup
      // 162: new java/lang/StringBuilder
      // 165: dup
      // 166: invokespecial java/lang/StringBuilder.<init> ()V
      // 169: aload 3
      // 16a: invokeinterface android/util/AttributeSet.getPositionDescription ()Ljava/lang/String; 1
      // 16f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 172: ldc_w ": Class is not a LayoutManager "
      // 175: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 178: aload 7
      // 17a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 17d: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 180: aload 1
      // 181: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;Ljava/lang/Throwable;)V
      // 184: athrow
      // try (13 -> 20): 101 java/lang/ClassNotFoundException
      // try (13 -> 20): 118 java/lang/reflect/InvocationTargetException
      // try (13 -> 20): 135 java/lang/InstantiationException
      // try (13 -> 20): 152 java/lang/IllegalAccessException
      // try (13 -> 20): 169 java/lang/ClassCastException
      // try (20 -> 26): 101 java/lang/ClassNotFoundException
      // try (20 -> 26): 118 java/lang/reflect/InvocationTargetException
      // try (20 -> 26): 135 java/lang/InstantiationException
      // try (20 -> 26): 152 java/lang/IllegalAccessException
      // try (20 -> 26): 169 java/lang/ClassCastException
      // try (26 -> 33): 67 java/lang/NoSuchMethodException
      // try (26 -> 33): 101 java/lang/ClassNotFoundException
      // try (26 -> 33): 118 java/lang/reflect/InvocationTargetException
      // try (26 -> 33): 135 java/lang/InstantiationException
      // try (26 -> 33): 152 java/lang/IllegalAccessException
      // try (26 -> 33): 169 java/lang/ClassCastException
      // try (41 -> 51): 67 java/lang/NoSuchMethodException
      // try (41 -> 51): 101 java/lang/ClassNotFoundException
      // try (41 -> 51): 118 java/lang/reflect/InvocationTargetException
      // try (41 -> 51): 135 java/lang/InstantiationException
      // try (41 -> 51): 152 java/lang/IllegalAccessException
      // try (41 -> 51): 169 java/lang/ClassCastException
      // try (53 -> 62): 101 java/lang/ClassNotFoundException
      // try (53 -> 62): 118 java/lang/reflect/InvocationTargetException
      // try (53 -> 62): 135 java/lang/InstantiationException
      // try (53 -> 62): 152 java/lang/IllegalAccessException
      // try (53 -> 62): 169 java/lang/ClassCastException
      // try (63 -> 66): 101 java/lang/ClassNotFoundException
      // try (63 -> 66): 118 java/lang/reflect/InvocationTargetException
      // try (63 -> 66): 135 java/lang/InstantiationException
      // try (63 -> 66): 152 java/lang/IllegalAccessException
      // try (63 -> 66): 169 java/lang/ClassCastException
      // try (68 -> 73): 76 java/lang/NoSuchMethodException
      // try (68 -> 73): 101 java/lang/ClassNotFoundException
      // try (68 -> 73): 118 java/lang/reflect/InvocationTargetException
      // try (68 -> 73): 135 java/lang/InstantiationException
      // try (68 -> 73): 152 java/lang/IllegalAccessException
      // try (68 -> 73): 169 java/lang/ClassCastException
      // try (77 -> 101): 101 java/lang/ClassNotFoundException
      // try (77 -> 101): 118 java/lang/reflect/InvocationTargetException
      // try (77 -> 101): 135 java/lang/InstantiationException
      // try (77 -> 101): 152 java/lang/IllegalAccessException
      // try (77 -> 101): 169 java/lang/ClassCastException
   }

   private boolean didChildRangeChange(int var1, int var2) {
      boolean var3 = false;
      this.findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
      if (this.mMinMaxLayoutPositions[0] != var1 || this.mMinMaxLayoutPositions[1] != var2) {
         var3 = true;
      }

      return var3;
   }

   private void dispatchContentChangedIfNecessary() {
      int var1 = this.mEatenAccessibilityChangeFlags;
      this.mEatenAccessibilityChangeFlags = 0;
      if (var1 != 0 && this.isAccessibilityEnabled()) {
         AccessibilityEvent var2 = AccessibilityEvent.obtain();
         var2.setEventType(2048);
         AccessibilityEventCompat.a(var2, var1);
         this.sendAccessibilityEventUnchecked(var2);
      }
   }

   private void dispatchLayoutStep1() {
      boolean var4 = true;
      this.mState.a(1);
      this.fillRemainingScrollValues(this.mState);
      this.mState.h = false;
      this.startInterceptRequestLayout();
      this.mViewInfoStore.a();
      this.onEnterLayoutOrScroll();
      this.processAdapterUpdatesAndSetAnimationFlags();
      this.saveFocusInfo();
      RecyclerView.State var7 = this.mState;
      if (!this.mState.i || !this.mItemsChanged) {
         var4 = false;
      }

      var7.g = var4;
      this.mItemsChanged = false;
      this.mItemsAddedOrRemoved = false;
      this.mState.f = this.mState.j;
      this.mState.d = this.mAdapter.getItemCount();
      this.findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
      if (this.mState.i) {
         int var2 = this.mChildHelper.b();

         for (int var1 = 0; var1 < var2; var1++) {
            RecyclerView.ViewHolder var13 = getChildViewHolderInt(this.mChildHelper.b(var1));
            if (!var13.shouldIgnore() && (!var13.isInvalid() || this.mAdapter.hasStableIds())) {
               RecyclerView.ItemAnimator.ItemHolderInfo var8 = this.mItemAnimator
                  .a(this.mState, var13, RecyclerView.ItemAnimator.e(var13), var13.getUnmodifiedPayloads());
               this.mViewInfoStore.a(var13, var8);
               if (this.mState.g && var13.isUpdated() && !var13.isRemoved() && !var13.shouldIgnore() && !var13.isInvalid()) {
                  long var5 = this.getChangedHolderKey(var13);
                  this.mViewInfoStore.a(var5, var13);
               }
            }
         }
      }

      if (this.mState.j) {
         this.saveOldPositions();
         var4 = this.mState.e;
         this.mState.e = false;
         this.mLayout.c(this.mRecycler, this.mState);
         this.mState.e = var4;

         for (int var9 = 0; var9 < this.mChildHelper.b(); var9++) {
            RecyclerView.ViewHolder var14 = getChildViewHolderInt(this.mChildHelper.b(var9));
            if (!var14.shouldIgnore() && !this.mViewInfoStore.d(var14)) {
               int var3 = RecyclerView.ItemAnimator.e(var14);
               var4 = var14.hasAnyOfTheFlags(8192);
               int var10 = var3;
               if (!var4) {
                  var10 = var3 | 4096;
               }

               RecyclerView.ItemAnimator.ItemHolderInfo var15 = this.mItemAnimator.a(this.mState, var14, var10, var14.getUnmodifiedPayloads());
               if (var4) {
                  this.recordAnimationInfoIfBouncedHiddenView(var14, var15);
               } else {
                  this.mViewInfoStore.b(var14, var15);
               }
            }
         }

         this.clearOldPositions();
      } else {
         this.clearOldPositions();
      }

      this.onExitLayoutOrScroll();
      this.stopInterceptRequestLayout(false);
      this.mState.c = 2;
   }

   private void dispatchLayoutStep2() {
      this.startInterceptRequestLayout();
      this.onEnterLayoutOrScroll();
      this.mState.a(6);
      this.mAdapterHelper.e();
      this.mState.d = this.mAdapter.getItemCount();
      this.mState.b = 0;
      this.mState.f = false;
      this.mLayout.c(this.mRecycler, this.mState);
      this.mState.e = false;
      this.mPendingSavedState = null;
      RecyclerView.State var2 = this.mState;
      boolean var1;
      if (this.mState.i && this.mItemAnimator != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      var2.i = var1;
      this.mState.c = 4;
      this.onExitLayoutOrScroll();
      this.stopInterceptRequestLayout(false);
   }

   private void dispatchLayoutStep3() {
      this.mState.a(4);
      this.startInterceptRequestLayout();
      this.onEnterLayoutOrScroll();
      this.mState.c = 1;
      if (this.mState.i) {
         for (int var1 = this.mChildHelper.b() - 1; var1 >= 0; var1--) {
            RecyclerView.ViewHolder var8 = getChildViewHolderInt(this.mChildHelper.b(var1));
            if (!var8.shouldIgnore()) {
               long var4 = this.getChangedHolderKey(var8);
               RecyclerView.ItemAnimator.ItemHolderInfo var9 = this.mItemAnimator.a(this.mState, var8);
               RecyclerView.ViewHolder var7 = this.mViewInfoStore.a(var4);
               if (var7 != null && !var7.shouldIgnore()) {
                  boolean var3 = this.mViewInfoStore.a(var7);
                  boolean var2 = this.mViewInfoStore.a(var8);
                  if (var3 && var7 == var8) {
                     this.mViewInfoStore.c(var8, var9);
                  } else {
                     RecyclerView.ItemAnimator.ItemHolderInfo var6 = this.mViewInfoStore.b(var7);
                     this.mViewInfoStore.c(var8, var9);
                     var9 = this.mViewInfoStore.c(var8);
                     if (var6 == null) {
                        this.handleMissingPreInfoForChangeError(var4, var8, var7);
                     } else {
                        this.animateChange(var7, var8, var6, var9, var3, var2);
                     }
                  }
               } else {
                  this.mViewInfoStore.c(var8, var9);
               }
            }
         }

         this.mViewInfoStore.a(this.mViewInfoProcessCallback);
      }

      this.mLayout.b(this.mRecycler);
      this.mState.a = this.mState.d;
      this.mDataSetHasChangedAfterLayout = false;
      this.mDispatchItemsChangedEvent = false;
      this.mState.i = false;
      this.mState.j = false;
      this.mLayout.u = false;
      if (this.mRecycler.b != null) {
         this.mRecycler.b.clear();
      }

      if (this.mLayout.y) {
         this.mLayout.x = 0;
         this.mLayout.y = false;
         this.mRecycler.b();
      }

      this.mLayout.a(this.mState);
      this.onExitLayoutOrScroll();
      this.stopInterceptRequestLayout(false);
      this.mViewInfoStore.a();
      if (this.didChildRangeChange(this.mMinMaxLayoutPositions[0], this.mMinMaxLayoutPositions[1])) {
         this.dispatchOnScrolled(0, 0);
      }

      this.recoverFocusFromState();
      this.resetFocusInfo();
   }

   private boolean dispatchOnItemTouch(MotionEvent var1) {
      int var2 = var1.getAction();
      if (this.mActiveOnItemTouchListener != null) {
         if (var2 != 0) {
            this.mActiveOnItemTouchListener.b(this, var1);
            if (var2 == 3 || var2 == 1) {
               this.mActiveOnItemTouchListener = null;
            }

            return true;
         }

         this.mActiveOnItemTouchListener = null;
      }

      if (var2 != 0) {
         int var3 = this.mOnItemTouchListeners.size();

         for (int var6 = 0; var6 < var3; var6++) {
            RecyclerView.OnItemTouchListener var5 = this.mOnItemTouchListeners.get(var6);
            if (var5.a(this, var1)) {
               this.mActiveOnItemTouchListener = var5;
               return true;
            }
         }
      }

      return false;
   }

   private boolean dispatchOnItemTouchIntercept(MotionEvent var1) {
      int var4 = var1.getAction();
      if (var4 == 3 || var4 == 0) {
         this.mActiveOnItemTouchListener = null;
      }

      int var3 = this.mOnItemTouchListeners.size();
      int var2 = 0;

      boolean var5;
      while (true) {
         if (var2 >= var3) {
            var5 = false;
            break;
         }

         RecyclerView.OnItemTouchListener var6 = this.mOnItemTouchListeners.get(var2);
         if (var6.a(this, var1) && var4 != 3) {
            this.mActiveOnItemTouchListener = var6;
            var5 = true;
            break;
         }

         var2++;
      }

      return var5;
   }

   private void findMinMaxChildLayoutPositions(int[] var1) {
      int var7 = this.mChildHelper.b();
      if (var7 == 0) {
         var1[0] = -1;
         var1[1] = -1;
      } else {
         int var2 = Integer.MAX_VALUE;
         int var5 = Integer.MIN_VALUE;

         for (int var4 = 0; var4 < var7; var4++) {
            RecyclerView.ViewHolder var8 = getChildViewHolderInt(this.mChildHelper.b(var4));
            if (!var8.shouldIgnore()) {
               int var6 = var8.getLayoutPosition();
               int var3 = var2;
               if (var6 < var2) {
                  var3 = var6;
               }

               if (var6 > var5) {
                  var5 = var6;
                  var2 = var3;
               } else {
                  var2 = var3;
               }
            }
         }

         var1[0] = var2;
         var1[1] = var5;
      }
   }

   static RecyclerView findNestedRecyclerView(View var0) {
      RecyclerView var4;
      if (!(var0 instanceof ViewGroup)) {
         var4 = null;
      } else if (var0 instanceof RecyclerView) {
         var4 = (RecyclerView)var0;
      } else {
         ViewGroup var3 = (ViewGroup)var0;
         int var2 = var3.getChildCount();
         int var1 = 0;

         while (true) {
            if (var1 >= var2) {
               var4 = null;
               break;
            }

            var4 = findNestedRecyclerView(var3.getChildAt(var1));
            if (var4 != null) {
               break;
            }

            var1++;
         }
      }

      return var4;
   }

   private View findNextViewToFocus() {
      int var1;
      if (this.mState.k != -1) {
         var1 = this.mState.k;
      } else {
         var1 = 0;
      }

      int var3 = this.mState.e();
      int var2 = var1;

      View var7;
      while (true) {
         if (var2 < var3) {
            RecyclerView.ViewHolder var4 = this.findViewHolderForAdapterPosition(var2);
            if (var4 != null) {
               if (var4.itemView.hasFocusable()) {
                  var7 = var4.itemView;
                  break;
               }

               var2++;
               continue;
            }
         }

         for (int var5 = Math.min(var3, var1) - 1; var5 >= 0; var5--) {
            RecyclerView.ViewHolder var6 = this.findViewHolderForAdapterPosition(var5);
            if (var6 == null) {
               var7 = null;
               return var7;
            }

            if (var6.itemView.hasFocusable()) {
               var7 = var6.itemView;
               return var7;
            }
         }

         var7 = null;
         break;
      }

      return var7;
   }

   static RecyclerView.ViewHolder getChildViewHolderInt(View var0) {
      RecyclerView.ViewHolder var1;
      if (var0 == null) {
         var1 = null;
      } else {
         var1 = ((RecyclerView.LayoutParams)var0.getLayoutParams()).c;
      }

      return var1;
   }

   static void getDecoratedBoundsWithMarginsInt(View var0, Rect var1) {
      RecyclerView.LayoutParams var13 = (RecyclerView.LayoutParams)var0.getLayoutParams();
      Rect var14 = var13.d;
      int var4 = var0.getLeft();
      int var6 = var14.left;
      int var2 = var13.leftMargin;
      int var3 = var0.getTop();
      int var12 = var14.top;
      int var5 = var13.topMargin;
      int var7 = var0.getRight();
      int var11 = var14.right;
      int var9 = var13.rightMargin;
      int var10 = var0.getBottom();
      int var8 = var14.bottom;
      var1.set(var4 - var6 - var2, var3 - var12 - var5, var7 + var11 + var9, var13.bottomMargin + var8 + var10);
   }

   private int getDeepestFocusedViewWithId(View var1) {
      int var2 = var1.getId();

      while (!var1.isFocused() && var1 instanceof ViewGroup && var1.hasFocus()) {
         var1 = ((ViewGroup)var1).getFocusedChild();
         if (var1.getId() != -1) {
            var2 = var1.getId();
         }
      }

      return var2;
   }

   private String getFullClassName(Context var1, String var2) {
      String var3;
      if (var2.charAt(0) == '.') {
         var3 = var1.getPackageName() + var2;
      } else {
         var3 = var2;
         if (!var2.contains(".")) {
            var3 = RecyclerView.class.getPackage().getName() + '.' + var2;
         }
      }

      return var3;
   }

   private NestedScrollingChildHelper getScrollingChildHelper() {
      if (this.mScrollingChildHelper == null) {
         this.mScrollingChildHelper = new NestedScrollingChildHelper(this);
      }

      return this.mScrollingChildHelper;
   }

   private void handleMissingPreInfoForChangeError(long var1, RecyclerView.ViewHolder var3, RecyclerView.ViewHolder var4) {
      int var6 = this.mChildHelper.b();

      for (int var5 = 0; var5 < var6; var5++) {
         RecyclerView.ViewHolder var7 = getChildViewHolderInt(this.mChildHelper.b(var5));
         if (var7 != var3 && this.getChangedHolderKey(var7) == var1) {
            if (this.mAdapter != null && this.mAdapter.hasStableIds()) {
               throw new IllegalStateException(
                  "Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:"
                     + var7
                     + " \n View Holder 2:"
                     + var3
                     + this.exceptionLabel()
               );
            }

            throw new IllegalStateException(
               "Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:"
                  + var7
                  + " \n View Holder 2:"
                  + var3
                  + this.exceptionLabel()
            );
         }
      }

      Log.e(
         "RecyclerView",
         "Problem while matching changed view holders with the newones. The pre-layout information for the change holder "
            + var4
            + " cannot be found but it is necessary for "
            + var3
            + this.exceptionLabel()
      );
   }

   private boolean hasUpdatedView() {
      boolean var4 = false;
      int var2 = this.mChildHelper.b();
      int var1 = 0;

      boolean var3;
      while (true) {
         var3 = var4;
         if (var1 >= var2) {
            break;
         }

         RecyclerView.ViewHolder var5 = getChildViewHolderInt(this.mChildHelper.b(var1));
         if (var5 != null && !var5.shouldIgnore() && var5.isUpdated()) {
            var3 = true;
            break;
         }

         var1++;
      }

      return var3;
   }

   private void initChildrenHelper() {
      this.mChildHelper = new ChildHelper(new ChildHelper.Callback(this) {
         final RecyclerView a;

         {
            this.a = var1;
         }

         @Override
         public int a() {
            return this.a.getChildCount();
         }

         @Override
         public int a(View var1) {
            return this.a.indexOfChild(var1);
         }

         @Override
         public void a(int var1) {
            View var2 = this.a.getChildAt(var1);
            if (var2 != null) {
               this.a.dispatchChildDetached(var2);
               var2.clearAnimation();
            }

            this.a.removeViewAt(var1);
         }

         @Override
         public void a(View var1, int var2) {
            this.a.addView(var1, var2);
            this.a.dispatchChildAttached(var1);
         }

         @Override
         public void a(View var1, int var2, android.view.ViewGroup.LayoutParams var3) {
            RecyclerView.ViewHolder var4 = RecyclerView.getChildViewHolderInt(var1);
            if (var4 != null) {
               if (!var4.isTmpDetached() && !var4.shouldIgnore()) {
                  throw new IllegalArgumentException("Called attach on a child which is not detached: " + var4 + this.a.exceptionLabel());
               }

               var4.clearTmpDetachFlag();
            }

            this.a.attachViewToParent(var1, var2, var3);
         }

         @Override
         public RecyclerView.ViewHolder b(View var1) {
            return RecyclerView.getChildViewHolderInt(var1);
         }

         @Override
         public View b(int var1) {
            return this.a.getChildAt(var1);
         }

         @Override
         public void b() {
            int var2 = this.a();

            for (int var1 = 0; var1 < var2; var1++) {
               View var3 = this.b(var1);
               this.a.dispatchChildDetached(var3);
               var3.clearAnimation();
            }

            this.a.removeAllViews();
         }

         @Override
         public void c(int var1) {
            View var2 = this.b(var1);
            if (var2 != null) {
               RecyclerView.ViewHolder var3 = RecyclerView.getChildViewHolderInt(var2);
               if (var3 != null) {
                  if (var3.isTmpDetached() && !var3.shouldIgnore()) {
                     throw new IllegalArgumentException("called detach on an already detached child " + var3 + this.a.exceptionLabel());
                  }

                  var3.addFlags(256);
               }
            }

            this.a.detachViewFromParent(var1);
         }

         @Override
         public void c(View var1) {
            RecyclerView.ViewHolder var2 = RecyclerView.getChildViewHolderInt(var1);
            if (var2 != null) {
               var2.onEnteredHiddenState(this.a);
            }
         }

         @Override
         public void d(View var1) {
            RecyclerView.ViewHolder var2 = RecyclerView.getChildViewHolderInt(var1);
            if (var2 != null) {
               var2.onLeftHiddenState(this.a);
            }
         }
      });
   }

   private boolean isPreferredNextFocus(View var1, View var2, int var3) {
      byte var5 = -1;
      boolean var10 = true;
      boolean var9 = false;
      boolean var8 = false;
      boolean var7;
      if (var2 == null || var2 == this) {
         var7 = false;
      } else if (this.findContainingItemView(var2) == null) {
         var7 = false;
      } else {
         var7 = var10;
         if (var1 != null) {
            var7 = var10;
            if (this.findContainingItemView(var1) != null) {
               this.mTempRect.set(0, 0, var1.getWidth(), var1.getHeight());
               this.mTempRect2.set(0, 0, var2.getWidth(), var2.getHeight());
               this.offsetDescendantRectToMyCoords(var1, this.mTempRect);
               this.offsetDescendantRectToMyCoords(var2, this.mTempRect2);
               byte var6;
               if (this.mLayout.t() == 1) {
                  var6 = -1;
               } else {
                  var6 = 1;
               }

               byte var4;
               if ((this.mTempRect.left < this.mTempRect2.left || this.mTempRect.right <= this.mTempRect2.left) && this.mTempRect.right < this.mTempRect2.right
                  )
                {
                  var4 = 1;
               } else if ((this.mTempRect.right > this.mTempRect2.right || this.mTempRect.left >= this.mTempRect2.right)
                  && this.mTempRect.left > this.mTempRect2.left) {
                  var4 = -1;
               } else {
                  var4 = 0;
               }

               if ((this.mTempRect.top < this.mTempRect2.top || this.mTempRect.bottom <= this.mTempRect2.top) && this.mTempRect.bottom < this.mTempRect2.bottom
                  )
                {
                  var5 = 1;
               } else if (this.mTempRect.bottom <= this.mTempRect2.bottom && this.mTempRect.top < this.mTempRect2.bottom
                  || this.mTempRect.top <= this.mTempRect2.top) {
                  var5 = 0;
               }

               switch (var3) {
                  case 1:
                     if (var5 >= 0) {
                        var7 = var9;
                        if (var5 != 0) {
                           break;
                        }

                        var7 = var9;
                        if (var6 * var4 > 0) {
                           break;
                        }
                     }

                     var7 = true;
                     break;
                  case 2:
                     if (var5 <= 0) {
                        var7 = var8;
                        if (var5 != 0) {
                           break;
                        }

                        var7 = var8;
                        if (var6 * var4 < 0) {
                           break;
                        }
                     }

                     var7 = true;
                     break;
                  case 17:
                     var7 = var10;
                     if (var4 >= 0) {
                        var7 = false;
                     }
                     break;
                  case 33:
                     var7 = var10;
                     if (var5 >= 0) {
                        var7 = false;
                     }
                     break;
                  case 66:
                     var7 = var10;
                     if (var4 <= 0) {
                        var7 = false;
                     }
                     break;
                  case 130:
                     var7 = var10;
                     if (var5 <= 0) {
                        var7 = false;
                     }
                     break;
                  default:
                     throw new IllegalArgumentException("Invalid direction: " + var3 + this.exceptionLabel());
               }
            }
         }
      }

      return var7;
   }

   private void onPointerUp(MotionEvent var1) {
      int var2 = var1.getActionIndex();
      if (var1.getPointerId(var2) == this.mScrollPointerId) {
         byte var4;
         if (var2 == 0) {
            var4 = 1;
         } else {
            var4 = 0;
         }

         this.mScrollPointerId = var1.getPointerId(var4);
         int var3 = (int)(var1.getX(var4) + 0.5F);
         this.mLastTouchX = var3;
         this.mInitialTouchX = var3;
         var4 = (int)(var1.getY(var4) + 0.5F);
         this.mLastTouchY = var4;
         this.mInitialTouchY = var4;
      }
   }

   private boolean predictiveItemAnimationsEnabled() {
      boolean var1;
      if (this.mItemAnimator != null && this.mLayout.b()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private void processAdapterUpdatesAndSetAnimationFlags() {
      boolean var3 = true;
      if (this.mDataSetHasChangedAfterLayout) {
         this.mAdapterHelper.a();
         if (this.mDispatchItemsChangedEvent) {
            this.mLayout.a(this);
         }
      }

      if (this.predictiveItemAnimationsEnabled()) {
         this.mAdapterHelper.b();
      } else {
         this.mAdapterHelper.e();
      }

      boolean var1;
      if (!this.mItemsAddedOrRemoved && !this.mItemsChanged) {
         var1 = false;
      } else {
         var1 = true;
      }

      RecyclerView.State var4 = this.mState;
      boolean var2;
      if (!this.mFirstLayoutComplete
         || this.mItemAnimator == null
         || !this.mDataSetHasChangedAfterLayout && !var1 && !this.mLayout.u
         || this.mDataSetHasChangedAfterLayout && !this.mAdapter.hasStableIds()) {
         var2 = false;
      } else {
         var2 = true;
      }

      var4.i = var2;
      var4 = this.mState;
      if (this.mState.i && var1 && !this.mDataSetHasChangedAfterLayout && this.predictiveItemAnimationsEnabled()) {
         var2 = var3;
      } else {
         var2 = false;
      }

      var4.j = var2;
   }

   private void pullGlows(float var1, float var2, float var3, float var4) {
      boolean var6 = true;
      boolean var5 = false;
      if (var2 < 0.0F) {
         this.ensureLeftGlow();
         EdgeEffectCompat.a(this.mLeftGlow, -var2 / this.getWidth(), 1.0F - var3 / this.getHeight());
         var5 = true;
      } else if (var2 > 0.0F) {
         this.ensureRightGlow();
         EdgeEffectCompat.a(this.mRightGlow, var2 / this.getWidth(), var3 / this.getHeight());
         var5 = true;
      }

      if (var4 < 0.0F) {
         this.ensureTopGlow();
         EdgeEffectCompat.a(this.mTopGlow, -var4 / this.getHeight(), var1 / this.getWidth());
         var5 = var6;
      } else if (var4 > 0.0F) {
         this.ensureBottomGlow();
         EdgeEffectCompat.a(this.mBottomGlow, var4 / this.getHeight(), 1.0F - var1 / this.getWidth());
         var5 = var6;
      }

      if (var5 || var2 != 0.0F || var4 != 0.0F) {
         ViewCompat.c(this);
      }
   }

   private void recoverFocusFromState() {
      View var2 = null;
      if (this.mPreserveFocusAfterLayout
         && this.mAdapter != null
         && this.hasFocus()
         && this.getDescendantFocusability() != 393216
         && (this.getDescendantFocusability() != 131072 || !this.isFocused())) {
         if (!this.isFocused()) {
            View var1 = this.getFocusedChild();
            if (IGNORE_DETACHED_FOCUSED_CHILD && (var1.getParent() == null || !var1.hasFocus())) {
               if (this.mChildHelper.b() == 0) {
                  this.requestFocus();
                  return;
               }
            } else if (!this.mChildHelper.c(var1)) {
               return;
            }
         }

         RecyclerView.ViewHolder var3;
         if (this.mState.l != -1L && this.mAdapter.hasStableIds()) {
            var3 = this.findViewHolderForItemId(this.mState.l);
         } else {
            var3 = null;
         }

         View var4;
         if (var3 != null && !this.mChildHelper.c(var3.itemView) && var3.itemView.hasFocusable()) {
            var4 = var3.itemView;
         } else {
            var4 = var2;
            if (this.mChildHelper.b() > 0) {
               var4 = this.findNextViewToFocus();
            }
         }

         if (var4 != null) {
            if (this.mState.m != -1L) {
               var2 = var4.findViewById(this.mState.m);
               if (var2 != null && var2.isFocusable()) {
                  var4 = var2;
               }
            }

            var4.requestFocus();
         }
      }
   }

   private void releaseGlows() {
      boolean var1 = false;
      if (this.mLeftGlow != null) {
         this.mLeftGlow.onRelease();
         var1 = this.mLeftGlow.isFinished();
      }

      boolean var2 = var1;
      if (this.mTopGlow != null) {
         this.mTopGlow.onRelease();
         var2 = var1 | this.mTopGlow.isFinished();
      }

      var1 = var2;
      if (this.mRightGlow != null) {
         this.mRightGlow.onRelease();
         var1 = var2 | this.mRightGlow.isFinished();
      }

      var2 = var1;
      if (this.mBottomGlow != null) {
         this.mBottomGlow.onRelease();
         var2 = var1 | this.mBottomGlow.isFinished();
      }

      if (var2) {
         ViewCompat.c(this);
      }
   }

   private void requestChildOnScreen(View var1, View var2) {
      boolean var5 = true;
      View var6;
      if (var2 != null) {
         var6 = var2;
      } else {
         var6 = var1;
      }

      this.mTempRect.set(0, 0, var6.getWidth(), var6.getHeight());
      android.view.ViewGroup.LayoutParams var8 = var6.getLayoutParams();
      if (var8 instanceof RecyclerView.LayoutParams) {
         RecyclerView.LayoutParams var9 = (RecyclerView.LayoutParams)var8;
         if (!var9.e) {
            Rect var10 = var9.d;
            Rect var7 = this.mTempRect;
            var7.left = var7.left - var10.left;
            var7 = this.mTempRect;
            var7.right = var7.right + var10.right;
            var7 = this.mTempRect;
            var7.top = var7.top - var10.top;
            var7 = this.mTempRect;
            int var3 = var7.bottom;
            var7.bottom = var10.bottom + var3;
         }
      }

      if (var2 != null) {
         this.offsetDescendantRectToMyCoords(var2, this.mTempRect);
         this.offsetRectIntoDescendantCoords(var1, this.mTempRect);
      }

      RecyclerView.LayoutManager var11 = this.mLayout;
      Rect var15 = this.mTempRect;
      boolean var4;
      if (!this.mFirstLayoutComplete) {
         var4 = true;
      } else {
         var4 = false;
      }

      if (var2 != null) {
         var5 = false;
      }

      var11.a(this, var1, var15, var4, var5);
   }

   private void resetFocusInfo() {
      this.mState.l = -1L;
      this.mState.k = -1;
      this.mState.m = -1;
   }

   private void resetTouch() {
      if (this.mVelocityTracker != null) {
         this.mVelocityTracker.clear();
      }

      this.stopNestedScroll(0);
      this.releaseGlows();
   }

   private void saveFocusInfo() {
      View var4;
      if (this.mPreserveFocusAfterLayout && this.hasFocus() && this.mAdapter != null) {
         var4 = this.getFocusedChild();
      } else {
         var4 = null;
      }

      RecyclerView.ViewHolder var6;
      if (var4 == null) {
         var6 = null;
      } else {
         var6 = this.findContainingViewHolder(var4);
      }

      if (var6 == null) {
         this.resetFocusInfo();
      } else {
         RecyclerView.State var5 = this.mState;
         long var2;
         if (this.mAdapter.hasStableIds()) {
            var2 = var6.getItemId();
         } else {
            var2 = -1L;
         }

         var5.l = var2;
         var5 = this.mState;
         int var1;
         if (this.mDataSetHasChangedAfterLayout) {
            var1 = -1;
         } else if (var6.isRemoved()) {
            var1 = var6.mOldPosition;
         } else {
            var1 = var6.getAdapterPosition();
         }

         var5.k = var1;
         this.mState.m = this.getDeepestFocusedViewWithId(var6.itemView);
      }
   }

   private void setAdapterInternal(RecyclerView.Adapter var1, boolean var2, boolean var3) {
      if (this.mAdapter != null) {
         this.mAdapter.unregisterAdapterDataObserver(this.mObserver);
         this.mAdapter.onDetachedFromRecyclerView(this);
      }

      if (!var2 || var3) {
         this.removeAndRecycleViews();
      }

      this.mAdapterHelper.a();
      RecyclerView.Adapter var4 = this.mAdapter;
      this.mAdapter = var1;
      if (var1 != null) {
         var1.registerAdapterDataObserver(this.mObserver);
         var1.onAttachedToRecyclerView(this);
      }

      if (this.mLayout != null) {
         this.mLayout.a(var4, this.mAdapter);
      }

      this.mRecycler.a(var4, this.mAdapter, var2);
      this.mState.e = true;
   }

   private void stopScrollersInternal() {
      this.mViewFlinger.b();
      if (this.mLayout != null) {
         this.mLayout.I();
      }
   }

   void absorbGlows(int var1, int var2) {
      if (var1 < 0) {
         this.ensureLeftGlow();
         this.mLeftGlow.onAbsorb(-var1);
      } else if (var1 > 0) {
         this.ensureRightGlow();
         this.mRightGlow.onAbsorb(var1);
      }

      if (var2 < 0) {
         this.ensureTopGlow();
         this.mTopGlow.onAbsorb(-var2);
      } else if (var2 > 0) {
         this.ensureBottomGlow();
         this.mBottomGlow.onAbsorb(var2);
      }

      if (var1 != 0 || var2 != 0) {
         ViewCompat.c(this);
      }
   }

   public void addFocusables(ArrayList<View> var1, int var2, int var3) {
      if (this.mLayout == null || !this.mLayout.a(this, var1, var2, var3)) {
         super.addFocusables(var1, var2, var3);
      }
   }

   public void addItemDecoration(RecyclerView.ItemDecoration var1) {
      this.addItemDecoration(var1, -1);
   }

   public void addItemDecoration(RecyclerView.ItemDecoration var1, int var2) {
      if (this.mLayout != null) {
         this.mLayout.a("Cannot add item decoration during a scroll  or layout");
      }

      if (this.mItemDecorations.isEmpty()) {
         this.setWillNotDraw(false);
      }

      if (var2 < 0) {
         this.mItemDecorations.add(var1);
      } else {
         this.mItemDecorations.add(var2, var1);
      }

      this.markItemDecorInsetsDirty();
      this.requestLayout();
   }

   public void addOnChildAttachStateChangeListener(RecyclerView.OnChildAttachStateChangeListener var1) {
      if (this.mOnChildAttachStateListeners == null) {
         this.mOnChildAttachStateListeners = new ArrayList<>();
      }

      this.mOnChildAttachStateListeners.add(var1);
   }

   public void addOnItemTouchListener(RecyclerView.OnItemTouchListener var1) {
      this.mOnItemTouchListeners.add(var1);
   }

   public void addOnScrollListener(RecyclerView.OnScrollListener var1) {
      if (this.mScrollListeners == null) {
         this.mScrollListeners = new ArrayList<>();
      }

      this.mScrollListeners.add(var1);
   }

   void animateAppearance(RecyclerView.ViewHolder var1, RecyclerView.ItemAnimator.ItemHolderInfo var2, RecyclerView.ItemAnimator.ItemHolderInfo var3) {
      var1.setIsRecyclable(false);
      if (this.mItemAnimator.b(var1, var2, var3)) {
         this.postAnimationRunner();
      }
   }

   void animateDisappearance(RecyclerView.ViewHolder var1, RecyclerView.ItemAnimator.ItemHolderInfo var2, RecyclerView.ItemAnimator.ItemHolderInfo var3) {
      this.addAnimatingView(var1);
      var1.setIsRecyclable(false);
      if (this.mItemAnimator.a(var1, var2, var3)) {
         this.postAnimationRunner();
      }
   }

   void assertInLayoutOrScroll(String var1) {
      if (!this.isComputingLayout()) {
         if (var1 == null) {
            throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + this.exceptionLabel());
         } else {
            throw new IllegalStateException(var1 + this.exceptionLabel());
         }
      }
   }

   void assertNotInLayoutOrScroll(String var1) {
      if (this.isComputingLayout()) {
         if (var1 == null) {
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + this.exceptionLabel());
         } else {
            throw new IllegalStateException(var1);
         }
      } else {
         if (this.mDispatchScrollCounter > 0) {
            Log.w(
               "RecyclerView",
               "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.",
               new IllegalStateException("" + this.exceptionLabel())
            );
         }
      }
   }

   boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder var1) {
      boolean var2;
      if (this.mItemAnimator != null && !this.mItemAnimator.a(var1, var1.getUnmodifiedPayloads())) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      boolean var2;
      if (var1 instanceof RecyclerView.LayoutParams && this.mLayout.a((RecyclerView.LayoutParams)var1)) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   void clearOldPositions() {
      int var2 = this.mChildHelper.c();

      for (int var1 = 0; var1 < var2; var1++) {
         RecyclerView.ViewHolder var3 = getChildViewHolderInt(this.mChildHelper.d(var1));
         if (!var3.shouldIgnore()) {
            var3.clearOldPosition();
         }
      }

      this.mRecycler.i();
   }

   public void clearOnChildAttachStateChangeListeners() {
      if (this.mOnChildAttachStateListeners != null) {
         this.mOnChildAttachStateListeners.clear();
      }
   }

   public void clearOnScrollListeners() {
      if (this.mScrollListeners != null) {
         this.mScrollListeners.clear();
      }
   }

   public int computeHorizontalScrollExtent() {
      int var1 = 0;
      if (this.mLayout != null && this.mLayout.e()) {
         var1 = this.mLayout.e(this.mState);
      }

      return var1;
   }

   public int computeHorizontalScrollOffset() {
      int var1 = 0;
      if (this.mLayout != null && this.mLayout.e()) {
         var1 = this.mLayout.c(this.mState);
      }

      return var1;
   }

   public int computeHorizontalScrollRange() {
      int var1 = 0;
      if (this.mLayout != null && this.mLayout.e()) {
         var1 = this.mLayout.g(this.mState);
      }

      return var1;
   }

   public int computeVerticalScrollExtent() {
      int var1 = 0;
      if (this.mLayout != null && this.mLayout.f()) {
         var1 = this.mLayout.f(this.mState);
      }

      return var1;
   }

   public int computeVerticalScrollOffset() {
      int var1 = 0;
      if (this.mLayout != null && this.mLayout.f()) {
         var1 = this.mLayout.d(this.mState);
      }

      return var1;
   }

   public int computeVerticalScrollRange() {
      int var1 = 0;
      if (this.mLayout != null && this.mLayout.f()) {
         var1 = this.mLayout.h(this.mState);
      }

      return var1;
   }

   void considerReleasingGlowsOnScroll(int var1, int var2) {
      boolean var4 = false;
      boolean var3 = var4;
      if (this.mLeftGlow != null) {
         var3 = var4;
         if (!this.mLeftGlow.isFinished()) {
            var3 = var4;
            if (var1 > 0) {
               this.mLeftGlow.onRelease();
               var3 = this.mLeftGlow.isFinished();
            }
         }
      }

      var4 = var3;
      if (this.mRightGlow != null) {
         var4 = var3;
         if (!this.mRightGlow.isFinished()) {
            var4 = var3;
            if (var1 < 0) {
               this.mRightGlow.onRelease();
               var4 = var3 | this.mRightGlow.isFinished();
            }
         }
      }

      var3 = var4;
      if (this.mTopGlow != null) {
         var3 = var4;
         if (!this.mTopGlow.isFinished()) {
            var3 = var4;
            if (var2 > 0) {
               this.mTopGlow.onRelease();
               var3 = var4 | this.mTopGlow.isFinished();
            }
         }
      }

      var4 = var3;
      if (this.mBottomGlow != null) {
         var4 = var3;
         if (!this.mBottomGlow.isFinished()) {
            var4 = var3;
            if (var2 < 0) {
               this.mBottomGlow.onRelease();
               var4 = var3 | this.mBottomGlow.isFinished();
            }
         }
      }

      if (var4) {
         ViewCompat.c(this);
      }
   }

   void consumePendingUpdateOperations() {
      if (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout) {
         TraceCompat.a("RV FullInvalidate");
         this.dispatchLayout();
         TraceCompat.a();
      } else if (this.mAdapterHelper.d()) {
         if (this.mAdapterHelper.a(4) && !this.mAdapterHelper.a(11)) {
            TraceCompat.a("RV PartialInvalidate");
            this.startInterceptRequestLayout();
            this.onEnterLayoutOrScroll();
            this.mAdapterHelper.b();
            if (!this.mLayoutWasDefered) {
               if (this.hasUpdatedView()) {
                  this.dispatchLayout();
               } else {
                  this.mAdapterHelper.c();
               }
            }

            this.stopInterceptRequestLayout(true);
            this.onExitLayoutOrScroll();
            TraceCompat.a();
         } else if (this.mAdapterHelper.d()) {
            TraceCompat.a("RV FullInvalidate");
            this.dispatchLayout();
            TraceCompat.a();
         }
      }
   }

   void defaultOnMeasure(int var1, int var2) {
      this.setMeasuredDimension(
         RecyclerView.LayoutManager.a(var1, this.getPaddingLeft() + this.getPaddingRight(), ViewCompat.j(this)),
         RecyclerView.LayoutManager.a(var2, this.getPaddingTop() + this.getPaddingBottom(), ViewCompat.k(this))
      );
   }

   void dispatchChildAttached(View var1) {
      RecyclerView.ViewHolder var3 = getChildViewHolderInt(var1);
      this.onChildAttachedToWindow(var1);
      if (this.mAdapter != null && var3 != null) {
         this.mAdapter.onViewAttachedToWindow(var3);
      }

      if (this.mOnChildAttachStateListeners != null) {
         for (int var2 = this.mOnChildAttachStateListeners.size() - 1; var2 >= 0; var2--) {
            this.mOnChildAttachStateListeners.get(var2).a(var1);
         }
      }
   }

   void dispatchChildDetached(View var1) {
      RecyclerView.ViewHolder var3 = getChildViewHolderInt(var1);
      this.onChildDetachedFromWindow(var1);
      if (this.mAdapter != null && var3 != null) {
         this.mAdapter.onViewDetachedFromWindow(var3);
      }

      if (this.mOnChildAttachStateListeners != null) {
         for (int var2 = this.mOnChildAttachStateListeners.size() - 1; var2 >= 0; var2--) {
            this.mOnChildAttachStateListeners.get(var2).b(var1);
         }
      }
   }

   void dispatchLayout() {
      if (this.mAdapter == null) {
         Log.e("RecyclerView", "No adapter attached; skipping layout");
      } else if (this.mLayout == null) {
         Log.e("RecyclerView", "No layout manager attached; skipping layout");
      } else {
         this.mState.h = false;
         if (this.mState.c == 1) {
            this.dispatchLayoutStep1();
            this.mLayout.f(this);
            this.dispatchLayoutStep2();
         } else if (!this.mAdapterHelper.f() && this.mLayout.y() == this.getWidth() && this.mLayout.z() == this.getHeight()) {
            this.mLayout.f(this);
         } else {
            this.mLayout.f(this);
            this.dispatchLayoutStep2();
         }

         this.dispatchLayoutStep3();
      }
   }

   public boolean dispatchNestedFling(float var1, float var2, boolean var3) {
      return this.getScrollingChildHelper().a(var1, var2, var3);
   }

   public boolean dispatchNestedPreFling(float var1, float var2) {
      return this.getScrollingChildHelper().a(var1, var2);
   }

   public boolean dispatchNestedPreScroll(int var1, int var2, int[] var3, int[] var4) {
      return this.getScrollingChildHelper().a(var1, var2, var3, var4);
   }

   public boolean dispatchNestedPreScroll(int var1, int var2, int[] var3, int[] var4, int var5) {
      return this.getScrollingChildHelper().a(var1, var2, var3, var4, var5);
   }

   public boolean dispatchNestedScroll(int var1, int var2, int var3, int var4, int[] var5) {
      return this.getScrollingChildHelper().a(var1, var2, var3, var4, var5);
   }

   public boolean dispatchNestedScroll(int var1, int var2, int var3, int var4, int[] var5, int var6) {
      return this.getScrollingChildHelper().a(var1, var2, var3, var4, var5, var6);
   }

   void dispatchOnScrollStateChanged(int var1) {
      if (this.mLayout != null) {
         this.mLayout.l(var1);
      }

      this.onScrollStateChanged(var1);
      if (this.mScrollListener != null) {
         this.mScrollListener.a(this, var1);
      }

      if (this.mScrollListeners != null) {
         for (int var2 = this.mScrollListeners.size() - 1; var2 >= 0; var2--) {
            this.mScrollListeners.get(var2).a(this, var1);
         }
      }
   }

   void dispatchOnScrolled(int var1, int var2) {
      this.mDispatchScrollCounter++;
      int var3 = this.getScrollX();
      int var4 = this.getScrollY();
      this.onScrollChanged(var3, var4, var3, var4);
      this.onScrolled(var1, var2);
      if (this.mScrollListener != null) {
         this.mScrollListener.a(this, var1, var2);
      }

      if (this.mScrollListeners != null) {
         for (int var5 = this.mScrollListeners.size() - 1; var5 >= 0; var5--) {
            this.mScrollListeners.get(var5).a(this, var1, var2);
         }
      }

      this.mDispatchScrollCounter--;
   }

   void dispatchPendingImportantForAccessibilityChanges() {
      for (int var1 = this.mPendingAccessibilityImportanceChange.size() - 1; var1 >= 0; var1--) {
         RecyclerView.ViewHolder var3 = this.mPendingAccessibilityImportanceChange.get(var1);
         if (var3.itemView.getParent() == this && !var3.shouldIgnore()) {
            int var2 = var3.mPendingAccessibilityState;
            if (var2 != -1) {
               ViewCompat.a(var3.itemView, var2);
               var3.mPendingAccessibilityState = -1;
            }
         }
      }

      this.mPendingAccessibilityImportanceChange.clear();
   }

   protected void dispatchRestoreInstanceState(SparseArray<Parcelable> var1) {
      this.dispatchThawSelfOnly(var1);
   }

   protected void dispatchSaveInstanceState(SparseArray<Parcelable> var1) {
      this.dispatchFreezeSelfOnly(var1);
   }

   public void draw(Canvas var1) {
      boolean var4 = true;
      boolean var5 = false;
      super.draw(var1);
      int var3 = this.mItemDecorations.size();

      for (int var2 = 0; var2 < var3; var2++) {
         this.mItemDecorations.get(var2).a(var1, this, this.mState);
      }

      boolean var13;
      if (this.mLeftGlow != null && !this.mLeftGlow.isFinished()) {
         int var6 = var1.save();
         int var8;
         if (this.mClipToPadding) {
            var8 = this.getPaddingBottom();
         } else {
            var8 = 0;
         }

         var1.rotate(270.0F);
         var1.translate(var8 + -this.getHeight(), 0.0F);
         if (this.mLeftGlow != null && this.mLeftGlow.draw(var1)) {
            var13 = 1;
         } else {
            var13 = 0;
         }

         var1.restoreToCount(var6);
      } else {
         var13 = 0;
      }

      boolean var9 = (boolean)var13;
      if (this.mTopGlow != null) {
         var9 = (boolean)var13;
         if (!this.mTopGlow.isFinished()) {
            int var17 = var1.save();
            if (this.mClipToPadding) {
               var1.translate(this.getPaddingLeft(), this.getPaddingTop());
            }

            if (this.mTopGlow != null && this.mTopGlow.draw(var1)) {
               var9 = true;
            } else {
               var9 = false;
            }

            var9 = (boolean)(var13 | var9);
            var1.restoreToCount(var17);
         }
      }

      var13 = var9;
      if (this.mRightGlow != null) {
         var13 = var9;
         if (!this.mRightGlow.isFinished()) {
            int var18 = var1.save();
            int var7 = this.getWidth();
            if (this.mClipToPadding) {
               var13 = this.getPaddingTop();
            } else {
               var13 = 0;
            }

            var1.rotate(90.0F);
            var1.translate(-var13, -var7);
            boolean var16;
            if (this.mRightGlow != null && this.mRightGlow.draw(var1)) {
               var16 = true;
            } else {
               var16 = false;
            }

            var13 = var9 | var16;
            var1.restoreToCount(var18);
         }
      }

      var9 = var13;
      if (this.mBottomGlow != null) {
         var9 = var13;
         if (!this.mBottomGlow.isFinished()) {
            int var19 = var1.save();
            var1.rotate(180.0F);
            if (this.mClipToPadding) {
               var1.translate(-this.getWidth() + this.getPaddingRight(), -this.getHeight() + this.getPaddingBottom());
            } else {
               var1.translate(-this.getWidth(), -this.getHeight());
            }

            var9 = var5;
            if (this.mBottomGlow != null) {
               var9 = var5;
               if (this.mBottomGlow.draw(var1)) {
                  var9 = true;
               }
            }

            var9 = var13 | var9;
            var1.restoreToCount(var19);
         }
      }

      if (!var9 && this.mItemAnimator != null && this.mItemDecorations.size() > 0 && this.mItemAnimator.b()) {
         var9 = var4;
      }

      if (var9) {
         ViewCompat.c(this);
      }
   }

   public boolean drawChild(Canvas var1, View var2, long var3) {
      return super.drawChild(var1, var2, var3);
   }

   void ensureBottomGlow() {
      if (this.mBottomGlow == null) {
         this.mBottomGlow = this.mEdgeEffectFactory.a(this, 3);
         if (this.mClipToPadding) {
            this.mBottomGlow
               .setSize(
                  this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight(),
                  this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom()
               );
         } else {
            this.mBottomGlow.setSize(this.getMeasuredWidth(), this.getMeasuredHeight());
         }
      }
   }

   void ensureLeftGlow() {
      if (this.mLeftGlow == null) {
         this.mLeftGlow = this.mEdgeEffectFactory.a(this, 0);
         if (this.mClipToPadding) {
            this.mLeftGlow
               .setSize(
                  this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom(),
                  this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight()
               );
         } else {
            this.mLeftGlow.setSize(this.getMeasuredHeight(), this.getMeasuredWidth());
         }
      }
   }

   void ensureRightGlow() {
      if (this.mRightGlow == null) {
         this.mRightGlow = this.mEdgeEffectFactory.a(this, 2);
         if (this.mClipToPadding) {
            this.mRightGlow
               .setSize(
                  this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom(),
                  this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight()
               );
         } else {
            this.mRightGlow.setSize(this.getMeasuredHeight(), this.getMeasuredWidth());
         }
      }
   }

   void ensureTopGlow() {
      if (this.mTopGlow == null) {
         this.mTopGlow = this.mEdgeEffectFactory.a(this, 1);
         if (this.mClipToPadding) {
            this.mTopGlow
               .setSize(
                  this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight(),
                  this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom()
               );
         } else {
            this.mTopGlow.setSize(this.getMeasuredWidth(), this.getMeasuredHeight());
         }
      }
   }

   String exceptionLabel() {
      return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + this.getContext();
   }

   final void fillRemainingScrollValues(RecyclerView.State var1) {
      if (this.getScrollState() == 2) {
         OverScroller var2 = this.mViewFlinger.e;
         var1.n = var2.getFinalX() - var2.getCurrX();
         var1.o = var2.getFinalY() - var2.getCurrY();
      } else {
         var1.n = 0;
         var1.o = 0;
      }
   }

   public View findChildViewUnder(float var1, float var2) {
      int var5 = this.mChildHelper.b() - 1;

      View var6;
      while (true) {
         if (var5 < 0) {
            var6 = null;
            break;
         }

         var6 = this.mChildHelper.b(var5);
         float var4 = var6.getTranslationX();
         float var3 = var6.getTranslationY();
         if (var1 >= var6.getLeft() + var4 && var1 <= var4 + var6.getRight() && var2 >= var6.getTop() + var3 && var2 <= var6.getBottom() + var3) {
            break;
         }

         var5--;
      }

      return var6;
   }

   public View findContainingItemView(View var1) {
      ViewParent var2;
      for (var2 = var1.getParent(); var2 != null && var2 != this && var2 instanceof View; var2 = var1.getParent()) {
         var1 = (View)var2;
      }

      if (var2 != this) {
         var1 = null;
      }

      return var1;
   }

   public RecyclerView.ViewHolder findContainingViewHolder(View var1) {
      var1 = this.findContainingItemView(var1);
      RecyclerView.ViewHolder var3;
      if (var1 == null) {
         var3 = null;
      } else {
         var3 = this.getChildViewHolder(var1);
      }

      return var3;
   }

   public RecyclerView.ViewHolder findViewHolderForAdapterPosition(int var1) {
      RecyclerView.ViewHolder var4 = null;
      if (!this.mDataSetHasChangedAfterLayout) {
         int var3 = this.mChildHelper.c();
         int var2 = 0;
         var4 = null;

         while (var2 < var3) {
            RecyclerView.ViewHolder var5 = getChildViewHolderInt(this.mChildHelper.d(var2));
            if (var5 != null && !var5.isRemoved() && this.getAdapterPositionFor(var5) == var1) {
               var4 = var5;
               if (!this.mChildHelper.c(var5.itemView)) {
                  break;
               }

               var4 = var5;
            }

            var2++;
         }
      }

      return var4;
   }

   public RecyclerView.ViewHolder findViewHolderForItemId(long var1) {
      RecyclerView.ViewHolder var6 = null;
      RecyclerView.ViewHolder var5 = var6;
      if (this.mAdapter != null) {
         if (!this.mAdapter.hasStableIds()) {
            var5 = var6;
         } else {
            int var4 = this.mChildHelper.c();
            int var3 = 0;
            var5 = null;

            while (var3 < var4) {
               var6 = getChildViewHolderInt(this.mChildHelper.d(var3));
               if (var6 != null && !var6.isRemoved() && var6.getItemId() == var1) {
                  var5 = var6;
                  if (!this.mChildHelper.c(var6.itemView)) {
                     break;
                  }

                  var5 = var6;
               }

               var3++;
            }
         }
      }

      return var5;
   }

   public RecyclerView.ViewHolder findViewHolderForLayoutPosition(int var1) {
      return this.findViewHolderForPosition(var1, false);
   }

   @Deprecated
   public RecyclerView.ViewHolder findViewHolderForPosition(int var1) {
      return this.findViewHolderForPosition(var1, false);
   }

   RecyclerView.ViewHolder findViewHolderForPosition(int var1, boolean var2) {
      int var4 = this.mChildHelper.c();
      int var3 = 0;
      RecyclerView.ViewHolder var5 = null;

      while (var3 < var4) {
         RecyclerView.ViewHolder var6 = getChildViewHolderInt(this.mChildHelper.d(var3));
         RecyclerView.ViewHolder var7 = var5;
         if (var6 != null) {
            var7 = var5;
            label25:
            if (!var6.isRemoved()) {
               if (var2) {
                  if (var6.mPosition != var1) {
                     var7 = var5;
                     break label25;
                  }
               } else {
                  var7 = var5;
                  if (var6.getLayoutPosition() != var1) {
                     break label25;
                  }
               }

               var5 = var6;
               if (!this.mChildHelper.c(var6.itemView)) {
                  break;
               }

               var7 = var6;
            }
         }

         var3++;
         var5 = var7;
      }

      return var5;
   }

   public boolean fling(int var1, int var2) {
      boolean var7 = false;
      boolean var5;
      if (this.mLayout == null) {
         Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
         var5 = var7;
      } else {
         var5 = var7;
         if (!this.mLayoutFrozen) {
            int var3;
            boolean var8;
            boolean var9;
            label58: {
               var8 = this.mLayout.e();
               var9 = this.mLayout.f();
               if (var8) {
                  var3 = var1;
                  if (Math.abs(var1) >= this.mMinFlingVelocity) {
                     break label58;
                  }
               }

               var3 = 0;
            }

            int var4;
            label53: {
               if (var9) {
                  var4 = var2;
                  if (Math.abs(var2) >= this.mMinFlingVelocity) {
                     break label53;
                  }
               }

               var4 = 0;
            }

            if (var3 == 0) {
               var5 = var7;
               if (var4 == 0) {
                  return var5;
               }
            }

            var5 = var7;
            if (!this.dispatchNestedPreFling(var3, var4)) {
               boolean var6;
               if (!var8 && !var9) {
                  var6 = false;
               } else {
                  var6 = true;
               }

               this.dispatchNestedFling(var3, var4, var6);
               if (this.mOnFlingListener != null && this.mOnFlingListener.a(var3, var4)) {
                  var5 = true;
               } else {
                  var5 = var7;
                  if (var6) {
                     byte var10;
                     if (var8) {
                        var10 = 1;
                     } else {
                        var10 = 0;
                     }

                     var2 = var10;
                     if (var9) {
                        var2 = var10 | 2;
                     }

                     this.startNestedScroll(var2, 1);
                     var10 = Math.max(-this.mMaxFlingVelocity, Math.min(var3, this.mMaxFlingVelocity));
                     var2 = Math.max(-this.mMaxFlingVelocity, Math.min(var4, this.mMaxFlingVelocity));
                     this.mViewFlinger.a(var10, var2);
                     var5 = true;
                  }
               }
            }
         }
      }

      return var5;
   }

   public View focusSearch(View var1, int var2) {
      boolean var5 = true;
      View var6 = this.mLayout.d(var1, var2);
      if (var6 != null) {
         var1 = var6;
      } else {
         boolean var3;
         if (this.mAdapter != null && this.mLayout != null && !this.isComputingLayout() && !this.mLayoutFrozen) {
            var3 = 1;
         } else {
            var3 = 0;
         }

         FocusFinder var13 = FocusFinder.getInstance();
         if (var3 && (var2 == 2 || var2 == 1)) {
            if (this.mLayout.f()) {
               short var4;
               if (var2 == 2) {
                  var4 = 130;
               } else {
                  var4 = 33;
               }

               if (var13.findNextFocus(this, var1, var4) == null) {
                  var3 = (boolean)1;
               } else {
                  var3 = (boolean)0;
               }

               if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                  var2 = var4;
               }
            } else {
               var3 = (boolean)0;
            }

            if (!var3 && this.mLayout.e()) {
               if (this.mLayout.t() == 1) {
                  var3 = (boolean)1;
               } else {
                  var3 = (boolean)0;
               }

               boolean var10;
               if (var2 == 2) {
                  var10 = true;
               } else {
                  var10 = false;
               }

               if (var10 ^ var3) {
                  var3 = 66;
               } else {
                  var3 = 17;
               }

               if (var13.findNextFocus(this, var1, var3) == null) {
                  var10 = var5;
               } else {
                  var10 = false;
               }

               var5 = var10;
               if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                  var2 = var3;
                  var5 = var10;
               }
            } else {
               var5 = var3;
            }

            if (var5) {
               this.consumePendingUpdateOperations();
               if (this.findContainingItemView(var1) == null) {
                  var1 = null;
                  return var1;
               }

               this.startInterceptRequestLayout();
               this.mLayout.a(var1, var2, this.mRecycler, this.mState);
               this.stopInterceptRequestLayout(false);
            }

            var6 = var13.findNextFocus(this, var1, var2);
         } else {
            var6 = var13.findNextFocus(this, var1, var2);
            if (var6 == null && var3) {
               this.consumePendingUpdateOperations();
               if (this.findContainingItemView(var1) == null) {
                  var1 = null;
                  return var1;
               }

               this.startInterceptRequestLayout();
               var6 = this.mLayout.a(var1, var2, this.mRecycler, this.mState);
               this.stopInterceptRequestLayout(false);
            }
         }

         if (var6 != null && !var6.hasFocusable()) {
            if (this.getFocusedChild() == null) {
               var1 = super.focusSearch(var1, var2);
            } else {
               this.requestChildOnScreen(var6, null);
            }
         } else {
            if (!this.isPreferredNextFocus(var1, var6, var2)) {
               var6 = super.focusSearch(var1, var2);
            }

            var1 = var6;
         }
      }

      return var1;
   }

   protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
      if (this.mLayout == null) {
         throw new IllegalStateException("RecyclerView has no LayoutManager" + this.exceptionLabel());
      } else {
         return this.mLayout.a();
      }
   }

   public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet var1) {
      if (this.mLayout == null) {
         throw new IllegalStateException("RecyclerView has no LayoutManager" + this.exceptionLabel());
      } else {
         return this.mLayout.a(this.getContext(), var1);
      }
   }

   protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      if (this.mLayout == null) {
         throw new IllegalStateException("RecyclerView has no LayoutManager" + this.exceptionLabel());
      } else {
         return this.mLayout.a(var1);
      }
   }

   public RecyclerView.Adapter getAdapter() {
      return this.mAdapter;
   }

   int getAdapterPositionFor(RecyclerView.ViewHolder var1) {
      int var2;
      if (!var1.hasAnyOfTheFlags(524) && var1.isBound()) {
         var2 = this.mAdapterHelper.c(var1.mPosition);
      } else {
         var2 = -1;
      }

      return var2;
   }

   public int getBaseline() {
      int var1;
      if (this.mLayout != null) {
         var1 = this.mLayout.u();
      } else {
         var1 = super.getBaseline();
      }

      return var1;
   }

   long getChangedHolderKey(RecyclerView.ViewHolder var1) {
      long var2;
      if (this.mAdapter.hasStableIds()) {
         var2 = var1.getItemId();
      } else {
         var2 = var1.mPosition;
      }

      return var2;
   }

   public int getChildAdapterPosition(View var1) {
      RecyclerView.ViewHolder var3 = getChildViewHolderInt(var1);
      int var2;
      if (var3 != null) {
         var2 = var3.getAdapterPosition();
      } else {
         var2 = -1;
      }

      return var2;
   }

   protected int getChildDrawingOrder(int var1, int var2) {
      if (this.mChildDrawingOrderCallback == null) {
         var1 = super.getChildDrawingOrder(var1, var2);
      } else {
         var1 = this.mChildDrawingOrderCallback.a(var1, var2);
      }

      return var1;
   }

   public long getChildItemId(View var1) {
      long var4 = -1L;
      long var2 = var4;
      if (this.mAdapter != null) {
         if (!this.mAdapter.hasStableIds()) {
            var2 = var4;
         } else {
            RecyclerView.ViewHolder var6 = getChildViewHolderInt(var1);
            var2 = var4;
            if (var6 != null) {
               var2 = var6.getItemId();
            }
         }
      }

      return var2;
   }

   public int getChildLayoutPosition(View var1) {
      RecyclerView.ViewHolder var3 = getChildViewHolderInt(var1);
      int var2;
      if (var3 != null) {
         var2 = var3.getLayoutPosition();
      } else {
         var2 = -1;
      }

      return var2;
   }

   @Deprecated
   public int getChildPosition(View var1) {
      return this.getChildAdapterPosition(var1);
   }

   public RecyclerView.ViewHolder getChildViewHolder(View var1) {
      ViewParent var2 = var1.getParent();
      if (var2 != null && var2 != this) {
         throw new IllegalArgumentException("View " + var1 + " is not a direct child of " + this);
      } else {
         return getChildViewHolderInt(var1);
      }
   }

   public boolean getClipToPadding() {
      return this.mClipToPadding;
   }

   public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
      return this.mAccessibilityDelegate;
   }

   public void getDecoratedBoundsWithMargins(View var1, Rect var2) {
      getDecoratedBoundsWithMarginsInt(var1, var2);
   }

   public RecyclerView.EdgeEffectFactory getEdgeEffectFactory() {
      return this.mEdgeEffectFactory;
   }

   public RecyclerView.ItemAnimator getItemAnimator() {
      return this.mItemAnimator;
   }

   Rect getItemDecorInsetsForChild(View var1) {
      RecyclerView.LayoutParams var5 = (RecyclerView.LayoutParams)var1.getLayoutParams();
      Rect var6;
      if (!var5.e) {
         var6 = var5.d;
      } else if (!this.mState.a() || !var5.e() && !var5.c()) {
         Rect var4 = var5.d;
         var4.set(0, 0, 0, 0);
         int var3 = this.mItemDecorations.size();

         for (int var2 = 0; var2 < var3; var2++) {
            this.mTempRect.set(0, 0, 0, 0);
            this.mItemDecorations.get(var2).a(this.mTempRect, var1, this, this.mState);
            var4.left = var4.left + this.mTempRect.left;
            var4.top = var4.top + this.mTempRect.top;
            var4.right = var4.right + this.mTempRect.right;
            var4.bottom = var4.bottom + this.mTempRect.bottom;
         }

         var5.e = false;
         var6 = var4;
      } else {
         var6 = var5.d;
      }

      return var6;
   }

   public RecyclerView.ItemDecoration getItemDecorationAt(int var1) {
      int var2 = this.getItemDecorationCount();
      if (var1 >= 0 && var1 < var2) {
         return this.mItemDecorations.get(var1);
      } else {
         throw new IndexOutOfBoundsException(var1 + " is an invalid index for size " + var2);
      }
   }

   public int getItemDecorationCount() {
      return this.mItemDecorations.size();
   }

   public RecyclerView.LayoutManager getLayoutManager() {
      return this.mLayout;
   }

   public int getMaxFlingVelocity() {
      return this.mMaxFlingVelocity;
   }

   public int getMinFlingVelocity() {
      return this.mMinFlingVelocity;
   }

   long getNanoTime() {
      long var1;
      if (ALLOW_THREAD_GAP_WORK) {
         var1 = System.nanoTime();
      } else {
         var1 = 0L;
      }

      return var1;
   }

   public RecyclerView.OnFlingListener getOnFlingListener() {
      return this.mOnFlingListener;
   }

   public boolean getPreserveFocusAfterLayout() {
      return this.mPreserveFocusAfterLayout;
   }

   public RecyclerView.RecycledViewPool getRecycledViewPool() {
      return this.mRecycler.g();
   }

   public int getScrollState() {
      return this.mScrollState;
   }

   public boolean hasFixedSize() {
      return this.mHasFixedSize;
   }

   public boolean hasNestedScrollingParent() {
      return this.getScrollingChildHelper().b();
   }

   public boolean hasNestedScrollingParent(int var1) {
      return this.getScrollingChildHelper().a(var1);
   }

   public boolean hasPendingAdapterUpdates() {
      boolean var1;
      if (this.mFirstLayoutComplete && !this.mDataSetHasChangedAfterLayout && !this.mAdapterHelper.d()) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   void initAdapterManager() {
      this.mAdapterHelper = new AdapterHelper(new AdapterHelper.Callback(this) {
         final RecyclerView a;

         {
            this.a = var1;
         }

         @Override
         public RecyclerView.ViewHolder a(int var1) {
            RecyclerView.ViewHolder var2 = null;
            RecyclerView.ViewHolder var3 = this.a.findViewHolderForPosition(var1, true);
            if (var3 != null && !this.a.mChildHelper.c(var3.itemView)) {
               var2 = var3;
            }

            return var2;
         }

         @Override
         public void a(int var1, int var2) {
            this.a.offsetPositionRecordsForRemove(var1, var2, true);
            this.a.mItemsAddedOrRemoved = true;
            RecyclerView.State var3 = this.a.mState;
            var3.b += var2;
         }

         @Override
         public void a(int var1, int var2, Object var3) {
            this.a.viewRangeUpdate(var1, var2, var3);
            this.a.mItemsChanged = true;
         }

         @Override
         public void a(AdapterHelper.UpdateOp var1) {
            this.c(var1);
         }

         @Override
         public void b(int var1, int var2) {
            this.a.offsetPositionRecordsForRemove(var1, var2, false);
            this.a.mItemsAddedOrRemoved = true;
         }

         @Override
         public void b(AdapterHelper.UpdateOp var1) {
            this.c(var1);
         }

         @Override
         public void c(int var1, int var2) {
            this.a.offsetPositionRecordsForInsert(var1, var2);
            this.a.mItemsAddedOrRemoved = true;
         }

         void c(AdapterHelper.UpdateOp var1) {
            switch (var1.a) {
               case 1:
                  this.a.mLayout.a(this.a, var1.b, var1.d);
                  break;
               case 2:
                  this.a.mLayout.b(this.a, var1.b, var1.d);
               case 3:
               case 5:
               case 6:
               case 7:
               default:
                  break;
               case 4:
                  this.a.mLayout.a(this.a, var1.b, var1.d, var1.c);
                  break;
               case 8:
                  this.a.mLayout.a(this.a, var1.b, var1.d, 1);
            }
         }

         @Override
         public void d(int var1, int var2) {
            this.a.offsetPositionRecordsForMove(var1, var2);
            this.a.mItemsAddedOrRemoved = true;
         }
      });
   }

   void initFastScroller(StateListDrawable var1, Drawable var2, StateListDrawable var3, Drawable var4) {
      if (var1 != null && var2 != null && var3 != null && var4 != null) {
         Resources var5 = this.getContext().getResources();
         new FastScroller(
            this,
            var1,
            var2,
            var3,
            var4,
            var5.getDimensionPixelSize(R.dimen.fastscroll_default_thickness),
            var5.getDimensionPixelSize(R.dimen.fastscroll_minimum_range),
            var5.getDimensionPixelOffset(R.dimen.fastscroll_margin)
         );
      } else {
         throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + this.exceptionLabel());
      }
   }

   void invalidateGlows() {
      this.mBottomGlow = null;
      this.mTopGlow = null;
      this.mRightGlow = null;
      this.mLeftGlow = null;
   }

   public void invalidateItemDecorations() {
      if (this.mItemDecorations.size() != 0) {
         if (this.mLayout != null) {
            this.mLayout.a("Cannot invalidate item decorations during a scroll or layout");
         }

         this.markItemDecorInsetsDirty();
         this.requestLayout();
      }
   }

   boolean isAccessibilityEnabled() {
      boolean var1;
      if (this.mAccessibilityManager != null && this.mAccessibilityManager.isEnabled()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean isAnimating() {
      boolean var1;
      if (this.mItemAnimator != null && this.mItemAnimator.b()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean isAttachedToWindow() {
      return this.mIsAttached;
   }

   public boolean isComputingLayout() {
      boolean var1;
      if (this.mLayoutOrScrollCounter > 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean isLayoutFrozen() {
      return this.mLayoutFrozen;
   }

   @Override
   public boolean isNestedScrollingEnabled() {
      return this.getScrollingChildHelper().a();
   }

   void jumpToPositionForSmoothScroller(int var1) {
      if (this.mLayout != null) {
         this.mLayout.e(var1);
         this.awakenScrollBars();
      }
   }

   void markItemDecorInsetsDirty() {
      int var2 = this.mChildHelper.c();

      for (int var1 = 0; var1 < var2; var1++) {
         ((RecyclerView.LayoutParams)this.mChildHelper.d(var1).getLayoutParams()).e = true;
      }

      this.mRecycler.j();
   }

   void markKnownViewsInvalid() {
      int var2 = this.mChildHelper.c();

      for (int var1 = 0; var1 < var2; var1++) {
         RecyclerView.ViewHolder var3 = getChildViewHolderInt(this.mChildHelper.d(var1));
         if (var3 != null && !var3.shouldIgnore()) {
            var3.addFlags(6);
         }
      }

      this.markItemDecorInsetsDirty();
      this.mRecycler.h();
   }

   public void offsetChildrenHorizontal(int var1) {
      int var3 = this.mChildHelper.b();

      for (int var2 = 0; var2 < var3; var2++) {
         this.mChildHelper.b(var2).offsetLeftAndRight(var1);
      }
   }

   public void offsetChildrenVertical(int var1) {
      int var3 = this.mChildHelper.b();

      for (int var2 = 0; var2 < var3; var2++) {
         this.mChildHelper.b(var2).offsetTopAndBottom(var1);
      }
   }

   void offsetPositionRecordsForInsert(int var1, int var2) {
      int var4 = this.mChildHelper.c();

      for (int var3 = 0; var3 < var4; var3++) {
         RecyclerView.ViewHolder var5 = getChildViewHolderInt(this.mChildHelper.d(var3));
         if (var5 != null && !var5.shouldIgnore() && var5.mPosition >= var1) {
            var5.offsetPosition(var2, false);
            this.mState.e = true;
         }
      }

      this.mRecycler.b(var1, var2);
      this.requestLayout();
   }

   void offsetPositionRecordsForMove(int var1, int var2) {
      int var7 = this.mChildHelper.c();
      int var3;
      int var4;
      byte var5;
      if (var1 < var2) {
         var5 = -1;
         var3 = var2;
         var4 = var1;
      } else {
         var5 = 1;
         var3 = var1;
         var4 = var2;
      }

      for (int var6 = 0; var6 < var7; var6++) {
         RecyclerView.ViewHolder var8 = getChildViewHolderInt(this.mChildHelper.d(var6));
         if (var8 != null && var8.mPosition >= var4 && var8.mPosition <= var3) {
            if (var8.mPosition == var1) {
               var8.offsetPosition(var2 - var1, false);
            } else {
               var8.offsetPosition(var5, false);
            }

            this.mState.e = true;
         }
      }

      this.mRecycler.a(var1, var2);
      this.requestLayout();
   }

   void offsetPositionRecordsForRemove(int var1, int var2, boolean var3) {
      int var5 = this.mChildHelper.c();

      for (int var4 = 0; var4 < var5; var4++) {
         RecyclerView.ViewHolder var6 = getChildViewHolderInt(this.mChildHelper.d(var4));
         if (var6 != null && !var6.shouldIgnore()) {
            if (var6.mPosition >= var1 + var2) {
               var6.offsetPosition(-var2, var3);
               this.mState.e = true;
            } else if (var6.mPosition >= var1) {
               var6.flagRemovedAndOffsetPosition(var1 - 1, -var2, var3);
               this.mState.e = true;
            }
         }
      }

      this.mRecycler.a(var1, var2, var3);
      this.requestLayout();
   }

   protected void onAttachedToWindow() {
      boolean var2 = true;
      super.onAttachedToWindow();
      this.mLayoutOrScrollCounter = 0;
      this.mIsAttached = true;
      if (!this.mFirstLayoutComplete || this.isLayoutRequested()) {
         var2 = false;
      }

      this.mFirstLayoutComplete = var2;
      if (this.mLayout != null) {
         this.mLayout.c(this);
      }

      this.mPostedAnimatorRunner = false;
      if (ALLOW_THREAD_GAP_WORK) {
         this.mGapWorker = GapWorker.a.get();
         if (this.mGapWorker == null) {
            float var1;
            label25: {
               this.mGapWorker = new GapWorker();
               Display var3 = ViewCompat.D(this);
               if (!this.isInEditMode() && var3 != null) {
                  var1 = var3.getRefreshRate();
                  if (var1 >= 30.0F) {
                     break label25;
                  }
               }

               var1 = 60.0F;
            }

            this.mGapWorker.d = (long)(1.0E9F / var1);
            GapWorker.a.set(this.mGapWorker);
         }

         this.mGapWorker.a(this);
      }
   }

   public void onChildAttachedToWindow(View var1) {
   }

   public void onChildDetachedFromWindow(View var1) {
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      if (this.mItemAnimator != null) {
         this.mItemAnimator.d();
      }

      this.stopScroll();
      this.mIsAttached = false;
      if (this.mLayout != null) {
         this.mLayout.b(this, this.mRecycler);
      }

      this.mPendingAccessibilityImportanceChange.clear();
      this.removeCallbacks(this.mItemAnimatorRunner);
      this.mViewInfoStore.b();
      if (ALLOW_THREAD_GAP_WORK && this.mGapWorker != null) {
         this.mGapWorker.b(this);
         this.mGapWorker = null;
      }
   }

   public void onDraw(Canvas var1) {
      super.onDraw(var1);
      int var3 = this.mItemDecorations.size();

      for (int var2 = 0; var2 < var3; var2++) {
         this.mItemDecorations.get(var2).b(var1, this, this.mState);
      }
   }

   void onEnterLayoutOrScroll() {
      this.mLayoutOrScrollCounter++;
   }

   void onExitLayoutOrScroll() {
      this.onExitLayoutOrScroll(true);
   }

   void onExitLayoutOrScroll(boolean var1) {
      this.mLayoutOrScrollCounter--;
      if (this.mLayoutOrScrollCounter < 1) {
         this.mLayoutOrScrollCounter = 0;
         if (var1) {
            this.dispatchContentChangedIfNecessary();
            this.dispatchPendingImportantForAccessibilityChanges();
         }
      }
   }

   public boolean onGenericMotionEvent(MotionEvent var1) {
      if (this.mLayout != null && !this.mLayoutFrozen && var1.getAction() == 8) {
         float var3;
         float var5;
         if ((var1.getSource() & 2) != 0) {
            if (this.mLayout.f()) {
               var5 = -var1.getAxisValue(9);
            } else {
               var5 = 0.0F;
            }

            if (this.mLayout.e()) {
               float var4 = var1.getAxisValue(10);
               var3 = var5;
               var5 = var4;
            } else {
               var3 = var5;
               var5 = 0.0F;
            }
         } else if ((var1.getSource() & 4194304) != 0) {
            var5 = var1.getAxisValue(26);
            if (this.mLayout.f()) {
               var3 = -var5;
               var5 = 0.0F;
            } else if (this.mLayout.e()) {
               var3 = 0.0F;
            } else {
               var5 = 0.0F;
               var3 = 0.0F;
            }
         } else {
            var5 = 0.0F;
            var3 = 0.0F;
         }

         if (var3 != 0.0F || var5 != 0.0F) {
            this.scrollByInternal((int)(var5 * this.mScaledHorizontalScrollFactor), (int)(this.mScaledVerticalScrollFactor * var3), var1);
         }
      }

      return false;
   }

   public boolean onInterceptTouchEvent(MotionEvent var1) {
      boolean var7 = false;
      boolean var6;
      if (this.mLayoutFrozen) {
         var6 = var7;
      } else if (this.dispatchOnItemTouchIntercept(var1)) {
         this.cancelTouch();
         var6 = true;
      } else {
         var6 = var7;
         if (this.mLayout != null) {
            var6 = this.mLayout.e();
            boolean var8 = this.mLayout.f();
            if (this.mVelocityTracker == null) {
               this.mVelocityTracker = VelocityTracker.obtain();
            }

            this.mVelocityTracker.addMovement(var1);
            int var3 = var1.getActionMasked();
            int var2 = var1.getActionIndex();
            switch (var3) {
               case 0:
                  if (this.mIgnoreMotionEventTillDown) {
                     this.mIgnoreMotionEventTillDown = false;
                  }

                  this.mScrollPointerId = var1.getPointerId(0);
                  var2 = (int)(var1.getX() + 0.5F);
                  this.mLastTouchX = var2;
                  this.mInitialTouchX = var2;
                  var2 = (int)(var1.getY() + 0.5F);
                  this.mLastTouchY = var2;
                  this.mInitialTouchY = var2;
                  if (this.mScrollState == 2) {
                     this.getParent().requestDisallowInterceptTouchEvent(true);
                     this.setScrollState(1);
                  }

                  int[] var9 = this.mNestedOffsets;
                  this.mNestedOffsets[1] = 0;
                  var9[0] = 0;
                  byte var15;
                  if (var6) {
                     var15 = 1;
                  } else {
                     var15 = 0;
                  }

                  var3 = var15;
                  if (var8) {
                     var3 = var15 | 2;
                  }

                  this.startNestedScroll(var3, 0);
                  break;
               case 1:
                  this.mVelocityTracker.clear();
                  this.stopNestedScroll(0);
                  break;
               case 2:
                  var3 = var1.findPointerIndex(this.mScrollPointerId);
                  if (var3 < 0) {
                     Log.e(
                        "RecyclerView",
                        "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?"
                     );
                     var6 = var7;
                     return var6;
                  }

                  var2 = (int)(var1.getX(var3) + 0.5F);
                  int var4 = (int)(var1.getY(var3) + 0.5F);
                  if (this.mScrollState != 1) {
                     var3 = this.mInitialTouchX;
                     int var5 = this.mInitialTouchY;
                     boolean var12;
                     if (var6 && Math.abs(var2 - var3) > this.mTouchSlop) {
                        this.mLastTouchX = var2;
                        var12 = true;
                     } else {
                        var12 = false;
                     }

                     boolean var19 = var12;
                     if (var8) {
                        var19 = var12;
                        if (Math.abs(var4 - var5) > this.mTouchSlop) {
                           this.mLastTouchY = var4;
                           var19 = true;
                        }
                     }

                     if (var19) {
                        this.setScrollState(1);
                     }
                  }
                  break;
               case 3:
                  this.cancelTouch();
               case 4:
               default:
                  break;
               case 5:
                  this.mScrollPointerId = var1.getPointerId(var2);
                  var3 = (int)(var1.getX(var2) + 0.5F);
                  this.mLastTouchX = var3;
                  this.mInitialTouchX = var3;
                  var2 = (int)(var1.getY(var2) + 0.5F);
                  this.mLastTouchY = var2;
                  this.mInitialTouchY = var2;
                  break;
               case 6:
                  this.onPointerUp(var1);
            }

            if (this.mScrollState == 1) {
               var6 = true;
            } else {
               var6 = false;
            }
         }
      }

      return var6;
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      TraceCompat.a("RV OnLayout");
      this.dispatchLayout();
      TraceCompat.a();
      this.mFirstLayoutComplete = true;
   }

   protected void onMeasure(int var1, int var2) {
      boolean var4 = false;
      if (this.mLayout == null) {
         this.defaultOnMeasure(var1, var2);
      } else if (this.mLayout.c()) {
         int var5 = MeasureSpec.getMode(var1);
         int var6 = MeasureSpec.getMode(var2);
         this.mLayout.a(this.mRecycler, this.mState, var1, var2);
         boolean var3 = var4;
         if (var5 == 1073741824) {
            var3 = var4;
            if (var6 == 1073741824) {
               var3 = true;
            }
         }

         if (!var3 && this.mAdapter != null) {
            if (this.mState.c == 1) {
               this.dispatchLayoutStep1();
            }

            this.mLayout.d(var1, var2);
            this.mState.h = true;
            this.dispatchLayoutStep2();
            this.mLayout.e(var1, var2);
            if (this.mLayout.l()) {
               this.mLayout
                  .d(MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(this.getMeasuredHeight(), 1073741824));
               this.mState.h = true;
               this.dispatchLayoutStep2();
               this.mLayout.e(var1, var2);
            }
         }
      } else if (this.mHasFixedSize) {
         this.mLayout.a(this.mRecycler, this.mState, var1, var2);
      } else {
         if (this.mAdapterUpdateDuringMeasure) {
            this.startInterceptRequestLayout();
            this.onEnterLayoutOrScroll();
            this.processAdapterUpdatesAndSetAnimationFlags();
            this.onExitLayoutOrScroll();
            if (this.mState.j) {
               this.mState.f = true;
            } else {
               this.mAdapterHelper.e();
               this.mState.f = false;
            }

            this.mAdapterUpdateDuringMeasure = false;
            this.stopInterceptRequestLayout(false);
         } else if (this.mState.j) {
            this.setMeasuredDimension(this.getMeasuredWidth(), this.getMeasuredHeight());
            return;
         }

         if (this.mAdapter != null) {
            this.mState.d = this.mAdapter.getItemCount();
         } else {
            this.mState.d = 0;
         }

         this.startInterceptRequestLayout();
         this.mLayout.a(this.mRecycler, this.mState, var1, var2);
         this.stopInterceptRequestLayout(false);
         this.mState.f = false;
      }
   }

   protected boolean onRequestFocusInDescendants(int var1, Rect var2) {
      boolean var3;
      if (this.isComputingLayout()) {
         var3 = false;
      } else {
         var3 = super.onRequestFocusInDescendants(var1, var2);
      }

      return var3;
   }

   protected void onRestoreInstanceState(Parcelable var1) {
      if (!(var1 instanceof RecyclerView.SavedState)) {
         super.onRestoreInstanceState(var1);
      } else {
         this.mPendingSavedState = (RecyclerView.SavedState)var1;
         super.onRestoreInstanceState(this.mPendingSavedState.a());
         if (this.mLayout != null && this.mPendingSavedState.a != null) {
            this.mLayout.a(this.mPendingSavedState.a);
         }
      }
   }

   protected Parcelable onSaveInstanceState() {
      RecyclerView.SavedState var1 = new RecyclerView.SavedState(super.onSaveInstanceState());
      if (this.mPendingSavedState != null) {
         var1.a(this.mPendingSavedState);
      } else if (this.mLayout != null) {
         var1.a = this.mLayout.d();
      } else {
         var1.a = null;
      }

      return var1;
   }

   public void onScrollStateChanged(int var1) {
   }

   public void onScrolled(int var1, int var2) {
   }

   protected void onSizeChanged(int var1, int var2, int var3, int var4) {
      super.onSizeChanged(var1, var2, var3, var4);
      if (var1 != var3 || var2 != var4) {
         this.invalidateGlows();
      }
   }

   public boolean onTouchEvent(MotionEvent var1) {
      boolean var10 = false;
      boolean var14 = false;
      boolean var13 = var14;
      if (!this.mLayoutFrozen) {
         if (this.mIgnoreMotionEventTillDown) {
            var13 = var14;
         } else if (this.dispatchOnItemTouch(var1)) {
            this.cancelTouch();
            var13 = true;
         } else {
            var13 = var14;
            if (this.mLayout != null) {
               var13 = this.mLayout.e();
               boolean var15 = this.mLayout.f();
               if (this.mVelocityTracker == null) {
                  this.mVelocityTracker = VelocityTracker.obtain();
               }

               MotionEvent var16 = MotionEvent.obtain(var1);
               int var6 = var1.getActionMasked();
               int var5 = var1.getActionIndex();
               if (var6 == 0) {
                  int[] var17 = this.mNestedOffsets;
                  this.mNestedOffsets[1] = 0;
                  var17[0] = 0;
               }

               var16.offsetLocation(this.mNestedOffsets[0], this.mNestedOffsets[1]);
               int var4 = var10;
               switch (var6) {
                  case 0:
                     this.mScrollPointerId = var1.getPointerId(0);
                     var4 = (int)(var1.getX() + 0.5F);
                     this.mLastTouchX = var4;
                     this.mInitialTouchX = var4;
                     var4 = (int)(var1.getY() + 0.5F);
                     this.mLastTouchY = var4;
                     this.mInitialTouchY = var4;
                     byte var28;
                     if (var13) {
                        var28 = 1;
                     } else {
                        var28 = 0;
                     }

                     var5 = var28;
                     if (var15) {
                        var5 = var28 | 2;
                     }

                     this.startNestedScroll(var5, 0);
                     var4 = var10;
                     break;
                  case 1:
                     this.mVelocityTracker.addMovement(var16);
                     this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxFlingVelocity);
                     float var2;
                     if (var13) {
                        var2 = -this.mVelocityTracker.getXVelocity(this.mScrollPointerId);
                     } else {
                        var2 = 0.0F;
                     }

                     float var3;
                     if (var15) {
                        var3 = -this.mVelocityTracker.getYVelocity(this.mScrollPointerId);
                     } else {
                        var3 = 0.0F;
                     }

                     if (var2 == 0.0F && var3 == 0.0F || !this.fling((int)var2, (int)var3)) {
                        this.setScrollState(0);
                     }

                     this.resetTouch();
                     var4 = 1;
                     break;
                  case 2:
                     var4 = var1.findPointerIndex(this.mScrollPointerId);
                     if (var4 < 0) {
                        Log.e(
                           "RecyclerView",
                           "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?"
                        );
                        var13 = var14;
                        return var13;
                     }

                     int var11 = (int)(var1.getX(var4) + 0.5F);
                     int var12 = (int)(var1.getY(var4) + 0.5F);
                     int var7 = this.mLastTouchX - var11;
                     var6 = this.mLastTouchY - var12;
                     var5 = var7;
                     var4 = var6;
                     if (this.dispatchNestedPreScroll(var7, var6, this.mScrollConsumed, this.mScrollOffset, 0)) {
                        var5 = var7 - this.mScrollConsumed[0];
                        var4 = var6 - this.mScrollConsumed[1];
                        var16.offsetLocation(this.mScrollOffset[0], this.mScrollOffset[1]);
                        int[] var18 = this.mNestedOffsets;
                        var18[0] += this.mScrollOffset[0];
                        int[] var19 = this.mNestedOffsets;
                        var19[1] += this.mScrollOffset[1];
                     }

                     var6 = var5;
                     var7 = var4;
                     if (this.mScrollState != 1) {
                        boolean var34;
                        if (var13 && Math.abs(var5) > this.mTouchSlop) {
                           if (var5 > 0) {
                              var5 -= this.mTouchSlop;
                           } else {
                              var5 += this.mTouchSlop;
                           }

                           var34 = true;
                        } else {
                           var34 = false;
                        }

                        boolean var9 = var34;
                        int var8 = var4;
                        if (var15) {
                           var9 = var34;
                           var8 = var4;
                           if (Math.abs(var4) > this.mTouchSlop) {
                              if (var4 > 0) {
                                 var4 -= this.mTouchSlop;
                              } else {
                                 var4 = this.mTouchSlop + var4;
                              }

                              var9 = true;
                              var8 = var4;
                           }
                        }

                        var6 = var5;
                        var7 = var8;
                        if (var9) {
                           this.setScrollState(1);
                           var7 = var8;
                           var6 = var5;
                        }
                     }

                     var4 = var10;
                     if (this.mScrollState == 1) {
                        this.mLastTouchX = var11 - this.mScrollOffset[0];
                        this.mLastTouchY = var12 - this.mScrollOffset[1];
                        if (var13) {
                           var4 = var6;
                        } else {
                           var4 = 0;
                        }

                        if (var15) {
                           var5 = var7;
                        } else {
                           var5 = 0;
                        }

                        if (this.scrollByInternal(var4, var5, var16)) {
                           this.getParent().requestDisallowInterceptTouchEvent(true);
                        }

                        var4 = var10;
                        if (this.mGapWorker != null) {
                           if (var6 == 0) {
                              var4 = var10;
                              if (var7 == 0) {
                                 break;
                              }
                           }

                           this.mGapWorker.a(this, var6, var7);
                           var4 = var10;
                        }
                     }
                     break;
                  case 3:
                     this.cancelTouch();
                     var4 = var10;
                  case 4:
                     break;
                  case 5:
                     this.mScrollPointerId = var1.getPointerId(var5);
                     var4 = (int)(var1.getX(var5) + 0.5F);
                     this.mLastTouchX = var4;
                     this.mInitialTouchX = var4;
                     var4 = (int)(var1.getY(var5) + 0.5F);
                     this.mLastTouchY = var4;
                     this.mInitialTouchY = var4;
                     var4 = var10;
                     break;
                  case 6:
                     this.onPointerUp(var1);
                     var4 = var10;
                     break;
                  default:
                     var4 = var10;
               }

               if (!var4) {
                  this.mVelocityTracker.addMovement(var16);
               }

               var16.recycle();
               var13 = true;
            }
         }
      }

      return var13;
   }

   void postAnimationRunner() {
      if (!this.mPostedAnimatorRunner && this.mIsAttached) {
         ViewCompat.a(this, this.mItemAnimatorRunner);
         this.mPostedAnimatorRunner = true;
      }
   }

   void processDataSetCompletelyChanged(boolean var1) {
      this.mDispatchItemsChangedEvent |= var1;
      this.mDataSetHasChangedAfterLayout = true;
      this.markKnownViewsInvalid();
   }

   void recordAnimationInfoIfBouncedHiddenView(RecyclerView.ViewHolder var1, RecyclerView.ItemAnimator.ItemHolderInfo var2) {
      var1.setFlags(0, 8192);
      if (this.mState.g && var1.isUpdated() && !var1.isRemoved() && !var1.shouldIgnore()) {
         long var3 = this.getChangedHolderKey(var1);
         this.mViewInfoStore.a(var3, var1);
      }

      this.mViewInfoStore.a(var1, var2);
   }

   void removeAndRecycleViews() {
      if (this.mItemAnimator != null) {
         this.mItemAnimator.d();
      }

      if (this.mLayout != null) {
         this.mLayout.c(this.mRecycler);
         this.mLayout.b(this.mRecycler);
      }

      this.mRecycler.a();
   }

   boolean removeAnimatingView(View var1) {
      this.startInterceptRequestLayout();
      boolean var3 = this.mChildHelper.f(var1);
      if (var3) {
         RecyclerView.ViewHolder var4 = getChildViewHolderInt(var1);
         this.mRecycler.c(var4);
         this.mRecycler.b(var4);
      }

      boolean var2;
      if (!var3) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.stopInterceptRequestLayout(var2);
      return var3;
   }

   protected void removeDetachedView(View var1, boolean var2) {
      RecyclerView.ViewHolder var3 = getChildViewHolderInt(var1);
      if (var3 != null) {
         if (var3.isTmpDetached()) {
            var3.clearTmpDetachFlag();
         } else if (!var3.shouldIgnore()) {
            throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + var3 + this.exceptionLabel());
         }
      }

      var1.clearAnimation();
      this.dispatchChildDetached(var1);
      super.removeDetachedView(var1, var2);
   }

   public void removeItemDecoration(RecyclerView.ItemDecoration var1) {
      if (this.mLayout != null) {
         this.mLayout.a("Cannot remove item decoration during a scroll  or layout");
      }

      this.mItemDecorations.remove(var1);
      if (this.mItemDecorations.isEmpty()) {
         boolean var2;
         if (this.getOverScrollMode() == 2) {
            var2 = true;
         } else {
            var2 = false;
         }

         this.setWillNotDraw(var2);
      }

      this.markItemDecorInsetsDirty();
      this.requestLayout();
   }

   public void removeItemDecorationAt(int var1) {
      int var2 = this.getItemDecorationCount();
      if (var1 >= 0 && var1 < var2) {
         this.removeItemDecoration(this.getItemDecorationAt(var1));
      } else {
         throw new IndexOutOfBoundsException(var1 + " is an invalid index for size " + var2);
      }
   }

   public void removeOnChildAttachStateChangeListener(RecyclerView.OnChildAttachStateChangeListener var1) {
      if (this.mOnChildAttachStateListeners != null) {
         this.mOnChildAttachStateListeners.remove(var1);
      }
   }

   public void removeOnItemTouchListener(RecyclerView.OnItemTouchListener var1) {
      this.mOnItemTouchListeners.remove(var1);
      if (this.mActiveOnItemTouchListener == var1) {
         this.mActiveOnItemTouchListener = null;
      }
   }

   public void removeOnScrollListener(RecyclerView.OnScrollListener var1) {
      if (this.mScrollListeners != null) {
         this.mScrollListeners.remove(var1);
      }
   }

   void repositionShadowingViews() {
      int var2 = this.mChildHelper.b();

      for (int var1 = 0; var1 < var2; var1++) {
         View var5 = this.mChildHelper.b(var1);
         RecyclerView.ViewHolder var6 = this.getChildViewHolder(var5);
         if (var6 != null && var6.mShadowingHolder != null) {
            View var7 = var6.mShadowingHolder.itemView;
            int var4 = var5.getLeft();
            int var3 = var5.getTop();
            if (var4 != var7.getLeft() || var3 != var7.getTop()) {
               var7.layout(var4, var3, var7.getWidth() + var4, var7.getHeight() + var3);
            }
         }
      }
   }

   public void requestChildFocus(View var1, View var2) {
      if (!this.mLayout.a(this, this.mState, var1, var2) && var2 != null) {
         this.requestChildOnScreen(var1, var2);
      }

      super.requestChildFocus(var1, var2);
   }

   public boolean requestChildRectangleOnScreen(View var1, Rect var2, boolean var3) {
      return this.mLayout.a(this, var1, var2, var3);
   }

   public void requestDisallowInterceptTouchEvent(boolean var1) {
      int var3 = this.mOnItemTouchListeners.size();

      for (int var2 = 0; var2 < var3; var2++) {
         this.mOnItemTouchListeners.get(var2).a(var1);
      }

      super.requestDisallowInterceptTouchEvent(var1);
   }

   public void requestLayout() {
      if (this.mInterceptRequestLayoutDepth == 0 && !this.mLayoutFrozen) {
         super.requestLayout();
      } else {
         this.mLayoutWasDefered = true;
      }
   }

   void saveOldPositions() {
      int var2 = this.mChildHelper.c();

      for (int var1 = 0; var1 < var2; var1++) {
         RecyclerView.ViewHolder var3 = getChildViewHolderInt(this.mChildHelper.d(var1));
         if (!var3.shouldIgnore()) {
            var3.saveOldPosition();
         }
      }
   }

   public void scrollBy(int var1, int var2) {
      if (this.mLayout == null) {
         Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      } else if (!this.mLayoutFrozen) {
         boolean var3 = this.mLayout.e();
         boolean var4 = this.mLayout.f();
         if (var3 || var4) {
            if (!var3) {
               var1 = 0;
            }

            if (!var4) {
               var2 = 0;
            }

            this.scrollByInternal(var1, var2, null);
         }
      }
   }

   boolean scrollByInternal(int var1, int var2, MotionEvent var3) {
      boolean var9 = false;
      this.consumePendingUpdateOperations();
      int var5;
      int var12;
      int var13;
      int var14;
      if (this.mAdapter != null) {
         this.startInterceptRequestLayout();
         this.onEnterLayoutOrScroll();
         TraceCompat.a("RV Scroll");
         this.fillRemainingScrollValues(this.mState);
         if (var1 != 0) {
            var5 = this.mLayout.a(var1, this.mRecycler, this.mState);
            var12 = var1 - var5;
         } else {
            var5 = 0;
            var12 = 0;
         }

         if (var2 != 0) {
            var13 = this.mLayout.b(var2, this.mRecycler, this.mState);
            var14 = var2 - var13;
         } else {
            var13 = 0;
            var14 = 0;
         }

         TraceCompat.a();
         this.repositionShadowingViews();
         this.onExitLayoutOrScroll();
         this.stopInterceptRequestLayout(false);
         int var8 = var13;
         var13 = var14;
         var14 = var12;
         var12 = var8;
      } else {
         var12 = 0;
         var5 = 0;
         var13 = 0;
         var14 = 0;
      }

      if (!this.mItemDecorations.isEmpty()) {
         this.invalidate();
      }

      if (this.dispatchNestedScroll(var5, var12, var14, var13, this.mScrollOffset, 0)) {
         this.mLastTouchX = this.mLastTouchX - this.mScrollOffset[0];
         this.mLastTouchY = this.mLastTouchY - this.mScrollOffset[1];
         if (var3 != null) {
            var3.offsetLocation(this.mScrollOffset[0], this.mScrollOffset[1]);
         }

         int[] var10 = this.mNestedOffsets;
         var10[0] += this.mScrollOffset[0];
         int[] var11 = this.mNestedOffsets;
         var11[1] += this.mScrollOffset[1];
      } else if (this.getOverScrollMode() != 2) {
         if (var3 != null && !MotionEventCompat.a(var3, 8194)) {
            this.pullGlows(var3.getX(), var14, var3.getY(), var13);
         }

         this.considerReleasingGlowsOnScroll(var1, var2);
      }

      if (var5 != 0 || var12 != 0) {
         this.dispatchOnScrolled(var5, var12);
      }

      if (!this.awakenScrollBars()) {
         this.invalidate();
      }

      if (var5 != 0 || var12 != 0) {
         var9 = true;
      }

      return var9;
   }

   public void scrollTo(int var1, int var2) {
      Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
   }

   public void scrollToPosition(int var1) {
      if (!this.mLayoutFrozen) {
         this.stopScroll();
         if (this.mLayout == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
         } else {
            this.mLayout.e(var1);
            this.awakenScrollBars();
         }
      }
   }

   public void sendAccessibilityEventUnchecked(AccessibilityEvent var1) {
      if (!this.shouldDeferAccessibilityEvent(var1)) {
         super.sendAccessibilityEventUnchecked(var1);
      }
   }

   public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate var1) {
      this.mAccessibilityDelegate = var1;
      ViewCompat.a(this, this.mAccessibilityDelegate);
   }

   public void setAdapter(RecyclerView.Adapter var1) {
      this.setLayoutFrozen(false);
      this.setAdapterInternal(var1, false, true);
      this.processDataSetCompletelyChanged(false);
      this.requestLayout();
   }

   public void setChildDrawingOrderCallback(RecyclerView.ChildDrawingOrderCallback var1) {
      if (var1 != this.mChildDrawingOrderCallback) {
         this.mChildDrawingOrderCallback = var1;
         boolean var2;
         if (this.mChildDrawingOrderCallback != null) {
            var2 = true;
         } else {
            var2 = false;
         }

         this.setChildrenDrawingOrderEnabled(var2);
      }
   }

   boolean setChildImportantForAccessibilityInternal(RecyclerView.ViewHolder var1, int var2) {
      boolean var3;
      if (this.isComputingLayout()) {
         var1.mPendingAccessibilityState = var2;
         this.mPendingAccessibilityImportanceChange.add(var1);
         var3 = false;
      } else {
         ViewCompat.a(var1.itemView, var2);
         var3 = true;
      }

      return var3;
   }

   public void setClipToPadding(boolean var1) {
      if (var1 != this.mClipToPadding) {
         this.invalidateGlows();
      }

      this.mClipToPadding = var1;
      super.setClipToPadding(var1);
      if (this.mFirstLayoutComplete) {
         this.requestLayout();
      }
   }

   public void setEdgeEffectFactory(RecyclerView.EdgeEffectFactory var1) {
      Preconditions.a(var1);
      this.mEdgeEffectFactory = var1;
      this.invalidateGlows();
   }

   public void setHasFixedSize(boolean var1) {
      this.mHasFixedSize = var1;
   }

   public void setItemAnimator(RecyclerView.ItemAnimator var1) {
      if (this.mItemAnimator != null) {
         this.mItemAnimator.d();
         this.mItemAnimator.a((RecyclerView.ItemAnimator.ItemAnimatorListener)null);
      }

      this.mItemAnimator = var1;
      if (this.mItemAnimator != null) {
         this.mItemAnimator.a(this.mItemAnimatorListener);
      }
   }

   public void setItemViewCacheSize(int var1) {
      this.mRecycler.a(var1);
   }

   public void setLayoutFrozen(boolean var1) {
      if (var1 != this.mLayoutFrozen) {
         this.assertNotInLayoutOrScroll("Do not setLayoutFrozen in layout or scroll");
         if (!var1) {
            this.mLayoutFrozen = false;
            if (this.mLayoutWasDefered && this.mLayout != null && this.mAdapter != null) {
               this.requestLayout();
            }

            this.mLayoutWasDefered = false;
         } else {
            long var2 = SystemClock.uptimeMillis();
            this.onTouchEvent(MotionEvent.obtain(var2, var2, 3, 0.0F, 0.0F, 0));
            this.mLayoutFrozen = true;
            this.mIgnoreMotionEventTillDown = true;
            this.stopScroll();
         }
      }
   }

   public void setLayoutManager(RecyclerView.LayoutManager var1) {
      if (var1 != this.mLayout) {
         this.stopScroll();
         if (this.mLayout != null) {
            if (this.mItemAnimator != null) {
               this.mItemAnimator.d();
            }

            this.mLayout.c(this.mRecycler);
            this.mLayout.b(this.mRecycler);
            this.mRecycler.a();
            if (this.mIsAttached) {
               this.mLayout.b(this, this.mRecycler);
            }

            this.mLayout.b((RecyclerView)null);
            this.mLayout = null;
         } else {
            this.mRecycler.a();
         }

         this.mChildHelper.a();
         this.mLayout = var1;
         if (var1 != null) {
            if (var1.q != null) {
               throw new IllegalArgumentException("LayoutManager " + var1 + " is already attached to a RecyclerView:" + var1.q.exceptionLabel());
            }

            this.mLayout.b(this);
            if (this.mIsAttached) {
               this.mLayout.c(this);
            }
         }

         this.mRecycler.b();
         this.requestLayout();
      }
   }

   public void setNestedScrollingEnabled(boolean var1) {
      this.getScrollingChildHelper().a(var1);
   }

   public void setOnFlingListener(RecyclerView.OnFlingListener var1) {
      this.mOnFlingListener = var1;
   }

   @Deprecated
   public void setOnScrollListener(RecyclerView.OnScrollListener var1) {
      this.mScrollListener = var1;
   }

   public void setPreserveFocusAfterLayout(boolean var1) {
      this.mPreserveFocusAfterLayout = var1;
   }

   public void setRecycledViewPool(RecyclerView.RecycledViewPool var1) {
      this.mRecycler.a(var1);
   }

   public void setRecyclerListener(RecyclerView.RecyclerListener var1) {
      this.mRecyclerListener = var1;
   }

   void setScrollState(int var1) {
      if (var1 != this.mScrollState) {
         this.mScrollState = var1;
         if (var1 != 2) {
            this.stopScrollersInternal();
         }

         this.dispatchOnScrollStateChanged(var1);
      }
   }

   public void setScrollingTouchSlop(int var1) {
      ViewConfiguration var2 = ViewConfiguration.get(this.getContext());
      switch (var1) {
         case 1:
            this.mTouchSlop = var2.getScaledPagingTouchSlop();
            break;
         default:
            Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + var1 + "; using default value");
         case 0:
            this.mTouchSlop = var2.getScaledTouchSlop();
      }
   }

   public void setViewCacheExtension(RecyclerView.ViewCacheExtension var1) {
      this.mRecycler.a(var1);
   }

   boolean shouldDeferAccessibilityEvent(AccessibilityEvent var1) {
      boolean var4 = false;
      byte var3 = 0;
      if (this.isComputingLayout()) {
         int var2;
         if (var1 != null) {
            var2 = AccessibilityEventCompat.a(var1);
         } else {
            var2 = 0;
         }

         if (var2 == 0) {
            var2 = var3;
         }

         this.mEatenAccessibilityChangeFlags |= var2;
         var4 = true;
      }

      return var4;
   }

   public void smoothScrollBy(int var1, int var2) {
      this.smoothScrollBy(var1, var2, null);
   }

   public void smoothScrollBy(int var1, int var2, Interpolator var3) {
      byte var4 = 0;
      if (this.mLayout == null) {
         Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      } else if (!this.mLayoutFrozen) {
         if (!this.mLayout.e()) {
            var1 = 0;
         }

         if (!this.mLayout.f()) {
            var2 = var4;
         }

         if (var1 != 0 || var2 != 0) {
            this.mViewFlinger.a(var1, var2, var3);
         }
      }
   }

   public void smoothScrollToPosition(int var1) {
      if (!this.mLayoutFrozen) {
         if (this.mLayout == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
         } else {
            this.mLayout.a(this, this.mState, var1);
         }
      }
   }

   void startInterceptRequestLayout() {
      this.mInterceptRequestLayoutDepth++;
      if (this.mInterceptRequestLayoutDepth == 1 && !this.mLayoutFrozen) {
         this.mLayoutWasDefered = false;
      }
   }

   public boolean startNestedScroll(int var1) {
      return this.getScrollingChildHelper().b(var1);
   }

   public boolean startNestedScroll(int var1, int var2) {
      return this.getScrollingChildHelper().a(var1, var2);
   }

   void stopInterceptRequestLayout(boolean var1) {
      if (this.mInterceptRequestLayoutDepth < 1) {
         this.mInterceptRequestLayoutDepth = 1;
      }

      if (!var1 && !this.mLayoutFrozen) {
         this.mLayoutWasDefered = false;
      }

      if (this.mInterceptRequestLayoutDepth == 1) {
         if (var1 && this.mLayoutWasDefered && !this.mLayoutFrozen && this.mLayout != null && this.mAdapter != null) {
            this.dispatchLayout();
         }

         if (!this.mLayoutFrozen) {
            this.mLayoutWasDefered = false;
         }
      }

      this.mInterceptRequestLayoutDepth--;
   }

   @Override
   public void stopNestedScroll() {
      this.getScrollingChildHelper().c();
   }

   public void stopNestedScroll(int var1) {
      this.getScrollingChildHelper().c(var1);
   }

   public void stopScroll() {
      this.setScrollState(0);
      this.stopScrollersInternal();
   }

   public void swapAdapter(RecyclerView.Adapter var1, boolean var2) {
      this.setLayoutFrozen(false);
      this.setAdapterInternal(var1, true, var2);
      this.processDataSetCompletelyChanged(true);
      this.requestLayout();
   }

   void viewRangeUpdate(int var1, int var2, Object var3) {
      int var5 = this.mChildHelper.c();

      for (int var4 = 0; var4 < var5; var4++) {
         View var7 = this.mChildHelper.d(var4);
         RecyclerView.ViewHolder var6 = getChildViewHolderInt(var7);
         if (var6 != null && !var6.shouldIgnore() && var6.mPosition >= var1 && var6.mPosition < var1 + var2) {
            var6.addFlags(2);
            var6.addChangePayload(var3);
            ((RecyclerView.LayoutParams)var7.getLayoutParams()).e = true;
         }
      }

      this.mRecycler.c(var1, var2);
   }

   public abstract static class Adapter<VH extends RecyclerView.ViewHolder> {
      private boolean mHasStableIds;
      private final RecyclerView.AdapterDataObservable mObservable = new RecyclerView.AdapterDataObservable();

      public Adapter() {
         this.mHasStableIds = false;
      }

      public final void bindViewHolder(VH var1, int var2) {
         var1.mPosition = var2;
         if (this.hasStableIds()) {
            var1.mItemId = this.getItemId(var2);
         }

         var1.setFlags(1, 519);
         TraceCompat.a("RV OnBindView");
         this.onBindViewHolder((VH)var1, var2, var1.getUnmodifiedPayloads());
         var1.clearPayload();
         android.view.ViewGroup.LayoutParams var3 = var1.itemView.getLayoutParams();
         if (var3 instanceof RecyclerView.LayoutParams) {
            ((RecyclerView.LayoutParams)var3).e = true;
         }

         TraceCompat.a();
      }

      public final VH createViewHolder(ViewGroup var1, int var2) {
         try {
            TraceCompat.a("RV CreateView");
            var5 = this.onCreateViewHolder(var1, var2);
            if (var5.itemView.getParent() != null) {
               IllegalStateException var6 = new IllegalStateException(
                  "ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)"
               );
               throw var6;
            }

            var5.mItemViewType = var2;
         } finally {
            TraceCompat.a();
         }

         return (VH)var5;
      }

      public abstract int getItemCount();

      public long getItemId(int var1) {
         return -1L;
      }

      public int getItemViewType(int var1) {
         return 0;
      }

      public final boolean hasObservers() {
         return this.mObservable.a();
      }

      public final boolean hasStableIds() {
         return this.mHasStableIds;
      }

      public final void notifyDataSetChanged() {
         this.mObservable.b();
      }

      public final void notifyItemChanged(int var1) {
         this.mObservable.a(var1, 1);
      }

      public final void notifyItemChanged(int var1, Object var2) {
         this.mObservable.a(var1, 1, var2);
      }

      public final void notifyItemInserted(int var1) {
         this.mObservable.b(var1, 1);
      }

      public final void notifyItemMoved(int var1, int var2) {
         this.mObservable.d(var1, var2);
      }

      public final void notifyItemRangeChanged(int var1, int var2) {
         this.mObservable.a(var1, var2);
      }

      public final void notifyItemRangeChanged(int var1, int var2, Object var3) {
         this.mObservable.a(var1, var2, var3);
      }

      public final void notifyItemRangeInserted(int var1, int var2) {
         this.mObservable.b(var1, var2);
      }

      public final void notifyItemRangeRemoved(int var1, int var2) {
         this.mObservable.c(var1, var2);
      }

      public final void notifyItemRemoved(int var1) {
         this.mObservable.c(var1, 1);
      }

      public void onAttachedToRecyclerView(RecyclerView var1) {
      }

      public abstract void onBindViewHolder(VH var1, int var2);

      public void onBindViewHolder(VH var1, int var2, List<Object> var3) {
         this.onBindViewHolder((VH)var1, var2);
      }

      public abstract VH onCreateViewHolder(ViewGroup var1, int var2);

      public void onDetachedFromRecyclerView(RecyclerView var1) {
      }

      public boolean onFailedToRecycleView(VH var1) {
         return false;
      }

      public void onViewAttachedToWindow(VH var1) {
      }

      public void onViewDetachedFromWindow(VH var1) {
      }

      public void onViewRecycled(VH var1) {
      }

      public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver var1) {
         this.mObservable.registerObserver(var1);
      }

      public void setHasStableIds(boolean var1) {
         if (this.hasObservers()) {
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
         }

         this.mHasStableIds = var1;
      }

      public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver var1) {
         this.mObservable.unregisterObserver(var1);
      }
   }

   static class AdapterDataObservable extends Observable<RecyclerView.AdapterDataObserver> {
      public void a(int var1, int var2) {
         this.a(var1, var2, null);
      }

      public void a(int var1, int var2, Object var3) {
         for (int var4 = this.mObservers.size() - 1; var4 >= 0; var4--) {
            ((RecyclerView.AdapterDataObserver)this.mObservers.get(var4)).a(var1, var2, var3);
         }
      }

      public boolean a() {
         boolean var1;
         if (!this.mObservers.isEmpty()) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      public void b() {
         for (int var1 = this.mObservers.size() - 1; var1 >= 0; var1--) {
            ((RecyclerView.AdapterDataObserver)this.mObservers.get(var1)).a();
         }
      }

      public void b(int var1, int var2) {
         for (int var3 = this.mObservers.size() - 1; var3 >= 0; var3--) {
            ((RecyclerView.AdapterDataObserver)this.mObservers.get(var3)).b(var1, var2);
         }
      }

      public void c(int var1, int var2) {
         for (int var3 = this.mObservers.size() - 1; var3 >= 0; var3--) {
            ((RecyclerView.AdapterDataObserver)this.mObservers.get(var3)).c(var1, var2);
         }
      }

      public void d(int var1, int var2) {
         for (int var3 = this.mObservers.size() - 1; var3 >= 0; var3--) {
            ((RecyclerView.AdapterDataObserver)this.mObservers.get(var3)).a(var1, var2, 1);
         }
      }
   }

   public abstract static class AdapterDataObserver {
      public void a() {
      }

      public void a(int var1, int var2) {
      }

      public void a(int var1, int var2, int var3) {
      }

      public void a(int var1, int var2, Object var3) {
         this.a(var1, var2);
      }

      public void b(int var1, int var2) {
      }

      public void c(int var1, int var2) {
      }
   }

   public interface ChildDrawingOrderCallback {
      int a(int var1, int var2);
   }

   public static class EdgeEffectFactory {
      protected EdgeEffect a(RecyclerView var1, int var2) {
         return new EdgeEffect(var1.getContext());
      }
   }

   public abstract static class ItemAnimator {
      private RecyclerView.ItemAnimator.ItemAnimatorListener a = null;
      private ArrayList<RecyclerView.ItemAnimator.ItemAnimatorFinishedListener> b = new ArrayList<>();
      private long c = 120L;
      private long d = 120L;
      private long e = 250L;
      private long f = 250L;

      static int e(RecyclerView.ViewHolder var0) {
         int var2 = var0.mFlags & 14;
         int var1;
         if (var0.isInvalid()) {
            var1 = 4;
         } else {
            var1 = var2;
            if ((var2 & 4) == 0) {
               int var4 = var0.getOldPosition();
               int var3 = var0.getAdapterPosition();
               var1 = var2;
               if (var4 != -1) {
                  var1 = var2;
                  if (var3 != -1) {
                     var1 = var2;
                     if (var4 != var3) {
                        var1 = var2 | 2048;
                     }
                  }
               }
            }
         }

         return var1;
      }

      public RecyclerView.ItemAnimator.ItemHolderInfo a(RecyclerView.State var1, RecyclerView.ViewHolder var2) {
         return this.j().a(var2);
      }

      public RecyclerView.ItemAnimator.ItemHolderInfo a(RecyclerView.State var1, RecyclerView.ViewHolder var2, int var3, List<Object> var4) {
         return this.j().a(var2);
      }

      public abstract void a();

      void a(RecyclerView.ItemAnimator.ItemAnimatorListener var1) {
         this.a = var1;
      }

      public final boolean a(RecyclerView.ItemAnimator.ItemAnimatorFinishedListener var1) {
         boolean var2 = this.b();
         if (var1 != null) {
            if (!var2) {
               var1.a();
            } else {
               this.b.add(var1);
            }
         }

         return var2;
      }

      public abstract boolean a(RecyclerView.ViewHolder var1, RecyclerView.ItemAnimator.ItemHolderInfo var2, RecyclerView.ItemAnimator.ItemHolderInfo var3);

      public abstract boolean a(
         RecyclerView.ViewHolder var1,
         RecyclerView.ViewHolder var2,
         RecyclerView.ItemAnimator.ItemHolderInfo var3,
         RecyclerView.ItemAnimator.ItemHolderInfo var4
      );

      public boolean a(RecyclerView.ViewHolder var1, List<Object> var2) {
         return this.h(var1);
      }

      public abstract boolean b();

      public abstract boolean b(RecyclerView.ViewHolder var1, RecyclerView.ItemAnimator.ItemHolderInfo var2, RecyclerView.ItemAnimator.ItemHolderInfo var3);

      public abstract boolean c(RecyclerView.ViewHolder var1, RecyclerView.ItemAnimator.ItemHolderInfo var2, RecyclerView.ItemAnimator.ItemHolderInfo var3);

      public abstract void d();

      public abstract void d(RecyclerView.ViewHolder var1);

      public long e() {
         return this.e;
      }

      public long f() {
         return this.c;
      }

      public final void f(RecyclerView.ViewHolder var1) {
         this.g(var1);
         if (this.a != null) {
            this.a.a(var1);
         }
      }

      public long g() {
         return this.d;
      }

      public void g(RecyclerView.ViewHolder var1) {
      }

      public long h() {
         return this.f;
      }

      public boolean h(RecyclerView.ViewHolder var1) {
         return true;
      }

      public final void i() {
         int var2 = this.b.size();

         for (int var1 = 0; var1 < var2; var1++) {
            this.b.get(var1).a();
         }

         this.b.clear();
      }

      public RecyclerView.ItemAnimator.ItemHolderInfo j() {
         return new RecyclerView.ItemAnimator.ItemHolderInfo();
      }

      public interface ItemAnimatorFinishedListener {
         void a();
      }

      interface ItemAnimatorListener {
         void a(RecyclerView.ViewHolder var1);
      }

      public static class ItemHolderInfo {
         public int a;
         public int b;
         public int c;
         public int d;

         public RecyclerView.ItemAnimator.ItemHolderInfo a(RecyclerView.ViewHolder var1) {
            return this.a(var1, 0);
         }

         public RecyclerView.ItemAnimator.ItemHolderInfo a(RecyclerView.ViewHolder var1, int var2) {
            View var3 = var1.itemView;
            this.a = var3.getLeft();
            this.b = var3.getTop();
            this.c = var3.getRight();
            this.d = var3.getBottom();
            return this;
         }
      }
   }

   private class ItemAnimatorRestoreListener implements RecyclerView.ItemAnimator.ItemAnimatorListener {
      final RecyclerView a;

      ItemAnimatorRestoreListener(RecyclerView var1) {
         this.a = var1;
      }

      @Override
      public void a(RecyclerView.ViewHolder var1) {
         var1.setIsRecyclable(true);
         if (var1.mShadowedHolder != null && var1.mShadowingHolder == null) {
            var1.mShadowedHolder = null;
         }

         var1.mShadowingHolder = null;
         if (!var1.shouldBeKeptAsChild() && !this.a.removeAnimatingView(var1.itemView) && var1.isTmpDetached()) {
            this.a.removeDetachedView(var1.itemView, false);
         }
      }
   }

   public abstract static class ItemDecoration {
      @Deprecated
      public void a(Canvas var1, RecyclerView var2) {
      }

      public void a(Canvas var1, RecyclerView var2, RecyclerView.State var3) {
         this.b(var1, var2);
      }

      @Deprecated
      public void a(Rect var1, int var2, RecyclerView var3) {
         var1.set(0, 0, 0, 0);
      }

      public void a(Rect var1, View var2, RecyclerView var3, RecyclerView.State var4) {
         this.a(var1, ((RecyclerView.LayoutParams)var2.getLayoutParams()).f(), var3);
      }

      @Deprecated
      public void b(Canvas var1, RecyclerView var2) {
      }

      public void b(Canvas var1, RecyclerView var2, RecyclerView.State var3) {
         this.a(var1, var2);
      }
   }

   public abstract static class LayoutManager {
      private final ViewBoundsCheck.Callback a = new ViewBoundsCheck.Callback(this) {
         final RecyclerView.LayoutManager a;

         {
            this.a = var1;
         }

         @Override
         public int a() {
            return this.a.A();
         }

         @Override
         public int a(View var1) {
            RecyclerView.LayoutParams var2 = (RecyclerView.LayoutParams)var1.getLayoutParams();
            return this.a.h(var1) - var2.leftMargin;
         }

         @Override
         public View a(int var1) {
            return this.a.i(var1);
         }

         @Override
         public int b() {
            return this.a.y() - this.a.C();
         }

         @Override
         public int b(View var1) {
            RecyclerView.LayoutParams var3 = (RecyclerView.LayoutParams)var1.getLayoutParams();
            int var2 = this.a.j(var1);
            return var3.rightMargin + var2;
         }
      };
      private final ViewBoundsCheck.Callback b = new ViewBoundsCheck.Callback(this) {
         final RecyclerView.LayoutManager a;

         {
            this.a = var1;
         }

         @Override
         public int a() {
            return this.a.B();
         }

         @Override
         public int a(View var1) {
            RecyclerView.LayoutParams var2 = (RecyclerView.LayoutParams)var1.getLayoutParams();
            return this.a.i(var1) - var2.topMargin;
         }

         @Override
         public View a(int var1) {
            return this.a.i(var1);
         }

         @Override
         public int b() {
            return this.a.z() - this.a.D();
         }

         @Override
         public int b(View var1) {
            RecyclerView.LayoutParams var3 = (RecyclerView.LayoutParams)var1.getLayoutParams();
            int var2 = this.a.k(var1);
            return var3.bottomMargin + var2;
         }
      };
      private boolean c;
      private boolean d;
      private int e;
      private int f;
      private int g;
      private int h;
      ChildHelper p;
      RecyclerView q;
      ViewBoundsCheck r = new ViewBoundsCheck(this.a);
      ViewBoundsCheck s = new ViewBoundsCheck(this.b);
      RecyclerView.SmoothScroller t;
      boolean u = false;
      boolean v = false;
      boolean w = false;
      int x;
      boolean y;

      public LayoutManager() {
         this.c = true;
         this.d = true;
      }

      public static int a(int var0, int var1, int var2) {
         int var4 = MeasureSpec.getMode(var0);
         int var3 = MeasureSpec.getSize(var0);
         var0 = var3;
         switch (var4) {
            case Integer.MIN_VALUE:
               var0 = Math.min(var3, Math.max(var1, var2));
            case 1073741824:
               break;
            default:
               var0 = Math.max(var1, var2);
         }

         return var0;
      }

      public static int a(int var0, int var1, int var2, int var3, boolean var4) {
         byte var6 = 0;
         byte var7 = 0;
         int var5 = Math.max(0, var0 - var2);
         if (var4) {
            if (var3 >= 0) {
               var0 = 1073741824;
               var2 = var3;
               return MeasureSpec.makeMeasureSpec(var2, var0);
            }

            if (var3 == -1) {
               switch (var1) {
                  case Integer.MIN_VALUE:
                  case 1073741824:
                     var0 = var5;
                     break;
                  case 0:
                     var1 = 0;
                     var0 = var6;
                     break;
                  default:
                     var1 = 0;
                     var0 = var6;
               }

               var2 = var0;
               var0 = var1;
               return MeasureSpec.makeMeasureSpec(var2, var0);
            }

            if (var3 == -2) {
               byte var10 = 0;
               byte var8 = var7;
               return MeasureSpec.makeMeasureSpec(var10, var8);
            }
         } else {
            if (var3 >= 0) {
               var0 = 1073741824;
               var2 = var3;
               return MeasureSpec.makeMeasureSpec(var2, var0);
            }

            if (var3 == -1) {
               var0 = var1;
               var2 = var5;
               return MeasureSpec.makeMeasureSpec(var2, var0);
            }

            if (var3 == -2) {
               if (var1 != Integer.MIN_VALUE) {
                  byte var14 = var7;
                  var2 = var5;
                  if (var1 != 1073741824) {
                     return MeasureSpec.makeMeasureSpec(var2, var14);
                  }
               }

               var0 = Integer.MIN_VALUE;
               var2 = var5;
               return MeasureSpec.makeMeasureSpec(var2, var0);
            }
         }

         byte var20 = 0;
         byte var13 = var7;
         return MeasureSpec.makeMeasureSpec(var20, var13);
      }

      public static RecyclerView.LayoutManager.Properties a(Context var0, AttributeSet var1, int var2, int var3) {
         RecyclerView.LayoutManager.Properties var4 = new RecyclerView.LayoutManager.Properties();
         TypedArray var5 = var0.obtainStyledAttributes(var1, R.styleable.RecyclerView, var2, var3);
         var4.a = var5.getInt(R.styleable.RecyclerView_android_orientation, 1);
         var4.b = var5.getInt(R.styleable.RecyclerView_spanCount, 1);
         var4.c = var5.getBoolean(R.styleable.RecyclerView_reverseLayout, false);
         var4.d = var5.getBoolean(R.styleable.RecyclerView_stackFromEnd, false);
         var5.recycle();
         return var4;
      }

      private void a(int var1, View var2) {
         this.p.e(var1);
      }

      private void a(RecyclerView.Recycler var1, int var2, View var3) {
         RecyclerView.ViewHolder var4 = RecyclerView.getChildViewHolderInt(var3);
         if (!var4.shouldIgnore()) {
            if (var4.isInvalid() && !var4.isRemoved() && !this.q.mAdapter.hasStableIds()) {
               this.g(var2);
               var1.b(var4);
            } else {
               this.h(var2);
               var1.c(var3);
               this.q.mViewInfoStore.h(var4);
            }
         }
      }

      private void a(View var1, int var2, boolean var3) {
         RecyclerView.ViewHolder var6 = RecyclerView.getChildViewHolderInt(var1);
         if (!var3 && !var6.isRemoved()) {
            this.q.mViewInfoStore.f(var6);
         } else {
            this.q.mViewInfoStore.e(var6);
         }

         RecyclerView.LayoutParams var7 = (RecyclerView.LayoutParams)var1.getLayoutParams();
         if (!var6.wasReturnedFromScrap() && !var6.isScrap()) {
            if (var1.getParent() == this.q) {
               int var5 = this.p.b(var1);
               int var4 = var2;
               if (var2 == -1) {
                  var4 = this.p.b();
               }

               if (var5 == -1) {
                  throw new IllegalStateException(
                     "Added View has RecyclerView as parent but view is not a real child. Unfiltered index:"
                        + this.q.indexOfChild(var1)
                        + this.q.exceptionLabel()
                  );
               }

               if (var5 != var4) {
                  this.q.mLayout.f(var5, var4);
               }
            } else {
               this.p.a(var1, var2, false);
               var7.e = true;
               if (this.t != null && this.t.h()) {
                  this.t.b(var1);
               }
            }
         } else {
            if (var6.isScrap()) {
               var6.unScrap();
            } else {
               var6.clearReturnedFromScrapFlag();
            }

            this.p.a(var1, var2, var1.getLayoutParams(), false);
         }

         if (var7.f) {
            var6.itemView.invalidate();
            var7.f = false;
         }
      }

      private void b(RecyclerView.SmoothScroller var1) {
         if (this.t == var1) {
            this.t = null;
         }
      }

      private static boolean b(int var0, int var1, int var2) {
         boolean var5 = true;
         int var3 = MeasureSpec.getMode(var1);
         var1 = MeasureSpec.getSize(var1);
         boolean var4;
         if (var2 > 0 && var0 != var2) {
            var4 = false;
         } else {
            var4 = var5;
            switch (var3) {
               case Integer.MIN_VALUE:
                  var4 = var5;
                  if (var1 < var0) {
                     var4 = false;
                  }
               case 0:
                  break;
               case 1073741824:
                  var4 = var5;
                  if (var1 != var0) {
                     var4 = false;
                  }
                  break;
               default:
                  var4 = false;
            }
         }

         return var4;
      }

      private int[] b(RecyclerView var1, View var2, Rect var3, boolean var4) {
         int var12 = this.A();
         int var8 = this.B();
         int var14 = this.y() - this.C();
         int var10 = this.z();
         int var15 = this.D();
         int var11 = var2.getLeft() + var3.left - var2.getScrollX();
         int var9 = var2.getTop() + var3.top - var2.getScrollY();
         int var13 = var11 + var3.width();
         int var16 = var3.height();
         int var7 = Math.min(0, var11 - var12);
         int var6 = Math.min(0, var9 - var8);
         int var5 = Math.max(0, var13 - var14);
         var10 = Math.max(0, var9 + var16 - (var10 - var15));
         if (this.t() == 1) {
            if (var5 == 0) {
               var5 = Math.max(var7, var13 - var14);
            }
         } else if (var7 != 0) {
            var5 = var7;
         } else {
            var5 = Math.min(var11 - var12, var5);
         }

         if (var6 == 0) {
            var6 = Math.min(var9 - var8, var10);
         }

         return new int[]{var5, var6};
      }

      private boolean d(RecyclerView var1, int var2, int var3) {
         boolean var11 = false;
         View var12 = var1.getFocusedChild();
         boolean var10;
         if (var12 == null) {
            var10 = var11;
         } else {
            int var6 = this.A();
            int var7 = this.B();
            int var5 = this.y();
            int var4 = this.C();
            int var8 = this.z();
            int var9 = this.D();
            Rect var13 = this.q.mTempRect;
            this.a(var12, var13);
            var10 = var11;
            if (var13.left - var2 < var5 - var4) {
               var10 = var11;
               if (var13.right - var2 > var6) {
                  var10 = var11;
                  if (var13.top - var3 < var8 - var9) {
                     var10 = var11;
                     if (var13.bottom - var3 > var7) {
                        var10 = true;
                     }
                  }
               }
            }
         }

         return var10;
      }

      public int A() {
         int var1;
         if (this.q != null) {
            var1 = this.q.getPaddingLeft();
         } else {
            var1 = 0;
         }

         return var1;
      }

      public int B() {
         int var1;
         if (this.q != null) {
            var1 = this.q.getPaddingTop();
         } else {
            var1 = 0;
         }

         return var1;
      }

      public int C() {
         int var1;
         if (this.q != null) {
            var1 = this.q.getPaddingRight();
         } else {
            var1 = 0;
         }

         return var1;
      }

      public int D() {
         int var1;
         if (this.q != null) {
            var1 = this.q.getPaddingBottom();
         } else {
            var1 = 0;
         }

         return var1;
      }

      public View E() {
         Object var2 = null;
         View var1;
         if (this.q == null) {
            var1 = (View)var2;
         } else {
            View var3 = this.q.getFocusedChild();
            var1 = (View)var2;
            if (var3 != null) {
               var1 = (View)var2;
               if (!this.p.c(var3)) {
                  var1 = var3;
               }
            }
         }

         return var1;
      }

      public int F() {
         RecyclerView.Adapter var2;
         if (this.q != null) {
            var2 = this.q.getAdapter();
         } else {
            var2 = null;
         }

         int var1;
         if (var2 != null) {
            var1 = var2.getItemCount();
         } else {
            var1 = 0;
         }

         return var1;
      }

      public int G() {
         return ViewCompat.j(this.q);
      }

      public int H() {
         return ViewCompat.k(this.q);
      }

      void I() {
         if (this.t != null) {
            this.t.f();
         }
      }

      public void J() {
         this.u = true;
      }

      boolean K() {
         boolean var4 = false;
         int var2 = this.v();
         int var1 = 0;

         boolean var3;
         while (true) {
            var3 = var4;
            if (var1 >= var2) {
               break;
            }

            android.view.ViewGroup.LayoutParams var5 = this.i(var1).getLayoutParams();
            if (var5.width < 0 && var5.height < 0) {
               var3 = true;
               break;
            }

            var1++;
         }

         return var3;
      }

      public int a(int var1, RecyclerView.Recycler var2, RecyclerView.State var3) {
         return 0;
      }

      public int a(RecyclerView.Recycler var1, RecyclerView.State var2) {
         byte var4 = 1;
         int var3 = var4;
         if (this.q != null) {
            if (this.q.mAdapter == null) {
               var3 = var4;
            } else {
               var3 = var4;
               if (this.f()) {
                  var3 = this.q.mAdapter.getItemCount();
               }
            }
         }

         return var3;
      }

      public abstract RecyclerView.LayoutParams a();

      public RecyclerView.LayoutParams a(Context var1, AttributeSet var2) {
         return new RecyclerView.LayoutParams(var1, var2);
      }

      public RecyclerView.LayoutParams a(android.view.ViewGroup.LayoutParams var1) {
         RecyclerView.LayoutParams var2;
         if (var1 instanceof RecyclerView.LayoutParams) {
            var2 = new RecyclerView.LayoutParams((RecyclerView.LayoutParams)var1);
         } else if (var1 instanceof MarginLayoutParams) {
            var2 = new RecyclerView.LayoutParams((MarginLayoutParams)var1);
         } else {
            var2 = new RecyclerView.LayoutParams(var1);
         }

         return var2;
      }

      public View a(View var1, int var2, RecyclerView.Recycler var3, RecyclerView.State var4) {
         return null;
      }

      public void a(int var1, int var2, RecyclerView.State var3, RecyclerView.LayoutManager.LayoutPrefetchRegistry var4) {
      }

      public void a(int var1, RecyclerView.LayoutManager.LayoutPrefetchRegistry var2) {
      }

      public void a(int var1, RecyclerView.Recycler var2) {
         View var3 = this.i(var1);
         this.g(var1);
         var2.a(var3);
      }

      public void a(Rect var1, int var2, int var3) {
         int var4 = var1.width();
         int var6 = this.A();
         int var7 = this.C();
         int var8 = var1.height();
         int var5 = this.B();
         int var9 = this.D();
         this.g(a(var2, var4 + var6 + var7, this.G()), a(var3, var8 + var5 + var9, this.H()));
      }

      public void a(Parcelable var1) {
      }

      void a(AccessibilityNodeInfoCompat var1) {
         this.a(this.q.mRecycler, this.q.mState, var1);
      }

      public void a(RecyclerView.Adapter var1, RecyclerView.Adapter var2) {
      }

      public void a(RecyclerView.Recycler var1) {
         for (int var2 = this.v() - 1; var2 >= 0; var2--) {
            this.a(var1, var2, this.i(var2));
         }
      }

      public void a(RecyclerView.Recycler var1, RecyclerView.State var2, int var3, int var4) {
         this.q.defaultOnMeasure(var3, var4);
      }

      public void a(RecyclerView.Recycler var1, RecyclerView.State var2, AccessibilityNodeInfoCompat var3) {
         if (this.q.canScrollVertically(-1) || this.q.canScrollHorizontally(-1)) {
            var3.a(8192);
            var3.k(true);
         }

         if (this.q.canScrollVertically(1) || this.q.canScrollHorizontally(1)) {
            var3.a(4096);
            var3.k(true);
         }

         var3.a(AccessibilityNodeInfoCompat.CollectionInfoCompat.a(this.a(var1, var2), this.b(var1, var2), this.e(var1, var2), this.d(var1, var2)));
      }

      public void a(RecyclerView.Recycler var1, RecyclerView.State var2, View var3, AccessibilityNodeInfoCompat var4) {
         int var5;
         if (this.f()) {
            var5 = this.d(var3);
         } else {
            var5 = 0;
         }

         int var6;
         if (this.e()) {
            var6 = this.d(var3);
         } else {
            var6 = 0;
         }

         var4.b(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.a(var5, 1, var6, 1, false, false));
      }

      public void a(RecyclerView.Recycler var1, RecyclerView.State var2, AccessibilityEvent var3) {
         boolean var5 = true;
         if (this.q != null && var3 != null) {
            boolean var4 = var5;
            if (!this.q.canScrollVertically(1)) {
               var4 = var5;
               if (!this.q.canScrollVertically(-1)) {
                  var4 = var5;
                  if (!this.q.canScrollHorizontally(-1)) {
                     if (this.q.canScrollHorizontally(1)) {
                        var4 = var5;
                     } else {
                        var4 = false;
                     }
                  }
               }
            }

            var3.setScrollable(var4);
            if (this.q.mAdapter != null) {
               var3.setItemCount(this.q.mAdapter.getItemCount());
            }
         }
      }

      public void a(RecyclerView.SmoothScroller var1) {
         if (this.t != null && var1 != this.t && this.t.h()) {
            this.t.f();
         }

         this.t = var1;
         this.t.a(this.q, this);
      }

      public void a(RecyclerView.State var1) {
      }

      public void a(RecyclerView var1) {
      }

      public void a(RecyclerView var1, int var2, int var3) {
      }

      public void a(RecyclerView var1, int var2, int var3, int var4) {
      }

      public void a(RecyclerView var1, int var2, int var3, Object var4) {
         this.c(var1, var2, var3);
      }

      public void a(RecyclerView var1, RecyclerView.Recycler var2) {
         this.e(var1);
      }

      public void a(RecyclerView var1, RecyclerView.State var2, int var3) {
         Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
      }

      public void a(View var1) {
         this.a(var1, -1);
      }

      public void a(View var1, int var2) {
         this.a(var1, var2, true);
      }

      public void a(View var1, int var2, int var3) {
         RecyclerView.LayoutParams var9 = (RecyclerView.LayoutParams)var1.getLayoutParams();
         Rect var8 = this.q.getItemDecorInsetsForChild(var1);
         int var7 = var8.left;
         int var6 = var8.right;
         int var5 = var8.top;
         int var4 = var8.bottom;
         var2 = a(this.y(), this.w(), var7 + var6 + var2 + this.A() + this.C() + var9.leftMargin + var9.rightMargin, var9.width, this.e());
         var3 = a(this.z(), this.x(), var4 + var5 + var3 + this.B() + this.D() + var9.topMargin + var9.bottomMargin, var9.height, this.f());
         if (this.b(var1, var2, var3, var9)) {
            var1.measure(var2, var3);
         }
      }

      public void a(View var1, int var2, int var3, int var4, int var5) {
         RecyclerView.LayoutParams var7 = (RecyclerView.LayoutParams)var1.getLayoutParams();
         Rect var6 = var7.d;
         var1.layout(
            var6.left + var2 + var7.leftMargin, var6.top + var3 + var7.topMargin, var4 - var6.right - var7.rightMargin, var5 - var6.bottom - var7.bottomMargin
         );
      }

      public void a(View var1, int var2, RecyclerView.LayoutParams var3) {
         RecyclerView.ViewHolder var4 = RecyclerView.getChildViewHolderInt(var1);
         if (var4.isRemoved()) {
            this.q.mViewInfoStore.e(var4);
         } else {
            this.q.mViewInfoStore.f(var4);
         }

         this.p.a(var1, var2, var3, var4.isRemoved());
      }

      public void a(View var1, Rect var2) {
         RecyclerView.getDecoratedBoundsWithMarginsInt(var1, var2);
      }

      void a(View var1, AccessibilityNodeInfoCompat var2) {
         RecyclerView.ViewHolder var3 = RecyclerView.getChildViewHolderInt(var1);
         if (var3 != null && !var3.isRemoved() && !this.p.c(var3.itemView)) {
            this.a(this.q.mRecycler, this.q.mState, var1, var2);
         }
      }

      public void a(View var1, RecyclerView.Recycler var2) {
         this.c(var1);
         var2.a(var1);
      }

      public void a(View var1, boolean var2, Rect var3) {
         if (var2) {
            Rect var9 = ((RecyclerView.LayoutParams)var1.getLayoutParams()).d;
            int var4 = -var9.left;
            int var6 = -var9.top;
            int var8 = var1.getWidth();
            int var5 = var9.right;
            int var7 = var1.getHeight();
            var3.set(var4, var6, var8 + var5, var9.bottom + var7);
         } else {
            var3.set(0, 0, var1.getWidth(), var1.getHeight());
         }

         if (this.q != null) {
            Matrix var11 = var1.getMatrix();
            if (var11 != null && !var11.isIdentity()) {
               RectF var10 = this.q.mTempRectF;
               var10.set(var3);
               var11.mapRect(var10);
               var3.set((int)Math.floor(var10.left), (int)Math.floor(var10.top), (int)Math.ceil(var10.right), (int)Math.ceil(var10.bottom));
            }
         }

         var3.offset(var1.getLeft(), var1.getTop());
      }

      public void a(AccessibilityEvent var1) {
         this.a(this.q.mRecycler, this.q.mState, var1);
      }

      public void a(String var1) {
         if (this.q != null) {
            this.q.assertNotInLayoutOrScroll(var1);
         }
      }

      boolean a(int var1, Bundle var2) {
         return this.a(this.q.mRecycler, this.q.mState, var1, var2);
      }

      public boolean a(RecyclerView.LayoutParams var1) {
         boolean var2;
         if (var1 != null) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }

      public boolean a(RecyclerView.Recycler var1, RecyclerView.State var2, int var3, Bundle var4) {
         boolean var9 = false;
         if (this.q != null) {
            int var5;
            label34: {
               switch (var3) {
                  case 4096:
                     if (this.q.canScrollVertically(1)) {
                        var3 = this.z() - this.B() - this.D();
                     } else {
                        var3 = 0;
                     }

                     var5 = var3;
                     if (this.q.canScrollHorizontally(1)) {
                        int var8 = this.y();
                        int var7 = this.A();
                        int var13 = this.C();
                        var5 = var3;
                        var3 = var8 - var7 - var13;
                        break label34;
                     }
                     break;
                  case 8192:
                     if (this.q.canScrollVertically(-1)) {
                        var3 = -(this.z() - this.B() - this.D());
                     } else {
                        var3 = 0;
                     }

                     var5 = var3;
                     if (this.q.canScrollHorizontally(-1)) {
                        int var6 = -(this.y() - this.A() - this.C());
                        var5 = var3;
                        var3 = var6;
                        break label34;
                     }
                     break;
                  default:
                     var3 = 0;
                     var5 = 0;
                     break label34;
               }

               var3 = 0;
            }

            if (var5 != 0 || var3 != 0) {
               this.q.scrollBy(var3, var5);
               var9 = true;
            }
         }

         return var9;
      }

      public boolean a(RecyclerView.Recycler var1, RecyclerView.State var2, View var3, int var4, Bundle var5) {
         return false;
      }

      public boolean a(RecyclerView var1, RecyclerView.State var2, View var3, View var4) {
         return this.a(var1, var3, var4);
      }

      public boolean a(RecyclerView var1, View var2, Rect var3, boolean var4) {
         return this.a(var1, var2, var3, var4, false);
      }

      public boolean a(RecyclerView var1, View var2, Rect var3, boolean var4, boolean var5) {
         boolean var8 = false;
         int[] var9 = this.b(var1, var2, var3, var4);
         int var7 = var9[0];
         int var6 = var9[1];
         if (var5) {
            var5 = var8;
            if (!this.d(var1, var7, var6)) {
               return var5;
            }
         }

         if (var7 == 0) {
            var5 = var8;
            if (var6 == 0) {
               return var5;
            }
         }

         if (var4) {
            var1.scrollBy(var7, var6);
         } else {
            var1.smoothScrollBy(var7, var6);
         }

         return true;
      }

      @Deprecated
      public boolean a(RecyclerView var1, View var2, View var3) {
         boolean var4;
         if (!this.s() && !var1.isComputingLayout()) {
            var4 = false;
         } else {
            var4 = true;
         }

         return var4;
      }

      public boolean a(RecyclerView var1, ArrayList<View> var2, int var3, int var4) {
         return false;
      }

      boolean a(View var1, int var2, int var3, RecyclerView.LayoutParams var4) {
         boolean var5;
         if (this.c && b(var1.getMeasuredWidth(), var2, var4.width) && b(var1.getMeasuredHeight(), var3, var4.height)) {
            var5 = false;
         } else {
            var5 = true;
         }

         return var5;
      }

      boolean a(View var1, int var2, Bundle var3) {
         return this.a(this.q.mRecycler, this.q.mState, var1, var2, var3);
      }

      public boolean a(View var1, boolean var2, boolean var3) {
         boolean var4 = true;
         if (this.r.a(var1, 24579) && this.s.a(var1, 24579)) {
            var3 = true;
         } else {
            var3 = false;
         }

         if (var2) {
            var2 = var3;
         } else {
            var2 = var4;
            if (var3) {
               var2 = false;
            }
         }

         return var2;
      }

      public boolean a(Runnable var1) {
         boolean var2;
         if (this.q != null) {
            var2 = this.q.removeCallbacks(var1);
         } else {
            var2 = false;
         }

         return var2;
      }

      public int b(int var1, RecyclerView.Recycler var2, RecyclerView.State var3) {
         return 0;
      }

      public int b(RecyclerView.Recycler var1, RecyclerView.State var2) {
         byte var4 = 1;
         int var3 = var4;
         if (this.q != null) {
            if (this.q.mAdapter == null) {
               var3 = var4;
            } else {
               var3 = var4;
               if (this.e()) {
                  var3 = this.q.mAdapter.getItemCount();
               }
            }
         }

         return var3;
      }

      void b(RecyclerView.Recycler var1) {
         int var3 = var1.e();

         for (int var2 = var3 - 1; var2 >= 0; var2--) {
            View var5 = var1.e(var2);
            RecyclerView.ViewHolder var4 = RecyclerView.getChildViewHolderInt(var5);
            if (!var4.shouldIgnore()) {
               var4.setIsRecyclable(false);
               if (var4.isTmpDetached()) {
                  this.q.removeDetachedView(var5, false);
               }

               if (this.q.mItemAnimator != null) {
                  this.q.mItemAnimator.d(var4);
               }

               var4.setIsRecyclable(true);
               var1.b(var5);
            }
         }

         var1.f();
         if (var3 > 0) {
            this.q.invalidate();
         }
      }

      void b(RecyclerView var1) {
         if (var1 == null) {
            this.q = null;
            this.p = null;
            this.g = 0;
            this.h = 0;
         } else {
            this.q = var1;
            this.p = var1.mChildHelper;
            this.g = var1.getWidth();
            this.h = var1.getHeight();
         }

         this.e = 1073741824;
         this.f = 1073741824;
      }

      public void b(RecyclerView var1, int var2, int var3) {
      }

      void b(RecyclerView var1, RecyclerView.Recycler var2) {
         this.v = false;
         this.a(var1, var2);
      }

      public void b(View var1) {
         this.b(var1, -1);
      }

      public void b(View var1, int var2) {
         this.a(var1, var2, false);
      }

      public void b(View var1, Rect var2) {
         if (this.q == null) {
            var2.set(0, 0, 0, 0);
         } else {
            var2.set(this.q.getItemDecorInsetsForChild(var1));
         }
      }

      public boolean b() {
         return false;
      }

      boolean b(View var1, int var2, int var3, RecyclerView.LayoutParams var4) {
         boolean var5;
         if (!var1.isLayoutRequested() && this.c && b(var1.getWidth(), var2, var4.width) && b(var1.getHeight(), var3, var4.height)) {
            var5 = false;
         } else {
            var5 = true;
         }

         return var5;
      }

      public int c(RecyclerView.State var1) {
         return 0;
      }

      public View c(int var1) {
         int var3 = this.v();
         int var2 = 0;

         View var4;
         while (true) {
            if (var2 >= var3) {
               var4 = null;
               break;
            }

            View var5 = this.i(var2);
            RecyclerView.ViewHolder var6 = RecyclerView.getChildViewHolderInt(var5);
            if (var6 != null && var6.getLayoutPosition() == var1 && !var6.shouldIgnore()) {
               var4 = var5;
               if (this.q.mState.a()) {
                  break;
               }

               if (!var6.isRemoved()) {
                  var4 = var5;
                  break;
               }
            }

            var2++;
         }

         return var4;
      }

      public void c(RecyclerView.Recycler var1) {
         for (int var2 = this.v() - 1; var2 >= 0; var2--) {
            if (!RecyclerView.getChildViewHolderInt(this.i(var2)).shouldIgnore()) {
               this.a(var2, var1);
            }
         }
      }

      public void c(RecyclerView.Recycler var1, RecyclerView.State var2) {
         Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
      }

      void c(RecyclerView var1) {
         this.v = true;
         this.d(var1);
      }

      public void c(RecyclerView var1, int var2, int var3) {
      }

      public void c(View var1) {
         this.p.a(var1);
      }

      public void c(View var1, int var2) {
         this.a(var1, var2, (RecyclerView.LayoutParams)var1.getLayoutParams());
      }

      public boolean c() {
         return this.w;
      }

      public int d(RecyclerView.Recycler var1, RecyclerView.State var2) {
         return 0;
      }

      public int d(RecyclerView.State var1) {
         return 0;
      }

      public int d(View var1) {
         return ((RecyclerView.LayoutParams)var1.getLayoutParams()).f();
      }

      public Parcelable d() {
         return null;
      }

      public View d(View var1, int var2) {
         return null;
      }

      void d(int var1, int var2) {
         this.g = MeasureSpec.getSize(var1);
         this.e = MeasureSpec.getMode(var1);
         if (this.e == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
            this.g = 0;
         }

         this.h = MeasureSpec.getSize(var2);
         this.f = MeasureSpec.getMode(var2);
         if (this.f == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
            this.h = 0;
         }
      }

      public void d(RecyclerView var1) {
      }

      public int e(RecyclerView.State var1) {
         return 0;
      }

      public View e(View var1) {
         Object var2 = null;
         if (this.q == null) {
            var1 = (View)var2;
         } else {
            View var3 = this.q.findContainingItemView(var1);
            var1 = (View)var2;
            if (var3 != null) {
               var1 = (View)var2;
               if (!this.p.c(var3)) {
                  var1 = var3;
               }
            }
         }

         return var1;
      }

      public void e(int var1) {
      }

      void e(int var1, int var2) {
         int var5 = Integer.MAX_VALUE;
         int var4 = Integer.MIN_VALUE;
         int var12 = this.v();
         if (var12 == 0) {
            this.q.defaultOnMeasure(var1, var2);
         } else {
            int var3 = 0;
            int var8 = Integer.MIN_VALUE;
            int var10 = Integer.MAX_VALUE;

            while (var3 < var12) {
               View var13 = this.i(var3);
               Rect var14 = this.q.mTempRect;
               this.a(var13, var14);
               int var6 = var10;
               if (var14.left < var10) {
                  var6 = var14.left;
               }

               int var7 = var8;
               if (var14.right > var8) {
                  var7 = var14.right;
               }

               int var9 = var5;
               if (var14.top < var5) {
                  var9 = var14.top;
               }

               int var11 = var4;
               if (var14.bottom > var4) {
                  var11 = var14.bottom;
               }

               var3++;
               var10 = var6;
               var8 = var7;
               var5 = var9;
               var4 = var11;
            }

            this.q.mTempRect.set(var10, var5, var8, var4);
            this.a(this.q.mTempRect, var1, var2);
         }
      }

      @Deprecated
      public void e(RecyclerView var1) {
      }

      public boolean e() {
         return false;
      }

      public boolean e(RecyclerView.Recycler var1, RecyclerView.State var2) {
         return false;
      }

      public int f(RecyclerView.State var1) {
         return 0;
      }

      public int f(View var1) {
         Rect var4 = ((RecyclerView.LayoutParams)var1.getLayoutParams()).d;
         int var2 = var1.getMeasuredWidth();
         int var3 = var4.left;
         return var4.right + var2 + var3;
      }

      public void f(int var1, int var2) {
         View var3 = this.i(var1);
         if (var3 == null) {
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + var1 + this.q.toString());
         }

         this.h(var1);
         this.c(var3, var2);
      }

      void f(RecyclerView var1) {
         this.d(MeasureSpec.makeMeasureSpec(var1.getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(var1.getHeight(), 1073741824));
      }

      public boolean f() {
         return false;
      }

      public int g(RecyclerView.State var1) {
         return 0;
      }

      public int g(View var1) {
         Rect var4 = ((RecyclerView.LayoutParams)var1.getLayoutParams()).d;
         int var2 = var1.getMeasuredHeight();
         int var3 = var4.top;
         return var4.bottom + var2 + var3;
      }

      public void g(int var1) {
         if (this.i(var1) != null) {
            this.p.a(var1);
         }
      }

      public void g(int var1, int var2) {
         this.q.setMeasuredDimension(var1, var2);
      }

      public int h(RecyclerView.State var1) {
         return 0;
      }

      public int h(View var1) {
         return var1.getLeft() - this.n(var1);
      }

      public void h(int var1) {
         this.a(var1, this.i(var1));
      }

      public int i(View var1) {
         return var1.getTop() - this.l(var1);
      }

      public View i(int var1) {
         View var2;
         if (this.p != null) {
            var2 = this.p.b(var1);
         } else {
            var2 = null;
         }

         return var2;
      }

      public int j(View var1) {
         return var1.getRight() + this.o(var1);
      }

      public void j(int var1) {
         if (this.q != null) {
            this.q.offsetChildrenHorizontal(var1);
         }
      }

      public int k(View var1) {
         return var1.getBottom() + this.m(var1);
      }

      public void k(int var1) {
         if (this.q != null) {
            this.q.offsetChildrenVertical(var1);
         }
      }

      public int l(View var1) {
         return ((RecyclerView.LayoutParams)var1.getLayoutParams()).d.top;
      }

      public void l(int var1) {
      }

      boolean l() {
         return false;
      }

      public int m(View var1) {
         return ((RecyclerView.LayoutParams)var1.getLayoutParams()).d.bottom;
      }

      public int n(View var1) {
         return ((RecyclerView.LayoutParams)var1.getLayoutParams()).d.left;
      }

      public int o(View var1) {
         return ((RecyclerView.LayoutParams)var1.getLayoutParams()).d.right;
      }

      public void o() {
         if (this.q != null) {
            this.q.requestLayout();
         }
      }

      public final boolean p() {
         return this.d;
      }

      public boolean q() {
         return this.v;
      }

      public boolean r() {
         boolean var1;
         if (this.q != null && this.q.mClipToPadding) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      public boolean s() {
         boolean var1;
         if (this.t != null && this.t.h()) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      public int t() {
         return ViewCompat.e(this.q);
      }

      public int u() {
         return -1;
      }

      public int v() {
         int var1;
         if (this.p != null) {
            var1 = this.p.b();
         } else {
            var1 = 0;
         }

         return var1;
      }

      public int w() {
         return this.e;
      }

      public int x() {
         return this.f;
      }

      public int y() {
         return this.g;
      }

      public int z() {
         return this.h;
      }

      public interface LayoutPrefetchRegistry {
         void b(int var1, int var2);
      }

      public static class Properties {
         public int a;
         public int b;
         public boolean c;
         public boolean d;
      }
   }

   public static class LayoutParams extends MarginLayoutParams {
      RecyclerView.ViewHolder c;
      final Rect d = new Rect();
      boolean e = true;
      boolean f = false;

      public LayoutParams(int var1, int var2) {
         super(var1, var2);
      }

      public LayoutParams(Context var1, AttributeSet var2) {
         super(var1, var2);
      }

      public LayoutParams(RecyclerView.LayoutParams var1) {
         super(var1);
      }

      public LayoutParams(android.view.ViewGroup.LayoutParams var1) {
         super(var1);
      }

      public LayoutParams(MarginLayoutParams var1) {
         super(var1);
      }

      public boolean c() {
         return this.c.isInvalid();
      }

      public boolean d() {
         return this.c.isRemoved();
      }

      public boolean e() {
         return this.c.isUpdated();
      }

      public int f() {
         return this.c.getLayoutPosition();
      }
   }

   public interface OnChildAttachStateChangeListener {
      void a(View var1);

      void b(View var1);
   }

   public abstract static class OnFlingListener {
      public abstract boolean a(int var1, int var2);
   }

   public interface OnItemTouchListener {
      void a(boolean var1);

      boolean a(RecyclerView var1, MotionEvent var2);

      void b(RecyclerView var1, MotionEvent var2);
   }

   public abstract static class OnScrollListener {
      public void a(RecyclerView var1, int var2) {
      }

      public void a(RecyclerView var1, int var2, int var3) {
      }
   }

   public static class RecycledViewPool {
      SparseArray<RecyclerView.RecycledViewPool.ScrapData> a = new SparseArray();
      private int b = 0;

      private RecyclerView.RecycledViewPool.ScrapData b(int var1) {
         RecyclerView.RecycledViewPool.ScrapData var3 = (RecyclerView.RecycledViewPool.ScrapData)this.a.get(var1);
         RecyclerView.RecycledViewPool.ScrapData var2 = var3;
         if (var3 == null) {
            var2 = new RecyclerView.RecycledViewPool.ScrapData();
            this.a.put(var1, var2);
         }

         return var2;
      }

      long a(long var1, long var3) {
         if (var1 != 0L) {
            var3 = var1 / 4L * 3L + var3 / 4L;
         }

         return var3;
      }

      public RecyclerView.ViewHolder a(int var1) {
         RecyclerView.RecycledViewPool.ScrapData var2 = (RecyclerView.RecycledViewPool.ScrapData)this.a.get(var1);
         RecyclerView.ViewHolder var3;
         if (var2 != null && !var2.a.isEmpty()) {
            ArrayList var4 = var2.a;
            var3 = (RecyclerView.ViewHolder)var4.remove(var4.size() - 1);
         } else {
            var3 = null;
         }

         return var3;
      }

      public void a() {
         for (int var1 = 0; var1 < this.a.size(); var1++) {
            ((RecyclerView.RecycledViewPool.ScrapData)this.a.valueAt(var1)).a.clear();
         }
      }

      void a(int var1, long var2) {
         RecyclerView.RecycledViewPool.ScrapData var4 = this.b(var1);
         var4.c = this.a(var4.c, var2);
      }

      void a(RecyclerView.Adapter var1) {
         this.b++;
      }

      void a(RecyclerView.Adapter var1, RecyclerView.Adapter var2, boolean var3) {
         if (var1 != null) {
            this.b();
         }

         if (!var3 && this.b == 0) {
            this.a();
         }

         if (var2 != null) {
            this.a(var2);
         }
      }

      public void a(RecyclerView.ViewHolder var1) {
         int var2 = var1.getItemViewType();
         ArrayList var3 = this.b(var2).a;
         if (((RecyclerView.RecycledViewPool.ScrapData)this.a.get(var2)).b > var3.size()) {
            var1.resetInternal();
            var3.add(var1);
         }
      }

      boolean a(int var1, long var2, long var4) {
         long var7 = this.b(var1).c;
         boolean var6;
         if (var7 != 0L && var7 + var2 >= var4) {
            var6 = false;
         } else {
            var6 = true;
         }

         return var6;
      }

      void b() {
         this.b--;
      }

      void b(int var1, long var2) {
         RecyclerView.RecycledViewPool.ScrapData var4 = this.b(var1);
         var4.d = this.a(var4.d, var2);
      }

      boolean b(int var1, long var2, long var4) {
         long var6 = this.b(var1).d;
         boolean var8;
         if (var6 != 0L && var6 + var2 >= var4) {
            var8 = false;
         } else {
            var8 = true;
         }

         return var8;
      }

      static class ScrapData {
         final ArrayList<RecyclerView.ViewHolder> a = new ArrayList<>();
         int b = 5;
         long c = 0L;
         long d = 0L;
      }
   }

   public final class Recycler {
      final ArrayList<RecyclerView.ViewHolder> a;
      ArrayList<RecyclerView.ViewHolder> b;
      final ArrayList<RecyclerView.ViewHolder> c;
      int d;
      RecyclerView.RecycledViewPool e;
      final RecyclerView f;
      private final List<RecyclerView.ViewHolder> g;
      private int h;
      private RecyclerView.ViewCacheExtension i;

      public Recycler(RecyclerView var1) {
         this.f = var1;
         this.a = new ArrayList<>();
         this.b = null;
         this.c = new ArrayList<>();
         this.g = Collections.unmodifiableList(this.a);
         this.h = 2;
         this.d = 2;
      }

      private void a(ViewGroup var1, boolean var2) {
         for (int var3 = var1.getChildCount() - 1; var3 >= 0; var3--) {
            View var4 = var1.getChildAt(var3);
            if (var4 instanceof ViewGroup) {
               this.a((ViewGroup)var4, true);
            }
         }

         if (var2) {
            if (var1.getVisibility() == 4) {
               var1.setVisibility(0);
               var1.setVisibility(4);
            } else {
               int var5 = var1.getVisibility();
               var1.setVisibility(4);
               var1.setVisibility(var5);
            }
         }
      }

      private boolean a(RecyclerView.ViewHolder var1, int var2, int var3, long var4) {
         var1.mOwnerRecyclerView = this.f;
         int var6 = var1.getItemViewType();
         long var8 = this.f.getNanoTime();
         boolean var7;
         if (var4 != Long.MAX_VALUE && !this.e.b(var6, var8, var4)) {
            var7 = false;
         } else {
            this.f.mAdapter.bindViewHolder(var1, var2);
            var4 = this.f.getNanoTime();
            this.e.b(var1.getItemViewType(), var4 - var8);
            this.e(var1);
            if (this.f.mState.a()) {
               var1.mPreLayoutPosition = var3;
            }

            var7 = true;
         }

         return var7;
      }

      private void e(RecyclerView.ViewHolder var1) {
         if (this.f.isAccessibilityEnabled()) {
            View var2 = var1.itemView;
            if (ViewCompat.d(var2) == 0) {
               ViewCompat.a(var2, 1);
            }

            if (!ViewCompat.a(var2)) {
               var1.addFlags(16384);
               ViewCompat.a(var2, this.f.mAccessibilityDelegate.c());
            }
         }
      }

      private void f(RecyclerView.ViewHolder var1) {
         if (var1.itemView instanceof ViewGroup) {
            this.a((ViewGroup)var1.itemView, false);
         }
      }

      RecyclerView.ViewHolder a(int var1, boolean var2, long var3) {
         boolean var8 = true;
         if (var1 >= 0 && var1 < this.f.mState.e()) {
            boolean var6;
            RecyclerView.ViewHolder var14;
            if (this.f.mState.a()) {
               var14 = this.f(var1);
               boolean var5;
               if (var14 != null) {
                  var5 = true;
               } else {
                  var5 = false;
               }

               var6 = var5;
            } else {
               var14 = null;
               var6 = 0;
            }

            RecyclerView.ViewHolder var13 = var14;
            boolean var18 = (boolean)var6;
            if (var14 == null) {
               var14 = this.b(var1, var2);
               var13 = var14;
               var18 = (boolean)var6;
               if (var14 != null) {
                  if (!this.a(var14)) {
                     if (!var2) {
                        var14.addFlags(4);
                        if (var14.isScrap()) {
                           this.f.removeDetachedView(var14.itemView, false);
                           var14.unScrap();
                        } else if (var14.wasReturnedFromScrap()) {
                           var14.clearReturnedFromScrapFlag();
                        }

                        this.b(var14);
                     }

                     var13 = null;
                     var18 = (boolean)var6;
                  } else {
                     var18 = true;
                     var13 = var14;
                  }
               }
            }

            if (var13 == null) {
               int var7 = this.f.mAdapterHelper.b(var1);
               if (var7 < 0 || var7 >= this.f.mAdapter.getItemCount()) {
                  throw new IndexOutOfBoundsException(
                     "Inconsistency detected. Invalid item position "
                        + var1
                        + "(offset:"
                        + var7
                        + ")."
                        + "state:"
                        + this.f.mState.e()
                        + this.f.exceptionLabel()
                  );
               }

               label137: {
                  var6 = this.f.mAdapter.getItemViewType(var7);
                  if (this.f.mAdapter.hasStableIds()) {
                     var14 = this.a(this.f.mAdapter.getItemId(var7), var6, var2);
                     var13 = var14;
                     if (var14 != null) {
                        var14.mPosition = var7;
                        var18 = true;
                        break label137;
                     }
                  }

                  var14 = var13;
               }

               var13 = var14;
               if (var14 == null) {
                  var13 = var14;
                  if (this.i != null) {
                     View var15 = this.i.a(this, var1, var6);
                     var13 = var14;
                     if (var15 != null) {
                        var14 = this.f.getChildViewHolder(var15);
                        if (var14 == null) {
                           throw new IllegalArgumentException(
                              "getViewForPositionAndType returned a view which does not have a ViewHolder" + this.f.exceptionLabel()
                           );
                        }

                        var13 = var14;
                        if (var14.shouldIgnore()) {
                           throw new IllegalArgumentException(
                              "getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view."
                                 + this.f.exceptionLabel()
                           );
                        }
                     }
                  }
               }

               var14 = var13;
               if (var13 == null) {
                  var13 = this.g().a(var6);
                  var14 = var13;
                  if (var13 != null) {
                     var13.resetInternal();
                     var14 = var13;
                     if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST) {
                        this.f(var13);
                        var14 = var13;
                     }
                  }
               }

               var13 = var14;
               if (var14 == null) {
                  long var9 = this.f.getNanoTime();
                  if (var3 != Long.MAX_VALUE && !this.e.a(var6, var9, var3)) {
                     var13 = null;
                     return var13;
                  }

                  var13 = this.f.mAdapter.createViewHolder(this.f, var6);
                  if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                     RecyclerView var27 = RecyclerView.findNestedRecyclerView(var13.itemView);
                     if (var27 != null) {
                        var13.mNestedRecyclerView = new WeakReference<>(var27);
                     }
                  }

                  long var11 = this.f.getNanoTime();
                  this.e.a(var6, var11 - var9);
               }
            }

            if (var18 && !this.f.mState.a() && var13.hasAnyOfTheFlags(8192)) {
               var13.setFlags(0, 8192);
               if (this.f.mState.i) {
                  var6 = RecyclerView.ItemAnimator.e(var13);
                  RecyclerView.ItemAnimator.ItemHolderInfo var28 = this.f.mItemAnimator.a(this.f.mState, var13, var6 | 4096, var13.getUnmodifiedPayloads());
                  this.f.recordAnimationInfoIfBouncedHiddenView(var13, var28);
               }
            }

            if (this.f.mState.a() && var13.isBound()) {
               var13.mPreLayoutPosition = var1;
               var2 = false;
            } else if (var13.isBound() && !var13.needsUpdate() && !var13.isInvalid()) {
               var2 = false;
            } else {
               var2 = this.a(var13, this.f.mAdapterHelper.b(var1), var1, var3);
            }

            android.view.ViewGroup.LayoutParams var29 = var13.itemView.getLayoutParams();
            RecyclerView.LayoutParams var30;
            if (var29 == null) {
               var30 = (RecyclerView.LayoutParams)this.f.generateDefaultLayoutParams();
               var13.itemView.setLayoutParams(var30);
            } else if (!this.f.checkLayoutParams(var29)) {
               var30 = (RecyclerView.LayoutParams)this.f.generateLayoutParams(var29);
               var13.itemView.setLayoutParams(var30);
            } else {
               var30 = (RecyclerView.LayoutParams)var29;
            }

            var30.c = var13;
            if (var18 && var2) {
               var2 = var8;
            } else {
               var2 = false;
            }

            var30.f = var2;
            return var13;
         } else {
            throw new IndexOutOfBoundsException("Invalid item position " + var1 + "(" + var1 + "). Item count:" + this.f.mState.e() + this.f.exceptionLabel());
         }
      }

      RecyclerView.ViewHolder a(long var1, int var3, boolean var4) {
         int var5 = this.a.size() - 1;

         RecyclerView.ViewHolder var6;
         while (true) {
            if (var5 < 0) {
               for (int var8 = this.c.size() - 1; var8 >= 0; var8--) {
                  RecyclerView.ViewHolder var9 = this.c.get(var8);
                  if (var9.getItemId() == var1) {
                     if (var3 == var9.getItemViewType()) {
                        var6 = var9;
                        if (!var4) {
                           this.c.remove(var8);
                           var6 = var9;
                        }

                        return var6;
                     }

                     if (!var4) {
                        this.d(var8);
                        var6 = null;
                        return var6;
                     }
                  }
               }

               var6 = null;
               break;
            }

            RecyclerView.ViewHolder var7 = this.a.get(var5);
            if (var7.getItemId() == var1 && !var7.wasReturnedFromScrap()) {
               if (var3 == var7.getItemViewType()) {
                  var7.addFlags(32);
                  var6 = var7;
                  if (var7.isRemoved()) {
                     var6 = var7;
                     if (!this.f.mState.a()) {
                        var7.setFlags(2, 14);
                        var6 = var7;
                     }
                  }
                  break;
               }

               if (!var4) {
                  this.a.remove(var5);
                  this.f.removeDetachedView(var7.itemView, false);
                  this.b(var7.itemView);
               }
            }

            var5--;
         }

         return var6;
      }

      View a(int var1, boolean var2) {
         return this.a(var1, var2, Long.MAX_VALUE).itemView;
      }

      public void a() {
         this.a.clear();
         this.d();
      }

      public void a(int var1) {
         this.h = var1;
         this.b();
      }

      void a(int var1, int var2) {
         int var3;
         int var4;
         byte var5;
         if (var1 < var2) {
            var5 = -1;
            var3 = var2;
            var4 = var1;
         } else {
            var5 = 1;
            var3 = var1;
            var4 = var2;
         }

         int var7 = this.c.size();

         for (int var6 = 0; var6 < var7; var6++) {
            RecyclerView.ViewHolder var8 = this.c.get(var6);
            if (var8 != null && var8.mPosition >= var4 && var8.mPosition <= var3) {
               if (var8.mPosition == var1) {
                  var8.offsetPosition(var2 - var1, false);
               } else {
                  var8.offsetPosition(var5, false);
               }
            }
         }
      }

      void a(int var1, int var2, boolean var3) {
         for (int var4 = this.c.size() - 1; var4 >= 0; var4--) {
            RecyclerView.ViewHolder var5 = this.c.get(var4);
            if (var5 != null) {
               if (var5.mPosition >= var1 + var2) {
                  var5.offsetPosition(-var2, var3);
               } else if (var5.mPosition >= var1) {
                  var5.addFlags(8);
                  this.d(var4);
               }
            }
         }
      }

      void a(RecyclerView.Adapter var1, RecyclerView.Adapter var2, boolean var3) {
         this.a();
         this.g().a(var1, var2, var3);
      }

      void a(RecyclerView.RecycledViewPool var1) {
         if (this.e != null) {
            this.e.b();
         }

         this.e = var1;
         if (var1 != null) {
            this.e.a(this.f.getAdapter());
         }
      }

      void a(RecyclerView.ViewCacheExtension var1) {
         this.i = var1;
      }

      void a(RecyclerView.ViewHolder var1, boolean var2) {
         RecyclerView.clearNestedRecyclerViewIfNotNested(var1);
         if (var1.hasAnyOfTheFlags(16384)) {
            var1.setFlags(0, 16384);
            ViewCompat.a(var1.itemView, (AccessibilityDelegateCompat)null);
         }

         if (var2) {
            this.d(var1);
         }

         var1.mOwnerRecyclerView = null;
         this.g().a(var1);
      }

      public void a(View var1) {
         RecyclerView.ViewHolder var2 = RecyclerView.getChildViewHolderInt(var1);
         if (var2.isTmpDetached()) {
            this.f.removeDetachedView(var1, false);
         }

         if (var2.isScrap()) {
            var2.unScrap();
         } else if (var2.wasReturnedFromScrap()) {
            var2.clearReturnedFromScrapFlag();
         }

         this.b(var2);
      }

      boolean a(RecyclerView.ViewHolder var1) {
         boolean var3 = true;
         boolean var2;
         if (var1.isRemoved()) {
            var2 = this.f.mState.a();
         } else {
            if (var1.mPosition < 0 || var1.mPosition >= this.f.mAdapter.getItemCount()) {
               throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + var1 + this.f.exceptionLabel());
            }

            if (!this.f.mState.a() && this.f.mAdapter.getItemViewType(var1.mPosition) != var1.getItemViewType()) {
               var2 = false;
            } else {
               var2 = var3;
               if (this.f.mAdapter.hasStableIds()) {
                  var2 = var3;
                  if (var1.getItemId() != this.f.mAdapter.getItemId(var1.mPosition)) {
                     var2 = false;
                  }
               }
            }
         }

         return var2;
      }

      public int b(int var1) {
         if (var1 >= 0 && var1 < this.f.mState.e()) {
            if (this.f.mState.a()) {
               var1 = this.f.mAdapterHelper.b(var1);
            }

            return var1;
         } else {
            throw new IndexOutOfBoundsException("invalid position " + var1 + ". State " + "item count is " + this.f.mState.e() + this.f.exceptionLabel());
         }
      }

      RecyclerView.ViewHolder b(int var1, boolean var2) {
         byte var4 = 0;
         int var5 = this.a.size();
         int var3 = 0;

         RecyclerView.ViewHolder var6;
         while (true) {
            if (var3 >= var5) {
               if (!var2) {
                  View var7 = this.f.mChildHelper.c(var1);
                  if (var7 != null) {
                     var6 = RecyclerView.getChildViewHolderInt(var7);
                     this.f.mChildHelper.e(var7);
                     var1 = this.f.mChildHelper.b(var7);
                     if (var1 == -1) {
                        throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + var6 + this.f.exceptionLabel());
                     }

                     this.f.mChildHelper.e(var1);
                     this.c(var7);
                     var6.addFlags(8224);
                     break;
                  }
               }

               var5 = this.c.size();

               for (int var9 = var4; var9 < var5; var9++) {
                  RecyclerView.ViewHolder var11 = this.c.get(var9);
                  if (!var11.isInvalid() && var11.getLayoutPosition() == var1) {
                     var6 = var11;
                     if (!var2) {
                        this.c.remove(var9);
                        var6 = var11;
                     }

                     return var6;
                  }
               }

               var6 = null;
               break;
            }

            var6 = this.a.get(var3);
            if (!var6.wasReturnedFromScrap() && var6.getLayoutPosition() == var1 && !var6.isInvalid() && (this.f.mState.f || !var6.isRemoved())) {
               var6.addFlags(32);
               break;
            }

            var3++;
         }

         return var6;
      }

      void b() {
         int var1;
         if (this.f.mLayout != null) {
            var1 = this.f.mLayout.x;
         } else {
            var1 = 0;
         }

         this.d = var1 + this.h;

         for (int var2 = this.c.size() - 1; var2 >= 0 && this.c.size() > this.d; var2--) {
            this.d(var2);
         }
      }

      void b(int var1, int var2) {
         int var4 = this.c.size();

         for (int var3 = 0; var3 < var4; var3++) {
            RecyclerView.ViewHolder var5 = this.c.get(var3);
            if (var5 != null && var5.mPosition >= var1) {
               var5.offsetPosition(var2, true);
            }
         }
      }

      void b(RecyclerView.ViewHolder var1) {
         boolean var4 = false;
         if (var1.isScrap() || var1.itemView.getParent() != null) {
            StringBuilder var6 = new StringBuilder()
               .append("Scrapped or attached views may not be recycled. isScrap:")
               .append(var1.isScrap())
               .append(" isAttached:");
            boolean var13;
            if (var1.itemView.getParent() != null) {
               var13 = true;
            } else {
               var13 = false;
            }

            throw new IllegalArgumentException(var6.append(var13).append(this.f.exceptionLabel()).toString());
         } else {
            if (var1.isTmpDetached()) {
               throw new IllegalArgumentException(
                  "Tmp detached view should be removed from RecyclerView before it can be recycled: " + var1 + this.f.exceptionLabel()
               );
            }

            if (var1.shouldIgnore()) {
               throw new IllegalArgumentException(
                  "Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + this.f.exceptionLabel()
               );
            }

            boolean var5 = var1.doesTransientStatePreventRecycling();
            boolean var2;
            if (this.f.mAdapter != null && var5 && this.f.mAdapter.onFailedToRecycleView(var1)) {
               var2 = 1;
            } else {
               var2 = 0;
            }

            boolean var12;
            if (!var2 && !var1.isRecyclable()) {
               var12 = 0;
            } else {
               if (this.d > 0 && !var1.hasAnyOfTheFlags(526)) {
                  var12 = this.c.size();
                  var2 = var12;
                  if (var12 >= this.d) {
                     var2 = var12;
                     if (var12 > 0) {
                        this.d(0);
                        var2 = var12 - 1;
                     }
                  }

                  var12 = var2;
                  if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                     var12 = var2;
                     if (var2 > 0) {
                        var12 = var2;
                        if (!this.f.mPrefetchRegistry.a(var1.mPosition)) {
                           var2--;

                           while (var2 >= 0) {
                              var12 = this.c.get(var2).mPosition;
                              if (!this.f.mPrefetchRegistry.a(var12)) {
                                 break;
                              }

                              var2--;
                           }

                           var12 = var2 + 1;
                        }
                     }
                  }

                  this.c.add(var12, var1);
                  var2 = (boolean)1;
               } else {
                  var2 = (boolean)0;
               }

               var12 = var2;
               if (!var2) {
                  this.a(var1, true);
                  var4 = true;
                  var12 = var2;
               }
            }

            this.f.mViewInfoStore.g(var1);
            if (!var12 && !var4 && var5) {
               var1.mOwnerRecyclerView = null;
            }
         }
      }

      void b(View var1) {
         RecyclerView.ViewHolder var2 = RecyclerView.getChildViewHolderInt(var1);
         var2.mScrapContainer = null;
         var2.mInChangeScrap = false;
         var2.clearReturnedFromScrapFlag();
         this.b(var2);
      }

      public View c(int var1) {
         return this.a(var1, false);
      }

      public List<RecyclerView.ViewHolder> c() {
         return this.g;
      }

      void c(int var1, int var2) {
         for (int var3 = this.c.size() - 1; var3 >= 0; var3--) {
            RecyclerView.ViewHolder var5 = this.c.get(var3);
            if (var5 != null) {
               int var4 = var5.mPosition;
               if (var4 >= var1 && var4 < var1 + var2) {
                  var5.addFlags(2);
                  this.d(var3);
               }
            }
         }
      }

      void c(RecyclerView.ViewHolder var1) {
         if (var1.mInChangeScrap) {
            this.b.remove(var1);
         } else {
            this.a.remove(var1);
         }

         var1.mScrapContainer = null;
         var1.mInChangeScrap = false;
         var1.clearReturnedFromScrapFlag();
      }

      void c(View var1) {
         RecyclerView.ViewHolder var2 = RecyclerView.getChildViewHolderInt(var1);
         if (!var2.hasAnyOfTheFlags(12) && var2.isUpdated() && !this.f.canReuseUpdatedViewHolder(var2)) {
            if (this.b == null) {
               this.b = new ArrayList<>();
            }

            var2.setScrapContainer(this, true);
            this.b.add(var2);
         } else {
            if (var2.isInvalid() && !var2.isRemoved() && !this.f.mAdapter.hasStableIds()) {
               throw new IllegalArgumentException(
                  "Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool."
                     + this.f.exceptionLabel()
               );
            }

            var2.setScrapContainer(this, false);
            this.a.add(var2);
         }
      }

      void d() {
         for (int var1 = this.c.size() - 1; var1 >= 0; var1--) {
            this.d(var1);
         }

         this.c.clear();
         if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
            this.f.mPrefetchRegistry.a();
         }
      }

      void d(int var1) {
         this.a(this.c.get(var1), true);
         this.c.remove(var1);
      }

      void d(RecyclerView.ViewHolder var1) {
         if (this.f.mRecyclerListener != null) {
            this.f.mRecyclerListener.a(var1);
         }

         if (this.f.mAdapter != null) {
            this.f.mAdapter.onViewRecycled(var1);
         }

         if (this.f.mState != null) {
            this.f.mViewInfoStore.g(var1);
         }
      }

      int e() {
         return this.a.size();
      }

      View e(int var1) {
         return this.a.get(var1).itemView;
      }

      RecyclerView.ViewHolder f(int var1) {
         byte var3 = 0;
         if (this.b != null) {
            int var4 = this.b.size();
            if (var4 != 0) {
               for (int var2 = 0; var2 < var4; var2++) {
                  RecyclerView.ViewHolder var10 = this.b.get(var2);
                  if (!var10.wasReturnedFromScrap() && var10.getLayoutPosition() == var1) {
                     var10.addFlags(32);
                     return var10;
                  }
               }

               if (this.f.mAdapter.hasStableIds()) {
                  var1 = this.f.mAdapterHelper.b(var1);
                  if (var1 > 0 && var1 < this.f.mAdapter.getItemCount()) {
                     long var5 = this.f.mAdapter.getItemId(var1);

                     for (int var9 = var3; var9 < var4; var9++) {
                        RecyclerView.ViewHolder var7 = this.b.get(var9);
                        if (!var7.wasReturnedFromScrap() && var7.getItemId() == var5) {
                           var7.addFlags(32);
                           return var7;
                        }
                     }
                  }
               }

               return null;
            }
         }

         return null;
      }

      void f() {
         this.a.clear();
         if (this.b != null) {
            this.b.clear();
         }
      }

      RecyclerView.RecycledViewPool g() {
         if (this.e == null) {
            this.e = new RecyclerView.RecycledViewPool();
         }

         return this.e;
      }

      void h() {
         int var2 = this.c.size();

         for (int var1 = 0; var1 < var2; var1++) {
            RecyclerView.ViewHolder var3 = this.c.get(var1);
            if (var3 != null) {
               var3.addFlags(6);
               var3.addChangePayload(null);
            }
         }

         if (this.f.mAdapter == null || !this.f.mAdapter.hasStableIds()) {
            this.d();
         }
      }

      void i() {
         byte var2 = 0;
         int var3 = this.c.size();

         for (int var1 = 0; var1 < var3; var1++) {
            this.c.get(var1).clearOldPosition();
         }

         var3 = this.a.size();

         for (int var4 = 0; var4 < var3; var4++) {
            this.a.get(var4).clearOldPosition();
         }

         if (this.b != null) {
            var3 = this.b.size();

            for (int var5 = var2; var5 < var3; var5++) {
               this.b.get(var5).clearOldPosition();
            }
         }
      }

      void j() {
         int var2 = this.c.size();

         for (int var1 = 0; var1 < var2; var1++) {
            RecyclerView.LayoutParams var3 = (RecyclerView.LayoutParams)this.c.get(var1).itemView.getLayoutParams();
            if (var3 != null) {
               var3.e = true;
            }
         }
      }
   }

   public interface RecyclerListener {
      void a(RecyclerView.ViewHolder var1);
   }

   private class RecyclerViewDataObserver extends RecyclerView.AdapterDataObserver {
      final RecyclerView a;

      RecyclerViewDataObserver(RecyclerView var1) {
         this.a = var1;
      }

      @Override
      public void a() {
         this.a.assertNotInLayoutOrScroll(null);
         this.a.mState.e = true;
         this.a.processDataSetCompletelyChanged(true);
         if (!this.a.mAdapterHelper.d()) {
            this.a.requestLayout();
         }
      }

      @Override
      public void a(int var1, int var2, int var3) {
         this.a.assertNotInLayoutOrScroll(null);
         if (this.a.mAdapterHelper.a(var1, var2, var3)) {
            this.b();
         }
      }

      @Override
      public void a(int var1, int var2, Object var3) {
         this.a.assertNotInLayoutOrScroll(null);
         if (this.a.mAdapterHelper.a(var1, var2, var3)) {
            this.b();
         }
      }

      void b() {
         if (RecyclerView.POST_UPDATES_ON_ANIMATION && this.a.mHasFixedSize && this.a.mIsAttached) {
            ViewCompat.a(this.a, this.a.mUpdateChildViewsRunnable);
         } else {
            this.a.mAdapterUpdateDuringMeasure = true;
            this.a.requestLayout();
         }
      }

      @Override
      public void b(int var1, int var2) {
         this.a.assertNotInLayoutOrScroll(null);
         if (this.a.mAdapterHelper.b(var1, var2)) {
            this.b();
         }
      }

      @Override
      public void c(int var1, int var2) {
         this.a.assertNotInLayoutOrScroll(null);
         if (this.a.mAdapterHelper.c(var1, var2)) {
            this.b();
         }
      }
   }

   public static class SavedState extends AbsSavedState {
      public static final Creator<RecyclerView.SavedState> CREATOR = new ClassLoaderCreator<RecyclerView.SavedState>() {
         public RecyclerView.SavedState a(Parcel var1) {
            return new RecyclerView.SavedState(var1, null);
         }

         public RecyclerView.SavedState a(Parcel var1, ClassLoader var2) {
            return new RecyclerView.SavedState(var1, var2);
         }

         public RecyclerView.SavedState[] a(int var1) {
            return new RecyclerView.SavedState[var1];
         }
      };
      Parcelable a;

      SavedState(Parcel var1, ClassLoader var2) {
         super(var1, var2);
         if (var2 == null) {
            var2 = RecyclerView.LayoutManager.class.getClassLoader();
         }

         this.a = var1.readParcelable(var2);
      }

      SavedState(Parcelable var1) {
         super(var1);
      }

      void a(RecyclerView.SavedState var1) {
         this.a = var1.a;
      }

      @Override
      public void writeToParcel(Parcel var1, int var2) {
         super.writeToParcel(var1, var2);
         var1.writeParcelable(this.a, 0);
      }
   }

   public abstract static class SmoothScroller {
      private int a = -1;
      private RecyclerView b;
      private RecyclerView.LayoutManager c;
      private boolean d;
      private boolean e;
      private View f;
      private final RecyclerView.SmoothScroller.Action g = new RecyclerView.SmoothScroller.Action(0, 0);

      private void a(int var1, int var2) {
         RecyclerView var4 = this.b;
         if (!this.e || this.a == -1 || var4 == null) {
            this.f();
         }

         this.d = false;
         if (this.f != null) {
            if (this.a(this.f) == this.a) {
               this.a(this.f, var4.mState, this.g);
               this.g.a(var4);
               this.f();
            } else {
               Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
               this.f = null;
            }
         }

         if (this.e) {
            this.a(var1, var2, var4.mState, this.g);
            boolean var3 = this.g.a();
            this.g.a(var4);
            if (var3) {
               if (this.e) {
                  this.d = true;
                  var4.mViewFlinger.a();
               } else {
                  this.f();
               }
            }
         }
      }

      public int a(View var1) {
         return this.b.getChildLayoutPosition(var1);
      }

      protected abstract void a();

      protected abstract void a(int var1, int var2, RecyclerView.State var3, RecyclerView.SmoothScroller.Action var4);

      protected void a(PointF var1) {
         float var2 = (float)Math.sqrt(var1.x * var1.x + var1.y * var1.y);
         var1.x /= var2;
         var1.y /= var2;
      }

      void a(RecyclerView var1, RecyclerView.LayoutManager var2) {
         this.b = var1;
         this.c = var2;
         if (this.a == -1) {
            throw new IllegalArgumentException("Invalid target position");
         }

         this.b.mState.p = this.a;
         this.e = true;
         this.d = true;
         this.f = this.e(this.i());
         this.a();
         this.b.mViewFlinger.a();
      }

      protected abstract void a(View var1, RecyclerView.State var2, RecyclerView.SmoothScroller.Action var3);

      protected abstract void b();

      protected void b(View var1) {
         if (this.a(var1) == this.i()) {
            this.f = var1;
         }
      }

      public void d(int var1) {
         this.a = var1;
      }

      public RecyclerView.LayoutManager e() {
         return this.c;
      }

      public View e(int var1) {
         return this.b.mLayout.c(var1);
      }

      protected final void f() {
         if (this.e) {
            this.b();
            this.b.mState.p = -1;
            this.f = null;
            this.a = -1;
            this.d = false;
            this.e = false;
            this.c.b(this);
            this.c = null;
            this.b = null;
         }
      }

      public boolean g() {
         return this.d;
      }

      public boolean h() {
         return this.e;
      }

      public int i() {
         return this.a;
      }

      public int j() {
         return this.b.mLayout.v();
      }

      public static class Action {
         private int a;
         private int b;
         private int c;
         private int d = -1;
         private Interpolator e;
         private boolean f = false;
         private int g = 0;

         public Action(int var1, int var2) {
            this(var1, var2, Integer.MIN_VALUE, null);
         }

         public Action(int var1, int var2, int var3, Interpolator var4) {
            this.a = var1;
            this.b = var2;
            this.c = var3;
            this.e = var4;
         }

         private void b() {
            if (this.e != null && this.c < 1) {
               throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
            }

            if (this.c < 1) {
               throw new IllegalStateException("Scroll duration must be a positive number");
            }
         }

         public void a(int var1) {
            this.d = var1;
         }

         public void a(int var1, int var2, int var3, Interpolator var4) {
            this.a = var1;
            this.b = var2;
            this.c = var3;
            this.e = var4;
            this.f = true;
         }

         void a(RecyclerView var1) {
            if (this.d >= 0) {
               int var2 = this.d;
               this.d = -1;
               var1.jumpToPositionForSmoothScroller(var2);
               this.f = false;
            } else if (this.f) {
               this.b();
               if (this.e == null) {
                  if (this.c == Integer.MIN_VALUE) {
                     var1.mViewFlinger.b(this.a, this.b);
                  } else {
                     var1.mViewFlinger.a(this.a, this.b, this.c);
                  }
               } else {
                  var1.mViewFlinger.a(this.a, this.b, this.c, this.e);
               }

               this.g++;
               if (this.g > 10) {
                  Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
               }

               this.f = false;
            } else {
               this.g = 0;
            }
         }

         boolean a() {
            boolean var1;
            if (this.d >= 0) {
               var1 = true;
            } else {
               var1 = false;
            }

            return var1;
         }
      }

      public interface ScrollVectorProvider {
         PointF d(int var1);
      }
   }

   public static class State {
      int a;
      int b;
      int c;
      int d;
      boolean e;
      boolean f;
      boolean g;
      boolean h;
      boolean i;
      boolean j;
      int k;
      long l;
      int m;
      int n;
      int o;
      private int p = -1;
      private SparseArray<Object> q;

      public State() {
         this.a = 0;
         this.b = 0;
         this.c = 1;
         this.d = 0;
         this.e = false;
         this.f = false;
         this.g = false;
         this.h = false;
         this.i = false;
         this.j = false;
      }

      void a(int var1) {
         if ((this.c & var1) == 0) {
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(var1) + " but it is " + Integer.toBinaryString(this.c));
         }
      }

      void a(RecyclerView.Adapter var1) {
         this.c = 1;
         this.d = var1.getItemCount();
         this.f = false;
         this.g = false;
         this.h = false;
      }

      public boolean a() {
         return this.f;
      }

      public boolean b() {
         return this.j;
      }

      public int c() {
         return this.p;
      }

      public boolean d() {
         boolean var1;
         if (this.p != -1) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      public int e() {
         int var1;
         if (this.f) {
            var1 = this.a - this.b;
         } else {
            var1 = this.d;
         }

         return var1;
      }

      @Override
      public String toString() {
         return "State{mTargetPosition="
            + this.p
            + ", mData="
            + this.q
            + ", mItemCount="
            + this.d
            + ", mIsMeasuring="
            + this.h
            + ", mPreviousLayoutItemCount="
            + this.a
            + ", mDeletedInvisibleItemCountSincePreviousLayout="
            + this.b
            + ", mStructureChanged="
            + this.e
            + ", mInPreLayout="
            + this.f
            + ", mRunSimpleAnimations="
            + this.i
            + ", mRunPredictiveAnimations="
            + this.j
            + '}';
      }
   }

   public abstract static class ViewCacheExtension {
      public abstract View a(RecyclerView.Recycler var1, int var2, int var3);
   }

   class ViewFlinger implements Runnable {
      Interpolator a;
      final RecyclerView b;
      private int c;
      private int d;
      private OverScroller e;
      private boolean f;
      private boolean g;

      ViewFlinger(RecyclerView var1) {
         this.b = var1;
         this.a = RecyclerView.sQuinticInterpolator;
         this.f = false;
         this.g = false;
         this.e = new OverScroller(var1.getContext(), RecyclerView.sQuinticInterpolator);
      }

      private float a(float var1) {
         return (float)Math.sin((var1 - 0.5F) * 0.47123894F);
      }

      private int b(int var1, int var2, int var3, int var4) {
         int var10 = Math.abs(var1);
         int var9 = Math.abs(var2);
         boolean var8;
         if (var10 > var9) {
            var8 = true;
         } else {
            var8 = false;
         }

         var3 = (int)Math.sqrt(var3 * var3 + var4 * var4);
         var2 = (int)Math.sqrt(var1 * var1 + var2 * var2);
         if (var8) {
            var1 = this.b.getWidth();
         } else {
            var1 = this.b.getHeight();
         }

         var4 = var1 / 2;
         float var7 = Math.min(1.0F, var2 * 1.0F / var1);
         float var6 = var4;
         float var5 = var4;
         var7 = this.a(var7);
         if (var3 > 0) {
            var1 = Math.round(1000.0F * Math.abs((var7 * var5 + var6) / var3)) * 4;
         } else {
            if (var8) {
               var2 = var10;
            } else {
               var2 = var9;
            }

            var1 = (int)(((float)var2 / var1 + 1.0F) * 300.0F);
         }

         return Math.min(var1, 2000);
      }

      private void c() {
         this.g = false;
         this.f = true;
      }

      private void d() {
         this.f = false;
         if (this.g) {
            this.a();
         }
      }

      void a() {
         if (this.f) {
            this.g = true;
         } else {
            this.b.removeCallbacks(this);
            ViewCompat.a(this.b, this);
         }
      }

      public void a(int var1, int var2) {
         this.b.setScrollState(2);
         this.d = 0;
         this.c = 0;
         this.e.fling(0, 0, var1, var2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
         this.a();
      }

      public void a(int var1, int var2, int var3) {
         this.a(var1, var2, var3, RecyclerView.sQuinticInterpolator);
      }

      public void a(int var1, int var2, int var3, int var4) {
         this.a(var1, var2, this.b(var1, var2, var3, var4));
      }

      public void a(int var1, int var2, int var3, Interpolator var4) {
         if (this.a != var4) {
            this.a = var4;
            this.e = new OverScroller(this.b.getContext(), var4);
         }

         this.b.setScrollState(2);
         this.d = 0;
         this.c = 0;
         this.e.startScroll(0, 0, var1, var2, var3);
         if (VERSION.SDK_INT < 23) {
            this.e.computeScrollOffset();
         }

         this.a();
      }

      public void a(int var1, int var2, Interpolator var3) {
         int var4 = this.b(var1, var2, 0, 0);
         Interpolator var5 = var3;
         if (var3 == null) {
            var5 = RecyclerView.sQuinticInterpolator;
         }

         this.a(var1, var2, var4, var5);
      }

      public void b() {
         this.b.removeCallbacks(this);
         this.e.abortAnimation();
      }

      public void b(int var1, int var2) {
         this.a(var1, var2, 0, 0);
      }

      @Override
      public void run() {
         if (this.b.mLayout == null) {
            this.b();
         } else {
            this.c();
            this.b.consumePendingUpdateOperations();
            OverScroller var13 = this.e;
            RecyclerView.SmoothScroller var12 = this.b.mLayout.t;
            if (var13.computeScrollOffset()) {
               int[] var14 = this.b.mScrollConsumed;
               int var11 = var13.getCurrX();
               int var10 = var13.getCurrY();
               int var5 = var11 - this.c;
               int var6 = var10 - this.d;
               this.c = var11;
               this.d = var10;
               if (this.b.dispatchNestedPreScroll(var5, var6, var14, null, 1)) {
                  int var1 = var14[0];
                  var6 -= var14[1];
                  var5 -= var1;
               }

               int var2;
               int var3;
               int var15;
               int var21;
               label184:
               if (this.b.mAdapter != null) {
                  this.b.startInterceptRequestLayout();
                  this.b.onEnterLayoutOrScroll();
                  TraceCompat.a("RV Scroll");
                  this.b.fillRemainingScrollValues(this.b.mState);
                  int var4;
                  if (var5 != 0) {
                     var15 = this.b.mLayout.a(var5, this.b.mRecycler, this.b.mState);
                     var4 = var5 - var15;
                  } else {
                     var4 = 0;
                     var15 = 0;
                  }

                  if (var6 != 0) {
                     var2 = this.b.mLayout.b(var6, this.b.mRecycler, this.b.mState);
                     var3 = var6 - var2;
                  } else {
                     var3 = 0;
                     var2 = 0;
                  }

                  TraceCompat.a();
                  this.b.repositionShadowingViews();
                  this.b.onExitLayoutOrScroll();
                  this.b.stopInterceptRequestLayout(false);
                  if (var12 != null && !var12.g() && var12.h()) {
                     var21 = this.b.mState.e();
                     if (var21 == 0) {
                        var12.f();
                        var21 = var4;
                        break label184;
                     }

                     if (var12.i() >= var21) {
                        var12.d(var21 - 1);
                        var12.a(var5 - var4, var6 - var3);
                        var21 = var4;
                        break label184;
                     }

                     var12.a(var5 - var4, var6 - var3);
                  }

                  var21 = var4;
               } else {
                  var3 = 0;
                  var21 = 0;
                  var2 = 0;
                  var15 = 0;
               }

               if (!this.b.mItemDecorations.isEmpty()) {
                  this.b.invalidate();
               }

               if (this.b.getOverScrollMode() != 2) {
                  this.b.considerReleasingGlowsOnScroll(var5, var6);
               }

               if (!this.b.dispatchNestedScroll(var15, var2, var21, var3, null, 1) && (var21 != 0 || var3 != 0)) {
                  int var8 = (int)var13.getCurrVelocity();
                  int var9;
                  if (var21 != var11) {
                     int var19;
                     if (var21 < 0) {
                        var19 = -var8;
                     } else if (var21 > 0) {
                        var19 = var8;
                     } else {
                        var19 = 0;
                     }

                     var9 = var19;
                  } else {
                     var9 = 0;
                  }

                  int var20;
                  if (var3 != var10) {
                     if (var3 < 0) {
                        var20 = -var8;
                     } else {
                        var20 = var8;
                        if (var3 <= 0) {
                           var20 = 0;
                        }
                     }
                  } else {
                     var20 = 0;
                  }

                  if (this.b.getOverScrollMode() != 2) {
                     this.b.absorbGlows(var9, var20);
                  }

                  if ((var9 != 0 || var21 == var11 || var13.getFinalX() == 0) && (var20 != 0 || var3 == var10 || var13.getFinalY() == 0)) {
                     var13.abortAnimation();
                  }
               }

               if (var15 != 0 || var2 != 0) {
                  this.b.dispatchOnScrolled(var15, var2);
               }

               if (!this.b.awakenScrollBars()) {
                  this.b.invalidate();
               }

               boolean var18;
               if (var6 != 0 && this.b.mLayout.f() && var2 == var6) {
                  var18 = true;
               } else {
                  var18 = false;
               }

               boolean var16;
               if (var5 != 0 && this.b.mLayout.e() && var15 == var5) {
                  var16 = true;
               } else {
                  var16 = false;
               }

               if ((var5 != 0 || var6 != 0) && !var16 && !var18) {
                  var16 = false;
               } else {
                  var16 = true;
               }

               if (var13.isFinished() || !var16 && !this.b.hasNestedScrollingParent(1)) {
                  this.b.setScrollState(0);
                  if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                     this.b.mPrefetchRegistry.a();
                  }

                  this.b.stopNestedScroll(1);
               } else {
                  this.a();
                  if (this.b.mGapWorker != null) {
                     this.b.mGapWorker.a(this.b, var5, var6);
                  }
               }
            }

            if (var12 != null) {
               if (var12.g()) {
                  var12.a(0, 0);
               }

               if (!this.g) {
                  var12.f();
               }
            }

            this.d();
         }
      }
   }

   public abstract static class ViewHolder {
      static final int FLAG_ADAPTER_FULLUPDATE = 1024;
      static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
      static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
      static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
      static final int FLAG_BOUND = 1;
      static final int FLAG_IGNORE = 128;
      static final int FLAG_INVALID = 4;
      static final int FLAG_MOVED = 2048;
      static final int FLAG_NOT_RECYCLABLE = 16;
      static final int FLAG_REMOVED = 8;
      static final int FLAG_RETURNED_FROM_SCRAP = 32;
      static final int FLAG_SET_A11Y_ITEM_DELEGATE = 16384;
      static final int FLAG_TMP_DETACHED = 256;
      static final int FLAG_UPDATE = 2;
      private static final List<Object> FULLUPDATE_PAYLOADS = Collections.EMPTY_LIST;
      static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
      public final View itemView;
      private int mFlags;
      private boolean mInChangeScrap;
      private int mIsRecyclableCount;
      long mItemId;
      int mItemViewType;
      WeakReference<RecyclerView> mNestedRecyclerView;
      int mOldPosition;
      RecyclerView mOwnerRecyclerView;
      List<Object> mPayloads;
      int mPendingAccessibilityState;
      int mPosition = -1;
      int mPreLayoutPosition;
      private RecyclerView.Recycler mScrapContainer;
      RecyclerView.ViewHolder mShadowedHolder;
      RecyclerView.ViewHolder mShadowingHolder;
      List<Object> mUnmodifiedPayloads;
      private int mWasImportantForAccessibilityBeforeHidden;

      public ViewHolder(View var1) {
         this.mOldPosition = -1;
         this.mItemId = -1L;
         this.mItemViewType = -1;
         this.mPreLayoutPosition = -1;
         this.mShadowedHolder = null;
         this.mShadowingHolder = null;
         this.mPayloads = null;
         this.mUnmodifiedPayloads = null;
         this.mIsRecyclableCount = 0;
         this.mScrapContainer = null;
         this.mInChangeScrap = false;
         this.mWasImportantForAccessibilityBeforeHidden = 0;
         this.mPendingAccessibilityState = -1;
         if (var1 == null) {
            throw new IllegalArgumentException("itemView may not be null");
         }

         this.itemView = var1;
      }

      private void createPayloadsIfNeeded() {
         if (this.mPayloads == null) {
            this.mPayloads = new ArrayList<>();
            this.mUnmodifiedPayloads = Collections.unmodifiableList(this.mPayloads);
         }
      }

      private boolean doesTransientStatePreventRecycling() {
         boolean var1;
         if ((this.mFlags & 16) == 0 && ViewCompat.b(this.itemView)) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      private void onEnteredHiddenState(RecyclerView var1) {
         if (this.mPendingAccessibilityState != -1) {
            this.mWasImportantForAccessibilityBeforeHidden = this.mPendingAccessibilityState;
         } else {
            this.mWasImportantForAccessibilityBeforeHidden = ViewCompat.d(this.itemView);
         }

         var1.setChildImportantForAccessibilityInternal(this, 4);
      }

      private void onLeftHiddenState(RecyclerView var1) {
         var1.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
         this.mWasImportantForAccessibilityBeforeHidden = 0;
      }

      private boolean shouldBeKeptAsChild() {
         boolean var1;
         if ((this.mFlags & 16) != 0) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      void addChangePayload(Object var1) {
         if (var1 == null) {
            this.addFlags(1024);
         } else if ((this.mFlags & 1024) == 0) {
            this.createPayloadsIfNeeded();
            this.mPayloads.add(var1);
         }
      }

      void addFlags(int var1) {
         this.mFlags |= var1;
      }

      void clearOldPosition() {
         this.mOldPosition = -1;
         this.mPreLayoutPosition = -1;
      }

      void clearPayload() {
         if (this.mPayloads != null) {
            this.mPayloads.clear();
         }

         this.mFlags &= -1025;
      }

      void clearReturnedFromScrapFlag() {
         this.mFlags &= -33;
      }

      void clearTmpDetachFlag() {
         this.mFlags &= -257;
      }

      void flagRemovedAndOffsetPosition(int var1, int var2, boolean var3) {
         this.addFlags(8);
         this.offsetPosition(var2, var3);
         this.mPosition = var1;
      }

      public final int getAdapterPosition() {
         int var1;
         if (this.mOwnerRecyclerView == null) {
            var1 = -1;
         } else {
            var1 = this.mOwnerRecyclerView.getAdapterPositionFor(this);
         }

         return var1;
      }

      public final long getItemId() {
         return this.mItemId;
      }

      public final int getItemViewType() {
         return this.mItemViewType;
      }

      public final int getLayoutPosition() {
         int var1;
         if (this.mPreLayoutPosition == -1) {
            var1 = this.mPosition;
         } else {
            var1 = this.mPreLayoutPosition;
         }

         return var1;
      }

      public final int getOldPosition() {
         return this.mOldPosition;
      }

      @Deprecated
      public final int getPosition() {
         int var1;
         if (this.mPreLayoutPosition == -1) {
            var1 = this.mPosition;
         } else {
            var1 = this.mPreLayoutPosition;
         }

         return var1;
      }

      List<Object> getUnmodifiedPayloads() {
         List var1;
         if ((this.mFlags & 1024) == 0) {
            if (this.mPayloads != null && this.mPayloads.size() != 0) {
               var1 = this.mUnmodifiedPayloads;
            } else {
               var1 = FULLUPDATE_PAYLOADS;
            }
         } else {
            var1 = FULLUPDATE_PAYLOADS;
         }

         return var1;
      }

      boolean hasAnyOfTheFlags(int var1) {
         boolean var2;
         if ((this.mFlags & var1) != 0) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }

      boolean isAdapterPositionUnknown() {
         boolean var1;
         if ((this.mFlags & 512) == 0 && !this.isInvalid()) {
            var1 = false;
         } else {
            var1 = true;
         }

         return var1;
      }

      boolean isBound() {
         boolean var1;
         if ((this.mFlags & 1) != 0) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      boolean isInvalid() {
         boolean var1;
         if ((this.mFlags & 4) != 0) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      public final boolean isRecyclable() {
         boolean var1;
         if ((this.mFlags & 16) == 0 && !ViewCompat.b(this.itemView)) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      boolean isRemoved() {
         boolean var1;
         if ((this.mFlags & 8) != 0) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      boolean isScrap() {
         boolean var1;
         if (this.mScrapContainer != null) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      boolean isTmpDetached() {
         boolean var1;
         if ((this.mFlags & 256) != 0) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      boolean isUpdated() {
         boolean var1;
         if ((this.mFlags & 2) != 0) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      boolean needsUpdate() {
         boolean var1;
         if ((this.mFlags & 2) != 0) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      void offsetPosition(int var1, boolean var2) {
         if (this.mOldPosition == -1) {
            this.mOldPosition = this.mPosition;
         }

         if (this.mPreLayoutPosition == -1) {
            this.mPreLayoutPosition = this.mPosition;
         }

         if (var2) {
            this.mPreLayoutPosition += var1;
         }

         this.mPosition += var1;
         if (this.itemView.getLayoutParams() != null) {
            ((RecyclerView.LayoutParams)this.itemView.getLayoutParams()).e = true;
         }
      }

      void resetInternal() {
         this.mFlags = 0;
         this.mPosition = -1;
         this.mOldPosition = -1;
         this.mItemId = -1L;
         this.mPreLayoutPosition = -1;
         this.mIsRecyclableCount = 0;
         this.mShadowedHolder = null;
         this.mShadowingHolder = null;
         this.clearPayload();
         this.mWasImportantForAccessibilityBeforeHidden = 0;
         this.mPendingAccessibilityState = -1;
         RecyclerView.clearNestedRecyclerViewIfNotNested(this);
      }

      void saveOldPosition() {
         if (this.mOldPosition == -1) {
            this.mOldPosition = this.mPosition;
         }
      }

      void setFlags(int var1, int var2) {
         this.mFlags = this.mFlags & ~var2 | var1 & var2;
      }

      public final void setIsRecyclable(boolean var1) {
         int var2;
         if (var1) {
            var2 = this.mIsRecyclableCount - 1;
         } else {
            var2 = this.mIsRecyclableCount + 1;
         }

         this.mIsRecyclableCount = var2;
         if (this.mIsRecyclableCount < 0) {
            this.mIsRecyclableCount = 0;
            Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
         } else if (!var1 && this.mIsRecyclableCount == 1) {
            this.mFlags |= 16;
         } else if (var1 && this.mIsRecyclableCount == 0) {
            this.mFlags &= -17;
         }
      }

      void setScrapContainer(RecyclerView.Recycler var1, boolean var2) {
         this.mScrapContainer = var1;
         this.mInChangeScrap = var2;
      }

      boolean shouldIgnore() {
         boolean var1;
         if ((this.mFlags & 128) != 0) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      void stopIgnoring() {
         this.mFlags &= -129;
      }

      @Override
      public String toString() {
         StringBuilder var3 = new StringBuilder(
            "ViewHolder{"
               + Integer.toHexString(this.hashCode())
               + " position="
               + this.mPosition
               + " id="
               + this.mItemId
               + ", oldPos="
               + this.mOldPosition
               + ", pLpos:"
               + this.mPreLayoutPosition
         );
         if (this.isScrap()) {
            StringBuilder var2 = var3.append(" scrap ");
            String var1;
            if (this.mInChangeScrap) {
               var1 = "[changeScrap]";
            } else {
               var1 = "[attachedScrap]";
            }

            var2.append(var1);
         }

         if (this.isInvalid()) {
            var3.append(" invalid");
         }

         if (!this.isBound()) {
            var3.append(" unbound");
         }

         if (this.needsUpdate()) {
            var3.append(" update");
         }

         if (this.isRemoved()) {
            var3.append(" removed");
         }

         if (this.shouldIgnore()) {
            var3.append(" ignored");
         }

         if (this.isTmpDetached()) {
            var3.append(" tmpDetached");
         }

         if (!this.isRecyclable()) {
            var3.append(" not recyclable(" + this.mIsRecyclableCount + ")");
         }

         if (this.isAdapterPositionUnknown()) {
            var3.append(" undefined adapter position");
         }

         if (this.itemView.getParent() == null) {
            var3.append(" no parent");
         }

         var3.append("}");
         return var3.toString();
      }

      void unScrap() {
         this.mScrapContainer.c(this);
      }

      boolean wasReturnedFromScrap() {
         boolean var1;
         if ((this.mFlags & 32) != 0) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }
   }
}
