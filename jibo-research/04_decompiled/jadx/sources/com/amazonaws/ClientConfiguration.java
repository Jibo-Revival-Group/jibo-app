package com.amazonaws;

import com.amazonaws.retry.PredefinedRetryPolicies;
import com.amazonaws.retry.RetryPolicy;
import com.amazonaws.util.VersionInfoUtils;

/* JADX INFO: loaded from: classes.dex */
public class ClientConfiguration {
    private String signerOverride;
    public static final String DEFAULT_USER_AGENT = VersionInfoUtils.getUserAgent();
    public static final RetryPolicy DEFAULT_RETRY_POLICY = PredefinedRetryPolicies.DEFAULT;
    private String userAgent = DEFAULT_USER_AGENT;
    private int maxErrorRetry = -1;
    private RetryPolicy retryPolicy = DEFAULT_RETRY_POLICY;
    private Protocol protocol = Protocol.HTTPS;
    private String proxyHost = null;
    private int proxyPort = -1;
    private String proxyUsername = null;
    private String proxyPassword = null;

    @Deprecated
    private String proxyDomain = null;

    @Deprecated
    private String proxyWorkstation = null;
    private int maxConnections = 10;
    private int socketTimeout = 15000;
    private int connectionTimeout = 15000;
    private int socketSendBufferSizeHint = 0;
    private int socketReceiveBufferSizeHint = 0;
    private boolean useReaper = true;

    public int getConnectionTimeout() {
        return this.connectionTimeout;
    }

    public int getMaxConnections() {
        return this.maxConnections;
    }

    public int getMaxErrorRetry() {
        return this.maxErrorRetry;
    }

    public Protocol getProtocol() {
        return this.protocol;
    }

    public RetryPolicy getRetryPolicy() {
        return this.retryPolicy;
    }

    public String getSignerOverride() {
        return this.signerOverride;
    }

    public int getSocketTimeout() {
        return this.socketTimeout;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public void setSignerOverride(String str) {
        this.signerOverride = str;
    }
}
