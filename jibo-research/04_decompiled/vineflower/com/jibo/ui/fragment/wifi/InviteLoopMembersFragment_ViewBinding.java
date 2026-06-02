package com.jibo.ui.fragment.wifi;

import android.view.View;
import android.widget.ImageView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.ui.view.proxima.CustomFontButton;

public class InviteLoopMembersFragment_ViewBinding extends WiFiBaseFragment_ViewBinding {
   private InviteLoopMembersFragment b;
   private View c;
   private View d;

   public InviteLoopMembersFragment_ViewBinding(InviteLoopMembersFragment var1, View var2) {
      super(var1, var2);
      this.b = var1;
      View var3 = Utils.a(var2, 16908327, "field 'closeButton' and method 'onCloseClick'");
      var1.closeButton = Utils.c(var3, 16908327, "field 'closeButton'", ImageView.class);
      this.c = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final InviteLoopMembersFragment b;
         final InviteLoopMembersFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.onCloseClick(var1);
         }
      });
      var2 = Utils.a(var2, 2131296366, "field 'btnInvitePeople' and method 'btnInvitePeople'");
      var1.btnInvitePeople = Utils.c(var2, 2131296366, "field 'btnInvitePeople'", CustomFontButton.class);
      this.d = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final InviteLoopMembersFragment b;
         final InviteLoopMembersFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.btnInvitePeople(var1);
         }
      });
   }

   @Override
   public void unbind() {
      InviteLoopMembersFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.closeButton = null;
      var1.btnInvitePeople = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
      super.unbind();
   }
}
