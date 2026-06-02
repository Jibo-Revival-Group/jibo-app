package com.jibo.ui.fragment.wifi;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class NetworkSelectionFragment_ViewBinding extends WiFiBaseFragment_ViewBinding {
   private NetworkSelectionFragment b;
   private View c;
   private View d;
   private View e;
   private View f;
   private View g;

   public NetworkSelectionFragment_ViewBinding(NetworkSelectionFragment var1, View var2) {
      super(var1, var2);
      this.b = var1;
      var1.cntNoNetwork = Utils.b(var2, 2131296460, "field 'cntNoNetwork'", ViewGroup.class);
      var1.cntNetworkOn = Utils.b(var2, 2131296459, "field 'cntNetworkOn'", ViewGroup.class);
      var1.textStep2Message = Utils.b(var2, 2131296989, "field 'textStep2Message'", TextView.class);
      View var3 = Utils.a(var2, 2131296394, "field 'btnSelectCurrentNetwork' and method 'onSelectCurrentNetwork'");
      var1.btnSelectCurrentNetwork = Utils.c(var3, 2131296394, "field 'btnSelectCurrentNetwork'", TextView.class);
      this.c = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final NetworkSelectionFragment b;
         final NetworkSelectionFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.onSelectCurrentNetwork(var1);
         }
      });
      var3 = Utils.a(var2, 2131296358, "method 'onEnterNetworkManually'");
      this.d = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final NetworkSelectionFragment b;
         final NetworkSelectionFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.onEnterNetworkManually(var1);
         }
      });
      var3 = Utils.a(var2, 2131296395, "method 'onSelectOtherNetwork'");
      this.e = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final NetworkSelectionFragment b;
         final NetworkSelectionFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.onSelectOtherNetwork(var1);
         }
      });
      var3 = Utils.a(var2, 2131296412, "method 'onSelectOtherNetwork'");
      this.f = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final NetworkSelectionFragment b;
         final NetworkSelectionFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.onSelectOtherNetwork(var1);
         }
      });
      var2 = Utils.a(var2, 2131296375, "method 'onShowMacFilteringInfo'");
      this.g = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final NetworkSelectionFragment b;
         final NetworkSelectionFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.onShowMacFilteringInfo(var1);
         }
      });
   }

   @Override
   public void unbind() {
      NetworkSelectionFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.cntNoNetwork = null;
      var1.cntNetworkOn = null;
      var1.textStep2Message = null;
      var1.btnSelectCurrentNetwork = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
      this.e.setOnClickListener(null);
      this.e = null;
      this.f.setOnClickListener(null);
      this.f = null;
      this.g.setOnClickListener(null);
      this.g = null;
      super.unbind();
   }
}
