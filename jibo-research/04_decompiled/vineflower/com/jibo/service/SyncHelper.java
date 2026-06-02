package com.jibo.service;

import android.content.Context;
import android.content.Intent;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.Trigger;
import com.jibo.JiboApplication;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.utils.ServiceUtils;

public class SyncHelper {
   public static final String a = SyncHelper.class.getName() + ".ARG_SYNC_FLAGS";

   public static void a(Context var0) {
      KeyRequestingSharingService.a(var0);
      Job var1 = JiboApplication.a.a().a(KeysCheckerJobService.class).a("scheduleKeysChecker").a(1).a(Trigger.a(120, 180)).a(1).b(true).j();
      JiboApplication.a.a("scheduleKeysChecker");
      if (JiboApplication.a.a(var1) != 0) {
      }
   }

   public static void a(Context var0, String var1) {
      Intent var2 = new Intent(var0, SyncTaskService.class);
      var2.putExtra(Loop.class.getSimpleName(), var1);
      var2.putExtra(a, 1);
      ServiceUtils.a(var0, var2);
   }

   public static void a(Context var0, String var1, boolean var2) {
      Intent var4 = new Intent(var0, SyncTaskService.class);
      var4.putExtra(Loop.class.getSimpleName(), var1);
      var1 = a;
      byte var3;
      if (var2) {
         var3 = 16;
      } else {
         var3 = 0;
      }

      var4.putExtra(var1, var3 | 8);
      ServiceUtils.a(var0, var4);
   }

   public static void b(Context var0) {
      Intent var1 = new Intent(var0, SyncTaskService.class);
      var1.putExtra(a, 2);
      ServiceUtils.a(var0, var1);
   }

   public static void b(Context var0, String var1) {
      Intent var2 = new Intent(var0, SyncTaskService.class);
      var2.putExtra(Loop.class.getSimpleName(), var1);
      var2.putExtra(a, 13);
      ServiceUtils.a(var0, var2);
   }

   public static void c(Context var0) {
      Intent var1 = new Intent(var0, SyncTaskService.class);
      var1.putExtra(a, 28);
      ServiceUtils.a(var0, var1);
   }

   public static void c(Context var0, String var1) {
      Intent var2 = new Intent(var0, SyncTaskService.class);
      var2.putExtra(Loop.class.getSimpleName(), var1);
      var2.putExtra(a, 4);
      ServiceUtils.a(var0, var2);
   }
}
