package android.arch.lifecycle;

public class SingleGeneratedAdapterObserver implements GenericLifecycleObserver {
   private final GeneratedAdapter a;

   SingleGeneratedAdapterObserver(GeneratedAdapter var1) {
      this.a = var1;
   }

   @Override
   public void a(LifecycleOwner var1, Lifecycle.Event var2) {
      this.a.a(var1, var2, false, null);
      this.a.a(var1, var2, true, null);
   }
}
