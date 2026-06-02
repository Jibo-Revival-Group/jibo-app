package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.util.AwsHostNameUtils;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.HttpUtils;
import com.jibo.aws.integration.util.C0977a;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import org.apache.http.HttpHeaders;

/* JADX INFO: loaded from: classes.dex */
public class AWS4Signer extends AbstractAWSSigner implements RegionAwareSigner, ServiceAwareSigner {
    public static final String TAG = C0977a.m10070a(AWS4Signer.class);
    protected boolean doubleUrlEncode;
    protected Date overriddenDate;
    protected String regionName;
    protected String serviceName;

    protected static class HeaderSigningResult {
        private String dateTime;
        private byte[] kSigning;
        private String scope;
        private byte[] signature;

        public HeaderSigningResult(String str, String str2, byte[] bArr, byte[] bArr2) {
            this.dateTime = str;
            this.scope = str2;
            this.kSigning = bArr;
            this.signature = bArr2;
        }

        public byte[] getSignature() {
            byte[] bArr = new byte[this.signature.length];
            System.arraycopy(this.signature, 0, bArr, 0, this.signature.length);
            return bArr;
        }
    }

    public AWS4Signer() {
        this(true);
    }

    public AWS4Signer(boolean z) {
        this.doubleUrlEncode = z;
    }

    protected void addHostHeader(Request<?> request) {
        String host = request.getEndpoint().getHost();
        if (HttpUtils.isUsingNonDefaultPort(request.getEndpoint())) {
            host = host + ":" + request.getEndpoint().getPort();
        }
        request.addHeader("Host", host);
    }

    @Override // com.amazonaws.auth.AbstractAWSSigner
    protected void addSessionCredentials(Request<?> request, AWSSessionCredentials aWSSessionCredentials) {
        request.addHeader("x-amz-security-token", aWSSessionCredentials.getSessionToken());
    }

    protected String calculateContentHash(Request<?> request) {
        if (request.getHeaders().get("Content-Type") != null && request.getHeaders().get("Content-Type").startsWith("multipart")) {
            return "UNSIGNED-PAYLOAD";
        }
        if (request.getHeaders().get("x-path") != null || request.getHeaders().get("x-key") != null || !request.getContent().markSupported()) {
            return "STREAMING-AWS4-HMAC-SHA256-PAYLOAD";
        }
        InputStream binaryRequestPayloadStream = getBinaryRequestPayloadStream(request);
        binaryRequestPayloadStream.mark(-1);
        String hex = BinaryUtils.toHex(hash(binaryRequestPayloadStream));
        try {
            binaryRequestPayloadStream.reset();
            return hex;
        } catch (IOException e) {
            throw new AmazonClientException("Unable to reset stream after calculating AWS4 signature", e);
        }
    }

    protected final HeaderSigningResult computeSignature(Request<?> request, String str, String str2, String str3, String str4, AWSCredentials aWSCredentials) {
        String strExtractRegionName = extractRegionName(request.getEndpoint());
        String strExtractServiceName = extractServiceName(request.getEndpoint());
        String str5 = str + "/" + strExtractRegionName + "/" + strExtractServiceName + "/aws4_request";
        String stringToSign = getStringToSign(str3, str2, str5, getCanonicalRequest(request, str4));
        byte[] bArrSign = sign("aws4_request", sign(strExtractServiceName, sign(strExtractRegionName, sign(str, ("AWS4" + aWSCredentials.getAWSSecretKey()).getBytes(), SigningAlgorithm.HmacSHA256), SigningAlgorithm.HmacSHA256), SigningAlgorithm.HmacSHA256), SigningAlgorithm.HmacSHA256);
        return new HeaderSigningResult(str2, str5, bArrSign, sign(stringToSign.getBytes(), bArrSign, SigningAlgorithm.HmacSHA256));
    }

    protected String extractRegionName(URI uri) {
        return this.regionName != null ? this.regionName : AwsHostNameUtils.parseRegionName(uri.getHost(), this.serviceName);
    }

    protected String extractServiceName(URI uri) {
        return this.serviceName != null ? this.serviceName : AwsHostNameUtils.parseServiceName(uri);
    }

    protected String getCanonicalRequest(Request<?> request, String str) {
        String str2 = request.getHttpMethod().toString() + "\n" + getCanonicalizedResourcePath(HttpUtils.appendUri(request.getEndpoint().getPath(), request.getResourcePath()), this.doubleUrlEncode) + "\n" + getCanonicalizedQueryString(request) + "\n" + getCanonicalizedHeaderString(request) + "\n" + getSignedHeadersString(request) + "\n" + str;
        C0977a.m10072a(TAG, "AWS4 Canonical Request: '\"" + str2 + "\"");
        return str2;
    }

