package android.support.v4.app;

import android.app.Notification;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class NotificationCompatBuilder implements NotificationBuilderWithBuilderAccessor {

    /* JADX INFO: renamed from: a */
    private final Notification.Builder f1714a;

    /* JADX INFO: renamed from: b */
    private final NotificationCompat.Builder f1715b;

    /* JADX INFO: renamed from: c */
    private RemoteViews f1716c;

    /* JADX INFO: renamed from: d */
    private RemoteViews f1717d;

    /* JADX INFO: renamed from: e */
    private final List<Bundle> f1718e = new ArrayList();

    /* JADX INFO: renamed from: f */
    private final Bundle f1719f = new Bundle();

    /* JADX INFO: renamed from: g */
    private int f1720g;

    /* JADX INFO: renamed from: h */
    private RemoteViews f1721h;

    NotificationCompatBuilder(NotificationCompat.Builder builder) {
        this.f1715b = builder;
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1714a = new Notification.Builder(builder.f1684a, builder.f1677H);
        } else {
            this.f1714a = new Notification.Builder(builder.f1684a);
        }
        Notification notification = builder.f1682M;
        this.f1714a.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, builder.f1690g).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(builder.f1686c).setContentText(builder.f1687d).setContentInfo(builder.f1692i).setContentIntent(builder.f1688e).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(builder.f1689f, (notification.flags & 128) != 0).setLargeIcon(builder.f1691h).setNumber(builder.f1693j).setProgress(builder.f1700q, builder.f1701r, builder.f1702s);
        if (Build.VERSION.SDK_INT < 21) {
            this.f1714a.setSound(notification.sound, notification.audioStreamType);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.f1714a.setSubText(builder.f1698o).setUsesChronometer(builder.f1696m).setPriority(builder.f1694k);
            Iterator<NotificationCompat.Action> it = builder.f1685b.iterator();
            while (it.hasNext()) {
                m1755a(it.next());
            }
            if (builder.f1670A != null) {
                this.f1719f.putAll(builder.f1670A);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (builder.f1706w) {
                    this.f1719f.putBoolean("android.support.localOnly", true);
                }
                if (builder.f1703t != null) {
                    this.f1719f.putString("android.support.groupKey", builder.f1703t);
                    if (builder.f1704u) {
                        this.f1719f.putBoolean("android.support.isGroupSummary", true);
                    } else {
                        this.f1719f.putBoolean("android.support.useSideChannel", true);
                    }
                }
                if (builder.f1705v != null) {
                    this.f1719f.putString("android.support.sortKey", builder.f1705v);
                }
            }
            this.f1716c = builder.f1674E;
            this.f1717d = builder.f1675F;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1714a.setShowWhen(builder.f1695l);
            if (Build.VERSION.SDK_INT < 21 && builder.f1683N != null && !builder.f1683N.isEmpty()) {
                this.f1719f.putStringArray("android.people", (String[]) builder.f1683N.toArray(new String[builder.f1683N.size()]));
            }
        }
        if (Build.VERSION.SDK_INT >= 20) {
            this.f1714a.setLocalOnly(builder.f1706w).setGroup(builder.f1703t).setGroupSummary(builder.f1704u).setSortKey(builder.f1705v);
            this.f1720g = builder.f1681L;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.f1714a.setCategory(builder.f1709z).setColor(builder.f1671B).setVisibility(builder.f1672C).setPublicVersion(builder.f1673D).setSound(notification.sound, notification.audioAttributes);
            Iterator<String> it2 = builder.f1683N.iterator();
            while (it2.hasNext()) {
                this.f1714a.addPerson(it2.next());
            }
            this.f1721h = builder.f1676G;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.f1714a.setExtras(builder.f1670A).setRemoteInputHistory(builder.f1699p);
            if (builder.f1674E != null) {
                this.f1714a.setCustomContentView(builder.f1674E);
            }
            if (builder.f1675F != null) {
                this.f1714a.setCustomBigContentView(builder.f1675F);
            }
            if (builder.f1676G != null) {
                this.f1714a.setCustomHeadsUpContentView(builder.f1676G);
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1714a.setBadgeIconType(builder.f1678I).setShortcutId(builder.f1679J).setTimeoutAfter(builder.f1680K).setGroupAlertBehavior(builder.f1681L);
            if (builder.f1708y) {
                this.f1714a.setColorized(builder.f1707x);
            }
            if (!TextUtils.isEmpty(builder.f1677H)) {
                this.f1714a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
    }

    @Override // android.support.v4.app.NotificationBuilderWithBuilderAccessor
    /* JADX INFO: renamed from: a */
    public Notification.Builder mo1717a() {
        return this.f1714a;
    }

    /* JADX INFO: renamed from: b */
    public Notification m1756b() {
        Bundle bundleM1718a;
        RemoteViews remoteViewsM1753d;
        RemoteViews remoteViewsM1752c;
        NotificationCompat.Style style = this.f1715b.f1697n;
        if (style != null) {
            style.mo1727a(this);
        }
        RemoteViews remoteViewsM1751b = style != null ? style.m1751b(this) : null;
        Notification notificationM1757c = m1757c();
        if (remoteViewsM1751b != null) {
            notificationM1757c.contentView = remoteViewsM1751b;
        } else if (this.f1715b.f1674E != null) {
            notificationM1757c.contentView = this.f1715b.f1674E;
        }
        if (Build.VERSION.SDK_INT >= 16 && style != null && (remoteViewsM1752c = style.m1752c(this)) != null) {
            notificationM1757c.bigContentView = remoteViewsM1752c;
        }
        if (Build.VERSION.SDK_INT >= 21 && style != null && (remoteViewsM1753d = this.f1715b.f1697n.m1753d(this)) != null) {
            notificationM1757c.headsUpContentView = remoteViewsM1753d;
        }
        if (Build.VERSION.SDK_INT >= 16 && style != null && (bundleM1718a = NotificationCompat.m1718a(notificationM1757c)) != null) {
            style.m1749a(bundleM1718a);
        }
        return notificationM1757c;
    }

    /* JADX INFO: renamed from: a */
    private void m1755a(NotificationCompat.Action action) {
        Bundle bundle;
        if (Build.VERSION.SDK_INT >= 20) {
            Notification.Action.Builder builder = new Notification.Action.Builder(action.m1719a(), action.m1720b(), action.m1721c());
            if (action.m1724f() != null) {
                for (android.app.RemoteInput remoteInput : RemoteInput.m1783a(action.m1724f())) {
                    builder.addRemoteInput(remoteInput);
                }
            }
            if (action.m1722d() != null) {
                bundle = new Bundle(action.m1722d());
            } else {
                bundle = new Bundle();
            }
            bundle.putBoolean("android.support.allowGeneratedReplies", action.m1723e());
            if (Build.VERSION.SDK_INT >= 24) {
                builder.setAllowGeneratedReplies(action.m1723e());
            }
            builder.addExtras(bundle);
            this.f1714a.addAction(builder.build());
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.f1718e.add(NotificationCompatJellybean.m1758a(this.f1714a, action));
        }
    }

    /* JADX INFO: renamed from: c */
    protected Notification m1757c() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.f1714a.build();
        }
        if (Build.VERSION.SDK_INT >= 24) {
            Notification notificationBuild = this.f1714a.build();
            if (this.f1720g != 0) {
                if (notificationBuild.getGroup() != null && (notificationBuild.flags & 512) != 0 && this.f1720g == 2) {
                    m1754a(notificationBuild);
                }
                if (notificationBuild.getGroup() != null && (notificationBuild.flags & 512) == 0 && this.f1720g == 1) {
                    m1754a(notificationBuild);
                    return notificationBuild;
                }
                return notificationBuild;
            }
            return notificationBuild;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.f1714a.setExtras(this.f1719f);
            Notification notificationBuild2 = this.f1714a.build();
            if (this.f1716c != null) {
                notificationBuild2.contentView = this.f1716c;
            }
            if (this.f1717d != null) {
                notificationBuild2.bigContentView = this.f1717d;
            }
            if (this.f1721h != null) {
                notificationBuild2.headsUpContentView = this.f1721h;
            }
            if (this.f1720g != 0) {
                if (notificationBuild2.getGroup() != null && (notificationBuild2.flags & 512) != 0 && this.f1720g == 2) {
                    m1754a(notificationBuild2);
                }
                if (notificationBuild2.getGroup() != null && (notificationBuild2.flags & 512) == 0 && this.f1720g == 1) {
                    m1754a(notificationBuild2);
                    return notificationBuild2;
                }
                return notificationBuild2;
            }
            return notificationBuild2;
        }
        if (Build.VERSION.SDK_INT >= 20) {
            this.f1714a.setExtras(this.f1719f);
            Notification notificationBuild3 = this.f1714a.build();
            if (this.f1716c != null) {
                notificationBuild3.contentView = this.f1716c;
            }
            if (this.f1717d != null) {
                notificationBuild3.bigContentView = this.f1717d;
            }
            if (this.f1720g != 0) {
                if (notificationBuild3.getGroup() != null && (notificationBuild3.flags & 512) != 0 && this.f1720g == 2) {
                    m1754a(notificationBuild3);
                }
                if (notificationBuild3.getGroup() != null && (notificationBuild3.flags & 512) == 0 && this.f1720g == 1) {
                    m1754a(notificationBuild3);
                    return notificationBuild3;
                }
                return notificationBuild3;
            }
            return notificationBuild3;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            SparseArray<Bundle> sparseArrayM1761a = NotificationCompatJellybean.m1761a(this.f1718e);
            if (sparseArrayM1761a != null) {
                this.f1719f.putSparseParcelableArray("android.support.actionExtras", sparseArrayM1761a);
            }
            this.f1714a.setExtras(this.f1719f);
            Notification notificationBuild4 = this.f1714a.build();
            if (this.f1716c != null) {
                notificationBuild4.contentView = this.f1716c;
            }
            if (this.f1717d != null) {
                notificationBuild4.bigContentView = this.f1717d;
                return notificationBuild4;
            }
            return notificationBuild4;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            Notification notificationBuild5 = this.f1714a.build();
            Bundle bundleM1718a = NotificationCompat.m1718a(notificationBuild5);
            Bundle bundle = new Bundle(this.f1719f);
            for (String str : this.f1719f.keySet()) {
                if (bundleM1718a.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            bundleM1718a.putAll(bundle);
            SparseArray<Bundle> sparseArrayM1761a2 = NotificationCompatJellybean.m1761a(this.f1718e);
            if (sparseArrayM1761a2 != null) {
                NotificationCompat.m1718a(notificationBuild5).putSparseParcelableArray("android.support.actionExtras", sparseArrayM1761a2);
            }
            if (this.f1716c != null) {
                notificationBuild5.contentView = this.f1716c;
            }
            if (this.f1717d != null) {
                notificationBuild5.bigContentView = this.f1717d;
            }
            return notificationBuild5;
        }
        return this.f1714a.getNotification();
    }

    /* JADX INFO: renamed from: a */
    private void m1754a(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -2;
        notification.defaults &= -3;
    }
}
