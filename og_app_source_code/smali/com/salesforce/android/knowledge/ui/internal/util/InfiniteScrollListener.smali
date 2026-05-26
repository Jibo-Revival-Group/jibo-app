.class public Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;
.super Lcom/salesforce/android/knowledge/ui/internal/util/ScrollPositionListener;
.source "InfiniteScrollListener.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener$BehaviorListener;
    }
.end annotation


# instance fields
.field private final a:Landroid/support/v7/widget/LinearLayoutManager;

.field private b:Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener$BehaviorListener;

.field private c:I

.field private d:Z


# direct methods
.method private constructor <init>(Landroid/support/v7/widget/LinearLayoutManager;)V
    .locals 1

    .prologue
    .line 64
    invoke-direct {p0}, Lcom/salesforce/android/knowledge/ui/internal/util/ScrollPositionListener;-><init>()V

    .line 54
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;->d:Z

    .line 65
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;->a:Landroid/support/v7/widget/LinearLayoutManager;

    .line 66
    return-void
.end method

.method public static a(Landroid/support/v7/widget/LinearLayoutManager;)Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;
    .locals 1

    .prologue
    .line 61
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;

    invoke-direct {v0, p0}, Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;-><init>(Landroid/support/v7/widget/LinearLayoutManager;)V

    return-object v0
.end method

.method private a(II)Z
    .locals 3

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 132
    iget-object v2, p0, Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;->a:Landroid/support/v7/widget/LinearLayoutManager;

    invoke-virtual {v2}, Landroid/support/v7/widget/LinearLayoutManager;->f()Z

    move-result v2

    if-eqz v2, :cond_2

    if-lez p2, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    move v0, v1

    goto :goto_0

    :cond_2
    if-gtz p1, :cond_0

    move v0, v1

    goto :goto_0
.end method


# virtual methods
.method public a()Landroid/support/v7/widget/LinearLayoutManager;
    .locals 1

    .prologue
    .line 103
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;->a:Landroid/support/v7/widget/LinearLayoutManager;

    return-object v0
.end method

.method public a(I)Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;
    .locals 0

    .prologue
    .line 89
    iput p1, p0, Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;->c:I

    .line 90
    return-object p0
.end method

.method public a(Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener$BehaviorListener;)Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;
    .locals 0

    .prologue
    .line 78
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;->b:Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener$BehaviorListener;

    .line 79
    return-object p0
.end method

.method public a(Landroid/support/v7/widget/RecyclerView;II)V
    .locals 4

    .prologue
    .line 111
    invoke-super {p0, p1, p2, p3}, Lcom/salesforce/android/knowledge/ui/internal/util/ScrollPositionListener;->a(Landroid/support/v7/widget/RecyclerView;II)V

    .line 113
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;->b:Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener$BehaviorListener;

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;->d:Z

    if-nez v0, :cond_1

    .line 125
    :cond_0
    :goto_0
    return-void

    .line 117
    :cond_1
    invoke-direct {p0, p2, p3}, Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;->a(II)Z

    move-result v0

    .line 118
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;->a:Landroid/support/v7/widget/LinearLayoutManager;

    invoke-virtual {v1}, Landroid/support/v7/widget/LinearLayoutManager;->m()I

    move-result v1

    invoke-virtual {p1}, Landroid/support/v7/widget/RecyclerView;->getChildCount()I

    move-result v2

    add-int/2addr v1, v2

    .line 119
    iget-object v2, p0, Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;->a:Landroid/support/v7/widget/LinearLayoutManager;

    invoke-virtual {v2}, Landroid/support/v7/widget/LinearLayoutManager;->F()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    iget v3, p0, Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;->c:I

    sub-int/2addr v2, v3

    .line 121
    if-eqz v0, :cond_0

    if-le v1, v2, :cond_0

    .line 122
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;->b:Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener$BehaviorListener;

    invoke-interface {v0}, Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener$BehaviorListener;->s_()V

    .line 123
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;->d:Z

    goto :goto_0
.end method

.method public a(Z)V
    .locals 0

    .prologue
    .line 99
    iput-boolean p1, p0, Lcom/salesforce/android/knowledge/ui/internal/util/InfiniteScrollListener;->d:Z

    .line 100
    return-void
.end method
