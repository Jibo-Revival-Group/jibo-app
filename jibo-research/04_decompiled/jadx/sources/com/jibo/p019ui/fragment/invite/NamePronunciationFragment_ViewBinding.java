package com.jibo.p019ui.fragment.invite;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class NamePronunciationFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private NamePronunciationFragment f10500b;

    public NamePronunciationFragment_ViewBinding(NamePronunciationFragment namePronunciationFragment, View view) {
        this.f10500b = namePronunciationFragment;
        namePronunciationFragment.mPhoneticNameView = (EditText) Utils.m5161b(view, R.id.phoneticName, "field 'mPhoneticNameView'", EditText.class);
        namePronunciationFragment.mPhoneticNameTip = (TextView) Utils.m5161b(view, R.id.phoneticNameTip, "field 'mPhoneticNameTip'", TextView.class);
        namePronunciationFragment.mTitleView = (TextView) Utils.m5161b(view, R.id.title, "field 'mTitleView'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        NamePronunciationFragment namePronunciationFragment = this.f10500b;
        if (namePronunciationFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10500b = null;
        namePronunciationFragment.mPhoneticNameView = null;
        namePronunciationFragment.mPhoneticNameTip = null;
        namePronunciationFragment.mTitleView = null;
    }
}
