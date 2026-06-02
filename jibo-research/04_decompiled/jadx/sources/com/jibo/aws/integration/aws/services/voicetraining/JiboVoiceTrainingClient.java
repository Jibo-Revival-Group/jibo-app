package com.jibo.aws.integration.aws.services.voicetraining;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.http.HttpClient;
import com.amazonaws.metrics.RequestMetricCollector;
import com.jibo.aws.integration.aws.services.file.JiboFileClient;
import com.jibo.aws.integration.util.Commons;

/* JADX INFO: loaded from: classes.dex */
public class JiboVoiceTrainingClient extends JiboFileClient {
    public JiboVoiceTrainingClient() {
        m10056a();
    }

    public JiboVoiceTrainingClient(ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        m10056a();
    }

    public JiboVoiceTrainingClient(AWSCredentials aWSCredentials) {
        super(aWSCredentials);
        m10056a();
    }

    public JiboVoiceTrainingClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        super(aWSCredentials, clientConfiguration);
        m10056a();
    }

    public JiboVoiceTrainingClient(AWSCredentialsProvider aWSCredentialsProvider) {
        super(aWSCredentialsProvider);
        m10056a();
    }

    public JiboVoiceTrainingClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(aWSCredentialsProvider, clientConfiguration);
        m10056a();
    }

    public JiboVoiceTrainingClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(aWSCredentialsProvider, clientConfiguration, httpClient);
        m10056a();
    }

    public JiboVoiceTrainingClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, RequestMetricCollector requestMetricCollector) {
        super(aWSCredentialsProvider, clientConfiguration, requestMetricCollector);
        m10056a();
    }

    /* JADX INFO: renamed from: a */
    private void m10056a() {
        setServiceNameIntern("voicetraining");
        setServiceType("voicetraining", Commons.TARGET_PREFIX_VOICE_TRAINING);
    }
}
