package com.salesforce.android.cases.core.internal.model;

import com.salesforce.android.cases.core.internal.http.response.CaseListFeeds;
import com.salesforce.android.cases.core.model.CaseListFeedRecord;
import java.util.Date;

public class CaseListFeedRecordModel implements CaseListFeedRecord {
   private String a;
   private String b;
   private Date c;

   CaseListFeedRecordModel(CaseListFeeds.CaseListFeedRecord var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("record cannot be null.");
      }

      this.a = var1.a();
      this.b = var1.b();
      this.c = var1.c();
   }

   public static CaseListFeedRecordModel a(CaseListFeeds.CaseListFeedRecord var0) {
      return new CaseListFeedRecordModel(var0);
   }

   @Override
   public String a() {
      return this.a;
   }

   @Override
   public String b() {
      return this.b;
   }

   @Override
   public Date c() {
      return this.c;
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
                  var2 = this.c.equals(var1.c);
               } else {
                  var2 = var3;
                  if (var1.c != null) {
                     var2 = false;
                  }
               }
            }
         }
      }

      return var2;
   }

   @Override
   public int hashCode() {
      int var3 = 0;
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

      if (this.c != null) {
         var3 = this.c.hashCode();
      }

      return (var2 + var1 * 31) * 31 + var3;
   }
}
