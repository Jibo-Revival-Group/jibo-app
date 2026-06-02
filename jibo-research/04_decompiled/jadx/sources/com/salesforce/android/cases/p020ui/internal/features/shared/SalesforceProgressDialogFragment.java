package com.salesforce.android.cases.p020ui.internal.features.shared;

import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.share.internal.ShareConstants;
import com.salesforce.android.cases.R;
import com.salesforce.android.service.common.p023ui.views.SalesforceTextView;

/* JADX INFO: loaded from: classes.dex */
public class SalesforceProgressDialogFragment extends AppCompatDialogFragment {
    /* JADX INFO: renamed from: a */
    public static SalesforceProgressDialogFragment m13013a(int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt(ShareConstants.WEB_DIALOG_PARAM_TITLE, i);
        bundle.putInt(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, i2);
        SalesforceProgressDialogFragment salesforceProgressDialogFragment = new SalesforceProgressDialogFragment();
        salesforceProgressDialogFragment.setArguments(bundle);
        return salesforceProgressDialogFragment;
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, R.style.Widget_ServiceCase_Dialog);
        setShowsDialog(true);
        setCancelable(false);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_salesforce_progress_dialog, viewGroup, false);
        Bundle arguments = getArguments();
        if (arguments != null) {
            ((SalesforceTextView) viewInflate.findViewById(R.id.progress_title)).setText(arguments.getInt(ShareConstants.WEB_DIALOG_PARAM_TITLE));
            ((SalesforceTextView) viewInflate.findViewById(R.id.progress_message)).setText(arguments.getInt(ShareConstants.WEB_DIALOG_PARAM_MESSAGE));
        }
        return viewInflate;
    }
}
