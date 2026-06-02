package android.support.v7.view.menu;

import android.R;
import android.content.Context;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/* JADX INFO: loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements MenuBuilder.ItemInvoker, MenuView, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a */
    private static final int[] f3312a = {R.attr.background, R.attr.divider};

    /* JADX INFO: renamed from: b */
    private MenuBuilder f3313b;

    /* JADX INFO: renamed from: c */
    private int f3314c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        TintTypedArray tintTypedArrayM4955a = TintTypedArray.m4955a(context, attributeSet, f3312a, i, 0);
        if (tintTypedArrayM4955a.m4973g(0)) {
            setBackgroundDrawable(tintTypedArrayM4955a.m4959a(0));
        }
        if (tintTypedArrayM4955a.m4973g(1)) {
            setDivider(tintTypedArrayM4955a.m4959a(1));
        }
        tintTypedArrayM4955a.m4960a();
    }

    @Override // android.support.v7.view.menu.MenuView
    /* JADX INFO: renamed from: a */
    public void mo343a(MenuBuilder menuBuilder) {
        this.f3313b = menuBuilder;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.support.v7.view.menu.MenuBuilder.ItemInvoker
    /* JADX INFO: renamed from: a */
    public boolean mo3554a(MenuItemImpl menuItemImpl) {
        return this.f3313b.m3594a(menuItemImpl, 0);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        mo3554a((MenuItemImpl) getAdapter().getItem(i));
    }

    public int getWindowAnimations() {
        return this.f3314c;
    }
}
