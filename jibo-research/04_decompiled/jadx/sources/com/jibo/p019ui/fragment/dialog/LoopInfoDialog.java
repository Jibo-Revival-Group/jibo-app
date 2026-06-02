package com.jibo.p019ui.fragment.dialog;

import android.R;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.p018db.EntityData;
import com.jibo.utils.SharedPreferencesUtil;

/* JADX INFO: loaded from: classes.dex */
public class LoopInfoDialog extends BaseDialogFragment {

    /* JADX INFO: renamed from: d */
    private Loop f10250d;

    @BindView
    TextView peopleCountMessage;

    @BindView
    TextView text;

    @Override // android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), R.style.Theme.DeviceDefault.Light.Dialog.NoActionBar);
        View viewInflate = getActivity().getLayoutInflater().inflate(com.jibo.R.layout.dialog_loop_info, (ViewGroup) null);
        ButterKnife.m5154a(this, viewInflate);
        this.f10250d = SharedPreferencesUtil.m11443f(getContext());
        if (LoopHelper.isOwner(this.f10250d, EntityData.m10089a(getContext()).m10134i().getId())) {
            int activeMembersCount = LoopHelper.getActiveMembersCount(this.f10250d);
            if (activeMembersCount >= 16) {
                this.peopleCountMessage.setText(getString(com.jibo.R.string.jibo_details_footer_no_place));
            } else {
                this.peopleCountMessage.setText(String.format(getString(com.jibo.R.string.loop_info_dialog_people_count_text), String.valueOf(16 - activeMembersCount)));
            }
        } else {
            this.text.setText(com.jibo.R.string.loop_info_non_owner);
            this.peopleCountMessage.setVisibility(8);
        }
        appCompatDialog.setContentView(viewInflate);
        appCompatDialog.setCancelable(true);
        return appCompatDialog;
    }

    @OnClick
    public void okayClicked(View view) {
        dismiss();
    }
}
