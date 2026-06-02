package com.facebook.share.widget;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.FacebookCallback;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareInternalUtility;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class JoinAppGroupDialog extends FacebookDialogBase<String, JoinAppGroupDialog.Result> {
   private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.AppGroupJoin.toRequestCode();
   private static final String JOIN_GAME_GROUP_DIALOG = "game_group_join";

   @Deprecated
   public JoinAppGroupDialog(Activity var1) {
      super(var1, DEFAULT_REQUEST_CODE);
   }

   @Deprecated
   public JoinAppGroupDialog(Fragment var1) {
      this(new FragmentWrapper(var1));
   }

   @Deprecated
   public JoinAppGroupDialog(android.support.v4.app.Fragment var1) {
      this(new FragmentWrapper(var1));
   }

   private JoinAppGroupDialog(FragmentWrapper var1) {
      super(var1, DEFAULT_REQUEST_CODE);
   }

   @Deprecated
   public static boolean canShow() {
      return true;
   }

   @Deprecated
   public static void show(Activity var0, String var1) {
      new JoinAppGroupDialog(var0).show(var1);
   }

   @Deprecated
   public static void show(Fragment var0, String var1) {
      show(new FragmentWrapper(var0), var1);
   }

   @Deprecated
   public static void show(android.support.v4.app.Fragment var0, String var1) {
      show(new FragmentWrapper(var0), var1);
   }

   private static void show(FragmentWrapper var0, String var1) {
      new JoinAppGroupDialog(var0).show(var1);
   }

   @Override
   protected AppCall createBaseAppCall() {
      return new AppCall(this.getRequestCode());
   }

   @Override
   protected List<FacebookDialogBase<String, JoinAppGroupDialog.Result>.ModeHandler> getOrderedModeHandlers() {
      ArrayList var1 = new ArrayList();
      var1.add(new JoinAppGroupDialog.WebHandler(this));
      return var1;
   }

   @Override
   protected void registerCallbackImpl(CallbackManagerImpl var1, FacebookCallback<JoinAppGroupDialog.Result> var2) {
      ResultProcessor var3;
      if (var2 == null) {
         var3 = null;
      } else {
         var3 = new ResultProcessor(this, var2, var2) {
            final JoinAppGroupDialog this$0;
            final FacebookCallback val$callback;

            {
               this.this$0 = var1;
               this.val$callback = var3x;
            }

            @Override
            public void onSuccess(AppCall var1, Bundle var2x) {
               this.val$callback.onSuccess(new JoinAppGroupDialog.Result(var2x));
            }
         };
      }

      CallbackManagerImpl.Callback var4 = new CallbackManagerImpl.Callback(this, var3) {
         final JoinAppGroupDialog this$0;
         final ResultProcessor val$resultProcessor;

         {
            this.this$0 = var1;
            this.val$resultProcessor = var2x;
         }

         @Override
         public boolean onActivityResult(int var1, Intent var2x) {
            return ShareInternalUtility.handleActivityResult(this.this$0.getRequestCode(), var1, var2x, this.val$resultProcessor);
         }
      };
      var1.registerCallback(this.getRequestCode(), var4);
   }

   @Deprecated
   public static final class Result {
      private final Bundle data;

      private Result(Bundle var1) {
         this.data = var1;
      }

      public Bundle getData() {
         return this.data;
      }
   }

   private class WebHandler extends FacebookDialogBase<String, JoinAppGroupDialog.Result>.ModeHandler {
      final JoinAppGroupDialog this$0;

      private WebHandler(JoinAppGroupDialog var1) {
         super(var1);
         this.this$0 = var1;
      }

      public boolean canShow(String var1, boolean var2) {
         return true;
      }

      public AppCall createAppCall(String var1) {
         AppCall var2 = this.this$0.createBaseAppCall();
         Bundle var3 = new Bundle();
         var3.putString("id", var1);
         DialogPresenter.setupAppCallForWebDialog(var2, "game_group_join", var3);
         return var2;
      }
   }
}
