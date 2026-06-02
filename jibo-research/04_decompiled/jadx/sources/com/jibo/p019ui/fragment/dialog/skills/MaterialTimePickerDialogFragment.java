package com.jibo.p019ui.fragment.dialog.skills;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TimePicker;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.google.gson.Gson;
import com.jibo.R;
import com.jibo.p019ui.activity.OnBoardingActivity;
import com.jibo.p019ui.helpers.skills.DataItems;
import com.jibo.p019ui.helpers.skills.SkillsJsonParser;

/* JADX INFO: loaded from: classes.dex */
public class MaterialTimePickerDialogFragment extends DialogFragment {

    /* JADX INFO: renamed from: a */
    Unbinder f10314a;

    /* JADX INFO: renamed from: b */
    private DataItems.TimeDataItem f10315b;

    /* JADX INFO: renamed from: c */
    private DataItems.TimeDataValue f10316c;

    @BindView
    TimePicker simpleTimePicker;

    public interface DataChangedListener {
        /* JADX INFO: renamed from: a */
        void mo10414a(DataItems.DataItem dataItem, DataItems.DataValue dataValue);
    }

    @Override // android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        if (bundle != null && bundle.getBoolean("ARGS_SKILL_FRAGMENT", false) && !SkillsJsonParser.isCreated()) {
            Intent intent = new Intent(getContext(), (Class<?>) OnBoardingActivity.class);
            intent.setFlags(67108864);
            getContext().startActivity(intent);
            return new Dialog(getContext());
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(getActivity(), R.style.MaterialDatePickerDialogTheme));
        View viewInflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_pretty_time_picker, (ViewGroup) null);
        this.f10314a = ButterKnife.m5154a(this, viewInflate);
        if (bundle != null) {
            this.f10315b = (DataItems.TimeDataItem) new Gson().m9355a(bundle.getString(DataItems.TimeDataItem.class.getSimpleName()), DataItems.TimeDataItem.class);
        }
        if (getArguments() != null) {
            this.f10315b = (DataItems.TimeDataItem) new Gson().m9355a(getArguments().getString(DataItems.TimeDataItem.class.getSimpleName()), DataItems.TimeDataItem.class);
        }
        if (this.f10315b != null) {
            SkillsJsonParser.getInstance().setItemDataValue(this.f10315b);
            this.f10316c = (DataItems.TimeDataValue) this.f10315b.getDataValue();
        } else {
            this.f10316c = new DataItems.TimeDataValue(0, 0);
        }
        if (this.f10316c == null) {
            this.f10316c = new DataItems.TimeDataValue(0, 0);
        }
        this.simpleTimePicker.setIs24HourView(true);
        if (Build.VERSION.SDK_INT >= 23) {
            this.simpleTimePicker.setHour(this.f10316c.getHour());
            this.simpleTimePicker.setMinute(this.f10316c.getMin());
        } else {
            this.simpleTimePicker.setCurrentHour(Integer.valueOf(this.f10316c.getHour()));
            this.simpleTimePicker.setCurrentMinute(Integer.valueOf(this.f10316c.getMin()));
        }
        this.simpleTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() { // from class: com.jibo.ui.fragment.dialog.skills.MaterialTimePickerDialogFragment.1
            @Override // android.widget.TimePicker.OnTimeChangedListener
            public void onTimeChanged(TimePicker timePicker, int i, int i2) {
                MaterialTimePickerDialogFragment.this.f10316c.setTime(i, i2);
            }
        });
        builder.m3233b(viewInflate);
        return builder.m3236b();
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(DataItems.TimeDataItem.class.getSimpleName(), new Gson().m9362b(this.f10315b));
        bundle.putBoolean("ARGS_SKILL_FRAGMENT", getArguments().getBoolean("ARGS_SKILL_FRAGMENT"));
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f10314a != null) {
            this.f10314a.unbind();
        }
    }

    @OnClick
    public void onCancelClick(View view) {
        dismiss();
    }

    @OnClick
    public void onSetClick(View view) {
        if (getTargetFragment() != null && (getTargetFragment() instanceof DataChangedListener)) {
            ((DataChangedListener) getTargetFragment()).mo10414a(this.f10315b, this.f10316c);
        }
        dismiss();
    }
}
