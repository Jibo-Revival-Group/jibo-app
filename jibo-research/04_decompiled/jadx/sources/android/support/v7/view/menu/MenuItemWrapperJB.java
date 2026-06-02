package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider;
import android.support.v7.view.menu.MenuItemWrapperICS;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class MenuItemWrapperJB extends MenuItemWrapperICS {
    MenuItemWrapperJB(Context context, SupportMenuItem supportMenuItem) {
        super(context, supportMenuItem);
    }

    @Override // android.support.v7.view.menu.MenuItemWrapperICS
    /* JADX INFO: renamed from: a */
    MenuItemWrapperICS.ActionProviderWrapper mo3653a(ActionProvider actionProvider) {
        return new ActionProviderWrapperJB(this.f3272a, actionProvider);
    }

    class ActionProviderWrapperJB extends MenuItemWrapperICS.ActionProviderWrapper implements ActionProvider.VisibilityListener {

        /* JADX INFO: renamed from: c */
        ActionProvider.VisibilityListener f3420c;

        public ActionProviderWrapperJB(Context context, android.view.ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // android.support.v4.view.ActionProvider
        /* JADX INFO: renamed from: a */
        public View mo2488a(MenuItem menuItem) {
            return this.f3415a.onCreateActionView(menuItem);
        }

        @Override // android.support.v4.view.ActionProvider
        /* JADX INFO: renamed from: b */
        public boolean mo2493b() {
            return this.f3415a.overridesItemVisibility();
        }

        @Override // android.support.v4.view.ActionProvider
        /* JADX INFO: renamed from: c */
        public boolean mo2494c() {
            return this.f3415a.isVisible();
        }

        @Override // android.support.v4.view.ActionProvider
        /* JADX INFO: renamed from: a */
        public void mo2490a(ActionProvider.VisibilityListener visibilityListener) {
            this.f3420c = visibilityListener;
            android.view.ActionProvider actionProvider = this.f3415a;
            if (visibilityListener == null) {
                this = null;
            }
            actionProvider.setVisibilityListener(this);
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z) {
            if (this.f3420c != null) {
                this.f3420c.mo2499a(z);
            }
        }
    }
}
