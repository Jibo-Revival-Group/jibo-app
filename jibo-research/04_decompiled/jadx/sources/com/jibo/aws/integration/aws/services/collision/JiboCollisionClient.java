package com.jibo.aws.integration.aws.services.collision;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.http.HttpClient;
import com.jibo.aws.integration.aws.services.AbstractJiboClient;
import com.jibo.aws.integration.aws.services.collision.model.CollisionCheckContainer;
import com.jibo.aws.integration.aws.services.collision.model.MatchRequest;
import com.jibo.aws.integration.aws.services.collision.model.p004a.C0849a;
import com.jibo.aws.integration.aws.services.common.model.p005a.C0855e;
import com.jibo.aws.integration.util.C0977a;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class JiboCollisionClient extends AbstractJiboClient {
    public static final String TAG = C0977a.m10070a(JiboCollisionClient.class);

    public JiboCollisionClient(AWSCredentials aWSCredentials) {
        super(aWSCredentials);
    }

    public JiboCollisionClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        super(aWSCredentials, clientConfiguration);
    }

    public JiboCollisionClient(AWSCredentialsProvider aWSCredentialsProvider) {
        super(aWSCredentialsProvider);
    }

    public JiboCollisionClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(aWSCredentialsProvider, clientConfiguration);
    }

    public JiboCollisionClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(aWSCredentialsProvider, clientConfiguration, httpClient);
    }

    public CollisionCheckContainer match(List<String> list, String str) {
        return (CollisionCheckContainer) m9913a(new MatchRequest(list, str), (C0855e) null, new C0849a()).getAwsResponse();
    }
}
