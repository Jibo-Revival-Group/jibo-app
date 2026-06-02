package com.jibo.aws.integration.aws.services.skills;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.AbstractJiboAsyncClient;
import com.jibo.aws.integration.aws.services.skills.model.DeleteSettingsRequest;
import com.jibo.aws.integration.aws.services.skills.model.GetSettingsRequest;
import com.jibo.aws.integration.aws.services.skills.model.UpdateSettingsRequest;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public class JiboSkillsAsyncClient extends AbstractJiboAsyncClient {
    public JiboSkillsAsyncClient(AWSCredentials aWSCredentials) {
        super(aWSCredentials);
    }

    public JiboSkillsAsyncClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        super(aWSCredentials, clientConfiguration);
    }

    public JiboSkillsAsyncClient(AWSCredentialsProvider aWSCredentialsProvider) {
        super(aWSCredentialsProvider);
    }

    public JiboSkillsAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(aWSCredentialsProvider, clientConfiguration);
    }

    public DeleteSettingsRequest.DeleteSettingData deleteSettings(String str, DeleteSettingsRequest.DeleteSettingData deleteSettingData) {
        return m17204getJiboClient().deleteSettings(str, deleteSettingData);
    }

    public Future<DeleteSettingsRequest.DeleteSettingData> deleteSettings(final String str, final DeleteSettingsRequest.DeleteSettingData deleteSettingData, final AsyncHandler<DeleteSettingsRequest, DeleteSettingsRequest.DeleteSettingData> asyncHandler) {
        return m9909c().submit(new Callable<DeleteSettingsRequest.DeleteSettingData>() { // from class: com.jibo.aws.integration.aws.services.skills.JiboSkillsAsyncClient.3
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public DeleteSettingsRequest.DeleteSettingData call() throws Exception {
                try {
                    DeleteSettingsRequest.DeleteSettingData deleteSettingDataDeleteSettings = JiboSkillsAsyncClient.this.deleteSettings(str, deleteSettingData);
                    if (deleteSettingDataDeleteSettings == null) {
                        throw new AmazonServiceException("Bad response data");
                    }
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new DeleteSettingsRequest(str, deleteSettingData), deleteSettingDataDeleteSettings);
                    }
                    return deleteSettingDataDeleteSettings;
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
    public JiboSkillsClient m17216getJiboClient() {
        return (JiboSkillsClient) super.m17204getJiboClient();
    }

    public String getSkillsJson(String str) {
        return m17204getJiboClient().getSkillsJson(str);
    }

    public Future<String> getSkillsJson(final String str, final AsyncHandler<GetSettingsRequest, String> asyncHandler) {
        return m9909c().submit(new Callable<String>() { // from class: com.jibo.aws.integration.aws.services.skills.JiboSkillsAsyncClient.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String call() throws Exception {
                try {
                    String skillsJson = JiboSkillsAsyncClient.this.getSkillsJson(str);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new GetSettingsRequest(str), skillsJson);
                    }
                    return skillsJson;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public UpdateSettingsRequest.UpdateSettingData updateSkill(String str, UpdateSettingsRequest.UpdateSettingData updateSettingData) {
        return m17204getJiboClient().updateSkill(str, updateSettingData);
    }

    public Future<UpdateSettingsRequest.UpdateSettingData> updateSkill(final String str, final UpdateSettingsRequest.UpdateSettingData updateSettingData, final AsyncHandler<UpdateSettingsRequest, UpdateSettingsRequest.UpdateSettingData> asyncHandler) {
        return m9909c().submit(new Callable<UpdateSettingsRequest.UpdateSettingData>() { // from class: com.jibo.aws.integration.aws.services.skills.JiboSkillsAsyncClient.2
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public UpdateSettingsRequest.UpdateSettingData call() throws Exception {
                try {
                    UpdateSettingsRequest.UpdateSettingData updateSettingDataUpdateSkill = JiboSkillsAsyncClient.this.updateSkill(str, updateSettingData);
                    if (updateSettingDataUpdateSkill == null) {
                        throw new AmazonServiceException("Bad response data");
                    }
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new UpdateSettingsRequest(str, updateSettingData), updateSettingDataUpdateSkill);
                    }
                    return updateSettingDataUpdateSkill;
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
