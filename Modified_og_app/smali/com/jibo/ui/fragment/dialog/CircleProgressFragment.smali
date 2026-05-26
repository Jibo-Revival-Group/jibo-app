.class public Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
.super Landroid/support/v4/app/DialogFragment;
.source "CircleProgressFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$OnDismissListener;,
        Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;
    }
.end annotation


# instance fields
.field private a:Landroid/text/SpannableStringBuilder;

.field private b:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

.field private c:Landroid/graphics/drawable/AnimationDrawable;

.field private d:Landroid/graphics/drawable/AnimationDrawable;

.field private e:Landroid/graphics/drawable/AnimationDrawable;

.field private f:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$OnDismissListener;

.field private g:Landroid/os/Handler;

.field private final h:Ljava/lang/Runnable;

.field private i:Landroid/view/View;

.field private j:Z

.field mProgressCircle:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field mProgressFailure:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field mProgressStatusText:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field mProgressSuccess:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 26
    invoke-direct {p0}, Landroid/support/v4/app/DialogFragment;-><init>()V

    .line 43
    sget-object v0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;->InProgress:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->b:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

    .line 56
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->g:Landroid/os/Handler;

    .line 57
    new-instance v0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$1;-><init>(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->h:Ljava/lang/Runnable;

    .line 66
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->j:Z

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;)Landroid/graphics/drawable/AnimationDrawable;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->c:Landroid/graphics/drawable/AnimationDrawable;

    return-object v0
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->b:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

    return-object v0
.end method

.method private b()V
    .locals 2

    .prologue
    .line 164
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->isResumed()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->isFinishing()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 165
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a()V

    .line 185
    :goto_0
    return-void

    .line 169
    :cond_1
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    new-instance v1, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$4;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$4;-><init>(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;)V

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    goto :goto_0
.end method

.method static synthetic c(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;)Landroid/text/SpannableStringBuilder;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a:Landroid/text/SpannableStringBuilder;

    return-object v0
.end method

.method private c()V
    .locals 2

    .prologue
    .line 192
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->isResumed()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->isFinishing()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 193
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a()V

    .line 214
    :goto_0
    return-void

    .line 197
    :cond_1
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    new-instance v1, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$5;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$5;-><init>(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;)V

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    goto :goto_0
.end method

.method static synthetic d(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;)Landroid/graphics/drawable/AnimationDrawable;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->d:Landroid/graphics/drawable/AnimationDrawable;

    return-object v0
.end method

.method static synthetic e(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;)Ljava/lang/Runnable;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->h:Ljava/lang/Runnable;

    return-object v0
.end method

