package android.support.v7.app;

import android.app.UiModeManager;
import android.content.Context;
import android.support.v7.app.AppCompatDelegateImplV14;
import android.view.ActionMode;
import android.view.Window;

/* JADX INFO: loaded from: classes.dex */
class AppCompatDelegateImplV23 extends AppCompatDelegateImplV14 {

    /* JADX INFO: renamed from: t */
    private final UiModeManager f2956t;

    AppCompatDelegateImplV23(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
        this.f2956t = (UiModeManager) context.getSystemService("uimode");
    }

    @Override // android.support.v7.app.AppCompatDelegateImplV14, android.support.v7.app.AppCompatDelegateImplBase
    /* JADX INFO: renamed from: a */
    Window.Callback mo3266a(Window.Callback callback) {
        return new AppCompatWindowCallbackV23(callback);
    }

    @Override // android.support.v7.app.AppCompatDelegateImplV14
    /* JADX INFO: renamed from: d */
    int mo3286d(int i) {
        if (i == 0 && this.f2956t.getNightMode() == 0) {
            return -1;
        }
        return super.mo3286d(i);
    }

    class AppCompatWindowCallbackV23 extends AppCompatDelegateImplV14.AppCompatWindowCallbackV14 {
        AppCompatWindowCallbackV23(Window.Callback callback) {
            super(callback);
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (AppCompatDelegateImplV23.this.mo3276p()) {
                switch (i) {
                    case 0:
                        return m3287a(callback);
                }
            }
            return super.onWindowStartingActionMode(callback, i);
        }

        @Override // android.support.v7.app.AppCompatDelegateImplV14.AppCompatWindowCallbackV14, android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }
    }
}
