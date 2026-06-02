package com.salesforce.android.knowledge.ui.internal;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public abstract class ViewBinder {
   public abstract View a(LayoutInflater var1, ViewGroup var2, Bundle var3);

   public void a(Bundle var1) {
   }

   public void a(Menu var1, MenuInflater var2) {
   }

   public boolean a(MenuItem var1) {
      return false;
   }

   public abstract void b();

   public void b(Bundle var1) {
   }

   public Toolbar d() {
      return null;
   }

   public int e() {
      return 17170443;
   }

   public boolean t_() {
      return false;
   }
}
