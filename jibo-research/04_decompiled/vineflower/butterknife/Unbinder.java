package butterknife;

public interface Unbinder {
   Unbinder a = new Unbinder() {
      @Override
      public void unbind() {
      }
   };

   void unbind();
}
