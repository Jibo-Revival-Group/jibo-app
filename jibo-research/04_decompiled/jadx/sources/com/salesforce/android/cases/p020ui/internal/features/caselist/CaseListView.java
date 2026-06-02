package com.salesforce.android.cases.p020ui.internal.features.caselist;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.salesforce.android.cases.R;
import com.salesforce.android.cases.p020ui.internal.features.caselist.CaseListContract;
import com.salesforce.android.cases.p020ui.internal.features.caselist.viewmodel.CaseListItemViewModel;
import com.salesforce.android.cases.p020ui.internal.features.caselist.viewmodel.CaseListViewModel;
import com.salesforce.android.cases.p020ui.internal.utils.VerticalDividerItemDecoration;
import com.salesforce.android.cases.p020ui.internal.utils.ViewUtils;
import com.salesforce.android.service.common.p023ui.views.SalesforceProgressSpinner;
import com.salesforce.android.service.common.p023ui.views.SalesforceTitleTextToolbar;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public class CaseListView extends CoordinatorLayout implements SwipeRefreshLayout.OnRefreshListener, CaseListContract.View {

    /* JADX INFO: renamed from: f */
    SalesforceTitleTextToolbar f12736f;

    /* JADX INFO: renamed from: g */
    SalesforceProgressSpinner f12737g;

    /* JADX INFO: renamed from: h */
    SwipeRefreshLayout f12738h;

    /* JADX INFO: renamed from: i */
    RecyclerView f12739i;

    /* JADX INFO: renamed from: j */
    ViewGroup f12740j;

    /* JADX INFO: renamed from: k */
    ViewGroup f12741k;

    /* JADX INFO: renamed from: l */
    ViewGroup f12742l;

    /* JADX INFO: renamed from: m */
    Snackbar f12743m;

    /* JADX INFO: renamed from: n */
    Snackbar f12744n;

    /* JADX INFO: renamed from: o */
    Snackbar f12745o;

    /* JADX INFO: renamed from: p */
    FloatingActionButton f12746p;

    /* JADX INFO: renamed from: q */
    CaseListAdapter f12747q;

    /* JADX INFO: renamed from: r */
    private CaseListContract.Presenter f12748r;

    /* JADX INFO: renamed from: s */
    private int f12749s;

    public CaseListView(Context context) {
        this(context, null);
    }

    public CaseListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CaseListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12904a(context, attributeSet, i);
    }

    @Override // com.salesforce.android.cases.ui.internal.features.caselist.CaseListContract.View
    /* JADX INFO: renamed from: l_ */
    public void mo12872l_() {
        ViewUtils.m13062b(this.f12737g);
    }

    @Override // com.salesforce.android.cases.ui.internal.features.caselist.CaseListContract.View
    /* JADX INFO: renamed from: c */
    public void mo12862c() {
        ViewUtils.m13063c(this.f12737g);
    }

    @Override // com.salesforce.android.cases.ui.internal.features.caselist.CaseListContract.View
    /* JADX INFO: renamed from: m_ */
    public void mo12874m_() {
        this.f12738h.setRefreshing(true);
    }

    @Override // com.salesforce.android.cases.ui.internal.features.caselist.CaseListContract.View
    /* JADX INFO: renamed from: e */
    public void mo12864e() {
        this.f12738h.setRefreshing(false);
    }

    @Override // com.salesforce.android.cases.ui.internal.features.caselist.CaseListContract.View
    /* JADX INFO: renamed from: f */
    public void mo12865f() {
        this.f12746p.m719a();
    }

    @Override // com.salesforce.android.cases.ui.internal.features.caselist.CaseListContract.View
    /* JADX INFO: renamed from: g */
    public void mo12866g() {
        this.f12746p.m723b();
    }

    @Override // com.salesforce.android.cases.ui.internal.features.caselist.CaseListContract.View
    /* JADX INFO: renamed from: a */
    public void mo12860a(CaseListViewModel caseListViewModel) {
        ViewUtils.m13062b(this.f12738h);
        ViewUtils.m13062b(this.f12739i);
        this.f12739i.requestLayout();
        this.f12747q.m12843a(caseListViewModel.m12927a());
    }

    @Override // com.salesforce.android.cases.ui.internal.features.caselist.CaseListContract.View
    /* JADX INFO: renamed from: h */
    public void mo12867h() {
        ViewUtils.m13062b(this.f12738h);
        ViewUtils.m13062b(this.f12740j);
    }

    @Override // com.salesforce.android.cases.ui.internal.features.caselist.CaseListContract.View
    /* JADX INFO: renamed from: i */
    public void mo12868i() {
        ViewUtils.m13063c(this.f12740j);
    }

    @Override // com.salesforce.android.cases.ui.internal.features.caselist.CaseListContract.View
    /* JADX INFO: renamed from: j */
    public void mo12869j() {
        ViewUtils.m13062b(this.f12741k);
    }

    @Override // com.salesforce.android.cases.ui.internal.features.caselist.CaseListContract.View
    /* JADX INFO: renamed from: k */
    public void mo12870k() {
        this.f12743m = Snackbar.m803a(this, R.string.cases_generic_error_title_text, -2).m809e(ContextCompat.m1840c(getContext(), R.color.cases_error_snackbar_action_text_color)).m806a(R.string.cases_snackbar_retry_action_text, new View.OnClickListener() { // from class: com.salesforce.android.cases.ui.internal.features.caselist.CaseListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CaseListView.this.m12913o();
                CaseListView.this.f12743m = null;
            }
        });
        m12905a(this.f12743m);
    }

    @Override // com.salesforce.android.cases.ui.internal.features.caselist.CaseListContract.View
    /* JADX INFO: renamed from: l */
    public void mo12871l() {
        ViewUtils.m13062b(this.f12742l);
    }

    @Override // com.salesforce.android.cases.ui.internal.features.caselist.CaseListContract.View
    /* JADX INFO: renamed from: m */
    public void mo12873m() {
        this.f12744n = Snackbar.m803a(this, R.string.cases_network_error_title_text, -2).m809e(ContextCompat.m1840c(getContext(), R.color.cases_error_snackbar_action_text_color)).m806a(R.string.cases_snackbar_retry_action_text, new View.OnClickListener() { // from class: com.salesforce.android.cases.ui.internal.features.caselist.CaseListView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CaseListView.this.m12914p();
                CaseListView.this.f12744n = null;
            }
        });
        m12905a(this.f12744n);
    }

    @Override // com.salesforce.android.cases.ui.internal.features.caselist.CaseListContract.View
    /* JADX INFO: renamed from: n */
    public void mo12875n() {
        Snackbar snackbarM806a = Snackbar.m803a(this, R.string.cases_case_list_out_of_date_snackbar_text, -2).m806a(R.string.cases_snackbar_refresh_action_text, new View.OnClickListener() { // from class: com.salesforce.android.cases.ui.internal.features.caselist.CaseListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CaseListView.this.f12748r.mo12856h();
            }
        });
        ViewUtils.m13061b(snackbarM806a, ContextCompat.m1840c(getContext(), R.color.cases_snackbar_refresh_text_color));
        snackbarM806a.m490c();
    }

    @Override // com.salesforce.android.cases.ui.internal.features.caselist.CaseListContract.View
    public void setPresenter(CaseListContract.Presenter presenter) {
        this.f12748r = presenter;
    }

    @Override // com.salesforce.android.cases.ui.internal.features.caselist.CaseListContract.View
    /* JADX INFO: renamed from: a */
    public void mo12858a(CaseListItemViewModel caseListItemViewModel) {
        if (this.f12747q != null && this.f12747q.getItemCount() > 0) {
            this.f12747q.m12844b(caseListItemViewModel);
        }
    }

    @Override // com.salesforce.android.cases.ui.internal.features.caselist.CaseListContract.View
    /* JADX INFO: renamed from: b */
    public void mo12861b(CaseListItemViewModel caseListItemViewModel) {
        if (this.f12747q != null && this.f12747q.getItemCount() > 0) {
            this.f12747q.m12845c(caseListItemViewModel);
        }
    }

    @Override // com.salesforce.android.cases.ui.internal.features.caselist.CaseListContract.View
    /* JADX INFO: renamed from: a */
    public void mo12859a(CaseListItemViewModel caseListItemViewModel, int i) {
        if (this.f12747q != null) {
            this.f12747q.m12842a(caseListItemViewModel, i);
        }
    }

    @Override // com.salesforce.android.cases.ui.internal.features.caselist.CaseListContract.View
    /* JADX INFO: renamed from: c */
    public void mo12863c(final CaseListItemViewModel caseListItemViewModel) {
        this.f12745o = Snackbar.m803a(this, R.string.cases_case_list_item_removed_snackbar_message_text, -2).m487a(new Snackbar.Callback() { // from class: com.salesforce.android.cases.ui.internal.features.caselist.CaseListView.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.support.design.widget.Snackbar.Callback, android.support.design.widget.BaseTransientBottomBar.BaseCallback
            /* JADX INFO: renamed from: a */
            public void mo507a(Snackbar snackbar) {
                CaseListView.this.f12749s = 0;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.support.design.widget.Snackbar.Callback, android.support.design.widget.BaseTransientBottomBar.BaseCallback
            /* JADX INFO: renamed from: a */
            public void mo508a(Snackbar snackbar, int i) {
                CaseListView.this.f12749s = 0;
                CaseListView.this.f12745o = null;
            }
        }).m809e(ContextCompat.m1840c(getContext(), R.color.cases_default_snackbar_text_color)).m806a(R.string.cases_snackbar_undo_action_text, new View.OnClickListener() { // from class: com.salesforce.android.cases.ui.internal.features.caselist.CaseListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CaseListView.this.f12748r != null) {
                    CaseListView.this.f12748r.mo12853c(caseListItemViewModel);
                }
            }
        });
        ViewUtils.m13058a(this.f12745o, ContextCompat.m1840c(getContext(), R.color.cases_default_snackbar_text_color));
        this.f12745o.m490c();
    }

    @Override // com.salesforce.android.cases.ui.internal.features.caselist.CaseListContract.View
    public void setTitle(String str) {
        this.f12736f.setTitleText(str);
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
    /* JADX INFO: renamed from: n_ */
    public void mo3115n_() {
        if (this.f12748r != null) {
            this.f12748r.mo12856h();
        }
        if (this.f12745o != null && this.f12745o.m494e()) {
            this.f12745o.m492d();
        }
    }

    /* JADX INFO: renamed from: o */
    void m12913o() {
        if (this.f12748r != null) {
            this.f12748r.mo12852c();
        }
    }

    /* JADX INFO: renamed from: p */
    void m12914p() {
        if (this.f12748r != null) {
            this.f12748r.mo12854f();
        }
    }

    /* JADX INFO: renamed from: q */
    void m12915q() {
        if (this.f12748r != null) {
            this.f12748r.mo12847a();
        }
    }

    /* JADX INFO: renamed from: r */
    void m12916r() {
        if (this.f12748r != null) {
            this.f12748r.mo12850b();
        }
    }

    /* JADX INFO: renamed from: d */
    void m12911d(CaseListItemViewModel caseListItemViewModel) {
        if (this.f12748r != null) {
            this.f12748r.mo12849a(caseListItemViewModel);
        }
    }

    /* JADX INFO: renamed from: e */
    void m12912e(CaseListItemViewModel caseListItemViewModel) {
        if (this.f12748r != null) {
            this.f12748r.mo12851b(caseListItemViewModel);
        }
    }

    /* JADX INFO: renamed from: b */
    void m12910b(int i) {
        if (this.f12745o != null) {
            this.f12749s += Math.abs(i);
            if (this.f12749s >= 200) {
                this.f12745o.m492d();
                this.f12745o = null;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m12905a(Snackbar snackbar) {
        ViewUtils.m13059a(snackbar, ContextCompat.m1840c(getContext(), R.color.cases_error_snackbar_background_color), ContextCompat.m1840c(getContext(), R.color.cases_error_snackbar_text_color));
        snackbar.m490c();
    }

    /* JADX INFO: renamed from: a */
    private void m12904a(Context context, AttributeSet attributeSet, int i) {
        context.getTheme().obtainStyledAttributes(attributeSet, new int[]{R.attr.colorControlNormal}, i, 0).recycle();
        LayoutInflater.from(context).inflate(R.layout.case_list_view, (ViewGroup) this, true);
        this.f12736f = (SalesforceTitleTextToolbar) findViewById(R.id.toolbar);
        this.f12737g = (SalesforceProgressSpinner) findViewById(R.id.progress_spinner);
        this.f12738h = (SwipeRefreshLayout) findViewById(R.id.case_list_swipe_refresh);
        this.f12739i = (RecyclerView) findViewById(R.id.case_list_recycler);
        this.f12740j = (ViewGroup) findViewById(R.id.case_list_empty_view);
        this.f12741k = (ViewGroup) findViewById(R.id.case_generic_error_view);
        this.f12742l = (ViewGroup) findViewById(R.id.case_network_error_view);
        this.f12746p = (FloatingActionButton) findViewById(R.id.create_case_button);
        if (this.f12746p != null) {
            this.f12746p.setOnClickListener(new View.OnClickListener() { // from class: com.salesforce.android.cases.ui.internal.features.caselist.CaseListView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CaseListView.this.m12915q();
                }
            });
        }
        if (this.f12736f != null) {
            this.f12736f.setNavigationIcon(VectorDrawableCompat.m987a(getResources(), R.drawable.cases_ic_clear, (Resources.Theme) null));
            this.f12736f.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.salesforce.android.cases.ui.internal.features.caselist.CaseListView.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CaseListView.this.m12916r();
                }
            });
            this.f12736f.setNavigationContentDescription(R.string.cases_close_button_text);
        }
        if (this.f12741k != null) {
            ((TextView) this.f12741k.findViewById(R.id.case_generic_error_message)).setText(R.string.cases_list_view_error_subtitle_text);
        }
        m12907s();
        m12909u();
    }

    /* JADX INFO: renamed from: s */
    private void m12907s() {
        if (this.f12738h != null) {
            this.f12738h.setOnRefreshListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: t */
    public void m12908t() {
        this.f12739i.getLayoutManager().mo4312e(0);
    }

    /* JADX INFO: renamed from: u */
    private void m12909u() {
        if (this.f12739i != null) {
            Resources resources = getResources();
            this.f12739i.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
            this.f12739i.addItemDecoration(new VerticalDividerItemDecoration(ContextCompat.m1832a(getContext(), R.drawable.cases_list_divider), resources.getDimensionPixelSize(R.dimen.cases_case_list_divider_left_padding), 0));
            this.f12747q = new CaseListAdapter(getContext()) { // from class: com.salesforce.android.cases.ui.internal.features.caselist.CaseListView.8
                @Override // com.salesforce.android.cases.p020ui.internal.features.caselist.CaseListAdapter
                /* JADX INFO: renamed from: a */
                void mo12841a(CaseListItemViewModel caseListItemViewModel) {
                    CaseListView.this.m12911d(caseListItemViewModel);
                }
            };
            this.f12747q.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() { // from class: com.salesforce.android.cases.ui.internal.features.caselist.CaseListView.9
                @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
                /* JADX INFO: renamed from: a */
                public void mo4429a(int i, int i2) {
                    if (i == 0) {
                        CaseListView.this.m12908t();
                    }
                }

                @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
                /* JADX INFO: renamed from: b */
                public void mo4432b(int i, int i2) {
                    if (i == 0) {
                        CaseListView.this.m12908t();
                    }
                }
            });
            this.f12739i.setAdapter(this.f12747q);
            new ItemTouchHelper(new SwipeCallback()).m5050a(this.f12739i);
            this.f12739i.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.salesforce.android.cases.ui.internal.features.caselist.CaseListView.10
                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                /* JADX INFO: renamed from: a */
                public void mo4164a(RecyclerView recyclerView, int i, int i2) {
                    CaseListView.this.m12910b(i2);
                }
            });
        }
    }

    private class SwipeCallback extends ItemTouchHelper.SimpleCallback {

        /* JADX INFO: renamed from: b */
        private Drawable f12762b;

        /* JADX INFO: renamed from: c */
        private Drawable f12763c;

        /* JADX INFO: renamed from: d */
        private int f12764d;

        SwipeCallback() {
            super(0, 12);
            this.f12762b = new ColorDrawable(ContextCompat.m1840c(CaseListView.this.getContext(), R.color.salesforce_feedback_secondary));
            this.f12763c = VectorDrawableCompat.m987a(CaseListView.this.getResources(), R.drawable.cases_ic_check, CaseListView.this.getContext().getTheme());
            this.f12764d = CaseListView.this.getResources().getDimensionPixelSize(R.dimen.cases_case_list_check_horizontal_margin);
        }

        @Override // android.support.v7.widget.helper.ItemTouchHelper.Callback
        /* JADX INFO: renamed from: b */
        public boolean mo5082b(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            return false;
        }

        @Override // android.support.v7.widget.helper.ItemTouchHelper.Callback
        /* JADX INFO: renamed from: a */
        public void mo5071a(RecyclerView.ViewHolder viewHolder, int i) {
            CaseListItemViewModel caseListItemViewModelM12839a = CaseListView.this.f12747q.m12839a(viewHolder.getAdapterPosition());
            if (caseListItemViewModelM12839a != null) {
                CaseListView.this.m12912e(caseListItemViewModelM12839a);
            }
        }

        @Override // android.support.v7.widget.helper.ItemTouchHelper.Callback
        /* JADX INFO: renamed from: a */
        public void mo5069a(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
            int left;
            int i2;
            int i3;
            if (i == 1) {
                CaseListView.this.f12738h.setEnabled(!z);
                View view = viewHolder.itemView;
                float fAbs = Math.abs(f) / view.getWidth();
                int bottom = view.getBottom() - view.getTop();
                int right = view.getRight();
                int left2 = view.getLeft();
                int top = view.getTop();
                int bottom2 = view.getBottom();
                float f3 = 0.5f * fAbs;
                int intrinsicWidth = this.f12763c.getIntrinsicWidth();
                int intrinsicHeight = this.f12763c.getIntrinsicHeight();
                int i4 = (int) ((intrinsicWidth * f3) + intrinsicWidth);
                int i5 = (int) ((f3 * intrinsicHeight) + intrinsicHeight);
                int i6 = top + ((bottom - i5) / 2);
                int i7 = i5 + i6;
                int i8 = (int) (fAbs * 255.0f);
                if (f > CropImageView.DEFAULT_ASPECT_RATIO) {
                    left = view.getLeft();
                    right = (int) f;
                    i3 = left2 + this.f12764d;
                    i2 = i3 + i4;
                } else {
                    left = (int) (right + f);
                    i2 = right - this.f12764d;
                    i3 = i2 - i4;
                }
                this.f12762b.setBounds(left, top, right, bottom2);
                this.f12762b.draw(canvas);
                this.f12763c.setBounds(i3, i6, i2, i7);
                this.f12763c.setAlpha(i8);
                this.f12763c.draw(canvas);
                super.mo5069a(canvas, recyclerView, viewHolder, f, f2, i, z);
            }
        }
    }
}
