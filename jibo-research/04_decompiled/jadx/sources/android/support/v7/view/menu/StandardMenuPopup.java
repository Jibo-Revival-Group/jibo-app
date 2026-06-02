package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.widget.MenuPopupWindow;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
final class StandardMenuPopup extends MenuPopup implements MenuPresenter, View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: a */
    final MenuPopupWindow f3436a;

    /* JADX INFO: renamed from: b */
    View f3437b;

    /* JADX INFO: renamed from: c */
    private final Context f3438c;

    /* JADX INFO: renamed from: d */
    private final MenuBuilder f3439d;

    /* JADX INFO: renamed from: e */
    private final MenuAdapter f3440e;

    /* JADX INFO: renamed from: f */
    private final boolean f3441f;

    /* JADX INFO: renamed from: g */
    private final int f3442g;

    /* JADX INFO: renamed from: h */
    private final int f3443h;

    /* JADX INFO: renamed from: i */
    private final int f3444i;

    /* JADX INFO: renamed from: l */
    private PopupWindow.OnDismissListener f3447l;

    /* JADX INFO: renamed from: m */
    private View f3448m;

    /* JADX INFO: renamed from: n */
    private MenuPresenter.Callback f3449n;

    /* JADX INFO: renamed from: o */
    private ViewTreeObserver f3450o;

    /* JADX INFO: renamed from: p */
    private boolean f3451p;

    /* JADX INFO: renamed from: q */
    private boolean f3452q;

    /* JADX INFO: renamed from: r */
    private int f3453r;

    /* JADX INFO: renamed from: t */
    private boolean f3455t;

    /* JADX INFO: renamed from: j */
    private final ViewTreeObserver.OnGlobalLayoutListener f3445j = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: android.support.v7.view.menu.StandardMenuPopup.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (StandardMenuPopup.this.mo3548f() && !StandardMenuPopup.this.f3436a.m4373c()) {
                View view = StandardMenuPopup.this.f3437b;
                if (view == null || !view.isShown()) {
                    StandardMenuPopup.this.mo3547e();
                } else {
                    StandardMenuPopup.this.f3436a.mo3546d();
                }
            }
        }
    };

    /* JADX INFO: renamed from: k */
    private final View.OnAttachStateChangeListener f3446k = new View.OnAttachStateChangeListener() { // from class: android.support.v7.view.menu.StandardMenuPopup.2
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (StandardMenuPopup.this.f3450o != null) {
                if (!StandardMenuPopup.this.f3450o.isAlive()) {
                    StandardMenuPopup.this.f3450o = view.getViewTreeObserver();
                }
                StandardMenuPopup.this.f3450o.removeGlobalOnLayoutListener(StandardMenuPopup.this.f3445j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };

    /* JADX INFO: renamed from: s */
    private int f3454s = 0;

    public StandardMenuPopup(Context context, MenuBuilder menuBuilder, View view, int i, int i2, boolean z) {
        this.f3438c = context;
        this.f3439d = menuBuilder;
        this.f3441f = z;
        this.f3440e = new MenuAdapter(menuBuilder, LayoutInflater.from(context), this.f3441f);
        this.f3443h = i;
        this.f3444i = i2;
        Resources resources = context.getResources();
        this.f3442g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f3448m = view;
        this.f3436a = new MenuPopupWindow(this.f3438c, null, this.f3443h, this.f3444i);
        menuBuilder.m3590a(this, context);
    }

    @Override // android.support.v7.view.menu.MenuPopup
    /* JADX INFO: renamed from: b */
    public void mo3543b(boolean z) {
        this.f3440e.m3567a(z);
    }

    @Override // android.support.v7.view.menu.MenuPopup
    /* JADX INFO: renamed from: a */
    public void mo3538a(int i) {
        this.f3454s = i;
    }

    /* JADX INFO: renamed from: j */
    private boolean m3681j() {
        if (mo3548f()) {
            return true;
        }
        if (this.f3451p || this.f3448m == null) {
            return false;
        }
        this.f3437b = this.f3448m;
        this.f3436a.m4367a((PopupWindow.OnDismissListener) this);
        this.f3436a.m4366a((AdapterView.OnItemClickListener) this);
        this.f3436a.m4368a(true);
        View view = this.f3437b;
        boolean z = this.f3450o == null;
        this.f3450o = view.getViewTreeObserver();
        if (z) {
            this.f3450o.addOnGlobalLayoutListener(this.f3445j);
        }
        view.addOnAttachStateChangeListener(this.f3446k);
        this.f3436a.m4370b(view);
        this.f3436a.m4375e(this.f3454s);
        if (!this.f3452q) {
            this.f3453r = m3656a(this.f3440e, null, this.f3438c, this.f3442g);
            this.f3452q = true;
        }
        this.f3436a.m4377g(this.f3453r);
        this.f3436a.m4379h(2);
        this.f3436a.m4364a(m3660i());
        this.f3436a.mo3546d();
        ListView listViewG = this.f3436a.mo3549g();
        listViewG.setOnKeyListener(this);
        if (this.f3455t && this.f3439d.m3620m() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f3438c).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) listViewG, false);
            TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
            if (textView != null) {
                textView.setText(this.f3439d.m3620m());
            }
            frameLayout.setEnabled(false);
            listViewG.addHeaderView(frameLayout, null, false);
        }
        this.f3436a.mo3919a((ListAdapter) this.f3440e);
        this.f3436a.mo3546d();
        return true;
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    /* JADX INFO: renamed from: d */
    public void mo3546d() {
        if (!m3681j()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    /* JADX INFO: renamed from: e */
    public void mo3547e() {
        if (mo3548f()) {
            this.f3436a.mo3547e();
        }
    }

    @Override // android.support.v7.view.menu.MenuPopup
    /* JADX INFO: renamed from: a */
    public void mo3539a(MenuBuilder menuBuilder) {
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    /* JADX INFO: renamed from: f */
    public boolean mo3548f() {
        return !this.f3451p && this.f3436a.mo3548f();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f3451p = true;
        this.f3439d.close();
        if (this.f3450o != null) {
            if (!this.f3450o.isAlive()) {
                this.f3450o = this.f3437b.getViewTreeObserver();
            }
            this.f3450o.removeGlobalOnLayoutListener(this.f3445j);
            this.f3450o = null;
        }
        this.f3437b.removeOnAttachStateChangeListener(this.f3446k);
        if (this.f3447l != null) {
            this.f3447l.onDismiss();
        }
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public void mo351a(boolean z) {
        this.f3452q = false;
        if (this.f3440e != null) {
            this.f3440e.notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public void mo350a(MenuPresenter.Callback callback) {
        this.f3449n = callback;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public boolean mo354a(SubMenuBuilder subMenuBuilder) {
        if (subMenuBuilder.hasVisibleItems()) {
            MenuPopupHelper menuPopupHelper = new MenuPopupHelper(this.f3438c, subMenuBuilder, this.f3437b, this.f3441f, this.f3443h, this.f3444i);
            menuPopupHelper.m3665a(this.f3449n);
            menuPopupHelper.m3668a(MenuPopup.m3658b(subMenuBuilder));
            menuPopupHelper.m3664a(this.f3454s);
            menuPopupHelper.m3667a(this.f3447l);
            this.f3447l = null;
            this.f3439d.m3600b(false);
            if (menuPopupHelper.m3669a(this.f3436a.m4382j(), this.f3436a.m4383k())) {
                if (this.f3449n != null) {
                    this.f3449n.mo3328a(subMenuBuilder);
                }
                return true;
            }
        }
        return false;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public void mo349a(MenuBuilder menuBuilder, boolean z) {
        if (menuBuilder == this.f3439d) {
            mo3547e();
            if (this.f3449n != null) {
                this.f3449n.mo3327a(menuBuilder, z);
            }
        }
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public boolean mo352a() {
        return false;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: c */
    public Parcelable mo358c() {
        return null;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public void mo347a(Parcelable parcelable) {
    }

    @Override // android.support.v7.view.menu.MenuPopup
    /* JADX INFO: renamed from: a */
    public void mo3540a(View view) {
        this.f3448m = view;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        mo3547e();
        return true;
    }

    @Override // android.support.v7.view.menu.MenuPopup
    /* JADX INFO: renamed from: a */
    public void mo3541a(PopupWindow.OnDismissListener onDismissListener) {
        this.f3447l = onDismissListener;
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    /* JADX INFO: renamed from: g */
    public ListView mo3549g() {
        return this.f3436a.mo3549g();
    }

    @Override // android.support.v7.view.menu.MenuPopup
    /* JADX INFO: renamed from: b */
    public void mo3542b(int i) {
        this.f3436a.m4372c(i);
    }

    @Override // android.support.v7.view.menu.MenuPopup
    /* JADX INFO: renamed from: c */
    public void mo3544c(int i) {
        this.f3436a.m4374d(i);
    }

    @Override // android.support.v7.view.menu.MenuPopup
    /* JADX INFO: renamed from: c */
    public void mo3545c(boolean z) {
        this.f3455t = z;
    }
}
