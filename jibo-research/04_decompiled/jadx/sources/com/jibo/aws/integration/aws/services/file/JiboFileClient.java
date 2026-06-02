package com.jibo.aws.integration.aws.services.file;

import android.text.TextUtils;
import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.Response;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.handlers.HandlerChainFactory;
import com.amazonaws.http.ExecutionContext;
import com.amazonaws.http.HttpClient;
import com.amazonaws.http.HttpResponseHandler;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.http.JsonResponseHandler;
import com.amazonaws.http.UrlHttpClient;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.amazonaws.util.AWSRequestMetrics;
import com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract;
import com.jibo.aws.integration.aws.services.common.model.p005a.C0852b;
import com.jibo.aws.integration.aws.services.exception.p006a.C0856a;
import com.jibo.aws.integration.aws.services.exception.p006a.C0857b;
import com.jibo.aws.integration.aws.services.exception.p006a.C0858c;
import com.jibo.aws.integration.aws.services.exception.p006a.C0859d;
import com.jibo.aws.integration.aws.services.exception.p006a.C0860e;
import com.jibo.aws.integration.aws.services.exception.p006a.C0861f;
import com.jibo.aws.integration.aws.services.exception.p006a.C0862g;
import com.jibo.aws.integration.aws.services.exception.p006a.C0863h;
import com.jibo.aws.integration.aws.services.exception.p006a.C0864i;
import com.jibo.aws.integration.aws.services.exception.p006a.C0865j;
import com.jibo.aws.integration.aws.services.file.model.FileLink;
import com.jibo.aws.integration.aws.services.file.model.GetFileRequest;
import com.jibo.aws.integration.aws.services.file.model.KeyRequest;
import com.jibo.aws.integration.aws.services.file.model.ListFilesRequest;
import com.jibo.aws.integration.aws.services.file.model.RemoveFileRequest;
import com.jibo.aws.integration.aws.services.file.model.UploadFileRequest;
import com.jibo.aws.integration.aws.services.file.model.p007a.C0870a;
import com.jibo.aws.integration.aws.services.file.model.p007a.C0871b;
import com.jibo.aws.integration.aws.services.file.model.p007a.C0872c;
import com.jibo.aws.integration.aws.services.file.model.p007a.C0873d;
import com.jibo.aws.integration.util.C0977a;
import com.jibo.aws.integration.util.Commons;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class JiboFileClient extends AmazonWebServiceClient {
    public static final String TAG = C0977a.m10070a(JiboFileClient.class);

    /* JADX INFO: renamed from: a */
    protected List<JsonErrorUnmarshaller> f9430a;

    /* JADX INFO: renamed from: b */
    protected String f9431b;

    /* JADX INFO: renamed from: c */
    protected String f9432c;

    /* JADX INFO: renamed from: d */
    private AWSCredentialsProvider f9433d;

    @Deprecated
    public JiboFileClient() {
        this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    @Deprecated
    public JiboFileClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    public JiboFileClient(AWSCredentials aWSCredentials) {
        this(aWSCredentials, new ClientConfiguration());
    }

    public JiboFileClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        this(new StaticCredentialsProvider(aWSCredentials), clientConfiguration);
    }

    public JiboFileClient(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, new ClientConfiguration());
    }

    public JiboFileClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        this(aWSCredentialsProvider, clientConfiguration, new UrlHttpClient(clientConfiguration));
    }

    public JiboFileClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(m9967a(clientConfiguration), httpClient);
        this.f9433d = aWSCredentialsProvider;
        m9969a();
    }

    @Deprecated
    public JiboFileClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, RequestMetricCollector requestMetricCollector) {
        super(m9967a(clientConfiguration), requestMetricCollector);
        this.f9433d = aWSCredentialsProvider;
        m9969a();
    }

    /* JADX INFO: renamed from: a */
    private static ClientConfiguration m9967a(ClientConfiguration clientConfiguration) {
        return clientConfiguration;
    }

    /* JADX INFO: renamed from: a */
    private <X, Y extends AmazonWebServiceRequest> Response<X> m9968a(Request<Y> request, HttpResponseHandler<AmazonWebServiceResponse<X>> httpResponseHandler, ExecutionContext executionContext) {
        request.setEndpoint(this.endpoint);
        request.setTimeOffset(this.timeOffset);
        if (!TextUtils.isEmpty(this.f9432c)) {
            String str = request.getHeaders().get("X-Amz-Target");
            if (!TextUtils.isEmpty(str)) {
                request.getHeaders().put("X-Amz-Target", str.replace(Commons.TARGET_PREFIX_PLACEHOLDER, this.f9432c));
            }
        }
        if (!TextUtils.isEmpty(this.f9431b)) {
            request.setServiceName(this.f9431b);
        }
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.CredentialsRequestTime);
        try {
            AWSCredentials credentials = this.f9433d.getCredentials();
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.CredentialsRequestTime);
            AmazonWebServiceRequest originalRequest = request.getOriginalRequest();
            if (originalRequest != null && originalRequest.getRequestCredentials() != null) {
                credentials = originalRequest.getRequestCredentials();
            }
            executionContext.setCredentials(credentials);
            return this.client.execute(request, httpResponseHandler, new JsonErrorResponseHandler(this.f9430a), executionContext);
        } catch (Throwable th) {
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.CredentialsRequestTime);
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m9969a() {
        this.f9430a = new ArrayList();
        this.f9430a.add(new C0863h());
        this.f9430a.add(new C0859d());
        this.f9430a.add(new C0856a());
        this.f9430a.add(new C0857b());
        this.f9430a.add(new C0858c());
        this.f9430a.add(new C0860e());
        this.f9430a.add(new C0861f());
        this.f9430a.add(new C0862g());
        this.f9430a.add(new C0864i());
        this.f9430a.add(new C0865j());
        this.f9430a.add(new C0865j());
        this.f9430a.add(new JsonErrorUnmarshaller());
        setEndpoint(Commons.ROOT_ENDPOINT);
        new HandlerChainFactory();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.amazonaws.metrics.MetricType, com.amazonaws.util.AWSRequestMetrics$Field] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.amazonaws.util.AWSRequestMetrics] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.jibo.aws.integration.aws.services.file.JiboFileClient] */
    public FileLink getFile(String str) throws Throwable {
        Request<KeyRequest> requestM9972a;
        GetFileRequest getFileRequest = new GetFileRequest(str);
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(getFileRequest);
        ?? awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        ?? r1 = AWSRequestMetrics.Field.ClientExecuteTime;
        awsRequestMetrics.startEvent(r1);
        try {
            try {
                try {
                    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                } catch (Throwable th) {
                    th = th;
                    endClientExecution(awsRequestMetrics, r1, null, true);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                requestM9972a = new C0872c().m9972a(getFileRequest);
                try {
                    requestM9972a.setAWSRequestMetrics(awsRequestMetrics);
                    awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                } catch (Exception e) {
                    e = e;
                    C0977a.m10073a(TAG, "removeFile", e);
                    awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                }
            } catch (Exception e2) {
                e = e2;
                requestM9972a = null;
            } catch (Throwable th3) {
                th = th3;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                throw th;
            }
            Response responseM9968a = m9968a(requestM9972a, new JsonResponseHandler(new C0870a()), executionContextCreateExecutionContext);
            FileLink fileLink = (FileLink) responseM9968a.getAwsResponse();
            endClientExecution(awsRequestMetrics, requestM9972a, responseM9968a, true);
            return fileLink;
        } catch (Throwable th4) {
            th = th4;
            r1 = 0;
            endClientExecution(awsRequestMetrics, r1, null, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.amazonaws.metrics.MetricType, com.amazonaws.util.AWSRequestMetrics$Field] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.amazonaws.util.AWSRequestMetrics] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.jibo.aws.integration.aws.services.file.JiboFileClient] */
    public List<FileLink> listFiles() throws Throwable {
        Request<JiboRequestAbstract> requestA;
        ListFilesRequest listFilesRequest = new ListFilesRequest();
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(listFilesRequest);
        ?? awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        ?? r1 = AWSRequestMetrics.Field.ClientExecuteTime;
        awsRequestMetrics.startEvent(r1);
        try {
            try {
                try {
                    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                } catch (Throwable th) {
                    th = th;
                    endClientExecution(awsRequestMetrics, r1, null, true);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                requestA = new C0852b().mo9956a(listFilesRequest);
                try {
                    requestA.setAWSRequestMetrics(awsRequestMetrics);
                    awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                } catch (Exception e) {
                    e = e;
                    C0977a.m10073a(TAG, "listFiles", e);
                    awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                }
            } catch (Exception e2) {
                e = e2;
                requestA = null;
            } catch (Throwable th3) {
                th = th3;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                throw th;
            }
            Response responseM9968a = m9968a(requestA, new JsonResponseHandler(new C0871b()), executionContextCreateExecutionContext);
            List<FileLink> list = (List) responseM9968a.getAwsResponse();
            endClientExecution(awsRequestMetrics, requestA, responseM9968a, true);
            return list;
        } catch (Throwable th4) {
            th = th4;
            r1 = 0;
            endClientExecution(awsRequestMetrics, r1, null, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.amazonaws.metrics.MetricType, com.amazonaws.util.AWSRequestMetrics$Field] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.amazonaws.util.AWSRequestMetrics] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.jibo.aws.integration.aws.services.file.JiboFileClient] */
    public FileLink removeFile(String str) throws Throwable {
        Request<KeyRequest> requestM9972a;
        RemoveFileRequest removeFileRequest = new RemoveFileRequest(str);
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(removeFileRequest);
        ?? awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        ?? r1 = AWSRequestMetrics.Field.ClientExecuteTime;
        awsRequestMetrics.startEvent(r1);
        try {
            try {
                try {
                    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                } catch (Throwable th) {
                    th = th;
                    endClientExecution(awsRequestMetrics, r1, null, true);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                requestM9972a = new C0872c().m9972a(removeFileRequest);
                try {
                    requestM9972a.setAWSRequestMetrics(awsRequestMetrics);
                    awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                } catch (Exception e) {
                    e = e;
                    C0977a.m10073a(TAG, "removeFile", e);
                    awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                }
            } catch (Exception e2) {
                e = e2;
                requestM9972a = null;
            } catch (Throwable th3) {
                th = th3;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                throw th;
            }
            Response responseM9968a = m9968a(requestM9972a, new JsonResponseHandler(new C0870a()), executionContextCreateExecutionContext);
            FileLink fileLink = (FileLink) responseM9968a.getAwsResponse();
            endClientExecution(awsRequestMetrics, requestM9972a, responseM9968a, true);
            return fileLink;
        } catch (Throwable th4) {
            th = th4;
            r1 = 0;
            endClientExecution(awsRequestMetrics, r1, null, true);
            throw th;
        }
    }

    public void setServiceType(String str, String str2) {
        this.f9431b = str;
        this.f9432c = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.amazonaws.metrics.MetricType, com.amazonaws.util.AWSRequestMetrics$Field] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.amazonaws.util.AWSRequestMetrics] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.jibo.aws.integration.aws.services.file.JiboFileClient] */
    public FileLink uploadFile(String str, File file) throws Throwable {
        Request<UploadFileRequest> requestM9973a;
        UploadFileRequest uploadFileRequest = new UploadFileRequest(str, file);
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(uploadFileRequest);
        ?? awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        ?? r1 = AWSRequestMetrics.Field.ClientExecuteTime;
        awsRequestMetrics.startEvent(r1);
        try {
            try {
                try {
                    awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                } catch (Throwable th) {
                    th = th;
                    endClientExecution(awsRequestMetrics, r1, null, true);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                requestM9973a = new C0873d().m9973a(uploadFileRequest);
                try {
                    requestM9973a.setAWSRequestMetrics(awsRequestMetrics);
                    awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                } catch (Exception e) {
                    e = e;
                    C0977a.m10073a(TAG, "uploadFile", e);
                    awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                }
            } catch (Exception e2) {
                e = e2;
                requestM9973a = null;
            } catch (Throwable th3) {
                th = th3;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                throw th;
            }
            Response responseM9968a = m9968a(requestM9973a, new JsonResponseHandler(new C0870a()), executionContextCreateExecutionContext);
            FileLink fileLink = (FileLink) responseM9968a.getAwsResponse();
            endClientExecution(awsRequestMetrics, requestM9973a, responseM9968a, true);
            return fileLink;
        } catch (Throwable th4) {
            th = th4;
            r1 = 0;
            endClientExecution(awsRequestMetrics, r1, null, true);
            throw th;
        }
    }
}
