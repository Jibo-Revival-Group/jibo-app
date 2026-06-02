package org.slf4j;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.event.SubstituteLoggingEvent;
import org.slf4j.helpers.NOPLoggerFactory;
import org.slf4j.helpers.SubstituteLogger;
import org.slf4j.helpers.SubstituteLoggerFactory;
import org.slf4j.helpers.Util;
import org.slf4j.impl.StaticLoggerBinder;

/* JADX INFO: loaded from: classes2.dex */
public final class LoggerFactory {

    /* JADX INFO: renamed from: a */
    static volatile int f16199a = 0;

    /* JADX INFO: renamed from: b */
    static final SubstituteLoggerFactory f16200b = new SubstituteLoggerFactory();

    /* JADX INFO: renamed from: c */
    static final NOPLoggerFactory f16201c = new NOPLoggerFactory();

    /* JADX INFO: renamed from: d */
    static boolean f16202d = Util.m17069b("slf4j.detectLoggerNameMismatch");

    /* JADX INFO: renamed from: e */
    private static final String[] f16203e = {"1.6", "1.7"};

    /* JADX INFO: renamed from: f */
    private static String f16204f = "org/slf4j/impl/StaticLoggerBinder.class";

    private LoggerFactory() {
    }

    /* JADX INFO: renamed from: c */
    private static final void m17034c() {
        m17036d();
        if (f16199a == 3) {
            m17040h();
        }
    }

    /* JADX INFO: renamed from: b */
    private static boolean m17033b(String str) {
        if (str == null) {
            return false;
        }
        return str.contains("org/slf4j/impl/StaticLoggerBinder") || str.contains("org.slf4j.impl.StaticLoggerBinder");
    }

