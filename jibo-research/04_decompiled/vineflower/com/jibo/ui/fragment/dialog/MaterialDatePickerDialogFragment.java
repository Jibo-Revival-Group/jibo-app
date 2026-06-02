package com.jibo.ui.fragment.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.view.ContextThemeWrapper;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.DatePicker.OnDateChangedListener;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.jibo.utils.ImageUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class MaterialDatePickerDialogFragment extends DialogFragment {
   Unbinder a;
   private Calendar b;
   private SimpleDateFormat c;
   private String d;
   @BindView
   DatePicker datePicker;
   private String e;
   private Long f = null;
   private Long g = null;
   private Long h = null;
   @BindView
   TextView textDayOfMonth;
   @BindView
   TextView textMonthYear;
   @BindView
   TextView textTitle;

   private long a(long var1) {
      Calendar var3 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
      var3.setTimeInMillis(var1);
      var3.set(11, 0);
      var3.set(12, 0);
      var3.set(14, 0);
      var3.set(13, 0);
      return var3.getTimeInMillis();
   }

   private boolean a() {
      boolean var1 = false;
      if (this.g == null || this.g >= this.b.getTimeInMillis() && (this.h == null || this.h <= this.b.getTimeInMillis())) {
         var1 = true;
      }

      return var1;
   }

   private void b() {
      this.textDayOfMonth.setText(String.valueOf(this.b.get(5)));
      this.textMonthYear.setText(this.c.format(this.b.getTime()).toUpperCase());
   }

   @OnClick
   public void onCancelClick(View var1) {
      this.dismiss();
   }

   @Override
   public Dialog onCreateDialog(Bundle var1) {
      Object var4 = null;
      AlertDialog.Builder var5 = new AlertDialog.Builder(new ContextThemeWrapper(this.getActivity(), 2131820824));
      View var6 = this.getActivity().getLayoutInflater().inflate(2131427412, null);
      this.a = ButterKnife.a(this, var6);
      this.f = System.currentTimeMillis();
      if (this.getArguments() != null) {
         long var2;
         if (this.getArguments().containsKey("ARGS_DATE")) {
            var2 = this.getArguments().getLong("ARGS_DATE");
         } else {
            var2 = this.f;
         }

         this.f = var2;
         Long var7;
         if (this.getArguments().containsKey("ARGS_MAX_VALUE")) {
            var7 = this.getArguments().getLong("ARGS_MAX_VALUE");
         } else {
            var7 = null;
         }

         this.g = var7;
         Long var8;
         if (this.getArguments().containsKey("ARGS_MIN_VALUE")) {
            var8 = this.getArguments().getLong("ARGS_MIN_VALUE");
         } else {
            var8 = null;
         }

         this.h = var8;
         if (this.h != null) {
            Long var9;
            if (this.g == null) {
               var9 = System.currentTimeMillis();
            } else {
               var9 = null;
            }

            this.g = var9;
            this.h = this.a(this.h);
         }

         Long var10 = (Long)var4;
         if (this.g != null) {
            var10 = this.a(this.g);
         }

         this.g = var10;
         this.d = this.getArguments().getString("ARGS_TITLE");
         this.e = this.getArguments().getString("ARGS_ERROR_TEXT");
      }

      this.f = this.a(this.f);
      this.b = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
      this.b.setTimeInMillis(this.f);
      if (!TextUtils.isEmpty(this.d)) {
         this.textTitle.setText(this.d);
      }

      this.datePicker.setMaxDate(System.currentTimeMillis());
      this.datePicker.init(this.b.get(1), this.b.get(2), this.b.get(5), new OnDateChangedListener(this) {
         final MaterialDatePickerDialogFragment a;

         {
            this.a = var1;
         }

         public void onDateChanged(DatePicker var1, int var2, int var3, int var4x) {
            this.a.b.set(5, var4x);
            this.a.b.set(2, var3);
            this.a.b.set(1, var2);
            this.a.b();
         }
      });
      this.c = new SimpleDateFormat("MMMM, yyyy");
      this.c.setTimeZone(TimeZone.getTimeZone("GMT"));
      this.b();
      var5.b(var6);
      return var5.b();
   }

   @Override
   public void onDestroyView() {
      super.onDestroyView();
      this.a.unbind();
   }

   @OnClick
   public void onSetClick(View var1) {
      if (!this.a()) {
         this.textTitle.setText(this.e);
         this.textTitle.setBackgroundColor(ImageUtils.b(this.getActivity(), 2131099764));
      } else {
         if (this.getTargetFragment() != null && this.getTargetFragment() instanceof MaterialDatePickerDialogFragment.OnDateChosenListener) {
            ((MaterialDatePickerDialogFragment.OnDateChosenListener)this.getTargetFragment()).a(this.b.getTimeInMillis());
         }

         this.dismiss();
      }
   }

   public interface OnDateChosenListener {
      void a(long var1);
   }
}
