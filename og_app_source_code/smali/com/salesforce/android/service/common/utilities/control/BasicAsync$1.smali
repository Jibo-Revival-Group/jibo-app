.class Lcom/salesforce/android/service/common/utilities/control/BasicAsync$1;
.super Ljava/lang/Object;
.source "BasicAsync.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/control/Async$Handler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->a(Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;)Lcom/salesforce/android/service/common/utilities/control/Async;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/service/common/utilities/control/Async$Handler",
        "<TT;>;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;

.field final synthetic b:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;


# direct methods
.method constructor <init>(Lcom/salesforce/android/service/common/utilities/control/BasicAsync;Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;)V
    .locals 0

    .prologue
    .line 213
    iput-object p1, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync$1;->b:Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    iput-object p2, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync$1;->a:Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 223
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync$1;->a:Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;

    invoke-interface {v0}, Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;->b()Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;

    .line 224
    return-void
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<*>;TT;)V"
        }
    .end annotation

    .prologue
    .line 215
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync$1;->a:Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;

    invoke-interface {v0, p2}, Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;->b(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;

    .line 216
    return-void
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;Ljava/lang/Throwable;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<*>;",
            "Ljava/lang/Throwable;",
            ")V"
        }
    .end annotation

    .prologue
    .line 219
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/control/BasicAsync$1;->a:Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;

    invoke-interface {v0, p2}, Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;->b(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;

    .line 220
    return-void
.end method
