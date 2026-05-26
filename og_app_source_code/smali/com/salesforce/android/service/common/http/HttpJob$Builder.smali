.class public Lcom/salesforce/android/service/common/http/HttpJob$Builder;
.super Ljava/lang/Object;
.source "HttpJob.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/service/common/http/HttpJob;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field protected a:Lcom/salesforce/android/service/common/http/HttpClient;

.field protected b:Lcom/salesforce/android/service/common/http/HttpRequest;

.field protected c:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<TT;>;"
        }
    .end annotation
.end field

.field protected d:Lcom/google/gson/Gson;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 119
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/google/gson/Gson;)Lcom/salesforce/android/service/common/http/HttpJob$Builder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/gson/Gson;",
            ")",
            "Lcom/salesforce/android/service/common/http/HttpJob$Builder",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 141
    iput-object p1, p0, Lcom/salesforce/android/service/common/http/HttpJob$Builder;->d:Lcom/google/gson/Gson;

    .line 142
    return-object p0
.end method

.method public a(Lcom/salesforce/android/service/common/http/HttpClient;)Lcom/salesforce/android/service/common/http/HttpJob$Builder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/http/HttpClient;",
            ")",
            "Lcom/salesforce/android/service/common/http/HttpJob$Builder",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 126
    iput-object p1, p0, Lcom/salesforce/android/service/common/http/HttpJob$Builder;->a:Lcom/salesforce/android/service/common/http/HttpClient;

    .line 127
    return-object p0
.end method

.method public a(Lcom/salesforce/android/service/common/http/HttpRequest;)Lcom/salesforce/android/service/common/http/HttpJob$Builder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/http/HttpRequest;",
            ")",
            "Lcom/salesforce/android/service/common/http/HttpJob$Builder",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 131
    iput-object p1, p0, Lcom/salesforce/android/service/common/http/HttpJob$Builder;->b:Lcom/salesforce/android/service/common/http/HttpRequest;

    .line 132
    return-object p0
.end method

.method public a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/http/HttpJob$Builder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<TT;>;)",
            "Lcom/salesforce/android/service/common/http/HttpJob$Builder",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 136
    iput-object p1, p0, Lcom/salesforce/android/service/common/http/HttpJob$Builder;->c:Ljava/lang/Class;

    .line 137
    return-object p0
.end method

.method public a()Lcom/salesforce/android/service/common/http/HttpJob;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/salesforce/android/service/common/http/HttpJob",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 146
    iget-object v0, p0, Lcom/salesforce/android/service/common/http/HttpJob$Builder;->a:Lcom/salesforce/android/service/common/http/HttpClient;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;)Ljava/lang/Object;

    .line 147
    iget-object v0, p0, Lcom/salesforce/android/service/common/http/HttpJob$Builder;->b:Lcom/salesforce/android/service/common/http/HttpRequest;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;)Ljava/lang/Object;

    .line 148
    iget-object v0, p0, Lcom/salesforce/android/service/common/http/HttpJob$Builder;->c:Ljava/lang/Class;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;)Ljava/lang/Object;

    .line 150
    iget-object v0, p0, Lcom/salesforce/android/service/common/http/HttpJob$Builder;->d:Lcom/google/gson/Gson;

    if-nez v0, :cond_0

    .line 151
    new-instance v0, Lcom/google/gson/GsonBuilder;

    invoke-direct {v0}, Lcom/google/gson/GsonBuilder;-><init>()V

    invoke-virtual {v0}, Lcom/google/gson/GsonBuilder;->a()Lcom/google/gson/Gson;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/http/HttpJob$Builder;->d:Lcom/google/gson/Gson;

    .line 154
    :cond_0
    new-instance v0, Lcom/salesforce/android/service/common/http/HttpJob;

    invoke-direct {v0, p0}, Lcom/salesforce/android/service/common/http/HttpJob;-><init>(Lcom/salesforce/android/service/common/http/HttpJob$Builder;)V

    return-object v0
.end method
