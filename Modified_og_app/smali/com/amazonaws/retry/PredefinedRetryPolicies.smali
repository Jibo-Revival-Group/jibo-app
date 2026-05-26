.class public Lcom/amazonaws/retry/PredefinedRetryPolicies;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazonaws/retry/PredefinedRetryPolicies$DynamoDBDefaultBackoffStrategy;,
        Lcom/amazonaws/retry/PredefinedRetryPolicies$SDKDefaultBackoffStrategy;,
        Lcom/amazonaws/retry/PredefinedRetryPolicies$SDKDefaultRetryCondition;
    }
.end annotation


# static fields
.field public static final DEFAULT:Lcom/amazonaws/retry/RetryPolicy;

.field public static final DEFAULT_BACKOFF_STRATEGY:Lcom/amazonaws/retry/RetryPolicy$BackoffStrategy;

.field public static final DEFAULT_RETRY_CONDITION:Lcom/amazonaws/retry/RetryPolicy$RetryCondition;

.field public static final DYNAMODB_DEFAULT:Lcom/amazonaws/retry/RetryPolicy;

.field public static final DYNAMODB_DEFAULT_BACKOFF_STRATEGY:Lcom/amazonaws/retry/RetryPolicy$BackoffStrategy;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    const/4 v1, 0x0

    new-instance v0, Lcom/amazonaws/retry/PredefinedRetryPolicies$SDKDefaultRetryCondition;

    invoke-direct {v0}, Lcom/amazonaws/retry/PredefinedRetryPolicies$SDKDefaultRetryCondition;-><init>()V

    sput-object v0, Lcom/amazonaws/retry/PredefinedRetryPolicies;->DEFAULT_RETRY_CONDITION:Lcom/amazonaws/retry/RetryPolicy$RetryCondition;

    new-instance v0, Lcom/amazonaws/retry/PredefinedRetryPolicies$SDKDefaultBackoffStrategy;

    invoke-direct {v0, v1}, Lcom/amazonaws/retry/PredefinedRetryPolicies$SDKDefaultBackoffStrategy;-><init>(Lcom/amazonaws/retry/PredefinedRetryPolicies$1;)V

    sput-object v0, Lcom/amazonaws/retry/PredefinedRetryPolicies;->DEFAULT_BACKOFF_STRATEGY:Lcom/amazonaws/retry/RetryPolicy$BackoffStrategy;

    new-instance v0, Lcom/amazonaws/retry/PredefinedRetryPolicies$DynamoDBDefaultBackoffStrategy;

    invoke-direct {v0, v1}, Lcom/amazonaws/retry/PredefinedRetryPolicies$DynamoDBDefaultBackoffStrategy;-><init>(Lcom/amazonaws/retry/PredefinedRetryPolicies$1;)V

    sput-object v0, Lcom/amazonaws/retry/PredefinedRetryPolicies;->DYNAMODB_DEFAULT_BACKOFF_STRATEGY:Lcom/amazonaws/retry/RetryPolicy$BackoffStrategy;

    invoke-static {}, Lcom/amazonaws/retry/PredefinedRetryPolicies;->getDefaultRetryPolicy()Lcom/amazonaws/retry/RetryPolicy;

    move-result-object v0

    sput-object v0, Lcom/amazonaws/retry/PredefinedRetryPolicies;->DEFAULT:Lcom/amazonaws/retry/RetryPolicy;

    invoke-static {}, Lcom/amazonaws/retry/PredefinedRetryPolicies;->getDynamoDBDefaultRetryPolicy()Lcom/amazonaws/retry/RetryPolicy;

    move-result-object v0

    sput-object v0, Lcom/amazonaws/retry/PredefinedRetryPolicies;->DYNAMODB_DEFAULT:Lcom/amazonaws/retry/RetryPolicy;

    return-void
.end method

.method public static getDefaultRetryPolicy()Lcom/amazonaws/retry/RetryPolicy;
    .locals 5

    new-instance v0, Lcom/amazonaws/retry/RetryPolicy;

    sget-object v1, Lcom/amazonaws/retry/PredefinedRetryPolicies;->DEFAULT_RETRY_CONDITION:Lcom/amazonaws/retry/RetryPolicy$RetryCondition;

    sget-object v2, Lcom/amazonaws/retry/PredefinedRetryPolicies;->DEFAULT_BACKOFF_STRATEGY:Lcom/amazonaws/retry/RetryPolicy$BackoffStrategy;

    const/4 v3, 0x2

    const/4 v4, 0x1

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazonaws/retry/RetryPolicy;-><init>(Lcom/amazonaws/retry/RetryPolicy$RetryCondition;Lcom/amazonaws/retry/RetryPolicy$BackoffStrategy;IZ)V

    return-object v0
.end method

.method public static getDynamoDBDefaultRetryPolicy()Lcom/amazonaws/retry/RetryPolicy;
    .locals 5

    new-instance v0, Lcom/amazonaws/retry/RetryPolicy;

    sget-object v1, Lcom/amazonaws/retry/PredefinedRetryPolicies;->DEFAULT_RETRY_CONDITION:Lcom/amazonaws/retry/RetryPolicy$RetryCondition;

    sget-object v2, Lcom/amazonaws/retry/PredefinedRetryPolicies;->DYNAMODB_DEFAULT_BACKOFF_STRATEGY:Lcom/amazonaws/retry/RetryPolicy$BackoffStrategy;

    const/4 v3, 0x3

    const/4 v4, 0x1

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazonaws/retry/RetryPolicy;-><init>(Lcom/amazonaws/retry/RetryPolicy$RetryCondition;Lcom/amazonaws/retry/RetryPolicy$BackoffStrategy;IZ)V

    return-object v0
.end method
