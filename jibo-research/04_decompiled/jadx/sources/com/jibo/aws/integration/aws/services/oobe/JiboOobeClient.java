package com.jibo.aws.integration.aws.services.oobe;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.http.HttpClient;
import com.jibo.aws.integration.aws.services.AbstractJiboClient;
import com.jibo.aws.integration.aws.services.common.model.p005a.C0855e;
import com.jibo.aws.integration.aws.services.oobe.model.GetStatusRequest;
import com.jibo.aws.integration.aws.services.oobe.model.KeysContainer;
import com.jibo.aws.integration.aws.services.oobe.model.PrepareRobotRequest;
import com.jibo.aws.integration.aws.services.oobe.model.SetupRobotRequest;
import com.jibo.aws.integration.aws.services.oobe.model.StatusContainer;
import com.jibo.aws.integration.aws.services.oobe.model.TokenContainer;
import com.jibo.aws.integration.aws.services.oobe.model.p014a.C0944a;
import com.jibo.aws.integration.aws.services.oobe.model.p014a.C0945b;
import com.jibo.aws.integration.aws.services.oobe.model.p014a.C0946c;
import com.jibo.aws.integration.util.C0977a;

/* JADX INFO: loaded from: classes.dex */
public class JiboOobeClient extends AbstractJiboClient {
    public static final String TAG = C0977a.m10070a(JiboOobeClient.class);

    public JiboOobeClient(AWSCredentials aWSCredentials) {
        super(aWSCredentials);
    }

    public JiboOobeClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        super(aWSCredentials, clientConfiguration);
    }

    public JiboOobeClient(AWSCredentialsProvider aWSCredentialsProvider) {
        super(aWSCredentialsProvider);
    }

    public JiboOobeClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(aWSCredentialsProvider, clientConfiguration);
    }

    public JiboOobeClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(aWSCredentialsProvider, clientConfiguration, httpClient);
    }

    public StatusContainer getStatus(String str) {
        return (StatusContainer) m9913a(new GetStatusRequest(str), (C0855e) null, new C0945b()).getAwsResponse();
    }

    public TokenContainer prepareRobot(String str) {
        return (TokenContainer) m9913a(new PrepareRobotRequest(str), (C0855e) null, new C0946c()).getAwsResponse();
    }

    public KeysContainer setupRobot(String str, String str2) {
        return (KeysContainer) m9913a(new SetupRobotRequest(str, str2), (C0855e) null, new C0944a()).getAwsResponse();
    }
}
