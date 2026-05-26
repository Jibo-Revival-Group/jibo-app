.class Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$2;
.super Ljava/lang/Object;
.source "MinimizedViewHolder.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


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
    .line 101
    iput-object p1, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$2;->a:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 103
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$2;->a:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;

    iget-object v0, v0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->d:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Listener;

    invoke-interface {v0, p1}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Listener;->b(Landroid/view/View;)V

    .line 104
    return-void
.end method
