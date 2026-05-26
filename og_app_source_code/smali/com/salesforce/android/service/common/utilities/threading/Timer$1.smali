.class Lcom/salesforce/android/service/common/utilities/threading/Timer$1;
.super Ljava/lang/Object;
.source "Timer.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/threading/Timer$OnTimerExecutedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/service/common/utilities/threading/Timer;-><init>(Lcom/salesforce/android/service/common/utilities/threading/Timer$Builder;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/service/common/utilities/threading/Timer;


# direct methods
.method constructor <init>(Lcom/salesforce/android/service/common/utilities/threading/Timer;)V
    .locals 0

    .prologue
    .line 81
    iput-object p1, p0, Lcom/salesforce/android/service/common/utilities/threading/Timer$1;->a:Lcom/salesforce/android/service/common/utilities/threading/Timer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 2

    .prologue
    .line 83
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/threading/Timer$1;->a:Lcom/salesforce/android/service/common/utilities/threading/Timer;

    const/4 v1, 0x0

    iput-boolean v1, v0, Lcom/salesforce/android/service/common/utilities/threading/Timer;->b:Z

    .line 84
    return-void
.end method
