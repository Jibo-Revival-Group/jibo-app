package com.salesforce.android.knowledge.core.offline;

import com.salesforce.android.knowledge.core.KnowledgeConfiguration;
import com.salesforce.android.knowledge.core.LogoutListener;
import com.salesforce.android.knowledge.core.internal.utils.MobileSdkUserManager;
import com.salesforce.android.knowledge.core.model.ArticleDetails;
import com.salesforce.android.service.common.http.okhttp.SalesforceOkHttpClient;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import com.salesforce.android.service.common.utilities.control.ResultReceiver;
import com.salesforce.android.service.common.utilities.threading.Job;
import com.salesforce.android.service.common.utilities.threading.JobQueue;
import com.salesforce.android.service.common.utilities.threading.PriorityThreadFactory;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class OfflineResourceCacher implements LogoutListener {
   private final JobQueue a;
   private final OfflineResourceConfig b;
   private final OfflineResourceCache c;
   private final ArticleParser d;
   private final ResourceDownload.Factory e;

   OfflineResourceCacher(
      JobQueue var1, OfflineResourceConfig var2, OfflineResourceCache var3, ArticleParser var4, ResourceDownload.Factory var5, MobileSdkUserManager var6
   ) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
      if (this.b != null && this.b.b()) {
         var6.a(this);
      }
   }

   public static OfflineResourceCacher a(KnowledgeConfiguration var0, MobileSdkUserManager var1) {
      OfflineResourceConfig var2 = var0.b();
      return new OfflineResourceCacher(
         new JobQueue(Executors.newFixedThreadPool(var2.e(), PriorityThreadFactory.a())),
         var2,
         OfflineResourceCache.a(var2),
         new ArticleParser(var0.a()),
         new ResourceDownload.Factory(SalesforceOkHttpClient.a(SalesforceSDKManager.a().E().a().d()).a().a(5L, TimeUnit.SECONDS).b(10L, TimeUnit.SECONDS).a()),
         var1
      );
   }

   public Async<Void> a(ArticleDetails var1) {
      BasicAsync var3;
      if (!this.b.b()) {
         var3 = BasicAsync.h();
      } else {
         for (String var2 : this.d.a(var1)) {
            this.a.a(new OfflineResourceCacher.DownloadJob(var2, this.c, this.e));
         }

         var3 = BasicAsync.h();
      }

      return var3;
   }

   @Override
   public void a() {
      if (this.b != null && this.b.b()) {
         this.c.b();
      }
   }

   public OfflineResourceCache b() {
      return this.c;
   }

   private static class DownloadJob implements Job<Void> {
      private final String a;
      private final OfflineResourceCache b;
      private final ResourceDownload.Factory c;

      DownloadJob(String var1, OfflineResourceCache var2, ResourceDownload.Factory var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }

      @Override
      public void a(ResultReceiver<Void> var1) {
         try {
            this.c.a(this.a).a(this.b);
         } catch (IOException var3) {
            var1.b(var3);
            return;
         }

         var1.b();
      }
   }
}
