package io.fabric.sdk.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import io.fabric.sdk.android.ActivityLifecycleManager;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.concurrency.DependsOn;
import io.fabric.sdk.android.services.concurrency.PriorityThreadPoolExecutor;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class Fabric {

    /* JADX INFO: renamed from: a */
    static volatile Fabric f14497a;

    /* JADX INFO: renamed from: b */
    static final Logger f14498b = new DefaultLogger();

    /* JADX INFO: renamed from: c */
    final Logger f14499c;

    /* JADX INFO: renamed from: d */
    final boolean f14500d;

    /* JADX INFO: renamed from: e */
    private final Context f14501e;

    /* JADX INFO: renamed from: f */
    private final Map<Class<? extends Kit>, Kit> f14502f;

    /* JADX INFO: renamed from: g */
    private final ExecutorService f14503g;

    /* JADX INFO: renamed from: h */
    private final Handler f14504h;

    /* JADX INFO: renamed from: i */
    private final InitializationCallback<Fabric> f14505i;

    /* JADX INFO: renamed from: j */
    private final InitializationCallback<?> f14506j;

    /* JADX INFO: renamed from: k */
    private final IdManager f14507k;

    /* JADX INFO: renamed from: l */
    private ActivityLifecycleManager f14508l;

    /* JADX INFO: renamed from: m */
    private WeakReference<Activity> f14509m;

    /* JADX INFO: renamed from: n */
    private AtomicBoolean f14510n = new AtomicBoolean(false);

    public static class Builder {

        /* JADX INFO: renamed from: a */
        private final Context f14515a;

        /* JADX INFO: renamed from: b */
        private Kit[] f14516b;

        /* JADX INFO: renamed from: c */
        private PriorityThreadPoolExecutor f14517c;

        /* JADX INFO: renamed from: d */
        private Handler f14518d;

        /* JADX INFO: renamed from: e */
        private Logger f14519e;

        /* JADX INFO: renamed from: f */
        private boolean f14520f;

        /* JADX INFO: renamed from: g */
        private String f14521g;

        /* JADX INFO: renamed from: h */
        private String f14522h;

        /* JADX INFO: renamed from: i */
        private InitializationCallback<Fabric> f14523i;

        public Builder(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.f14515a = context;
        }

        /* JADX INFO: renamed from: a */
        public Builder m15101a(Kit... kitArr) {
            if (this.f14516b != null) {
                throw new IllegalStateException("Kits already set.");
            }
            this.f14516b = kitArr;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Fabric m15102a() {
            Map mapM15081b;
            if (this.f14517c == null) {
                this.f14517c = PriorityThreadPoolExecutor.m15310a();
            }
            if (this.f14518d == null) {
                this.f14518d = new Handler(Looper.getMainLooper());
            }
            if (this.f14519e == null) {
                if (this.f14520f) {
                    this.f14519e = new DefaultLogger(3);
                } else {
                    this.f14519e = new DefaultLogger();
                }
            }
            if (this.f14522h == null) {
                this.f14522h = this.f14515a.getPackageName();
            }
            if (this.f14523i == null) {
                this.f14523i = InitializationCallback.f14527d;
            }
            if (this.f14516b != null) {
                mapM15081b = Fabric.m15081b(Arrays.asList(this.f14516b));
            } else {
                mapM15081b = new HashMap();
            }
            Context applicationContext = this.f14515a.getApplicationContext();
            return new Fabric(applicationContext, mapM15081b, this.f14517c, this.f14518d, this.f14519e, this.f14520f, this.f14523i, new IdManager(applicationContext, this.f14522h, this.f14521g, mapM15081b.values()), Fabric.m15084d(this.f14515a));
        }
    }

    /* JADX INFO: renamed from: a */
    static Fabric m15074a() {
        if (f14497a == null) {
            throw new IllegalStateException("Must Initialize Fabric before using singleton()");
        }
        return f14497a;
    }

    Fabric(Context context, Map<Class<? extends Kit>, Kit> map, PriorityThreadPoolExecutor priorityThreadPoolExecutor, Handler handler, Logger logger, boolean z, InitializationCallback initializationCallback, IdManager idManager, Activity activity) {
        this.f14501e = context;
        this.f14502f = map;
        this.f14503g = priorityThreadPoolExecutor;
        this.f14504h = handler;
        this.f14499c = logger;
        this.f14500d = z;
        this.f14505i = initializationCallback;
        this.f14506j = m15089a(map.size());
        this.f14507k = idManager;
        m15088a(activity);
    }

    /* JADX INFO: renamed from: a */
    public static Fabric m15075a(Context context, Kit... kitArr) {
        if (f14497a == null) {
            synchronized (Fabric.class) {
                if (f14497a == null) {
                    m15083c(new Builder(context).m15101a(kitArr).m15102a());
                }
            }
        }
        return f14497a;
    }

    /* JADX INFO: renamed from: c */
    private static void m15083c(Fabric fabric) {
        f14497a = fabric;
        fabric.m15087j();
    }

    /* JADX INFO: renamed from: a */
    public Fabric m15088a(Activity activity) {
        this.f14509m = new WeakReference<>(activity);
        return this;
    }

    /* JADX INFO: renamed from: b */
    public Activity m15092b() {
        if (this.f14509m != null) {
            return this.f14509m.get();
        }
        return null;
    }

    /* JADX INFO: renamed from: j */
    private void m15087j() {
        this.f14508l = new ActivityLifecycleManager(this.f14501e);
        this.f14508l.m15056a(new ActivityLifecycleManager.Callbacks() { // from class: io.fabric.sdk.android.Fabric.1
            @Override // io.fabric.sdk.android.ActivityLifecycleManager.Callbacks
            /* JADX INFO: renamed from: a */
            public void mo5628a(Activity activity, Bundle bundle) {
                Fabric.this.m15088a(activity);
            }

            @Override // io.fabric.sdk.android.ActivityLifecycleManager.Callbacks
            /* JADX INFO: renamed from: a */
            public void mo5627a(Activity activity) {
                Fabric.this.m15088a(activity);
            }

            @Override // io.fabric.sdk.android.ActivityLifecycleManager.Callbacks
            /* JADX INFO: renamed from: b */
            public void mo5629b(Activity activity) {
                Fabric.this.m15088a(activity);
            }
        });
        m15090a(this.f14501e);
    }

    /* JADX INFO: renamed from: c */
    public String m15094c() {
        return "1.3.17.dev";
    }

    /* JADX INFO: renamed from: d */
    public String m15095d() {
        return "io.fabric.sdk.android:fabric";
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: a */
    void m15090a(Context context) {
        StringBuilder sbAppend;
        Future<Map<String, KitInfo>> futureM15093b = m15093b(context);
        Collection<Kit> collectionM15098g = m15098g();
        Onboarding onboarding = new Onboarding(futureM15093b, collectionM15098g);
        ArrayList<Kit> arrayList = new ArrayList(collectionM15098g);
        Collections.sort(arrayList);
        onboarding.m15115a(context, this, InitializationCallback.f14527d, this.f14507k);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Kit) it.next()).m15115a(context, this, this.f14506j, this.f14507k);
        }
        onboarding.m15119p();
        if (m15085h().mo15065a("Fabric", 3)) {
            sbAppend = new StringBuilder("Initializing ").append(m15095d()).append(" [Version: ").append(m15094c()).append("], with the following kits:\n");
        } else {
            sbAppend = null;
        }
        for (Kit kit : arrayList) {
            kit.f14530f.mo15285c(onboarding.f14530f);
            m15091a(this.f14502f, kit);
            kit.m15119p();
            if (sbAppend != null) {
                sbAppend.append(kit.mo5601b()).append(" [Version: ").append(kit.mo5600a()).append("]\n");
            }
        }
        if (sbAppend != null) {
            m15085h().mo15063a("Fabric", sbAppend.toString());
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: a */
    void m15091a(Map<Class<? extends Kit>, Kit> map, Kit kit) {
        DependsOn dependsOn = kit.f14534j;
        if (dependsOn != null) {
            for (Class<?> cls : dependsOn.m15297a()) {
                if (cls.isInterface()) {
                    for (Kit kit2 : map.values()) {
                        if (cls.isAssignableFrom(kit2.getClass())) {
                            kit.f14530f.mo15285c(kit2.f14530f);
                        }
                    }
                } else {
                    if (map.get(cls) == null) {
                        throw new UnmetDependencyException("Referenced Kit was null, does the kit exist?");
                    }
                    kit.f14530f.mo15285c(map.get(cls).f14530f);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d */
    public static Activity m15084d(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    /* JADX INFO: renamed from: e */
    public ActivityLifecycleManager m15096e() {
        return this.f14508l;
    }

    /* JADX INFO: renamed from: f */
    public ExecutorService m15097f() {
        return this.f14503g;
    }

    /* JADX INFO: renamed from: g */
    public Collection<Kit> m15098g() {
        return this.f14502f.values();
    }

    /* JADX INFO: renamed from: a */
    public static <T extends Kit> T m15076a(Class<T> cls) {
        return (T) m15074a().f14502f.get(cls);
    }

    /* JADX INFO: renamed from: h */
    public static Logger m15085h() {
        return f14497a == null ? f14498b : f14497a.f14499c;
    }

    /* JADX INFO: renamed from: i */
    public static boolean m15086i() {
        if (f14497a == null) {
            return false;
        }
        return f14497a.f14500d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static Map<Class<? extends Kit>, Kit> m15081b(Collection<? extends Kit> collection) {
        HashMap map = new HashMap(collection.size());
        m15079a(map, collection);
        return map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    private static void m15079a(Map<Class<? extends Kit>, Kit> map, Collection<? extends Kit> collection) {
        for (Object obj : collection) {
            map.put(obj.getClass(), obj);
            if (obj instanceof KitGroup) {
                m15079a(map, ((KitGroup) obj).mo5602c());
            }
        }
    }

    /* JADX INFO: renamed from: a */
    InitializationCallback<?> m15089a(final int i) {
        return new InitializationCallback() { // from class: io.fabric.sdk.android.Fabric.2

            /* JADX INFO: renamed from: a */
            final CountDownLatch f14512a;

            {
                this.f14512a = new CountDownLatch(i);
            }

            @Override // io.fabric.sdk.android.InitializationCallback
            /* JADX INFO: renamed from: a */
            public void mo15100a(Object obj) {
                this.f14512a.countDown();
                if (this.f14512a.getCount() == 0) {
                    Fabric.this.f14510n.set(true);
                    Fabric.this.f14505i.mo15100a(Fabric.this);
                }
            }

            @Override // io.fabric.sdk.android.InitializationCallback
            /* JADX INFO: renamed from: a */
            public void mo15099a(Exception exc) {
                Fabric.this.f14505i.mo15099a(exc);
            }
        };
    }

    /* JADX INFO: renamed from: b */
    Future<Map<String, KitInfo>> m15093b(Context context) {
        return m15097f().submit(new FabricKitsFinder(context.getPackageCodePath()));
    }
}
