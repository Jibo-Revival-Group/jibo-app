package com.facebook;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.util.Pair;
import com.facebook.internal.NativeAppCallAttachmentStore;
import java.io.FileNotFoundException;
import java.util.UUID;

public class FacebookContentProvider extends ContentProvider {
   private static final String ATTACHMENT_URL_BASE = "content://com.facebook.app.FacebookContentProvider";
   private static final String TAG = FacebookContentProvider.class.getName();

   public static String getAttachmentUrl(String var0, UUID var1, String var2) {
      return String.format("%s%s/%s/%s", "content://com.facebook.app.FacebookContentProvider", var0, var1.toString(), var2);
   }

   public int delete(Uri var1, String var2, String[] var3) {
      return 0;
   }

   public String getType(Uri var1) {
      return null;
   }

   public Uri insert(Uri var1, ContentValues var2) {
      return null;
   }

   public boolean onCreate() {
      return true;
   }

   public ParcelFileDescriptor openFile(Uri var1, String var2) throws FileNotFoundException {
      Pair var4 = this.parseCallIdAndAttachmentName(var1);
      if (var4 == null) {
         throw new FileNotFoundException();
      }

      try {
         return ParcelFileDescriptor.open(NativeAppCallAttachmentStore.openAttachment((UUID)var4.first, (String)var4.second), 268435456);
      } catch (FileNotFoundException var3) {
         Log.e(TAG, "Got unexpected exception:" + var3);
         throw var3;
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   Pair<UUID, String> parseCallIdAndAttachmentName(Uri var1) {
      String[] var2;
      try {
         var2 = var1.getPath().substring(1).split("/");
      } catch (Exception var5) {
         return null;
      }

      String var7 = var2[0];
      String var8 = var2[1];

      try {
         UUID var3 = UUID.fromString(var7);
         var6 = new Pair(var3, var8);
      } catch (Exception var4) {
         var6 = null;
      }

      return var6;
   }

   public Cursor query(Uri var1, String[] var2, String var3, String[] var4, String var5) {
      return null;
   }

   public int update(Uri var1, ContentValues var2, String var3, String[] var4) {
      return 0;
   }
}
