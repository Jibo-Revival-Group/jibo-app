package com.jibo.ui.fragment.dialog.skills;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.view.ContextThemeWrapper;
import android.view.View;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.google.gson.Gson;
import com.jibo.ui.activity.OnBoardingActivity;
import com.jibo.ui.helpers.skills.DataItems;
import com.jibo.ui.helpers.skills.SkillsJsonParser;

public class MaterialTimePickerDialogFragment extends DialogFragment {
   Unbinder a;
   private DataItems.TimeDataItem b;
   private DataItems.TimeDataValue c;
   @BindView
   TimePicker simpleTimePicker;

   @OnClick
   public void onCancelClick(View var1) {
      this.dismiss();
   }

   @Override
   public Dialog onCreateDialog(Bundle var1) {
      Dialog var4;
      if (var1 != null && var1.getBoolean("ARGS_SKILL_FRAGMENT", false) && !SkillsJsonParser.isCreated()) {
         Intent var5 = new Intent(this.getContext(), OnBoardingActivity.class);
         var5.setFlags(67108864);
         this.getContext().startActivity(var5);
         var4 = new Dialog(this.getContext());
      } else {
         AlertDialog.Builder var2 = new AlertDialog.Builder(new ContextThemeWrapper(this.getActivity(), 2131820824));
         View var3 = this.getActivity().getLayoutInflater().inflate(2131427413, null);
         this.a = ButterKnife.a(this, var3);
         if (var1 != null) {
            this.b = new Gson().a(var1.getString(DataItems.TimeDataItem.class.getSimpleName()), DataItems.TimeDataItem.class);
         }

         if (this.getArguments() != null) {
            this.b = new Gson().a(this.getArguments().getString(DataItems.TimeDataItem.class.getSimpleName()), DataItems.TimeDataItem.class);
         }

         if (this.b != null) {
            SkillsJsonParser.getInstance().setItemDataValue(this.b);
            this.c = (DataItems.TimeDataValue)this.b.getDataValue();
         } else {
            this.c = new DataItems.TimeDataValue(0, 0);
         }

         if (this.c == null) {
            this.c = new DataItems.TimeDataValue(0, 0);
         }

         this.simpleTimePicker.setIs24HourView(true);
         if (VERSION.SDK_INT >= 23) {
            this.simpleTimePicker.setHour(this.c.getHour());
            this.simpleTimePicker.setMinute(this.c.getMin());
         } else {
            this.simpleTimePicker.setCurrentHour(this.c.getHour());
            this.simpleTimePicker.setCurrentMinute(this.c.getMin());
         }

         this.simpleTimePicker.setOnTimeChangedListener(new OnTimeChangedListener(this) {
            final MaterialTimePickerDialogFragment a;

            {
               this.a = var1;
            }

            public void onTimeChanged(TimePicker var1, int var2x, int var3x) {
               this.a.c.setTime(var2x, var3x);
            }
         });
         var2.b(var3);
         var4 = var2.b();
      }

      return var4;
   }

   @Override
   public void onDestroyView() {
      super.onDestroyView();
      if (this.a != null) {
         this.a.unbind();
      }
   }

   @Override
   public void onSaveInstanceState(Bundle var1) {
      var1.putString(DataItems.TimeDataItem.class.getSimpleName(), new Gson().b(this.b));
      var1.putBoolean("ARGS_SKILL_FRAGMENT", this.getArguments().getBoolean("ARGS_SKILL_FRAGMENT"));
   }

   @OnClick
   public void onSetClick(View var1) {
      if (this.getTargetFragment() != null && this.getTargetFragment() instanceof MaterialTimePickerDialogFragment.DataChangedListener) {
         ((MaterialTimePickerDialogFragment.DataChangedListener)this.getTargetFragment()).a(this.b, this.c);
      }

      this.dismiss();
   }

   public interface DataChangedListener {
      void a(DataItems.DataItem var1, DataItems.DataValue var2);
   }
}
