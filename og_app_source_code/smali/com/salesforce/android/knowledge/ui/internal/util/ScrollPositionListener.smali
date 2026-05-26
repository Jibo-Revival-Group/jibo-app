.class public Lcom/salesforce/android/knowledge/ui/internal/util/ScrollPositionListener;
.super Landroid/support/v7/widget/RecyclerView$OnScrollListener;
.source "ScrollPositionListener.java"


# instance fields
.field private a:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 32
    invoke-direct {p0}, Landroid/support/v7/widget/RecyclerView$OnScrollListener;-><init>()V

    .line 36
    const/4 v0, 0x0

    iput v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/ScrollPositionListener;->a:I

    return-void
.end method


# virtual methods
.method public a(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 53
    const-string v0, "scroll_position_y_state"

    iget v1, p0, Lcom/salesforce/android/knowledge/ui/internal/util/ScrollPositionListener;->a:I

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 54
    return-void
.end method

.method public a(Landroid/support/v7/widget/RecyclerView;II)V
    .locals 1

    .prologue
    .line 43
    invoke-super {p0, p1, p2, p3}, Landroid/support/v7/widget/RecyclerView$OnScrollListener;->a(Landroid/support/v7/widget/RecyclerView;II)V

    .line 44
    iget v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/ScrollPositionListener;->a:I

    add-int/2addr v0, p3

    iput v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/ScrollPositionListener;->a:I

    .line 45
    return-void
.end method

.method public b()I
    .locals 1

    .prologue
    .line 62
    iget v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/ScrollPositionListener;->a:I

    return v0
.end method

.method public b(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 58
    const-string v0, "scroll_position_y_state"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/ScrollPositionListener;->a:I

    .line 59
    return-void
.end method
