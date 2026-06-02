package com.jibo.ui.fragment.onboarding;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.InputFilter.LengthFilter;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.amazonaws.services.cognitoidentity.model.InvalidParameterException;
import com.crashlytics.android.Crashlytics;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.util.DateTimeUtils;
import com.jibo.ui.activity.OnBoardingActivity;
import com.jibo.ui.fragment.AvatarBaseFragment;
import com.jibo.ui.fragment.dialog.DialogUtils;
import com.jibo.ui.fragment.dialog.MaterialDatePickerDialogFragment;
import com.jibo.ui.view.proxima.CustomFontEditText;
import com.jibo.utils.ImageUtils;
import java.util.Calendar;
import java.util.TimeZone;

public class AboutYouFragment extends AvatarBaseFragment implements MaterialDatePickerDialogFragment.OnDateChosenListener {
   public static final String n = AboutYouFragment.class.getSimpleName();
   @BindView
   ImageView avatarEditButton;
   @BindView
   TextView first_name;
   @BindView
   TextView last_name;
   @BindView
   TextView mBirthday;
   @BindView
   TextView mGender;
   private MenuItem o;
   private TextWatcher p = new TextWatcher(this) {
      final AboutYouFragment a;

      {
         this.a = var1;
      }

      public void afterTextChanged(Editable var1) {
      }

      public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
      }

