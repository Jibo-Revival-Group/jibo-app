.class Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$1$1;
.super Ljava/lang/Object;
.source "MinimizedViewHolder.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$1;->onViewAttachedToWindow(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/view/View;

.field final synthetic b:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$1;


# direct methods
.method constructor <init>(Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$1;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 87
    iput-object p1, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$1$1;->b:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$1;

    iput-object p2, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$1$1;->a:Landroid/view/View;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 89
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$1$1;->b:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$1;

    iget-object v0, v0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$1;->a:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;

    iget-object v0, v0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->d:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Listener;

    iget-object v1, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$1$1;->a:Landroid/view/View;

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Listener;->d(Landroid/view/View;)V

    .line 90
    return-void
.end method
