.class Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker$1;
.super Ljava/lang/Object;
.source "BackgroundTracker.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker;->a(Landroid/app/Activity;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker;


# direct methods
.method constructor <init>(Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker;)V
    .locals 0

    .prologue
    .line 135
    iput-object p1, p0, Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker$1;->a:Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 138
    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker$1;->a:Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/internal/android/BackgroundTracker;->c()V

    .line 139
    return-void
.end method
