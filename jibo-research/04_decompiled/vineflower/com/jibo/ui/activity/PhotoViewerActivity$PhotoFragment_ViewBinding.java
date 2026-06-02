package com.jibo.ui.activity;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.ui.view.TouchImageView;

public class PhotoViewerActivity$PhotoFragment_ViewBinding implements Unbinder {
   private PhotoViewerActivity.PhotoFragment b;
   private View c;

   public PhotoViewerActivity$PhotoFragment_ViewBinding(PhotoViewerActivity.PhotoFragment var1, View var2) {
      this.b = var1;
      var1.image = Utils.b(var2, 2131296596, "field 'image'", TouchImageView.class);
      var2 = Utils.a(var2, 16908301, "field 'progress' and method 'onContentClick'");
      var1.progress = var2;
      this.c = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final PhotoViewerActivity.PhotoFragment b;
         final PhotoViewerActivity$PhotoFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.onContentClick(var1);
         }
      });
   }

   @Override
   public void unbind() {
      PhotoViewerActivity.PhotoFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.image = null;
      var1.progress = null;
      this.c.setOnClickListener(null);
      this.c = null;
   }
}
