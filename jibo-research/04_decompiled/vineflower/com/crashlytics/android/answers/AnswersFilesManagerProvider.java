package com.crashlytics.android.answers;

import android.content.Context;
import android.os.Looper;
import io.fabric.sdk.android.services.common.SystemCurrentTimeProvider;
import io.fabric.sdk.android.services.events.GZIPQueueFileEventStorage;
import io.fabric.sdk.android.services.persistence.FileStore;
import java.io.File;
import java.io.IOException;

class AnswersFilesManagerProvider {
   final Context a;
   final FileStore b;

   public AnswersFilesManagerProvider(Context var1, FileStore var2) {
      this.a = var1;
      this.b = var2;
   }

   public SessionAnalyticsFilesManager a() throws IOException {
      if (Looper.myLooper() == Looper.getMainLooper()) {
         throw new IllegalStateException("AnswersFilesManagerProvider cannot be called on the main thread");
      }

      SessionEventTransform var1 = new SessionEventTransform();
      SystemCurrentTimeProvider var2 = new SystemCurrentTimeProvider();
      File var3 = this.b.a();
      GZIPQueueFileEventStorage var4 = new GZIPQueueFileEventStorage(this.a, var3, "session_analytics.tap", "session_analytics_to_send");
      return new SessionAnalyticsFilesManager(this.a, var1, var2, var4);
   }
}
