package bolts;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
final class AndroidExecutors {

    /* JADX INFO: renamed from: d */
    private final Executor f4572d = new UIThreadExecutor();

    /* JADX INFO: renamed from: c */
    private static final AndroidExecutors f4570c = new AndroidExecutors();

    /* JADX INFO: renamed from: e */
    private static final int f4571e = Runtime.getRuntime().availableProcessors();

    /* JADX INFO: renamed from: a */
    static final int f4568a = f4571e + 1;

    /* JADX INFO: renamed from: b */
    static final int f4569b = (f4571e * 2) + 1;

    private AndroidExecutors() {
    }

    /* JADX INFO: renamed from: a */
    public static ExecutorService m5100a() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f4568a, f4569b, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        m5101a(threadPoolExecutor, true);
        return threadPoolExecutor;
    }

    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: a */
    public static void m5101a(ThreadPoolExecutor threadPoolExecutor, boolean z) {
        if (Build.VERSION.SDK_INT >= 9) {
            threadPoolExecutor.allowCoreThreadTimeOut(z);
        }
    }

    /* JADX INFO: renamed from: b */
    public static Executor m5102b() {
        return f4570c.f4572d;
    }

    private static class UIThreadExecutor implements Executor {
        private UIThreadExecutor() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }
}
