.class Lcom/jibo/ui/activity/LoopInviteDetailsActivity$1;
.super Ljava/lang/Object;
.source "LoopInviteDetailsActivity.java"

# interfaces
.implements Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$OnDismissListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->onJoinClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;


# direct methods
.method constructor <init>(Lcom/jibo/ui/activity/LoopInviteDetailsActivity;)V
    .locals 0

    .prologue
    .line 125
    iput-object p1, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$1;->a:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;)V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 128
    sget-object v0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;->Success:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

    if-ne p1, v0, :cond_0

    .line 129
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$1;->a:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

    invoke-static {v0}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->a(Lcom/jibo/ui/activity/LoopInviteDetailsActivity;)V

    .line 134
    :goto_0
    return-void

    .line 131
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$1;->a:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

    iget-object v0, v0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->buttonAccept:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setClickable(Z)V

    .line 132
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity$1;->a:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

    iget-object v0, v0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->buttonDecline:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setClickable(Z)V

    goto :goto_0
.end method
