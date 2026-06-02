package okio;

import java.io.Closeable;
import java.io.IOException;

public interface Source extends Closeable {
   long a(Buffer var1, long var2) throws IOException;

   Timeout a();

   @Override
   void close() throws IOException;
}
