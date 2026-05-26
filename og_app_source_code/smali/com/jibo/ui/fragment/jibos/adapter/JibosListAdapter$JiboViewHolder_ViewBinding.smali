.class public Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder_ViewBinding;
.super Ljava/lang/Object;
.source "JibosListAdapter$JiboViewHolder_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    iput-object p1, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder_ViewBinding;->b:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder;

    .line 23
    const v0, 0x1020006

    const-string v1, "field \'avatar\'"

    const-class v2, Landroid/widget/ImageView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder;->avatar:Landroid/widget/ImageView;

    .line 24
    const v0, 0x1020014

    const-string v1, "field \'titleText\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder;->titleText:Landroid/widget/TextView;

    .line 25
    const v0, 0x1020015

    const-string v1, "field \'ownerText\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder;->ownerText:Landroid/widget/TextView;

    .line 26
    const v0, 0x7f0901cb

    const-string v1, "field \'loopSuspended\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder;->loopSuspended:Landroid/widget/TextView;

    .line 27
    const v0, 0x7f0900c3

    const-string v1, "field \'checkbox\'"

    const-class v2, Landroid/widget/ImageView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder;->checkbox:Landroid/widget/ImageView;

    .line 28
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 33
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder_ViewBinding;->b:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder;

    .line 34
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 35
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder_ViewBinding;->b:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder;

    .line 37
    iput-object v1, v0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder;->avatar:Landroid/widget/ImageView;

    .line 38
    iput-object v1, v0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder;->titleText:Landroid/widget/TextView;

    .line 39
    iput-object v1, v0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder;->ownerText:Landroid/widget/TextView;

    .line 40
    iput-object v1, v0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder;->loopSuspended:Landroid/widget/TextView;

    .line 41
    iput-object v1, v0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder;->checkbox:Landroid/widget/ImageView;

    .line 42
    return-void
.end method
