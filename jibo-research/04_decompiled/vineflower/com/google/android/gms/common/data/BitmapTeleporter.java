package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class BitmapTeleporter extends zzbfm implements ReflectedParcelable {
   public static final Creator<BitmapTeleporter> CREATOR = new zza();
   private int a;
   private ParcelFileDescriptor b;
   private int c;
   private Bitmap d;
   private boolean e;
   private File f;

   BitmapTeleporter(int var1, ParcelFileDescriptor var2, int var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = null;
      this.e = false;
   }

   private static void a(Closeable var0) {
      try {
         var0.close();
      } catch (IOException var1) {
         Log.w("BitmapTeleporter", "Could not close stream", var1);
      }
   }

   private final FileOutputStream b() {
      if (this.f == null) {
         throw new IllegalStateException("setTempDir() must be called before writing this object to a parcel");
      }

      File var1;
      try {
         var1 = File.createTempFile("teleporter", ".tmp", this.f);
      } catch (IOException var4) {
         throw new IllegalStateException("Could not create temporary file", var4);
      }

      FileOutputStream var2;
      try {
         var2 = new FileOutputStream(var1);
         this.b = ParcelFileDescriptor.open(var1, 268435456);
      } catch (FileNotFoundException var3) {
         throw new IllegalStateException("Temporary file is somehow already deleted");
      }

      var1.delete();
      return var2;
   }

   public final Bitmap a() {
      if (!this.e) {
         DataInputStream var3 = new DataInputStream(new AutoCloseInputStream(this.b));

         int var1;
         int var2;
         byte[] var5;
         Config var11;
         try {
            var5 = new byte[var3.readInt()];
            var1 = var3.readInt();
            var2 = var3.readInt();
            var11 = Config.valueOf(var3.readUTF());
            var3.read(var5);
         } catch (IOException var8) {
            IllegalStateException var4 = new IllegalStateException("Could not read from parcel file descriptor", var8);
            throw var4;
         } finally {
            a(var3);
         }

         ByteBuffer var10 = ByteBuffer.wrap(var5);
         Bitmap var12 = Bitmap.createBitmap(var1, var2, var11);
         var12.copyPixelsFromBuffer(var10);
         this.d = var12;
         this.e = true;
      }

      return this.d;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if (this.b == null) {
         Bitmap var5 = this.d;
         ByteBuffer var4 = ByteBuffer.allocate(var5.getRowBytes() * var5.getHeight());
         var5.copyPixelsToBuffer(var4);
         byte[] var6 = var4.array();
         DataOutputStream var12 = new DataOutputStream(new BufferedOutputStream(this.b()));

         try {
            var12.writeInt(var6.length);
            var12.writeInt(var5.getWidth());
            var12.writeInt(var5.getHeight());
            var12.writeUTF(var5.getConfig().toString());
            var12.write(var6);
         } catch (IOException var9) {
            IllegalStateException var11 = new IllegalStateException("Could not write into unlinked file", var9);
            throw var11;
         } finally {
            a(var12);
         }
      }

      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a);
      zzbfp.a(var1, 2, this.b, var2 | 1, false);
      zzbfp.a(var1, 3, this.c);
      zzbfp.a(var1, var3);
      this.b = null;
   }
}
