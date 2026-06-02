package com.firebase.jobdispatcher;

import android.os.Bundle;

public final class Job implements JobParameters {
   private final String a;
   private final String b;
   private final JobTrigger c;
   private final RetryStrategy d;
   private final int e;
   private final boolean f;
   private final int[] g;
   private final boolean h;
   private final Bundle i;

   private Job(Job.Builder var1) {
      this.a = var1.b;
      Bundle var2;
      if (var1.c == null) {
         var2 = null;
      } else {
         var2 = new Bundle(var1.c);
      }

      this.i = var2;
      this.b = var1.d;
      this.c = var1.e;
      this.d = var1.h;
      this.e = var1.f;
      this.f = var1.j;
      int[] var3;
      if (var1.g != null) {
         var3 = var1.g;
      } else {
         var3 = new int[0];
      }

      this.g = var3;
      this.h = var1.i;
   }

   @Override
   public int[] a() {
      return this.g;
   }

   @Override
   public Bundle b() {
      return this.i;
   }

   @Override
   public RetryStrategy c() {
      return this.d;
   }

   @Override
   public boolean d() {
      return this.h;
   }

   @Override
   public String e() {
      return this.b;
   }

   @Override
   public JobTrigger f() {
      return this.c;
   }

   @Override
   public int g() {
      return this.e;
   }

   @Override
   public boolean h() {
      return this.f;
   }

   @Override
   public String i() {
      return this.a;
   }

   public static final class Builder implements JobParameters {
      private final ValidationEnforcer a;
      private String b;
      private Bundle c;
      private String d;
      private JobTrigger e = Trigger.a;
      private int f = 1;
      private int[] g;
      private RetryStrategy h = RetryStrategy.a;
      private boolean i = false;
      private boolean j = false;

      Builder(ValidationEnforcer var1) {
         this.a = var1;
      }

      Builder(ValidationEnforcer var1, JobParameters var2) {
         this.a = var1;
         this.d = var2.e();
         this.b = var2.i();
         this.e = var2.f();
         this.j = var2.h();
         this.f = var2.g();
         this.g = var2.a();
         this.c = var2.b();
         this.h = var2.c();
      }

      public Job.Builder a(int var1) {
         this.f = var1;
         return this;
      }

      public Job.Builder a(JobTrigger var1) {
         this.e = var1;
         return this;
      }

      public Job.Builder a(Class<? extends JobService> var1) {
         String var2;
         if (var1 == null) {
            var2 = null;
         } else {
            var2 = var1.getName();
         }

         this.b = var2;
         return this;
      }

      public Job.Builder a(String var1) {
         this.d = var1;
         return this;
      }

      public Job.Builder a(boolean var1) {
         this.i = var1;
         return this;
      }

      public Job.Builder a(int... var1) {
         this.g = var1;
         return this;
      }

      @Override
      public int[] a() {
         int[] var1;
         if (this.g == null) {
            var1 = new int[0];
         } else {
            var1 = this.g;
         }

         return var1;
      }

      @Override
      public Bundle b() {
         return this.c;
      }

      public Job.Builder b(boolean var1) {
         this.j = var1;
         return this;
      }

      @Override
      public RetryStrategy c() {
         return this.h;
      }

      @Override
      public boolean d() {
         return this.i;
      }

      @Override
      public String e() {
         return this.d;
      }

      @Override
      public JobTrigger f() {
         return this.e;
      }

      @Override
      public int g() {
         return this.f;
      }

      @Override
      public boolean h() {
         return this.j;
      }

      @Override
      public String i() {
         return this.b;
      }

      public Job j() {
         this.a.b(this);
         return new Job(this);
      }
   }
}
