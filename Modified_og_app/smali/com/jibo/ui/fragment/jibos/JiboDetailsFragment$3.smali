.class Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$3;
.super Landroid/content/BroadcastReceiver;
.source "JiboDetailsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)V
    .locals 0

    .prologue
    .line 181
    iput-object p1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$3;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 2

    .prologue
    .line 184
    const-string v0, "LOOP_HOLIDAYS_ALARM_ACTION"

    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$3;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    .line 185
    invoke-static {v0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->b(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v0

    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 186
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$3;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$3;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->c(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/ui/fragment/dialog/HolidaysPopupFragment;->a(Landroid/support/v4/app/FragmentManager;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    .line 188
    :cond_0
    return-void
.end method
