package com.salesforce.androidsdk.analytics.store;

import android.content.Context;
import android.text.TextUtils;
import com.salesforce.androidsdk.analytics.model.InstrumentationEvent;
import com.salesforce.androidsdk.analytics.security.Encryptor;
import com.salesforce.androidsdk.analytics.util.SalesforceAnalyticsLogger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class EventStoreManager {
   private String a;
   private File b;
   private EventStoreManager.EventFileFilter c;
   private Context d;
   private String e;
   private boolean f = true;
   private int g = 1000;

   public EventStoreManager(String var1, Context var2, String var3) {
      this.a = var1;
      this.d = var2;
      this.e = var3;
      this.c = new EventStoreManager.EventFileFilter(var1);
      this.b = var2.getFilesDir();
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private InstrumentationEvent a(File var1) {
      Object var3 = null;
      InstrumentationEvent var2;
      if (var1 != null && var1.exists()) {
         StringBuilder var13 = new StringBuilder();

         label42: {
            BufferedReader var4;
            try {
               FileReader var5 = new FileReader(var1);
               var4 = new BufferedReader(var5);
            } catch (Exception var10) {
               SalesforceAnalyticsLogger.a(this.d, "EventStoreManager", "Exception occurred while attempting to read file contents", var10);
               var11 = null;
               break label42;
            }

            while (true) {
               try {
                  var12 = var4.readLine();
               } catch (Exception var8) {
                  SalesforceAnalyticsLogger.a(this.d, "EventStoreManager", "Exception occurred while attempting to read file contents", var8);
                  var11 = null;
                  break;
               }

               if (var12 == null) {
                  try {
                     var4.close();
                     var11 = this.c(var13.toString());
                  } catch (Exception var7) {
                     SalesforceAnalyticsLogger.a(this.d, "EventStoreManager", "Exception occurred while attempting to read file contents", var7);
                     var11 = null;
                  }
                  break;
               }

               try {
                  var13.append(var12).append('\n');
               } catch (Exception var9) {
                  SalesforceAnalyticsLogger.a(this.d, "EventStoreManager", "Exception occurred while attempting to read file contents", var9);
                  var11 = null;
                  break;
               }
            }
         }

         var2 = (InstrumentationEvent)var3;
         if (!TextUtils.isEmpty(var11)) {
            try {
               JSONObject var14 = new JSONObject(var11);
               var2 = new InstrumentationEvent(var14);
            } catch (JSONException var6) {
               SalesforceAnalyticsLogger.a(this.d, "EventStoreManager", "Exception occurred while attempting to convert to JSON", var6);
               var2 = (InstrumentationEvent)var3;
            }
         }
      } else {
         SalesforceAnalyticsLogger.a(this.d, "EventStoreManager", "File does not exist");
         var2 = (InstrumentationEvent)var3;
      }

      return var2;
   }

   private String b(String var1) {
      return Encryptor.b(var1, this.e);
   }

   private String c(String var1) {
      return Encryptor.a(var1, this.e);
   }

   private boolean c() {
      boolean var3 = false;
      List var4 = this.d();
      int var1;
      if (var4 != null) {
         var1 = var4.size();
      } else {
         var1 = 0;
      }

      boolean var2 = var3;
      if (this.f) {
         var2 = var3;
         if (var1 < this.g) {
            var2 = true;
         }
      }

      return var2;
   }

   private List<File> d() {
      ArrayList var4 = new ArrayList();

      for (File var3 : this.b.listFiles()) {
         if (var3 != null && this.c.accept(this.b, var3.getName())) {
            var4.add(var3);
         }
      }

      return var4;
   }

   public List<InstrumentationEvent> a() {
      List var2 = this.d();
      ArrayList var1 = new ArrayList();
      Iterator var3 = var2.iterator();

      while (var3.hasNext()) {
         InstrumentationEvent var4 = this.a((File)var3.next());
         if (var4 != null) {
            var1.add(var4);
         }
      }

      return var1;
   }

   public void a(InstrumentationEvent var1) {
      if (var1 == null || TextUtils.isEmpty(var1.t().toString())) {
         SalesforceAnalyticsLogger.b(this.d, "EventStoreManager", "Invalid event");
      } else if (this.c()) {
         String var2 = var1.a() + this.a;

         try {
            FileOutputStream var4 = this.d.openFileOutput(var2, 0);
            var4.write(this.b(var1.t().toString()).getBytes());
            var4.close();
         } catch (Exception var3) {
            SalesforceAnalyticsLogger.a(this.d, "EventStoreManager", "Exception occurred while saving event to filesystem", var3);
         }
      }
   }

   public void a(String var1, String var2) {
      List var3 = this.a();
      this.b();
      this.e = var2;
      this.a(var3);
   }

   public void a(List<InstrumentationEvent> var1) {
      if (var1 == null || var1.size() == 0) {
         SalesforceAnalyticsLogger.b(this.d, "EventStoreManager", "No events to store");
      } else if (this.c()) {
         Iterator var2 = var1.iterator();

         while (var2.hasNext()) {
            this.a((InstrumentationEvent)var2.next());
         }
      }
   }

   public void a(boolean var1) {
      synchronized (this) {
         this.f = var1;
      }
   }

   public boolean a(String var1) {
      boolean var2;
      if (TextUtils.isEmpty(var1)) {
         SalesforceAnalyticsLogger.a(this.d, "EventStoreManager", "Invalid event ID supplied: " + var1);
         var2 = false;
      } else {
         var1 = var1 + this.a;
         var2 = new File(this.b, var1).delete();
      }

      return var2;
   }

   public void b() {
      Iterator var1 = this.d().iterator();

      while (var1.hasNext()) {
         ((File)var1.next()).delete();
      }
   }

   public void b(List<String> var1) {
      if (var1 != null && var1.size() != 0) {
         Iterator var2 = var1.iterator();

         while (var2.hasNext()) {
            this.a((String)var2.next());
         }
      } else {
         SalesforceAnalyticsLogger.b(this.d, "EventStoreManager", "No events to delete");
      }
   }

   private static class EventFileFilter implements FilenameFilter {
      private String a;

      public EventFileFilter(String var1) {
         this.a = var1;
      }

      @Override
      public boolean accept(File var1, String var2) {
         boolean var3;
         if (var2 != null && var2.endsWith(this.a)) {
            var3 = true;
         } else {
            var3 = false;
         }

         return var3;
      }
   }
}
