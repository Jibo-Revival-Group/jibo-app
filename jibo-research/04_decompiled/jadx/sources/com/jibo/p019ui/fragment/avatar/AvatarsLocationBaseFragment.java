package com.jibo.p019ui.fragment.avatar;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.BindView;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.robotProperties.JiboRobotPropertiesAsyncClient;
import com.jibo.aws.integration.aws.services.robotProperties.model.CreateRobotRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.Robot;
import com.jibo.aws.integration.helpers.RobotHelper;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.fragment.dialog.CircleProgressFragment;
import com.jibo.p019ui.fragment.settings.LocationFragment;
import com.jibo.utils.SharedPreferencesUtil;

/* JADX INFO: loaded from: classes.dex */
public abstract class AvatarsLocationBaseFragment extends LocationFragment {

    /* JADX INFO: renamed from: a */
    protected JiboRobotPropertiesAsyncClient f10146a;

    /* JADX INFO: renamed from: b */
    protected Robot f10147b;

    @BindView
    protected RecyclerView list;

    /* JADX INFO: renamed from: b */
    public abstract void mo10487b(int i);

    @Override // com.jibo.p019ui.fragment.settings.LocationFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        if (bundle != null) {
            this.f10147b = (Robot) bundle.getParcelable(Robot.class.getSimpleName());
        } else if (getArguments() != null) {
            this.f10147b = (Robot) getArguments().getParcelable(Robot.class.getSimpleName());
        }
        if (EntityData.m10089a(getActivity()).m10134i() != null) {
            this.f10146a = EntityData.m10089a(getActivity()).m10132g();
        }
        this.f9934k = SharedPreferencesUtil.m11443f(getActivity());
    }

    @Override // com.jibo.p019ui.fragment.settings.LocationFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        GridLayoutManager gridLayoutManager = new GridLayoutManager((Context) getActivity(), 4, 1, false);
        this.list.setHasFixedSize(true);
        this.list.setItemAnimator(new DefaultItemAnimator());
        this.list.setLayoutManager(gridLayoutManager);
        this.list.setAdapter(new AvatarsAdapter(R.layout.item_jibo_avatar, RobotHelper.getAvatar(this.f10147b), new ViewOnClickListenerC10851()));
        getActivity().setResult(-1);
    }

    /* JADX INFO: renamed from: com.jibo.ui.fragment.avatar.AvatarsLocationBaseFragment$1 */
    class ViewOnClickListenerC10851 implements View.OnClickListener {
        ViewOnClickListenerC10851() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AvatarsLocationBaseFragment.this.f11033o != null) {
                AvatarsLocationBaseFragment.this.f11033o.m10502a();
                AvatarsLocationBaseFragment.this.f11033o = null;
            }
            AvatarsLocationBaseFragment.this.f11033o = new CircleProgressFragment();
            AvatarsLocationBaseFragment.this.f11033o.m10509c(AvatarsLocationBaseFragment.this.getString(R.string.avatar_set_progress));
            AvatarsLocationBaseFragment.this.f11033o.show(AvatarsLocationBaseFragment.this.getActivity().getSupportFragmentManager(), "CircleFragment");
            final int iIntValue = ((Integer) view.getTag()).intValue();
            if (AvatarsLocationBaseFragment.this.f10147b != null) {
                AvatarsLocationBaseFragment.this.f10147b.getPayload().m9404a(RobotHelper.FIELD_AVATAR, Integer.valueOf(iIntValue));
            }
            AvatarsLocationBaseFragment.this.f10146a.updateRobot(AvatarsLocationBaseFragment.this.f10147b, new AsyncHandler<CreateRobotRequest, CommandResponse>() { // from class: com.jibo.ui.fragment.avatar.AvatarsLocationBaseFragment.1.1
                @Override // com.amazonaws.handlers.AsyncHandler
                public void onError(Exception exc) {
                    AvatarsLocationBaseFragment.this.m10338a((Throwable) exc, "robot update", true);
                    AvatarsLocationBaseFragment.this.f11033o.m10505a(AvatarsLocationBaseFragment.this.getString(R.string.avatar_set_failure));
                    AvatarsLocationBaseFragment.this.f11033o = null;
                }

                @Override // com.amazonaws.handlers.AsyncHandler
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(CreateRobotRequest createRobotRequest, CommandResponse commandResponse) {
                    AvatarsLocationBaseFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.avatar.AvatarsLocationBaseFragment.1.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AvatarsLocationBaseFragment.this.f11033o.m10505a(AvatarsLocationBaseFragment.this.getString(R.string.avatar_set_success));
                            AvatarsLocationBaseFragment.this.f11033o = null;
                            AvatarsLocationBaseFragment.this.mo10487b(iIntValue);
                            ((AvatarsAdapter) AvatarsLocationBaseFragment.this.list.getAdapter()).m10475a(iIntValue);
                            AvatarsLocationBaseFragment.this.list.getAdapter().notifyDataSetChanged();
                        }
                    });
                }
            });
        }
    }

    @Override // com.jibo.p019ui.fragment.settings.LocationFragment, com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return null;
    }
}
