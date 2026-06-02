package com.jibo.aws.integration.aws.services.account;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.http.HttpClient;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.jibo.aws.integration.aws.services.AbstractJiboClient;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.account.model.AccountRequest;
import com.jibo.aws.integration.aws.services.account.model.ActivateByCodeRequest;
import com.jibo.aws.integration.aws.services.account.model.ActivateByIdRequest;
import com.jibo.aws.integration.aws.services.account.model.ChangeEmailRequest;
import com.jibo.aws.integration.aws.services.account.model.ChangePasswordRequest;
import com.jibo.aws.integration.aws.services.account.model.CreateAccessTokenRequest;
import com.jibo.aws.integration.aws.services.account.model.FacebookConnectRequest;
import com.jibo.aws.integration.aws.services.account.model.FacebookMobileConnectRequest;
import com.jibo.aws.integration.aws.services.account.model.FacebookPrepareLogin;
import com.jibo.aws.integration.aws.services.account.model.FacebookPrepareLoginRequest;
import com.jibo.aws.integration.aws.services.account.model.GetRequest;
import com.jibo.aws.integration.aws.services.account.model.PasswordResetByCodeRequest;
import com.jibo.aws.integration.aws.services.account.model.RemovePhotoRequest;
import com.jibo.aws.integration.aws.services.account.model.RemoveRequest;
import com.jibo.aws.integration.aws.services.account.model.ResendActivationCodeRequest;
import com.jibo.aws.integration.aws.services.account.model.ResetKeysRequest;
import com.jibo.aws.integration.aws.services.account.model.SearchRequest;
import com.jibo.aws.integration.aws.services.account.model.SendPasswordResetRequest;
import com.jibo.aws.integration.aws.services.account.model.SendPhoneVerificationCodeRequest;
import com.jibo.aws.integration.aws.services.account.model.TokenContainer;
import com.jibo.aws.integration.aws.services.account.model.UpdatePhotoRequest;
import com.jibo.aws.integration.aws.services.account.model.UpdateRequest;
import com.jibo.aws.integration.aws.services.account.model.VerifyPhoneByCodeRequest;
import com.jibo.aws.integration.aws.services.account.model.p001a.C0830a;
import com.jibo.aws.integration.aws.services.account.model.p001a.C0831b;
import com.jibo.aws.integration.aws.services.account.model.p001a.C0832c;
import com.jibo.aws.integration.aws.services.account.model.p001a.C0833d;
import com.jibo.aws.integration.aws.services.account.model.p001a.C0834e;
import com.jibo.aws.integration.aws.services.common.model.IdResponse;
import com.jibo.aws.integration.aws.services.common.model.p005a.C0852b;
import com.jibo.aws.integration.aws.services.common.model.p005a.C0853c;
import com.jibo.aws.integration.aws.services.common.model.p005a.C0854d;
import com.jibo.aws.integration.aws.services.common.model.p005a.C0855e;
import com.jibo.aws.integration.util.C0977a;
import java.io.File;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class JiboAccountClient extends AbstractJiboClient {
    public static final String TAG = C0977a.m10070a(JiboAccountClient.class);

    public JiboAccountClient(AWSCredentials aWSCredentials) {
        super(aWSCredentials);
    }

    public JiboAccountClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        super(aWSCredentials, clientConfiguration);
    }

    public JiboAccountClient(AWSCredentialsProvider aWSCredentialsProvider) {
        super(aWSCredentialsProvider);
    }

    public JiboAccountClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(aWSCredentialsProvider, clientConfiguration);
    }

    public JiboAccountClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(aWSCredentialsProvider, clientConfiguration, httpClient);
    }

    public Account activateByCode(String str) {
        String signerOverride = this.clientConfiguration.getSignerOverride();
        this.clientConfiguration.setSignerOverride("NoOpSignerType");
        Account account = (Account) m9913a(new ActivateByCodeRequest(str), (C0855e) null, new C0830a()).getAwsResponse();
        this.clientConfiguration.setSignerOverride(signerOverride);
        return account;
    }

    public Account activateById(String str) {
        return (Account) m9913a(new ActivateByIdRequest(str), new C0853c(), new C0830a()).getAwsResponse();
    }

    public IdResponse changeEmail(String str, String str2) {
        return (IdResponse) m9913a(new ChangeEmailRequest(str, str2), (C0855e) null, new C0854d()).getAwsResponse();
    }

    public Account changePassword(String str, String str2) {
        return (Account) m9913a(new ChangePasswordRequest(str, str2), (C0855e) null, new C0830a()).getAwsResponse();
    }

    public Account create(String str, String str2, String str3) {
        String signerOverride = this.clientConfiguration.getSignerOverride();
        try {
            this.clientConfiguration.setSignerOverride("NoOpSignerType");
            Account account = (Account) m9913a(new AccountRequest(str, str2, str3, "Create"), (C0855e) null, new C0830a()).getAwsResponse();
            this.f9302b = new StaticCredentialsProvider(new BasicAWSCredentials(account.getAccessKeyId(), account.getSecretAccessKey()));
            return account;
        } finally {
            this.clientConfiguration.setSignerOverride(signerOverride);
        }
    }

    public TokenContainer createAccessToken() {
        return (TokenContainer) m9913a(new CreateAccessTokenRequest(), (C0855e) null, new C0833d()).getAwsResponse();
    }

    public Account facebookConnect(String str, String str2) {
        return (Account) m9913a(new FacebookConnectRequest(str, str2), (C0855e) null, new C0830a()).getAwsResponse();
    }

    public TokenContainer facebookMobileConnect(String str) {
        return (TokenContainer) m9913a(new FacebookMobileConnectRequest(str), (C0855e) null, new C0833d()).getAwsResponse();
    }

    public FacebookPrepareLogin facebookPrepareLogin() {
        return (FacebookPrepareLogin) m9913a(new FacebookPrepareLoginRequest(), (C0855e) null, new C0832c()).getAwsResponse();
    }

    public List<Account> get(List<String> list) {
        return (List) m9913a(new GetRequest(list), (C0855e) null, new C0831b()).getAwsResponse();
    }

    public Account login(String str, String str2) {
        String signerOverride = this.clientConfiguration.getSignerOverride();
        try {
            this.clientConfiguration.setSignerOverride("NoOpSignerType");
            Account account = (Account) m9913a(new AccountRequest(str, str2, "Login"), (C0855e) null, new C0830a()).getAwsResponse();
            this.f9302b = new StaticCredentialsProvider(new BasicAWSCredentials(account.getAccessKeyId(), account.getSecretAccessKey()));
            return account;
        } finally {
            this.clientConfiguration.setSignerOverride(signerOverride);
        }
    }

    public void logout() {
        this.f9302b = new StaticCredentialsProvider(new BasicAWSCredentials("", ""));
    }

    public Account passwordResetByCode(String str, String str2) {
        String signerOverride = this.clientConfiguration.getSignerOverride();
        this.clientConfiguration.setSignerOverride("NoOpSignerType");
        Account account = (Account) m9913a(new PasswordResetByCodeRequest(str, str2), (C0855e) null, new C0830a()).getAwsResponse();
        this.clientConfiguration.setSignerOverride(signerOverride);
        return account;
    }

    public Account remove() {
        Account account = (Account) m9913a(new RemoveRequest(), new C0852b(), new C0830a()).getAwsResponse();
        this.f9302b = new StaticCredentialsProvider(new BasicAWSCredentials("", ""));
        return account;
    }

    public Account removePhoto() {
        return (Account) m9913a(new RemovePhotoRequest(), new C0853c(), new C0830a()).getAwsResponse();
    }

    public Account resendActivationCode(String str) {
        String signerOverride = this.clientConfiguration.getSignerOverride();
        this.clientConfiguration.setSignerOverride("NoOpSignerType");
        Account account = (Account) m9913a(new ResendActivationCodeRequest(str), (C0855e) null, new C0830a()).getAwsResponse();
        this.clientConfiguration.setSignerOverride(signerOverride);
        return account;
    }

    public Account resetKeys() {
        Account account = (Account) m9913a(new ResetKeysRequest(), new C0852b(), new C0830a()).getAwsResponse();
        this.f9302b = new StaticCredentialsProvider(new BasicAWSCredentials(account.getAccessKeyId(), account.getSecretAccessKey()));
        return account;
    }

    public List<Account> search(String str) {
        return (List) m9913a(new SearchRequest(str), (C0855e) null, new C0831b()).getAwsResponse();
    }

    public Account sendPasswordReset(String str) {
        String signerOverride = this.clientConfiguration.getSignerOverride();
        this.clientConfiguration.setSignerOverride("NoOpSignerType");
        Account account = (Account) m9913a(new SendPasswordResetRequest(str), (C0855e) null, new C0830a()).getAwsResponse();
        this.clientConfiguration.setSignerOverride(signerOverride);
        return account;
    }

    public IdResponse sendPhoneVerificationCode(String str) {
        return (IdResponse) m9913a(new SendPhoneVerificationCodeRequest(str), (C0855e) null, new C0854d()).getAwsResponse();
    }

    public Account update(UpdateRequest updateRequest) {
        return (Account) m9913a(updateRequest, (C0855e) null, new C0830a()).getAwsResponse();
    }

    public Account updatePhoto(File file, Map<String, String> map) {
        return (Account) m9913a(new UpdatePhotoRequest(file, map), new C0834e(), new C0830a()).getAwsResponse();
    }

    public Account verifyPhoneByCode(String str) {
        return (Account) m9913a(new VerifyPhoneByCodeRequest(str), (C0855e) null, new C0830a()).getAwsResponse();
    }
}
