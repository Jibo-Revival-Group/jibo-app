package bolts;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
final class BoltsExecutors {

    /* JADX INFO: renamed from: a */
    private static final BoltsExecutors f4580a = new BoltsExecutors();

    /* JADX INFO: renamed from: b */
    private final ExecutorService f4581b;

    /* JADX INFO: renamed from: c */
    private final ScheduledExecutorService f4582c;

    /* JADX INFO: renamed from: d */
    private final Executor f4583d;

    /* JADX INFO: renamed from: c */
    private static boolean m5107c() {
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            return false;
        }
        return property.toLowerCase(Locale.US).contains("android");
    }

    private BoltsExecutors() {
        this.f4581b = !m5107c() ? Executors.newCachedThreadPool() : AndroidExecutors.m5100a();
        this.f4582c = Executors.newSingleThreadScheduledExecutor();
        this.f4583d = new ImmediateExecutor();
    }

    /* JADX INFO: renamed from: a */
    public static ExecutorService m5105a() {
        return f4580a.f4581b;
    }

    /* JADX INFO: renamed from: b */
    static Executor m5106b() {
        return f4580a.f4583d;
    }

    private static class ImmediateExecutor implements Executor {

        /* JADX INFO: renamed from: a */
        private ThreadLocal<Integer> f4584a;

        private ImmediateExecutor() {
            this.f4584a = new ThreadLocal<>();
        }

        /* JADX INFO: renamed from: a */
        private int m5108a() {
            Integer num = this.f4584a.get();
            if (num == null) {
                num = 0;
            }
            int iIntValue = num.intValue() + 1;
            this.f4584a.set(Integer.valueOf(iIntValue));
            return iIntValue;
        }

        /* JADX INFO: renamed from: b */
        private int m5109b() {
            Integer num = this.f4584a.get();
            if (num == null) {
                num = 0;
            }
            int iIntValue = num.intValue() - 1;
            if (iIntValue == 0) {
                this.f4584a.remove();
            } else {
                this.f4584a.set(Integer.valueOf(iIntValue));
            }
            return iIntValue;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            try {
                if (m5108a() <= 15) {
                    runnable.run();
                } else {
                    BoltsExecutors.m5105a().execute(runnable);
                }
            } finally {
                m5109b();
            }
        }
    }
}
