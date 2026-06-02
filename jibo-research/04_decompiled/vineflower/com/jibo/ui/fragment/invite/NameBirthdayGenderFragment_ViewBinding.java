package com.jibo.ui.fragment.invite;

import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class NameBirthdayGenderFragment_ViewBinding implements Unbinder {
   private NameBirthdayGenderFragment b;
   private View c;
   private View d;
   private View e;
   private View f;

   public NameBirthdayGenderFragment_ViewBinding(NameBirthdayGenderFragment var1, View var2) {
      this.b = var1;
      var1.title = Utils.b(var2, 2131297019, "field 'title'", TextView.class);
      var1.firstName = Utils.b(var2, 2131296567, "field 'firstName'", AutoCompleteTextView.class);
      var1.lastName = Utils.b(var2, 2131296686, "field 'lastName'", AutoCompleteTextView.class);
      View var3 = Utils.a(var2, 2131296516, "field 'dateText' and method 'selectBirthday'");
      var1.dateText = Utils.c(var3, 2131296516, "field 'dateText'", TextView.class);
      this.c = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final NameBirthdayGenderFragment b;
         final NameBirthdayGenderFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.selectBirthday(var1);
         }
      });
      var1.birthdayTitle = Utils.b(var2, 2131296335, "field 'birthdayTitle'", TextView.class);
      var1.genderGroup = Utils.b(var2, 2131296577, "field 'genderGroup'", RadioGroup.class);
      var1.genderTitle = Utils.b(var2, 2131296578, "field 'genderTitle'", TextView.class);
      var1.radioMale = Utils.b(var2, 2131296822, "field 'radioMale'", RadioButton.class);
      var1.radioFemale = Utils.b(var2, 2131296821, "field 'radioFemale'", RadioButton.class);
      var1.radioOther = Utils.b(var2, 2131296823, "field 'radioOther'", RadioButton.class);
      var1.formNavigationPanel = Utils.a(var2, 2131296573, "field 'formNavigationPanel'");
      var3 = Utils.a(var2, 2131296384, "field 'btnPrev' and method 'onBtnPrevClick'");
      var1.btnPrev = Utils.c(var3, 2131296384, "field 'btnPrev'", ImageView.class);
      this.d = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final NameBirthdayGenderFragment b;
         final NameBirthdayGenderFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.onBtnPrevClick(var1);
         }
      });
      var3 = Utils.a(var2, 2131296376, "field 'btnNext' and method 'onBtnNextClick'");
      var1.btnNext = Utils.c(var3, 2131296376, "field 'btnNext'", ImageView.class);
      this.e = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final NameBirthdayGenderFragment b;
         final NameBirthdayGenderFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.onBtnNextClick(var1);
         }
      });
      var2 = Utils.a(var2, 2131296353, "method 'onBtnDoneClick'");
      this.f = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final NameBirthdayGenderFragment b;
         final NameBirthdayGenderFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.onBtnDoneClick(var1);
         }
      });
   }

   @Override
   public void unbind() {
      NameBirthdayGenderFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.title = null;
      var1.firstName = null;
      var1.lastName = null;
      var1.dateText = null;
      var1.birthdayTitle = null;
      var1.genderGroup = null;
      var1.genderTitle = null;
      var1.radioMale = null;
      var1.radioFemale = null;
      var1.radioOther = null;
      var1.formNavigationPanel = null;
      var1.btnPrev = null;
      var1.btnNext = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
      this.e.setOnClickListener(null);
      this.e = null;
      this.f.setOnClickListener(null);
      this.f = null;
   }
}
