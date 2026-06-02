package android.arch.lifecycle;

class ReflectiveGenericLifecycleObserver implements GenericLifecycleObserver {
   private final Object a;
   private final ClassesInfoCache.CallbackInfo b;

   ReflectiveGenericLifecycleObserver(Object var1) {
      this.a = var1;
      this.b = ClassesInfoCache.a.b(this.a.getClass());
   }

   @Override
   public void a(LifecycleOwner var1, Lifecycle.Event var2) {
      this.b.a(var1, var2, this.a);
   }
}
