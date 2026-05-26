.class Lcom/jibo/ui/activity/PhotoViewerActivity$1;
.super Landroid/database/ContentObserver;
.source "PhotoViewerActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/activity/PhotoViewerActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/activity/PhotoViewerActivity;


# direct methods
.method constructor <init>(Lcom/jibo/ui/activity/PhotoViewerActivity;Landroid/os/Handler;)V
    .locals 0

    .prologue
    .line 117
    iput-object p1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$1;->a:Lcom/jibo/ui/activity/PhotoViewerActivity;

    invoke-direct {p0, p2}, Landroid/database/ContentObserver;-><init>(Landroid/os/Handler;)V

    return-void
.end method


# virtual methods
.method public onChange(ZLandroid/net/Uri;)V
    .locals 2

    .prologue
    .line 121
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$1;->a:Lcom/jibo/ui/activity/PhotoViewerActivity;

    invoke-static {v0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->a(Lcom/jibo/ui/activity/PhotoViewerActivity;)V

    .line 123
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$1;->a:Lcom/jibo/ui/activity/PhotoViewerActivity;

    iget-object v0, v0, Lcom/jibo/ui/activity/PhotoViewerActivity;->pager:Landroid/support/v4/view/ViewPager;

    iget-object v1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$1;->a:Lcom/jibo/ui/activity/PhotoViewerActivity;

    invoke-static {v1}, Lcom/jibo/ui/activity/PhotoViewerActivity;->b(Lcom/jibo/ui/activity/PhotoViewerActivity;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/support/v4/view/ViewPager;->setCurrentItem(I)V

    .line 124
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$1;->a:Lcom/jibo/ui/activity/PhotoViewerActivity;

    invoke-static {v0}, Lcom/jibo/ui/activity/PhotoViewerActivity;->c(Lcom/jibo/ui/activity/PhotoViewerActivity;)V

    .line 125
    return-void
.end method
