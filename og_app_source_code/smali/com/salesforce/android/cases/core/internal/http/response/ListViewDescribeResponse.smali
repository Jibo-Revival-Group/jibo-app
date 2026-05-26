.class public Lcom/salesforce/android/cases/core/internal/http/response/ListViewDescribeResponse;
.super Ljava/lang/Object;
.source "ListViewDescribeResponse.java"


# instance fields
.field private query:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "query"
    .end annotation
.end field

.field private scope:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "scope"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/ListViewDescribeResponse;->scope:Ljava/lang/String;

    return-object v0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/ListViewDescribeResponse;->query:Ljava/lang/String;

    return-object v0
.end method
