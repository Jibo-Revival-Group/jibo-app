package com.salesforce.android.cases.core.internal.local;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.salesforce.android.cases.core.internal.http.serializer.DateTypeAdapter;
import com.salesforce.android.cases.core.internal.http.util.CaseConstants;
import com.salesforce.android.cases.core.internal.model.CaseDetailRecordModel;
import com.salesforce.android.cases.core.internal.model.CaseFeedModel;
import com.salesforce.android.cases.core.internal.model.CaseLayoutDataModel;
import com.salesforce.android.cases.core.internal.model.CaseListRecordModel;
import com.salesforce.android.cases.core.internal.model.CommunityModel;
import com.salesforce.android.cases.core.internal.model.DefaultValuesModel;
import com.salesforce.android.cases.core.internal.model.ListViewDescribeModel;
import com.salesforce.android.cases.core.internal.util.DateUtils;
import com.salesforce.android.cases.core.internal.util.StringUtils;
import com.salesforce.android.cases.core.model.CaseDetailRecord;
import com.salesforce.android.cases.core.model.CaseFeed;
import com.salesforce.android.cases.core.model.CaseLayoutData;
import com.salesforce.android.cases.core.model.CaseListRecord;
import com.salesforce.android.cases.core.model.Community;
import com.salesforce.android.cases.core.model.DefaultValues;
import com.salesforce.android.cases.core.model.ListViewDescribe;
import com.salesforce.android.cases.core.requests.CaseDetailRequest;
import com.salesforce.android.cases.core.requests.CaseFeedRequest;
import com.salesforce.android.cases.core.requests.CaseListRequest;
import com.salesforce.android.cases.core.requests.CommunitiesListRequest;
import com.salesforce.android.cases.core.requests.CreateCaseQuickActionRequest;
import com.salesforce.android.cases.core.requests.DefaultValuesRequest;
import com.salesforce.android.cases.core.requests.ListViewDescribeRequest;
import com.salesforce.android.cases.core.requests.ListViewRequest;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import com.salesforce.android.service.common.utilities.functional.Function;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.threading.JobQueue;
import com.salesforce.android.service.common.utilities.threading.PriorityThreadFactory;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.smartstore.app.SmartStoreSDKManager;
import com.salesforce.androidsdk.smartstore.store.IndexSpec;
import com.salesforce.androidsdk.smartstore.store.QuerySpec;
import com.salesforce.androidsdk.smartstore.store.SmartStore;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;

public class SmartStoreRepository implements LocalRepository {
   private static final IndexSpec[] a = new IndexSpec[]{new IndexSpec("id", SmartStore.Type.string)};
   private KeyValueSmartstore b;
   private KeyValueSmartstore c;
   private KeyValueSmartstore d;
   private KeyValueSmartstore e;
   private KeyValueSmartstore f;
   private KeyValueSmartstore g;
   private KeyValueSmartstore h;
   private KeyValueSmartstore i;
   private KeyValueSmartstore j;
   private KeyValueSmartstore k;
   private KeyValueSmartstore l;
   private final KeyValueSmartstoreFactory m;
   private final Gson n;
   private final UserAccount o;
   private final JobQueue p;
   private SmartStore q;
   private final ServiceLogger r = ServiceLogging.a(SmartStoreRepository.class);

   SmartStoreRepository(SmartStoreRepository.Builder var1) {
      this.n = var1.b();
      this.p = var1.c();
      this.m = var1.a();
      this.o = var1.d();
      this.d();
   }

   private void d() {
      if (DbUtils.a(this.o)) {
         try {
            this.e();
         } catch (Exception var2) {
            this.r
               .d("{} encountered trying to initialize Smarstore, deleting database. Cause: {}", var2.getClass().getSimpleName(), var2.getLocalizedMessage());
            this.f();
            this.e();
         }
      }
   }

