package com.jibo.aws.integration.aws.services.gqa;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.http.HttpClient;
import com.jibo.aws.integration.aws.services.AbstractJiboClient;
import com.jibo.aws.integration.aws.services.common.model.p005a.C0855e;
import com.jibo.aws.integration.aws.services.gqa.model.AttributionListResponse;
import com.jibo.aws.integration.aws.services.gqa.model.GQAAttribution;
import com.jibo.aws.integration.aws.services.gqa.model.ListAttributionRequest;
import com.jibo.aws.integration.aws.services.gqa.model.QuestionRequest;
import com.jibo.aws.integration.aws.services.gqa.model.p008a.C0879a;
import com.jibo.aws.integration.aws.services.gqa.model.p008a.C0880b;
import com.jibo.aws.integration.util.C0977a;

/* JADX INFO: loaded from: classes.dex */
public class JiboGQAClient extends AbstractJiboClient {
    public static final String TAG = C0977a.m10070a(JiboGQAClient.class);

    public JiboGQAClient(AWSCredentials aWSCredentials) {
        super(aWSCredentials);
    }

    public JiboGQAClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        super(aWSCredentials, clientConfiguration);
    }

    public JiboGQAClient(AWSCredentialsProvider aWSCredentialsProvider) {
        super(aWSCredentialsProvider);
    }

    public JiboGQAClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(aWSCredentialsProvider, clientConfiguration);
    }

    public JiboGQAClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(aWSCredentialsProvider, clientConfiguration, httpClient);
    }

    public AttributionListResponse listAttributions(String str, long j) {
        return (AttributionListResponse) m9913a(new ListAttributionRequest(str, j), new C0855e(), new C0880b()).getAwsResponse();
    }

    public GQAAttribution sendQuestion(String str) {
        return (GQAAttribution) m9913a(new QuestionRequest(str), new C0855e(), new C0879a()).getAwsResponse();
    }
}
