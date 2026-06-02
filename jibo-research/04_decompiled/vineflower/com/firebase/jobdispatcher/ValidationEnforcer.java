package com.firebase.jobdispatcher;

import android.text.TextUtils;
import java.util.List;

public class ValidationEnforcer implements JobValidator {
   private final JobValidator a;

   public ValidationEnforcer(JobValidator var1) {
      this.a = var1;
   }

   private static void a(List<String> var0) {
      if (var0 != null) {
         throw new ValidationEnforcer.ValidationException("JobParameters is invalid", var0);
      }
   }

   @Override
   public List<String> a(JobParameters var1) {
      return this.a.a(var1);
   }

   public final void b(JobParameters var1) {
      a(this.a(var1));
   }

   public static final class ValidationException extends RuntimeException {
      private final List<String> a;

      public ValidationException(String var1, List<String> var2) {
         super(var1 + ": " + TextUtils.join("\n  - ", var2));
         this.a = var2;
      }
   }
}