      public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
         this.a.getActivity().invalidateOptionsMenu();
      }
   };

   private boolean t() {
      boolean var1;
      if (!TextUtils.isEmpty(this.first_name.getText().toString().trim())
         && !TextUtils.isEmpty(this.last_name.getText().toString().trim())
         && this.e.getGender() != null
         && this.e.getBirthday() != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private void u() {
      try {
         this.e();
         this.a(true);
         Account var1 = new Account();
         var1.setId(this.e.getId());
         var1.setFirstName(this.first_name.getText().toString().trim());
         var1.setLastName(this.last_name.getText().toString().trim());
         var1.setGender(this.e.getGender());
         var1.setBirthday(this.e.getBirthday());
         this.o.setEnabled(false);
         this.b(var1);
      } catch (InvalidParameterException var2) {
         this.getActivity().invalidateOptionsMenu();
      } catch (Exception var3) {
         ((OnBoardingActivity)this.getActivity()).l();
         Crashlytics.a(var3);
         this.getActivity().invalidateOptionsMenu();
      }
   }

   @Override
   public void a(int var1, int var2, Object var3) {
      super.a(var1, var2, var3);
      if (var1 == 108) {
         if (var2 == 0) {
            this.e.setGender(Account.Gender.male);
         } else if (var2 == 1) {
            this.e.setGender(Account.Gender.female);
         } else if (var2 == 2) {
            this.e.setGender(Account.Gender.other);
         } else if (var2 == 3) {
            this.e.setGender(Account.Gender.they);
         }

         this.mGender.setText(this.getResources().getStringArray(2130903043)[this.e.getGender().ordinal()]);
         this.getActivity().invalidateOptionsMenu();
      }
   }

   @Override
   public void a(long var1) {
      this.e.setBirthday(var1);
      Calendar.getInstance().setTimeInMillis(var1);
      this.mBirthday.setText(DateTimeUtils.getBirthdayString(this.e.getBirthday(), DateTimeUtils.FULL_DATE_FORMAT));
      this.getActivity().invalidateOptionsMenu();
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      this.l();
      var1.setDisplayHomeAsUpEnabled(false);
   }

   @Override
   protected void a(String var1) {
      super.a(var1);
      this.getActivity().invalidateOptionsMenu();
   }

   @OnClick
   public void birthdayClick() {
      MaterialDatePickerDialogFragment var3 = new MaterialDatePickerDialogFragment();
      Bundle var4 = new Bundle();
      Calendar var5 = Calendar.getInstance();
      var5.add(1, -18);
      long var1;
      if (this.e.getBirthday() != null && this.e.getBirthday() != -1L) {
         var1 = this.e.getBirthday();
      } else {
         var1 = var5.getTimeInMillis();
      }

      var4.putLong("ARGS_DATE", var1);
      var4.putString("ARGS_TITLE", this.getString(2131755768));
      var4.putString("ARGS_ERROR_TEXT", this.getString(2131755308));
      var5 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
      var5.add(1, -13);
      var5.add(6, 1);
      var4.putLong("ARGS_MAX_VALUE", var5.getTimeInMillis() - 86400000L);
      var3.setArguments(var4);
      var3.setTargetFragment(this, 0);
      var3.show(((AppCompatActivity)this.getContext()).getSupportFragmentManager(), "datePicker");
   }

   @OnClick
   public void changePicture(View var1) {
      this.onAvatarClick(var1);
   }

   @OnClick
   public void genderClick() {
      String var2 = this.getString(2131755479);
      int var1;
      if (this.e.getGender() != null) {
         var1 = this.e.getGender().ordinal();
      } else {
         var1 = -1;
      }

      DialogUtils.a(this, 108, var2, 2130903042, var1);
   }

   @Override
   protected String o() {
      return this.getString(2131756023);
   }

   @Override
   public void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      if (var1 == 69) {
         ((OnBoardingActivity)this.getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      }
   }

   @OnClick
   @Override
   public void onAvatarClick(View var1) {
      if (!this.c) {
         String var3 = this.getString(2131755770);
         int var2;
         if (this.d) {
            var2 = 2130903046;
         } else {
            var2 = 2130903045;
         }

         DialogUtils.a(this, 107, var3, var2);
      }
   }

   @Override
   public void onCreateOptionsMenu(Menu var1, MenuInflater var2) {
      var2.inflate(2131492871, var1);
      super.onCreateOptionsMenu(var1, var2);
      this.o = var1.findItem(2131296304);
      ImageUtils.a(this.getActivity(), var1);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427418, var2, false);
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem var1) {
      boolean var2;
      if (2131296304 == var1.getItemId()) {
         this.u();
         var2 = true;
      } else {
         var2 = super.onOptionsItemSelected(var1);
      }

      return var2;
   }

   @Override
   public void onPrepareOptionsMenu(Menu var1) {
      super.onPrepareOptionsMenu(var1);
      var1.findItem(2131296304).setEnabled(this.t());
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.setHasOptionsMenu(true);
      OnFocusChangeListener var3 = new OnFocusChangeListener(this) {
         final AboutYouFragment a;

         {
            this.a = var1;
         }

         public void onFocusChange(View var1, boolean var2x) {
            if (var2x) {
               ((EditText)var1).setSelection(((EditText)var1).getText().length());
            }
         }
      };
      this.first_name.setOnFocusChangeListener(var3);
      this.last_name.setOnFocusChangeListener(var3);
      this.first_name.setFilters(new InputFilter[]{new CustomFontEditText.NameInputFilter(), new LengthFilter(32)});
      this.last_name.setFilters(new InputFilter[]{new CustomFontEditText.NameInputFilter(), new LengthFilter(32)});
      this.first_name.addTextChangedListener(this.p);
      this.last_name.addTextChangedListener(this.p);
      if (this.e != null) {
         this.first_name.setText(this.e.getFirstName());
         this.last_name.setText(this.e.getLastName());
         if (this.e.getGender() != null) {
            this.mGender.setText(this.getResources().getStringArray(2130903043)[this.e.getGender().ordinal()]);
         }

         if (this.e.getBirthday() != null) {
            this.mBirthday.setText(DateTimeUtils.getBirthdayString(this.e.getBirthday(), DateTimeUtils.FULL_DATE_FORMAT));
         }

         this.a(this.e);
      }

      this.avatarEditButton.setVisibility(0);
   }
}
