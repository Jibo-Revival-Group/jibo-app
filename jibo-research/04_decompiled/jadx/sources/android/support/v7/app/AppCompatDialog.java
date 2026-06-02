package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.appcompat.R;
import android.support.v7.view.ActionMode;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatDialog extends Dialog implements AppCompatCallback {

    /* JADX INFO: renamed from: a */
    private AppCompatDelegate f3019a;

    public AppCompatDialog(Context context, int i) {
        super(context, m3342a(context, i));
        m3343b().mo3247a((Bundle) null);
        m3343b().mo3265j();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        m3343b().mo3264i();
        super.onCreate(bundle);
        m3343b().mo3247a(bundle);
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        m3343b().mo3253b(i);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        m3343b().mo3249a(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m3343b().mo3250a(view, layoutParams);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i) {
        return (T) m3343b().mo3245a(i);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        m3343b().mo3251a(charSequence);
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        super.setTitle(i);
        m3343b().mo3251a(getContext().getString(i));
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m3343b().mo3255b(view, layoutParams);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        m3343b().mo3259d();
    }

    /* JADX INFO: renamed from: b */
    public boolean m3344b(int i) {
        return m3343b().mo3258c(i);
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        m3343b().mo3261f();
    }

    /* JADX INFO: renamed from: b */
    public AppCompatDelegate m3343b() {
        if (this.f3019a == null) {
            this.f3019a = AppCompatDelegate.m3239a(this, this);
        }
        return this.f3019a;
    }

    /* JADX INFO: renamed from: a */
    private static int m3342a(Context context, int i) {
        if (i == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue, true);
            return typedValue.resourceId;
        }
        return i;
    }

    @Override // android.support.v7.app.AppCompatCallback
    public void onSupportActionModeStarted(ActionMode actionMode) {
    }

    @Override // android.support.v7.app.AppCompatCallback
    public void onSupportActionModeFinished(ActionMode actionMode) {
    }

    @Override // android.support.v7.app.AppCompatCallback
    public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback callback) {
        return null;
    }
}
