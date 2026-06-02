package okhttp3;

abstract class EventListener {
   public static final EventListener a = new EventListener() {};

   static EventListener.Factory a(EventListener var0) {
      return new EventListener.Factory(var0) {
         final EventListener a;

         {
            this.a = var1;
         }

         @Override
         public EventListener a(Call var1) {
            return this.a;
         }
      };
   }

   public interface Factory {
      EventListener a(Call var1);
   }
}
