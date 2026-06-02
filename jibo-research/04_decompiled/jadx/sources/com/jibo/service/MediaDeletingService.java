package com.jibo.service;

import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import com.amazonaws.auth.BasicAWSCredentials;
import com.crashlytics.android.Crashlytics;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.media.JiboMediaClient;
import com.jibo.aws.integration.aws.services.media.model.Media;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.p018db.EntityData;
import com.jibo.utils.LogUtils;
import com.jibo.utils.ServiceUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class MediaDeletingService extends IntentService {

    /* JADX INFO: renamed from: a */
    public static final String f9752a = MediaDeletingService.class.getSimpleName();

    /* JADX INFO: renamed from: b */
    private JiboMediaClient f9753b;

    public MediaDeletingService() {
        super(f9752a);
        this.f9753b = null;
    }

    /* JADX INFO: renamed from: a */
    public static void m10170a(Context context, Media media) {
        if (media != null) {
            Intent intent = new Intent(context, (Class<?>) MediaDeletingService.class);
            intent.putExtra("EXTRA_IDS", new String[]{media.getPath()});
            intent.putExtra("EXTRA_FROM_OUTSIDE", false);
            ServiceUtils.m11427a(context, intent);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m10171a(Context context, String[] strArr, boolean z) {
        if (strArr != null && strArr.length != 0) {
            Intent intent = new Intent(context, (Class<?>) MediaDeletingService.class);
            intent.putExtra("EXTRA_IDS", strArr);
            intent.putExtra("EXTRA_FROM_OUTSIDE", z);
            ServiceUtils.m11427a(context, intent);
        }
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        ServiceUtils.m11426a((Service) this);
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ServiceUtils.m11428b(this);
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        String[] stringArrayExtra = intent.getStringArrayExtra("EXTRA_IDS");
        boolean booleanExtra = intent.getBooleanExtra("EXTRA_FROM_OUTSIDE", false);
        if (stringArrayExtra != null && stringArrayExtra.length != 0) {
            LogUtils.m11407a(f9752a, "onHandleIntent-start");
            ArrayList arrayList = new ArrayList();
            try {
                try {
                    Account accountM10134i = EntityData.m10089a(this).m10134i();
                    for (int i = 0; i < stringArrayExtra.length; i++) {
                        Media mediaM10129e = EntityData.m10089a(this).m10129e(stringArrayExtra[i]);
                        if (mediaM10129e == null) {
                            mediaM10129e = EntityData.m10089a(this).m10127d(stringArrayExtra[i]);
                        }
                        if (mediaM10129e != null) {
                            Loop loopM10125c = EntityData.m10089a(this).m10125c(mediaM10129e.getLoopId());
                            if (booleanExtra || LoopHelper.isOwner(loopM10125c, accountM10134i.getId()) || mediaM10129e.getAccountId().equals(accountM10134i.getId())) {
                                arrayList.add(mediaM10129e.getPath());
                                if (mediaM10129e.getReference() != null) {
                                    arrayList.add(mediaM10129e.getReference());
                                }
                            }
                        } else {
                            arrayList.add(stringArrayExtra[i]);
                        }
                    }
                    EntityData.m10089a(this).m10120a(arrayList);
                    if (!booleanExtra && !arrayList.isEmpty()) {
                        this.f9753b = new JiboMediaClient(new BasicAWSCredentials(accountM10134i.getAccessKeyId(), accountM10134i.getSecretAccessKey()));
                        this.f9753b.remove(arrayList);
                    }
                    if (this.f9753b != null) {
                        this.f9753b.shutdown();
                    }
                } catch (Exception e) {
                    Crashlytics.m5597a((Throwable) e);
                    if (this.f9753b != null) {
                        this.f9753b.shutdown();
                    }
                }
                LogUtils.m11407a(f9752a, "onHandleIntent-end");
            } catch (Throwable th) {
                if (this.f9753b != null) {
                    this.f9753b.shutdown();
                }
                throw th;
            }
        }
    }
}
