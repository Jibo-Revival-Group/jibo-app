package com.jibo.p019ui.fragment.settings;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.BindView;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.robotProperties.model.GetRobotRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.Robot;
import com.jibo.aws.integration.helpers.RobotHelper;
import com.jibo.p019ui.fragment.avatar.AvatarsAdapter;
import com.jibo.p019ui.fragment.avatar.AvatarsLocationBaseFragment;
import com.jibo.utils.ImageUtils;

/* JADX INFO: loaded from: classes.dex */
public class AvatarSelectionFragment extends AvatarsLocationBaseFragment {

    /* JADX INFO: renamed from: c */
    public static final String f10915c = AvatarSelectionFragment.class.getSimpleName();

    @BindView
    ImageView jiboAvatar;

    /* JADX INFO: renamed from: p */
    private boolean f10916p = false;

    @Override // com.jibo.p019ui.fragment.avatar.AvatarsLocationBaseFragment, com.jibo.p019ui.fragment.settings.LocationFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        if (bundle != null) {
            this.f10147b = (Robot) bundle.getParcelable(Robot.class.getSimpleName());
        } else if (getArguments() != null) {
            this.f10147b = (Robot) getArguments().getParcelable(Robot.class.getSimpleName());
        }
        this.f10916p = getActivity().getSupportFragmentManager().mo1481e() <= 0;
    }

    @Override // com.jibo.p019ui.fragment.settings.LocationFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_avatar_selection, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.avatar.AvatarsLocationBaseFragment, com.jibo.p019ui.fragment.settings.LocationFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.jiboAvatar.setImageLevel(RobotHelper.getAvatar(this.f10147b));
    }

    @Override // com.jibo.p019ui.fragment.avatar.AvatarsLocationBaseFragment
    /* JADX INFO: renamed from: b */
    public void mo10487b(int i) {
        this.jiboAvatar.setImageLevel(i);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f9934k == null) {
            getActivity().onBackPressed();
        } else if (this.f10147b == null) {
            m10927b();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        if (this.f10916p) {
            menuInflater.inflate(R.menu.menu_action_done, menu);
            ImageUtils.m11393a(getActivity(), menu);
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.action_done) {
            return super.onOptionsItemSelected(menuItem);
        }
        getActivity().onBackPressed();
        return true;
    }

    @Override // com.jibo.p019ui.fragment.settings.LocationFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(Robot.class.getSimpleName(), this.f10147b);
    }

    @Override // com.jibo.p019ui.fragment.settings.LocationFragment, com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
        super.mo10334a(actionBar);
        actionBar.setDisplayHomeAsUpEnabled(!this.f10916p);
    }

    @Override // com.jibo.p019ui.fragment.avatar.AvatarsLocationBaseFragment, com.jibo.p019ui.fragment.settings.LocationFragment, com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return getString(R.string.title_avatar_select);
    }

    /* JADX INFO: renamed from: b */
    private void m10927b() {
        m10339a(true);
        this.f10146a.getRobot(this.f9934k.getRobotFriendlyId(), new AsyncHandler<GetRobotRequest, Robot>() { // from class: com.jibo.ui.fragment.settings.AvatarSelectionFragment.1
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                AvatarSelectionFragment.this.m10338a((Throwable) exc, "get robot", false);
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(GetRobotRequest getRobotRequest, Robot robot) {
                AvatarSelectionFragment.this.f10147b = robot;
                AvatarSelectionFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.settings.AvatarSelectionFragment.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AvatarSelectionFragment.this.mo10345g();
                        AvatarSelectionFragment.this.jiboAvatar.setImageLevel(RobotHelper.getAvatar(AvatarSelectionFragment.this.f10147b));
                        ((AvatarsAdapter) AvatarSelectionFragment.this.list.getAdapter()).m10475a(RobotHelper.getAvatar(AvatarSelectionFragment.this.f10147b));
                        AvatarSelectionFragment.this.list.getAdapter().notifyDataSetChanged();
                    }
                });
            }
        });
    }
}
