.class Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$1;
.super Ljava/lang/Object;
.source "DownloadProgressFragment.java"

# interfaces
.implements Landroid/os/Handler$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;)V
    .locals 0

    .prologue
    .line 43
    iput-object p1, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$1;->a:Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)Z
    .locals 4

    .prologue
    .line 47
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$1;->a:Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$1;->a:Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->isFinishing()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$1;->a:Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->isDetached()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$1;->a:Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->isResumed()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 49
    iget v0, p1, Landroid/os/Message;->what:I

    if-ltz v0, :cond_1

    .line 50
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$1;->a:Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->getDialog()Landroid/app/Dialog;

    move-result-object v0

    check-cast v0, Landroid/app/ProgressDialog;

    iget v1, p1, Landroid/os/Message;->what:I

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setProgress(I)V

    .line 62
    :cond_0
    :goto_0
    const/4 v0, 0x1

    return v0

    .line 53
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$1;->a:Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$1;->a:Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;

    .line 54
    invoke-virtual {v0}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    instance-of v0, v0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapperClickListener;

    if-eqz v0, :cond_2

    .line 55
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$1;->a:Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapperClickListener;

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$1;->a:Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->getTargetRequestCode()I

    move-result v1

    const/4 v2, -0x1

    iget-object v3, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$1;->a:Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;

    .line 56
    invoke-static {v3}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->a(Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;)Ljava/util/ArrayList;

    move-result-object v3

    .line 55
    invoke-interface {v0, v1, v2, v3}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapperClickListener;->a(IILjava/lang/Object;)V

    .line 58
    :cond_2
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$1;->a:Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->getDialog()Landroid/app/Dialog;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Dialog;->dismiss()V

    goto :goto_0
.end method
