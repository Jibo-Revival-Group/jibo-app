.class public Lcom/salesforce/android/cases/core/internal/model/PickListOptionModel;
.super Ljava/lang/Object;
.source "PickListOptionModel.java"

# interfaces
.implements Lcom/salesforce/android/cases/core/model/PickListOption;


# instance fields
.field private a:Ljava/lang/String;

.field private b:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse$PickListOption;)V
    .locals 2

    .prologue
    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    if-nez p1, :cond_0

    .line 38
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "PickListOption cannot be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 41
    :cond_0
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse$PickListOption;->a()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/PickListOptionModel;->a:Ljava/lang/String;

    .line 42
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse$PickListOption;->b()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/PickListOptionModel;->b:Ljava/lang/String;

    .line 43
    return-void
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/PickListOptionModel;->a:Ljava/lang/String;

    return-object v0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/PickListOptionModel;->b:Ljava/lang/String;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    invoke-virtual {p0}, Lcom/salesforce/android/cases/core/internal/model/PickListOptionModel;->a()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
