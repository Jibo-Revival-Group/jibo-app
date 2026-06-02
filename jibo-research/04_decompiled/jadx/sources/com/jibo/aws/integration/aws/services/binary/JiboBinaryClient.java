package com.jibo.aws.integration.aws.services.binary;

import android.content.Context;
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
import com.jibo.aws.integration.aws.services.binary.model.BinaryLink;
import com.jibo.aws.integration.aws.services.binary.model.CreateBinaryRequest;
import com.jibo.aws.integration.aws.services.binary.model.GetBinaryRequest;
import com.jibo.aws.integration.aws.services.binary.model.ListBinaryRequest;
import com.jibo.aws.integration.aws.services.binary.model.PathRequest;
import com.jibo.aws.integration.aws.services.binary.model.RemoveBinaryRequest;
import com.jibo.aws.integration.aws.services.binary.model.p003a.C0844a;
import com.jibo.aws.integration.aws.services.binary.model.p003a.C0845b;
import com.jibo.aws.integration.aws.services.binary.model.p003a.C0846c;
import com.jibo.aws.integration.aws.services.binary.model.p003a.C0847d;
import com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract;
import com.jibo.aws.integration.aws.services.exception.ResourceNotFoundException;
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
import com.jibo.aws.integration.util.C0977a;
import com.jibo.aws.integration.util.Commons;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.entity.mime.MIME;

/* JADX INFO: loaded from: classes.dex */
public class JiboBinaryClient extends AmazonWebServiceClient {
    public static final String TAG = C0977a.m10070a(JiboBinaryClient.class);

    /* JADX INFO: renamed from: a */
    protected List<JsonErrorUnmarshaller> f9402a;

    /* JADX INFO: renamed from: b */
    protected String f9403b;

    /* JADX INFO: renamed from: c */
    protected String f9404c;

    /* JADX INFO: renamed from: d */
    private AWSCredentialsProvider f9405d;

    @Deprecated
    public JiboBinaryClient() {
        this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    @Deprecated
    public JiboBinaryClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    public JiboBinaryClient(AWSCredentials aWSCredentials) {
        this(aWSCredentials, new ClientConfiguration());
    }

    public JiboBinaryClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        this(new StaticCredentialsProvider(aWSCredentials), clientConfiguration);
    }

