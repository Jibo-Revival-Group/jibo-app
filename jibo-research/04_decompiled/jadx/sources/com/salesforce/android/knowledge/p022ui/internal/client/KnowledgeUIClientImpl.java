package com.salesforce.android.knowledge.p022ui.internal.client;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import com.salesforce.android.knowledge.core.KnowledgeClient;
import com.salesforce.android.knowledge.core.LogoutListener;
import com.salesforce.android.knowledge.p022ui.KnowledgeCssProvider;
import com.salesforce.android.knowledge.p022ui.KnowledgeImageProvider;
import com.salesforce.android.knowledge.p022ui.KnowledgeJsProvider;
import com.salesforce.android.knowledge.p022ui.KnowledgeUIAnalyticsEmit;
import com.salesforce.android.knowledge.p022ui.KnowledgeUIClient;
import com.salesforce.android.knowledge.p022ui.KnowledgeUIConfiguration;
import com.salesforce.android.knowledge.p022ui.KnowledgeViewAddition;
import com.salesforce.android.knowledge.p022ui.internal.CssProviderWrapper;
import com.salesforce.android.knowledge.p022ui.internal.ImageProviderWrapper;
import com.salesforce.android.knowledge.p022ui.internal.JsProviderWrapper;
import com.salesforce.android.knowledge.p022ui.internal.activity.FragmentLoader;
import com.salesforce.android.knowledge.p022ui.internal.activity.KnowledgeActivity;
import com.salesforce.android.knowledge.p022ui.internal.logging.LiveAgentKnowledgeLogger;
import com.salesforce.android.knowledge.p022ui.internal.minimize.MinimizeControl;
import com.salesforce.android.knowledge.p022ui.internal.navigation.Navigator;
import com.salesforce.android.knowledge.p022ui.internal.presenter.PresenterFactory;
import com.salesforce.android.service.common.utilities.activity.ActivityReference;
import com.salesforce.android.service.common.utilities.activity.ActivityTracker;
import com.salesforce.android.service.common.utilities.functional.Consumer;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class KnowledgeUIClientImpl implements LogoutListener, KnowledgeUIClient, ActivityTracker.OnCreateListener, ActivityTracker.OnDestroyListener, ActivityTracker.OnStartListener {

    /* JADX INFO: renamed from: n */
    private static final ServiceLogger f13213n = ServiceLogging.m14203a((Class<?>) KnowledgeUIClientImpl.class);

    /* JADX INFO: renamed from: b */
    private final KnowledgeUIConfiguration f13215b;

    /* JADX INFO: renamed from: c */
    private final KnowledgeClient f13216c;

    /* JADX INFO: renamed from: d */
    private final KnowledgeImageProvider f13217d;

    /* JADX INFO: renamed from: e */
    private final KnowledgeCssProvider f13218e;

    /* JADX INFO: renamed from: f */
    private final KnowledgeJsProvider f13219f;

    /* JADX INFO: renamed from: g */
    private final PresenterFactory f13220g;

    /* JADX INFO: renamed from: h */
    private final FragmentLoader f13221h;

    /* JADX INFO: renamed from: i */
    private final Navigator f13222i;

    /* JADX INFO: renamed from: j */
    private final MinimizeControl f13223j;

    /* JADX INFO: renamed from: k */
    private final ActivityTracker f13224k;

    /* JADX INFO: renamed from: l */
    private final LiveAgentKnowledgeLogger f13225l;

    /* JADX INFO: renamed from: m */
    private final Set<ViewAdditionController> f13226m = new HashSet();

    /* JADX INFO: renamed from: o */
    private final Set<KnowledgeUIClient.OnCloseListener> f13227o = Collections.newSetFromMap(new ConcurrentHashMap());

    /* JADX INFO: renamed from: a */
    ActivityReference<KnowledgeActivity> f13214a = ActivityReference.m14053a();

    /* JADX INFO: renamed from: a */
    public static KnowledgeUIClientImpl m13526a(KnowledgeUIConfiguration knowledgeUIConfiguration, KnowledgeClient knowledgeClient, Set<KnowledgeViewAddition> set) {
        return new KnowledgeUIClientImpl(knowledgeUIConfiguration, knowledgeClient, set, new RuntimeModuleProvider());
    }

    private KnowledgeUIClientImpl(KnowledgeUIConfiguration knowledgeUIConfiguration, KnowledgeClient knowledgeClient, Set<KnowledgeViewAddition> set, ModuleProvider moduleProvider) {
        this.f13215b = knowledgeUIConfiguration;
        this.f13216c = knowledgeClient;
        Iterator<KnowledgeViewAddition> it = set.iterator();
        while (it.hasNext()) {
            this.f13226m.add(new ViewAdditionController(it.next()));
        }
        this.f13224k = moduleProvider.mo13542a().m14056a((ActivityTracker.OnCreateListener) this).m14060a((ActivityTracker.OnStartListener) this).m14057a((ActivityTracker.OnDestroyListener) this);
        this.f13221h = moduleProvider.mo13543b();
        this.f13223j = moduleProvider.mo13544b(this);
        this.f13220g = moduleProvider.mo13541a(this);
        this.f13225l = moduleProvider.mo13545c(this);
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.f13226m);
        hashSet.add(this.f13221h);
        this.f13222i = moduleProvider.mo13540a(this, (Navigator.Listener[]) hashSet.toArray(new Navigator.Listener[hashSet.size()]));
        this.f13217d = ImageProviderWrapper.m13411a(this.f13215b.m13399c());
        this.f13218e = CssProviderWrapper.m13410a(this.f13215b.m13400d());
        this.f13219f = JsProviderWrapper.m13412a(this.f13215b.m13401e());
    }

    @Override // com.salesforce.android.knowledge.p022ui.KnowledgeUIClient
    /* JADX INFO: renamed from: b */
    public void mo13391b() {
        m13539n();
    }

    @Override // com.salesforce.android.knowledge.p022ui.KnowledgeUIClient
    /* JADX INFO: renamed from: b */
    public void mo13392b(Activity activity) {
        if (!this.f13214a.m14100b()) {
            if (this.f13223j.m13615a()) {
                this.f13223j.m13611a(activity);
                return;
            }
            this.f13224k.m14063a(activity);
            this.f13224k.m14064a(activity.getApplicationContext());
            this.f13225l.m13604a(activity.getApplicationContext());
            m13527a((Context) activity);
        }
    }

    @Override // com.salesforce.android.knowledge.p022ui.KnowledgeUIClient
    /* JADX INFO: renamed from: c */
    public KnowledgeClient mo13393c() {
        return this.f13216c;
    }

    /* JADX INFO: renamed from: f */
    public KnowledgeUIConfiguration m13531f() {
        return this.f13215b;
    }

    /* JADX INFO: renamed from: g */
    public KnowledgeImageProvider m13532g() {
        return this.f13217d;
    }

    @Override // com.salesforce.android.knowledge.p022ui.KnowledgeUIClient
    /* JADX INFO: renamed from: d */
    public KnowledgeCssProvider mo13394d() {
        return this.f13218e;
    }

    @Override // com.salesforce.android.knowledge.p022ui.KnowledgeUIClient
    /* JADX INFO: renamed from: e */
    public KnowledgeJsProvider mo13395e() {
        return this.f13219f;
    }

    @Override // com.salesforce.android.knowledge.p022ui.KnowledgeUIClient
    /* JADX INFO: renamed from: a */
    public void mo13390a(KnowledgeUIClient.OnCloseListener onCloseListener) {
        this.f13227o.add(onCloseListener);
    }

    @Override // com.salesforce.android.service.common.utilities.activity.ActivityTracker.OnCreateListener
    /* JADX INFO: renamed from: c */
    public void mo13529c(Activity activity) {
        if (activity instanceof KnowledgeActivity) {
            KnowledgeActivity knowledgeActivity = (KnowledgeActivity) activity;
            knowledgeActivity.m13433a(this);
            this.f13214a = ActivityReference.m14054a(knowledgeActivity);
        }
    }

    @Override // com.salesforce.android.service.common.utilities.activity.ActivityTracker.OnStartListener
    /* JADX INFO: renamed from: a */
    public void mo12740a(Activity activity) {
        if (activity instanceof KnowledgeActivity) {
            KnowledgeActivity knowledgeActivity = (KnowledgeActivity) activity;
            Iterator<ViewAdditionController> it = this.f13226m.iterator();
            while (it.hasNext()) {
                it.next().m13548a(knowledgeActivity, this.f13222i.m13647e());
            }
            this.f13222i.m13639a(activity, this.f13215b.m13398b());
            this.f13221h.m13425a(knowledgeActivity);
        }
    }

    @Override // com.salesforce.android.service.common.utilities.activity.ActivityTracker.OnDestroyListener
    /* JADX INFO: renamed from: d */
    public void mo13530d(Activity activity) {
        if (activity instanceof KnowledgeActivity) {
            this.f13214a.m14099b((KnowledgeActivity) activity);
        }
    }

    /* JADX INFO: renamed from: h */
    public PresenterFactory m13533h() {
        return this.f13220g;
    }

    /* JADX INFO: renamed from: i */
    public Navigator m13534i() {
        return this.f13222i;
    }

    /* JADX INFO: renamed from: j */
    public MinimizeControl m13535j() {
        return this.f13223j;
    }

    /* JADX INFO: renamed from: k */
    public ActivityTracker m13536k() {
        return this.f13224k;
    }

    /* JADX INFO: renamed from: a */
    public void m13527a(Context context) {
        KnowledgeActivity.m13431a(context);
    }

    /* JADX INFO: renamed from: l */
    public void m13537l() {
        this.f13214a.m14097a(new Consumer<AppCompatActivity>() { // from class: com.salesforce.android.knowledge.ui.internal.client.KnowledgeUIClientImpl.1
            @Override // com.salesforce.android.service.common.utilities.functional.Consumer
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public void mo13033a(AppCompatActivity appCompatActivity) {
                appCompatActivity.finish();
            }
        });
    }

    /* JADX INFO: renamed from: m */
    public void m13538m() {
        this.f13222i.m13646d();
        if (this.f13222i.m13645c()) {
            m13539n();
        }
    }

    /* JADX INFO: renamed from: n */
    public void m13539n() {
        KnowledgeUIAnalyticsEmit.m13380i();
        this.f13223j.m13616b();
        this.f13222i.m13648f();
        m13537l();
        Iterator<KnowledgeUIClient.OnCloseListener> it = this.f13227o.iterator();
        while (it.hasNext()) {
            it.next().mo9876a();
        }
        this.f13225l.m13603a();
        this.f13224k.m14066b((ActivityTracker.OnCreateListener) this).m14070b((ActivityTracker.OnStartListener) this).m14067b((ActivityTracker.OnDestroyListener) this).m14062a();
        KnowledgeUIAnalyticsEmit.m13361a();
        this.f13216c.mo13072c();
    }

    /* JADX INFO: renamed from: b */
    public boolean m13528b(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override // com.salesforce.android.knowledge.core.LogoutListener
    /* JADX INFO: renamed from: a */
    public void mo13084a() {
        f13213n.mo14190c("Terminating KB UI due to Auth user logout.");
        m13539n();
    }
}
