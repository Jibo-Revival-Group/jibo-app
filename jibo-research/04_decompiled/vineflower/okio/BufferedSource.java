package okio;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public interface BufferedSource extends Source {
   long a(byte var1) throws IOException;

   long a(Sink var1) throws IOException;

   String a(Charset var1) throws IOException;

   void a(long var1) throws IOException;

   void a(byte[] var1) throws IOException;

   boolean a(long var1, ByteString var3) throws IOException;

   boolean b(long var1) throws IOException;

   Buffer c();

   ByteString d(long var1) throws IOException;

   boolean f() throws IOException;

   InputStream g();

   byte[] h(long var1) throws IOException;

   byte i() throws IOException;

   void i(long var1) throws IOException;

   short j() throws IOException;

   int k() throws IOException;

   short l() throws IOException;

   int m() throws IOException;

   long n() throws IOException;

   long o() throws IOException;

   ByteString p() throws IOException;

   String r() throws IOException;

   byte[] t() throws IOException;
}
