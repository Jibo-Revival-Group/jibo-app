package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class FragmentController {

    /* JADX INFO: renamed from: a */
    private final FragmentHostCallback<?> f1471a;

    /* JADX INFO: renamed from: a */
    public static FragmentController m1436a(FragmentHostCallback<?> fragmentHostCallback) {
        return new FragmentController(fragmentHostCallback);
    }

    private FragmentController(FragmentHostCallback<?> fragmentHostCallback) {
        this.f1471a = fragmentHostCallback;
    }

    /* JADX INFO: renamed from: a */
    public FragmentManager m1438a() {
        return this.f1471a.m1466k();
    }

    /* JADX INFO: renamed from: a */
    public Fragment m1437a(String str) {
        return this.f1471a.f1475d.m1551b(str);
    }

    /* JADX INFO: renamed from: a */
    public void m1442a(Fragment fragment) {
        this.f1471a.f1475d.m1544a(this.f1471a, this.f1471a, fragment);
    }

    /* JADX INFO: renamed from: a */
    public View m1439a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f1471a.f1475d.onCreateView(view, str, context, attributeSet);
    }

    /* JADX INFO: renamed from: b */
    public void m1447b() {
        this.f1471a.f1475d.m1591o();
    }

    /* JADX INFO: renamed from: c */
    public Parcelable m1451c() {
        return this.f1471a.f1475d.m1588n();
    }

    /* JADX INFO: renamed from: a */
    public void m1441a(Parcelable parcelable, FragmentManagerNonConfig fragmentManagerNonConfig) {
        this.f1471a.f1475d.m1538a(parcelable, fragmentManagerNonConfig);
    }

    /* JADX INFO: renamed from: d */
    public FragmentManagerNonConfig m1452d() {
        return this.f1471a.f1475d.m1584l();
    }

    /* JADX INFO: renamed from: e */
    public void m1453e() {
        this.f1471a.f1475d.m1592p();
    }

    /* JADX INFO: renamed from: f */
    public void m1454f() {
        this.f1471a.f1475d.m1594q();
    }

    /* JADX INFO: renamed from: g */
    public void m1455g() {
        this.f1471a.f1475d.m1595r();
    }

    /* JADX INFO: renamed from: h */
    public void m1456h() {
        this.f1471a.f1475d.m1596s();
    }

    /* JADX INFO: renamed from: i */
    public void m1457i() {
        this.f1471a.f1475d.m1597t();
    }

    /* JADX INFO: renamed from: j */
    public void m1458j() {
        this.f1471a.f1475d.m1598u();
    }

    /* JADX INFO: renamed from: k */
    public void m1459k() {
        this.f1471a.f1475d.m1599v();
    }

    /* JADX INFO: renamed from: l */
    public void m1460l() {
        this.f1471a.f1475d.m1601x();
    }

    /* JADX INFO: renamed from: a */
    public void m1443a(boolean z) {
        this.f1471a.f1475d.m1546a(z);
    }

    /* JADX INFO: renamed from: b */
    public void m1449b(boolean z) {
        this.f1471a.f1475d.m1559b(z);
    }

    /* JADX INFO: renamed from: a */
    public void m1440a(Configuration configuration) {
        this.f1471a.f1475d.m1537a(configuration);
    }

    /* JADX INFO: renamed from: m */
    public void m1461m() {
        this.f1471a.f1475d.m1602y();
    }

    /* JADX INFO: renamed from: a */
    public boolean m1445a(Menu menu, MenuInflater menuInflater) {
        return this.f1471a.f1475d.m1548a(menu, menuInflater);
    }

    /* JADX INFO: renamed from: a */
    public boolean m1444a(Menu menu) {
        return this.f1471a.f1475d.m1547a(menu);
    }

    /* JADX INFO: renamed from: a */
    public boolean m1446a(MenuItem menuItem) {
        return this.f1471a.f1475d.m1549a(menuItem);
    }

    /* JADX INFO: renamed from: b */
    public boolean m1450b(MenuItem menuItem) {
        return this.f1471a.f1475d.m1560b(menuItem);
    }

    /* JADX INFO: renamed from: b */
    public void m1448b(Menu menu) {
        this.f1471a.f1475d.m1558b(menu);
    }

    /* JADX INFO: renamed from: n */
    public boolean m1462n() {
        return this.f1471a.f1475d.m1579i();
    }
}
