package android.support.v4.app;

import android.app.Notification;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.util.SparseArray;
import com.facebook.applinks.AppLinkData;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class NotificationCompatJellybean {

    /* JADX INFO: renamed from: b */
    private static Field f1723b;

    /* JADX INFO: renamed from: c */
    private static boolean f1724c;

    /* JADX INFO: renamed from: a */
    private static final Object f1722a = new Object();

    /* JADX INFO: renamed from: d */
    private static final Object f1725d = new Object();

    /* JADX INFO: renamed from: a */
    public static SparseArray<Bundle> m1761a(List<Bundle> list) {
        SparseArray<Bundle> sparseArray = null;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Bundle bundle = list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    /* JADX INFO: renamed from: a */
    public static Bundle m1759a(Notification notification) {
        synchronized (f1722a) {
            if (f1724c) {
                return null;
            }
            try {
                if (f1723b == null) {
                    Field declaredField = Notification.class.getDeclaredField(AppLinkData.ARGUMENTS_EXTRAS_KEY);
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f1724c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    f1723b = declaredField;
                }
                Bundle bundle = (Bundle) f1723b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f1723b.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e) {
                Log.e("NotificationCompat", "Unable to access notification extras", e);
                f1724c = true;
                return null;
            } catch (NoSuchFieldException e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                f1724c = true;
                return null;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static Bundle m1758a(Notification.Builder builder, NotificationCompat.Action action) {
        builder.addAction(action.m1719a(), action.m1720b(), action.m1721c());
        Bundle bundle = new Bundle(action.m1722d());
        if (action.m1724f() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", m1762a(action.m1724f()));
        }
        if (action.m1725g() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", m1762a(action.m1725g()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", action.m1723e());
        return bundle;
    }

    /* JADX INFO: renamed from: a */
    private static Bundle m1760a(RemoteInput remoteInput) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", remoteInput.m1784a());
        bundle.putCharSequence("label", remoteInput.m1785b());
        bundle.putCharSequenceArray("choices", remoteInput.m1786c());
        bundle.putBoolean("allowFreeFormInput", remoteInput.m1788e());
        bundle.putBundle(AppLinkData.ARGUMENTS_EXTRAS_KEY, remoteInput.m1789f());
        Set<String> setM1787d = remoteInput.m1787d();
        if (setM1787d != null && !setM1787d.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>(setM1787d.size());
            Iterator<String> it = setM1787d.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    /* JADX INFO: renamed from: a */
    private static Bundle[] m1762a(RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[remoteInputArr.length];
        for (int i = 0; i < remoteInputArr.length; i++) {
            bundleArr[i] = m1760a(remoteInputArr[i]);
        }
        return bundleArr;
    }
}
