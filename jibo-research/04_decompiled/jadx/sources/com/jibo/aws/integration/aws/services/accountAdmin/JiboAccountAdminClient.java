package com.jibo.aws.integration.aws.services.accountAdmin;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.http.HttpClient;
import com.jibo.aws.integration.aws.services.AbstractJiboClient;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.account.model.p001a.C0830a;
import com.jibo.aws.integration.aws.services.accountAdmin.model.ActivateByIdRequest;
import com.jibo.aws.integration.aws.services.common.model.p005a.C0855e;
import com.jibo.aws.integration.util.C0977a;

/* JADX INFO: loaded from: classes.dex */
public class JiboAccountAdminClient extends AbstractJiboClient {
    public static final String TAG = C0977a.m10070a(JiboAccountAdminClient.class);

    public JiboAccountAdminClient(AWSCredentials aWSCredentials) {
        super(aWSCredentials);
    }

    public JiboAccountAdminClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        super(aWSCredentials, clientConfiguration);
    }

    public JiboAccountAdminClient(AWSCredentialsProvider aWSCredentialsProvider) {
        super(aWSCredentialsProvider);
    }

    public JiboAccountAdminClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(aWSCredentialsProvider, clientConfiguration);
    }

    public JiboAccountAdminClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(aWSCredentialsProvider, clientConfiguration, httpClient);
    }

    public Account activateById(String str) {
        return (Account) m9913a(new ActivateByIdRequest(str), (C0855e) null, new C0830a()).getAwsResponse();
    }
}
