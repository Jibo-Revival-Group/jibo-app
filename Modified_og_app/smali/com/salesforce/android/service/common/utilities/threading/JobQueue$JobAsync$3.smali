.class Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobAsync$3;
.super Ljava/lang/Object;
.source "JobQueue.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobAsync;->a()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobAsync;


# direct methods
.method constructor <init>(Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobAsync;)V
    .locals 0

    .prologue
    .line 176
    iput-object p1, p0, Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobAsync$3;->a:Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobAsync;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 178
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobAsync$3;->a:Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobAsync;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobAsync;->a(Lcom/salesforce/android/service/common/utilities/threading/JobQueue$JobAsync;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    .line 179
    return-void
.end method
