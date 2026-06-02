package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.widget.MenuItemHoverListener;
import android.support.v7.widget.MenuPopupWindow;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class CascadingMenuPopup extends MenuPopup implements MenuPresenter, View.OnKeyListener, PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: a */
    final Handler f3276a;

    /* JADX INFO: renamed from: c */
    View f3278c;

    /* JADX INFO: renamed from: d */
    boolean f3279d;

    /* JADX INFO: renamed from: e */
    private final Context f3280e;

    /* JADX INFO: renamed from: f */
    private final int f3281f;

    /* JADX INFO: renamed from: g */
    private final int f3282g;

    /* JADX INFO: renamed from: h */
    private final int f3283h;

    /* JADX INFO: renamed from: i */
    private final boolean f3284i;

    /* JADX INFO: renamed from: p */
    private View f3291p;

    /* JADX INFO: renamed from: r */
    private boolean f3293r;

    /* JADX INFO: renamed from: s */
    private boolean f3294s;

    /* JADX INFO: renamed from: t */
    private int f3295t;

    /* JADX INFO: renamed from: u */
    private int f3296u;

    /* JADX INFO: renamed from: w */
    private boolean f3298w;

    /* JADX INFO: renamed from: x */
    private MenuPresenter.Callback f3299x;

    /* JADX INFO: renamed from: y */
    private ViewTreeObserver f3300y;

    /* JADX INFO: renamed from: z */
    private PopupWindow.OnDismissListener f3301z;

    /* JADX INFO: renamed from: j */
    private final List<MenuBuilder> f3285j = new ArrayList();

    /* JADX INFO: renamed from: b */
    final List<CascadingMenuInfo> f3277b = new ArrayList();

    /* JADX INFO: renamed from: k */
    private final ViewTreeObserver.OnGlobalLayoutListener f3286k = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: android.support.v7.view.menu.CascadingMenuPopup.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (CascadingMenuPopup.this.mo3548f() && CascadingMenuPopup.this.f3277b.size() > 0 && !CascadingMenuPopup.this.f3277b.get(0).f3309a.m4373c()) {
                View view = CascadingMenuPopup.this.f3278c;
                if (view == null || !view.isShown()) {
                    CascadingMenuPopup.this.mo3547e();
                    return;
                }
                Iterator<CascadingMenuInfo> it = CascadingMenuPopup.this.f3277b.iterator();
                while (it.hasNext()) {
                    it.next().f3309a.mo3546d();
                }
            }
        }
    };

    /* JADX INFO: renamed from: l */
    private final View.OnAttachStateChangeListener f3287l = new View.OnAttachStateChangeListener() { // from class: android.support.v7.view.menu.CascadingMenuPopup.2
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (CascadingMenuPopup.this.f3300y != null) {
                if (!CascadingMenuPopup.this.f3300y.isAlive()) {
                    CascadingMenuPopup.this.f3300y = view.getViewTreeObserver();
                }
                CascadingMenuPopup.this.f3300y.removeGlobalOnLayoutListener(CascadingMenuPopup.this.f3286k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };

    /* JADX INFO: renamed from: m */
    private final MenuItemHoverListener f3288m = new MenuItemHoverListener() { // from class: android.support.v7.view.menu.CascadingMenuPopup.3
        @Override // android.support.v7.widget.MenuItemHoverListener
        /* JADX INFO: renamed from: a */
        public void mo3551a(MenuBuilder menuBuilder, MenuItem menuItem) {
            CascadingMenuPopup.this.f3276a.removeCallbacksAndMessages(menuBuilder);
        }

        @Override // android.support.v7.widget.MenuItemHoverListener
        /* JADX INFO: renamed from: b */
        public void mo3552b(final MenuBuilder menuBuilder, final MenuItem menuItem) {
            int i;
            CascadingMenuPopup.this.f3276a.removeCallbacksAndMessages(null);
            int i2 = 0;
            int size = CascadingMenuPopup.this.f3277b.size();
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                } else {
                    if (menuBuilder == CascadingMenuPopup.this.f3277b.get(i2).f3310b) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
            }
            if (i != -1) {
                int i3 = i + 1;
                final CascadingMenuInfo cascadingMenuInfo = i3 < CascadingMenuPopup.this.f3277b.size() ? CascadingMenuPopup.this.f3277b.get(i3) : null;
                CascadingMenuPopup.this.f3276a.postAtTime(new Runnable() { // from class: android.support.v7.view.menu.CascadingMenuPopup.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (cascadingMenuInfo != null) {
                            CascadingMenuPopup.this.f3279d = true;
                            cascadingMenuInfo.f3310b.m3600b(false);
                            CascadingMenuPopup.this.f3279d = false;
                        }
                        if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                            menuBuilder.m3594a(menuItem, 4);
                        }
                    }
                }, menuBuilder, SystemClock.uptimeMillis() + 200);
            }
        }
    };

    /* JADX INFO: renamed from: n */
    private int f3289n = 0;

    /* JADX INFO: renamed from: o */
    private int f3290o = 0;

    /* JADX INFO: renamed from: v */
    private boolean f3297v = false;

    /* JADX INFO: renamed from: q */
    private int f3292q = m3537k();

    public CascadingMenuPopup(Context context, View view, int i, int i2, boolean z) {
        this.f3280e = context;
        this.f3291p = view;
        this.f3282g = i;
        this.f3283h = i2;
        this.f3284i = z;
        Resources resources = context.getResources();
        this.f3281f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f3276a = new Handler();
    }

    @Override // android.support.v7.view.menu.MenuPopup
    /* JADX INFO: renamed from: b */
    public void mo3543b(boolean z) {
        this.f3297v = z;
    }

    /* JADX INFO: renamed from: j */
    private MenuPopupWindow m3536j() {
        MenuPopupWindow menuPopupWindow = new MenuPopupWindow(this.f3280e, null, this.f3282g, this.f3283h);
        menuPopupWindow.m4387a(this.f3288m);
        menuPopupWindow.m4366a((AdapterView.OnItemClickListener) this);
        menuPopupWindow.m4367a((PopupWindow.OnDismissListener) this);
        menuPopupWindow.m4370b(this.f3291p);
        menuPopupWindow.m4375e(this.f3290o);
        menuPopupWindow.m4368a(true);
        menuPopupWindow.m4379h(2);
        return menuPopupWindow;
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    /* JADX INFO: renamed from: d */
    public void mo3546d() {
        if (!mo3548f()) {
            Iterator<MenuBuilder> it = this.f3285j.iterator();
            while (it.hasNext()) {
                m3533c(it.next());
            }
            this.f3285j.clear();
            this.f3278c = this.f3291p;
            if (this.f3278c != null) {
                boolean z = this.f3300y == null;
                this.f3300y = this.f3278c.getViewTreeObserver();
                if (z) {
                    this.f3300y.addOnGlobalLayoutListener(this.f3286k);
                }
                this.f3278c.addOnAttachStateChangeListener(this.f3287l);
            }
        }
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    /* JADX INFO: renamed from: e */
    public void mo3547e() {
        int size = this.f3277b.size();
        if (size > 0) {
            CascadingMenuInfo[] cascadingMenuInfoArr = (CascadingMenuInfo[]) this.f3277b.toArray(new CascadingMenuInfo[size]);
            for (int i = size - 1; i >= 0; i--) {
                CascadingMenuInfo cascadingMenuInfo = cascadingMenuInfoArr[i];
                if (cascadingMenuInfo.f3309a.mo3548f()) {
                    cascadingMenuInfo.f3309a.mo3547e();
                }
            }
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        mo3547e();
        return true;
    }

    /* JADX INFO: renamed from: k */
    private int m3537k() {
        return ViewCompat.m2601e(this.f3291p) == 1 ? 0 : 1;
    }

    /* JADX INFO: renamed from: d */
    private int m3534d(int i) {
        ListView listViewM3553a = this.f3277b.get(this.f3277b.size() - 1).m3553a();
        int[] iArr = new int[2];
        listViewM3553a.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f3278c.getWindowVisibleDisplayFrame(rect);
        if (this.f3292q == 1) {
            return (listViewM3553a.getWidth() + iArr[0]) + i > rect.right ? 0 : 1;
        }
        return iArr[0] - i < 0 ? 1 : 0;
    }

    @Override // android.support.v7.view.menu.MenuPopup
    /* JADX INFO: renamed from: a */
    public void mo3539a(MenuBuilder menuBuilder) {
        menuBuilder.m3590a(this, this.f3280e);
        if (mo3548f()) {
            m3533c(menuBuilder);
        } else {
            this.f3285j.add(menuBuilder);
        }
    }

    /* JADX INFO: renamed from: c */
    private void m3533c(MenuBuilder menuBuilder) {
        View viewM3529a;
        CascadingMenuInfo cascadingMenuInfo;
        int i;
        int i2;
        int width;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f3280e);
        MenuAdapter menuAdapter = new MenuAdapter(menuBuilder, layoutInflaterFrom, this.f3284i);
        if (!mo3548f() && this.f3297v) {
            menuAdapter.m3567a(true);
        } else if (mo3548f()) {
            menuAdapter.m3567a(MenuPopup.m3658b(menuBuilder));
        }
        int iA = m3656a(menuAdapter, null, this.f3280e, this.f3281f);
        MenuPopupWindow menuPopupWindowM3536j = m3536j();
        menuPopupWindowM3536j.mo3919a((ListAdapter) menuAdapter);
        menuPopupWindowM3536j.m4377g(iA);
        menuPopupWindowM3536j.m4375e(this.f3290o);
        if (this.f3277b.size() > 0) {
            CascadingMenuInfo cascadingMenuInfo2 = this.f3277b.get(this.f3277b.size() - 1);
            viewM3529a = m3529a(cascadingMenuInfo2, menuBuilder);
            cascadingMenuInfo = cascadingMenuInfo2;
        } else {
            viewM3529a = null;
            cascadingMenuInfo = null;
        }
        if (viewM3529a != null) {
            menuPopupWindowM3536j.m4390c(false);
            menuPopupWindowM3536j.m4388a((Object) null);
            int iM3534d = m3534d(iA);
            boolean z = iM3534d == 1;
            this.f3292q = iM3534d;
            if (Build.VERSION.SDK_INT >= 26) {
                menuPopupWindowM3536j.m4370b(viewM3529a);
                i2 = 0;
                i = 0;
            } else {
                int[] iArr = new int[2];
                this.f3291p.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                viewM3529a.getLocationOnScreen(iArr2);
                if ((this.f3290o & 7) == 5) {
                    iArr[0] = iArr[0] + this.f3291p.getWidth();
                    iArr2[0] = iArr2[0] + viewM3529a.getWidth();
                }
                i = iArr2[0] - iArr[0];
                i2 = iArr2[1] - iArr[1];
            }
            if ((this.f3290o & 5) == 5) {
                if (z) {
                    width = i + iA;
                } else {
                    width = i - viewM3529a.getWidth();
                }
            } else if (z) {
                width = viewM3529a.getWidth() + i;
            } else {
                width = i - iA;
            }
            menuPopupWindowM3536j.m4372c(width);
            menuPopupWindowM3536j.m4371b(true);
            menuPopupWindowM3536j.m4374d(i2);
        } else {
            if (this.f3293r) {
                menuPopupWindowM3536j.m4372c(this.f3295t);
            }
            if (this.f3294s) {
                menuPopupWindowM3536j.m4374d(this.f3296u);
            }
            menuPopupWindowM3536j.m4364a(m3660i());
        }
        this.f3277b.add(new CascadingMenuInfo(menuPopupWindowM3536j, menuBuilder, this.f3292q));
        menuPopupWindowM3536j.mo3546d();
        ListView listViewG = menuPopupWindowM3536j.mo3549g();
        listViewG.setOnKeyListener(this);
        if (cascadingMenuInfo == null && this.f3298w && menuBuilder.m3620m() != null) {
            FrameLayout frameLayout = (FrameLayout) layoutInflaterFrom.inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) listViewG, false);
            TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(menuBuilder.m3620m());
            listViewG.addHeaderView(frameLayout, null, false);
            menuPopupWindowM3536j.mo3546d();
        }
    }

    /* JADX INFO: renamed from: a */
    private MenuItem m3528a(MenuBuilder menuBuilder, MenuBuilder menuBuilder2) {
        int size = menuBuilder.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = menuBuilder.getItem(i);
            if (item.hasSubMenu() && menuBuilder2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    private View m3529a(CascadingMenuInfo cascadingMenuInfo, MenuBuilder menuBuilder) {
        MenuAdapter menuAdapter;
        int headersCount;
        int i;
        int i2 = 0;
        MenuItem menuItemM3528a = m3528a(cascadingMenuInfo.f3310b, menuBuilder);
        if (menuItemM3528a == null) {
            return null;
        }
        ListView listViewM3553a = cascadingMenuInfo.m3553a();
        ListAdapter adapter = listViewM3553a.getAdapter();
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            menuAdapter = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
        } else {
            menuAdapter = (MenuAdapter) adapter;
            headersCount = 0;
        }
        int count = menuAdapter.getCount();
        while (true) {
            if (i2 >= count) {
                i = -1;
                break;
            }
            if (menuItemM3528a == menuAdapter.getItem(i2)) {
                i = i2;
                break;
            }
            i2++;
        }
        if (i == -1) {
            return null;
        }
        int firstVisiblePosition = (i + headersCount) - listViewM3553a.getFirstVisiblePosition();
        if (firstVisiblePosition < 0 || firstVisiblePosition >= listViewM3553a.getChildCount()) {
            return null;
        }
        return listViewM3553a.getChildAt(firstVisiblePosition);
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    /* JADX INFO: renamed from: f */
    public boolean mo3548f() {
        return this.f3277b.size() > 0 && this.f3277b.get(0).f3309a.mo3548f();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        CascadingMenuInfo cascadingMenuInfo;
        int size = this.f3277b.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                cascadingMenuInfo = null;
                break;
            }
            cascadingMenuInfo = this.f3277b.get(i);
            if (!cascadingMenuInfo.f3309a.mo3548f()) {
                break;
            } else {
                i++;
            }
        }
        if (cascadingMenuInfo != null) {
            cascadingMenuInfo.f3310b.m3600b(false);
        }
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public void mo351a(boolean z) {
        Iterator<CascadingMenuInfo> it = this.f3277b.iterator();
        while (it.hasNext()) {
            m3657a(it.next().m3553a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public void mo350a(MenuPresenter.Callback callback) {
        this.f3299x = callback;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public boolean mo354a(SubMenuBuilder subMenuBuilder) {
        for (CascadingMenuInfo cascadingMenuInfo : this.f3277b) {
            if (subMenuBuilder == cascadingMenuInfo.f3310b) {
                cascadingMenuInfo.m3553a().requestFocus();
                return true;
            }
        }
        if (subMenuBuilder.hasVisibleItems()) {
            mo3539a((MenuBuilder) subMenuBuilder);
            if (this.f3299x != null) {
                this.f3299x.mo3328a(subMenuBuilder);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: renamed from: d */
    private int m3535d(MenuBuilder menuBuilder) {
        int size = this.f3277b.size();
        for (int i = 0; i < size; i++) {
            if (menuBuilder == this.f3277b.get(i).f3310b) {
                return i;
            }
        }
        return -1;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public void mo349a(MenuBuilder menuBuilder, boolean z) {
        int iM3535d = m3535d(menuBuilder);
        if (iM3535d >= 0) {
            int i = iM3535d + 1;
            if (i < this.f3277b.size()) {
                this.f3277b.get(i).f3310b.m3600b(false);
            }
            CascadingMenuInfo cascadingMenuInfoRemove = this.f3277b.remove(iM3535d);
            cascadingMenuInfoRemove.f3310b.m3599b(this);
            if (this.f3279d) {
                cascadingMenuInfoRemove.f3309a.m4389b((Object) null);
                cascadingMenuInfoRemove.f3309a.m4369b(0);
            }
            cascadingMenuInfoRemove.f3309a.mo3547e();
            int size = this.f3277b.size();
            if (size > 0) {
                this.f3292q = this.f3277b.get(size - 1).f3311c;
            } else {
                this.f3292q = m3537k();
            }
            if (size == 0) {
                mo3547e();
                if (this.f3299x != null) {
                    this.f3299x.mo3327a(menuBuilder, true);
                }
                if (this.f3300y != null) {
                    if (this.f3300y.isAlive()) {
                        this.f3300y.removeGlobalOnLayoutListener(this.f3286k);
                    }
                    this.f3300y = null;
                }
                this.f3278c.removeOnAttachStateChangeListener(this.f3287l);
                this.f3301z.onDismiss();
                return;
            }
            if (z) {
                this.f3277b.get(0).f3310b.m3600b(false);
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
    public void mo3538a(int i) {
        if (this.f3289n != i) {
            this.f3289n = i;
            this.f3290o = GravityCompat.m2508a(i, ViewCompat.m2601e(this.f3291p));
        }
    }

    @Override // android.support.v7.view.menu.MenuPopup
    /* JADX INFO: renamed from: a */
    public void mo3540a(View view) {
        if (this.f3291p != view) {
            this.f3291p = view;
            this.f3290o = GravityCompat.m2508a(this.f3289n, ViewCompat.m2601e(this.f3291p));
        }
    }

    @Override // android.support.v7.view.menu.MenuPopup
    /* JADX INFO: renamed from: a */
    public void mo3541a(PopupWindow.OnDismissListener onDismissListener) {
        this.f3301z = onDismissListener;
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    /* JADX INFO: renamed from: g */
    public ListView mo3549g() {
        if (this.f3277b.isEmpty()) {
            return null;
        }
        return this.f3277b.get(this.f3277b.size() - 1).m3553a();
    }

    @Override // android.support.v7.view.menu.MenuPopup
    /* JADX INFO: renamed from: b */
    public void mo3542b(int i) {
        this.f3293r = true;
        this.f3295t = i;
    }

    @Override // android.support.v7.view.menu.MenuPopup
    /* JADX INFO: renamed from: c */
    public void mo3544c(int i) {
        this.f3294s = true;
        this.f3296u = i;
    }

    @Override // android.support.v7.view.menu.MenuPopup
    /* JADX INFO: renamed from: c */
    public void mo3545c(boolean z) {
        this.f3298w = z;
    }

    @Override // android.support.v7.view.menu.MenuPopup
    /* JADX INFO: renamed from: h */
    protected boolean mo3550h() {
        return false;
    }

    private static class CascadingMenuInfo {

        /* JADX INFO: renamed from: a */
        public final MenuPopupWindow f3309a;

        /* JADX INFO: renamed from: b */
        public final MenuBuilder f3310b;

        /* JADX INFO: renamed from: c */
        public final int f3311c;

        public CascadingMenuInfo(MenuPopupWindow menuPopupWindow, MenuBuilder menuBuilder, int i) {
            this.f3309a = menuPopupWindow;
            this.f3310b = menuBuilder;
            this.f3311c = i;
        }

        /* JADX INFO: renamed from: a */
        public ListView m3553a() {
            return this.f3309a.mo3549g();
        }
    }
}
