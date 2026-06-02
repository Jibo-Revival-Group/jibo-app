package okhttp3.internal;

public abstract class NamedRunnable implements Runnable {
   protected final String b;

   public NamedRunnable(String var1, Object... var2) {
      this.b = Util.a(var1, var2);
   }

   protected abstract void c();

   @Override
   public final void run() {
      String var1 = Thread.currentThread().getName();
      Thread.currentThread().setName(this.b);

      try {
         this.c();
      } finally {
         Thread.currentThread().setName(var1);
      }
   }
}
