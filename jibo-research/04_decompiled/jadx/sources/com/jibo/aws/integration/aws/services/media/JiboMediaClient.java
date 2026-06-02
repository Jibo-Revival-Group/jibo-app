package com.jibo.aws.integration.aws.services.media;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.http.HttpClient;
import com.jibo.aws.integration.aws.services.AbstractJiboClient;
import com.jibo.aws.integration.aws.services.common.model.p005a.C0855e;
import com.jibo.aws.integration.aws.services.media.model.CreateRequest;
import com.jibo.aws.integration.aws.services.media.model.GetRequest;
import com.jibo.aws.integration.aws.services.media.model.ListRequest;
import com.jibo.aws.integration.aws.services.media.model.Media;
import com.jibo.aws.integration.aws.services.media.model.RemoveRequest;
import com.jibo.aws.integration.aws.services.media.model.p012a.C0934a;
import com.jibo.aws.integration.aws.services.media.model.p012a.C0935b;
import com.jibo.aws.integration.aws.services.media.model.p012a.C0936c;
import com.jibo.aws.integration.util.C0977a;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class JiboMediaClient extends AbstractJiboClient {
    public static final String TAG = C0977a.m10070a(JiboMediaClient.class);

    public JiboMediaClient(AWSCredentials aWSCredentials) {
        super(aWSCredentials);
    }

    public JiboMediaClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        super(aWSCredentials, clientConfiguration);
    }

    public JiboMediaClient(AWSCredentialsProvider aWSCredentialsProvider) {
        super(aWSCredentialsProvider);
    }

    public JiboMediaClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(aWSCredentialsProvider, clientConfiguration);
    }

    public JiboMediaClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(aWSCredentialsProvider, clientConfiguration, httpClient);
    }

    public Media create(String str, String str2, String str3, String str4, File file, Boolean bool) {
        return (Media) m9913a(new CreateRequest(str, str2, str3, str4, file, bool), new C0934a(), new C0935b()).getAwsResponse();
    }

    public List<Media> get(List<String> list) {
        return (List) m9913a(new GetRequest(list), (C0855e) null, new C0936c()).getAwsResponse();
    }

    public List<Media> list(List<String> list, Long l, Long l2) {
        return (List) m9913a(new ListRequest(list, l, l2), (C0855e) null, new C0936c()).getAwsResponse();
    }

    public List<Media> remove(List<String> list) {
        return (List) m9913a(new RemoveRequest(list), (C0855e) null, new C0936c()).getAwsResponse();
    }
}
