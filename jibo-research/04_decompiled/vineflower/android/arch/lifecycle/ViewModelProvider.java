package android.arch.lifecycle;

public class ViewModelProvider {
   private final ViewModelProvider.Factory a;
   private final ViewModelStore b;

   public ViewModelProvider(ViewModelStore var1, ViewModelProvider.Factory var2) {
      this.a = var2;
      this.b = var1;
   }

   public <T extends ViewModel> T a(Class<T> var1) {
      String var2 = var1.getCanonicalName();
      if (var2 == null) {
         throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
      } else {
         return this.a("android.arch.lifecycle.ViewModelProvider.DefaultKey:" + var2, var1);
      }
   }

   public <T extends ViewModel> T a(String var1, Class<T> var2) {
      ViewModel var3 = this.b.a(var1);
      ViewModel var4;
      if (var2.isInstance(var3)) {
         var4 = var3;
      } else {
         if (var3 != null) {
         }

         ViewModel var5 = this.a.a(var2);
         this.b.a(var1, var5);
         var4 = var5;
      }

      return (T)var4;
   }

   public interface Factory {
      <T extends ViewModel> T a(Class<T> var1);
   }
}
