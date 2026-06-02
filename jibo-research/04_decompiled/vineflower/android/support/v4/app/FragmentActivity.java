package android.support.v4.app;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.ViewModelStore;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.support.v4.util.SparseArrayCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Iterator;

public class FragmentActivity
   extends BaseFragmentActivityApi16
   implements ActivityCompat.OnRequestPermissionsResultCallback,
   ActivityCompat.RequestPermissionsRequestCodeValidator {
   static final String ALLOCATED_REQUEST_INDICIES_TAG = "android:support:request_indicies";
   static final String FRAGMENTS_TAG = "android:support:fragments";
   static final int MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS = 65534;
   static final int MSG_REALLY_STOPPED = 1;
   static final int MSG_RESUME_PENDING = 2;
   static final String NEXT_CANDIDATE_REQUEST_INDEX_TAG = "android:support:next_request_index";
   static final String REQUEST_FRAGMENT_WHO_TAG = "android:support:request_fragment_who";
   private static final String TAG = "FragmentActivity";
   boolean mCreated;
   final FragmentController mFragments;
   final Handler mHandler = new Handler(this) {
      final FragmentActivity a;

      {
         this.a = var1;
      }

      public void handleMessage(Message var1) {
         switch (var1.what) {
            case 1:
               if (this.a.mStopped) {
                  this.a.doReallyStop(false);
               }
               break;
            case 2:
               this.a.onResumeFragments();
               this.a.mFragments.n();
               break;
            default:
               super.handleMessage(var1);
         }
      }
   };
   LoaderManager mLoaderManager;
   int mNextCandidateRequestIndex;
   SparseArrayCompat<String> mPendingFragmentActivityResults;
   boolean mReallyStopped;
   boolean mRequestedPermissionsFromFragment;
   boolean mResumed;
   boolean mRetaining;
   boolean mStopped;
   private ViewModelStore mViewModelStore;

   public FragmentActivity() {
      this.mFragments = FragmentController.a(new FragmentActivity.HostCallbacks(this));
      this.mStopped = true;
      this.mReallyStopped = true;
   }

   private int allocateRequestIndex(Fragment var1) {
      if (this.mPendingFragmentActivityResults.b() >= 65534) {
         throw new IllegalStateException("Too many pending Fragment activity results.");
      }

      while (this.mPendingFragmentActivityResults.f(this.mNextCandidateRequestIndex) >= 0) {
         this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % 65534;
      }

      int var2 = this.mNextCandidateRequestIndex;
      this.mPendingFragmentActivityResults.b(var2, var1.mWho);
      this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % 65534;
      return var2;
   }

   private void markFragmentsCreated() {
      while (markState(this.getSupportFragmentManager(), Lifecycle.State.CREATED)) {
      }
   }

   private static boolean markState(FragmentManager var0, Lifecycle.State var1) {
      Iterator var4 = var0.f().iterator();
      boolean var2 = false;

      while (var4.hasNext()) {
         Fragment var3 = (Fragment)var4.next();
         if (var3 != null) {
            if (var3.getLifecycle().a().isAtLeast(Lifecycle.State.STARTED)) {
               var3.mLifecycleRegistry.a(var1);
               var2 = true;
            }

            FragmentManager var5 = var3.peekChildFragmentManager();
            if (var5 != null) {
               var2 |= markState(var5, var1);
            }
         }
      }

      return var2;
   }

   @Override
   final View dispatchFragmentsOnCreateView(View var1, String var2, Context var3, AttributeSet var4) {
      return this.mFragments.a(var1, var2, var3, var4);
   }

   void doReallyStop(boolean var1) {
      if (!this.mReallyStopped) {
         this.mReallyStopped = true;
         this.mRetaining = var1;
         this.mHandler.removeMessages(1);
         this.onReallyStop();
      }
   }

   public void dump(String var1, FileDescriptor var2, PrintWriter var3, String[] var4) {
      super.dump(var1, var2, var3, var4);
      var3.print(var1);
      var3.print("Local FragmentActivity ");
      var3.print(Integer.toHexString(System.identityHashCode(this)));
      var3.println(" State:");
      String var5 = var1 + "  ";
      var3.print(var5);
      var3.print("mCreated=");
      var3.print(this.mCreated);
      var3.print("mResumed=");
      var3.print(this.mResumed);
      var3.print(" mStopped=");
      var3.print(this.mStopped);
      var3.print(" mReallyStopped=");
      var3.println(this.mReallyStopped);
      if (this.mLoaderManager != null) {
         this.mLoaderManager.a(var5, var2, var3, var4);
      }

      this.mFragments.a().a(var1, var2, var3, var4);
   }

   public Object getLastCustomNonConfigurationInstance() {
      FragmentActivity.NonConfigurationInstances var1 = (FragmentActivity.NonConfigurationInstances)this.getLastNonConfigurationInstance();
      Object var2;
      if (var1 != null) {
         var2 = var1.a;
      } else {
         var2 = null;
      }

      return var2;
   }

   @Override
   public Lifecycle getLifecycle() {
      return super.getLifecycle();
   }

   public FragmentManager getSupportFragmentManager() {
      return this.mFragments.a();
   }

   public LoaderManager getSupportLoaderManager() {
      LoaderManager var1;
      if (this.mLoaderManager != null) {
         var1 = this.mLoaderManager;
      } else {
         this.mLoaderManager = new LoaderManagerImpl(this, this.getViewModelStore());
         var1 = this.mLoaderManager;
      }

      return var1;
   }

   public ViewModelStore getViewModelStore() {
      if (this.getApplication() == null) {
         throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
      }

      if (this.mViewModelStore == null) {
         this.mViewModelStore = new ViewModelStore();
      }

      return this.mViewModelStore;
   }

   protected void onActivityResult(int var1, int var2, Intent var3) {
      this.mFragments.b();
      int var4 = var1 >> 16;
      if (var4 != 0) {
         String var5 = this.mPendingFragmentActivityResults.a(--var4);
         this.mPendingFragmentActivityResults.c(var4);
         if (var5 == null) {
            Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
         } else {
            Fragment var6 = this.mFragments.a(var5);
            if (var6 == null) {
               Log.w("FragmentActivity", "Activity result no fragment exists for who: " + var5);
            } else {
               var6.onActivityResult(65535 & var1, var2, var3);
            }
         }
      } else {
         ActivityCompat.PermissionCompatDelegate var8 = ActivityCompat.a();
         if (var8 == null || !var8.a(this, var1, var2, var3)) {
            super.onActivityResult(var1, var2, var3);
         }
      }
   }

   public void onAttachFragment(Fragment var1) {
   }

   public void onBackPressed() {
      FragmentManager var2 = this.mFragments.a();
      boolean var1 = var2.g();
      if ((!var1 || VERSION.SDK_INT > 25) && (var1 || !var2.d())) {
         super.onBackPressed();
      }
   }

   public void onConfigurationChanged(Configuration var1) {
      super.onConfigurationChanged(var1);
      this.mFragments.b();
      this.mFragments.a(var1);
   }

   @Override
   protected void onCreate(Bundle var1) {
      this.mFragments.a((Fragment)null);
      super.onCreate(var1);
      FragmentActivity.NonConfigurationInstances var3 = (FragmentActivity.NonConfigurationInstances)this.getLastNonConfigurationInstance();
      if (var3 != null) {
         this.mViewModelStore = var3.b;
      }

      if (var1 != null) {
         Parcelable var5 = var1.getParcelable("android:support:fragments");
         FragmentController var4 = this.mFragments;
         FragmentManagerNonConfig var7;
         if (var3 != null) {
            var7 = var3.c;
         } else {
            var7 = null;
         }

         var4.a(var5, var7);
         if (var1.containsKey("android:support:next_request_index")) {
            this.mNextCandidateRequestIndex = var1.getInt("android:support:next_request_index");
            int[] var8 = var1.getIntArray("android:support:request_indicies");
            String[] var6 = var1.getStringArray("android:support:request_fragment_who");
            if (var8 != null && var6 != null && var8.length == var6.length) {
               this.mPendingFragmentActivityResults = new SparseArrayCompat<>(var8.length);

               for (int var2 = 0; var2 < var8.length; var2++) {
                  this.mPendingFragmentActivityResults.b(var8[var2], var6[var2]);
               }
            } else {
               Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
            }
         }
      }

      if (this.mPendingFragmentActivityResults == null) {
         this.mPendingFragmentActivityResults = new SparseArrayCompat<>();
         this.mNextCandidateRequestIndex = 0;
      }

      this.mFragments.e();
   }

   public boolean onCreatePanelMenu(int var1, Menu var2) {
      boolean var3;
      if (var1 == 0) {
         var3 = super.onCreatePanelMenu(var1, var2) | this.mFragments.a(var2, this.getMenuInflater());
      } else {
         var3 = super.onCreatePanelMenu(var1, var2);
      }

      return var3;
   }

   protected void onDestroy() {
      super.onDestroy();
      this.doReallyStop(false);
      if (this.mViewModelStore != null && !this.mRetaining) {
         this.mViewModelStore.a();
      }

      this.mFragments.l();
   }

   public void onLowMemory() {
      super.onLowMemory();
      this.mFragments.m();
   }

   public boolean onMenuItemSelected(int var1, MenuItem var2) {
      boolean var3;
      if (super.onMenuItemSelected(var1, var2)) {
         var3 = true;
      } else {
         switch (var1) {
            case 0:
               var3 = this.mFragments.a(var2);
               break;
            case 6:
               var3 = this.mFragments.b(var2);
               break;
            default:
               var3 = false;
         }
      }

      return var3;
   }

   public void onMultiWindowModeChanged(boolean var1) {
      this.mFragments.a(var1);
   }

   protected void onNewIntent(Intent var1) {
      super.onNewIntent(var1);
      this.mFragments.b();
   }

   public void onPanelClosed(int var1, Menu var2) {
      switch (var1) {
         case 0:
            this.mFragments.b(var2);
         default:
            super.onPanelClosed(var1, var2);
      }
   }

   protected void onPause() {
      super.onPause();
      this.mResumed = false;
      if (this.mHandler.hasMessages(2)) {
         this.mHandler.removeMessages(2);
         this.onResumeFragments();
      }

      this.mFragments.i();
   }

   public void onPictureInPictureModeChanged(boolean var1) {
      this.mFragments.b(var1);
   }

   protected void onPostResume() {
      super.onPostResume();
      this.mHandler.removeMessages(2);
      this.onResumeFragments();
      this.mFragments.n();
   }

   protected boolean onPrepareOptionsPanel(View var1, Menu var2) {
      return super.onPreparePanel(0, var1, var2);
   }

   public boolean onPreparePanel(int var1, View var2, Menu var3) {
      boolean var4;
      if (var1 == 0 && var3 != null) {
         var4 = this.onPrepareOptionsPanel(var2, var3) | this.mFragments.a(var3);
      } else {
         var4 = super.onPreparePanel(var1, var2, var3);
      }

      return var4;
   }

   void onReallyStop() {
      this.mFragments.k();
   }

   @Override
   public void onRequestPermissionsResult(int var1, String[] var2, int[] var3) {
      this.mFragments.b();
      int var4 = var1 >> 16 & 65535;
      if (var4 != 0) {
         String var5 = this.mPendingFragmentActivityResults.a(--var4);
         this.mPendingFragmentActivityResults.c(var4);
         if (var5 == null) {
            Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
         } else {
            Fragment var6 = this.mFragments.a(var5);
            if (var6 == null) {
               Log.w("FragmentActivity", "Activity result no fragment exists for who: " + var5);
            } else {
               var6.onRequestPermissionsResult(var1 & 65535, var2, var3);
            }
         }
      }
   }

   protected void onResume() {
      super.onResume();
      this.mHandler.sendEmptyMessage(2);
      this.mResumed = true;
      this.mFragments.n();
   }

   protected void onResumeFragments() {
      this.mFragments.h();
   }

   public Object onRetainCustomNonConfigurationInstance() {
      return null;
   }

   public final Object onRetainNonConfigurationInstance() {
      if (this.mStopped) {
         this.doReallyStop(true);
      }

      Object var2 = this.onRetainCustomNonConfigurationInstance();
      FragmentManagerNonConfig var3 = this.mFragments.d();
      FragmentActivity.NonConfigurationInstances var1;
      if (var3 == null && this.mViewModelStore == null && var2 == null) {
         var1 = null;
      } else {
         var1 = new FragmentActivity.NonConfigurationInstances();
         var1.a = var2;
         var1.b = this.mViewModelStore;
         var1.c = var3;
      }

      return var1;
   }

   @Override
   protected void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      this.markFragmentsCreated();
      Parcelable var3 = this.mFragments.c();
      if (var3 != null) {
         var1.putParcelable("android:support:fragments", var3);
      }

      if (this.mPendingFragmentActivityResults.b() > 0) {
         var1.putInt("android:support:next_request_index", this.mNextCandidateRequestIndex);
         int[] var5 = new int[this.mPendingFragmentActivityResults.b()];
         String[] var4 = new String[this.mPendingFragmentActivityResults.b()];

         for (int var2 = 0; var2 < this.mPendingFragmentActivityResults.b(); var2++) {
            var5[var2] = this.mPendingFragmentActivityResults.d(var2);
            var4[var2] = this.mPendingFragmentActivityResults.e(var2);
         }

         var1.putIntArray("android:support:request_indicies", var5);
         var1.putStringArray("android:support:request_fragment_who", var4);
      }
   }

   protected void onStart() {
      super.onStart();
      this.mStopped = false;
      this.mReallyStopped = false;
      this.mHandler.removeMessages(1);
      if (!this.mCreated) {
         this.mCreated = true;
         this.mFragments.f();
      }

      this.mFragments.b();
      this.mFragments.n();
      this.mFragments.g();
   }

   public void onStateNotSaved() {
      this.mFragments.b();
   }

   protected void onStop() {
      super.onStop();
      this.mStopped = true;
      this.markFragmentsCreated();
      this.mHandler.sendEmptyMessage(1);
      this.mFragments.j();
   }

   void requestPermissionsFromFragment(Fragment var1, String[] var2, int var3) {
      if (var3 == -1) {
         ActivityCompat.a(this, var2, var3);
      } else {
         checkForValidRequestCode(var3);

         try {
            this.mRequestedPermissionsFromFragment = true;
            ActivityCompat.a(this, var2, (this.allocateRequestIndex(var1) + 1 << 16) + (65535 & var3));
         } finally {
            this.mRequestedPermissionsFromFragment = false;
         }
      }
   }

   public void setEnterSharedElementCallback(SharedElementCallback var1) {
      ActivityCompat.a(this, var1);
   }

   public void setExitSharedElementCallback(SharedElementCallback var1) {
      ActivityCompat.b(this, var1);
   }

   public void startActivityForResult(Intent var1, int var2) {
      if (!this.mStartedActivityFromFragment && var2 != -1) {
         checkForValidRequestCode(var2);
      }

      super.startActivityForResult(var1, var2);
   }

   public void startActivityFromFragment(Fragment var1, Intent var2, int var3) {
      this.startActivityFromFragment(var1, var2, var3, null);
   }

   public void startActivityFromFragment(Fragment param1, Intent param2, int param3, Bundle param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1065)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:566)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: bipush 1
      // 02: putfield android/support/v4/app/FragmentActivity.mStartedActivityFromFragment Z
      // 05: iload 3
      // 06: bipush -1
      // 07: if_icmpne 18
      // 0a: aload 0
      // 0b: aload 2
      // 0c: bipush -1
      // 0d: aload 4
      // 0f: invokestatic android/support/v4/app/ActivityCompat.a (Landroid/app/Activity;Landroid/content/Intent;ILandroid/os/Bundle;)V
      // 12: aload 0
      // 13: bipush 0
      // 14: putfield android/support/v4/app/FragmentActivity.mStartedActivityFromFragment Z
      // 17: return
      // 18: iload 3
      // 19: invokestatic android/support/v4/app/FragmentActivity.checkForValidRequestCode (I)V
      // 1c: aload 0
      // 1d: aload 2
      // 1e: aload 0
      // 1f: aload 1
      // 20: invokespecial android/support/v4/app/FragmentActivity.allocateRequestIndex (Landroid/support/v4/app/Fragment;)I
      // 23: bipush 1
      // 24: iadd
      // 25: bipush 16
      // 27: ishl
      // 28: ldc_w 65535
      // 2b: iload 3
      // 2c: iand
      // 2d: iadd
      // 2e: aload 4
      // 30: invokestatic android/support/v4/app/ActivityCompat.a (Landroid/app/Activity;Landroid/content/Intent;ILandroid/os/Bundle;)V
      // 33: aload 0
      // 34: bipush 0
      // 35: putfield android/support/v4/app/FragmentActivity.mStartedActivityFromFragment Z
      // 38: goto 17
      // 3b: astore 1
      // 3c: aload 0
      // 3d: bipush 0
      // 3e: putfield android/support/v4/app/FragmentActivity.mStartedActivityFromFragment Z
      // 41: aload 1
      // 42: athrow
      // try (6 -> 11): 36 null
      // try (15 -> 32): 36 null
   }

   public void startIntentSenderFromFragment(Fragment param1, IntentSender param2, int param3, Intent param4, int param5, int param6, int param7, Bundle param8) throws SendIntentException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1065)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:566)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: bipush 1
      // 02: putfield android/support/v4/app/FragmentActivity.mStartedIntentSenderFromFragment Z
      // 05: iload 3
      // 06: bipush -1
      // 07: if_icmpne 20
      // 0a: aload 0
      // 0b: aload 2
      // 0c: iload 3
      // 0d: aload 4
      // 0f: iload 5
      // 11: iload 6
      // 13: iload 7
      // 15: aload 8
      // 17: invokestatic android/support/v4/app/ActivityCompat.a (Landroid/app/Activity;Landroid/content/IntentSender;ILandroid/content/Intent;IIILandroid/os/Bundle;)V
      // 1a: aload 0
      // 1b: bipush 0
      // 1c: putfield android/support/v4/app/FragmentActivity.mStartedIntentSenderFromFragment Z
      // 1f: return
      // 20: iload 3
      // 21: invokestatic android/support/v4/app/FragmentActivity.checkForValidRequestCode (I)V
      // 24: aload 0
      // 25: aload 2
      // 26: aload 0
      // 27: aload 1
      // 28: invokespecial android/support/v4/app/FragmentActivity.allocateRequestIndex (Landroid/support/v4/app/Fragment;)I
      // 2b: bipush 1
      // 2c: iadd
      // 2d: bipush 16
      // 2f: ishl
      // 30: ldc_w 65535
      // 33: iload 3
      // 34: iand
      // 35: iadd
      // 36: aload 4
      // 38: iload 5
      // 3a: iload 6
      // 3c: iload 7
      // 3e: aload 8
      // 40: invokestatic android/support/v4/app/ActivityCompat.a (Landroid/app/Activity;Landroid/content/IntentSender;ILandroid/content/Intent;IIILandroid/os/Bundle;)V
      // 43: aload 0
      // 44: bipush 0
      // 45: putfield android/support/v4/app/FragmentActivity.mStartedIntentSenderFromFragment Z
      // 48: goto 1f
      // 4b: astore 1
      // 4c: aload 0
      // 4d: bipush 0
      // 4e: putfield android/support/v4/app/FragmentActivity.mStartedIntentSenderFromFragment Z
      // 51: aload 1
      // 52: athrow
      // try (6 -> 15): 44 null
      // try (19 -> 40): 44 null
   }

   public void supportFinishAfterTransition() {
      ActivityCompat.b(this);
   }

   @Deprecated
   public void supportInvalidateOptionsMenu() {
      this.invalidateOptionsMenu();
   }

   public void supportPostponeEnterTransition() {
      ActivityCompat.c(this);
   }

   public void supportStartPostponedEnterTransition() {
      ActivityCompat.d(this);
   }

   @Override
   public final void validateRequestPermissionsRequestCode(int var1) {
      if (!this.mRequestedPermissionsFromFragment && var1 != -1) {
         checkForValidRequestCode(var1);
      }
   }

   class HostCallbacks extends FragmentHostCallback<FragmentActivity> {
      final FragmentActivity a;

      public HostCallbacks(FragmentActivity var1) {
         super(var1);
         this.a = var1;
      }

      @Override
      public View a(int var1) {
         return this.a.findViewById(var1);
      }

      @Override
      public void a(Fragment var1, Intent var2, int var3, Bundle var4) {
         this.a.startActivityFromFragment(var1, var2, var3, var4);
      }

      @Override
      public void a(Fragment var1, IntentSender var2, int var3, Intent var4, int var5, int var6, int var7, Bundle var8) throws SendIntentException {
         this.a.startIntentSenderFromFragment(var1, var2, var3, var4, var5, var6, var7, var8);
      }

      @Override
      public void a(Fragment var1, String[] var2, int var3) {
         this.a.requestPermissionsFromFragment(var1, var2, var3);
      }

      @Override
      public void a(String var1, FileDescriptor var2, PrintWriter var3, String[] var4) {
         this.a.dump(var1, var2, var3, var4);
      }

      @Override
      public boolean a() {
         Window var2 = this.a.getWindow();
         boolean var1;
         if (var2 != null && var2.peekDecorView() != null) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      @Override
      public boolean a(Fragment var1) {
         boolean var2;
         if (!this.a.isFinishing()) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }

      @Override
      public boolean a(String var1) {
         return ActivityCompat.a(this.a, var1);
      }

      @Override
      public LayoutInflater b() {
         return this.a.getLayoutInflater().cloneInContext(this.a);
      }

      @Override
      public void b(Fragment var1) {
         this.a.onAttachFragment(var1);
      }

      public FragmentActivity c() {
         return this.a;
      }

      @Override
      public void d() {
         this.a.supportInvalidateOptionsMenu();
      }

      @Override
      public boolean e() {
         boolean var1;
         if (this.a.getWindow() != null) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      @Override
      public int f() {
         Window var2 = this.a.getWindow();
         int var1;
         if (var2 == null) {
            var1 = 0;
         } else {
            var1 = var2.getAttributes().windowAnimations;
         }

         return var1;
      }
   }

   static final class NonConfigurationInstances {
      Object a;
      ViewModelStore b;
      FragmentManagerNonConfig c;
   }
}
