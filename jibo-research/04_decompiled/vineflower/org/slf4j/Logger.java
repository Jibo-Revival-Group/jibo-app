package org.slf4j;

public interface Logger {
   void a(String var1);

   void a(String var1, Object var2);

   void a(String var1, Object var2, Object var3);

   void a(String var1, Throwable var2);

   void a(String var1, Object... var2);

   void b(String var1);
}
