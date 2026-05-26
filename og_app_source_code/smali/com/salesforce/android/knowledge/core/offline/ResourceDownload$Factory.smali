.class Lcom/salesforce/android/knowledge/core/offline/ResourceDownload$Factory;
.super Ljava/lang/Object;
.source "ResourceDownload.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/core/offline/ResourceDownload;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Factory"
.end annotation


# instance fields
.field private final a:Lcom/salesforce/android/service/common/http/HttpClient;


# direct methods
.method constructor <init>(Lcom/salesforce/android/service/common/http/HttpClient;)V
    .locals 0

    .prologue
    .line 84
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 85
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/offline/ResourceDownload$Factory;->a:Lcom/salesforce/android/service/common/http/HttpClient;

    .line 86
    return-void
.end method


# virtual methods
.method a(Ljava/lang/String;)Lcom/salesforce/android/knowledge/core/offline/ResourceDownload;
    .locals 2

    .prologue
    .line 89
    new-instance v0, Lcom/salesforce/android/knowledge/core/offline/ResourceDownload;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/offline/ResourceDownload$Factory;->a:Lcom/salesforce/android/service/common/http/HttpClient;

    invoke-direct {v0, p1, v1}, Lcom/salesforce/android/knowledge/core/offline/ResourceDownload;-><init>(Ljava/lang/String;Lcom/salesforce/android/service/common/http/HttpClient;)V

    return-object v0
.end method
