.class public interface abstract Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;
.super Ljava/lang/Object;
.source "LiveAgentRequest.java"


# static fields
.field public static final a:Lokhttp3/MediaType;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 46
    const-string v0, "application/json; charset=utf-8"

    invoke-static {v0}, Lokhttp3/MediaType;->a(Ljava/lang/String;)Lokhttp3/MediaType;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;->a:Lokhttp3/MediaType;

    return-void
.end method


# virtual methods
.method public abstract a(Ljava/lang/String;Lcom/google/gson/Gson;I)Lcom/salesforce/android/service/common/http/HttpRequest;
.end method

.method public abstract a(Lcom/google/gson/Gson;)Ljava/lang/String;
.end method

.method public abstract a(Ljava/lang/String;)Ljava/lang/String;
.end method
