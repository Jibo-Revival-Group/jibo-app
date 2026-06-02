package com.google.api.client.testing.http.javanet;

import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Beta
public class MockHttpURLConnection extends HttpURLConnection {
   @Deprecated
   public static final byte[] ERROR_BUF = new byte[5];
   @Deprecated
   public static final byte[] INPUT_BUF = new byte[1];
   private boolean doOutputCalled;
   private InputStream errorStream;
   private Map<String, List<String>> headers;
   private InputStream inputStream;
   private OutputStream outputStream = new ByteArrayOutputStream(0);

   public MockHttpURLConnection(URL var1) {
      super(var1);
      this.inputStream = null;
      this.errorStream = null;
      this.headers = new LinkedHashMap<>();
   }

   public MockHttpURLConnection addHeader(String var1, String var2) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
      if (this.headers.containsKey(var1)) {
         this.headers.get(var1).add(var2);
      } else {
         ArrayList var3 = new ArrayList();
         var3.add(var2);
         this.headers.put(var1, var3);
      }

      return this;
   }

   @Override
   public void connect() throws IOException {
   }

   @Override
   public void disconnect() {
   }

   public final boolean doOutputCalled() {
      return this.doOutputCalled;
   }

   @Override
   public InputStream getErrorStream() {
      return this.errorStream;
   }

   @Override
   public String getHeaderField(String var1) {
      List var2 = this.headers.get(var1);
      if (var2 == null) {
         var1 = null;
      } else {
         var1 = (String)var2.get(0);
      }

      return var1;
   }

   @Override
   public Map<String, List<String>> getHeaderFields() {
      return this.headers;
   }

   @Override
   public InputStream getInputStream() throws IOException {
      if (this.responseCode < 400) {
         return this.inputStream;
      } else {
         throw new IOException();
      }
   }

   @Override
   public OutputStream getOutputStream() throws IOException {
      OutputStream var1;
      if (this.outputStream != null) {
         var1 = this.outputStream;
      } else {
         var1 = super.getOutputStream();
      }

      return var1;
   }

   @Override
   public int getResponseCode() throws IOException {
      return this.responseCode;
   }

   @Override
   public void setDoOutput(boolean var1) {
      this.doOutputCalled = true;
   }

   public MockHttpURLConnection setErrorStream(InputStream var1) {
      Preconditions.checkNotNull(var1);
      if (this.errorStream == null) {
         this.errorStream = var1;
      }

      return this;
   }

   public MockHttpURLConnection setInputStream(InputStream var1) {
      Preconditions.checkNotNull(var1);
      if (this.inputStream == null) {
         this.inputStream = var1;
      }

      return this;
   }

   public MockHttpURLConnection setOutputStream(OutputStream var1) {
      this.outputStream = var1;
      return this;
   }

   public MockHttpURLConnection setResponseCode(int var1) {
      boolean var2;
      if (var1 >= -1) {
         var2 = true;
      } else {
         var2 = false;
      }

      Preconditions.checkArgument(var2);
      this.responseCode = var1;
      return this;
   }

   @Override
   public boolean usingProxy() {
      return false;
   }
}