    public JiboBinaryClient(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, new ClientConfiguration());
    }

    public JiboBinaryClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        this(aWSCredentialsProvider, clientConfiguration, new UrlHttpClient(clientConfiguration));
    }

    public JiboBinaryClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(m9948a(clientConfiguration), httpClient);
        this.f9403b = MIME.ENC_BINARY;
        this.f9404c = Commons.TARGET_PREFIX_BINARY;
        this.f9405d = aWSCredentialsProvider;
        m9950a();
    }

    @Deprecated
    public JiboBinaryClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, RequestMetricCollector requestMetricCollector) {
        super(m9948a(clientConfiguration), requestMetricCollector);
        this.f9403b = MIME.ENC_BINARY;
        this.f9404c = Commons.TARGET_PREFIX_BINARY;
        this.f9405d = aWSCredentialsProvider;
        m9950a();
    }

    /* JADX INFO: renamed from: a */
    private static ClientConfiguration m9948a(ClientConfiguration clientConfiguration) {
        return clientConfiguration;
    }

    /* JADX INFO: renamed from: a */
    private <X, Y extends AmazonWebServiceRequest> Response<X> m9949a(Request<Y> request, HttpResponseHandler<AmazonWebServiceResponse<X>> httpResponseHandler, ExecutionContext executionContext) {
        request.setEndpoint(this.endpoint);
        request.setTimeOffset(this.timeOffset);
        if (!TextUtils.isEmpty(this.f9404c)) {
            String str = request.getHeaders().get("X-Amz-Target");
            if (!TextUtils.isEmpty(str)) {
                request.getHeaders().put("X-Amz-Target", str.replace(Commons.TARGET_PREFIX_PLACEHOLDER, this.f9404c));
            }
        }
        if (!TextUtils.isEmpty(this.f9403b)) {
            request.setServiceName(this.f9403b);
        }
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.CredentialsRequestTime);
        try {
            AWSCredentials credentials = this.f9405d.getCredentials();
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.CredentialsRequestTime);
            AmazonWebServiceRequest originalRequest = request.getOriginalRequest();
            if (originalRequest != null && originalRequest.getRequestCredentials() != null) {
                credentials = originalRequest.getRequestCredentials();
            }
            executionContext.setCredentials(credentials);
            return this.client.execute(request, httpResponseHandler, new JsonErrorResponseHandler(this.f9402a), executionContext);
        } catch (Throwable th) {
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.CredentialsRequestTime);
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m9950a() {
        this.f9402a = new ArrayList();
        this.f9402a.add(new C0863h());
        this.f9402a.add(new C0859d());
        this.f9402a.add(new C0856a());
        this.f9402a.add(new C0857b());
        this.f9402a.add(new C0858c());
        this.f9402a.add(new C0860e());
        this.f9402a.add(new C0861f());
        this.f9402a.add(new C0862g());
        this.f9402a.add(new C0864i());
        this.f9402a.add(new C0865j());
        this.f9402a.add(new C0865j());
        this.f9402a.add(new JsonErrorUnmarshaller());
        setEndpoint(Commons.ROOT_ENDPOINT);
        new HandlerChainFactory();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006b A[Catch: IOException -> 0x00d7, TRY_LEAVE, TryCatch #0 {IOException -> 0x00d7, blocks: (B:14:0x0066, B:16:0x006b), top: B:54:0x0066 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.io.File downloadFileFromUrl(java.lang.String r13, java.io.File r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jibo.aws.integration.aws.services.binary.JiboBinaryClient.downloadFileFromUrl(java.lang.String, java.io.File):java.io.File");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.amazonaws.metrics.MetricType, com.amazonaws.util.AWSRequestMetrics$Field] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.amazonaws.util.AWSRequestMetrics] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.jibo.aws.integration.aws.services.binary.JiboBinaryClient] */
    public BinaryLink create(String str, File file, Map<String, String> map) throws Throwable {
        Request<JiboRequestAbstract> requestMo9956a;
        CreateBinaryRequest createBinaryRequest = new CreateBinaryRequest(str, file, map);
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(createBinaryRequest);
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
                requestMo9956a = new C0846c().mo9956a(createBinaryRequest);
                try {
                    requestMo9956a.setAWSRequestMetrics(awsRequestMetrics);
                    awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                } catch (Exception e) {
                    e = e;
                    C0977a.m10073a(TAG, "uploadFile", e);
                    awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                }
            } catch (Exception e2) {
                e = e2;
                requestMo9956a = null;
            } catch (Throwable th3) {
                th = th3;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                throw th;
            }
            Response responseM9949a = m9949a(requestMo9956a, new JsonResponseHandler(new C0844a()), executionContextCreateExecutionContext);
            BinaryLink binaryLink = (BinaryLink) responseM9949a.getAwsResponse();
            endClientExecution(awsRequestMetrics, requestMo9956a, responseM9949a, true);
            return binaryLink;
        } catch (Throwable th4) {
            th = th4;
            r1 = 0;
            endClientExecution(awsRequestMetrics, r1, null, true);
            throw th;
        }
    }

    public BinaryLink get(Context context, String str) throws Throwable {
        BinaryLink binaryLink = get(str);
        if (binaryLink == null || TextUtils.isEmpty(binaryLink.getUrl())) {
            throw new ResourceNotFoundException(str);
        }
        try {
            binaryLink.setFile(downloadFileFromUrl(binaryLink.getUrl(), File.createTempFile("BIN", "bin", context.getCacheDir())));
            return binaryLink;
        } catch (Exception e) {
            throw new ResourceNotFoundException(str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.amazonaws.metrics.MetricType, com.amazonaws.util.AWSRequestMetrics$Field] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.amazonaws.util.AWSRequestMetrics] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.jibo.aws.integration.aws.services.binary.JiboBinaryClient] */
    public BinaryLink get(String str) throws Throwable {
        Request<PathRequest> requestM9957a;
        GetBinaryRequest getBinaryRequest = new GetBinaryRequest(str);
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(getBinaryRequest);
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
                requestM9957a = new C0847d().m9957a(getBinaryRequest);
                try {
                    requestM9957a.setAWSRequestMetrics(awsRequestMetrics);
                    awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                } catch (Exception e) {
                    e = e;
                    C0977a.m10073a(TAG, "removeFile", e);
                    awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                }
            } catch (Exception e2) {
                e = e2;
                requestM9957a = null;
            } catch (Throwable th3) {
                th = th3;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                throw th;
            }
            Response responseM9949a = m9949a(requestM9957a, new JsonResponseHandler(new C0844a()), executionContextCreateExecutionContext);
            BinaryLink binaryLink = (BinaryLink) responseM9949a.getAwsResponse();
            endClientExecution(awsRequestMetrics, requestM9957a, responseM9949a, true);
            return binaryLink;
        } catch (Throwable th4) {
            th = th4;
            r1 = 0;
            endClientExecution(awsRequestMetrics, r1, null, true);
            throw th;
        }
    }

    public BinaryLink get(String str, String str2) throws Throwable {
        BinaryLink binaryLink = get(str);
        if (binaryLink == null || TextUtils.isEmpty(binaryLink.getUrl())) {
            throw new ResourceNotFoundException(str);
        }
        try {
            binaryLink.setFile(downloadFileFromUrl(binaryLink.getUrl(), new File(str2)));
            return binaryLink;
        } catch (Exception e) {
            throw new ResourceNotFoundException(str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.amazonaws.metrics.MetricType, com.amazonaws.util.AWSRequestMetrics$Field] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.amazonaws.util.AWSRequestMetrics] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.jibo.aws.integration.aws.services.binary.JiboBinaryClient] */
    public List<BinaryLink> list(String str) throws Throwable {
        Request<PathRequest> requestM9957a;
        ListBinaryRequest listBinaryRequest = new ListBinaryRequest(str);
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(listBinaryRequest);
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
                requestM9957a = new C0847d().m9957a(listBinaryRequest);
                try {
                    requestM9957a.setAWSRequestMetrics(awsRequestMetrics);
                    awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                } catch (Exception e) {
                    e = e;
                    C0977a.m10073a(TAG, "listFiles", e);
                    awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                }
            } catch (Exception e2) {
                e = e2;
                requestM9957a = null;
            } catch (Throwable th3) {
                th = th3;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                throw th;
            }
            Response responseM9949a = m9949a(requestM9957a, new JsonResponseHandler(new C0845b()), executionContextCreateExecutionContext);
            List<BinaryLink> list = (List) responseM9949a.getAwsResponse();
            endClientExecution(awsRequestMetrics, requestM9957a, responseM9949a, true);
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
    /* JADX WARN: Type inference failed for: r8v0, types: [com.jibo.aws.integration.aws.services.binary.JiboBinaryClient] */
    public BinaryLink remove(String str) throws Throwable {
        Request<PathRequest> requestM9957a;
        RemoveBinaryRequest removeBinaryRequest = new RemoveBinaryRequest(str);
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(removeBinaryRequest);
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
                requestM9957a = new C0847d().m9957a(removeBinaryRequest);
                try {
                    requestM9957a.setAWSRequestMetrics(awsRequestMetrics);
                    awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                } catch (Exception e) {
                    e = e;
                    C0977a.m10073a(TAG, "removeFile", e);
                    awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                }
            } catch (Exception e2) {
                e = e2;
                requestM9957a = null;
            } catch (Throwable th3) {
                th = th3;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                throw th;
            }
            Response responseM9949a = m9949a(requestM9957a, new JsonResponseHandler(new C0844a()), executionContextCreateExecutionContext);
            BinaryLink binaryLink = (BinaryLink) responseM9949a.getAwsResponse();
            endClientExecution(awsRequestMetrics, requestM9957a, responseM9949a, true);
            return binaryLink;
        } catch (Throwable th4) {
            th = th4;
            r1 = 0;
            endClientExecution(awsRequestMetrics, r1, null, true);
            throw th;
        }
    }

    public void setServiceType(String str, String str2) {
        this.f9403b = str;
        this.f9404c = str2;
    }
}