    protected String getCanonicalizedHeaderString(Request<?> request) {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.addAll(request.getHeaders().keySet());
        Collections.sort(arrayList, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for (String str : arrayList) {
            if (needsSign(str)) {
                String strReplaceAll = str.toLowerCase().replaceAll("\\s+", " ");
                String str2 = request.getHeaders().get(str);
                sb.append(strReplaceAll).append(":");
                if (str2 != null) {
                    sb.append(str2.replaceAll("\\s+", " "));
                }
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    protected final long getDateFromRequest(Request<?> request) {
        Date signatureDate = getSignatureDate(getTimeOffset(request));
        if (this.overriddenDate != null) {
            signatureDate = this.overriddenDate;
        }
        return signatureDate.getTime();
    }

    protected final String getDateStamp(long j) {
        return DateUtils.format("yyyyMMdd", new Date(j));
    }

    protected String getScope(Request<?> request, String str) {
        return str + "/" + extractRegionName(request.getEndpoint()) + "/" + extractServiceName(request.getEndpoint()) + "/aws4_request";
    }

    protected String getSignedHeadersString(Request<?> request) {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.addAll(request.getHeaders().keySet());
        Collections.sort(arrayList, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for (String str : arrayList) {
            if (needsSign(str)) {
                if (sb.length() > 0) {
                    sb.append(";");
                }
                sb.append(str.toLowerCase());
            }
        }
        return sb.toString();
    }

    protected String getStringToSign(String str, String str2, String str3, String str4) {
        String str5 = str + "\n" + str2 + "\n" + str3 + "\n" + BinaryUtils.toHex(hash(str4));
        C0977a.m10072a(TAG, "AWS4 String to Sign: '\"" + str5 + "\"");
        return str5;
    }

    protected final String getTimeStamp(long j) {
        return DateUtils.format("yyyyMMdd'T'HHmmss'Z'", new Date(j));
    }

    boolean needsSign(String str) {
        return str.equalsIgnoreCase("date") || str.equalsIgnoreCase(HttpHeaders.CONTENT_MD5) || str.equalsIgnoreCase("host") || str.startsWith("x-amz") || str.startsWith("X-Amz");
    }

    protected void processRequestPayload(Request<?> request, HeaderSigningResult headerSigningResult) {
    }

    @Override // com.amazonaws.auth.RegionAwareSigner
    public void setRegionName(String str) {
        this.regionName = str;
    }

    @Override // com.amazonaws.auth.ServiceAwareSigner
    public void setServiceName(String str) {
        this.serviceName = str;
    }

    @Override // com.amazonaws.auth.Signer
    public void sign(Request<?> request, AWSCredentials aWSCredentials) {
        if (aWSCredentials instanceof AnonymousAWSCredentials) {
            return;
        }
        AWSCredentials aWSCredentialsSanitizeCredentials = sanitizeCredentials(aWSCredentials);
        if (aWSCredentialsSanitizeCredentials instanceof AWSSessionCredentials) {
            addSessionCredentials(request, (AWSSessionCredentials) aWSCredentialsSanitizeCredentials);
        }
        addHostHeader(request);
        long dateFromRequest = getDateFromRequest(request);
        String dateStamp = getDateStamp(dateFromRequest);
        String scope = getScope(request, dateStamp);
        String strCalculateContentHash = calculateContentHash(request);
        String timeStamp = getTimeStamp(dateFromRequest);
        request.addHeader("X-Amz-Date", timeStamp);
        if (request.getHeaders().get("x-amz-content-sha256") != null && request.getHeaders().get("x-amz-content-sha256").equals("required")) {
            request.addHeader("x-amz-content-sha256", strCalculateContentHash);
        }
        String str = aWSCredentialsSanitizeCredentials.getAWSAccessKeyId() + "/" + scope;
        HeaderSigningResult headerSigningResultComputeSignature = computeSignature(request, dateStamp, timeStamp, "AWS4-HMAC-SHA256", strCalculateContentHash, aWSCredentialsSanitizeCredentials);
        request.addHeader(HttpHeaders.AUTHORIZATION, "AWS4-HMAC-SHA256 " + ("Credential=" + str) + ", " + ("SignedHeaders=" + getSignedHeadersString(request)) + ", " + ("Signature=" + BinaryUtils.toHex(headerSigningResultComputeSignature.getSignature())));
        processRequestPayload(request, headerSigningResultComputeSignature);
    }
}
