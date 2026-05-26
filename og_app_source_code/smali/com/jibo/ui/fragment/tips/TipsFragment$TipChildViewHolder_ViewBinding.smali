.class public Lcom/jibo/ui/fragment/tips/TipsFragment$TipChildViewHolder_ViewBinding;
.super Ljava/lang/Object;
.source "TipsFragment$TipChildViewHolder_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/tips/TipsFragment$TipChildViewHolder;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/tips/TipsFragment$TipChildViewHolder;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    iput-object p1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipChildViewHolder_ViewBinding;->b:Lcom/jibo/ui/fragment/tips/TipsFragment$TipChildViewHolder;

    .line 21
    const v0, 0x1020014

    const-string v1, "field \'text\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/tips/TipsFragment$TipChildViewHolder;->text:Landroid/widget/TextView;

    .line 22
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 27
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipChildViewHolder_ViewBinding;->b:Lcom/jibo/ui/fragment/tips/TipsFragment$TipChildViewHolder;

    .line 28
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 29
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipChildViewHolder_ViewBinding;->b:Lcom/jibo/ui/fragment/tips/TipsFragment$TipChildViewHolder;

    .line 31
    iput-object v1, v0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipChildViewHolder;->text:Landroid/widget/TextView;

    .line 32
    return-void
.end method
