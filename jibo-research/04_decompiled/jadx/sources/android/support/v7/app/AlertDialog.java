package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AlertController;
import android.support.v7.appcompat.R;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;

/* JADX INFO: loaded from: classes.dex */
public class AlertDialog extends AppCompatDialog implements DialogInterface {

    /* JADX INFO: renamed from: a */
    final AlertController f2918a;

    protected AlertDialog(Context context, int i) {
        super(context, m3217a(context, i));
        this.f2918a = new AlertController(getContext(), this, getWindow());
    }

    /* JADX INFO: renamed from: a */
    static int m3217a(Context context, int i) {
        if (((i >>> 24) & 255) < 1) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
            return typedValue.resourceId;
        }
        return i;
    }

    /* JADX INFO: renamed from: a */
    public Button m3218a(int i) {
        return this.f2918a.m3212d(i);
    }

    @Override // android.support.v7.app.AppCompatDialog, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f2918a.m3204a(charSequence);
    }

    @Override // android.support.v7.app.AppCompatDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2918a.m3199a();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f2918a.m3205a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f2918a.m3209b(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        private final AlertController.AlertParams f2919a;

        /* JADX INFO: renamed from: b */
        private final int f2920b;

        public Builder(Context context) {
            this(context, AlertDialog.m3217a(context, 0));
        }

        public Builder(Context context, int i) {
            this.f2919a = new AlertController.AlertParams(new ContextThemeWrapper(context, AlertDialog.m3217a(context, i)));
            this.f2920b = i;
        }

        /* JADX INFO: renamed from: a */
        public Context m3219a() {
            return this.f2919a.f2877a;
        }

        /* JADX INFO: renamed from: a */
        public Builder m3220a(int i) {
            this.f2919a.f2882f = this.f2919a.f2877a.getText(i);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m3228a(CharSequence charSequence) {
            this.f2919a.f2882f = charSequence;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m3225a(View view) {
            this.f2919a.f2883g = view;
            return this;
        }

        /* JADX INFO: renamed from: b */
        public Builder m3231b(int i) {
            this.f2919a.f2884h = this.f2919a.f2877a.getText(i);
            return this;
        }

        /* JADX INFO: renamed from: b */
        public Builder m3234b(CharSequence charSequence) {
            this.f2919a.f2884h = charSequence;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m3224a(Drawable drawable) {
            this.f2919a.f2880d = drawable;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m3221a(int i, DialogInterface.OnClickListener onClickListener) {
            this.f2919a.f2885i = this.f2919a.f2877a.getText(i);
            this.f2919a.f2887k = onClickListener;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m3229a(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f2919a.f2885i = charSequence;
            this.f2919a.f2887k = onClickListener;
            return this;
        }

        /* JADX INFO: renamed from: b */
        public Builder m3232b(int i, DialogInterface.OnClickListener onClickListener) {
            this.f2919a.f2888l = this.f2919a.f2877a.getText(i);
            this.f2919a.f2890n = onClickListener;
            return this;
        }

        /* JADX INFO: renamed from: b */
        public Builder m3235b(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f2919a.f2888l = charSequence;
            this.f2919a.f2890n = onClickListener;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m3230a(boolean z) {
            this.f2919a.f2894r = z;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m3222a(DialogInterface.OnDismissListener onDismissListener) {
            this.f2919a.f2896t = onDismissListener;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m3223a(DialogInterface.OnKeyListener onKeyListener) {
            this.f2919a.f2897u = onKeyListener;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m3227a(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            this.f2919a.f2899w = listAdapter;
            this.f2919a.f2900x = onClickListener;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m3226a(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
            this.f2919a.f2899w = listAdapter;
            this.f2919a.f2900x = onClickListener;
            this.f2919a.f2869I = i;
            this.f2919a.f2868H = true;
            return this;
        }

        /* JADX INFO: renamed from: b */
        public Builder m3233b(View view) {
            this.f2919a.f2902z = view;
            this.f2919a.f2901y = 0;
            this.f2919a.f2865E = false;
            return this;
        }

        /* JADX INFO: renamed from: b */
        public AlertDialog m3236b() {
            AlertDialog alertDialog = new AlertDialog(this.f2919a.f2877a, this.f2920b);
            this.f2919a.m3214a(alertDialog.f2918a);
            alertDialog.setCancelable(this.f2919a.f2894r);
            if (this.f2919a.f2894r) {
                alertDialog.setCanceledOnTouchOutside(true);
            }
            alertDialog.setOnCancelListener(this.f2919a.f2895s);
            alertDialog.setOnDismissListener(this.f2919a.f2896t);
            if (this.f2919a.f2897u != null) {
                alertDialog.setOnKeyListener(this.f2919a.f2897u);
            }
            return alertDialog;
        }

        /* JADX INFO: renamed from: c */
        public AlertDialog m3237c() {
            AlertDialog alertDialogM3236b = m3236b();
            alertDialogM3236b.show();
            return alertDialogM3236b;
        }
    }
}
