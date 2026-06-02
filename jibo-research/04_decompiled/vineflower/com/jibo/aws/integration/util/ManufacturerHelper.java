package com.jibo.aws.integration.util;

import com.amazonaws.auth.BasicAWSCredentials;
import java.util.HashMap;

public class ManufacturerHelper {
   public static BasicAWSCredentials getCredentials(String var0) {
      HashMap var1 = new HashMap();
      var1.put("stg-entrypoint.jibo.com", new BasicAWSCredentials("CbSnGI2XHdaFBff9BrjG", "bXkdejbgC035uPjkukmKgUjG6bBuWbhkN7NdbNFG"));
      var1.put("dev-entrypoint.jibo.com", new BasicAWSCredentials("iHkLSFLiUPecg6vv6GeM", "RojePBbRsyNPJAiudu1ecV0lFhsJO0cYhbmc4jM6"));
      var1.put("api.jibo.com", new BasicAWSCredentials("fewLRhASX7mvecAY4bk9", "ISYyCv7HwFQCZH6JwseCM5oYKCJ2iEwkbCBxVkCC"));
      var1.put("https://jibo-dev.ling.cn", new BasicAWSCredentials("AKIAODFZEA2U6RO7ZHYA", "ImM9prQKwG5VmplyPgk3MkBfMuly9km+qZcn6AV7"));
      var1.put("https://jibo.ling.cn", new BasicAWSCredentials("AKIAODFZEA2U6RO7ZHYA", "ImM9prQKwG5VmplyPgk3MkBfMuly9km+qZcn6AV7"));
      return (BasicAWSCredentials)var1.get(var0);
   }
}
