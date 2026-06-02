package com.jibo.p019ui.fragment.jibos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.OnClick;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.SingleFragmentActivity;
import com.jibo.p019ui.activity.WifiActivity;
import com.jibo.p019ui.fragment.BaseFragment;
import com.jibo.p019ui.fragment.account.AccountSettingsFragment;
import com.jibo.p019ui.fragment.dialog.DialogUtils;
import com.jibo.p019ui.helpers.skills.SkillsJsonParser;
import com.jibo.utils.ImageUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class NoLoopsFragment extends BaseFragment {

    @BindView
    View icon;

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.layout_jibos_screen_empty, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        float f = getResources().getConfiguration().fontScale;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.icon.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, (int) (layoutParams.topMargin / f), layoutParams.rightMargin, layoutParams.bottomMargin);
    }

    @OnClick
    public void onConnectWifi(View view) {
        WifiActivity.m10316a(getActivity(), (ArrayList<Loop>) null);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.menu_settings, menu);
        ImageUtils.m11393a(getActivity(), menu);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.action_settings) {
            return super.onOptionsItemSelected(menuItem);
        }
        SkillsJsonParser.getInstance().clearSkills();
        new SingleFragmentActivity.Builder(getActivity(), AccountSettingsFragment.class.getName()).m10275a(1001);
        return true;
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return getString(R.string.title_your_loops);
    }

    @OnClick
    public void onInviteInfo(View view) {
        DialogUtils.m10526d(this, 1, getString(R.string.msg_getting_invited_into_right_loop_title), String.format(getString(R.string.msg_getting_invited_into_right_loop_text), EntityData.m10089a(getActivity()).m10134i().getEmail()));
    }
}
