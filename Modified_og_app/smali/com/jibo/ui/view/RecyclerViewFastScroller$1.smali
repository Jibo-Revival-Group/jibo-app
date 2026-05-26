.class Lcom/jibo/ui/view/RecyclerViewFastScroller$1;
.super Landroid/support/v7/widget/RecyclerView$OnScrollListener;
.source "RecyclerViewFastScroller.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/view/RecyclerViewFastScroller;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/view/RecyclerViewFastScroller;


# direct methods
.method constructor <init>(Lcom/jibo/ui/view/RecyclerViewFastScroller;)V
    .locals 0

    .prologue
    .line 32
    iput-object p1, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller$1;->a:Lcom/jibo/ui/view/RecyclerViewFastScroller;

    invoke-direct {p0}, Landroid/support/v7/widget/RecyclerView$OnScrollListener;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/support/v7/widget/RecyclerView;II)V
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/jibo/ui/view/RecyclerViewFastScroller$1;->a:Lcom/jibo/ui/view/RecyclerViewFastScroller;

    invoke-static {v0}, Lcom/jibo/ui/view/RecyclerViewFastScroller;->a(Lcom/jibo/ui/view/RecyclerViewFastScroller;)V

    .line 36
    return-void
.end method
