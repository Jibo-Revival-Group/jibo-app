package com.google.api.client.googleapis.services;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface GoogleClientRequestInitializer {
    void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException;
}
