package com.jibo.p019ui.fragment.dialog;

import android.R;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatDialog;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.p019ui.activity.SingleFragmentActivity;
import com.jibo.p019ui.fragment.settings.HolidaySettingsFragment;
import com.jibo.utils.LoopHolidaysAlarmReceiver;

/* JADX INFO: loaded from: classes.dex */
public class HolidaysPopupFragment extends DialogFragment {

    /* JADX INFO: renamed from: a */
    private Loop f10237a;

    /* JADX INFO: renamed from: a */
    public static void m10554a(FragmentManager fragmentManager, Loop loop) {
        HolidaysPopupFragment holidaysPopupFragment = new HolidaysPopupFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(Loop.class.getSimpleName(), loop);
        holidaysPopupFragment.setArguments(bundle);
        holidaysPopupFragment.show(fragmentManager, HolidaysPopupFragment.class.getSimpleName());
    }

    @Override // android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), R.style.Theme.Black.NoTitleBar);
        View viewInflate = getActivity().getLayoutInflater().inflate(com.jibo.R.layout.dialog_holidays_popup, (ViewGroup) null);
        ButterKnife.m5154a(this, viewInflate);
        setCancelable(true);
        appCompatDialog.setContentView(viewInflate);
        appCompatDialog.setCancelable(true);
        if (bundle != null) {
            this.f10237a = (Loop) bundle.getParcelable(Loop.class.getSimpleName());
        } else if (getArguments() != null) {
            this.f10237a = (Loop) getArguments().getParcelable(Loop.class.getSimpleName());
        }
        LoopHolidaysAlarmReceiver.m11414b(getActivity(), this.f10237a);
        return appCompatDialog;
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f10237a != null) {
            bundle.putParcelable(Loop.class.getSimpleName(), this.f10237a);
        }
    }

    @OnClick
    public void onBtnAddHolidaysClick() {
        new SingleFragmentActivity.Builder(getActivity(), HolidaySettingsFragment.class.getName()).m10272a(Loop.class.getSimpleName(), (Parcelable) this.f10237a).m10275a(1022);
        dismiss();
    }

    @OnClick
    public void onBtnCancelClick() {
        dismiss();
    }
}
