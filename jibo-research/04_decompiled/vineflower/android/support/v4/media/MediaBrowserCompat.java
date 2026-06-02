package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.Build.VERSION;
import android.os.Parcelable.Creator;
import android.support.v4.app.BundleCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public final class MediaBrowserCompat {
   static final boolean a = Log.isLoggable("MediaBrowserCompat", 3);
   private final MediaBrowserCompat.MediaBrowserImpl b;

   public MediaBrowserCompat(Context var1, ComponentName var2, MediaBrowserCompat.ConnectionCallback var3, Bundle var4) {
      if (VERSION.SDK_INT >= 26) {
         this.b = new MediaBrowserCompat.MediaBrowserImplApi26(var1, var2, var3, var4);
      } else if (VERSION.SDK_INT >= 23) {
         this.b = new MediaBrowserCompat.MediaBrowserImplApi23(var1, var2, var3, var4);
      } else if (VERSION.SDK_INT >= 21) {
         this.b = new MediaBrowserCompat.MediaBrowserImplApi21(var1, var2, var3, var4);
      } else {
         this.b = new MediaBrowserCompat.MediaBrowserImplBase(var1, var2, var3, var4);
      }
   }

   public void a() {
      this.b.d();
   }

   public void b() {
      this.b.e();
   }

   public MediaSessionCompat.Token c() {
      return this.b.f();
   }

   private static class CallbackHandler extends Handler {
      private final WeakReference<MediaBrowserCompat.MediaBrowserServiceCallbackImpl> a;
      private WeakReference<Messenger> b;

      CallbackHandler(MediaBrowserCompat.MediaBrowserServiceCallbackImpl var1) {
         this.a = new WeakReference<>(var1);
      }

      void a(Messenger var1) {
         this.b = new WeakReference<>(var1);
      }

      public void handleMessage(Message var1) {
         if (this.b != null && this.b.get() != null && this.a.get() != null) {
            Bundle var4 = var1.getData();
            var4.setClassLoader(MediaSessionCompat.class.getClassLoader());
            MediaBrowserCompat.MediaBrowserServiceCallbackImpl var2 = this.a.get();
            Messenger var3 = this.b.get();

            try {
               switch (var1.what) {
                  case 1:
                     var2.a(
                        var3,
                        var4.getString("data_media_item_id"),
                        (MediaSessionCompat.Token)var4.getParcelable("data_media_session_token"),
                        var4.getBundle("data_root_hints")
                     );
                     break;
                  case 2:
                     var2.a(var3);
                     break;
                  case 3:
                     var2.a(var3, var4.getString("data_media_item_id"), var4.getParcelableArrayList("data_media_item_list"), var4.getBundle("data_options"));
                     break;
                  default:
                     StringBuilder var6 = new StringBuilder();
                     Log.w(
                        "MediaBrowserCompat",
                        var6.append("Unhandled message: ")
                           .append(var1)
                           .append("\n  Client version: ")
                           .append(1)
                           .append("\n  Service version: ")
                           .append(var1.arg1)
                           .toString()
                     );
               }
            } catch (BadParcelableException var5) {
               Log.e("MediaBrowserCompat", "Could not unparcel the data.");
               if (var1.what == 1) {
                  var2.a(var3);
               }
            }
         }
      }
   }

   public static class ConnectionCallback {
      final Object a;
      MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal b;

      public ConnectionCallback() {
         if (VERSION.SDK_INT >= 21) {
            this.a = MediaBrowserCompatApi21.a(new MediaBrowserCompat.ConnectionCallback.StubApi21(this));
         } else {
            this.a = null;
         }
      }

      public void a() {
      }

      void a(MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal var1) {
         this.b = var1;
      }

      public void b() {
      }

      public void c() {
      }

      interface ConnectionCallbackInternal {
         void a();

         void b();

         void c();
      }

      private class StubApi21 implements MediaBrowserCompatApi21.ConnectionCallback {
         final MediaBrowserCompat.ConnectionCallback a;

         StubApi21(MediaBrowserCompat.ConnectionCallback var1) {
            this.a = var1;
         }

         @Override
         public void a() {
            if (this.a.b != null) {
               this.a.b.a();
            }

            this.a.a();
         }

         @Override
         public void b() {
            if (this.a.b != null) {
               this.a.b.b();
            }

            this.a.b();
         }

         @Override
         public void c() {
            if (this.a.b != null) {
               this.a.b.c();
            }

            this.a.c();
         }
      }
   }

   public abstract static class CustomActionCallback {
      public void a(String var1, Bundle var2, Bundle var3) {
      }

      public void b(String var1, Bundle var2, Bundle var3) {
      }

      public void c(String var1, Bundle var2, Bundle var3) {
      }
   }

   private static class CustomActionResultReceiver extends ResultReceiver {
      private final String d;
      private final Bundle e;
      private final MediaBrowserCompat.CustomActionCallback f;

      @Override
      protected void a(int var1, Bundle var2) {
         if (this.f != null) {
            switch (var1) {
               case -1:
                  this.f.c(this.d, this.e, var2);
                  break;
               case 0:
                  this.f.b(this.d, this.e, var2);
                  break;
               case 1:
                  this.f.a(this.d, this.e, var2);
                  break;
               default:
                  Log.w("MediaBrowserCompat", "Unknown result code: " + var1 + " (extras=" + this.e + ", resultData=" + var2 + ")");
            }
         }
      }
   }

   public abstract static class ItemCallback {
      public void a(MediaBrowserCompat.MediaItem var1) {
      }

      public void a(String var1) {
      }
   }

   private static class ItemReceiver extends ResultReceiver {
      private final String d;
      private final MediaBrowserCompat.ItemCallback e;

      @Override
      protected void a(int var1, Bundle var2) {
         if (var2 != null) {
            var2.setClassLoader(MediaBrowserCompat.class.getClassLoader());
         }

         if (var1 == 0 && var2 != null && var2.containsKey("media_item")) {
            Parcelable var3 = var2.getParcelable("media_item");
            if (var3 != null && !(var3 instanceof MediaBrowserCompat.MediaItem)) {
               this.e.a(this.d);
            } else {
               this.e.a((MediaBrowserCompat.MediaItem)var3);
            }
         } else {
            this.e.a(this.d);
         }
      }
   }

   interface MediaBrowserImpl {
      void d();

      void e();

      MediaSessionCompat.Token f();
   }

   static class MediaBrowserImplApi21
      implements MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal,
      MediaBrowserCompat.MediaBrowserImpl,
      MediaBrowserCompat.MediaBrowserServiceCallbackImpl {
      final Context a;
      protected final Object b;
      protected final Bundle c;
      protected final MediaBrowserCompat.CallbackHandler d = new MediaBrowserCompat.CallbackHandler(this);
      protected int e;
      protected MediaBrowserCompat.ServiceBinderWrapper f;
      protected Messenger g;
      private final ArrayMap<String, MediaBrowserCompat.Subscription> h = new ArrayMap<>();
      private MediaSessionCompat.Token i;

      MediaBrowserImplApi21(Context var1, ComponentName var2, MediaBrowserCompat.ConnectionCallback var3, Bundle var4) {
         this.a = var1;
         Bundle var5 = var4;
         if (var4 == null) {
            var5 = new Bundle();
         }

         var5.putInt("extra_client_version", 1);
         this.c = new Bundle(var5);
         var3.a(this);
         this.b = MediaBrowserCompatApi21.a(var1, var2, var3.a, this.c);
      }

      @Override
      public void a() {
         Bundle var1 = MediaBrowserCompatApi21.c(this.b);
         if (var1 != null) {
            this.e = var1.getInt("extra_service_version", 0);
            IBinder var2 = BundleCompat.a(var1, "extra_messenger");
            if (var2 != null) {
               this.f = new MediaBrowserCompat.ServiceBinderWrapper(var2, this.c);
               this.g = new Messenger(this.d);
               this.d.a(this.g);

               try {
                  this.f.b(this.g);
               } catch (RemoteException var3) {
                  Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
               }
            }

            IMediaSession var4 = IMediaSession.Stub.a(BundleCompat.a(var1, "extra_session_binder"));
            if (var4 != null) {
               this.i = MediaSessionCompat.Token.a(MediaBrowserCompatApi21.d(this.b), var4);
            }
         }
      }

      @Override
      public void a(Messenger var1) {
      }

      @Override
      public void a(Messenger var1, String var2, MediaSessionCompat.Token var3, Bundle var4) {
      }

      @Override
      public void a(Messenger var1, String var2, List var3, Bundle var4) {
         if (this.g == var1) {
            MediaBrowserCompat.Subscription var5 = this.h.get(var2);
            if (var5 == null) {
               if (MediaBrowserCompat.a) {
                  Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + var2);
               }
            } else {
               MediaBrowserCompat.SubscriptionCallback var6 = var5.a(this.a, var4);
               if (var6 != null) {
                  if (var4 == null) {
                     if (var3 == null) {
                        var6.a(var2);
                     } else {
                        var6.a(var2, var3);
                     }
                  } else if (var3 == null) {
                     var6.a(var2, var4);
                  } else {
                     var6.a(var2, var3, var4);
                  }
               }
            }
         }
      }

      @Override
      public void b() {
         this.f = null;
         this.g = null;
         this.i = null;
         this.d.a(null);
      }

      @Override
      public void c() {
      }

      @Override
      public void d() {
         MediaBrowserCompatApi21.a(this.b);
      }

      @Override
      public void e() {
         if (this.f != null && this.g != null) {
            try {
               this.f.c(this.g);
            } catch (RemoteException var2) {
               Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
            }
         }

         MediaBrowserCompatApi21.b(this.b);
      }

      @Override
      public MediaSessionCompat.Token f() {
         if (this.i == null) {
            this.i = MediaSessionCompat.Token.a(MediaBrowserCompatApi21.d(this.b));
         }

         return this.i;
      }
   }

   static class MediaBrowserImplApi23 extends MediaBrowserCompat.MediaBrowserImplApi21 {
      MediaBrowserImplApi23(Context var1, ComponentName var2, MediaBrowserCompat.ConnectionCallback var3, Bundle var4) {
         super(var1, var2, var3, var4);
      }
   }

   static class MediaBrowserImplApi26 extends MediaBrowserCompat.MediaBrowserImplApi23 {
      MediaBrowserImplApi26(Context var1, ComponentName var2, MediaBrowserCompat.ConnectionCallback var3, Bundle var4) {
         super(var1, var2, var3, var4);
      }
   }

   static class MediaBrowserImplBase implements MediaBrowserCompat.MediaBrowserImpl, MediaBrowserCompat.MediaBrowserServiceCallbackImpl {
      final Context a;
      final ComponentName b;
      final MediaBrowserCompat.ConnectionCallback c;
      final Bundle d;
      final MediaBrowserCompat.CallbackHandler e = new MediaBrowserCompat.CallbackHandler(this);
      int f;
      MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection g;
      MediaBrowserCompat.ServiceBinderWrapper h;
      Messenger i;
      private final ArrayMap<String, MediaBrowserCompat.Subscription> j = new ArrayMap<>();
      private String k;
      private MediaSessionCompat.Token l;
      private Bundle m;

      public MediaBrowserImplBase(Context var1, ComponentName var2, MediaBrowserCompat.ConnectionCallback var3, Bundle var4) {
         this.f = 1;
         if (var1 == null) {
            throw new IllegalArgumentException("context must not be null");
         }

         if (var2 == null) {
            throw new IllegalArgumentException("service component must not be null");
         }

         if (var3 == null) {
            throw new IllegalArgumentException("connection callback must not be null");
         }

         this.a = var1;
         this.b = var2;
         this.c = var3;
         Bundle var5;
         if (var4 == null) {
            var5 = null;
         } else {
            var5 = new Bundle(var4);
         }

         this.d = var5;
      }

      private static String a(int var0) {
         String var1;
         switch (var0) {
            case 0:
               var1 = "CONNECT_STATE_DISCONNECTING";
               break;
            case 1:
               var1 = "CONNECT_STATE_DISCONNECTED";
               break;
            case 2:
               var1 = "CONNECT_STATE_CONNECTING";
               break;
            case 3:
               var1 = "CONNECT_STATE_CONNECTED";
               break;
            case 4:
               var1 = "CONNECT_STATE_SUSPENDED";
               break;
            default:
               var1 = "UNKNOWN/" + var0;
         }

         return var1;
      }

      private boolean a(Messenger var1, String var2) {
         boolean var3 = true;
         if (this.i != var1 || this.f == 0 || this.f == 1) {
            if (this.f != 0 && this.f != 1) {
               Log.i("MediaBrowserCompat", var2 + " for " + this.b + " with mCallbacksMessenger=" + this.i + " this=" + this);
            }

            var3 = false;
         }

         return var3;
      }

      void a() {
         if (this.g != null) {
            this.a.unbindService(this.g);
         }

         this.f = 1;
         this.g = null;
         this.h = null;
         this.i = null;
         this.e.a(null);
         this.k = null;
         this.l = null;
      }

      @Override
      public void a(Messenger var1) {
         Log.e("MediaBrowserCompat", "onConnectFailed for " + this.b);
         if (this.a(var1, "onConnectFailed")) {
            if (this.f != 2) {
               Log.w("MediaBrowserCompat", "onConnect from service while mState=" + a(this.f) + "... ignoring");
            } else {
               this.a();
               this.c.c();
            }
         }
      }

      // $VF: Duplicated exception handlers to handle obfuscated exceptions
      @Override
      public void a(Messenger var1, String var2, MediaSessionCompat.Token var3, Bundle var4) {
         if (this.a(var1, "onConnect")) {
            if (this.f != 2) {
               Log.w("MediaBrowserCompat", "onConnect from service while mState=" + a(this.f) + "... ignoring");
            } else {
               this.k = var2;
               this.l = var3;
               this.m = var4;
               this.f = 3;
               if (MediaBrowserCompat.a) {
                  Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                  this.c();
               }

               this.c.a();

               try {
                  var10 = this.j.entrySet().iterator();
               } catch (RemoteException var7) {
                  Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException.");
                  return;
               }

               while (true) {
                  try {
                     if (!var10.hasNext()) {
                        break;
                     }

                     Entry var11 = (Entry)var10.next();
                     var9 = (String)var11.getKey();
                     MediaBrowserCompat.Subscription var13 = (MediaBrowserCompat.Subscription)var11.getValue();
                     var12 = var13.b();
                     var14 = var13.a();
                  } catch (RemoteException var6) {
                     Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException.");
                     break;
                  }

                  int var5 = 0;

                  while (true) {
                     try {
                        if (var5 >= var12.size()) {
                           break;
                        }

                        this.h.a(var9, ((MediaBrowserCompat.SubscriptionCallback)var12.get(var5)).c, (Bundle)var14.get(var5), this.i);
                     } catch (RemoteException var8) {
                        Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException.");
                        return;
                     }

                     var5++;
                  }
               }
            }
         }
      }

      @Override
      public void a(Messenger var1, String var2, List var3, Bundle var4) {
         if (this.a(var1, "onLoadChildren")) {
            if (MediaBrowserCompat.a) {
               Log.d("MediaBrowserCompat", "onLoadChildren for " + this.b + " id=" + var2);
            }

            MediaBrowserCompat.Subscription var5 = this.j.get(var2);
            if (var5 == null) {
               if (MediaBrowserCompat.a) {
                  Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + var2);
               }
            } else {
               MediaBrowserCompat.SubscriptionCallback var6 = var5.a(this.a, var4);
               if (var6 != null) {
                  if (var4 == null) {
                     if (var3 == null) {
                        var6.a(var2);
                     } else {
                        var6.a(var2, var3);
                     }
                  } else if (var3 == null) {
                     var6.a(var2, var4);
                  } else {
                     var6.a(var2, var3, var4);
                  }
               }
            }
         }
      }

      public boolean b() {
         boolean var1;
         if (this.f == 3) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      void c() {
         Log.d("MediaBrowserCompat", "MediaBrowserCompat...");
         Log.d("MediaBrowserCompat", "  mServiceComponent=" + this.b);
         Log.d("MediaBrowserCompat", "  mCallback=" + this.c);
         Log.d("MediaBrowserCompat", "  mRootHints=" + this.d);
         Log.d("MediaBrowserCompat", "  mState=" + a(this.f));
         Log.d("MediaBrowserCompat", "  mServiceConnection=" + this.g);
         Log.d("MediaBrowserCompat", "  mServiceBinderWrapper=" + this.h);
         Log.d("MediaBrowserCompat", "  mCallbacksMessenger=" + this.i);
         Log.d("MediaBrowserCompat", "  mRootId=" + this.k);
         Log.d("MediaBrowserCompat", "  mMediaSessionToken=" + this.l);
      }

      @Override
      public void d() {
         if (this.f != 0 && this.f != 1) {
            throw new IllegalStateException("connect() called while neigther disconnecting nor disconnected (state=" + a(this.f) + ")");
         }

         this.f = 2;
         this.e.post(new Runnable(this) {
            final MediaBrowserCompat.MediaBrowserImplBase a;

            {
               this.a = var1;
            }

            @Override
            public void run() {
               if (this.a.f != 0) {
                  this.a.f = 2;
                  if (MediaBrowserCompat.a && this.a.g != null) {
                     throw new RuntimeException("mServiceConnection should be null. Instead it is " + this.a.g);
                  }

                  if (this.a.h != null) {
                     throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + this.a.h);
                  }

                  if (this.a.i != null) {
                     throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + this.a.i);
                  }

                  Intent var3 = new Intent("android.media.browse.MediaBrowserService");
                  var3.setComponent(this.a.b);
                  this.a.g = this.a.new MediaServiceConnection(this.a);
                  boolean var1 = false;

                  label30: {
                     boolean var2;
                     try {
                        var2 = this.a.a.bindService(var3, this.a.g, 1);
                     } catch (Exception var4) {
                        Log.e("MediaBrowserCompat", "Failed binding to service " + this.a.b);
                        break label30;
                     }

                     var1 = var2;
                  }

                  if (!var1) {
                     this.a.a();
                     this.a.c.c();
                  }

                  if (MediaBrowserCompat.a) {
                     Log.d("MediaBrowserCompat", "connect...");
                     this.a.c();
                  }
               }
            }
         });
      }

      @Override
      public void e() {
         this.f = 0;
         this.e.post(new Runnable(this) {
            final MediaBrowserCompat.MediaBrowserImplBase a;

            {
               this.a = var1;
            }

            @Override
            public void run() {
               if (this.a.i != null) {
                  try {
                     this.a.h.a(this.a.i);
                  } catch (RemoteException var3) {
                     Log.w("MediaBrowserCompat", "RemoteException during connect for " + this.a.b);
                  }
               }

               int var1 = this.a.f;
               this.a.a();
               if (var1 != 0) {
                  this.a.f = var1;
               }

               if (MediaBrowserCompat.a) {
                  Log.d("MediaBrowserCompat", "disconnect...");
                  this.a.c();
               }
            }
         });
      }

      @Override
      public MediaSessionCompat.Token f() {
         if (!this.b()) {
            throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.f + ")");
         } else {
            return this.l;
         }
      }

      private class MediaServiceConnection implements ServiceConnection {
         final MediaBrowserCompat.MediaBrowserImplBase a;

         MediaServiceConnection(MediaBrowserCompat.MediaBrowserImplBase var1) {
            this.a = var1;
         }

         private void a(Runnable var1) {
            if (Thread.currentThread() == this.a.e.getLooper().getThread()) {
               var1.run();
            } else {
               this.a.e.post(var1);
            }
         }

         boolean a(String var1) {
            boolean var2 = true;
            if (this.a.g != this || this.a.f == 0 || this.a.f == 1) {
               if (this.a.f != 0 && this.a.f != 1) {
                  Log.i("MediaBrowserCompat", var1 + " for " + this.a.b + " with mServiceConnection=" + this.a.g + " this=" + this);
               }

               var2 = false;
            }

            return var2;
         }

         public void onServiceConnected(ComponentName var1, IBinder var2) {
            this.a(new Runnable(this, var1, var2) {
               final ComponentName a;
               final IBinder b;
               final MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection c;

               {
                  this.c = var1;
                  this.a = var2x;
                  this.b = var3;
               }

               @Override
               public void run() {
                  if (MediaBrowserCompat.a) {
                     Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceConnected name=" + this.a + " binder=" + this.b);
                     this.c.a.c();
                  }

                  if (this.c.a("onServiceConnected")) {
                     this.c.a.h = new MediaBrowserCompat.ServiceBinderWrapper(this.b, this.c.a.d);
                     this.c.a.i = new Messenger(this.c.a.e);
                     this.c.a.e.a(this.c.a.i);
                     this.c.a.f = 2;

                     try {
                        if (MediaBrowserCompat.a) {
                           Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                           this.c.a.c();
                        }

                        this.c.a.h.a(this.c.a.a, this.c.a.i);
                     } catch (RemoteException var2x) {
                        Log.w("MediaBrowserCompat", "RemoteException during connect for " + this.c.a.b);
                        if (MediaBrowserCompat.a) {
                           Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                           this.c.a.c();
                        }
                     }
                  }
               }
            });
         }

         public void onServiceDisconnected(ComponentName var1) {
            this.a(
               new Runnable(this, var1) {
                  final ComponentName a;
                  final MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection b;

                  {
                     this.b = var1;
                     this.a = var2;
                  }

                  @Override
                  public void run() {
                     if (MediaBrowserCompat.a) {
                        Log.d(
                           "MediaBrowserCompat",
                           "MediaServiceConnection.onServiceDisconnected name=" + this.a + " this=" + this + " mServiceConnection=" + this.b.a.g
                        );
                        this.b.a.c();
                     }

                     if (this.b.a("onServiceDisconnected")) {
                        this.b.a.h = null;
                        this.b.a.i = null;
                        this.b.a.e.a(null);
                        this.b.a.f = 4;
                        this.b.a.c.b();
                     }
                  }
               }
            );
         }
      }
   }

   interface MediaBrowserServiceCallbackImpl {
      void a(Messenger var1);

      void a(Messenger var1, String var2, MediaSessionCompat.Token var3, Bundle var4);

      void a(Messenger var1, String var2, List var3, Bundle var4);
   }

   public static class MediaItem implements Parcelable {
      public static final Creator<MediaBrowserCompat.MediaItem> CREATOR = new Creator<MediaBrowserCompat.MediaItem>() {
         public MediaBrowserCompat.MediaItem a(Parcel var1) {
            return new MediaBrowserCompat.MediaItem(var1);
         }

         public MediaBrowserCompat.MediaItem[] a(int var1) {
            return new MediaBrowserCompat.MediaItem[var1];
         }
      };
      private final int a;
      private final MediaDescriptionCompat b;

      MediaItem(Parcel var1) {
         this.a = var1.readInt();
         this.b = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(var1);
      }

      public MediaItem(MediaDescriptionCompat var1, int var2) {
         if (var1 == null) {
            throw new IllegalArgumentException("description cannot be null");
         }

         if (TextUtils.isEmpty(var1.a())) {
            throw new IllegalArgumentException("description must have a non-empty media id");
         }

         this.a = var2;
         this.b = var1;
      }

      public static MediaBrowserCompat.MediaItem a(Object var0) {
         if (var0 != null && VERSION.SDK_INT >= 21) {
            int var1 = MediaBrowserCompatApi21.MediaItem.a(var0);
            var0 = new MediaBrowserCompat.MediaItem(MediaDescriptionCompat.a(MediaBrowserCompatApi21.MediaItem.b(var0)), var1);
         } else {
            var0 = null;
         }

         return var0;
      }

      public static List<MediaBrowserCompat.MediaItem> a(List<?> var0) {
         if (var0 != null && VERSION.SDK_INT >= 21) {
            ArrayList var1 = new ArrayList(var0.size());
            Iterator var2 = var0.iterator();

            while (true) {
               var0 = var1;
               if (!var2.hasNext()) {
                  break;
               }

               var1.add(a(var2.next()));
            }
         } else {
            var0 = null;
         }

         return var0;
      }

      public int describeContents() {
         return 0;
      }

      @Override
      public String toString() {
         StringBuilder var1 = new StringBuilder("MediaItem{");
         var1.append("mFlags=").append(this.a);
         var1.append(", mDescription=").append(this.b);
         var1.append('}');
         return var1.toString();
      }

      public void writeToParcel(Parcel var1, int var2) {
         var1.writeInt(this.a);
         this.b.writeToParcel(var1, var2);
      }
   }

   public abstract static class SearchCallback {
      public void a(String var1, Bundle var2) {
      }

      public void a(String var1, Bundle var2, List<MediaBrowserCompat.MediaItem> var3) {
      }
   }

   private static class SearchResultReceiver extends ResultReceiver {
      private final String d;
      private final Bundle e;
      private final MediaBrowserCompat.SearchCallback f;

      @Override
      protected void a(int var1, Bundle var2) {
         if (var2 != null) {
            var2.setClassLoader(MediaBrowserCompat.class.getClassLoader());
         }

         if (var1 == 0 && var2 != null && var2.containsKey("search_results")) {
            Parcelable[] var4 = var2.getParcelableArray("search_results");
            ArrayList var6 = null;
            if (var4 != null) {
               var6 = new ArrayList();
               int var3 = var4.length;

               for (int var5 = 0; var5 < var3; var5++) {
                  var6.add((MediaBrowserCompat.MediaItem)var4[var5]);
               }
            }

            this.f.a(this.d, this.e, var6);
         } else {
            this.f.a(this.d, this.e);
         }
      }
   }

   private static class ServiceBinderWrapper {
      private Messenger a;
      private Bundle b;

      public ServiceBinderWrapper(IBinder var1, Bundle var2) {
         this.a = new Messenger(var1);
         this.b = var2;
      }

      private void a(int var1, Bundle var2, Messenger var3) throws RemoteException {
         Message var4 = Message.obtain();
         var4.what = var1;
         var4.arg1 = 1;
         var4.setData(var2);
         var4.replyTo = var3;
         this.a.send(var4);
      }

      void a(Context var1, Messenger var2) throws RemoteException {
         Bundle var3 = new Bundle();
         var3.putString("data_package_name", var1.getPackageName());
         var3.putBundle("data_root_hints", this.b);
         this.a(1, var3, var2);
      }

      void a(Messenger var1) throws RemoteException {
         this.a(2, null, var1);
      }

      void a(String var1, IBinder var2, Bundle var3, Messenger var4) throws RemoteException {
         Bundle var5 = new Bundle();
         var5.putString("data_media_item_id", var1);
         BundleCompat.a(var5, "data_callback_token", var2);
         var5.putBundle("data_options", var3);
         this.a(3, var5, var4);
      }

      void b(Messenger var1) throws RemoteException {
         Bundle var2 = new Bundle();
         var2.putBundle("data_root_hints", this.b);
         this.a(6, var2, var1);
      }

      void c(Messenger var1) throws RemoteException {
         this.a(7, null, var1);
      }
   }

   private static class Subscription {
      private final List<MediaBrowserCompat.SubscriptionCallback> a = new ArrayList<>();
      private final List<Bundle> b = new ArrayList<>();

      public Subscription() {
      }

      public MediaBrowserCompat.SubscriptionCallback a(Context var1, Bundle var2) {
         if (var2 != null) {
            var2.setClassLoader(var1.getClassLoader());
         }

         int var3 = 0;

         while (true) {
            if (var3 >= this.b.size()) {
               var4 = null;
               break;
            }

            if (MediaBrowserCompatUtils.a(this.b.get(var3), var2)) {
               var4 = this.a.get(var3);
               break;
            }

            var3++;
         }

         return var4;
      }

      public List<Bundle> a() {
         return this.b;
      }

      public List<MediaBrowserCompat.SubscriptionCallback> b() {
         return this.a;
      }
   }

   public abstract static class SubscriptionCallback {
      WeakReference<MediaBrowserCompat.Subscription> a;
      private final Object b;
      private final IBinder c = new Binder();

      public SubscriptionCallback() {
         if (VERSION.SDK_INT >= 26) {
            this.b = MediaBrowserCompatApi26.a(new MediaBrowserCompat.SubscriptionCallback.StubApi26(this));
         } else if (VERSION.SDK_INT >= 21) {
            this.b = MediaBrowserCompatApi21.a(new MediaBrowserCompat.SubscriptionCallback.StubApi21(this));
         } else {
            this.b = null;
         }
      }

      public void a(String var1) {
      }

      public void a(String var1, Bundle var2) {
      }

      public void a(String var1, List<MediaBrowserCompat.MediaItem> var2) {
      }

      public void a(String var1, List<MediaBrowserCompat.MediaItem> var2, Bundle var3) {
      }

      private class StubApi21 implements MediaBrowserCompatApi21.SubscriptionCallback {
         final MediaBrowserCompat.SubscriptionCallback a;

         StubApi21(MediaBrowserCompat.SubscriptionCallback var1) {
            this.a = var1;
         }

         List<MediaBrowserCompat.MediaItem> a(List<MediaBrowserCompat.MediaItem> var1, Bundle var2) {
            List var7;
            if (var1 == null) {
               var7 = null;
            } else {
               int var6 = var2.getInt("android.media.browse.extra.PAGE", -1);
               int var3 = var2.getInt("android.media.browse.extra.PAGE_SIZE", -1);
               if (var6 == -1) {
                  List var9 = var1;
                  if (var3 == -1) {
                     return var9;
                  }
               }

               int var5 = var3 * var6;
               int var4 = var5 + var3;
               if (var6 >= 0 && var3 >= 1 && var5 < var1.size()) {
                  var3 = var4;
                  if (var4 > var1.size()) {
                     var3 = var1.size();
                  }

                  var7 = var1.subList(var5, var3);
               } else {
                  var7 = Collections.EMPTY_LIST;
               }
            }

            return var7;
         }

         @Override
         public void a(String var1) {
            this.a.a(var1);
         }

         @Override
         public void a(String var1, List<?> var2) {
            MediaBrowserCompat.Subscription var4;
            if (this.a.a == null) {
               var4 = null;
            } else {
               var4 = this.a.a.get();
            }

            if (var4 == null) {
               this.a.a(var1, MediaBrowserCompat.MediaItem.a(var2));
            } else {
               List var5 = MediaBrowserCompat.MediaItem.a(var2);
               var2 = var4.b();
               List var6 = var4.a();

               for (int var3 = 0; var3 < var2.size(); var3++) {
                  Bundle var8 = (Bundle)var6.get(var3);
                  if (var8 == null) {
                     this.a.a(var1, var5);
                  } else {
                     this.a.a(var1, this.a(var5, var8), var8);
                  }
               }
            }
         }
      }

      private class StubApi26 extends MediaBrowserCompat.SubscriptionCallback.StubApi21 implements MediaBrowserCompatApi26.SubscriptionCallback {
         final MediaBrowserCompat.SubscriptionCallback b;

         StubApi26(MediaBrowserCompat.SubscriptionCallback var1) {
            super(var1);
            this.b = var1;
         }

         @Override
         public void a(String var1, Bundle var2) {
            this.b.a(var1, var2);
         }

         @Override
         public void a(String var1, List<?> var2, Bundle var3) {
            this.b.a(var1, MediaBrowserCompat.MediaItem.a(var2), var3);
         }
      }
   }
}
