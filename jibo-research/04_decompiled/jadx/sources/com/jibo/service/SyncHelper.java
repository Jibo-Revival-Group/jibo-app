package com.jibo.service;

import android.content.Context;
import android.content.Intent;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.Trigger;
import com.jibo.JiboApplication;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.utils.ServiceUtils;

/* JADX INFO: loaded from: classes.dex */
public class SyncHelper {

    /* JADX INFO: renamed from: a */
    public static final String f9757a = SyncHelper.class.getName() + ".ARG_SYNC_FLAGS";

    /* JADX INFO: renamed from: a */
    public static void m10175a(Context context) {
        KeyRequestingSharingService.m10160a(context);
        Job jobM6587j = JiboApplication.f9172a.m6523a().m6582a(KeysCheckerJobService.class).m6583a("scheduleKeysChecker").m6585a(1).m6581a(Trigger.m6643a(120, 180)).m6580a(1).m6586b(true).m6587j();
        JiboApplication.f9172a.m6522a("scheduleKeysChecker");
        if (JiboApplication.f9172a.m6521a(jobM6587j) != 0) {
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m10178b(Context context) {
        Intent intent = new Intent(context, (Class<?>) SyncTaskService.class);
        intent.putExtra(f9757a, 2);
        ServiceUtils.m11427a(context, intent);
    }

    /* JADX INFO: renamed from: c */
    public static void m10180c(Context context) {
        Intent intent = new Intent(context, (Class<?>) SyncTaskService.class);
        intent.putExtra(f9757a, 28);
        ServiceUtils.m11427a(context, intent);
    }

    /* JADX INFO: renamed from: a */
    public static void m10176a(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) SyncTaskService.class);
        intent.putExtra(Loop.class.getSimpleName(), str);
        intent.putExtra(f9757a, 1);
        ServiceUtils.m11427a(context, intent);
    }

    /* JADX INFO: renamed from: b */
    public static void m10179b(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) SyncTaskService.class);
        intent.putExtra(Loop.class.getSimpleName(), str);
        intent.putExtra(f9757a, 13);
        ServiceUtils.m11427a(context, intent);
    }

    /* JADX INFO: renamed from: c */
    public static void m10181c(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) SyncTaskService.class);
        intent.putExtra(Loop.class.getSimpleName(), str);
        intent.putExtra(f9757a, 4);
        ServiceUtils.m11427a(context, intent);
    }

    /* JADX INFO: renamed from: a */
    public static void m10177a(Context context, String str, boolean z) {
        Intent intent = new Intent(context, (Class<?>) SyncTaskService.class);
        intent.putExtra(Loop.class.getSimpleName(), str);
        intent.putExtra(f9757a, (z ? 16 : 0) | 8);
        ServiceUtils.m11427a(context, intent);
    }
}
