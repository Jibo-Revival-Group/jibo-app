package com.jibo.aws.integration.aws.services;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractJiboAsyncClient {

    /* JADX INFO: renamed from: a */
    protected AbstractJiboClient f9299a;

    /* JADX INFO: renamed from: b */
    private ExecutorService f9300b;

    public AbstractJiboAsyncClient() {
        this(new BasicAWSCredentials("", ""), new ClientConfiguration());
    }

    public AbstractJiboAsyncClient(AWSCredentials aWSCredentials) {
        m9903a(aWSCredentials);
        this.f9300b = m9909c();
    }

    public AbstractJiboAsyncClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        m9904a(aWSCredentials, clientConfiguration);
        this.f9300b = m9909c();
    }

    public AbstractJiboAsyncClient(AWSCredentialsProvider aWSCredentialsProvider) {
        m9905a(aWSCredentialsProvider);
        this.f9300b = m9909c();
    }

    public AbstractJiboAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        m9906a(aWSCredentialsProvider, clientConfiguration);
        this.f9300b = m9909c();
    }

    /* JADX INFO: renamed from: a */
    private void m9903a(AWSCredentials aWSCredentials) {
        try {
            this.f9299a = (AbstractJiboClient) Class.forName(m9907a()).getConstructor(AWSCredentials.class).newInstance(aWSCredentials);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m9904a(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        try {
            this.f9299a = (AbstractJiboClient) Class.forName(m9907a()).getConstructor(AWSCredentials.class, ClientConfiguration.class).newInstance(aWSCredentials, clientConfiguration);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m9905a(AWSCredentialsProvider aWSCredentialsProvider) {
        try {
            this.f9299a = (AbstractJiboClient) Class.forName(m9907a()).getConstructor(AWSCredentialsProvider.class).newInstance(aWSCredentialsProvider);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m9906a(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        try {
            this.f9299a = (AbstractJiboClient) Class.forName(m9907a()).getConstructor(AWSCredentialsProvider.class, ClientConfiguration.class).newInstance(aWSCredentialsProvider, clientConfiguration);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: a */
    protected String m9907a() {
        return getClass().getName().replace("Async", "");
    }

    /* JADX INFO: renamed from: b */
    protected ExecutorService m9908b() {
        return Executors.newCachedThreadPool();
    }

    /* JADX INFO: renamed from: c */
    protected ExecutorService m9909c() {
        if (isTerminated()) {
            synchronized (AbstractJiboAsyncClient.class) {
                this.f9300b = m9908b();
            }
        }
        return this.f9300b;
    }

    /* JADX INFO: renamed from: getJiboClient */
    protected AbstractJiboClient m17205getJiboClient() {
        if (this.f9299a == null) {
            throw new NullPointerException();
        }
        return this.f9299a;
    }

    public boolean isTerminated() {
        return this.f9300b == null || this.f9300b.isTerminated() || this.f9300b.isShutdown();
    }

    public void setEndpoint(String str) {
        m17205getJiboClient().setEndpoint(str);
    }

    public void setRegion(Region region) {
        m17205getJiboClient().setRegion(region);
    }

    public void shutdown() {
        if (this.f9299a != null) {
            this.f9299a.shutdown();
        }
        if (isTerminated()) {
            return;
        }
        this.f9300b.shutdownNow();
    }
}
