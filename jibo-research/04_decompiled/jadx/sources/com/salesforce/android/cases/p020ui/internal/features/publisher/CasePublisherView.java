package com.salesforce.android.cases.p020ui.internal.features.publisher;

import android.content.Context;
import android.content.res.Resources;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.salesforce.android.cases.R;
import com.salesforce.android.cases.core.model.CaseField;
import com.salesforce.android.cases.core.model.CaseFieldType;
import com.salesforce.android.cases.p020ui.internal.features.publisher.CasePublisherContract;
import com.salesforce.android.cases.p020ui.internal.features.publisher.SalesforceConfirmationDialogFragment;
import com.salesforce.android.cases.p020ui.internal.features.publisher.viewmodel.CaseFieldViewModel;
import com.salesforce.android.cases.p020ui.internal.features.publisher.viewmodel.CasePickListViewModel;
import com.salesforce.android.cases.p020ui.internal.features.publisher.viewmodel.CaseTextInputViewModel;
import com.salesforce.android.cases.p020ui.internal.features.shared.SalesforceProgressDialogFragment;
import com.salesforce.android.cases.p020ui.internal.utils.DrawableUtils;
import com.salesforce.android.cases.p020ui.internal.utils.ViewUtils;
import com.salesforce.android.service.common.p023ui.views.SalesforcePickListView;
import com.salesforce.android.service.common.p023ui.views.SalesforceProgressSpinner;
import com.salesforce.android.service.common.p023ui.views.SalesforceTextInputLayout;
import com.salesforce.android.service.common.p023ui.views.SalesforceTitleTextToolbar;

/* JADX INFO: loaded from: classes.dex */
public class CasePublisherView extends CoordinatorLayout implements Toolbar.OnMenuItemClickListener, CasePublisherContract.View, SalesforceConfirmationDialogFragment.SalesforceConfirmationDialogListener {

    /* JADX INFO: renamed from: f */
    SalesforceTitleTextToolbar f12795f;

    /* JADX INFO: renamed from: g */
    SalesforceProgressSpinner f12796g;

    /* JADX INFO: renamed from: h */
    ScrollView f12797h;

    /* JADX INFO: renamed from: i */
    LinearLayout f12798i;

    /* JADX INFO: renamed from: j */
    ViewGroup f12799j;

    /* JADX INFO: renamed from: k */
    ViewGroup f12800k;

    /* JADX INFO: renamed from: l */
    ViewGroup f12801l;

    /* JADX INFO: renamed from: m */
    MenuItem f12802m;

    /* JADX INFO: renamed from: n */
    Snackbar f12803n;

    /* JADX INFO: renamed from: o */
    private int f12804o;

    /* JADX INFO: renamed from: p */
    private CasePublisherContract.Presenter f12805p;

    /* JADX INFO: renamed from: q */
    private FragmentManager f12806q;

    public CasePublisherView(Context context) {
        this(context, null);
    }

