package com.jibo.aws.integration.aws.services.voicetraining;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.http.HttpClient;
import com.amazonaws.metrics.RequestMetricCollector;
import com.jibo.aws.integration.aws.services.file.JiboFileClient;

public class JiboVoiceTrainingClient extends JiboFileClient {
   public JiboVoiceTrainingClient() {
      this.a();
   }

   public JiboVoiceTrainingClient(ClientConfiguration var1) {
      super(var1);
      this.a();
   }

   public JiboVoiceTrainingClient(AWSCredentials var1) {
      super(var1);
      this.a();
   }

   public JiboVoiceTrainingClient(AWSCredentials var1, ClientConfiguration var2) {
      super(var1, var2);
      this.a();
   }

   public JiboVoiceTrainingClient(AWSCredentialsProvider var1) {
      super(var1);
      this.a();
   }

   public JiboVoiceTrainingClient(AWSCredentialsProvider var1, ClientConfiguration var2) {
      super(var1, var2);
      this.a();
   }

   public JiboVoiceTrainingClient(AWSCredentialsProvider var1, ClientConfiguration var2, HttpClient var3) {
      super(var1, var2, var3);
      this.a();
   }

   public JiboVoiceTrainingClient(AWSCredentialsProvider var1, ClientConfiguration var2, RequestMetricCollector var3) {
      super(var1, var2, var3);
      this.a();
   }

   private void a() {
      this.setServiceNameIntern("voicetraining");
      this.setServiceType("voicetraining", "VoiceTraining_20151103.");
   }
}
