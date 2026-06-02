package com.jibo.service;

import android.os.AsyncTask;
import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;
import com.jibo.db.EntityData;
import com.jibo.utils.LogUtils;

public class DataSyncJobService extends JobService {
   public static final String a = LogUtils.a(DataSyncJobService.class);
   private AsyncTask b;

   @Override
   public boolean a(JobParameters var1) {
      this.b = new AsyncTask<Void, Void, Void>(this, var1) {
         final JobParameters a;
         final DataSyncJobService b;

         {
            this.b = var1;
            this.a = var2;
         }

         protected Void a(Void... var1) {
            LogUtils.a(DataSyncJobService.a, "onStartJob-start");
            EntityData.a(this.b).a(this.a.b());
            LogUtils.a(DataSyncJobService.a, "onStartJob-end");
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
