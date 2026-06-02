package android.support.v7.view.menu;

class BaseWrapper<T> {
   final T b;

   BaseWrapper(T var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("Wrapped Object can not be null.");
      }

      this.b = (T)var1;
   }
}
