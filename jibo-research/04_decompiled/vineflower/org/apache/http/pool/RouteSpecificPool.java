package org.apache.http.pool;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

@NotThreadSafe
abstract class RouteSpecificPool<T, C, E extends PoolEntry<T, C>> {
   private final LinkedList<E> available;
   private final Set<E> leased;
   private final LinkedList<PoolEntryFuture<E>> pending;
   private final T route;

   RouteSpecificPool(T var1) {
      this.route = (T)var1;
      this.leased = new HashSet<>();
      this.available = new LinkedList<>();
      this.pending = new LinkedList<>();
   }

   public E add(C var1) {
      var1 = this.createEntry((C)var1);
      this.leased.add((E)var1);
      return (E)var1;
   }

   protected abstract E createEntry(C var1);

   public void free(E var1, boolean var2) {
      Args.notNull(var1, "Pool entry");
      Asserts.check(this.leased.remove(var1), "Entry %s has not been leased from this pool", var1);
      if (var2) {
         this.available.addFirst((E)var1);
      }
   }

   public int getAllocatedCount() {
      return this.available.size() + this.leased.size();
   }

   public int getAvailableCount() {
      return this.available.size();
   }

   public E getFree(Object var1) {
      if (!this.available.isEmpty()) {
         if (var1 != null) {
            Iterator var3 = this.available.iterator();

            while (var3.hasNext()) {
               PoolEntry var2 = (PoolEntry)var3.next();
               if (var1.equals(var2.getState())) {
                  var3.remove();
                  this.leased.add((E)var2);
                  var1 = var2;
                  return (E)var1;
               }
            }
         }

         Iterator var5 = this.available.iterator();

         while (var5.hasNext()) {
            var1 = (PoolEntry)var5.next();
            if (var1.getState() == null) {
               var5.remove();
               this.leased.add((E)var1);
               return (E)var1;
            }
         }
      }

      return null;
   }

   public E getLastUsed() {
      PoolEntry var1;
      if (!this.available.isEmpty()) {
         var1 = this.available.getLast();
      } else {
         var1 = null;
      }

      return (E)var1;
   }

   public int getLeasedCount() {
      return this.leased.size();
   }

   public int getPendingCount() {
      return this.pending.size();
   }

   public final T getRoute() {
      return this.route;
   }

   public PoolEntryFuture<E> nextPending() {
      return this.pending.poll();
   }

   public void queue(PoolEntryFuture<E> var1) {
      if (var1 != null) {
         this.pending.add(var1);
      }
   }

   public boolean remove(E var1) {
      Args.notNull(var1, "Pool entry");
      boolean var2;
      if (!this.available.remove(var1) && !this.leased.remove(var1)) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   public void shutdown() {
      Iterator var1 = this.pending.iterator();

      while (var1.hasNext()) {
         ((PoolEntryFuture)var1.next()).cancel(true);
      }

      this.pending.clear();
      var1 = this.available.iterator();

      while (var1.hasNext()) {
         ((PoolEntry)var1.next()).close();
      }

      this.available.clear();
      var1 = this.leased.iterator();

      while (var1.hasNext()) {
         ((PoolEntry)var1.next()).close();
      }

      this.leased.clear();
   }

   @Override
   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("[route: ");
      var1.append(this.route);
      var1.append("][leased: ");
      var1.append(this.leased.size());
      var1.append("][available: ");
      var1.append(this.available.size());
      var1.append("][pending: ");
      var1.append(this.pending.size());
      var1.append("]");
      return var1.toString();
   }

   public void unqueue(PoolEntryFuture<E> var1) {
      if (var1 != null) {
         this.pending.remove(var1);
      }
   }
}
