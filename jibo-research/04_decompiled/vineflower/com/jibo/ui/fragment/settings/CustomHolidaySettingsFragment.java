package com.jibo.ui.fragment.settings;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import butterknife.BindView;
import butterknife.OnClick;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.person.JiboPersonAsyncClient;
import com.jibo.aws.integration.aws.services.person.model.Holiday;
import com.jibo.aws.integration.aws.services.person.model.SetLoopPropertyRequest;
import com.jibo.aws.integration.util.DateTimeUtils;
import com.jibo.db.EntityData;
import com.jibo.ui.fragment.BaseFragment;
import com.jibo.ui.view.proxima.CustomFontAutoCompleteTextView;
import com.jibo.ui.view.proxima.CustomFontTextView;
import com.jibo.utils.CustomHolidaysUtils;
import com.jibo.utils.ImageUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class CustomHolidaySettingsFragment extends BaseFragment implements OnDateSetListener {
   private static final String b = CustomHolidaySettingsFragment.class.getSimpleName();
   final TextWatcher a;
   private MenuItem c;
   private List<Holiday> d;
   @BindView
   CustomFontTextView date;
   private int e;
   @BindView
   CustomFontAutoCompleteTextView holidayName;
   private String l;
   private Long m;
   private Account n;
   private JiboPersonAsyncClient o;
   private Boolean p = false;

   public CustomHolidaySettingsFragment() {
      this.a = new TextWatcher(this) {
         final CustomHolidaySettingsFragment a;

         {
            this.a = var1;
         }

         public void afterTextChanged(Editable var1) {
            this.a.s();
         }

         public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
         }

         public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
         }
      };
   }

   private void a() {
      this.n = EntityData.a(this.getActivity()).i();
      this.o = new JiboPersonAsyncClient(new BasicAWSCredentials(this.n.getAccessKeyId(), this.n.getSecretAccessKey()));
      this.a(this.o);
   }

   private void b() {
      ((View)this.holidayName.getParent()).requestFocus();
      this.e();
   }

   private void b(boolean var1) {
      if (this.c != null) {
         this.c.setEnabled(var1);
         FragmentActivity var4 = this.getActivity();
         MenuItem var3 = this.c;
         int var2;
         if (this.c.isEnabled()) {
            var2 = 2131099871;
         } else {
            var2 = 2131099701;
         }

         ImageUtils.a(var4, var3, var2);
      }
   }

   private void q() {
      if (this.l != null) {
         this.holidayName.setText(this.l);
      }
   }

   private void r() {
      if (this.m != null) {
         this.date.setText(DateTimeUtils.getBirthdayString(this.m, "MMMM, d, yyyy"));
      }
   }

   private void s() {
      boolean var2 = true;
      boolean var3 = TextUtils.isEmpty(this.holidayName.getText().toString());
      boolean var1;
      if (this.m == null) {
         var1 = true;
      } else {
         var1 = false;
      }

      if (var3 || var1) {
         var2 = false;
      }

      this.b(var2);
   }

   private void t() {
      this.b();
      this.f();
      this.u();
   }

   private void u() {
      if (this.e == -1) {
         Holiday var1 = CustomHolidaysUtils.a(this.holidayName.getText().toString(), this.k.getId(), this.n.getId(), this.m);
         this.d.add(var1);
      } else {
         Holiday var2 = this.d.get(this.e);
         var2.setName(this.holidayName.getText().toString());
         var2.setDate(DateTimeUtils.getBirthdayString(this.m, "yyyy-MM-dd"));
      }

      this.v();
   }

   private void v() {
      if (this.o != null && this.k != null) {
         this.o
            .setLoopProperty(this.k.getId(), "customHolidays", CustomHolidaysUtils.a(this.d), new AsyncHandler<SetLoopPropertyRequest, CommandResponse>(this) {
               final CustomHolidaySettingsFragment a;

               {
                  this.a = var1;
               }

               public void a(SetLoopPropertyRequest var1, CommandResponse var2) {
                  if (this.a.d()) {
                     this.a.a(new Runnable(this) {
                        final <unrepresentable> a;

                        {
                           this.a = var1;
                        }

                        @Override
                        public void run() {
                           this.a.a.g();
                           this.a.a.getActivity().getSupportFragmentManager().c();
                        }
                     });
                  } else {
                     this.a.p = true;
                  }
               }

               @Override
               public void onError(Exception var1) {
                  this.a.a(var1, "create custom holidays", true);
               }
            });
      }
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      var1.setDisplayHomeAsUpEnabled(true);
      var1.setHomeButtonEnabled(true);
      this.n();
   }

   @Override
   public void b(Bundle var1) {
      super.b(var1);
      if (var1.containsKey("args_custom_holidays")) {
         this.d = (List<Holiday>)var1.getSerializable("args_custom_holidays");
      }

      this.e = var1.getInt("args_custom_holidays_pos", -1);
      if (this.e < 0 || this.e >= this.d.size()) {
         this.e = -1;
      }

      if (this.e != -1) {
         this.l = this.d.get(this.e).getName();
      }

      if (var1.containsKey("args_millis")) {
         this.m = var1.getLong("args_millis");
      } else if (this.e != -1) {
         this.m = CustomHolidaysUtils.a(this.d.get(this.e).getDate());
      }
   }

   @Override
   protected String o() {
      return this.getString(2131755778);
   }

   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setHasOptionsMenu(true);
   }

   @Override
   public void onCreateOptionsMenu(Menu var1, MenuInflater var2) {
      var2.inflate(2131492867, var1);
      super.onCreateOptionsMenu(var1, var2);
      ImageUtils.a(this.getActivity(), var1);
      this.c = var1.findItem(2131296294);
      this.s();
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427431, var2, false);
   }

   public void onDateSet(DatePicker var1, int var2, int var3, int var4) {
      Calendar var5 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
      var5.set(1, var2);
      var5.set(2, var3);
      var5.set(5, var4);
      this.m = var5.getTimeInMillis();
      this.r();
      this.s();
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem var1) {
      boolean var2;
      if (2131296294 == var1.getItemId()) {
         this.t();
         var2 = true;
      } else {
         var2 = super.onOptionsItemSelected(var1);
      }

      return var2;
   }

   @Override
   public void onResume() {
      super.onResume();
      if (this.p) {
         this.g();
         this.getActivity().getSupportFragmentManager().c();
      }
   }

   @Override
   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      if (this.m != null) {
         var1.putLong("args_millis", this.m);
      }
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.a();
      if (this.d == null) {
         this.d = new ArrayList<>();
      }

      this.q();
      this.r();
      this.s();
      this.holidayName.addTextChangedListener(this.a);
   }

   @OnClick
   public void selectDate(View var1) {
      this.b();
      Calendar var2 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
      if (this.m != null) {
         var2.setTimeInMillis(this.m);
      }

      new DatePickerDialog(this.getContext(), this, var2.get(1), var2.get(2), var2.get(5)).show();
   }
}
