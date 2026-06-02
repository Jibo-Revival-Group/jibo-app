package android.support.v4.media.session;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.Build.VERSION;
import android.os.IBinder.DeathRecipient;
import android.support.v4.app.BundleCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.util.Log;
import android.view.KeyEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class MediaControllerCompat {
   private final MediaControllerCompat.MediaControllerImpl a;
   private final MediaSessionCompat.Token b;
   private final HashSet<MediaControllerCompat.Callback> c = new HashSet<>();

   public MediaControllerCompat(Context var1, MediaSessionCompat.Token var2) throws RemoteException {
      if (var2 == null) {
         throw new IllegalArgumentException("sessionToken must not be null");
      }

      this.b = var2;
      if (VERSION.SDK_INT >= 24) {
         this.a = new MediaControllerCompat.MediaControllerImplApi24(var1, var2);
      } else if (VERSION.SDK_INT >= 23) {
         this.a = new MediaControllerCompat.MediaControllerImplApi23(var1, var2);
      } else if (VERSION.SDK_INT >= 21) {
         this.a = new MediaControllerCompat.MediaControllerImplApi21(var1, var2);
      } else {
         this.a = new MediaControllerCompat.MediaControllerImplBase(this.b);
      }
   }

   public boolean a(KeyEvent var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("KeyEvent may not be null");
      } else {
         return this.a.a(var1);
      }
   }

   public abstract static class Callback implements DeathRecipient {
      MediaControllerCompat.Callback.MessageHandler a;
      boolean b;
      private final Object c;

      public Callback() {
         if (VERSION.SDK_INT >= 21) {
            this.c = MediaControllerCompatApi21.a(new MediaControllerCompat.Callback.StubApi21(this));
         } else {
            this.c = new MediaControllerCompat.Callback.StubCompat(this);
         }
      }

      public void a() {
      }

      public void a(int var1) {
      }

      void a(int var1, Object var2, Bundle var3) {
         if (this.a != null) {
            var2 = this.a.obtainMessage(var1, var2);
            var2.setData(var3);
            var2.sendToTarget();
         }
      }

      public void a(Bundle var1) {
      }

      public void a(MediaMetadataCompat var1) {
      }

      public void a(MediaControllerCompat.PlaybackInfo var1) {
      }

      public void a(PlaybackStateCompat var1) {
      }

      public void a(CharSequence var1) {
      }

      public void a(String var1, Bundle var2) {
      }

      public void a(List<MediaSessionCompat.QueueItem> var1) {
      }

      public void a(boolean var1) {
      }

      public void b() {
      }

      public void b(int var1) {
      }

      private class MessageHandler extends Handler {
         boolean a;
         final MediaControllerCompat.Callback b;

         public void handleMessage(Message var1) {
            if (this.a) {
               switch (var1.what) {
                  case 1:
                     this.b.a((String)var1.obj, var1.getData());
                     break;
                  case 2:
                     this.b.a((PlaybackStateCompat)var1.obj);
                     break;
                  case 3:
                     this.b.a((MediaMetadataCompat)var1.obj);
                     break;
                  case 4:
                     this.b.a((MediaControllerCompat.PlaybackInfo)var1.obj);
                     break;
                  case 5:
                     this.b.a((List<MediaSessionCompat.QueueItem>)var1.obj);
                     break;
                  case 6:
                     this.b.a((CharSequence)var1.obj);
                     break;
                  case 7:
                     this.b.a((Bundle)var1.obj);
                     break;
                  case 8:
                     this.b.b();
                     break;
                  case 9:
                     this.b.a((Integer)var1.obj);
                  case 10:
                  default:
                     break;
                  case 11:
                     this.b.a((Boolean)var1.obj);
                     break;
                  case 12:
                     this.b.b((Integer)var1.obj);
                     break;
                  case 13:
                     this.b.a();
               }
            }
         }
      }

      private static class StubApi21 implements MediaControllerCompatApi21.Callback {
         private final WeakReference<MediaControllerCompat.Callback> a;

         StubApi21(MediaControllerCompat.Callback var1) {
            this.a = new WeakReference<>(var1);
         }

         @Override
         public void a() {
            MediaControllerCompat.Callback var1 = this.a.get();
            if (var1 != null) {
               var1.b();
            }
         }

         @Override
         public void a(int var1, int var2, int var3, int var4, int var5) {
            MediaControllerCompat.Callback var6 = this.a.get();
            if (var6 != null) {
               var6.a(new MediaControllerCompat.PlaybackInfo(var1, var2, var3, var4, var5));
            }
         }

         @Override
         public void a(Bundle var1) {
            MediaControllerCompat.Callback var2 = this.a.get();
            if (var2 != null) {
               var2.a(var1);
            }
         }

         @Override
         public void a(CharSequence var1) {
            MediaControllerCompat.Callback var2 = this.a.get();
            if (var2 != null) {
               var2.a(var1);
            }
         }

         @Override
         public void a(Object var1) {
            MediaControllerCompat.Callback var2 = this.a.get();
            if (var2 != null && !var2.b) {
               var2.a(PlaybackStateCompat.a(var1));
            }
         }

         @Override
         public void a(String var1, Bundle var2) {
            MediaControllerCompat.Callback var3 = this.a.get();
            if (var3 != null && (!var3.b || VERSION.SDK_INT >= 23)) {
               var3.a(var1, var2);
            }
         }

         @Override
         public void a(List<?> var1) {
            MediaControllerCompat.Callback var2 = this.a.get();
            if (var2 != null) {
               var2.a(MediaSessionCompat.QueueItem.a(var1));
            }
         }

         @Override
         public void b(Object var1) {
            MediaControllerCompat.Callback var2 = this.a.get();
            if (var2 != null) {
               var2.a(MediaMetadataCompat.a(var1));
            }
         }
      }

      private static class StubCompat extends IMediaControllerCallback.Stub {
         private final WeakReference<MediaControllerCompat.Callback> a;

         StubCompat(MediaControllerCompat.Callback var1) {
            this.a = new WeakReference<>(var1);
         }

         @Override
         public void a() throws RemoteException {
            MediaControllerCompat.Callback var1 = this.a.get();
            if (var1 != null) {
               var1.a(8, null, null);
            }
         }

         @Override
         public void a(int var1) throws RemoteException {
            MediaControllerCompat.Callback var2 = this.a.get();
            if (var2 != null) {
               var2.a(9, var1, null);
            }
         }

         @Override
         public void a(Bundle var1) throws RemoteException {
            MediaControllerCompat.Callback var2 = this.a.get();
            if (var2 != null) {
               var2.a(7, var1, null);
            }
         }

         @Override
         public void a(MediaMetadataCompat var1) throws RemoteException {
            MediaControllerCompat.Callback var2 = this.a.get();
            if (var2 != null) {
               var2.a(3, var1, null);
            }
         }

         @Override
         public void a(ParcelableVolumeInfo var1) throws RemoteException {
            MediaControllerCompat.Callback var2 = this.a.get();
            if (var2 != null) {
               MediaControllerCompat.PlaybackInfo var3;
               if (var1 != null) {
                  var3 = new MediaControllerCompat.PlaybackInfo(var1.a, var1.b, var1.c, var1.d, var1.e);
               } else {
                  var3 = null;
               }

               var2.a(4, var3, null);
            }
         }

         @Override
         public void a(PlaybackStateCompat var1) throws RemoteException {
            MediaControllerCompat.Callback var2 = this.a.get();
            if (var2 != null) {
               var2.a(2, var1, null);
            }
         }

         @Override
         public void a(CharSequence var1) throws RemoteException {
            MediaControllerCompat.Callback var2 = this.a.get();
            if (var2 != null) {
               var2.a(6, var1, null);
            }
         }

         @Override
         public void a(String var1, Bundle var2) throws RemoteException {
            MediaControllerCompat.Callback var3 = this.a.get();
            if (var3 != null) {
               var3.a(1, var1, var2);
            }
         }

         @Override
         public void a(List<MediaSessionCompat.QueueItem> var1) throws RemoteException {
            MediaControllerCompat.Callback var2 = this.a.get();
            if (var2 != null) {
               var2.a(5, var1, null);
            }
         }

         @Override
         public void a(boolean var1) throws RemoteException {
         }

         @Override
         public void b() throws RemoteException {
            MediaControllerCompat.Callback var1 = this.a.get();
            if (var1 != null) {
               var1.a(13, null, null);
            }
         }

         @Override
         public void b(int var1) throws RemoteException {
            MediaControllerCompat.Callback var2 = this.a.get();
            if (var2 != null) {
               var2.a(12, var1, null);
            }
         }

         @Override
         public void b(boolean var1) throws RemoteException {
            MediaControllerCompat.Callback var2 = this.a.get();
            if (var2 != null) {
               var2.a(11, var1, null);
            }
         }
      }
   }

   interface MediaControllerImpl {
      boolean a(KeyEvent var1);
   }

   static class MediaControllerImplApi21 implements MediaControllerCompat.MediaControllerImpl {
      protected final Object a;
      private final List<MediaControllerCompat.Callback> b = new ArrayList<>();
      private IMediaSession c;
      private HashMap<MediaControllerCompat.Callback, MediaControllerCompat.MediaControllerImplApi21.ExtraCallback> d = new HashMap<>();

      public MediaControllerImplApi21(Context var1, MediaSessionCompat.Token var2) throws RemoteException {
         this.a = MediaControllerCompatApi21.a(var1, var2.a());
         if (this.a == null) {
            throw new RemoteException();
         }

         this.c = var2.b();
         if (this.c == null) {
            this.a();
         }
      }

      private void a() {
         this.a(
            "android.support.v4.media.session.command.GET_EXTRA_BINDER",
            null,
            new MediaControllerCompat.MediaControllerImplApi21.ExtraBinderRequestResultReceiver(this, new Handler())
         );
      }

      private void b() {
         // $VF: Couldn't be decompiled
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         // java.lang.RuntimeException: parsing failure!
         //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
         //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
         //
         // Bytecode:
         // 00: aload 0
         // 01: getfield android/support/v4/media/session/MediaControllerCompat$MediaControllerImplApi21.c Landroid/support/v4/media/session/IMediaSession;
         // 04: ifnonnull 08
         // 07: return
         // 08: aload 0
         // 09: getfield android/support/v4/media/session/MediaControllerCompat$MediaControllerImplApi21.b Ljava/util/List;
         // 0c: astore 1
         // 0d: aload 1
         // 0e: monitorenter
         // 0f: aload 0
         // 10: getfield android/support/v4/media/session/MediaControllerCompat$MediaControllerImplApi21.b Ljava/util/List;
         // 13: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
         // 18: astore 4
         // 1a: aload 4
         // 1c: invokeinterface java/util/Iterator.hasNext ()Z 1
         // 21: ifeq 67
         // 24: aload 4
         // 26: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
         // 2b: checkcast android/support/v4/media/session/MediaControllerCompat$Callback
         // 2e: astore 3
         // 2f: new android/support/v4/media/session/MediaControllerCompat$MediaControllerImplApi21$ExtraCallback
         // 32: astore 2
         // 33: aload 2
         // 34: aload 3
         // 35: invokespecial android/support/v4/media/session/MediaControllerCompat$MediaControllerImplApi21$ExtraCallback.<init> (Landroid/support/v4/media/session/MediaControllerCompat$Callback;)V
         // 38: aload 0
         // 39: getfield android/support/v4/media/session/MediaControllerCompat$MediaControllerImplApi21.d Ljava/util/HashMap;
         // 3c: aload 3
         // 3d: aload 2
         // 3e: invokevirtual java/util/HashMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
         // 41: pop
         // 42: aload 3
         // 43: bipush 1
         // 44: putfield android/support/v4/media/session/MediaControllerCompat$Callback.b Z
         // 47: aload 0
         // 48: getfield android/support/v4/media/session/MediaControllerCompat$MediaControllerImplApi21.c Landroid/support/v4/media/session/IMediaSession;
         // 4b: aload 2
         // 4c: invokeinterface android/support/v4/media/session/IMediaSession.a (Landroid/support/v4/media/session/IMediaControllerCallback;)V 2
         // 51: aload 3
         // 52: invokevirtual android/support/v4/media/session/MediaControllerCompat$Callback.a ()V
         // 55: goto 1a
         // 58: astore 2
         // 59: aload 1
         // 5a: monitorexit
         // 5b: aload 2
         // 5c: athrow
         // 5d: astore 2
         // 5e: ldc "MediaControllerCompat"
         // 60: ldc "Dead object in registerCallback."
         // 62: aload 2
         // 63: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
         // 66: pop
         // 67: aload 0
         // 68: getfield android/support/v4/media/session/MediaControllerCompat$MediaControllerImplApi21.b Ljava/util/List;
         // 6b: invokeinterface java/util/List.clear ()V 1
         // 70: aload 1
         // 71: monitorexit
         // 72: goto 07
         // try (9 -> 13): 41 null
         // try (13 -> 34): 41 null
         // try (34 -> 38): 46 android/os/RemoteException
         // try (34 -> 38): 41 null
         // try (38 -> 40): 41 null
         // try (42 -> 44): 41 null
         // try (47 -> 52): 41 null
         // try (52 -> 57): 41 null
      }

      public void a(String var1, Bundle var2, ResultReceiver var3) {
         MediaControllerCompatApi21.a(this.a, var1, var2, var3);
      }

      @Override
      public boolean a(KeyEvent var1) {
         return MediaControllerCompatApi21.a(this.a, var1);
      }

      private static class ExtraBinderRequestResultReceiver extends ResultReceiver {
         private WeakReference<MediaControllerCompat.MediaControllerImplApi21> a;

         public ExtraBinderRequestResultReceiver(MediaControllerCompat.MediaControllerImplApi21 var1, Handler var2) {
            super(var2);
            this.a = new WeakReference<>(var1);
         }

         protected void onReceiveResult(int var1, Bundle var2) {
            MediaControllerCompat.MediaControllerImplApi21 var3 = this.a.get();
            if (var3 != null && var2 != null) {
               var3.c = IMediaSession.Stub.a(BundleCompat.a(var2, "android.support.v4.media.session.EXTRA_BINDER"));
               var3.b();
            }
         }
      }

      private static class ExtraCallback extends MediaControllerCompat.Callback.StubCompat {
         ExtraCallback(MediaControllerCompat.Callback var1) {
            super(var1);
         }

         @Override
         public void a() throws RemoteException {
            throw new AssertionError();
         }

         @Override
         public void a(Bundle var1) throws RemoteException {
            throw new AssertionError();
         }

         @Override
         public void a(MediaMetadataCompat var1) throws RemoteException {
            throw new AssertionError();
         }

         @Override
         public void a(ParcelableVolumeInfo var1) throws RemoteException {
            throw new AssertionError();
         }

         @Override
         public void a(CharSequence var1) throws RemoteException {
            throw new AssertionError();
         }

         @Override
         public void a(List<MediaSessionCompat.QueueItem> var1) throws RemoteException {
            throw new AssertionError();
         }
      }
   }

   static class MediaControllerImplApi23 extends MediaControllerCompat.MediaControllerImplApi21 {
      public MediaControllerImplApi23(Context var1, MediaSessionCompat.Token var2) throws RemoteException {
         super(var1, var2);
      }
   }

   static class MediaControllerImplApi24 extends MediaControllerCompat.MediaControllerImplApi23 {
      public MediaControllerImplApi24(Context var1, MediaSessionCompat.Token var2) throws RemoteException {
         super(var1, var2);
      }
   }

   static class MediaControllerImplBase implements MediaControllerCompat.MediaControllerImpl {
      private IMediaSession a;

      public MediaControllerImplBase(MediaSessionCompat.Token var1) {
         this.a = IMediaSession.Stub.a((IBinder)var1.a());
      }

      @Override
      public boolean a(KeyEvent var1) {
         if (var1 == null) {
            throw new IllegalArgumentException("event may not be null.");
         }

         try {
            this.a.a(var1);
         } catch (RemoteException var2) {
            Log.e("MediaControllerCompat", "Dead object in dispatchMediaButtonEvent.", var2);
         }

         return false;
      }
   }

   public static final class PlaybackInfo {
      private final int a;
      private final int b;
      private final int c;
      private final int d;
      private final int e;

      PlaybackInfo(int var1, int var2, int var3, int var4, int var5) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
         this.d = var4;
         this.e = var5;
      }
   }
}
