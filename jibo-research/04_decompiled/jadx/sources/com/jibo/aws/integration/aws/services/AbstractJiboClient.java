package com.jibo.aws.integration.aws.services;

import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.Response;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.handlers.HandlerChainFactory;
import com.amazonaws.http.ExecutionContext;
import com.amazonaws.http.HttpClient;
import com.amazonaws.http.HttpResponseHandler;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.http.JsonResponseHandler;
import com.amazonaws.http.UrlHttpClient;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.AWSRequestMetrics;
import com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract;
import com.jibo.aws.integration.aws.services.common.model.p005a.C0855e;
import com.jibo.aws.integration.aws.services.exception.p006a.C0857b;
import com.jibo.aws.integration.aws.services.exception.p006a.C0858c;
import com.jibo.aws.integration.aws.services.exception.p006a.C0860e;
import com.jibo.aws.integration.aws.services.exception.p006a.C0861f;
import com.jibo.aws.integration.aws.services.exception.p006a.C0862g;
import com.jibo.aws.integration.aws.services.exception.p006a.C0864i;
import com.jibo.aws.integration.aws.services.exception.p006a.C0865j;
import com.jibo.aws.integration.util.C0977a;
import com.jibo.aws.integration.util.Commons;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractJiboClient extends AmazonWebServiceClient {
    public static final String TAG = C0977a.m10070a(AbstractJiboClient.class);

    /* JADX INFO: renamed from: a */
    protected List<JsonErrorUnmarshaller> f9301a;

    /* JADX INFO: renamed from: b */
    protected AWSCredentialsProvider f9302b;

    public AbstractJiboClient(AWSCredentials aWSCredentials) {
        this(aWSCredentials, new ClientConfiguration());
    }

    public AbstractJiboClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        this(new StaticCredentialsProvider(aWSCredentials), clientConfiguration);
    }

    public AbstractJiboClient(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, new ClientConfiguration());
    }

    public AbstractJiboClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        this(aWSCredentialsProvider, clientConfiguration, new UrlHttpClient(clientConfiguration));
    }

    public AbstractJiboClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(m9910a(clientConfiguration), httpClient);
        this.f9302b = aWSCredentialsProvider;
        m9911a();
    }

    /* JADX INFO: renamed from: a */
    private static ClientConfiguration m9910a(ClientConfiguration clientConfiguration) {
        return clientConfiguration;
    }

    /* JADX INFO: renamed from: a */
    private void m9911a() {
        this.f9301a = new ArrayList();
        this.f9301a.add(new C0857b());
        this.f9301a.add(new C0858c());
        this.f9301a.add(new C0860e());
        this.f9301a.add(new C0861f());
        this.f9301a.add(new C0862g());
        this.f9301a.add(new C0864i());
        this.f9301a.add(new C0865j());
        this.f9301a.add(new C0865j());
        this.f9301a.add(new JsonErrorUnmarshaller());
        setEndpoint(Commons.ROOT_ENDPOINT);
        new HandlerChainFactory();
    }

    /* JADX INFO: renamed from: a */
    protected <X, Y extends AmazonWebServiceRequest> Response<X> m9912a(Request<Y> request, HttpResponseHandler<AmazonWebServiceResponse<X>> httpResponseHandler, ExecutionContext executionContext) {
        request.setEndpoint(this.endpoint);
        request.setTimeOffset(this.timeOffset);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.CredentialsRequestTime);
        try {
            AWSCredentials credentials = this.f9302b.getCredentials();
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.CredentialsRequestTime);
            AmazonWebServiceRequest originalRequest = request.getOriginalRequest();
            if (originalRequest != null && originalRequest.getRequestCredentials() != null) {
                credentials = originalRequest.getRequestCredentials();
            }
            executionContext.setCredentials(credentials);
            return this.client.execute(request, httpResponseHandler, new JsonErrorResponseHandler(this.f9301a), executionContext);
        } catch (Throwable th) {
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.CredentialsRequestTime);
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    protected <X, Y extends AmazonWebServiceRequest> Response<X> m9913a(JiboRequestAbstract jiboRequestAbstract, C0855e c0855e, Unmarshaller<X, JsonUnmarshallerContext> unmarshaller) throws Throwable {
        Request<JiboRequestAbstract> requestMo9956a;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(jiboRequestAbstract);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (c0855e == null) {
                try {
                    c0855e = new C0855e();
                } catch (Exception e) {
                    e = e;
                    requestMo9956a = null;
                    C0977a.m10073a(TAG, jiboRequestAbstract.getClass().getSimpleName(), e);
                    awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                    Response<X> responseM9912a = m9912a(requestMo9956a, new JsonResponseHandler(unmarshaller), executionContextCreateExecutionContext);
                    endClientExecution(awsRequestMetrics, requestMo9956a, responseM9912a, true);
                    return responseM9912a;
                } catch (Throwable th2) {
                    th = th2;
                    awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                    throw th;
                }
            }
            requestMo9956a = c0855e.mo9956a(jiboRequestAbstract);
            try {
                try {
                    requestMo9956a.setAWSRequestMetrics(awsRequestMetrics);
                    awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                } catch (Exception e2) {
                    e = e2;
                    C0977a.m10073a(TAG, jiboRequestAbstract.getClass().getSimpleName(), e);
                    awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                }
                Response<X> responseM9912a2 = m9912a(requestMo9956a, new JsonResponseHandler(unmarshaller), executionContextCreateExecutionContext);
                endClientExecution(awsRequestMetrics, requestMo9956a, responseM9912a2, true);
                return responseM9912a2;
            } catch (Throwable th3) {
                th = th3;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            endClientExecution(awsRequestMetrics, null, null, true);
            throw th;
        }
    }

    public AWSCredentialsProvider getAwsCredentialsProvider() {
        return this.f9302b;
    }

    @Override // com.amazonaws.AmazonWebServiceClient
    public void setEndpoint(String str) {
        super.setEndpoint(str);
    }

    @Override // com.amazonaws.AmazonWebServiceClient
    public void setRegion(Region region) {
        super.setRegion(region);
    }
}
