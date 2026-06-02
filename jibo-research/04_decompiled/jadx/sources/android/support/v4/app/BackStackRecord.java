package android.support.v4.app;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManagerImpl;
import android.support.v4.util.LogWriter;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
final class BackStackRecord extends FragmentTransaction implements FragmentManager.BackStackEntry, FragmentManagerImpl.OpGenerator {

    /* JADX INFO: renamed from: a */
    final FragmentManagerImpl f1401a;

    /* JADX INFO: renamed from: c */
    int f1403c;

    /* JADX INFO: renamed from: d */
    int f1404d;

    /* JADX INFO: renamed from: e */
    int f1405e;

    /* JADX INFO: renamed from: f */
    int f1406f;

    /* JADX INFO: renamed from: g */
    int f1407g;

    /* JADX INFO: renamed from: h */
    int f1408h;

    /* JADX INFO: renamed from: i */
    boolean f1409i;

    /* JADX INFO: renamed from: k */
    String f1411k;

    /* JADX INFO: renamed from: l */
    boolean f1412l;

    /* JADX INFO: renamed from: n */
    int f1414n;

    /* JADX INFO: renamed from: o */
    CharSequence f1415o;

    /* JADX INFO: renamed from: p */
    int f1416p;

    /* JADX INFO: renamed from: q */
    CharSequence f1417q;

    /* JADX INFO: renamed from: r */
    ArrayList<String> f1418r;

    /* JADX INFO: renamed from: s */
    ArrayList<String> f1419s;

    /* JADX INFO: renamed from: u */
    ArrayList<Runnable> f1421u;

    /* JADX INFO: renamed from: b */
    ArrayList<C0116Op> f1402b = new ArrayList<>();

    /* JADX INFO: renamed from: j */
    boolean f1410j = true;

    /* JADX INFO: renamed from: m */
    int f1413m = -1;

    /* JADX INFO: renamed from: t */
    boolean f1420t = false;

    /* JADX INFO: renamed from: android.support.v4.app.BackStackRecord$Op */
    static final class C0116Op {

        /* JADX INFO: renamed from: a */
        int f1422a;

        /* JADX INFO: renamed from: b */
        Fragment f1423b;

        /* JADX INFO: renamed from: c */
        int f1424c;

        /* JADX INFO: renamed from: d */
        int f1425d;

        /* JADX INFO: renamed from: e */
        int f1426e;

        /* JADX INFO: renamed from: f */
        int f1427f;

        C0116Op() {
        }

        C0116Op(int i, Fragment fragment) {
            this.f1422a = i;
            this.f1423b = fragment;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f1413m >= 0) {
            sb.append(" #");
            sb.append(this.f1413m);
        }
        if (this.f1411k != null) {
            sb.append(" ");
            sb.append(this.f1411k);
        }
        sb.append("}");
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    public void m1372a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        m1373a(str, printWriter, true);
    }

