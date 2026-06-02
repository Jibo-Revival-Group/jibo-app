package bolts;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Build.VERSION;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class AndroidExecutors {
   static final int a = AndroidExecutors.e + 1;
   static final int b = AndroidExecutors.e * 2 + 1;
   private static final AndroidExecutors c = new AndroidExecutors();
   private static final int e = Runtime.getRuntime().availableProcessors();
   private final Executor d = new AndroidExecutors.UIThreadExecutor();

   private AndroidExecutors() {
   }

   public static ExecutorService a() {
      ThreadPoolExecutor var0 = new ThreadPoolExecutor(a, b, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
      a(var0, true);
      return var0;
   }

   @SuppressLint("NewApi")
   public static void a(ThreadPoolExecutor var0, boolean var1) {
      if (VERSION.SDK_INT >= 9) {
         var0.allowCoreThreadTimeOut(var1);
      }
   }

   public static Executor b() {
      return c.d;
   }

   private static class UIThreadExecutor implements Executor {
      private UIThreadExecutor() {
      }

      @Override
      public void execute(Runnable var1) {
         new Handler(Looper.getMainLooper()).post(var1);
      }
   }
}
