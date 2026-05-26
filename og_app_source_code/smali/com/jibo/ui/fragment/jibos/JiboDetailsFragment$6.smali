.class Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$6;
.super Ljava/lang/Object;
.source "JiboDetailsFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->a(Ljava/util/Collection;)V
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
    .line 306
    iput-object p1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$6;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 309
    new-instance v0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$6;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const-class v2, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 310
    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment$6;->a:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-static {v2}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->e(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Landroid/os/Parcelable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    move-result-object v0

    const/16 v1, 0x3eb

    .line 311
    invoke-virtual {v0, v1}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(I)V

    .line 313
    return-void
.end method
