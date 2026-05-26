.class Lcom/jibo/ui/activity/PhotoViewerActivity$2$1;
.super Ljava/lang/Object;
.source "PhotoViewerActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/activity/PhotoViewerActivity$2;->a(Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/activity/PhotoViewerActivity$2;


# direct methods
.method constructor <init>(Lcom/jibo/ui/activity/PhotoViewerActivity$2;)V
    .locals 0

    .prologue
    .line 135
    iput-object p1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$2$1;->a:Lcom/jibo/ui/activity/PhotoViewerActivity$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 138
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$2$1;->a:Lcom/jibo/ui/activity/PhotoViewerActivity$2;

    iget-object v0, v0, Lcom/jibo/ui/activity/PhotoViewerActivity$2;->a:Lcom/jibo/ui/activity/PhotoViewerActivity;

    iget-object v1, v0, Lcom/jibo/ui/activity/PhotoViewerActivity;->viewNetworkDown:Landroid/view/View;

    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$2$1;->a:Lcom/jibo/ui/activity/PhotoViewerActivity$2;

    iget-object v0, v0, Lcom/jibo/ui/activity/PhotoViewerActivity$2;->a:Lcom/jibo/ui/activity/PhotoViewerActivity;

    invoke-static {v0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->d(Lcom/jibo/ui/activity/PhotoViewerActivity;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    invoke-virtual {v1, v0}, Landroid/view/View;->setVisibility(I)V

    .line 139
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$2$1;->a:Lcom/jibo/ui/activity/PhotoViewerActivity$2;

    iget-object v0, v0, Lcom/jibo/ui/activity/PhotoViewerActivity$2;->a:Lcom/jibo/ui/activity/PhotoViewerActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->invalidateOptionsMenu()V

    .line 140
    return-void

    .line 138
    :cond_0
    const/16 v0, 0x8

    goto :goto_0
.end method
