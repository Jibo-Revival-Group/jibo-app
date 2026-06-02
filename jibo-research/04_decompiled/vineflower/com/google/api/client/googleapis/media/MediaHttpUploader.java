package com.google.api.client.googleapis.media;

import com.google.api.client.googleapis.MethodOverride;
import com.google.api.client.http.AbstractInputStreamContent;
import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.EmptyContent;
import com.google.api.client.http.GZipEncoding;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.InputStreamContent;
import com.google.api.client.http.MultipartContent;
import com.google.api.client.util.Beta;
import com.google.api.client.util.ByteStreams;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sleeper;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public final class MediaHttpUploader {
   public static final String CONTENT_LENGTH_HEADER = "X-Upload-Content-Length";
   public static final String CONTENT_TYPE_HEADER = "X-Upload-Content-Type";
   public static final int DEFAULT_CHUNK_SIZE = 10485760;
   private static final int KB = 1024;
   static final int MB = 1048576;
   public static final int MINIMUM_CHUNK_SIZE = 262144;
   private Byte cachedByte;
   private int chunkSize;
   private InputStream contentInputStream;
   private int currentChunkLength;
   private HttpRequest currentRequest;
   private byte[] currentRequestContentBuffer;
   private boolean directUploadEnabled;
   private boolean disableGZipContent;
   private HttpHeaders initiationHeaders;
   private String initiationRequestMethod;
   private boolean isMediaContentLengthCalculated;
   private final AbstractInputStreamContent mediaContent;
   private long mediaContentLength;
   String mediaContentLengthStr;
   private HttpContent metadata;
   private MediaHttpUploaderProgressListener progressListener;
   private final HttpRequestFactory requestFactory;
   Sleeper sleeper;
   private long totalBytesClientSent;
   private long totalBytesServerReceived;
   private final HttpTransport transport;
   private MediaHttpUploader.UploadState uploadState = MediaHttpUploader.UploadState.NOT_STARTED;

   public MediaHttpUploader(AbstractInputStreamContent var1, HttpTransport var2, HttpRequestInitializer var3) {
      this.initiationRequestMethod = "POST";
      this.initiationHeaders = new HttpHeaders();
      this.mediaContentLengthStr = "*";
      this.chunkSize = 10485760;
      this.sleeper = Sleeper.DEFAULT;
      this.mediaContent = Preconditions.checkNotNull(var1);
      this.transport = Preconditions.checkNotNull(var2);
      HttpRequestFactory var4;
      if (var3 == null) {
         var4 = var2.createRequestFactory();
      } else {
         var4 = var2.createRequestFactory(var3);
      }

      this.requestFactory = var4;
   }

   private HttpResponse directUpload(GenericUrl var1) throws IOException {
      this.updateStateAndNotifyListener(MediaHttpUploader.UploadState.MEDIA_IN_PROGRESS);
      HttpContent var2 = this.mediaContent;
      if (this.metadata != null) {
         var2 = new MultipartContent().setContentParts(Arrays.asList(this.metadata, this.mediaContent));
         var1.put("uploadType", "multipart");
      } else {
         var1.put("uploadType", "media");
      }

      HttpRequest var5 = this.requestFactory.buildRequest(this.initiationRequestMethod, var1, var2);
      var5.getHeaders().putAll(this.initiationHeaders);
      HttpResponse var6 = this.executeCurrentRequest(var5);

      try {
         if (this.isMediaLengthKnown()) {
            this.totalBytesServerReceived = this.getMediaContentLength();
         }

         this.updateStateAndNotifyListener(MediaHttpUploader.UploadState.MEDIA_COMPLETE);
         return var6;
      } finally {
         var6.disconnect();
      }
   }

   private HttpResponse executeCurrentRequest(HttpRequest var1) throws IOException {
      if (!this.disableGZipContent && !(var1.getContent() instanceof EmptyContent)) {
         var1.setEncoding(new GZipEncoding());
      }

      return this.executeCurrentRequestWithoutGZip(var1);
   }

   private HttpResponse executeCurrentRequestWithoutGZip(HttpRequest var1) throws IOException {
      new MethodOverride().intercept(var1);
      var1.setThrowExceptionOnExecuteError(false);
      return var1.execute();
   }

   private HttpResponse executeUploadInitiation(GenericUrl var1) throws IOException {
      this.updateStateAndNotifyListener(MediaHttpUploader.UploadState.INITIATION_STARTED);
      var1.put("uploadType", "resumable");
      HttpContent var2;
      if (this.metadata == null) {
         var2 = new EmptyContent();
      } else {
         var2 = this.metadata;
      }

      HttpRequest var5 = this.requestFactory.buildRequest(this.initiationRequestMethod, var1, var2);
      this.initiationHeaders.set("X-Upload-Content-Type", this.mediaContent.getType());
      if (this.isMediaLengthKnown()) {
         this.initiationHeaders.set("X-Upload-Content-Length", this.getMediaContentLength());
      }

      var5.getHeaders().putAll(this.initiationHeaders);
      HttpResponse var6 = this.executeCurrentRequest(var5);

      try {
         this.updateStateAndNotifyListener(MediaHttpUploader.UploadState.INITIATION_COMPLETE);
         return var6;
      } finally {
         var6.disconnect();
      }
   }

   private long getMediaContentLength() throws IOException {
      if (!this.isMediaContentLengthCalculated) {
         this.mediaContentLength = this.mediaContent.getLength();
         this.isMediaContentLengthCalculated = true;
      }

      return this.mediaContentLength;
   }

   private long getNextByteIndex(String var1) {
      long var2;
      if (var1 == null) {
         var2 = 0L;
      } else {
         var2 = Long.parseLong(var1.substring(var1.indexOf(45) + 1)) + 1L;
      }

      return var2;
   }

   private boolean isMediaLengthKnown() throws IOException {
      boolean var1;
      if (this.getMediaContentLength() >= 0L) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private HttpResponse resumableUpload(GenericUrl param1) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.insertSemaphore(FinallyProcessor.java:351)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:98)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 000: aload 0
      // 001: aload 1
      // 002: invokespecial com/google/api/client/googleapis/media/MediaHttpUploader.executeUploadInitiation (Lcom/google/api/client/http/GenericUrl;)Lcom/google/api/client/http/HttpResponse;
      // 005: astore 10
      // 007: aload 10
      // 009: invokevirtual com/google/api/client/http/HttpResponse.isSuccessStatusCode ()Z
      // 00c: ifne 012
      // 00f: aload 10
      // 011: areturn
      // 012: new com/google/api/client/http/GenericUrl
      // 015: dup
      // 016: aload 10
      // 018: invokevirtual com/google/api/client/http/HttpResponse.getHeaders ()Lcom/google/api/client/http/HttpHeaders;
      // 01b: invokevirtual com/google/api/client/http/HttpHeaders.getLocation ()Ljava/lang/String;
      // 01e: invokespecial com/google/api/client/http/GenericUrl.<init> (Ljava/lang/String;)V
      // 021: astore 1
      // 022: aload 10
      // 024: invokevirtual com/google/api/client/http/HttpResponse.disconnect ()V
      // 027: aload 0
      // 028: aload 0
      // 029: getfield com/google/api/client/googleapis/media/MediaHttpUploader.mediaContent Lcom/google/api/client/http/AbstractInputStreamContent;
      // 02c: invokevirtual com/google/api/client/http/AbstractInputStreamContent.getInputStream ()Ljava/io/InputStream;
      // 02f: putfield com/google/api/client/googleapis/media/MediaHttpUploader.contentInputStream Ljava/io/InputStream;
      // 032: aload 1
      // 033: astore 9
      // 035: aload 0
      // 036: getfield com/google/api/client/googleapis/media/MediaHttpUploader.contentInputStream Ljava/io/InputStream;
      // 039: invokevirtual java/io/InputStream.markSupported ()Z
      // 03c: ifne 05b
      // 03f: aload 1
      // 040: astore 9
      // 042: aload 0
      // 043: invokespecial com/google/api/client/googleapis/media/MediaHttpUploader.isMediaLengthKnown ()Z
      // 046: ifeq 05b
      // 049: aload 0
      // 04a: new java/io/BufferedInputStream
      // 04d: dup
      // 04e: aload 0
      // 04f: getfield com/google/api/client/googleapis/media/MediaHttpUploader.contentInputStream Ljava/io/InputStream;
      // 052: invokespecial java/io/BufferedInputStream.<init> (Ljava/io/InputStream;)V
      // 055: putfield com/google/api/client/googleapis/media/MediaHttpUploader.contentInputStream Ljava/io/InputStream;
      // 058: aload 1
      // 059: astore 9
      // 05b: aload 0
      // 05c: aload 0
      // 05d: getfield com/google/api/client/googleapis/media/MediaHttpUploader.requestFactory Lcom/google/api/client/http/HttpRequestFactory;
      // 060: aload 9
      // 062: aconst_null
      // 063: invokevirtual com/google/api/client/http/HttpRequestFactory.buildPutRequest (Lcom/google/api/client/http/GenericUrl;Lcom/google/api/client/http/HttpContent;)Lcom/google/api/client/http/HttpRequest;
      // 066: putfield com/google/api/client/googleapis/media/MediaHttpUploader.currentRequest Lcom/google/api/client/http/HttpRequest;
      // 069: aload 0
      // 06a: invokespecial com/google/api/client/googleapis/media/MediaHttpUploader.setContentAndHeadersOnCurrentRequest ()V
      // 06d: new com/google/api/client/googleapis/media/MediaUploadErrorHandler
      // 070: dup
      // 071: aload 0
      // 072: aload 0
      // 073: getfield com/google/api/client/googleapis/media/MediaHttpUploader.currentRequest Lcom/google/api/client/http/HttpRequest;
      // 076: invokespecial com/google/api/client/googleapis/media/MediaUploadErrorHandler.<init> (Lcom/google/api/client/googleapis/media/MediaHttpUploader;Lcom/google/api/client/http/HttpRequest;)V
      // 079: pop
      // 07a: aload 0
      // 07b: invokespecial com/google/api/client/googleapis/media/MediaHttpUploader.isMediaLengthKnown ()Z
      // 07e: ifeq 0c8
      // 081: aload 0
      // 082: aload 0
      // 083: getfield com/google/api/client/googleapis/media/MediaHttpUploader.currentRequest Lcom/google/api/client/http/HttpRequest;
      // 086: invokespecial com/google/api/client/googleapis/media/MediaHttpUploader.executeCurrentRequestWithoutGZip (Lcom/google/api/client/http/HttpRequest;)Lcom/google/api/client/http/HttpResponse;
      // 089: astore 1
      // 08a: aload 1
      // 08b: invokevirtual com/google/api/client/http/HttpResponse.isSuccessStatusCode ()Z
      // 08e: ifeq 0d4
      // 091: aload 0
      // 092: aload 0
      // 093: invokespecial com/google/api/client/googleapis/media/MediaHttpUploader.getMediaContentLength ()J
      // 096: putfield com/google/api/client/googleapis/media/MediaHttpUploader.totalBytesServerReceived J
      // 099: aload 0
      // 09a: getfield com/google/api/client/googleapis/media/MediaHttpUploader.mediaContent Lcom/google/api/client/http/AbstractInputStreamContent;
      // 09d: invokevirtual com/google/api/client/http/AbstractInputStreamContent.getCloseInputStream ()Z
      // 0a0: ifeq 0aa
      // 0a3: aload 0
      // 0a4: getfield com/google/api/client/googleapis/media/MediaHttpUploader.contentInputStream Ljava/io/InputStream;
      // 0a7: invokevirtual java/io/InputStream.close ()V
      // 0aa: aload 0
      // 0ab: getstatic com/google/api/client/googleapis/media/MediaHttpUploader$UploadState.MEDIA_COMPLETE Lcom/google/api/client/googleapis/media/MediaHttpUploader$UploadState;
      // 0ae: invokespecial com/google/api/client/googleapis/media/MediaHttpUploader.updateStateAndNotifyListener (Lcom/google/api/client/googleapis/media/MediaHttpUploader$UploadState;)V
      // 0b1: aload 1
      // 0b2: astore 10
      // 0b4: goto 00f
      // 0b7: astore 9
      // 0b9: aload 1
      // 0ba: invokevirtual com/google/api/client/http/HttpResponse.disconnect ()V
      // 0bd: aload 9
      // 0bf: athrow
      // 0c0: astore 1
      // 0c1: aload 10
      // 0c3: invokevirtual com/google/api/client/http/HttpResponse.disconnect ()V
      // 0c6: aload 1
      // 0c7: athrow
      // 0c8: aload 0
      // 0c9: aload 0
      // 0ca: getfield com/google/api/client/googleapis/media/MediaHttpUploader.currentRequest Lcom/google/api/client/http/HttpRequest;
      // 0cd: invokespecial com/google/api/client/googleapis/media/MediaHttpUploader.executeCurrentRequest (Lcom/google/api/client/http/HttpRequest;)Lcom/google/api/client/http/HttpResponse;
      // 0d0: astore 1
      // 0d1: goto 08a
      // 0d4: aload 1
      // 0d5: astore 10
      // 0d7: aload 1
      // 0d8: invokevirtual com/google/api/client/http/HttpResponse.getStatusCode ()I
      // 0db: sipush 308
      // 0de: if_icmpne 00f
      // 0e1: aload 1
      // 0e2: invokevirtual com/google/api/client/http/HttpResponse.getHeaders ()Lcom/google/api/client/http/HttpHeaders;
      // 0e5: invokevirtual com/google/api/client/http/HttpHeaders.getLocation ()Ljava/lang/String;
      // 0e8: astore 10
      // 0ea: aload 10
      // 0ec: ifnull 0fb
      // 0ef: new com/google/api/client/http/GenericUrl
      // 0f2: astore 9
      // 0f4: aload 9
      // 0f6: aload 10
      // 0f8: invokespecial com/google/api/client/http/GenericUrl.<init> (Ljava/lang/String;)V
      // 0fb: aload 0
      // 0fc: aload 1
      // 0fd: invokevirtual com/google/api/client/http/HttpResponse.getHeaders ()Lcom/google/api/client/http/HttpHeaders;
      // 100: invokevirtual com/google/api/client/http/HttpHeaders.getRange ()Ljava/lang/String;
      // 103: invokespecial com/google/api/client/googleapis/media/MediaHttpUploader.getNextByteIndex (Ljava/lang/String;)J
      // 106: lstore 4
      // 108: lload 4
      // 10a: aload 0
      // 10b: getfield com/google/api/client/googleapis/media/MediaHttpUploader.totalBytesServerReceived J
      // 10e: lsub
      // 10f: lstore 6
      // 111: lload 6
      // 113: lconst_0
      // 114: lcmp
      // 115: iflt 173
      // 118: lload 6
      // 11a: aload 0
      // 11b: getfield com/google/api/client/googleapis/media/MediaHttpUploader.currentChunkLength I
      // 11e: i2l
      // 11f: lcmp
      // 120: ifgt 173
      // 123: bipush 1
      // 124: istore 8
      // 126: iload 8
      // 128: invokestatic com/google/api/client/util/Preconditions.checkState (Z)V
      // 12b: aload 0
      // 12c: getfield com/google/api/client/googleapis/media/MediaHttpUploader.currentChunkLength I
      // 12f: i2l
      // 130: lload 6
      // 132: lsub
      // 133: lstore 2
      // 134: aload 0
      // 135: invokespecial com/google/api/client/googleapis/media/MediaHttpUploader.isMediaLengthKnown ()Z
      // 138: ifeq 17f
      // 13b: lload 2
      // 13c: lconst_0
      // 13d: lcmp
      // 13e: ifle 15f
      // 141: aload 0
      // 142: getfield com/google/api/client/googleapis/media/MediaHttpUploader.contentInputStream Ljava/io/InputStream;
      // 145: invokevirtual java/io/InputStream.reset ()V
      // 148: lload 6
      // 14a: aload 0
      // 14b: getfield com/google/api/client/googleapis/media/MediaHttpUploader.contentInputStream Ljava/io/InputStream;
      // 14e: lload 6
      // 150: invokevirtual java/io/InputStream.skip (J)J
      // 153: lcmp
      // 154: ifne 179
      // 157: bipush 1
      // 158: istore 8
      // 15a: iload 8
      // 15c: invokestatic com/google/api/client/util/Preconditions.checkState (Z)V
      // 15f: aload 0
      // 160: lload 4
      // 162: putfield com/google/api/client/googleapis/media/MediaHttpUploader.totalBytesServerReceived J
      // 165: aload 0
      // 166: getstatic com/google/api/client/googleapis/media/MediaHttpUploader$UploadState.MEDIA_IN_PROGRESS Lcom/google/api/client/googleapis/media/MediaHttpUploader$UploadState;
      // 169: invokespecial com/google/api/client/googleapis/media/MediaHttpUploader.updateStateAndNotifyListener (Lcom/google/api/client/googleapis/media/MediaHttpUploader$UploadState;)V
      // 16c: aload 1
      // 16d: invokevirtual com/google/api/client/http/HttpResponse.disconnect ()V
      // 170: goto 05b
      // 173: bipush 0
      // 174: istore 8
      // 176: goto 126
      // 179: bipush 0
      // 17a: istore 8
      // 17c: goto 15a
      // 17f: lload 2
      // 180: lconst_0
      // 181: lcmp
      // 182: ifne 15f
      // 185: aload 0
      // 186: aconst_null
      // 187: putfield com/google/api/client/googleapis/media/MediaHttpUploader.currentRequestContentBuffer [B
      // 18a: goto 15f
      // try (9 -> 16): 92 null
      // try (67 -> 81): 87 null
      // try (81 -> 84): 87 null
      // try (105 -> 113): 87 null
      // try (115 -> 120): 87 null
      // try (120 -> 131): 87 null
      // try (135 -> 141): 87 null
      // try (143 -> 154): 87 null
      // try (158 -> 168): 87 null
      // try (170 -> 172): 87 null
      // try (172 -> 178): 87 null
      // try (191 -> 194): 87 null
   }

   private void setContentAndHeadersOnCurrentRequest() throws IOException {
      int var1;
      if (this.isMediaLengthKnown()) {
         var1 = (int)Math.min(this.chunkSize, this.getMediaContentLength() - this.totalBytesServerReceived);
      } else {
         var1 = this.chunkSize;
      }

      AbstractInputStreamContent var16;
      if (this.isMediaLengthKnown()) {
         this.contentInputStream.mark(var1);
         InputStream var11 = ByteStreams.limit(this.contentInputStream, var1);
         var16 = new InputStreamContent(this.mediaContent.getType(), var11).setRetrySupported(true).setLength(var1).setCloseInputStream(false);
         this.mediaContentLengthStr = String.valueOf(this.getMediaContentLength());
      } else {
         int var2;
         int var3;
         if (this.currentRequestContentBuffer == null) {
            if (this.cachedByte == null) {
               var3 = var1 + 1;
            } else {
               var3 = var1;
            }

            this.currentRequestContentBuffer = new byte[var1 + 1];
            if (this.cachedByte != null) {
               this.currentRequestContentBuffer[0] = this.cachedByte;
               var2 = 0;
            } else {
               var2 = 0;
            }
         } else {
            var2 = (int)(this.totalBytesClientSent - this.totalBytesServerReceived);
            System.arraycopy(this.currentRequestContentBuffer, this.currentChunkLength - var2, this.currentRequestContentBuffer, 0, var2);
            if (this.cachedByte != null) {
               this.currentRequestContentBuffer[var2] = this.cachedByte;
            }

            var3 = var1 - var2;
         }

         int var4 = ByteStreams.read(this.contentInputStream, this.currentRequestContentBuffer, var1 + 1 - var3, var3);
         if (var4 < var3) {
            var2 = Math.max(0, var4) + var2;
            var1 = var2;
            if (this.cachedByte != null) {
               var1 = var2 + 1;
               this.cachedByte = null;
            }

            var2 = var1;
            if (this.mediaContentLengthStr.equals("*")) {
               this.mediaContentLengthStr = String.valueOf(this.totalBytesServerReceived + var1);
               var2 = var1;
            }
         } else {
            this.cachedByte = this.currentRequestContentBuffer[var1];
            var2 = var1;
         }

         var16 = new ByteArrayContent(this.mediaContent.getType(), this.currentRequestContentBuffer, 0, var2);
         this.totalBytesClientSent = this.totalBytesServerReceived + var2;
         var1 = var2;
      }

      this.currentChunkLength = var1;
      this.currentRequest.setContent(var16);
      if (var1 == 0) {
         HttpHeaders var12 = this.currentRequest.getHeaders();
         String var17 = String.valueOf(this.mediaContentLengthStr);
         String var18;
         if (var17.length() != 0) {
            var18 = "bytes */".concat(var17);
         } else {
            var18 = new String("bytes */");
         }

         var12.setContentRange(var18);
      } else {
         HttpHeaders var20 = this.currentRequest.getHeaders();
         long var5 = this.totalBytesServerReceived;
         long var9 = this.totalBytesServerReceived;
         long var7 = var1;
         String var19 = String.valueOf(String.valueOf(this.mediaContentLengthStr));
         var20.setContentRange(
            new StringBuilder(var19.length() + 48).append("bytes ").append(var5).append("-").append(var9 + var7 - 1L).append("/").append(var19).toString()
         );
      }
   }

   private void updateStateAndNotifyListener(MediaHttpUploader.UploadState var1) throws IOException {
      this.uploadState = var1;
      if (this.progressListener != null) {
         this.progressListener.progressChanged(this);
      }
   }

   public int getChunkSize() {
      return this.chunkSize;
   }

   public boolean getDisableGZipContent() {
      return this.disableGZipContent;
   }

   public HttpHeaders getInitiationHeaders() {
      return this.initiationHeaders;
   }

   public String getInitiationRequestMethod() {
      return this.initiationRequestMethod;
   }

   public HttpContent getMediaContent() {
      return this.mediaContent;
   }

   public HttpContent getMetadata() {
      return this.metadata;
   }

   public long getNumBytesUploaded() {
      return this.totalBytesServerReceived;
   }

   public double getProgress() throws IOException {
      Preconditions.checkArgument(
         this.isMediaLengthKnown(),
         "Cannot call getProgress() if the specified AbstractInputStreamContent has no content length. Use  getNumBytesUploaded() to denote progress instead."
      );
      double var1;
      if (this.getMediaContentLength() == 0L) {
         var1 = 0.0;
      } else {
         var1 = (double)this.totalBytesServerReceived / this.getMediaContentLength();
      }

      return var1;
   }

   public MediaHttpUploaderProgressListener getProgressListener() {
      return this.progressListener;
   }

   public Sleeper getSleeper() {
      return this.sleeper;
   }

   public HttpTransport getTransport() {
      return this.transport;
   }

   public MediaHttpUploader.UploadState getUploadState() {
      return this.uploadState;
   }

   public boolean isDirectUploadEnabled() {
      return this.directUploadEnabled;
   }

   @Beta
   void serverErrorCallback() throws IOException {
      Preconditions.checkNotNull(this.currentRequest, "The current request should not be null");
      this.currentRequest.setContent(new EmptyContent());
      HttpHeaders var2 = this.currentRequest.getHeaders();
      String var1 = String.valueOf(this.mediaContentLengthStr);
      if (var1.length() != 0) {
         var1 = "bytes */".concat(var1);
      } else {
         var1 = new String("bytes */");
      }

      var2.setContentRange(var1);
   }

   public MediaHttpUploader setChunkSize(int var1) {
      boolean var2;
      if (var1 > 0 && var1 % 262144 == 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      Preconditions.checkArgument(var2, "chunkSize must be a positive multiple of 262144.");
      this.chunkSize = var1;
      return this;
   }

   public MediaHttpUploader setDirectUploadEnabled(boolean var1) {
      this.directUploadEnabled = var1;
      return this;
   }

   public MediaHttpUploader setDisableGZipContent(boolean var1) {
      this.disableGZipContent = var1;
      return this;
   }

   public MediaHttpUploader setInitiationHeaders(HttpHeaders var1) {
      this.initiationHeaders = var1;
      return this;
   }

   public MediaHttpUploader setInitiationRequestMethod(String var1) {
      boolean var2;
      if (!var1.equals("POST") && !var1.equals("PUT") && !var1.equals("PATCH")) {
         var2 = false;
      } else {
         var2 = true;
      }

      Preconditions.checkArgument(var2);
      this.initiationRequestMethod = var1;
      return this;
   }

   public MediaHttpUploader setMetadata(HttpContent var1) {
      this.metadata = var1;
      return this;
   }

   public MediaHttpUploader setProgressListener(MediaHttpUploaderProgressListener var1) {
      this.progressListener = var1;
      return this;
   }

   public MediaHttpUploader setSleeper(Sleeper var1) {
      this.sleeper = var1;
      return this;
   }

   public HttpResponse upload(GenericUrl var1) throws IOException {
      boolean var2;
      if (this.uploadState == MediaHttpUploader.UploadState.NOT_STARTED) {
         var2 = true;
      } else {
         var2 = false;
      }

      Preconditions.checkArgument(var2);
      HttpResponse var3;
      if (this.directUploadEnabled) {
         var3 = this.directUpload(var1);
      } else {
         var3 = this.resumableUpload(var1);
      }

      return var3;
   }

   public enum UploadState {
      INITIATION_COMPLETE,
      INITIATION_STARTED,
      MEDIA_COMPLETE,
      MEDIA_IN_PROGRESS,
      NOT_STARTED;

      private static final MediaHttpUploader.UploadState[] $VALUES = new MediaHttpUploader.UploadState[]{
         MediaHttpUploader.UploadState.NOT_STARTED,
         MediaHttpUploader.UploadState.INITIATION_STARTED,
         MediaHttpUploader.UploadState.INITIATION_COMPLETE,
         MediaHttpUploader.UploadState.MEDIA_IN_PROGRESS,
         MediaHttpUploader.UploadState.MEDIA_COMPLETE
      };
   }
}
