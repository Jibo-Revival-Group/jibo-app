package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class NotificationCompat {

    public static class Builder {

        /* JADX INFO: renamed from: A */
        Bundle f1670A;

        /* JADX INFO: renamed from: B */
        int f1671B;

        /* JADX INFO: renamed from: C */
        int f1672C;

        /* JADX INFO: renamed from: D */
        Notification f1673D;

        /* JADX INFO: renamed from: E */
        RemoteViews f1674E;

        /* JADX INFO: renamed from: F */
        RemoteViews f1675F;

        /* JADX INFO: renamed from: G */
        RemoteViews f1676G;

        /* JADX INFO: renamed from: H */
        String f1677H;

        /* JADX INFO: renamed from: I */
        int f1678I;

        /* JADX INFO: renamed from: J */
        String f1679J;

        /* JADX INFO: renamed from: K */
        long f1680K;

        /* JADX INFO: renamed from: L */
        int f1681L;

        /* JADX INFO: renamed from: M */
        Notification f1682M;

        /* JADX INFO: renamed from: N */
        @Deprecated
        public ArrayList<String> f1683N;

        /* JADX INFO: renamed from: a */
        public Context f1684a;

        /* JADX INFO: renamed from: b */
        public ArrayList<Action> f1685b;

        /* JADX INFO: renamed from: c */
        CharSequence f1686c;

        /* JADX INFO: renamed from: d */
        CharSequence f1687d;

        /* JADX INFO: renamed from: e */
        PendingIntent f1688e;

        /* JADX INFO: renamed from: f */
        PendingIntent f1689f;

        /* JADX INFO: renamed from: g */
        RemoteViews f1690g;

        /* JADX INFO: renamed from: h */
        Bitmap f1691h;

        /* JADX INFO: renamed from: i */
        CharSequence f1692i;

        /* JADX INFO: renamed from: j */
        int f1693j;

        /* JADX INFO: renamed from: k */
        int f1694k;

        /* JADX INFO: renamed from: l */
        boolean f1695l;

        /* JADX INFO: renamed from: m */
        boolean f1696m;

        /* JADX INFO: renamed from: n */
        Style f1697n;

        /* JADX INFO: renamed from: o */
        CharSequence f1698o;

        /* JADX INFO: renamed from: p */
        CharSequence[] f1699p;

        /* JADX INFO: renamed from: q */
        int f1700q;

        /* JADX INFO: renamed from: r */
        int f1701r;

        /* JADX INFO: renamed from: s */
        boolean f1702s;

        /* JADX INFO: renamed from: t */
        String f1703t;

        /* JADX INFO: renamed from: u */
        boolean f1704u;

        /* JADX INFO: renamed from: v */
        String f1705v;

        /* JADX INFO: renamed from: w */
        boolean f1706w;

        /* JADX INFO: renamed from: x */
        boolean f1707x;

        /* JADX INFO: renamed from: y */
        boolean f1708y;

        /* JADX INFO: renamed from: z */
        String f1709z;

        public Builder(Context context, String str) {
            this.f1685b = new ArrayList<>();
            this.f1695l = true;
            this.f1706w = false;
            this.f1671B = 0;
            this.f1672C = 0;
            this.f1678I = 0;
            this.f1681L = 0;
            this.f1682M = new Notification();
            this.f1684a = context;
            this.f1677H = str;
            this.f1682M.when = System.currentTimeMillis();
            this.f1682M.audioStreamType = -1;
            this.f1694k = 0;
            this.f1683N = new ArrayList<>();
        }

        @Deprecated
        public Builder(Context context) {
            this(context, null);
        }

        /* JADX INFO: renamed from: a */
        public Builder m1733a(long j) {
            this.f1682M.when = j;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m1732a(int i) {
            this.f1682M.icon = i;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m1738a(CharSequence charSequence) {
            this.f1686c = m1730d(charSequence);
            return this;
        }

        /* JADX INFO: renamed from: b */
        public Builder m1744b(CharSequence charSequence) {
            this.f1687d = m1730d(charSequence);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m1734a(PendingIntent pendingIntent) {
            this.f1688e = pendingIntent;
            return this;
        }

        /* JADX INFO: renamed from: b */
        public Builder m1743b(PendingIntent pendingIntent) {
            this.f1682M.deleteIntent = pendingIntent;
            return this;
        }

        /* JADX INFO: renamed from: c */
        public Builder m1747c(CharSequence charSequence) {
            this.f1682M.tickerText = m1730d(charSequence);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m1735a(Bitmap bitmap) {
            this.f1691h = bitmap;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m1736a(Uri uri) {
            this.f1682M.sound = uri;
            this.f1682M.audioStreamType = -1;
            if (Build.VERSION.SDK_INT >= 21) {
                this.f1682M.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
            }
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m1740a(boolean z) {
            m1729a(16, z);
            return this;
        }

        /* JADX INFO: renamed from: b */
        public Builder m1745b(boolean z) {
            this.f1706w = z;
            return this;
        }

        /* JADX INFO: renamed from: b */
        public Builder m1742b(int i) {
            this.f1682M.defaults = i;
            if ((i & 4) != 0) {
                this.f1682M.flags |= 1;
            }
            return this;
        }

        /* JADX INFO: renamed from: a */
        private void m1729a(int i, boolean z) {
            if (z) {
                this.f1682M.flags |= i;
            } else {
                this.f1682M.flags &= i ^ (-1);
            }
        }

        /* JADX INFO: renamed from: c */
        public Builder m1746c(int i) {
            this.f1694k = i;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m1737a(Style style) {
            if (this.f1697n != style) {
                this.f1697n = style;
                if (this.f1697n != null) {
                    this.f1697n.m1750a(this);
                }
            }
            return this;
        }

        /* JADX INFO: renamed from: d */
        public Builder m1748d(int i) {
            this.f1671B = i;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m1739a(String str) {
            this.f1677H = str;
            return this;
        }

        @Deprecated
        /* JADX INFO: renamed from: a */
        public Notification m1731a() {
            return m1741b();
        }

        /* JADX INFO: renamed from: b */
        public Notification m1741b() {
            return new NotificationCompatBuilder(this).m1756b();
        }

        /* JADX INFO: renamed from: d */
        protected static CharSequence m1730d(CharSequence charSequence) {
            if (charSequence != null && charSequence.length() > 5120) {
                return charSequence.subSequence(0, 5120);
            }
            return charSequence;
        }
    }

    public static abstract class Style {

        /* JADX INFO: renamed from: a */
        protected Builder f1710a;

        /* JADX INFO: renamed from: b */
        CharSequence f1711b;

        /* JADX INFO: renamed from: c */
        CharSequence f1712c;

        /* JADX INFO: renamed from: d */
        boolean f1713d = false;

        /* JADX INFO: renamed from: a */
        public void m1750a(Builder builder) {
            if (this.f1710a != builder) {
                this.f1710a = builder;
                if (this.f1710a != null) {
                    this.f1710a.m1737a(this);
                }
            }
        }

        /* JADX INFO: renamed from: a */
        public void mo1727a(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        }

        /* JADX INFO: renamed from: b */
        public RemoteViews m1751b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        /* JADX INFO: renamed from: c */
        public RemoteViews m1752c(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        /* JADX INFO: renamed from: d */
        public RemoteViews m1753d(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        /* JADX INFO: renamed from: a */
        public void m1749a(Bundle bundle) {
        }
    }

    public static class BigTextStyle extends Style {

        /* JADX INFO: renamed from: e */
        private CharSequence f1669e;

        public BigTextStyle() {
        }

        public BigTextStyle(Builder builder) {
            m1750a(builder);
        }

        /* JADX INFO: renamed from: a */
        public BigTextStyle m1726a(CharSequence charSequence) {
            this.f1711b = Builder.m1730d(charSequence);
            return this;
        }

        /* JADX INFO: renamed from: b */
        public BigTextStyle m1728b(CharSequence charSequence) {
            this.f1669e = Builder.m1730d(charSequence);
            return this;
        }

        @Override // android.support.v4.app.NotificationCompat.Style
        /* JADX INFO: renamed from: a */
        public void mo1727a(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigTextStyle bigTextStyleBigText = new Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.mo1717a()).setBigContentTitle(this.f1711b).bigText(this.f1669e);
                if (this.f1713d) {
                    bigTextStyleBigText.setSummaryText(this.f1712c);
                }
            }
        }
    }

    public static class Action {

        /* JADX INFO: renamed from: a */
        final Bundle f1662a;

        /* JADX INFO: renamed from: b */
        public int f1663b;

        /* JADX INFO: renamed from: c */
        public CharSequence f1664c;

        /* JADX INFO: renamed from: d */
        public PendingIntent f1665d;

        /* JADX INFO: renamed from: e */
        private final RemoteInput[] f1666e;

        /* JADX INFO: renamed from: f */
        private final RemoteInput[] f1667f;

        /* JADX INFO: renamed from: g */
        private boolean f1668g;

        /* JADX INFO: renamed from: a */
        public int m1719a() {
            return this.f1663b;
        }

        /* JADX INFO: renamed from: b */
        public CharSequence m1720b() {
            return this.f1664c;
        }

        /* JADX INFO: renamed from: c */
        public PendingIntent m1721c() {
            return this.f1665d;
        }

        /* JADX INFO: renamed from: d */
        public Bundle m1722d() {
            return this.f1662a;
        }

        /* JADX INFO: renamed from: e */
        public boolean m1723e() {
            return this.f1668g;
        }

        /* JADX INFO: renamed from: f */
        public RemoteInput[] m1724f() {
            return this.f1666e;
        }

        /* JADX INFO: renamed from: g */
        public RemoteInput[] m1725g() {
            return this.f1667f;
        }
    }

    /* JADX INFO: renamed from: a */
    public static Bundle m1718a(Notification notification) {
        if (Build.VERSION.SDK_INT >= 19) {
            return notification.extras;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return NotificationCompatJellybean.m1759a(notification);
        }
        return null;
    }
}
