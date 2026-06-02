package com.firebase.jobdispatcher;

import android.os.Bundle;
import java.util.Arrays;
import org.json.JSONObject;

final class JobInvocation implements JobParameters {
   private final String a;
   private final String b;
   private final JobTrigger c;
   private final boolean d;
   private final int e;
   private final int[] f;
   private final Bundle g;
   private final RetryStrategy h;
   private final boolean i;
   private final TriggerReason j;

   private JobInvocation(JobInvocation.Builder var1) {
      this.a = var1.a;
      this.b = var1.b;
      this.c = var1.c;
      this.h = var1.h;
      this.d = var1.d;
      this.e = var1.e;
      this.f = var1.f;
      this.g = var1.g;
      this.i = var1.i;
      this.j = var1.j;
   }

   @Override
   public int[] a() {
      return this.f;
   }

   @Override
   public Bundle b() {
      return this.g;
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
      return this.a;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (var1 != null && this.getClass().equals(var1.getClass())) {
            var1 = var1;
            if (!this.a.equals(var1.a) || !this.b.equals(var1.b)) {
               var2 = false;
            }
         } else {
            var2 = false;
         }
      }

      return var2;
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
      return this.d;
   }

   @Override
   public int hashCode() {
      return this.a.hashCode() * 31 + this.b.hashCode();
   }

   @Override
   public String i() {
      return this.b;
   }

   @Override
   public String toString() {
      return "JobInvocation{tag='"
         + JSONObject.quote(this.a)
         + '\''
         + ", service='"
         + this.b
         + '\''
         + ", trigger="
         + this.c
         + ", recurring="
         + this.d
         + ", lifetime="
         + this.e
         + ", constraints="
         + Arrays.toString(this.f)
         + ", extras="
         + this.g
         + ", retryStrategy="
         + this.h
         + ", replaceCurrent="
         + this.i
         + ", triggerReason="
         + this.j
         + '}';
   }

   static final class Builder {
      private String a;
      private String b;
      private JobTrigger c;
      private boolean d;
      private int e;
      private int[] f;
      private final Bundle g = new Bundle();
      private RetryStrategy h;
      private boolean i;
      private TriggerReason j;

      public JobInvocation.Builder a(int var1) {
         this.e = var1;
         return this;
      }

      public JobInvocation.Builder a(Bundle var1) {
         if (var1 != null) {
            this.g.putAll(var1);
         }

         return this;
      }

      public JobInvocation.Builder a(JobTrigger var1) {
         this.c = var1;
         return this;
      }

      public JobInvocation.Builder a(RetryStrategy var1) {
         this.h = var1;
         return this;
      }

      public JobInvocation.Builder a(TriggerReason var1) {
         this.j = var1;
         return this;
      }

      public JobInvocation.Builder a(String var1) {
         this.a = var1;
         return this;
      }

      public JobInvocation.Builder a(boolean var1) {
         this.d = var1;
         return this;
      }

      public JobInvocation.Builder a(int[] var1) {
         this.f = var1;
         return this;
      }

      JobInvocation a() {
         if (this.a != null && this.b != null && this.c != null) {
            return new JobInvocation(this);
         } else {
            throw new IllegalArgumentException("Required fields were not populated.");
         }
      }

      public JobInvocation.Builder b(String var1) {
         this.b = var1;
         return this;
      }

      public JobInvocation.Builder b(boolean var1) {
         this.i = var1;
         return this;
      }
   }
}
