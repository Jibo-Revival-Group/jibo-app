package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.content.ContextCompat;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ActionProvider;
import android.support.v7.appcompat.R;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class MenuBuilder implements SupportMenu {

    /* JADX INFO: renamed from: d */
    private static final int[] f3348d = {1, 4, 5, 3, 2, 0};

    /* JADX INFO: renamed from: a */
    CharSequence f3349a;

    /* JADX INFO: renamed from: b */
    Drawable f3350b;

    /* JADX INFO: renamed from: c */
    View f3351c;

    /* JADX INFO: renamed from: e */
    private final Context f3352e;

    /* JADX INFO: renamed from: f */
    private final Resources f3353f;

    /* JADX INFO: renamed from: g */
    private boolean f3354g;

    /* JADX INFO: renamed from: h */
    private boolean f3355h;

    /* JADX INFO: renamed from: i */
    private Callback f3356i;

    /* JADX INFO: renamed from: q */
    private ContextMenu.ContextMenuInfo f3364q;

    /* JADX INFO: renamed from: y */
    private MenuItemImpl f3372y;

    /* JADX INFO: renamed from: z */
    private boolean f3373z;

    /* JADX INFO: renamed from: p */
    private int f3363p = 0;

    /* JADX INFO: renamed from: r */
    private boolean f3365r = false;

    /* JADX INFO: renamed from: s */
    private boolean f3366s = false;

    /* JADX INFO: renamed from: t */
    private boolean f3367t = false;

    /* JADX INFO: renamed from: u */
    private boolean f3368u = false;

    /* JADX INFO: renamed from: v */
    private boolean f3369v = false;

    /* JADX INFO: renamed from: w */
    private ArrayList<MenuItemImpl> f3370w = new ArrayList<>();

    /* JADX INFO: renamed from: x */
    private CopyOnWriteArrayList<WeakReference<MenuPresenter>> f3371x = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: j */
    private ArrayList<MenuItemImpl> f3357j = new ArrayList<>();

    /* JADX INFO: renamed from: k */
    private ArrayList<MenuItemImpl> f3358k = new ArrayList<>();

    /* JADX INFO: renamed from: l */
    private boolean f3359l = true;

    /* JADX INFO: renamed from: m */
    private ArrayList<MenuItemImpl> f3360m = new ArrayList<>();

    /* JADX INFO: renamed from: n */
    private ArrayList<MenuItemImpl> f3361n = new ArrayList<>();

    /* JADX INFO: renamed from: o */
    private boolean f3362o = true;

    public interface Callback {
        /* JADX INFO: renamed from: a */
        void mo517a(MenuBuilder menuBuilder);

        /* JADX INFO: renamed from: a */
        boolean mo518a(MenuBuilder menuBuilder, MenuItem menuItem);
    }

    public interface ItemInvoker {
        /* JADX INFO: renamed from: a */
        boolean mo3554a(MenuItemImpl menuItemImpl);
    }

    public MenuBuilder(Context context) {
        this.f3352e = context;
        this.f3353f = context.getResources();
        m3576e(true);
    }

    /* JADX INFO: renamed from: a */
    public MenuBuilder m3580a(int i) {
        this.f3363p = i;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public void m3589a(MenuPresenter menuPresenter) {
        m3590a(menuPresenter, this.f3352e);
    }

    /* JADX INFO: renamed from: a */
    public void m3590a(MenuPresenter menuPresenter, Context context) {
        this.f3371x.add(new WeakReference<>(menuPresenter));
        menuPresenter.mo346a(context, this);
        this.f3362o = true;
    }

    /* JADX INFO: renamed from: b */
    public void m3599b(MenuPresenter menuPresenter) {
        for (WeakReference<MenuPresenter> weakReference : this.f3371x) {
            MenuPresenter menuPresenter2 = weakReference.get();
            if (menuPresenter2 == null || menuPresenter2 == menuPresenter) {
                this.f3371x.remove(weakReference);
            }
        }
    }

    /* JADX INFO: renamed from: d */
    private void m3574d(boolean z) {
        if (!this.f3371x.isEmpty()) {
            m3614g();
            for (WeakReference<MenuPresenter> weakReference : this.f3371x) {
                MenuPresenter menuPresenter = weakReference.get();
                if (menuPresenter == null) {
                    this.f3371x.remove(weakReference);
                } else {
                    menuPresenter.mo351a(z);
                }
            }
            m3615h();
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m3573a(SubMenuBuilder subMenuBuilder, MenuPresenter menuPresenter) {
        if (this.f3371x.isEmpty()) {
            return false;
        }
        boolean zMo354a = menuPresenter != null ? menuPresenter.mo354a(subMenuBuilder) : false;
        Iterator<WeakReference<MenuPresenter>> it = this.f3371x.iterator();
        while (true) {
            boolean zMo354a2 = zMo354a;
            if (!it.hasNext()) {
                return zMo354a2;
            }
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter2 = next.get();
            if (menuPresenter2 == null) {
                this.f3371x.remove(next);
            } else if (!zMo354a2) {
                zMo354a2 = menuPresenter2.mo354a(subMenuBuilder);
            }
            zMo354a = zMo354a2;
        }
    }

    /* JADX INFO: renamed from: e */
    private void m3575e(Bundle bundle) {
        Parcelable parcelableMo358c;
        if (!this.f3371x.isEmpty()) {
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            for (WeakReference<MenuPresenter> weakReference : this.f3371x) {
                MenuPresenter menuPresenter = weakReference.get();
                if (menuPresenter == null) {
                    this.f3371x.remove(weakReference);
                } else {
                    int iMo355b = menuPresenter.mo355b();
                    if (iMo355b > 0 && (parcelableMo358c = menuPresenter.mo358c()) != null) {
                        sparseArray.put(iMo355b, parcelableMo358c);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
        }
    }

    /* JADX INFO: renamed from: f */
    private void m3578f(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray != null && !this.f3371x.isEmpty()) {
            for (WeakReference<MenuPresenter> weakReference : this.f3371x) {
                MenuPresenter menuPresenter = weakReference.get();
                if (menuPresenter == null) {
                    this.f3371x.remove(weakReference);
                } else {
                    int iMo355b = menuPresenter.mo355b();
                    if (iMo355b > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(iMo355b)) != null) {
                        menuPresenter.mo347a(parcelable);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3586a(Bundle bundle) {
        m3575e(bundle);
    }

    /* JADX INFO: renamed from: b */
    public void m3597b(Bundle bundle) {
        m3578f(bundle);
    }

    /* JADX INFO: renamed from: c */
    public void m3603c(Bundle bundle) {
        int size = size();
        int i = 0;
        SparseArray<? extends Parcelable> sparseArray = null;
        while (i < size) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            SparseArray<? extends Parcelable> sparseArray2 = sparseArray;
            if (item.hasSubMenu()) {
                ((SubMenuBuilder) item.getSubMenu()).m3603c(bundle);
            }
            i++;
            sparseArray = sparseArray2;
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(mo3585a(), sparseArray);
        }
    }

    /* JADX INFO: renamed from: d */
    public void m3609d(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle != null) {
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(mo3585a());
            int size = size();
            for (int i = 0; i < size; i++) {
                MenuItem item = getItem(i);
                View actionView = item.getActionView();
                if (actionView != null && actionView.getId() != -1) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((SubMenuBuilder) item.getSubMenu()).m3609d(bundle);
                }
            }
            int i2 = bundle.getInt("android:menu:expandedactionview");
            if (i2 > 0 && (menuItemFindItem = findItem(i2)) != null) {
                menuItemFindItem.expandActionView();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    protected String mo3585a() {
        return "android:menu:actionviewstates";
    }

    /* JADX INFO: renamed from: a */
    public void mo3587a(Callback callback) {
        this.f3356i = callback;
    }

    /* JADX INFO: renamed from: a */
    protected MenuItem mo338a(int i, int i2, int i3, CharSequence charSequence) {
        int iM3577f = m3577f(i3);
        MenuItemImpl menuItemImplM3570a = m3570a(i, i2, i3, iM3577f, charSequence, this.f3363p);
        if (this.f3364q != null) {
            menuItemImplM3570a.m3633a(this.f3364q);
        }
        this.f3357j.add(m3569a(this.f3357j, iM3577f), menuItemImplM3570a);
        mo394a(true);
        return menuItemImplM3570a;
    }

    /* JADX INFO: renamed from: a */
    private MenuItemImpl m3570a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new MenuItemImpl(this, i, i2, i3, i4, charSequence, i5);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return mo338a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return mo338a(0, 0, 0, this.f3353f.getString(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return mo338a(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return mo338a(i, i2, i3, this.f3353f.getString(i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f3353f.getString(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) mo338a(i, i2, i3, charSequence);
        SubMenuBuilder subMenuBuilder = new SubMenuBuilder(this.f3352e, this, menuItemImpl);
        menuItemImpl.m3632a(subMenuBuilder);
        return subMenuBuilder;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f3353f.getString(i4));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.f3352e.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i5);
            Intent intent2 = new Intent(resolveInfo.specificIndex < 0 ? intent : intentArr[resolveInfo.specificIndex]);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        m3572a(m3596b(i), true);
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        int iM3602c = m3602c(i);
        if (iM3602c >= 0) {
            int size = this.f3357j.size() - iM3602c;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || this.f3357j.get(iM3602c).getGroupId() != i) {
                    break;
                }
                m3572a(iM3602c, false);
                i2 = i3;
            }
            mo394a(true);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3572a(int i, boolean z) {
        if (i >= 0 && i < this.f3357j.size()) {
            this.f3357j.remove(i);
            if (z) {
                mo394a(true);
            }
        }
    }

    @Override // android.view.Menu
    public void clear() {
        if (this.f3372y != null) {
            mo3610d(this.f3372y);
        }
        this.f3357j.clear();
        mo394a(true);
    }

    /* JADX INFO: renamed from: a */
    void m3591a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f3357j.size();
        m3614g();
        for (int i = 0; i < size; i++) {
            MenuItemImpl menuItemImpl = this.f3357j.get(i);
            if (menuItemImpl.getGroupId() == groupId && menuItemImpl.m3645g() && menuItemImpl.isCheckable()) {
                menuItemImpl.m3636b(menuItemImpl == menuItem);
            }
        }
        m3615h();
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.f3357j.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = this.f3357j.get(i2);
            if (menuItemImpl.getGroupId() == i) {
                menuItemImpl.m3634a(z2);
                menuItemImpl.setCheckable(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        int size = this.f3357j.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            MenuItemImpl menuItemImpl = this.f3357j.get(i2);
            i2++;
            z2 = (menuItemImpl.getGroupId() == i && menuItemImpl.m3639c(z)) ? true : z2;
        }
        if (z2) {
            mo394a(true);
        }
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        int size = this.f3357j.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = this.f3357j.get(i2);
            if (menuItemImpl.getGroupId() == i) {
                menuItemImpl.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.f3373z) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.f3357j.get(i).isVisible()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        MenuItem menuItemFindItem;
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = this.f3357j.get(i2);
            if (menuItemImpl.getItemId() != i) {
                if (menuItemImpl.hasSubMenu() && (menuItemFindItem = menuItemImpl.getSubMenu().findItem(i)) != null) {
                    return menuItemFindItem;
                }
            } else {
                return menuItemImpl;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    public int m3596b(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f3357j.get(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: c */
    public int m3602c(int i) {
        return m3579a(i, 0);
    }

    /* JADX INFO: renamed from: a */
    public int m3579a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        for (int i3 = i2; i3 < size; i3++) {
            if (this.f3357j.get(i3).getGroupId() == i) {
                return i3;
            }
        }
        return -1;
    }

    @Override // android.view.Menu
    public int size() {
        return this.f3357j.size();
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return this.f3357j.get(i);
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return m3584a(i, keyEvent) != null;
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.f3354g = z;
        mo394a(false);
    }

    /* JADX INFO: renamed from: f */
    private static int m3577f(int i) {
        int i2 = ((-65536) & i) >> 16;
        if (i2 < 0 || i2 >= f3348d.length) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        return (f3348d[i2] << 16) | (65535 & i);
    }

    /* JADX INFO: renamed from: b */
    boolean mo3601b() {
        return this.f3354g;
    }

    /* JADX INFO: renamed from: e */
    private void m3576e(boolean z) {
        this.f3355h = z && this.f3353f.getConfiguration().keyboard != 1 && this.f3353f.getBoolean(R.bool.abc_config_showMenuShortcutsWhenKeyboardPresent);
    }

    /* JADX INFO: renamed from: c */
    public boolean mo3605c() {
        return this.f3355h;
    }

    /* JADX INFO: renamed from: d */
    Resources m3607d() {
        return this.f3353f;
    }

    /* JADX INFO: renamed from: e */
    public Context m3611e() {
        return this.f3352e;
    }

    /* JADX INFO: renamed from: a */
    boolean mo3593a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.f3356i != null && this.f3356i.mo518a(menuBuilder, menuItem);
    }

    /* JADX INFO: renamed from: f */
    public void m3613f() {
        if (this.f3356i != null) {
            this.f3356i.mo517a(this);
        }
    }

    /* JADX INFO: renamed from: a */
    private static int m3569a(ArrayList<MenuItemImpl> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).m3638c() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        MenuItemImpl menuItemImplM3584a = m3584a(i, keyEvent);
        boolean zM3594a = false;
        if (menuItemImplM3584a != null) {
            zM3594a = m3594a(menuItemImplM3584a, i2);
        }
        if ((i2 & 2) != 0) {
            m3600b(true);
        }
        return zM3594a;
    }

    /* JADX INFO: renamed from: a */
    void m3592a(List<MenuItemImpl> list, int i, KeyEvent keyEvent) {
        boolean zMo3601b = mo3601b();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.f3357j.size();
            for (int i2 = 0; i2 < size; i2++) {
                MenuItemImpl menuItemImpl = this.f3357j.get(i2);
                if (menuItemImpl.hasSubMenu()) {
                    ((MenuBuilder) menuItemImpl.getSubMenu()).m3592a(list, i, keyEvent);
                }
                char alphabeticShortcut = zMo3601b ? menuItemImpl.getAlphabeticShortcut() : menuItemImpl.getNumericShortcut();
                if (((modifiers & 69647) == ((zMo3601b ? menuItemImpl.getAlphabeticModifiers() : menuItemImpl.getNumericModifiers()) & 69647)) && alphabeticShortcut != 0 && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (zMo3601b && alphabeticShortcut == '\b' && i == 67)) && menuItemImpl.isEnabled())) {
                    list.add(menuItemImpl);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    MenuItemImpl m3584a(int i, KeyEvent keyEvent) {
        ArrayList<MenuItemImpl> arrayList = this.f3370w;
        arrayList.clear();
        m3592a(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean zMo3601b = mo3601b();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = arrayList.get(i2);
            char alphabeticShortcut = zMo3601b ? menuItemImpl.getAlphabeticShortcut() : menuItemImpl.getNumericShortcut();
            if (alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) {
                return menuItemImpl;
            }
            if (alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) {
                return menuItemImpl;
            }
            if (zMo3601b && alphabeticShortcut == '\b' && i == 67) {
                return menuItemImpl;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return m3594a(findItem(i), i2);
    }

    /* JADX INFO: renamed from: a */
    public boolean m3594a(MenuItem menuItem, int i) {
        return m3595a(menuItem, (MenuPresenter) null, i);
    }

    /* JADX INFO: renamed from: a */
    public boolean m3595a(MenuItem menuItem, MenuPresenter menuPresenter, int i) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) menuItem;
        if (menuItemImpl == null || !menuItemImpl.isEnabled()) {
            return false;
        }
        boolean zM3637b = menuItemImpl.m3637b();
        ActionProvider actionProviderMo2022a = menuItemImpl.mo2022a();
        boolean z = actionProviderMo2022a != null && actionProviderMo2022a.mo2496e();
        if (menuItemImpl.m3652n()) {
            boolean zExpandActionView = menuItemImpl.expandActionView() | zM3637b;
            if (zExpandActionView) {
                m3600b(true);
                return zExpandActionView;
            }
            return zExpandActionView;
        }
        if (menuItemImpl.hasSubMenu() || z) {
            if ((i & 4) == 0) {
                m3600b(false);
            }
            if (!menuItemImpl.hasSubMenu()) {
                menuItemImpl.m3632a(new SubMenuBuilder(m3611e(), this, menuItemImpl));
            }
            SubMenuBuilder subMenuBuilder = (SubMenuBuilder) menuItemImpl.getSubMenu();
            if (z) {
                actionProviderMo2022a.mo2491a(subMenuBuilder);
            }
            boolean zM3573a = m3573a(subMenuBuilder, menuPresenter) | zM3637b;
            if (!zM3573a) {
                m3600b(true);
                return zM3573a;
            }
            return zM3573a;
        }
        if ((i & 1) == 0) {
            m3600b(true);
        }
        return zM3637b;
    }

    /* JADX INFO: renamed from: b */
    public final void m3600b(boolean z) {
        if (!this.f3369v) {
            this.f3369v = true;
            for (WeakReference<MenuPresenter> weakReference : this.f3371x) {
                MenuPresenter menuPresenter = weakReference.get();
                if (menuPresenter == null) {
                    this.f3371x.remove(weakReference);
                } else {
                    menuPresenter.mo349a(this, z);
                }
            }
            this.f3369v = false;
        }
    }

    @Override // android.view.Menu
    public void close() {
        m3600b(true);
    }

    /* JADX INFO: renamed from: a */
    public void mo394a(boolean z) {
        if (!this.f3365r) {
            if (z) {
                this.f3359l = true;
                this.f3362o = true;
            }
            m3574d(z);
            return;
        }
        this.f3366s = true;
        if (z) {
            this.f3367t = true;
        }
    }

    /* JADX INFO: renamed from: g */
    public void m3614g() {
        if (!this.f3365r) {
            this.f3365r = true;
            this.f3366s = false;
            this.f3367t = false;
        }
    }

    /* JADX INFO: renamed from: h */
    public void m3615h() {
        this.f3365r = false;
        if (this.f3366s) {
            this.f3366s = false;
            mo394a(this.f3367t);
        }
    }

    /* JADX INFO: renamed from: a */
    void m3588a(MenuItemImpl menuItemImpl) {
        this.f3359l = true;
        mo394a(true);
    }

    /* JADX INFO: renamed from: b */
    void m3598b(MenuItemImpl menuItemImpl) {
        this.f3362o = true;
        mo394a(true);
    }

    /* JADX INFO: renamed from: i */
    public ArrayList<MenuItemImpl> m3616i() {
        if (!this.f3359l) {
            return this.f3358k;
        }
        this.f3358k.clear();
        int size = this.f3357j.size();
        for (int i = 0; i < size; i++) {
            MenuItemImpl menuItemImpl = this.f3357j.get(i);
            if (menuItemImpl.isVisible()) {
                this.f3358k.add(menuItemImpl);
            }
        }
        this.f3359l = false;
        this.f3362o = true;
        return this.f3358k;
    }

    /* JADX INFO: renamed from: j */
    public void m3617j() {
        boolean zMo352a;
        ArrayList<MenuItemImpl> arrayListM3616i = m3616i();
        if (this.f3362o) {
            boolean z = false;
            for (WeakReference<MenuPresenter> weakReference : this.f3371x) {
                MenuPresenter menuPresenter = weakReference.get();
                if (menuPresenter == null) {
                    this.f3371x.remove(weakReference);
                    zMo352a = z;
                } else {
                    zMo352a = menuPresenter.mo352a() | z;
                }
                z = zMo352a;
            }
            if (z) {
                this.f3360m.clear();
                this.f3361n.clear();
                int size = arrayListM3616i.size();
                for (int i = 0; i < size; i++) {
                    MenuItemImpl menuItemImpl = arrayListM3616i.get(i);
                    if (menuItemImpl.m3648j()) {
                        this.f3360m.add(menuItemImpl);
                    } else {
                        this.f3361n.add(menuItemImpl);
                    }
                }
            } else {
                this.f3360m.clear();
                this.f3361n.clear();
                this.f3361n.addAll(m3616i());
            }
            this.f3362o = false;
        }
    }

    /* JADX INFO: renamed from: k */
    public ArrayList<MenuItemImpl> m3618k() {
        m3617j();
        return this.f3360m;
    }

    /* JADX INFO: renamed from: l */
    public ArrayList<MenuItemImpl> m3619l() {
        m3617j();
        return this.f3361n;
    }

    public void clearHeader() {
        this.f3350b = null;
        this.f3349a = null;
        this.f3351c = null;
        mo394a(false);
    }

    /* JADX INFO: renamed from: a */
    private void m3571a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources resourcesM3607d = m3607d();
        if (view != null) {
            this.f3351c = view;
            this.f3349a = null;
            this.f3350b = null;
        } else {
            if (i > 0) {
                this.f3349a = resourcesM3607d.getText(i);
            } else if (charSequence != null) {
                this.f3349a = charSequence;
            }
            if (i2 > 0) {
                this.f3350b = ContextCompat.m1832a(m3611e(), i2);
            } else if (drawable != null) {
                this.f3350b = drawable;
            }
            this.f3351c = null;
        }
        mo394a(false);
    }

    /* JADX INFO: renamed from: a */
    protected MenuBuilder m3583a(CharSequence charSequence) {
        m3571a(0, charSequence, 0, null, null);
        return this;
    }

    /* JADX INFO: renamed from: d */
    protected MenuBuilder m3608d(int i) {
        m3571a(i, null, 0, null, null);
        return this;
    }

    /* JADX INFO: renamed from: a */
    protected MenuBuilder m3581a(Drawable drawable) {
        m3571a(0, null, 0, drawable, null);
        return this;
    }

    /* JADX INFO: renamed from: e */
    protected MenuBuilder m3612e(int i) {
        m3571a(0, null, i, null, null);
        return this;
    }

    /* JADX INFO: renamed from: a */
    protected MenuBuilder m3582a(View view) {
        m3571a(0, null, 0, null, view);
        return this;
    }

    /* JADX INFO: renamed from: m */
    public CharSequence m3620m() {
        return this.f3349a;
    }

    /* JADX INFO: renamed from: n */
    public Drawable m3621n() {
        return this.f3350b;
    }

    /* JADX INFO: renamed from: o */
    public View m3622o() {
        return this.f3351c;
    }

    /* JADX INFO: renamed from: p */
    public MenuBuilder mo3623p() {
        return this;
    }

    /* JADX INFO: renamed from: q */
    boolean m3624q() {
        return this.f3368u;
    }

    /* JADX INFO: renamed from: c */
    public boolean mo3606c(MenuItemImpl menuItemImpl) {
        boolean zMo353a = false;
        if (!this.f3371x.isEmpty()) {
            m3614g();
            Iterator<WeakReference<MenuPresenter>> it = this.f3371x.iterator();
            while (true) {
                boolean z = zMo353a;
                if (!it.hasNext()) {
                    zMo353a = z;
                    break;
                }
                WeakReference<MenuPresenter> next = it.next();
                MenuPresenter menuPresenter = next.get();
                if (menuPresenter == null) {
                    this.f3371x.remove(next);
                    zMo353a = z;
                } else {
                    zMo353a = menuPresenter.mo353a(this, menuItemImpl);
                    if (zMo353a) {
                        break;
                    }
                }
            }
            m3615h();
            if (zMo353a) {
                this.f3372y = menuItemImpl;
            }
        }
        return zMo353a;
    }

    /* JADX INFO: renamed from: d */
    public boolean mo3610d(MenuItemImpl menuItemImpl) {
        boolean zMo357b = false;
        if (!this.f3371x.isEmpty() && this.f3372y == menuItemImpl) {
            m3614g();
            Iterator<WeakReference<MenuPresenter>> it = this.f3371x.iterator();
            while (true) {
                boolean z = zMo357b;
                if (!it.hasNext()) {
                    zMo357b = z;
                    break;
                }
                WeakReference<MenuPresenter> next = it.next();
                MenuPresenter menuPresenter = next.get();
                if (menuPresenter == null) {
                    this.f3371x.remove(next);
                    zMo357b = z;
                } else {
                    zMo357b = menuPresenter.mo357b(this, menuItemImpl);
                    if (zMo357b) {
                        break;
                    }
                }
            }
            m3615h();
            if (zMo357b) {
                this.f3372y = null;
            }
        }
        return zMo357b;
    }

    /* JADX INFO: renamed from: r */
    public MenuItemImpl m3625r() {
        return this.f3372y;
    }

    /* JADX INFO: renamed from: c */
    public void m3604c(boolean z) {
        this.f3373z = z;
    }
}
