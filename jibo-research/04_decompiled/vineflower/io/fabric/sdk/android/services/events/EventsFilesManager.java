package io.fabric.sdk.android.services.events;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class EventsFilesManager<T> {
   protected final Context a;
   protected final EventTransform<T> b;
   protected final CurrentTimeProvider c;
   protected final EventsStorage d;
   protected volatile long e;
   protected final List<EventsStorageListener> f = new CopyOnWriteArrayList<>();
   private final int g;

   public EventsFilesManager(Context var1, EventTransform<T> var2, CurrentTimeProvider var3, EventsStorage var4, int var5) throws IOException {
      this.a = var1.getApplicationContext();
      this.b = var2;
      this.d = var4;
      this.c = var3;
      this.e = this.c.a();
      this.g = var5;
   }

   private void a(int var1) throws IOException {
      if (!this.d.a(var1, this.c())) {
         String var2 = String.format(
            Locale.US,
            "session analytics events file is %d bytes, new event is %d bytes, this is over flush limit of %d, rolling it over",
            this.d.a(),
            var1,
            this.c()
         );
         CommonUtils.a(this.a, 4, "Fabric", var2);
         this.d();
      }
   }

   private void b(String var1) {
      for (EventsStorageListener var3 : this.f) {
         try {
            var3.a(var1);
         } catch (Exception var4) {
            CommonUtils.a(this.a, "One of the roll over listeners threw an exception", var4);
         }
      }
   }

   public long a(String var1) {
      long var2 = 0L;
      String[] var7 = var1.split("_");
      if (var7.length == 3) {
         long var4;
         try {
            var4 = Long.valueOf(var7[2]);
         } catch (NumberFormatException var6) {
            return var2;
         }

         var2 = var4;
      }

      return var2;
   }

   protected abstract String a();

   public void a(EventsStorageListener var1) {
      if (var1 != null) {
         this.f.add(var1);
      }
   }

   public void a(T var1) throws IOException {
      var1 = this.b.a((T)var1);
      this.a(var1.length);
      this.d.a(var1);
   }

   public void a(List<File> var1) {
      this.d.a(var1);
   }

   protected int b() {
      return this.g;
   }

   protected int c() {
      return 8000;
   }

   public boolean d() throws IOException {
      boolean var1 = true;
      String var2 = null;
      if (!this.d.b()) {
         var2 = this.a();
         this.d.a(var2);
         CommonUtils.a(this.a, 4, "Fabric", String.format(Locale.US, "generated new file %s", var2));
         this.e = this.c.a();
      } else {
         var1 = false;
      }

      this.b(var2);
      return var1;
   }

   public List<File> e() {
      return this.d.a(1);
   }

   public void f() {
      this.d.a(this.d.c());
      this.d.d();
   }

   public void g() {
      ArrayList var4 = this.d.c();
      int var2 = this.b();
      if (var4.size() > var2) {
         int var1 = var4.size() - var2;
         CommonUtils.a(
            this.a,
            String.format(Locale.US, "Found %d files in  roll over directory, this is greater than %d, deleting %d oldest files", var4.size(), var2, var1)
         );
         TreeSet var3 = new TreeSet<>(new Comparator<EventsFilesManager.FileWithTimestamp>(this) {
            final EventsFilesManager a;

            {
               this.a = var1;
            }

            public int a(EventsFilesManager.FileWithTimestamp var1, EventsFilesManager.FileWithTimestamp var2x) {
               return (int)(var1.b - var2x.b);
            }
         });

         for (File var7 : var4) {
            var3.add(new EventsFilesManager.FileWithTimestamp(var7, this.a(var7.getName())));
         }

         var4 = new ArrayList();
         Iterator var6 = var3.iterator();

         while (var6.hasNext()) {
            var4.add(((EventsFilesManager.FileWithTimestamp)var6.next()).a);
            if (var4.size() == var1) {
               break;
            }
         }

         this.d.a(var4);
      }
   }

   static class FileWithTimestamp {
      final File a;
      final long b;

      public FileWithTimestamp(File var1, long var2) {
         this.a = var1;
         this.b = var2;
      }
   }
}
