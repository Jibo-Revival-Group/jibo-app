package com.bumptech.glide.manager;

class ApplicationLifecycle implements Lifecycle {
   @Override
   public void a(LifecycleListener var1) {
      var1.onStart();
   }
}
