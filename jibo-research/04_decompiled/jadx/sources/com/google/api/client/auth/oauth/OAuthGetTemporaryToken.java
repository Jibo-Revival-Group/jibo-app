package com.google.api.client.auth.oauth;

import com.google.api.client.util.Beta;

/* JADX INFO: loaded from: classes.dex */
@Beta
public class OAuthGetTemporaryToken extends AbstractOAuthGetToken {
    public String callback;

    public OAuthGetTemporaryToken(String str) {
        super(str);
    }

    @Override // com.google.api.client.auth.oauth.AbstractOAuthGetToken
    public OAuthParameters createParameters() {
        OAuthParameters oAuthParametersCreateParameters = super.createParameters();
        oAuthParametersCreateParameters.callback = this.callback;
        return oAuthParametersCreateParameters;
    }
}
