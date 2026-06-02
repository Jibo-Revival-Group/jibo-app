package com.salesforce.android.cases.core.internal.model;

import com.salesforce.android.cases.core.internal.http.response.CaseDetailResponse;
import com.salesforce.android.cases.core.model.CaseDetailRecord;
import java.util.Date;
import java.util.Map;

public class CaseDetailRecordModel implements CaseDetailRecord {
   private String A;
   private Date B;
   private Date C;
   private String D;
   private String E;
   private String F;
   private Map<String, String> G;
   private String a;
   private boolean b;
   private String c;
   private String d;
   private String e;
   private String f;
   private String g;
   private String h;
   private String i;
   private String j;
   private String k;
   private String l;
   private String m;
   private String n;
   private String o;
   private String p;
   private String q;
   private boolean r;
   private Date s;
   private boolean t;
   private boolean u;
   private boolean v;
   private String w;
   private Date x;
   private String y;
   private Date z;

   CaseDetailRecordModel(CaseDetailResponse var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("CaseDetailResponse cannot be null");
      }

      this.a = var1.a();
      this.b = var1.b();
      this.c = var1.c();
      this.d = var1.d();
      this.e = var1.e();
      this.f = var1.f();
      this.g = var1.g();
      this.h = var1.h();
      this.i = var1.i();
      this.j = var1.j();
      this.k = var1.k();
      this.l = var1.l();
      this.m = var1.m();
      this.n = var1.n();
      this.o = var1.o();
      this.p = var1.p();
      this.q = var1.q();
      this.r = var1.r();
      this.s = var1.s();
      this.t = var1.t();
      this.u = var1.u();
      this.v = var1.v();
      this.w = var1.w();
      this.x = var1.x();
      this.y = var1.y();
      this.z = var1.z();
      this.A = var1.A();
      this.B = var1.B();
      this.C = var1.C();
      this.D = var1.D();
      this.E = var1.E();
      this.F = var1.F();
      this.G = var1.G();
   }

   public static CaseDetailRecordModel a(CaseDetailResponse var0) {
      return new CaseDetailRecordModel(var0);
   }

   @Override
   public String A() {
      return this.F;
   }

   @Override
   public Map<String, String> B() {
      return this.G;
   }

   @Override
   public String a() {
      return this.a;
   }

   @Override
   public String b() {
      return this.c;
   }

   @Override
   public String c() {
      return this.d;
   }

   @Override
   public String d() {
      return this.e;
   }

   @Override
   public String e() {
      return this.f;
   }

   @Override
   public String f() {
      return this.g;
   }

   @Override
   public String g() {
      return this.h;
   }

   @Override
   public String h() {
      return this.i;
   }

   @Override
   public String i() {
      return this.j;
   }

   @Override
   public String j() {
      return this.k;
   }

   @Override
   public String k() {
      return this.l;
   }

   @Override
   public String l() {
      return this.m;
   }

   @Override
   public String m() {
      return this.n;
   }

   @Override
   public String n() {
      return this.o;
   }

   @Override
   public String o() {
      return this.p;
   }

   @Override
   public String p() {
      return this.q;
   }

   @Override
   public Date q() {
      return this.s;
   }

   @Override
   public String r() {
      return this.w;
   }

   @Override
   public Date s() {
      return this.x;
   }

   @Override
   public String t() {
      return this.y;
   }

   @Override
   public Date u() {
      return this.z;
   }

   @Override
   public String v() {
      return this.A;
   }

   @Override
   public Date w() {
      return this.B;
   }

   @Override
   public Date x() {
      return this.C;
   }

   @Override
   public String y() {
      return this.D;
   }

   @Override
   public String z() {
      return this.E;
   }
}