   private void e() {
      this.q = SmartStoreSDKManager.H().b(this.o);
      this.q.a("CaseList", a);
      this.c = this.m.a("ListLabel");
      this.b = this.m.a("ListId");
      this.d = this.m.a("CaseReadDate");
      this.e = this.m.a("CasesHidden");
      this.f = this.m.a("ListViewDescribe");
      this.g = this.m.a("CaseFeed");
      this.h = this.m.a("CaseDetail");
      this.i = this.m.a("DefaultValues");
      this.j = this.m.a("CaseLayout");
      this.k = this.m.a("Communities");
      this.l = this.m.a("CommunityId");
   }

   private void f() {
      if (DbUtils.a(this.o)) {
         SmartStoreSDKManager.H().I();
      }
   }

   @Override
   public Async<Map<String, Date>> a() {
      BasicAsync var1;
      if (!DbUtils.a(this.o)) {
         var1 = BasicAsync.c(new IllegalStateException("Cannot Retrieve Last Read Dates: Not authenticated"));
      } else {
         this.r.b("Starting Local getCaseLastReadDates");
         BasicAsync var7 = BasicAsync.g();
         Map var3 = this.d.a();
         HashMap var4 = new HashMap(var3.size() + 1, 1.0F);

         for (String var6 : var3.keySet()) {
            String var8 = (String)var3.get(var6);
            Date var9;
            if (StringUtils.b(var8)) {
               var9 = DateUtils.a(var8);
            } else {
               var9 = null;
            }

            Date var2 = var9;
            if (var9 == null) {
               var2 = CaseConstants.a;
            }

            var4.put(var6, var2);
         }

         this.r.b("Finished Local getCaseLastReadDates");
         var1 = var7.a(var4).a();
      }

      return var1;
   }

   @Override
   public Async<CaseDetailRecord> a(CaseDetailRequest var1) {
      BasicAsync var4;
      if (!DbUtils.a(this.o)) {
         var4 = BasicAsync.c(new IllegalStateException("Cannot Get Case Detail, not authenticated"));
      } else {
         this.r.b("Starting Local getCaseDetail");
         BasicAsync var2 = BasicAsync.g();
         String var3 = this.h.a(var1.a());
         CaseDetailRecord var5 = null;
         if (var3 != null) {
            var5 = this.n.a(var3, CaseDetailRecordModel.class);
         }

         if (var5 != null) {
            var2.a(var5);
         }

         this.r.b("Finished Local getCaseDetail");
         var4 = var2.a();
      }

      return var4;
   }

   @Override
   public Async<Void> a(CaseDetailRequest var1, CaseDetailRecord var2) {
      BasicAsync var3;
      if (!DbUtils.a(this.o)) {
         var3 = BasicAsync.c(new IllegalStateException("Cannot Set Case Detail, not authenticated"));
      } else {
         this.r.b("Starting Local setCaseDetail");
         this.h.a(var1.a(), this.n.b(var2));
         this.r.b("Ending Local setCaseFeed");
         var3 = BasicAsync.h();
      }

      return var3;
   }

   @Override
   public Async<CaseFeed> a(CaseFeedRequest var1) {
      BasicAsync var4;
      if (!DbUtils.a(this.o)) {
         var4 = BasicAsync.c(new IllegalStateException("Cannot Get Case Feed, not authenticated"));
      } else {
         this.r.b("Starting Local getCaseFeed");
         BasicAsync var2 = BasicAsync.g();
         String var3 = this.g.a(var1.b());
         CaseFeed var5 = null;
         if (var3 != null) {
            var5 = this.n.a(var3, CaseFeedModel.class);
         }

         if (var5 != null) {
            var2.a(var5);
         }

         this.r.b("Finished Local getCaseFeed");
         var4 = var2.a();
      }

      return var4;
   }

   @Override
   public Async<Void> a(CaseFeedRequest var1, CaseFeed var2) {
      BasicAsync var3;
      if (!DbUtils.a(this.o)) {
         var3 = BasicAsync.c(new IllegalStateException("Cannot Set Case Feed, not authenticated"));
      } else {
         this.r.b("Starting Local setCaseFeed");
         this.g.a(var1.b(), this.n.b(var2));
         this.r.b("Ending Local setCaseFeed");
         var3 = BasicAsync.h();
      }

      return var3;
   }

