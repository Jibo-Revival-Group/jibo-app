package com.salesforce.android.knowledge.ui.internal.navigation;

import android.os.Bundle;
import com.salesforce.android.knowledge.ui.internal.ViewBinder;

public class ViewState {
   private final ViewBinder a;
   private final Bundle b;

   ViewState(ViewBinder var1, Bundle var2) {
      this.a = var1;
      this.b = var2;
   }

   public ViewBinder a() {
      return this.a;
   }

   public void b() {
      this.a.a(this.b);
   }

   public void c() {
      this.a.b(this.b);
   }
}
