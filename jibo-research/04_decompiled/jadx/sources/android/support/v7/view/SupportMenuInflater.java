package android.support.v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuItemWrapperICS;
import android.support.v7.widget.DrawableUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class SupportMenuInflater extends MenuInflater {

    /* JADX INFO: renamed from: a */
    static final Class<?>[] f3177a = {Context.class};

    /* JADX INFO: renamed from: b */
    static final Class<?>[] f3178b = f3177a;

    /* JADX INFO: renamed from: c */
    final Object[] f3179c;

    /* JADX INFO: renamed from: d */
    final Object[] f3180d;

    /* JADX INFO: renamed from: e */
    Context f3181e;

    /* JADX INFO: renamed from: f */
    private Object f3182f;

    public SupportMenuInflater(Context context) {
        super(context);
        this.f3181e = context;
        this.f3179c = new Object[]{context};
        this.f3180d = this.f3179c;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i, Menu menu) {
        if (!(menu instanceof SupportMenu)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser layout = null;
        try {
            try {
                layout = this.f3181e.getResources().getLayout(i);
                m3482a(layout, Xml.asAttributeSet(layout), menu);
            } catch (IOException e) {
                throw new InflateException("Error inflating menu XML", e);
            } catch (XmlPullParserException e2) {
                throw new InflateException("Error inflating menu XML", e2);
            }
        } finally {
            if (layout != null) {
                layout.close();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0025, code lost:
    
        switch(r3) {
            case 1: goto L58;
            case 2: goto L18;
            case 3: goto L30;
            default: goto L11;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
    
        r3 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
    
        r9 = r3;
        r3 = r11.next();
        r5 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
    
        if (r5 == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0053, code lost:
    
        r3 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0055, code lost:
    
        r3 = r11.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005f, code lost:
    
        if (r3.equals("group") == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0061, code lost:
    
        r7.m3488a(r12);
        r3 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006c, code lost:
    
        if (r3.equals("item") == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006e, code lost:
    
        r7.m3490b(r12);
        r3 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0079, code lost:
    
        if (r3.equals("menu") == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007b, code lost:
    
        m3482a(r11, r12, r7.m3491c());
        r3 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0084, code lost:
    
        r2 = r3;
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0087, code lost:
    
        r3 = r11.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008b, code lost:
    
        if (r5 == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0091, code lost:
    
        if (r3.equals(r2) == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0093, code lost:
    
        r2 = null;
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x009c, code lost:
    
        if (r3.equals("group") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x009e, code lost:
    
        r7.m3487a();
        r3 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a9, code lost:
    
        if (r3.equals("item") == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00af, code lost:
    
        if (r7.m3492d() != false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b3, code lost:
    
        if (r7.f3192a == null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00bb, code lost:
    
        if (r7.f3192a.mo2496e() == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00bd, code lost:
    
        r7.m3491c();
        r3 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c3, code lost:
    
        r7.m3489b();
        r3 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00cf, code lost:
    
        if (r3.equals("menu") == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d1, code lost:
    
        r0 = true;
        r3 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00dc, code lost:
    
        throw new java.lang.RuntimeException("Unexpected end of document");
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00dd, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:?, code lost:
    
        r3 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:?, code lost:
    
        r3 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001f, code lost:
    
        r2 = null;
        r5 = false;
        r3 = r0;
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0023, code lost:
    
        if (r0 != false) goto L57;
     */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m3482a(org.xmlpull.v1.XmlPullParser r11, android.util.AttributeSet r12, android.view.Menu r13) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.view.SupportMenuInflater.m3482a(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    /* JADX INFO: renamed from: a */
    Object m3483a() {
        if (this.f3182f == null) {
            this.f3182f = m3481a(this.f3181e);
        }
        return this.f3182f;
    }

    /* JADX INFO: renamed from: a */
    private Object m3481a(Object obj) {
        if (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) {
            return m3481a(((ContextWrapper) obj).getBaseContext());
        }
        return obj;
    }

    private static class InflatedOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: a */
        private static final Class<?>[] f3183a = {MenuItem.class};

        /* JADX INFO: renamed from: b */
        private Object f3184b;

        /* JADX INFO: renamed from: c */
        private Method f3185c;

        public InflatedOnMenuItemClickListener(Object obj, String str) {
            this.f3184b = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f3185c = cls.getMethod(str, f3183a);
            } catch (Exception e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f3185c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f3185c.invoke(this.f3184b, menuItem)).booleanValue();
                }
                this.f3185c.invoke(this.f3184b, menuItem);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class MenuState {

        /* JADX INFO: renamed from: A */
        private String f3186A;

        /* JADX INFO: renamed from: B */
        private String f3187B;

        /* JADX INFO: renamed from: C */
        private CharSequence f3188C;

        /* JADX INFO: renamed from: D */
        private CharSequence f3189D;

        /* JADX INFO: renamed from: E */
        private ColorStateList f3190E = null;

        /* JADX INFO: renamed from: F */
        private PorterDuff.Mode f3191F = null;

        /* JADX INFO: renamed from: a */
        ActionProvider f3192a;

        /* JADX INFO: renamed from: c */
        private Menu f3194c;

        /* JADX INFO: renamed from: d */
        private int f3195d;

        /* JADX INFO: renamed from: e */
        private int f3196e;

        /* JADX INFO: renamed from: f */
        private int f3197f;

        /* JADX INFO: renamed from: g */
        private int f3198g;

        /* JADX INFO: renamed from: h */
        private boolean f3199h;

        /* JADX INFO: renamed from: i */
        private boolean f3200i;

        /* JADX INFO: renamed from: j */
        private boolean f3201j;

        /* JADX INFO: renamed from: k */
        private int f3202k;

        /* JADX INFO: renamed from: l */
        private int f3203l;

        /* JADX INFO: renamed from: m */
        private CharSequence f3204m;

        /* JADX INFO: renamed from: n */
        private CharSequence f3205n;

        /* JADX INFO: renamed from: o */
        private int f3206o;

        /* JADX INFO: renamed from: p */
        private char f3207p;

        /* JADX INFO: renamed from: q */
        private int f3208q;

        /* JADX INFO: renamed from: r */
        private char f3209r;

        /* JADX INFO: renamed from: s */
        private int f3210s;

        /* JADX INFO: renamed from: t */
        private int f3211t;

        /* JADX INFO: renamed from: u */
        private boolean f3212u;

        /* JADX INFO: renamed from: v */
        private boolean f3213v;

        /* JADX INFO: renamed from: w */
        private boolean f3214w;

        /* JADX INFO: renamed from: x */
        private int f3215x;

        /* JADX INFO: renamed from: y */
        private int f3216y;

        /* JADX INFO: renamed from: z */
        private String f3217z;

        public MenuState(Menu menu) {
            this.f3194c = menu;
            m3487a();
        }

        /* JADX INFO: renamed from: a */
        public void m3487a() {
            this.f3195d = 0;
            this.f3196e = 0;
            this.f3197f = 0;
            this.f3198g = 0;
            this.f3199h = true;
            this.f3200i = true;
        }

        /* JADX INFO: renamed from: a */
        public void m3488a(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = SupportMenuInflater.this.f3181e.obtainStyledAttributes(attributeSet, R.styleable.MenuGroup);
            this.f3195d = typedArrayObtainStyledAttributes.getResourceId(R.styleable.MenuGroup_android_id, 0);
            this.f3196e = typedArrayObtainStyledAttributes.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
            this.f3197f = typedArrayObtainStyledAttributes.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
            this.f3198g = typedArrayObtainStyledAttributes.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
            this.f3199h = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_visible, true);
            this.f3200i = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_enabled, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        /* JADX INFO: renamed from: b */
        public void m3490b(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = SupportMenuInflater.this.f3181e.obtainStyledAttributes(attributeSet, R.styleable.MenuItem);
            this.f3202k = typedArrayObtainStyledAttributes.getResourceId(R.styleable.MenuItem_android_id, 0);
            this.f3203l = (typedArrayObtainStyledAttributes.getInt(R.styleable.MenuItem_android_menuCategory, this.f3196e) & (-65536)) | (typedArrayObtainStyledAttributes.getInt(R.styleable.MenuItem_android_orderInCategory, this.f3197f) & 65535);
            this.f3204m = typedArrayObtainStyledAttributes.getText(R.styleable.MenuItem_android_title);
            this.f3205n = typedArrayObtainStyledAttributes.getText(R.styleable.MenuItem_android_titleCondensed);
            this.f3206o = typedArrayObtainStyledAttributes.getResourceId(R.styleable.MenuItem_android_icon, 0);
            this.f3207p = m3484a(typedArrayObtainStyledAttributes.getString(R.styleable.MenuItem_android_alphabeticShortcut));
            this.f3208q = typedArrayObtainStyledAttributes.getInt(R.styleable.MenuItem_alphabeticModifiers, 4096);
            this.f3209r = m3484a(typedArrayObtainStyledAttributes.getString(R.styleable.MenuItem_android_numericShortcut));
            this.f3210s = typedArrayObtainStyledAttributes.getInt(R.styleable.MenuItem_numericModifiers, 4096);
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.MenuItem_android_checkable)) {
                this.f3211t = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.f3211t = this.f3198g;
            }
            this.f3212u = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_checked, false);
            this.f3213v = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_visible, this.f3199h);
            this.f3214w = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_enabled, this.f3200i);
            this.f3215x = typedArrayObtainStyledAttributes.getInt(R.styleable.MenuItem_showAsAction, -1);
            this.f3187B = typedArrayObtainStyledAttributes.getString(R.styleable.MenuItem_android_onClick);
            this.f3216y = typedArrayObtainStyledAttributes.getResourceId(R.styleable.MenuItem_actionLayout, 0);
            this.f3217z = typedArrayObtainStyledAttributes.getString(R.styleable.MenuItem_actionViewClass);
            this.f3186A = typedArrayObtainStyledAttributes.getString(R.styleable.MenuItem_actionProviderClass);
            boolean z = this.f3186A != null;
            if (z && this.f3216y == 0 && this.f3217z == null) {
                this.f3192a = (ActionProvider) m3485a(this.f3186A, SupportMenuInflater.f3178b, SupportMenuInflater.this.f3180d);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f3192a = null;
            }
            this.f3188C = typedArrayObtainStyledAttributes.getText(R.styleable.MenuItem_contentDescription);
            this.f3189D = typedArrayObtainStyledAttributes.getText(R.styleable.MenuItem_tooltipText);
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.MenuItem_iconTintMode)) {
                this.f3191F = DrawableUtils.m4114a(typedArrayObtainStyledAttributes.getInt(R.styleable.MenuItem_iconTintMode, -1), this.f3191F);
            } else {
                this.f3191F = null;
            }
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.MenuItem_iconTint)) {
                this.f3190E = typedArrayObtainStyledAttributes.getColorStateList(R.styleable.MenuItem_iconTint);
            } else {
                this.f3190E = null;
            }
            typedArrayObtainStyledAttributes.recycle();
            this.f3201j = false;
        }

        /* JADX INFO: renamed from: a */
        private char m3484a(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        /* JADX INFO: renamed from: a */
        private void m3486a(MenuItem menuItem) {
            boolean z = true;
            menuItem.setChecked(this.f3212u).setVisible(this.f3213v).setEnabled(this.f3214w).setCheckable(this.f3211t >= 1).setTitleCondensed(this.f3205n).setIcon(this.f3206o);
            if (this.f3215x >= 0) {
                menuItem.setShowAsAction(this.f3215x);
            }
            if (this.f3187B != null) {
                if (SupportMenuInflater.this.f3181e.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new InflatedOnMenuItemClickListener(SupportMenuInflater.this.m3483a(), this.f3187B));
            }
            if (menuItem instanceof MenuItemImpl) {
            }
            if (this.f3211t >= 2) {
                if (menuItem instanceof MenuItemImpl) {
                    ((MenuItemImpl) menuItem).m3634a(true);
                } else if (menuItem instanceof MenuItemWrapperICS) {
                    ((MenuItemWrapperICS) menuItem).m3654a(true);
                }
            }
            if (this.f3217z != null) {
                menuItem.setActionView((View) m3485a(this.f3217z, SupportMenuInflater.f3177a, SupportMenuInflater.this.f3179c));
            } else {
                z = false;
            }
            if (this.f3216y > 0) {
                if (!z) {
                    menuItem.setActionView(this.f3216y);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            if (this.f3192a != null) {
                MenuItemCompat.m2515a(menuItem, this.f3192a);
            }
            MenuItemCompat.m2519a(menuItem, this.f3188C);
            MenuItemCompat.m2521b(menuItem, this.f3189D);
            MenuItemCompat.m2520b(menuItem, this.f3207p, this.f3208q);
            MenuItemCompat.m2516a(menuItem, this.f3209r, this.f3210s);
            if (this.f3191F != null) {
                MenuItemCompat.m2518a(menuItem, this.f3191F);
            }
            if (this.f3190E != null) {
                MenuItemCompat.m2517a(menuItem, this.f3190E);
            }
        }

        /* JADX INFO: renamed from: b */
        public void m3489b() {
            this.f3201j = true;
            m3486a(this.f3194c.add(this.f3195d, this.f3202k, this.f3203l, this.f3204m));
        }

        /* JADX INFO: renamed from: c */
        public SubMenu m3491c() {
            this.f3201j = true;
            SubMenu subMenuAddSubMenu = this.f3194c.addSubMenu(this.f3195d, this.f3202k, this.f3203l, this.f3204m);
            m3486a(subMenuAddSubMenu.getItem());
            return subMenuAddSubMenu;
        }

        /* JADX INFO: renamed from: d */
        public boolean m3492d() {
            return this.f3201j;
        }

        /* JADX INFO: renamed from: a */
        private <T> T m3485a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = SupportMenuInflater.this.f3181e.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }
    }
}
