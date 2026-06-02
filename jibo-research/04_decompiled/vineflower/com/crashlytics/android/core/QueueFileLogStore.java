package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.QueueFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

class QueueFileLogStore implements FileLogStore {
   private final File a;
   private final int b;
   private QueueFile c;

   public QueueFileLogStore(File var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   private void d() {
      if (this.c == null) {
         try {
            QueueFile var1 = new QueueFile(this.a);
            this.c = var1;
         } catch (IOException var2) {
            Fabric.h().e("CrashlyticsCore", "Could not open log file: " + this.a, var2);
         }
      }
   }

   @Override
   public ByteString a() {
      ByteString var1 = null;
      if (this.a.exists()) {
         this.d();
         if (this.c != null) {
            int[] var2 = new int[]{0};
            byte[] var6 = new byte[this.c.a()];

            try {
               QueueFile var4 = this.c;
               QueueFile.ElementReader var3 = new QueueFile.ElementReader(this, var6, var2) {
                  final byte[] a;
                  final int[] b;
                  final QueueFileLogStore c;

                  {
                     this.c = var1;
                     this.a = var2x;
                     this.b = var3x;
                  }

                  // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
                  // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
                  @Override
                  public void a(InputStream var1, int var2x) throws IOException {
                     boolean var5 = false /* VF: Semaphore variable */;

                     int[] var3x;
                     try {
                        var5 = true;
                        var1.read(this.a, this.b[0], var2x);
                        var3x = this.b;
                        var5 = false;
                     } finally {
                        if (var5) {
                           var1.close();
                        }
                     }

                     var3x[0] += var2x;
                     var1.close();
                  }
               };
               var4.a(var3);
            } catch (IOException var5) {
               Fabric.h().e("CrashlyticsCore", "A problem occurred while reading the Crashlytics log file.", var5);
            }

            var1 = ByteString.a(var6, 0, var2[0]);
         }
      }

      return var1;
   }

   @Override
   public void b() {
      CommonUtils.a(this.c, "There was a problem closing the Crashlytics log file.");
      this.c = null;
   }

   @Override
   public void c() {
      this.b();
      this.a.delete();
   }
}
