package com.salesforce.android.cases.p020ui.internal.features.publisher;

import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.share.internal.ShareConstants;
import com.salesforce.android.cases.R;
import com.salesforce.android.service.common.p023ui.views.SalesforceTextView;

/* JADX INFO: loaded from: classes.dex */
public class SalesforceConfirmationDialogFragment extends AppCompatDialogFragment {

    /* JADX INFO: renamed from: a */
    private SalesforceConfirmationDialogListener f12809a;

    public interface SalesforceConfirmationDialogListener {
        /* JADX INFO: renamed from: o */
        void mo12985o();
    }

    /* JADX INFO: renamed from: a */
    public static SalesforceConfirmationDialogFragment m12988a(int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt(ShareConstants.WEB_DIALOG_PARAM_TITLE, i);
        bundle.putInt(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, i2);
        SalesforceConfirmationDialogFragment salesforceConfirmationDialogFragment = new SalesforceConfirmationDialogFragment();
        salesforceConfirmationDialogFragment.setArguments(bundle);
        return salesforceConfirmationDialogFragment;
    }

    /* JADX INFO: renamed from: a */
    public void m12989a(SalesforceConfirmationDialogListener salesforceConfirmationDialogListener) {
        this.f12809a = salesforceConfirmationDialogListener;
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
        View viewInflate = layoutInflater.inflate(R.layout.fragment_salesforce_confirmation_dialog, viewGroup, false);
        Bundle arguments = getArguments();
        if (arguments != null) {
            ((SalesforceTextView) viewInflate.findViewById(R.id.progress_title)).setText(arguments.getInt(ShareConstants.WEB_DIALOG_PARAM_TITLE));
            ((SalesforceTextView) viewInflate.findViewById(R.id.progress_message)).setText(arguments.getInt(ShareConstants.WEB_DIALOG_PARAM_MESSAGE));
        }
        viewInflate.findViewById(R.id.continue_button).setOnClickListener(new View.OnClickListener() { // from class: com.salesforce.android.cases.ui.internal.features.publisher.SalesforceConfirmationDialogFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SalesforceConfirmationDialogFragment.this.f12809a != null) {
                    SalesforceConfirmationDialogFragment.this.f12809a.mo12985o();
                }
            }
        });
        viewInflate.findViewById(R.id.cancel_button).setOnClickListener(new View.OnClickListener() { // from class: com.salesforce.android.cases.ui.internal.features.publisher.SalesforceConfirmationDialogFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SalesforceConfirmationDialogFragment.this.getDialog().dismiss();
            }
        });
        return viewInflate;
    }
}
