package com.salesforce.android.knowledge.core.offline;

import com.jakewharton.disklrucache.DiskLruCache;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import com.salesforce.android.service.common.utilities.control.ResultReceiver;
import com.salesforce.android.service.common.utilities.functional.Function;
import com.salesforce.android.service.common.utilities.hashing.Murmur3_32;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.threading.Job;
import com.salesforce.android.service.common.utilities.threading.JobQueue;
import com.salesforce.android.service.common.utilities.threading.PriorityThreadFactory;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import com.salesforce.androidsdk.analytics.security.Encryptor;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executors;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;
import okio.Source;

/* JADX INFO: loaded from: classes.dex */
public class OfflineResourceCache {

    /* JADX INFO: renamed from: a */
    static final ServiceLogger f13013a = ServiceLogging.m14203a((Class<?>) OfflineResourceCache.class);

    /* JADX INFO: renamed from: b */
    DiskLruCache f13014b;

    /* JADX INFO: renamed from: c */
    final JobQueue f13015c;

    /* JADX INFO: renamed from: d */
    final OfflineResourceConfig f13016d;

    /* JADX INFO: renamed from: a */
    public static OfflineResourceCache m13286a(OfflineResourceConfig offlineResourceConfig) {
        return new OfflineResourceCache(offlineResourceConfig, new JobQueue(Executors.newFixedThreadPool(offlineResourceConfig.m13300e(), PriorityThreadFactory.m14230a())));
    }

    OfflineResourceCache(OfflineResourceConfig offlineResourceConfig, JobQueue jobQueue) {
        this.f13016d = offlineResourceConfig;
        this.f13015c = jobQueue;
    }

