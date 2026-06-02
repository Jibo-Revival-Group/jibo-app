package android.support.v4.media;

import android.app.Service;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.IBinder.DeathRecipient;
import android.support.v4.app.BundleCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.Pair;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class MediaBrowserServiceCompat extends Service {
   static final boolean a = Log.isLoggable("MBServiceCompat", 3);
   final ArrayMap<IBinder, MediaBrowserServiceCompat.ConnectionRecord> b = new ArrayMap<>();
   MediaBrowserServiceCompat.ConnectionRecord c;
   final MediaBrowserServiceCompat.ServiceHandler d = new MediaBrowserServiceCompat.ServiceHandler(this);
   MediaSessionCompat.Token e;

   public abstract MediaBrowserServiceCompat.BrowserRoot a(String var1, int var2, Bundle var3);

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

   void a(String var1, Bundle var2, MediaBrowserServiceCompat.ConnectionRecord var3, ResultReceiver var4) {
      MediaBrowserServiceCompat.Result var5 = new MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>>(this, var1, var4) {
         final ResultReceiver a;
         final MediaBrowserServiceCompat b;

         {
            this.b = var1;
            this.a = var3x;
         }

         void a(List<MediaBrowserCompat.MediaItem> var1) {
            if ((this.b() & 4) == 0 && var1 != null) {
               Bundle var2x = new Bundle();
               var2x.putParcelableArray("search_results", var1.toArray(new MediaBrowserCompat.MediaItem[0]));
               this.a.b(0, var2x);
            } else {
               this.a.b(-1, null);
            }
         }
      };
      this.c = var3;
      this.a(var1, var2, var5);
      this.c = null;
      if (!var5.a()) {
         throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + var1);
      }
   }

   public void a(String var1, Bundle var2, MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> var3) {
      var3.a(4);
      var3.b((Object)null);
   }

   void a(String var1, MediaBrowserServiceCompat.ConnectionRecord var2, Bundle var3) {
      MediaBrowserServiceCompat.Result var4 = new MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>>(this, var1, var2, var1, var3) {
         final MediaBrowserServiceCompat.ConnectionRecord a;
         final String b;
         final Bundle c;
         final MediaBrowserServiceCompat d;

         {
            this.d = var1;
            this.a = var3x;
            this.b = var4x;
            this.c = var5;
         }

         void a(List<MediaBrowserCompat.MediaItem> var1) {
            if (this.d.b.get(this.a.c.a()) != this.a) {
               if (MediaBrowserServiceCompat.a) {
                  Log.d("MBServiceCompat", "Not sending onLoadChildren result for connection that has been disconnected. pkg=" + this.a.a + " id=" + this.b);
               }
            } else {
               List var2x = var1;
               if ((this.b() & 1) != 0) {
                  var2x = this.d.a(var1, this.c);
               }

               try {
                  this.a.c.a(this.b, var2x, this.c);
               } catch (RemoteException var3x) {
                  Log.w("MBServiceCompat", "Calling onLoadChildren() failed for id=" + this.b + " package=" + this.a.a);
               }
            }
         }
      };
      this.c = var2;
      if (var3 == null) {
         this.a(var1, var4);
      } else {
         this.a(var1, var4, var3);
      }

      this.c = null;
      if (!var4.a()) {
         throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + var2.a + " id=" + var1);
      }
   }

   void a(String var1, MediaBrowserServiceCompat.ConnectionRecord var2, IBinder var3, Bundle var4) {
      List var5 = var2.e.get(var1);
      if (var5 == null) {
         var5 = new ArrayList();
      }

      Iterator var6 = var5.iterator();

      Pair var7;
      do {
         if (!var6.hasNext()) {
            var5.add(new Pair<>(var3, var4));
            var2.e.put(var1, var5);
            this.a(var1, var2, var4);
            break;
         }

         var7 = (Pair)var6.next();
      } while (var3 != var7.a || !MediaBrowserCompatUtils.a(var4, (Bundle)var7.b));
   }

   void a(String var1, MediaBrowserServiceCompat.ConnectionRecord var2, ResultReceiver var3) {
      MediaBrowserServiceCompat.Result var4 = new MediaBrowserServiceCompat.Result<MediaBrowserCompat.MediaItem>(this, var1, var3) {
         final ResultReceiver a;
         final MediaBrowserServiceCompat b;

         {
            this.b = var1;
            this.a = var3x;
         }

         void a(MediaBrowserCompat.MediaItem var1) {
            if ((this.b() & 2) != 0) {
               this.a.b(-1, null);
            } else {
               Bundle var2x = new Bundle();
               var2x.putParcelable("media_item", var1);
               this.a.b(0, var2x);
            }
         }
      };
      this.c = var2;
      this.b(var1, var4);
      this.c = null;
      if (!var4.a()) {
         throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + var1);
      }
   }

   public abstract void a(String var1, MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> var2);

   public void a(String var1, MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> var2, Bundle var3) {
      var2.a(1);
      this.a(var1, var2);
   }

   boolean a(String var1, int var2) {
      boolean var5 = false;
      boolean var4;
      if (var1 == null) {
         var4 = var5;
      } else {
         String[] var6 = this.getPackageManager().getPackagesForUid(var2);
         int var3 = var6.length;
         var2 = 0;

         while (true) {
            var4 = var5;
            if (var2 >= var3) {
               break;
            }

            if (var6[var2].equals(var1)) {
               var4 = true;
               break;
            }

            var2++;
         }
      }

      return var4;
   }

   boolean a(String var1, MediaBrowserServiceCompat.ConnectionRecord var2, IBinder var3) {
      boolean var4;
      if (var3 == null) {
         if (var2.e.remove(var1) != null) {
            var4 = true;
         } else {
            var4 = false;
         }
      } else {
         List var6 = var2.e.get(var1);
         if (var6 != null) {
            Iterator var7 = var6.iterator();
            boolean var5 = false;

            while (var7.hasNext()) {
               if (var3 == ((Pair)var7.next()).a) {
                  var7.remove();
                  var5 = true;
               }
            }

            var4 = var5;
            if (var6.size() == 0) {
               var2.e.remove(var1);
               var4 = var5;
            }
         } else {
            var4 = false;
         }
      }

      return var4;
   }

   void b(String var1, Bundle var2, MediaBrowserServiceCompat.ConnectionRecord var3, ResultReceiver var4) {
      MediaBrowserServiceCompat.Result var5 = new MediaBrowserServiceCompat.Result<Bundle>(this, var1, var4) {
         final ResultReceiver a;
         final MediaBrowserServiceCompat b;

         {
            this.b = var1;
            this.a = var3x;
         }

         void a(Bundle var1) {
            this.a.b(0, var1);
         }

         @Override
         void b(Bundle var1) {
            this.a.b(-1, var1);
         }
      };
      this.c = var3;
      this.b(var1, var2, var5);
      this.c = null;
      if (!var5.a()) {
         throw new IllegalStateException(
            "onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + var1 + " extras=" + var2
         );
      }
   }

   public void b(String var1, Bundle var2, MediaBrowserServiceCompat.Result<Bundle> var3) {
      var3.c(null);
   }

   public void b(String var1, MediaBrowserServiceCompat.Result<MediaBrowserCompat.MediaItem> var2) {
      var2.a(2);
      var2.b((Object)null);
   }

   public static final class BrowserRoot {
      private final String a;
      private final Bundle b;

      public String a() {
         return this.a;
      }

      public Bundle b() {
         return this.b;
      }
   }

   private class ConnectionRecord implements DeathRecipient {
      String a;
      Bundle b;
      MediaBrowserServiceCompat.ServiceCallbacks c;
      MediaBrowserServiceCompat.BrowserRoot d;
      HashMap<String, List<Pair<IBinder, Bundle>>> e;
      final MediaBrowserServiceCompat f;

      ConnectionRecord(MediaBrowserServiceCompat var1) {
         this.f = var1;
         this.e = new HashMap<>();
      }

      public void binderDied() {
         this.f.d.post(new Runnable(this) {
            final MediaBrowserServiceCompat.ConnectionRecord a;

            {
               this.a = var1;
            }

            @Override
            public void run() {
               this.a.f.b.remove(this.a.c.a());
            }
         });
      }
   }

   public static class Result<T> {
      private final Object a;
      private boolean b;
      private boolean c;
      private boolean d;
      private int e;

      Result(Object var1) {
         this.a = var1;
      }

      void a(int var1) {
         this.e = var1;
      }

      void a(T var1) {
      }

      boolean a() {
         boolean var1;
         if (!this.b && !this.c && !this.d) {
            var1 = false;
         } else {
            var1 = true;
         }

         return var1;
      }

      int b() {
         return this.e;
      }

      void b(Bundle var1) {
         throw new UnsupportedOperationException("It is not supported to send an error for " + this.a);
      }

      public void b(T var1) {
         if (!this.c && !this.d) {
            this.c = true;
            this.a((T)var1);
         } else {
            throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.a);
         }
      }

      public void c(Bundle var1) {
         if (!this.c && !this.d) {
            this.d = true;
            this.b(var1);
         } else {
            throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.a);
         }
      }
   }

   private class ServiceBinderImpl {
      final MediaBrowserServiceCompat a;

      ServiceBinderImpl(MediaBrowserServiceCompat var1) {
         this.a = var1;
      }

      public void a(MediaBrowserServiceCompat.ServiceCallbacks var1) {
         this.a.d.a(new Runnable(this, var1) {
            final MediaBrowserServiceCompat.ServiceCallbacks a;
            final MediaBrowserServiceCompat.ServiceBinderImpl b;

            {
               this.b = var1;
               this.a = var2;
            }

            @Override
            public void run() {
               IBinder var1x = this.a.a();
               MediaBrowserServiceCompat.ConnectionRecord var2 = this.b.a.b.remove(var1x);
               if (var2 != null) {
                  var2.c.a().unlinkToDeath(var2, 0);
               }
            }
         });
      }

      public void a(MediaBrowserServiceCompat.ServiceCallbacks var1, Bundle var2) {
         this.a.d.a(new Runnable(this, var1, var2) {
            final MediaBrowserServiceCompat.ServiceCallbacks a;
            final Bundle b;
            final MediaBrowserServiceCompat.ServiceBinderImpl c;

            {
               this.c = var1;
               this.a = var2x;
               this.b = var3;
            }

            @Override
            public void run() {
               IBinder var2x = this.a.a();
               this.c.a.b.remove(var2x);
               MediaBrowserServiceCompat.ConnectionRecord var1x = this.c.a.new ConnectionRecord(this.c.a);
               var1x.c = this.a;
               var1x.b = this.b;
               this.c.a.b.put(var2x, var1x);

               try {
                  var2x.linkToDeath(var1x, 0);
               } catch (RemoteException var3) {
                  Log.w("MBServiceCompat", "IBinder is already dead.");
               }
            }
         });
      }

      public void a(String var1, int var2, Bundle var3, MediaBrowserServiceCompat.ServiceCallbacks var4) {
         if (!this.a.a(var1, var2)) {
            throw new IllegalArgumentException("Package/uid mismatch: uid=" + var2 + " package=" + var1);
         }

         this.a.d.a(new Runnable(this, var4, var1, var3, var2) {
            final MediaBrowserServiceCompat.ServiceCallbacks a;
            final String b;
            final Bundle c;
            final int d;
            final MediaBrowserServiceCompat.ServiceBinderImpl e;

            {
               this.e = var1;
               this.a = var2x;
               this.b = var3x;
               this.c = var4x;
               this.d = var5;
            }

            @Override
            public void run() {
               IBinder var1x = this.a.a();
               this.e.a.b.remove(var1x);
               MediaBrowserServiceCompat.ConnectionRecord var2x = this.e.a.new ConnectionRecord(this.e.a);
               var2x.a = this.b;
               var2x.b = this.c;
               var2x.c = this.a;
               var2x.d = this.e.a.a(this.b, this.d, this.c);
               if (var2x.d == null) {
                  Log.i("MBServiceCompat", "No root for client " + this.b + " from service " + this.getClass().getName());

                  try {
                     this.a.b();
                  } catch (RemoteException var4x) {
                     Log.w("MBServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=" + this.b);
                  }
               } else {
                  try {
                     this.e.a.b.put(var1x, var2x);
                     var1x.linkToDeath(var2x, 0);
                     if (this.e.a.e != null) {
                        this.a.a(var2x.d.a(), this.e.a.e, var2x.d.b());
                     }
                  } catch (RemoteException var3x) {
                     Log.w("MBServiceCompat", "Calling onConnect() failed. Dropping client. pkg=" + this.b);
                     this.e.a.b.remove(var1x);
                  }
               }
            }
         });
      }

      public void a(String var1, Bundle var2, ResultReceiver var3, MediaBrowserServiceCompat.ServiceCallbacks var4) {
         if (!TextUtils.isEmpty(var1) && var3 != null) {
            this.a.d.a(new Runnable(this, var4, var1, var2, var3) {
               final MediaBrowserServiceCompat.ServiceCallbacks a;
               final String b;
               final Bundle c;
               final ResultReceiver d;
               final MediaBrowserServiceCompat.ServiceBinderImpl e;

               {
                  this.e = var1;
                  this.a = var2x;
                  this.b = var3x;
                  this.c = var4x;
                  this.d = var5;
               }

               @Override
               public void run() {
                  IBinder var1x = this.a.a();
                  MediaBrowserServiceCompat.ConnectionRecord var2x = this.e.a.b.get(var1x);
                  if (var2x == null) {
                     Log.w("MBServiceCompat", "search for callback that isn't registered query=" + this.b);
                  } else {
                     this.e.a.a(this.b, this.c, var2x, this.d);
                  }
               }
            });
         }
      }

      public void a(String var1, IBinder var2, Bundle var3, MediaBrowserServiceCompat.ServiceCallbacks var4) {
         this.a.d.a(new Runnable(this, var4, var1, var2, var3) {
            final MediaBrowserServiceCompat.ServiceCallbacks a;
            final String b;
            final IBinder c;
            final Bundle d;
            final MediaBrowserServiceCompat.ServiceBinderImpl e;

            {
               this.e = var1;
               this.a = var2x;
               this.b = var3x;
               this.c = var4x;
               this.d = var5;
            }

            @Override
            public void run() {
               IBinder var1x = this.a.a();
               MediaBrowserServiceCompat.ConnectionRecord var2x = this.e.a.b.get(var1x);
               if (var2x == null) {
                  Log.w("MBServiceCompat", "addSubscription for callback that isn't registered id=" + this.b);
               } else {
                  this.e.a.a(this.b, var2x, this.c, this.d);
               }
            }
         });
      }

      public void a(String var1, IBinder var2, MediaBrowserServiceCompat.ServiceCallbacks var3) {
         this.a.d.a(new Runnable(this, var3, var1, var2) {
            final MediaBrowserServiceCompat.ServiceCallbacks a;
            final String b;
            final IBinder c;
            final MediaBrowserServiceCompat.ServiceBinderImpl d;

            {
               this.d = var1;
               this.a = var2x;
               this.b = var3x;
               this.c = var4;
            }

            @Override
            public void run() {
               IBinder var1x = this.a.a();
               MediaBrowserServiceCompat.ConnectionRecord var2x = this.d.a.b.get(var1x);
               if (var2x == null) {
                  Log.w("MBServiceCompat", "removeSubscription for callback that isn't registered id=" + this.b);
               } else if (!this.d.a.a(this.b, var2x, this.c)) {
                  Log.w("MBServiceCompat", "removeSubscription called for " + this.b + " which is not subscribed");
               }
            }
         });
      }

      public void a(String var1, ResultReceiver var2, MediaBrowserServiceCompat.ServiceCallbacks var3) {
         if (!TextUtils.isEmpty(var1) && var2 != null) {
            this.a.d.a(new Runnable(this, var3, var1, var2) {
               final MediaBrowserServiceCompat.ServiceCallbacks a;
               final String b;
               final ResultReceiver c;
               final MediaBrowserServiceCompat.ServiceBinderImpl d;

               {
                  this.d = var1;
                  this.a = var2x;
                  this.b = var3x;
                  this.c = var4;
               }

               @Override
               public void run() {
                  IBinder var1x = this.a.a();
                  MediaBrowserServiceCompat.ConnectionRecord var2x = this.d.a.b.get(var1x);
                  if (var2x == null) {
                     Log.w("MBServiceCompat", "getMediaItem for callback that isn't registered id=" + this.b);
                  } else {
                     this.d.a.a(this.b, var2x, this.c);
                  }
               }
            });
         }
      }

      public void b(MediaBrowserServiceCompat.ServiceCallbacks var1) {
         this.a.d.a(new Runnable(this, var1) {
            final MediaBrowserServiceCompat.ServiceCallbacks a;
            final MediaBrowserServiceCompat.ServiceBinderImpl b;

            {
               this.b = var1;
               this.a = var2;
            }

            @Override
            public void run() {
               IBinder var2 = this.a.a();
               MediaBrowserServiceCompat.ConnectionRecord var1x = this.b.a.b.remove(var2);
               if (var1x != null) {
                  var2.unlinkToDeath(var1x, 0);
               }
            }
         });
      }

      public void b(String var1, Bundle var2, ResultReceiver var3, MediaBrowserServiceCompat.ServiceCallbacks var4) {
         if (!TextUtils.isEmpty(var1) && var3 != null) {
            this.a.d.a(new Runnable(this, var4, var1, var2, var3) {
               final MediaBrowserServiceCompat.ServiceCallbacks a;
               final String b;
               final Bundle c;
               final ResultReceiver d;
               final MediaBrowserServiceCompat.ServiceBinderImpl e;

               {
                  this.e = var1;
                  this.a = var2x;
                  this.b = var3x;
                  this.c = var4x;
                  this.d = var5;
               }

               @Override
               public void run() {
                  IBinder var1x = this.a.a();
                  MediaBrowserServiceCompat.ConnectionRecord var2x = this.e.a.b.get(var1x);
                  if (var2x == null) {
                     Log.w("MBServiceCompat", "sendCustomAction for callback that isn't registered action=" + this.b + ", extras=" + this.c);
                  } else {
                     this.e.a.b(this.b, this.c, var2x, this.d);
                  }
               }
            });
         }
      }
   }

   private interface ServiceCallbacks {
      IBinder a();

      void a(String var1, MediaSessionCompat.Token var2, Bundle var3) throws RemoteException;

      void a(String var1, List<MediaBrowserCompat.MediaItem> var2, Bundle var3) throws RemoteException;

      void b() throws RemoteException;
   }

   private static class ServiceCallbacksCompat implements MediaBrowserServiceCompat.ServiceCallbacks {
      final Messenger a;

      ServiceCallbacksCompat(Messenger var1) {
         this.a = var1;
      }

      private void a(int var1, Bundle var2) throws RemoteException {
         Message var3 = Message.obtain();
         var3.what = var1;
         var3.arg1 = 2;
         var3.setData(var2);
         this.a.send(var3);
      }

      @Override
      public IBinder a() {
         return this.a.getBinder();
      }

      @Override
      public void a(String var1, MediaSessionCompat.Token var2, Bundle var3) throws RemoteException {
         Bundle var4 = var3;
         if (var3 == null) {
            var4 = new Bundle();
         }

         var4.putInt("extra_service_version", 2);
         var3 = new Bundle();
         var3.putString("data_media_item_id", var1);
         var3.putParcelable("data_media_session_token", var2);
         var3.putBundle("data_root_hints", var4);
         this.a(1, var3);
      }

      @Override
      public void a(String var1, List<MediaBrowserCompat.MediaItem> var2, Bundle var3) throws RemoteException {
         Bundle var4 = new Bundle();
         var4.putString("data_media_item_id", var1);
         var4.putBundle("data_options", var3);
         if (var2 != null) {
            ArrayList var5;
            if (var2 instanceof ArrayList) {
               var5 = (ArrayList)var2;
            } else {
               var5 = new ArrayList(var2);
            }

            var4.putParcelableArrayList("data_media_item_list", var5);
         }

         this.a(3, var4);
      }

      @Override
      public void b() throws RemoteException {
         this.a(2, null);
      }
   }

   private final class ServiceHandler extends Handler {
      final MediaBrowserServiceCompat a;
      private final MediaBrowserServiceCompat.ServiceBinderImpl b;

      ServiceHandler(MediaBrowserServiceCompat var1) {
         this.a = var1;
         this.b = this.a.new ServiceBinderImpl(this.a);
      }

      public void a(Runnable var1) {
         if (Thread.currentThread() == this.getLooper().getThread()) {
            var1.run();
         } else {
            this.post(var1);
         }
      }

      public void handleMessage(Message var1) {
         Bundle var2 = var1.getData();
         switch (var1.what) {
            case 1:
               this.b
                  .a(
                     var2.getString("data_package_name"),
                     var2.getInt("data_calling_uid"),
                     var2.getBundle("data_root_hints"),
                     new MediaBrowserServiceCompat.ServiceCallbacksCompat(var1.replyTo)
                  );
               break;
            case 2:
               this.b.a(new MediaBrowserServiceCompat.ServiceCallbacksCompat(var1.replyTo));
               break;
            case 3:
               this.b
                  .a(
                     var2.getString("data_media_item_id"),
                     BundleCompat.a(var2, "data_callback_token"),
                     var2.getBundle("data_options"),
                     new MediaBrowserServiceCompat.ServiceCallbacksCompat(var1.replyTo)
                  );
               break;
            case 4:
               this.b
                  .a(
                     var2.getString("data_media_item_id"),
                     BundleCompat.a(var2, "data_callback_token"),
                     new MediaBrowserServiceCompat.ServiceCallbacksCompat(var1.replyTo)
                  );
               break;
            case 5:
               this.b
                  .a(
                     var2.getString("data_media_item_id"),
                     (ResultReceiver)var2.getParcelable("data_result_receiver"),
                     new MediaBrowserServiceCompat.ServiceCallbacksCompat(var1.replyTo)
                  );
               break;
            case 6:
               this.b.a(new MediaBrowserServiceCompat.ServiceCallbacksCompat(var1.replyTo), var2.getBundle("data_root_hints"));
               break;
            case 7:
               this.b.b(new MediaBrowserServiceCompat.ServiceCallbacksCompat(var1.replyTo));
               break;
            case 8:
               this.b
                  .a(
                     var2.getString("data_search_query"),
                     var2.getBundle("data_search_extras"),
                     (ResultReceiver)var2.getParcelable("data_result_receiver"),
                     new MediaBrowserServiceCompat.ServiceCallbacksCompat(var1.replyTo)
                  );
               break;
            case 9:
               this.b
                  .b(
                     var2.getString("data_custom_action"),
                     var2.getBundle("data_custom_action_extras"),
                     (ResultReceiver)var2.getParcelable("data_result_receiver"),
                     new MediaBrowserServiceCompat.ServiceCallbacksCompat(var1.replyTo)
                  );
               break;
            default:
               Log.w("MBServiceCompat", "Unhandled message: " + var1 + "\n  Service version: " + 2 + "\n  Client version: " + var1.arg1);
         }
      }

      public boolean sendMessageAtTime(Message var1, long var2) {
         Bundle var4 = var1.getData();
         var4.setClassLoader(MediaBrowserCompat.class.getClassLoader());
         var4.putInt("data_calling_uid", Binder.getCallingUid());
         return super.sendMessageAtTime(var1, var2);
      }
   }
}
