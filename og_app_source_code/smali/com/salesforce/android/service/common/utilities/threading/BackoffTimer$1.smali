.class Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$1;
.super Ljava/lang/Object;
.source "BackoffTimer.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$OnTimerExecutedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;-><init>(Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$Builder;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;


# direct methods
.method constructor <init>(Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;)V
    .locals 0

    .prologue
    .line 83
    iput-object p1, p0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$1;->a:Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer$1;->a:Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/threading/BackoffTimer;->c()V

    .line 86
    return-void
.end method