    /* JADX INFO: renamed from: a */
    public void m1373a(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f1411k);
            printWriter.print(" mIndex=");
            printWriter.print(this.f1413m);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f1412l);
            if (this.f1407g != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f1407g));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f1408h));
            }
            if (this.f1403c != 0 || this.f1404d != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1403c));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1404d));
            }
            if (this.f1405e != 0 || this.f1406f != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1405e));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1406f));
            }
            if (this.f1414n != 0 || this.f1415o != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1414n));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f1415o);
            }
            if (this.f1416p != 0 || this.f1417q != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1416p));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f1417q);
            }
        }
        if (!this.f1402b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str3 = str + "    ";
            int size = this.f1402b.size();
            for (int i = 0; i < size; i++) {
                C0116Op c0116Op = this.f1402b.get(i);
                switch (c0116Op.f1422a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    default:
                        str2 = "cmd=" + c0116Op.f1422a;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(c0116Op.f1423b);
                if (z) {
                    if (c0116Op.f1424c != 0 || c0116Op.f1425d != 0) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(c0116Op.f1424c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(c0116Op.f1425d));
                    }
                    if (c0116Op.f1426e != 0 || c0116Op.f1427f != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(c0116Op.f1426e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(c0116Op.f1427f));
                    }
                }
            }
        }
    }

    public BackStackRecord(FragmentManagerImpl fragmentManagerImpl) {
        this.f1401a = fragmentManagerImpl;
    }

    @Override // android.support.v4.app.FragmentManager.BackStackEntry
    /* JADX INFO: renamed from: a */
    public int mo1359a() {
        return this.f1413m;
    }

    /* JADX INFO: renamed from: a */
    void m1370a(C0116Op c0116Op) {
        this.f1402b.add(c0116Op);
        c0116Op.f1424c = this.f1403c;
        c0116Op.f1425d = this.f1404d;
        c0116Op.f1426e = this.f1405e;
        c0116Op.f1427f = this.f1406f;
    }

    @Override // android.support.v4.app.FragmentTransaction
    /* JADX INFO: renamed from: a */
    public FragmentTransaction mo1367a(Fragment fragment, String str) {
        m1357a(0, fragment, str, 1);
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    /* JADX INFO: renamed from: a */
    public FragmentTransaction mo1364a(int i, Fragment fragment) {
        m1357a(i, fragment, (String) null, 1);
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    /* JADX INFO: renamed from: a */
    public FragmentTransaction mo1365a(int i, Fragment fragment, String str) {
        m1357a(i, fragment, str, 1);
        return this;
    }

    /* JADX INFO: renamed from: a */
    private void m1357a(int i, Fragment fragment, String str, int i2) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        fragment.mFragmentManager = this.f1401a;
        if (str != null) {
            if (fragment.mTag != null && !str.equals(fragment.mTag)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
            fragment.mTag = str;
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            if (fragment.mFragmentId != 0 && fragment.mFragmentId != i) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i);
            }
            fragment.mFragmentId = i;
            fragment.mContainerId = i;
        }
        m1370a(new C0116Op(i2, fragment));
    }

    @Override // android.support.v4.app.FragmentTransaction
    /* JADX INFO: renamed from: b */
    public FragmentTransaction mo1378b(int i, Fragment fragment) {
        return mo1379b(i, fragment, null);
    }

    @Override // android.support.v4.app.FragmentTransaction
    /* JADX INFO: renamed from: b */
    public FragmentTransaction mo1379b(int i, Fragment fragment, String str) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        m1357a(i, fragment, str, 2);
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    /* JADX INFO: renamed from: a */
    public FragmentTransaction mo1366a(Fragment fragment) {
        m1370a(new C0116Op(3, fragment));
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    /* JADX INFO: renamed from: b */
    public FragmentTransaction mo1380b(Fragment fragment) {
        m1370a(new C0116Op(6, fragment));
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    /* JADX INFO: renamed from: c */
    public FragmentTransaction mo1383c(Fragment fragment) {
        m1370a(new C0116Op(7, fragment));
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    /* JADX INFO: renamed from: a */
    public FragmentTransaction mo1362a(int i, int i2) {
        return mo1363a(i, i2, 0, 0);
    }

    @Override // android.support.v4.app.FragmentTransaction
    /* JADX INFO: renamed from: a */
    public FragmentTransaction mo1363a(int i, int i2, int i3, int i4) {
        this.f1403c = i;
        this.f1404d = i2;
        this.f1405e = i3;
        this.f1406f = i4;
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    /* JADX INFO: renamed from: a */
    public FragmentTransaction mo1368a(String str) {
        if (!this.f1410j) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.f1409i = true;
        this.f1411k = str;
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    /* JADX INFO: renamed from: b */
    public FragmentTransaction mo1377b() {
        if (this.f1409i) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f1410j = false;
        return this;
    }

    /* JADX INFO: renamed from: a */
    void m1369a(int i) {
        if (this.f1409i) {
            if (FragmentManagerImpl.f1481a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            int size = this.f1402b.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0116Op c0116Op = this.f1402b.get(i2);
                if (c0116Op.f1423b != null) {
                    c0116Op.f1423b.mBackStackNesting += i;
                    if (FragmentManagerImpl.f1481a) {
                        Log.v("FragmentManager", "Bump nesting of " + c0116Op.f1423b + " to " + c0116Op.f1423b.mBackStackNesting);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public void m1384c() {
        if (this.f1421u != null) {
            int size = this.f1421u.size();
            for (int i = 0; i < size; i++) {
                this.f1421u.get(i).run();
            }
            this.f1421u = null;
        }
    }

    @Override // android.support.v4.app.FragmentTransaction
    /* JADX INFO: renamed from: d */
    public int mo1385d() {
        return m1360a(false);
    }

    @Override // android.support.v4.app.FragmentTransaction
    /* JADX INFO: renamed from: e */
    public int mo1386e() {
        return m1360a(true);
    }

    @Override // android.support.v4.app.FragmentTransaction
    /* JADX INFO: renamed from: f */
    public void mo1387f() {
        mo1377b();
        this.f1401a.m1557b((FragmentManagerImpl.OpGenerator) this, false);
    }

    @Override // android.support.v4.app.FragmentTransaction
    /* JADX INFO: renamed from: g */
    public void mo1388g() {
        mo1377b();
        this.f1401a.m1557b((FragmentManagerImpl.OpGenerator) this, true);
    }

    /* JADX INFO: renamed from: a */
    int m1360a(boolean z) {
        if (this.f1412l) {
            throw new IllegalStateException("commit already called");
        }
        if (FragmentManagerImpl.f1481a) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
            m1372a("  ", (FileDescriptor) null, printWriter, (String[]) null);
            printWriter.close();
        }
        this.f1412l = true;
        if (this.f1409i) {
            this.f1413m = this.f1401a.m1533a(this);
        } else {
            this.f1413m = -1;
        }
        this.f1401a.m1545a(this, z);
        return this.f1413m;
    }

    @Override // android.support.v4.app.FragmentManagerImpl.OpGenerator
    /* JADX INFO: renamed from: a */
    public boolean mo1375a(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        if (FragmentManagerImpl.f1481a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(false);
        if (this.f1409i) {
            this.f1401a.m1552b(this);
            return true;
        }
        return true;
    }

    /* JADX INFO: renamed from: b */
    boolean m1382b(int i) {
        int size = this.f1402b.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0116Op c0116Op = this.f1402b.get(i2);
            int i3 = c0116Op.f1423b != null ? c0116Op.f1423b.mContainerId : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    boolean m1374a(ArrayList<BackStackRecord> arrayList, int i, int i2) {
        int i3;
        if (i2 == i) {
            return false;
        }
        int size = this.f1402b.size();
        int i4 = -1;
        int i5 = 0;
        while (i5 < size) {
            C0116Op c0116Op = this.f1402b.get(i5);
            int i6 = c0116Op.f1423b != null ? c0116Op.f1423b.mContainerId : 0;
            if (i6 == 0 || i6 == i4) {
                i3 = i4;
            } else {
                for (int i7 = i; i7 < i2; i7++) {
                    BackStackRecord backStackRecord = arrayList.get(i7);
                    int size2 = backStackRecord.f1402b.size();
                    for (int i8 = 0; i8 < size2; i8++) {
                        C0116Op c0116Op2 = backStackRecord.f1402b.get(i8);
                        if ((c0116Op2.f1423b != null ? c0116Op2.f1423b.mContainerId : 0) == i6) {
                            return true;
                        }
                    }
                }
                i3 = i6;
            }
            i5++;
            i4 = i3;
        }
        return false;
    }

    /* JADX INFO: renamed from: h */
    void m1389h() {
        int size = this.f1402b.size();
        for (int i = 0; i < size; i++) {
            C0116Op c0116Op = this.f1402b.get(i);
            Fragment fragment = c0116Op.f1423b;
            if (fragment != null) {
                fragment.setNextTransition(this.f1407g, this.f1408h);
            }
            switch (c0116Op.f1422a) {
                case 1:
                    fragment.setNextAnim(c0116Op.f1424c);
                    this.f1401a.m1543a(fragment, false);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + c0116Op.f1422a);
                case 3:
                    fragment.setNextAnim(c0116Op.f1425d);
                    this.f1401a.m1578i(fragment);
                    break;
                case 4:
                    fragment.setNextAnim(c0116Op.f1425d);
                    this.f1401a.m1581j(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(c0116Op.f1424c);
                    this.f1401a.m1583k(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(c0116Op.f1425d);
                    this.f1401a.m1585l(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(c0116Op.f1424c);
                    this.f1401a.m1587m(fragment);
                    break;
                case 8:
                    this.f1401a.m1593p(fragment);
                    break;
                case 9:
                    this.f1401a.m1593p(null);
                    break;
            }
            if (!this.f1420t && c0116Op.f1422a != 1 && fragment != null) {
                this.f1401a.m1571f(fragment);
            }
        }
        if (!this.f1420t) {
            this.f1401a.m1536a(this.f1401a.f1498l, true);
        }
    }

    /* JADX INFO: renamed from: b */
    void m1381b(boolean z) {
        for (int size = this.f1402b.size() - 1; size >= 0; size--) {
            C0116Op c0116Op = this.f1402b.get(size);
            Fragment fragment = c0116Op.f1423b;
            if (fragment != null) {
                fragment.setNextTransition(FragmentManagerImpl.m1529e(this.f1407g), this.f1408h);
            }
            switch (c0116Op.f1422a) {
                case 1:
                    fragment.setNextAnim(c0116Op.f1427f);
                    this.f1401a.m1578i(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + c0116Op.f1422a);
                case 3:
                    fragment.setNextAnim(c0116Op.f1426e);
                    this.f1401a.m1543a(fragment, false);
                    break;
                case 4:
                    fragment.setNextAnim(c0116Op.f1426e);
                    this.f1401a.m1583k(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(c0116Op.f1427f);
                    this.f1401a.m1581j(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(c0116Op.f1426e);
                    this.f1401a.m1587m(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(c0116Op.f1427f);
                    this.f1401a.m1585l(fragment);
                    break;
                case 8:
                    this.f1401a.m1593p(null);
                    break;
                case 9:
                    this.f1401a.m1593p(fragment);
                    break;
            }
            if (!this.f1420t && c0116Op.f1422a != 3 && fragment != null) {
                this.f1401a.m1571f(fragment);
            }
        }
        if (!this.f1420t && z) {
            this.f1401a.m1536a(this.f1401a.f1498l, true);
        }
    }

    /* JADX INFO: renamed from: a */
    Fragment m1361a(ArrayList<Fragment> arrayList, Fragment fragment) {
        boolean z;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f1402b.size()) {
                C0116Op c0116Op = this.f1402b.get(i2);
                switch (c0116Op.f1422a) {
                    case 1:
                    case 7:
                        arrayList.add(c0116Op.f1423b);
                        break;
                    case 2:
                        Fragment fragment2 = c0116Op.f1423b;
                        int i3 = fragment2.mContainerId;
                        boolean z2 = false;
                        int size = arrayList.size() - 1;
                        Fragment fragment3 = fragment;
                        int i4 = i2;
                        while (size >= 0) {
                            Fragment fragment4 = arrayList.get(size);
                            if (fragment4.mContainerId != i3) {
                                z = z2;
                            } else if (fragment4 == fragment2) {
                                z = true;
                            } else {
                                if (fragment4 == fragment3) {
                                    this.f1402b.add(i4, new C0116Op(9, fragment4));
                                    i4++;
                                    fragment3 = null;
                                }
                                C0116Op c0116Op2 = new C0116Op(3, fragment4);
                                c0116Op2.f1424c = c0116Op.f1424c;
                                c0116Op2.f1426e = c0116Op.f1426e;
                                c0116Op2.f1425d = c0116Op.f1425d;
                                c0116Op2.f1427f = c0116Op.f1427f;
                                this.f1402b.add(i4, c0116Op2);
                                arrayList.remove(fragment4);
                                i4++;
                                z = z2;
                            }
                            size--;
                            z2 = z;
                        }
                        if (z2) {
                            this.f1402b.remove(i4);
                            i4--;
                        } else {
                            c0116Op.f1422a = 1;
                            arrayList.add(fragment2);
                        }
                        i2 = i4;
                        fragment = fragment3;
                        break;
                    case 3:
                    case 6:
                        arrayList.remove(c0116Op.f1423b);
                        if (c0116Op.f1423b == fragment) {
                            this.f1402b.add(i2, new C0116Op(9, c0116Op.f1423b));
                            i2++;
                            fragment = null;
                        }
                        break;
                    case 8:
                        this.f1402b.add(i2, new C0116Op(9, fragment));
                        i2++;
                        fragment = c0116Op.f1423b;
                        break;
                }
                i = i2 + 1;
            } else {
                return fragment;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    Fragment m1376b(ArrayList<Fragment> arrayList, Fragment fragment) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f1402b.size()) {
                C0116Op c0116Op = this.f1402b.get(i2);
                switch (c0116Op.f1422a) {
                    case 1:
                    case 7:
                        arrayList.remove(c0116Op.f1423b);
                        break;
                    case 3:
                    case 6:
                        arrayList.add(c0116Op.f1423b);
                        break;
                    case 8:
                        fragment = null;
                        break;
                    case 9:
                        fragment = c0116Op.f1423b;
                        break;
                }
                i = i2 + 1;
            } else {
                return fragment;
            }
        }
    }

    /* JADX INFO: renamed from: i */
    boolean m1390i() {
        for (int i = 0; i < this.f1402b.size(); i++) {
            if (m1358b(this.f1402b.get(i))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    void m1371a(Fragment.OnStartEnterTransitionListener onStartEnterTransitionListener) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f1402b.size()) {
                C0116Op c0116Op = this.f1402b.get(i2);
                if (m1358b(c0116Op)) {
                    c0116Op.f1423b.setOnStartEnterTransitionListener(onStartEnterTransitionListener);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private static boolean m1358b(C0116Op c0116Op) {
        Fragment fragment = c0116Op.f1423b;
        return (fragment == null || !fragment.mAdded || fragment.mView == null || fragment.mDetached || fragment.mHidden || !fragment.isPostponed()) ? false : true;
    }

    /* JADX INFO: renamed from: j */
    public String m1391j() {
        return this.f1411k;
    }

    @Override // android.support.v4.app.FragmentTransaction
    /* JADX INFO: renamed from: k */
    public boolean mo1392k() {
        return this.f1402b.isEmpty();
    }
}
