package com.jibo.p019ui.fragment.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.view.ContextThemeWrapper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.jibo.R;
import com.jibo.utils.ImageUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class MaterialDatePickerDialogFragment extends DialogFragment {

    /* JADX INFO: renamed from: a */
    Unbinder f10255a;

    /* JADX INFO: renamed from: b */
    private Calendar f10256b;

    /* JADX INFO: renamed from: c */
    private SimpleDateFormat f10257c;

    /* JADX INFO: renamed from: d */
    private String f10258d;

    @BindView
    DatePicker datePicker;

    /* JADX INFO: renamed from: e */
    private String f10259e;

    /* JADX INFO: renamed from: f */
    private Long f10260f = null;

    /* JADX INFO: renamed from: g */
    private Long f10261g = null;

    /* JADX INFO: renamed from: h */
    private Long f10262h = null;

    @BindView
    TextView textDayOfMonth;

    @BindView
    TextView textMonthYear;

    @BindView
    TextView textTitle;

    public interface OnDateChosenListener {
        /* JADX INFO: renamed from: a */
        void mo10374a(long j);
    }

    @Override // android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        long jLongValue;
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(getActivity(), R.style.MaterialDatePickerDialogTheme));
        View viewInflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_pretty_date_picker, (ViewGroup) null);
        this.f10255a = ButterKnife.m5154a(this, viewInflate);
        this.f10260f = Long.valueOf(System.currentTimeMillis());
        if (getArguments() != null) {
            if (getArguments().containsKey("ARGS_DATE")) {
                jLongValue = getArguments().getLong("ARGS_DATE");
            } else {
                jLongValue = this.f10260f.longValue();
            }
            this.f10260f = Long.valueOf(jLongValue);
            this.f10261g = getArguments().containsKey("ARGS_MAX_VALUE") ? Long.valueOf(getArguments().getLong("ARGS_MAX_VALUE")) : null;
            this.f10262h = getArguments().containsKey("ARGS_MIN_VALUE") ? Long.valueOf(getArguments().getLong("ARGS_MIN_VALUE")) : null;
            if (this.f10262h != null) {
                this.f10261g = this.f10261g == null ? Long.valueOf(System.currentTimeMillis()) : null;
                this.f10262h = Long.valueOf(m10555a(this.f10262h.longValue()));
            }
            this.f10261g = this.f10261g != null ? Long.valueOf(m10555a(this.f10261g.longValue())) : null;
            this.f10258d = getArguments().getString("ARGS_TITLE");
            this.f10259e = getArguments().getString("ARGS_ERROR_TEXT");
        }
        this.f10260f = Long.valueOf(m10555a(this.f10260f.longValue()));
        this.f10256b = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        this.f10256b.setTimeInMillis(this.f10260f.longValue());
        if (!TextUtils.isEmpty(this.f10258d)) {
            this.textTitle.setText(this.f10258d);
        }
        this.datePicker.setMaxDate(System.currentTimeMillis());
        this.datePicker.init(this.f10256b.get(1), this.f10256b.get(2), this.f10256b.get(5), new DatePicker.OnDateChangedListener() { // from class: com.jibo.ui.fragment.dialog.MaterialDatePickerDialogFragment.1
            @Override // android.widget.DatePicker.OnDateChangedListener
            public void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
                MaterialDatePickerDialogFragment.this.f10256b.set(5, i3);
                MaterialDatePickerDialogFragment.this.f10256b.set(2, i2);
                MaterialDatePickerDialogFragment.this.f10256b.set(1, i);
                MaterialDatePickerDialogFragment.this.m10558b();
            }
        });
        this.f10257c = new SimpleDateFormat("MMMM, yyyy");
        this.f10257c.setTimeZone(TimeZone.getTimeZone("GMT"));
        m10558b();
        builder.m3233b(viewInflate);
        return builder.m3236b();
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f10255a.unbind();
    }

    @OnClick
    public void onCancelClick(View view) {
        dismiss();
    }

    @OnClick
    public void onSetClick(View view) {
        if (!m10557a()) {
            this.textTitle.setText(this.f10259e);
            this.textTitle.setBackgroundColor(ImageUtils.m11399b(getActivity(), R.color.firecracker));
        } else {
            if (getTargetFragment() != null && (getTargetFragment() instanceof OnDateChosenListener)) {
                ((OnDateChosenListener) getTargetFragment()).mo10374a(this.f10256b.getTimeInMillis());
            }
            dismiss();
        }
    }

    /* JADX INFO: renamed from: a */
    private long m10555a(long j) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        calendar.setTimeInMillis(j);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(14, 0);
        calendar.set(13, 0);
        return calendar.getTimeInMillis();
    }

    /* JADX INFO: renamed from: a */
    private boolean m10557a() {
        if (this.f10261g != null) {
            if (this.f10261g.longValue() < this.f10256b.getTimeInMillis()) {
                return false;
            }
            if (this.f10262h != null && this.f10262h.longValue() > this.f10256b.getTimeInMillis()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m10558b() {
        this.textDayOfMonth.setText(String.valueOf(this.f10256b.get(5)));
        this.textMonthYear.setText(this.f10257c.format(this.f10256b.getTime()).toUpperCase());
    }
}
