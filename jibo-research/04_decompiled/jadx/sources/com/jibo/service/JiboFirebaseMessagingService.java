package com.jibo.service;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.jibo.R;
import com.jibo.p019ui.activity.OnBoardingActivity;
import com.jibo.utils.SharedPreferencesUtil;
import com.jibo.utils.UIUtils;
import com.yalantis.ucrop.util.FileUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes.dex */
public class JiboFirebaseMessagingService extends FirebaseMessagingService {

    /* JADX INFO: renamed from: b */
    private static final String f9742b = JiboFirebaseMessagingService.class.getSimpleName();

    /* JADX INFO: renamed from: c */
    private static final CharSequence f9743c = "channel_name";

    enum MessageType {
        jot_created_silent,
        jot_created_tagged,
        loop_changed_silent,
        loop_invited,
        loop_accepted,
        key_needed_silent,
        key_shared_silent,
        media_deleted_silent,
        key_timeout_silent,
        media_created_silent,
        version_installed,
        version_updated
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    /* JADX INFO: renamed from: a */
    public void mo9196a(RemoteMessage remoteMessage) {
        super.mo9196a(remoteMessage);
        final Map<String, String> mapM9199a = remoteMessage.m9199a();
        if (mapM9199a.get(ShareConstants.MEDIA_TYPE) != null) {
            String strReplace = mapM9199a.get(ShareConstants.MEDIA_TYPE).replace("-", "_").replace(FileUtils.HIDDEN_PREFIX, "_");
            if (strReplace.equals(MessageType.loop_changed_silent.toString())) {
                SyncHelper.m10176a(getApplicationContext(), mapM9199a.get("loopId"));
                return;
            }
            if (strReplace.equals(MessageType.loop_invited.toString())) {
                SyncHelper.m10176a(getApplicationContext(), mapM9199a.get("loopId"));
                Bundle bundle = new Bundle();
                bundle.putInt("ARG_TAB_SELECTED", 0);
                bundle.putString("ARG_ENTITY_SELECTED", mapM9199a.get("loopId"));
                m10158a(mapM9199a, null, getString(R.string.notification_invited_to_join_the_loop), 2, mapM9199a.get("loopId"), bundle);
                return;
            }
            if (strReplace.equals(MessageType.loop_accepted.toString())) {
                SyncHelper.m10176a(getApplicationContext(), mapM9199a.get("loopId"));
                Bundle bundle2 = new Bundle();
                bundle2.putInt("ARG_TAB_SELECTED", 0);
                bundle2.putString("ARG_ENTITY_SELECTED", mapM9199a.get("loopId"));
                m10157a(mapM9199a, null, getString(R.string.notification_loop_invitation_accepted), 3, bundle2);
                return;
            }
            if (strReplace.equals(MessageType.jot_created_silent.toString())) {
                SyncHelper.m10181c(getApplicationContext(), mapM9199a.get("loopId"));
                return;
            }
            if (strReplace.equals(MessageType.media_created_silent.toString())) {
                new Timer().schedule(new TimerTask() { // from class: com.jibo.service.JiboFirebaseMessagingService.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        SyncHelper.m10177a(JiboFirebaseMessagingService.this.getApplicationContext(), (String) mapM9199a.get("loopId"), false);
                        if (SharedPreferencesUtil.m11456p(JiboFirebaseMessagingService.this)) {
                            Bundle bundle3 = new Bundle();
                            bundle3.putInt("ARG_TAB_SELECTED", 1);
                            JiboFirebaseMessagingService.this.m10158a(mapM9199a, JiboFirebaseMessagingService.this.getString(R.string.notification_new_content_in_gallery_title), JiboFirebaseMessagingService.this.getString(R.string.notification_new_content_in_gallery_msg), 4, MessageType.media_created_silent.toString(), bundle3);
                        }
                    }
                }, 4000L);
                return;
            }
            if (strReplace.equals(MessageType.media_deleted_silent.toString())) {
                MediaDeletingService.m10171a(getApplicationContext(), new String[]{mapM9199a.get("path")}, true);
                return;
            }
            if (strReplace.equals(MessageType.key_needed_silent.toString())) {
                KeyRequestingSharingService.m10162a(this, mapM9199a);
                return;
            }
            if (strReplace.equals(MessageType.key_shared_silent.toString())) {
                KeyRequestingSharingService.m10165b(this, mapM9199a);
                return;
            }
            if (strReplace.equals(MessageType.key_timeout_silent.toString())) {
                ArrayList arrayList = new ArrayList();
                Collections.addAll(arrayList, SharedPreferencesUtil.m11454n(this));
                if (arrayList.indexOf(mapM9199a.get("loopId")) == -1) {
                    SharedPreferencesUtil.m11437c(this, mapM9199a.get("loopId"));
                    return;
                }
                return;
            }
            if (strReplace.equals(MessageType.version_installed.toString())) {
                Bundle bundle3 = new Bundle();
                bundle3.putString("android.intent.action.VIEW", getString(R.string.release_notes_url));
                m10157a(mapM9199a, null, getString(R.string.notification_ota_installed), 5, bundle3);
            } else if (strReplace.equals(MessageType.version_updated.toString())) {
                Bundle bundle4 = new Bundle();
                bundle4.putString("android.intent.action.VIEW", getString(R.string.release_notes_url));
                m10157a(mapM9199a, null, getString(R.string.notification_ota_updated), 5, bundle4);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m10157a(Map<String, String> map, String str, String str2, int i, Bundle bundle) {
        m10158a(map, str, str2, i, null, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m10158a(Map<String, String> map, String str, String str2, int i, String str3, Bundle bundle) {
        Intent intent;
        String str4;
        NotificationChannel notificationChannel;
        if (!bundle.containsKey("android.intent.action.VIEW")) {
            intent = new Intent(this, (Class<?>) OnBoardingActivity.class);
            intent.addFlags(67108864);
            if (bundle != null) {
                intent.putExtra("ARG_EXTRAS", bundle);
            }
        } else {
            intent = new Intent("android.intent.action.VIEW", Uri.parse(bundle.getString("android.intent.action.VIEW")));
        }
        PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 134217728);
        if (Build.VERSION.SDK_INT < 26) {
            str4 = "";
            notificationChannel = null;
        } else {
            str4 = "my_channel_01";
            notificationChannel = new NotificationChannel("my_channel_01", f9743c, 3);
        }
        NotificationCompat.Builder builderM1738a = new NotificationCompat.Builder(this, str4).m1732a(UIUtils.m11472a()).m1738a((CharSequence) (TextUtils.isEmpty(str) ? getString(R.string.app_name) : str));
        Object[] objArr = new Object[1];
        objArr[0] = map.get("loc-args") == null ? "" : map.get("loc-args").replace("[\"", "").replace("\"]", "");
        NotificationCompat.Builder builderM1734a = builderM1738a.m1744b(String.format(str2, objArr)).m1740a(true).m1736a(RingtoneManager.getDefaultUri(2)).m1734a(activity);
        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle(builderM1734a);
        Object[] objArr2 = new Object[1];
        objArr2[0] = map.get("loc-args") == null ? "" : map.get("loc-args").replace("[\"", "").replace("\"]", "");
        bigTextStyle.m1728b(String.format(str2, objArr2));
        if (TextUtils.isEmpty(str)) {
            str = getString(R.string.app_name);
        }
        bigTextStyle.m1726a(str);
        builderM1734a.m1737a(bigTextStyle);
        if (Build.VERSION.SDK_INT >= 21) {
            builderM1734a.m1748d(getResources().getColor(R.color.jibo_blue));
        }
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (notificationManager != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
            notificationManager.notify(str3, i, builderM1734a.m1741b());
        }
    }
}
