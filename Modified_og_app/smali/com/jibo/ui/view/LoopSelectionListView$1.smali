.class Lcom/jibo/ui/view/LoopSelectionListView$1;
.super Ljava/lang/Object;
.source "LoopSelectionListView.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/view/LoopSelectionListView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/view/LoopSelectionListView;


# direct methods
.method constructor <init>(Lcom/jibo/ui/view/LoopSelectionListView;)V
    .locals 0

    .prologue
    .line 192
    iput-object p1, p0, Lcom/jibo/ui/view/LoopSelectionListView$1;->a:Lcom/jibo/ui/view/LoopSelectionListView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 195
    iget-object v0, p0, Lcom/jibo/ui/view/LoopSelectionListView$1;->a:Lcom/jibo/ui/view/LoopSelectionListView;

    invoke-static {v0}, Lcom/jibo/ui/view/LoopSelectionListView;->a(Lcom/jibo/ui/view/LoopSelectionListView;)Landroid/widget/ListAdapter;

    move-result-object v0

    invoke-interface {v0, p3}, Landroid/widget/ListAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 196
    iget-object v1, p0, Lcom/jibo/ui/view/LoopSelectionListView$1;->a:Lcom/jibo/ui/view/LoopSelectionListView;

    invoke-static {v1}, Lcom/jibo/ui/view/LoopSelectionListView;->b(Lcom/jibo/ui/view/LoopSelectionListView;)Lcom/jibo/ui/view/LoopSelectionListView$OnLoopSelectedListener;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 197
    iget-object v1, p0, Lcom/jibo/ui/view/LoopSelectionListView$1;->a:Lcom/jibo/ui/view/LoopSelectionListView;

    invoke-static {v1}, Lcom/jibo/ui/view/LoopSelectionListView;->b(Lcom/jibo/ui/view/LoopSelectionListView;)Lcom/jibo/ui/view/LoopSelectionListView$OnLoopSelectedListener;

    move-result-object v1

    invoke-interface {v1, v0}, Lcom/jibo/ui/view/LoopSelectionListView$OnLoopSelectedListener;->a(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    .line 199
    :cond_0
    return-void
.end method
