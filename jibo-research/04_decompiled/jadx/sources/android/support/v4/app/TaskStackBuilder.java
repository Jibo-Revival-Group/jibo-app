package android.support.v4.app;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import net.sqlcipher.database.SQLiteDatabase;

/* JADX INFO: loaded from: classes.dex */
public final class TaskStackBuilder implements Iterable<Intent> {

    /* JADX INFO: renamed from: a */
    private static final TaskStackBuilderBaseImpl f1767a;

    /* JADX INFO: renamed from: b */
    private final ArrayList<Intent> f1768b = new ArrayList<>();

    /* JADX INFO: renamed from: c */
    private final Context f1769c;

    public interface SupportParentable {
        Intent getSupportParentActivityIntent();
    }

    static class TaskStackBuilderBaseImpl {
        TaskStackBuilderBaseImpl() {
        }

        /* JADX INFO: renamed from: a */
        public PendingIntent mo1816a(Context context, Intent[] intentArr, int i, int i2, Bundle bundle) {
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            return PendingIntent.getActivities(context, i, intentArr, i2);
        }
    }

    static class TaskStackBuilderApi16Impl extends TaskStackBuilderBaseImpl {
        TaskStackBuilderApi16Impl() {
        }

        @Override // android.support.v4.app.TaskStackBuilder.TaskStackBuilderBaseImpl
        /* JADX INFO: renamed from: a */
        public PendingIntent mo1816a(Context context, Intent[] intentArr, int i, int i2, Bundle bundle) {
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            return PendingIntent.getActivities(context, i, intentArr, i2, bundle);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            f1767a = new TaskStackBuilderApi16Impl();
        } else {
            f1767a = new TaskStackBuilderBaseImpl();
        }
    }

    private TaskStackBuilder(Context context) {
        this.f1769c = context;
    }

    /* JADX INFO: renamed from: a */
    public static TaskStackBuilder m1807a(Context context) {
        return new TaskStackBuilder(context);
    }

    /* JADX INFO: renamed from: a */
    public TaskStackBuilder m1812a(Intent intent) {
        this.f1768b.add(intent);
        return this;
    }

    /* JADX INFO: renamed from: b */
    public TaskStackBuilder m1815b(Intent intent) {
        ComponentName component = intent.getComponent();
        if (component == null) {
            component = intent.resolveActivity(this.f1769c.getPackageManager());
        }
        if (component != null) {
            m1811a(component);
        }
        m1812a(intent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public TaskStackBuilder m1810a(Activity activity) {
        Intent supportParentActivityIntent = null;
        if (activity instanceof SupportParentable) {
            supportParentActivityIntent = ((SupportParentable) activity).getSupportParentActivityIntent();
        }
        Intent intentM1711a = supportParentActivityIntent == null ? NavUtils.m1711a(activity) : supportParentActivityIntent;
        if (intentM1711a != null) {
            ComponentName component = intentM1711a.getComponent();
            if (component == null) {
                component = intentM1711a.resolveActivity(this.f1769c.getPackageManager());
            }
            m1811a(component);
            m1812a(intentM1711a);
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public TaskStackBuilder m1811a(ComponentName componentName) {
        int size = this.f1768b.size();
        try {
            Intent intentM1712a = NavUtils.m1712a(this.f1769c, componentName);
            while (intentM1712a != null) {
                this.f1768b.add(size, intentM1712a);
                intentM1712a = NavUtils.m1712a(this.f1769c, intentM1712a.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f1768b.iterator();
    }

    /* JADX INFO: renamed from: a */
    public void m1813a() {
        m1814a((Bundle) null);
    }

    /* JADX INFO: renamed from: a */
    public void m1814a(Bundle bundle) {
        if (this.f1768b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.f1768b.toArray(new Intent[this.f1768b.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (!ContextCompat.m1834a(this.f1769c, intentArr, bundle)) {
            Intent intent = new Intent(intentArr[intentArr.length - 1]);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            this.f1769c.startActivity(intent);
        }
    }

    /* JADX INFO: renamed from: a */
    public PendingIntent m1808a(int i, int i2) {
        return m1809a(i, i2, null);
    }

    /* JADX INFO: renamed from: a */
    public PendingIntent m1809a(int i, int i2, Bundle bundle) {
        if (this.f1768b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
        }
        Intent[] intentArr = (Intent[]) this.f1768b.toArray(new Intent[this.f1768b.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        return f1767a.mo1816a(this.f1769c, intentArr, i, i2, bundle);
    }
}
