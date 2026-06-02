package com.jibo.ui.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class LoopInviteDetailsActivity_ViewBinding extends BaseActivity_ViewBinding {
   private LoopInviteDetailsActivity b;
   private View c;
   private View d;

   public LoopInviteDetailsActivity_ViewBinding(LoopInviteDetailsActivity var1) {
      this(var1, var1.getWindow().getDecorView());
   }

   public LoopInviteDetailsActivity_ViewBinding(LoopInviteDetailsActivity var1, View var2) {
      super(var1, var2);
      this.b = var1;
      View var3 = Utils.a(var2, 2131296418, "field 'buttonAccept' and method 'onJoinClick'");
      var1.buttonAccept = var3;
      this.c = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final LoopInviteDetailsActivity b;
         final LoopInviteDetailsActivity_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.onJoinClick(var1);
         }
      });
      var3 = Utils.a(var2, 2131296420, "field 'buttonDecline' and method 'onDeclineClick'");
      var1.buttonDecline = var3;
      this.d = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final LoopInviteDetailsActivity b;
         final LoopInviteDetailsActivity_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.onDeclineClick(var1);
         }
      });
      var1.recyclerView = Utils.b(var2, 2131296825, "field 'recyclerView'", RecyclerView.class);
   }

   @Override
   public void unbind() {
      LoopInviteDetailsActivity var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.buttonAccept = null;
      var1.buttonDecline = null;
      var1.recyclerView = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
      super.unbind();
   }
}
