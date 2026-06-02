package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import com.facebook.FacebookException;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

public class AttributionIdentifiers {
   private static final String ANDROID_ID_COLUMN_NAME = "androidid";
   private static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
   private static final String ATTRIBUTION_ID_CONTENT_PROVIDER = "com.facebook.katana.provider.AttributionIdProvider";
   private static final String ATTRIBUTION_ID_CONTENT_PROVIDER_WAKIZASHI = "com.facebook.wakizashi.provider.AttributionIdProvider";
   private static final int CONNECTION_RESULT_SUCCESS = 0;
   private static final long IDENTIFIER_REFRESH_INTERVAL_MILLIS = 3600000L;
   private static final String LIMIT_TRACKING_COLUMN_NAME = "limit_tracking";
   private static final String TAG = AttributionIdentifiers.class.getCanonicalName();
   private static AttributionIdentifiers recentlyFetchedIdentifiers;
   private String androidAdvertiserId;
   private String androidInstallerPackage;
   private String attributionId;
   private long fetchTime;
   private boolean limitTracking;

   private static AttributionIdentifiers cacheAndReturnIdentifiers(AttributionIdentifiers var0) {
      var0.fetchTime = System.currentTimeMillis();
      recentlyFetchedIdentifiers = var0;
      return var0;
   }

