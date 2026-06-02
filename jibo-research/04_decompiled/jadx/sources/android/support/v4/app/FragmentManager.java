package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentManager {

    public interface BackStackEntry {
        /* JADX INFO: renamed from: a */
        int mo1359a();
    }

    public interface OnBackStackChangedListener {
        /* JADX INFO: renamed from: a */
        void m1498a();
    }

    /* JADX INFO: renamed from: a */
    public abstract Fragment.SavedState mo1467a(Fragment fragment);

    /* JADX INFO: renamed from: a */
    public abstract Fragment mo1468a(int i);

    /* JADX INFO: renamed from: a */
    public abstract Fragment mo1469a(Bundle bundle, String str);

    /* JADX INFO: renamed from: a */
    public abstract Fragment mo1470a(String str);

    /* JADX INFO: renamed from: a */
    public abstract FragmentTransaction mo1471a();

    /* JADX INFO: renamed from: a */
    public abstract void mo1472a(int i, int i2);

    /* JADX INFO: renamed from: a */
    public abstract void mo1473a(Bundle bundle, String str, Fragment fragment);

    /* JADX INFO: renamed from: a */
    public abstract void mo1474a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    /* JADX INFO: renamed from: a */
    public abstract boolean mo1475a(String str, int i);

    /* JADX INFO: renamed from: b */
    public abstract BackStackEntry mo1476b(int i);

    /* JADX INFO: renamed from: b */
    public abstract boolean mo1477b();

    /* JADX INFO: renamed from: b */
    public abstract boolean mo1478b(int i, int i2);

    /* JADX INFO: renamed from: c */
    public abstract void mo1479c();

    /* JADX INFO: renamed from: d */
    public abstract boolean mo1480d();

    /* JADX INFO: renamed from: e */
    public abstract int mo1481e();

    /* JADX INFO: renamed from: f */
    public abstract List<Fragment> mo1482f();

    /* JADX INFO: renamed from: g */
    public abstract boolean mo1483g();

    public static abstract class FragmentLifecycleCallbacks {
        /* JADX INFO: renamed from: a */
        public void m1485a(FragmentManager fragmentManager, Fragment fragment, Context context) {
        }

        /* JADX INFO: renamed from: b */
        public void m1489b(FragmentManager fragmentManager, Fragment fragment, Context context) {
        }

        /* JADX INFO: renamed from: a */
        public void m1486a(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        /* JADX INFO: renamed from: b */
        public void m1490b(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        /* JADX INFO: renamed from: c */
        public void m1492c(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        /* JADX INFO: renamed from: a */
        public void m1487a(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
        }

        /* JADX INFO: renamed from: a */
        public void m1484a(FragmentManager fragmentManager, Fragment fragment) {
        }

        /* JADX INFO: renamed from: b */
        public void m1488b(FragmentManager fragmentManager, Fragment fragment) {
        }

        /* JADX INFO: renamed from: c */
        public void m1491c(FragmentManager fragmentManager, Fragment fragment) {
        }

        /* JADX INFO: renamed from: d */
        public void m1493d(FragmentManager fragmentManager, Fragment fragment) {
        }

        /* JADX INFO: renamed from: d */
        public void m1494d(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        /* JADX INFO: renamed from: e */
        public void m1495e(FragmentManager fragmentManager, Fragment fragment) {
        }

        /* JADX INFO: renamed from: f */
        public void m1496f(FragmentManager fragmentManager, Fragment fragment) {
        }

        /* JADX INFO: renamed from: g */
        public void m1497g(FragmentManager fragmentManager, Fragment fragment) {
        }
    }
}
