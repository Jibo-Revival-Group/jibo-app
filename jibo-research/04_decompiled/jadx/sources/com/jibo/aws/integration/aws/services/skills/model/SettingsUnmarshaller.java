package com.jibo.aws.integration.aws.services.skills.model;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import java.io.BufferedReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class SettingsUnmarshaller implements Unmarshaller<String, JsonUnmarshallerContext> {
    private static SettingsUnmarshaller instance;

    public static SettingsUnmarshaller getInstance() {
        if (instance == null) {
            instance = new SettingsUnmarshaller();
        }
        return instance;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public String unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(jsonUnmarshallerContext.getReader().getReader());
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return sb.toString();
            }
            sb.append(line);
        }
    }
}
