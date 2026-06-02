package android.arch.lifecycle;

public abstract class Lifecycle {
   public abstract Lifecycle.State a();

   public abstract void a(LifecycleObserver var1);

   public abstract void b(LifecycleObserver var1);

   public enum Event {
      ON_ANY,
      ON_CREATE,
      ON_DESTROY,
      ON_PAUSE,
      ON_RESUME,
      ON_START,
      ON_STOP;

      private static final Lifecycle.Event[] $VALUES = new Lifecycle.Event[]{
         Lifecycle.Event.ON_CREATE,
         Lifecycle.Event.ON_START,
         Lifecycle.Event.ON_RESUME,
         Lifecycle.Event.ON_PAUSE,
         Lifecycle.Event.ON_STOP,
         Lifecycle.Event.ON_DESTROY,
         Lifecycle.Event.ON_ANY
      };
   }

   public enum State {
      CREATED,
      DESTROYED,
      INITIALIZED,
      RESUMED,
      STARTED;

      private static final Lifecycle.State[] $VALUES = new Lifecycle.State[]{
         Lifecycle.State.DESTROYED, Lifecycle.State.INITIALIZED, Lifecycle.State.CREATED, Lifecycle.State.STARTED, Lifecycle.State.RESUMED
      };

      public boolean isAtLeast(Lifecycle.State var1) {
         boolean var2;
         if (this.compareTo(var1) >= 0) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }
   }
}
