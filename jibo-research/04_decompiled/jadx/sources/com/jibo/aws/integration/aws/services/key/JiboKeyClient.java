package com.jibo.aws.integration.aws.services.key;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.http.HttpClient;
import com.jibo.aws.integration.aws.services.AbstractJiboClient;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.common.model.p005a.C0851a;
import com.jibo.aws.integration.aws.services.common.model.p005a.C0853c;
import com.jibo.aws.integration.aws.services.common.model.p005a.C0855e;
import com.jibo.aws.integration.aws.services.key.model.Backup;
import com.jibo.aws.integration.aws.services.key.model.BackupRequest;
import com.jibo.aws.integration.aws.services.key.model.CreateRequest;
import com.jibo.aws.integration.aws.services.key.model.GetRequest;
import com.jibo.aws.integration.aws.services.key.model.ListIncomingRequest;
import com.jibo.aws.integration.aws.services.key.model.Request;
import com.jibo.aws.integration.aws.services.key.model.RestoreRequest;
import com.jibo.aws.integration.aws.services.key.model.ShareRequest;
import com.jibo.aws.integration.aws.services.key.model.p010a.C0896a;
import com.jibo.aws.integration.aws.services.key.model.p010a.C0897b;
import com.jibo.aws.integration.aws.services.loop.model.p011a.C0922a;
import com.jibo.aws.integration.util.C0977a;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class JiboKeyClient extends AbstractJiboClient {
    public static final String TAG = C0977a.m10070a(JiboKeyClient.class);

    public JiboKeyClient(AWSCredentials aWSCredentials) {
        super(aWSCredentials);
    }

    public JiboKeyClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        super(aWSCredentials, clientConfiguration);
    }

    public JiboKeyClient(AWSCredentialsProvider aWSCredentialsProvider) {
        super(aWSCredentialsProvider);
    }

    public JiboKeyClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(aWSCredentialsProvider, clientConfiguration);
    }

    public JiboKeyClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(aWSCredentialsProvider, clientConfiguration, httpClient);
    }

    public CommandResponse backupEncryptedKey(String str, String str2, String str3) {
        return (CommandResponse) m9913a(new BackupRequest(str, str2, str3), (C0855e) null, new C0851a()).getAwsResponse();
    }

    public Request createRequest(String str, String str2) {
        return (Request) m9913a(new CreateRequest(str, str2), (C0855e) null, new C0897b()).getAwsResponse();
    }

    public Request getRequest(String str) {
        return (Request) m9913a(new GetRequest(str), new C0853c(), new C0897b()).getAwsResponse();
    }

    public List<Request> listIncomingRequests(String str) {
        return (List) m9913a(new ListIncomingRequest(str), (C0855e) null, new C0896a()).getAwsResponse();
    }

    public Backup restoreEncryptedKey(String str, String str2) {
        return (Backup) m9913a(new RestoreRequest(str, str2), (C0855e) null, new C0922a()).getAwsResponse();
    }

    public Request share(String str, String str2) {
        return (Request) m9913a(new ShareRequest(str, str2), (C0855e) null, new C0897b()).getAwsResponse();
    }
}
