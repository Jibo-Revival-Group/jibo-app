.class public Lcom/salesforce/android/cases/core/requests/CommentPostRequest$CommentPostRequestBuilder;
.super Lcom/salesforce/android/cases/core/requests/NoCacheRequestBuilder;
.source "CommentPostRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/core/requests/CommentPostRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CommentPostRequestBuilder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/salesforce/android/cases/core/requests/NoCacheRequestBuilder",
        "<",
        "Lcom/salesforce/android/cases/core/requests/CommentPostRequest$CommentPostRequestBuilder;",
        ">;"
    }
.end annotation


# instance fields
.field private final a:Ljava/lang/String;

.field private final b:Ljava/lang/String;

.field private final c:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 79
    invoke-direct {p0}, Lcom/salesforce/android/cases/core/requests/NoCacheRequestBuilder;-><init>()V

    .line 80
    iput-object p1, p0, Lcom/salesforce/android/cases/core/requests/CommentPostRequest$CommentPostRequestBuilder;->c:Ljava/lang/String;

    .line 81
    iput-object p2, p0, Lcom/salesforce/android/cases/core/requests/CommentPostRequest$CommentPostRequestBuilder;->a:Ljava/lang/String;

    .line 82
    iput-object p3, p0, Lcom/salesforce/android/cases/core/requests/CommentPostRequest$CommentPostRequestBuilder;->b:Ljava/lang/String;

    .line 83
    return-void
.end method

.method static synthetic a(Lcom/salesforce/android/cases/core/requests/CommentPostRequest$CommentPostRequestBuilder;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/salesforce/android/cases/core/requests/CommentPostRequest$CommentPostRequestBuilder;->a:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic b(Lcom/salesforce/android/cases/core/requests/CommentPostRequest$CommentPostRequestBuilder;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/salesforce/android/cases/core/requests/CommentPostRequest$CommentPostRequestBuilder;->b:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic c(Lcom/salesforce/android/cases/core/requests/CommentPostRequest$CommentPostRequestBuilder;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/salesforce/android/cases/core/requests/CommentPostRequest$CommentPostRequestBuilder;->c:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method protected a()Lcom/salesforce/android/cases/core/requests/CommentPostRequest$CommentPostRequestBuilder;
    .locals 0

    .prologue
    .line 86
    return-object p0
.end method

.method public b()Lcom/salesforce/android/cases/core/requests/CommentPostRequest;
    .locals 1

    .prologue
    .line 90
    new-instance v0, Lcom/salesforce/android/cases/core/requests/CommentPostRequest;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/core/requests/CommentPostRequest;-><init>(Lcom/salesforce/android/cases/core/requests/CommentPostRequest$CommentPostRequestBuilder;)V

    return-object v0
.end method

.method protected synthetic c()Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;
    .locals 1

    .prologue
    .line 72
    invoke-virtual {p0}, Lcom/salesforce/android/cases/core/requests/CommentPostRequest$CommentPostRequestBuilder;->a()Lcom/salesforce/android/cases/core/requests/CommentPostRequest$CommentPostRequestBuilder;

    move-result-object v0

    return-object v0
.end method
