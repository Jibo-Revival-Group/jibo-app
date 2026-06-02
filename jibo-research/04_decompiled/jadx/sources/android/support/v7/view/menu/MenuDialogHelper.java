package android.support.v7.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.support.v7.app.AlertDialog;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuPresenter;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes.dex */
class MenuDialogHelper implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnKeyListener, MenuPresenter.Callback {

    /* JADX INFO: renamed from: a */
    ListMenuPresenter f3374a;

    /* JADX INFO: renamed from: b */
    private MenuBuilder f3375b;

    /* JADX INFO: renamed from: c */
    private AlertDialog f3376c;

    /* JADX INFO: renamed from: d */
    private MenuPresenter.Callback f3377d;

    public MenuDialogHelper(MenuBuilder menuBuilder) {
        this.f3375b = menuBuilder;
    }

    /* JADX INFO: renamed from: a */
    public void m3627a(IBinder iBinder) {
        MenuBuilder menuBuilder = this.f3375b;
        AlertDialog.Builder builder = new AlertDialog.Builder(menuBuilder.m3611e());
        this.f3374a = new ListMenuPresenter(builder.m3219a(), R.layout.abc_list_menu_item_layout);
        this.f3374a.mo350a(this);
        this.f3375b.m3589a(this.f3374a);
        builder.m3227a(this.f3374a.m3562d(), this);
        View viewM3622o = menuBuilder.m3622o();
        if (viewM3622o != null) {
            builder.m3225a(viewM3622o);
        } else {
            builder.m3224a(menuBuilder.m3621n()).m3228a(menuBuilder.m3620m());
        }
        builder.m3223a((DialogInterface.OnKeyListener) this);
        this.f3376c = builder.m3236b();
        this.f3376c.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f3376c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f3376c.show();
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f3376c.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f3376c.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f3375b.m3600b(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f3375b.performShortcut(i, keyEvent, 0);
    }

    /* JADX INFO: renamed from: a */
    public void m3626a() {
        if (this.f3376c != null) {
            this.f3376c.dismiss();
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f3374a.mo349a(this.f3375b, true);
    }

    @Override // android.support.v7.view.menu.MenuPresenter.Callback
    /* JADX INFO: renamed from: a */
    public void mo3327a(MenuBuilder menuBuilder, boolean z) {
        if (z || menuBuilder == this.f3375b) {
            m3626a();
        }
        if (this.f3377d != null) {
            this.f3377d.mo3327a(menuBuilder, z);
        }
    }

    @Override // android.support.v7.view.menu.MenuPresenter.Callback
    /* JADX INFO: renamed from: a */
    public boolean mo3328a(MenuBuilder menuBuilder) {
        if (this.f3377d != null) {
            return this.f3377d.mo3328a(menuBuilder);
        }
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f3375b.m3594a((MenuItemImpl) this.f3374a.m3562d().getItem(i), 0);
    }
}
