package android.arch.lifecycle;

class FullLifecycleObserverAdapter implements GenericLifecycleObserver {
   private final FullLifecycleObserver a;

   FullLifecycleObserverAdapter(FullLifecycleObserver var1) {
      this.a = var1;
   }

   @Override
   public void a(LifecycleOwner var1, Lifecycle.Event var2) {
      switch (<unrepresentable>.a[var2.ordinal()]) {
         case 1:
            this.a.a(var1);
            break;
         case 2:
            this.a.b(var1);
            break;
         case 3:
            this.a.c(var1);
            break;
         case 4:
            this.a.d(var1);
            break;
         case 5:
            this.a.e(var1);
            break;
         case 6:
            this.a.f(var1);
            break;
         case 7:
            throw new IllegalArgumentException("ON_ANY must not been send by anybody");
      }
   }
}
