package com.salesforce.android.knowledge.p022ui.internal.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.salesforce.android.knowledge.p022ui.R;
import com.salesforce.android.knowledge.p022ui.internal.ViewBinder;
import com.salesforce.android.knowledge.p022ui.internal.client.KnowledgeUIClientImpl;
import com.salesforce.android.knowledge.p022ui.internal.navigation.ViewState;

/* JADX INFO: loaded from: classes.dex */
public class KnowledgeFragment extends Fragment {

    /* JADX INFO: renamed from: a */
    private ViewState f13107a;

    /* JADX INFO: renamed from: b */
    private ViewBinder f13108b;

    /* JADX INFO: renamed from: a */
    private ViewState m13434a(KnowledgeActivity knowledgeActivity) {
        KnowledgeUIClientImpl knowledgeUIClientImplM13432a = knowledgeActivity.m13432a();
        if (knowledgeUIClientImplM13432a == null || knowledgeUIClientImplM13432a.m13534i() == null) {
            return null;
        }
        return knowledgeUIClientImplM13432a.m13534i().m13637a(knowledgeActivity);
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof KnowledgeActivity) {
            this.f13107a = m13434a((KnowledgeActivity) context);
            if (this.f13107a != null) {
                this.f13108b = this.f13107a.m13652a();
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f13108b != null) {
            setHasOptionsMenu(this.f13108b.mo13421t_());
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f13108b == null) {
            return null;
        }
        View viewMo13413a = this.f13108b.mo13413a(layoutInflater, viewGroup, bundle);
        if (this.f13108b.mo13421t_()) {
            ((AppCompatActivity) getActivity()).setSupportActionBar(this.f13108b.mo13419d());
        }
        return viewMo13413a;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.f13108b != null) {
            getActivity().findViewById(R.id.knowledge_fragment_container).setBackgroundResource(this.f13108b.mo13420e());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (this.f13107a != null) {
            this.f13107a.m13654c();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f13107a != null) {
            this.f13107a.m13653b();
        }
        if (this.f13108b != null) {
            this.f13108b.mo13417b();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        if (this.f13108b != null) {
            this.f13108b.mo13415a(menu, menuInflater);
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.f13108b != null && this.f13108b.mo13416a(menuItem);
    }

    static class Factory {
        Factory() {
        }

        /* JADX INFO: renamed from: a */
        KnowledgeFragment m13435a() {
            return new KnowledgeFragment();
        }
    }
}
