package com.jibo.aws.integration.aws.services.voicetraining;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.jibo.aws.integration.aws.services.file.JiboFileAsyncClient;
import com.jibo.aws.integration.util.Commons;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public class JiboVoiceTrainingAsyncClient extends JiboFileAsyncClient {
    public JiboVoiceTrainingAsyncClient(ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        m10055a();
    }

    public JiboVoiceTrainingAsyncClient(AWSCredentials aWSCredentials) {
        super(aWSCredentials);
        m10055a();
    }

    public JiboVoiceTrainingAsyncClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(aWSCredentials, clientConfiguration, executorService);
        m10055a();
    }

    public JiboVoiceTrainingAsyncClient(AWSCredentials aWSCredentials, ExecutorService executorService) {
        super(aWSCredentials, executorService);
        m10055a();
    }

    public JiboVoiceTrainingAsyncClient(AWSCredentialsProvider aWSCredentialsProvider) {
        super(aWSCredentialsProvider);
        m10055a();
    }

    public JiboVoiceTrainingAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(aWSCredentialsProvider, clientConfiguration);
        m10055a();
    }

    public JiboVoiceTrainingAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(aWSCredentialsProvider, clientConfiguration, executorService);
        m10055a();
    }

    public JiboVoiceTrainingAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ExecutorService executorService) {
        super(aWSCredentialsProvider, executorService);
        m10055a();
    }

    /* JADX INFO: renamed from: a */
    protected void m10055a() {
        setServiceNameIntern("voicetraining");
        setServiceType("voicetraining", Commons.TARGET_PREFIX_VOICE_TRAINING);
    }
}