    /* JADX INFO: renamed from: d */
    private static final void m17036d() {
        Set<URL> setM17024a = null;
        try {
            if (!m17041i()) {
                setM17024a = m17024a();
                m17032b(setM17024a);
            }
            StaticLoggerBinder.m17071a();
            f16199a = 3;
            m17035c(setM17024a);
            m17037e();
            m17038f();
            f16200b.m17066d();
        } catch (Exception e) {
            m17027a(e);
            throw new IllegalStateException("Unexpected initialization failure", e);
        } catch (NoClassDefFoundError e2) {
            if (m17033b(e2.getMessage())) {
                f16199a = 4;
                Util.m17070c("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
                Util.m17070c("Defaulting to no-operation (NOP) logger implementation");
                Util.m17070c("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
                return;
            }
            m17027a(e2);
            throw e2;
        } catch (NoSuchMethodError e3) {
            String message = e3.getMessage();
            if (message != null && message.contains("org.slf4j.impl.StaticLoggerBinder.getSingleton()")) {
                f16199a = 2;
                Util.m17070c("slf4j-api 1.6.x (or later) is incompatible with this binding.");
                Util.m17070c("Your binding is version 1.5.5 or earlier.");
                Util.m17070c("Upgrade your binding to version 1.6.x.");
            }
            throw e3;
        }
    }

    /* JADX INFO: renamed from: e */
    private static void m17037e() {
        synchronized (f16200b) {
            f16200b.m17065c();
            for (SubstituteLogger substituteLogger : f16200b.m17063a()) {
                substituteLogger.m17057a(m17025a(substituteLogger.m17056a()));
            }
        }
    }

    /* JADX INFO: renamed from: a */
    static void m17027a(Throwable th) {
        f16199a = 2;
        Util.m17068a("Failed to instantiate SLF4J LoggerFactory", th);
    }

    /* JADX INFO: renamed from: f */
    private static void m17038f() {
        LinkedBlockingQueue<SubstituteLoggingEvent> linkedBlockingQueueM17064b = f16200b.m17064b();
        int size = linkedBlockingQueueM17064b.size();
        int i = 0;
        ArrayList<SubstituteLoggingEvent> arrayList = new ArrayList(128);
        while (linkedBlockingQueueM17064b.drainTo(arrayList, 128) != 0) {
            int i2 = i;
            for (SubstituteLoggingEvent substituteLoggingEvent : arrayList) {
                m17028a(substituteLoggingEvent);
                int i3 = i2 + 1;
                if (i2 == 0) {
                    m17029a(substituteLoggingEvent, size);
                }
                i2 = i3;
            }
            arrayList.clear();
            i = i2;
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m17029a(SubstituteLoggingEvent substituteLoggingEvent, int i) {
        if (substituteLoggingEvent.m17044a().m17060c()) {
            m17026a(i);
        } else if (!substituteLoggingEvent.m17044a().m17062e()) {
            m17039g();
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m17028a(SubstituteLoggingEvent substituteLoggingEvent) {
        if (substituteLoggingEvent != null) {
            SubstituteLogger substituteLoggerM17044a = substituteLoggingEvent.m17044a();
            String strM17056a = substituteLoggerM17044a.m17056a();
            if (substituteLoggerM17044a.m17061d()) {
                throw new IllegalStateException("Delegate logger cannot be null at this state.");
            }
            if (!substituteLoggerM17044a.m17062e()) {
                if (substituteLoggerM17044a.m17060c()) {
                    substituteLoggerM17044a.m17058a(substituteLoggingEvent);
                } else {
                    Util.m17070c(strM17056a);
                }
            }
        }
    }

    /* JADX INFO: renamed from: g */
    private static void m17039g() {
        Util.m17070c("The following set of substitute loggers may have been accessed");
        Util.m17070c("during the initialization phase. Logging calls during this");
        Util.m17070c("phase were not honored. However, subsequent logging calls to these");
        Util.m17070c("loggers will work as normally expected.");
        Util.m17070c("See also http://www.slf4j.org/codes.html#substituteLogger");
    }

    /* JADX INFO: renamed from: a */
    private static void m17026a(int i) {
        Util.m17070c("A number (" + i + ") of logging calls during the initialization phase have been intercepted and are");
        Util.m17070c("now being replayed. These are subject to the filtering rules of the underlying logging system.");
        Util.m17070c("See also http://www.slf4j.org/codes.html#replay");
    }

    /* JADX INFO: renamed from: h */
    private static final void m17040h() {
        boolean z = false;
        try {
            String str = StaticLoggerBinder.f16230a;
            for (String str2 : f16203e) {
                if (str.startsWith(str2)) {
                    z = true;
                }
            }
            if (!z) {
                Util.m17070c("The requested version " + str + " by your slf4j binding is not compatible with " + Arrays.asList(f16203e).toString());
                Util.m17070c("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
            }
        } catch (NoSuchFieldError e) {
        } catch (Throwable th) {
            Util.m17068a("Unexpected problem occured during version sanity check", th);
        }
    }

    /* JADX INFO: renamed from: a */
    static Set<URL> m17024a() throws IOException {
        Enumeration<URL> resources;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            ClassLoader classLoader = LoggerFactory.class.getClassLoader();
            if (classLoader == null) {
                resources = ClassLoader.getSystemResources(f16204f);
            } else {
                resources = classLoader.getResources(f16204f);
            }
            while (resources.hasMoreElements()) {
                linkedHashSet.add(resources.nextElement());
            }
        } catch (IOException e) {
            Util.m17068a("Error getting resources from path", e);
        }
        return linkedHashSet;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m17030a(Set<URL> set) {
        return set.size() > 1;
    }

    /* JADX INFO: renamed from: b */
    private static void m17032b(Set<URL> set) {
        if (m17030a(set)) {
            Util.m17070c("Class path contains multiple SLF4J bindings.");
            Iterator<URL> it = set.iterator();
            while (it.hasNext()) {
                Util.m17070c("Found binding in [" + it.next() + "]");
            }
            Util.m17070c("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }

    /* JADX INFO: renamed from: i */
    private static boolean m17041i() {
        String strM17067a = Util.m17067a("java.vendor.url");
        if (strM17067a == null) {
            return false;
        }
        return strM17067a.toLowerCase().contains("android");
    }

    /* JADX INFO: renamed from: c */
    private static void m17035c(Set<URL> set) {
        if (set != null && m17030a(set)) {
            Util.m17070c("Actual binding is of type [" + StaticLoggerBinder.m17071a().m17073c() + "]");
        }
    }

    /* JADX INFO: renamed from: a */
    public static Logger m17025a(String str) {
        return m17031b().mo17017a(str);
    }

    /* JADX INFO: renamed from: b */
    public static ILoggerFactory m17031b() {
        if (f16199a == 0) {
            synchronized (LoggerFactory.class) {
                if (f16199a == 0) {
                    f16199a = 1;
                    m17034c();
                }
            }
        }
        switch (f16199a) {
            case 1:
                return f16200b;
            case 2:
                throw new IllegalStateException("org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
            case 3:
                return StaticLoggerBinder.m17071a().m17072b();
            case 4:
                return f16201c;
            default:
                throw new IllegalStateException("Unreachable code");
        }
    }
}
