package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseMenuPresenter implements MenuPresenter {

    /* JADX INFO: renamed from: a */
    protected Context f3262a;

    /* JADX INFO: renamed from: b */
    protected Context f3263b;

    /* JADX INFO: renamed from: c */
    protected MenuBuilder f3264c;

    /* JADX INFO: renamed from: d */
    protected LayoutInflater f3265d;

    /* JADX INFO: renamed from: e */
    protected LayoutInflater f3266e;

    /* JADX INFO: renamed from: f */
    protected MenuView f3267f;

    /* JADX INFO: renamed from: g */
    private MenuPresenter.Callback f3268g;

    /* JADX INFO: renamed from: h */
    private int f3269h;

    /* JADX INFO: renamed from: i */
    private int f3270i;

    /* JADX INFO: renamed from: j */
    private int f3271j;

    /* JADX INFO: renamed from: a */
    public abstract void mo3517a(MenuItemImpl menuItemImpl, MenuView.ItemView itemView);

    public BaseMenuPresenter(Context context, int i, int i2) {
        this.f3262a = context;
        this.f3265d = LayoutInflater.from(context);
        this.f3269h = i;
        this.f3270i = i2;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public void mo346a(Context context, MenuBuilder menuBuilder) {
        this.f3263b = context;
        this.f3266e = LayoutInflater.from(this.f3263b);
        this.f3264c = menuBuilder;
    }

    /* JADX INFO: renamed from: a */
    public MenuView mo3514a(ViewGroup viewGroup) {
        if (this.f3267f == null) {
            this.f3267f = (MenuView) this.f3265d.inflate(this.f3269h, viewGroup, false);
            this.f3267f.mo343a(this.f3264c);
            mo351a(true);
        }
        return this.f3267f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public void mo351a(boolean z) {
        int i;
        int i2;
        ViewGroup viewGroup = (ViewGroup) this.f3267f;
        if (viewGroup != null) {
            if (this.f3264c != null) {
                this.f3264c.m3617j();
                ArrayList<MenuItemImpl> arrayListM3616i = this.f3264c.m3616i();
                int size = arrayListM3616i.size();
                int i3 = 0;
                i = 0;
                while (i3 < size) {
                    MenuItemImpl menuItemImpl = arrayListM3616i.get(i3);
                    if (mo3519a(i, menuItemImpl)) {
                        View childAt = viewGroup.getChildAt(i);
                        MenuItemImpl itemData = childAt instanceof MenuView.ItemView ? ((MenuView.ItemView) childAt).getItemData() : null;
                        View viewMo3515a = mo3515a(menuItemImpl, childAt, viewGroup);
                        if (menuItemImpl != itemData) {
                            viewMo3515a.setPressed(false);
                            viewMo3515a.jumpDrawablesToCurrentState();
                        }
                        if (viewMo3515a != childAt) {
                            m3518a(viewMo3515a, i);
                        }
                        i2 = i + 1;
                    } else {
                        i2 = i;
                    }
                    i3++;
                    i = i2;
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (!mo3520a(viewGroup, i)) {
                    i++;
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    protected void m3518a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f3267f).addView(view, i);
    }

    /* JADX INFO: renamed from: a */
    protected boolean mo3520a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public void mo350a(MenuPresenter.Callback callback) {
        this.f3268g = callback;
    }

    /* JADX INFO: renamed from: d */
    public MenuPresenter.Callback m3522d() {
        return this.f3268g;
    }

    /* JADX INFO: renamed from: b */
    public MenuView.ItemView m3521b(ViewGroup viewGroup) {
        return (MenuView.ItemView) this.f3265d.inflate(this.f3270i, viewGroup, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public View mo3515a(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        MenuView.ItemView itemViewM3521b;
        if (view instanceof MenuView.ItemView) {
            itemViewM3521b = (MenuView.ItemView) view;
        } else {
            itemViewM3521b = m3521b(viewGroup);
        }
        mo3517a(menuItemImpl, itemViewM3521b);
        return (View) itemViewM3521b;
    }

    /* JADX INFO: renamed from: a */
    public boolean mo3519a(int i, MenuItemImpl menuItemImpl) {
        return true;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public void mo349a(MenuBuilder menuBuilder, boolean z) {
        if (this.f3268g != null) {
            this.f3268g.mo3327a(menuBuilder, z);
        }
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public boolean mo354a(SubMenuBuilder subMenuBuilder) {
        if (this.f3268g != null) {
            return this.f3268g.mo3328a(subMenuBuilder);
        }
        return false;
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

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: b */
    public int mo355b() {
        return this.f3271j;
    }

    /* JADX INFO: renamed from: a */
    public void m3516a(int i) {
        this.f3271j = i;
    }
}