.method static synthetic f(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;)Landroid/os/Handler;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->g:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic g(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;)Landroid/graphics/drawable/AnimationDrawable;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->e:Landroid/graphics/drawable/AnimationDrawable;

    return-object v0
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 149
    :try_start_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->isResumed()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->isDetached()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->isFinishing()Z

    move-result v0

    if-nez v0, :cond_0

    .line 150
    invoke-super {p0}, Landroid/support/v4/app/DialogFragment;->dismiss()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 155
    :cond_0
    :goto_0
    return-void

    .line 152
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public a(Landroid/text/SpannableStringBuilder;)V
    .locals 1

    .prologue
    .line 224
    sget-object v0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;->Success:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->b:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

    .line 225
    invoke-virtual {p0, p1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->c(Landroid/text/SpannableStringBuilder;)V

    .line 226
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->j:Z

    .line 228
    invoke-direct {p0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->b()V

    .line 229
    return-void
.end method

.method public a(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$OnDismissListener;)V
    .locals 0

    .prologue
    .line 53
    iput-object p1, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->f:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$OnDismissListener;

    .line 54
    return-void
.end method

.method public a(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 237
    new-instance v0, Landroid/text/SpannableStringBuilder;

    invoke-direct {v0, p1}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a(Landroid/text/SpannableStringBuilder;)V

    .line 238
    return-void
.end method

.method public b(Landroid/text/SpannableStringBuilder;)V
    .locals 1

    .prologue
    .line 246
    sget-object v0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;->Failure:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->b:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

    .line 247
    invoke-virtual {p0, p1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->c(Landroid/text/SpannableStringBuilder;)V

    .line 248
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->j:Z

    .line 250
    invoke-direct {p0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->c()V

    .line 251
    return-void
.end method

.method public b(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 259
    new-instance v0, Landroid/text/SpannableStringBuilder;

    invoke-direct {v0, p1}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->b(Landroid/text/SpannableStringBuilder;)V

    .line 260
    return-void
.end method

.method public c(Landroid/text/SpannableStringBuilder;)V
    .locals 0

    .prologue
    .line 268
    iput-object p1, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a:Landroid/text/SpannableStringBuilder;

    .line 269
    return-void
.end method

.method public c(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 277
    new-instance v0, Landroid/text/SpannableStringBuilder;

    invoke-direct {v0, p1}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a:Landroid/text/SpannableStringBuilder;

    .line 278
    return-void
.end method

.method public dismiss()V
    .locals 2

    .prologue
    .line 140
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->f:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$OnDismissListener;

    if-eqz v0, :cond_0

    .line 141
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->f:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$OnDismissListener;

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->b:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

    invoke-interface {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$OnDismissListener;->a(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;)V

    .line 144
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a()V

    .line 145
    return-void
.end method

.method public onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    .locals 5

    .prologue
    const/4 v1, 0x0

    .line 70
    new-instance v2, Landroid/support/v7/app/AppCompatDialog;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const v3, 0x1030009

    invoke-direct {v2, v0, v3}, Landroid/support/v7/app/AppCompatDialog;-><init>(Landroid/content/Context;I)V

    .line 71
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    const v3, 0x7f0b0056

    const/4 v4, 0x0

    invoke-virtual {v0, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->i:Landroid/view/View;

    .line 72
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->i:Landroid/view/View;

    invoke-static {p0, v0}, Lbutterknife/ButterKnife;->a(Ljava/lang/Object;Landroid/view/View;)Lbutterknife/Unbinder;

    .line 74
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->mProgressCircle:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    check-cast v0, Landroid/graphics/drawable/AnimationDrawable;

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->c:Landroid/graphics/drawable/AnimationDrawable;

    .line 75
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->mProgressSuccess:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    check-cast v0, Landroid/graphics/drawable/AnimationDrawable;

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->d:Landroid/graphics/drawable/AnimationDrawable;

    .line 76
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->mProgressFailure:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    check-cast v0, Landroid/graphics/drawable/AnimationDrawable;

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->e:Landroid/graphics/drawable/AnimationDrawable;

    .line 78
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->mProgressCircle:Landroid/widget/ImageView;

    new-instance v3, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$2;

    invoke-direct {v3, p0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$2;-><init>(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;)V

    invoke-virtual {v0, v3}, Landroid/widget/ImageView;->post(Ljava/lang/Runnable;)Z

    .line 87
    iget-object v3, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->mProgressStatusText:Landroid/widget/TextView;

    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a:Landroid/text/SpannableStringBuilder;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/16 v0, 0x8

    :goto_0
    invoke-virtual {v3, v0}, Landroid/widget/TextView;->setVisibility(I)V

    .line 88
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->mProgressStatusText:Landroid/widget/TextView;

    iget-object v3, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a:Landroid/text/SpannableStringBuilder;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 89
    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->setCancelable(Z)V

    .line 91
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->i:Landroid/view/View;

    invoke-virtual {v2, v0}, Landroid/support/v7/app/AppCompatDialog;->setContentView(Landroid/view/View;)V

    .line 92
    invoke-virtual {v2, v1}, Landroid/support/v7/app/AppCompatDialog;->setCancelable(Z)V

    .line 94
    return-object v2

    :cond_0
    move v0, v1

    .line 87
    goto :goto_0
.end method

.method public onDestroyView()V
    .locals 0

    .prologue
    .line 135
    invoke-super {p0}, Landroid/support/v4/app/DialogFragment;->onDestroyView()V

    .line 136
    return-void
.end method

.method public onPause()V
    .locals 2

    .prologue
    .line 129
    invoke-super {p0}, Landroid/support/v4/app/DialogFragment;->onPause()V

    .line 130
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->g:Landroid/os/Handler;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    .line 131
    return-void
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 99
    invoke-super {p0}, Landroid/support/v4/app/DialogFragment;->onResume()V

    .line 100
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->b:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

    sget-object v1, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;->InProgress:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

    if-eq v0, v1, :cond_0

    .line 101
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->j:Z

    .line 102
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->b:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

    sget-object v1, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;->Success:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

    if-ne v0, v1, :cond_2

    .line 103
    invoke-direct {p0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->b()V

    .line 109
    :cond_0
    :goto_0
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x15

    if-lt v0, v1, :cond_1

    .line 110
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->i:Landroid/view/View;

    new-instance v1, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$3;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$3;-><init>(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->addOnLayoutChangeListener(Landroid/view/View$OnLayoutChangeListener;)V

    .line 125
    :cond_1
    return-void

    .line 104
    :cond_2
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->b:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

    sget-object v1, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;->Failure:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$Status;

    if-ne v0, v1, :cond_0

    .line 105
    invoke-direct {p0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->c()V

    goto :goto_0
.end method
