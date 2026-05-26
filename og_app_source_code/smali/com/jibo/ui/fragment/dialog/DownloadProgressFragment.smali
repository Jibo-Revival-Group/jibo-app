.class public Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;
.super Landroid/support/v4/app/DialogFragment;
.source "DownloadProgressFragment.java"


# instance fields
.field private a:Ljava/lang/Thread;

.field private b:Landroid/os/Handler;

.field private c:Landroid/os/Handler$Callback;

.field private d:I

.field private e:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private f:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    .line 69
    invoke-direct {p0}, Landroid/support/v4/app/DialogFragment;-><init>()V

    .line 43
    new-instance v0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$1;-><init>(Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->c:Landroid/os/Handler$Callback;

    .line 65
    const/4 v0, 0x0

    iput v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->d:I

    .line 67
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->f:Ljava/util/ArrayList;

    .line 70
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->c:Landroid/os/Handler$Callback;

    invoke-direct {v0, v1, v2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;Landroid/os/Handler$Callback;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->b:Landroid/os/Handler;

    .line 71
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->f:Ljava/util/ArrayList;

    return-object v0
.end method

.method private a()Z
    .locals 1

    .prologue
    .line 232
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->isFinishing()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->isDetached()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->isResumed()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;)Ljava/lang/Thread;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->a:Ljava/lang/Thread;

    return-object v0
.end method

.method static synthetic c(Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;)Z
    .locals 1

    .prologue
    .line 35
    invoke-direct {p0}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->a()Z

    move-result v0

    return v0
.end method

.method static synthetic d(Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;)I
    .locals 1

    .prologue
    .line 35
    iget v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->d:I

    return v0
.end method

.method static synthetic e(Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->e:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic f(Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;)Landroid/os/Handler;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->b:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic g(Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;)I
    .locals 2

    .prologue
    .line 35
    iget v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->d:I

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->d:I

    return v0
.end method


# virtual methods
.method public onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    .locals 4

    .prologue
    const/4 v2, 0x0

    .line 76
    if-eqz p1, :cond_1

    .line 77
    const-string v0, "ARG_IDS"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->e:Ljava/util/ArrayList;

    .line 78
    const-string v0, "ARG_PATHS"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->f:Ljava/util/ArrayList;

    .line 79
    const-string v0, "ARG_INDX"

    invoke-virtual {p1, v0, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->d:I

    .line 85
    :cond_0
    :goto_0
    new-instance v0, Landroid/app/ProgressDialog;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;)V

    .line 86
    const v1, 0x7f100105

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setTitle(Ljava/lang/CharSequence;)V

    .line 87
    invoke-virtual {v0, v2}, Landroid/app/ProgressDialog;->setIndeterminate(Z)V

    .line 88
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setProgressStyle(I)V

    .line 89
    new-instance v1, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$2;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$2;-><init>(Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;)V

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    .line 94
    invoke-virtual {v0, v2}, Landroid/app/ProgressDialog;->setCanceledOnTouchOutside(Z)V

    .line 95
    const/4 v1, -0x2

    const/high16 v2, 0x1040000

    invoke-virtual {p0, v2}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$3;

    invoke-direct {v3, p0}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$3;-><init>(Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;)V

    invoke-virtual {v0, v1, v2, v3}, Landroid/app/ProgressDialog;->setButton(ILjava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)V

    .line 102
    return-object v0

    .line 80
    :cond_1
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 81
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ARG_IDS"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->e:Ljava/util/ArrayList;

    .line 82
    iput v2, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->d:I

    goto :goto_0
.end method

.method public onPause()V
    .locals 2

    .prologue
    .line 215
    invoke-super {p0}, Landroid/support/v4/app/DialogFragment;->onPause()V

    .line 217
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->a:Ljava/lang/Thread;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->a:Ljava/lang/Thread;

    invoke-virtual {v0}, Ljava/lang/Thread;->isInterrupted()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->a:Ljava/lang/Thread;

    invoke-virtual {v0}, Ljava/lang/Thread;->interrupt()V

    .line 219
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->b:Landroid/os/Handler;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    .line 220
    return-void
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 107
    invoke-super {p0}, Landroid/support/v4/app/DialogFragment;->onResume()V

    .line 109
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->e:Ljava/util/ArrayList;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->e:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 110
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->getDialog()Landroid/app/Dialog;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Dialog;->dismiss()V

    .line 205
    :goto_0
    return-void

    .line 113
    :cond_1
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->getDialog()Landroid/app/Dialog;

    move-result-object v0

    check-cast v0, Landroid/app/ProgressDialog;

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->e:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setMax(I)V

    .line 114
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->getDialog()Landroid/app/Dialog;

    move-result-object v0

    check-cast v0, Landroid/app/ProgressDialog;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setProgress(I)V

    .line 116
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$4;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment$4;-><init>(Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->a:Ljava/lang/Thread;

    .line 204
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->a:Ljava/lang/Thread;

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    goto :goto_0
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 224
    invoke-super {p0, p1}, Landroid/support/v4/app/DialogFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 226
    const-string v0, "ARG_INDX"

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->e:Ljava/util/ArrayList;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 227
    const-string v0, "ARG_PATHS"

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->f:Ljava/util/ArrayList;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 228
    const-string v0, "ARG_INDX"

    iget v1, p0, Lcom/jibo/ui/fragment/dialog/DownloadProgressFragment;->d:I

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 229
    return-void
.end method

.method public onStart()V
    .locals 0

    .prologue
    .line 209
    invoke-super {p0}, Landroid/support/v4/app/DialogFragment;->onStart()V

    .line 211
    return-void
.end method
