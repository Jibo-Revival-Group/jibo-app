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
import com.facebook.share.internal.WebDialogParameters;
import com.facebook.share.model.AppGroupCreationContent;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class CreateAppGroupDialog extends FacebookDialogBase<AppGroupCreationContent, CreateAppGroupDialog.Result> {
   private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.AppGroupCreate.toRequestCode();
   private static final String GAME_GROUP_CREATION_DIALOG = "game_group_create";

   @Deprecated
   public CreateAppGroupDialog(Activity var1) {
      super(var1, DEFAULT_REQUEST_CODE);
   }

   @Deprecated
   public CreateAppGroupDialog(Fragment var1) {
      this(new FragmentWrapper(var1));
   }

   @Deprecated
   public CreateAppGroupDialog(android.support.v4.app.Fragment var1) {
      this(new FragmentWrapper(var1));
   }

   private CreateAppGroupDialog(FragmentWrapper var1) {
      super(var1, DEFAULT_REQUEST_CODE);
   }

   @Deprecated
   public static boolean canShow() {
      return true;
   }

   @Deprecated
   public static void show(Activity var0, AppGroupCreationContent var1) {
      new CreateAppGroupDialog(var0).show(var1);
   }

   @Deprecated
   public static void show(Fragment var0, AppGroupCreationContent var1) {
      show(new FragmentWrapper(var0), var1);
   }

   @Deprecated
   public static void show(android.support.v4.app.Fragment var0, AppGroupCreationContent var1) {
      show(new FragmentWrapper(var0), var1);
   }

   private static void show(FragmentWrapper var0, AppGroupCreationContent var1) {
      new CreateAppGroupDialog(var0).show(var1);
   }

   @Override
   protected AppCall createBaseAppCall() {
      return new AppCall(this.getRequestCode());
   }

   @Override
   protected List<FacebookDialogBase<AppGroupCreationContent, CreateAppGroupDialog.Result>.ModeHandler> getOrderedModeHandlers() {
      ArrayList var1 = new ArrayList();
      var1.add(new CreateAppGroupDialog.WebHandler(this));
      return var1;
   }

   @Override
   protected void registerCallbackImpl(CallbackManagerImpl var1, FacebookCallback<CreateAppGroupDialog.Result> var2) {
      ResultProcessor var3;
      if (var2 == null) {
         var3 = null;
      } else {
         var3 = new ResultProcessor(this, var2, var2) {
            final CreateAppGroupDialog this$0;
            final FacebookCallback val$callback;

            {
               this.this$0 = var1;
               this.val$callback = var3x;
            }

            @Override
            public void onSuccess(AppCall var1, Bundle var2x) {
               this.val$callback.onSuccess(new CreateAppGroupDialog.Result(var2x.getString("id")));
            }
         };
      }

      CallbackManagerImpl.Callback var4 = new CallbackManagerImpl.Callback(this, var3) {
         final CreateAppGroupDialog this$0;
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
      private final String id;

      private Result(String var1) {
         this.id = var1;
      }

      public String getId() {
         return this.id;
      }
   }

   private class WebHandler extends FacebookDialogBase<AppGroupCreationContent, CreateAppGroupDialog.Result>.ModeHandler {
      final CreateAppGroupDialog this$0;

      private WebHandler(CreateAppGroupDialog var1) {
         super(var1);
         this.this$0 = var1;
      }

      public boolean canShow(AppGroupCreationContent var1, boolean var2) {
         return true;
      }

      public AppCall createAppCall(AppGroupCreationContent var1) {
         AppCall var2 = this.this$0.createBaseAppCall();
         DialogPresenter.setupAppCallForWebDialog(var2, "game_group_create", WebDialogParameters.create(var1));
         return var2;
      }
   }
}
