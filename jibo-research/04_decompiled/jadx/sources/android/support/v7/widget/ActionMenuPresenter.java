package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ActionProvider;
import android.support.v7.appcompat.R;
import android.support.v7.view.ActionBarPolicy;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.BaseMenuPresenter;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.ShowableListMenu;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.widget.ActionMenuView;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class ActionMenuPresenter extends BaseMenuPresenter implements ActionProvider.SubUiVisibilityListener {

    /* JADX INFO: renamed from: A */
    private ActionMenuPopupCallback f3527A;

    /* JADX INFO: renamed from: g */
    OverflowMenuButton f3528g;

    /* JADX INFO: renamed from: h */
    OverflowPopup f3529h;

    /* JADX INFO: renamed from: i */
    ActionButtonSubmenu f3530i;

    /* JADX INFO: renamed from: j */
    OpenOverflowRunnable f3531j;

    /* JADX INFO: renamed from: k */
    final PopupPresenterCallback f3532k;

    /* JADX INFO: renamed from: l */
    int f3533l;

    /* JADX INFO: renamed from: m */
    private Drawable f3534m;

    /* JADX INFO: renamed from: n */
    private boolean f3535n;

    /* JADX INFO: renamed from: o */
    private boolean f3536o;

    /* JADX INFO: renamed from: p */
    private boolean f3537p;

    /* JADX INFO: renamed from: q */
    private int f3538q;

    /* JADX INFO: renamed from: r */
    private int f3539r;

    /* JADX INFO: renamed from: s */
    private int f3540s;

    /* JADX INFO: renamed from: t */
    private boolean f3541t;

    /* JADX INFO: renamed from: u */
    private boolean f3542u;

    /* JADX INFO: renamed from: v */
    private boolean f3543v;

    /* JADX INFO: renamed from: w */
    private boolean f3544w;

    /* JADX INFO: renamed from: x */
    private int f3545x;

    /* JADX INFO: renamed from: y */
    private final SparseBooleanArray f3546y;

    /* JADX INFO: renamed from: z */
    private View f3547z;

    public ActionMenuPresenter(Context context) {
        super(context, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
        this.f3546y = new SparseBooleanArray();
        this.f3532k = new PopupPresenterCallback();
    }

    @Override // android.support.v7.view.menu.BaseMenuPresenter, android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public void mo346a(Context context, MenuBuilder menuBuilder) {
        super.mo346a(context, menuBuilder);
        Resources resources = context.getResources();
        ActionBarPolicy actionBarPolicyM3462a = ActionBarPolicy.m3462a(context);
        if (!this.f3537p) {
            this.f3536o = actionBarPolicyM3462a.m3464b();
        }
        if (!this.f3543v) {
            this.f3538q = actionBarPolicyM3462a.m3465c();
        }
        if (!this.f3541t) {
            this.f3540s = actionBarPolicyM3462a.m3463a();
        }
        int measuredWidth = this.f3538q;
        if (this.f3536o) {
            if (this.f3528g == null) {
                this.f3528g = new OverflowMenuButton(this.f3262a);
                if (this.f3535n) {
                    this.f3528g.setImageDrawable(this.f3534m);
                    this.f3534m = null;
                    this.f3535n = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f3528g.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.f3528g.getMeasuredWidth();
        } else {
            this.f3528g = null;
        }
        this.f3539r = measuredWidth;
        this.f3545x = (int) (56.0f * resources.getDisplayMetrics().density);
        this.f3547z = null;
    }

    /* JADX INFO: renamed from: a */
    public void m3729a(Configuration configuration) {
        if (!this.f3541t) {
            this.f3540s = ActionBarPolicy.m3462a(this.f3263b).m3463a();
        }
        if (this.f3264c != null) {
            this.f3264c.mo394a(true);
        }
    }

    /* JADX INFO: renamed from: c */
    public void m3732c(boolean z) {
        this.f3536o = z;
        this.f3537p = true;
    }

    /* JADX INFO: renamed from: d */
    public void m3733d(boolean z) {
        this.f3544w = z;
    }

    /* JADX INFO: renamed from: a */
    public void m3730a(Drawable drawable) {
        if (this.f3528g != null) {
            this.f3528g.setImageDrawable(drawable);
        } else {
            this.f3535n = true;
            this.f3534m = drawable;
        }
    }

    /* JADX INFO: renamed from: e */
    public Drawable m3734e() {
        if (this.f3528g != null) {
            return this.f3528g.getDrawable();
        }
        if (this.f3535n) {
            return this.f3534m;
        }
        return null;
    }

    @Override // android.support.v7.view.menu.BaseMenuPresenter
    /* JADX INFO: renamed from: a */
    public MenuView mo3514a(ViewGroup viewGroup) {
        MenuView menuView = this.f3267f;
        MenuView menuViewMo3514a = super.mo3514a(viewGroup);
        if (menuView != menuViewMo3514a) {
            ((ActionMenuView) menuViewMo3514a).setPresenter(this);
        }
        return menuViewMo3514a;
    }

    @Override // android.support.v7.view.menu.BaseMenuPresenter
    /* JADX INFO: renamed from: a */
    public View mo3515a(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        View actionView = menuItemImpl.getActionView();
        if (actionView == null || menuItemImpl.m3652n()) {
            actionView = super.mo3515a(menuItemImpl, view, viewGroup);
        }
        actionView.setVisibility(menuItemImpl.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // android.support.v7.view.menu.BaseMenuPresenter
    /* JADX INFO: renamed from: a */
    public void mo3517a(MenuItemImpl menuItemImpl, MenuView.ItemView itemView) {
        itemView.mo336a(menuItemImpl, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) itemView;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f3267f);
        if (this.f3527A == null) {
            this.f3527A = new ActionMenuPopupCallback();
        }
        actionMenuItemView.setPopupCallback(this.f3527A);
    }

    @Override // android.support.v7.view.menu.BaseMenuPresenter
    /* JADX INFO: renamed from: a */
    public boolean mo3519a(int i, MenuItemImpl menuItemImpl) {
        return menuItemImpl.m3648j();
    }

    @Override // android.support.v7.view.menu.BaseMenuPresenter, android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public void mo351a(boolean z) {
        boolean z2 = false;
        super.mo351a(z);
        ((View) this.f3267f).requestLayout();
        if (this.f3264c != null) {
            ArrayList<MenuItemImpl> arrayListM3618k = this.f3264c.m3618k();
            int size = arrayListM3618k.size();
            for (int i = 0; i < size; i++) {
                ActionProvider actionProviderMo2022a = arrayListM3618k.get(i).mo2022a();
                if (actionProviderMo2022a != null) {
                    actionProviderMo2022a.m2489a(this);
                }
            }
        }
        ArrayList<MenuItemImpl> arrayListM3619l = this.f3264c != null ? this.f3264c.m3619l() : null;
        if (this.f3536o && arrayListM3619l != null) {
            int size2 = arrayListM3619l.size();
            if (size2 == 1) {
                z2 = !arrayListM3619l.get(0).isActionViewExpanded();
            } else {
                z2 = size2 > 0;
            }
        }
        if (z2) {
            if (this.f3528g == null) {
                this.f3528g = new OverflowMenuButton(this.f3262a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f3528g.getParent();
            if (viewGroup != this.f3267f) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f3528g);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f3267f;
                actionMenuView.addView(this.f3528g, actionMenuView.m3754c());
            }
        } else if (this.f3528g != null && this.f3528g.getParent() == this.f3267f) {
            ((ViewGroup) this.f3267f).removeView(this.f3528g);
        }
        ((ActionMenuView) this.f3267f).setOverflowReserved(this.f3536o);
    }

    @Override // android.support.v7.view.menu.BaseMenuPresenter
    /* JADX INFO: renamed from: a */
    public boolean mo3520a(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.f3528g) {
            return false;
        }
        return super.mo3520a(viewGroup, i);
    }

    @Override // android.support.v7.view.menu.BaseMenuPresenter, android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public boolean mo354a(SubMenuBuilder subMenuBuilder) {
        boolean z;
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
        while (subMenuBuilder2.m3682s() != this.f3264c) {
            subMenuBuilder2 = (SubMenuBuilder) subMenuBuilder2.m3682s();
        }
        View viewM3723a = m3723a(subMenuBuilder2.getItem());
        if (viewM3723a == null) {
            return false;
        }
        this.f3533l = subMenuBuilder.getItem().getItemId();
        int size = subMenuBuilder.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
                break;
            }
            MenuItem item = subMenuBuilder.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
            i++;
        }
        this.f3530i = new ActionButtonSubmenu(this.f3263b, subMenuBuilder, viewM3723a);
        this.f3530i.m3668a(z);
        this.f3530i.m3663a();
        super.mo354a(subMenuBuilder);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    private View m3723a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f3267f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof MenuView.ItemView) && ((MenuView.ItemView) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: f */
    public boolean m3735f() {
        if (!this.f3536o || m3739j() || this.f3264c == null || this.f3267f == null || this.f3531j != null || this.f3264c.m3619l().isEmpty()) {
            return false;
        }
        this.f3531j = new OpenOverflowRunnable(new OverflowPopup(this.f3263b, this.f3264c, this.f3528g, true));
        ((View) this.f3267f).post(this.f3531j);
        super.mo354a((SubMenuBuilder) null);
        return true;
    }

    /* JADX INFO: renamed from: g */
    public boolean m3736g() {
        if (this.f3531j != null && this.f3267f != null) {
            ((View) this.f3267f).removeCallbacks(this.f3531j);
            this.f3531j = null;
            return true;
        }
        OverflowPopup overflowPopup = this.f3529h;
        if (overflowPopup != null) {
            overflowPopup.m3672d();
            return true;
        }
        return false;
    }

    /* JADX INFO: renamed from: h */
    public boolean m3737h() {
        return m3736g() | m3738i();
    }

    /* JADX INFO: renamed from: i */
    public boolean m3738i() {
        if (this.f3530i == null) {
            return false;
        }
        this.f3530i.m3672d();
        return true;
    }

    /* JADX INFO: renamed from: j */
    public boolean m3739j() {
        return this.f3529h != null && this.f3529h.m3674f();
    }

    /* JADX INFO: renamed from: k */
    public boolean m3740k() {
        return this.f3531j != null || m3739j();
    }

    @Override // android.support.v7.view.menu.BaseMenuPresenter, android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public boolean mo352a() {
        int size;
        ArrayList<MenuItemImpl> arrayList;
        int i;
        int measuredWidth;
        int i2;
        int i3;
        boolean z;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z2;
        if (this.f3264c != null) {
            ArrayList<MenuItemImpl> arrayListM3616i = this.f3264c.m3616i();
            size = arrayListM3616i.size();
            arrayList = arrayListM3616i;
        } else {
            size = 0;
            arrayList = null;
        }
        int i8 = this.f3540s;
        int i9 = this.f3539r;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.f3267f;
        int i10 = 0;
        int i11 = 0;
        boolean z3 = false;
        int i12 = 0;
        while (i12 < size) {
            MenuItemImpl menuItemImpl = arrayList.get(i12);
            if (menuItemImpl.m3650l()) {
                i10++;
            } else if (menuItemImpl.m3649k()) {
                i11++;
            } else {
                z3 = true;
            }
            i12++;
            i8 = (this.f3544w && menuItemImpl.isActionViewExpanded()) ? 0 : i8;
        }
        if (this.f3536o && (z3 || i10 + i11 > i8)) {
            i8--;
        }
        int i13 = i8 - i10;
        SparseBooleanArray sparseBooleanArray = this.f3546y;
        sparseBooleanArray.clear();
        int i14 = 0;
        if (!this.f3542u) {
            i = 0;
        } else {
            i14 = i9 / this.f3545x;
            i = ((i9 % this.f3545x) / i14) + this.f3545x;
        }
        int i15 = 0;
        int i16 = 0;
        int iM3744a = i14;
        while (i15 < size) {
            MenuItemImpl menuItemImpl2 = arrayList.get(i15);
            if (menuItemImpl2.m3650l()) {
                View viewMo3515a = mo3515a(menuItemImpl2, this.f3547z, viewGroup);
                if (this.f3547z == null) {
                    this.f3547z = viewMo3515a;
                }
                if (this.f3542u) {
                    iM3744a -= ActionMenuView.m3744a(viewMo3515a, i, iM3744a, iMakeMeasureSpec, 0);
                } else {
                    viewMo3515a.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                }
                measuredWidth = viewMo3515a.getMeasuredWidth();
                int i17 = i9 - measuredWidth;
                if (i16 != 0) {
                    measuredWidth = i16;
                }
                int groupId = menuItemImpl2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                menuItemImpl2.m3641d(true);
                i2 = i17;
                i3 = i13;
            } else if (menuItemImpl2.m3649k()) {
                int groupId2 = menuItemImpl2.getGroupId();
                boolean z4 = sparseBooleanArray.get(groupId2);
                boolean z5 = (i13 > 0 || z4) && i9 > 0 && (!this.f3542u || iM3744a > 0);
                if (z5) {
                    View viewMo3515a2 = mo3515a(menuItemImpl2, this.f3547z, viewGroup);
                    if (this.f3547z == null) {
                        this.f3547z = viewMo3515a2;
                    }
                    if (this.f3542u) {
                        int iM3744a2 = ActionMenuView.m3744a(viewMo3515a2, i, iM3744a, iMakeMeasureSpec, 0);
                        int i18 = iM3744a - iM3744a2;
                        z2 = iM3744a2 == 0 ? false : z5;
                        i7 = i18;
                    } else {
                        viewMo3515a2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                        boolean z6 = z5;
                        i7 = iM3744a;
                        z2 = z6;
                    }
                    int measuredWidth2 = viewMo3515a2.getMeasuredWidth();
                    i9 -= measuredWidth2;
                    if (i16 == 0) {
                        i16 = measuredWidth2;
                    }
                    if (this.f3542u) {
                        z = z2 & (i9 >= 0);
                        i4 = i16;
                        i5 = i7;
                    } else {
                        z = z2 & (i9 + i16 > 0);
                        i4 = i16;
                        i5 = i7;
                    }
                } else {
                    z = z5;
                    i4 = i16;
                    i5 = iM3744a;
                }
                if (z && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                    i6 = i13;
                } else if (z4) {
                    sparseBooleanArray.put(groupId2, false);
                    int i19 = i13;
                    for (int i20 = 0; i20 < i15; i20++) {
                        MenuItemImpl menuItemImpl3 = arrayList.get(i20);
                        if (menuItemImpl3.getGroupId() == groupId2) {
                            if (menuItemImpl3.m3648j()) {
                                i19++;
                            }
                            menuItemImpl3.m3641d(false);
                        }
                    }
                    i6 = i19;
                } else {
                    i6 = i13;
                }
                if (z) {
                    i6--;
                }
                menuItemImpl2.m3641d(z);
                measuredWidth = i4;
                i2 = i9;
                int i21 = i5;
                i3 = i6;
                iM3744a = i21;
            } else {
                menuItemImpl2.m3641d(false);
                measuredWidth = i16;
                i2 = i9;
                i3 = i13;
            }
            i15++;
            i9 = i2;
            i13 = i3;
            i16 = measuredWidth;
        }
        return true;
    }

    @Override // android.support.v7.view.menu.BaseMenuPresenter, android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public void mo349a(MenuBuilder menuBuilder, boolean z) {
        m3737h();
        super.mo349a(menuBuilder, z);
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: c */
    public Parcelable mo358c() {
        SavedState savedState = new SavedState();
        savedState.f3558a = this.f3533l;
        return savedState;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public void mo347a(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            if (savedState.f3558a > 0 && (menuItemFindItem = this.f3264c.findItem(savedState.f3558a)) != null) {
                mo354a((SubMenuBuilder) menuItemFindItem.getSubMenu());
            }
        }
    }

    @Override // android.support.v4.view.ActionProvider.SubUiVisibilityListener
    /* JADX INFO: renamed from: b */
    public void mo2498b(boolean z) {
        if (z) {
            super.mo354a((SubMenuBuilder) null);
        } else if (this.f3264c != null) {
            this.f3264c.m3600b(false);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3731a(ActionMenuView actionMenuView) {
        this.f3267f = actionMenuView;
        actionMenuView.mo343a(this.f3264c);
    }

    private static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.support.v7.widget.ActionMenuPresenter.SavedState.1
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
        public int f3558a;

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f3558a = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f3558a);
        }
    }

    private class OverflowMenuButton extends AppCompatImageView implements ActionMenuView.ActionMenuChildView {

        /* JADX INFO: renamed from: b */
        private final float[] f3553b;

        public OverflowMenuButton(Context context) {
            super(context, null, R.attr.actionOverflowButtonStyle);
            this.f3553b = new float[2];
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            TooltipCompat.m4985a(this, getContentDescription());
            setOnTouchListener(new ForwardingListener(this) { // from class: android.support.v7.widget.ActionMenuPresenter.OverflowMenuButton.1
                @Override // android.support.v7.widget.ForwardingListener
                /* JADX INFO: renamed from: a */
                public ShowableListMenu mo3511a() {
                    if (ActionMenuPresenter.this.f3529h == null) {
                        return null;
                    }
                    return ActionMenuPresenter.this.f3529h.m3670b();
                }

                @Override // android.support.v7.widget.ForwardingListener
                /* JADX INFO: renamed from: b */
                public boolean mo3512b() {
                    ActionMenuPresenter.this.m3735f();
                    return true;
                }

                @Override // android.support.v7.widget.ForwardingListener
                /* JADX INFO: renamed from: c */
                public boolean mo3741c() {
                    if (ActionMenuPresenter.this.f3531j != null) {
                        return false;
                    }
                    ActionMenuPresenter.this.m3736g();
                    return true;
                }
            });
        }

        @Override // android.view.View
        public boolean performClick() {
            if (!super.performClick()) {
                playSoundEffect(0);
                ActionMenuPresenter.this.m3735f();
            }
            return true;
        }

        @Override // android.support.v7.widget.ActionMenuView.ActionMenuChildView
        /* JADX INFO: renamed from: c */
        public boolean mo3509c() {
            return false;
        }

        @Override // android.support.v7.widget.ActionMenuView.ActionMenuChildView
        /* JADX INFO: renamed from: d */
        public boolean mo3510d() {
            return false;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                DrawableCompat.m1988a(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    private class OverflowPopup extends MenuPopupHelper {
        public OverflowPopup(Context context, MenuBuilder menuBuilder, View view, boolean z) {
            super(context, menuBuilder, view, z, R.attr.actionOverflowMenuStyle);
            m3664a(8388613);
            m3665a(ActionMenuPresenter.this.f3532k);
        }

        @Override // android.support.v7.view.menu.MenuPopupHelper
        /* JADX INFO: renamed from: e */
        protected void mo3673e() {
            if (ActionMenuPresenter.this.f3264c != null) {
                ActionMenuPresenter.this.f3264c.close();
            }
            ActionMenuPresenter.this.f3529h = null;
            super.mo3673e();
        }
    }

    private class ActionButtonSubmenu extends MenuPopupHelper {
        public ActionButtonSubmenu(Context context, SubMenuBuilder subMenuBuilder, View view) {
            View view2;
            super(context, subMenuBuilder, view, false, R.attr.actionOverflowMenuStyle);
            if (!((MenuItemImpl) subMenuBuilder.getItem()).m3648j()) {
                if (ActionMenuPresenter.this.f3528g == null) {
                    view2 = (View) ActionMenuPresenter.this.f3267f;
                } else {
                    view2 = ActionMenuPresenter.this.f3528g;
                }
                m3666a(view2);
            }
            m3665a(ActionMenuPresenter.this.f3532k);
        }

        @Override // android.support.v7.view.menu.MenuPopupHelper
        /* JADX INFO: renamed from: e */
        protected void mo3673e() {
            ActionMenuPresenter.this.f3530i = null;
            ActionMenuPresenter.this.f3533l = 0;
            super.mo3673e();
        }
    }

    private class PopupPresenterCallback implements MenuPresenter.Callback {
        PopupPresenterCallback() {
        }

        @Override // android.support.v7.view.menu.MenuPresenter.Callback
        /* JADX INFO: renamed from: a */
        public boolean mo3328a(MenuBuilder menuBuilder) {
            if (menuBuilder == null) {
                return false;
            }
            ActionMenuPresenter.this.f3533l = ((SubMenuBuilder) menuBuilder).getItem().getItemId();
            MenuPresenter.Callback callbackD = ActionMenuPresenter.this.m3522d();
            return callbackD != null ? callbackD.mo3328a(menuBuilder) : false;
        }

        @Override // android.support.v7.view.menu.MenuPresenter.Callback
        /* JADX INFO: renamed from: a */
        public void mo3327a(MenuBuilder menuBuilder, boolean z) {
            if (menuBuilder instanceof SubMenuBuilder) {
                menuBuilder.mo3623p().m3600b(false);
            }
            MenuPresenter.Callback callbackD = ActionMenuPresenter.this.m3522d();
            if (callbackD != null) {
                callbackD.mo3327a(menuBuilder, z);
            }
        }
    }

    private class OpenOverflowRunnable implements Runnable {

        /* JADX INFO: renamed from: b */
        private OverflowPopup f3551b;

        public OpenOverflowRunnable(OverflowPopup overflowPopup) {
            this.f3551b = overflowPopup;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ActionMenuPresenter.this.f3264c != null) {
                ActionMenuPresenter.this.f3264c.m3613f();
            }
            View view = (View) ActionMenuPresenter.this.f3267f;
            if (view != null && view.getWindowToken() != null && this.f3551b.m3671c()) {
                ActionMenuPresenter.this.f3529h = this.f3551b;
            }
            ActionMenuPresenter.this.f3531j = null;
        }
    }

    private class ActionMenuPopupCallback extends ActionMenuItemView.PopupCallback {
        ActionMenuPopupCallback() {
        }

        @Override // android.support.v7.view.menu.ActionMenuItemView.PopupCallback
        /* JADX INFO: renamed from: a */
        public ShowableListMenu mo3513a() {
            if (ActionMenuPresenter.this.f3530i != null) {
                return ActionMenuPresenter.this.f3530i.m3670b();
            }
            return null;
        }
    }
}
