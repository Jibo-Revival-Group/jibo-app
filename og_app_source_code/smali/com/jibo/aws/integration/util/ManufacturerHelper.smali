.class public Lcom/jibo/aws/integration/util/ManufacturerHelper;
.super Ljava/lang/Object;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getCredentials(Ljava/lang/String;)Lcom/amazonaws/auth/BasicAWSCredentials;
    .locals 5

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    const-string v1, "stg-entrypoint.jibo.com"

    new-instance v2, Lcom/amazonaws/auth/BasicAWSCredentials;

    const-string v3, "CbSnGI2XHdaFBff9BrjG"

    const-string v4, "bXkdejbgC035uPjkukmKgUjG6bBuWbhkN7NdbNFG"

    invoke-direct {v2, v3, v4}, Lcom/amazonaws/auth/BasicAWSCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "dev-entrypoint.jibo.com"

    new-instance v2, Lcom/amazonaws/auth/BasicAWSCredentials;

    const-string v3, "iHkLSFLiUPecg6vv6GeM"

    const-string v4, "RojePBbRsyNPJAiudu1ecV0lFhsJO0cYhbmc4jM6"

    invoke-direct {v2, v3, v4}, Lcom/amazonaws/auth/BasicAWSCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "api.jibo.com"

    new-instance v2, Lcom/amazonaws/auth/BasicAWSCredentials;

    const-string v3, "fewLRhASX7mvecAY4bk9"

    const-string v4, "ISYyCv7HwFQCZH6JwseCM5oYKCJ2iEwkbCBxVkCC"

    invoke-direct {v2, v3, v4}, Lcom/amazonaws/auth/BasicAWSCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "https://jibo-dev.ling.cn"

    new-instance v2, Lcom/amazonaws/auth/BasicAWSCredentials;

    const-string v3, "AKIAODFZEA2U6RO7ZHYA"

    const-string v4, "ImM9prQKwG5VmplyPgk3MkBfMuly9km+qZcn6AV7"

    invoke-direct {v2, v3, v4}, Lcom/amazonaws/auth/BasicAWSCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v1, "https://jibo.ling.cn"

    new-instance v2, Lcom/amazonaws/auth/BasicAWSCredentials;

    const-string v3, "AKIAODFZEA2U6RO7ZHYA"

    const-string v4, "ImM9prQKwG5VmplyPgk3MkBfMuly9km+qZcn6AV7"

    invoke-direct {v2, v3, v4}, Lcom/amazonaws/auth/BasicAWSCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazonaws/auth/BasicAWSCredentials;

    return-object v0
.end method