   @Override
   public Async<List<CaseListRecord>> a(CaseListRequest var1) {
      Async var2;
      if (!DbUtils.a(this.o)) {
         var2 = BasicAsync.c(new IllegalStateException("Cannot Get Hidden Status, not authenticated"));
      } else {
         QuerySpec var3 = QuerySpec.a("CaseList", "id", QuerySpec.Order.descending, Integer.MAX_VALUE);
         var2 = this.p.a(ReadJob.a(this.q, var3, 0, this.o)).b(new SmartStoreRepository.WriteCaseListFunction(this.n));
      }

      return var2;
   }

   @Override
   public Async<Void> a(CaseListRequest var1, List<CaseListRecord> var2) {
      Async var4;
      if (!DbUtils.a(this.o)) {
         var4 = BasicAsync.c(new IllegalStateException("Cannot Set Case List, not authenticated"));
      } else {
         this.r.b("Scheduling write asysc for {}", "CaseList");

         try {
            String var6 = this.n.b(var2);
            JSONArray var5 = new JSONArray(var6);
            this.r.b("Write schedule complete for {}", "CaseList");
            var4 = this.p.a(WriteJob.a(this.q, "CaseList", var5, this.o));
         } catch (JSONException var3) {
            this.r.e("JSONException: Error storing CaseListRecords to local db, {}", var3.getMessage());
            var4 = BasicAsync.c(var3);
         }
      }

      return var4;
   }

   @Override
   public Async<Void> a(CommunitiesListRequest var1, List<Community> var2) {
      BasicAsync var3;
      if (!DbUtils.a(this.o)) {
         var3 = BasicAsync.c(new IllegalStateException("Cannot Set Communities, not authenticated"));
      } else {
         this.r.b("Starting Local setCommunities");
         this.k.a("Instance", this.n.b(var2));
         this.r.b("Ending Local setCommunities");
         var3 = BasicAsync.h();
      }

      return var3;
   }

   @Override
   public Async<CaseLayoutData> a(CreateCaseQuickActionRequest var1) {
      BasicAsync var4;
      if (!DbUtils.a(this.o)) {
         var4 = BasicAsync.c(new IllegalStateException("Cannot Get Case Layout Data, not authenticated"));
      } else {
         this.r.b("Starting Local getDefaultValues");
         BasicAsync var2 = BasicAsync.g();
         String var3 = this.j.a(var1.a());
         CaseLayoutData var5 = null;
         if (var3 != null) {
            var5 = this.n.a(var3, CaseLayoutDataModel.class);
         }

         if (var5 != null) {
            var2.a(var5);
         }

         this.r.b("Finished Local getDefaultValues");
         var4 = var2.a();
      }

      return var4;
   }

   @Override
   public Async<Void> a(CreateCaseQuickActionRequest var1, CaseLayoutData var2) {
      BasicAsync var3;
      if (!DbUtils.a(this.o)) {
         var3 = BasicAsync.c(new IllegalStateException("Cannot Set Case Layout Data, not authenticated"));
      } else {
         this.r.b("Starting Local setDefaultValues");
         this.j.a(var1.a(), this.n.b(var2));
         this.r.b("Ending Local setDefaultValues");
         var3 = BasicAsync.h();
      }

      return var3;
   }

   @Override
   public Async<DefaultValues> a(DefaultValuesRequest var1) {
      BasicAsync var4;
      if (!DbUtils.a(this.o)) {
         var4 = BasicAsync.c(new IllegalStateException("Cannot Get Default Values, not authenticated"));
      } else {
         this.r.b("Starting Local getDefaultValues");
         BasicAsync var2 = BasicAsync.g();
         String var3 = this.i.a(var1.a());
         DefaultValues var5 = null;
         if (var3 != null) {
            var5 = this.n.a(var3, DefaultValuesModel.class);
         }

         if (var5 != null) {
            var2.a(var5);
         }

         this.r.b("Finished Local getDefaultValues");
         var4 = var2.a();
      }

      return var4;
   }

