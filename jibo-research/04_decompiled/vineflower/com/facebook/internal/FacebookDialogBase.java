package com.facebook.internal;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookDialog;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import java.util.Iterator;
import java.util.List;

public abstract class FacebookDialogBase<CONTENT, RESULT> implements FacebookDialog<CONTENT, RESULT> {
   protected static final Object BASE_AUTOMATIC_MODE = new Object();
   private static final String TAG = "FacebookDialog";
   private final Activity activity;
   private final FragmentWrapper fragmentWrapper;
   private List<FacebookDialogBase<CONTENT, RESULT>.ModeHandler> modeHandlers;
   private int requestCode;

   protected FacebookDialogBase(Activity var1, int var2) {
      Validate.notNull(var1, "activity");
      this.activity = var1;
      this.fragmentWrapper = null;
      this.requestCode = var2;
   }

   protected FacebookDialogBase(FragmentWrapper var1, int var2) {
      Validate.notNull(var1, "fragmentWrapper");
      this.fragmentWrapper = var1;
      this.activity = null;
      this.requestCode = var2;
      if (var1.getActivity() == null) {
         throw new IllegalArgumentException("Cannot use a fragment that is not attached to an activity");
      }
   }

   private List<FacebookDialogBase<CONTENT, RESULT>.ModeHandler> cachedModeHandlers() {
      if (this.modeHandlers == null) {
         this.modeHandlers = this.getOrderedModeHandlers();
      }

      return this.modeHandlers;
   }

   private AppCall createAppCallForMode(CONTENT var1, Object var2) {
      boolean var3;
      if (var2 == BASE_AUTOMATIC_MODE) {
         var3 = true;
      } else {
         var3 = false;
      }

      Iterator var4 = this.cachedModeHandlers().iterator();

      while (true) {
         if (var4.hasNext()) {
            FacebookDialogBase.ModeHandler var5 = (FacebookDialogBase.ModeHandler)var4.next();
            if (!var3 && !Utility.areObjectsEqual(var5.getMode(), var2) || !var5.canShow((boolean)var1, true)) {
               continue;
            }

            try {
               var1 = var5.createAppCall((CONTENT)var1);
            } catch (FacebookException var6) {
               var1 = this.createBaseAppCall();
               DialogPresenter.setupAppCallForValidationError(var1, var6);
            }
            break;
         }

         var1 = null;
         break;
      }

      var2 = var1;
      if (var1 == null) {
         var2 = this.createBaseAppCall();
         DialogPresenter.setupAppCallForCannotShowError(var2);
      }

      return var2;
   }

   @Override
   public boolean canShow(CONTENT var1) {
      return this.canShowImpl((CONTENT)var1, BASE_AUTOMATIC_MODE);
   }

   protected boolean canShowImpl(CONTENT var1, Object var2) {
      boolean var4 = true;
      boolean var3;
      if (var2 == BASE_AUTOMATIC_MODE) {
         var3 = true;
      } else {
         var3 = false;
      }

      Iterator var5 = this.cachedModeHandlers().iterator();

      FacebookDialogBase.ModeHandler var6;
      do {
         if (!var5.hasNext()) {
            var4 = false;
            break;
         }

         var6 = (FacebookDialogBase.ModeHandler)var5.next();
      } while (!var3 && !Utility.areObjectsEqual(var6.getMode(), var2) || !var6.canShow((boolean)var1, false));

      return var4;
   }

   protected abstract AppCall createBaseAppCall();

   protected Activity getActivityContext() {
      Activity var1;
      if (this.activity != null) {
         var1 = this.activity;
      } else if (this.fragmentWrapper != null) {
         var1 = this.fragmentWrapper.getActivity();
      } else {
         var1 = null;
      }

      return var1;
   }

   protected abstract List<FacebookDialogBase<CONTENT, RESULT>.ModeHandler> getOrderedModeHandlers();

   public int getRequestCode() {
      return this.requestCode;
   }

   @Override
   public final void registerCallback(CallbackManager var1, FacebookCallback<RESULT> var2) {
      if (!(var1 instanceof CallbackManagerImpl)) {
         throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
      }

      this.registerCallbackImpl((CallbackManagerImpl)var1, var2);
   }

   @Override
   public final void registerCallback(CallbackManager var1, FacebookCallback<RESULT> var2, int var3) {
      this.setRequestCode(var3);
      this.registerCallback(var1, var2);
   }

   protected abstract void registerCallbackImpl(CallbackManagerImpl var1, FacebookCallback<RESULT> var2);

   protected void setRequestCode(int var1) {
      if (FacebookSdk.isFacebookRequestCode(var1)) {
         throw new IllegalArgumentException("Request code " + var1 + " cannot be within the range reserved by the Facebook SDK.");
      }

      this.requestCode = var1;
   }

   @Override
   public void show(CONTENT var1) {
      this.showImpl((CONTENT)var1, BASE_AUTOMATIC_MODE);
   }

   protected void showImpl(CONTENT var1, Object var2) {
      var1 = this.createAppCallForMode((CONTENT)var1, var2);
      if (var1 != null) {
         if (this.fragmentWrapper != null) {
            DialogPresenter.present(var1, this.fragmentWrapper);
         } else {
            DialogPresenter.present(var1, this.activity);
         }
      } else {
         Log.e("FacebookDialog", "No code path should ever result in a null appCall");
         if (FacebookSdk.isDebugEnabled()) {
            throw new IllegalStateException("No code path should ever result in a null appCall");
         }
      }
   }

   protected void startActivityForResult(Intent var1, int var2) {
      Object var3 = null;
      String var4;
      if (this.activity != null) {
         this.activity.startActivityForResult(var1, var2);
         var4 = (String)var3;
      } else if (this.fragmentWrapper != null) {
         if (this.fragmentWrapper.getNativeFragment() != null) {
            this.fragmentWrapper.getNativeFragment().startActivityForResult(var1, var2);
            var4 = (String)var3;
         } else if (this.fragmentWrapper.getSupportFragment() != null) {
            this.fragmentWrapper.getSupportFragment().startActivityForResult(var1, var2);
            var4 = (String)var3;
         } else {
            var4 = "Failed to find Activity or Fragment to startActivityForResult ";
         }
      } else {
         var4 = "Failed to find Activity or Fragment to startActivityForResult ";
      }

      if (var4 != null) {
         Logger.log(LoggingBehavior.DEVELOPER_ERRORS, 6, this.getClass().getName(), var4);
      }
   }

   protected abstract class ModeHandler {
      final FacebookDialogBase this$0;

      protected ModeHandler(FacebookDialogBase var1) {
         this.this$0 = var1;
      }

      public abstract boolean canShow(CONTENT var1, boolean var2);

      public abstract AppCall createAppCall(CONTENT var1);

      public Object getMode() {
         return FacebookDialogBase.BASE_AUTOMATIC_MODE;
      }
   }
}
