.class Lcom/jibo/ui/fragment/tips/TipsListFragment$1;
.super Ljava/lang/Object;
.source "TipsListFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/tips/TipsListFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/tips/TipsListFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/tips/TipsListFragment;)V
    .locals 0

    .prologue
    .line 124
    iput-object p1, p0, Lcom/jibo/ui/fragment/tips/TipsListFragment$1;->a:Lcom/jibo/ui/fragment/tips/TipsListFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    .line 127
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 129
    const/4 v1, -0x1

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v2

    packed-switch v2, :pswitch_data_0

    :cond_0
    :goto_0
    packed-switch v1, :pswitch_data_1

    .line 150
    :goto_1
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 151
    iget-object v2, p0, Lcom/jibo/ui/fragment/tips/TipsListFragment$1;->a:Lcom/jibo/ui/fragment/tips/TipsListFragment;

    invoke-virtual {v2}, Lcom/jibo/ui/fragment/tips/TipsListFragment;->getContext()Landroid/content/Context;

    move-result-object v2

    const-class v3, Lcom/jibo/ui/activity/TipsActivity;

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    .line 152
    const-string v2, "ARGS_TAG"

    invoke-virtual {v1, v2, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 153
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsListFragment$1;->a:Lcom/jibo/ui/fragment/tips/TipsListFragment;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/tips/TipsListFragment;->startActivity(Landroid/content/Intent;)V

    .line 154
    return-void

    .line 129
    :pswitch_0
    const-string v2, "TAG_TIP0"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v1, 0x0

    goto :goto_0

    :pswitch_1
    const-string v2, "TAG_TIP1"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v1, 0x1

    goto :goto_0

    :pswitch_2
    const-string v2, "TAG_TIP2"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v1, 0x2

    goto :goto_0

    :pswitch_3
    const-string v2, "TAG_TIP3"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v1, 0x3

    goto :goto_0

    :pswitch_4
    const-string v2, "TAG_TIP4"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v1, 0x4

    goto :goto_0

    :pswitch_5
    const-string v2, "TAG_TIP5"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v1, 0x5

    goto :goto_0

    .line 131
    :pswitch_6
    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsListFragment$1;->a:Lcom/jibo/ui/fragment/tips/TipsListFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/tips/TipsListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    sget-object v2, Lcom/jibo/JiboAnalytics;->aK:Ljava/lang/String;

    invoke-static {v1, v2}, Lcom/jibo/JiboAnalytics;->f(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_1

    .line 134
    :pswitch_7
    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsListFragment$1;->a:Lcom/jibo/ui/fragment/tips/TipsListFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/tips/TipsListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    sget-object v2, Lcom/jibo/JiboAnalytics;->aL:Ljava/lang/String;

    invoke-static {v1, v2}, Lcom/jibo/JiboAnalytics;->f(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_1

    .line 137
    :pswitch_8
    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsListFragment$1;->a:Lcom/jibo/ui/fragment/tips/TipsListFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/tips/TipsListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    sget-object v2, Lcom/jibo/JiboAnalytics;->aM:Ljava/lang/String;

    invoke-static {v1, v2}, Lcom/jibo/JiboAnalytics;->f(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_1

    .line 140
    :pswitch_9
    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsListFragment$1;->a:Lcom/jibo/ui/fragment/tips/TipsListFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/tips/TipsListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    sget-object v2, Lcom/jibo/JiboAnalytics;->aN:Ljava/lang/String;

    invoke-static {v1, v2}, Lcom/jibo/JiboAnalytics;->f(Landroid/content/Context;Ljava/lang/String;)V

    goto/16 :goto_1

    .line 143
    :pswitch_a
    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsListFragment$1;->a:Lcom/jibo/ui/fragment/tips/TipsListFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/tips/TipsListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    sget-object v2, Lcom/jibo/JiboAnalytics;->aO:Ljava/lang/String;

    invoke-static {v1, v2}, Lcom/jibo/JiboAnalytics;->f(Landroid/content/Context;Ljava/lang/String;)V

    goto/16 :goto_1

    .line 146
    :pswitch_b
    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsListFragment$1;->a:Lcom/jibo/ui/fragment/tips/TipsListFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/tips/TipsListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    sget-object v2, Lcom/jibo/JiboAnalytics;->aP:Ljava/lang/String;

    invoke-static {v1, v2}, Lcom/jibo/JiboAnalytics;->f(Landroid/content/Context;Ljava/lang/String;)V

    goto/16 :goto_1

    .line 129
    nop

    :pswitch_data_0
    .packed-switch 0x2e1dcba
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
    .end packed-switch

    :pswitch_data_1
    .packed-switch 0x0
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_9
        :pswitch_a
        :pswitch_b
    .end packed-switch
.end method
