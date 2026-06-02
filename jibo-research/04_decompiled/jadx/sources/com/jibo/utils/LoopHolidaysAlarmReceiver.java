package com.jibo.utils;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Parcelable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.p019ui.activity.SingleFragmentActivity;
import com.jibo.p019ui.fragment.settings.HolidaySettingsFragment;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public class LoopHolidaysAlarmReceiver extends BroadcastReceiver {
    /* JADX WARN: Removed duplicated region for block: B:27:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onReceive(android.content.Context r10, android.content.Intent r11) throws java.lang.Throwable {
        /*
            r9 = this;
            r6 = 0
            java.lang.Class<com.jibo.aws.integration.aws.services.loop.model.Loop> r0 = com.jibo.aws.integration.aws.services.loop.model.Loop.class
            java.lang.String r0 = r0.getSimpleName()
            java.lang.String r0 = r11.getStringExtra(r0)
            if (r0 == 0) goto L30
            java.lang.Class<com.jibo.aws.integration.aws.services.loop.model.Loop> r0 = com.jibo.aws.integration.aws.services.loop.model.Loop.class
            java.lang.String r0 = r0.getSimpleName()     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L87
            java.lang.String r7 = r11.getStringExtra(r0)     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L87
            com.jibo.db.EntityData r0 = com.jibo.p018db.EntityData.m10089a(r10)     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L87
            com.jibo.aws.integration.aws.services.loop.model.Loop r8 = r0.m10125c(r7)     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L87
            if (r8 == 0) goto L2b
            java.lang.Boolean r0 = r8.isSuspended()     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L87
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L87
            if (r0 == 0) goto L31
        L2b:
            if (r6 == 0) goto L30
            r6.close()
        L30:
            return
        L31:
            android.content.ContentResolver r0 = r10.getContentResolver()     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L87
            r1 = 8
            android.net.Uri r1 = com.jibo.db.DatabaseContract.EntityEntry.m10079a(r1)     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L87
            java.lang.String[] r2 = com.jibo.db.DatabaseContract.EntityEntry.f9694a     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L87
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L7c java.lang.Throwable -> L87
            if (r1 == 0) goto L76
            boolean r0 = r1.isClosed()     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            if (r0 != 0) goto L76
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            if (r0 == 0) goto L76
            com.jibo.utils.SharedPreferencesUtil.m11445g(r10, r7)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            r2 = 1
            if (r0 != r2) goto L5f
            r9.m11415c(r10, r8)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
        L5f:
            android.content.Intent r0 = new android.content.Intent     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            java.lang.String r2 = "LOOP_HOLIDAYS_ALARM_ACTION"
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            java.lang.Class<com.jibo.aws.integration.aws.services.loop.model.Loop> r2 = com.jibo.aws.integration.aws.services.loop.model.Loop.class
            java.lang.String r2 = r2.getSimpleName()     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            r0.putExtra(r2, r7)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            android.support.v4.content.LocalBroadcastManager r2 = android.support.v4.content.LocalBroadcastManager.m1878a(r10)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            r2.m1883a(r0)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
        L76:
            if (r1 == 0) goto L30
            r1.close()
            goto L30
        L7c:
            r0 = move-exception
            r1 = r6
        L7e:
            com.crashlytics.android.Crashlytics.m5597a(r0)     // Catch: java.lang.Throwable -> L8f
            if (r1 == 0) goto L30
            r1.close()
            goto L30
        L87:
            r0 = move-exception
            r1 = r6
        L89:
            if (r1 == 0) goto L8e
            r1.close()
        L8e:
            throw r0
        L8f:
            r0 = move-exception
            goto L89
        L91:
            r0 = move-exception
            goto L7e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jibo.utils.LoopHolidaysAlarmReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }

    /* JADX INFO: renamed from: a */
    public static void m11413a(Context context, Loop loop) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        Intent intent = new Intent(context, (Class<?>) LoopHolidaysAlarmReceiver.class);
        intent.putExtra(Loop.class.getSimpleName(), loop.getId());
        PendingIntent broadcast = PendingIntent.getBroadcast(context, loop.getId().hashCode() + 10000, intent, 134217728);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(6, 2);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.add(11, 12);
        alarmManager.set(1, calendar.getTimeInMillis(), broadcast);
    }

    /* JADX INFO: renamed from: b */
    public static void m11414b(Context context, Loop loop) {
        if (loop != null) {
            SharedPreferencesUtil.m11447h(context, loop.getId());
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            Intent intent = new Intent(context, (Class<?>) LoopHolidaysAlarmReceiver.class);
            intent.putExtra(Loop.class.getSimpleName(), loop.getId());
            alarmManager.cancel(PendingIntent.getBroadcast(context, loop.getId().hashCode() + 10000, intent, 134217728));
            ((NotificationManager) context.getSystemService("notification")).cancel(loop.getId(), loop.getId().hashCode() + 10001);
        }
    }

    /* JADX INFO: renamed from: c */
    private void m11415c(Context context, Loop loop) {
        NotificationCompat.Builder builderM1734a = new NotificationCompat.Builder(context).m1732a(UIUtils.m11472a()).m1744b(context.getString(R.string.notification_loop_no_holidays_msg)).m1738a((CharSequence) context.getString(R.string.notification_loop_no_holidays_title)).m1740a(true).m1736a(RingtoneManager.getDefaultUri(2)).m1734a(TaskStackBuilder.m1807a(context).m1815b(new SingleFragmentActivity.Builder(context, HolidaySettingsFragment.class.getName()).m10272a(Loop.class.getSimpleName(), (Parcelable) loop).m10270a()).m1808a(loop.getId().hashCode() + 10001, 134217728));
        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle(builderM1734a);
        bigTextStyle.m1728b(context.getString(R.string.notification_loop_no_holidays_msg));
        bigTextStyle.m1726a(context.getString(R.string.notification_loop_no_holidays_title));
        builderM1734a.m1737a(bigTextStyle);
        if (Build.VERSION.SDK_INT >= 21) {
            builderM1734a.m1748d(context.getResources().getColor(R.color.jibo_blue));
        }
        ((NotificationManager) context.getSystemService("notification")).notify(loop.getId(), loop.getId().hashCode() + 10001, builderM1734a.m1741b());
    }
}
