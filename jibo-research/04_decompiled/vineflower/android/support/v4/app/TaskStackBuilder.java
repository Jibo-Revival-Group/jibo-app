package android.support.v4.app;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class TaskStackBuilder implements Iterable<Intent> {
   private static final TaskStackBuilder.TaskStackBuilderBaseImpl a;
   private final ArrayList<Intent> b = new ArrayList<>();
   private final Context c;

   static {
      if (VERSION.SDK_INT >= 16) {
         a = new TaskStackBuilder.TaskStackBuilderApi16Impl();
      } else {
         a = new TaskStackBuilder.TaskStackBuilderBaseImpl();
      }
   }

   private TaskStackBuilder(Context var1) {
      this.c = var1;
   }

   public static TaskStackBuilder a(Context var0) {
      return new TaskStackBuilder(var0);
   }

   public PendingIntent a(int var1, int var2) {
      return this.a(var1, var2, null);
   }

   public PendingIntent a(int var1, int var2, Bundle var3) {
      if (this.b.isEmpty()) {
         throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
      }

      Intent[] var4 = this.b.toArray(new Intent[this.b.size()]);
      var4[0] = new Intent(var4[0]).addFlags(268484608);
      return a.a(this.c, var4, var1, var2, var3);
   }

   public TaskStackBuilder a(Activity var1) {
      Intent var2 = null;
      if (var1 instanceof TaskStackBuilder.SupportParentable) {
         var2 = ((TaskStackBuilder.SupportParentable)var1).getSupportParentActivityIntent();
      }

      Intent var4;
      if (var2 == null) {
         var4 = NavUtils.a(var1);
      } else {
         var4 = var2;
      }

      if (var4 != null) {
         ComponentName var3 = var4.getComponent();
         ComponentName var5 = var3;
         if (var3 == null) {
            var5 = var4.resolveActivity(this.c.getPackageManager());
         }

         this.a(var5);
         this.a(var4);
      }

      return this;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public TaskStackBuilder a(ComponentName var1) {
      int var2 = this.b.size();

      try {
         var5 = NavUtils.a(this.c, var1);
      } catch (NameNotFoundException var4) {
         Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
         throw new IllegalArgumentException(var4);
      }

      while (var5 != null) {
         try {
            this.b.add(var2, var5);
            var5 = NavUtils.a(this.c, var5.getComponent());
         } catch (NameNotFoundException var3) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(var3);
         }
      }

      return this;
   }

   public TaskStackBuilder a(Intent var1) {
      this.b.add(var1);
      return this;
   }

   public void a() {
      this.a((Bundle)null);
   }

   public void a(Bundle var1) {
      if (this.b.isEmpty()) {
         throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
      }

      Intent[] var2 = this.b.toArray(new Intent[this.b.size()]);
      var2[0] = new Intent(var2[0]).addFlags(268484608);
      if (!ContextCompat.a(this.c, var2, var1)) {
         Intent var3 = new Intent(var2[var2.length - 1]);
         var3.addFlags(268435456);
         this.c.startActivity(var3);
      }
   }

   public TaskStackBuilder b(Intent var1) {
      ComponentName var3 = var1.getComponent();
      ComponentName var2 = var3;
      if (var3 == null) {
         var2 = var1.resolveActivity(this.c.getPackageManager());
      }

      if (var2 != null) {
         this.a(var2);
      }

      this.a(var1);
      return this;
   }

   @Deprecated
   @Override
   public Iterator<Intent> iterator() {
      return this.b.iterator();
   }

   public interface SupportParentable {
      Intent getSupportParentActivityIntent();
   }

   static class TaskStackBuilderApi16Impl extends TaskStackBuilder.TaskStackBuilderBaseImpl {
      @Override
      public PendingIntent a(Context var1, Intent[] var2, int var3, int var4, Bundle var5) {
         var2[0] = new Intent(var2[0]).addFlags(268484608);
         return PendingIntent.getActivities(var1, var3, var2, var4, var5);
      }
   }

   static class TaskStackBuilderBaseImpl {
      public PendingIntent a(Context var1, Intent[] var2, int var3, int var4, Bundle var5) {
         var2[0] = new Intent(var2[0]).addFlags(268484608);
         return PendingIntent.getActivities(var1, var3, var2, var4);
      }
   }
}
