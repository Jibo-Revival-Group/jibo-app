package android.support.v4.app;

import android.animation.Animator;
import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.ViewModelStore;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SimpleArrayMap;
import android.support.v4.view.LayoutInflaterCompat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnCreateContextMenuListener;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

public class Fragment implements LifecycleOwner, ComponentCallbacks, OnCreateContextMenuListener {
   static final int ACTIVITY_CREATED = 2;
   static final int CREATED = 1;
   static final int INITIALIZING = 0;
   static final int RESUMED = 5;
   static final int STARTED = 4;
   static final int STOPPED = 3;
   static final Object USE_DEFAULT_TRANSITION = new Object();
   private static final SimpleArrayMap<String, Class<?>> sClassMap = new SimpleArrayMap<>();
   boolean mAdded;
   Fragment.AnimationInfo mAnimationInfo;
   Bundle mArguments;
   int mBackStackNesting;
   boolean mCalled;
   FragmentManagerImpl mChildFragmentManager;
   FragmentManagerNonConfig mChildNonConfig;
   ViewGroup mContainer;
   int mContainerId;
   boolean mDeferStart;
   boolean mDetached;
   int mFragmentId;
   FragmentManagerImpl mFragmentManager;
   boolean mFromLayout;
   boolean mHasMenu;
   boolean mHidden;
   boolean mHiddenChanged;
   FragmentHostCallback mHost;
   boolean mInLayout;
   int mIndex;
   View mInnerView;
   boolean mIsCreated;
   boolean mIsNewlyAdded;
   LayoutInflater mLayoutInflater;
   LifecycleRegistry mLifecycleRegistry;
   LoaderManagerImpl mLoaderManager;
   boolean mMenuVisible;
   Fragment mParentFragment;
   boolean mPerformedCreateView;
   float mPostponedAlpha;
   boolean mRemoving;
   boolean mRestored;
   boolean mRetainInstance;
   boolean mRetaining;
   Bundle mSavedFragmentState;
   SparseArray<Parcelable> mSavedViewState;
   int mState = 0;
   String mTag;
   Fragment mTarget;
   int mTargetIndex;
   int mTargetRequestCode;
   boolean mUserVisibleHint;
   View mView;
   ViewModelStore mViewModelStore;
   String mWho;

   public Fragment() {
      this.mIndex = -1;
      this.mTargetIndex = -1;
      this.mMenuVisible = true;
      this.mUserVisibleHint = true;
      this.mLifecycleRegistry = new LifecycleRegistry(this);
   }

   private void callStartTransitionListener() {
      Fragment.OnStartEnterTransitionListener var1 = null;
      if (this.mAnimationInfo != null) {
         this.mAnimationInfo.i = false;
         var1 = this.mAnimationInfo.j;
         this.mAnimationInfo.j = null;
      }

      if (var1 != null) {
         var1.a();
      }
   }

   private Fragment.AnimationInfo ensureAnimationInfo() {
      if (this.mAnimationInfo == null) {
         this.mAnimationInfo = new Fragment.AnimationInfo();
      }

      return this.mAnimationInfo;
   }

