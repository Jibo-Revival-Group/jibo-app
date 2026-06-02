package com.salesforce.androidsdk.analytics.logger;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Log;
import com.squareup.tape.QueueFile;
import java.io.File;
import java.io.IOException;

public class FileLogger {
   private Context a;
   private String b;
   private QueueFile c;
   private int d;

   public FileLogger(Context var1, String var2) throws IOException {
      this.a = var1;
      this.b = var2;
      this.b();
      this.c = new QueueFile(new File(var1.getFilesDir(), var2 + "_log"));
   }

   private void a(int var1) {
      synchronized (this) {
         Editor var2 = this.a.getSharedPreferences("sf_file_logger_prefs", 0).edit();
         var2.putInt(this.b, var1);
         var2.commit();
         this.d = var1;
      }
   }

   private void b() {
      SharedPreferences var1 = this.a.getSharedPreferences("sf_file_logger_prefs", 0);
      if (!var1.contains(this.b)) {
         this.a(10000);
      }

      this.d = var1.getInt(this.b, 10000);
   }

   public int a() {
      return this.c.b();
   }

   public void a(String var1) {
      if (!TextUtils.isEmpty(var1)) {
         while (true) {
            try {
               if (this.a() < this.d) {
                  if (this.d > 0) {
                     this.c.a(var1.getBytes("UTF-8"));
                  }
                  break;
               }

               this.c.c();
            } catch (Exception var2) {
               Log.e("FileLogger", "Failed to write log line", var2);
               break;
            }
         }
      }
   }
}
