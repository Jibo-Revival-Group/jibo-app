package org.apache.http.pool;

public interface ConnPoolControl<T> {
   int getDefaultMaxPerRoute();

   int getMaxPerRoute(T var1);

   int getMaxTotal();

   PoolStats getStats(T var1);

   PoolStats getTotalStats();

   void setDefaultMaxPerRoute(int var1);

   void setMaxPerRoute(T var1, int var2);

   void setMaxTotal(int var1);
}
