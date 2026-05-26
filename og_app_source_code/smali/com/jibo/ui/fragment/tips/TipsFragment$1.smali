.class Lcom/jibo/ui/fragment/tips/TipsFragment$1;
.super Landroid/os/CountDownTimer;
.source "TipsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/tips/TipsFragment;->b()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/tips/TipsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/tips/TipsFragment;JJ)V
    .locals 0

    .prologue
    .line 149
    iput-object p1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$1;->a:Lcom/jibo/ui/fragment/tips/TipsFragment;

    invoke-direct {p0, p2, p3, p4, p5}, Landroid/os/CountDownTimer;-><init>(JJ)V

    return-void
.end method


# virtual methods
.method public onFinish()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 157
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$1;->a:Lcom/jibo/ui/fragment/tips/TipsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/tips/TipsFragment;->a(Lcom/jibo/ui/fragment/tips/TipsFragment;)Landroid/support/v7/widget/RecyclerView$Adapter;

    move-result-object v0

    check-cast v0, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;

    invoke-virtual {v0, v1}, Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;->e(I)V

    .line 158
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$1;->a:Lcom/jibo/ui/fragment/tips/TipsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/tips/TipsFragment;->a:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->a(Z)V

    .line 159
    return-void
.end method

.method public onTick(J)V
    .locals 0

    .prologue
    .line 153
    return-void
.end method
