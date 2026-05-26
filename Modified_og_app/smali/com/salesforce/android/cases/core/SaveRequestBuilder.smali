.class public abstract Lcom/salesforce/android/cases/core/SaveRequestBuilder;
.super Ljava/lang/Object;
.source "SaveRequestBuilder.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Lcom/salesforce/android/cases/core/SaveRequestBuilder",
        "<TT;>;>",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private a:Z

.field private b:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Z)Lcom/salesforce/android/cases/core/SaveRequestBuilder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z)TT;"
        }
    .end annotation

    .prologue
    .line 42
    iput-boolean p1, p0, Lcom/salesforce/android/cases/core/SaveRequestBuilder;->a:Z

    .line 43
    invoke-virtual {p0}, Lcom/salesforce/android/cases/core/SaveRequestBuilder;->c()Lcom/salesforce/android/cases/core/SaveRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public a()Z
    .locals 1

    .prologue
    .line 63
    iget-boolean v0, p0, Lcom/salesforce/android/cases/core/SaveRequestBuilder;->a:Z

    return v0
.end method

.method public b(Z)Lcom/salesforce/android/cases/core/SaveRequestBuilder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z)TT;"
        }
    .end annotation

    .prologue
    .line 53
    iput-boolean p1, p0, Lcom/salesforce/android/cases/core/SaveRequestBuilder;->b:Z

    .line 54
    invoke-virtual {p0}, Lcom/salesforce/android/cases/core/SaveRequestBuilder;->c()Lcom/salesforce/android/cases/core/SaveRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public b()Z
    .locals 1

    .prologue
    .line 70
    iget-boolean v0, p0, Lcom/salesforce/android/cases/core/SaveRequestBuilder;->b:Z

    return v0
.end method

.method protected abstract c()Lcom/salesforce/android/cases/core/SaveRequestBuilder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation
.end method
