package com.jibo.ui.fragment.invite;

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
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnFocusChangeListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RadioGroup.OnCheckedChangeListener;
import butterknife.BindView;
import butterknife.OnClick;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.collision.JiboCollisionAsyncClient;
import com.jibo.aws.integration.aws.services.collision.model.CollisionCheckContainer;
import com.jibo.aws.integration.aws.services.collision.model.MatchRequest;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.util.DateTimeUtils;
import com.jibo.db.EntityData;
import com.jibo.ui.fragment.dialog.MaterialDatePickerDialogFragment;
import com.jibo.ui.view.proxima.CustomFontEditText;
import com.jibo.ui.view.proxima.ProximaHelper;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.LogUtils;
import com.jibo.utils.UIUtils;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class NameBirthdayGenderFragment extends BaseSuggestionFragment implements MaterialDatePickerDialogFragment.OnDateChosenListener {
   public static final String r = LogUtils.a(NameBirthdayGenderFragment.class);
   @BindView
   TextView birthdayTitle;
   @BindView
   ImageView btnNext;
   @BindView
   ImageView btnPrev;
   @BindView
   TextView dateText;
   @BindView
   AutoCompleteTextView firstName;
   @BindView
   View formNavigationPanel;
   @BindView
   RadioGroup genderGroup;
   @BindView
   TextView genderTitle;
   @BindView
   AutoCompleteTextView lastName;
   @BindView
   RadioButton radioFemale;
   @BindView
   RadioButton radioMale;
   @BindView
   RadioButton radioOther;
   final TextWatcher s;
   private JiboCollisionAsyncClient t;
   @BindView
   TextView title;
   private OnCheckedChangeListener u = new OnCheckedChangeListener(this) {
      final NameBirthdayGenderFragment a;

      {
         this.a = var1;
      }

      public void onCheckedChanged(RadioGroup var1, int var2) {
         String var4 = (String)this.a.genderGroup.findViewById(var2).getTag();
         this.a.c.setGender(Account.Gender.valueOf(var4));

         for (int var3 = 0; var3 < var1.getChildCount(); var3++) {
            if (var1.getChildAt(var3) instanceof RadioButton) {
               RadioButton var5 = (RadioButton)var1.getChildAt(var3);
               if (var5.getId() == var2) {
                  ProximaHelper.b(var5);
               } else {
                  ProximaHelper.a(var5);
               }
            }
         }

         this.a.s();
      }
   };
   private OnItemClickListener v;

   public NameBirthdayGenderFragment() {
      this.s = new TextWatcher(this) {
         final NameBirthdayGenderFragment a;

         {
            this.a = var1;
         }

         public void afterTextChanged(Editable var1) {
            this.a.r();
            this.a.s();
            if (var1.length() > 0) {
               this.a.genderTitle.setText(this.a.getString(2131756044, this.a.firstName.getText().toString()));
               this.a.birthdayTitle.setText(this.a.getString(2131756042, this.a.firstName.getText().toString()));
            } else {
               this.a.genderTitle.setText(this.a.getString(2131755479));
               this.a.birthdayTitle.setText(this.a.getString(2131755768));
            }
         }

         public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
         }

         public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
         }
      };
      this.v = new OnItemClickListener(this) {
         final NameBirthdayGenderFragment a;

         {
            this.a = var1;
         }

         public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
            BaseSuggestionFragment.EmailSuggestion var7 = ((BaseSuggestionFragment.EmailSuggestionsListAdapter)var1.getAdapter()).a(var3);
            String[] var6 = var7.b().split(" ");
            this.a.c.setFirstName(var6[0]);
            this.a.firstName.setText(var6[0]);
            if (var6.length > 1) {
               this.a.c.setLastName(var6[var6.length - 1]);
               this.a.lastName.setText(var6[var6.length - 1]);
            }

            this.a.c.setEmail(var7.a());
            if (var7.d() != null) {
               this.a.c.setBirthday(var7.e());
               this.a.dateText.setText(DateTimeUtils.getBirthdayString(var7.e(), DateTimeUtils.FULL_DATE_FORMAT));
            } else {
               this.a.c.setBirthday(null);
               this.a.dateText.setText(2131755507);
            }
         }
      };
   }

   private void a(Long var1) {
      if (var1 != null && this.dateText != null) {
         this.dateText.setText(DateTimeUtils.getBirthdayString(var1, DateTimeUtils.FULL_DATE_FORMAT));
      }
   }

   private void r() {
      this.c.setFirstName(this.firstName.getText().toString().trim());
      this.c.setLastName(this.lastName.getText().toString().trim());
   }

   private void s() {
      if (this.p != null) {
         boolean var1;
         if (!this.firstName.getText().toString().trim().isEmpty() && !this.lastName.getText().toString().trim().isEmpty()) {
            var1 = false;
         } else {
            var1 = true;
         }

         boolean var2;
         if (this.c.getBirthday() != null && this.c.getBirthday() != null) {
            var2 = true;
         } else {
            var2 = false;
         }

         if (!var1 && var2) {
            this.b(true);
         } else {
            this.b(false);
         }
      }
   }

   private void t() {
      this.genderGroup.setOnCheckedChangeListener(null);
      if (this.c.getGender() == null) {
         this.radioOther.setChecked(true);
      } else {
         switch (<unrepresentable>.a[this.c.getGender().ordinal()]) {
            case 1:
               this.radioMale.setChecked(true);
               break;
            case 2:
               this.radioFemale.setChecked(true);
               break;
            case 3:
               this.radioOther.setChecked(true);
         }
      }

      this.genderGroup.setOnCheckedChangeListener(this.u);
   }

   @Override
   public void a() {
      this.firstName.setText(this.c.getFirstName());
      this.firstName.setDropDownWidth(this.q);
      this.lastName.setText(this.c.getLastName());
      this.firstName.setFilters(new InputFilter[]{new CustomFontEditText.NameInputFilter(), new LengthFilter(32)});
      this.lastName.setFilters(new InputFilter[]{new CustomFontEditText.NameInputFilter(), new LengthFilter(32)});
      this.firstName.addTextChangedListener(this.s);
      this.lastName.addTextChangedListener(this.s);
      this.firstName.setOnItemClickListener(this.v);
      this.lastName.setOnItemClickListener(this.v);
      this.genderGroup.setOnCheckedChangeListener(this.u);
      if (this.c.getGender() == null) {
         this.c.setGender(Account.Gender.other);
      }

      if (this.b != null && this.b) {
         this.title.setText(2131755773);
      } else {
         this.title.setText(2131755858);
      }

      if (!TextUtils.isEmpty(this.c.getFirstName())) {
         this.birthdayTitle.setText(this.getString(2131756042, this.c.getFirstName()));
         this.genderTitle.setText(this.getString(2131756044, this.c.getFirstName()));
      } else {
         this.birthdayTitle.setText(2131755768);
         this.genderTitle.setText(2131755787);
      }

      this.a(this.c.getBirthday());
      this.t();
      this.s();
   }

   @Override
   public void a(long var1) {
      this.c.setBirthday(var1);
      this.a(this.c.getBirthday());
      this.s();
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      var1.setHomeAsUpIndicator(2131230814);
   }

   @Override
   public void b() {
      UIUtils.a(this.getActivity(), this.firstName);
      UIUtils.a(this.getActivity(), this.lastName);
      this.a(false);
      this.b(false);
      List var1 = LoopHelper.getMembersNicknames(this.k);
      this.t.match(var1, this.c.getFirstName(), new AsyncHandler<MatchRequest, CollisionCheckContainer>(this) {
         final NameBirthdayGenderFragment a;

         {
            this.a = var1;
         }

         public void a(MatchRequest var1, CollisionCheckContainer var2) {
            this.a.a(new Runnable(this, var2) {
               final CollisionCheckContainer a;
               final <unrepresentable> b;

               {
                  this.b = var1;
                  this.a = var2x;
               }

               @Override
               public void run() {
                  this.b.a.g();
                  this.b.a.b(true);
                  if (!this.a.getCollision()) {
                     Bundle var1x = new Bundle();
                     var1x.putString("ARG_NICKNAME", this.b.a.c.getFirstName());
                     this.b.a.a(PreferredNameFragment.class, var1x);
                  } else {
                     this.b.a.a(PreferredNameFragment.class);
                  }
               }
            });
         }

         @Override
         public void onError(Exception var1) {
            this.a.a(var1, "collision match", false);
            this.a.a(new Runnable(this) {
               final <unrepresentable> a;

               {
                  this.a = var1;
               }

               @Override
               public void run() {
                  this.a.a.b(true);
               }
            });
         }
      });
   }

   @Override
   protected String o() {
      String var1;
      if (this.b != null && this.b) {
         var1 = this.getString(2131755382);
         if (this.m != null) {
            if (LoopHelper.isOwner(this.k, this.m.getAccountId())) {
               var1 = this.getString(2131756080);
            } else {
               var1 = this.getString(2131756058, this.m.getAccount().getFirstName());
            }
         }
      } else {
         var1 = this.getString(2131755382);
      }

      return var1;
   }

   @OnClick
   public void onBtnDoneClick(View var1) {
      ((View)this.lastName.getParent().getParent()).requestFocus();
      this.e();
   }

   @OnClick
   public void onBtnNextClick(View var1) {
      this.lastName.requestFocusFromTouch();
      this.btnPrev.setEnabled(true);
      this.btnNext.setEnabled(false);
   }

   @OnClick
   public void onBtnPrevClick(View var1) {
      this.firstName.requestFocusFromTouch();
      this.btnNext.setEnabled(true);
      this.btnPrev.setEnabled(false);
   }

   @Override
   public void onCreateOptionsMenu(Menu var1, MenuInflater var2) {
      super.onCreateOptionsMenu(var1, var2);
      this.s();
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427452, var2, false);
   }

   @Override
   public void onResume() {
      super.onResume();
      this.a.a = false;
      this.firstName.setAdapter(this.a);
      this.lastName.setAdapter(this.a);
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      Account var3 = EntityData.a(this.getActivity()).i();
      if (var3 != null) {
         JiboCollisionAsyncClient var4 = new JiboCollisionAsyncClient(new BasicAWSCredentials(var3.getAccessKeyId(), var3.getSecretAccessKey()));
         this.t = var4;
         this.a(var4);
      }

      var1.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
         final NameBirthdayGenderFragment a;
         private int b;

         {
            this.a = var1;
         }

         public void onGlobalLayout() {
            if (this.a.getView() != null && this.a.getView().getRootView() != null) {
               int var1x = this.a.getView().getRootView().getHeight() - this.a.getView().getHeight();
               if (this.b != var1x) {
                  if (var1x > this.a.getResources().getDisplayMetrics().heightPixels / 2) {
                     this.a.formNavigationPanel.setVisibility(0);
                  } else {
                     this.a.formNavigationPanel.setVisibility(8);
                  }
               }

               this.b = var1x;
            }
         }
      });
      this.btnNext.setImageDrawable(ImageUtils.b(this.getActivity(), 2131231006, 2131099690));
      this.btnPrev.setImageDrawable(ImageUtils.b(this.getActivity(), 2131231006, 2131099690));
      this.firstName.setOnFocusChangeListener(new OnFocusChangeListener(this) {
         final NameBirthdayGenderFragment a;

         {
            this.a = var1;
         }

         public void onFocusChange(View var1, boolean var2x) {
            if (var2x) {
               this.a.btnPrev.setEnabled(false);
               this.a.btnNext.setEnabled(true);
            }
         }
      });
      this.lastName.setOnFocusChangeListener(new OnFocusChangeListener(this) {
         final NameBirthdayGenderFragment a;

         {
            this.a = var1;
         }

         public void onFocusChange(View var1, boolean var2) {
            if (var2) {
               this.a.btnNext.setEnabled(false);
               this.a.btnPrev.setEnabled(true);
            }
         }
      });
   }

   @OnClick
   public void selectBirthday(View var1) {
      this.onBtnDoneClick(null);
      MaterialDatePickerDialogFragment var6 = new MaterialDatePickerDialogFragment();
      Bundle var4 = new Bundle();
      Calendar var5 = Calendar.getInstance();
      var5.add(1, -18);
      long var2;
      if (this.c.getBirthday() != null) {
         var2 = this.c.getBirthday();
      } else {
         var2 = var5.getTimeInMillis();
      }

      var4.putLong("ARGS_DATE", var2);
      var4.putString("ARGS_TITLE", this.getString(2131755768));
      var5 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
      var5.add(1, -13);
      var5.add(6, 1);
      if (this.b != null) {
         if (this.b) {
            var4.putString("ARGS_ERROR_TEXT", this.getString(2131755300));
            var4.putLong("ARGS_MIN_VALUE", var5.getTimeInMillis());
         } else {
            var4.putString("ARGS_ERROR_TEXT", this.getString(2131755298));
            var4.putLong("ARGS_MAX_VALUE", var5.getTimeInMillis() - 86400000L);
         }
      }

      var6.setArguments(var4);
      var6.setTargetFragment(this, 0);
      var6.show(((AppCompatActivity)this.getContext()).getSupportFragmentManager(), "datePicker");
   }
}
