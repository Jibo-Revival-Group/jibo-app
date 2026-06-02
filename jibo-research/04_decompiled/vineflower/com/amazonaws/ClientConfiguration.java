package com.amazonaws;

import com.amazonaws.retry.PredefinedRetryPolicies;
import com.amazonaws.retry.RetryPolicy;
import com.amazonaws.util.VersionInfoUtils;

public class ClientConfiguration {
   public static final RetryPolicy DEFAULT_RETRY_POLICY = PredefinedRetryPolicies.DEFAULT;
   public static final String DEFAULT_USER_AGENT = VersionInfoUtils.getUserAgent();
   private int connectionTimeout;
   private int maxConnections;
   private int maxErrorRetry;
   private Protocol protocol;
   @Deprecated
   private String proxyDomain;
   private String proxyHost;
   private String proxyPassword;
   private int proxyPort;
   private String proxyUsername;
   @Deprecated
   private String proxyWorkstation;
   private RetryPolicy retryPolicy;
   private String signerOverride;
   private int socketReceiveBufferSizeHint;
   private int socketSendBufferSizeHint;
   private int socketTimeout;
   private boolean useReaper;
   private String userAgent = DEFAULT_USER_AGENT;

   public ClientConfiguration() {
      this.maxErrorRetry = -1;
      this.retryPolicy = DEFAULT_RETRY_POLICY;
      this.protocol = Protocol.HTTPS;
      this.proxyHost = null;
      this.proxyPort = -1;
      this.proxyUsername = null;
      this.proxyPassword = null;
      this.proxyDomain = null;
      this.proxyWorkstation = null;
      this.maxConnections = 10;
      this.socketTimeout = 15000;
      this.connectionTimeout = 15000;
      this.socketSendBufferSizeHint = 0;
      this.socketReceiveBufferSizeHint = 0;
      this.useReaper = true;
   }

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

   public void setSignerOverride(String var1) {
      this.signerOverride = var1;
   }
}