   public static Fragment instantiate(Context var0, String var1) {
      return instantiate(var0, var1, null);
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static Fragment instantiate(Context var0, String var1, Bundle var2) {
      Class var4;
      try {
         var4 = sClassMap.get(var1);
      } catch (ClassNotFoundException var20) {
         throw new Fragment.InstantiationException(
            "Unable to instantiate fragment " + var1 + ": make sure class name exists, is public, and has an" + " empty constructor that is public", var20
         );
      } catch (java.lang.InstantiationException var21) {
         throw new Fragment.InstantiationException(
            "Unable to instantiate fragment " + var1 + ": make sure class name exists, is public, and has an" + " empty constructor that is public", var21
         );
      } catch (IllegalAccessException var22) {
         throw new Fragment.InstantiationException(
            "Unable to instantiate fragment " + var1 + ": make sure class name exists, is public, and has an" + " empty constructor that is public", var22
         );
      } catch (NoSuchMethodException var23) {
         throw new Fragment.InstantiationException("Unable to instantiate fragment " + var1 + ": could not find Fragment constructor", var23);
      } catch (InvocationTargetException var24) {
         throw new Fragment.InstantiationException("Unable to instantiate fragment " + var1 + ": calling Fragment constructor caused an exception", var24);
      }

      Class var3 = var4;
      if (var4 == null) {
         try {
            var3 = var0.getClassLoader().loadClass(var1);
            sClassMap.put(var1, var3);
         } catch (ClassNotFoundException var15) {
            throw new Fragment.InstantiationException(
               "Unable to instantiate fragment " + var1 + ": make sure class name exists, is public, and has an" + " empty constructor that is public", var15
            );
         } catch (java.lang.InstantiationException var16) {
            throw new Fragment.InstantiationException(
               "Unable to instantiate fragment " + var1 + ": make sure class name exists, is public, and has an" + " empty constructor that is public", var16
            );
         } catch (IllegalAccessException var17) {
            throw new Fragment.InstantiationException(
               "Unable to instantiate fragment " + var1 + ": make sure class name exists, is public, and has an" + " empty constructor that is public", var17
            );
         } catch (NoSuchMethodException var18) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + var1 + ": could not find Fragment constructor", var18);
         } catch (InvocationTargetException var19) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + var1 + ": calling Fragment constructor caused an exception", var19);
         }
      }

      try {
         var25 = (Fragment)var3.getConstructor().newInstance();
      } catch (ClassNotFoundException var10) {
         throw new Fragment.InstantiationException(
            "Unable to instantiate fragment " + var1 + ": make sure class name exists, is public, and has an" + " empty constructor that is public", var10
         );
      } catch (java.lang.InstantiationException var11) {
         throw new Fragment.InstantiationException(
            "Unable to instantiate fragment " + var1 + ": make sure class name exists, is public, and has an" + " empty constructor that is public", var11
         );
      } catch (IllegalAccessException var12) {
         throw new Fragment.InstantiationException(
            "Unable to instantiate fragment " + var1 + ": make sure class name exists, is public, and has an" + " empty constructor that is public", var12
         );
      } catch (NoSuchMethodException var13) {
         throw new Fragment.InstantiationException("Unable to instantiate fragment " + var1 + ": could not find Fragment constructor", var13);
      } catch (InvocationTargetException var14) {
         throw new Fragment.InstantiationException("Unable to instantiate fragment " + var1 + ": calling Fragment constructor caused an exception", var14);
      }

      if (var2 != null) {
         try {
            var2.setClassLoader(var25.getClass().getClassLoader());
            var25.setArguments(var2);
         } catch (ClassNotFoundException var5) {
            throw new Fragment.InstantiationException(
               "Unable to instantiate fragment " + var1 + ": make sure class name exists, is public, and has an" + " empty constructor that is public", var5
            );
         } catch (java.lang.InstantiationException var6) {
            throw new Fragment.InstantiationException(
               "Unable to instantiate fragment " + var1 + ": make sure class name exists, is public, and has an" + " empty constructor that is public", var6
            );
         } catch (IllegalAccessException var7) {
            throw new Fragment.InstantiationException(
               "Unable to instantiate fragment " + var1 + ": make sure class name exists, is public, and has an" + " empty constructor that is public", var7
            );
         } catch (NoSuchMethodException var8) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + var1 + ": could not find Fragment constructor", var8);
         } catch (InvocationTargetException var9) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + var1 + ": calling Fragment constructor caused an exception", var9);
         }
      }

      return var25;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   static boolean isSupportFragmentClass(Context var0, String var1) {
      Class var4;
      try {
         var4 = sClassMap.get(var1);
      } catch (ClassNotFoundException var7) {
         return false;
      }

      Class var3 = var4;
      if (var4 == null) {
         try {
            var3 = var0.getClassLoader().loadClass(var1);
            sClassMap.put(var1, var3);
         } catch (ClassNotFoundException var6) {
            return false;
         }
      }

      boolean var2;
      try {
         var2 = Fragment.class.isAssignableFrom(var3);
      } catch (ClassNotFoundException var5) {
         var2 = false;
      }

      return var2;
   }

   public void dump(String var1, FileDescriptor var2, PrintWriter var3, String[] var4) {
      var3.print(var1);
      var3.print("mFragmentId=#");
      var3.print(Integer.toHexString(this.mFragmentId));
      var3.print(" mContainerId=#");
      var3.print(Integer.toHexString(this.mContainerId));
      var3.print(" mTag=");
      var3.println(this.mTag);
      var3.print(var1);
      var3.print("mState=");
      var3.print(this.mState);
      var3.print(" mIndex=");
      var3.print(this.mIndex);
      var3.print(" mWho=");
      var3.print(this.mWho);
      var3.print(" mBackStackNesting=");
      var3.println(this.mBackStackNesting);
      var3.print(var1);
      var3.print("mAdded=");
      var3.print(this.mAdded);
      var3.print(" mRemoving=");
      var3.print(this.mRemoving);
      var3.print(" mFromLayout=");
      var3.print(this.mFromLayout);
      var3.print(" mInLayout=");
      var3.println(this.mInLayout);
      var3.print(var1);
      var3.print("mHidden=");
      var3.print(this.mHidden);
      var3.print(" mDetached=");
      var3.print(this.mDetached);
      var3.print(" mMenuVisible=");
      var3.print(this.mMenuVisible);
      var3.print(" mHasMenu=");
      var3.println(this.mHasMenu);
      var3.print(var1);
      var3.print("mRetainInstance=");
      var3.print(this.mRetainInstance);
      var3.print(" mRetaining=");
      var3.print(this.mRetaining);
      var3.print(" mUserVisibleHint=");
      var3.println(this.mUserVisibleHint);
      if (this.mFragmentManager != null) {
         var3.print(var1);
         var3.print("mFragmentManager=");
         var3.println(this.mFragmentManager);
      }

      if (this.mHost != null) {
         var3.print(var1);
         var3.print("mHost=");
         var3.println(this.mHost);
      }

      if (this.mParentFragment != null) {
         var3.print(var1);
         var3.print("mParentFragment=");
         var3.println(this.mParentFragment);
      }

      if (this.mArguments != null) {
         var3.print(var1);
         var3.print("mArguments=");
         var3.println(this.mArguments);
      }

      if (this.mSavedFragmentState != null) {
         var3.print(var1);
         var3.print("mSavedFragmentState=");
         var3.println(this.mSavedFragmentState);
      }

      if (this.mSavedViewState != null) {
         var3.print(var1);
         var3.print("mSavedViewState=");
         var3.println(this.mSavedViewState);
      }

      if (this.mTarget != null) {
         var3.print(var1);
         var3.print("mTarget=");
         var3.print(this.mTarget);
         var3.print(" mTargetRequestCode=");
         var3.println(this.mTargetRequestCode);
      }

      if (this.getNextAnim() != 0) {
         var3.print(var1);
         var3.print("mNextAnim=");
         var3.println(this.getNextAnim());
      }

      if (this.mContainer != null) {
         var3.print(var1);
         var3.print("mContainer=");
         var3.println(this.mContainer);
      }

      if (this.mView != null) {
         var3.print(var1);
         var3.print("mView=");
         var3.println(this.mView);
      }

      if (this.mInnerView != null) {
         var3.print(var1);
         var3.print("mInnerView=");
         var3.println(this.mView);
      }

      if (this.getAnimatingAway() != null) {
         var3.print(var1);
         var3.print("mAnimatingAway=");
         var3.println(this.getAnimatingAway());
         var3.print(var1);
         var3.print("mStateAfterAnimating=");
         var3.println(this.getStateAfterAnimating());
      }

      if (this.mLoaderManager != null) {
         var3.print(var1);
         var3.println("Loader Manager:");
         this.mLoaderManager.a(var1 + "  ", var2, var3, var4);
      }

      if (this.mChildFragmentManager != null) {
         var3.print(var1);
         var3.println("Child " + this.mChildFragmentManager + ":");
         this.mChildFragmentManager.a(var1 + "  ", var2, var3, var4);
      }
   }

   @Override
   public final boolean equals(Object var1) {
      return super.equals(var1);
   }

   Fragment findFragmentByWho(String var1) {
      Fragment var2;
      if (var1.equals(this.mWho)) {
         var2 = this;
      } else if (this.mChildFragmentManager != null) {
         var2 = this.mChildFragmentManager.b(var1);
      } else {
         var2 = null;
      }

      return var2;
   }

   public final FragmentActivity getActivity() {
      FragmentActivity var1;
      if (this.mHost == null) {
         var1 = null;
      } else {
         var1 = (FragmentActivity)this.mHost.h();
      }

      return var1;
   }

   public boolean getAllowEnterTransitionOverlap() {
      boolean var1;
      if (this.mAnimationInfo != null && this.mAnimationInfo.s != null) {
         var1 = this.mAnimationInfo.s;
      } else {
         var1 = true;
      }

      return var1;
   }

   public boolean getAllowReturnTransitionOverlap() {
      boolean var1;
      if (this.mAnimationInfo != null && this.mAnimationInfo.r != null) {
         var1 = this.mAnimationInfo.r;
      } else {
         var1 = true;
      }

      return var1;
   }

   View getAnimatingAway() {
      View var1;
      if (this.mAnimationInfo == null) {
         var1 = null;
      } else {
         var1 = this.mAnimationInfo.a;
      }

      return var1;
   }

   Animator getAnimator() {
      Animator var1;
      if (this.mAnimationInfo == null) {
         var1 = null;
      } else {
         var1 = this.mAnimationInfo.b;
      }

      return var1;
   }

   public final Bundle getArguments() {
      return this.mArguments;
   }

   public final FragmentManager getChildFragmentManager() {
      if (this.mChildFragmentManager == null) {
         this.instantiateChildFragmentManager();
         if (this.mState >= 5) {
            this.mChildFragmentManager.s();
         } else if (this.mState >= 4) {
            this.mChildFragmentManager.r();
         } else if (this.mState >= 2) {
            this.mChildFragmentManager.q();
         } else if (this.mState >= 1) {
            this.mChildFragmentManager.p();
         }
      }

      return this.mChildFragmentManager;
   }

   public Context getContext() {
      Context var1;
      if (this.mHost == null) {
         var1 = null;
      } else {
         var1 = this.mHost.i();
      }

      return var1;
   }

   public Object getEnterTransition() {
      Object var1;
      if (this.mAnimationInfo == null) {
         var1 = null;
      } else {
         var1 = this.mAnimationInfo.l;
      }

      return var1;
   }

   SharedElementCallback getEnterTransitionCallback() {
      SharedElementCallback var1;
      if (this.mAnimationInfo == null) {
         var1 = null;
      } else {
         var1 = this.mAnimationInfo.g;
      }

      return var1;
   }

   public Object getExitTransition() {
      Object var1;
      if (this.mAnimationInfo == null) {
         var1 = null;
      } else {
         var1 = this.mAnimationInfo.n;
      }

      return var1;
   }

   SharedElementCallback getExitTransitionCallback() {
      SharedElementCallback var1;
      if (this.mAnimationInfo == null) {
         var1 = null;
      } else {
         var1 = this.mAnimationInfo.h;
      }

      return var1;
   }

   public final FragmentManager getFragmentManager() {
      return this.mFragmentManager;
   }

   public final Object getHost() {
      Object var1;
      if (this.mHost == null) {
         var1 = null;
      } else {
         var1 = this.mHost.g();
      }

      return var1;
   }

   public final int getId() {
      return this.mFragmentId;
   }

   public final LayoutInflater getLayoutInflater() {
      LayoutInflater var1;
      if (this.mLayoutInflater == null) {
         var1 = this.performGetLayoutInflater(null);
      } else {
         var1 = this.mLayoutInflater;
      }

      return var1;
   }

   @Deprecated
   public LayoutInflater getLayoutInflater(Bundle var1) {
      if (this.mHost == null) {
         throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
      }

      LayoutInflater var2 = this.mHost.b();
      this.getChildFragmentManager();
      LayoutInflaterCompat.b(var2, this.mChildFragmentManager.A());
      return var2;
   }

   @Override
   public Lifecycle getLifecycle() {
      return this.mLifecycleRegistry;
   }

   public LoaderManager getLoaderManager() {
      LoaderManagerImpl var1;
      if (this.mLoaderManager != null) {
         var1 = this.mLoaderManager;
      } else {
         this.mLoaderManager = new LoaderManagerImpl(this, this.getViewModelStore());
         var1 = this.mLoaderManager;
      }

      return var1;
   }

   int getNextAnim() {
      int var1;
      if (this.mAnimationInfo == null) {
         var1 = 0;
      } else {
         var1 = this.mAnimationInfo.d;
      }

      return var1;
   }

   int getNextTransition() {
      int var1;
      if (this.mAnimationInfo == null) {
         var1 = 0;
      } else {
         var1 = this.mAnimationInfo.e;
      }

      return var1;
   }

   int getNextTransitionStyle() {
      int var1;
      if (this.mAnimationInfo == null) {
         var1 = 0;
      } else {
         var1 = this.mAnimationInfo.f;
      }

      return var1;
   }

   public final Fragment getParentFragment() {
      return this.mParentFragment;
   }

   public Object getReenterTransition() {
      Object var1;
      if (this.mAnimationInfo == null) {
         var1 = null;
      } else if (this.mAnimationInfo.o == USE_DEFAULT_TRANSITION) {
         var1 = this.getExitTransition();
      } else {
         var1 = this.mAnimationInfo.o;
      }

      return var1;
   }

   public final Resources getResources() {
      return this.requireContext().getResources();
   }

   public final boolean getRetainInstance() {
      return this.mRetainInstance;
   }

   public Object getReturnTransition() {
      Object var1;
      if (this.mAnimationInfo == null) {
         var1 = null;
      } else if (this.mAnimationInfo.m == USE_DEFAULT_TRANSITION) {
         var1 = this.getEnterTransition();
      } else {
         var1 = this.mAnimationInfo.m;
      }

      return var1;
   }

   public Object getSharedElementEnterTransition() {
      Object var1;
      if (this.mAnimationInfo == null) {
         var1 = null;
      } else {
         var1 = this.mAnimationInfo.p;
      }

      return var1;
   }

   public Object getSharedElementReturnTransition() {
      Object var1;
      if (this.mAnimationInfo == null) {
         var1 = null;
      } else if (this.mAnimationInfo.q == USE_DEFAULT_TRANSITION) {
         var1 = this.getSharedElementEnterTransition();
      } else {
         var1 = this.mAnimationInfo.q;
      }

      return var1;
   }

   int getStateAfterAnimating() {
      int var1;
      if (this.mAnimationInfo == null) {
         var1 = 0;
      } else {
         var1 = this.mAnimationInfo.c;
      }

      return var1;
   }

   public final String getString(int var1) {
      return this.getResources().getString(var1);
   }

   public final String getString(int var1, Object... var2) {
      return this.getResources().getString(var1, var2);
   }

   public final String getTag() {
      return this.mTag;
   }

   public final Fragment getTargetFragment() {
      return this.mTarget;
   }

   public final int getTargetRequestCode() {
      return this.mTargetRequestCode;
   }

   public final CharSequence getText(int var1) {
      return this.getResources().getText(var1);
   }

   public boolean getUserVisibleHint() {
      return this.mUserVisibleHint;
   }

   public View getView() {
      return this.mView;
   }

   public ViewModelStore getViewModelStore() {
      if (this.getContext() == null) {
         throw new IllegalStateException("Can't access ViewModels from detached fragment");
      }

      if (this.mViewModelStore == null) {
         this.mViewModelStore = new ViewModelStore();
      }

      return this.mViewModelStore;
   }

   public final boolean hasOptionsMenu() {
      return this.mHasMenu;
   }

   @Override
   public final int hashCode() {
      return super.hashCode();
   }

   void initState() {
      this.mIndex = -1;
      this.mWho = null;
      this.mAdded = false;
      this.mRemoving = false;
      this.mFromLayout = false;
      this.mInLayout = false;
      this.mRestored = false;
      this.mBackStackNesting = 0;
      this.mFragmentManager = null;
      this.mChildFragmentManager = null;
      this.mHost = null;
      this.mFragmentId = 0;
      this.mContainerId = 0;
      this.mTag = null;
      this.mHidden = false;
      this.mDetached = false;
      this.mRetaining = false;
   }

   void instantiateChildFragmentManager() {
      if (this.mHost == null) {
         throw new IllegalStateException("Fragment has not been attached yet.");
      }

      this.mChildFragmentManager = new FragmentManagerImpl();
      this.mChildFragmentManager.a(this.mHost, new FragmentContainer(this) {
         final Fragment a;

         {
            this.a = var1;
         }

         @Override
         public Fragment a(Context var1, String var2, Bundle var3) {
            return this.a.mHost.a(var1, var2, var3);
         }

         @Override
         public View a(int var1) {
            if (this.a.mView == null) {
               throw new IllegalStateException("Fragment does not have a view");
            } else {
               return this.a.mView.findViewById(var1);
            }
         }

         @Override
         public boolean a() {
            boolean var1;
            if (this.a.mView != null) {
               var1 = true;
            } else {
               var1 = false;
            }

            return var1;
         }
      }, this);
   }

   public final boolean isAdded() {
      boolean var1;
      if (this.mHost != null && this.mAdded) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public final boolean isDetached() {
      return this.mDetached;
   }

   public final boolean isHidden() {
      return this.mHidden;
   }

   boolean isHideReplaced() {
      boolean var1;
      if (this.mAnimationInfo == null) {
         var1 = false;
      } else {
         var1 = this.mAnimationInfo.k;
      }

      return var1;
   }

   final boolean isInBackStack() {
      boolean var1;
      if (this.mBackStackNesting > 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public final boolean isInLayout() {
      return this.mInLayout;
   }

   public final boolean isMenuVisible() {
      return this.mMenuVisible;
   }

   boolean isPostponed() {
      boolean var1;
      if (this.mAnimationInfo == null) {
         var1 = false;
      } else {
         var1 = this.mAnimationInfo.i;
      }

      return var1;
   }

   public final boolean isRemoving() {
      return this.mRemoving;
   }

   public final boolean isResumed() {
      boolean var1;
      if (this.mState >= 5) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public final boolean isStateSaved() {
      boolean var1;
      if (this.mFragmentManager == null) {
         var1 = false;
      } else {
         var1 = this.mFragmentManager.g();
      }

      return var1;
   }

   public final boolean isVisible() {
      boolean var1;
      if (this.isAdded() && !this.isHidden() && this.mView != null && this.mView.getWindowToken() != null && this.mView.getVisibility() == 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   void noteStateNotSaved() {
      if (this.mChildFragmentManager != null) {
         this.mChildFragmentManager.o();
      }
   }

   public void onActivityCreated(Bundle var1) {
      this.mCalled = true;
   }

   public void onActivityResult(int var1, int var2, Intent var3) {
   }

   @Deprecated
   public void onAttach(Activity var1) {
      this.mCalled = true;
   }

   public void onAttach(Context var1) {
      this.mCalled = true;
      Activity var2;
      if (this.mHost == null) {
         var2 = null;
      } else {
         var2 = this.mHost.h();
      }

      if (var2 != null) {
         this.mCalled = false;
         this.onAttach(var2);
      }
   }

   public void onAttachFragment(Fragment var1) {
   }

   public void onConfigurationChanged(Configuration var1) {
      this.mCalled = true;
   }

   public boolean onContextItemSelected(MenuItem var1) {
      return false;
   }

   public void onCreate(Bundle var1) {
      this.mCalled = true;
      this.restoreChildFragmentState(var1);
      if (this.mChildFragmentManager != null && !this.mChildFragmentManager.c(1)) {
         this.mChildFragmentManager.p();
      }
   }

   public Animation onCreateAnimation(int var1, boolean var2, int var3) {
      return null;
   }

   public Animator onCreateAnimator(int var1, boolean var2, int var3) {
      return null;
   }

   public void onCreateContextMenu(ContextMenu var1, View var2, ContextMenuInfo var3) {
      this.getActivity().onCreateContextMenu(var1, var2, var3);
   }

   public void onCreateOptionsMenu(Menu var1, MenuInflater var2) {
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return null;
   }

   public void onDestroy() {
      this.mCalled = true;
      if (this.mViewModelStore != null && !this.mHost.d.g()) {
         this.mViewModelStore.a();
      }
   }

   public void onDestroyOptionsMenu() {
   }

   public void onDestroyView() {
      this.mCalled = true;
   }

   public void onDetach() {
      this.mCalled = true;
   }

   public LayoutInflater onGetLayoutInflater(Bundle var1) {
      return this.getLayoutInflater(var1);
   }

   public void onHiddenChanged(boolean var1) {
   }

   @Deprecated
   public void onInflate(Activity var1, AttributeSet var2, Bundle var3) {
      this.mCalled = true;
   }

   public void onInflate(Context var1, AttributeSet var2, Bundle var3) {
      this.mCalled = true;
      Activity var4;
      if (this.mHost == null) {
         var4 = null;
      } else {
         var4 = this.mHost.h();
      }

      if (var4 != null) {
         this.mCalled = false;
         this.onInflate(var4, var2, var3);
      }
   }

   public void onLowMemory() {
      this.mCalled = true;
   }

   public void onMultiWindowModeChanged(boolean var1) {
   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      return false;
   }

   public void onOptionsMenuClosed(Menu var1) {
   }

   public void onPause() {
      this.mCalled = true;
   }

   public void onPictureInPictureModeChanged(boolean var1) {
   }

   public void onPrepareOptionsMenu(Menu var1) {
   }

   public void onRequestPermissionsResult(int var1, String[] var2, int[] var3) {
   }

   public void onResume() {
      this.mCalled = true;
   }

   public void onSaveInstanceState(Bundle var1) {
   }

   public void onStart() {
      this.mCalled = true;
   }

   public void onStop() {
      this.mCalled = true;
   }

   public void onViewCreated(View var1, Bundle var2) {
   }

   public void onViewStateRestored(Bundle var1) {
      this.mCalled = true;
   }

   FragmentManager peekChildFragmentManager() {
      return this.mChildFragmentManager;
   }

   void performActivityCreated(Bundle var1) {
      if (this.mChildFragmentManager != null) {
         this.mChildFragmentManager.o();
      }

      this.mState = 2;
      this.mCalled = false;
      this.onActivityCreated(var1);
      if (!this.mCalled) {
         throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
      }

      if (this.mChildFragmentManager != null) {
         this.mChildFragmentManager.q();
      }
   }

   void performConfigurationChanged(Configuration var1) {
      this.onConfigurationChanged(var1);
      if (this.mChildFragmentManager != null) {
         this.mChildFragmentManager.a(var1);
      }
   }

   boolean performContextItemSelected(MenuItem var1) {
      boolean var2 = true;
      if (this.mHidden || !this.onContextItemSelected(var1) && (this.mChildFragmentManager == null || !this.mChildFragmentManager.b(var1))) {
         var2 = false;
      }

      return var2;
   }

   void performCreate(Bundle var1) {
      if (this.mChildFragmentManager != null) {
         this.mChildFragmentManager.o();
      }

      this.mState = 1;
      this.mCalled = false;
      this.onCreate(var1);
      this.mIsCreated = true;
      if (!this.mCalled) {
         throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
      }

      this.mLifecycleRegistry.a(Lifecycle.Event.ON_CREATE);
   }

   boolean performCreateOptionsMenu(Menu var1, MenuInflater var2) {
      boolean var4 = false;
      boolean var5 = false;
      if (!this.mHidden) {
         boolean var3 = var5;
         if (this.mHasMenu) {
            var3 = var5;
            if (this.mMenuVisible) {
               var3 = true;
               this.onCreateOptionsMenu(var1, var2);
            }
         }

         var4 = var3;
         if (this.mChildFragmentManager != null) {
            var4 = var3 | this.mChildFragmentManager.a(var1, var2);
         }
      }

      return var4;
   }

   View performCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      if (this.mChildFragmentManager != null) {
         this.mChildFragmentManager.o();
      }

      this.mPerformedCreateView = true;
      return this.onCreateView(var1, var2, var3);
   }

   void performDestroy() {
      this.mLifecycleRegistry.a(Lifecycle.Event.ON_DESTROY);
      if (this.mChildFragmentManager != null) {
         this.mChildFragmentManager.x();
      }

      this.mState = 0;
      this.mCalled = false;
      this.mIsCreated = false;
      this.onDestroy();
      if (!this.mCalled) {
         throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
      }

      this.mChildFragmentManager = null;
   }

   void performDestroyView() {
      if (this.mChildFragmentManager != null) {
         this.mChildFragmentManager.w();
      }

      this.mState = 1;
      this.mCalled = false;
      this.onDestroyView();
      if (!this.mCalled) {
         throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
      }

      if (this.mLoaderManager != null) {
         this.mLoaderManager.b();
      }

      this.mPerformedCreateView = false;
   }

   void performDetach() {
      this.mCalled = false;
      this.onDetach();
      this.mLayoutInflater = null;
      if (!this.mCalled) {
         throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDetach()");
      }

      if (this.mChildFragmentManager != null) {
         if (!this.mRetaining) {
            throw new IllegalStateException("Child FragmentManager of " + this + " was not " + " destroyed and this fragment is not retaining instance");
         }

         this.mChildFragmentManager.x();
         this.mChildFragmentManager = null;
      }
   }

   LayoutInflater performGetLayoutInflater(Bundle var1) {
      this.mLayoutInflater = this.onGetLayoutInflater(var1);
      return this.mLayoutInflater;
   }

   void performLowMemory() {
      this.onLowMemory();
      if (this.mChildFragmentManager != null) {
         this.mChildFragmentManager.y();
      }
   }

   void performMultiWindowModeChanged(boolean var1) {
      this.onMultiWindowModeChanged(var1);
      if (this.mChildFragmentManager != null) {
         this.mChildFragmentManager.a(var1);
      }
   }

   boolean performOptionsItemSelected(MenuItem var1) {
      boolean var2 = true;
      if (this.mHidden
         || (!this.mHasMenu || !this.mMenuVisible || !this.onOptionsItemSelected(var1))
            && (this.mChildFragmentManager == null || !this.mChildFragmentManager.a(var1))) {
         var2 = false;
      }

      return var2;
   }

   void performOptionsMenuClosed(Menu var1) {
      if (!this.mHidden) {
         if (this.mHasMenu && this.mMenuVisible) {
            this.onOptionsMenuClosed(var1);
         }

         if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.b(var1);
         }
      }
   }

   void performPause() {
      this.mLifecycleRegistry.a(Lifecycle.Event.ON_PAUSE);
      if (this.mChildFragmentManager != null) {
         this.mChildFragmentManager.t();
      }

      this.mState = 4;
      this.mCalled = false;
      this.onPause();
      if (!this.mCalled) {
         throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
      }
   }

   void performPictureInPictureModeChanged(boolean var1) {
      this.onPictureInPictureModeChanged(var1);
      if (this.mChildFragmentManager != null) {
         this.mChildFragmentManager.b(var1);
      }
   }

   boolean performPrepareOptionsMenu(Menu var1) {
      boolean var3 = false;
      boolean var4 = false;
      if (!this.mHidden) {
         boolean var2 = var4;
         if (this.mHasMenu) {
            var2 = var4;
            if (this.mMenuVisible) {
               var2 = true;
               this.onPrepareOptionsMenu(var1);
            }
         }

         var3 = var2;
         if (this.mChildFragmentManager != null) {
            var3 = var2 | this.mChildFragmentManager.a(var1);
         }
      }

      return var3;
   }

   void performReallyStop() {
      if (this.mChildFragmentManager != null) {
         this.mChildFragmentManager.v();
      }

      this.mState = 2;
   }

   void performResume() {
      if (this.mChildFragmentManager != null) {
         this.mChildFragmentManager.o();
         this.mChildFragmentManager.i();
      }

      this.mState = 5;
      this.mCalled = false;
      this.onResume();
      if (!this.mCalled) {
         throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
      }

      if (this.mChildFragmentManager != null) {
         this.mChildFragmentManager.s();
         this.mChildFragmentManager.i();
      }

      this.mLifecycleRegistry.a(Lifecycle.Event.ON_RESUME);
   }

   void performSaveInstanceState(Bundle var1) {
      this.onSaveInstanceState(var1);
      if (this.mChildFragmentManager != null) {
         Parcelable var2 = this.mChildFragmentManager.n();
         if (var2 != null) {
            var1.putParcelable("android:support:fragments", var2);
         }
      }
   }

   void performStart() {
      if (this.mChildFragmentManager != null) {
         this.mChildFragmentManager.o();
         this.mChildFragmentManager.i();
      }

      this.mState = 4;
      this.mCalled = false;
      this.onStart();
      if (!this.mCalled) {
         throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
      }

      if (this.mChildFragmentManager != null) {
         this.mChildFragmentManager.r();
      }

      this.mLifecycleRegistry.a(Lifecycle.Event.ON_START);
   }

   void performStop() {
      this.mLifecycleRegistry.a(Lifecycle.Event.ON_STOP);
      if (this.mChildFragmentManager != null) {
         this.mChildFragmentManager.u();
      }

      this.mState = 3;
      this.mCalled = false;
      this.onStop();
      if (!this.mCalled) {
         throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
      }
   }

   public void postponeEnterTransition() {
      this.ensureAnimationInfo().i = true;
   }

   public void registerForContextMenu(View var1) {
      var1.setOnCreateContextMenuListener(this);
   }

   public final void requestPermissions(String[] var1, int var2) {
      if (this.mHost == null) {
         throw new IllegalStateException("Fragment " + this + " not attached to Activity");
      }

      this.mHost.a(this, var1, var2);
   }

   public final FragmentActivity requireActivity() {
      FragmentActivity var1 = this.getActivity();
      if (var1 == null) {
         throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
      } else {
         return var1;
      }
   }

   public final Context requireContext() {
      Context var1 = this.getContext();
      if (var1 == null) {
         throw new IllegalStateException("Fragment " + this + " not attached to a context.");
      } else {
         return var1;
      }
   }

   public final FragmentManager requireFragmentManager() {
      FragmentManager var1 = this.getFragmentManager();
      if (var1 == null) {
         throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
      } else {
         return var1;
      }
   }

   public final Object requireHost() {
      Object var1 = this.getHost();
      if (var1 == null) {
         throw new IllegalStateException("Fragment " + this + " not attached to a host.");
      } else {
         return var1;
      }
   }

   void restoreChildFragmentState(Bundle var1) {
      if (var1 != null) {
         Parcelable var2 = var1.getParcelable("android:support:fragments");
         if (var2 != null) {
            if (this.mChildFragmentManager == null) {
               this.instantiateChildFragmentManager();
            }

            this.mChildFragmentManager.a(var2, this.mChildNonConfig);
            this.mChildNonConfig = null;
            this.mChildFragmentManager.p();
         }
      }
   }

   final void restoreViewState(Bundle var1) {
      if (this.mSavedViewState != null) {
         this.mInnerView.restoreHierarchyState(this.mSavedViewState);
         this.mSavedViewState = null;
      }

      this.mCalled = false;
      this.onViewStateRestored(var1);
      if (!this.mCalled) {
         throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
      }
   }

   public void setAllowEnterTransitionOverlap(boolean var1) {
      this.ensureAnimationInfo().s = var1;
   }

   public void setAllowReturnTransitionOverlap(boolean var1) {
      this.ensureAnimationInfo().r = var1;
   }

   void setAnimatingAway(View var1) {
      this.ensureAnimationInfo().a = var1;
   }

   void setAnimator(Animator var1) {
      this.ensureAnimationInfo().b = var1;
   }

   public void setArguments(Bundle var1) {
      if (this.mIndex >= 0 && this.isStateSaved()) {
         throw new IllegalStateException("Fragment already active and state has been saved");
      }

      this.mArguments = var1;
   }

   public void setEnterSharedElementCallback(SharedElementCallback var1) {
      this.ensureAnimationInfo().g = var1;
   }

   public void setEnterTransition(Object var1) {
      this.ensureAnimationInfo().l = var1;
   }

   public void setExitSharedElementCallback(SharedElementCallback var1) {
      this.ensureAnimationInfo().h = var1;
   }

   public void setExitTransition(Object var1) {
      this.ensureAnimationInfo().n = var1;
   }

   public void setHasOptionsMenu(boolean var1) {
      if (this.mHasMenu != var1) {
         this.mHasMenu = var1;
         if (this.isAdded() && !this.isHidden()) {
            this.mHost.d();
         }
      }
   }

   void setHideReplaced(boolean var1) {
      this.ensureAnimationInfo().k = var1;
   }

   final void setIndex(int var1, Fragment var2) {
      this.mIndex = var1;
      if (var2 != null) {
         this.mWho = var2.mWho + ":" + this.mIndex;
      } else {
         this.mWho = "android:fragment:" + this.mIndex;
      }
   }

   public void setInitialSavedState(Fragment.SavedState var1) {
      if (this.mIndex >= 0) {
         throw new IllegalStateException("Fragment already active");
      }

      Bundle var2;
      if (var1 != null && var1.a != null) {
         var2 = var1.a;
      } else {
         var2 = null;
      }

      this.mSavedFragmentState = var2;
   }

   public void setMenuVisibility(boolean var1) {
      if (this.mMenuVisible != var1) {
         this.mMenuVisible = var1;
         if (this.mHasMenu && this.isAdded() && !this.isHidden()) {
            this.mHost.d();
         }
      }
   }

   void setNextAnim(int var1) {
      if (this.mAnimationInfo != null || var1 != 0) {
         this.ensureAnimationInfo().d = var1;
      }
   }

   void setNextTransition(int var1, int var2) {
      if (this.mAnimationInfo != null || var1 != 0 || var2 != 0) {
         this.ensureAnimationInfo();
         this.mAnimationInfo.e = var1;
         this.mAnimationInfo.f = var2;
      }
   }

   void setOnStartEnterTransitionListener(Fragment.OnStartEnterTransitionListener var1) {
      this.ensureAnimationInfo();
      if (var1 != this.mAnimationInfo.j) {
         if (var1 != null && this.mAnimationInfo.j != null) {
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
         }

         if (this.mAnimationInfo.i) {
            this.mAnimationInfo.j = var1;
         }

         if (var1 != null) {
            var1.b();
         }
      }
   }

   public void setReenterTransition(Object var1) {
      this.ensureAnimationInfo().o = var1;
   }

   public void setRetainInstance(boolean var1) {
      this.mRetainInstance = var1;
   }

   public void setReturnTransition(Object var1) {
      this.ensureAnimationInfo().m = var1;
   }

   public void setSharedElementEnterTransition(Object var1) {
      this.ensureAnimationInfo().p = var1;
   }

   public void setSharedElementReturnTransition(Object var1) {
      this.ensureAnimationInfo().q = var1;
   }

   void setStateAfterAnimating(int var1) {
      this.ensureAnimationInfo().c = var1;
   }

   public void setTargetFragment(Fragment var1, int var2) {
      FragmentManager var4 = this.getFragmentManager();
      FragmentManager var3;
      if (var1 != null) {
         var3 = var1.getFragmentManager();
      } else {
         var3 = null;
      }

      if (var4 != null && var3 != null && var4 != var3) {
         throw new IllegalArgumentException("Fragment " + var1 + " must share the same FragmentManager to be set as a target fragment");
      }

      for (Fragment var5 = var1; var5 != null; var5 = var5.getTargetFragment()) {
         if (var5 == this) {
            throw new IllegalArgumentException("Setting " + var1 + " as the target of " + this + " would create a target cycle");
         }
      }

      this.mTarget = var1;
      this.mTargetRequestCode = var2;
   }

   public void setUserVisibleHint(boolean var1) {
      if (!this.mUserVisibleHint && var1 && this.mState < 4 && this.mFragmentManager != null && this.isAdded()) {
         this.mFragmentManager.b(this);
      }

      this.mUserVisibleHint = var1;
      if (this.mState < 4 && !var1) {
         var1 = true;
      } else {
         var1 = false;
      }

      this.mDeferStart = var1;
      if (this.mSavedFragmentState != null) {
         this.mSavedFragmentState.putBoolean("android:user_visible_hint", this.mUserVisibleHint);
      }
   }

   public boolean shouldShowRequestPermissionRationale(String var1) {
      boolean var2;
      if (this.mHost != null) {
         var2 = this.mHost.a(var1);
      } else {
         var2 = false;
      }

      return var2;
   }

   public void startActivity(Intent var1) {
      this.startActivity(var1, null);
   }

   public void startActivity(Intent var1, Bundle var2) {
      if (this.mHost == null) {
         throw new IllegalStateException("Fragment " + this + " not attached to Activity");
      }

      this.mHost.a(this, var1, -1, var2);
   }

   public void startActivityForResult(Intent var1, int var2) {
      this.startActivityForResult(var1, var2, null);
   }

   public void startActivityForResult(Intent var1, int var2, Bundle var3) {
      if (this.mHost == null) {
         throw new IllegalStateException("Fragment " + this + " not attached to Activity");
      }

      this.mHost.a(this, var1, var2, var3);
   }

   public void startIntentSenderForResult(IntentSender var1, int var2, Intent var3, int var4, int var5, int var6, Bundle var7) throws SendIntentException {
      if (this.mHost == null) {
         throw new IllegalStateException("Fragment " + this + " not attached to Activity");
      }

      this.mHost.a(this, var1, var2, var3, var4, var5, var6, var7);
   }

   public void startPostponedEnterTransition() {
      if (this.mFragmentManager != null && this.mFragmentManager.m != null) {
         if (Looper.myLooper() != this.mFragmentManager.m.j().getLooper()) {
            this.mFragmentManager.m.j().postAtFrontOfQueue(new Runnable(this) {
               final Fragment a;

               {
                  this.a = var1;
               }

               @Override
               public void run() {
                  this.a.callStartTransitionListener();
               }
            });
         } else {
            this.callStartTransitionListener();
         }
      } else {
         this.ensureAnimationInfo().i = false;
      }
   }

   @Override
   public String toString() {
      StringBuilder var1 = new StringBuilder(128);
      DebugUtils.a(this, var1);
      if (this.mIndex >= 0) {
         var1.append(" #");
         var1.append(this.mIndex);
      }

      if (this.mFragmentId != 0) {
         var1.append(" id=0x");
         var1.append(Integer.toHexString(this.mFragmentId));
      }

      if (this.mTag != null) {
         var1.append(" ");
         var1.append(this.mTag);
      }

      var1.append('}');
      return var1.toString();
   }

   public void unregisterForContextMenu(View var1) {
      var1.setOnCreateContextMenuListener(null);
   }

   static class AnimationInfo {
      View a;
      Animator b;
      int c;
      int d;
      int e;
      int f;
      SharedElementCallback g;
      SharedElementCallback h;
      boolean i;
      Fragment.OnStartEnterTransitionListener j;
      boolean k;
      private Object l = null;
      private Object m = Fragment.USE_DEFAULT_TRANSITION;
      private Object n = null;
      private Object o = Fragment.USE_DEFAULT_TRANSITION;
      private Object p = null;
      private Object q = Fragment.USE_DEFAULT_TRANSITION;
      private Boolean r;
      private Boolean s;

      AnimationInfo() {
         this.g = null;
         this.h = null;
      }
   }

   public static class InstantiationException extends RuntimeException {
      public InstantiationException(String var1, Exception var2) {
         super(var1, var2);
      }
   }

   interface OnStartEnterTransitionListener {
      void a();

      void b();
   }

   public static class SavedState implements Parcelable {
      public static final Creator<Fragment.SavedState> CREATOR = new Creator<Fragment.SavedState>() {
         public Fragment.SavedState a(Parcel var1) {
            return new Fragment.SavedState(var1, null);
         }

         public Fragment.SavedState[] a(int var1) {
            return new Fragment.SavedState[var1];
         }
      };
      final Bundle a;

      SavedState(Bundle var1) {
         this.a = var1;
      }

      SavedState(Parcel var1, ClassLoader var2) {
         this.a = var1.readBundle();
         if (var2 != null && this.a != null) {
            this.a.setClassLoader(var2);
         }
      }

      public int describeContents() {
         return 0;
      }

      public void writeToParcel(Parcel var1, int var2) {
         var1.writeBundle(this.a);
      }
   }
}
