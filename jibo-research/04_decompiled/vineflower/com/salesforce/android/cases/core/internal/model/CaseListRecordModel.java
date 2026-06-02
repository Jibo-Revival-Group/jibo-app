package com.salesforce.android.cases.core.internal.model;

import com.salesforce.android.cases.core.model.CaseListFeedRecord;
import com.salesforce.android.cases.core.model.CaseListRecord;
import java.util.Date;

public class CaseListRecordModel implements CaseListRecord {
   private String a;
   private String b;
   private String c;
   private Date d;
   private Date e;
   private boolean f;
   private boolean g;
   private CaseListFeedRecordModel h;

   CaseListRecordModel(com.salesforce.android.cases.core.internal.http.response.CaseListRecord var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("CaseListResponse.CaseListRecord cannot be null");
      }

      this.a = var1.c();
      this.b = var1.a();
      this.c = var1.b();
      this.d = var1.d();
      if (var1.f() != null && var1.f().a().size() > 0) {
         this.h = CaseListFeedRecordModel.a(var1.f().a().get(0));
      }

      if (this.h != null && this.h.c() != null) {
         this.e = this.h.c();
      } else {
         this.e = var1.e();
      }
   }

   public static CaseListRecordModel a(com.salesforce.android.cases.core.internal.http.response.CaseListRecord var0) {
      return new CaseListRecordModel(var0);
   }

   @Override
   public String a() {
      return this.a;
   }

   @Override
   public void a(boolean var1) {
      this.f = var1;
   }

   @Override
   public String b() {
      return this.b;
   }

   @Override
   public void b(boolean var1) {
      this.g = var1;
   }

   @Override
   public String c() {
      return this.c;
   }

   @Override
   public Date d() {
      return this.e;
   }

   @Override
   public boolean e() {
      return this.f;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var3 = true;
      boolean var4 = false;
      boolean var2;
      if (this == var1) {
         var2 = true;
      } else {
         var2 = var4;
         if (var1 != null) {
            var2 = var4;
            if (this.getClass() == var1.getClass()) {
               var1 = var1;
               var2 = var4;
               if (this.f == var1.f) {
                  var2 = var4;
                  if (this.g == var1.g) {
                     if (this.a != null) {
                        var2 = var4;
                        if (!this.a.equals(var1.a)) {
                           return var2;
                        }
                     } else if (var1.a != null) {
                        var2 = var4;
                        return var2;
                     }

                     if (this.b != null) {
                        var2 = var4;
                        if (!this.b.equals(var1.b)) {
                           return var2;
                        }
                     } else if (var1.b != null) {
                        var2 = var4;
                        return var2;
                     }

                     if (this.c != null) {
                        var2 = var4;
                        if (!this.c.equals(var1.c)) {
                           return var2;
                        }
                     } else if (var1.c != null) {
                        var2 = var4;
                        return var2;
                     }

                     if (this.d != null) {
                        var2 = var4;
                        if (!this.d.equals(var1.d)) {
                           return var2;
                        }
                     } else if (var1.d != null) {
                        var2 = var4;
                        return var2;
                     }

                     if (this.e != null) {
                        var2 = var4;
                        if (!this.e.equals(var1.e)) {
                           return var2;
                        }
                     } else if (var1.e != null) {
                        var2 = var4;
                        return var2;
                     }

                     if (this.h != null) {
                        var2 = this.h.equals(var1.h);
                     } else {
                        var2 = var3;
                        if (var1.h != null) {
                           var2 = false;
                        }
                     }
                  }
               }
            }
         }
      }

      return var2;
   }

   @Override
   public boolean f() {
      return this.g;
   }

   @Override
   public CaseListFeedRecord g() {
      return this.h;
   }

   @Override
   public int hashCode() {
      byte var7 = 1;
      int var8 = 0;
      int var1;
      if (this.a != null) {
         var1 = this.a.hashCode();
      } else {
         var1 = 0;
      }

      int var2;
      if (this.b != null) {
         var2 = this.b.hashCode();
      } else {
         var2 = 0;
      }

      int var3;
      if (this.c != null) {
         var3 = this.c.hashCode();
      } else {
         var3 = 0;
      }

      int var4;
      if (this.d != null) {
         var4 = this.d.hashCode();
      } else {
         var4 = 0;
      }

      int var5;
      if (this.e != null) {
         var5 = this.e.hashCode();
      } else {
         var5 = 0;
      }

      byte var6;
      if (this.f) {
         var6 = 1;
      } else {
         var6 = 0;
      }

      if (!this.g) {
         var7 = 0;
      }

      if (this.h != null) {
         var8 = this.h.hashCode();
      }

      return ((var6 + (var5 + (var4 + (var3 + (var2 + var1 * 31) * 31) * 31) * 31) * 31) * 31 + var7) * 31 + var8;
   }
}
