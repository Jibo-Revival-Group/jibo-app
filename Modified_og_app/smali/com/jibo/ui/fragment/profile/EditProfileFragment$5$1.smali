.class Lcom/jibo/ui/fragment/profile/EditProfileFragment$5$1;
.super Ljava/lang/Object;
.source "EditProfileFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/profile/EditProfileFragment$5;->a(Lcom/jibo/aws/integration/aws/services/loop/model/InviteMemberRequest;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/profile/EditProfileFragment$5;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/profile/EditProfileFragment$5;)V
    .locals 0

    .prologue
    .line 544
    iput-object p1, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$5$1;->a:Lcom/jibo/ui/fragment/profile/EditProfileFragment$5;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 547
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$5$1;->a:Lcom/jibo/ui/fragment/profile/EditProfileFragment$5;

    iget-object v0, v0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$5;->a:Lcom/jibo/ui/fragment/profile/EditProfileFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->avatar:Landroid/widget/ImageView;

    const v1, 0x7f100120

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Landroid/support/design/widget/Snackbar;->a(Landroid/view/View;II)Landroid/support/design/widget/Snackbar;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/design/widget/Snackbar;->c()V

    .line 548
    return-void
.end method
