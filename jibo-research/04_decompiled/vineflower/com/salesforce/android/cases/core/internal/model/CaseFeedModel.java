package com.salesforce.android.cases.core.internal.model;

import com.salesforce.android.cases.core.internal.http.response.ActorResponse;
import com.salesforce.android.cases.core.internal.http.response.BodyResponse;
import com.salesforce.android.cases.core.internal.http.response.CaseFeedResponse;
import com.salesforce.android.cases.core.internal.http.response.PhotoResponse;
import com.salesforce.android.cases.core.internal.util.DateUtils;
import com.salesforce.android.cases.core.model.Actor;
import com.salesforce.android.cases.core.model.Body;
import com.salesforce.android.cases.core.model.CaseFeed;
import com.salesforce.android.cases.core.model.Element;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class CaseFeedModel implements CaseFeed {
   private String a;
   private List<CaseFeedModel.ElementModel> b;
   private String c;
   private String d;

   CaseFeedModel(CaseFeedResponse var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("CaseFeedResponse cannot be null");
      }

      this.a = var1.a();
      this.c = var1.c();
      this.d = var1.d();
      this.b = new ArrayList<>();

      for (CaseFeedResponse.Element var2 : var1.b()) {
         if (var2 != null) {
            this.b.add(new CaseFeedModel.ElementModel(this, var2));
         }
      }
   }

   public static CaseFeedModel a(CaseFeedResponse var0) {
      return new CaseFeedModel(var0);
   }

   @Override
   public List<? extends Element> a() {
      List var1;
      if (this.b == null) {
         var1 = Collections.emptyList();
      } else {
         var1 = Collections.unmodifiableList(this.b);
      }

      return var1;
   }

   public class ActorModel implements Actor {
      final CaseFeedModel a;
      private String b;
      private String c;
      private String d;
      private String e;
      private boolean f;
      private boolean g;
      private String h;
      private CaseFeedModel.PhotoModel i;
      private String j;
      private String k;

      private ActorModel(CaseFeedModel var1, ActorResponse var2) {
         this.a = var1;
         this.b = var2.a();
         this.c = var2.b();
         this.d = var2.c();
         this.e = var2.d();
         this.f = var2.e();
         this.g = var2.f();
         this.h = var2.g();
         if (var2.h() != null) {
            this.i = var1.new PhotoModel(var1, var2.h());
         }

         this.j = var2.i();
         this.k = var2.j();
      }

      @Override
      public String a() {
         return this.c;
      }

      @Override
      public String b() {
         return this.e;
      }
   }

   public class BodyModel implements Body {
      final CaseFeedModel a;
      private boolean b;
      private String c;

      private BodyModel(CaseFeedModel var1, BodyResponse var2) {
         this.a = var1;
         this.b = var2.a();
         this.c = var2.b();
      }

      @Override
      public String a() {
         return this.c;
      }
   }

   public class ElementModel implements Element {
      final CaseFeedModel a;
      private CaseFeedModel.ActorModel b;
      private CaseFeedModel.BodyModel c;
      private Date d;
      private String e;
      private Date f;
      private String g;
      private String h;
      private String i;
      private String j;

      private ElementModel(CaseFeedModel var1, CaseFeedResponse.Element var2) {
         this.a = var1;
         if (var2.a() != null) {
            this.b = var1.new ActorModel(var1, var2.a());
         }

         if (var2.b() != null) {
            this.c = var1.new BodyModel(var1, var2.b());
         }

         this.d = DateUtils.a(var2.c());
         this.e = var2.d();
         this.f = DateUtils.a(var2.e());
         this.g = var2.f();
         this.h = var2.g();
         this.i = var2.h();
         this.j = var2.i();
      }

      public CaseFeedModel.ActorModel a() {
         return this.b;
      }

      public CaseFeedModel.BodyModel b() {
         return this.c;
      }

      @Override
      public Date c() {
         return this.d;
      }
   }

   public class PhotoModel {
      final CaseFeedModel a;
      private String b;
      private String c;
      private String d;
      private String e;
      private String f;
      private String g;

      private PhotoModel(CaseFeedModel var1, PhotoResponse var2) {
         this.a = var1;
         this.b = var2.a();
         this.c = var2.b();
         this.d = var2.c();
         this.e = var2.d();
         this.f = var2.e();
         this.g = var2.f();
      }
   }
}
