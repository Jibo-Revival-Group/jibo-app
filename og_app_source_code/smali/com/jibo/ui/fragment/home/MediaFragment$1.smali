.class Lcom/jibo/ui/fragment/home/MediaFragment$1;
.super Ljava/lang/Object;
.source "MediaFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/home/MediaFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/home/MediaFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/home/MediaFragment;)V
    .locals 0

    .prologue
    .line 131
    iput-object p1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$1;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 134
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$1;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->a(Lcom/jibo/ui/fragment/home/MediaFragment;)Lcom/jibo/ui/activity/TabbedActivity;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/activity/TabbedActivity;->r()Landroid/support/v7/view/ActionMode;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$1;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->b(Lcom/jibo/ui/fragment/home/MediaFragment;)Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;->a()I

    move-result v0

    if-nez v0, :cond_0

    .line 135
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$1;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->c(Lcom/jibo/ui/fragment/home/MediaFragment;)Lcom/jibo/ui/activity/TabbedActivity;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/activity/TabbedActivity;->r()Landroid/support/v7/view/ActionMode;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v7/view/ActionMode;->c()V

    .line 137
    :cond_0
    return-void
.end method
