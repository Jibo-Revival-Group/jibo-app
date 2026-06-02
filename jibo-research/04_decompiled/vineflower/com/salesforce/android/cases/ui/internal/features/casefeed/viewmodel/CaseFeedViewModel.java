package com.salesforce.android.cases.ui.internal.features.casefeed.viewmodel;

import android.content.Context;
import android.text.TextUtils;
import com.salesforce.android.cases.R;
import com.salesforce.android.cases.core.internal.util.DateUtils;
import com.salesforce.android.cases.core.internal.util.StringUtils;
import com.salesforce.android.cases.core.model.Body;
import com.salesforce.android.cases.core.model.CaseDetailRecord;
import com.salesforce.android.cases.core.model.CaseFeed;
import com.salesforce.android.cases.core.model.CaseField;
import com.salesforce.android.cases.core.model.CaseLayoutData;
import com.salesforce.android.cases.core.model.CommentPost;
import com.salesforce.android.cases.core.model.Element;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class CaseFeedViewModel {
   List<Object> a;
   private final Context b;
   private final CaseDetailRecord c;
   private final CaseLayoutData d;
   private final CaseFeed e;
   private final String f;
   private final DateFormat g;
   private final Date h;

   public CaseFeedViewModel(Context var1, CaseDetailRecord var2, CaseLayoutData var3, CaseFeed var4, String var5) {
      this.b = var1;
      this.c = var2;
      this.d = var3;
      this.e = var4;
      this.f = var5;
      Date var6 = var2.u();

      for (Element var9 : var4.a()) {
         if (var6 == null || var9.c() != null && var6.before(var9.c())) {
            var6 = var9.c();
         }
      }

      Date var8 = var6;
      if (var6 == null) {
         var8 = new Date();
      }

      this.h = var8;
      this.g = new SimpleDateFormat("MMM d, yyyy", Locale.getDefault());
      if (var2 != null && var4 != null && !var4.a().isEmpty()) {
         this.e();
      }
   }

   private String a(CaseDetailRecord var1) {
      StringBuilder var3 = new StringBuilder();

      for (CaseField var2 : this.d.a()) {
         if (!var2.i()) {
            String var5 = StringUtils.d(this.a(var2, var1));
            if (!TextUtils.isEmpty(var5)) {
               if (var3.length() > 0) {
                  var3.append("\n").append("\n");
               }

               var3.append(var2.b());
               var3.append("\n");
               var3.append(var5);
            }
         }
      }

      return var3.toString();
   }

   private String a(CaseField var1, CaseDetailRecord var2) {
      String var5;
      switch (var1.a()) {
         case "Subject":
            var5 = var2.n();
            break;
         case "Description":
            var5 = var2.p();
            break;
         case "Id":
            var5 = var2.a();
            break;
         case "Status":
            var5 = var2.l();
            break;
         case "RecordTypeId":
            var5 = var2.k();
            break;
         case "CreatedDate":
            var5 = DateUtils.a.format(var2.s());
            break;
         case "LastModifiedDate":
            var5 = DateUtils.a.format(var2.u());
            break;
         case "CaseNumber":
            var5 = var2.b();
            break;
         case "ContactId":
            var5 = var2.c();
            break;
         case "AssetId":
            var5 = var2.d();
            break;
         case "FeedItemId":
            var5 = var2.e();
            break;
         case "SourceId":
            var5 = var2.f();
            break;
         case "CommunityId":
            var5 = var2.g();
            break;
         case "SuppliedName":
            var5 = var2.h();
            break;
         case "SuppliedEmail":
            var5 = var2.i();
            break;
         case "Type":
            var5 = var2.j();
            break;
         case "Reason":
            var5 = var2.m();
            break;
         case "Priority":
            var5 = var2.o();
            break;
         case "ClosedDate":
            var5 = DateUtils.a.format(var2.q());
            break;
         case "OwnerId":
            var5 = var2.r();
            break;
         case "CreatedById":
            var5 = var2.t();
            break;
         case "LastModifiedById":
            var5 = var2.v();
            break;
         case "LastViewedDate":
            var5 = DateUtils.a.format(var2.w());
            break;
         case "LastReferencedDate":
            var5 = DateUtils.a.format(var2.x());
            break;
         case "CreatorFullPhotoUrl":
            var5 = var2.y();
            break;
         case "CreatorSmallPhotoUrl":
            var5 = var2.z();
            break;
         case "CreatorName":
            var5 = var2.A();
            break;
         default:
            if (var2.B().containsKey(var1.a())) {
               var5 = var2.B().get(var1.a());
            } else {
               var5 = var1.h();
            }
      }

      return var5;
   }

   private boolean a(Date var1, Date var2) {
      boolean var3 = true;
      Calendar var4 = Calendar.getInstance();
      Calendar var5 = Calendar.getInstance();
      var4.setTime(var1);
      var5.setTime(var2);
      if (var4.get(1) != var5.get(1) || var4.get(6) != var5.get(6)) {
         var3 = false;
      }

      return var3;
   }

   private void e() {
      this.a = new ArrayList<>();
      Date var5 = new Date();
      Date var1 = this.c.s();
      if (var1 == null) {
         var1 = new Date(0L);
      }

      if (this.a(var5, var1)) {
         this.a.add(new HorizontalRuleModel(this.b.getString(R.string.cases_horizontal_rule_today_text)));
      } else {
         this.a.add(new HorizontalRuleModel(this.g.format(var1)));
      }

      String var2 = this.a(this.c);
      this.a.add(new SentMessageModel(var2, var1));
      ArrayList var10 = new ArrayList<>(this.e.a());
      Collections.reverse(var10);
      HashSet var6 = new HashSet();
      Iterator var3 = SalesforceSDKManager.a().o().d().iterator();

      while (var3.hasNext()) {
         var6.add(((UserAccount)var3.next()).g());
      }

      Iterator var7 = var10.iterator();
      Date var12 = var1;

      while (var7.hasNext()) {
         Element var9 = (Element)var7.next();
         Body var8 = var9.d();
         Date var11;
         if (var8 != null && !TextUtils.isEmpty(var8.a())) {
            Date var4 = var9.c();
            var11 = var4;
            if (var4 == null) {
               var11 = var1;
            }

            if (var12 == null && this.a(var5, var9.c())) {
               this.a.add(new HorizontalRuleModel(this.b.getString(R.string.cases_horizontal_rule_today_text)));
            } else if (var12 == null || !this.a(var12, var11)) {
               this.a.add(new HorizontalRuleModel(this.g.format(var11)));
            }

            if (var9.e() != null && var6.contains(var9.e().b())) {
               this.a.add(new SentMessageModel(StringUtils.d(var8.a()), var11));
            } else if (var9.e() != null) {
               String var13;
               if (TextUtils.isEmpty(var9.e().a())) {
                  var13 = "";
               } else {
                  var13 = var9.e().a();
               }

               String var14;
               if (TextUtils.isEmpty(var9.e().b())) {
                  var14 = "";
               } else {
                  var14 = var9.e().a();
               }

               this.a.add(new ReceivedMessageModel(StringUtils.d(var8.a()), var13, var14, var11));
            }
         } else {
            var11 = var12;
         }

         var12 = var11;
      }
   }

   public List<Object> a() {
      List var1;
      if (this.a == null) {
         var1 = Collections.emptyList();
      } else {
         var1 = Collections.unmodifiableList(this.a);
      }

      return var1;
   }

   public List<Object> a(CommentPost var1) {
      Object var5 = null;
      ArrayList var4 = new ArrayList();
      ArrayList var8;
      if (var1 != null && var1.a() != null && !TextUtils.isEmpty(var1.a().a())) {
         Date var7 = var1.b();
         Date var6 = new Date();
         int var2 = this.a.size() - 1;

         Date var3;
         while (true) {
            var3 = (Date)var5;
            if (var2 < 0) {
               break;
            }

            Object var10 = this.a.get(var2);
            if (var10 instanceof SentMessageModel) {
               var3 = ((SentMessageModel)var10).d();
               break;
            }

            if (var10 instanceof ReceivedMessageModel) {
               var3 = ((ReceivedMessageModel)var10).d();
               break;
            }

            var2--;
         }

         if (var3 == null && this.a(var6, var1.b())) {
            HorizontalRuleModel var12 = new HorizontalRuleModel(this.b.getString(R.string.cases_horizontal_rule_today_text));
            this.a.add(var12);
            var4.add(var12);
         } else if (var3 == null || !this.a(var3, var7)) {
            HorizontalRuleModel var11 = new HorizontalRuleModel(this.g.format(var7));
            this.a.add(var11);
            var4.add(var11);
         }

         SentMessageModel var9 = new SentMessageModel(StringUtils.d(var1.a().a()), var1.b());
         this.a.add(var9);
         var4.add(var9);
         var8 = var4;
      } else {
         var8 = null;
      }

      return var8;
   }

   public String b() {
      String var1;
      if (this.c != null && !TextUtils.isEmpty(this.c.n())) {
         var1 = this.c.n();
      } else if (this.c != null && this.c.b() != null) {
         var1 = this.b.getString(R.string.cases_case_feed_default_title_text, new Object[]{this.c.b()});
      } else {
         var1 = "";
      }

      return var1;
   }

   public Date c() {
      return this.h;
   }

   public String d() {
      return this.f;
   }
}
