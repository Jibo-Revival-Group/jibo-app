package android.support.v7.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.menu.MenuView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes.dex */
public final class MenuItemImpl implements SupportMenuItem {

    /* JADX INFO: renamed from: F */
    private static String f3378F;

    /* JADX INFO: renamed from: G */
    private static String f3379G;

    /* JADX INFO: renamed from: H */
    private static String f3380H;

    /* JADX INFO: renamed from: I */
    private static String f3381I;

    /* JADX INFO: renamed from: A */
    private View f3382A;

    /* JADX INFO: renamed from: B */
    private ActionProvider f3383B;

    /* JADX INFO: renamed from: C */
    private MenuItem.OnActionExpandListener f3384C;

    /* JADX INFO: renamed from: E */
    private ContextMenu.ContextMenuInfo f3386E;

    /* JADX INFO: renamed from: a */
    MenuBuilder f3387a;

    /* JADX INFO: renamed from: b */
    private final int f3388b;

    /* JADX INFO: renamed from: c */
    private final int f3389c;

    /* JADX INFO: renamed from: d */
    private final int f3390d;

    /* JADX INFO: renamed from: e */
    private final int f3391e;

    /* JADX INFO: renamed from: f */
    private CharSequence f3392f;

    /* JADX INFO: renamed from: g */
    private CharSequence f3393g;

    /* JADX INFO: renamed from: h */
    private Intent f3394h;

    /* JADX INFO: renamed from: i */
    private char f3395i;

    /* JADX INFO: renamed from: k */
    private char f3397k;

    /* JADX INFO: renamed from: m */
    private Drawable f3399m;

    /* JADX INFO: renamed from: o */
    private SubMenuBuilder f3401o;

    /* JADX INFO: renamed from: p */
    private Runnable f3402p;

    /* JADX INFO: renamed from: q */
    private MenuItem.OnMenuItemClickListener f3403q;

    /* JADX INFO: renamed from: r */
    private CharSequence f3404r;

    /* JADX INFO: renamed from: s */
    private CharSequence f3405s;

    /* JADX INFO: renamed from: z */
    private int f3412z;

    /* JADX INFO: renamed from: j */
    private int f3396j = 4096;

    /* JADX INFO: renamed from: l */
    private int f3398l = 4096;

    /* JADX INFO: renamed from: n */
    private int f3400n = 0;

    /* JADX INFO: renamed from: t */
    private ColorStateList f3406t = null;

    /* JADX INFO: renamed from: u */
    private PorterDuff.Mode f3407u = null;

    /* JADX INFO: renamed from: v */
    private boolean f3408v = false;

    /* JADX INFO: renamed from: w */
    private boolean f3409w = false;

    /* JADX INFO: renamed from: x */
    private boolean f3410x = false;

    /* JADX INFO: renamed from: y */
    private int f3411y = 16;

    /* JADX INFO: renamed from: D */
    private boolean f3385D = false;

    MenuItemImpl(MenuBuilder menuBuilder, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.f3412z = 0;
        this.f3387a = menuBuilder;
        this.f3388b = i2;
        this.f3389c = i;
        this.f3390d = i3;
        this.f3391e = i4;
        this.f3392f = charSequence;
        this.f3412z = i5;
    }

    /* JADX INFO: renamed from: b */
    public boolean m3637b() {
        if ((this.f3403q != null && this.f3403q.onMenuItemClick(this)) || this.f3387a.mo3593a(this.f3387a, this)) {
            return true;
        }
        if (this.f3402p != null) {
            this.f3402p.run();
            return true;
        }
        if (this.f3394h != null) {
            try {
                this.f3387a.m3611e().startActivity(this.f3394h);
                return true;
            } catch (ActivityNotFoundException e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        return this.f3383B != null && this.f3383B.mo2495d();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f3411y & 16) != 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.f3411y |= 16;
        } else {
            this.f3411y &= -17;
        }
        this.f3387a.mo394a(false);
        return this;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f3389c;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f3388b;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f3390d;
    }

