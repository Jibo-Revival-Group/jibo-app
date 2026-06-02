package com.salesforce.android.service.common.ui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.salesforce.android.service.common.ui.R;
import com.salesforce.android.service.common.ui.internal.utils.ViewGroupHelper;

public class SalesforcePickListView extends LinearLayout {
   private TextView a;
   private Spinner b;

   public SalesforcePickListView(Context var1) {
      this(var1, null);
   }

   public SalesforcePickListView(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public SalesforcePickListView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.a(var1, var2, var3);
   }

   private void a(Context var1, AttributeSet var2, int var3) {
      this.setOrientation(1);
      this.setMinimumHeight(var1.getResources().getDimensionPixelSize(R.dimen.salesforce_input_minimum_height));
      this.setAddStatesFromChildren(true);
      LayoutInflater.from(var1).inflate(R.layout.salesforce_pick_list_view, this, true);
      this.a = (TextView)this.findViewById(R.id.pick_list_label);
      this.b = (Spinner)this.findViewById(R.id.pick_list_spinner);
      this.b.setFocusableInTouchMode(true);
      this.b.setFocusable(true);
      ((ViewGroup)this.findViewById(R.id.pick_list_spinner_frame)).setAddStatesFromChildren(true);
      TypedArray var4 = var1.getTheme().obtainStyledAttributes(var2, R.styleable.SalesforcePickListView, var3, 0);
      CharSequence var5 = var4.getText(R.styleable.SalesforcePickListView_salesforce_label);
      if (!TextUtils.isEmpty(var5)) {
         this.setLabel(var5);
      }

      var4.recycle();
   }

   public boolean dispatchTouchEvent(MotionEvent var1) {
      this.b.dispatchTouchEvent(var1);
      return true;
   }

   public TextView getLabelView() {
      return this.a;
   }

   public int getSelectedItemPosition() {
      return this.b.getSelectedItemPosition();
   }

   public Spinner getSpinner() {
      return this.b;
   }

   public void setAdapter(SpinnerAdapter var1) {
      this.b.setAdapter(var1);
   }

   public void setEnabled(boolean var1) {
      ViewGroupHelper.a(this, var1);
      super.setEnabled(var1);
   }

   public void setId(int var1) {
      this.b.setId(var1);
   }

   public void setLabel(int var1) {
      this.a.setText(var1);
   }

   public void setLabel(CharSequence var1) {
      this.a.setText(var1);
   }

   public void setOnItemSelectedListener(OnItemSelectedListener var1) {
      this.b.setOnItemSelectedListener(var1);
   }

   public void setSelection(int var1) {
      this.b.setSelection(var1);
   }
}
