.class Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder$1$1;
.super Ljava/lang/Object;
.source "ViewHolders.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder$1;->onAnimationEnd(Landroid/animation/Animator;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder$1;


# direct methods
.method constructor <init>(Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder$1;)V
    .locals 0

    .prologue
    .line 628
    iput-object p1, p0, Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder$1$1;->a:Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 631
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder$1$1;->a:Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder$1;

    iget-object v0, v0, Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder$1;->a:Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder;

    invoke-static {v0}, Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder;->a(Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder;)Ljava/util/concurrent/atomic/AtomicBoolean;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 632
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder$1$1;->a:Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder$1;

    iget-object v0, v0, Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder$1;->a:Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/ViewHolders$InviteMemberViewHolder;->invalidateView()V

    .line 633
    return-void
.end method
