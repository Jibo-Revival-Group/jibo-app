.class Lcom/jibo/ui/activity/BaseActivity$1;
.super Ljava/lang/Object;
.source "BaseActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/activity/BaseActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/activity/BaseActivity;


# direct methods
.method constructor <init>(Lcom/jibo/ui/activity/BaseActivity;)V
    .locals 0

    .prologue
    .line 107
    iput-object p1, p0, Lcom/jibo/ui/activity/BaseActivity$1;->a:Lcom/jibo/ui/activity/BaseActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 110
    iget-object v0, p0, Lcom/jibo/ui/activity/BaseActivity$1;->a:Lcom/jibo/ui/activity/BaseActivity;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/jibo/ui/activity/BaseActivity;->a(Lcom/jibo/ui/activity/BaseActivity;Z)Z

    .line 111
    iget-object v0, p0, Lcom/jibo/ui/activity/BaseActivity$1;->a:Lcom/jibo/ui/activity/BaseActivity;

    iget-object v0, v0, Lcom/jibo/ui/activity/BaseActivity;->g:Landroid/os/Handler;

    iget-object v1, p0, Lcom/jibo/ui/activity/BaseActivity$1;->a:Lcom/jibo/ui/activity/BaseActivity;

    invoke-static {v1}, Lcom/jibo/ui/activity/BaseActivity;->a(Lcom/jibo/ui/activity/BaseActivity;)Ljava/lang/Runnable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 112
    return-void
.end method
