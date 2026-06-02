package okio;

import java.io.IOException;

public interface BufferedSink extends Sink {
   BufferedSink b(String var1) throws IOException;

   BufferedSink b(ByteString var1) throws IOException;

   Buffer c();

   BufferedSink c(byte[] var1) throws IOException;

   BufferedSink c(byte[] var1, int var2, int var3) throws IOException;

   @Override
   void flush() throws IOException;

   BufferedSink h(int var1) throws IOException;

   BufferedSink i(int var1) throws IOException;

   BufferedSink j(int var1) throws IOException;

   BufferedSink k(int var1) throws IOException;

   BufferedSink l(long var1) throws IOException;

   BufferedSink m(long var1) throws IOException;

   BufferedSink x() throws IOException;
}
