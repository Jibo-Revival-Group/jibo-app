.class public abstract Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;
.super Ljava/lang/Object;
.source "FetchSaveRequest.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;
    }
.end annotation


# instance fields
.field private final a:Z

.field private final b:Z

.field private final c:Z


# direct methods
.method protected constructor <init>(Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;)V
    .locals 1

    .prologue
    .line 49
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 50
    invoke-virtual {p1}, Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;->d()Z

    move-result v0

    iput-boolean v0, p0, Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;->a:Z

    .line 51
    invoke-virtual {p1}, Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;->f_()Z

    move-result v0

    iput-boolean v0, p0, Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;->b:Z

    .line 52
    invoke-virtual {p1}, Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;->f()Z

    move-result v0

    iput-boolean v0, p0, Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;->c:Z

    .line 53
    return-void
.end method


# virtual methods
.method public l()Z
    .locals 1

    .prologue
    .line 67
    iget-boolean v0, p0, Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;->a:Z

    return v0
.end method

.method public m()Z
    .locals 1

    .prologue
    .line 79
    iget-boolean v0, p0, Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;->b:Z

    return v0
.end method

.method public n()Z
    .locals 1

    .prologue
    .line 89
    iget-boolean v0, p0, Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;->c:Z

    return v0
.end method
