.class public Lcom/jibo/ui/fragment/avatar/AvatarViewHolder_ViewBinding;
.super Ljava/lang/Object;
.source "AvatarViewHolder_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/avatar/AvatarViewHolder;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/avatar/AvatarViewHolder;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    iput-object p1, p0, Lcom/jibo/ui/fragment/avatar/AvatarViewHolder_ViewBinding;->b:Lcom/jibo/ui/fragment/avatar/AvatarViewHolder;

    .line 20
    const v0, 0x1020006

    const-string v1, "field \'avatar\'"

    const-class v2, Landroid/widget/ImageView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/avatar/AvatarViewHolder;->avatar:Landroid/widget/ImageView;

    .line 21
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 26
    iget-object v0, p0, Lcom/jibo/ui/fragment/avatar/AvatarViewHolder_ViewBinding;->b:Lcom/jibo/ui/fragment/avatar/AvatarViewHolder;

    .line 27
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 28
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/avatar/AvatarViewHolder_ViewBinding;->b:Lcom/jibo/ui/fragment/avatar/AvatarViewHolder;

    .line 30
    iput-object v1, v0, Lcom/jibo/ui/fragment/avatar/AvatarViewHolder;->avatar:Landroid/widget/ImageView;

    .line 31
    return-void
.end method
