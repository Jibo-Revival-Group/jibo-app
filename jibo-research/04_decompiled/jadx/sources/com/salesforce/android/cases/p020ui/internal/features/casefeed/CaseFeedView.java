package com.salesforce.android.cases.p020ui.internal.features.casefeed;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.salesforce.android.cases.R;
import com.salesforce.android.cases.core.internal.util.StringUtils;
import com.salesforce.android.cases.p020ui.internal.features.casefeed.CaseFeedContract;
import com.salesforce.android.cases.p020ui.internal.features.casefeed.adapter.MessageViewFactory;
import com.salesforce.android.cases.p020ui.internal.utils.ViewUtils;
import com.salesforce.android.service.common.p023ui.internal.android.LayoutInflaterFactory;
import com.salesforce.android.service.common.p023ui.internal.messaging.MessageFeedAdapter;
import com.salesforce.android.service.common.p023ui.internal.text.SalesforceTextWatcher;
import com.salesforce.android.service.common.p023ui.views.SalesforceProgressSpinner;
import com.salesforce.android.service.common.p023ui.views.SalesforceTitleTextToolbar;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CaseFeedView extends CoordinatorLayout implements CaseFeedContract.View, SalesforceTextWatcher.OnAfterTextChangedListener {

    /* JADX INFO: renamed from: f */
    CaseFeedContract.Presenter f12652f;

    /* JADX INFO: renamed from: g */
    SalesforceProgressSpinner f12653g;

    /* JADX INFO: renamed from: h */
    View f12654h;

    /* JADX INFO: renamed from: i */
    ViewGroup f12655i;

    /* JADX INFO: renamed from: j */
    ViewGroup f12656j;

    /* JADX INFO: renamed from: k */
    SalesforceTitleTextToolbar f12657k;

    /* JADX INFO: renamed from: l */
    SwipeRefreshLayout f12658l;

    /* JADX INFO: renamed from: m */
    EditText f12659m;

    /* JADX INFO: renamed from: n */
    View f12660n;

    /* JADX INFO: renamed from: o */
    MessageFeedAdapter f12661o;

    /* JADX INFO: renamed from: p */
    RecyclerView f12662p;

    /* JADX INFO: renamed from: q */
    SalesforceTextWatcher f12663q;

    public CaseFeedView(Context context) {
        this(context, null);
    }

    public CaseFeedView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CaseFeedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12802a(context);
    }

    @Override // com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedContract.View
    /* JADX INFO: renamed from: h_ */
    public void mo12760h_() {
        ViewUtils.m13062b(this.f12653g);
    }

    @Override // com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedContract.View
    /* JADX INFO: renamed from: i_ */
    public void mo12762i_() {
        ViewUtils.m13063c(this.f12653g);
    }

    @Override // com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedContract.View
    /* JADX INFO: renamed from: j_ */
    public void mo12764j_() {
        ViewUtils.m13062b(this.f12654h);
    }

    @Override // com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedContract.View
    /* JADX INFO: renamed from: k_ */
    public void mo12766k_() {
        ViewUtils.m13063c(this.f12654h);
    }

    @Override // com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedContract.View
    /* JADX INFO: renamed from: e */
    public void mo12756e() {
        ViewUtils.m13063c(this.f12655i);
    }

    @Override // com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedContract.View
    /* JADX INFO: renamed from: f */
    public void mo12757f() {
        ViewUtils.m13063c(this.f12656j);
    }

    @Override // com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedContract.View
    /* JADX INFO: renamed from: g */
    public void mo12758g() {
        ViewUtils.m13062b(this.f12655i);
    }

    @Override // com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedContract.View
    /* JADX INFO: renamed from: h */
    public void mo12759h() {
        ViewUtils.m13062b(this.f12656j);
    }

    @Override // com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedContract.View
    public void setPresenter(CaseFeedContract.Presenter presenter) {
        this.f12652f = presenter;
    }

    @Override // com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedContract.View
    public void setCaseId(String str) {
        if (this.f12652f != null && str != null) {
            this.f12652f.mo12787a(str);
            return;
        }
        throw new IllegalStateException("CaseFeedContract.Presenter and caseId cannot be null.");
    }

    @Override // com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedContract.View
    /* JADX INFO: renamed from: a */
    public void mo12755a(List<Object> list) {
        this.f12661o.m13945a();
        Iterator<Object> it = list.iterator();
        while (it.hasNext()) {
            mo12754a(it.next());
        }
    }

    @Override // com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedContract.View
    public void setTitle(String str) {
        this.f12657k.setTitleText(str);
    }

    @Override // com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedContract.View
    /* JADX INFO: renamed from: i */
    public void mo12761i() {
        this.f12658l.setRefreshing(false);
    }

    @Override // com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedContract.View
    public Context getApplicationContext() {
        return getContext().getApplicationContext();
    }

    /* JADX INFO: renamed from: p */
    public void m12807p() {
        this.f12652f.mo12749a();
    }

    @Override // com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedContract.View
    /* JADX INFO: renamed from: a */
    public void mo12754a(Object obj) {
        this.f12661o.m13947a(obj);
        this.f12662p.getLayoutManager().mo4312e(this.f12661o.getItemCount() - 1);
    }

    @Override // com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedContract.View
    /* JADX INFO: renamed from: j */
    public void mo12763j() {
        this.f12659m.setEnabled(true);
    }

    @Override // com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedContract.View
    /* JADX INFO: renamed from: l */
    public void mo12767l() {
        this.f12660n.setEnabled(false);
    }

    @Override // com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedContract.View
    /* JADX INFO: renamed from: m */
    public void mo12768m() {
        this.f12660n.setEnabled(true);
    }

    @Override // com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedContract.View
    /* JADX INFO: renamed from: n */
    public void mo12769n() {
        this.f12659m.setText("");
    }

    @Override // com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedContract.View
    /* JADX INFO: renamed from: k */
    public void mo12765k() {
        Snackbar snackbarM806a = Snackbar.m803a(this, R.string.cases_post_comment_error_snackbar_text, -2).m809e(ContextCompat.m1840c(getContext(), R.color.cases_error_snackbar_action_text_color)).m806a(R.string.cases_snackbar_retry_action_text, new View.OnClickListener() { // from class: com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CaseFeedView.this.m12804q();
            }
        });
        ViewUtils.m13059a(snackbarM806a, ContextCompat.m1840c(getContext(), R.color.cases_error_snackbar_background_color), ContextCompat.m1840c(getContext(), R.color.cases_error_snackbar_text_color));
        snackbarM806a.m490c();
    }

    @Override // com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedContract.View
    /* JADX INFO: renamed from: o */
    public void mo12770o() {
        ViewUtils.m13060a(this);
    }

    @Override // com.salesforce.android.service.common.ui.internal.text.SalesforceTextWatcher.OnAfterTextChangedListener
    /* JADX INFO: renamed from: a */
    public void mo12805a(Editable editable) {
        this.f12660n.setEnabled(editable.length() > 0);
    }

    /* JADX INFO: renamed from: a */
    private void m12802a(final Context context) {
        LayoutInflater.from(context).inflate(R.layout.case_feed_view, (ViewGroup) this, true);
        this.f12657k = (SalesforceTitleTextToolbar) findViewById(R.id.toolbar);
        this.f12654h = findViewById(R.id.case_feed_container);
        this.f12662p = (RecyclerView) findViewById(R.id.recycler_view);
        this.f12653g = (SalesforceProgressSpinner) findViewById(R.id.progress_spinner);
        this.f12655i = (ViewGroup) findViewById(R.id.case_generic_error_view);
        this.f12656j = (ViewGroup) findViewById(R.id.case_network_error_view);
        this.f12659m = (EditText) findViewById(R.id.salesforce_message_input);
        this.f12660n = findViewById(R.id.salesforce_send_message_button);
        this.f12663q = new SalesforceTextWatcher();
        this.f12663q.m14008a(this);
        if (this.f12659m != null) {
            this.f12659m.getBackground().setColorFilter(ContextCompat.m1840c(context.getApplicationContext(), R.color.salesforce_contrast_secondary), PorterDuff.Mode.SRC_IN);
            final Drawable background = this.f12659m.getBackground();
            this.f12659m.setHorizontallyScrolling(false);
            this.f12659m.setMaxLines(Integer.MAX_VALUE);
            this.f12659m.addTextChangedListener(this.f12663q);
            this.f12659m.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedView.2
                @Override // android.widget.TextView.OnEditorActionListener
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (i != 4 || !CaseFeedView.this.f12660n.isEnabled()) {
                        return false;
                    }
                    CaseFeedView.this.m12804q();
                    return true;
                }
            });
            this.f12659m.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedView.3
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view, boolean z) {
                    if (z) {
                        CaseFeedView.this.f12659m.setBackgroundColor(ContextCompat.m1840c(context, android.R.color.transparent));
                    } else {
                        CaseFeedView.this.f12659m.setBackground(background);
                    }
                }
            });
        }
        this.f12658l = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        if (this.f12658l != null) {
            this.f12658l.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedView.4
                @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
                /* JADX INFO: renamed from: n_ */
                public void mo3115n_() {
                    CaseFeedView.this.f12652f.mo12753c();
                }
            });
        }
        if (this.f12657k != null) {
            this.f12657k.setNavigationIcon(VectorDrawableCompat.m987a(getResources(), R.drawable.cases_ic_arrow_back, (Resources.Theme) null));
            this.f12657k.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedView.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CaseFeedView.this.m12807p();
                }
            });
            this.f12657k.setNavigationContentDescription(R.string.cases_navigate_back_content_description);
        }
        this.f12661o = new MessageFeedAdapter.Builder().m13951a(new MessageViewFactory()).m13950a(new LayoutInflaterFactory()).m13952a();
        if (this.f12662p != null) {
            this.f12661o.m13946a(this.f12662p);
        }
        if (this.f12660n != null) {
            this.f12660n.setEnabled(false);
            this.f12660n.setOnClickListener(new View.OnClickListener() { // from class: com.salesforce.android.cases.ui.internal.features.casefeed.CaseFeedView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CaseFeedView.this.m12804q();
                }
            });
        }
    }

    /* JADX INFO: renamed from: a */
    void m12806a(String str) {
        if (this.f12652f != null && StringUtils.m12617b(str)) {
            this.f12652f.mo12751a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: q */
    public void m12804q() {
        m12806a(this.f12659m.getText().toString());
    }
}
