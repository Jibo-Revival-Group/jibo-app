package com.amazonaws.auth;

import com.amazonaws.Request;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.HttpUtils;
import com.jibo.aws.integration.util.C0977a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class AWS3Signer extends AbstractAWSSigner {
    public static final String TAG = C0977a.m10070a(AWS3Signer.class);
    private String overriddenDate;

    private String getSignedHeadersComponent(Request<?> request) {
        StringBuilder sb = new StringBuilder();
        sb.append("SignedHeaders=");
        boolean z = true;
        Iterator<String> it = getHeadersForStringToSign(request).iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return sb.toString();
            }
            String next = it.next();
            if (!z2) {
                sb.append(";");
            }
            sb.append(next);
            z = false;
        }
    }

    @Override // com.amazonaws.auth.AbstractAWSSigner
    protected void addSessionCredentials(Request<?> request, AWSSessionCredentials aWSSessionCredentials) {
        request.addHeader("x-amz-security-token", aWSSessionCredentials.getSessionToken());
    }

    protected String getCanonicalizedHeadersForStringToSign(Request<?> request) {
        List<String> headersForStringToSign = getHeadersForStringToSign(request);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= headersForStringToSign.size()) {
                break;
            }
            headersForStringToSign.set(i2, headersForStringToSign.get(i2).toLowerCase());
            i = i2 + 1;
        }
        TreeMap treeMap = new TreeMap();
        for (Map.Entry<String, String> entry : request.getHeaders().entrySet()) {
            if (headersForStringToSign.contains(entry.getKey().toLowerCase())) {
                treeMap.put(entry.getKey().toLowerCase(), entry.getValue());
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry2 : treeMap.entrySet()) {
            sb.append(((String) entry2.getKey()).toLowerCase()).append(":").append((String) entry2.getValue()).append("\n");
        }
        return sb.toString();
    }

    protected List<String> getHeadersForStringToSign(Request<?> request) {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, String>> it = request.getHeaders().entrySet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            String lowerCase = key.toLowerCase();
            if (lowerCase.startsWith("x-amz") || lowerCase.equals("host")) {
                arrayList.add(key);
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    @Override // com.amazonaws.auth.Signer
    public void sign(Request<?> request, AWSCredentials aWSCredentials) {
        if (aWSCredentials instanceof AnonymousAWSCredentials) {
            return;
        }
        AWSCredentials aWSCredentialsSanitizeCredentials = sanitizeCredentials(aWSCredentials);
        SigningAlgorithm signingAlgorithm = SigningAlgorithm.HmacSHA256;
        UUID.randomUUID().toString();
        String rFC822Date = DateUtils.formatRFC822Date(getSignatureDate(getTimeOffset(request)));
        if (this.overriddenDate != null) {
            rFC822Date = this.overriddenDate;
        }
        request.addHeader("Date", rFC822Date);
        request.addHeader("X-Amz-Date", rFC822Date);
        String host = request.getEndpoint().getHost();
        if (HttpUtils.isUsingNonDefaultPort(request.getEndpoint())) {
            host = host + ":" + request.getEndpoint().getPort();
        }
        request.addHeader("Host", host);
        if (aWSCredentialsSanitizeCredentials instanceof AWSSessionCredentials) {
            addSessionCredentials(request, (AWSSessionCredentials) aWSCredentialsSanitizeCredentials);
        }
        String str = request.getHttpMethod().toString() + "\n" + getCanonicalizedResourcePath(HttpUtils.appendUri(request.getEndpoint().getPath(), request.getResourcePath())) + "\n" + getCanonicalizedQueryString(request.getParameters()) + "\n" + getCanonicalizedHeadersForStringToSign(request) + "\n" + getRequestPayloadWithoutQueryParams(request);
        byte[] bArrHash = hash(str);
        C0977a.m10072a(TAG, "Calculated StringToSign: " + str);
        String strSignAndBase64Encode = signAndBase64Encode(bArrHash, aWSCredentialsSanitizeCredentials.getAWSSecretKey(), signingAlgorithm);
        StringBuilder sb = new StringBuilder();
        sb.append("AWS3").append(" ");
        sb.append("AWSAccessKeyId=" + aWSCredentialsSanitizeCredentials.getAWSAccessKeyId() + ",");
        sb.append("Algorithm=" + signingAlgorithm.toString() + ",");
        sb.append(getSignedHeadersComponent(request) + ",");
        sb.append("Signature=" + strSignAndBase64Encode);
        request.addHeader("X-Amzn-Authorization", sb.toString());
    }
}