    public CasePublisherView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CasePublisherView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12982a(context);
    }

    @Override // com.salesforce.android.cases.ui.internal.features.publisher.CasePublisherContract.View
    /* JADX INFO: renamed from: p_ */
    public void mo12952p_() {
        ViewUtils.m13062b(this.f12796g);
    }

    @Override // com.salesforce.android.cases.ui.internal.features.publisher.CasePublisherContract.View
    /* JADX INFO: renamed from: q_ */
    public void mo12953q_() {
        ViewUtils.m13063c(this.f12796g);
    }

    @Override // com.salesforce.android.cases.ui.internal.features.publisher.CasePublisherContract.View
    /* JADX INFO: renamed from: c */
    public void mo12941c() {
        ViewUtils.m13062b(this.f12797h);
    }

    @Override // com.salesforce.android.cases.ui.internal.features.publisher.CasePublisherContract.View
    /* JADX INFO: renamed from: r_ */
    public void mo12954r_() {
        ViewUtils.m13063c(this.f12797h);
    }

    @Override // com.salesforce.android.cases.ui.internal.features.publisher.CasePublisherContract.View
    /* JADX INFO: renamed from: e */
    public void mo12942e() {
        ViewUtils.m13062b(this.f12799j);
    }

    @Override // com.salesforce.android.cases.ui.internal.features.publisher.CasePublisherContract.View
    /* JADX INFO: renamed from: f */
    public void mo12943f() {
        ViewUtils.m13062b(this.f12800k);
    }

    @Override // com.salesforce.android.cases.ui.internal.features.publisher.CasePublisherContract.View
    /* JADX INFO: renamed from: g */
    public void mo12944g() {
        ViewUtils.m13062b(this.f12801l);
    }

    @Override // com.salesforce.android.cases.ui.internal.features.publisher.CasePublisherContract.View
    /* JADX INFO: renamed from: h */
    public void mo12945h() {
        this.f12803n = Snackbar.m803a(this, R.string.cases_case_create_error_snackbar_text, -2).m809e(ContextCompat.m1840c(getContext(), R.color.cases_error_snackbar_action_text_color)).m806a(R.string.cases_snackbar_retry_action_text, new View.OnClickListener() { // from class: com.salesforce.android.cases.ui.internal.features.publisher.CasePublisherView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CasePublisherView.this.f12805p != null) {
                    CasePublisherView.this.f12805p.mo12935c();
                }
            }
        });
        ViewUtils.m13059a(this.f12803n, ContextCompat.m1840c(getContext(), R.color.cases_error_snackbar_background_color), ContextCompat.m1840c(getContext(), R.color.cases_error_snackbar_text_color));
        this.f12803n.m490c();
    }

    @Override // com.salesforce.android.cases.ui.internal.features.publisher.CasePublisherContract.View
    /* JADX INFO: renamed from: i */
    public void mo12946i() {
        if (this.f12803n != null) {
            this.f12803n.m492d();
        }
    }

    @Override // com.salesforce.android.cases.ui.internal.features.publisher.CasePublisherContract.View
    /* JADX INFO: renamed from: j */
    public void mo12947j() {
        if (getCreatingCaseDialogFragment() == null) {
            SalesforceProgressDialogFragment.m13013a(R.string.cases_creating_case_progress_dialog_title_text, R.string.cases_creating_case_progress_dialog_message_text).show(this.f12806q, "createCaseDialogFragment");
        }
    }

    @Override // com.salesforce.android.cases.ui.internal.features.publisher.CasePublisherContract.View
    /* JADX INFO: renamed from: k */
    public void mo12948k() {
        SalesforceProgressDialogFragment creatingCaseDialogFragment = getCreatingCaseDialogFragment();
        if (creatingCaseDialogFragment != null) {
            creatingCaseDialogFragment.dismiss();
        }
    }

    @Override // com.salesforce.android.cases.ui.internal.features.publisher.CasePublisherContract.View
    /* JADX INFO: renamed from: l */
    public void mo12949l() {
        this.f12802m.setVisible(false);
    }

    @Override // com.salesforce.android.cases.ui.internal.features.publisher.CasePublisherContract.View
    /* JADX INFO: renamed from: m */
    public void mo12950m() {
        this.f12802m.setVisible(true);
    }

    @Override // com.salesforce.android.cases.ui.internal.features.publisher.CasePublisherContract.View
    /* JADX INFO: renamed from: a */
    public CaseTextInputViewModel mo12939a(CaseField caseField) {
        CaseFieldType caseFieldTypeMo12453f = caseField.mo12453f();
        if (caseFieldTypeMo12453f != CaseFieldType.TEXT && caseFieldTypeMo12453f != CaseFieldType.EMAIL && caseFieldTypeMo12453f != CaseFieldType.TEXT_AREA) {
            throw new IllegalArgumentException("CaseField must be of type CaseFieldType.TEXT, CaseFieldType.EMAIL or CaseFieldType.TEXT_AREA.");
        }
        CaseTextInputViewModel caseTextInputViewModel = new CaseTextInputViewModel((SalesforceTextInputLayout) LayoutInflater.from(getContext()).inflate(R.layout.case_text_input_view, (ViewGroup) null, false), caseField);
        m12983a(caseTextInputViewModel);
        return caseTextInputViewModel;
    }

    @Override // com.salesforce.android.cases.ui.internal.features.publisher.CasePublisherContract.View
    /* JADX INFO: renamed from: b */
    public CasePickListViewModel mo12940b(CaseField caseField) {
        if (caseField.mo12453f() != CaseFieldType.PICK_LIST) {
            throw new IllegalArgumentException("CaseField must be of type CaseFieldType.PICK_LIST.");
        }
        CasePickListViewModel casePickListViewModel = new CasePickListViewModel((SalesforcePickListView) LayoutInflater.from(getContext()).inflate(R.layout.case_pick_list_view, (ViewGroup) null, false), caseField);
        m12983a(casePickListViewModel);
        return casePickListViewModel;
    }

    @Override // com.salesforce.android.cases.ui.internal.features.publisher.CasePublisherContract.View
    public void setPresenter(CasePublisherContract.Presenter presenter) {
        this.f12805p = presenter;
    }

    @Override // com.salesforce.android.cases.ui.internal.features.publisher.CasePublisherContract.View
    public void setFragmentManager(FragmentManager fragmentManager) {
        this.f12806q = fragmentManager;
        m12984q();
    }

    @Override // com.salesforce.android.cases.ui.internal.features.publisher.CasePublisherContract.View
    /* JADX INFO: renamed from: n */
    public void mo12951n() {
        if (getDiscardCaseDialogFragment() == null) {
            SalesforceConfirmationDialogFragment salesforceConfirmationDialogFragmentM12988a = SalesforceConfirmationDialogFragment.m12988a(R.string.cases_discard_case_confirmation_dialog_title_text, R.string.case_discard_case_confirmation_dialog_message_text);
            salesforceConfirmationDialogFragmentM12988a.m12989a(this);
            salesforceConfirmationDialogFragmentM12988a.show(this.f12806q, "discardCaseDialogFragment");
        }
    }

    @Override // com.salesforce.android.cases.ui.internal.features.publisher.SalesforceConfirmationDialogFragment.SalesforceConfirmationDialogListener
    /* JADX INFO: renamed from: o */
    public void mo12985o() {
        this.f12805p.mo12938h();
    }

    @Override // android.support.v7.widget.Toolbar.OnMenuItemClickListener
    /* JADX INFO: renamed from: a */
    public boolean mo3371a(MenuItem menuItem) {
        if (R.id.action_send != menuItem.getItemId()) {
            return false;
        }
        if (this.f12805p != null) {
            this.f12805p.mo12932a();
        }
        return true;
    }

    /* JADX INFO: renamed from: p */
    void m12986p() {
        if (this.f12805p != null) {
            this.f12805p.mo12934b();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m12983a(CaseFieldViewModel caseFieldViewModel) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.f12804o;
        this.f12798i.addView(caseFieldViewModel.mo12990a(), layoutParams);
    }

    private SalesforceProgressDialogFragment getCreatingCaseDialogFragment() {
        return (SalesforceProgressDialogFragment) this.f12806q.mo1470a("createCaseDialogFragment");
    }

    private SalesforceConfirmationDialogFragment getDiscardCaseDialogFragment() {
        return (SalesforceConfirmationDialogFragment) this.f12806q.mo1470a("discardCaseDialogFragment");
    }

    /* JADX INFO: renamed from: a */
    private void m12982a(Context context) {
        this.f12804o = context.getResources().getDimensionPixelSize(R.dimen.cases_case_publisher_field_spacing);
        LayoutInflater.from(getContext()).inflate(R.layout.case_publisher_view, (ViewGroup) this, true);
        this.f12795f = (SalesforceTitleTextToolbar) findViewById(R.id.toolbar);
        this.f12796g = (SalesforceProgressSpinner) findViewById(R.id.progress_spinner);
        this.f12797h = (ScrollView) findViewById(R.id.case_layout_frame);
        this.f12798i = (LinearLayout) findViewById(R.id.case_layout_container);
        this.f12799j = (ViewGroup) findViewById(R.id.case_generic_error_view);
        this.f12800k = (ViewGroup) findViewById(R.id.case_network_error_view);
        this.f12801l = (ViewGroup) findViewById(R.id.case_created_view);
        if (this.f12795f != null) {
            this.f12795f.setNavigationContentDescription(R.string.cases_cancel_button_text);
            this.f12795f.setNavigationIcon(VectorDrawableCompat.m987a(getResources(), R.drawable.cases_ic_clear, (Resources.Theme) null));
            this.f12795f.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.salesforce.android.cases.ui.internal.features.publisher.CasePublisherView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CasePublisherView.this.m12986p();
                }
            });
            this.f12795f.inflateMenu(R.menu.case_publisher_menu);
            this.f12795f.setOnMenuItemClickListener(this);
            DrawableUtils.m13046a(this.f12795f.getMenu(), ContextCompat.m1840c(getContext(), R.color.salesforce_contrast_primary), R.id.action_send);
            this.f12802m = this.f12795f.getMenu().findItem(R.id.action_send);
        }
    }

    /* JADX INFO: renamed from: q */
    private void m12984q() {
        SalesforceConfirmationDialogFragment discardCaseDialogFragment = getDiscardCaseDialogFragment();
        if (discardCaseDialogFragment != null) {
            discardCaseDialogFragment.m12989a(this);
        }
    }
}
