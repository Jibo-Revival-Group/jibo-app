package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.internal.view.SupportMenuItem;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuItem implements SupportMenuItem {

    /* JADX INFO: renamed from: a */
    private final int f3228a;

    /* JADX INFO: renamed from: b */
    private final int f3229b;

    /* JADX INFO: renamed from: c */
    private final int f3230c;

    /* JADX INFO: renamed from: d */
    private final int f3231d;

    /* JADX INFO: renamed from: e */
    private CharSequence f3232e;

    /* JADX INFO: renamed from: f */
    private CharSequence f3233f;

    /* JADX INFO: renamed from: g */
    private Intent f3234g;

    /* JADX INFO: renamed from: h */
    private char f3235h;

    /* JADX INFO: renamed from: j */
    private char f3237j;

    /* JADX INFO: renamed from: l */
    private Drawable f3239l;

    /* JADX INFO: renamed from: n */
    private Context f3241n;

    /* JADX INFO: renamed from: o */
    private MenuItem.OnMenuItemClickListener f3242o;

    /* JADX INFO: renamed from: p */
    private CharSequence f3243p;

    /* JADX INFO: renamed from: q */
    private CharSequence f3244q;

    /* JADX INFO: renamed from: i */
    private int f3236i = 4096;

    /* JADX INFO: renamed from: k */
    private int f3238k = 4096;

    /* JADX INFO: renamed from: m */
    private int f3240m = 0;

    /* JADX INFO: renamed from: r */
    private ColorStateList f3245r = null;

    /* JADX INFO: renamed from: s */
    private PorterDuff.Mode f3246s = null;

    /* JADX INFO: renamed from: t */
    private boolean f3247t = false;

    /* JADX INFO: renamed from: u */
    private boolean f3248u = false;

    /* JADX INFO: renamed from: v */
    private int f3249v = 16;

    public ActionMenuItem(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.f3241n = context;
        this.f3228a = i2;
        this.f3229b = i;
        this.f3230c = i3;
        this.f3231d = i4;
        this.f3232e = charSequence;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f3237j;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f3238k;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f3229b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f3239l;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f3234g;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f3228a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f3235h;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f3236i;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f3231d;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f3232e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f3233f != null ? this.f3233f : this.f3232e;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f3249v & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f3249v & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f3249v & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f3249v & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        this.f3237j = Character.toLowerCase(c);
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c, int i) {
        this.f3237j = Character.toLowerCase(c);
        this.f3238k = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        this.f3249v = (z ? 1 : 0) | (this.f3249v & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        this.f3249v = (z ? 2 : 0) | (this.f3249v & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.f3249v = (z ? 16 : 0) | (this.f3249v & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f3239l = drawable;
        this.f3240m = 0;
        m3502b();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.f3240m = i;
        this.f3239l = ContextCompat.m1832a(this.f3241n, i);
        m3502b();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f3234g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        this.f3235h = c;
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setNumericShortcut(char c, int i) {
        this.f3235h = c;
        this.f3236i = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f3242o = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        this.f3235h = c;
        this.f3237j = Character.toLowerCase(c2);
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f3235h = c;
        this.f3236i = KeyEvent.normalizeMetaState(i);
        this.f3237j = Character.toLowerCase(c2);
        this.f3238k = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f3232e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        this.f3232e = this.f3241n.getResources().getString(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f3233f = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        this.f3249v = (z ? 0 : 8) | (this.f3249v & 8);
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public void setShowAsAction(int i) {
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public SupportMenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public SupportMenuItem setActionView(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // android.support.v4.internal.view.SupportMenuItem
    /* JADX INFO: renamed from: a */
    public android.support.v4.view.ActionProvider mo2022a() {
        return null;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem
    /* JADX INFO: renamed from: a */
    public SupportMenuItem mo2020a(android.support.v4.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public SupportMenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    /* JADX INFO: renamed from: a */
    public SupportMenuItem setContentDescription(CharSequence charSequence) {
        this.f3243p = charSequence;
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f3243p;
    }

    @Override // android.view.MenuItem
    /* JADX INFO: renamed from: b */
    public SupportMenuItem setTooltipText(CharSequence charSequence) {
        this.f3244q = charSequence;
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f3244q;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f3245r = colorStateList;
        this.f3247t = true;
        m3502b();
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f3245r;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f3246s = mode;
        this.f3248u = true;
        m3502b();
        return this;
    }

    @Override // android.support.v4.internal.view.SupportMenuItem, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f3246s;
    }

    /* JADX INFO: renamed from: b */
    private void m3502b() {
        if (this.f3239l != null) {
            if (this.f3247t || this.f3248u) {
                this.f3239l = DrawableCompat.m2000g(this.f3239l);
                this.f3239l = this.f3239l.mutate();
                if (this.f3247t) {
                    DrawableCompat.m1989a(this.f3239l, this.f3245r);
                }
                if (this.f3248u) {
                    DrawableCompat.m1992a(this.f3239l, this.f3246s);
                }
            }
        }
    }
}
