.class Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Factory;
.super Ljava/lang/Object;
.source "MinimizedViewHolder.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Factory"
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 266
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method a(Landroid/app/Activity;Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Listener;)Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;
    .locals 1

    .prologue
    .line 268
    new-instance v0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Builder;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Builder;-><init>()V

    invoke-virtual {v0, p2}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Builder;->a(Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Listener;)Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Builder;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Builder;->a(Landroid/app/Activity;)Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;

    move-result-object v0

    return-object v0
.end method
