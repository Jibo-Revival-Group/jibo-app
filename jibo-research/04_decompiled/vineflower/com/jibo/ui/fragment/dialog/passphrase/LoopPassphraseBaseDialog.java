package com.jibo.ui.fragment.dialog.passphrase;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.jibo.ui.fragment.dialog.BaseDialogFragment;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.UIUtils;

public class LoopPassphraseBaseDialog extends BaseDialogFragment {
   public static final String d = LoopPassphraseBaseDialog.class.getSimpleName();
   @BindView
   TextView btnCancel;
   @BindView
   TextView btnSet;
   protected String e;
   protected TextWatcher f = new TextWatcher(this) {
      final LoopPassphraseBaseDialog a;

      {
         this.a = var1;
      }

      public void afterTextChanged(Editable var1) {
      }

      public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
      }

      public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
         this.a.getActivity().invalidateOptionsMenu();
         UIUtils.b(this.a.passphraseEdit.getText().toString(), this.a.footer, ImageUtils.b(this.a.getContext(), 2131099679));
         this.a.btnSet.setEnabled(UIUtils.a(this.a.passphraseEdit.getText().toString()));
      }
   };
   @BindView
   TextView footer;
   @BindView
   EditText passphraseEdit;
   @BindView
   TextView text;
   @BindView
   TextView title;

   public Dialog a(Bundle var1, int var2) {
      AppCompatDialog var3 = new AppCompatDialog(this.getActivity(), 16974132);
      this.b = this.getActivity().getLayoutInflater().inflate(var2, null);
      ButterKnife.a(this, this.b);
      this.passphraseEdit.addTextChangedListener(this.f);
      UIUtils.b(this.passphraseEdit.getText().toString(), this.footer, ImageUtils.b(this.getContext(), 2131099679));
      this.btnSet.setEnabled(UIUtils.a(this.passphraseEdit.getText().toString()));
      var3.setContentView(this.b);
      this.setCancelable(true);
      return var3;
   }

   @Override
   public void a(Bundle var1) {
      super.a(var1);
      this.e = this.getArguments().getString("ARGS_DIALOG_TYPE", "");
   }

   @Override
   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.putString("ARGS_DIALOG_TYPE", this.e);
   }
}
