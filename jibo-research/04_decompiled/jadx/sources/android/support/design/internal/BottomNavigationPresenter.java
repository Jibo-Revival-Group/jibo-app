package android.support.design.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.SubMenuBuilder;

/* JADX INFO: loaded from: classes.dex */
public class BottomNavigationPresenter implements MenuPresenter {

    /* JADX INFO: renamed from: a */
    private MenuBuilder f413a;

    /* JADX INFO: renamed from: b */
    private BottomNavigationMenuView f414b;

    /* JADX INFO: renamed from: c */
    private boolean f415c = false;

    /* JADX INFO: renamed from: d */
    private int f416d;

    /* JADX INFO: renamed from: a */
    public void m348a(BottomNavigationMenuView bottomNavigationMenuView) {
        this.f414b = bottomNavigationMenuView;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public void mo346a(Context context, MenuBuilder menuBuilder) {
        this.f414b.mo343a(this.f413a);
        this.f413a = menuBuilder;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public void mo351a(boolean z) {
        if (!this.f415c) {
            if (z) {
                this.f414b.m341a();
            } else {
                this.f414b.m344b();
            }
        }
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public void mo350a(MenuPresenter.Callback callback) {
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public boolean mo354a(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public void mo349a(MenuBuilder menuBuilder, boolean z) {
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public boolean mo352a() {
        return false;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public boolean mo353a(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: b */
    public boolean mo357b(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    /* JADX INFO: renamed from: a */
    public void m345a(int i) {
        this.f416d = i;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: b */
    public int mo355b() {
        return this.f416d;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: c */
    public Parcelable mo358c() {
        SavedState savedState = new SavedState();
        savedState.f417a = this.f414b.getSelectedItemId();
        return savedState;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public void mo347a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f414b.m342a(((SavedState) parcelable).f417a);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m356b(boolean z) {
        this.f415c = z;
    }

    static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.support.design.internal.BottomNavigationPresenter.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* JADX INFO: renamed from: a */
        int f417a;

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f417a = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f417a);
        }
    }
}
