package com.firebase.jobdispatcher;

import android.net.Uri;

public final class ObservedUri {
   private final Uri a;
   private final int b;

   public ObservedUri(Uri var1, int var2) {
      if (var1 == null) {
         throw new IllegalArgumentException("URI must not be null.");
      }

      this.a = var1;
      this.b = var2;
   }

   public Uri a() {
      return this.a;
   }

   public int b() {
      return this.b;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (!(var1 instanceof ObservedUri)) {
            var2 = false;
         } else {
            var1 = var1;
            if (this.b != var1.b || !this.a.equals(var1.a)) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   @Override
   public int hashCode() {
      return this.a.hashCode() ^ this.b;
   }
}
