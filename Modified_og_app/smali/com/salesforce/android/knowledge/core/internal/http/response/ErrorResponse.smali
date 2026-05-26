.class public Lcom/salesforce/android/knowledge/core/internal/http/response/ErrorResponse;
.super Ljava/lang/Object;
.source "ErrorResponse.java"


# static fields
.field private static a:Ljava/lang/String;

.field private static b:Ljava/lang/String;


# instance fields
.field private mErrorCode:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "errorCode"
    .end annotation
.end field

.field private mMessage:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "message"
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 31
    const-string v0, "INVALID_FILTER_LANGUAGE"

    sput-object v0, Lcom/salesforce/android/knowledge/core/internal/http/response/ErrorResponse;->a:Ljava/lang/String;

    .line 33
    const-string v0, "ILLEGAL_QUERY_PARAMETER_VALUE"

    sput-object v0, Lcom/salesforce/android/knowledge/core/internal/http/response/ErrorResponse;->b:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    const-string v0, ""

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/response/ErrorResponse;->mErrorCode:Ljava/lang/String;

    .line 36
    const-string v0, ""

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/response/ErrorResponse;->mMessage:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public a()Z
    .locals 2

    .prologue
    .line 47
    sget-object v0, Lcom/salesforce/android/knowledge/core/internal/http/response/ErrorResponse;->a:Ljava/lang/String;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/internal/http/response/ErrorResponse;->mErrorCode:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Lcom/salesforce/android/knowledge/core/internal/http/response/ErrorResponse;->b:Ljava/lang/String;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/internal/http/response/ErrorResponse;->mErrorCode:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method
