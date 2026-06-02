package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import okio.BufferedSource;

public interface PushObserver {
   PushObserver a = new PushObserver() {
      @Override
      public void a(int var1, ErrorCode var2) {
      }

      @Override
      public boolean a(int var1, List<Header> var2) {
         return true;
      }

      @Override
      public boolean a(int var1, List<Header> var2, boolean var3) {
         return true;
      }

      @Override
      public boolean a(int var1, BufferedSource var2, int var3, boolean var4) throws IOException {
         var2.i(var3);
         return true;
      }
   };

   void a(int var1, ErrorCode var2);

   boolean a(int var1, List<Header> var2);

   boolean a(int var1, List<Header> var2, boolean var3);

   boolean a(int var1, BufferedSource var2, int var3, boolean var4) throws IOException;
}
