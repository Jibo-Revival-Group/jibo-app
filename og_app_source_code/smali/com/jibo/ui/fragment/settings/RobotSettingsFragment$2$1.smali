.class Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2$1;
.super Ljava/lang/Object;
.source "RobotSettingsFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;->onError(Ljava/lang/Exception;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;)V
    .locals 0

    .prologue
    .line 267
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2$1;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 270
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2$1;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->btnPassphrase:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 271
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2$1;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;

    iget-boolean v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;->a:Z

    if-eqz v0, :cond_0

    .line 272
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2$1;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->passphraseText:Landroid/widget/TextView;

    const v1, 0x7f1000d7

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 273
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2$1;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->iconPassphrase:Landroid/widget/ImageView;

    const v1, 0x7f080139

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 274
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2$1;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->btnPassphrase:Landroid/view/View;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2$1;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;

    iget-object v1, v1, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->a(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)Landroid/view/View$OnClickListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 281
    :goto_0
    return-void

    .line 276
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2$1;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->passphraseText:Landroid/widget/TextView;

    const v1, 0x7f100274

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 277
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2$1;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->iconPassphrase:Landroid/widget/ImageView;

    const v1, 0x7f080233

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 278
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2$1;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->btnPassphrase:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 279
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2$1;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->passphraseText:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2$1;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;

    iget-object v1, v1, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0600c6

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    goto :goto_0
.end method
