.class Lcom/jibo/ui/fragment/profile/EditProfileFragment$1$1;
.super Ljava/lang/Object;
.source "EditProfileFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/profile/EditProfileFragment$1;->a(Lcom/jibo/aws/integration/aws/services/loop/model/UpdateMemberPhotoRequest;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/profile/EditProfileFragment$1;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/profile/EditProfileFragment$1;)V
    .locals 0

    .prologue
    .line 233
    iput-object p1, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$1$1;->a:Lcom/jibo/ui/fragment/profile/EditProfileFragment$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 236
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$1$1;->a:Lcom/jibo/ui/fragment/profile/EditProfileFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$1;->a:Lcom/jibo/ui/fragment/profile/EditProfileFragment;

    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$1$1;->a:Lcom/jibo/ui/fragment/profile/EditProfileFragment$1;

    iget-object v1, v1, Lcom/jibo/ui/fragment/profile/EditProfileFragment$1;->a:Lcom/jibo/ui/fragment/profile/EditProfileFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->b(Lcom/jibo/ui/fragment/profile/EditProfileFragment;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->b(Ljava/lang/String;)V

    .line 237
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$1$1;->a:Lcom/jibo/ui/fragment/profile/EditProfileFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$1;->a:Lcom/jibo/ui/fragment/profile/EditProfileFragment;

    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/EditProfileFragment$1$1;->a:Lcom/jibo/ui/fragment/profile/EditProfileFragment$1;

    iget-object v1, v1, Lcom/jibo/ui/fragment/profile/EditProfileFragment$1;->a:Lcom/jibo/ui/fragment/profile/EditProfileFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->c(Lcom/jibo/ui/fragment/profile/EditProfileFragment;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/ui/fragment/profile/EditProfileFragment;->b(Lcom/jibo/ui/fragment/profile/EditProfileFragment;Ljava/lang/String;)V

    .line 238
    return-void
.end method
