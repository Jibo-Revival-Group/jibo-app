package com.jibo.p019ui.fragment.phone;

import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class PhoneFillFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private PhoneFillFragment f10845b;

    /* JADX INFO: renamed from: c */
    private View f10846c;

    public PhoneFillFragment_ViewBinding(final PhoneFillFragment phoneFillFragment, View view) {
        this.f10845b = phoneFillFragment;
        phoneFillFragment.phone = (EditText) Utils.m5161b(view, R.id.phone, "field 'phone'", EditText.class);
        View viewM5158a = Utils.m5158a(view, R.id.btnNext, "field 'btnNext' and method 'onNext'");
        phoneFillFragment.btnNext = viewM5158a;
        this.f10846c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.phone.PhoneFillFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                phoneFillFragment.onNext(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        PhoneFillFragment phoneFillFragment = this.f10845b;
        if (phoneFillFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10845b = null;
        phoneFillFragment.phone = null;
        phoneFillFragment.btnNext = null;
        this.f10846c.setOnClickListener(null);
        this.f10846c = null;
    }
}
