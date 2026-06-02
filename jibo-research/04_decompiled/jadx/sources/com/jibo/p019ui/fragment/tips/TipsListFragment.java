package com.jibo.p019ui.fragment.tips;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import com.jibo.JiboAnalytics;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.TipsActivity;
import com.jibo.p019ui.fragment.BaseFragment;
import com.jibo.utils.Lists;
import com.jibo.utils.SharedPreferencesUtil;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TipsListFragment extends BaseFragment {

    /* JADX INFO: renamed from: a */
    public static final List<String> f11195a = Lists.m11404a("TAG_TIP4", "TAG_TIP0", "TAG_TIP1", "TAG_TIP2", "TAG_TIP3");

    /* JADX INFO: renamed from: b */
    private View.OnClickListener f11196b = new View.OnClickListener() { // from class: com.jibo.ui.fragment.tips.TipsListFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = (String) view.getTag();
            switch (str) {
                case "TAG_TIP0":
                    JiboAnalytics.m9853f(TipsListFragment.this.getActivity(), JiboAnalytics.f9210aK);
                    break;
                case "TAG_TIP1":
                    JiboAnalytics.m9853f(TipsListFragment.this.getActivity(), JiboAnalytics.f9211aL);
                    break;
                case "TAG_TIP2":
                    JiboAnalytics.m9853f(TipsListFragment.this.getActivity(), JiboAnalytics.f9212aM);
                    break;
                case "TAG_TIP3":
                    JiboAnalytics.m9853f(TipsListFragment.this.getActivity(), JiboAnalytics.f9213aN);
                    break;
                case "TAG_TIP4":
                    JiboAnalytics.m9853f(TipsListFragment.this.getActivity(), JiboAnalytics.f9214aO);
                    break;
                case "TAG_TIP5":
                    JiboAnalytics.m9853f(TipsListFragment.this.getActivity(), JiboAnalytics.f9215aP);
                    break;
            }
            Intent intent = new Intent();
            intent.setClass(TipsListFragment.this.getContext(), TipsActivity.class);
            intent.putExtra("ARGS_TAG", str);
            TipsListFragment.this.startActivity(intent);
        }
    };

    @BindView
    View tip0;

    @BindView
    View tip1;

    @BindView
    View tip2;

    @BindView
    View tip3;

    @BindView
    View tip4;

    @BindView
    View tip5;

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_tips_list, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Account accountM10134i = EntityData.m10089a(getActivity()).m10134i();
        this.f9934k = SharedPreferencesUtil.m11443f(getActivity());
        if (accountM10134i != null && LoopHelper.isOwner(this.f9934k, accountM10134i.getId())) {
            this.tip0.setVisibility(0);
            this.tip0.setOnClickListener(this.f11196b);
        } else {
            this.tip0.setVisibility(8);
        }
        this.tip1.setOnClickListener(this.f11196b);
        this.tip2.setOnClickListener(this.f11196b);
        this.tip3.setOnClickListener(this.f11196b);
        this.tip4.setOnClickListener(this.f11196b);
        this.tip5.setOnClickListener(this.f11196b);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.menu_action_support, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (R.id.action_support != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getString(R.string.support_url))));
        return true;
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    public String mo10353o() {
        return getString(R.string.title_tips);
    }
}
