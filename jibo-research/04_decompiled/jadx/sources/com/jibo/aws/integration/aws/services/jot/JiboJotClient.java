package com.jibo.aws.integration.aws.services.jot;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.http.HttpClient;
import com.jibo.aws.integration.aws.services.AbstractJiboClient;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.common.model.p005a.C0851a;
import com.jibo.aws.integration.aws.services.common.model.p005a.C0855e;
import com.jibo.aws.integration.aws.services.jot.model.CreateMessageRequest;
import com.jibo.aws.integration.aws.services.jot.model.ListMessagesRequest;
import com.jibo.aws.integration.aws.services.jot.model.MarkReadRequest;
import com.jibo.aws.integration.aws.services.jot.model.Message;
import com.jibo.aws.integration.aws.services.jot.model.MessagePart;
import com.jibo.aws.integration.aws.services.jot.model.p009a.C0887a;
import com.jibo.aws.integration.aws.services.jot.model.p009a.C0888b;
import com.jibo.aws.integration.util.C0977a;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class JiboJotClient extends AbstractJiboClient {
    public static final String TAG = C0977a.m10070a(JiboJotClient.class);

    public JiboJotClient(AWSCredentials aWSCredentials) {
        super(aWSCredentials);
    }

    public JiboJotClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        super(aWSCredentials, clientConfiguration);
    }

    public JiboJotClient(AWSCredentialsProvider aWSCredentialsProvider) {
        super(aWSCredentialsProvider);
    }

    public JiboJotClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(aWSCredentialsProvider, clientConfiguration);
    }

    public JiboJotClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(aWSCredentialsProvider, clientConfiguration, httpClient);
    }

    public Message createMessage(String str, String str2, List<MessagePart> list, List<String> list2) {
        return (Message) m9913a(new CreateMessageRequest(str, str2, list, list2), (C0855e) null, new C0887a()).getAwsResponse();
    }

    public List<Message> listMessages(String str, Long l, Long l2) {
        return (List) m9913a(new ListMessagesRequest(str, l, l2), (C0855e) null, new C0888b()).getAwsResponse();
    }

    public CommandResponse markRead(List<String> list) {
        return (CommandResponse) m9913a(new MarkReadRequest(list), (C0855e) null, new C0851a()).getAwsResponse();
    }
}
