package bolts;

public class TaskCompletionSource<TResult> {
   private final Task<TResult> a = new Task<>();

   public Task<TResult> a() {
      return this.a;
   }

   public boolean a(Exception var1) {
      return this.a.b(var1);
   }

   public boolean a(TResult var1) {
      return this.a.b((TResult)var1);
   }

   public void b(Exception var1) {
      if (!this.a(var1)) {
         throw new IllegalStateException("Cannot set the error on a completed task.");
      }
   }

   public void b(TResult var1) {
      if (!this.a((TResult)var1)) {
         throw new IllegalStateException("Cannot set the result of a completed task.");
      }
   }

   public boolean b() {
      return this.a.i();
   }

   public void c() {
      if (!this.b()) {
         throw new IllegalStateException("Cannot cancel a completed task.");
      }
   }
}
