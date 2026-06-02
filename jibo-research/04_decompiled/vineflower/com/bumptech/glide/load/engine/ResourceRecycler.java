package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Handler.Callback;
import com.bumptech.glide.util.Util;

class ResourceRecycler {
   private final Handler handler = new Handler(Looper.getMainLooper(), new ResourceRecycler.ResourceRecyclerCallback());
   private boolean isRecycling;

   public void recycle(Resource<?> var1) {
      Util.a();
      if (this.isRecycling) {
         this.handler.obtainMessage(1, var1).sendToTarget();
      } else {
         this.isRecycling = true;
         var1.recycle();
         this.isRecycling = false;
      }
   }

   private static class ResourceRecyclerCallback implements Callback {
      private ResourceRecyclerCallback() {
      }

      public boolean handleMessage(Message var1) {
         boolean var2;
         if (var1.what == 1) {
            ((Resource)var1.obj).recycle();
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }
   }
}
