package com.jibo.p019ui.fragment.invite;

import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class NameBirthdayGenderFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private NameBirthdayGenderFragment f10477b;

    /* JADX INFO: renamed from: c */
    private View f10478c;

    /* JADX INFO: renamed from: d */
    private View f10479d;

    /* JADX INFO: renamed from: e */
    private View f10480e;

    /* JADX INFO: renamed from: f */
    private View f10481f;

    public NameBirthdayGenderFragment_ViewBinding(final NameBirthdayGenderFragment nameBirthdayGenderFragment, View view) {
        this.f10477b = nameBirthdayGenderFragment;
        nameBirthdayGenderFragment.title = (TextView) Utils.m5161b(view, R.id.title, "field 'title'", TextView.class);
        nameBirthdayGenderFragment.firstName = (AutoCompleteTextView) Utils.m5161b(view, R.id.first_name, "field 'firstName'", AutoCompleteTextView.class);
        nameBirthdayGenderFragment.lastName = (AutoCompleteTextView) Utils.m5161b(view, R.id.last_name, "field 'lastName'", AutoCompleteTextView.class);
        View viewM5158a = Utils.m5158a(view, R.id.date_text, "field 'dateText' and method 'selectBirthday'");
        nameBirthdayGenderFragment.dateText = (TextView) Utils.m5162c(viewM5158a, R.id.date_text, "field 'dateText'", TextView.class);
        this.f10478c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.invite.NameBirthdayGenderFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                nameBirthdayGenderFragment.selectBirthday(view2);
            }
        });
        nameBirthdayGenderFragment.birthdayTitle = (TextView) Utils.m5161b(view, R.id.birthsday_title, "field 'birthdayTitle'", TextView.class);
        nameBirthdayGenderFragment.genderGroup = (RadioGroup) Utils.m5161b(view, R.id.gender_group, "field 'genderGroup'", RadioGroup.class);
        nameBirthdayGenderFragment.genderTitle = (TextView) Utils.m5161b(view, R.id.gender_title, "field 'genderTitle'", TextView.class);
        nameBirthdayGenderFragment.radioMale = (RadioButton) Utils.m5161b(view, R.id.radio_button_male, "field 'radioMale'", RadioButton.class);
        nameBirthdayGenderFragment.radioFemale = (RadioButton) Utils.m5161b(view, R.id.radio_button_female, "field 'radioFemale'", RadioButton.class);
        nameBirthdayGenderFragment.radioOther = (RadioButton) Utils.m5161b(view, R.id.radio_button_other, "field 'radioOther'", RadioButton.class);
        nameBirthdayGenderFragment.formNavigationPanel = Utils.m5158a(view, R.id.formNavigationPanel, "field 'formNavigationPanel'");
        View viewM5158a2 = Utils.m5158a(view, R.id.btnPrev, "field 'btnPrev' and method 'onBtnPrevClick'");
        nameBirthdayGenderFragment.btnPrev = (ImageView) Utils.m5162c(viewM5158a2, R.id.btnPrev, "field 'btnPrev'", ImageView.class);
        this.f10479d = viewM5158a2;
        viewM5158a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.invite.NameBirthdayGenderFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                nameBirthdayGenderFragment.onBtnPrevClick(view2);
            }
        });
        View viewM5158a3 = Utils.m5158a(view, R.id.btnNext, "field 'btnNext' and method 'onBtnNextClick'");
        nameBirthdayGenderFragment.btnNext = (ImageView) Utils.m5162c(viewM5158a3, R.id.btnNext, "field 'btnNext'", ImageView.class);
        this.f10480e = viewM5158a3;
        viewM5158a3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.invite.NameBirthdayGenderFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                nameBirthdayGenderFragment.onBtnNextClick(view2);
            }
        });
        View viewM5158a4 = Utils.m5158a(view, R.id.btnDone, "method 'onBtnDoneClick'");
        this.f10481f = viewM5158a4;
        viewM5158a4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.invite.NameBirthdayGenderFragment_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                nameBirthdayGenderFragment.onBtnDoneClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        NameBirthdayGenderFragment nameBirthdayGenderFragment = this.f10477b;
        if (nameBirthdayGenderFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10477b = null;
        nameBirthdayGenderFragment.title = null;
        nameBirthdayGenderFragment.firstName = null;
        nameBirthdayGenderFragment.lastName = null;
        nameBirthdayGenderFragment.dateText = null;
        nameBirthdayGenderFragment.birthdayTitle = null;
        nameBirthdayGenderFragment.genderGroup = null;
        nameBirthdayGenderFragment.genderTitle = null;
        nameBirthdayGenderFragment.radioMale = null;
        nameBirthdayGenderFragment.radioFemale = null;
        nameBirthdayGenderFragment.radioOther = null;
        nameBirthdayGenderFragment.formNavigationPanel = null;
        nameBirthdayGenderFragment.btnPrev = null;
        nameBirthdayGenderFragment.btnNext = null;
        this.f10478c.setOnClickListener(null);
        this.f10478c = null;
        this.f10479d.setOnClickListener(null);
        this.f10479d = null;
        this.f10480e.setOnClickListener(null);
        this.f10480e = null;
        this.f10481f.setOnClickListener(null);
        this.f10481f = null;
    }
}
