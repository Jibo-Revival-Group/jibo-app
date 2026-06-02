package com.jibo.service;

import android.app.IntentService;
import android.content.Intent;
import com.jibo.db.EntityData;
import com.jibo.utils.LogUtils;
import com.jibo.utils.ServiceUtils;

public class SyncTaskService extends IntentService {
   public static final String a = LogUtils.a(SyncTaskService.class);

   public SyncTaskService() {
      super(a);
   }

   public void onCreate() {
      super.onCreate();
      ServiceUtils.a(this);
   }

   public void onDestroy() {
      super.onDestroy();
      ServiceUtils.b(this);
   }

   protected void onHandleIntent(Intent var1) {
      EntityData.a(this).a(var1.getExtras());
   }
}
