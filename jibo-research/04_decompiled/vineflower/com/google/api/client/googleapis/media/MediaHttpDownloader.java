package com.google.api.client.googleapis.media;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.util.IOUtils;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.io.OutputStream;

public final class MediaHttpDownloader {
   public static final int MAXIMUM_CHUNK_SIZE = 33554432;
   private long bytesDownloaded;
   private int chunkSize;
   private boolean directDownloadEnabled = false;
   private MediaHttpDownloader.DownloadState downloadState;
   private long lastBytePos;
   private long mediaContentLength;
   private MediaHttpDownloaderProgressListener progressListener;
   private final HttpRequestFactory requestFactory;
   private final HttpTransport transport;

   public MediaHttpDownloader(HttpTransport var1, HttpRequestInitializer var2) {
      this.chunkSize = 33554432;
      this.downloadState = MediaHttpDownloader.DownloadState.NOT_STARTED;
      this.lastBytePos = -1L;
      this.transport = Preconditions.checkNotNull(var1);
      HttpRequestFactory var3;
      if (var2 == null) {
         var3 = var1.createRequestFactory();
      } else {
         var3 = var1.createRequestFactory(var2);
      }

      this.requestFactory = var3;
   }

   private HttpResponse executeCurrentRequest(long var1, GenericUrl var3, HttpHeaders var4, OutputStream var5) throws IOException {
      HttpRequest var8 = this.requestFactory.buildGetRequest(var3);
      if (var4 != null) {
         var8.getHeaders().putAll(var4);
      }

      if (this.bytesDownloaded != 0L || var1 != -1L) {
         StringBuilder var10 = new StringBuilder();
         var10.append("bytes=").append(this.bytesDownloaded).append("-");
         if (var1 != -1L) {
            var10.append(var1);
         }

         var8.getHeaders().setRange(var10.toString());
      }

      HttpResponse var9 = var8.execute();

      try {
         IOUtils.copy(var9.getContent(), var5);
      } finally {
         var9.disconnect();
      }

      return var9;
   }

   private long getNextByteIndex(String var1) {
      long var2;
      if (var1 == null) {
         var2 = 0L;
      } else {
         var2 = Long.parseLong(var1.substring(var1.indexOf(45) + 1, var1.indexOf(47))) + 1L;
      }

      return var2;
   }

   private void setMediaContentLength(String var1) {
      if (var1 != null && this.mediaContentLength == 0L) {
         this.mediaContentLength = Long.parseLong(var1.substring(var1.indexOf(47) + 1));
      }
   }

   private void updateStateAndNotifyListener(MediaHttpDownloader.DownloadState var1) throws IOException {
      this.downloadState = var1;
      if (this.progressListener != null) {
         this.progressListener.progressChanged(this);
      }
   }

   public void download(GenericUrl var1, HttpHeaders var2, OutputStream var3) throws IOException {
      boolean var4;
      if (this.downloadState == MediaHttpDownloader.DownloadState.NOT_STARTED) {
         var4 = true;
      } else {
         var4 = false;
      }

      Preconditions.checkArgument(var4);
      var1.put("alt", "media");
      if (this.directDownloadEnabled) {
         this.updateStateAndNotifyListener(MediaHttpDownloader.DownloadState.MEDIA_IN_PROGRESS);
         this.mediaContentLength = this.executeCurrentRequest(this.lastBytePos, var1, var2, var3).getHeaders().getContentLength();
         this.bytesDownloaded = this.mediaContentLength;
         this.updateStateAndNotifyListener(MediaHttpDownloader.DownloadState.MEDIA_COMPLETE);
      } else {
         while (true) {
            long var7 = this.bytesDownloaded + this.chunkSize - 1L;
            long var5 = var7;
            if (this.lastBytePos != -1L) {
               var5 = Math.min(this.lastBytePos, var7);
            }

            String var9 = this.executeCurrentRequest(var5, var1, var2, var3).getHeaders().getContentRange();
            var5 = this.getNextByteIndex(var9);
            this.setMediaContentLength(var9);
            if (this.mediaContentLength <= var5) {
               this.bytesDownloaded = this.mediaContentLength;
               this.updateStateAndNotifyListener(MediaHttpDownloader.DownloadState.MEDIA_COMPLETE);
               break;
            }

            this.bytesDownloaded = var5;
            this.updateStateAndNotifyListener(MediaHttpDownloader.DownloadState.MEDIA_IN_PROGRESS);
         }
      }
   }

   public void download(GenericUrl var1, OutputStream var2) throws IOException {
      this.download(var1, null, var2);
   }

   public int getChunkSize() {
      return this.chunkSize;
   }

   public MediaHttpDownloader.DownloadState getDownloadState() {
      return this.downloadState;
   }

   public long getLastBytePosition() {
      return this.lastBytePos;
   }

   public long getNumBytesDownloaded() {
      return this.bytesDownloaded;
   }

   public double getProgress() {
      double var1;
      if (this.mediaContentLength == 0L) {
         var1 = 0.0;
      } else {
         var1 = (double)this.bytesDownloaded / this.mediaContentLength;
      }

      return var1;
   }

   public MediaHttpDownloaderProgressListener getProgressListener() {
      return this.progressListener;
   }

   public HttpTransport getTransport() {
      return this.transport;
   }

   public boolean isDirectDownloadEnabled() {
      return this.directDownloadEnabled;
   }

   public MediaHttpDownloader setBytesDownloaded(long var1) {
      boolean var3;
      if (var1 >= 0L) {
         var3 = true;
      } else {
         var3 = false;
      }

      Preconditions.checkArgument(var3);
      this.bytesDownloaded = var1;
      return this;
   }

   public MediaHttpDownloader setChunkSize(int var1) {
      boolean var2;
      if (var1 > 0 && var1 <= 33554432) {
         var2 = true;
      } else {
         var2 = false;
      }

      Preconditions.checkArgument(var2);
      this.chunkSize = var1;
      return this;
   }

   public MediaHttpDownloader setContentRange(long var1, int var3) {
      boolean var4;
      if (var3 >= var1) {
         var4 = true;
      } else {
         var4 = false;
      }

      Preconditions.checkArgument(var4);
      this.setBytesDownloaded(var1);
      this.lastBytePos = var3;
      return this;
   }

   public MediaHttpDownloader setDirectDownloadEnabled(boolean var1) {
      this.directDownloadEnabled = var1;
      return this;
   }

   public MediaHttpDownloader setProgressListener(MediaHttpDownloaderProgressListener var1) {
      this.progressListener = var1;
      return this;
   }

   public enum DownloadState {
      MEDIA_COMPLETE,
      MEDIA_IN_PROGRESS,
      NOT_STARTED;

      private static final MediaHttpDownloader.DownloadState[] $VALUES = new MediaHttpDownloader.DownloadState[]{
         MediaHttpDownloader.DownloadState.NOT_STARTED, MediaHttpDownloader.DownloadState.MEDIA_IN_PROGRESS, MediaHttpDownloader.DownloadState.MEDIA_COMPLETE
      };
   }
}
