.class Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder$1;
.super Ljava/lang/Object;
.source "MediaFragment.java"

# interfaces
.implements Lcom/bumptech/glide/request/RequestListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->a(ILcom/jibo/aws/integration/aws/services/media/model/Media;Z)V
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
.field final synthetic a:Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;)V
    .locals 0

    .prologue
    .line 1040
    iput-object p1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder$1;->a:Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/bumptech/glide/load/resource/drawable/GlideDrawable;Ljava/lang/String;Lcom/bumptech/glide/request/target/Target;ZZ)Z
    .locals 1
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
    .line 1058
    const/4 v0, 0x0

    return v0
.end method

.method public bridge synthetic a(Ljava/lang/Exception;Ljava/lang/Object;Lcom/bumptech/glide/request/target/Target;Z)Z
    .locals 1

    .prologue
    .line 1040
    check-cast p2, Ljava/lang/String;

    invoke-virtual {p0, p1, p2, p3, p4}, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder$1;->a(Ljava/lang/Exception;Ljava/lang/String;Lcom/bumptech/glide/request/target/Target;Z)Z

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
    .line 1044
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder$1;->a:Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;

    invoke-static {v0}, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->a(Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;)Lcom/jibo/ui/fragment/home/MediaFragment;

    move-result-object v0

    new-instance v1, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder$1$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder$1$1;-><init>(Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder$1;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/home/MediaFragment;->a(Ljava/lang/Runnable;)V

    .line 1051
    const/4 v0, 0x0

    return v0
.end method

.method public bridge synthetic a(Ljava/lang/Object;Ljava/lang/Object;Lcom/bumptech/glide/request/target/Target;ZZ)Z
    .locals 6

    .prologue
    .line 1040
    move-object v1, p1

    check-cast v1, Lcom/bumptech/glide/load/resource/drawable/GlideDrawable;

    move-object v2, p2

    check-cast v2, Ljava/lang/String;

    move-object v0, p0

    move-object v3, p3

    move v4, p4

    move v5, p5

    invoke-virtual/range {v0 .. v5}, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder$1;->a(Lcom/bumptech/glide/load/resource/drawable/GlideDrawable;Ljava/lang/String;Lcom/bumptech/glide/request/target/Target;ZZ)Z

    move-result v0

    return v0
.end method