    /* JADX INFO: renamed from: c */
    public int m3638c() {
        return this.f3391e;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f3394h;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f3394h = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f3397k;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        if (this.f3397k != c) {
            this.f3397k = Character.toLowerCase(c);
            this.f3387a.mo394a(false);
        }
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c, int i) {
        if (this.f3397k != c || this.f3398l != i) {
            this.f3397k = Character.toLowerCase(c);
            this.f3398l = KeyEvent.normalizeMetaState(i);
            this.f3387a.mo394a(false);
        }
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f3398l;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f3395i;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f3396j;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        if (this.f3395i != c) {
            this.f3395i = c;
            this.f3387a.mo394a(false);
        }
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setNumericShortcut(char c, int i) {
        if (this.f3395i != c || this.f3396j != i) {
            this.f3395i = c;
            this.f3396j = KeyEvent.normalizeMetaState(i);
            this.f3387a.mo394a(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        this.f3395i = c;
        this.f3397k = Character.toLowerCase(c2);
        this.f3387a.mo394a(false);
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f3395i = c;
        this.f3396j = KeyEvent.normalizeMetaState(i);
        this.f3397k = Character.toLowerCase(c2);
        this.f3398l = KeyEvent.normalizeMetaState(i2);
        this.f3387a.mo394a(false);
        return this;
    }

    /* JADX INFO: renamed from: d */
    char m3640d() {
        return this.f3387a.mo3601b() ? this.f3397k : this.f3395i;
    }

    /* JADX INFO: renamed from: e */
    String m3642e() {
        char cM3640d = m3640d();
        if (cM3640d == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(f3378F);
        switch (cM3640d) {
            case '\b':
                sb.append(f3380H);
                break;
            case '\n':
                sb.append(f3379G);
                break;
            case ' ':
                sb.append(f3381I);
                break;
            default:
                sb.append(cM3640d);
                break;
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: f */
    boolean m3644f() {
        return this.f3387a.mo3605c() && m3640d() != 0;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f3401o;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f3401o != null;
    }

    /* JADX INFO: renamed from: a */
    public void m3632a(SubMenuBuilder subMenuBuilder) {
        this.f3401o = subMenuBuilder;
        subMenuBuilder.setHeaderTitle(getTitle());
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f3392f;
    }

    /* JADX INFO: renamed from: a */
    CharSequence m3631a(MenuView.ItemView itemView) {
        return (itemView == null || !itemView.mo337a()) ? getTitle() : getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f3392f = charSequence;
        this.f3387a.mo394a(false);
        if (this.f3401o != null) {
            this.f3401o.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        return setTitle(this.f3387a.m3611e().getString(i));
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f3393g != null ? this.f3393g : this.f3392f;
        if (Build.VERSION.SDK_INT < 18 && charSequence != null && !(charSequence instanceof String)) {
            return charSequence.toString();
        }
        return charSequence;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f3393g = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.f3392f;
        }
        this.f3387a.mo394a(false);
        return this;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        if (this.f3399m != null) {
            return m3628a(this.f3399m);
        }
        if (this.f3400n != 0) {
            Drawable drawableM3426b = AppCompatResources.m3426b(this.f3387a.m3611e(), this.f3400n);
            this.f3400n = 0;
            this.f3399m = drawableM3426b;
            return m3628a(drawableM3426b);
        }
        return null;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f3400n = 0;
        this.f3399m = drawable;
        this.f3410x = true;
        this.f3387a.mo394a(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.f3399m = null;
        this.f3400n = i;
        this.f3410x = true;
        this.f3387a.mo394a(false);
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f3406t = colorStateList;
        this.f3408v = true;
        this.f3410x = true;
        this.f3387a.mo394a(false);
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f3406t;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f3407u = mode;
        this.f3409w = true;
        this.f3410x = true;
        this.f3387a.mo394a(false);
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f3407u;
    }

    /* JADX INFO: renamed from: a */
    private Drawable m3628a(Drawable drawable) {
        if (drawable != null && this.f3410x && (this.f3408v || this.f3409w)) {
            drawable = DrawableCompat.m2000g(drawable).mutate();
            if (this.f3408v) {
                DrawableCompat.m1989a(drawable, this.f3406t);
            }
            if (this.f3409w) {
                DrawableCompat.m1992a(drawable, this.f3407u);
            }
            this.f3410x = false;
        }
        return drawable;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f3411y & 1) == 1;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        int i = this.f3411y;
        this.f3411y = (z ? 1 : 0) | (this.f3411y & (-2));
        if (i != this.f3411y) {
            this.f3387a.mo394a(false);
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public void m3634a(boolean z) {
        this.f3411y = (z ? 4 : 0) | (this.f3411y & (-5));
    }

    /* JADX INFO: renamed from: g */
    public boolean m3645g() {
        return (this.f3411y & 4) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f3411y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        if ((this.f3411y & 4) != 0) {
            this.f3387a.m3591a((MenuItem) this);
        } else {
            m3636b(z);
        }
        return this;
    }

    /* JADX INFO: renamed from: b */
    void m3636b(boolean z) {
        int i = this.f3411y;
        this.f3411y = (z ? 2 : 0) | (this.f3411y & (-3));
        if (i != this.f3411y) {
            this.f3387a.mo394a(false);
        }
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f3383B == null || !this.f3383B.mo2493b()) ? (this.f3411y & 8) == 0 : (this.f3411y & 8) == 0 && this.f3383B.mo2494c();
    }

    /* JADX INFO: renamed from: c */
    boolean m3639c(boolean z) {
        int i = this.f3411y;
        this.f3411y = (z ? 0 : 8) | (this.f3411y & (-9));
        return i != this.f3411y;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        if (m3639c(z)) {
            this.f3387a.m3588a(this);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f3403q = onMenuItemClickListener;
        return this;
    }

    public String toString() {
        if (this.f3392f != null) {
            return this.f3392f.toString();
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    void m3633a(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f3386E = contextMenuInfo;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f3386E;
    }

    /* JADX INFO: renamed from: h */
    public void m3646h() {
        this.f3387a.m3598b(this);
    }

    /* JADX INFO: renamed from: i */
    public boolean m3647i() {
        return this.f3387a.m3624q();
    }

    /* JADX INFO: renamed from: j */
    public boolean m3648j() {
        return (this.f3411y & 32) == 32;
    }

    /* JADX INFO: renamed from: k */
    public boolean m3649k() {
        return (this.f3412z & 1) == 1;
    }

    /* JADX INFO: renamed from: l */
    public boolean m3650l() {
        return (this.f3412z & 2) == 2;
    }

    /* JADX INFO: renamed from: d */
    public void m3641d(boolean z) {
        if (z) {
            this.f3411y |= 32;
        } else {
            this.f3411y &= -33;
        }
    }

    /* JADX INFO: renamed from: m */
    public boolean m3651m() {
        return (this.f3412z & 4) == 4;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public void setShowAsAction(int i) {
        switch (i & 3) {
            case 0:
            case 1:
            case 2:
                this.f3412z = i;
                this.f3387a.m3598b(this);
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public SupportMenuItem setActionView(View view) {
        this.f3382A = view;
        this.f3383B = null;
        if (view != null && view.getId() == -1 && this.f3388b > 0) {
            view.setId(this.f3388b);
        }
        this.f3387a.m3598b(this);
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public SupportMenuItem setActionView(int i) {
        Context contextM3611e = this.f3387a.m3611e();
        setActionView(LayoutInflater.from(contextM3611e).inflate(i, (ViewGroup) new LinearLayout(contextM3611e), false));
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public View getActionView() {
        if (this.f3382A != null) {
            return this.f3382A;
        }
        if (this.f3383B != null) {
            this.f3382A = this.f3383B.mo2488a(this);
            return this.f3382A;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // android.support.v4.internal.view.SupportMenuItem
    /* JADX INFO: renamed from: a */
    public ActionProvider mo2022a() {
        return this.f3383B;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem
    /* JADX INFO: renamed from: a */
    public SupportMenuItem mo2020a(ActionProvider actionProvider) {
        if (this.f3383B != null) {
            this.f3383B.m2497f();
        }
        this.f3382A = null;
        this.f3383B = actionProvider;
        this.f3387a.mo394a(true);
        if (this.f3383B != null) {
            this.f3383B.mo2490a(new ActionProvider.VisibilityListener() { // from class: android.support.v7.view.menu.MenuItemImpl.1
                @Override // android.support.v4.view.ActionProvider.VisibilityListener
                /* JADX INFO: renamed from: a */
                public void mo2499a(boolean z) {
                    MenuItemImpl.this.f3387a.m3588a(MenuItemImpl.this);
                }
            });
        }
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public SupportMenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean expandActionView() {
        if (!m3652n()) {
            return false;
        }
        if (this.f3384C == null || this.f3384C.onMenuItemActionExpand(this)) {
            return this.f3387a.mo3606c(this);
        }
        return false;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.f3412z & 8) == 0) {
            return false;
        }
        if (this.f3382A == null) {
            return true;
        }
        if (this.f3384C == null || this.f3384C.onMenuItemActionCollapse(this)) {
            return this.f3387a.mo3610d(this);
        }
        return false;
    }

    /* JADX INFO: renamed from: n */
    public boolean m3652n() {
        if ((this.f3412z & 8) == 0) {
            return false;
        }
        if (this.f3382A == null && this.f3383B != null) {
            this.f3382A = this.f3383B.mo2488a(this);
        }
        return this.f3382A != null;
    }

    /* JADX INFO: renamed from: e */
    public void m3643e(boolean z) {
        this.f3385D = z;
        this.f3387a.mo394a(false);
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f3385D;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f3384C = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public SupportMenuItem setContentDescription(CharSequence charSequence) {
        this.f3404r = charSequence;
        this.f3387a.mo394a(false);
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f3404r;
    }

    @Override // android.view.MenuItem
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public SupportMenuItem setTooltipText(CharSequence charSequence) {
        this.f3405s = charSequence;
        this.f3387a.mo394a(false);
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f3405s;
    }
}
