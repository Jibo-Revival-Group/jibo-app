.class Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder$1$1;
.super Ljava/lang/Object;
.source "MediaFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder$1;->a(Ljava/lang/Exception;Ljava/lang/String;Lcom/bumptech/glide/request/target/Target;Z)Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder$1;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder$1;)V
    .locals 0

    .prologue
    .line 1044
    iput-object p1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder$1$1;->a:Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 1048
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder$1$1;->a:Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder$1;->a:Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;

    iget-object v0, v0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->photo:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 1049
    return-void
.end method
