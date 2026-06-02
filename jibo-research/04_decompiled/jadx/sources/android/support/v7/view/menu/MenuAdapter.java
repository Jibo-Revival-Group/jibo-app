package android.support.v7.view.menu;

import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class MenuAdapter extends BaseAdapter {

    /* JADX INFO: renamed from: a */
    static final int f3342a = R.layout.abc_popup_menu_item_layout;

    /* JADX INFO: renamed from: b */
    MenuBuilder f3343b;

    /* JADX INFO: renamed from: c */
    private int f3344c = -1;

    /* JADX INFO: renamed from: d */
    private boolean f3345d;

    /* JADX INFO: renamed from: e */
    private final boolean f3346e;

    /* JADX INFO: renamed from: f */
    private final LayoutInflater f3347f;

    public MenuAdapter(MenuBuilder menuBuilder, LayoutInflater layoutInflater, boolean z) {
        this.f3346e = z;
        this.f3347f = layoutInflater;
        this.f3343b = menuBuilder;
        m3568b();
    }

    /* JADX INFO: renamed from: a */
    public void m3567a(boolean z) {
        this.f3345d = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<MenuItemImpl> arrayListM3619l = this.f3346e ? this.f3343b.m3619l() : this.f3343b.m3616i();
        if (this.f3344c < 0) {
            return arrayListM3619l.size();
        }
        return arrayListM3619l.size() - 1;
    }

    /* JADX INFO: renamed from: a */
    public MenuBuilder m3565a() {
        return this.f3343b;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public MenuItemImpl getItem(int i) {
        ArrayList<MenuItemImpl> arrayListM3619l = this.f3346e ? this.f3343b.m3619l() : this.f3343b.m3616i();
        if (this.f3344c >= 0 && i >= this.f3344c) {
            i++;
        }
        return arrayListM3619l.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate = view == null ? this.f3347f.inflate(f3342a, viewGroup, false) : view;
        MenuView.ItemView itemView = (MenuView.ItemView) viewInflate;
        if (this.f3345d) {
            ((ListMenuItemView) viewInflate).setForceShowIcon(true);
        }
        itemView.mo336a(getItem(i), 0);
        return viewInflate;
    }

    /* JADX INFO: renamed from: b */
    void m3568b() {
        MenuItemImpl menuItemImplM3625r = this.f3343b.m3625r();
        if (menuItemImplM3625r != null) {
            ArrayList<MenuItemImpl> arrayListM3619l = this.f3343b.m3619l();
            int size = arrayListM3619l.size();
            for (int i = 0; i < size; i++) {
                if (arrayListM3619l.get(i) == menuItemImplM3625r) {
                    this.f3344c = i;
                    return;
                }
            }
        }
        this.f3344c = -1;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        m3568b();
        super.notifyDataSetChanged();
    }
}
