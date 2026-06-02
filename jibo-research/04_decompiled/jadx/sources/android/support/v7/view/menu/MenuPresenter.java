package android.support.v7.view.menu;

import android.content.Context;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public interface MenuPresenter {

    public interface Callback {
        /* JADX INFO: renamed from: a */
        void mo3327a(MenuBuilder menuBuilder, boolean z);

        /* JADX INFO: renamed from: a */
        boolean mo3328a(MenuBuilder menuBuilder);
    }

    /* JADX INFO: renamed from: a */
    void mo346a(Context context, MenuBuilder menuBuilder);

    /* JADX INFO: renamed from: a */
    void mo347a(Parcelable parcelable);

    /* JADX INFO: renamed from: a */
    void mo349a(MenuBuilder menuBuilder, boolean z);

    /* JADX INFO: renamed from: a */
    void mo350a(Callback callback);

    /* JADX INFO: renamed from: a */
    void mo351a(boolean z);

    /* JADX INFO: renamed from: a */
    boolean mo352a();

    /* JADX INFO: renamed from: a */
    boolean mo353a(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl);

    /* JADX INFO: renamed from: a */
    boolean mo354a(SubMenuBuilder subMenuBuilder);

    /* JADX INFO: renamed from: b */
    int mo355b();

    /* JADX INFO: renamed from: b */
    boolean mo357b(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl);

    /* JADX INFO: renamed from: c */
    Parcelable mo358c();
}
