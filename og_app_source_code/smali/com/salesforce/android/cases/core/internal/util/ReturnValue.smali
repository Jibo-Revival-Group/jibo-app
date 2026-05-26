.class public Lcom/salesforce/android/cases/core/internal/util/ReturnValue;
.super Lcom/salesforce/android/service/common/utilities/control/BasicAsync;
.source "ReturnValue.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/salesforce/android/service/common/utilities/control/BasicAsync",
        "<TT;>;",
        "Lcom/salesforce/android/service/common/utilities/control/ResultReceiver",
        "<TT;>;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 37
    invoke-direct {p0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;-><init>()V

    return-void
.end method


# virtual methods
.method public a()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/salesforce/android/service/common/utilities/control/BasicAsync",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 49
    invoke-super {p0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 50
    return-object p0
.end method

.method public a(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)",
            "Lcom/salesforce/android/service/common/utilities/control/BasicAsync",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 39
    invoke-super {p0, p1}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 40
    return-object p0
.end method

.method public a(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Throwable;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/BasicAsync",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 44
    invoke-super {p0, p1}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 45
    return-object p0
.end method

.method public synthetic b()Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;
    .locals 1

    .prologue
    .line 37
    invoke-virtual {p0}, Lcom/salesforce/android/cases/core/internal/util/ReturnValue;->a()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    return-object v0
.end method

.method public synthetic b(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;
    .locals 1

    .prologue
    .line 37
    invoke-virtual {p0, p1}, Lcom/salesforce/android/cases/core/internal/util/ReturnValue;->a(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    return-object v0
.end method

.method public synthetic b(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;
    .locals 1

    .prologue
    .line 37
    invoke-virtual {p0, p1}, Lcom/salesforce/android/cases/core/internal/util/ReturnValue;->a(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    return-object v0
.end method
