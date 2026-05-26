.class public abstract Lcom/salesforce/android/cases/core/requests/SaveRequest;
.super Ljava/lang/Object;
.source "SaveRequest.java"


# instance fields
.field private final a:Z

.field private final b:Z


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/core/SaveRequestBuilder;)V
    .locals 1

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/SaveRequestBuilder;->a()Z

    move-result v0

    iput-boolean v0, p0, Lcom/salesforce/android/cases/core/requests/SaveRequest;->a:Z

    .line 36
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/SaveRequestBuilder;->b()Z

    move-result v0

    iput-boolean v0, p0, Lcom/salesforce/android/cases/core/requests/SaveRequest;->b:Z

    .line 37
    return-void
.end method


# virtual methods
.method public a()Z
    .locals 1

    .prologue
    .line 43
    iget-boolean v0, p0, Lcom/salesforce/android/cases/core/requests/SaveRequest;->a:Z

    return v0
.end method

.method public b()Z
    .locals 1

    .prologue
    .line 50
    iget-boolean v0, p0, Lcom/salesforce/android/cases/core/requests/SaveRequest;->b:Z

    return v0
.end method
