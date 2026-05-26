.class public Lcom/salesforce/android/knowledge/core/internal/http/HttpService$JobFactory;
.super Ljava/lang/Object;
.source "HttpService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/core/internal/http/HttpService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "JobFactory"
.end annotation


# static fields
.field public static a:Lcom/salesforce/android/knowledge/core/internal/http/HttpService$JobFactory;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 264
    new-instance v0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$JobFactory;

    invoke-direct {v0}, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$JobFactory;-><init>()V

    sput-object v0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$JobFactory;->a:Lcom/salesforce/android/knowledge/core/internal/http/HttpService$JobFactory;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 261
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/http/HttpClient;Lcom/salesforce/android/service/common/http/HttpRequest;Ljava/lang/Class;Lcom/google/gson/Gson;)Lcom/salesforce/android/service/common/utilities/threading/Job;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/salesforce/android/service/common/http/HttpClient;",
            "Lcom/salesforce/android/service/common/http/HttpRequest;",
            "Ljava/lang/Class",
            "<TT;>;",
            "Lcom/google/gson/Gson;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/threading/Job",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 269
    invoke-static {p1, p2, p3, p4}, Lcom/salesforce/android/service/common/http/HttpJob;->a(Lcom/salesforce/android/service/common/http/HttpClient;Lcom/salesforce/android/service/common/http/HttpRequest;Ljava/lang/Class;Lcom/google/gson/Gson;)Lcom/salesforce/android/service/common/http/HttpJob;

    move-result-object v0

    return-object v0
.end method
