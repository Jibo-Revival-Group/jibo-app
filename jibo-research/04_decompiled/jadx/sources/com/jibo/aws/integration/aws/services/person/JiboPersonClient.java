package com.jibo.aws.integration.aws.services.person;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.http.HttpClient;
import com.google.gson.JsonObject;
import com.jibo.aws.integration.aws.services.AbstractJiboClient;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.common.model.p005a.C0851a;
import com.jibo.aws.integration.aws.services.common.model.p005a.C0855e;
import com.jibo.aws.integration.aws.services.person.model.GetAccountPropertiesRequest;
import com.jibo.aws.integration.aws.services.person.model.GetLoopPropertiesRequest;
import com.jibo.aws.integration.aws.services.person.model.Holiday;
import com.jibo.aws.integration.aws.services.person.model.HolidaysSwitchRequest;
import com.jibo.aws.integration.aws.services.person.model.ListHolidaysRequest;
import com.jibo.aws.integration.aws.services.person.model.SetAccountPropertyRequest;
import com.jibo.aws.integration.aws.services.person.model.SetLoopPropertyRequest;
import com.jibo.aws.integration.aws.services.person.model.p015a.C0954a;
import com.jibo.aws.integration.aws.services.person.model.p015a.C0955b;
import com.jibo.aws.integration.util.C0977a;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class JiboPersonClient extends AbstractJiboClient {
    public static final String TAG = C0977a.m10070a(JiboPersonClient.class);

    public JiboPersonClient(AWSCredentials aWSCredentials) {
        super(aWSCredentials);
    }

    public JiboPersonClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        super(aWSCredentials, clientConfiguration);
    }

    public JiboPersonClient(AWSCredentialsProvider aWSCredentialsProvider) {
        super(aWSCredentialsProvider);
    }

    public JiboPersonClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(aWSCredentialsProvider, clientConfiguration);
    }

    public JiboPersonClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(aWSCredentialsProvider, clientConfiguration, httpClient);
    }

    public HashMap<String, JsonObject> getAccountProperties(List<String> list) {
        return (HashMap) m9913a(new GetAccountPropertiesRequest(list), (C0855e) null, new C0954a()).getAwsResponse();
    }

    public HashMap<String, JsonObject> getLoopProperties(String str, List<String> list) {
        return (HashMap) m9913a(new GetLoopPropertiesRequest(str, list), (C0855e) null, new C0954a()).getAwsResponse();
    }

    public List<Holiday> listHolidays(String str) {
        return (List) m9913a(new ListHolidaysRequest(str), (C0855e) null, new C0955b()).getAwsResponse();
    }

    public CommandResponse setAccountProperty(String str, JsonObject jsonObject) {
        return (CommandResponse) m9913a(new SetAccountPropertyRequest(str, jsonObject), (C0855e) null, new C0851a()).getAwsResponse();
    }

    public CommandResponse setLoopProperty(String str, String str2, JsonObject jsonObject) {
        return (CommandResponse) m9913a(new SetLoopPropertyRequest(str, str2, jsonObject), (C0855e) null, new C0851a()).getAwsResponse();
    }

    public CommandResponse switchHolidays(boolean z, List<String> list, String str) {
        return (CommandResponse) m9913a(new HolidaysSwitchRequest(z, list, str), (C0855e) null, new C0851a()).getAwsResponse();
    }
}
