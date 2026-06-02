package com.jibo.p019ui.fragment.dialog.passphrase;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class LoopPassphraseBaseDialog_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private LoopPassphraseBaseDialog f10282b;

    public LoopPassphraseBaseDialog_ViewBinding(LoopPassphraseBaseDialog loopPassphraseBaseDialog, View view) {
        this.f10282b = loopPassphraseBaseDialog;
        loopPassphraseBaseDialog.passphraseEdit = (EditText) Utils.m5159a(view, R.id.text_input, "field 'passphraseEdit'", EditText.class);
        loopPassphraseBaseDialog.text = (TextView) Utils.m5161b(view, android.R.id.text1, "field 'text'", TextView.class);
        loopPassphraseBaseDialog.title = (TextView) Utils.m5161b(view, android.R.id.title, "field 'title'", TextView.class);
        loopPassphraseBaseDialog.footer = (TextView) Utils.m5159a(view, R.id.footer, "field 'footer'", TextView.class);
        loopPassphraseBaseDialog.btnSet = (TextView) Utils.m5161b(view, R.id.btnSet, "field 'btnSet'", TextView.class);
        loopPassphraseBaseDialog.btnCancel = (TextView) Utils.m5161b(view, R.id.btnCancel, "field 'btnCancel'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LoopPassphraseBaseDialog loopPassphraseBaseDialog = this.f10282b;
        if (loopPassphraseBaseDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10282b = null;
        loopPassphraseBaseDialog.passphraseEdit = null;
        loopPassphraseBaseDialog.text = null;
        loopPassphraseBaseDialog.title = null;
        loopPassphraseBaseDialog.footer = null;
        loopPassphraseBaseDialog.btnSet = null;
        loopPassphraseBaseDialog.btnCancel = null;
    }
}
