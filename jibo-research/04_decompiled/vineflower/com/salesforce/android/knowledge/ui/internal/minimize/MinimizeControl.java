package com.salesforce.android.knowledge.ui.internal.minimize;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.salesforce.android.knowledge.ui.KnowledgeUIAnalyticsEmit;
import com.salesforce.android.knowledge.ui.R;
import com.salesforce.android.knowledge.ui.internal.client.KnowledgeUIClientImpl;
import com.salesforce.android.service.common.ui.internal.minimize.MinimizeListener;
import com.salesforce.android.service.common.ui.internal.minimize.Minimizer;
import com.salesforce.android.service.common.utilities.spatial.Coordinate;

public class MinimizeControl implements MinimizeListener {
   static final boolean a;
   private final KnowledgeUIClientImpl b;
   private final Minimizer c;
   private MinimizeContext d;

   static {
      boolean var0;
      if (!MinimizeControl.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      a = var0;
   }

   public MinimizeControl(KnowledgeUIClientImpl var1) {
      this.b = var1;
      this.c = new Minimizer.Builder().a(this).a(var1.k()).a();
   }

   public void a(Context var1) {
      this.c.a(var1);
   }

   @Override
   public void a(ViewGroup var1, Context var2) {
      if (!a && this.d == null) {
         throw new AssertionError();
      }

      View var6 = LayoutInflater.from(var2).inflate(R.layout.knowledge_minimized_view_content, var1);
      ImageView var4 = (ImageView)var6.findViewById(R.id.knowledge_minview_image);
      Drawable var5 = this.d.a();
      var4.setImageDrawable(var5);
      byte var3;
      if (var5 == null) {
         var3 = 8;
      } else {
         var3 = 0;
      }

      var4.setVisibility(var3);
      ((TextView)var6.findViewById(R.id.knowledge_minview_label)).setText(this.d.b());
   }

   public void a(MinimizeContext var1) {
      if (!this.a()) {
         this.d = var1;
         KnowledgeUIAnalyticsEmit.i(var1.c(), var1.b());
         this.c.b();
      }
   }

   @Override
   public void a(Coordinate var1) {
      KnowledgeUIAnalyticsEmit.k();
   }

   public boolean a() {
      return this.c.a();
   }

   public void b() {
      this.c.d();
   }

   @Override
   public void b(Context var1) {
      if (!a && this.d == null) {
         throw new AssertionError();
      }

      KnowledgeUIAnalyticsEmit.h(this.d.c(), this.d.b());
      this.b.a(var1);
      this.c.c();
      KnowledgeUIAnalyticsEmit.f();
      this.d = null;
   }

   @Override
   public void c() {
      this.b.l();
      KnowledgeUIAnalyticsEmit.g();
   }

   @Override
   public void d() {
      this.b.n();
   }
}
