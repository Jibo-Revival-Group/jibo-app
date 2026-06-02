package android.support.v4.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.OperationCanceledException;
import android.os.Build.VERSION;
import android.support.v4.os.CancellationSignal;

public final class ContentResolverCompat {
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static Cursor a(ContentResolver var0, Uri var1, String[] var2, String var3, String[] var4, String var5, CancellationSignal var6) {
      if (VERSION.SDK_INT < 16) {
         if (var6 != null) {
            var6.b();
         }

         return var0.query(var1, var2, var3, var4, var5);
      } else {
         Object var11;
         if (var6 != null) {
            try {
               var11 = var6.d();
            } catch (Exception var8) {
               if (var8 instanceof OperationCanceledException) {
                  throw new android.support.v4.os.OperationCanceledException();
               }

               throw var8;
            }
         } else {
            var11 = null;
         }

         try {
            return var0.query(var1, var2, var3, var4, var5, (android.os.CancellationSignal)var11);
         } catch (Exception var7) {
            if (var7 instanceof OperationCanceledException) {
               throw new android.support.v4.os.OperationCanceledException();
            } else {
               throw var7;
            }
         }
      }
   }
}