   @Override
   public Async<Void> a(DefaultValuesRequest var1, DefaultValues var2) {
      BasicAsync var3;
      if (!DbUtils.a(this.o)) {
         var3 = BasicAsync.c(new IllegalStateException("Cannot Set Default Values, not authenticated"));
      } else {
         this.r.b("Starting Local setDefaultValues");
         this.i.a(var1.a(), this.n.b(var2));
         this.r.b("Ending Local setDefaultValues");
         var3 = BasicAsync.h();
      }

      return var3;
   }

   @Override
   public Async<ListViewDescribe> a(ListViewDescribeRequest var1) {
      BasicAsync var4;
      if (!DbUtils.a(this.o)) {
         var4 = BasicAsync.c(new IllegalStateException("Cannot Get List View, not authenticated"));
      } else {
         this.r.b("Starting Local getListViewDescribe");
         BasicAsync var2 = BasicAsync.g();
         String var3 = this.f.a(var1.a());
         ListViewDescribe var5 = null;
         if (var3 != null) {
            var5 = this.n.a(var3, ListViewDescribeModel.class);
         }

         if (var5 != null) {
            var2.a(var5);
         }

         this.r.b("Finished Local getListViewDescribe");
         var4 = var2.a();
      }

      return var4;
   }

   @Override
   public Async<Void> a(ListViewDescribeRequest var1, ListViewDescribe var2) {
      BasicAsync var3;
      if (!DbUtils.a(this.o)) {
         var3 = BasicAsync.c(new IllegalStateException("Cannot Set List View, not authenticated"));
      } else {
         this.r.b("Starting Local setListViewDescribe");
         this.f.a(var1.a(), this.n.b(var2));
         this.r.b("Ending Local setListViewDescribe");
         var3 = BasicAsync.h();
      }

      return var3;
   }

   @Override
   public Async<String> a(ListViewRequest var1) {
      BasicAsync var2 = BasicAsync.g();
      BasicAsync var3;
      if (!DbUtils.a(this.o)) {
         var3 = BasicAsync.c(new IllegalStateException("Cannot retrieve list view id: Not authenticated"));
      } else {
         this.r.b("Starting Local getListViewId");
         var2.a(this.b.a(var1.a()));
         this.r.b("Ending Local getListViewId");
         var3 = var2.a();
      }

      return var3;
   }

   @Override
   public Async<Void> a(ListViewRequest var1, String var2) {
      BasicAsync var3;
      if (!DbUtils.a(this.o)) {
         var3 = BasicAsync.c(new IllegalStateException("Cannot store list view id: Not authenticated"));
      } else {
         this.r.b("Starting Local storeListViewId");
         this.b.a(var1.a(), var2);
         this.r.b("Ending Local storeListViewId");
         var3 = BasicAsync.h();
      }

      return var3;
   }

   @Override
   public Async<Void> a(String var1, Date var2) {
      BasicAsync var3;
      if (!DbUtils.a(this.o)) {
         var3 = BasicAsync.c(new IllegalStateException("Cannot Set Last Read Dates: Not authenticated"));
      } else {
         this.r.b("Starting setCaseLastReadDate");
         String var4 = DateUtils.a(var2);
         this.d.a(var1, var4);
         this.r.b("Finished local setCaseLastReadDate");
         var3 = BasicAsync.h();
      }

      return var3;
   }

   @Override
   public Async<Void> a(String var1, boolean var2) {
      BasicAsync var3;
      if (!DbUtils.a(this.o)) {
         var3 = BasicAsync.c(new IllegalStateException("Cannot Set Hidden Status, not authenticated"));
      } else {
         this.r.b("Starting Local setCaseHidden");
         this.e.a(var1, String.valueOf(var2));
         this.r.b("Finished Local setCaseHidden");
         var3 = BasicAsync.h();
      }

      return var3;
   }

