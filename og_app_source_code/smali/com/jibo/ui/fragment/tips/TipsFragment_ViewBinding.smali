.class public Lcom/jibo/ui/fragment/tips/TipsFragment_ViewBinding;
.super Ljava/lang/Object;
.source "TipsFragment_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/tips/TipsFragment;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/tips/TipsFragment;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    iput-object p1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/tips/TipsFragment;

    .line 20
    const v0, 0x102000a

    const-string v1, "field \'list\'"

    const-class v2, Landroid/support/v7/widget/RecyclerView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/RecyclerView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/tips/TipsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    .line 21
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 26
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/tips/TipsFragment;

    .line 27
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 28
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/tips/TipsFragment;

    .line 30
    iput-object v1, v0, Lcom/jibo/ui/fragment/tips/TipsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    .line 31
    return-void
.end method
