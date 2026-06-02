package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Notification.Builder;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class NotificationCompatBuilder implements NotificationBuilderWithBuilderAccessor {
   private final Builder a;
   private final NotificationCompat.Builder b;
   private RemoteViews c;
   private RemoteViews d;
   private final List<Bundle> e = new ArrayList<>();
   private final Bundle f = new Bundle();
   private int g;
   private RemoteViews h;

   NotificationCompatBuilder(NotificationCompat.Builder var1) {
      this.b = var1;
      if (VERSION.SDK_INT >= 26) {
         this.a = new Builder(var1.a, var1.H);
      } else {
         this.a = new Builder(var1.a);
      }

      Notification var3 = var1.M;
      Builder var4 = this.a
         .setWhen(var3.when)
         .setSmallIcon(var3.icon, var3.iconLevel)
         .setContent(var3.contentView)
         .setTicker(var3.tickerText, var1.g)
         .setVibrate(var3.vibrate)
         .setLights(var3.ledARGB, var3.ledOnMS, var3.ledOffMS);
      boolean var2;
      if ((var3.flags & 2) != 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      var4 = var4.setOngoing(var2);
      if ((var3.flags & 8) != 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      var4 = var4.setOnlyAlertOnce(var2);
      if ((var3.flags & 16) != 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      var4 = var4.setAutoCancel(var2)
         .setDefaults(var3.defaults)
         .setContentTitle(var1.c)
         .setContentText(var1.d)
         .setContentInfo(var1.i)
         .setContentIntent(var1.e)
         .setDeleteIntent(var3.deleteIntent);
      PendingIntent var5 = var1.f;
      if ((var3.flags & 128) != 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      var4.setFullScreenIntent(var5, var2).setLargeIcon(var1.h).setNumber(var1.j).setProgress(var1.q, var1.r, var1.s);
      if (VERSION.SDK_INT < 21) {
         this.a.setSound(var3.sound, var3.audioStreamType);
      }

      if (VERSION.SDK_INT >= 16) {
         this.a.setSubText(var1.o).setUsesChronometer(var1.m).setPriority(var1.k);
         Iterator var13 = var1.b.iterator();

         while (var13.hasNext()) {
            this.a((NotificationCompat.Action)var13.next());
         }

         if (var1.A != null) {
            this.f.putAll(var1.A);
         }

         if (VERSION.SDK_INT < 20) {
            if (var1.w) {
               this.f.putBoolean("android.support.localOnly", true);
            }

            if (var1.t != null) {
               this.f.putString("android.support.groupKey", var1.t);
               if (var1.u) {
                  this.f.putBoolean("android.support.isGroupSummary", true);
               } else {
                  this.f.putBoolean("android.support.useSideChannel", true);
               }
            }

            if (var1.v != null) {
               this.f.putString("android.support.sortKey", var1.v);
            }
         }

         this.c = var1.E;
         this.d = var1.F;
      }

      if (VERSION.SDK_INT >= 19) {
         this.a.setShowWhen(var1.l);
         if (VERSION.SDK_INT < 21 && var1.N != null && !var1.N.isEmpty()) {
            this.f.putStringArray("android.people", var1.N.toArray(new String[var1.N.size()]));
         }
      }

      if (VERSION.SDK_INT >= 20) {
         this.a.setLocalOnly(var1.w).setGroup(var1.t).setGroupSummary(var1.u).setSortKey(var1.v);
         this.g = var1.L;
      }

      if (VERSION.SDK_INT >= 21) {
         this.a.setCategory(var1.z).setColor(var1.B).setVisibility(var1.C).setPublicVersion(var1.D).setSound(var3.sound, var3.audioAttributes);

         for (String var14 : var1.N) {
            this.a.addPerson(var14);
         }

         this.h = var1.G;
      }

      if (VERSION.SDK_INT >= 24) {
         this.a.setExtras(var1.A).setRemoteInputHistory(var1.p);
         if (var1.E != null) {
            this.a.setCustomContentView(var1.E);
         }

         if (var1.F != null) {
            this.a.setCustomBigContentView(var1.F);
         }

         if (var1.G != null) {
            this.a.setCustomHeadsUpContentView(var1.G);
         }
      }

      if (VERSION.SDK_INT >= 26) {
         this.a.setBadgeIconType(var1.I).setShortcutId(var1.J).setTimeoutAfter(var1.K).setGroupAlertBehavior(var1.L);
         if (var1.y) {
            this.a.setColorized(var1.x);
         }

         if (!TextUtils.isEmpty(var1.H)) {
            this.a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
         }
      }
   }

   private void a(Notification var1) {
      var1.sound = null;
      var1.vibrate = null;
      var1.defaults &= -2;
      var1.defaults &= -3;
   }

   private void a(NotificationCompat.Action var1) {
      if (VERSION.SDK_INT >= 20) {
         android.app.Notification.Action.Builder var5 = new android.app.Notification.Action.Builder(var1.a(), var1.b(), var1.c());
         if (var1.f() != null) {
            android.app.RemoteInput[] var4 = RemoteInput.a(var1.f());
            int var3 = var4.length;

            for (int var2 = 0; var2 < var3; var2++) {
               var5.addRemoteInput(var4[var2]);
            }
         }

         Bundle var6;
         if (var1.d() != null) {
            var6 = new Bundle(var1.d());
         } else {
            var6 = new Bundle();
         }

         var6.putBoolean("android.support.allowGeneratedReplies", var1.e());
         if (VERSION.SDK_INT >= 24) {
            var5.setAllowGeneratedReplies(var1.e());
         }

         var5.addExtras(var6);
         this.a.addAction(var5.build());
      } else if (VERSION.SDK_INT >= 16) {
         this.e.add(NotificationCompatJellybean.a(this.a, var1));
      }
   }

   @Override
   public Builder a() {
      return this.a;
   }

   public Notification b() {
      NotificationCompat.Style var2 = this.b.n;
      if (var2 != null) {
         var2.a(this);
      }

      RemoteViews var1;
      if (var2 != null) {
         var1 = var2.b(this);
      } else {
         var1 = null;
      }

      Notification var3 = this.c();
      if (var1 != null) {
         var3.contentView = var1;
      } else if (this.b.E != null) {
         var3.contentView = this.b.E;
      }

      if (VERSION.SDK_INT >= 16 && var2 != null) {
         var1 = var2.c(this);
         if (var1 != null) {
            var3.bigContentView = var1;
         }
      }

      if (VERSION.SDK_INT >= 21 && var2 != null) {
         var1 = this.b.n.d(this);
         if (var1 != null) {
            var3.headsUpContentView = var1;
         }
      }

      if (VERSION.SDK_INT >= 16 && var2 != null) {
         Bundle var6 = NotificationCompat.a(var3);
         if (var6 != null) {
            var2.a(var6);
         }
      }

      return var3;
   }

   protected Notification c() {
      Notification var1;
      if (VERSION.SDK_INT >= 26) {
         var1 = this.a.build();
      } else if (VERSION.SDK_INT >= 24) {
         Notification var2 = this.a.build();
         var1 = var2;
         if (this.g != 0) {
            if (var2.getGroup() != null && (var2.flags & 512) != 0 && this.g == 2) {
               this.a(var2);
            }

            var1 = var2;
            if (var2.getGroup() != null) {
               var1 = var2;
               if ((var2.flags & 512) == 0) {
                  var1 = var2;
                  if (this.g == 1) {
                     this.a(var2);
                     var1 = var2;
                  }
               }
            }
         }
      } else if (VERSION.SDK_INT >= 21) {
         this.a.setExtras(this.f);
         Notification var7 = this.a.build();
         if (this.c != null) {
            var7.contentView = this.c;
         }

         if (this.d != null) {
            var7.bigContentView = this.d;
         }

         if (this.h != null) {
            var7.headsUpContentView = this.h;
         }

         var1 = var7;
         if (this.g != 0) {
            if (var7.getGroup() != null && (var7.flags & 512) != 0 && this.g == 2) {
               this.a(var7);
            }

            var1 = var7;
            if (var7.getGroup() != null) {
               var1 = var7;
               if ((var7.flags & 512) == 0) {
                  var1 = var7;
                  if (this.g == 1) {
                     this.a(var7);
                     var1 = var7;
                  }
               }
            }
         }
      } else if (VERSION.SDK_INT >= 20) {
         this.a.setExtras(this.f);
         Notification var8 = this.a.build();
         if (this.c != null) {
            var8.contentView = this.c;
         }

         if (this.d != null) {
            var8.bigContentView = this.d;
         }

         var1 = var8;
         if (this.g != 0) {
            if (var8.getGroup() != null && (var8.flags & 512) != 0 && this.g == 2) {
               this.a(var8);
            }

            var1 = var8;
            if (var8.getGroup() != null) {
               var1 = var8;
               if ((var8.flags & 512) == 0) {
                  var1 = var8;
                  if (this.g == 1) {
                     this.a(var8);
                     var1 = var8;
                  }
               }
            }
         }
      } else if (VERSION.SDK_INT >= 19) {
         SparseArray var6 = NotificationCompatJellybean.a(this.e);
         if (var6 != null) {
            this.f.putSparseParcelableArray("android.support.actionExtras", var6);
         }

         this.a.setExtras(this.f);
         Notification var9 = this.a.build();
         if (this.c != null) {
            var9.contentView = this.c;
         }

         var1 = var9;
         if (this.d != null) {
            var9.bigContentView = this.d;
            var1 = var9;
         }
      } else if (VERSION.SDK_INT >= 16) {
         var1 = this.a.build();
         Bundle var3 = NotificationCompat.a(var1);
         Bundle var10 = new Bundle(this.f);

         for (String var5 : this.f.keySet()) {
            if (var3.containsKey(var5)) {
               var10.remove(var5);
            }
         }

         var3.putAll(var10);
         SparseArray var11 = NotificationCompatJellybean.a(this.e);
         if (var11 != null) {
            NotificationCompat.a(var1).putSparseParcelableArray("android.support.actionExtras", var11);
         }

         if (this.c != null) {
            var1.contentView = this.c;
         }

         if (this.d != null) {
            var1.bigContentView = this.d;
         }
      } else {
         var1 = this.a.getNotification();
      }

      return var1;
   }
}
