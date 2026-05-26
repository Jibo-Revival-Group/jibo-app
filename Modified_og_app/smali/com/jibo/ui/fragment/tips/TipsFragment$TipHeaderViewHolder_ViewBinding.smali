.class public Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder_ViewBinding;
.super Ljava/lang/Object;
.source "TipsFragment$TipHeaderViewHolder_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    iput-object p1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder_ViewBinding;->b:Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;

    .line 23
    const v0, 0x7f09014c

    const-string v1, "field \'icon\'"

    const-class v2, Landroid/widget/ImageView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;->icon:Landroid/widget/ImageView;

    .line 24
    const v0, 0x7f0902fb

    const-string v1, "field \'title\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;->title:Landroid/widget/TextView;

    .line 25
    const v0, 0x7f0902c9

    const-string v1, "field \'subtitle\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;->subtitle:Landroid/widget/TextView;

    .line 26
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 31
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder_ViewBinding;->b:Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;

    .line 32
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 33
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder_ViewBinding;->b:Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;

    .line 35
    iput-object v1, v0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;->icon:Landroid/widget/ImageView;

    .line 36
    iput-object v1, v0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;->title:Landroid/widget/TextView;

    .line 37
    iput-object v1, v0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipHeaderViewHolder;->subtitle:Landroid/widget/TextView;

    .line 38
    return-void
.end method
