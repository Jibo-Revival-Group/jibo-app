.class public Lcom/salesforce/android/knowledge/ui/internal/views/KnowledgeRecyclerView;
.super Landroid/support/v7/widget/RecyclerView;
.source "KnowledgeRecyclerView.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 36
    invoke-direct {p0, p1}, Landroid/support/v7/widget/RecyclerView;-><init>(Landroid/content/Context;)V

    .line 37
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0, p1, p2}, Landroid/support/v7/widget/RecyclerView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 41
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0

    .prologue
    .line 44
    invoke-direct {p0, p1, p2, p3}, Landroid/support/v7/widget/RecyclerView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 45
    return-void
.end method


# virtual methods
.method protected onAttachedToWindow()V
    .locals 1

    .prologue
    .line 48
    invoke-super {p0}, Landroid/support/v7/widget/RecyclerView;->onAttachedToWindow()V

    .line 54
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/views/KnowledgeRecyclerView$1;

    invoke-direct {v0, p0}, Lcom/salesforce/android/knowledge/ui/internal/views/KnowledgeRecyclerView$1;-><init>(Lcom/salesforce/android/knowledge/ui/internal/views/KnowledgeRecyclerView;)V

    invoke-virtual {p0, v0}, Lcom/salesforce/android/knowledge/ui/internal/views/KnowledgeRecyclerView;->post(Ljava/lang/Runnable;)Z

    .line 59
    return-void
.end method
