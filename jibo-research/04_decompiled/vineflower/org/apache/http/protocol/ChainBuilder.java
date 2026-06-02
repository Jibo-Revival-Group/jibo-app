package org.apache.http.protocol;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
final class ChainBuilder<E> {
   private final LinkedList<E> list = new LinkedList<>();
   private final Map<Class<?>, E> uniqueClasses = new HashMap<>();

   public ChainBuilder() {
   }

   private void ensureUnique(E var1) {
      Object var2 = this.uniqueClasses.remove(var1.getClass());
      if (var2 != null) {
         this.list.remove(var2);
      }

      this.uniqueClasses.put(var1.getClass(), (E)var1);
   }

   public ChainBuilder<E> addAllFirst(Collection<E> var1) {
      if (var1 != null) {
         Iterator var2 = var1.iterator();

         while (var2.hasNext()) {
            this.addFirst((E)var2.next());
         }
      }

      return this;
   }

   public ChainBuilder<E> addAllFirst(E... var1) {
      if (var1 != null) {
         int var3 = var1.length;

         for (int var2 = 0; var2 < var3; var2++) {
            this.addFirst((E)var1[var2]);
         }
      }

      return this;
   }

   public ChainBuilder<E> addAllLast(Collection<E> var1) {
      if (var1 != null) {
         Iterator var2 = var1.iterator();

         while (var2.hasNext()) {
            this.addLast((E)var2.next());
         }
      }

      return this;
   }

   public ChainBuilder<E> addAllLast(E... var1) {
      if (var1 != null) {
         int var3 = var1.length;

         for (int var2 = 0; var2 < var3; var2++) {
            this.addLast((E)var1[var2]);
         }
      }

      return this;
   }

   public ChainBuilder<E> addFirst(E var1) {
      if (var1 != null) {
         this.ensureUnique((E)var1);
         this.list.addFirst((E)var1);
      }

      return this;
   }

   public ChainBuilder<E> addLast(E var1) {
      if (var1 != null) {
         this.ensureUnique((E)var1);
         this.list.addLast((E)var1);
      }

      return this;
   }

   public LinkedList<E> build() {
      return new LinkedList<>(this.list);
   }
}
