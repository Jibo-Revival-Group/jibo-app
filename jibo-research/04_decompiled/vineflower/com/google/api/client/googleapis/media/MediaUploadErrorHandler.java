package com.google.api.client.googleapis.media;

import com.google.api.client.http.HttpIOExceptionHandler;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpUnsuccessfulResponseHandler;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Beta
class MediaUploadErrorHandler implements HttpIOExceptionHandler, HttpUnsuccessfulResponseHandler {
   static final Logger LOGGER = Logger.getLogger(MediaUploadErrorHandler.class.getName());
   private final HttpIOExceptionHandler originalIOExceptionHandler;
   private final HttpUnsuccessfulResponseHandler originalUnsuccessfulHandler;
   private final MediaHttpUploader uploader;

   public MediaUploadErrorHandler(MediaHttpUploader var1, HttpRequest var2) {
      this.uploader = Preconditions.checkNotNull(var1);
      this.originalIOExceptionHandler = var2.getIOExceptionHandler();
      this.originalUnsuccessfulHandler = var2.getUnsuccessfulResponseHandler();
      var2.setIOExceptionHandler(this);
      var2.setUnsuccessfulResponseHandler(this);
   }

   @Override
   public boolean handleIOException(HttpRequest var1, boolean var2) throws IOException {
      if (this.originalIOExceptionHandler != null && this.originalIOExceptionHandler.handleIOException(var1, var2)) {
         var2 = true;
      } else {
         var2 = false;
      }

      if (var2) {
         try {
            this.uploader.serverErrorCallback();
         } catch (IOException var3) {
            LOGGER.log(Level.WARNING, "exception thrown while calling server callback", var3);
         }
      }

      return var2;
   }

   @Override
   public boolean handleResponse(HttpRequest var1, HttpResponse var2, boolean var3) throws IOException {
      boolean var4;
      if (this.originalUnsuccessfulHandler != null && this.originalUnsuccessfulHandler.handleResponse(var1, var2, var3)) {
         var4 = true;
      } else {
         var4 = false;
      }

      if (var4 && var3 && var2.getStatusCode() / 100 == 5) {
         try {
            this.uploader.serverErrorCallback();
         } catch (IOException var5) {
            LOGGER.log(Level.WARNING, "exception thrown while calling server callback", var5);
         }
      }

      return var4;
   }
}
