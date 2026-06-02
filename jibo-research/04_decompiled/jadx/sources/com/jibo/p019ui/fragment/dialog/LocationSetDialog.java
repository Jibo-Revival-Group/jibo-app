package com.jibo.p019ui.fragment.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.jibo.R;
import com.jibo.aws.integration.helpers.RobotHelper;

/* JADX INFO: loaded from: classes.dex */
public class LocationSetDialog extends DialogFragment {

    /* JADX INFO: renamed from: a */
    Unbinder f10245a;

    @BindView
    TextView location;

    @BindView
    TextView timezone;

    @Override // android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        TextView textView = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.dialog_title, (ViewGroup) null);
        textView.setText(R.string.guided_experience_location_set_title);
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_location_set, (ViewGroup) null);
        AlertDialog.Builder builderM3233b = new AlertDialog.Builder(getActivity()).m3225a(textView).m3233b(viewInflate);
        this.f10245a = ButterKnife.m5154a(this, viewInflate);
        String string = bundle != null ? bundle.getString("ARGS_LOCATION") : getArguments().getString("ARGS_LOCATION");
        String string2 = bundle != null ? bundle.getString("ARGS_TIMEZONE") : getArguments().getString("ARGS_TIMEZONE");
        TextView textView2 = this.location;
        if (TextUtils.isEmpty(string)) {
            string = getString(R.string.robot_info_not_available);
        }
        textView2.setText(string);
        this.timezone.setText(RobotHelper.getTimeZoneFriendly(string2 != null ? string2.replace("\\/", "/") : "", getString(R.string.text_location_not_set)));
        return builderM3233b.m3236b();
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f10245a.unbind();
    }

    @OnClick
    public void onBtnSetClicked(View view) {
        dismiss();
    }
}