   @Override
   public Async<Map<String, Boolean>> b() {
      BasicAsync var1;
      if (!DbUtils.a(this.o)) {
         var1 = BasicAsync.c(new IllegalStateException("Cannot Get Hidden Status: Not authenticated"));
      } else {
         this.r.b("Starting Local getCaseHiddenStatus");
         Map var3 = this.e.a();
         HashMap var4 = new HashMap(var3.size() + 1, 1.0F);

         for (String var2 : var3.keySet()) {
            var4.put(var2, Boolean.parseBoolean((String)var3.get(var2)));
         }

         this.r.b("Finished Local getCaseHiddenStatus");
         var1 = BasicAsync.c(var4);
      }

      return var1;
   }

   @Override
   public Async<String> b(ListViewRequest var1) {
      BasicAsync var3;
      if (!DbUtils.a(this.o)) {
         var3 = BasicAsync.c(new IllegalStateException("Cannot Retrieve List View Label: Not authenticated"));
      } else {
         this.r.b("Starting Local getListViewLabel");
         BasicAsync var2 = BasicAsync.g();
         var2.a(this.c.a(var1.a()));
         this.r.b("Finished Local getListViewLabel");
         var3 = var2.a();
      }

      return var3;
   }

   @Override
   public Async<Void> b(ListViewRequest var1, String var2) {
      BasicAsync var3;
      if (!DbUtils.a(this.o)) {
         var3 = BasicAsync.c(new IllegalStateException("Cannot Save List View Label: Not authenticated"));
      } else {
         this.r.b("Starting Local storeListViewLabel");
         this.c.a(var1.a(), var2);
         this.r.b("Finished Local storeListViewLabel");
         var3 = BasicAsync.h();
      }

      return var3;
   }

   @Override
   public Async<List<Community>> c() {
      BasicAsync var1;
      if (!DbUtils.a(this.o)) {
         var1 = BasicAsync.c(new IllegalStateException("Cannot Get Communities, not authenticated"));
      } else {
         this.r.b("Starting Local getCommunities");
         BasicAsync var2 = BasicAsync.g();
         String var3 = this.k.a("Instance");
         List var4 = null;
         if (var3 != null) {
            Type var5 = (new TypeToken<ArrayList<CommunityModel>>(this) {
               final SmartStoreRepository a;

               {
                  this.a = var1;
               }
            }).getType();
            var4 = this.n.a(var3, var5);
         }

         if (var4 != null) {
            var2.a(var4);
         }

         this.r.b("Finished Local getCommunities");
         var1 = var2.a();
      }

      return var1;
   }

   public static class Builder {
      private KeyValueSmartstoreFactory a;
      private Gson b;
      private JobQueue c;
      private UserAccount d;

      public KeyValueSmartstoreFactory a() {
         return this.a;
      }

      public SmartStoreRepository.Builder a(UserAccount var1) {
         this.d = var1;
         return this;
      }

      public Gson b() {
         return this.b;
      }

      public JobQueue c() {
         return this.c;
      }

      public UserAccount d() {
         return this.d;
      }

      public LocalRepository e() {
         if (this.a == null) {
            this.a = new KeyValueSmartstoreFactory(this.d);
         }

         if (this.b == null) {
            this.b = new GsonBuilder().a(Date.class, new DateTypeAdapter(Date.class)).a("yyyy-MM-dd'T'HH:mm:ss.SSSZ").a();
         }

         if (this.c == null) {
            this.c = new JobQueue(Executors.newSingleThreadExecutor(PriorityThreadFactory.a()));
         }

         return new SmartStoreRepository(this);
      }
   }

   static class WriteCaseListFunction implements Function<JSONArray, Async<List<CaseListRecord>>> {
      private final Gson a;

      WriteCaseListFunction(Gson var1) {
         this.a = var1;
      }

      public Async<List<CaseListRecord>> a(JSONArray var1) {
         Type var2 = (new TypeToken<ArrayList<CaseListRecordModel>>(this) {
            final SmartStoreRepository.WriteCaseListFunction a;

            {
               this.a = var1;
            }
         }).getType();
         List var3 = this.a.a(var1.toString(), var2);
         BasicAsync var4;
         if (var3 != null && !var3.isEmpty()) {
            var4 = BasicAsync.c(var3);
         } else {
            var4 = BasicAsync.c(new IllegalStateException("Cannot retrieve case list, List empty"));
         }

         return var4;
      }
   }
}
