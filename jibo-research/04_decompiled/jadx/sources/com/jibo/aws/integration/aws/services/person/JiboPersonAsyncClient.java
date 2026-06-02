package com.jibo.aws.integration.aws.services.person;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.handlers.AsyncHandler;
import com.google.gson.JsonObject;
import com.jibo.aws.integration.aws.services.AbstractJiboAsyncClient;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.person.model.GetAccountPropertiesRequest;
import com.jibo.aws.integration.aws.services.person.model.GetLoopPropertiesRequest;
import com.jibo.aws.integration.aws.services.person.model.Holiday;
import com.jibo.aws.integration.aws.services.person.model.HolidaysSwitchRequest;
import com.jibo.aws.integration.aws.services.person.model.ListHolidaysRequest;
import com.jibo.aws.integration.aws.services.person.model.SetAccountPropertyRequest;
import com.jibo.aws.integration.aws.services.person.model.SetLoopPropertyRequest;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public class JiboPersonAsyncClient extends AbstractJiboAsyncClient {
    public JiboPersonAsyncClient(AWSCredentials aWSCredentials) {
        super(aWSCredentials);
    }

    public JiboPersonAsyncClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        super(aWSCredentials, clientConfiguration);
    }

    public JiboPersonAsyncClient(AWSCredentialsProvider aWSCredentialsProvider) {
        super(aWSCredentialsProvider);
    }

    public JiboPersonAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(aWSCredentialsProvider, clientConfiguration);
    }

    public HashMap<String, JsonObject> getAccountProperties(List<String> list) {
        return m17216getJiboClient().getAccountProperties(list);
    }

    public Future<HashMap<String, JsonObject>> getAccountProperties(final List<String> list, final AsyncHandler<GetAccountPropertiesRequest, HashMap<String, JsonObject>> asyncHandler) {
        return m9909c().submit(new Callable<HashMap<String, JsonObject>>() { // from class: com.jibo.aws.integration.aws.services.person.JiboPersonAsyncClient.3
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public HashMap<String, JsonObject> call() throws Exception {
                try {
                    HashMap<String, JsonObject> accountProperties = JiboPersonAsyncClient.this.getAccountProperties(list);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new GetAccountPropertiesRequest(list), accountProperties);
                    }
                    return accountProperties;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    @Override // com.jibo.aws.integration.aws.services.AbstractJiboAsyncClient
    /* JADX INFO: renamed from: getJiboClient, reason: merged with bridge method [inline-methods] */
    public JiboPersonClient m17213getJiboClient() {
        return (JiboPersonClient) super.m17216getJiboClient();
    }

    public HashMap<String, JsonObject> getLoopProperties(String str, List<String> list) {
        return m17216getJiboClient().getLoopProperties(str, list);
    }

    public Future<HashMap<String, JsonObject>> getLoopProperties(final String str, final List<String> list, final AsyncHandler<GetLoopPropertiesRequest, HashMap<String, JsonObject>> asyncHandler) {
        return m9909c().submit(new Callable<HashMap<String, JsonObject>>() { // from class: com.jibo.aws.integration.aws.services.person.JiboPersonAsyncClient.5
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public HashMap<String, JsonObject> call() throws Exception {
                try {
                    HashMap<String, JsonObject> loopProperties = JiboPersonAsyncClient.this.getLoopProperties(str, list);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new GetLoopPropertiesRequest(str, list), loopProperties);
                    }
                    return loopProperties;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public List<Holiday> listHolidays(String str) {
        return m17216getJiboClient().listHolidays(str);
    }

    public Future<List<Holiday>> listHolidays(final String str, final AsyncHandler<ListHolidaysRequest, List<Holiday>> asyncHandler) {
        return m9909c().submit(new Callable<List<Holiday>>() { // from class: com.jibo.aws.integration.aws.services.person.JiboPersonAsyncClient.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public List<Holiday> call() throws Exception {
                try {
                    List<Holiday> listListHolidays = JiboPersonAsyncClient.this.listHolidays(str);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new ListHolidaysRequest(str), listListHolidays);
                    }
                    return listListHolidays;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public CommandResponse setAccountProperty(String str, JsonObject jsonObject) {
        return m17216getJiboClient().setAccountProperty(str, jsonObject);
    }

    public Future<CommandResponse> setAccountProperty(final String str, final JsonObject jsonObject, final AsyncHandler<SetAccountPropertyRequest, CommandResponse> asyncHandler) {
        return m9909c().submit(new Callable<CommandResponse>() { // from class: com.jibo.aws.integration.aws.services.person.JiboPersonAsyncClient.4
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public CommandResponse call() throws Exception {
                try {
                    CommandResponse accountProperty = JiboPersonAsyncClient.this.setAccountProperty(str, jsonObject);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new SetAccountPropertyRequest(str, jsonObject), accountProperty);
                    }
                    return accountProperty;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public CommandResponse setLoopProperty(String str, String str2, JsonObject jsonObject) {
        return m17216getJiboClient().setLoopProperty(str, str2, jsonObject);
    }

    public Future<CommandResponse> setLoopProperty(final String str, final String str2, final JsonObject jsonObject, final AsyncHandler<SetLoopPropertyRequest, CommandResponse> asyncHandler) {
        return m9909c().submit(new Callable<CommandResponse>() { // from class: com.jibo.aws.integration.aws.services.person.JiboPersonAsyncClient.6
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public CommandResponse call() throws Exception {
                try {
                    CommandResponse loopProperty = JiboPersonAsyncClient.this.setLoopProperty(str, str2, jsonObject);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new SetLoopPropertyRequest(str, str2, jsonObject), loopProperty);
                    }
                    return loopProperty;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public CommandResponse switchHolidays(boolean z, List<String> list, String str) {
        return m17216getJiboClient().switchHolidays(z, list, str);
    }

    public Future<CommandResponse> switchHolidays(final boolean z, final List<String> list, final String str, final AsyncHandler<HolidaysSwitchRequest, CommandResponse> asyncHandler) {
        return m9909c().submit(new Callable<CommandResponse>() { // from class: com.jibo.aws.integration.aws.services.person.JiboPersonAsyncClient.2
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public CommandResponse call() throws Exception {
                try {
                    CommandResponse commandResponseSwitchHolidays = JiboPersonAsyncClient.this.switchHolidays(z, list, str);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new HolidaysSwitchRequest(z, list, str), commandResponseSwitchHolidays);
                    }
                    return commandResponseSwitchHolidays;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }
}
