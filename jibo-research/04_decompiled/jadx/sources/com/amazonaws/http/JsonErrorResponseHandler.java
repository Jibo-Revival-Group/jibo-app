package com.amazonaws.http;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.amazonaws.util.json.JsonUtils;
import com.facebook.share.internal.ShareConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class JsonErrorResponseHandler implements HttpResponseHandler<AmazonServiceException> {
    private final List<? extends JsonErrorUnmarshaller> unmarshallerList;

    public static class JsonErrorResponse {
        private final String errorCode;
        private final Map<String, String> map;
        private final String message = get(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        private final int statusCode;

        private JsonErrorResponse(int i, String str, Map<String, String> map) {
            this.statusCode = i;
            this.errorCode = str;
            this.map = map;
        }

        public static JsonErrorResponse fromResponse(HttpResponse httpResponse) {
            Map<String, String> map;
            int statusCode = httpResponse.getStatusCode();
            try {
                map = JsonUtils.jsonToMap(new BufferedReader(new InputStreamReader(httpResponse.getContent())));
            } catch (Exception e) {
                map = new HashMap();
            }
            String statusText = httpResponse.getStatusText();
            if (map.containsKey("code")) {
                statusText = map.get("code");
            } else if (map.containsKey("error")) {
                statusText = map.get("error");
            }
            return new JsonErrorResponse(statusCode, statusText, map);
        }

        public String get(String str) {
            if (str == null || str.length() == 0) {
                return null;
            }
            String str2 = str.substring(0, 1).toLowerCase() + str.substring(1);
            String str3 = str.substring(0, 1).toUpperCase() + str.substring(1);
            return this.map.containsKey(str3) ? this.map.get(str3) : this.map.containsKey(str2) ? this.map.get(str2) : "";
        }

        public String getErrorCode() {
            return this.errorCode;
        }

        public String getMessage() {
            return this.message;
        }

        public int getStatusCode() {
            return this.statusCode;
        }
    }

    public JsonErrorResponseHandler(List<? extends JsonErrorUnmarshaller> list) {
        this.unmarshallerList = list;
    }

    private AmazonServiceException runErrorUnmarshallers(JsonErrorResponse jsonErrorResponse) {
        for (JsonErrorUnmarshaller jsonErrorUnmarshaller : this.unmarshallerList) {
            if (jsonErrorUnmarshaller.match(jsonErrorResponse)) {
                return jsonErrorUnmarshaller.unmarshall(jsonErrorResponse);
            }
        }
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.amazonaws.http.HttpResponseHandler
    public AmazonServiceException handle(HttpResponse httpResponse) {
        try {
            JsonErrorResponse jsonErrorResponseFromResponse = JsonErrorResponse.fromResponse(httpResponse);
            AmazonServiceException amazonServiceExceptionRunErrorUnmarshallers = runErrorUnmarshallers(jsonErrorResponseFromResponse);
            if (amazonServiceExceptionRunErrorUnmarshallers == null) {
                return null;
            }
            amazonServiceExceptionRunErrorUnmarshallers.setStatusCode(httpResponse.getStatusCode());
            if (httpResponse.getStatusCode() < 500) {
                amazonServiceExceptionRunErrorUnmarshallers.setErrorType(AmazonServiceException.ErrorType.Client);
            } else {
                amazonServiceExceptionRunErrorUnmarshallers.setErrorType(AmazonServiceException.ErrorType.Service);
            }
            amazonServiceExceptionRunErrorUnmarshallers.setErrorCode(jsonErrorResponseFromResponse.getErrorCode());
            for (Map.Entry<String, String> entry : httpResponse.getHeaders().entrySet()) {
                if (entry.getKey().equalsIgnoreCase("X-Amzn-RequestId")) {
                    amazonServiceExceptionRunErrorUnmarshallers.setRequestId(entry.getValue());
                }
            }
            return amazonServiceExceptionRunErrorUnmarshallers;
        } catch (IOException e) {
            throw new AmazonClientException("Unable to parse error response", e);
        }
    }

    @Override // com.amazonaws.http.HttpResponseHandler
    public boolean needsConnectionLeftOpen() {
        return false;
    }
}