    /* JADX INFO: renamed from: a */
    public Async<OfflineResourceCache> m13289a() {
        if (!this.f13016d.m13297b()) {
            return BasicAsync.m14084c(this);
        }
        if (this.f13014b != null) {
            return BasicAsync.m14084c(this);
        }
        return this.f13015c.m14223a(new InitJob(this.f13016d)).mo14076a(new Function<DiskLruCache, OfflineResourceCache>() { // from class: com.salesforce.android.knowledge.core.offline.OfflineResourceCache.1
            @Override // com.salesforce.android.service.common.utilities.functional.Function
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public OfflineResourceCache mo12236a(DiskLruCache diskLruCache) {
                OfflineResourceCache.this.f13014b = diskLruCache;
                return OfflineResourceCache.this;
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public InputStream m13290a(String str) {
        ByteArrayInputStream byteArrayInputStream = null;
        if (this.f13016d.m13297b()) {
            Arguments.m14236a(this.f13014b, "You must call init and wait for the result prior to using this class");
            InputStream inputStreamM13288c = m13288c(m13287b(str));
            if (inputStreamM13288c != null) {
                try {
                    String strM14365a = Encryptor.m14365a(Okio.m16360a(Okio.m16366a(inputStreamM13288c)).mo16305p().mo16330b(), SalesforceSDKManager.m14403a().m14434c(null));
                    if (strM14365a != null) {
                        byteArrayInputStream = new ByteArrayInputStream(ByteString.m16319b(strM14365a).mo16337i());
                    } else {
                        this.f13014b.m9799c(m13287b(str));
                        f13013a.mo14189b("Error decrypting cached resources at {} ", str);
                    }
                } catch (IOException e) {
                    f13013a.mo14195e("Error reading Encrypted cached image, aborting. {}", e.getMessage());
                }
            }
        }
        return byteArrayInputStream;
    }

    /* JADX INFO: renamed from: a */
    public boolean m13291a(String str, Source source) {
        DiskLruCache.Editor editor;
        DiskLruCache.Editor editorM9797b;
        BufferedSink bufferedSinkM16359a = null;
        Arguments.m14236a(this.f13014b, "You must call init and wait for the result prior to using this class");
        String strM13287b = m13287b(str);
        String strM14434c = SalesforceSDKManager.m14403a().m14434c(null);
        try {
            try {
                editorM9797b = this.f13014b.m9797b(strM13287b);
            } finally {
                if (0 != 0) {
                    try {
                        bufferedSinkM16359a.close();
                    } catch (IOException e) {
                    }
                }
            }
        } catch (IOException e2) {
            editor = null;
        }
        try {
            ByteString byteStringM16319b = ByteString.m16319b(Encryptor.m14371b(Okio.m16360a(source).mo16305p().mo16330b(), strM14434c));
            bufferedSinkM16359a = Okio.m16359a(Okio.m16362a(editorM9797b.m9804a(0)));
            bufferedSinkM16359a.mo16268b(byteStringM16319b);
            editorM9797b.m9805a();
            f13013a.mo14187a("Cached resource {} at key {}, total cache size is now {}", str, strM13287b, Long.valueOf(this.f13014b.m9795a()));
            if (bufferedSinkM16359a == null) {
                return true;
            }
            try {
                bufferedSinkM16359a.close();
                return true;
            } catch (IOException e3) {
                return true;
            }
        } catch (IOException e4) {
            editor = editorM9797b;
            f13013a.mo14193d("Resource {} could not be written to cache at key {}.", str, strM13287b);
            if (editor != null) {
                try {
                    editor.m9806b();
                } catch (IOException e5) {
                }
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: b */
    public Async<Void> m13292b() {
        Arguments.m14236a(this.f13014b, "You must call init and wait for the result prior to using this class");
        return this.f13015c.m14223a(new DeleteJob(this.f13014b));
    }

    /* JADX INFO: renamed from: b */
    static String m13287b(String str) {
        return Integer.toHexString(Murmur3_32.m14101a(str, 129492964));
    }

    /* JADX INFO: renamed from: c */
    private InputStream m13288c(String str) {
        try {
            DiskLruCache.Snapshot snapshotM9796a = this.f13014b.m9796a(str);
            if (snapshotM9796a == null) {
                return null;
            }
            return snapshotM9796a.m9821a(0);
        } catch (Exception e) {
            f13013a.mo14193d("Could not fetch cached bitmap: {}", e);
            return null;
        }
    }

    private static class InitJob implements Job<DiskLruCache> {

        /* JADX INFO: renamed from: a */
        private final OfflineResourceConfig f13019a;

        InitJob(OfflineResourceConfig offlineResourceConfig) {
            this.f13019a = offlineResourceConfig;
        }

        @Override // com.salesforce.android.service.common.utilities.threading.Job
        /* JADX INFO: renamed from: a */
        public void mo12210a(ResultReceiver<DiskLruCache> resultReceiver) {
            try {
                resultReceiver.mo12614b(DiskLruCache.m9775a(this.f13019a.m13299d(), 0, 1, this.f13019a.m13298c())).mo12613b();
            } catch (Exception e) {
                OfflineResourceCache.f13013a.mo14193d("Exception initializing OfflineImageCache: {}", e);
                resultReceiver.mo12615b(e);
            }
        }
    }

    private static class DeleteJob implements Job<Void> {

        /* JADX INFO: renamed from: a */
        private final DiskLruCache f13018a;

        DeleteJob(DiskLruCache diskLruCache) {
            this.f13018a = diskLruCache;
        }

        @Override // com.salesforce.android.service.common.utilities.threading.Job
        /* JADX INFO: renamed from: a */
        public void mo12210a(ResultReceiver<Void> resultReceiver) {
            OfflineResourceCache.f13013a.mo14191c("Deleting disk cache of size {}", Long.valueOf(this.f13018a.m9795a()));
            try {
                this.f13018a.m9798b();
                resultReceiver.mo12613b();
            } catch (IOException e) {
                OfflineResourceCache.f13013a.mo14193d("Could not delete disk cache {}", e);
                resultReceiver.mo12615b(e);
            }
        }
    }
}
