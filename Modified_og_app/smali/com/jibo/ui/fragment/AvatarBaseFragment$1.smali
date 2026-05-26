.class Lcom/jibo/ui/fragment/AvatarBaseFragment$1;
.super Ljava/lang/Object;
.source "AvatarBaseFragment.java"

# interfaces
.implements Lcom/bumptech/glide/request/RequestListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/AvatarBaseFragment;->a(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/bumptech/glide/request/RequestListener",
        "<",
        "Ljava/lang/String;",
        "Lcom/bumptech/glide/load/resource/drawable/GlideDrawable;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/AvatarBaseFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/AvatarBaseFragment;)V
    .locals 0

    .prologue
    .line 152
    iput-object p1, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$1;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/bumptech/glide/load/resource/drawable/GlideDrawable;Ljava/lang/String;Lcom/bumptech/glide/request/target/Target;ZZ)Z
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bumptech/glide/load/resource/drawable/GlideDrawable;",
            "Ljava/lang/String;",
            "Lcom/bumptech/glide/request/target/Target",
            "<",
            "Lcom/bumptech/glide/load/resource/drawable/GlideDrawable;",
            ">;ZZ)Z"
        }
    .end annotation

    .prologue
    .line 167
    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$1;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$1;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->isFinishing()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$1;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->isRemoving()Z

    move-result v0

    if-nez v0, :cond_0

    .line 168
    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$1;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/AvatarBaseFragment;->photoProgressBar:Landroid/widget/ProgressBar;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 170
    :cond_0
    const/4 v0, 0x0

    return v0
.end method

.method public bridge synthetic a(Ljava/lang/Exception;Ljava/lang/Object;Lcom/bumptech/glide/request/target/Target;Z)Z
    .locals 1

    .prologue
    .line 152
    check-cast p2, Ljava/lang/String;

    invoke-virtual {p0, p1, p2, p3, p4}, Lcom/jibo/ui/fragment/AvatarBaseFragment$1;->a(Ljava/lang/Exception;Ljava/lang/String;Lcom/bumptech/glide/request/target/Target;Z)Z

    move-result v0

    return v0
.end method

.method public a(Ljava/lang/Exception;Ljava/lang/String;Lcom/bumptech/glide/request/target/Target;Z)Z
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Exception;",
            "Ljava/lang/String;",
            "Lcom/bumptech/glide/request/target/Target",
            "<",
            "Lcom/bumptech/glide/load/resource/drawable/GlideDrawable;",
            ">;Z)Z"
        }
    .end annotation

    .prologue
    .line 156
    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$1;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$1;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->isFinishing()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$1;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/AvatarBaseFragment;->isRemoving()Z

    move-result v0

    if-nez v0, :cond_0

    .line 157
    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment$1;->a:Lcom/jibo/ui/fragment/AvatarBaseFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/AvatarBaseFragment;->photoProgressBar:Landroid/widget/ProgressBar;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 159
    :cond_0
    const/4 v0, 0x0

    return v0
.end method

.method public bridge synthetic a(Ljava/lang/Object;Ljava/lang/Object;Lcom/bumptech/glide/request/target/Target;ZZ)Z
    .locals 6

    .prologue
    .line 152
    move-object v1, p1

    check-cast v1, Lcom/bumptech/glide/load/resource/drawable/GlideDrawable;

    move-object v2, p2

    check-cast v2, Ljava/lang/String;

    move-object v0, p0

    move-object v3, p3

    move v4, p4

    move v5, p5

    invoke-virtual/range {v0 .. v5}, Lcom/jibo/ui/fragment/AvatarBaseFragment$1;->a(Lcom/bumptech/glide/load/resource/drawable/GlideDrawable;Ljava/lang/String;Lcom/bumptech/glide/request/target/Target;ZZ)Z

    move-result v0

    return v0
.end method
