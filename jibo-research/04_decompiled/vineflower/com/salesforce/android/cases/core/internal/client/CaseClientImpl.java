package com.salesforce.android.cases.core.internal.client;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import com.salesforce.android.cases.core.CaseClient;
import com.salesforce.android.cases.core.CaseClientCallbacks;
import com.salesforce.android.cases.core.CaseConfiguration;
import com.salesforce.android.cases.core.NotificationHandler;
import com.salesforce.android.cases.core.internal.local.LocalRepository;
import com.salesforce.android.cases.core.internal.local.SmartStoreRepository;
import com.salesforce.android.cases.core.internal.operations.OperationFactory;
import com.salesforce.android.cases.core.internal.remote.RemoteRepository;
import com.salesforce.android.cases.core.model.CaseLayoutData;
import com.salesforce.android.cases.core.model.CaseListRecord;
import com.salesforce.android.cases.core.model.CommentPost;
import com.salesforce.android.cases.core.model.CompleteCaseFeed;
import com.salesforce.android.cases.core.model.CreateCaseRecordResult;
import com.salesforce.android.cases.core.model.DefaultValues;
import com.salesforce.android.cases.core.model.ListViewDescribe;
import com.salesforce.android.cases.core.model.PushNotification;
import com.salesforce.android.cases.core.requests.CaseListRequest;
import com.salesforce.android.cases.core.requests.CommentPostRequest;
import com.salesforce.android.cases.core.requests.CompleteCaseFeedRequest;
import com.salesforce.android.cases.core.requests.CreateCaseQuickActionRequest;
import com.salesforce.android.cases.core.requests.CreateCaseRecordRequest;
import com.salesforce.android.cases.core.requests.DefaultValuesRequest;
import com.salesforce.android.cases.core.requests.ListViewDescribeRequest;
import com.salesforce.android.cases.core.requests.ListViewRequest;
import com.salesforce.android.cases.core.requests.SetCaseHiddenRequest;
import com.salesforce.android.cases.core.requests.SetCaseLastReadDateRequest;
import com.salesforce.android.service.common.utilities.activity.ActivityTracker;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.smartstore.app.SmartStoreSDKManager;
import java.security.GeneralSecurityException;
import java.util.List;

public class CaseClientImpl implements CaseClient {
   Context a;
   ActivityTracker b;
   private final RemoteRepository c;
   private final OperationFactory d;
   private final CaseClientCallbacks e;
   private final LocalRepository f;
   private final UserAccount g;
   private NotificationHandler h;

   CaseClientImpl(CaseClientImpl.Builder var1) {
      this.c = var1.c();
      this.d = var1.d();
      this.e = var1.b();
      this.f = var1.e();
      this.a = var1.h();
      this.g = var1.g().i();
      if (this.c == null) {
         throw new IllegalStateException("RemoteRepository cannot be null.");
      }

      if (this.d == null) {
         throw new IllegalStateException("OperationFactory cannot be null.");
      }

      if (this.f == null) {
         throw new IllegalStateException("LocalRepository cannot be null.");
      }

      if (this.a == null) {
         throw new IllegalStateException("Context cannot be null.");
      }

      if (var1.f()) {
         SalesforceSDKManager.a().a(this);
         this.b = new ActivityTracker();
         this.b.a(this.a.getApplicationContext());
      }
   }

   public static CaseClientImpl.Builder a(CaseConfiguration var0) {
      return new CaseClientImpl.Builder(var0);
   }

   private boolean b() {
      boolean var1;
      if (this.b.b() != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public CaseClientCallbacks a() {
      return this.e;
   }

   @Override
   public Async<List<CaseListRecord>> a(CaseListRequest var1) {
      return this.d.a(var1, this.f, this.c).e().f();
   }

   @Override
   public Async<CommentPost> a(CommentPostRequest var1) {
      return this.d.a(var1, this.c).e().f();
   }

   @Override
   public Async<CompleteCaseFeed> a(CompleteCaseFeedRequest var1) {
      return this.d.a(var1, this.f, this.c, this.g).e().f();
   }

   @Override
   public Async<CaseLayoutData> a(CreateCaseQuickActionRequest var1) {
      return this.d.a(var1, this.f, this.c, this.g).e().f();
   }

   @Override
   public Async<CreateCaseRecordResult> a(CreateCaseRecordRequest var1) {
      return this.d.a(var1, this.c).e().f();
   }

   @Override
   public Async<DefaultValues> a(DefaultValuesRequest var1) {
      return this.d.a(var1, this.f, this.c).e().f();
   }

   @Override
   public Async<ListViewDescribe> a(ListViewDescribeRequest var1) {
      return this.d.a(var1, this.f, this.c).e().f();
   }

   @Override
   public Async<String> a(ListViewRequest var1) {
      return this.d.a(var1, this.f, this.c).e().f();
   }

   @Override
   public Async<Void> a(SetCaseHiddenRequest var1) {
      return this.d.a(var1, this.f, this.c).e().f();
   }

   @Override
   public Async<Void> a(SetCaseLastReadDateRequest var1) {
      return this.d.a(var1, this.f, this.c).e().f();
   }

   @Override
   public void a(Bundle var1) {
      boolean var2 = false;
      if (this.e != null) {
         if (this.b()) {
            var2 = this.e.b(var1);
         } else {
            var2 = this.e.a(var1);
         }
      }

      PushNotification var3 = new PushNotification(var1);
      if (this.h != null) {
         this.h.a(var3);
      }

      if (this.h != null && !var2 && !this.b()) {
         this.h.a(this.a, var3);
      }

      if (this.a != null) {
         Intent var4 = new Intent("Body").putExtras(var1);
         LocalBroadcastManager.a(this.a).a(var4);
      }
   }

   public void a(NotificationHandler var1) {
      this.h = var1;
   }

   @Override
   public Async<String> b(ListViewRequest var1) {
      return this.d.b(var1, this.f, this.c).e().f();
   }

   public static class Builder {
      private final CaseConfiguration a;
      private RemoteRepository b;
      private OperationFactory c;
      private LocalRepository d;
      private Context e;

      public Builder(CaseConfiguration var1) {
         this.a = var1;
      }

      public CaseClientImpl.Builder a(Context var1) {
         this.e = var1;
         return this;
      }

      public CaseClientImpl a() throws GeneralSecurityException {
         if (this.e == null) {
            throw new IllegalStateException("Must set valid context for CaseClient");
         }

         if (SalesforceSDKManager.b() && SalesforceSDKManager.a() instanceof SmartStoreSDKManager) {
            if (this.c == null) {
               this.c = new OperationFactory();
            }

            if (this.b == null) {
               this.b = RemoteRepository.a(this.e.getApplicationContext(), this.a).b();
            }

            if (this.d == null) {
               this.d = new SmartStoreRepository.Builder().a(this.a.i()).e();
            }

            Arguments.a(this.e);
            return new CaseClientImpl(this);
         } else {
            throw new IllegalStateException("SmartstoreSdkManager must be initialized using SmartStoreSDKManager.initNative before launching CaseClient");
         }
      }

      CaseClientCallbacks b() {
         return this.a.h();
      }

      public RemoteRepository c() {
         return this.b;
      }

      public OperationFactory d() {
         return this.c;
      }

      public LocalRepository e() {
         return this.d;
      }

      public boolean f() {
         return this.a.f();
      }

      public CaseConfiguration g() {
         return this.a;
      }

      public Context h() {
         return this.e;
      }
   }
}
