package com.jibo.service;

import android.os.AsyncTask;
import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;
import com.jibo.utils.LogUtils;

public class KeysCheckerJobService extends JobService {
   public static final String a = LogUtils.a(KeysCheckerJobService.class);
   private AsyncTask b;

   @Override
   public boolean a(JobParameters var1) {
      this.b = new AsyncTask<Object, Void, Void>(this, var1) {
         final JobParameters a;
         final KeysCheckerJobService b;

         {
            this.b = var1;
            this.a = var2;
         }

         protected Void a(Object... var1) {
            LogUtils.a(KeysCheckerJobService.a, "onStartJob-start");
            KeyRequestingSharingService.a(this.b.getApplicationContext());
            LogUtils.a(KeysCheckerJobService.a, "onStartJob-end");
            return null;
         }

         protected void a(Void var1) {
            this.b.b(this.a, false);
         }
      };
      this.b.execute(new Object[0]);
      return true;
   }

   @Override
   public boolean b(JobParameters var1) {
      this.b.cancel(true);
      return true;
   }
}
