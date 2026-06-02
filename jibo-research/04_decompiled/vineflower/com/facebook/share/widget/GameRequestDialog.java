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
import com.facebook.share.internal.GameRequestValidation;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.internal.WebDialogParameters;
import com.facebook.share.model.GameRequestContent;
import java.util.ArrayList;
import java.util.List;

public class GameRequestDialog extends FacebookDialogBase<GameRequestContent, GameRequestDialog.Result> {
   private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.GameRequest.toRequestCode();
   private static final String GAME_REQUEST_DIALOG = "apprequests";

   public GameRequestDialog(Activity var1) {
      super(var1, DEFAULT_REQUEST_CODE);
   }

   public GameRequestDialog(Fragment var1) {
      this(new FragmentWrapper(var1));
   }

   public GameRequestDialog(android.support.v4.app.Fragment var1) {
      this(new FragmentWrapper(var1));
   }

   private GameRequestDialog(FragmentWrapper var1) {
      super(var1, DEFAULT_REQUEST_CODE);
   }

   public static boolean canShow() {
      return true;
   }

   public static void show(Activity var0, GameRequestContent var1) {
      new GameRequestDialog(var0).show(var1);
   }

   public static void show(Fragment var0, GameRequestContent var1) {
      show(new FragmentWrapper(var0), var1);
   }

   public static void show(android.support.v4.app.Fragment var0, GameRequestContent var1) {
      show(new FragmentWrapper(var0), var1);
   }

   private static void show(FragmentWrapper var0, GameRequestContent var1) {
      new GameRequestDialog(var0).show(var1);
   }

   @Override
   protected AppCall createBaseAppCall() {
      return new AppCall(this.getRequestCode());
   }

   @Override
   protected List<FacebookDialogBase<GameRequestContent, GameRequestDialog.Result>.ModeHandler> getOrderedModeHandlers() {
      ArrayList var1 = new ArrayList();
      var1.add(new GameRequestDialog.WebHandler(this));
      return var1;
   }

   @Override
   protected void registerCallbackImpl(CallbackManagerImpl var1, FacebookCallback<GameRequestDialog.Result> var2) {
      ResultProcessor var3;
      if (var2 == null) {
         var3 = null;
      } else {
         var3 = new ResultProcessor(this, var2, var2) {
            final GameRequestDialog this$0;
            final FacebookCallback val$callback;

            {
               this.this$0 = var1;
               this.val$callback = var3x;
            }

            @Override
            public void onSuccess(AppCall var1, Bundle var2x) {
               if (var2x != null) {
                  this.val$callback.onSuccess(new GameRequestDialog.Result(var2x));
               } else {
                  this.onCancel(var1);
               }
            }
         };
      }

      var1.registerCallback(this.getRequestCode(), new CallbackManagerImpl.Callback(this, var3) {
         final GameRequestDialog this$0;
         final ResultProcessor val$resultProcessor;

         {
            this.this$0 = var1;
            this.val$resultProcessor = var2x;
         }

         @Override
         public boolean onActivityResult(int var1, Intent var2x) {
            return ShareInternalUtility.handleActivityResult(this.this$0.getRequestCode(), var1, var2x, this.val$resultProcessor);
         }
      });
   }

   public static final class Result {
      String requestId;
      List<String> to;

      private Result(Bundle var1) {
         this.requestId = var1.getString("request");
         this.to = new ArrayList<>();

         while (var1.containsKey(String.format("to[%d]", this.to.size()))) {
            this.to.add(var1.getString(String.format("to[%d]", this.to.size())));
         }
      }

      public String getRequestId() {
         return this.requestId;
      }

      public List<String> getRequestRecipients() {
         return this.to;
      }
   }

   private class WebHandler extends FacebookDialogBase<GameRequestContent, GameRequestDialog.Result>.ModeHandler {
      final GameRequestDialog this$0;

      private WebHandler(GameRequestDialog var1) {
         super(var1);
         this.this$0 = var1;
      }

      public boolean canShow(GameRequestContent var1, boolean var2) {
         return true;
      }

      public AppCall createAppCall(GameRequestContent var1) {
         GameRequestValidation.validate(var1);
         AppCall var2 = this.this$0.createBaseAppCall();
         DialogPresenter.setupAppCallForWebDialog(var2, "apprequests", WebDialogParameters.create(var1));
         return var2;
      }
   }
}
