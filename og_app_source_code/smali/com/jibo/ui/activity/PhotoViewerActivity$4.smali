.class Lcom/jibo/ui/activity/PhotoViewerActivity$4;
.super Ljava/lang/Object;
.source "PhotoViewerActivity.java"

# interfaces
.implements Landroid/support/v4/view/ViewPager$OnPageChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/activity/PhotoViewerActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/activity/PhotoViewerActivity;


# direct methods
.method constructor <init>(Lcom/jibo/ui/activity/PhotoViewerActivity;)V
    .locals 0

    .prologue
    .line 234
    iput-object p1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$4;->a:Lcom/jibo/ui/activity/PhotoViewerActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(I)V
    .locals 2

    .prologue
    .line 252
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$4;->a:Lcom/jibo/ui/activity/PhotoViewerActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    iget v0, v0, Landroid/content/res/Configuration;->orientation:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    .line 253
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$4;->a:Lcom/jibo/ui/activity/PhotoViewerActivity;

    invoke-static {v0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->f(Lcom/jibo/ui/activity/PhotoViewerActivity;)V

    .line 255
    :cond_0
    return-void
.end method

.method public a(IFI)V
    .locals 0

    .prologue
    .line 237
    return-void
.end method

.method public b(I)V
    .locals 2

    .prologue
    .line 241
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$4;->a:Lcom/jibo/ui/activity/PhotoViewerActivity;

    invoke-static {v0, p1}, Lcom/jibo/ui/activity/PhotoViewerActivity;->a(Lcom/jibo/ui/activity/PhotoViewerActivity;I)I

    .line 242
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$4;->a:Lcom/jibo/ui/activity/PhotoViewerActivity;

    invoke-static {v0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->e(Lcom/jibo/ui/activity/PhotoViewerActivity;)Lcom/jibo/ui/activity/PhotoViewerActivity$MediaAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/activity/PhotoViewerActivity$MediaAdapter;->f()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$4;->a:Lcom/jibo/ui/activity/PhotoViewerActivity;

    invoke-static {v0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->b(Lcom/jibo/ui/activity/PhotoViewerActivity;)I

    move-result v0

    iget-object v1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$4;->a:Lcom/jibo/ui/activity/PhotoViewerActivity;

    invoke-static {v1}, Lcom/jibo/ui/activity/PhotoViewerActivity;->e(Lcom/jibo/ui/activity/PhotoViewerActivity;)Lcom/jibo/ui/activity/PhotoViewerActivity$MediaAdapter;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/ui/activity/PhotoViewerActivity$MediaAdapter;->b()I

    move-result v1

    if-lt v0, v1, :cond_1

    .line 247
    :cond_0
    :goto_0
    return-void

    .line 244
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$4;->a:Lcom/jibo/ui/activity/PhotoViewerActivity;

    invoke-static {v0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->e(Lcom/jibo/ui/activity/PhotoViewerActivity;)Lcom/jibo/ui/activity/PhotoViewerActivity$MediaAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/activity/PhotoViewerActivity$MediaAdapter;->d()Landroid/database/Cursor;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$4;->a:Lcom/jibo/ui/activity/PhotoViewerActivity;

    invoke-static {v1}, Lcom/jibo/ui/activity/PhotoViewerActivity;->b(Lcom/jibo/ui/activity/PhotoViewerActivity;)I

    move-result v1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->moveToPosition(I)Z

    .line 246
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$4;->a:Lcom/jibo/ui/activity/PhotoViewerActivity;

    invoke-static {v0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->c(Lcom/jibo/ui/activity/PhotoViewerActivity;)V

    goto :goto_0
.end method
