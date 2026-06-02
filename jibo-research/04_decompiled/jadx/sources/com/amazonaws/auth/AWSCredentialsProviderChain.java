package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.jibo.aws.integration.util.C0977a;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AWSCredentialsProviderChain implements AWSCredentialsProvider {
    private static final String TAG = C0977a.m10070a(AWSCredentialsProviderChain.class);
    private AWSCredentialsProvider lastUsedProvider;
    private List<AWSCredentialsProvider> credentialsProviders = new LinkedList();
    private boolean reuseLastProvider = true;

    public AWSCredentialsProviderChain(AWSCredentialsProvider... aWSCredentialsProviderArr) {
        if (aWSCredentialsProviderArr == null || aWSCredentialsProviderArr.length == 0) {
            throw new IllegalArgumentException("No credential providers specified");
        }
        for (AWSCredentialsProvider aWSCredentialsProvider : aWSCredentialsProviderArr) {
            this.credentialsProviders.add(aWSCredentialsProvider);
        }
    }

    @Override // com.amazonaws.auth.AWSCredentialsProvider
    public AWSCredentials getCredentials() {
        if (this.reuseLastProvider && this.lastUsedProvider != null) {
            return this.lastUsedProvider.getCredentials();
        }
        for (AWSCredentialsProvider aWSCredentialsProvider : this.credentialsProviders) {
            try {
                AWSCredentials credentials = aWSCredentialsProvider.getCredentials();
                if (credentials.getAWSAccessKeyId() != null && credentials.getAWSSecretKey() != null) {
                    C0977a.m10072a(TAG, "Loading credentials from " + aWSCredentialsProvider.toString());
                    this.lastUsedProvider = aWSCredentialsProvider;
                    return credentials;
                }
            } catch (Exception e) {
                C0977a.m10072a(TAG, "Unable to load credentials from " + aWSCredentialsProvider.toString() + ": " + e.getMessage());
            }
        }
        throw new AmazonClientException("Unable to load AWS credentials from any provider in the chain");
    }
}
