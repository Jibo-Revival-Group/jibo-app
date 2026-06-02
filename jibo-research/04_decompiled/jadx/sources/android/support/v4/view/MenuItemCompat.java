package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.support.v4.internal.view.SupportMenuItem;
import android.util.Log;
import android.view.MenuItem;

/* JADX INFO: loaded from: classes.dex */
public final class MenuItemCompat {

    /* JADX INFO: renamed from: a */
    static final MenuVersionImpl f2289a;

    interface MenuVersionImpl {
        /* JADX INFO: renamed from: a */
        void mo2522a(MenuItem menuItem, char c, int i);

        /* JADX INFO: renamed from: a */
        void mo2523a(MenuItem menuItem, ColorStateList colorStateList);

        /* JADX INFO: renamed from: a */
        void mo2524a(MenuItem menuItem, PorterDuff.Mode mode);

        /* JADX INFO: renamed from: a */
        void mo2525a(MenuItem menuItem, CharSequence charSequence);

        /* JADX INFO: renamed from: b */
        void mo2526b(MenuItem menuItem, char c, int i);

        /* JADX INFO: renamed from: b */
        void mo2527b(MenuItem menuItem, CharSequence charSequence);
    }

    static class MenuItemCompatBaseImpl implements MenuVersionImpl {
        MenuItemCompatBaseImpl() {
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        /* JADX INFO: renamed from: a */
        public void mo2525a(MenuItem menuItem, CharSequence charSequence) {
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        /* JADX INFO: renamed from: b */
        public void mo2527b(MenuItem menuItem, CharSequence charSequence) {
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        /* JADX INFO: renamed from: a */
        public void mo2522a(MenuItem menuItem, char c, int i) {
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        /* JADX INFO: renamed from: b */
        public void mo2526b(MenuItem menuItem, char c, int i) {
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        /* JADX INFO: renamed from: a */
        public void mo2523a(MenuItem menuItem, ColorStateList colorStateList) {
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuVersionImpl
        /* JADX INFO: renamed from: a */
        public void mo2524a(MenuItem menuItem, PorterDuff.Mode mode) {
        }
    }

    static class MenuItemCompatApi26Impl extends MenuItemCompatBaseImpl {
        MenuItemCompatApi26Impl() {
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuItemCompatBaseImpl, android.support.v4.view.MenuItemCompat.MenuVersionImpl
        /* JADX INFO: renamed from: a */
        public void mo2525a(MenuItem menuItem, CharSequence charSequence) {
            menuItem.setContentDescription(charSequence);
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuItemCompatBaseImpl, android.support.v4.view.MenuItemCompat.MenuVersionImpl
        /* JADX INFO: renamed from: b */
        public void mo2527b(MenuItem menuItem, CharSequence charSequence) {
            menuItem.setTooltipText(charSequence);
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuItemCompatBaseImpl, android.support.v4.view.MenuItemCompat.MenuVersionImpl
        /* JADX INFO: renamed from: a */
        public void mo2522a(MenuItem menuItem, char c, int i) {
            menuItem.setAlphabeticShortcut(c, i);
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuItemCompatBaseImpl, android.support.v4.view.MenuItemCompat.MenuVersionImpl
        /* JADX INFO: renamed from: b */
        public void mo2526b(MenuItem menuItem, char c, int i) {
            menuItem.setNumericShortcut(c, i);
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuItemCompatBaseImpl, android.support.v4.view.MenuItemCompat.MenuVersionImpl
        /* JADX INFO: renamed from: a */
        public void mo2523a(MenuItem menuItem, ColorStateList colorStateList) {
            menuItem.setIconTintList(colorStateList);
        }

        @Override // android.support.v4.view.MenuItemCompat.MenuItemCompatBaseImpl, android.support.v4.view.MenuItemCompat.MenuVersionImpl
        /* JADX INFO: renamed from: a */
        public void mo2524a(MenuItem menuItem, PorterDuff.Mode mode) {
            menuItem.setIconTintMode(mode);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 26) {
            f2289a = new MenuItemCompatApi26Impl();
        } else {
            f2289a = new MenuItemCompatBaseImpl();
        }
    }

    /* JADX INFO: renamed from: a */
    public static MenuItem m2515a(MenuItem menuItem, ActionProvider actionProvider) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).mo2020a(actionProvider);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    /* JADX INFO: renamed from: a */
    public static void m2519a(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).mo2021a(charSequence);
        } else {
            f2289a.mo2525a(menuItem, charSequence);
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m2521b(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).mo2023b(charSequence);
        } else {
            f2289a.mo2527b(menuItem, charSequence);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2516a(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setNumericShortcut(c, i);
        } else {
            f2289a.mo2526b(menuItem, c, i);
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m2520b(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setAlphabeticShortcut(c, i);
        } else {
            f2289a.mo2522a(menuItem, c, i);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2517a(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setIconTintList(colorStateList);
        } else {
            f2289a.mo2523a(menuItem, colorStateList);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2518a(MenuItem menuItem, PorterDuff.Mode mode) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setIconTintMode(mode);
        } else {
            f2289a.mo2524a(menuItem, mode);
        }
    }
}
