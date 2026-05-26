.class Lcom/amazonaws/retry/PredefinedRetryPolicies$SDKDefaultBackoffStrategy;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/amazonaws/retry/RetryPolicy$BackoffStrategy;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazonaws/retry/PredefinedRetryPolicies;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "SDKDefaultBackoffStrategy"
.end annotation


# instance fields
.field private final random:Ljava/util/Random;


# direct methods
.method private constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/Random;

    invoke-direct {v0}, Ljava/util/Random;-><init>()V

    iput-object v0, p0, Lcom/amazonaws/retry/PredefinedRetryPolicies$SDKDefaultBackoffStrategy;->random:Ljava/util/Random;

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazonaws/retry/PredefinedRetryPolicies$1;)V
    .locals 0

    invoke-direct {p0}, Lcom/amazonaws/retry/PredefinedRetryPolicies$SDKDefaultBackoffStrategy;-><init>()V

    return-void
.end method


# virtual methods
.method public final delayBeforeNextRetry(Lcom/amazonaws/AmazonWebServiceRequest;Lcom/amazonaws/AmazonClientException;I)J
    .locals 4

    if-gtz p3, :cond_0

    const-wide/16 v0, 0x0

    :goto_0
    return-wide v0

    :cond_0
    instance-of v0, p2, Lcom/amazonaws/AmazonServiceException;

    if-eqz v0, :cond_1

    check-cast p2, Lcom/amazonaws/AmazonServiceException;

    invoke-static {p2}, Lcom/amazonaws/retry/RetryUtils;->isThrottlingException(Lcom/amazonaws/AmazonServiceException;)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/amazonaws/retry/PredefinedRetryPolicies$SDKDefaultBackoffStrategy;->random:Ljava/util/Random;

    const/16 v1, 0x7d

    invoke-virtual {v0, v1}, Ljava/util/Random;->nextInt(I)I

    move-result v0

    add-int/lit16 v0, v0, 0x1f4

    :goto_1
    const/4 v1, 0x1

    shl-int/2addr v1, p3

    mul-int/2addr v0, v1

    int-to-long v0, v0

    const-wide/16 v2, 0x4e20

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v0

    goto :goto_0

    :cond_1
    const/16 v0, 0x12c

    goto :goto_1
.end method
