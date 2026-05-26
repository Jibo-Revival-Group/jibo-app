.class public Lcom/salesforce/android/cases/core/requests/CommentPostRequest;
.super Lcom/salesforce/android/cases/core/requests/FetchSaveRequest;
.source "CommentPostRequest.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/cases/core/requests/CommentPostRequest$CommentPostRequestBuilder;
    }
.end annotation


# instance fields
.field private final a:Ljava/lang/String;

.field private final b:Ljava/lang/String;

.field private final c:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/core/requests/CommentPostRequest$CommentPostRequestBuilder;)V
    .locals 1

    .prologue
    .line 42
    invoke-direct {p0, p1}, Lcom/salesforce/android/cases/core/requests/FetchSaveRequest;-><init>(Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;)V

    .line 43
    invoke-static {p1}, Lcom/salesforce/android/cases/core/requests/CommentPostRequest$CommentPostRequestBuilder;->a(Lcom/salesforce/android/cases/core/requests/CommentPostRequest$CommentPostRequestBuilder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/requests/CommentPostRequest;->a:Ljava/lang/String;

    .line 44
    invoke-static {p1}, Lcom/salesforce/android/cases/core/requests/CommentPostRequest$CommentPostRequestBuilder;->b(Lcom/salesforce/android/cases/core/requests/CommentPostRequest$CommentPostRequestBuilder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/requests/CommentPostRequest;->c:Ljava/lang/String;

    .line 45
    invoke-static {p1}, Lcom/salesforce/android/cases/core/requests/CommentPostRequest$CommentPostRequestBuilder;->c(Lcom/salesforce/android/cases/core/requests/CommentPostRequest$CommentPostRequestBuilder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/requests/CommentPostRequest;->b:Ljava/lang/String;

    .line 46
    return-void
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/salesforce/android/cases/core/requests/CommentPostRequest;->a:Ljava/lang/String;

    return-object v0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/salesforce/android/cases/core/requests/CommentPostRequest;->c:Ljava/lang/String;

    return-object v0
.end method

.method public c()Ljava/lang/String;
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/salesforce/android/cases/core/requests/CommentPostRequest;->b:Ljava/lang/String;

    return-object v0
.end method
