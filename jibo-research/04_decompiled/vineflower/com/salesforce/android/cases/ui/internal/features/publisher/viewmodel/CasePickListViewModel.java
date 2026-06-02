package com.salesforce.android.cases.ui.internal.features.publisher.viewmodel;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemSelectedListener;
import com.salesforce.android.cases.R;
import com.salesforce.android.cases.core.internal.util.StringUtils;
import com.salesforce.android.cases.core.model.CaseField;
import com.salesforce.android.cases.core.model.CaseFieldType;
import com.salesforce.android.cases.core.model.PickListOption;
import com.salesforce.android.cases.ui.internal.utils.ViewUtils;
import com.salesforce.android.service.common.ui.views.SalesforcePickListView;

public class CasePickListViewModel implements OnItemSelectedListener, CaseFieldViewModel<SalesforcePickListView> {
   private SalesforcePickListView a;
   private ArrayAdapter<? extends PickListOption> b;
   private CaseField c;
   private int d;
   private boolean e;

   public CasePickListViewModel(SalesforcePickListView var1, CaseField var2) {
      int var3 = 0;
      super();
      this.d = 0;
      if (var2.f() != CaseFieldType.PICK_LIST) {
         throw new IllegalArgumentException("CaseField must be of type CaseFieldType.PICK_LIST.");
      }

      this.a = var1;
      this.c = var2;
      var1.setId(var2.a().hashCode());
      String var5 = var2.b();
      String var4 = var5;
      if (var2.d()) {
         var4 = var5 + "*";
      }

      var1.setLabel(var4);
      this.b = new ArrayAdapter(var1.getContext(), R.layout.pick_list_item, var2.c());
      this.b.setDropDownViewResource(R.layout.pick_list_drop_down_item);
      var1.setAdapter(this.b);
      var4 = var2.h();
      if (StringUtils.b(var4)) {
         while (var3 < var2.c().size()) {
            if (var4.equalsIgnoreCase(var2.c().get(var3).b())) {
               var1.setSelection(var3);
               this.d = var3;
               break;
            }

            var3++;
         }
      }

      var1.setOnItemSelectedListener(this);
   }

   @Override
   public boolean b() {
      return this.a.isFocused();
   }

   @Override
   public void c() {
      ViewUtils.d(this.a);
   }

   @Override
   public CaseField d() {
      return this.c;
   }

   @Override
   public boolean e() {
      return true;
   }

   @Override
   public String f() {
      PickListOption var1 = (PickListOption)this.b.getItem(this.a.getSelectedItemPosition());
      String var2;
      if (var1 != null) {
         var2 = var1.b();
      } else {
         var2 = "";
      }

      return var2;
   }

   @Override
   public boolean g() {
      return this.e;
   }

   public SalesforcePickListView h() {
      return this.a;
   }

   public void onItemSelected(AdapterView<?> var1, View var2, int var3, long var4) {
      if (this.d != var3) {
         this.e = true;
      }

      this.d = var3;
   }

   public void onNothingSelected(AdapterView<?> var1) {
   }
}
