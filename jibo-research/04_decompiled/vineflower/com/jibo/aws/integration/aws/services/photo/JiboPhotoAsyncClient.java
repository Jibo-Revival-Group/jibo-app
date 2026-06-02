package com.jibo.aws.integration.aws.services.photo;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.jibo.aws.integration.aws.services.file.JiboFileAsyncClient;
import java.util.concurrent.ExecutorService;

public class JiboPhotoAsyncClient extends JiboFileAsyncClient {
   public JiboPhotoAsyncClient(ClientConfiguration var1) {
      super(var1);
      this.a();
   }

   public JiboPhotoAsyncClient(AWSCredentials var1) {
      super(var1);
      this.a();
   }

   public JiboPhotoAsyncClient(AWSCredentials var1, ClientConfiguration var2, ExecutorService var3) {
      super(var1, var2, var3);
      this.a();
   }

   public JiboPhotoAsyncClient(AWSCredentials var1, ExecutorService var2) {
      super(var1, var2);
      this.a();
   }

   public JiboPhotoAsyncClient(AWSCredentialsProvider var1) {
      super(var1);
      this.a();
   }

   public JiboPhotoAsyncClient(AWSCredentialsProvider var1, ClientConfiguration var2) {
      super(var1, var2);
      this.a();
   }

   public JiboPhotoAsyncClient(AWSCredentialsProvider var1, ClientConfiguration var2, ExecutorService var3) {
      super(var1, var2, var3);
      this.a();
   }

   public JiboPhotoAsyncClient(AWSCredentialsProvider var1, ExecutorService var2) {
      super(var1, var2);
      this.a();
   }

   @Override
   protected void a() {
      this.setServiceNameIntern("photo");
      this.setServiceType("photo", "Photo_20151103.");
   }
}
