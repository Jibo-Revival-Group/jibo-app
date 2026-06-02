package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.R;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class NavigationMenuPresenter implements MenuPresenter {

    /* JADX INFO: renamed from: a */
    LinearLayout f436a;

    /* JADX INFO: renamed from: b */
    MenuBuilder f437b;

    /* JADX INFO: renamed from: c */
    NavigationMenuAdapter f438c;

    /* JADX INFO: renamed from: d */
    LayoutInflater f439d;

    /* JADX INFO: renamed from: e */
    int f440e;

    /* JADX INFO: renamed from: f */
    boolean f441f;

    /* JADX INFO: renamed from: g */
    ColorStateList f442g;

    /* JADX INFO: renamed from: h */
    ColorStateList f443h;

    /* JADX INFO: renamed from: i */
    Drawable f444i;

    /* JADX INFO: renamed from: j */
    int f445j;

    /* JADX INFO: renamed from: k */
    final View.OnClickListener f446k = new View.OnClickListener() { // from class: android.support.design.internal.NavigationMenuPresenter.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NavigationMenuPresenter.this.m375b(true);
            MenuItemImpl itemData = ((NavigationMenuItemView) view).getItemData();
            boolean zM3595a = NavigationMenuPresenter.this.f437b.m3595a(itemData, NavigationMenuPresenter.this, 0);
            if (itemData != null && itemData.isCheckable() && zM3595a) {
                NavigationMenuPresenter.this.f438c.m388a(itemData);
            }
            NavigationMenuPresenter.this.m375b(false);
            NavigationMenuPresenter.this.mo351a(false);
        }
    };

    /* JADX INFO: renamed from: l */
    private NavigationMenuView f447l;

    /* JADX INFO: renamed from: m */
    private MenuPresenter.Callback f448m;

    /* JADX INFO: renamed from: n */
    private int f449n;

    /* JADX INFO: renamed from: o */
    private int f450o;

    private interface NavigationMenuItem {
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public void mo346a(Context context, MenuBuilder menuBuilder) {
        this.f439d = LayoutInflater.from(context);
        this.f437b = menuBuilder;
        this.f445j = context.getResources().getDimensionPixelOffset(R.dimen.design_navigation_separator_vertical_padding);
    }

    /* JADX INFO: renamed from: a */
    public MenuView m366a(ViewGroup viewGroup) {
        if (this.f447l == null) {
            this.f447l = (NavigationMenuView) this.f439d.inflate(R.layout.design_navigation_menu, viewGroup, false);
            if (this.f438c == null) {
                this.f438c = new NavigationMenuAdapter();
            }
            this.f436a = (LinearLayout) this.f439d.inflate(R.layout.design_navigation_item_header, (ViewGroup) this.f447l, false);
            this.f447l.setAdapter(this.f438c);
        }
        return this.f447l;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public void mo351a(boolean z) {
        if (this.f438c != null) {
            this.f438c.m384a();
        }
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public void mo350a(MenuPresenter.Callback callback) {
        this.f448m = callback;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public boolean mo354a(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public void mo349a(MenuBuilder menuBuilder, boolean z) {
        if (this.f448m != null) {
            this.f448m.mo3327a(menuBuilder, z);
        }
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
        return this.f449n;
    }

    /* JADX INFO: renamed from: a */
    public void m367a(int i) {
        this.f449n = i;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: c */
    public Parcelable mo358c() {
        if (Build.VERSION.SDK_INT < 11) {
            return null;
        }
        Bundle bundle = new Bundle();
        if (this.f447l != null) {
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            this.f447l.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        if (this.f438c != null) {
            bundle.putBundle("android:menu:adapter", this.f438c.m390b());
        }
        if (this.f436a != null) {
            SparseArray<? extends Parcelable> sparseArray2 = new SparseArray<>();
            this.f436a.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray2);
            return bundle;
        }
        return bundle;
    }

    @Override // android.support.v7.view.menu.MenuPresenter
    /* JADX INFO: renamed from: a */
    public void mo347a(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.f447l.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                this.f438c.m385a(bundle2);
            }
            SparseArray sparseParcelableArray2 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray2 != null) {
                this.f436a.restoreHierarchyState(sparseParcelableArray2);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m371a(MenuItemImpl menuItemImpl) {
        this.f438c.m388a(menuItemImpl);
    }

    /* JADX INFO: renamed from: b */
    public View m373b(int i) {
        View viewInflate = this.f439d.inflate(i, (ViewGroup) this.f436a, false);
        m372a(viewInflate);
        return viewInflate;
    }

    /* JADX INFO: renamed from: a */
    public void m372a(View view) {
        this.f436a.addView(view);
        this.f447l.setPadding(0, 0, 0, this.f447l.getPaddingBottom());
    }

    /* JADX INFO: renamed from: d */
    public int m377d() {
        return this.f436a.getChildCount();
    }

    /* JADX INFO: renamed from: e */
    public ColorStateList m378e() {
        return this.f443h;
    }

    /* JADX INFO: renamed from: a */
    public void m368a(ColorStateList colorStateList) {
        this.f443h = colorStateList;
        mo351a(false);
    }

    /* JADX INFO: renamed from: f */
    public ColorStateList m379f() {
        return this.f442g;
    }

    /* JADX INFO: renamed from: b */
    public void m374b(ColorStateList colorStateList) {
        this.f442g = colorStateList;
        mo351a(false);
    }

    /* JADX INFO: renamed from: c */
    public void m376c(int i) {
        this.f440e = i;
        this.f441f = true;
        mo351a(false);
    }

    /* JADX INFO: renamed from: g */
    public Drawable m380g() {
        return this.f444i;
    }

    /* JADX INFO: renamed from: a */
    public void m369a(Drawable drawable) {
        this.f444i = drawable;
        mo351a(false);
    }

    /* JADX INFO: renamed from: b */
    public void m375b(boolean z) {
        if (this.f438c != null) {
            this.f438c.m389a(z);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m370a(WindowInsetsCompat windowInsetsCompat) {
        int iM2770b = windowInsetsCompat.m2770b();
        if (this.f450o != iM2770b) {
            this.f450o = iM2770b;
            if (this.f436a.getChildCount() == 0) {
                this.f447l.setPadding(0, this.f450o, 0, this.f447l.getPaddingBottom());
            }
        }
        ViewCompat.m2591b(this.f436a, windowInsetsCompat);
    }

    private static abstract class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View view) {
            super(view);
        }
    }

    private static class NormalViewHolder extends ViewHolder {
        public NormalViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(R.layout.design_navigation_item, viewGroup, false));
            this.itemView.setOnClickListener(onClickListener);
        }
    }

    private static class SubheaderViewHolder extends ViewHolder {
        public SubheaderViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.design_navigation_item_subheader, viewGroup, false));
        }
    }

    private static class SeparatorViewHolder extends ViewHolder {
        public SeparatorViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.design_navigation_item_separator, viewGroup, false));
        }
    }

    private static class HeaderViewHolder extends ViewHolder {
        public HeaderViewHolder(View view) {
            super(view);
        }
    }

    private class NavigationMenuAdapter extends RecyclerView.Adapter<ViewHolder> {

        /* JADX INFO: renamed from: b */
        private final ArrayList<NavigationMenuItem> f453b = new ArrayList<>();

        /* JADX INFO: renamed from: c */
        private MenuItemImpl f454c;

        /* JADX INFO: renamed from: d */
        private boolean f455d;

        NavigationMenuAdapter() {
            m382c();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f453b.size();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            NavigationMenuItem navigationMenuItem = this.f453b.get(i);
            if (navigationMenuItem instanceof NavigationMenuSeparatorItem) {
                return 2;
            }
            if (navigationMenuItem instanceof NavigationMenuHeaderItem) {
                return 3;
            }
            if (navigationMenuItem instanceof NavigationMenuTextItem) {
                if (((NavigationMenuTextItem) navigationMenuItem).m393a().hasSubMenu()) {
                    return 1;
                }
                return 0;
            }
            throw new RuntimeException("Unknown item type.");
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    return new NormalViewHolder(NavigationMenuPresenter.this.f439d, viewGroup, NavigationMenuPresenter.this.f446k);
                case 1:
                    return new SubheaderViewHolder(NavigationMenuPresenter.this.f439d, viewGroup);
                case 2:
                    return new SeparatorViewHolder(NavigationMenuPresenter.this.f439d, viewGroup);
                case 3:
                    return new HeaderViewHolder(NavigationMenuPresenter.this.f436a);
                default:
                    return null;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            switch (getItemViewType(i)) {
                case 0:
                    NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) viewHolder.itemView;
                    navigationMenuItemView.setIconTintList(NavigationMenuPresenter.this.f443h);
                    if (NavigationMenuPresenter.this.f441f) {
                        navigationMenuItemView.setTextAppearance(NavigationMenuPresenter.this.f440e);
                    }
                    if (NavigationMenuPresenter.this.f442g != null) {
                        navigationMenuItemView.setTextColor(NavigationMenuPresenter.this.f442g);
                    }
                    ViewCompat.m2582a(navigationMenuItemView, NavigationMenuPresenter.this.f444i != null ? NavigationMenuPresenter.this.f444i.getConstantState().newDrawable() : null);
                    NavigationMenuTextItem navigationMenuTextItem = (NavigationMenuTextItem) this.f453b.get(i);
                    navigationMenuItemView.setNeedsEmptyIcon(navigationMenuTextItem.f458a);
                    navigationMenuItemView.mo336a(navigationMenuTextItem.m393a(), 0);
                    break;
                case 1:
                    ((TextView) viewHolder.itemView).setText(((NavigationMenuTextItem) this.f453b.get(i)).m393a().getTitle());
                    break;
                case 2:
                    NavigationMenuSeparatorItem navigationMenuSeparatorItem = (NavigationMenuSeparatorItem) this.f453b.get(i);
                    viewHolder.itemView.setPadding(0, navigationMenuSeparatorItem.m391a(), 0, navigationMenuSeparatorItem.m392b());
                    break;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onViewRecycled(ViewHolder viewHolder) {
            if (viewHolder instanceof NormalViewHolder) {
                ((NavigationMenuItemView) viewHolder.itemView).m364b();
            }
        }

        /* JADX INFO: renamed from: a */
        public void m384a() {
            m382c();
            notifyDataSetChanged();
        }

        /* JADX INFO: renamed from: c */
        private void m382c() {
            boolean z;
            int size;
            int i;
            if (!this.f455d) {
                this.f455d = true;
                this.f453b.clear();
                this.f453b.add(new NavigationMenuHeaderItem());
                int i2 = -1;
                int i3 = 0;
                boolean z2 = false;
                int size2 = NavigationMenuPresenter.this.f437b.m3616i().size();
                int i4 = 0;
                while (i4 < size2) {
                    MenuItemImpl menuItemImpl = NavigationMenuPresenter.this.f437b.m3616i().get(i4);
                    if (menuItemImpl.isChecked()) {
                        m388a(menuItemImpl);
                    }
                    if (menuItemImpl.isCheckable()) {
                        menuItemImpl.m3634a(false);
                    }
                    if (menuItemImpl.hasSubMenu()) {
                        SubMenu subMenu = menuItemImpl.getSubMenu();
                        if (subMenu.hasVisibleItems()) {
                            if (i4 != 0) {
                                this.f453b.add(new NavigationMenuSeparatorItem(NavigationMenuPresenter.this.f445j, 0));
                            }
                            this.f453b.add(new NavigationMenuTextItem(menuItemImpl));
                            boolean z3 = false;
                            int size3 = this.f453b.size();
                            int size4 = subMenu.size();
                            for (int i5 = 0; i5 < size4; i5++) {
                                MenuItemImpl menuItemImpl2 = (MenuItemImpl) subMenu.getItem(i5);
                                if (menuItemImpl2.isVisible()) {
                                    if (!z3 && menuItemImpl2.getIcon() != null) {
                                        z3 = true;
                                    }
                                    if (menuItemImpl2.isCheckable()) {
                                        menuItemImpl2.m3634a(false);
                                    }
                                    if (menuItemImpl.isChecked()) {
                                        m388a(menuItemImpl);
                                    }
                                    this.f453b.add(new NavigationMenuTextItem(menuItemImpl2));
                                }
                            }
                            if (z3) {
                                m381a(size3, this.f453b.size());
                            }
                        }
                        i = i2;
                    } else {
                        int groupId = menuItemImpl.getGroupId();
                        if (groupId != i2) {
                            size = this.f453b.size();
                            z = menuItemImpl.getIcon() != null;
                            if (i4 != 0) {
                                size++;
                                this.f453b.add(new NavigationMenuSeparatorItem(NavigationMenuPresenter.this.f445j, NavigationMenuPresenter.this.f445j));
                            }
                        } else if (z2 || menuItemImpl.getIcon() == null) {
                            z = z2;
                            size = i3;
                        } else {
                            z = true;
                            m381a(i3, this.f453b.size());
                            size = i3;
                        }
                        NavigationMenuTextItem navigationMenuTextItem = new NavigationMenuTextItem(menuItemImpl);
                        navigationMenuTextItem.f458a = z;
                        this.f453b.add(navigationMenuTextItem);
                        z2 = z;
                        i3 = size;
                        i = groupId;
                    }
                    i4++;
                    i2 = i;
                }
                this.f455d = false;
            }
        }

        /* JADX INFO: renamed from: a */
        private void m381a(int i, int i2) {
            while (i < i2) {
                ((NavigationMenuTextItem) this.f453b.get(i)).f458a = true;
                i++;
            }
        }

        /* JADX INFO: renamed from: a */
        public void m388a(MenuItemImpl menuItemImpl) {
            if (this.f454c != menuItemImpl && menuItemImpl.isCheckable()) {
                if (this.f454c != null) {
                    this.f454c.setChecked(false);
                }
                this.f454c = menuItemImpl;
                menuItemImpl.setChecked(true);
            }
        }

        /* JADX INFO: renamed from: b */
        public Bundle m390b() {
            Bundle bundle = new Bundle();
            if (this.f454c != null) {
                bundle.putInt("android:menu:checked", this.f454c.getItemId());
            }
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            int size = this.f453b.size();
            for (int i = 0; i < size; i++) {
                NavigationMenuItem navigationMenuItem = this.f453b.get(i);
                if (navigationMenuItem instanceof NavigationMenuTextItem) {
                    MenuItemImpl menuItemImplM393a = ((NavigationMenuTextItem) navigationMenuItem).m393a();
                    View actionView = menuItemImplM393a != null ? menuItemImplM393a.getActionView() : null;
                    if (actionView != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(menuItemImplM393a.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }

        /* JADX INFO: renamed from: a */
        public void m385a(Bundle bundle) {
            MenuItemImpl menuItemImplM393a;
            View actionView;
            ParcelableSparseArray parcelableSparseArray;
            MenuItemImpl menuItemImplM393a2;
            int i = bundle.getInt("android:menu:checked", 0);
            if (i != 0) {
                this.f455d = true;
                int size = this.f453b.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    NavigationMenuItem navigationMenuItem = this.f453b.get(i2);
                    if (!(navigationMenuItem instanceof NavigationMenuTextItem) || (menuItemImplM393a2 = ((NavigationMenuTextItem) navigationMenuItem).m393a()) == null || menuItemImplM393a2.getItemId() != i) {
                        i2++;
                    } else {
                        m388a(menuItemImplM393a2);
                        break;
                    }
                }
                this.f455d = false;
                m382c();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:action_views");
            if (sparseParcelableArray != null) {
                int size2 = this.f453b.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    NavigationMenuItem navigationMenuItem2 = this.f453b.get(i3);
                    if ((navigationMenuItem2 instanceof NavigationMenuTextItem) && (menuItemImplM393a = ((NavigationMenuTextItem) navigationMenuItem2).m393a()) != null && (actionView = menuItemImplM393a.getActionView()) != null && (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray.get(menuItemImplM393a.getItemId())) != null) {
                        actionView.restoreHierarchyState(parcelableSparseArray);
                    }
                }
            }
        }

        /* JADX INFO: renamed from: a */
        public void m389a(boolean z) {
            this.f455d = z;
        }
    }

    private static class NavigationMenuTextItem implements NavigationMenuItem {

        /* JADX INFO: renamed from: a */
        boolean f458a;

        /* JADX INFO: renamed from: b */
        private final MenuItemImpl f459b;

        NavigationMenuTextItem(MenuItemImpl menuItemImpl) {
            this.f459b = menuItemImpl;
        }

        /* JADX INFO: renamed from: a */
        public MenuItemImpl m393a() {
            return this.f459b;
        }
    }

    private static class NavigationMenuSeparatorItem implements NavigationMenuItem {

        /* JADX INFO: renamed from: a */
        private final int f456a;

        /* JADX INFO: renamed from: b */
        private final int f457b;

        public NavigationMenuSeparatorItem(int i, int i2) {
            this.f456a = i;
            this.f457b = i2;
        }

        /* JADX INFO: renamed from: a */
        public int m391a() {
            return this.f456a;
        }

        /* JADX INFO: renamed from: b */
        public int m392b() {
            return this.f457b;
        }
    }

    private static class NavigationMenuHeaderItem implements NavigationMenuItem {
        NavigationMenuHeaderItem() {
        }
    }
}
