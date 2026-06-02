package com.salesforce.android.knowledge.core.offline;

import com.salesforce.android.knowledge.core.KnowledgeConfiguration;
import com.salesforce.android.knowledge.core.LogoutListener;
import com.salesforce.android.knowledge.core.internal.utils.MobileSdkUserManager;
import com.salesforce.android.knowledge.core.model.ArticleDetails;
import com.salesforce.android.knowledge.core.offline.ResourceDownload;
import com.salesforce.android.service.common.http.okhttp.SalesforceOkHttpClient;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import com.salesforce.android.service.common.utilities.control.ResultReceiver;
import com.salesforce.android.service.common.utilities.threading.Job;
import com.salesforce.android.service.common.utilities.threading.JobQueue;
import com.salesforce.android.service.common.utilities.threading.PriorityThreadFactory;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class OfflineResourceCacher implements LogoutListener {

    /* JADX INFO: renamed from: a */
    private final JobQueue f13020a;

    /* JADX INFO: renamed from: b */
    private final OfflineResourceConfig f13021b;

    /* JADX INFO: renamed from: c */
    private final OfflineResourceCache f13022c;

    /* JADX INFO: renamed from: d */
    private final ArticleParser f13023d;

    /* JADX INFO: renamed from: e */
    private final ResourceDownload.Factory f13024e;

    OfflineResourceCacher(JobQueue jobQueue, OfflineResourceConfig offlineResourceConfig, OfflineResourceCache offlineResourceCache, ArticleParser articleParser, ResourceDownload.Factory factory, MobileSdkUserManager mobileSdkUserManager) {
        this.f13020a = jobQueue;
        this.f13021b = offlineResourceConfig;
        this.f13022c = offlineResourceCache;
        this.f13023d = articleParser;
        this.f13024e = factory;
        if (this.f13021b != null && this.f13021b.m13297b()) {
            mobileSdkUserManager.mo13274a(this);
        }
    }

    /* JADX INFO: renamed from: a */
    public static OfflineResourceCacher m13293a(KnowledgeConfiguration knowledgeConfiguration, MobileSdkUserManager mobileSdkUserManager) {
        OfflineResourceConfig offlineResourceConfigM13076b = knowledgeConfiguration.m13076b();
        return new OfflineResourceCacher(new JobQueue(Executors.newFixedThreadPool(offlineResourceConfigM13076b.m13300e(), PriorityThreadFactory.m14230a())), offlineResourceConfigM13076b, OfflineResourceCache.m13286a(offlineResourceConfigM13076b), new ArticleParser(knowledgeConfiguration.m13075a()), new ResourceDownload.Factory(SalesforceOkHttpClient.m13785a(SalesforceSDKManager.m14403a().m14423E().m14559a().m14602d()).mo13746a().mo13748a(5L, TimeUnit.SECONDS).mo13753b(10L, TimeUnit.SECONDS).mo13747a()), mobileSdkUserManager);
    }

    /* JADX INFO: renamed from: a */
    public Async<Void> m13294a(ArticleDetails articleDetails) {
        if (!this.f13021b.m13297b()) {
            return BasicAsync.m14087h();
        }
        Iterator<String> it = this.f13023d.m13285a(articleDetails).iterator();
        while (it.hasNext()) {
            this.f13020a.m14223a(new DownloadJob(it.next(), this.f13022c, this.f13024e));
        }
        return BasicAsync.m14087h();
    }

    /* JADX INFO: renamed from: b */
    public OfflineResourceCache m13295b() {
        return this.f13022c;
    }

    @Override // com.salesforce.android.knowledge.core.LogoutListener
    /* JADX INFO: renamed from: a */
    public void mo13084a() {
        if (this.f13021b != null && this.f13021b.m13297b()) {
            this.f13022c.m13292b();
        }
    }

    private static class DownloadJob implements Job<Void> {

        /* JADX INFO: renamed from: a */
        private final String f13025a;

        /* JADX INFO: renamed from: b */
        private final OfflineResourceCache f13026b;

        /* JADX INFO: renamed from: c */
        private final ResourceDownload.Factory f13027c;

        DownloadJob(String str, OfflineResourceCache offlineResourceCache, ResourceDownload.Factory factory) {
            this.f13025a = str;
            this.f13026b = offlineResourceCache;
            this.f13027c = factory;
        }

        @Override // com.salesforce.android.service.common.utilities.threading.Job
        /* JADX INFO: renamed from: a */
        public void mo12210a(ResultReceiver<Void> resultReceiver) {
            try {
                this.f13027c.m13302a(this.f13025a).m13301a(this.f13026b);
                resultReceiver.mo12613b();
            } catch (IOException e) {
                resultReceiver.mo12615b(e);
            }
        }
    }
}
