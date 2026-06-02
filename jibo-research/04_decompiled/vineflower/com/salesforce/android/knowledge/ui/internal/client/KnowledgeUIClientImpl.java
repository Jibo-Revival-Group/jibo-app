package com.salesforce.android.knowledge.ui.internal.client;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import com.salesforce.android.knowledge.core.KnowledgeClient;
import com.salesforce.android.knowledge.core.LogoutListener;
import com.salesforce.android.knowledge.ui.KnowledgeCssProvider;
import com.salesforce.android.knowledge.ui.KnowledgeImageProvider;
import com.salesforce.android.knowledge.ui.KnowledgeJsProvider;
import com.salesforce.android.knowledge.ui.KnowledgeUIAnalyticsEmit;
import com.salesforce.android.knowledge.ui.KnowledgeUIClient;
import com.salesforce.android.knowledge.ui.KnowledgeUIConfiguration;
import com.salesforce.android.knowledge.ui.KnowledgeViewAddition;
import com.salesforce.android.knowledge.ui.internal.CssProviderWrapper;
import com.salesforce.android.knowledge.ui.internal.ImageProviderWrapper;
import com.salesforce.android.knowledge.ui.internal.JsProviderWrapper;
import com.salesforce.android.knowledge.ui.internal.activity.FragmentLoader;
import com.salesforce.android.knowledge.ui.internal.activity.KnowledgeActivity;
import com.salesforce.android.knowledge.ui.internal.logging.LiveAgentKnowledgeLogger;
import com.salesforce.android.knowledge.ui.internal.minimize.MinimizeControl;
import com.salesforce.android.knowledge.ui.internal.navigation.Navigator;
import com.salesforce.android.knowledge.ui.internal.presenter.PresenterFactory;
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

public class KnowledgeUIClientImpl
   implements LogoutListener,
   KnowledgeUIClient,
   ActivityTracker.OnCreateListener,
   ActivityTracker.OnDestroyListener,
   ActivityTracker.OnStartListener {
   private static final ServiceLogger n = ServiceLogging.a(KnowledgeUIClientImpl.class);
   ActivityReference<KnowledgeActivity> a;
   private final KnowledgeUIConfiguration b;
   private final KnowledgeClient c;
   private final KnowledgeImageProvider d;
   private final KnowledgeCssProvider e;
   private final KnowledgeJsProvider f;
   private final PresenterFactory g;
   private final FragmentLoader h;
   private final Navigator i;
   private final MinimizeControl j;
   private final ActivityTracker k;
   private final LiveAgentKnowledgeLogger l;
   private final Set<ViewAdditionController> m = new HashSet<>();
   private final Set<KnowledgeUIClient.OnCloseListener> o = Collections.newSetFromMap(new ConcurrentHashMap<>());

   private KnowledgeUIClientImpl(KnowledgeUIConfiguration var1, KnowledgeClient var2, Set<KnowledgeViewAddition> var3, ModuleProvider var4) {
      this.a = ActivityReference.a();
      this.b = var1;
      this.c = var2;

      for (KnowledgeViewAddition var5 : var3) {
         this.m.add(new ViewAdditionController(var5));
      }

      this.k = var4.a().a(this).a(this).a(this);
      this.h = var4.b();
      this.j = var4.b(this);
      this.g = var4.a(this);
      this.l = var4.c(this);
      HashSet var6 = new HashSet();
      var6.addAll(this.m);
      var6.add(this.h);
      this.i = var4.a(this, var6.toArray(new Navigator.Listener[var6.size()]));
      this.d = ImageProviderWrapper.a(this.b.c());
      this.e = CssProviderWrapper.a(this.b.d());
      this.f = JsProviderWrapper.a(this.b.e());
   }

   public static KnowledgeUIClientImpl a(KnowledgeUIConfiguration var0, KnowledgeClient var1, Set<KnowledgeViewAddition> var2) {
      return new KnowledgeUIClientImpl(var0, var1, var2, new RuntimeModuleProvider());
   }

   @Override
   public void a() {
      n.c("Terminating KB UI due to Auth user logout.");
      this.n();
   }

   @Override
   public void a(Activity var1) {
      if (var1 instanceof KnowledgeActivity) {
         KnowledgeActivity var2 = (KnowledgeActivity)var1;
         Iterator var3 = this.m.iterator();

         while (var3.hasNext()) {
            ((ViewAdditionController)var3.next()).a(var2, this.i.e());
         }

         this.i.a(var1, this.b.b());
         this.h.a(var2);
      }
   }

   public void a(Context var1) {
      KnowledgeActivity.a(var1);
   }

   @Override
   public void a(KnowledgeUIClient.OnCloseListener var1) {
      this.o.add(var1);
   }

   @Override
   public void b() {
      this.n();
   }

   @Override
   public void b(Activity var1) {
      if (!this.a.b()) {
         if (this.j.a()) {
            this.j.a(var1);
         } else {
            this.k.a(var1);
            this.k.a(var1.getApplicationContext());
            this.l.a(var1.getApplicationContext());
            this.a(var1);
         }
      }
   }

   public boolean b(Context var1) {
      NetworkInfo var3 = ((ConnectivityManager)var1.getSystemService("connectivity")).getActiveNetworkInfo();
      boolean var2;
      if (var3 != null && var3.isConnected()) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   @Override
   public KnowledgeClient c() {
      return this.c;
   }

   @Override
   public void c(Activity var1) {
      if (var1 instanceof KnowledgeActivity) {
         var1 = var1;
         var1.a(this);
         this.a = ActivityReference.a(var1);
      }
   }

   @Override
   public KnowledgeCssProvider d() {
      return this.e;
   }

   @Override
   public void d(Activity var1) {
      if (var1 instanceof KnowledgeActivity) {
         this.a.b((KnowledgeActivity)var1);
      }
   }

   @Override
   public KnowledgeJsProvider e() {
      return this.f;
   }

   public KnowledgeUIConfiguration f() {
      return this.b;
   }

   public KnowledgeImageProvider g() {
      return this.d;
   }

   public PresenterFactory h() {
      return this.g;
   }

   public Navigator i() {
      return this.i;
   }

   public MinimizeControl j() {
      return this.j;
   }

   public ActivityTracker k() {
      return this.k;
   }

   public void l() {
      this.a.a(new Consumer<AppCompatActivity>(this) {
         final KnowledgeUIClientImpl a;

         {
            this.a = var1;
         }

         public void a(AppCompatActivity var1) {
            var1.finish();
         }
      });
   }

   public void m() {
      this.i.d();
      if (this.i.c()) {
         this.n();
      }
   }

   public void n() {
      KnowledgeUIAnalyticsEmit.i();
      this.j.b();
      this.i.f();
      this.l();
      Iterator var1 = this.o.iterator();

      while (var1.hasNext()) {
         ((KnowledgeUIClient.OnCloseListener)var1.next()).a();
      }

      this.l.a();
      this.k.b(this).b(this).b(this).a();
      KnowledgeUIAnalyticsEmit.a();
      this.c.c();
   }
}
