.class Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$4;
.super Ljava/lang/Object;
.source "CircleProgressFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->b()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;)V
    .locals 0

    .prologue
    .line 169
    iput-object p1, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$4;->a:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    const/16 v1, 0x8

    const/4 v2, 0x0

    .line 172
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$4;->a:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    iget-object v3, v0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->mProgressStatusText:Landroid/widget/TextView;

    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$4;->a:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->c(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;)Landroid/text/SpannableStringBuilder;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    move v0, v1

    :goto_0
    invoke-virtual {v3, v0}, Landroid/widget/TextView;->setVisibility(I)V

    .line 173
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$4;->a:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->mProgressStatusText:Landroid/widget/TextView;

    iget-object v3, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$4;->a:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-static {v3}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->c(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;)Landroid/text/SpannableStringBuilder;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 174
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$4;->a:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->mProgressStatusText:Landroid/widget/TextView;

    iget-object v3, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$4;->a:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-virtual {v3}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f06001f

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setTextColor(I)V

    .line 176
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$4;->a:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;)Landroid/graphics/drawable/AnimationDrawable;

    move-result-object v0

    invoke-virtual {v0}, Landroid/graphics/drawable/AnimationDrawable;->stop()V

    .line 177
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$4;->a:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->mProgressCircle:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 179
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$4;->a:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->mProgressSuccess:Landroid/widget/ImageView;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 180
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$4;->a:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->d(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;)Landroid/graphics/drawable/AnimationDrawable;

    move-result-object v0

    invoke-virtual {v0}, Landroid/graphics/drawable/AnimationDrawable;->start()V

    .line 182
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$4;->a:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->f(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;)Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment$4;->a:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->e(Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;)Ljava/lang/Runnable;

    move-result-object v1

    const-wide/16 v2, 0x5dc

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 183
    return-void

    :cond_0
    move v0, v2

    .line 172
    goto :goto_0
.end method
