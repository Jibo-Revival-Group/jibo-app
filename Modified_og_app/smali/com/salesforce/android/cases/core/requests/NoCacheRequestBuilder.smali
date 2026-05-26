.class public abstract Lcom/salesforce/android/cases/core/requests/NoCacheRequestBuilder;
.super Lcom/salesforce/android/cases/core/FetchSaveRequestBuilder;
.source "NoCacheRequestBuilder.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Lcom/salesforce/android/cases/core/FetchSaveRequestBuilder",
        "<TT;>;>",
        "Lcom/salesforce/android/cases/core/FetchSaveRequestBuilder",
        "<TT;>;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Lcom/salesforce/android/cases/core/FetchSaveRequestBuilder;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Z)Lcom/salesforce/android/cases/core/FetchSaveRequestBuilder;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z)TT;"
        }
    .end annotation

    .prologue
    .line 37
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Cannot set return cached results on NoCacheRequest"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public final b(Z)Lcom/salesforce/android/cases/core/FetchSaveRequestBuilder;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z)TT;"
        }
    .end annotation

    .prologue
    .line 41
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Cannot set cache results on NoCacheRequest"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public synthetic c(Z)Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;
    .locals 1

    .prologue
    .line 33
    invoke-virtual {p0, p1}, Lcom/salesforce/android/cases/core/requests/NoCacheRequestBuilder;->b(Z)Lcom/salesforce/android/cases/core/FetchSaveRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public synthetic d(Z)Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;
    .locals 1

    .prologue
    .line 33
    invoke-virtual {p0, p1}, Lcom/salesforce/android/cases/core/requests/NoCacheRequestBuilder;->a(Z)Lcom/salesforce/android/cases/core/FetchSaveRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public final d()Z
    .locals 1

    .prologue
    .line 45
    const/4 v0, 0x0

    return v0
.end method

.method public final f_()Z
    .locals 1

    .prologue
    .line 49
    const/4 v0, 0x0

    return v0
.end method