   private static AttributionIdentifiers getAndroidId(Context var0) {
      AttributionIdentifiers var2 = getAndroidIdViaReflection(var0);
      AttributionIdentifiers var1 = var2;
      if (var2 == null) {
         AttributionIdentifiers var3 = getAndroidIdViaService(var0);
         var1 = var3;
         if (var3 == null) {
            var1 = new AttributionIdentifiers();
         }
      }

      return var1;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static AttributionIdentifiers getAndroidIdViaReflection(Context var0) {
      try {
         if (Looper.myLooper() == Looper.getMainLooper()) {
            FacebookException var12 = new FacebookException("getAndroidId cannot be called on the main thread.");
            throw var12;
         }
      } catch (Exception var10) {
         Utility.logd("android_id", var10);
         return null;
      }

      Method var1;
      try {
         var1 = Utility.getMethodQuietly("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", Context.class);
      } catch (Exception var9) {
         Utility.logd("android_id", var9);
         return null;
      }

      Object var11;
      if (var1 == null) {
         var11 = null;
      } else {
         label93: {
            try {
               Object var13 = Utility.invokeMethodQuietly(null, var1, var0);
               if (!(var13 instanceof Integer) || (Integer)var13 != 0) {
                  break label93;
               }
            } catch (Exception var8) {
               Utility.logd("android_id", var8);
               return null;
            }

            try {
               var1 = Utility.getMethodQuietly("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", Context.class);
            } catch (Exception var7) {
               Utility.logd("android_id", var7);
               return null;
            }

            if (var1 == null) {
               return null;
            }

            Object var2;
            try {
               var2 = Utility.invokeMethodQuietly(null, var1, var0);
            } catch (Exception var6) {
               Utility.logd("android_id", var6);
               return null;
            }

            if (var2 == null) {
               return null;
            }

            Method var3;
            try {
               var3 = Utility.getMethodQuietly(var2.getClass(), "getId");
               var1 = Utility.getMethodQuietly(var2.getClass(), "isLimitAdTrackingEnabled");
            } catch (Exception var5) {
               Utility.logd("android_id", var5);
               return null;
            }

            if (var3 != null && var1 != null) {
               try {
                  var11 = new AttributionIdentifiers();
                  var11.androidAdvertiserId = (String)Utility.invokeMethodQuietly(var2, var3);
                  var11.limitTracking = (Boolean)Utility.invokeMethodQuietly(var2, var1);
               } catch (Exception var4) {
                  Utility.logd("android_id", var4);
                  var11 = null;
               }

               return var11;
            } else {
               return null;
            }
         }

         var11 = null;
      }

      return var11;
   }

   private static AttributionIdentifiers getAndroidIdViaService(Context var0) {
      AttributionIdentifiers.GoogleAdServiceConnection var2 = new AttributionIdentifiers.GoogleAdServiceConnection();
      Intent var1 = new Intent("com.google.android.gms.ads.identifier.service.START");
      var1.setPackage("com.google.android.gms");
      if (var0.bindService(var1, var2, 1)) {
         try {
            AttributionIdentifiers.GoogleAdInfo var3 = new AttributionIdentifiers.GoogleAdInfo(var2.getBinder());
            var9 = new AttributionIdentifiers();
            var9.androidAdvertiserId = var3.getAdvertiserId();
            var9.limitTracking = var3.isTrackingLimited();
         } catch (Exception var6) {
            Utility.logd("android_id", var6);
            return null;
         } finally {
            var0.unbindService(var2);
         }

         return var9;
      } else {
         return null;
      }
   }

   public static AttributionIdentifiers getAttributionIdentifiers(Context param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: invokestatic android/os/Looper.myLooper ()Landroid/os/Looper;
      // 003: invokestatic android/os/Looper.getMainLooper ()Landroid/os/Looper;
      // 006: if_acmpne 012
      // 009: getstatic com/facebook/internal/AttributionIdentifiers.TAG Ljava/lang/String;
      // 00c: ldc "getAttributionIdentifiers should not be called from the main thread"
      // 00e: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;)I
      // 011: pop
      // 012: getstatic com/facebook/internal/AttributionIdentifiers.recentlyFetchedIdentifiers Lcom/facebook/internal/AttributionIdentifiers;
      // 015: ifnull 02f
      // 018: invokestatic java/lang/System.currentTimeMillis ()J
      // 01b: getstatic com/facebook/internal/AttributionIdentifiers.recentlyFetchedIdentifiers Lcom/facebook/internal/AttributionIdentifiers;
      // 01e: getfield com/facebook/internal/AttributionIdentifiers.fetchTime J
      // 021: lsub
      // 022: ldc2_w 3600000
      // 025: lcmp
      // 026: ifge 02f
      // 029: getstatic com/facebook/internal/AttributionIdentifiers.recentlyFetchedIdentifiers Lcom/facebook/internal/AttributionIdentifiers;
      // 02c: astore 0
      // 02d: aload 0
      // 02e: areturn
      // 02f: aload 0
      // 030: invokestatic com/facebook/internal/AttributionIdentifiers.getAndroidId (Landroid/content/Context;)Lcom/facebook/internal/AttributionIdentifiers;
      // 033: astore 5
      // 035: aload 0
      // 036: invokevirtual android/content/Context.getPackageManager ()Landroid/content/pm/PackageManager;
      // 039: ldc "com.facebook.katana.provider.AttributionIdProvider"
      // 03b: bipush 0
      // 03c: invokevirtual android/content/pm/PackageManager.resolveContentProvider (Ljava/lang/String;I)Landroid/content/pm/ProviderInfo;
      // 03f: ifnull 072
      // 042: ldc "content://com.facebook.katana.provider.AttributionIdProvider"
      // 044: invokestatic android/net/Uri.parse (Ljava/lang/String;)Landroid/net/Uri;
      // 047: astore 4
      // 049: aload 0
      // 04a: invokestatic com/facebook/internal/AttributionIdentifiers.getInstallerPackageName (Landroid/content/Context;)Ljava/lang/String;
      // 04d: astore 6
      // 04f: aload 6
      // 051: ifnull 05b
      // 054: aload 5
      // 056: aload 6
      // 058: putfield com/facebook/internal/AttributionIdentifiers.androidInstallerPackage Ljava/lang/String;
      // 05b: aload 4
      // 05d: ifnonnull 089
      // 060: aload 5
      // 062: invokestatic com/facebook/internal/AttributionIdentifiers.cacheAndReturnIdentifiers (Lcom/facebook/internal/AttributionIdentifiers;)Lcom/facebook/internal/AttributionIdentifiers;
      // 065: astore 0
      // 066: bipush 0
      // 067: ifeq 02d
      // 06a: new java/lang/NullPointerException
      // 06d: dup
      // 06e: invokespecial java/lang/NullPointerException.<init> ()V
      // 071: athrow
      // 072: aload 0
      // 073: invokevirtual android/content/Context.getPackageManager ()Landroid/content/pm/PackageManager;
      // 076: ldc "com.facebook.wakizashi.provider.AttributionIdProvider"
      // 078: bipush 0
      // 079: invokevirtual android/content/pm/PackageManager.resolveContentProvider (Ljava/lang/String;I)Landroid/content/pm/ProviderInfo;
      // 07c: ifnull 1c2
      // 07f: ldc "content://com.facebook.wakizashi.provider.AttributionIdProvider"
      // 081: invokestatic android/net/Uri.parse (Ljava/lang/String;)Landroid/net/Uri;
      // 084: astore 4
      // 086: goto 049
      // 089: aload 0
      // 08a: invokevirtual android/content/Context.getContentResolver ()Landroid/content/ContentResolver;
      // 08d: aload 4
      // 08f: bipush 3
      // 090: anewarray 142
      // 093: dup
      // 094: bipush 0
      // 095: ldc "aid"
      // 097: aastore
      // 098: dup
      // 099: bipush 1
      // 09a: ldc "androidid"
      // 09c: aastore
      // 09d: dup
      // 09e: bipush 2
      // 09f: ldc "limit_tracking"
      // 0a1: aastore
      // 0a2: aconst_null
      // 0a3: aconst_null
      // 0a4: aconst_null
      // 0a5: invokevirtual android/content/ContentResolver.query (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      // 0a8: astore 4
      // 0aa: aload 4
      // 0ac: ifnull 0bc
      // 0af: aload 4
      // 0b1: astore 0
      // 0b2: aload 4
      // 0b4: invokeinterface android/database/Cursor.moveToFirst ()Z 1
      // 0b9: ifne 0db
      // 0bc: aload 4
      // 0be: astore 0
      // 0bf: aload 5
      // 0c1: invokestatic com/facebook/internal/AttributionIdentifiers.cacheAndReturnIdentifiers (Lcom/facebook/internal/AttributionIdentifiers;)Lcom/facebook/internal/AttributionIdentifiers;
      // 0c4: astore 5
      // 0c6: aload 5
      // 0c8: astore 0
      // 0c9: aload 4
      // 0cb: ifnull 02d
      // 0ce: aload 4
      // 0d0: invokeinterface android/database/Cursor.close ()V 1
      // 0d5: aload 5
      // 0d7: astore 0
      // 0d8: goto 02d
      // 0db: aload 4
      // 0dd: astore 0
      // 0de: aload 4
      // 0e0: ldc "aid"
      // 0e2: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 0e7: istore 2
      // 0e8: aload 4
      // 0ea: astore 0
      // 0eb: aload 4
      // 0ed: ldc "androidid"
      // 0ef: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 0f4: istore 1
      // 0f5: aload 4
      // 0f7: astore 0
      // 0f8: aload 4
      // 0fa: ldc "limit_tracking"
      // 0fc: invokeinterface android/database/Cursor.getColumnIndex (Ljava/lang/String;)I 2
      // 101: istore 3
      // 102: aload 4
      // 104: astore 0
      // 105: aload 5
      // 107: aload 4
      // 109: iload 2
      // 10a: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 10f: putfield com/facebook/internal/AttributionIdentifiers.attributionId Ljava/lang/String;
      // 112: iload 1
      // 113: ifle 148
      // 116: iload 3
      // 117: ifle 148
      // 11a: aload 4
      // 11c: astore 0
      // 11d: aload 5
      // 11f: invokevirtual com/facebook/internal/AttributionIdentifiers.getAndroidAdvertiserId ()Ljava/lang/String;
      // 122: ifnonnull 148
      // 125: aload 4
      // 127: astore 0
      // 128: aload 5
      // 12a: aload 4
      // 12c: iload 1
      // 12d: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 132: putfield com/facebook/internal/AttributionIdentifiers.androidAdvertiserId Ljava/lang/String;
      // 135: aload 4
      // 137: astore 0
      // 138: aload 5
      // 13a: aload 4
      // 13c: iload 3
      // 13d: invokeinterface android/database/Cursor.getString (I)Ljava/lang/String; 2
      // 142: invokestatic java/lang/Boolean.parseBoolean (Ljava/lang/String;)Z
      // 145: putfield com/facebook/internal/AttributionIdentifiers.limitTracking Z
      // 148: aload 4
      // 14a: ifnull 154
      // 14d: aload 4
      // 14f: invokeinterface android/database/Cursor.close ()V 1
      // 154: aload 5
      // 156: invokestatic com/facebook/internal/AttributionIdentifiers.cacheAndReturnIdentifiers (Lcom/facebook/internal/AttributionIdentifiers;)Lcom/facebook/internal/AttributionIdentifiers;
      // 159: astore 0
      // 15a: goto 02d
      // 15d: astore 5
      // 15f: aconst_null
      // 160: astore 4
      // 162: aload 4
      // 164: astore 0
      // 165: getstatic com/facebook/internal/AttributionIdentifiers.TAG Ljava/lang/String;
      // 168: astore 6
      // 16a: aload 4
      // 16c: astore 0
      // 16d: new java/lang/StringBuilder
      // 170: astore 7
      // 172: aload 4
      // 174: astore 0
      // 175: aload 7
      // 177: invokespecial java/lang/StringBuilder.<init> ()V
      // 17a: aload 4
      // 17c: astore 0
      // 17d: aload 6
      // 17f: aload 7
      // 181: ldc_w "Caught unexpected exception in getAttributionId(): "
      // 184: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 187: aload 5
      // 189: invokevirtual java/lang/Exception.toString ()Ljava/lang/String;
      // 18c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 18f: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 192: invokestatic android/util/Log.d (Ljava/lang/String;Ljava/lang/String;)I
      // 195: pop
      // 196: aload 4
      // 198: ifnull 1a2
      // 19b: aload 4
      // 19d: invokeinterface android/database/Cursor.close ()V 1
      // 1a2: aconst_null
      // 1a3: astore 0
      // 1a4: goto 02d
      // 1a7: astore 4
      // 1a9: aconst_null
      // 1aa: astore 0
      // 1ab: aload 0
      // 1ac: ifnull 1b5
      // 1af: aload 0
      // 1b0: invokeinterface android/database/Cursor.close ()V 1
      // 1b5: aload 4
      // 1b7: athrow
      // 1b8: astore 4
      // 1ba: goto 1ab
      // 1bd: astore 5
      // 1bf: goto 162
      // 1c2: aconst_null
      // 1c3: astore 4
      // 1c5: goto 049
      // try (23 -> 32): 161 java/lang/Exception
      // try (23 -> 32): 195 null
      // try (32 -> 35): 161 java/lang/Exception
      // try (32 -> 35): 195 null
      // try (37 -> 40): 161 java/lang/Exception
      // try (37 -> 40): 195 null
      // try (42 -> 45): 161 java/lang/Exception
      // try (42 -> 45): 195 null
      // try (51 -> 60): 161 java/lang/Exception
      // try (51 -> 60): 195 null
      // try (61 -> 83): 161 java/lang/Exception
      // try (61 -> 83): 195 null
      // try (87 -> 90): 206 java/lang/Exception
      // try (87 -> 90): 204 null
      // try (92 -> 95): 206 java/lang/Exception
      // try (92 -> 95): 204 null
      // try (106 -> 110): 206 java/lang/Exception
      // try (106 -> 110): 204 null
      // try (112 -> 116): 206 java/lang/Exception
      // try (112 -> 116): 204 null
      // try (118 -> 122): 206 java/lang/Exception
      // try (118 -> 122): 204 null
      // try (124 -> 129): 206 java/lang/Exception
      // try (124 -> 129): 204 null
      // try (135 -> 138): 206 java/lang/Exception
      // try (135 -> 138): 204 null
      // try (140 -> 145): 206 java/lang/Exception
      // try (140 -> 145): 204 null
      // try (147 -> 153): 206 java/lang/Exception
      // try (147 -> 153): 204 null
      // try (166 -> 168): 204 null
      // try (170 -> 172): 204 null
      // try (174 -> 176): 204 null
      // try (178 -> 188): 204 null
   }

   private static String getInstallerPackageName(Context var0) {
      PackageManager var1 = var0.getPackageManager();
      String var2;
      if (var1 != null) {
         var2 = var1.getInstallerPackageName(var0.getPackageName());
      } else {
         var2 = null;
      }

      return var2;
   }

   public String getAndroidAdvertiserId() {
      return this.androidAdvertiserId;
   }

   public String getAndroidInstallerPackage() {
      return this.androidInstallerPackage;
   }

   public String getAttributionId() {
      return this.attributionId;
   }

   public boolean isTrackingLimited() {
      return this.limitTracking;
   }

   private static final class GoogleAdInfo implements IInterface {
      private static final int FIRST_TRANSACTION_CODE = 1;
      private static final int SECOND_TRANSACTION_CODE = 2;
      private IBinder binder;

      GoogleAdInfo(IBinder var1) {
         this.binder = var1;
      }

      public IBinder asBinder() {
         return this.binder;
      }

      public String getAdvertiserId() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            this.binder.transact(1, var1, var2, 0);
            var2.readException();
            return var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }
      }

      // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      public boolean isTrackingLimited() throws RemoteException {
         boolean var2 = true;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var7 = false /* VF: Semaphore variable */;

         int var1;
         try {
            var7 = true;
            var3.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            var3.writeInt(1);
            this.binder.transact(2, var3, var4, 0);
            var4.readException();
            var1 = var4.readInt();
            var7 = false;
         } finally {
            if (var7) {
               var4.recycle();
               var3.recycle();
            }
         }

         if (var1 == 0) {
            var2 = false;
         }

         var4.recycle();
         var3.recycle();
         return var2;
      }
   }

   private static final class GoogleAdServiceConnection implements ServiceConnection {
      private AtomicBoolean consumed = new AtomicBoolean(false);
      private final BlockingQueue<IBinder> queue = new LinkedBlockingDeque<>();

      private GoogleAdServiceConnection() {
      }

      public IBinder getBinder() throws InterruptedException {
         if (this.consumed.compareAndSet(true, true)) {
            throw new IllegalStateException("Binder already consumed");
         } else {
            return this.queue.take();
         }
      }

      public void onServiceConnected(ComponentName var1, IBinder var2) {
         try {
            this.queue.put(var2);
         } catch (InterruptedException var3) {
         }
      }

      public void onServiceDisconnected(ComponentName var1) {
      }
   }
}
