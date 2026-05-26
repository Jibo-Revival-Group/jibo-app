.class Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$1;
.super Ljava/lang/Object;
.source "MinimizedViewHolder.java"

# interfaces
.implements Landroid/view/View$OnAttachStateChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->a()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;


# direct methods
.method constructor <init>(Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;)V
    .locals 0

    .prologue
    .line 83
    iput-object p1, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$1;->a:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onViewAttachedToWindow(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 87
    new-instance v0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$1$1;

    invoke-direct {v0, p0, p1}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$1$1;-><init>(Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$1;Landroid/view/View;)V

    invoke-virtual {p1, v0}, Landroid/view/View;->post(Ljava/lang/Runnable;)Z

    .line 92
    return-void
.end method

.method public onViewDetachedFromWindow(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 95
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$1;->a:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;

    iget-object v0, v0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->b:Landroid/view/ViewGroup;

    invoke-virtual {v0, p0}, Landroid/view/ViewGroup;->removeOnAttachStateChangeListener(Landroid/view/View$OnAttachStateChangeListener;)V

    .line 96
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$1;->a:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;

    iget-object v0, v0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->b:Landroid/view/ViewGroup;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 97
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$1;->a:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;

    iget-object v0, v0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->e:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;->a()V

    .line 98
    return-void
.end method
