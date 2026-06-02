package com.google.api.client.util;

public final class Objects {
   private Objects() {
   }

   public static boolean equal(Object var0, Object var1) {
      return com.google.api.client.repackaged.com.google.common.base.Objects.equal(var0, var1);
   }

   public static Objects.ToStringHelper toStringHelper(Object var0) {
      return new Objects.ToStringHelper(var0.getClass().getSimpleName());
   }

   public static final class ToStringHelper {
      private final String className;
      private Objects.ToStringHelper.ValueHolder holderHead = new Objects.ToStringHelper.ValueHolder();
      private Objects.ToStringHelper.ValueHolder holderTail = this.holderHead;
      private boolean omitNullValues;

      ToStringHelper(String var1) {
         this.className = var1;
      }

      private Objects.ToStringHelper.ValueHolder addHolder() {
         Objects.ToStringHelper.ValueHolder var1 = new Objects.ToStringHelper.ValueHolder();
         this.holderTail.next = var1;
         this.holderTail = var1;
         return var1;
      }

      private Objects.ToStringHelper addHolder(String var1, Object var2) {
         Objects.ToStringHelper.ValueHolder var3 = this.addHolder();
         var3.value = var2;
         var3.name = Preconditions.checkNotNull(var1);
         return this;
      }

      public Objects.ToStringHelper add(String var1, Object var2) {
         return this.addHolder(var1, var2);
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
