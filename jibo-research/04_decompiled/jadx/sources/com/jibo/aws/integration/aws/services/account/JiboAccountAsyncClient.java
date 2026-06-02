package com.jibo.aws.integration.aws.services.account;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.AbstractJiboAsyncClient;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.account.model.AccountRequest;
import com.jibo.aws.integration.aws.services.account.model.ActivateByCodeRequest;
import com.jibo.aws.integration.aws.services.account.model.ActivateByIdRequest;
import com.jibo.aws.integration.aws.services.account.model.ChangeEmailRequest;
import com.jibo.aws.integration.aws.services.account.model.ChangePasswordRequest;
import com.jibo.aws.integration.aws.services.account.model.CreateAccessTokenRequest;
import com.jibo.aws.integration.aws.services.account.model.EmailRequest;
import com.jibo.aws.integration.aws.services.account.model.FacebookConnectRequest;
import com.jibo.aws.integration.aws.services.account.model.FacebookMobileConnectRequest;
import com.jibo.aws.integration.aws.services.account.model.FacebookPrepareLogin;
import com.jibo.aws.integration.aws.services.account.model.FacebookPrepareLoginRequest;
import com.jibo.aws.integration.aws.services.account.model.GetRequest;
import com.jibo.aws.integration.aws.services.account.model.PasswordResetByCodeRequest;
import com.jibo.aws.integration.aws.services.account.model.RemovePhotoRequest;
import com.jibo.aws.integration.aws.services.account.model.RemoveRequest;
import com.jibo.aws.integration.aws.services.account.model.ResetKeysRequest;
import com.jibo.aws.integration.aws.services.account.model.SearchRequest;
import com.jibo.aws.integration.aws.services.account.model.SendPasswordResetRequest;
import com.jibo.aws.integration.aws.services.account.model.SendPhoneVerificationCodeRequest;
import com.jibo.aws.integration.aws.services.account.model.TokenContainer;
import com.jibo.aws.integration.aws.services.account.model.UpdatePhotoRequest;
import com.jibo.aws.integration.aws.services.account.model.UpdateRequest;
import com.jibo.aws.integration.aws.services.account.model.VerifyPhoneByCodeRequest;
import com.jibo.aws.integration.aws.services.common.model.IdResponse;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public class JiboAccountAsyncClient extends AbstractJiboAsyncClient {
    public JiboAccountAsyncClient() {
    }

    public JiboAccountAsyncClient(AWSCredentials aWSCredentials) {
        super(aWSCredentials);
    }

    public JiboAccountAsyncClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        super(aWSCredentials, clientConfiguration);
    }

    public JiboAccountAsyncClient(AWSCredentialsProvider aWSCredentialsProvider) {
        super(aWSCredentialsProvider);
    }

    public JiboAccountAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(aWSCredentialsProvider, clientConfiguration);
    }

    public Account activateByCode(String str) {
        return m17216getJiboClient().activateByCode(str);
    }

    public Future<Account> activateByCode(final String str, final AsyncHandler<ActivateByCodeRequest, Account> asyncHandler) {
        return m9909c().submit(new Callable<Account>() { // from class: com.jibo.aws.integration.aws.services.account.JiboAccountAsyncClient.20
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Account call() throws Exception {
                try {
                    Account accountActivateByCode = JiboAccountAsyncClient.this.activateByCode(str);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new ActivateByCodeRequest(str), accountActivateByCode);
                    }
                    return accountActivateByCode;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public Account activateById(String str) {
        return m17216getJiboClient().activateById(str);
    }

    public Future<Account> activateById(final String str, final AsyncHandler<ActivateByIdRequest, Account> asyncHandler) {
        return m9909c().submit(new Callable<Account>() { // from class: com.jibo.aws.integration.aws.services.account.JiboAccountAsyncClient.21
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Account call() throws Exception {
                try {
                    Account accountActivateById = JiboAccountAsyncClient.this.activateById(str);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new ActivateByIdRequest(str), accountActivateById);
                    }
                    return accountActivateById;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public IdResponse changeEmail(String str, String str2) {
        return m17216getJiboClient().changeEmail(str, str2);
    }

    public Future<IdResponse> changeEmail(final String str, final String str2, final AsyncHandler<ChangeEmailRequest, IdResponse> asyncHandler) {
        return m9909c().submit(new Callable<IdResponse>() { // from class: com.jibo.aws.integration.aws.services.account.JiboAccountAsyncClient.15
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public IdResponse call() throws Exception {
                try {
                    IdResponse idResponseChangeEmail = JiboAccountAsyncClient.this.changeEmail(str, str2);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new ChangeEmailRequest(str, str2), idResponseChangeEmail);
                    }
                    return idResponseChangeEmail;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public Account changePassword(String str, String str2) {
        return m17216getJiboClient().changePassword(str, str2);
    }

    public Future<Account> changePassword(final String str, final String str2, final AsyncHandler<ChangePasswordRequest, Account> asyncHandler) {
        return m9909c().submit(new Callable<Account>() { // from class: com.jibo.aws.integration.aws.services.account.JiboAccountAsyncClient.3
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Account call() throws Exception {
                try {
                    Account accountChangePassword = JiboAccountAsyncClient.this.changePassword(str, str2);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new ChangePasswordRequest(str, str2), accountChangePassword);
                    }
                    return accountChangePassword;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public Account create(String str, String str2, String str3) {
        return m17216getJiboClient().create(str, str2, str3);
    }

    public Future<Account> create(final String str, final String str2, final String str3, final AsyncHandler<AccountRequest, Account> asyncHandler) {
        return m9909c().submit(new Callable<Account>() { // from class: com.jibo.aws.integration.aws.services.account.JiboAccountAsyncClient.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Account call() throws Exception {
                try {
                    Account accountCreate = JiboAccountAsyncClient.this.create(str, str2, str3);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new AccountRequest(str, str2, "Create"), accountCreate);
                    }
                    return accountCreate;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public TokenContainer createAccessToken() {
        return m17216getJiboClient().createAccessToken();
    }

    public Future<TokenContainer> createAccessToken(final AsyncHandler<CreateAccessTokenRequest, TokenContainer> asyncHandler) {
        return m9909c().submit(new Callable<TokenContainer>() { // from class: com.jibo.aws.integration.aws.services.account.JiboAccountAsyncClient.8
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public TokenContainer call() throws Exception {
                try {
                    TokenContainer tokenContainerCreateAccessToken = JiboAccountAsyncClient.this.createAccessToken();
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new CreateAccessTokenRequest(), tokenContainerCreateAccessToken);
                    }
                    return tokenContainerCreateAccessToken;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public Account facebookConnect(String str, String str2) {
        return m17216getJiboClient().facebookConnect(str, str2);
    }

    public Future<Account> facebookConnect(final String str, final String str2, final AsyncHandler<FacebookConnectRequest, Account> asyncHandler) {
        return m9909c().submit(new Callable<Account>() { // from class: com.jibo.aws.integration.aws.services.account.JiboAccountAsyncClient.10
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Account call() throws Exception {
                try {
                    Account accountFacebookConnect = JiboAccountAsyncClient.this.facebookConnect(str, str2);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new FacebookConnectRequest(str, str2), accountFacebookConnect);
                    }
                    return accountFacebookConnect;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public TokenContainer facebookMobileConnect(String str) {
        return m17216getJiboClient().facebookMobileConnect(str);
    }

    public Future<TokenContainer> facebookMobileConnect(final String str, final AsyncHandler<FacebookMobileConnectRequest, TokenContainer> asyncHandler) {
        return m9909c().submit(new Callable<TokenContainer>() { // from class: com.jibo.aws.integration.aws.services.account.JiboAccountAsyncClient.11
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public TokenContainer call() throws Exception {
                try {
                    TokenContainer tokenContainerFacebookMobileConnect = JiboAccountAsyncClient.this.facebookMobileConnect(str);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new FacebookMobileConnectRequest(str), tokenContainerFacebookMobileConnect);
                    }
                    return tokenContainerFacebookMobileConnect;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public FacebookPrepareLogin facebookPrepareLogin() {
        return m17216getJiboClient().facebookPrepareLogin();
    }

    public Future<FacebookPrepareLogin> facebookPrepareLogin(final AsyncHandler<FacebookPrepareLoginRequest, FacebookPrepareLogin> asyncHandler) {
        return m9909c().submit(new Callable<FacebookPrepareLogin>() { // from class: com.jibo.aws.integration.aws.services.account.JiboAccountAsyncClient.9
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public FacebookPrepareLogin call() throws Exception {
                try {
                    FacebookPrepareLogin facebookPrepareLogin = JiboAccountAsyncClient.this.facebookPrepareLogin();
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new FacebookPrepareLoginRequest(), facebookPrepareLogin);
                    }
                    return facebookPrepareLogin;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public List<Account> get(List<String> list) {
        return m17216getJiboClient().get(list);
    }

    public Future<List<Account>> get(final List<String> list, final AsyncHandler<GetRequest, List<Account>> asyncHandler) {
        return m9909c().submit(new Callable<List<Account>>() { // from class: com.jibo.aws.integration.aws.services.account.JiboAccountAsyncClient.17
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public List<Account> call() throws Exception {
                try {
                    List<Account> list2 = JiboAccountAsyncClient.this.get(list);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new GetRequest(list), list2);
                    }
                    return list2;
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
    public JiboAccountClient m17203getJiboClient() {
        return (JiboAccountClient) super.m17216getJiboClient();
    }

    public Account login(String str, String str2) {
        return m17216getJiboClient().login(str, str2);
    }

    public Future<Account> login(final String str, final String str2, final AsyncHandler<AccountRequest, Account> asyncHandler) {
        return m9909c().submit(new Callable<Account>() { // from class: com.jibo.aws.integration.aws.services.account.JiboAccountAsyncClient.12
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Account call() throws Exception {
                try {
                    Account accountLogin = JiboAccountAsyncClient.this.login(str, str2);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new AccountRequest(str, str2, "login"), accountLogin);
                    }
                    return accountLogin;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public void logout() {
        m17216getJiboClient().logout();
    }

    public Account passwordResetByCode(String str, String str2) {
        return m17216getJiboClient().passwordResetByCode(str, str2);
    }

    public Future<Account> passwordResetByCode(final String str, final String str2, final AsyncHandler<PasswordResetByCodeRequest, Account> asyncHandler) {
        return m9909c().submit(new Callable<Account>() { // from class: com.jibo.aws.integration.aws.services.account.JiboAccountAsyncClient.5
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Account call() throws Exception {
                try {
                    Account accountPasswordResetByCode = JiboAccountAsyncClient.this.passwordResetByCode(str, str2);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new PasswordResetByCodeRequest(str, str2), accountPasswordResetByCode);
                    }
                    return accountPasswordResetByCode;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public Account remove() {
        return m17216getJiboClient().remove();
    }

    public Future<Account> remove(final AsyncHandler<RemoveRequest, Account> asyncHandler) {
        return m9909c().submit(new Callable<Account>() { // from class: com.jibo.aws.integration.aws.services.account.JiboAccountAsyncClient.19
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Account call() throws Exception {
                try {
                    Account accountRemove = JiboAccountAsyncClient.this.remove();
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new RemoveRequest(), accountRemove);
                    }
                    return accountRemove;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public Account removePhoto() {
        return m17216getJiboClient().removePhoto();
    }

    public Future<Account> removePhoto(final AsyncHandler<RemovePhotoRequest, Account> asyncHandler) {
        return m9909c().submit(new Callable<Account>() { // from class: com.jibo.aws.integration.aws.services.account.JiboAccountAsyncClient.7
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Account call() throws Exception {
                try {
                    Account accountRemovePhoto = JiboAccountAsyncClient.this.removePhoto();
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new RemovePhotoRequest(), accountRemovePhoto);
                    }
                    return accountRemovePhoto;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public Account resendActivationCode(String str) {
        return m17216getJiboClient().resendActivationCode(str);
    }

    public Future<Account> resendActivationCode(final String str, final AsyncHandler<EmailRequest, Account> asyncHandler) {
        return m9909c().submit(new Callable<Account>() { // from class: com.jibo.aws.integration.aws.services.account.JiboAccountAsyncClient.22
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Account call() throws Exception {
                try {
                    Account accountResendActivationCode = JiboAccountAsyncClient.this.resendActivationCode(str);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new EmailRequest(str), accountResendActivationCode);
                    }
                    return accountResendActivationCode;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public Account resetKeys() {
        return m17216getJiboClient().resetKeys();
    }

    public Future<Account> resetKeys(final AsyncHandler<ResetKeysRequest, Account> asyncHandler) {
        return m9909c().submit(new Callable<Account>() { // from class: com.jibo.aws.integration.aws.services.account.JiboAccountAsyncClient.16
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Account call() throws Exception {
                try {
                    Account accountResetKeys = JiboAccountAsyncClient.this.resetKeys();
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new ResetKeysRequest(), accountResetKeys);
                    }
                    return accountResetKeys;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public List<Account> search(String str) {
        return m17216getJiboClient().search(str);
    }

    public Future<List<Account>> search(final String str, final AsyncHandler<SearchRequest, List<Account>> asyncHandler) {
        return m9909c().submit(new Callable<List<Account>>() { // from class: com.jibo.aws.integration.aws.services.account.JiboAccountAsyncClient.2
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public List<Account> call() throws Exception {
                try {
                    List<Account> listSearch = JiboAccountAsyncClient.this.search(str);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new SearchRequest(str), listSearch);
                    }
                    return listSearch;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public Account sendPasswordReset(String str) {
        return m17216getJiboClient().sendPasswordReset(str);
    }

    public Future<Account> sendPasswordReset(final String str, final AsyncHandler<SendPasswordResetRequest, Account> asyncHandler) {
        return m9909c().submit(new Callable<Account>() { // from class: com.jibo.aws.integration.aws.services.account.JiboAccountAsyncClient.4
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Account call() throws Exception {
                try {
                    Account accountSendPasswordReset = JiboAccountAsyncClient.this.sendPasswordReset(str);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new SendPasswordResetRequest(str), accountSendPasswordReset);
                    }
                    return accountSendPasswordReset;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public IdResponse sendPhoneVerificationCode(String str) {
        return m17216getJiboClient().sendPhoneVerificationCode(str);
    }

    public Future<IdResponse> sendPhoneVerificationCode(final String str, final AsyncHandler<SendPhoneVerificationCodeRequest, IdResponse> asyncHandler) {
        return m9909c().submit(new Callable<IdResponse>() { // from class: com.jibo.aws.integration.aws.services.account.JiboAccountAsyncClient.13
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public IdResponse call() throws Exception {
                try {
                    IdResponse idResponseSendPhoneVerificationCode = JiboAccountAsyncClient.this.sendPhoneVerificationCode(str);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new SendPhoneVerificationCodeRequest(str), idResponseSendPhoneVerificationCode);
                    }
                    return idResponseSendPhoneVerificationCode;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public Account update(UpdateRequest updateRequest) {
        return m17216getJiboClient().update(updateRequest);
    }

    public Future<Account> update(final UpdateRequest updateRequest, final AsyncHandler<UpdateRequest, Account> asyncHandler) {
        return m9909c().submit(new Callable<Account>() { // from class: com.jibo.aws.integration.aws.services.account.JiboAccountAsyncClient.18
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Account call() throws Exception {
                try {
                    Account accountUpdate = JiboAccountAsyncClient.this.update(updateRequest);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(updateRequest, accountUpdate);
                    }
                    return accountUpdate;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public Account updatePhoto(File file, Map<String, String> map) {
        return m17216getJiboClient().updatePhoto(file, map);
    }

    public Future<Account> updatePhoto(final File file, final Map<String, String> map, final AsyncHandler<UpdatePhotoRequest, Account> asyncHandler) {
        return m9909c().submit(new Callable<Account>() { // from class: com.jibo.aws.integration.aws.services.account.JiboAccountAsyncClient.6
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Account call() throws Exception {
                try {
                    Account accountUpdatePhoto = JiboAccountAsyncClient.this.updatePhoto(file, map);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new UpdatePhotoRequest(file, map), accountUpdatePhoto);
                    }
                    return accountUpdatePhoto;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public Account verifyPhoneByCode(String str) {
        return m17216getJiboClient().verifyPhoneByCode(str);
    }

    public Future<Account> verifyPhoneByCode(final String str, final AsyncHandler<VerifyPhoneByCodeRequest, Account> asyncHandler) {
        return m9909c().submit(new Callable<Account>() { // from class: com.jibo.aws.integration.aws.services.account.JiboAccountAsyncClient.14
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Account call() throws Exception {
                try {
                    Account accountVerifyPhoneByCode = JiboAccountAsyncClient.this.verifyPhoneByCode(str);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new VerifyPhoneByCodeRequest(str), accountVerifyPhoneByCode);
                    }
                    return accountVerifyPhoneByCode;
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
