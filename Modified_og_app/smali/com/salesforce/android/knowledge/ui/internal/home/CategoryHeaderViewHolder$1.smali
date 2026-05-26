.class Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder$1;
.super Ljava/lang/Object;
.source "CategoryHeaderViewHolder.java"

# interfaces
.implements Landroid/view/View$OnLayoutChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;-><init>(Landroid/view/View;Lcom/salesforce/android/knowledge/ui/internal/home/HomePresenter;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;)V
    .locals 0

    .prologue
    .line 78
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder$1;->a:Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onLayoutChange(Landroid/view/View;IIIIIIII)V
    .locals 2

    .prologue
    .line 81
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder$1;->a:Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;

    iget-object v0, v0, Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;->d:Landroid/widget/ImageView;

    sub-int v1, p4, p2

    div-int/lit8 v1, v1, 0x2

    int-to-float v1, v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setPivotX(F)V

    .line 82
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder$1;->a:Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;

    iget-object v0, v0, Lcom/salesforce/android/knowledge/ui/internal/home/CategoryHeaderViewHolder;->d:Landroid/widget/ImageView;

    sub-int v1, p5, p3

    div-int/lit8 v1, v1, 0x2

    int-to-float v1, v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setPivotX(F)V

    .line 83
    return-void
.end method
