package io.fabric.sdk.android;

public interface InitializationCallback<T> {
   InitializationCallback d = new InitializationCallback.Empty();

   void a(Exception var1);

   void a(T var1);

   class Empty implements InitializationCallback<Object> {
      private Empty() {
      }

      @Override
      public void a(Exception var1) {
      }

      @Override
      public void a(Object var1) {
      }
   }
}
