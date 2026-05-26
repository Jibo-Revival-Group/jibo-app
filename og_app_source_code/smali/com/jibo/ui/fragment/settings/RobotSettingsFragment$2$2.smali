.class Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2$2;
.super Ljava/lang/Object;
.source "RobotSettingsFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;->a(Lcom/jibo/aws/integration/aws/services/key/model/RestoreRequest;Lcom/jibo/aws/integration/aws/services/key/model/Backup;)V
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
    .line 287
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2$2;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    const v2, 0x7f08013f

    .line 290
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2$2;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->btnPassphrase:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 291
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2$2;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;

    iget-boolean v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;->a:Z

    if-eqz v0, :cond_0

    .line 292
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2$2;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->passphraseText:Landroid/widget/TextView;

    const v1, 0x7f100271

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 293
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2$2;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->iconPassphrase:Landroid/widget/ImageView;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 294
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2$2;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->btnPassphrase:Landroid/view/View;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2$2;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;

    iget-object v1, v1, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->a(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)Landroid/view/View$OnClickListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 300
    :goto_0
    return-void

    .line 296
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2$2;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->passphraseText:Landroid/widget/TextView;

    const v1, 0x7f100273

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 297
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2$2;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->iconPassphrase:Landroid/widget/ImageView;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 298
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2$2;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->btnPassphrase:Landroid/view/View;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2$2;->a:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;

    iget-object v1, v1, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;->b:Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->b(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)Landroid/view/View$OnClickListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0
.end method
