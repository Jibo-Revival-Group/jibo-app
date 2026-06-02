package android.support.v7.widget;

import android.support.v7.view.menu.MenuPresenter;
import android.view.Menu;
import android.view.Window;

/* JADX INFO: loaded from: classes.dex */
public interface DecorContentParent {
    /* JADX INFO: renamed from: a */
    void mo3708a(int i);

    /* JADX INFO: renamed from: a */
    void mo3709a(Menu menu, MenuPresenter.Callback callback);

    /* JADX INFO: renamed from: f */
    boolean mo3715f();

    /* JADX INFO: renamed from: g */
    boolean mo3716g();

    /* JADX INFO: renamed from: h */
    boolean mo3717h();

    /* JADX INFO: renamed from: i */
    boolean mo3718i();

    /* JADX INFO: renamed from: j */
    boolean mo3719j();

    /* JADX INFO: renamed from: k */
    void mo3720k();

    /* JADX INFO: renamed from: l */
    void mo3721l();

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);
}
