package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.SpinnerAdapter;

/* JADX INFO: loaded from: classes.dex */
public interface DecorToolbar {
    /* JADX INFO: renamed from: a */
    ViewPropertyAnimatorCompat mo4046a(int i, long j);

    /* JADX INFO: renamed from: a */
    ViewGroup mo4047a();

    /* JADX INFO: renamed from: a */
    void mo4048a(int i);

    /* JADX INFO: renamed from: a */
    void mo4049a(Drawable drawable);

    /* JADX INFO: renamed from: a */
    void mo4050a(MenuPresenter.Callback callback, MenuBuilder.Callback callback2);

    /* JADX INFO: renamed from: a */
    void mo4051a(ScrollingTabContainerView scrollingTabContainerView);

    /* JADX INFO: renamed from: a */
    void mo4052a(Menu menu, MenuPresenter.Callback callback);

    /* JADX INFO: renamed from: a */
    void mo4053a(View view);

    /* JADX INFO: renamed from: a */
    void mo4054a(Window.Callback callback);

    /* JADX INFO: renamed from: a */
    void mo4055a(SpinnerAdapter spinnerAdapter, AdapterView.OnItemSelectedListener onItemSelectedListener);

    /* JADX INFO: renamed from: a */
    void mo4056a(CharSequence charSequence);

    /* JADX INFO: renamed from: a */
    void mo4057a(boolean z);

    /* JADX INFO: renamed from: b */
    Context mo4058b();

    /* JADX INFO: renamed from: b */
    void mo4059b(int i);

    /* JADX INFO: renamed from: b */
    void mo4060b(Drawable drawable);

    /* JADX INFO: renamed from: b */
    void mo4061b(CharSequence charSequence);

    /* JADX INFO: renamed from: b */
    void mo4062b(boolean z);

    /* JADX INFO: renamed from: c */
    void mo4063c(int i);

    /* JADX INFO: renamed from: c */
    void mo4064c(Drawable drawable);

    /* JADX INFO: renamed from: c */
    void mo4065c(CharSequence charSequence);

    /* JADX INFO: renamed from: c */
    boolean mo4066c();

    /* JADX INFO: renamed from: d */
    void mo4067d();

    /* JADX INFO: renamed from: d */
    void mo4068d(int i);

    /* JADX INFO: renamed from: d */
    void mo4069d(Drawable drawable);

    /* JADX INFO: renamed from: d */
    void mo4070d(CharSequence charSequence);

    /* JADX INFO: renamed from: e */
    CharSequence mo4071e();

    /* JADX INFO: renamed from: e */
    void mo4072e(int i);

    /* JADX INFO: renamed from: f */
    CharSequence mo4073f();

    /* JADX INFO: renamed from: f */
    void mo4074f(int i);

    /* JADX INFO: renamed from: g */
    void mo4075g();

    /* JADX INFO: renamed from: g */
    void mo4076g(int i);

    /* JADX INFO: renamed from: h */
    void mo4077h();

    /* JADX INFO: renamed from: h */
    void mo4078h(int i);

    /* JADX INFO: renamed from: i */
    boolean mo4079i();

    /* JADX INFO: renamed from: j */
    boolean mo4080j();

    /* JADX INFO: renamed from: k */
    boolean mo4081k();

    /* JADX INFO: renamed from: l */
    boolean mo4082l();

    /* JADX INFO: renamed from: m */
    boolean mo4083m();

    /* JADX INFO: renamed from: n */
    void mo4084n();

    /* JADX INFO: renamed from: o */
    void mo4085o();

    /* JADX INFO: renamed from: p */
    int mo4086p();

    /* JADX INFO: renamed from: q */
    boolean mo4087q();

    /* JADX INFO: renamed from: r */
    int mo4088r();

    /* JADX INFO: renamed from: s */
    int mo4089s();

    /* JADX INFO: renamed from: t */
    int mo4090t();

    /* JADX INFO: renamed from: u */
    View mo4091u();

    /* JADX INFO: renamed from: v */
    int mo4092v();

    /* JADX INFO: renamed from: w */
    int mo4093w();

    /* JADX INFO: renamed from: x */
    Menu mo4094x();
}
