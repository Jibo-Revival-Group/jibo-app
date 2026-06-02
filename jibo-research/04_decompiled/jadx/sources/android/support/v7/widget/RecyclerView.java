package android.support.v7.widget;

import android.R;
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
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
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
import android.support.v7.widget.AdapterHelper;
import android.support.v7.widget.ChildHelper;
import android.support.v7.widget.GapWorker;
import android.support.v7.widget.ViewBoundsCheck;
import android.support.v7.widget.ViewInfoStore;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import com.facebook.internal.Utility;
import com.google.api.client.googleapis.media.MediaHttpUploader;
import com.yalantis.ucrop.util.FileUtils;
import com.yalantis.ucrop.view.CropImageView;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements NestedScrollingChild2 {
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC;
    private static final boolean ALLOW_THREAD_GAP_WORK;
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
    public static final long NO_ID = -1;
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
    private OnItemTouchListener mActiveOnItemTouchListener;
    Adapter mAdapter;
    AdapterHelper mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private ChildDrawingOrderCallback mChildDrawingOrderCallback;
    ChildHelper mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;
    private EdgeEffectFactory mEdgeEffectFactory;
    boolean mEnableFastScroller;
    boolean mFirstLayoutComplete;
    GapWorker mGapWorker;
    boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    boolean mIsAttached;
    ItemAnimator mItemAnimator;
    private ItemAnimator.ItemAnimatorListener mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    final ArrayList<ItemDecoration> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastTouchX;
    private int mLastTouchY;
    LayoutManager mLayout;
    boolean mLayoutFrozen;
    private int mLayoutOrScrollCounter;
    boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final RecyclerViewDataObserver mObserver;
    private List<OnChildAttachStateChangeListener> mOnChildAttachStateListeners;
    private OnFlingListener mOnFlingListener;
    private final ArrayList<OnItemTouchListener> mOnItemTouchListeners;
    final List<ViewHolder> mPendingAccessibilityImportanceChange;
    private SavedState mPendingSavedState;
    boolean mPostedAnimatorRunner;
    GapWorker.LayoutPrefetchRegistryImpl mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final Recycler mRecycler;
    RecyclerListener mRecyclerListener;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private final int[] mScrollConsumed;
    private OnScrollListener mScrollListener;
    private List<OnScrollListener> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private NestedScrollingChildHelper mScrollingChildHelper;
    final State mState;
    final Rect mTempRect;
    private final Rect mTempRect2;
    final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    final ViewFlinger mViewFlinger;
    private final ViewInfoStore.ProcessCallback mViewInfoProcessCallback;
    final ViewInfoStore mViewInfoStore;
    private static final int[] NESTED_SCROLLING_ATTRS = {R.attr.nestedScrollingEnabled};
    private static final int[] CLIP_TO_PADDING_ATTR = {R.attr.clipToPadding};

    public interface ChildDrawingOrderCallback {
        /* JADX INFO: renamed from: a */
        int mo4434a(int i, int i2);
    }

    public interface OnChildAttachStateChangeListener {
        /* JADX INFO: renamed from: a */
        void mo4575a(View view);

        /* JADX INFO: renamed from: b */
        void mo4576b(View view);
    }

    public static abstract class OnFlingListener {
        /* JADX INFO: renamed from: a */
        public abstract boolean m4577a(int i, int i2);
    }

    public interface OnItemTouchListener {
        /* JADX INFO: renamed from: a */
        void mo4159a(boolean z);

        /* JADX INFO: renamed from: a */
        boolean mo4161a(RecyclerView recyclerView, MotionEvent motionEvent);

        /* JADX INFO: renamed from: b */
        void mo4162b(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    public interface RecyclerListener {
        /* JADX INFO: renamed from: a */
        void m4630a(ViewHolder viewHolder);
    }

    public static abstract class ViewCacheExtension {
        /* JADX INFO: renamed from: a */
        public abstract View m4663a(Recycler recycler, int i, int i2);
    }

    static {
        FORCE_INVALIDATE_DISPLAY_LIST = Build.VERSION.SDK_INT == 18 || Build.VERSION.SDK_INT == 19 || Build.VERSION.SDK_INT == 20;
        ALLOW_SIZE_IN_UNSPECIFIED_SPEC = Build.VERSION.SDK_INT >= 23;
        POST_UPDATES_ON_ANIMATION = Build.VERSION.SDK_INT >= 16;
        ALLOW_THREAD_GAP_WORK = Build.VERSION.SDK_INT >= 21;
        FORCE_ABS_FOCUS_SEARCH_DIRECTION = Build.VERSION.SDK_INT <= 15;
        IGNORE_DETACHED_FOCUSED_CHILD = Build.VERSION.SDK_INT <= 15;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
        sQuinticInterpolator = new Interpolator() { // from class: android.support.v7.widget.RecyclerView.3
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                float f2 = f - 1.0f;
                return (f2 * f2 * f2 * f2 * f2) + 1.0f;
            }
        };
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecyclerView(Context context, AttributeSet attributeSet, int i) throws NoSuchMethodException {
        super(context, attributeSet, i);
        boolean z = true;
        this.mObserver = new RecyclerViewDataObserver();
        this.mRecycler = new Recycler();
        this.mViewInfoStore = new ViewInfoStore();
        this.mUpdateChildViewsRunnable = new Runnable() { // from class: android.support.v7.widget.RecyclerView.1
            @Override // java.lang.Runnable
            public void run() {
                if (RecyclerView.this.mFirstLayoutComplete && !RecyclerView.this.isLayoutRequested()) {
                    if (!RecyclerView.this.mIsAttached) {
                        RecyclerView.this.requestLayout();
                    } else if (RecyclerView.this.mLayoutFrozen) {
                        RecyclerView.this.mLayoutWasDefered = true;
                    } else {
                        RecyclerView.this.consumePendingUpdateOperations();
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
        this.mEdgeEffectFactory = new EdgeEffectFactory();
        this.mItemAnimator = new DefaultItemAnimator();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new ViewFlinger();
        this.mPrefetchRegistry = ALLOW_THREAD_GAP_WORK ? new GapWorker.LayoutPrefetchRegistryImpl() : null;
        this.mState = new State();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new ItemAnimatorRestoreListener();
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        this.mNestedOffsets = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new Runnable() { // from class: android.support.v7.widget.RecyclerView.2
            @Override // java.lang.Runnable
            public void run() {
                if (RecyclerView.this.mItemAnimator != null) {
                    RecyclerView.this.mItemAnimator.mo4100a();
                }
                RecyclerView.this.mPostedAnimatorRunner = false;
            }
        };
        this.mViewInfoProcessCallback = new ViewInfoStore.ProcessCallback() { // from class: android.support.v7.widget.RecyclerView.4
            @Override // android.support.v7.widget.ViewInfoStore.ProcessCallback
            /* JADX INFO: renamed from: a */
            public void mo4417a(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                RecyclerView.this.mRecycler.m4617c(viewHolder);
                RecyclerView.this.animateDisappearance(viewHolder, itemHolderInfo, itemHolderInfo2);
            }

            @Override // android.support.v7.widget.ViewInfoStore.ProcessCallback
            /* JADX INFO: renamed from: b */
            public void mo4418b(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                RecyclerView.this.animateAppearance(viewHolder, itemHolderInfo, itemHolderInfo2);
            }

            @Override // android.support.v7.widget.ViewInfoStore.ProcessCallback
            /* JADX INFO: renamed from: c */
            public void mo4419c(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                viewHolder.setIsRecyclable(false);
                if (RecyclerView.this.mDataSetHasChangedAfterLayout) {
                    if (RecyclerView.this.mItemAnimator.mo4442a(viewHolder, viewHolder, itemHolderInfo, itemHolderInfo2)) {
                        RecyclerView.this.postAnimationRunner();
                    }
                } else if (RecyclerView.this.mItemAnimator.mo4444c(viewHolder, itemHolderInfo, itemHolderInfo2)) {
                    RecyclerView.this.postAnimationRunner();
                }
            }

            @Override // android.support.v7.widget.ViewInfoStore.ProcessCallback
            /* JADX INFO: renamed from: a */
            public void mo4416a(ViewHolder viewHolder) {
                RecyclerView.this.mLayout.m4500a(viewHolder.itemView, RecyclerView.this.mRecycler);
            }
        };
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, CLIP_TO_PADDING_ATTR, i, 0);
            this.mClipToPadding = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
        } else {
            this.mClipToPadding = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = ViewConfigurationCompat.m2678a(viewConfiguration, context);
        this.mScaledVerticalScrollFactor = ViewConfigurationCompat.m2679b(viewConfiguration, context);
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.mItemAnimator.m4439a(this.mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        if (ViewCompat.m2599d(this) == 0) {
            ViewCompat.m2575a((View) this, 1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, android.support.v7.recyclerview.R.styleable.RecyclerView, i, 0);
            String string = typedArrayObtainStyledAttributes2.getString(android.support.v7.recyclerview.R.styleable.RecyclerView_layoutManager);
            if (typedArrayObtainStyledAttributes2.getInt(android.support.v7.recyclerview.R.styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
                setDescendantFocusability(MediaHttpUploader.MINIMUM_CHUNK_SIZE);
            }
            this.mEnableFastScroller = typedArrayObtainStyledAttributes2.getBoolean(android.support.v7.recyclerview.R.styleable.RecyclerView_fastScrollEnabled, false);
            if (this.mEnableFastScroller) {
                initFastScroller((StateListDrawable) typedArrayObtainStyledAttributes2.getDrawable(android.support.v7.recyclerview.R.styleable.RecyclerView_fastScrollVerticalThumbDrawable), typedArrayObtainStyledAttributes2.getDrawable(android.support.v7.recyclerview.R.styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) typedArrayObtainStyledAttributes2.getDrawable(android.support.v7.recyclerview.R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable), typedArrayObtainStyledAttributes2.getDrawable(android.support.v7.recyclerview.R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
            }
            typedArrayObtainStyledAttributes2.recycle();
            createLayoutManager(context, string, attributeSet, i, 0);
            if (Build.VERSION.SDK_INT >= 21) {
                TypedArray typedArrayObtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, NESTED_SCROLLING_ATTRS, i, 0);
                z = typedArrayObtainStyledAttributes3.getBoolean(0, true);
                typedArrayObtainStyledAttributes3.recycle();
            }
        } else {
            setDescendantFocusability(MediaHttpUploader.MINIMUM_CHUNK_SIZE);
        }
        setNestedScrollingEnabled(z);
    }

    String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
    }

    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
        this.mAccessibilityDelegate = recyclerViewAccessibilityDelegate;
        ViewCompat.m2583a(this, this.mAccessibilityDelegate);
    }

    private void createLayoutManager(Context context, String str, AttributeSet attributeSet, int i, int i2) throws NoSuchMethodException {
        ClassLoader classLoader;
        Constructor constructor;
        Object[] objArr;
        if (str != null) {
            String strTrim = str.trim();
            if (!strTrim.isEmpty()) {
                String fullClassName = getFullClassName(context, strTrim);
                try {
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class<? extends U> clsAsSubclass = classLoader.loadClass(fullClassName).asSubclass(LayoutManager.class);
                    try {
                        Constructor constructor2 = clsAsSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
                        constructor = constructor2;
                    } catch (NoSuchMethodException e) {
                        try {
                            constructor = clsAsSubclass.getConstructor(new Class[0]);
                            objArr = null;
                        } catch (NoSuchMethodException e2) {
                            e2.initCause(e);
                            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + fullClassName, e2);
                        }
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((LayoutManager) constructor.newInstance(objArr));
                } catch (ClassCastException e3) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + fullClassName, e3);
                } catch (ClassNotFoundException e4) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + fullClassName, e4);
                } catch (IllegalAccessException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + fullClassName, e5);
                } catch (InstantiationException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e6);
                } catch (InvocationTargetException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e7);
                }
            }
        }
    }

    private String getFullClassName(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        return !str.contains(FileUtils.HIDDEN_PREFIX) ? RecyclerView.class.getPackage().getName() + '.' + str : str;
    }

    private void initChildrenHelper() {
        this.mChildHelper = new ChildHelper(new ChildHelper.Callback() { // from class: android.support.v7.widget.RecyclerView.5
            @Override // android.support.v7.widget.ChildHelper.Callback
            /* JADX INFO: renamed from: a */
            public int mo4033a() {
                return RecyclerView.this.getChildCount();
            }

            @Override // android.support.v7.widget.ChildHelper.Callback
            /* JADX INFO: renamed from: a */
            public void mo4036a(View view, int i) {
                RecyclerView.this.addView(view, i);
                RecyclerView.this.dispatchChildAttached(view);
            }

            @Override // android.support.v7.widget.ChildHelper.Callback
            /* JADX INFO: renamed from: a */
            public int mo4034a(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            @Override // android.support.v7.widget.ChildHelper.Callback
            /* JADX INFO: renamed from: a */
            public void mo4035a(int i) {
                View childAt = RecyclerView.this.getChildAt(i);
                if (childAt != null) {
                    RecyclerView.this.dispatchChildDetached(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i);
            }

            @Override // android.support.v7.widget.ChildHelper.Callback
            /* JADX INFO: renamed from: b */
            public View mo4039b(int i) {
                return RecyclerView.this.getChildAt(i);
            }

            @Override // android.support.v7.widget.ChildHelper.Callback
            /* JADX INFO: renamed from: b */
            public void mo4040b() {
                int iMo4033a = mo4033a();
                for (int i = 0; i < iMo4033a; i++) {
                    View viewMo4039b = mo4039b(i);
                    RecyclerView.this.dispatchChildDetached(viewMo4039b);
                    viewMo4039b.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }

            @Override // android.support.v7.widget.ChildHelper.Callback
            /* JADX INFO: renamed from: b */
            public ViewHolder mo4038b(View view) {
                return RecyclerView.getChildViewHolderInt(view);
            }

            @Override // android.support.v7.widget.ChildHelper.Callback
            /* JADX INFO: renamed from: a */
            public void mo4037a(View view, int i, ViewGroup.LayoutParams layoutParams) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    if (!childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                    }
                    childViewHolderInt.clearTmpDetachFlag();
                }
                RecyclerView.this.attachViewToParent(view, i, layoutParams);
            }

            @Override // android.support.v7.widget.ChildHelper.Callback
            /* JADX INFO: renamed from: c */
            public void mo4041c(int i) {
                ViewHolder childViewHolderInt;
                View viewMo4039b = mo4039b(i);
                if (viewMo4039b != null && (childViewHolderInt = RecyclerView.getChildViewHolderInt(viewMo4039b)) != null) {
                    if (childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                        throw new IllegalArgumentException("called detach on an already detached child " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                    }
                    childViewHolderInt.addFlags(256);
                }
                RecyclerView.this.detachViewFromParent(i);
            }

            @Override // android.support.v7.widget.ChildHelper.Callback
            /* JADX INFO: renamed from: c */
            public void mo4042c(View view) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt == null) {
                    return;
                }
                childViewHolderInt.onEnteredHiddenState(RecyclerView.this);
            }

            @Override // android.support.v7.widget.ChildHelper.Callback
            /* JADX INFO: renamed from: d */
            public void mo4043d(View view) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt == null) {
                    return;
                }
                childViewHolderInt.onLeftHiddenState(RecyclerView.this);
            }
        });
    }

    void initAdapterManager() {
        this.mAdapterHelper = new AdapterHelper(new AdapterHelper.Callback() { // from class: android.support.v7.widget.RecyclerView.6
            @Override // android.support.v7.widget.AdapterHelper.Callback
            /* JADX INFO: renamed from: a */
            public ViewHolder mo3824a(int i) {
                ViewHolder viewHolderFindViewHolderForPosition = RecyclerView.this.findViewHolderForPosition(i, true);
                if (viewHolderFindViewHolderForPosition == null || RecyclerView.this.mChildHelper.m4019c(viewHolderFindViewHolderForPosition.itemView)) {
                    return null;
                }
                return viewHolderFindViewHolderForPosition;
            }

            @Override // android.support.v7.widget.AdapterHelper.Callback
            /* JADX INFO: renamed from: a */
            public void mo3825a(int i, int i2) {
                RecyclerView.this.offsetPositionRecordsForRemove(i, i2, true);
                RecyclerView.this.mItemsAddedOrRemoved = true;
                RecyclerView.this.mState.f4131b += i2;
            }

            @Override // android.support.v7.widget.AdapterHelper.Callback
            /* JADX INFO: renamed from: b */
            public void mo3828b(int i, int i2) {
                RecyclerView.this.offsetPositionRecordsForRemove(i, i2, false);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            @Override // android.support.v7.widget.AdapterHelper.Callback
            /* JADX INFO: renamed from: a */
            public void mo3826a(int i, int i2, Object obj) {
                RecyclerView.this.viewRangeUpdate(i, i2, obj);
                RecyclerView.this.mItemsChanged = true;
            }

            @Override // android.support.v7.widget.AdapterHelper.Callback
            /* JADX INFO: renamed from: a */
            public void mo3827a(AdapterHelper.UpdateOp updateOp) {
                m4420c(updateOp);
            }

            /* JADX INFO: renamed from: c */
            void m4420c(AdapterHelper.UpdateOp updateOp) {
                switch (updateOp.f3639a) {
                    case 1:
                        RecyclerView.this.mLayout.mo4220a(RecyclerView.this, updateOp.f3640b, updateOp.f3642d);
                        break;
                    case 2:
                        RecyclerView.this.mLayout.mo4227b(RecyclerView.this, updateOp.f3640b, updateOp.f3642d);
                        break;
                    case 4:
                        RecyclerView.this.mLayout.mo4222a(RecyclerView.this, updateOp.f3640b, updateOp.f3642d, updateOp.f3641c);
                        break;
                    case 8:
                        RecyclerView.this.mLayout.mo4221a(RecyclerView.this, updateOp.f3640b, updateOp.f3642d, 1);
                        break;
                }
            }

            @Override // android.support.v7.widget.AdapterHelper.Callback
            /* JADX INFO: renamed from: b */
            public void mo3829b(AdapterHelper.UpdateOp updateOp) {
                m4420c(updateOp);
            }

            @Override // android.support.v7.widget.AdapterHelper.Callback
            /* JADX INFO: renamed from: c */
            public void mo3830c(int i, int i2) {
                RecyclerView.this.offsetPositionRecordsForInsert(i, i2);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            @Override // android.support.v7.widget.AdapterHelper.Callback
            /* JADX INFO: renamed from: d */
            public void mo3831d(int i, int i2) {
                RecyclerView.this.offsetPositionRecordsForMove(i, i2);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }
        });
    }

    public void setHasFixedSize(boolean z) {
        this.mHasFixedSize = z;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z;
        super.setClipToPadding(z);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        switch (i) {
            case 0:
                break;
            case 1:
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            default:
                Log.w(TAG, "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
                break;
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void swapAdapter(Adapter adapter, boolean z) {
        setLayoutFrozen(false);
        setAdapterInternal(adapter, true, z);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    public void setAdapter(Adapter adapter) {
        setLayoutFrozen(false);
        setAdapterInternal(adapter, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    void removeAndRecycleViews() {
        if (this.mItemAnimator != null) {
            this.mItemAnimator.mo4112d();
        }
        if (this.mLayout != null) {
            this.mLayout.m4521c(this.mRecycler);
            this.mLayout.m4514b(this.mRecycler);
        }
        this.mRecycler.m4598a();
    }

    private void setAdapterInternal(Adapter adapter, boolean z, boolean z2) {
        if (this.mAdapter != null) {
            this.mAdapter.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!z || z2) {
            removeAndRecycleViews();
        }
        this.mAdapterHelper.m3808a();
        Adapter adapter2 = this.mAdapter;
        this.mAdapter = adapter;
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.mObserver);
            adapter.onAttachedToRecyclerView(this);
        }
        if (this.mLayout != null) {
            this.mLayout.m4487a(adapter2, this.mAdapter);
        }
        this.mRecycler.m4602a(adapter2, this.mAdapter, z);
        this.mState.f4134e = true;
    }

    public Adapter getAdapter() {
        return this.mAdapter;
    }

    public void setRecyclerListener(RecyclerListener recyclerListener) {
        this.mRecyclerListener = recyclerListener;
    }

    @Override // android.view.View
    public int getBaseline() {
        return this.mLayout != null ? this.mLayout.m4560u() : super.getBaseline();
    }

    public void addOnChildAttachStateChangeListener(OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(onChildAttachStateChangeListener);
    }

    public void removeOnChildAttachStateChangeListener(OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        if (this.mOnChildAttachStateListeners != null) {
            this.mOnChildAttachStateListeners.remove(onChildAttachStateChangeListener);
        }
    }

    public void clearOnChildAttachStateChangeListeners() {
        if (this.mOnChildAttachStateListeners != null) {
            this.mOnChildAttachStateListeners.clear();
        }
    }

    public void setLayoutManager(LayoutManager layoutManager) {
        if (layoutManager != this.mLayout) {
            stopScroll();
            if (this.mLayout != null) {
                if (this.mItemAnimator != null) {
                    this.mItemAnimator.mo4112d();
                }
                this.mLayout.m4521c(this.mRecycler);
                this.mLayout.m4514b(this.mRecycler);
                this.mRecycler.m4598a();
                if (this.mIsAttached) {
                    this.mLayout.m4516b(this, this.mRecycler);
                }
                this.mLayout.m4515b((RecyclerView) null);
                this.mLayout = null;
            } else {
                this.mRecycler.m4598a();
            }
            this.mChildHelper.m4008a();
            this.mLayout = layoutManager;
            if (layoutManager != null) {
                if (layoutManager.f4080q != null) {
                    throw new IllegalArgumentException("LayoutManager " + layoutManager + " is already attached to a RecyclerView:" + layoutManager.f4080q.exceptionLabel());
                }
                this.mLayout.m4515b(this);
                if (this.mIsAttached) {
                    this.mLayout.m4522c(this);
                }
            }
            this.mRecycler.m4610b();
            requestLayout();
        }
    }

    public void setOnFlingListener(OnFlingListener onFlingListener) {
        this.mOnFlingListener = onFlingListener;
    }

    public OnFlingListener getOnFlingListener() {
        return this.mOnFlingListener;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.mPendingSavedState != null) {
            savedState.m4632a(this.mPendingSavedState);
        } else if (this.mLayout != null) {
            savedState.f4115a = this.mLayout.mo4310d();
        } else {
            savedState.f4115a = null;
        }
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        this.mPendingSavedState = (SavedState) parcelable;
        super.onRestoreInstanceState(this.mPendingSavedState.m2474a());
        if (this.mLayout != null && this.mPendingSavedState.f4115a != null) {
            this.mLayout.mo4293a(this.mPendingSavedState.f4115a);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    private void addAnimatingView(ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        boolean z = view.getParent() == this;
        this.mRecycler.m4617c(getChildViewHolder(view));
        if (viewHolder.isTmpDetached()) {
            this.mChildHelper.m4011a(view, -1, view.getLayoutParams(), true);
        } else if (!z) {
            this.mChildHelper.m4013a(view, true);
        } else {
            this.mChildHelper.m4021d(view);
        }
    }

    boolean removeAnimatingView(View view) {
        startInterceptRequestLayout();
        boolean zM4024f = this.mChildHelper.m4024f(view);
        if (zM4024f) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(view);
            this.mRecycler.m4617c(childViewHolderInt);
            this.mRecycler.m4612b(childViewHolderInt);
        }
        stopInterceptRequestLayout(!zM4024f);
        return zM4024f;
    }

    public LayoutManager getLayoutManager() {
        return this.mLayout;
    }

    public RecycledViewPool getRecycledViewPool() {
        return this.mRecycler.m4626g();
    }

    public void setRecycledViewPool(RecycledViewPool recycledViewPool) {
        this.mRecycler.m4603a(recycledViewPool);
    }

    public void setViewCacheExtension(ViewCacheExtension viewCacheExtension) {
        this.mRecycler.m4604a(viewCacheExtension);
    }

    public void setItemViewCacheSize(int i) {
        this.mRecycler.m4599a(i);
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    void setScrollState(int i) {
        if (i != this.mScrollState) {
            this.mScrollState = i;
            if (i != 2) {
                stopScrollersInternal();
            }
            dispatchOnScrollStateChanged(i);
        }
    }

    public void addItemDecoration(ItemDecoration itemDecoration, int i) {
        if (this.mLayout != null) {
            this.mLayout.mo4298a("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i < 0) {
            this.mItemDecorations.add(itemDecoration);
        } else {
            this.mItemDecorations.add(i, itemDecoration);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addItemDecoration(ItemDecoration itemDecoration) {
        addItemDecoration(itemDecoration, -1);
    }

    public ItemDecoration getItemDecorationAt(int i) {
        int itemDecorationCount = getItemDecorationCount();
        if (i < 0 || i >= itemDecorationCount) {
            throw new IndexOutOfBoundsException(i + " is an invalid index for size " + itemDecorationCount);
        }
        return this.mItemDecorations.get(i);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    public void removeItemDecorationAt(int i) {
        int itemDecorationCount = getItemDecorationCount();
        if (i < 0 || i >= itemDecorationCount) {
            throw new IndexOutOfBoundsException(i + " is an invalid index for size " + itemDecorationCount);
        }
        removeItemDecoration(getItemDecorationAt(i));
    }

    public void removeItemDecoration(ItemDecoration itemDecoration) {
        if (this.mLayout != null) {
            this.mLayout.mo4298a("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(itemDecoration);
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void setChildDrawingOrderCallback(ChildDrawingOrderCallback childDrawingOrderCallback) {
        if (childDrawingOrderCallback != this.mChildDrawingOrderCallback) {
            this.mChildDrawingOrderCallback = childDrawingOrderCallback;
            setChildrenDrawingOrderEnabled(this.mChildDrawingOrderCallback != null);
        }
    }

    @Deprecated
    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.mScrollListener = onScrollListener;
    }

    public void addOnScrollListener(OnScrollListener onScrollListener) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(onScrollListener);
    }

    public void removeOnScrollListener(OnScrollListener onScrollListener) {
        if (this.mScrollListeners != null) {
            this.mScrollListeners.remove(onScrollListener);
        }
    }

    public void clearOnScrollListeners() {
        if (this.mScrollListeners != null) {
            this.mScrollListeners.clear();
        }
    }

    public void scrollToPosition(int i) {
        if (!this.mLayoutFrozen) {
            stopScroll();
            if (this.mLayout == null) {
                Log.e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
            } else {
                this.mLayout.mo4312e(i);
                awakenScrollBars();
            }
        }
    }

    void jumpToPositionForSmoothScroller(int i) {
        if (this.mLayout != null) {
            this.mLayout.mo4312e(i);
            awakenScrollBars();
        }
    }

    public void smoothScrollToPosition(int i) {
        if (!this.mLayoutFrozen) {
            if (this.mLayout == null) {
                Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            } else {
                this.mLayout.mo4295a(this, this.mState, i);
            }
        }
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        Log.w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View
    public void scrollBy(int i, int i2) {
        if (this.mLayout == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (!this.mLayoutFrozen) {
            boolean zMo4313e = this.mLayout.mo4313e();
            boolean zMo4316f = this.mLayout.mo4316f();
            if (zMo4313e || zMo4316f) {
                if (!zMo4313e) {
                    i = 0;
                }
                if (!zMo4316f) {
                    i2 = 0;
                }
                scrollByInternal(i, i2, null);
            }
        }
    }

    void consumePendingUpdateOperations() {
        if (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout) {
            TraceCompat.m2325a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
            dispatchLayout();
            TraceCompat.m2324a();
            return;
        }
        if (this.mAdapterHelper.m3821d()) {
            if (this.mAdapterHelper.m3812a(4) && !this.mAdapterHelper.m3812a(11)) {
                TraceCompat.m2325a(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                this.mAdapterHelper.m3816b();
                if (!this.mLayoutWasDefered) {
                    if (hasUpdatedView()) {
                        dispatchLayout();
                    } else {
                        this.mAdapterHelper.m3819c();
                    }
                }
                stopInterceptRequestLayout(true);
                onExitLayoutOrScroll();
                TraceCompat.m2324a();
                return;
            }
            if (this.mAdapterHelper.m3821d()) {
                TraceCompat.m2325a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
                dispatchLayout();
                TraceCompat.m2324a();
            }
        }
    }

    private boolean hasUpdatedView() {
        int iM4014b = this.mChildHelper.m4014b();
        for (int i = 0; i < iM4014b; i++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4016b(i));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.isUpdated()) {
                return true;
            }
        }
        return false;
    }

    boolean scrollByInternal(int i, int i2, MotionEvent motionEvent) {
        int i3;
        int i4;
        int i5;
        int i6;
        int iMo4204a;
        int iMo4225b;
        int i7;
        consumePendingUpdateOperations();
        if (this.mAdapter != null) {
            startInterceptRequestLayout();
            onEnterLayoutOrScroll();
            TraceCompat.m2325a(TRACE_SCROLL_TAG);
            fillRemainingScrollValues(this.mState);
            if (i != 0) {
                iMo4204a = this.mLayout.mo4204a(i, this.mRecycler, this.mState);
                i6 = i - iMo4204a;
            } else {
                iMo4204a = 0;
                i6 = 0;
            }
            if (i2 != 0) {
                iMo4225b = this.mLayout.mo4225b(i2, this.mRecycler, this.mState);
                i7 = i2 - iMo4225b;
            } else {
                iMo4225b = 0;
                i7 = 0;
            }
            TraceCompat.m2324a();
            repositionShadowingViews();
            onExitLayoutOrScroll();
            stopInterceptRequestLayout(false);
            i5 = i7;
            i4 = iMo4204a;
            i3 = iMo4225b;
        } else {
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        if (dispatchNestedScroll(i4, i3, i6, i5, this.mScrollOffset, 0)) {
            this.mLastTouchX -= this.mScrollOffset[0];
            this.mLastTouchY -= this.mScrollOffset[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation(this.mScrollOffset[0], this.mScrollOffset[1]);
            }
            int[] iArr = this.mNestedOffsets;
            iArr[0] = iArr[0] + this.mScrollOffset[0];
            int[] iArr2 = this.mNestedOffsets;
            iArr2[1] = iArr2[1] + this.mScrollOffset[1];
        } else if (getOverScrollMode() != 2) {
            if (motionEvent != null && !MotionEventCompat.m2528a(motionEvent, 8194)) {
                pullGlows(motionEvent.getX(), i6, motionEvent.getY(), i5);
            }
            considerReleasingGlowsOnScroll(i, i2);
        }
        if (i4 != 0 || i3 != 0) {
            dispatchOnScrolled(i4, i3);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (i4 == 0 && i3 == 0) ? false : true;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        if (this.mLayout != null && this.mLayout.mo4313e()) {
            return this.mLayout.mo4304c(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        if (this.mLayout != null && this.mLayout.mo4313e()) {
            return this.mLayout.mo4311e(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        if (this.mLayout != null && this.mLayout.mo4313e()) {
            return this.mLayout.mo4318g(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        if (this.mLayout != null && this.mLayout.mo4316f()) {
            return this.mLayout.mo4308d(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        if (this.mLayout != null && this.mLayout.mo4316f()) {
            return this.mLayout.mo4315f(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        if (this.mLayout != null && this.mLayout.mo4316f()) {
            return this.mLayout.mo4319h(this.mState);
        }
        return 0;
    }

    void startInterceptRequestLayout() {
        this.mInterceptRequestLayoutDepth++;
        if (this.mInterceptRequestLayoutDepth == 1 && !this.mLayoutFrozen) {
            this.mLayoutWasDefered = false;
        }
    }

    void stopInterceptRequestLayout(boolean z) {
        if (this.mInterceptRequestLayoutDepth < 1) {
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!z && !this.mLayoutFrozen) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z && this.mLayoutWasDefered && !this.mLayoutFrozen && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutFrozen) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.mLayoutFrozen) {
            assertNotInLayoutOrScroll("Do not setLayoutFrozen in layout or scroll");
            if (!z) {
                this.mLayoutFrozen = false;
                if (this.mLayoutWasDefered && this.mLayout != null && this.mAdapter != null) {
                    requestLayout();
                }
                this.mLayoutWasDefered = false;
                return;
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 0));
            this.mLayoutFrozen = true;
            this.mIgnoreMotionEventTillDown = true;
            stopScroll();
        }
    }

    public boolean isLayoutFrozen() {
        return this.mLayoutFrozen;
    }

    public void smoothScrollBy(int i, int i2) {
        smoothScrollBy(i, i2, null);
    }

    public void smoothScrollBy(int i, int i2, Interpolator interpolator) {
        if (this.mLayout == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (!this.mLayoutFrozen) {
            if (!this.mLayout.mo4313e()) {
                i = 0;
            }
            int i3 = this.mLayout.mo4316f() ? i2 : 0;
            if (i != 0 || i3 != 0) {
                this.mViewFlinger.m4674a(i, i3, interpolator);
            }
        }
    }

    public boolean fling(int i, int i2) {
        if (this.mLayout == null) {
            Log.e(TAG, "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.mLayoutFrozen) {
            return false;
        }
        boolean zMo4313e = this.mLayout.mo4313e();
        boolean zMo4316f = this.mLayout.mo4316f();
        if (!zMo4313e || Math.abs(i) < this.mMinFlingVelocity) {
            i = 0;
        }
        if (!zMo4316f || Math.abs(i2) < this.mMinFlingVelocity) {
            i2 = 0;
        }
        if ((i == 0 && i2 == 0) || dispatchNestedPreFling(i, i2)) {
            return false;
        }
        boolean z = zMo4313e || zMo4316f;
        dispatchNestedFling(i, i2, z);
        if (this.mOnFlingListener != null && this.mOnFlingListener.m4577a(i, i2)) {
            return true;
        }
        if (!z) {
            return false;
        }
        int i3 = zMo4313e ? 1 : 0;
        if (zMo4316f) {
            i3 |= 2;
        }
        startNestedScroll(i3, 1);
        this.mViewFlinger.m4670a(Math.max(-this.mMaxFlingVelocity, Math.min(i, this.mMaxFlingVelocity)), Math.max(-this.mMaxFlingVelocity, Math.min(i2, this.mMaxFlingVelocity)));
        return true;
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.m4675b();
        if (this.mLayout != null) {
            this.mLayout.m4482I();
        }
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    private void pullGlows(float f, float f2, float f3, float f4) {
        boolean z = true;
        boolean z2 = false;
        if (f2 < CropImageView.DEFAULT_ASPECT_RATIO) {
            ensureLeftGlow();
            EdgeEffectCompat.m3012a(this.mLeftGlow, (-f2) / getWidth(), 1.0f - (f3 / getHeight()));
            z2 = true;
        } else if (f2 > CropImageView.DEFAULT_ASPECT_RATIO) {
            ensureRightGlow();
            EdgeEffectCompat.m3012a(this.mRightGlow, f2 / getWidth(), f3 / getHeight());
            z2 = true;
        }
        if (f4 < CropImageView.DEFAULT_ASPECT_RATIO) {
            ensureTopGlow();
            EdgeEffectCompat.m3012a(this.mTopGlow, (-f4) / getHeight(), f / getWidth());
        } else if (f4 > CropImageView.DEFAULT_ASPECT_RATIO) {
            ensureBottomGlow();
            EdgeEffectCompat.m3012a(this.mBottomGlow, f4 / getHeight(), 1.0f - (f / getWidth()));
        } else {
            z = z2;
        }
        if (z || f2 != CropImageView.DEFAULT_ASPECT_RATIO || f4 != CropImageView.DEFAULT_ASPECT_RATIO) {
            ViewCompat.m2597c(this);
        }
    }

    private void releaseGlows() {
        boolean zIsFinished = false;
        if (this.mLeftGlow != null) {
            this.mLeftGlow.onRelease();
            zIsFinished = this.mLeftGlow.isFinished();
        }
        if (this.mTopGlow != null) {
            this.mTopGlow.onRelease();
            zIsFinished |= this.mTopGlow.isFinished();
        }
        if (this.mRightGlow != null) {
            this.mRightGlow.onRelease();
            zIsFinished |= this.mRightGlow.isFinished();
        }
        if (this.mBottomGlow != null) {
            this.mBottomGlow.onRelease();
            zIsFinished |= this.mBottomGlow.isFinished();
        }
        if (zIsFinished) {
            ViewCompat.m2597c(this);
        }
    }

    void considerReleasingGlowsOnScroll(int i, int i2) {
        boolean zIsFinished = false;
        if (this.mLeftGlow != null && !this.mLeftGlow.isFinished() && i > 0) {
            this.mLeftGlow.onRelease();
            zIsFinished = this.mLeftGlow.isFinished();
        }
        if (this.mRightGlow != null && !this.mRightGlow.isFinished() && i < 0) {
            this.mRightGlow.onRelease();
            zIsFinished |= this.mRightGlow.isFinished();
        }
        if (this.mTopGlow != null && !this.mTopGlow.isFinished() && i2 > 0) {
            this.mTopGlow.onRelease();
            zIsFinished |= this.mTopGlow.isFinished();
        }
        if (this.mBottomGlow != null && !this.mBottomGlow.isFinished() && i2 < 0) {
            this.mBottomGlow.onRelease();
            zIsFinished |= this.mBottomGlow.isFinished();
        }
        if (zIsFinished) {
            ViewCompat.m2597c(this);
        }
    }

    void absorbGlows(int i, int i2) {
        if (i < 0) {
            ensureLeftGlow();
            this.mLeftGlow.onAbsorb(-i);
        } else if (i > 0) {
            ensureRightGlow();
            this.mRightGlow.onAbsorb(i);
        }
        if (i2 < 0) {
            ensureTopGlow();
            this.mTopGlow.onAbsorb(-i2);
        } else if (i2 > 0) {
            ensureBottomGlow();
            this.mBottomGlow.onAbsorb(i2);
        }
        if (i != 0 || i2 != 0) {
            ViewCompat.m2597c(this);
        }
    }

    void ensureLeftGlow() {
        if (this.mLeftGlow == null) {
            this.mLeftGlow = this.mEdgeEffectFactory.m4435a(this, 0);
            if (this.mClipToPadding) {
                this.mLeftGlow.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.mLeftGlow.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void ensureRightGlow() {
        if (this.mRightGlow == null) {
            this.mRightGlow = this.mEdgeEffectFactory.m4435a(this, 2);
            if (this.mClipToPadding) {
                this.mRightGlow.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.mRightGlow.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void ensureTopGlow() {
        if (this.mTopGlow == null) {
            this.mTopGlow = this.mEdgeEffectFactory.m4435a(this, 1);
            if (this.mClipToPadding) {
                this.mTopGlow.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.mTopGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void ensureBottomGlow() {
        if (this.mBottomGlow == null) {
            this.mBottomGlow = this.mEdgeEffectFactory.m4435a(this, 3);
            if (this.mClipToPadding) {
                this.mBottomGlow.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.mBottomGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void setEdgeEffectFactory(EdgeEffectFactory edgeEffectFactory) {
        Preconditions.m2441a(edgeEffectFactory);
        this.mEdgeEffectFactory = edgeEffectFactory;
        invalidateGlows();
    }

    public EdgeEffectFactory getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i) {
        View viewMo4210a;
        boolean z;
        boolean z2;
        View viewM4528d = this.mLayout.m4528d(view, i);
        if (viewM4528d != null) {
            return viewM4528d;
        }
        boolean z3 = (this.mAdapter == null || this.mLayout == null || isComputingLayout() || this.mLayoutFrozen) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z3 && (i == 2 || i == 1)) {
            if (this.mLayout.mo4316f()) {
                int i2 = i == 2 ? 130 : 33;
                boolean z4 = focusFinder.findNextFocus(this, view, i2) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i = i2;
                    z = z4;
                } else {
                    z = z4;
                }
            } else {
                z = false;
            }
            if (z || !this.mLayout.mo4313e()) {
                z2 = z;
            } else {
                int i3 = (i == 2) ^ (this.mLayout.m4559t() == 1) ? 66 : 17;
                z2 = focusFinder.findNextFocus(this, view, i3) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i = i3;
                }
            }
            if (z2) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                this.mLayout.mo4210a(view, i, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
            viewMo4210a = focusFinder.findNextFocus(this, view, i);
        } else {
            View viewFindNextFocus = focusFinder.findNextFocus(this, view, i);
            if (viewFindNextFocus == null && z3) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                viewMo4210a = this.mLayout.mo4210a(view, i, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            } else {
                viewMo4210a = viewFindNextFocus;
            }
        }
        if (viewMo4210a != null && !viewMo4210a.hasFocusable()) {
            if (getFocusedChild() == null) {
                return super.focusSearch(view, i);
            }
            requestChildOnScreen(viewMo4210a, null);
            return view;
        }
        if (!isPreferredNextFocus(view, viewMo4210a, i)) {
            viewMo4210a = super.focusSearch(view, i);
        }
        return viewMo4210a;
    }

    private boolean isPreferredNextFocus(View view, View view2, int i) {
        int i2;
        byte b = -1;
        boolean z = false;
        if (view2 == null || view2 == this) {
            return false;
        }
        if (findContainingItemView(view2) == null) {
            return false;
        }
        if (view == null || findContainingItemView(view) == null) {
            return true;
        }
        this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
        this.mTempRect2.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        offsetDescendantRectToMyCoords(view2, this.mTempRect2);
        int i3 = this.mLayout.m4559t() == 1 ? -1 : 1;
        if ((this.mTempRect.left < this.mTempRect2.left || this.mTempRect.right <= this.mTempRect2.left) && this.mTempRect.right < this.mTempRect2.right) {
            i2 = 1;
        } else {
            i2 = ((this.mTempRect.right > this.mTempRect2.right || this.mTempRect.left >= this.mTempRect2.right) && this.mTempRect.left > this.mTempRect2.left) ? -1 : 0;
        }
        if ((this.mTempRect.top < this.mTempRect2.top || this.mTempRect.bottom <= this.mTempRect2.top) && this.mTempRect.bottom < this.mTempRect2.bottom) {
            b = 1;
        } else if ((this.mTempRect.bottom <= this.mTempRect2.bottom && this.mTempRect.top < this.mTempRect2.bottom) || this.mTempRect.top <= this.mTempRect2.top) {
            b = 0;
        }
        switch (i) {
            case 1:
                if (b < 0 || (b == 0 && i3 * i2 <= 0)) {
                    z = true;
                }
                return z;
            case 2:
                if (b > 0 || (b == 0 && i3 * i2 >= 0)) {
                    z = true;
                }
                return z;
            case 17:
                return i2 < 0;
            case 33:
                return b < 0;
            case 66:
                return i2 > 0;
            case 130:
                return b > 0;
            default:
                throw new IllegalArgumentException("Invalid direction: " + i + exceptionLabel());
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.mLayout.m4505a(this, this.mState, view, view2) && view2 != null) {
            requestChildOnScreen(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    private void requestChildOnScreen(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.f4097e) {
                Rect rect = layoutParams2.f4096d;
                this.mTempRect.left -= rect.left;
                this.mTempRect.right += rect.right;
                this.mTempRect.top -= rect.top;
                Rect rect2 = this.mTempRect;
                rect2.bottom = rect.bottom + rect2.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        this.mLayout.m4507a(this, view, this.mTempRect, !this.mFirstLayoutComplete, view2 == null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.mLayout.m4506a(this, view, rect, z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (this.mLayout == null || !this.mLayout.m4509a(this, arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006a  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onAttachedToWindow() {
        /*
            r4 = this;
            r0 = 1
            r1 = 0
            super.onAttachedToWindow()
            r4.mLayoutOrScrollCounter = r1
            r4.mIsAttached = r0
            boolean r2 = r4.mFirstLayoutComplete
            if (r2 == 0) goto L68
            boolean r2 = r4.isLayoutRequested()
            if (r2 != 0) goto L68
        L13:
            r4.mFirstLayoutComplete = r0
            android.support.v7.widget.RecyclerView$LayoutManager r0 = r4.mLayout
            if (r0 == 0) goto L1e
            android.support.v7.widget.RecyclerView$LayoutManager r0 = r4.mLayout
            r0.m4522c(r4)
        L1e:
            r4.mPostedAnimatorRunner = r1
            boolean r0 = android.support.v7.widget.RecyclerView.ALLOW_THREAD_GAP_WORK
            if (r0 == 0) goto L67
            java.lang.ThreadLocal<android.support.v7.widget.GapWorker> r0 = android.support.v7.widget.GapWorker.f3904a
            java.lang.Object r0 = r0.get()
            android.support.v7.widget.GapWorker r0 = (android.support.v7.widget.GapWorker) r0
            r4.mGapWorker = r0
            android.support.v7.widget.GapWorker r0 = r4.mGapWorker
            if (r0 != 0) goto L62
            android.support.v7.widget.GapWorker r0 = new android.support.v7.widget.GapWorker
            r0.<init>()
            r4.mGapWorker = r0
            android.view.Display r0 = android.support.v4.view.ViewCompat.m2572D(r4)
            r1 = 1114636288(0x42700000, float:60.0)
            boolean r2 = r4.isInEditMode()
            if (r2 != 0) goto L6a
            if (r0 == 0) goto L6a
            float r0 = r0.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 < 0) goto L6a
        L51:
            android.support.v7.widget.GapWorker r1 = r4.mGapWorker
            r2 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r0 = r2 / r0
            long r2 = (long) r0
            r1.f3908d = r2
            java.lang.ThreadLocal<android.support.v7.widget.GapWorker> r0 = android.support.v7.widget.GapWorker.f3904a
            android.support.v7.widget.GapWorker r1 = r4.mGapWorker
            r0.set(r1)
        L62:
            android.support.v7.widget.GapWorker r0 = r4.mGapWorker
            r0.m4179a(r4)
        L67:
            return
        L68:
            r0 = r1
            goto L13
        L6a:
            r0 = r1
            goto L51
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mItemAnimator != null) {
            this.mItemAnimator.mo4112d();
        }
        stopScroll();
        this.mIsAttached = false;
        if (this.mLayout != null) {
            this.mLayout.m4516b(this, this.mRecycler);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.m5016b();
        if (ALLOW_THREAD_GAP_WORK && this.mGapWorker != null) {
            this.mGapWorker.m4181b(this);
            this.mGapWorker = null;
        }
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    void assertInLayoutOrScroll(String str) {
        if (!isComputingLayout()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + exceptionLabel());
            }
            throw new IllegalStateException(str + exceptionLabel());
        }
    }

    void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + exceptionLabel());
            }
            throw new IllegalStateException(str);
        }
        if (this.mDispatchScrollCounter > 0) {
            Log.w(TAG, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + exceptionLabel()));
        }
    }

    public void addOnItemTouchListener(OnItemTouchListener onItemTouchListener) {
        this.mOnItemTouchListeners.add(onItemTouchListener);
    }

    public void removeOnItemTouchListener(OnItemTouchListener onItemTouchListener) {
        this.mOnItemTouchListeners.remove(onItemTouchListener);
        if (this.mActiveOnItemTouchListener == onItemTouchListener) {
            this.mActiveOnItemTouchListener = null;
        }
    }

    private boolean dispatchOnItemTouchIntercept(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.mActiveOnItemTouchListener = null;
        }
        int size = this.mOnItemTouchListeners.size();
        for (int i = 0; i < size; i++) {
            OnItemTouchListener onItemTouchListener = this.mOnItemTouchListeners.get(i);
            if (onItemTouchListener.mo4161a(this, motionEvent) && action != 3) {
                this.mActiveOnItemTouchListener = onItemTouchListener;
                return true;
            }
        }
        return false;
    }

    private boolean dispatchOnItemTouch(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mActiveOnItemTouchListener != null) {
            if (action == 0) {
                this.mActiveOnItemTouchListener = null;
            } else {
                this.mActiveOnItemTouchListener.mo4162b(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.mActiveOnItemTouchListener = null;
                }
                return true;
            }
        }
        if (action != 0) {
            int size = this.mOnItemTouchListeners.size();
            for (int i = 0; i < size; i++) {
                OnItemTouchListener onItemTouchListener = this.mOnItemTouchListeners.get(i);
                if (onItemTouchListener.mo4161a(this, motionEvent)) {
                    this.mActiveOnItemTouchListener = onItemTouchListener;
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.mLayoutFrozen) {
            return false;
        }
        if (dispatchOnItemTouchIntercept(motionEvent)) {
            cancelTouch();
            return true;
        }
        if (this.mLayout == null) {
            return false;
        }
        boolean zMo4313e = this.mLayout.mo4313e();
        boolean zMo4316f = this.mLayout.mo4316f();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        switch (actionMasked) {
            case 0:
                if (this.mIgnoreMotionEventTillDown) {
                    this.mIgnoreMotionEventTillDown = false;
                }
                this.mScrollPointerId = motionEvent.getPointerId(0);
                int x = (int) (motionEvent.getX() + 0.5f);
                this.mLastTouchX = x;
                this.mInitialTouchX = x;
                int y = (int) (motionEvent.getY() + 0.5f);
                this.mLastTouchY = y;
                this.mInitialTouchY = y;
                if (this.mScrollState == 2) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    setScrollState(1);
                }
                int[] iArr = this.mNestedOffsets;
                this.mNestedOffsets[1] = 0;
                iArr[0] = 0;
                int i = zMo4313e ? 1 : 0;
                if (zMo4316f) {
                    i |= 2;
                }
                startNestedScroll(i, 0);
                break;
            case 1:
                this.mVelocityTracker.clear();
                stopNestedScroll(0);
                break;
            case 2:
                int iFindPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
                if (iFindPointerIndex < 0) {
                    Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                    return false;
                }
                int x2 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
                int y2 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
                if (this.mScrollState != 1) {
                    int i2 = x2 - this.mInitialTouchX;
                    int i3 = y2 - this.mInitialTouchY;
                    if (!zMo4313e || Math.abs(i2) <= this.mTouchSlop) {
                        z = false;
                    } else {
                        this.mLastTouchX = x2;
                        z = true;
                    }
                    if (zMo4316f && Math.abs(i3) > this.mTouchSlop) {
                        this.mLastTouchY = y2;
                        z = true;
                    }
                    if (z) {
                        setScrollState(1);
                    }
                }
                break;
                break;
            case 3:
                cancelTouch();
                break;
            case 5:
                this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
                int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                this.mLastTouchX = x3;
                this.mInitialTouchX = x3;
                int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                this.mLastTouchY = y3;
                this.mInitialTouchY = y3;
                break;
            case 6:
                onPointerUp(motionEvent);
                break;
        }
        return this.mScrollState == 1;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.mOnItemTouchListeners.size();
        for (int i = 0; i < size; i++) {
            this.mOnItemTouchListeners.get(i).mo4159a(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int i;
        int i2;
        boolean z2 = false;
        if (this.mLayoutFrozen || this.mIgnoreMotionEventTillDown) {
            return false;
        }
        if (dispatchOnItemTouch(motionEvent)) {
            cancelTouch();
            return true;
        }
        if (this.mLayout == null) {
            return false;
        }
        boolean zMo4313e = this.mLayout.mo4313e();
        boolean zMo4316f = this.mLayout.mo4316f();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            int[] iArr = this.mNestedOffsets;
            this.mNestedOffsets[1] = 0;
            iArr[0] = 0;
        }
        motionEventObtain.offsetLocation(this.mNestedOffsets[0], this.mNestedOffsets[1]);
        switch (actionMasked) {
            case 0:
                this.mScrollPointerId = motionEvent.getPointerId(0);
                int x = (int) (motionEvent.getX() + 0.5f);
                this.mLastTouchX = x;
                this.mInitialTouchX = x;
                int y = (int) (motionEvent.getY() + 0.5f);
                this.mLastTouchY = y;
                this.mInitialTouchY = y;
                int i3 = zMo4313e ? 1 : 0;
                if (zMo4316f) {
                    i3 |= 2;
                }
                startNestedScroll(i3, 0);
                break;
            case 1:
                this.mVelocityTracker.addMovement(motionEventObtain);
                this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxFlingVelocity);
                float f = zMo4313e ? -this.mVelocityTracker.getXVelocity(this.mScrollPointerId) : 0.0f;
                float f2 = zMo4316f ? -this.mVelocityTracker.getYVelocity(this.mScrollPointerId) : 0.0f;
                if ((f == CropImageView.DEFAULT_ASPECT_RATIO && f2 == CropImageView.DEFAULT_ASPECT_RATIO) || !fling((int) f, (int) f2)) {
                    setScrollState(0);
                }
                resetTouch();
                z2 = true;
                break;
            case 2:
                int iFindPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
                if (iFindPointerIndex < 0) {
                    Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                    return false;
                }
                int x2 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
                int y2 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
                int i4 = this.mLastTouchX - x2;
                int i5 = this.mLastTouchY - y2;
                if (dispatchNestedPreScroll(i4, i5, this.mScrollConsumed, this.mScrollOffset, 0)) {
                    i4 -= this.mScrollConsumed[0];
                    i5 -= this.mScrollConsumed[1];
                    motionEventObtain.offsetLocation(this.mScrollOffset[0], this.mScrollOffset[1]);
                    int[] iArr2 = this.mNestedOffsets;
                    iArr2[0] = iArr2[0] + this.mScrollOffset[0];
                    int[] iArr3 = this.mNestedOffsets;
                    iArr3[1] = iArr3[1] + this.mScrollOffset[1];
                }
                if (this.mScrollState != 1) {
                    if (!zMo4313e || Math.abs(i4) <= this.mTouchSlop) {
                        z = false;
                    } else {
                        if (i4 > 0) {
                            i2 = i4 - this.mTouchSlop;
                        } else {
                            i2 = this.mTouchSlop + i4;
                        }
                        i4 = i2;
                        z = true;
                    }
                    if (zMo4316f && Math.abs(i5) > this.mTouchSlop) {
                        if (i5 > 0) {
                            i = i5 - this.mTouchSlop;
                        } else {
                            i = this.mTouchSlop + i5;
                        }
                        i5 = i;
                        z = true;
                    }
                    if (z) {
                        setScrollState(1);
                    }
                }
                if (this.mScrollState == 1) {
                    this.mLastTouchX = x2 - this.mScrollOffset[0];
                    this.mLastTouchY = y2 - this.mScrollOffset[1];
                    if (scrollByInternal(zMo4313e ? i4 : 0, zMo4316f ? i5 : 0, motionEventObtain)) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    if (this.mGapWorker != null && (i4 != 0 || i5 != 0)) {
                        this.mGapWorker.m4180a(this, i4, i5);
                    }
                }
                break;
                break;
            case 3:
                cancelTouch();
                break;
            case 5:
                this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
                int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                this.mLastTouchX = x3;
                this.mInitialTouchX = x3;
                int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                this.mLastTouchY = y3;
                this.mInitialTouchY = y3;
                break;
            case 6:
                onPointerUp(motionEvent);
                break;
        }
        if (!z2) {
            this.mVelocityTracker.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    private void resetTouch() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
        }
        stopNestedScroll(0);
        releaseGlows();
    }

    private void cancelTouch() {
        resetTouch();
        setScrollState(0);
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            int i = actionIndex == 0 ? 1 : 0;
            this.mScrollPointerId = motionEvent.getPointerId(i);
            int x = (int) (motionEvent.getX(i) + 0.5f);
            this.mLastTouchX = x;
            this.mInitialTouchX = x;
            int y = (int) (motionEvent.getY(i) + 0.5f);
            this.mLastTouchY = y;
            this.mInitialTouchY = y;
        }
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue;
        float f;
        if (this.mLayout != null && !this.mLayoutFrozen && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                float f2 = this.mLayout.mo4316f() ? -motionEvent.getAxisValue(9) : 0.0f;
                if (this.mLayout.mo4313e()) {
                    f = f2;
                    axisValue = motionEvent.getAxisValue(10);
                } else {
                    f = f2;
                    axisValue = 0.0f;
                }
            } else if ((motionEvent.getSource() & 4194304) != 0) {
                axisValue = motionEvent.getAxisValue(26);
                if (this.mLayout.mo4316f()) {
                    f = -axisValue;
                    axisValue = 0.0f;
                } else if (this.mLayout.mo4313e()) {
                    f = 0.0f;
                } else {
                    axisValue = 0.0f;
                    f = 0.0f;
                }
            } else {
                axisValue = 0.0f;
                f = 0.0f;
            }
            if (f != CropImageView.DEFAULT_ASPECT_RATIO || axisValue != CropImageView.DEFAULT_ASPECT_RATIO) {
                scrollByInternal((int) (axisValue * this.mScaledHorizontalScrollFactor), (int) (this.mScaledVerticalScrollFactor * f), motionEvent);
            }
        }
        return false;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        boolean z = false;
        if (this.mLayout == null) {
            defaultOnMeasure(i, i2);
            return;
        }
        if (this.mLayout.mo4307c()) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.mLayout.m4489a(this.mRecycler, this.mState, i, i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            if (!z && this.mAdapter != null) {
                if (this.mState.f4132c == 1) {
                    dispatchLayoutStep1();
                }
                this.mLayout.m4529d(i, i2);
                this.mState.f4137h = true;
                dispatchLayoutStep2();
                this.mLayout.m4532e(i, i2);
                if (this.mLayout.mo4324l()) {
                    this.mLayout.m4529d(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.mState.f4137h = true;
                    dispatchLayoutStep2();
                    this.mLayout.m4532e(i, i2);
                    return;
                }
                return;
            }
            return;
        }
        if (this.mHasFixedSize) {
            this.mLayout.m4489a(this.mRecycler, this.mState, i, i2);
            return;
        }
        if (this.mAdapterUpdateDuringMeasure) {
            startInterceptRequestLayout();
            onEnterLayoutOrScroll();
            processAdapterUpdatesAndSetAnimationFlags();
            onExitLayoutOrScroll();
            if (this.mState.f4139j) {
                this.mState.f4135f = true;
            } else {
                this.mAdapterHelper.m3822e();
                this.mState.f4135f = false;
            }
            this.mAdapterUpdateDuringMeasure = false;
            stopInterceptRequestLayout(false);
        } else if (this.mState.f4139j) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        if (this.mAdapter != null) {
            this.mState.f4133d = this.mAdapter.getItemCount();
        } else {
            this.mState.f4133d = 0;
        }
        startInterceptRequestLayout();
        this.mLayout.m4489a(this.mRecycler, this.mState, i, i2);
        stopInterceptRequestLayout(false);
        this.mState.f4135f = false;
    }

    void defaultOnMeasure(int i, int i2) {
        setMeasuredDimension(LayoutManager.m4463a(i, getPaddingLeft() + getPaddingRight(), ViewCompat.m2606j(this)), LayoutManager.m4463a(i2, getPaddingTop() + getPaddingBottom(), ViewCompat.m2607k(this)));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            invalidateGlows();
        }
    }

    public void setItemAnimator(ItemAnimator itemAnimator) {
        if (this.mItemAnimator != null) {
            this.mItemAnimator.mo4112d();
            this.mItemAnimator.m4439a((ItemAnimator.ItemAnimatorListener) null);
        }
        this.mItemAnimator = itemAnimator;
        if (this.mItemAnimator != null) {
            this.mItemAnimator.m4439a(this.mItemAnimatorListener);
        }
    }

    void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    void onExitLayoutOrScroll(boolean z) {
        this.mLayoutOrScrollCounter--;
        if (this.mLayoutOrScrollCounter < 1) {
            this.mLayoutOrScrollCounter = 0;
            if (z) {
                dispatchContentChangedIfNecessary();
                dispatchPendingImportantForAccessibilityChanges();
            }
        }
    }

    boolean isAccessibilityEnabled() {
        return this.mAccessibilityManager != null && this.mAccessibilityManager.isEnabled();
    }

    private void dispatchContentChangedIfNecessary() {
        int i = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (i != 0 && isAccessibilityEnabled()) {
            AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
            accessibilityEventObtain.setEventType(2048);
            AccessibilityEventCompat.m2777a(accessibilityEventObtain, i);
            sendAccessibilityEventUnchecked(accessibilityEventObtain);
        }
    }

    public boolean isComputingLayout() {
        return this.mLayoutOrScrollCounter > 0;
    }

    boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (!isComputingLayout()) {
            return false;
        }
        int iM2776a = accessibilityEvent != null ? AccessibilityEventCompat.m2776a(accessibilityEvent) : 0;
        this.mEatenAccessibilityChangeFlags = (iM2776a != 0 ? iM2776a : 0) | this.mEatenAccessibilityChangeFlags;
        return true;
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!shouldDeferAccessibilityEvent(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public ItemAnimator getItemAnimator() {
        return this.mItemAnimator;
    }

    void postAnimationRunner() {
        if (!this.mPostedAnimatorRunner && this.mIsAttached) {
            ViewCompat.m2586a(this, this.mItemAnimatorRunner);
            this.mPostedAnimatorRunner = true;
        }
    }

    private boolean predictiveItemAnimationsEnabled() {
        return this.mItemAnimator != null && this.mLayout.mo4228b();
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        if (this.mDataSetHasChangedAfterLayout) {
            this.mAdapterHelper.m3808a();
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.mo4219a(this);
            }
        }
        if (predictiveItemAnimationsEnabled()) {
            this.mAdapterHelper.m3816b();
        } else {
            this.mAdapterHelper.m3822e();
        }
        boolean z = this.mItemsAddedOrRemoved || this.mItemsChanged;
        this.mState.f4138i = this.mFirstLayoutComplete && this.mItemAnimator != null && (this.mDataSetHasChangedAfterLayout || z || this.mLayout.f4084u) && (!this.mDataSetHasChangedAfterLayout || this.mAdapter.hasStableIds());
        this.mState.f4139j = this.mState.f4138i && z && !this.mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled();
    }

    void dispatchLayout() {
        if (this.mAdapter == null) {
            Log.e(TAG, "No adapter attached; skipping layout");
            return;
        }
        if (this.mLayout == null) {
            Log.e(TAG, "No layout manager attached; skipping layout");
            return;
        }
        this.mState.f4137h = false;
        if (this.mState.f4132c == 1) {
            dispatchLayoutStep1();
            this.mLayout.m4537f(this);
            dispatchLayoutStep2();
        } else if (this.mAdapterHelper.m3823f() || this.mLayout.m4564y() != getWidth() || this.mLayout.m4565z() != getHeight()) {
            this.mLayout.m4537f(this);
            dispatchLayoutStep2();
        } else {
            this.mLayout.m4537f(this);
        }
        dispatchLayoutStep3();
    }

    private void saveFocusInfo() {
        int adapterPosition;
        View focusedChild = (this.mPreserveFocusAfterLayout && hasFocus() && this.mAdapter != null) ? getFocusedChild() : null;
        ViewHolder viewHolderFindContainingViewHolder = focusedChild == null ? null : findContainingViewHolder(focusedChild);
        if (viewHolderFindContainingViewHolder == null) {
            resetFocusInfo();
            return;
        }
        this.mState.f4141l = this.mAdapter.hasStableIds() ? viewHolderFindContainingViewHolder.getItemId() : -1L;
        State state = this.mState;
        if (this.mDataSetHasChangedAfterLayout) {
            adapterPosition = -1;
        } else {
            adapterPosition = viewHolderFindContainingViewHolder.isRemoved() ? viewHolderFindContainingViewHolder.mOldPosition : viewHolderFindContainingViewHolder.getAdapterPosition();
        }
        state.f4140k = adapterPosition;
        this.mState.f4142m = getDeepestFocusedViewWithId(viewHolderFindContainingViewHolder.itemView);
    }

    private void resetFocusInfo() {
        this.mState.f4141l = -1L;
        this.mState.f4140k = -1;
        this.mState.f4142m = -1;
    }

    private View findNextViewToFocus() {
        int i = this.mState.f4140k != -1 ? this.mState.f4140k : 0;
        int iM4662e = this.mState.m4662e();
        for (int i2 = i; i2 < iM4662e; i2++) {
            ViewHolder viewHolderFindViewHolderForAdapterPosition = findViewHolderForAdapterPosition(i2);
            if (viewHolderFindViewHolderForAdapterPosition == null) {
                break;
            }
            if (viewHolderFindViewHolderForAdapterPosition.itemView.hasFocusable()) {
                return viewHolderFindViewHolderForAdapterPosition.itemView;
            }
        }
        for (int iMin = Math.min(iM4662e, i) - 1; iMin >= 0; iMin--) {
            ViewHolder viewHolderFindViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(iMin);
            if (viewHolderFindViewHolderForAdapterPosition2 == null) {
                return null;
            }
            if (viewHolderFindViewHolderForAdapterPosition2.itemView.hasFocusable()) {
                return viewHolderFindViewHolderForAdapterPosition2.itemView;
            }
        }
        return null;
    }

    private void recoverFocusFromState() {
        View viewFindViewById;
        View viewFindNextViewToFocus = null;
        if (this.mPreserveFocusAfterLayout && this.mAdapter != null && hasFocus() && getDescendantFocusability() != 393216) {
            if (getDescendantFocusability() != 131072 || !isFocused()) {
                if (!isFocused()) {
                    View focusedChild = getFocusedChild();
                    if (IGNORE_DETACHED_FOCUSED_CHILD && (focusedChild.getParent() == null || !focusedChild.hasFocus())) {
                        if (this.mChildHelper.m4014b() == 0) {
                            requestFocus();
                            return;
                        }
                    } else if (!this.mChildHelper.m4019c(focusedChild)) {
                        return;
                    }
                }
                ViewHolder viewHolderFindViewHolderForItemId = (this.mState.f4141l == -1 || !this.mAdapter.hasStableIds()) ? null : findViewHolderForItemId(this.mState.f4141l);
                if (viewHolderFindViewHolderForItemId == null || this.mChildHelper.m4019c(viewHolderFindViewHolderForItemId.itemView) || !viewHolderFindViewHolderForItemId.itemView.hasFocusable()) {
                    if (this.mChildHelper.m4014b() > 0) {
                        viewFindNextViewToFocus = findNextViewToFocus();
                    }
                } else {
                    viewFindNextViewToFocus = viewHolderFindViewHolderForItemId.itemView;
                }
                if (viewFindNextViewToFocus != null) {
                    if (this.mState.f4142m == -1 || (viewFindViewById = viewFindNextViewToFocus.findViewById(this.mState.f4142m)) == null || !viewFindViewById.isFocusable()) {
                        viewFindViewById = viewFindNextViewToFocus;
                    }
                    viewFindViewById.requestFocus();
                }
            }
        }
    }

    private int getDeepestFocusedViewWithId(View view) {
        int i;
        int id = view.getId();
        while (true) {
            i = id;
            View view2 = view;
            if (view2.isFocused() || !(view2 instanceof ViewGroup) || !view2.hasFocus()) {
                break;
            }
            view = ((ViewGroup) view2).getFocusedChild();
            id = view.getId() != -1 ? view.getId() : i;
        }
        return i;
    }

    final void fillRemainingScrollValues(State state) {
        if (getScrollState() != 2) {
            state.f4143n = 0;
            state.f4144o = 0;
        } else {
            OverScroller overScroller = this.mViewFlinger.f4151e;
            state.f4143n = overScroller.getFinalX() - overScroller.getCurrX();
            state.f4144o = overScroller.getFinalY() - overScroller.getCurrY();
        }
    }

    private void dispatchLayoutStep1() {
        this.mState.m4656a(1);
        fillRemainingScrollValues(this.mState);
        this.mState.f4137h = false;
        startInterceptRequestLayout();
        this.mViewInfoStore.m5010a();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        this.mState.f4136g = this.mState.f4138i && this.mItemsChanged;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        this.mState.f4135f = this.mState.f4139j;
        this.mState.f4133d = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.f4138i) {
            int iM4014b = this.mChildHelper.m4014b();
            for (int i = 0; i < iM4014b; i++) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4016b(i));
                if (!childViewHolderInt.shouldIgnore() && (!childViewHolderInt.isInvalid() || this.mAdapter.hasStableIds())) {
                    this.mViewInfoStore.m5012a(childViewHolderInt, this.mItemAnimator.m4438a(this.mState, childViewHolderInt, ItemAnimator.m4436e(childViewHolderInt), childViewHolderInt.getUnmodifiedPayloads()));
                    if (this.mState.f4136g && childViewHolderInt.isUpdated() && !childViewHolderInt.isRemoved() && !childViewHolderInt.shouldIgnore() && !childViewHolderInt.isInvalid()) {
                        this.mViewInfoStore.m5011a(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.f4139j) {
            saveOldPositions();
            boolean z = this.mState.f4134e;
            this.mState.f4134e = false;
            this.mLayout.mo4229c(this.mRecycler, this.mState);
            this.mState.f4134e = z;
            for (int i2 = 0; i2 < this.mChildHelper.m4014b(); i2++) {
                ViewHolder childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.m4016b(i2));
                if (!childViewHolderInt2.shouldIgnore() && !this.mViewInfoStore.m5020d(childViewHolderInt2)) {
                    int iM4436e = ItemAnimator.m4436e(childViewHolderInt2);
                    boolean zHasAnyOfTheFlags = childViewHolderInt2.hasAnyOfTheFlags(Utility.DEFAULT_STREAM_BUFFER_SIZE);
                    if (!zHasAnyOfTheFlags) {
                        iM4436e |= 4096;
                    }
                    ItemAnimator.ItemHolderInfo itemHolderInfoM4438a = this.mItemAnimator.m4438a(this.mState, childViewHolderInt2, iM4436e, childViewHolderInt2.getUnmodifiedPayloads());
                    if (zHasAnyOfTheFlags) {
                        recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, itemHolderInfoM4438a);
                    } else {
                        this.mViewInfoStore.m5017b(childViewHolderInt2, itemHolderInfoM4438a);
                    }
                }
            }
            clearOldPositions();
        } else {
            clearOldPositions();
        }
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.f4132c = 2;
    }

    private void dispatchLayoutStep2() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.m4656a(6);
        this.mAdapterHelper.m3822e();
        this.mState.f4133d = this.mAdapter.getItemCount();
        this.mState.f4131b = 0;
        this.mState.f4135f = false;
        this.mLayout.mo4229c(this.mRecycler, this.mState);
        this.mState.f4134e = false;
        this.mPendingSavedState = null;
        this.mState.f4138i = this.mState.f4138i && this.mItemAnimator != null;
        this.mState.f4132c = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
    }

    private void dispatchLayoutStep3() {
        this.mState.m4656a(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.f4132c = 1;
        if (this.mState.f4138i) {
            for (int iM4014b = this.mChildHelper.m4014b() - 1; iM4014b >= 0; iM4014b--) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4016b(iM4014b));
                if (!childViewHolderInt.shouldIgnore()) {
                    long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                    ItemAnimator.ItemHolderInfo itemHolderInfoM4437a = this.mItemAnimator.m4437a(this.mState, childViewHolderInt);
                    ViewHolder viewHolderM5009a = this.mViewInfoStore.m5009a(changedHolderKey);
                    if (viewHolderM5009a != null && !viewHolderM5009a.shouldIgnore()) {
                        boolean zM5014a = this.mViewInfoStore.m5014a(viewHolderM5009a);
                        boolean zM5014a2 = this.mViewInfoStore.m5014a(childViewHolderInt);
                        if (zM5014a && viewHolderM5009a == childViewHolderInt) {
                            this.mViewInfoStore.m5019c(childViewHolderInt, itemHolderInfoM4437a);
                        } else {
                            ItemAnimator.ItemHolderInfo itemHolderInfoM5015b = this.mViewInfoStore.m5015b(viewHolderM5009a);
                            this.mViewInfoStore.m5019c(childViewHolderInt, itemHolderInfoM4437a);
                            ItemAnimator.ItemHolderInfo itemHolderInfoM5018c = this.mViewInfoStore.m5018c(childViewHolderInt);
                            if (itemHolderInfoM5015b == null) {
                                handleMissingPreInfoForChangeError(changedHolderKey, childViewHolderInt, viewHolderM5009a);
                            } else {
                                animateChange(viewHolderM5009a, childViewHolderInt, itemHolderInfoM5015b, itemHolderInfoM5018c, zM5014a, zM5014a2);
                            }
                        }
                    } else {
                        this.mViewInfoStore.m5019c(childViewHolderInt, itemHolderInfoM4437a);
                    }
                }
            }
            this.mViewInfoStore.m5013a(this.mViewInfoProcessCallback);
        }
        this.mLayout.m4514b(this.mRecycler);
        this.mState.f4130a = this.mState.f4133d;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mState.f4138i = false;
        this.mState.f4139j = false;
        this.mLayout.f4084u = false;
        if (this.mRecycler.f4106b != null) {
            this.mRecycler.f4106b.clear();
        }
        if (this.mLayout.f4088y) {
            this.mLayout.f4087x = 0;
            this.mLayout.f4088y = false;
            this.mRecycler.m4610b();
        }
        this.mLayout.mo4217a(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mViewInfoStore.m5010a();
        if (didChildRangeChange(this.mMinMaxLayoutPositions[0], this.mMinMaxLayoutPositions[1])) {
            dispatchOnScrolled(0, 0);
        }
        recoverFocusFromState();
        resetFocusInfo();
    }

    private void handleMissingPreInfoForChangeError(long j, ViewHolder viewHolder, ViewHolder viewHolder2) {
        int iM4014b = this.mChildHelper.m4014b();
        for (int i = 0; i < iM4014b; i++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4016b(i));
            if (childViewHolderInt != viewHolder && getChangedHolderKey(childViewHolderInt) == j) {
                if (this.mAdapter != null && this.mAdapter.hasStableIds()) {
                    throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + viewHolder + exceptionLabel());
                }
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + viewHolder + exceptionLabel());
            }
        }
        Log.e(TAG, "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + viewHolder2 + " cannot be found but it is necessary for " + viewHolder + exceptionLabel());
    }

    void recordAnimationInfoIfBouncedHiddenView(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo) {
        viewHolder.setFlags(0, Utility.DEFAULT_STREAM_BUFFER_SIZE);
        if (this.mState.f4136g && viewHolder.isUpdated() && !viewHolder.isRemoved() && !viewHolder.shouldIgnore()) {
            this.mViewInfoStore.m5011a(getChangedHolderKey(viewHolder), viewHolder);
        }
        this.mViewInfoStore.m5012a(viewHolder, itemHolderInfo);
    }

    private void findMinMaxChildLayoutPositions(int[] iArr) {
        int iM4014b = this.mChildHelper.m4014b();
        if (iM4014b == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        int i3 = 0;
        while (i3 < iM4014b) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4016b(i3));
            if (!childViewHolderInt.shouldIgnore()) {
                int layoutPosition = childViewHolderInt.getLayoutPosition();
                if (layoutPosition < i) {
                    i = layoutPosition;
                }
                if (layoutPosition > i2) {
                    i2 = layoutPosition;
                }
            }
            i3++;
            i = i;
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    private boolean didChildRangeChange(int i, int i2) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        return (this.mMinMaxLayoutPositions[0] == i && this.mMinMaxLayoutPositions[1] == i2) ? false : true;
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            } else if (!childViewHolderInt.shouldIgnore()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + childViewHolderInt + exceptionLabel());
            }
        }
        view.clearAnimation();
        dispatchChildDetached(view);
        super.removeDetachedView(view, z);
    }

    long getChangedHolderKey(ViewHolder viewHolder) {
        return this.mAdapter.hasStableIds() ? viewHolder.getItemId() : viewHolder.mPosition;
    }

    void animateAppearance(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        viewHolder.setIsRecyclable(false);
        if (this.mItemAnimator.mo4443b(viewHolder, itemHolderInfo, itemHolderInfo2)) {
            postAnimationRunner();
        }
    }

    void animateDisappearance(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        addAnimatingView(viewHolder);
        viewHolder.setIsRecyclable(false);
        if (this.mItemAnimator.mo4441a(viewHolder, itemHolderInfo, itemHolderInfo2)) {
            postAnimationRunner();
        }
    }

    private void animateChange(ViewHolder viewHolder, ViewHolder viewHolder2, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2, boolean z, boolean z2) {
        viewHolder.setIsRecyclable(false);
        if (z) {
            addAnimatingView(viewHolder);
        }
        if (viewHolder != viewHolder2) {
            if (z2) {
                addAnimatingView(viewHolder2);
            }
            viewHolder.mShadowedHolder = viewHolder2;
            addAnimatingView(viewHolder);
            this.mRecycler.m4617c(viewHolder);
            viewHolder2.setIsRecyclable(false);
            viewHolder2.mShadowingHolder = viewHolder;
        }
        if (this.mItemAnimator.mo4442a(viewHolder, viewHolder2, itemHolderInfo, itemHolderInfo2)) {
            postAnimationRunner();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        TraceCompat.m2325a(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        TraceCompat.m2324a();
        this.mFirstLayoutComplete = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth == 0 && !this.mLayoutFrozen) {
            super.requestLayout();
        } else {
            this.mLayoutWasDefered = true;
        }
    }

    void markItemDecorInsetsDirty() {
        int iM4017c = this.mChildHelper.m4017c();
        for (int i = 0; i < iM4017c; i++) {
            ((LayoutParams) this.mChildHelper.m4020d(i).getLayoutParams()).f4097e = true;
        }
        this.mRecycler.m4629j();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        boolean z2 = false;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        for (int i = 0; i < size; i++) {
            this.mItemDecorations.get(i).mo4157a(canvas, this, this.mState);
        }
        if (this.mLeftGlow == null || this.mLeftGlow.isFinished()) {
            z = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.mClipToPadding ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate(paddingBottom + (-getHeight()), CropImageView.DEFAULT_ASPECT_RATIO);
            z = this.mLeftGlow != null && this.mLeftGlow.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        if (this.mTopGlow != null && !this.mTopGlow.isFinished()) {
            int iSave2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            z |= this.mTopGlow != null && this.mTopGlow.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        if (this.mRightGlow != null && !this.mRightGlow.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.mClipToPadding ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            z |= this.mRightGlow != null && this.mRightGlow.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        if (this.mBottomGlow != null && !this.mBottomGlow.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            if (this.mBottomGlow != null && this.mBottomGlow.draw(canvas)) {
                z2 = true;
            }
            z |= z2;
            canvas.restoreToCount(iSave4);
        }
        if ((z || this.mItemAnimator == null || this.mItemDecorations.size() <= 0 || !this.mItemAnimator.mo4108b()) ? z : true) {
            ViewCompat.m2597c(this);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int i = 0; i < size; i++) {
            this.mItemDecorations.get(i).mo4462b(canvas, this, this.mState);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.mLayout.mo4224a((LayoutParams) layoutParams);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        if (this.mLayout == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
        }
        return this.mLayout.mo4206a();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.mLayout == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
        }
        return this.mLayout.mo4207a(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (this.mLayout == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
        }
        return this.mLayout.mo4208a(layoutParams);
    }

    public boolean isAnimating() {
        return this.mItemAnimator != null && this.mItemAnimator.mo4108b();
    }

    void saveOldPositions() {
        int iM4017c = this.mChildHelper.m4017c();
        for (int i = 0; i < iM4017c; i++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4020d(i));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.saveOldPosition();
            }
        }
    }

    void clearOldPositions() {
        int iM4017c = this.mChildHelper.m4017c();
        for (int i = 0; i < iM4017c; i++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4020d(i));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        this.mRecycler.m4628i();
    }

    void offsetPositionRecordsForMove(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int iM4017c = this.mChildHelper.m4017c();
        if (i < i2) {
            i3 = -1;
            i4 = i2;
            i5 = i;
        } else {
            i3 = 1;
            i4 = i;
            i5 = i2;
        }
        for (int i6 = 0; i6 < iM4017c; i6++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4020d(i6));
            if (childViewHolderInt != null && childViewHolderInt.mPosition >= i5 && childViewHolderInt.mPosition <= i4) {
                if (childViewHolderInt.mPosition == i) {
                    childViewHolderInt.offsetPosition(i2 - i, false);
                } else {
                    childViewHolderInt.offsetPosition(i3, false);
                }
                this.mState.f4134e = true;
            }
        }
        this.mRecycler.m4600a(i, i2);
        requestLayout();
    }

    void offsetPositionRecordsForInsert(int i, int i2) {
        int iM4017c = this.mChildHelper.m4017c();
        for (int i3 = 0; i3 < iM4017c; i3++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4020d(i3));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i) {
                childViewHolderInt.offsetPosition(i2, false);
                this.mState.f4134e = true;
            }
        }
        this.mRecycler.m4611b(i, i2);
        requestLayout();
    }

    void offsetPositionRecordsForRemove(int i, int i2, boolean z) {
        int i3 = i + i2;
        int iM4017c = this.mChildHelper.m4017c();
        for (int i4 = 0; i4 < iM4017c; i4++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4020d(i4));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                if (childViewHolderInt.mPosition >= i3) {
                    childViewHolderInt.offsetPosition(-i2, z);
                    this.mState.f4134e = true;
                } else if (childViewHolderInt.mPosition >= i) {
                    childViewHolderInt.flagRemovedAndOffsetPosition(i - 1, -i2, z);
                    this.mState.f4134e = true;
                }
            }
        }
        this.mRecycler.m4601a(i, i2, z);
        requestLayout();
    }

    void viewRangeUpdate(int i, int i2, Object obj) {
        int iM4017c = this.mChildHelper.m4017c();
        int i3 = i + i2;
        for (int i4 = 0; i4 < iM4017c; i4++) {
            View viewM4020d = this.mChildHelper.m4020d(i4);
            ViewHolder childViewHolderInt = getChildViewHolderInt(viewM4020d);
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i && childViewHolderInt.mPosition < i3) {
                childViewHolderInt.addFlags(2);
                childViewHolderInt.addChangePayload(obj);
                ((LayoutParams) viewM4020d.getLayoutParams()).f4097e = true;
            }
        }
        this.mRecycler.m4616c(i, i2);
    }

    boolean canReuseUpdatedViewHolder(ViewHolder viewHolder) {
        return this.mItemAnimator == null || this.mItemAnimator.mo4106a(viewHolder, viewHolder.getUnmodifiedPayloads());
    }

    void processDataSetCompletelyChanged(boolean z) {
        this.mDispatchItemsChangedEvent |= z;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    void markKnownViewsInvalid() {
        int iM4017c = this.mChildHelper.m4017c();
        for (int i = 0; i < iM4017c; i++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4020d(i));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        this.mRecycler.m4627h();
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() != 0) {
            if (this.mLayout != null) {
                this.mLayout.mo4298a("Cannot invalidate item decorations during a scroll or layout");
            }
            markItemDecorInsetsDirty();
            requestLayout();
        }
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.mPreserveFocusAfterLayout = z;
    }

    public ViewHolder getChildViewHolder(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && parent != this) {
            throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
        }
        return getChildViewHolderInt(view);
    }

    public View findContainingItemView(View view) {
        Object parent = view.getParent();
        View view2 = view;
        while (parent != null && parent != this && (parent instanceof View)) {
            View view3 = (View) parent;
            view2 = view3;
            parent = view3.getParent();
        }
        if (parent == this) {
            return view2;
        }
        return null;
    }

    public ViewHolder findContainingViewHolder(View view) {
        View viewFindContainingItemView = findContainingItemView(view);
        if (viewFindContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(viewFindContainingItemView);
    }

    static ViewHolder getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).f4095c;
    }

    @Deprecated
    public int getChildPosition(View view) {
        return getChildAdapterPosition(view);
    }

    public int getChildAdapterPosition(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getAdapterPosition();
        }
        return -1;
    }

    public int getChildLayoutPosition(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getLayoutPosition();
        }
        return -1;
    }

    public long getChildItemId(View view) {
        ViewHolder childViewHolderInt;
        if (this.mAdapter == null || !this.mAdapter.hasStableIds() || (childViewHolderInt = getChildViewHolderInt(view)) == null) {
            return -1L;
        }
        return childViewHolderInt.getItemId();
    }

    @Deprecated
    public ViewHolder findViewHolderForPosition(int i) {
        return findViewHolderForPosition(i, false);
    }

    public ViewHolder findViewHolderForLayoutPosition(int i) {
        return findViewHolderForPosition(i, false);
    }

    public ViewHolder findViewHolderForAdapterPosition(int i) {
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int iM4017c = this.mChildHelper.m4017c();
        int i2 = 0;
        ViewHolder viewHolder = null;
        while (i2 < iM4017c) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4020d(i2));
            if (childViewHolderInt == null || childViewHolderInt.isRemoved() || getAdapterPositionFor(childViewHolderInt) != i) {
                childViewHolderInt = viewHolder;
            } else if (!this.mChildHelper.m4019c(childViewHolderInt.itemView)) {
                return childViewHolderInt;
            }
            i2++;
            viewHolder = childViewHolderInt;
        }
        return viewHolder;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    android.support.v7.widget.RecyclerView.ViewHolder findViewHolderForPosition(int r6, boolean r7) {
        /*
            r5 = this;
            android.support.v7.widget.ChildHelper r0 = r5.mChildHelper
            int r3 = r0.m4017c()
            r1 = 0
            r0 = 0
            r2 = r0
            r0 = r1
        La:
            if (r2 >= r3) goto L3a
            android.support.v7.widget.ChildHelper r1 = r5.mChildHelper
            android.view.View r1 = r1.m4020d(r2)
            android.support.v7.widget.RecyclerView$ViewHolder r1 = getChildViewHolderInt(r1)
            if (r1 == 0) goto L24
            boolean r4 = r1.isRemoved()
            if (r4 != 0) goto L24
            if (r7 == 0) goto L28
            int r4 = r1.mPosition
            if (r4 == r6) goto L2e
        L24:
            int r1 = r2 + 1
            r2 = r1
            goto La
        L28:
            int r4 = r1.getLayoutPosition()
            if (r4 != r6) goto L24
        L2e:
            android.support.v7.widget.ChildHelper r0 = r5.mChildHelper
            android.view.View r4 = r1.itemView
            boolean r0 = r0.m4019c(r4)
            if (r0 == 0) goto L3b
            r0 = r1
            goto L24
        L3a:
            r1 = r0
        L3b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.findViewHolderForPosition(int, boolean):android.support.v7.widget.RecyclerView$ViewHolder");
    }

    public ViewHolder findViewHolderForItemId(long j) {
        if (this.mAdapter == null || !this.mAdapter.hasStableIds()) {
            return null;
        }
        int iM4017c = this.mChildHelper.m4017c();
        int i = 0;
        ViewHolder viewHolder = null;
        while (i < iM4017c) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m4020d(i));
            if (childViewHolderInt == null || childViewHolderInt.isRemoved() || childViewHolderInt.getItemId() != j) {
                childViewHolderInt = viewHolder;
            } else if (!this.mChildHelper.m4019c(childViewHolderInt.itemView)) {
                return childViewHolderInt;
            }
            i++;
            viewHolder = childViewHolderInt;
        }
        return viewHolder;
    }

    public View findChildViewUnder(float f, float f2) {
        for (int iM4014b = this.mChildHelper.m4014b() - 1; iM4014b >= 0; iM4014b--) {
            View viewM4016b = this.mChildHelper.m4016b(iM4014b);
            float translationX = viewM4016b.getTranslationX();
            float translationY = viewM4016b.getTranslationY();
            if (f >= viewM4016b.getLeft() + translationX && f <= translationX + viewM4016b.getRight() && f2 >= viewM4016b.getTop() + translationY && f2 <= viewM4016b.getBottom() + translationY) {
                return viewM4016b;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    public void offsetChildrenVertical(int i) {
        int iM4014b = this.mChildHelper.m4014b();
        for (int i2 = 0; i2 < iM4014b; i2++) {
            this.mChildHelper.m4016b(i2).offsetTopAndBottom(i);
        }
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    public void offsetChildrenHorizontal(int i) {
        int iM4014b = this.mChildHelper.m4014b();
        for (int i2 = 0; i2 < iM4014b; i2++) {
            this.mChildHelper.m4016b(i2).offsetLeftAndRight(i);
        }
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        getDecoratedBoundsWithMarginsInt(view, rect);
    }

    static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.f4096d;
        rect.set((view.getLeft() - rect2.left) - layoutParams.leftMargin, (view.getTop() - rect2.top) - layoutParams.topMargin, view.getRight() + rect2.right + layoutParams.rightMargin, layoutParams.bottomMargin + rect2.bottom + view.getBottom());
    }

    Rect getItemDecorInsetsForChild(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.f4097e) {
            return layoutParams.f4096d;
        }
        if (this.mState.m4658a() && (layoutParams.m4573e() || layoutParams.m4571c())) {
            return layoutParams.f4096d;
        }
        Rect rect = layoutParams.f4096d;
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int i = 0; i < size; i++) {
            this.mTempRect.set(0, 0, 0, 0);
            this.mItemDecorations.get(i).mo4460a(this.mTempRect, view, this, this.mState);
            rect.left += this.mTempRect.left;
            rect.top += this.mTempRect.top;
            rect.right += this.mTempRect.right;
            rect.bottom += this.mTempRect.bottom;
        }
        layoutParams.f4097e = false;
        return rect;
    }

    public void onScrolled(int i, int i2) {
    }

    void dispatchOnScrolled(int i, int i2) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        onScrolled(i, i2);
        if (this.mScrollListener != null) {
            this.mScrollListener.mo4164a(this, i, i2);
        }
        if (this.mScrollListeners != null) {
            for (int size = this.mScrollListeners.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).mo4164a(this, i, i2);
            }
        }
        this.mDispatchScrollCounter--;
    }

    public void onScrollStateChanged(int i) {
    }

    void dispatchOnScrollStateChanged(int i) {
        if (this.mLayout != null) {
            this.mLayout.mo4550l(i);
        }
        onScrollStateChanged(i);
        if (this.mScrollListener != null) {
            this.mScrollListener.m4578a(this, i);
        }
        if (this.mScrollListeners != null) {
            for (int size = this.mScrollListeners.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).m4578a(this, i);
            }
        }
    }

    public boolean hasPendingAdapterUpdates() {
        return !this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.m3821d();
    }

    class ViewFlinger implements Runnable {

        /* JADX INFO: renamed from: c */
        private int f4149c;

        /* JADX INFO: renamed from: d */
        private int f4150d;

        /* JADX INFO: renamed from: e */
        private OverScroller f4151e;

        /* JADX INFO: renamed from: a */
        Interpolator f4147a = RecyclerView.sQuinticInterpolator;

        /* JADX INFO: renamed from: f */
        private boolean f4152f = false;

        /* JADX INFO: renamed from: g */
        private boolean f4153g = false;

        ViewFlinger() {
            this.f4151e = new OverScroller(RecyclerView.this.getContext(), RecyclerView.sQuinticInterpolator);
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            int iMo4204a;
            int i9;
            int iMo4225b;
            if (RecyclerView.this.mLayout == null) {
                m4675b();
                return;
            }
            m4667c();
            RecyclerView.this.consumePendingUpdateOperations();
            OverScroller overScroller = this.f4151e;
            SmoothScroller smoothScroller = RecyclerView.this.mLayout.f4083t;
            if (overScroller.computeScrollOffset()) {
                int[] iArr = RecyclerView.this.mScrollConsumed;
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i10 = currX - this.f4149c;
                int i11 = currY - this.f4150d;
                this.f4149c = currX;
                this.f4150d = currY;
                if (RecyclerView.this.dispatchNestedPreScroll(i10, i11, iArr, null, 1)) {
                    int i12 = i10 - iArr[0];
                    i = i11 - iArr[1];
                    i2 = i12;
                } else {
                    i = i11;
                    i2 = i10;
                }
                if (RecyclerView.this.mAdapter == null) {
                    i3 = 0;
                    i4 = 0;
                    i5 = 0;
                    i6 = 0;
                } else {
                    RecyclerView.this.startInterceptRequestLayout();
                    RecyclerView.this.onEnterLayoutOrScroll();
                    TraceCompat.m2325a(RecyclerView.TRACE_SCROLL_TAG);
                    RecyclerView.this.fillRemainingScrollValues(RecyclerView.this.mState);
                    if (i2 == 0) {
                        i4 = 0;
                        iMo4204a = 0;
                    } else {
                        iMo4204a = RecyclerView.this.mLayout.mo4204a(i2, RecyclerView.this.mRecycler, RecyclerView.this.mState);
                        i4 = i2 - iMo4204a;
                    }
                    if (i == 0) {
                        i9 = 0;
                        iMo4225b = 0;
                    } else {
                        iMo4225b = RecyclerView.this.mLayout.mo4225b(i, RecyclerView.this.mRecycler, RecyclerView.this.mState);
                        i9 = i - iMo4225b;
                    }
                    TraceCompat.m2324a();
                    RecyclerView.this.repositionShadowingViews();
                    RecyclerView.this.onExitLayoutOrScroll();
                    RecyclerView.this.stopInterceptRequestLayout(false);
                    if (smoothScroller == null || smoothScroller.m4646g() || !smoothScroller.m4647h()) {
                        i3 = i9;
                        int i13 = iMo4225b;
                        i6 = iMo4204a;
                        i5 = i13;
                    } else {
                        int iM4662e = RecyclerView.this.mState.m4662e();
                        if (iM4662e == 0) {
                            smoothScroller.m4645f();
                            i3 = i9;
                            int i14 = iMo4225b;
                            i6 = iMo4204a;
                            i5 = i14;
                        } else if (smoothScroller.m4648i() >= iM4662e) {
                            smoothScroller.m4642d(iM4662e - 1);
                            smoothScroller.m4636a(i2 - i4, i - i9);
                            i3 = i9;
                            int i15 = iMo4225b;
                            i6 = iMo4204a;
                            i5 = i15;
                        } else {
                            smoothScroller.m4636a(i2 - i4, i - i9);
                            i3 = i9;
                            int i132 = iMo4225b;
                            i6 = iMo4204a;
                            i5 = i132;
                        }
                    }
                }
                if (!RecyclerView.this.mItemDecorations.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.considerReleasingGlowsOnScroll(i2, i);
                }
                if (!RecyclerView.this.dispatchNestedScroll(i6, i5, i4, i3, null, 1) && (i4 != 0 || i3 != 0)) {
                    int currVelocity = (int) overScroller.getCurrVelocity();
                    if (i4 == currX) {
                        i7 = 0;
                    } else {
                        if (i4 < 0) {
                            i8 = -currVelocity;
                        } else {
                            i8 = i4 > 0 ? currVelocity : 0;
                        }
                        i7 = i8;
                    }
                    if (i3 == currY) {
                        currVelocity = 0;
                    } else if (i3 < 0) {
                        currVelocity = -currVelocity;
                    } else if (i3 <= 0) {
                        currVelocity = 0;
                    }
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        RecyclerView.this.absorbGlows(i7, currVelocity);
                    }
                    if ((i7 != 0 || i4 == currX || overScroller.getFinalX() == 0) && (currVelocity != 0 || i3 == currY || overScroller.getFinalY() == 0)) {
                        overScroller.abortAnimation();
                    }
                }
                if (i6 != 0 || i5 != 0) {
                    RecyclerView.this.dispatchOnScrolled(i6, i5);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = (i2 == 0 && i == 0) || (i2 != 0 && RecyclerView.this.mLayout.mo4313e() && i6 == i2) || (i != 0 && RecyclerView.this.mLayout.mo4316f() && i5 == i);
                if (overScroller.isFinished() || (!z && !RecyclerView.this.hasNestedScrollingParent(1))) {
                    RecyclerView.this.setScrollState(0);
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                        RecyclerView.this.mPrefetchRegistry.m4183a();
                    }
                    RecyclerView.this.stopNestedScroll(1);
                } else {
                    m4669a();
                    if (RecyclerView.this.mGapWorker != null) {
                        RecyclerView.this.mGapWorker.m4180a(RecyclerView.this, i2, i);
                    }
                }
            }
            if (smoothScroller != null) {
                if (smoothScroller.m4646g()) {
                    smoothScroller.m4636a(0, 0);
                }
                if (!this.f4153g) {
                    smoothScroller.m4645f();
                }
            }
            m4668d();
        }

        /* JADX INFO: renamed from: c */
        private void m4667c() {
            this.f4153g = false;
            this.f4152f = true;
        }

        /* JADX INFO: renamed from: d */
        private void m4668d() {
            this.f4152f = false;
            if (this.f4153g) {
                m4669a();
            }
        }

        /* JADX INFO: renamed from: a */
        void m4669a() {
            if (this.f4152f) {
                this.f4153g = true;
            } else {
                RecyclerView.this.removeCallbacks(this);
                ViewCompat.m2586a(RecyclerView.this, this);
            }
        }

        /* JADX INFO: renamed from: a */
        public void m4670a(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.f4150d = 0;
            this.f4149c = 0;
            this.f4151e.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            m4669a();
        }

        /* JADX INFO: renamed from: b */
        public void m4676b(int i, int i2) {
            m4672a(i, i2, 0, 0);
        }

        /* JADX INFO: renamed from: a */
        public void m4672a(int i, int i2, int i3, int i4) {
            m4671a(i, i2, m4666b(i, i2, i3, i4));
        }

        /* JADX INFO: renamed from: a */
        private float m4664a(float f) {
            return (float) Math.sin((f - 0.5f) * 0.47123894f);
        }

        /* JADX INFO: renamed from: b */
        private int m4666b(int i, int i2, int i3, int i4) {
            int iRound;
            boolean z = Math.abs(i) > Math.abs(i2);
            int iSqrt = (int) Math.sqrt((i3 * i3) + (i4 * i4));
            int iSqrt2 = (int) Math.sqrt((i * i) + (i2 * i2));
            int width = z ? RecyclerView.this.getWidth() : RecyclerView.this.getHeight();
            int i5 = width / 2;
            float fM4664a = (m4664a(Math.min(1.0f, (iSqrt2 * 1.0f) / width)) * i5) + i5;
            if (iSqrt > 0) {
                iRound = Math.round(1000.0f * Math.abs(fM4664a / iSqrt)) * 4;
            } else {
                iRound = (int) ((((z ? r2 : r3) / width) + 1.0f) * 300.0f);
            }
            return Math.min(iRound, RecyclerView.MAX_SCROLL_DURATION);
        }

        /* JADX INFO: renamed from: a */
        public void m4671a(int i, int i2, int i3) {
            m4673a(i, i2, i3, RecyclerView.sQuinticInterpolator);
        }

        /* JADX INFO: renamed from: a */
        public void m4674a(int i, int i2, Interpolator interpolator) {
            int iM4666b = m4666b(i, i2, 0, 0);
            if (interpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            m4673a(i, i2, iM4666b, interpolator);
        }

        /* JADX INFO: renamed from: a */
        public void m4673a(int i, int i2, int i3, Interpolator interpolator) {
            if (this.f4147a != interpolator) {
                this.f4147a = interpolator;
                this.f4151e = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.f4150d = 0;
            this.f4149c = 0;
            this.f4151e.startScroll(0, 0, i, i2, i3);
            if (Build.VERSION.SDK_INT < 23) {
                this.f4151e.computeScrollOffset();
            }
            m4669a();
        }

        /* JADX INFO: renamed from: b */
        public void m4675b() {
            RecyclerView.this.removeCallbacks(this);
            this.f4151e.abortAnimation();
        }
    }

    void repositionShadowingViews() {
        int iM4014b = this.mChildHelper.m4014b();
        for (int i = 0; i < iM4014b; i++) {
            View viewM4016b = this.mChildHelper.m4016b(i);
            ViewHolder childViewHolder = getChildViewHolder(viewM4016b);
            if (childViewHolder != null && childViewHolder.mShadowingHolder != null) {
                View view = childViewHolder.mShadowingHolder.itemView;
                int left = viewM4016b.getLeft();
                int top = viewM4016b.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    private class RecyclerViewDataObserver extends AdapterDataObserver {
        RecyclerViewDataObserver() {
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        /* JADX INFO: renamed from: a */
        public void mo4428a() {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            RecyclerView.this.mState.f4134e = true;
            RecyclerView.this.processDataSetCompletelyChanged(true);
            if (!RecyclerView.this.mAdapterHelper.m3821d()) {
                RecyclerView.this.requestLayout();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        /* JADX INFO: renamed from: a */
        public void mo4431a(int i, int i2, Object obj) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.m3814a(i, i2, obj)) {
                m4631b();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        /* JADX INFO: renamed from: b */
        public void mo4432b(int i, int i2) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.m3817b(i, i2)) {
                m4631b();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        /* JADX INFO: renamed from: c */
        public void mo4433c(int i, int i2) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.m3820c(i, i2)) {
                m4631b();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        /* JADX INFO: renamed from: a */
        public void mo4430a(int i, int i2, int i3) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.m3813a(i, i2, i3)) {
                m4631b();
            }
        }

        /* JADX INFO: renamed from: b */
        void m4631b() {
            if (RecyclerView.POST_UPDATES_ON_ANIMATION && RecyclerView.this.mHasFixedSize && RecyclerView.this.mIsAttached) {
                ViewCompat.m2586a(RecyclerView.this, RecyclerView.this.mUpdateChildViewsRunnable);
            } else {
                RecyclerView.this.mAdapterUpdateDuringMeasure = true;
                RecyclerView.this.requestLayout();
            }
        }
    }

    public static class EdgeEffectFactory {
        /* JADX INFO: renamed from: a */
        protected EdgeEffect m4435a(RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static class RecycledViewPool {

        /* JADX INFO: renamed from: a */
        SparseArray<ScrapData> f4099a = new SparseArray<>();

        /* JADX INFO: renamed from: b */
        private int f4100b = 0;

        static class ScrapData {

            /* JADX INFO: renamed from: a */
            final ArrayList<ViewHolder> f4101a = new ArrayList<>();

            /* JADX INFO: renamed from: b */
            int f4102b = 5;

            /* JADX INFO: renamed from: c */
            long f4103c = 0;

            /* JADX INFO: renamed from: d */
            long f4104d = 0;

            ScrapData() {
            }
        }

        /* JADX INFO: renamed from: a */
        public void m4582a() {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f4099a.size()) {
                    this.f4099a.valueAt(i2).f4101a.clear();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        /* JADX INFO: renamed from: a */
        public ViewHolder m4581a(int i) {
            ScrapData scrapData = this.f4099a.get(i);
            if (scrapData == null || scrapData.f4101a.isEmpty()) {
                return null;
            }
            return scrapData.f4101a.remove(r0.size() - 1);
        }

        /* JADX INFO: renamed from: a */
        public void m4586a(ViewHolder viewHolder) {
            int itemViewType = viewHolder.getItemViewType();
            ArrayList<ViewHolder> arrayList = m4579b(itemViewType).f4101a;
            if (this.f4099a.get(itemViewType).f4102b > arrayList.size()) {
                viewHolder.resetInternal();
                arrayList.add(viewHolder);
            }
        }

        /* JADX INFO: renamed from: a */
        long m4580a(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        /* JADX INFO: renamed from: a */
        void m4583a(int i, long j) {
            ScrapData scrapDataM4579b = m4579b(i);
            scrapDataM4579b.f4103c = m4580a(scrapDataM4579b.f4103c, j);
        }

        /* JADX INFO: renamed from: b */
        void m4589b(int i, long j) {
            ScrapData scrapDataM4579b = m4579b(i);
            scrapDataM4579b.f4104d = m4580a(scrapDataM4579b.f4104d, j);
        }

        /* JADX INFO: renamed from: a */
        boolean m4587a(int i, long j, long j2) {
            long j3 = m4579b(i).f4103c;
            return j3 == 0 || j3 + j < j2;
        }

        /* JADX INFO: renamed from: b */
        boolean m4590b(int i, long j, long j2) {
            long j3 = m4579b(i).f4104d;
            return j3 == 0 || j3 + j < j2;
        }

        /* JADX INFO: renamed from: a */
        void m4584a(Adapter adapter) {
            this.f4100b++;
        }

        /* JADX INFO: renamed from: b */
        void m4588b() {
            this.f4100b--;
        }

        /* JADX INFO: renamed from: a */
        void m4585a(Adapter adapter, Adapter adapter2, boolean z) {
            if (adapter != null) {
                m4588b();
            }
            if (!z && this.f4100b == 0) {
                m4582a();
            }
            if (adapter2 != null) {
                m4584a(adapter2);
            }
        }

        /* JADX INFO: renamed from: b */
        private ScrapData m4579b(int i) {
            ScrapData scrapData = this.f4099a.get(i);
            if (scrapData == null) {
                ScrapData scrapData2 = new ScrapData();
                this.f4099a.put(i, scrapData2);
                return scrapData2;
            }
            return scrapData;
        }
    }

    static RecyclerView findNestedRecyclerView(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView recyclerViewFindNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i));
            if (recyclerViewFindNestedRecyclerView != null) {
                return recyclerViewFindNestedRecyclerView;
            }
        }
        return null;
    }

    static void clearNestedRecyclerViewIfNotNested(ViewHolder viewHolder) {
        if (viewHolder.mNestedRecyclerView != null) {
            RecyclerView recyclerView = viewHolder.mNestedRecyclerView.get();
            while (recyclerView != null) {
                if (recyclerView != viewHolder.itemView) {
                    Object parent = recyclerView.getParent();
                    recyclerView = parent instanceof View ? (View) parent : null;
                } else {
                    return;
                }
            }
            viewHolder.mNestedRecyclerView = null;
        }
    }

    long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK) {
            return System.nanoTime();
        }
        return 0L;
    }

    public final class Recycler {

        /* JADX INFO: renamed from: e */
        RecycledViewPool f4109e;

        /* JADX INFO: renamed from: i */
        private ViewCacheExtension f4113i;

        /* JADX INFO: renamed from: a */
        final ArrayList<ViewHolder> f4105a = new ArrayList<>();

        /* JADX INFO: renamed from: b */
        ArrayList<ViewHolder> f4106b = null;

        /* JADX INFO: renamed from: c */
        final ArrayList<ViewHolder> f4107c = new ArrayList<>();

        /* JADX INFO: renamed from: g */
        private final List<ViewHolder> f4111g = Collections.unmodifiableList(this.f4105a);

        /* JADX INFO: renamed from: h */
        private int f4112h = 2;

        /* JADX INFO: renamed from: d */
        int f4108d = 2;

        public Recycler() {
        }

        /* JADX INFO: renamed from: a */
        public void m4598a() {
            this.f4105a.clear();
            m4619d();
        }

        /* JADX INFO: renamed from: a */
        public void m4599a(int i) {
            this.f4112h = i;
            m4610b();
        }

        /* JADX INFO: renamed from: b */
        void m4610b() {
            this.f4108d = (RecyclerView.this.mLayout != null ? RecyclerView.this.mLayout.f4087x : 0) + this.f4112h;
            for (int size = this.f4107c.size() - 1; size >= 0 && this.f4107c.size() > this.f4108d; size--) {
                m4620d(size);
            }
        }

        /* JADX INFO: renamed from: c */
        public List<ViewHolder> m4615c() {
            return this.f4111g;
        }

        /* JADX INFO: renamed from: a */
        boolean m4607a(ViewHolder viewHolder) {
            if (viewHolder.isRemoved()) {
                return RecyclerView.this.mState.m4658a();
            }
            if (viewHolder.mPosition < 0 || viewHolder.mPosition >= RecyclerView.this.mAdapter.getItemCount()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + viewHolder + RecyclerView.this.exceptionLabel());
            }
            if (RecyclerView.this.mState.m4658a() || RecyclerView.this.mAdapter.getItemViewType(viewHolder.mPosition) == viewHolder.getItemViewType()) {
                return !RecyclerView.this.mAdapter.hasStableIds() || viewHolder.getItemId() == RecyclerView.this.mAdapter.getItemId(viewHolder.mPosition);
            }
            return false;
        }

        /* JADX INFO: renamed from: a */
        private boolean m4592a(ViewHolder viewHolder, int i, int i2, long j) {
            viewHolder.mOwnerRecyclerView = RecyclerView.this;
            int itemViewType = viewHolder.getItemViewType();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j != RecyclerView.FOREVER_NS && !this.f4109e.m4590b(itemViewType, nanoTime, j)) {
                return false;
            }
            RecyclerView.this.mAdapter.bindViewHolder(viewHolder, i);
            this.f4109e.m4589b(viewHolder.getItemViewType(), RecyclerView.this.getNanoTime() - nanoTime);
            m4593e(viewHolder);
            if (RecyclerView.this.mState.m4658a()) {
                viewHolder.mPreLayoutPosition = i2;
            }
            return true;
        }

        /* JADX INFO: renamed from: b */
        public int m4608b(int i) {
            if (i < 0 || i >= RecyclerView.this.mState.m4662e()) {
                throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + RecyclerView.this.mState.m4662e() + RecyclerView.this.exceptionLabel());
            }
            return !RecyclerView.this.mState.m4658a() ? i : RecyclerView.this.mAdapterHelper.m3815b(i);
        }

        /* JADX INFO: renamed from: c */
        public View m4614c(int i) {
            return m4597a(i, false);
        }

        /* JADX INFO: renamed from: a */
        View m4597a(int i, boolean z) {
            return m4595a(i, z, RecyclerView.FOREVER_NS).itemView;
        }

        /* JADX INFO: renamed from: a */
        ViewHolder m4595a(int i, boolean z, long j) {
            ViewHolder viewHolderCreateViewHolder;
            boolean z2;
            ViewHolder viewHolder;
            boolean z3;
            boolean zM4592a;
            LayoutParams layoutParams;
            boolean z4;
            RecyclerView recyclerViewFindNestedRecyclerView;
            View viewM4663a;
            if (i < 0 || i >= RecyclerView.this.mState.m4662e()) {
                throw new IndexOutOfBoundsException("Invalid item position " + i + "(" + i + "). Item count:" + RecyclerView.this.mState.m4662e() + RecyclerView.this.exceptionLabel());
            }
            if (RecyclerView.this.mState.m4658a()) {
                ViewHolder viewHolderM4624f = m4624f(i);
                z2 = viewHolderM4624f != null;
                viewHolderCreateViewHolder = viewHolderM4624f;
            } else {
                viewHolderCreateViewHolder = null;
                z2 = false;
            }
            if (viewHolderCreateViewHolder == null && (viewHolderCreateViewHolder = m4609b(i, z)) != null) {
                if (m4607a(viewHolderCreateViewHolder)) {
                    z2 = true;
                } else {
                    if (!z) {
                        viewHolderCreateViewHolder.addFlags(4);
                        if (viewHolderCreateViewHolder.isScrap()) {
                            RecyclerView.this.removeDetachedView(viewHolderCreateViewHolder.itemView, false);
                            viewHolderCreateViewHolder.unScrap();
                        } else if (viewHolderCreateViewHolder.wasReturnedFromScrap()) {
                            viewHolderCreateViewHolder.clearReturnedFromScrapFlag();
                        }
                        m4612b(viewHolderCreateViewHolder);
                    }
                    viewHolderCreateViewHolder = null;
                }
            }
            if (viewHolderCreateViewHolder == null) {
                int iM3815b = RecyclerView.this.mAdapterHelper.m3815b(i);
                if (iM3815b < 0 || iM3815b >= RecyclerView.this.mAdapter.getItemCount()) {
                    throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + iM3815b + ").state:" + RecyclerView.this.mState.m4662e() + RecyclerView.this.exceptionLabel());
                }
                int itemViewType = RecyclerView.this.mAdapter.getItemViewType(iM3815b);
                if (!RecyclerView.this.mAdapter.hasStableIds() || (viewHolderCreateViewHolder = m4596a(RecyclerView.this.mAdapter.getItemId(iM3815b), itemViewType, z)) == null) {
                    z4 = z2;
                } else {
                    viewHolderCreateViewHolder.mPosition = iM3815b;
                    z4 = true;
                }
                if (viewHolderCreateViewHolder == null && this.f4113i != null && (viewM4663a = this.f4113i.m4663a(this, i, itemViewType)) != null) {
                    viewHolderCreateViewHolder = RecyclerView.this.getChildViewHolder(viewM4663a);
                    if (viewHolderCreateViewHolder == null) {
                        throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder" + RecyclerView.this.exceptionLabel());
                    }
                    if (viewHolderCreateViewHolder.shouldIgnore()) {
                        throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view." + RecyclerView.this.exceptionLabel());
                    }
                }
                if (viewHolderCreateViewHolder == null && (viewHolderCreateViewHolder = m4626g().m4581a(itemViewType)) != null) {
                    viewHolderCreateViewHolder.resetInternal();
                    if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST) {
                        m4594f(viewHolderCreateViewHolder);
                    }
                }
                if (viewHolderCreateViewHolder == null) {
                    long nanoTime = RecyclerView.this.getNanoTime();
                    if (j != RecyclerView.FOREVER_NS && !this.f4109e.m4587a(itemViewType, nanoTime, j)) {
                        return null;
                    }
                    viewHolderCreateViewHolder = RecyclerView.this.mAdapter.createViewHolder(RecyclerView.this, itemViewType);
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK && (recyclerViewFindNestedRecyclerView = RecyclerView.findNestedRecyclerView(viewHolderCreateViewHolder.itemView)) != null) {
                        viewHolderCreateViewHolder.mNestedRecyclerView = new WeakReference<>(recyclerViewFindNestedRecyclerView);
                    }
                    this.f4109e.m4583a(itemViewType, RecyclerView.this.getNanoTime() - nanoTime);
                }
                viewHolder = viewHolderCreateViewHolder;
                z3 = z4;
            } else {
                viewHolder = viewHolderCreateViewHolder;
                z3 = z2;
            }
            if (z3 && !RecyclerView.this.mState.m4658a() && viewHolder.hasAnyOfTheFlags(Utility.DEFAULT_STREAM_BUFFER_SIZE)) {
                viewHolder.setFlags(0, Utility.DEFAULT_STREAM_BUFFER_SIZE);
                if (RecyclerView.this.mState.f4138i) {
                    RecyclerView.this.recordAnimationInfoIfBouncedHiddenView(viewHolder, RecyclerView.this.mItemAnimator.m4438a(RecyclerView.this.mState, viewHolder, ItemAnimator.m4436e(viewHolder) | 4096, viewHolder.getUnmodifiedPayloads()));
                }
            }
            if (RecyclerView.this.mState.m4658a() && viewHolder.isBound()) {
                viewHolder.mPreLayoutPosition = i;
                zM4592a = false;
            } else {
                zM4592a = (!viewHolder.isBound() || viewHolder.needsUpdate() || viewHolder.isInvalid()) ? m4592a(viewHolder, RecyclerView.this.mAdapterHelper.m3815b(i), i, j) : false;
            }
            ViewGroup.LayoutParams layoutParams2 = viewHolder.itemView.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams = (LayoutParams) RecyclerView.this.generateDefaultLayoutParams();
                viewHolder.itemView.setLayoutParams(layoutParams);
            } else if (!RecyclerView.this.checkLayoutParams(layoutParams2)) {
                layoutParams = (LayoutParams) RecyclerView.this.generateLayoutParams(layoutParams2);
                viewHolder.itemView.setLayoutParams(layoutParams);
            } else {
                layoutParams = (LayoutParams) layoutParams2;
            }
            layoutParams.f4095c = viewHolder;
            layoutParams.f4098f = z3 && zM4592a;
            return viewHolder;
        }

        /* JADX INFO: renamed from: e */
        private void m4593e(ViewHolder viewHolder) {
            if (RecyclerView.this.isAccessibilityEnabled()) {
                View view = viewHolder.itemView;
                if (ViewCompat.m2599d(view) == 0) {
                    ViewCompat.m2575a(view, 1);
                }
                if (!ViewCompat.m2590a(view)) {
                    viewHolder.addFlags(16384);
                    ViewCompat.m2583a(view, RecyclerView.this.mAccessibilityDelegate.m4678c());
                }
            }
        }

        /* JADX INFO: renamed from: f */
        private void m4594f(ViewHolder viewHolder) {
            if (viewHolder.itemView instanceof ViewGroup) {
                m4591a((ViewGroup) viewHolder.itemView, false);
            }
        }

        /* JADX INFO: renamed from: a */
        private void m4591a(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    m4591a((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        /* JADX INFO: renamed from: a */
        public void m4606a(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.unScrap();
            } else if (childViewHolderInt.wasReturnedFromScrap()) {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            m4612b(childViewHolderInt);
        }

        /* JADX INFO: renamed from: d */
        void m4619d() {
            for (int size = this.f4107c.size() - 1; size >= 0; size--) {
                m4620d(size);
            }
            this.f4107c.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                RecyclerView.this.mPrefetchRegistry.m4183a();
            }
        }

        /* JADX INFO: renamed from: d */
        void m4620d(int i) {
            m4605a(this.f4107c.get(i), true);
            this.f4107c.remove(i);
        }

        /* JADX INFO: renamed from: b */
        void m4612b(ViewHolder viewHolder) {
            boolean z;
            boolean z2 = false;
            if (viewHolder.isScrap() || viewHolder.itemView.getParent() != null) {
                throw new IllegalArgumentException("Scrapped or attached views may not be recycled. isScrap:" + viewHolder.isScrap() + " isAttached:" + (viewHolder.itemView.getParent() != null) + RecyclerView.this.exceptionLabel());
            }
            if (viewHolder.isTmpDetached()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + viewHolder + RecyclerView.this.exceptionLabel());
            }
            if (viewHolder.shouldIgnore()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.exceptionLabel());
            }
            boolean zDoesTransientStatePreventRecycling = viewHolder.doesTransientStatePreventRecycling();
            if ((RecyclerView.this.mAdapter != null && zDoesTransientStatePreventRecycling && RecyclerView.this.mAdapter.onFailedToRecycleView(viewHolder)) || viewHolder.isRecyclable()) {
                if (this.f4108d <= 0 || viewHolder.hasAnyOfTheFlags(526)) {
                    z = false;
                } else {
                    int size = this.f4107c.size();
                    if (size >= this.f4108d && size > 0) {
                        m4620d(0);
                        size--;
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK && size > 0 && !RecyclerView.this.mPrefetchRegistry.m4186a(viewHolder.mPosition)) {
                        int i = size - 1;
                        while (i >= 0) {
                            if (!RecyclerView.this.mPrefetchRegistry.m4186a(this.f4107c.get(i).mPosition)) {
                                break;
                            } else {
                                i--;
                            }
                        }
                        size = i + 1;
                    }
                    this.f4107c.add(size, viewHolder);
                    z = true;
                }
                if (!z) {
                    m4605a(viewHolder, true);
                    z2 = true;
                }
            } else {
                z = false;
            }
            RecyclerView.this.mViewInfoStore.m5023g(viewHolder);
            if (!z && !z2 && zDoesTransientStatePreventRecycling) {
                viewHolder.mOwnerRecyclerView = null;
            }
        }

        /* JADX INFO: renamed from: a */
        void m4605a(ViewHolder viewHolder, boolean z) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(viewHolder);
            if (viewHolder.hasAnyOfTheFlags(16384)) {
                viewHolder.setFlags(0, 16384);
                ViewCompat.m2583a(viewHolder.itemView, (AccessibilityDelegateCompat) null);
            }
            if (z) {
                m4621d(viewHolder);
            }
            viewHolder.mOwnerRecyclerView = null;
            m4626g().m4586a(viewHolder);
        }

        /* JADX INFO: renamed from: b */
        void m4613b(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.mScrapContainer = null;
            childViewHolderInt.mInChangeScrap = false;
            childViewHolderInt.clearReturnedFromScrapFlag();
            m4612b(childViewHolderInt);
        }

        /* JADX INFO: renamed from: c */
        void m4618c(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.hasAnyOfTheFlags(12) || !childViewHolderInt.isUpdated() || RecyclerView.this.canReuseUpdatedViewHolder(childViewHolderInt)) {
                if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !RecyclerView.this.mAdapter.hasStableIds()) {
                    throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.exceptionLabel());
                }
                childViewHolderInt.setScrapContainer(this, false);
                this.f4105a.add(childViewHolderInt);
                return;
            }
            if (this.f4106b == null) {
                this.f4106b = new ArrayList<>();
            }
            childViewHolderInt.setScrapContainer(this, true);
            this.f4106b.add(childViewHolderInt);
        }

        /* JADX INFO: renamed from: c */
        void m4617c(ViewHolder viewHolder) {
            if (viewHolder.mInChangeScrap) {
                this.f4106b.remove(viewHolder);
            } else {
                this.f4105a.remove(viewHolder);
            }
            viewHolder.mScrapContainer = null;
            viewHolder.mInChangeScrap = false;
            viewHolder.clearReturnedFromScrapFlag();
        }

        /* JADX INFO: renamed from: e */
        int m4622e() {
            return this.f4105a.size();
        }

        /* JADX INFO: renamed from: e */
        View m4623e(int i) {
            return this.f4105a.get(i).itemView;
        }

        /* JADX INFO: renamed from: f */
        void m4625f() {
            this.f4105a.clear();
            if (this.f4106b != null) {
                this.f4106b.clear();
            }
        }

        /* JADX INFO: renamed from: f */
        ViewHolder m4624f(int i) {
            int size;
            int iM3815b;
            if (this.f4106b == null || (size = this.f4106b.size()) == 0) {
                return null;
            }
            for (int i2 = 0; i2 < size; i2++) {
                ViewHolder viewHolder = this.f4106b.get(i2);
                if (!viewHolder.wasReturnedFromScrap() && viewHolder.getLayoutPosition() == i) {
                    viewHolder.addFlags(32);
                    return viewHolder;
                }
            }
            if (RecyclerView.this.mAdapter.hasStableIds() && (iM3815b = RecyclerView.this.mAdapterHelper.m3815b(i)) > 0 && iM3815b < RecyclerView.this.mAdapter.getItemCount()) {
                long itemId = RecyclerView.this.mAdapter.getItemId(iM3815b);
                for (int i3 = 0; i3 < size; i3++) {
                    ViewHolder viewHolder2 = this.f4106b.get(i3);
                    if (!viewHolder2.wasReturnedFromScrap() && viewHolder2.getItemId() == itemId) {
                        viewHolder2.addFlags(32);
                        return viewHolder2;
                    }
                }
            }
            return null;
        }

        /* JADX INFO: renamed from: b */
        ViewHolder m4609b(int i, boolean z) {
            View viewM4018c;
            int size = this.f4105a.size();
            for (int i2 = 0; i2 < size; i2++) {
                ViewHolder viewHolder = this.f4105a.get(i2);
                if (!viewHolder.wasReturnedFromScrap() && viewHolder.getLayoutPosition() == i && !viewHolder.isInvalid() && (RecyclerView.this.mState.f4135f || !viewHolder.isRemoved())) {
                    viewHolder.addFlags(32);
                    return viewHolder;
                }
            }
            if (!z && (viewM4018c = RecyclerView.this.mChildHelper.m4018c(i)) != null) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(viewM4018c);
                RecyclerView.this.mChildHelper.m4023e(viewM4018c);
                int iM4015b = RecyclerView.this.mChildHelper.m4015b(viewM4018c);
                if (iM4015b == -1) {
                    throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + childViewHolderInt + RecyclerView.this.exceptionLabel());
                }
                RecyclerView.this.mChildHelper.m4022e(iM4015b);
                m4618c(viewM4018c);
                childViewHolderInt.addFlags(8224);
                return childViewHolderInt;
            }
            int size2 = this.f4107c.size();
            for (int i3 = 0; i3 < size2; i3++) {
                ViewHolder viewHolder2 = this.f4107c.get(i3);
                if (!viewHolder2.isInvalid() && viewHolder2.getLayoutPosition() == i) {
                    if (!z) {
                        this.f4107c.remove(i3);
                        return viewHolder2;
                    }
                    return viewHolder2;
                }
            }
            return null;
        }

        /* JADX INFO: renamed from: a */
        ViewHolder m4596a(long j, int i, boolean z) {
            for (int size = this.f4105a.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.f4105a.get(size);
                if (viewHolder.getItemId() == j && !viewHolder.wasReturnedFromScrap()) {
                    if (i == viewHolder.getItemViewType()) {
                        viewHolder.addFlags(32);
                        if (viewHolder.isRemoved() && !RecyclerView.this.mState.m4658a()) {
                            viewHolder.setFlags(2, 14);
                            return viewHolder;
                        }
                        return viewHolder;
                    }
                    if (!z) {
                        this.f4105a.remove(size);
                        RecyclerView.this.removeDetachedView(viewHolder.itemView, false);
                        m4613b(viewHolder.itemView);
                    }
                }
            }
            for (int size2 = this.f4107c.size() - 1; size2 >= 0; size2--) {
                ViewHolder viewHolder2 = this.f4107c.get(size2);
                if (viewHolder2.getItemId() == j) {
                    if (i == viewHolder2.getItemViewType()) {
                        if (!z) {
                            this.f4107c.remove(size2);
                            return viewHolder2;
                        }
                        return viewHolder2;
                    }
                    if (!z) {
                        m4620d(size2);
                        return null;
                    }
                }
            }
            return null;
        }

        /* JADX INFO: renamed from: d */
        void m4621d(ViewHolder viewHolder) {
            if (RecyclerView.this.mRecyclerListener != null) {
                RecyclerView.this.mRecyclerListener.m4630a(viewHolder);
            }
            if (RecyclerView.this.mAdapter != null) {
                RecyclerView.this.mAdapter.onViewRecycled(viewHolder);
            }
            if (RecyclerView.this.mState != null) {
                RecyclerView.this.mViewInfoStore.m5023g(viewHolder);
            }
        }

        /* JADX INFO: renamed from: a */
        void m4602a(Adapter adapter, Adapter adapter2, boolean z) {
            m4598a();
            m4626g().m4585a(adapter, adapter2, z);
        }

        /* JADX INFO: renamed from: a */
        void m4600a(int i, int i2) {
            int i3;
            int i4;
            int i5;
            if (i < i2) {
                i3 = -1;
                i4 = i2;
                i5 = i;
            } else {
                i3 = 1;
                i4 = i;
                i5 = i2;
            }
            int size = this.f4107c.size();
            for (int i6 = 0; i6 < size; i6++) {
                ViewHolder viewHolder = this.f4107c.get(i6);
                if (viewHolder != null && viewHolder.mPosition >= i5 && viewHolder.mPosition <= i4) {
                    if (viewHolder.mPosition == i) {
                        viewHolder.offsetPosition(i2 - i, false);
                    } else {
                        viewHolder.offsetPosition(i3, false);
                    }
                }
            }
        }

        /* JADX INFO: renamed from: b */
        void m4611b(int i, int i2) {
            int size = this.f4107c.size();
            for (int i3 = 0; i3 < size; i3++) {
                ViewHolder viewHolder = this.f4107c.get(i3);
                if (viewHolder != null && viewHolder.mPosition >= i) {
                    viewHolder.offsetPosition(i2, true);
                }
            }
        }

        /* JADX INFO: renamed from: a */
        void m4601a(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.f4107c.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.f4107c.get(size);
                if (viewHolder != null) {
                    if (viewHolder.mPosition >= i3) {
                        viewHolder.offsetPosition(-i2, z);
                    } else if (viewHolder.mPosition >= i) {
                        viewHolder.addFlags(8);
                        m4620d(size);
                    }
                }
            }
        }

        /* JADX INFO: renamed from: a */
        void m4604a(ViewCacheExtension viewCacheExtension) {
            this.f4113i = viewCacheExtension;
        }

        /* JADX INFO: renamed from: a */
        void m4603a(RecycledViewPool recycledViewPool) {
            if (this.f4109e != null) {
                this.f4109e.m4588b();
            }
            this.f4109e = recycledViewPool;
            if (recycledViewPool != null) {
                this.f4109e.m4584a(RecyclerView.this.getAdapter());
            }
        }

        /* JADX INFO: renamed from: g */
        RecycledViewPool m4626g() {
            if (this.f4109e == null) {
                this.f4109e = new RecycledViewPool();
            }
            return this.f4109e;
        }

        /* JADX INFO: renamed from: c */
        void m4616c(int i, int i2) {
            int i3;
            int i4 = i + i2;
            for (int size = this.f4107c.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.f4107c.get(size);
                if (viewHolder != null && (i3 = viewHolder.mPosition) >= i && i3 < i4) {
                    viewHolder.addFlags(2);
                    m4620d(size);
                }
            }
        }

        /* JADX INFO: renamed from: h */
        void m4627h() {
            int size = this.f4107c.size();
            for (int i = 0; i < size; i++) {
                ViewHolder viewHolder = this.f4107c.get(i);
                if (viewHolder != null) {
                    viewHolder.addFlags(6);
                    viewHolder.addChangePayload(null);
                }
            }
            if (RecyclerView.this.mAdapter == null || !RecyclerView.this.mAdapter.hasStableIds()) {
                m4619d();
            }
        }

        /* JADX INFO: renamed from: i */
        void m4628i() {
            int size = this.f4107c.size();
            for (int i = 0; i < size; i++) {
                this.f4107c.get(i).clearOldPosition();
            }
            int size2 = this.f4105a.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.f4105a.get(i2).clearOldPosition();
            }
            if (this.f4106b != null) {
                int size3 = this.f4106b.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    this.f4106b.get(i3).clearOldPosition();
                }
            }
        }

        /* JADX INFO: renamed from: j */
        void m4629j() {
            int size = this.f4107c.size();
            for (int i = 0; i < size; i++) {
                LayoutParams layoutParams = (LayoutParams) this.f4107c.get(i).itemView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.f4097e = true;
                }
            }
        }
    }

    public static abstract class Adapter<VH extends ViewHolder> {
        private final AdapterDataObservable mObservable = new AdapterDataObservable();
        private boolean mHasStableIds = false;

        public abstract int getItemCount();

        public abstract void onBindViewHolder(VH vh, int i);

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i);

        public void onBindViewHolder(VH vh, int i, List<Object> list) {
            onBindViewHolder(vh, i);
        }

        public final VH createViewHolder(ViewGroup viewGroup, int i) {
            try {
                TraceCompat.m2325a(RecyclerView.TRACE_CREATE_VIEW_TAG);
                VH vh = (VH) onCreateViewHolder(viewGroup, i);
                if (vh.itemView.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                vh.mItemViewType = i;
                return vh;
            } finally {
                TraceCompat.m2324a();
            }
        }

        public final void bindViewHolder(VH vh, int i) {
            vh.mPosition = i;
            if (hasStableIds()) {
                vh.mItemId = getItemId(i);
            }
            vh.setFlags(1, 519);
            TraceCompat.m2325a(RecyclerView.TRACE_BIND_VIEW_TAG);
            onBindViewHolder(vh, i, vh.getUnmodifiedPayloads());
            vh.clearPayload();
            ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
            if (layoutParams instanceof LayoutParams) {
                ((LayoutParams) layoutParams).f4097e = true;
            }
            TraceCompat.m2324a();
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public void setHasStableIds(boolean z) {
            if (hasObservers()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.mHasStableIds = z;
        }

        public long getItemId(int i) {
            return -1L;
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public void onViewRecycled(VH vh) {
        }

        public boolean onFailedToRecycleView(VH vh) {
            return false;
        }

        public void onViewAttachedToWindow(VH vh) {
        }

        public void onViewDetachedFromWindow(VH vh) {
        }

        public final boolean hasObservers() {
            return this.mObservable.m4423a();
        }

        public void registerAdapterDataObserver(AdapterDataObserver adapterDataObserver) {
            this.mObservable.registerObserver(adapterDataObserver);
        }

        public void unregisterAdapterDataObserver(AdapterDataObserver adapterDataObserver) {
            this.mObservable.unregisterObserver(adapterDataObserver);
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public final void notifyDataSetChanged() {
            this.mObservable.m4424b();
        }

        public final void notifyItemChanged(int i) {
            this.mObservable.m4421a(i, 1);
        }

        public final void notifyItemChanged(int i, Object obj) {
            this.mObservable.m4422a(i, 1, obj);
        }

        public final void notifyItemRangeChanged(int i, int i2) {
            this.mObservable.m4421a(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2, Object obj) {
            this.mObservable.m4422a(i, i2, obj);
        }

        public final void notifyItemInserted(int i) {
            this.mObservable.m4425b(i, 1);
        }

        public final void notifyItemMoved(int i, int i2) {
            this.mObservable.m4427d(i, i2);
        }

        public final void notifyItemRangeInserted(int i, int i2) {
            this.mObservable.m4425b(i, i2);
        }

        public final void notifyItemRemoved(int i) {
            this.mObservable.m4426c(i, 1);
        }

        public final void notifyItemRangeRemoved(int i, int i2) {
            this.mObservable.m4426c(i, i2);
        }
    }

    void dispatchChildDetached(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        if (this.mAdapter != null && childViewHolderInt != null) {
            this.mAdapter.onViewDetachedFromWindow(childViewHolderInt);
        }
        if (this.mOnChildAttachStateListeners != null) {
            for (int size = this.mOnChildAttachStateListeners.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).mo4576b(view);
            }
        }
    }

    void dispatchChildAttached(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        if (this.mAdapter != null && childViewHolderInt != null) {
            this.mAdapter.onViewAttachedToWindow(childViewHolderInt);
        }
        if (this.mOnChildAttachStateListeners != null) {
            for (int size = this.mOnChildAttachStateListeners.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).mo4575a(view);
            }
        }
    }

    public static abstract class LayoutManager {

        /* JADX INFO: renamed from: e */
        private int f4075e;

        /* JADX INFO: renamed from: f */
        private int f4076f;

        /* JADX INFO: renamed from: g */
        private int f4077g;

        /* JADX INFO: renamed from: h */
        private int f4078h;

        /* JADX INFO: renamed from: p */
        ChildHelper f4079p;

        /* JADX INFO: renamed from: q */
        RecyclerView f4080q;

        /* JADX INFO: renamed from: t */
        SmoothScroller f4083t;

        /* JADX INFO: renamed from: x */
        int f4087x;

        /* JADX INFO: renamed from: y */
        boolean f4088y;

        /* JADX INFO: renamed from: a */
        private final ViewBoundsCheck.Callback f4071a = new ViewBoundsCheck.Callback() { // from class: android.support.v7.widget.RecyclerView.LayoutManager.1
            @Override // android.support.v7.widget.ViewBoundsCheck.Callback
            /* JADX INFO: renamed from: a */
            public View mo4568a(int i) {
                return LayoutManager.this.m4544i(i);
            }

            @Override // android.support.v7.widget.ViewBoundsCheck.Callback
            /* JADX INFO: renamed from: a */
            public int mo4566a() {
                return LayoutManager.this.m4474A();
            }

            @Override // android.support.v7.widget.ViewBoundsCheck.Callback
            /* JADX INFO: renamed from: b */
            public int mo4569b() {
                return LayoutManager.this.m4564y() - LayoutManager.this.m4476C();
            }

            @Override // android.support.v7.widget.ViewBoundsCheck.Callback
            /* JADX INFO: renamed from: a */
            public int mo4567a(View view) {
                return LayoutManager.this.m4541h(view) - ((LayoutParams) view.getLayoutParams()).leftMargin;
            }

            @Override // android.support.v7.widget.ViewBoundsCheck.Callback
            /* JADX INFO: renamed from: b */
            public int mo4570b(View view) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return layoutParams.rightMargin + LayoutManager.this.m4545j(view);
            }
        };

        /* JADX INFO: renamed from: b */
        private final ViewBoundsCheck.Callback f4072b = new ViewBoundsCheck.Callback() { // from class: android.support.v7.widget.RecyclerView.LayoutManager.2
            @Override // android.support.v7.widget.ViewBoundsCheck.Callback
            /* JADX INFO: renamed from: a */
            public View mo4568a(int i) {
                return LayoutManager.this.m4544i(i);
            }

            @Override // android.support.v7.widget.ViewBoundsCheck.Callback
            /* JADX INFO: renamed from: a */
            public int mo4566a() {
                return LayoutManager.this.m4475B();
            }

            @Override // android.support.v7.widget.ViewBoundsCheck.Callback
            /* JADX INFO: renamed from: b */
            public int mo4569b() {
                return LayoutManager.this.m4565z() - LayoutManager.this.m4477D();
            }

            @Override // android.support.v7.widget.ViewBoundsCheck.Callback
            /* JADX INFO: renamed from: a */
            public int mo4567a(View view) {
                return LayoutManager.this.m4543i(view) - ((LayoutParams) view.getLayoutParams()).topMargin;
            }

            @Override // android.support.v7.widget.ViewBoundsCheck.Callback
            /* JADX INFO: renamed from: b */
            public int mo4570b(View view) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return layoutParams.bottomMargin + LayoutManager.this.m4547k(view);
            }
        };

        /* JADX INFO: renamed from: r */
        ViewBoundsCheck f4081r = new ViewBoundsCheck(this.f4071a);

        /* JADX INFO: renamed from: s */
        ViewBoundsCheck f4082s = new ViewBoundsCheck(this.f4072b);

        /* JADX INFO: renamed from: u */
        boolean f4084u = false;

        /* JADX INFO: renamed from: v */
        boolean f4085v = false;

        /* JADX INFO: renamed from: w */
        boolean f4086w = false;

        /* JADX INFO: renamed from: c */
        private boolean f4073c = true;

        /* JADX INFO: renamed from: d */
        private boolean f4074d = true;

        public interface LayoutPrefetchRegistry {
            /* JADX INFO: renamed from: b */
            void mo4187b(int i, int i2);
        }

        public static class Properties {

            /* JADX INFO: renamed from: a */
            public int f4091a;

            /* JADX INFO: renamed from: b */
            public int f4092b;

            /* JADX INFO: renamed from: c */
            public boolean f4093c;

            /* JADX INFO: renamed from: d */
            public boolean f4094d;
        }

        /* JADX INFO: renamed from: a */
        public abstract LayoutParams mo4206a();

        /* JADX INFO: renamed from: b */
        void m4515b(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f4080q = null;
                this.f4079p = null;
                this.f4077g = 0;
                this.f4078h = 0;
            } else {
                this.f4080q = recyclerView;
                this.f4079p = recyclerView.mChildHelper;
                this.f4077g = recyclerView.getWidth();
                this.f4078h = recyclerView.getHeight();
            }
            this.f4075e = 1073741824;
            this.f4076f = 1073741824;
        }

        /* JADX INFO: renamed from: d */
        void m4529d(int i, int i2) {
            this.f4077g = View.MeasureSpec.getSize(i);
            this.f4075e = View.MeasureSpec.getMode(i);
            if (this.f4075e == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.f4077g = 0;
            }
            this.f4078h = View.MeasureSpec.getSize(i2);
            this.f4076f = View.MeasureSpec.getMode(i2);
            if (this.f4076f == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.f4078h = 0;
            }
        }

        /* JADX INFO: renamed from: e */
        void m4532e(int i, int i2) {
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MIN_VALUE;
            int iM4561v = m4561v();
            if (iM4561v == 0) {
                this.f4080q.defaultOnMeasure(i, i2);
                return;
            }
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < iM4561v; i7++) {
                View viewM4544i = m4544i(i7);
                Rect rect = this.f4080q.mTempRect;
                m4498a(viewM4544i, rect);
                if (rect.left < i6) {
                    i6 = rect.left;
                }
                if (rect.right > i5) {
                    i5 = rect.right;
                }
                if (rect.top < i3) {
                    i3 = rect.top;
                }
                if (rect.bottom > i4) {
                    i4 = rect.bottom;
                }
            }
            this.f4080q.mTempRect.set(i6, i3, i5, i4);
            mo4212a(this.f4080q.mTempRect, i, i2);
        }

        /* JADX INFO: renamed from: a */
        public void mo4212a(Rect rect, int i, int i2) {
            m4540g(m4463a(i, rect.width() + m4474A() + m4476C(), m4480G()), m4463a(i2, rect.height() + m4475B() + m4477D(), m4481H()));
        }

        /* JADX INFO: renamed from: o */
        public void m4554o() {
            if (this.f4080q != null) {
                this.f4080q.requestLayout();
            }
        }

        /* JADX INFO: renamed from: a */
        public static int m4463a(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            switch (mode) {
                case Integer.MIN_VALUE:
                    return Math.min(size, Math.max(i2, i3));
                case 1073741824:
                    return size;
                default:
                    return Math.max(i2, i3);
            }
        }

        /* JADX INFO: renamed from: a */
        public void mo4298a(String str) {
            if (this.f4080q != null) {
                this.f4080q.assertNotInLayoutOrScroll(str);
            }
        }

        /* JADX INFO: renamed from: c */
        public boolean mo4307c() {
            return this.f4086w;
        }

        /* JADX INFO: renamed from: b */
        public boolean mo4228b() {
            return false;
        }

        /* JADX INFO: renamed from: p */
        public final boolean m4555p() {
            return this.f4074d;
        }

        /* JADX INFO: renamed from: a */
        public void mo4291a(int i, int i2, State state, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        /* JADX INFO: renamed from: a */
        public void mo4292a(int i, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        /* JADX INFO: renamed from: c */
        void m4522c(RecyclerView recyclerView) {
            this.f4085v = true;
            m4530d(recyclerView);
        }

        /* JADX INFO: renamed from: b */
        void m4516b(RecyclerView recyclerView, Recycler recycler) {
            this.f4085v = false;
            mo4294a(recyclerView, recycler);
        }

        /* JADX INFO: renamed from: q */
        public boolean m4556q() {
            return this.f4085v;
        }

        /* JADX INFO: renamed from: a */
        public boolean m4513a(Runnable runnable) {
            if (this.f4080q != null) {
                return this.f4080q.removeCallbacks(runnable);
            }
            return false;
        }

        /* JADX INFO: renamed from: d */
        public void m4530d(RecyclerView recyclerView) {
        }

        @Deprecated
        /* JADX INFO: renamed from: e */
        public void m4533e(RecyclerView recyclerView) {
        }

        /* JADX INFO: renamed from: a */
        public void mo4294a(RecyclerView recyclerView, Recycler recycler) {
            m4533e(recyclerView);
        }

        /* JADX INFO: renamed from: r */
        public boolean m4557r() {
            return this.f4080q != null && this.f4080q.mClipToPadding;
        }

        /* JADX INFO: renamed from: c */
        public void mo4229c(Recycler recycler, State state) {
            Log.e(RecyclerView.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        /* JADX INFO: renamed from: a */
        public void mo4217a(State state) {
        }

        /* JADX INFO: renamed from: a */
        public boolean mo4224a(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        /* JADX INFO: renamed from: a */
        public LayoutParams mo4208a(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }

        /* JADX INFO: renamed from: a */
        public LayoutParams mo4207a(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        /* JADX INFO: renamed from: a */
        public int mo4204a(int i, Recycler recycler, State state) {
            return 0;
        }

        /* JADX INFO: renamed from: b */
        public int mo4225b(int i, Recycler recycler, State state) {
            return 0;
        }

        /* JADX INFO: renamed from: e */
        public boolean mo4313e() {
            return false;
        }

        /* JADX INFO: renamed from: f */
        public boolean mo4316f() {
            return false;
        }

        /* JADX INFO: renamed from: e */
        public void mo4312e(int i) {
        }

        /* JADX INFO: renamed from: a */
        public void mo4295a(RecyclerView recyclerView, State state, int i) {
            Log.e(RecyclerView.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        /* JADX INFO: renamed from: a */
        public void m4492a(SmoothScroller smoothScroller) {
            if (this.f4083t != null && smoothScroller != this.f4083t && this.f4083t.m4647h()) {
                this.f4083t.m4645f();
            }
            this.f4083t = smoothScroller;
            this.f4083t.m4640a(this.f4080q, this);
        }

        /* JADX INFO: renamed from: s */
        public boolean m4558s() {
            return this.f4083t != null && this.f4083t.m4647h();
        }

        /* JADX INFO: renamed from: t */
        public int m4559t() {
            return ViewCompat.m2601e(this.f4080q);
        }

        /* JADX INFO: renamed from: a */
        public void m4493a(View view) {
            m4494a(view, -1);
        }

        /* JADX INFO: renamed from: a */
        public void m4494a(View view, int i) {
            m4469a(view, i, true);
        }

        /* JADX INFO: renamed from: b */
        public void m4517b(View view) {
            m4518b(view, -1);
        }

        /* JADX INFO: renamed from: b */
        public void m4518b(View view, int i) {
            m4469a(view, i, false);
        }

        /* JADX INFO: renamed from: a */
        private void m4469a(View view, int i, boolean z) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (z || childViewHolderInt.isRemoved()) {
                this.f4080q.mViewInfoStore.m5021e(childViewHolderInt);
            } else {
                this.f4080q.mViewInfoStore.m5022f(childViewHolderInt);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (childViewHolderInt.wasReturnedFromScrap() || childViewHolderInt.isScrap()) {
                if (childViewHolderInt.isScrap()) {
                    childViewHolderInt.unScrap();
                } else {
                    childViewHolderInt.clearReturnedFromScrapFlag();
                }
                this.f4079p.m4011a(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f4080q) {
                int iM4015b = this.f4079p.m4015b(view);
                if (i == -1) {
                    i = this.f4079p.m4014b();
                }
                if (iM4015b == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f4080q.indexOfChild(view) + this.f4080q.exceptionLabel());
                }
                if (iM4015b != i) {
                    this.f4080q.mLayout.m4536f(iM4015b, i);
                }
            } else {
                this.f4079p.m4012a(view, i, false);
                layoutParams.f4097e = true;
                if (this.f4083t != null && this.f4083t.m4647h()) {
                    this.f4083t.m4641b(view);
                }
            }
            if (layoutParams.f4098f) {
                childViewHolderInt.itemView.invalidate();
                layoutParams.f4098f = false;
            }
        }

        /* JADX INFO: renamed from: c */
        public void m4524c(View view) {
            this.f4079p.m4010a(view);
        }

        /* JADX INFO: renamed from: g */
        public void m4539g(int i) {
            if (m4544i(i) != null) {
                this.f4079p.m4009a(i);
            }
        }

        /* JADX INFO: renamed from: u */
        public int m4560u() {
            return -1;
        }

        /* JADX INFO: renamed from: d */
        public int m4527d(View view) {
            return ((LayoutParams) view.getLayoutParams()).m4574f();
        }

        /* JADX INFO: renamed from: e */
        public View m4531e(View view) {
            View viewFindContainingItemView;
            if (this.f4080q == null || (viewFindContainingItemView = this.f4080q.findContainingItemView(view)) == null || this.f4079p.m4019c(viewFindContainingItemView)) {
                return null;
            }
            return viewFindContainingItemView;
        }

        /* JADX INFO: renamed from: c */
        public View mo4305c(int i) {
            int iM4561v = m4561v();
            for (int i2 = 0; i2 < iM4561v; i2++) {
                View viewM4544i = m4544i(i2);
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(viewM4544i);
                if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == i && !childViewHolderInt.shouldIgnore() && (this.f4080q.mState.m4658a() || !childViewHolderInt.isRemoved())) {
                    return viewM4544i;
                }
            }
            return null;
        }

        /* JADX INFO: renamed from: h */
        public void m4542h(int i) {
            m4466a(i, m4544i(i));
        }

        /* JADX INFO: renamed from: a */
        private void m4466a(int i, View view) {
            this.f4079p.m4022e(i);
        }

        /* JADX INFO: renamed from: a */
        public void m4497a(View view, int i, LayoutParams layoutParams) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isRemoved()) {
                this.f4080q.mViewInfoStore.m5021e(childViewHolderInt);
            } else {
                this.f4080q.mViewInfoStore.m5022f(childViewHolderInt);
            }
            this.f4079p.m4011a(view, i, layoutParams, childViewHolderInt.isRemoved());
        }

        /* JADX INFO: renamed from: c */
        public void m4525c(View view, int i) {
            m4497a(view, i, (LayoutParams) view.getLayoutParams());
        }

        /* JADX INFO: renamed from: f */
        public void m4536f(int i, int i2) {
            View viewM4544i = m4544i(i);
            if (viewM4544i == null) {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.f4080q.toString());
            }
            m4542h(i);
            m4525c(viewM4544i, i2);
        }

        /* JADX INFO: renamed from: a */
        public void m4500a(View view, Recycler recycler) {
            m4524c(view);
            recycler.m4606a(view);
        }

        /* JADX INFO: renamed from: a */
        public void m4485a(int i, Recycler recycler) {
            View viewM4544i = m4544i(i);
            m4539g(i);
            recycler.m4606a(viewM4544i);
        }

        /* JADX INFO: renamed from: v */
        public int m4561v() {
            if (this.f4079p != null) {
                return this.f4079p.m4014b();
            }
            return 0;
        }

        /* JADX INFO: renamed from: i */
        public View m4544i(int i) {
            if (this.f4079p != null) {
                return this.f4079p.m4016b(i);
            }
            return null;
        }

        /* JADX INFO: renamed from: w */
        public int m4562w() {
            return this.f4075e;
        }

        /* JADX INFO: renamed from: x */
        public int m4563x() {
            return this.f4076f;
        }

        /* JADX INFO: renamed from: y */
        public int m4564y() {
            return this.f4077g;
        }

        /* JADX INFO: renamed from: z */
        public int m4565z() {
            return this.f4078h;
        }

        /* JADX INFO: renamed from: A */
        public int m4474A() {
            if (this.f4080q != null) {
                return this.f4080q.getPaddingLeft();
            }
            return 0;
        }

        /* JADX INFO: renamed from: B */
        public int m4475B() {
            if (this.f4080q != null) {
                return this.f4080q.getPaddingTop();
            }
            return 0;
        }

        /* JADX INFO: renamed from: C */
        public int m4476C() {
            if (this.f4080q != null) {
                return this.f4080q.getPaddingRight();
            }
            return 0;
        }

        /* JADX INFO: renamed from: D */
        public int m4477D() {
            if (this.f4080q != null) {
                return this.f4080q.getPaddingBottom();
            }
            return 0;
        }

        /* JADX INFO: renamed from: E */
        public View m4478E() {
            View focusedChild;
            if (this.f4080q == null || (focusedChild = this.f4080q.getFocusedChild()) == null || this.f4079p.m4019c(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        /* JADX INFO: renamed from: F */
        public int m4479F() {
            Adapter adapter = this.f4080q != null ? this.f4080q.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        /* JADX INFO: renamed from: j */
        public void mo4546j(int i) {
            if (this.f4080q != null) {
                this.f4080q.offsetChildrenHorizontal(i);
            }
        }

        /* JADX INFO: renamed from: k */
        public void mo4548k(int i) {
            if (this.f4080q != null) {
                this.f4080q.offsetChildrenVertical(i);
            }
        }

        /* JADX INFO: renamed from: a */
        public void m4488a(Recycler recycler) {
            for (int iM4561v = m4561v() - 1; iM4561v >= 0; iM4561v--) {
                m4468a(recycler, iM4561v, m4544i(iM4561v));
            }
        }

        /* JADX INFO: renamed from: a */
        private void m4468a(Recycler recycler, int i, View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.shouldIgnore()) {
                if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !this.f4080q.mAdapter.hasStableIds()) {
                    m4539g(i);
                    recycler.m4612b(childViewHolderInt);
                } else {
                    m4542h(i);
                    recycler.m4618c(view);
                    this.f4080q.mViewInfoStore.m5024h(childViewHolderInt);
                }
            }
        }

        /* JADX INFO: renamed from: b */
        void m4514b(Recycler recycler) {
            int iM4622e = recycler.m4622e();
            for (int i = iM4622e - 1; i >= 0; i--) {
                View viewM4623e = recycler.m4623e(i);
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(viewM4623e);
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.setIsRecyclable(false);
                    if (childViewHolderInt.isTmpDetached()) {
                        this.f4080q.removeDetachedView(viewM4623e, false);
                    }
                    if (this.f4080q.mItemAnimator != null) {
                        this.f4080q.mItemAnimator.mo4113d(childViewHolderInt);
                    }
                    childViewHolderInt.setIsRecyclable(true);
                    recycler.m4613b(viewM4623e);
                }
            }
            recycler.m4625f();
            if (iM4622e > 0) {
                this.f4080q.invalidate();
            }
        }

        /* JADX INFO: renamed from: a */
        boolean m4510a(View view, int i, int i2, LayoutParams layoutParams) {
            return (this.f4073c && m4471b(view.getMeasuredWidth(), i, layoutParams.width) && m4471b(view.getMeasuredHeight(), i2, layoutParams.height)) ? false : true;
        }

        /* JADX INFO: renamed from: b */
        boolean m4520b(View view, int i, int i2, LayoutParams layoutParams) {
            return (!view.isLayoutRequested() && this.f4073c && m4471b(view.getWidth(), i, layoutParams.width) && m4471b(view.getHeight(), i2, layoutParams.height)) ? false : true;
        }

        /* JADX INFO: renamed from: b */
        private static boolean m4471b(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            switch (mode) {
                case Integer.MIN_VALUE:
                    return size >= i;
                case 0:
                    return true;
                case 1073741824:
                    return size == i;
                default:
                    return false;
            }
        }

        /* JADX INFO: renamed from: a */
        public void m4495a(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.f4080q.getItemDecorInsetsForChild(view);
            int i3 = itemDecorInsetsForChild.left + itemDecorInsetsForChild.right + i;
            int i4 = itemDecorInsetsForChild.bottom + itemDecorInsetsForChild.top + i2;
            int iM4464a = m4464a(m4564y(), m4562w(), i3 + m4474A() + m4476C() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width, mo4313e());
            int iM4464a2 = m4464a(m4565z(), m4563x(), i4 + m4475B() + m4477D() + layoutParams.topMargin + layoutParams.bottomMargin, layoutParams.height, mo4316f());
            if (m4520b(view, iM4464a, iM4464a2, layoutParams)) {
                view.measure(iM4464a, iM4464a2);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x003a  */
        /* JADX INFO: renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int m4464a(int r6, int r7, int r8, int r9, boolean r10) {
            /*
                r5 = -1
                r4 = -2
                r3 = -2147483648(0xffffffff80000000, float:-0.0)
                r2 = 1073741824(0x40000000, float:2.0)
                r0 = 0
                int r1 = r6 - r8
                int r1 = java.lang.Math.max(r0, r1)
                if (r10 == 0) goto L29
                if (r9 < 0) goto L18
                r0 = r2
                r1 = r9
            L13:
                int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r0)
                return r0
            L18:
                if (r9 != r5) goto L25
                switch(r7) {
                    case -2147483648: goto L21;
                    case 0: goto L23;
                    case 1073741824: goto L21;
                    default: goto L1d;
                }
            L1d:
                r7 = r0
            L1e:
                r1 = r0
                r0 = r7
                goto L13
            L21:
                r0 = r1
                goto L1e
            L23:
                r7 = r0
                goto L1e
            L25:
                if (r9 != r4) goto L3a
                r1 = r0
                goto L13
            L29:
                if (r9 < 0) goto L2e
                r0 = r2
                r1 = r9
                goto L13
            L2e:
                if (r9 != r5) goto L32
                r0 = r7
                goto L13
            L32:
                if (r9 != r4) goto L3a
                if (r7 == r3) goto L38
                if (r7 != r2) goto L13
            L38:
                r0 = r3
                goto L13
            L3a:
                r1 = r0
                goto L13
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.LayoutManager.m4464a(int, int, int, int, boolean):int");
        }

        /* JADX INFO: renamed from: f */
        public int m4535f(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f4096d;
            return rect.right + view.getMeasuredWidth() + rect.left;
        }

        /* JADX INFO: renamed from: g */
        public int m4538g(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f4096d;
            return rect.bottom + view.getMeasuredHeight() + rect.top;
        }

        /* JADX INFO: renamed from: a */
        public void m4496a(View view, int i, int i2, int i3, int i4) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.f4096d;
            view.layout(rect.left + i + layoutParams.leftMargin, rect.top + i2 + layoutParams.topMargin, (i3 - rect.right) - layoutParams.rightMargin, (i4 - rect.bottom) - layoutParams.bottomMargin);
        }

        /* JADX INFO: renamed from: a */
        public void m4501a(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((LayoutParams) view.getLayoutParams()).f4096d;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, rect2.bottom + view.getHeight());
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.f4080q != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.f4080q.mTempRectF;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        /* JADX INFO: renamed from: a */
        public void m4498a(View view, Rect rect) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
        }

        /* JADX INFO: renamed from: h */
        public int m4541h(View view) {
            return view.getLeft() - m4552n(view);
        }

        /* JADX INFO: renamed from: i */
        public int m4543i(View view) {
            return view.getTop() - m4549l(view);
        }

        /* JADX INFO: renamed from: j */
        public int m4545j(View view) {
            return view.getRight() + m4553o(view);
        }

        /* JADX INFO: renamed from: k */
        public int m4547k(View view) {
            return view.getBottom() + m4551m(view);
        }

        /* JADX INFO: renamed from: b */
        public void m4519b(View view, Rect rect) {
            if (this.f4080q == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(this.f4080q.getItemDecorInsetsForChild(view));
            }
        }

        /* JADX INFO: renamed from: l */
        public int m4549l(View view) {
            return ((LayoutParams) view.getLayoutParams()).f4096d.top;
        }

        /* JADX INFO: renamed from: m */
        public int m4551m(View view) {
            return ((LayoutParams) view.getLayoutParams()).f4096d.bottom;
        }

        /* JADX INFO: renamed from: n */
        public int m4552n(View view) {
            return ((LayoutParams) view.getLayoutParams()).f4096d.left;
        }

        /* JADX INFO: renamed from: o */
        public int m4553o(View view) {
            return ((LayoutParams) view.getLayoutParams()).f4096d.right;
        }

        /* JADX INFO: renamed from: a */
        public View mo4210a(View view, int i, Recycler recycler, State state) {
            return null;
        }

        /* JADX INFO: renamed from: d */
        public View m4528d(View view, int i) {
            return null;
        }

        /* JADX INFO: renamed from: b */
        private int[] m4472b(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            int iMin;
            int[] iArr = new int[2];
            int iM4474A = m4474A();
            int iM4475B = m4475B();
            int iM4564y = m4564y() - m4476C();
            int iM4565z = m4565z() - m4477D();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = left + rect.width();
            int iHeight = top + rect.height();
            int iMin2 = Math.min(0, left - iM4474A);
            int iMin3 = Math.min(0, top - iM4475B);
            int iMax = Math.max(0, iWidth - iM4564y);
            int iMax2 = Math.max(0, iHeight - iM4565z);
            if (m4559t() == 1) {
                if (iMax == 0) {
                    iMax = Math.max(iMin2, iWidth - iM4564y);
                }
                iMin = iMax;
            } else {
                iMin = iMin2 != 0 ? iMin2 : Math.min(left - iM4474A, iMax);
            }
            int iMin4 = iMin3 != 0 ? iMin3 : Math.min(top - iM4475B, iMax2);
            iArr[0] = iMin;
            iArr[1] = iMin4;
            return iArr;
        }

        /* JADX INFO: renamed from: a */
        public boolean m4506a(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return m4507a(recyclerView, view, rect, z, false);
        }

        /* JADX INFO: renamed from: a */
        public boolean m4507a(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] iArrM4472b = m4472b(recyclerView, view, rect, z);
            int i = iArrM4472b[0];
            int i2 = iArrM4472b[1];
            if (z2 && !m4473d(recyclerView, i, i2)) {
                return false;
            }
            if (i == 0 && i2 == 0) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.smoothScrollBy(i, i2);
            }
            return true;
        }

        /* JADX INFO: renamed from: a */
        public boolean m4512a(View view, boolean z, boolean z2) {
            boolean z3 = this.f4081r.m5002a(view, 24579) && this.f4082s.m5002a(view, 24579);
            return z ? z3 : !z3;
        }

        /* JADX INFO: renamed from: d */
        private boolean m4473d(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int iM4474A = m4474A();
            int iM4475B = m4475B();
            int iM4564y = m4564y() - m4476C();
            int iM4565z = m4565z() - m4477D();
            Rect rect = this.f4080q.mTempRect;
            m4498a(focusedChild, rect);
            return rect.left - i < iM4564y && rect.right - i > iM4474A && rect.top - i2 < iM4565z && rect.bottom - i2 > iM4475B;
        }

        @Deprecated
        /* JADX INFO: renamed from: a */
        public boolean m4508a(RecyclerView recyclerView, View view, View view2) {
            return m4558s() || recyclerView.isComputingLayout();
        }

        /* JADX INFO: renamed from: a */
        public boolean m4505a(RecyclerView recyclerView, State state, View view, View view2) {
            return m4508a(recyclerView, view, view2);
        }

        /* JADX INFO: renamed from: a */
        public void m4487a(Adapter adapter, Adapter adapter2) {
        }

        /* JADX INFO: renamed from: a */
        public boolean m4509a(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        /* JADX INFO: renamed from: a */
        public void mo4219a(RecyclerView recyclerView) {
        }

        /* JADX INFO: renamed from: a */
        public void mo4220a(RecyclerView recyclerView, int i, int i2) {
        }

        /* JADX INFO: renamed from: b */
        public void mo4227b(RecyclerView recyclerView, int i, int i2) {
        }

        /* JADX INFO: renamed from: c */
        public void m4523c(RecyclerView recyclerView, int i, int i2) {
        }

        /* JADX INFO: renamed from: a */
        public void mo4222a(RecyclerView recyclerView, int i, int i2, Object obj) {
            m4523c(recyclerView, i, i2);
        }

        /* JADX INFO: renamed from: a */
        public void mo4221a(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        /* JADX INFO: renamed from: e */
        public int mo4311e(State state) {
            return 0;
        }

        /* JADX INFO: renamed from: c */
        public int mo4304c(State state) {
            return 0;
        }

        /* JADX INFO: renamed from: g */
        public int mo4318g(State state) {
            return 0;
        }

        /* JADX INFO: renamed from: f */
        public int mo4315f(State state) {
            return 0;
        }

        /* JADX INFO: renamed from: d */
        public int mo4308d(State state) {
            return 0;
        }

        /* JADX INFO: renamed from: h */
        public int mo4319h(State state) {
            return 0;
        }

        /* JADX INFO: renamed from: a */
        public void m4489a(Recycler recycler, State state, int i, int i2) {
            this.f4080q.defaultOnMeasure(i, i2);
        }

        /* JADX INFO: renamed from: g */
        public void m4540g(int i, int i2) {
            this.f4080q.setMeasuredDimension(i, i2);
        }

        /* JADX INFO: renamed from: G */
        public int m4480G() {
            return ViewCompat.m2606j(this.f4080q);
        }

        /* JADX INFO: renamed from: H */
        public int m4481H() {
            return ViewCompat.m2607k(this.f4080q);
        }

        /* JADX INFO: renamed from: d */
        public Parcelable mo4310d() {
            return null;
        }

        /* JADX INFO: renamed from: a */
        public void mo4293a(Parcelable parcelable) {
        }

        /* JADX INFO: renamed from: I */
        void m4482I() {
            if (this.f4083t != null) {
                this.f4083t.m4645f();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: b */
        public void m4470b(SmoothScroller smoothScroller) {
            if (this.f4083t == smoothScroller) {
                this.f4083t = null;
            }
        }

        /* JADX INFO: renamed from: l */
        public void mo4550l(int i) {
        }

        /* JADX INFO: renamed from: c */
        public void m4521c(Recycler recycler) {
            for (int iM4561v = m4561v() - 1; iM4561v >= 0; iM4561v--) {
                if (!RecyclerView.getChildViewHolderInt(m4544i(iM4561v)).shouldIgnore()) {
                    m4485a(iM4561v, recycler);
                }
            }
        }

        /* JADX INFO: renamed from: a */
        void m4486a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            m4490a(this.f4080q.mRecycler, this.f4080q.mState, accessibilityNodeInfoCompat);
        }

        /* JADX INFO: renamed from: a */
        public void m4490a(Recycler recycler, State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (this.f4080q.canScrollVertically(-1) || this.f4080q.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.m2782a(Utility.DEFAULT_STREAM_BUFFER_SIZE);
                accessibilityNodeInfoCompat.m2819k(true);
            }
            if (this.f4080q.canScrollVertically(1) || this.f4080q.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.m2782a(4096);
                accessibilityNodeInfoCompat.m2819k(true);
            }
            accessibilityNodeInfoCompat.m2786a(AccessibilityNodeInfoCompat.CollectionInfoCompat.m2834a(mo4205a(recycler, state), mo4226b(recycler, state), m4534e(recycler, state), m4526d(recycler, state)));
        }

        /* JADX INFO: renamed from: a */
        public void mo4297a(AccessibilityEvent accessibilityEvent) {
            m4491a(this.f4080q.mRecycler, this.f4080q.mState, accessibilityEvent);
        }

        /* JADX INFO: renamed from: a */
        public void m4491a(Recycler recycler, State state, AccessibilityEvent accessibilityEvent) {
            boolean z = true;
            if (this.f4080q != null && accessibilityEvent != null) {
                if (!this.f4080q.canScrollVertically(1) && !this.f4080q.canScrollVertically(-1) && !this.f4080q.canScrollHorizontally(-1) && !this.f4080q.canScrollHorizontally(1)) {
                    z = false;
                }
                accessibilityEvent.setScrollable(z);
                if (this.f4080q.mAdapter != null) {
                    accessibilityEvent.setItemCount(this.f4080q.mAdapter.getItemCount());
                }
            }
        }

        /* JADX INFO: renamed from: a */
        void m4499a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && !this.f4079p.m4019c(childViewHolderInt.itemView)) {
                mo4216a(this.f4080q.mRecycler, this.f4080q.mState, view, accessibilityNodeInfoCompat);
            }
        }

        /* JADX INFO: renamed from: a */
        public void mo4216a(Recycler recycler, State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.m2794b(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.m2835a(mo4316f() ? m4527d(view) : 0, 1, mo4313e() ? m4527d(view) : 0, 1, false, false));
        }

        /* JADX INFO: renamed from: J */
        public void m4483J() {
            this.f4084u = true;
        }

        /* JADX INFO: renamed from: d */
        public int m4526d(Recycler recycler, State state) {
            return 0;
        }

        /* JADX INFO: renamed from: a */
        public int mo4205a(Recycler recycler, State state) {
            if (this.f4080q == null || this.f4080q.mAdapter == null || !mo4316f()) {
                return 1;
            }
            return this.f4080q.mAdapter.getItemCount();
        }

        /* JADX INFO: renamed from: b */
        public int mo4226b(Recycler recycler, State state) {
            if (this.f4080q == null || this.f4080q.mAdapter == null || !mo4313e()) {
                return 1;
            }
            return this.f4080q.mAdapter.getItemCount();
        }

        /* JADX INFO: renamed from: e */
        public boolean m4534e(Recycler recycler, State state) {
            return false;
        }

        /* JADX INFO: renamed from: a */
        boolean m4502a(int i, Bundle bundle) {
            return m4503a(this.f4080q.mRecycler, this.f4080q.mState, i, bundle);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x007a A[PHI: r0
          0x007a: PHI (r0v9 int) = (r0v4 int), (r0v14 int) binds: [B:20:0x0066, B:14:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX INFO: renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean m4503a(android.support.v7.widget.RecyclerView.Recycler r7, android.support.v7.widget.RecyclerView.State r8, int r9, android.os.Bundle r10) {
            /*
                r6 = this;
                r4 = -1
                r2 = 1
                r1 = 0
                android.support.v7.widget.RecyclerView r0 = r6.f4080q
                if (r0 != 0) goto L8
            L7:
                return r1
            L8:
                switch(r9) {
                    case 4096: goto L4a;
                    case 8192: goto L18;
                    default: goto Lb;
                }
            Lb:
                r0 = r1
                r3 = r1
            Ld:
                if (r3 != 0) goto L11
                if (r0 == 0) goto L7
            L11:
                android.support.v7.widget.RecyclerView r1 = r6.f4080q
                r1.scrollBy(r0, r3)
                r1 = r2
                goto L7
            L18:
                android.support.v7.widget.RecyclerView r0 = r6.f4080q
                boolean r0 = r0.canScrollVertically(r4)
                if (r0 == 0) goto L7f
                int r0 = r6.m4565z()
                int r3 = r6.m4475B()
                int r0 = r0 - r3
                int r3 = r6.m4477D()
                int r0 = r0 - r3
                int r0 = -r0
            L2f:
                android.support.v7.widget.RecyclerView r3 = r6.f4080q
                boolean r3 = r3.canScrollHorizontally(r4)
                if (r3 == 0) goto L7a
                int r3 = r6.m4564y()
                int r4 = r6.m4474A()
                int r3 = r3 - r4
                int r4 = r6.m4476C()
                int r3 = r3 - r4
                int r3 = -r3
                r5 = r3
                r3 = r0
                r0 = r5
                goto Ld
            L4a:
                android.support.v7.widget.RecyclerView r0 = r6.f4080q
                boolean r0 = r0.canScrollVertically(r2)
                if (r0 == 0) goto L7d
                int r0 = r6.m4565z()
                int r3 = r6.m4475B()
                int r0 = r0 - r3
                int r3 = r6.m4477D()
                int r0 = r0 - r3
            L60:
                android.support.v7.widget.RecyclerView r3 = r6.f4080q
                boolean r3 = r3.canScrollHorizontally(r2)
                if (r3 == 0) goto L7a
                int r3 = r6.m4564y()
                int r4 = r6.m4474A()
                int r3 = r3 - r4
                int r4 = r6.m4476C()
                int r3 = r3 - r4
                r5 = r3
                r3 = r0
                r0 = r5
                goto Ld
            L7a:
                r3 = r0
                r0 = r1
                goto Ld
            L7d:
                r0 = r1
                goto L60
            L7f:
                r0 = r1
                goto L2f
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.LayoutManager.m4503a(android.support.v7.widget.RecyclerView$Recycler, android.support.v7.widget.RecyclerView$State, int, android.os.Bundle):boolean");
        }

        /* JADX INFO: renamed from: a */
        boolean m4511a(View view, int i, Bundle bundle) {
            return m4504a(this.f4080q.mRecycler, this.f4080q.mState, view, i, bundle);
        }

        /* JADX INFO: renamed from: a */
        public boolean m4504a(Recycler recycler, State state, View view, int i, Bundle bundle) {
            return false;
        }

        /* JADX INFO: renamed from: a */
        public static Properties m4465a(Context context, AttributeSet attributeSet, int i, int i2) {
            Properties properties = new Properties();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.recyclerview.R.styleable.RecyclerView, i, i2);
            properties.f4091a = typedArrayObtainStyledAttributes.getInt(android.support.v7.recyclerview.R.styleable.RecyclerView_android_orientation, 1);
            properties.f4092b = typedArrayObtainStyledAttributes.getInt(android.support.v7.recyclerview.R.styleable.RecyclerView_spanCount, 1);
            properties.f4093c = typedArrayObtainStyledAttributes.getBoolean(android.support.v7.recyclerview.R.styleable.RecyclerView_reverseLayout, false);
            properties.f4094d = typedArrayObtainStyledAttributes.getBoolean(android.support.v7.recyclerview.R.styleable.RecyclerView_stackFromEnd, false);
            typedArrayObtainStyledAttributes.recycle();
            return properties;
        }

        /* JADX INFO: renamed from: f */
        void m4537f(RecyclerView recyclerView) {
            m4529d(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        /* JADX INFO: renamed from: l */
        boolean mo4324l() {
            return false;
        }

        /* JADX INFO: renamed from: K */
        boolean m4484K() {
            int iM4561v = m4561v();
            for (int i = 0; i < iM4561v; i++) {
                ViewGroup.LayoutParams layoutParams = m4544i(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    public static abstract class ItemDecoration {
        /* JADX INFO: renamed from: b */
        public void mo4462b(Canvas canvas, RecyclerView recyclerView, State state) {
            m4458a(canvas, recyclerView);
        }

        @Deprecated
        /* JADX INFO: renamed from: a */
        public void m4458a(Canvas canvas, RecyclerView recyclerView) {
        }

        /* JADX INFO: renamed from: a */
        public void mo4157a(Canvas canvas, RecyclerView recyclerView, State state) {
            m4461b(canvas, recyclerView);
        }

        @Deprecated
        /* JADX INFO: renamed from: b */
        public void m4461b(Canvas canvas, RecyclerView recyclerView) {
        }

        @Deprecated
        /* JADX INFO: renamed from: a */
        public void m4459a(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        /* JADX INFO: renamed from: a */
        public void mo4460a(Rect rect, View view, RecyclerView recyclerView, State state) {
            m4459a(rect, ((LayoutParams) view.getLayoutParams()).m4574f(), recyclerView);
        }
    }

    public static abstract class OnScrollListener {
        /* JADX INFO: renamed from: a */
        public void m4578a(RecyclerView recyclerView, int i) {
        }

        /* JADX INFO: renamed from: a */
        public void mo4164a(RecyclerView recyclerView, int i, int i2) {
        }
    }

    public static abstract class ViewHolder {
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
        WeakReference<RecyclerView> mNestedRecyclerView;
        RecyclerView mOwnerRecyclerView;
        int mPosition = -1;
        int mOldPosition = -1;
        long mItemId = -1;
        int mItemViewType = -1;
        int mPreLayoutPosition = -1;
        ViewHolder mShadowedHolder = null;
        ViewHolder mShadowingHolder = null;
        List<Object> mPayloads = null;
        List<Object> mUnmodifiedPayloads = null;
        private int mIsRecyclableCount = 0;
        private Recycler mScrapContainer = null;
        private boolean mInChangeScrap = false;
        private int mWasImportantForAccessibilityBeforeHidden = 0;
        int mPendingAccessibilityState = -1;

        public ViewHolder(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.itemView = view;
        }

        void flagRemovedAndOffsetPosition(int i, int i2, boolean z) {
            addFlags(8);
            offsetPosition(i2, z);
            this.mPosition = i;
        }

        void offsetPosition(int i, boolean z) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z) {
                this.mPreLayoutPosition += i;
            }
            this.mPosition += i;
            if (this.itemView.getLayoutParams() != null) {
                ((LayoutParams) this.itemView.getLayoutParams()).f4097e = true;
            }
        }

        void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        boolean shouldIgnore() {
            return (this.mFlags & FLAG_IGNORE) != 0;
        }

        @Deprecated
        public final int getPosition() {
            return this.mPreLayoutPosition == -1 ? this.mPosition : this.mPreLayoutPosition;
        }

        public final int getLayoutPosition() {
            return this.mPreLayoutPosition == -1 ? this.mPosition : this.mPreLayoutPosition;
        }

        public final int getAdapterPosition() {
            if (this.mOwnerRecyclerView == null) {
                return -1;
            }
            return this.mOwnerRecyclerView.getAdapterPositionFor(this);
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        boolean isScrap() {
            return this.mScrapContainer != null;
        }

        void unScrap() {
            this.mScrapContainer.m4617c(this);
        }

        boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }

        void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        void stopIgnoring() {
            this.mFlags &= -129;
        }

        void setScrapContainer(Recycler recycler, boolean z) {
            this.mScrapContainer = recycler;
            this.mInChangeScrap = z;
        }

        boolean isInvalid() {
            return (this.mFlags & 4) != 0;
        }

        boolean needsUpdate() {
            return (this.mFlags & 2) != 0;
        }

        boolean isBound() {
            return (this.mFlags & 1) != 0;
        }

        boolean isRemoved() {
            return (this.mFlags & 8) != 0;
        }

        boolean hasAnyOfTheFlags(int i) {
            return (this.mFlags & i) != 0;
        }

        boolean isTmpDetached() {
            return (this.mFlags & FLAG_TMP_DETACHED) != 0;
        }

        boolean isAdapterPositionUnknown() {
            return (this.mFlags & FLAG_ADAPTER_POSITION_UNKNOWN) != 0 || isInvalid();
        }

        void setFlags(int i, int i2) {
            this.mFlags = (this.mFlags & (i2 ^ (-1))) | (i & i2);
        }

        void addFlags(int i) {
            this.mFlags |= i;
        }

        void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(FLAG_ADAPTER_FULLUPDATE);
            } else if ((this.mFlags & FLAG_ADAPTER_FULLUPDATE) == 0) {
                createPayloadsIfNeeded();
                this.mPayloads.add(obj);
            }
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                this.mPayloads = new ArrayList();
                this.mUnmodifiedPayloads = Collections.unmodifiableList(this.mPayloads);
            }
        }

        void clearPayload() {
            if (this.mPayloads != null) {
                this.mPayloads.clear();
            }
            this.mFlags &= -1025;
        }

        List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & FLAG_ADAPTER_FULLUPDATE) == 0) {
                if (this.mPayloads == null || this.mPayloads.size() == 0) {
                    return FULLUPDATE_PAYLOADS;
                }
                return this.mUnmodifiedPayloads;
            }
            return FULLUPDATE_PAYLOADS;
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
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onEnteredHiddenState(RecyclerView recyclerView) {
            if (this.mPendingAccessibilityState != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = this.mPendingAccessibilityState;
            } else {
                this.mWasImportantForAccessibilityBeforeHidden = ViewCompat.m2599d(this.itemView);
            }
            recyclerView.setChildImportantForAccessibilityInternal(this, 4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
            if (isScrap()) {
                sb.append(" scrap ").append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                sb.append(" invalid");
            }
            if (!isBound()) {
                sb.append(" unbound");
            }
            if (needsUpdate()) {
                sb.append(" update");
            }
            if (isRemoved()) {
                sb.append(" removed");
            }
            if (shouldIgnore()) {
                sb.append(" ignored");
            }
            if (isTmpDetached()) {
                sb.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb.append(" not recyclable(" + this.mIsRecyclableCount + ")");
            }
            if (isAdapterPositionUnknown()) {
                sb.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public final void setIsRecyclable(boolean z) {
            this.mIsRecyclableCount = z ? this.mIsRecyclableCount - 1 : this.mIsRecyclableCount + 1;
            if (this.mIsRecyclableCount < 0) {
                this.mIsRecyclableCount = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && this.mIsRecyclableCount == 1) {
                this.mFlags |= 16;
            } else if (z && this.mIsRecyclableCount == 0) {
                this.mFlags &= -17;
            }
        }

        public final boolean isRecyclable() {
            return (this.mFlags & 16) == 0 && !ViewCompat.m2596b(this.itemView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean shouldBeKeptAsChild() {
            return (this.mFlags & 16) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean doesTransientStatePreventRecycling() {
            return (this.mFlags & 16) == 0 && ViewCompat.m2596b(this.itemView);
        }

        boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }
    }

    boolean setChildImportantForAccessibilityInternal(ViewHolder viewHolder, int i) {
        if (isComputingLayout()) {
            viewHolder.mPendingAccessibilityState = i;
            this.mPendingAccessibilityImportanceChange.add(viewHolder);
            return false;
        }
        ViewCompat.m2575a(viewHolder.itemView, i);
        return true;
    }

    void dispatchPendingImportantForAccessibilityChanges() {
        int i;
        for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
            ViewHolder viewHolder = this.mPendingAccessibilityImportanceChange.get(size);
            if (viewHolder.itemView.getParent() == this && !viewHolder.shouldIgnore() && (i = viewHolder.mPendingAccessibilityState) != -1) {
                ViewCompat.m2575a(viewHolder.itemView, i);
                viewHolder.mPendingAccessibilityState = -1;
            }
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }

    int getAdapterPositionFor(ViewHolder viewHolder) {
        if (viewHolder.hasAnyOfTheFlags(524) || !viewHolder.isBound()) {
            return -1;
        }
        return this.mAdapterHelper.m3818c(viewHolder.mPosition);
    }

    void initFastScroller(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + exceptionLabel());
        }
        Resources resources = getContext().getResources();
        new FastScroller(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(android.support.v7.recyclerview.R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(android.support.v7.recyclerview.R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(android.support.v7.recyclerview.R.dimen.fastscroll_margin));
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().m2531a(z);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().m2532a();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().m2542b(i);
    }

    public boolean startNestedScroll(int i, int i2) {
        return getScrollingChildHelper().m2536a(i, i2);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public void stopNestedScroll() {
        getScrollingChildHelper().m2543c();
    }

    public void stopNestedScroll(int i) {
        getScrollingChildHelper().m2544c(i);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().m2541b();
    }

    public boolean hasNestedScrollingParent(int i) {
        return getScrollingChildHelper().m2535a(i);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().m2537a(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return getScrollingChildHelper().m2538a(i, i2, i3, i4, iArr, i5);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().m2539a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().m2540a(i, i2, iArr, iArr2, i3);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().m2534a(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().m2533a(f, f2);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: c */
        ViewHolder f4095c;

        /* JADX INFO: renamed from: d */
        final Rect f4096d;

        /* JADX INFO: renamed from: e */
        boolean f4097e;

        /* JADX INFO: renamed from: f */
        boolean f4098f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f4096d = new Rect();
            this.f4097e = true;
            this.f4098f = false;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f4096d = new Rect();
            this.f4097e = true;
            this.f4098f = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f4096d = new Rect();
            this.f4097e = true;
            this.f4098f = false;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f4096d = new Rect();
            this.f4097e = true;
            this.f4098f = false;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.f4096d = new Rect();
            this.f4097e = true;
            this.f4098f = false;
        }

        /* JADX INFO: renamed from: c */
        public boolean m4571c() {
            return this.f4095c.isInvalid();
        }

        /* JADX INFO: renamed from: d */
        public boolean m4572d() {
            return this.f4095c.isRemoved();
        }

        /* JADX INFO: renamed from: e */
        public boolean m4573e() {
            return this.f4095c.isUpdated();
        }

        /* JADX INFO: renamed from: f */
        public int m4574f() {
            return this.f4095c.getLayoutPosition();
        }
    }

    public static abstract class AdapterDataObserver {
        /* JADX INFO: renamed from: a */
        public void mo4428a() {
        }

        /* JADX INFO: renamed from: a */
        public void mo4429a(int i, int i2) {
        }

        /* JADX INFO: renamed from: a */
        public void mo4431a(int i, int i2, Object obj) {
            mo4429a(i, i2);
        }

        /* JADX INFO: renamed from: b */
        public void mo4432b(int i, int i2) {
        }

        /* JADX INFO: renamed from: c */
        public void mo4433c(int i, int i2) {
        }

        /* JADX INFO: renamed from: a */
        public void mo4430a(int i, int i2, int i3) {
        }
    }

    public static abstract class SmoothScroller {

        /* JADX INFO: renamed from: b */
        private RecyclerView f4117b;

        /* JADX INFO: renamed from: c */
        private LayoutManager f4118c;

        /* JADX INFO: renamed from: d */
        private boolean f4119d;

        /* JADX INFO: renamed from: e */
        private boolean f4120e;

        /* JADX INFO: renamed from: f */
        private View f4121f;

        /* JADX INFO: renamed from: a */
        private int f4116a = -1;

        /* JADX INFO: renamed from: g */
        private final Action f4122g = new Action(0, 0);

        public interface ScrollVectorProvider {
            /* JADX INFO: renamed from: d */
            PointF mo4309d(int i);
        }

        /* JADX INFO: renamed from: a */
        protected abstract void mo4348a();

        /* JADX INFO: renamed from: a */
        protected abstract void mo4349a(int i, int i2, State state, Action action);

        /* JADX INFO: renamed from: a */
        protected abstract void mo4351a(View view, State state, Action action);

        /* JADX INFO: renamed from: b */
        protected abstract void mo4354b();

        /* JADX INFO: renamed from: a */
        void m4640a(RecyclerView recyclerView, LayoutManager layoutManager) {
            this.f4117b = recyclerView;
            this.f4118c = layoutManager;
            if (this.f4116a == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            this.f4117b.mState.f4145p = this.f4116a;
            this.f4120e = true;
            this.f4119d = true;
            this.f4121f = m4644e(m4648i());
            mo4348a();
            this.f4117b.mViewFlinger.m4669a();
        }

        /* JADX INFO: renamed from: d */
        public void m4642d(int i) {
            this.f4116a = i;
        }

        /* JADX INFO: renamed from: e */
        public LayoutManager m4643e() {
            return this.f4118c;
        }

        /* JADX INFO: renamed from: f */
        protected final void m4645f() {
            if (this.f4120e) {
                mo4354b();
                this.f4117b.mState.f4145p = -1;
                this.f4121f = null;
                this.f4116a = -1;
                this.f4119d = false;
                this.f4120e = false;
                this.f4118c.m4470b(this);
                this.f4118c = null;
                this.f4117b = null;
            }
        }

        /* JADX INFO: renamed from: g */
        public boolean m4646g() {
            return this.f4119d;
        }

        /* JADX INFO: renamed from: h */
        public boolean m4647h() {
            return this.f4120e;
        }

        /* JADX INFO: renamed from: i */
        public int m4648i() {
            return this.f4116a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: a */
        public void m4636a(int i, int i2) {
            RecyclerView recyclerView = this.f4117b;
            if (!this.f4120e || this.f4116a == -1 || recyclerView == null) {
                m4645f();
            }
            this.f4119d = false;
            if (this.f4121f != null) {
                if (m4638a(this.f4121f) == this.f4116a) {
                    mo4351a(this.f4121f, recyclerView.mState, this.f4122g);
                    this.f4122g.m4653a(recyclerView);
                    m4645f();
                } else {
                    Log.e(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
                    this.f4121f = null;
                }
            }
            if (this.f4120e) {
                mo4349a(i, i2, recyclerView.mState, this.f4122g);
                boolean zM4654a = this.f4122g.m4654a();
                this.f4122g.m4653a(recyclerView);
                if (zM4654a) {
                    if (this.f4120e) {
                        this.f4119d = true;
                        recyclerView.mViewFlinger.m4669a();
                    } else {
                        m4645f();
                    }
                }
            }
        }

        /* JADX INFO: renamed from: a */
        public int m4638a(View view) {
            return this.f4117b.getChildLayoutPosition(view);
        }

        /* JADX INFO: renamed from: j */
        public int m4649j() {
            return this.f4117b.mLayout.m4561v();
        }

        /* JADX INFO: renamed from: e */
        public View m4644e(int i) {
            return this.f4117b.mLayout.mo4305c(i);
        }

        /* JADX INFO: renamed from: b */
        protected void m4641b(View view) {
            if (m4638a(view) == m4648i()) {
                this.f4121f = view;
            }
        }

        /* JADX INFO: renamed from: a */
        protected void m4639a(PointF pointF) {
            float fSqrt = (float) Math.sqrt((pointF.x * pointF.x) + (pointF.y * pointF.y));
            pointF.x /= fSqrt;
            pointF.y /= fSqrt;
        }

        public static class Action {

            /* JADX INFO: renamed from: a */
            private int f4123a;

            /* JADX INFO: renamed from: b */
            private int f4124b;

            /* JADX INFO: renamed from: c */
            private int f4125c;

            /* JADX INFO: renamed from: d */
            private int f4126d;

            /* JADX INFO: renamed from: e */
            private Interpolator f4127e;

            /* JADX INFO: renamed from: f */
            private boolean f4128f;

            /* JADX INFO: renamed from: g */
            private int f4129g;

            public Action(int i, int i2) {
                this(i, i2, Integer.MIN_VALUE, null);
            }

            public Action(int i, int i2, int i3, Interpolator interpolator) {
                this.f4126d = -1;
                this.f4128f = false;
                this.f4129g = 0;
                this.f4123a = i;
                this.f4124b = i2;
                this.f4125c = i3;
                this.f4127e = interpolator;
            }

            /* JADX INFO: renamed from: a */
            public void m4651a(int i) {
                this.f4126d = i;
            }

            /* JADX INFO: renamed from: a */
            boolean m4654a() {
                return this.f4126d >= 0;
            }

            /* JADX INFO: renamed from: a */
            void m4653a(RecyclerView recyclerView) {
                if (this.f4126d >= 0) {
                    int i = this.f4126d;
                    this.f4126d = -1;
                    recyclerView.jumpToPositionForSmoothScroller(i);
                    this.f4128f = false;
                    return;
                }
                if (this.f4128f) {
                    m4650b();
                    if (this.f4127e == null) {
                        if (this.f4125c == Integer.MIN_VALUE) {
                            recyclerView.mViewFlinger.m4676b(this.f4123a, this.f4124b);
                        } else {
                            recyclerView.mViewFlinger.m4671a(this.f4123a, this.f4124b, this.f4125c);
                        }
                    } else {
                        recyclerView.mViewFlinger.m4673a(this.f4123a, this.f4124b, this.f4125c, this.f4127e);
                    }
                    this.f4129g++;
                    if (this.f4129g > 10) {
                        Log.e(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f4128f = false;
                    return;
                }
                this.f4129g = 0;
            }

            /* JADX INFO: renamed from: b */
            private void m4650b() {
                if (this.f4127e != null && this.f4125c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.f4125c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            /* JADX INFO: renamed from: a */
            public void m4652a(int i, int i2, int i3, Interpolator interpolator) {
                this.f4123a = i;
                this.f4124b = i2;
                this.f4125c = i3;
                this.f4127e = interpolator;
                this.f4128f = true;
            }
        }
    }

    static class AdapterDataObservable extends Observable<AdapterDataObserver> {
        AdapterDataObservable() {
        }

        /* JADX INFO: renamed from: a */
        public boolean m4423a() {
            return !this.mObservers.isEmpty();
        }

        /* JADX INFO: renamed from: b */
        public void m4424b() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).mo4428a();
            }
        }

        /* JADX INFO: renamed from: a */
        public void m4421a(int i, int i2) {
            m4422a(i, i2, null);
        }

        /* JADX INFO: renamed from: a */
        public void m4422a(int i, int i2, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).mo4431a(i, i2, obj);
            }
        }

        /* JADX INFO: renamed from: b */
        public void m4425b(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).mo4432b(i, i2);
            }
        }

        /* JADX INFO: renamed from: c */
        public void m4426c(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).mo4433c(i, i2);
            }
        }

        /* JADX INFO: renamed from: d */
        public void m4427d(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).mo4430a(i, i2, 1);
            }
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: android.support.v7.widget.RecyclerView.SavedState.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* JADX INFO: renamed from: a */
        Parcelable f4115a;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f4115a = parcel.readParcelable(classLoader == null ? LayoutManager.class.getClassLoader() : classLoader);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f4115a, 0);
        }

        /* JADX INFO: renamed from: a */
        void m4632a(SavedState savedState) {
            this.f4115a = savedState.f4115a;
        }
    }

    public static class State {

        /* JADX INFO: renamed from: k */
        int f4140k;

        /* JADX INFO: renamed from: l */
        long f4141l;

        /* JADX INFO: renamed from: m */
        int f4142m;

        /* JADX INFO: renamed from: n */
        int f4143n;

        /* JADX INFO: renamed from: o */
        int f4144o;

        /* JADX INFO: renamed from: q */
        private SparseArray<Object> f4146q;

        /* JADX INFO: renamed from: p */
        private int f4145p = -1;

        /* JADX INFO: renamed from: a */
        int f4130a = 0;

        /* JADX INFO: renamed from: b */
        int f4131b = 0;

        /* JADX INFO: renamed from: c */
        int f4132c = 1;

        /* JADX INFO: renamed from: d */
        int f4133d = 0;

        /* JADX INFO: renamed from: e */
        boolean f4134e = false;

        /* JADX INFO: renamed from: f */
        boolean f4135f = false;

        /* JADX INFO: renamed from: g */
        boolean f4136g = false;

        /* JADX INFO: renamed from: h */
        boolean f4137h = false;

        /* JADX INFO: renamed from: i */
        boolean f4138i = false;

        /* JADX INFO: renamed from: j */
        boolean f4139j = false;

        /* JADX INFO: renamed from: a */
        void m4656a(int i) {
            if ((this.f4132c & i) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.f4132c));
            }
        }

        /* JADX INFO: renamed from: a */
        void m4657a(Adapter adapter) {
            this.f4132c = 1;
            this.f4133d = adapter.getItemCount();
            this.f4135f = false;
            this.f4136g = false;
            this.f4137h = false;
        }

        /* JADX INFO: renamed from: a */
        public boolean m4658a() {
            return this.f4135f;
        }

        /* JADX INFO: renamed from: b */
        public boolean m4659b() {
            return this.f4139j;
        }

        /* JADX INFO: renamed from: c */
        public int m4660c() {
            return this.f4145p;
        }

        /* JADX INFO: renamed from: d */
        public boolean m4661d() {
            return this.f4145p != -1;
        }

        /* JADX INFO: renamed from: e */
        public int m4662e() {
            return this.f4135f ? this.f4130a - this.f4131b : this.f4133d;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f4145p + ", mData=" + this.f4146q + ", mItemCount=" + this.f4133d + ", mIsMeasuring=" + this.f4137h + ", mPreviousLayoutItemCount=" + this.f4130a + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f4131b + ", mStructureChanged=" + this.f4134e + ", mInPreLayout=" + this.f4135f + ", mRunSimpleAnimations=" + this.f4138i + ", mRunPredictiveAnimations=" + this.f4139j + '}';
        }
    }

    private class ItemAnimatorRestoreListener implements ItemAnimator.ItemAnimatorListener {
        ItemAnimatorRestoreListener() {
        }

        @Override // android.support.v7.widget.RecyclerView.ItemAnimator.ItemAnimatorListener
        /* JADX INFO: renamed from: a */
        public void mo4455a(ViewHolder viewHolder) {
            viewHolder.setIsRecyclable(true);
            if (viewHolder.mShadowedHolder != null && viewHolder.mShadowingHolder == null) {
                viewHolder.mShadowedHolder = null;
            }
            viewHolder.mShadowingHolder = null;
            if (!viewHolder.shouldBeKeptAsChild() && !RecyclerView.this.removeAnimatingView(viewHolder.itemView) && viewHolder.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(viewHolder.itemView, false);
            }
        }
    }

    public static abstract class ItemAnimator {

        /* JADX INFO: renamed from: a */
        private ItemAnimatorListener f4060a = null;

        /* JADX INFO: renamed from: b */
        private ArrayList<ItemAnimatorFinishedListener> f4061b = new ArrayList<>();

        /* JADX INFO: renamed from: c */
        private long f4062c = 120;

        /* JADX INFO: renamed from: d */
        private long f4063d = 120;

        /* JADX INFO: renamed from: e */
        private long f4064e = 250;

        /* JADX INFO: renamed from: f */
        private long f4065f = 250;

        public interface ItemAnimatorFinishedListener {
            /* JADX INFO: renamed from: a */
            void m4454a();
        }

        interface ItemAnimatorListener {
            /* JADX INFO: renamed from: a */
            void mo4455a(ViewHolder viewHolder);
        }

        /* JADX INFO: renamed from: a */
        public abstract void mo4100a();

        /* JADX INFO: renamed from: a */
        public abstract boolean mo4441a(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        /* JADX INFO: renamed from: a */
        public abstract boolean mo4442a(ViewHolder viewHolder, ViewHolder viewHolder2, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        /* JADX INFO: renamed from: b */
        public abstract boolean mo4108b();

        /* JADX INFO: renamed from: b */
        public abstract boolean mo4443b(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        /* JADX INFO: renamed from: c */
        public abstract boolean mo4444c(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        /* JADX INFO: renamed from: d */
        public abstract void mo4112d();

        /* JADX INFO: renamed from: d */
        public abstract void mo4113d(ViewHolder viewHolder);

        /* JADX INFO: renamed from: e */
        public long m4445e() {
            return this.f4064e;
        }

        /* JADX INFO: renamed from: f */
        public long m4446f() {
            return this.f4062c;
        }

        /* JADX INFO: renamed from: g */
        public long m4448g() {
            return this.f4063d;
        }

        /* JADX INFO: renamed from: h */
        public long m4450h() {
            return this.f4065f;
        }

        /* JADX INFO: renamed from: a */
        void m4439a(ItemAnimatorListener itemAnimatorListener) {
            this.f4060a = itemAnimatorListener;
        }

        /* JADX INFO: renamed from: a */
        public ItemHolderInfo m4438a(State state, ViewHolder viewHolder, int i, List<Object> list) {
            return m4453j().m4456a(viewHolder);
        }

        /* JADX INFO: renamed from: a */
        public ItemHolderInfo m4437a(State state, ViewHolder viewHolder) {
            return m4453j().m4456a(viewHolder);
        }

        /* JADX INFO: renamed from: e */
        static int m4436e(ViewHolder viewHolder) {
            int i = viewHolder.mFlags & 14;
            if (viewHolder.isInvalid()) {
                return 4;
            }
            if ((i & 4) == 0) {
                int oldPosition = viewHolder.getOldPosition();
                int adapterPosition = viewHolder.getAdapterPosition();
                if (oldPosition != -1 && adapterPosition != -1 && oldPosition != adapterPosition) {
                    return i | 2048;
                }
                return i;
            }
            return i;
        }

        /* JADX INFO: renamed from: f */
        public final void m4447f(ViewHolder viewHolder) {
            m4449g(viewHolder);
            if (this.f4060a != null) {
                this.f4060a.mo4455a(viewHolder);
            }
        }

        /* JADX INFO: renamed from: g */
        public void m4449g(ViewHolder viewHolder) {
        }

        /* JADX INFO: renamed from: a */
        public final boolean m4440a(ItemAnimatorFinishedListener itemAnimatorFinishedListener) {
            boolean zMo4108b = mo4108b();
            if (itemAnimatorFinishedListener != null) {
                if (!zMo4108b) {
                    itemAnimatorFinishedListener.m4454a();
                } else {
                    this.f4061b.add(itemAnimatorFinishedListener);
                }
            }
            return zMo4108b;
        }

        /* JADX INFO: renamed from: h */
        public boolean mo4451h(ViewHolder viewHolder) {
            return true;
        }

        /* JADX INFO: renamed from: a */
        public boolean mo4106a(ViewHolder viewHolder, List<Object> list) {
            return mo4451h(viewHolder);
        }

        /* JADX INFO: renamed from: i */
        public final void m4452i() {
            int size = this.f4061b.size();
            for (int i = 0; i < size; i++) {
                this.f4061b.get(i).m4454a();
            }
            this.f4061b.clear();
        }

        /* JADX INFO: renamed from: j */
        public ItemHolderInfo m4453j() {
            return new ItemHolderInfo();
        }

        public static class ItemHolderInfo {

            /* JADX INFO: renamed from: a */
            public int f4066a;

            /* JADX INFO: renamed from: b */
            public int f4067b;

            /* JADX INFO: renamed from: c */
            public int f4068c;

            /* JADX INFO: renamed from: d */
            public int f4069d;

            /* JADX INFO: renamed from: a */
            public ItemHolderInfo m4456a(ViewHolder viewHolder) {
                return m4457a(viewHolder, 0);
            }

            /* JADX INFO: renamed from: a */
            public ItemHolderInfo m4457a(ViewHolder viewHolder, int i) {
                View view = viewHolder.itemView;
                this.f4066a = view.getLeft();
                this.f4067b = view.getTop();
                this.f4068c = view.getRight();
                this.f4069d = view.getBottom();
                return this;
            }
        }
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        return this.mChildDrawingOrderCallback == null ? super.getChildDrawingOrder(i, i2) : this.mChildDrawingOrderCallback.mo4434a(i, i2);
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new NestedScrollingChildHelper(this);
        }
        return this.mScrollingChildHelper;
    }
}
