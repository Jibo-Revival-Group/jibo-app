package android.arch.lifecycle;

public class CompositeGeneratedAdaptersObserver implements GenericLifecycleObserver {
   private final GeneratedAdapter[] a;

   CompositeGeneratedAdaptersObserver(GeneratedAdapter[] var1) {
      this.a = var1;
   }

   @Override
   public void a(LifecycleOwner var1, Lifecycle.Event var2) {
      byte var4 = 0;
      MethodCallsLogger var6 = new MethodCallsLogger();
      GeneratedAdapter[] var7 = this.a;
      int var5 = var7.length;

      for (int var3 = 0; var3 < var5; var3++) {
         var7[var3].a(var1, var2, false, var6);
      }

      var7 = this.a;
      var5 = var7.length;

      for (int var8 = var4; var8 < var5; var8++) {
         var7[var8].a(var1, var2, true, var6);
      }
   }
}
