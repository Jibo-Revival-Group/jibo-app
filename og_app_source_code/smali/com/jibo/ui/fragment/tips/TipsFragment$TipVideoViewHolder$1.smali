.class Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder$1;
.super Ljava/lang/Object;
.source "TipsFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder;->a(Lcom/jibo/ui/fragment/tips/TipsFragment$VideoTip;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/tips/TipsFragment$VideoTip;

.field final synthetic b:Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder;Lcom/jibo/ui/fragment/tips/TipsFragment$VideoTip;)V
    .locals 0

    .prologue
    .line 241
    iput-object p1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder$1;->b:Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder;

    iput-object p2, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder$1;->a:Lcom/jibo/ui/fragment/tips/TipsFragment$VideoTip;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 245
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder$1;->b:Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder;

    iget-object v1, v1, Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder;->a:Lcom/jibo/ui/fragment/tips/TipsFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/tips/TipsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const-class v2, Lcom/jibo/ui/activity/TipVideoActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 246
    const-string v1, "extra_video_url_res_id"

    iget-object v2, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder$1;->a:Lcom/jibo/ui/fragment/tips/TipsFragment$VideoTip;

    invoke-virtual {v2}, Lcom/jibo/ui/fragment/tips/TipsFragment$VideoTip;->i()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 247
    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder$1;->b:Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder;

    iget-object v1, v1, Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder;->a:Lcom/jibo/ui/fragment/tips/TipsFragment;

    invoke-virtual {v1, v0}, Lcom/jibo/ui/fragment/tips/TipsFragment;->startActivity(Landroid/content/Intent;)V

    .line 248
    return-void
.end method
