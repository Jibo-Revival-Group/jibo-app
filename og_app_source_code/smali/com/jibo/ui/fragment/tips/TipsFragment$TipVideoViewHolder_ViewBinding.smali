.class public Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder_ViewBinding;
.super Ljava/lang/Object;
.source "TipsFragment$TipVideoViewHolder_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    iput-object p1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder_ViewBinding;->b:Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder;

    .line 24
    const v0, 0x1020014

    const-string v1, "field \'text\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder;->text:Landroid/widget/TextView;

    .line 25
    const v0, 0x7f0900eb

    const-string v1, "field \'contentImage\'"

    const-class v2, Landroid/widget/RelativeLayout;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p1, Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder;->contentImage:Landroid/widget/RelativeLayout;

    .line 26
    const v0, 0x7f090154

    const-string v1, "field \'image\'"

    const-class v2, Landroid/widget/ImageView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder;->image:Landroid/widget/ImageView;

    .line 27
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 32
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder_ViewBinding;->b:Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder;

    .line 33
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 34
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder_ViewBinding;->b:Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder;

    .line 36
    iput-object v1, v0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder;->text:Landroid/widget/TextView;

    .line 37
    iput-object v1, v0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder;->contentImage:Landroid/widget/RelativeLayout;

    .line 38
    iput-object v1, v0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder;->image:Landroid/widget/ImageView;

    .line 39
    return-void
.end method
