.class public abstract Lcom/salesforce/android/knowledge/ui/internal/util/ListController;
.super Ljava/lang/Object;
.source "ListController.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Landroid/support/v7/widget/RecyclerView$ViewHolder;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private final a:Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method protected constructor <init>()V
    .locals 1

    .prologue
    .line 42
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;

    invoke-direct {v0}, Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;-><init>()V

    invoke-direct {p0, v0}, Lcom/salesforce/android/knowledge/ui/internal/util/ListController;-><init>(Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;)V

    .line 43
    return-void
.end method

.method protected constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 46
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 47
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/util/ListController;->a:Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;

    .line 48
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/ListController;->a:Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;

    invoke-virtual {v0, p0}, Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;->a(Lcom/salesforce/android/knowledge/ui/internal/util/ListController;)V

    .line 49
    return-void
.end method


# virtual methods
.method public abstract a()I
.end method

.method public a(I)I
    .locals 1

    .prologue
    .line 74
    const/4 v0, 0x0

    return v0
.end method

.method public abstract a(Landroid/view/ViewGroup;I)Landroid/support/v7/widget/RecyclerView$ViewHolder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/ViewGroup;",
            "I)TT;"
        }
    .end annotation
.end method

.method public a(Landroid/support/v7/widget/RecyclerView$ViewHolder;)V
    .locals 0

    .prologue
    .line 78
    return-void
.end method

.method public abstract a(Landroid/support/v7/widget/RecyclerView$ViewHolder;I)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;I)V"
        }
    .end annotation
.end method

.method public b(I)J
    .locals 2

    .prologue
    .line 81
    const-wide/16 v0, -0x1

    return-wide v0
.end method

.method public c()Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 56
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/ListController;->a:Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;

    return-object v0
.end method
