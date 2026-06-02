package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class NotificationManagerCompat {

    /* JADX INFO: renamed from: b */
    private static String f1727b;

    /* JADX INFO: renamed from: g */
    private static SideChannelManager f1730g;

    /* JADX INFO: renamed from: d */
    private final Context f1731d;

    /* JADX INFO: renamed from: e */
    private final NotificationManager f1732e;

    /* JADX INFO: renamed from: a */
    private static final Object f1726a = new Object();

    /* JADX INFO: renamed from: c */
    private static Set<String> f1728c = new HashSet();

    /* JADX INFO: renamed from: f */
    private static final Object f1729f = new Object();

    private interface Task {
        /* JADX INFO: renamed from: a */
        void mo1769a(INotificationSideChannel iNotificationSideChannel) throws RemoteException;
    }

    /* JADX INFO: renamed from: a */
    public static NotificationManagerCompat m1763a(Context context) {
        return new NotificationManagerCompat(context);
    }

    private NotificationManagerCompat(Context context) {
        this.f1731d = context;
        this.f1732e = (NotificationManager) this.f1731d.getSystemService("notification");
    }

    /* JADX INFO: renamed from: a */
    public void m1767a(int i, Notification notification) {
        m1768a(null, i, notification);
    }

    /* JADX INFO: renamed from: a */
    public void m1768a(String str, int i, Notification notification) {
        if (m1765a(notification)) {
            m1764a(new NotifyTask(this.f1731d.getPackageName(), i, str, notification));
            this.f1732e.cancel(str, i);
        } else {
            this.f1732e.notify(str, i, notification);
        }
    }

    /* JADX INFO: renamed from: b */
    public static Set<String> m1766b(Context context) {
        Set<String> set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f1726a) {
            if (string != null) {
                if (!string.equals(f1727b)) {
                    String[] strArrSplit = string.split(":");
                    HashSet hashSet = new HashSet(strArrSplit.length);
                    for (String str : strArrSplit) {
                        ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
                        if (componentNameUnflattenFromString != null) {
                            hashSet.add(componentNameUnflattenFromString.getPackageName());
                        }
                    }
                    f1728c = hashSet;
                    f1727b = string;
                }
                set = f1728c;
            } else {
                set = f1728c;
            }
        }
        return set;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m1765a(Notification notification) {
        Bundle bundleM1718a = NotificationCompat.m1718a(notification);
        return bundleM1718a != null && bundleM1718a.getBoolean("android.support.useSideChannel");
    }

    /* JADX INFO: renamed from: a */
    private void m1764a(Task task) {
        synchronized (f1729f) {
            if (f1730g == null) {
                f1730g = new SideChannelManager(this.f1731d.getApplicationContext());
            }
            f1730g.m1779a(task);
        }
    }

    private static class SideChannelManager implements ServiceConnection, Handler.Callback {

        /* JADX INFO: renamed from: a */
        private final Context f1739a;

        /* JADX INFO: renamed from: c */
        private final Handler f1741c;

        /* JADX INFO: renamed from: d */
        private final Map<ComponentName, ListenerRecord> f1742d = new HashMap();

        /* JADX INFO: renamed from: e */
        private Set<String> f1743e = new HashSet();

        /* JADX INFO: renamed from: b */
        private final HandlerThread f1740b = new HandlerThread("NotificationManagerCompat");

        SideChannelManager(Context context) {
            this.f1739a = context;
            this.f1740b.start();
            this.f1741c = new Handler(this.f1740b.getLooper(), this);
        }

        /* JADX INFO: renamed from: a */
        public void m1779a(Task task) {
            this.f1741c.obtainMessage(0, task).sendToTarget();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    m1776b((Task) message.obj);
                    break;
                case 1:
                    ServiceConnectedEvent serviceConnectedEvent = (ServiceConnectedEvent) message.obj;
                    m1772a(serviceConnectedEvent.f1737a, serviceConnectedEvent.f1738b);
                    break;
                case 2:
                    m1771a((ComponentName) message.obj);
                    break;
                case 3:
                    m1774b((ComponentName) message.obj);
                    break;
            }
            return true;
        }

        /* JADX INFO: renamed from: b */
        private void m1776b(Task task) {
            m1770a();
            for (ListenerRecord listenerRecord : this.f1742d.values()) {
                listenerRecord.f1747d.add(task);
                m1778d(listenerRecord);
            }
        }

        /* JADX INFO: renamed from: a */
        private void m1772a(ComponentName componentName, IBinder iBinder) {
            ListenerRecord listenerRecord = this.f1742d.get(componentName);
            if (listenerRecord != null) {
                listenerRecord.f1746c = INotificationSideChannel.Stub.m1682a(iBinder);
                listenerRecord.f1748e = 0;
                m1778d(listenerRecord);
            }
        }

        /* JADX INFO: renamed from: a */
        private void m1771a(ComponentName componentName) {
            ListenerRecord listenerRecord = this.f1742d.get(componentName);
            if (listenerRecord != null) {
                m1775b(listenerRecord);
            }
        }

        /* JADX INFO: renamed from: b */
        private void m1774b(ComponentName componentName) {
            ListenerRecord listenerRecord = this.f1742d.get(componentName);
            if (listenerRecord != null) {
                m1778d(listenerRecord);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service " + componentName);
            }
            this.f1741c.obtainMessage(1, new ServiceConnectedEvent(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.f1741c.obtainMessage(2, componentName).sendToTarget();
        }

        /* JADX INFO: renamed from: a */
        private void m1770a() {
            Set<String> setM1766b = NotificationManagerCompat.m1766b(this.f1739a);
            if (!setM1766b.equals(this.f1743e)) {
                this.f1743e = setM1766b;
                List<ResolveInfo> listQueryIntentServices = this.f1739a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
                HashSet<ComponentName> hashSet = new HashSet();
                for (ResolveInfo resolveInfo : listQueryIntentServices) {
                    if (setM1766b.contains(resolveInfo.serviceInfo.packageName)) {
                        ComponentName componentName = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
                        if (resolveInfo.serviceInfo.permission != null) {
                            Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                        } else {
                            hashSet.add(componentName);
                        }
                    }
                }
                for (ComponentName componentName2 : hashSet) {
                    if (!this.f1742d.containsKey(componentName2)) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                        }
                        this.f1742d.put(componentName2, new ListenerRecord(componentName2));
                    }
                }
                Iterator<Map.Entry<ComponentName, ListenerRecord>> it = this.f1742d.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<ComponentName, ListenerRecord> next = it.next();
                    if (!hashSet.contains(next.getKey())) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Removing listener record for " + next.getKey());
                        }
                        m1775b(next.getValue());
                        it.remove();
                    }
                }
            }
        }

        /* JADX INFO: renamed from: a */
        private boolean m1773a(ListenerRecord listenerRecord) {
            if (listenerRecord.f1745b) {
                return true;
            }
            listenerRecord.f1745b = this.f1739a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(listenerRecord.f1744a), this, 33);
            if (listenerRecord.f1745b) {
                listenerRecord.f1748e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + listenerRecord.f1744a);
                this.f1739a.unbindService(this);
            }
            return listenerRecord.f1745b;
        }

        /* JADX INFO: renamed from: b */
        private void m1775b(ListenerRecord listenerRecord) {
            if (listenerRecord.f1745b) {
                this.f1739a.unbindService(this);
                listenerRecord.f1745b = false;
            }
            listenerRecord.f1746c = null;
        }

        /* JADX INFO: renamed from: c */
        private void m1777c(ListenerRecord listenerRecord) {
            if (!this.f1741c.hasMessages(3, listenerRecord.f1744a)) {
                listenerRecord.f1748e++;
                if (listenerRecord.f1748e > 6) {
                    Log.w("NotifManCompat", "Giving up on delivering " + listenerRecord.f1747d.size() + " tasks to " + listenerRecord.f1744a + " after " + listenerRecord.f1748e + " retries");
                    listenerRecord.f1747d.clear();
                    return;
                }
                int i = (1 << (listenerRecord.f1748e - 1)) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Scheduling retry for " + i + " ms");
                }
                this.f1741c.sendMessageDelayed(this.f1741c.obtainMessage(3, listenerRecord.f1744a), i);
            }
        }

        /* JADX INFO: renamed from: d */
        private void m1778d(ListenerRecord listenerRecord) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + listenerRecord.f1744a + ", " + listenerRecord.f1747d.size() + " queued tasks");
            }
            if (!listenerRecord.f1747d.isEmpty()) {
                if (!m1773a(listenerRecord) || listenerRecord.f1746c == null) {
                    m1777c(listenerRecord);
                    return;
                }
                while (true) {
                    Task taskPeek = listenerRecord.f1747d.peek();
                    if (taskPeek == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Sending task " + taskPeek);
                        }
                        taskPeek.mo1769a(listenerRecord.f1746c);
                        listenerRecord.f1747d.remove();
                    } catch (DeadObjectException e) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Remote service has died: " + listenerRecord.f1744a);
                        }
                    } catch (RemoteException e2) {
                        Log.w("NotifManCompat", "RemoteException communicating with " + listenerRecord.f1744a, e2);
                    }
                }
                if (!listenerRecord.f1747d.isEmpty()) {
                    m1777c(listenerRecord);
                }
            }
        }

        private static class ListenerRecord {

            /* JADX INFO: renamed from: a */
            final ComponentName f1744a;

            /* JADX INFO: renamed from: c */
            INotificationSideChannel f1746c;

            /* JADX INFO: renamed from: b */
            boolean f1745b = false;

            /* JADX INFO: renamed from: d */
            ArrayDeque<Task> f1747d = new ArrayDeque<>();

            /* JADX INFO: renamed from: e */
            int f1748e = 0;

            ListenerRecord(ComponentName componentName) {
                this.f1744a = componentName;
            }
        }
    }

    private static class ServiceConnectedEvent {

        /* JADX INFO: renamed from: a */
        final ComponentName f1737a;

        /* JADX INFO: renamed from: b */
        final IBinder f1738b;

        ServiceConnectedEvent(ComponentName componentName, IBinder iBinder) {
            this.f1737a = componentName;
            this.f1738b = iBinder;
        }
    }

    private static class NotifyTask implements Task {

        /* JADX INFO: renamed from: a */
        final String f1733a;

        /* JADX INFO: renamed from: b */
        final int f1734b;

        /* JADX INFO: renamed from: c */
        final String f1735c;

        /* JADX INFO: renamed from: d */
        final Notification f1736d;

        NotifyTask(String str, int i, String str2, Notification notification) {
            this.f1733a = str;
            this.f1734b = i;
            this.f1735c = str2;
            this.f1736d = notification;
        }

        @Override // android.support.v4.app.NotificationManagerCompat.Task
        /* JADX INFO: renamed from: a */
        public void mo1769a(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
            iNotificationSideChannel.mo1681a(this.f1733a, this.f1734b, this.f1735c, this.f1736d);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("NotifyTask[");
            sb.append("packageName:").append(this.f1733a);
            sb.append(", id:").append(this.f1734b);
            sb.append(", tag:").append(this.f1735c);
            sb.append("]");
            return sb.toString();
        }
    }
}
