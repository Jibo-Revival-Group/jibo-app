package com.salesforce.android.cases.ui.internal.features.caselist.viewmodel;

import android.content.Context;
import android.text.format.DateUtils;
import com.salesforce.android.cases.R;
import com.salesforce.android.cases.core.model.CaseListRecord;
import java.util.Date;

public class CaseListItemViewModel {
   private Context a;
   private CaseListRecord b;
   private boolean c;
   private String d;
   private String e;
   private String f;
   private Date g;

   public CaseListItemViewModel(Context var1, CaseListRecord var2) {
      if (var1 == null) {
         throw new IllegalArgumentException("Context cannot be null.");
      }

      if (var2 == null) {
         throw new IllegalArgumentException("CaseListRecord cannot be null.");
      }

      this.a = var1;
      this.b = var2;
      this.c = var2.e();
      this.d = var2.b();
      String var3;
      if (var2.a() != null) {
         var3 = var2.a();
      } else {
         var3 = var2.c();
      }

      this.e = var3;
      this.g = var2.d();
      if (var2.g() != null) {
         this.f = var2.g().a();
      }
   }

   public CaseListRecord a() {
      return this.b;
   }

   public void a(boolean var1) {
      this.b.a(var1);
      this.c = var1;
   }

   public boolean b() {
      return this.c;
   }

   public String c() {
      return this.d;
   }

   public String d() {
      String var5;
      if (this.g == null) {
         var5 = null;
      } else {
         long var3 = this.g.getTime();
         long var1 = System.currentTimeMillis();
         if (var1 - var3 <= 60000L) {
            var5 = this.a.getString(R.string.cases_timestamp_just_now_text);
         } else {
            var5 = DateUtils.getRelativeTimeSpanString(var3, var1, 60000L).toString();
         }
      }

      return var5;
   }

   public String e() {
      return this.e;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var4 = true;
      boolean var3 = false;
      boolean var2;
      if (this == var1) {
         var2 = true;
      } else {
         var2 = var3;
         if (var1 != null) {
            var2 = var3;
            if (this.getClass() == var1.getClass()) {
               var1 = var1;
               var2 = var3;
               if (this.c == var1.c) {
                  if (this.b != null) {
                     var2 = var3;
                     if (!this.b.equals(var1.b)) {
                        return var2;
                     }
                  } else if (var1.b != null) {
                     var2 = var3;
                     return var2;
                  }

                  if (this.d != null) {
                     var2 = var3;
                     if (!this.d.equals(var1.d)) {
                        return var2;
                     }
                  } else if (var1.d != null) {
                     var2 = var3;
                     return var2;
                  }

                  if (this.e != null) {
                     var2 = var3;
                     if (!this.e.equals(var1.e)) {
                        return var2;
                     }
                  } else if (var1.e != null) {
                     var2 = var3;
                     return var2;
                  }

                  if (this.f != null) {
                     var2 = var3;
                     if (!this.f.equals(var1.f)) {
                        return var2;
                     }
                  } else if (var1.f != null) {
                     var2 = var3;
                     return var2;
                  }

                  if (this.g != null) {
                     var2 = this.g.equals(var1.g);
                  } else {
                     var2 = var4;
                     if (var1.g != null) {
                        var2 = false;
                     }
                  }
               }
            }
         }
      }

      return var2;
   }

   public String f() {
      return this.f;
   }

   public Date g() {
      return this.g;
   }

   @Override
   public int hashCode() {
      int var6 = 0;
      int var1;
      if (this.b != null) {
         var1 = this.b.hashCode();
      } else {
         var1 = 0;
      }

      byte var2;
      if (this.c) {
         var2 = 1;
      } else {
         var2 = 0;
      }

      int var3;
      if (this.d != null) {
         var3 = this.d.hashCode();
      } else {
         var3 = 0;
      }

      int var4;
      if (this.e != null) {
         var4 = this.e.hashCode();
      } else {
         var4 = 0;
      }

      int var5;
      if (this.f != null) {
         var5 = this.f.hashCode();
      } else {
         var5 = 0;
      }

      if (this.g != null) {
         var6 = this.g.hashCode();
      }

      return (var5 + (var4 + (var3 + (var2 + var1 * 31) * 31) * 31) * 31) * 31 + var6;
   }
}
