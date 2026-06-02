package com.jibo.aws.integration.util;

import com.amazonaws.auth.BasicAWSCredentials;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class ManufacturerHelper {
    public static BasicAWSCredentials getCredentials(String str) {
        HashMap map = new HashMap();
        map.put(Commons.STG_ENDPOINT, new BasicAWSCredentials("CbSnGI2XHdaFBff9BrjG", "bXkdejbgC035uPjkukmKgUjG6bBuWbhkN7NdbNFG"));
        map.put(Commons.DEV_ENDPOINT, new BasicAWSCredentials("iHkLSFLiUPecg6vv6GeM", "RojePBbRsyNPJAiudu1ecV0lFhsJO0cYhbmc4jM6"));
        map.put(Commons.API_ENDPOINT, new BasicAWSCredentials("fewLRhASX7mvecAY4bk9", "ISYyCv7HwFQCZH6JwseCM5oYKCJ2iEwkbCBxVkCC"));
        map.put(Commons.NETPOSA_1_ENDPOINT, new BasicAWSCredentials("AKIAODFZEA2U6RO7ZHYA", "ImM9prQKwG5VmplyPgk3MkBfMuly9km+qZcn6AV7"));
        map.put(Commons.NETPOSA_2_ENDPOINT, new BasicAWSCredentials("AKIAODFZEA2U6RO7ZHYA", "ImM9prQKwG5VmplyPgk3MkBfMuly9km+qZcn6AV7"));
        return (BasicAWSCredentials) map.get(str);
    }
}
