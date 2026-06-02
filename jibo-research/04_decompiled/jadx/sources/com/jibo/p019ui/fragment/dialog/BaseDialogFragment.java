package com.jibo.p019ui.fragment.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import com.crashlytics.android.Crashlytics;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.utils.ErrorHelper;
import com.jibo.utils.UIUtils;

/* JADX INFO: loaded from: classes.dex */
public class BaseDialogFragment extends DialogFragment {

    /* JADX INFO: renamed from: a */
    public static final String f10163a = BaseDialogFragment.class.getSimpleName();

    /* JADX INFO: renamed from: b */
    protected View f10164b;

    /* JADX INFO: renamed from: c */
    protected Loop f10165c;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a */
    public void m10491a(final Exception exc, String str, final boolean z) {
        Crashlytics.m5597a((Throwable) exc);
        getActivity().runOnUiThread(new Runnable() { // from class: com.jibo.ui.fragment.dialog.BaseDialogFragment.1
            @Override // java.lang.Runnable
            public void run() {
                if (ErrorHelper.m11383a(null, BaseDialogFragment.this, exc) || !z || BaseDialogFragment.this.f10164b == null) {
                    return;
                }
                UIUtils.m11476a(BaseDialogFragment.this.f10164b, exc);
            }
        });
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            mo10490a(bundle);
        } else if (getArguments() != null) {
            mo10490a(getArguments());
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (getTargetFragment() != null && (getTargetFragment() instanceof DialogInterface.OnDismissListener)) {
            ((DialogInterface.OnDismissListener) getTargetFragment()).onDismiss(dialogInterface);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        getDialog().getWindow().setLayout(getResources().getDimensionPixelSize(m10489a()), -2);
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f10165c != null) {
            bundle.putParcelable(Loop.class.getSimpleName(), this.f10165c);
        }
    }

    /* JADX INFO: renamed from: a */
    public void mo10490a(Bundle bundle) {
        if (bundle.containsKey(Loop.class.getSimpleName())) {
            this.f10165c = (Loop) bundle.getParcelable(Loop.class.getSimpleName());
        }
    }

    /* JADX INFO: renamed from: a */
    protected int m10489a() {
        return R.dimen.dialog_width;
    }
}
