package com.jibo.ui.fragment.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatDialog;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.ui.view.proxima.CustomFontEditText;

public class ChangeLoopNameDialog extends DialogFragment {
   Unbinder a;
   private Loop b;
   @BindView
   EditText nameEdit;
   @BindView
   TextView tipText;

   private String a() {
      return this.nameEdit.getText().toString().trim() + " Jibo";
   }

   @OnClick
   public void onCancelClicked(View var1) {
      this.dismiss();
   }

   @Override
   public Dialog onCreateDialog(Bundle var1) {
      if (var1 != null) {
         this.b = (Loop)var1.getParcelable(Loop.class.getSimpleName());
      } else if (this.getArguments() != null) {
         this.b = (Loop)this.getArguments().getParcelable(Loop.class.getSimpleName());
      }

      AppCompatDialog var3 = new AppCompatDialog(this.getActivity(), 16974132);
      View var2 = this.getActivity().getLayoutInflater().inflate(2131427399, null);
      this.a = ButterKnife.a(this, var2);
      var3.setContentView(var2);
      var3.setCancelable(true);
      this.tipText.setText(this.getString(2131755252, this.b.getName()));
      this.nameEdit.setText(this.b.getName().replace(" Jibo", ""));
      this.nameEdit.setFilters(new InputFilter[]{new CustomFontEditText.NameInputFilter()});
      return var3;
   }

   @Override
   public void onDestroyView() {
      super.onDestroyView();
      this.a.unbind();
   }

   @OnClick
   public void onSetClicked(View var1) {
      if (TextUtils.isEmpty(this.nameEdit.getText().toString().trim())) {
         Snackbar.a(var1, this.getString(2131755597), 0).c();
      } else if (this.a().length() > 27) {
         Snackbar.a(var1, this.getString(2131755737), 0).c();
      } else {
         if (this.getTargetFragment() != null && this.getTargetFragment() instanceof DialogUtils.DialogFragmentWrapperClickListener) {
            ((DialogUtils.DialogFragmentWrapperClickListener)this.getTargetFragment()).a(this.getTargetRequestCode(), var1.getId(), this.a());
         }

         this.dismiss();
      }
   }
}
