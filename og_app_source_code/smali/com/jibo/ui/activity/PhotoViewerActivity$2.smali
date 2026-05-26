.class Lcom/jibo/ui/activity/PhotoViewerActivity$2;
.super Lcom/jibo/utils/NetworkStateReceiver;
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
.method constructor <init>(Lcom/jibo/ui/activity/PhotoViewerActivity;)V
    .locals 0

    .prologue
    .line 130
    iput-object p1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$2;->a:Lcom/jibo/ui/activity/PhotoViewerActivity;

    invoke-direct {p0}, Lcom/jibo/utils/NetworkStateReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Z)V
    .locals 2

    .prologue
    .line 134
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$2;->a:Lcom/jibo/ui/activity/PhotoViewerActivity;

    invoke-static {v0, p1}, Lcom/jibo/ui/activity/PhotoViewerActivity;->a(Lcom/jibo/ui/activity/PhotoViewerActivity;Z)Z

    .line 135
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity$2;->a:Lcom/jibo/ui/activity/PhotoViewerActivity;

    new-instance v1, Lcom/jibo/ui/activity/PhotoViewerActivity$2$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/activity/PhotoViewerActivity$2$1;-><init>(Lcom/jibo/ui/activity/PhotoViewerActivity$2;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/activity/PhotoViewerActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 142
    return-void
.end method
