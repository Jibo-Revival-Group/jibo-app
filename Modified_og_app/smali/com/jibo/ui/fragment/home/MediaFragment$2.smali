.class Lcom/jibo/ui/fragment/home/MediaFragment$2;
.super Ljava/lang/Object;
.source "MediaFragment.java"

# interfaces
.implements Landroid/support/v7/view/ActionMode$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/home/MediaFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/home/MediaFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/home/MediaFragment;)V
    .locals 0

    .prologue
    .line 141
    iput-object p1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$2;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/support/v7/view/ActionMode;)V
    .locals 4

    .prologue
    .line 187
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$2;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->f(Lcom/jibo/ui/fragment/home/MediaFragment;)Lcom/jibo/ui/activity/TabbedActivity;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/jibo/ui/activity/TabbedActivity;->a(Landroid/support/v7/view/ActionMode;)V

    .line 189
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$2;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->b(Lcom/jibo/ui/fragment/home/MediaFragment;)Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;->b()V

    .line 190
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$2;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->g(Lcom/jibo/ui/fragment/home/MediaFragment;)Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    move-result-object v0

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/jibo/ui/fragment/home/MediaFragment$2;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    .line 191
    invoke-static {v2}, Lcom/jibo/ui/fragment/home/MediaFragment;->g(Lcom/jibo/ui/fragment/home/MediaFragment;)Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->getItemCount()I

    move-result v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/home/MediaFragment$2;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-static {v3}, Lcom/jibo/ui/fragment/home/MediaFragment;->h(Lcom/jibo/ui/fragment/home/MediaFragment;)Landroid/support/v7/view/ActionMode$Callback;

    move-result-object v3

    .line 190
    invoke-virtual {v0, v1, v2, v3}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->notifyItemRangeChanged(IILjava/lang/Object;)V

    .line 192
    return-void
.end method

.method public a(Landroid/support/v7/view/ActionMode;Landroid/view/Menu;)Z
    .locals 2

    .prologue
    .line 147
    invoke-virtual {p1}, Landroid/support/v7/view/ActionMode;->a()Landroid/view/MenuInflater;

    move-result-object v0

    .line 148
    const v1, 0x7f0c000d

    invoke-virtual {v0, v1, p2}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 149
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$2;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0, p2}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;Landroid/view/Menu;)V

    .line 151
    const/4 v0, 0x1

    return v0
.end method

.method public a(Landroid/support/v7/view/ActionMode;Landroid/view/MenuItem;)Z
    .locals 6

    .prologue
    const/4 v0, 0x1

    .line 169
    iget-object v1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$2;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-static {v1, p1}, Lcom/jibo/ui/fragment/home/MediaFragment;->a(Lcom/jibo/ui/fragment/home/MediaFragment;Landroid/support/v7/view/ActionMode;)Landroid/support/v7/view/ActionMode;

    .line 170
    invoke-interface {p2}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    sparse-switch v1, :sswitch_data_0

    .line 179
    invoke-virtual {p1}, Landroid/support/v7/view/ActionMode;->c()V

    .line 180
    const/4 v0, 0x0

    :goto_0
    return v0

    .line 172
    :sswitch_0
    iget-object v1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$2;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    const/16 v2, 0x75

    iget-object v3, p0, Lcom/jibo/ui/fragment/home/MediaFragment$2;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    const v4, 0x7f10026d

    .line 173
    invoke-virtual {v3, v4}, Lcom/jibo/ui/fragment/home/MediaFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/jibo/ui/fragment/home/MediaFragment$2;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    const v5, 0x7f100269

    invoke-virtual {v4, v5}, Lcom/jibo/ui/fragment/home/MediaFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 172
    invoke-static {v1, v2, v3, v4}, Lcom/jibo/ui/fragment/dialog/DialogUtils;->a(Landroid/support/v4/app/Fragment;ILjava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 176
    :sswitch_1
    iget-object v1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$2;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/home/MediaFragment;->e(Lcom/jibo/ui/fragment/home/MediaFragment;)V

    goto :goto_0

    .line 170
    :sswitch_data_0
    .sparse-switch
        0x7f090024 -> :sswitch_0
        0x7f090033 -> :sswitch_1
    .end sparse-switch
.end method

.method public b(Landroid/support/v7/view/ActionMode;Landroid/view/Menu;)Z
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 158
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$2;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->b(Lcom/jibo/ui/fragment/home/MediaFragment;)Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;->a()I

    move-result v0

    .line 159
    if-lez v0, :cond_0

    .line 160
    iget-object v1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$2;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    const v2, 0x7f100300

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    aput-object v0, v3, v4

    invoke-virtual {v1, v2, v3}, Lcom/jibo/ui/fragment/home/MediaFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/support/v7/view/ActionMode;->b(Ljava/lang/CharSequence;)V

    .line 162
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$2;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->c()Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$2;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/home/MediaFragment;->d(Lcom/jibo/ui/fragment/home/MediaFragment;)Ljava/lang/Runnable;

    move-result-object v1

    const-wide/16 v2, 0x32

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 163
    return v4
.end method
