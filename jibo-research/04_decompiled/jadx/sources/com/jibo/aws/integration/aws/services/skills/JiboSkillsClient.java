package com.jibo.aws.integration.aws.services.skills;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.http.HttpClient;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jibo.aws.integration.aws.services.AbstractJiboClient;
import com.jibo.aws.integration.aws.services.common.model.p005a.C0855e;
import com.jibo.aws.integration.aws.services.skills.model.DeleteSettingsRequest;
import com.jibo.aws.integration.aws.services.skills.model.GetSettingsRequest;
import com.jibo.aws.integration.aws.services.skills.model.SettingsUnmarshaller;
import com.jibo.aws.integration.aws.services.skills.model.UpdateSettingsRequest;
import com.jibo.aws.integration.util.C0977a;

/* JADX INFO: loaded from: classes.dex */
public class JiboSkillsClient extends AbstractJiboClient {
    public static final String TAG = C0977a.m10070a(JiboSkillsClient.class);

    public JiboSkillsClient(AWSCredentials aWSCredentials) {
        super(aWSCredentials);
    }

    public JiboSkillsClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        super(aWSCredentials, clientConfiguration);
    }

    public JiboSkillsClient(AWSCredentialsProvider aWSCredentialsProvider) {
        super(aWSCredentialsProvider);
    }

    public JiboSkillsClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(aWSCredentialsProvider, clientConfiguration);
    }

    public JiboSkillsClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(aWSCredentialsProvider, clientConfiguration, httpClient);
    }

    public DeleteSettingsRequest.DeleteSettingData deleteSettings(String str, DeleteSettingsRequest.DeleteSettingData deleteSettingData) {
        JsonObject jsonObject = (JsonObject) new JsonParser().m9413a((String) m9913a(new DeleteSettingsRequest(str, deleteSettingData), (C0855e) null, new SettingsUnmarshaller()).getAwsResponse());
        if (jsonObject.m9406b(ShareConstants.WEB_DIALOG_PARAM_DATA) && jsonObject.m9409e(ShareConstants.WEB_DIALOG_PARAM_DATA).m9406b(deleteSettingData.key) && jsonObject.m9409e(ShareConstants.WEB_DIALOG_PARAM_DATA).m9407c(deleteSettingData.key).m9392i()) {
            return new DeleteSettingsRequest.DeleteSettingData(str, (DeleteSettingsRequest.DeleteSettingData.DeleteSettingValue) new Gson().m9350a(jsonObject.m9409e(ShareConstants.WEB_DIALOG_PARAM_DATA).m9407c(deleteSettingData.key), DeleteSettingsRequest.DeleteSettingData.DeleteSettingValue.class));
        }
        return null;
    }

    public String getSkillsJson(String str) {
        return (String) m9913a(new GetSettingsRequest(str), (C0855e) null, new SettingsUnmarshaller()).getAwsResponse();
    }

    public UpdateSettingsRequest.UpdateSettingData updateSkill(String str, UpdateSettingsRequest.UpdateSettingData updateSettingData) {
        JsonObject jsonObject = (JsonObject) new JsonParser().m9413a((String) m9913a(new UpdateSettingsRequest(str, updateSettingData), (C0855e) null, new SettingsUnmarshaller()).getAwsResponse());
        if (jsonObject.m9406b(ShareConstants.WEB_DIALOG_PARAM_DATA) && jsonObject.m9409e(ShareConstants.WEB_DIALOG_PARAM_DATA).m9406b(updateSettingData.key) && jsonObject.m9409e(ShareConstants.WEB_DIALOG_PARAM_DATA).m9407c(updateSettingData.key).m9392i()) {
            return new UpdateSettingsRequest.UpdateSettingData(str, (UpdateSettingsRequest.UpdateSettingData.UpdateSettingValue) new Gson().m9350a(jsonObject.m9409e(ShareConstants.WEB_DIALOG_PARAM_DATA).m9407c(updateSettingData.key), UpdateSettingsRequest.UpdateSettingData.UpdateSettingValue.class));
        }
        return null;
    }
}
