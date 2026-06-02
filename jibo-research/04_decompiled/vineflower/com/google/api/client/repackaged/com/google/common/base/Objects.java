package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import java.util.Arrays;

@GwtCompatible
public final class Objects {
   private Objects() {
   }

   public static boolean equal(Object var0, Object var1) {
      boolean var2;
      if (var0 != var1 && (var0 == null || !var0.equals(var1))) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   public static <T> T firstNonNull(T var0, T var1) {
      if (var0 == null) {
         var0 = Preconditions.checkNotNull(var1);
      }

      return (T)var0;
   }

   public static int hashCode(Object... var0) {
      return Arrays.hashCode(var0);
   }

   private static String simpleName(Class<?> var0) {
      String var3 = var0.getName().replaceAll("\\$[0-9]+", "\\$");
      int var2 = var3.lastIndexOf(36);
      int var1 = var2;
      if (var2 == -1) {
         var1 = var3.lastIndexOf(46);
      }

      return var3.substring(var1 + 1);
   }

   public static Objects.ToStringHelper toStringHelper(Class<?> var0) {
      return new Objects.ToStringHelper(simpleName(var0));
   }

   public static Objects.ToStringHelper toStringHelper(Object var0) {
      return new Objects.ToStringHelper(simpleName(var0.getClass()));
   }

   public static Objects.ToStringHelper toStringHelper(String var0) {
      return new Objects.ToStringHelper(var0);
   }

   public static final class ToStringHelper {
      private final String className;
      private Objects.ToStringHelper.ValueHolder holderHead = new Objects.ToStringHelper.ValueHolder();
      private Objects.ToStringHelper.ValueHolder holderTail = this.holderHead;
      private boolean omitNullValues = false;

      private ToStringHelper(String var1) {
         this.className = Preconditions.checkNotNull(var1);
      }

      private Objects.ToStringHelper.ValueHolder addHolder() {
         Objects.ToStringHelper.ValueHolder var1 = new Objects.ToStringHelper.ValueHolder();
         this.holderTail.next = var1;
         this.holderTail = var1;
         return var1;
      }

      private Objects.ToStringHelper addHolder(Object var1) {
         this.addHolder().value = var1;
         return this;
      }

      private Objects.ToStringHelper addHolder(String var1, Object var2) {
         Objects.ToStringHelper.ValueHolder var3 = this.addHolder();
         var3.value = var2;
         var3.name = Preconditions.checkNotNull(var1);
         return this;
      }

      public Objects.ToStringHelper add(String var1, char var2) {
         return this.addHolder(var1, String.valueOf(var2));
      }

      public Objects.ToStringHelper add(String var1, double var2) {
         return this.addHolder(var1, String.valueOf(var2));
      }

      public Objects.ToStringHelper add(String var1, float var2) {
         return this.addHolder(var1, String.valueOf(var2));
      }

      public Objects.ToStringHelper add(String var1, int var2) {
         return this.addHolder(var1, String.valueOf(var2));
      }

      public Objects.ToStringHelper add(String var1, long var2) {
         return this.addHolder(var1, String.valueOf(var2));
      }

      public Objects.ToStringHelper add(String var1, Object var2) {
         return this.addHolder(var1, var2);
      }

      public Objects.ToStringHelper add(String var1, boolean var2) {
         return this.addHolder(var1, String.valueOf(var2));
      }

      public Objects.ToStringHelper addValue(char var1) {
         return this.addHolder(String.valueOf(var1));
      }

      public Objects.ToStringHelper addValue(double var1) {
         return this.addHolder(String.valueOf(var1));
      }

      public Objects.ToStringHelper addValue(float var1) {
         return this.addHolder(String.valueOf(var1));
      }

      public Objects.ToStringHelper addValue(int var1) {
         return this.addHolder(String.valueOf(var1));
      }

      public Objects.ToStringHelper addValue(long var1) {
         return this.addHolder(String.valueOf(var1));
      }

      public Objects.ToStringHelper addValue(Object var1) {
         return this.addHolder(var1);
      }

      public Objects.ToStringHelper addValue(boolean var1) {
         return this.addHolder(String.valueOf(var1));
      }

      public Objects.ToStringHelper omitNullValues() {
         this.omitNullValues = true;
         return this;
      }

      @Override
      public String toString() {
         boolean var1 = this.omitNullValues;
         StringBuilder var5 = new StringBuilder(32).append(this.className).append('{');
         Objects.ToStringHelper.ValueHolder var2 = this.holderHead.next;
         String var3 = "";

         while (var2 != null) {
            String var4;
            label26: {
               if (var1) {
                  var4 = var3;
                  if (var2.value == null) {
                     break label26;
                  }
               }

               var5.append(var3);
               var4 = ", ";
               if (var2.name != null) {
                  var5.append(var2.name).append('=');
               }

               var5.append(var2.value);
            }

            var2 = var2.next;
            var3 = var4;
         }

         return var5.append('}').toString();
      }

      private static final class ValueHolder {
         String name;
         Objects.ToStringHelper.ValueHolder next;
         Object value;

         private ValueHolder() {
         }
      }
   }
}
