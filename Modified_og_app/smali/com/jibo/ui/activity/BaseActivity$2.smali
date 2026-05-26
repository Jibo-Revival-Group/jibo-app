.class Lcom/jibo/ui/activity/BaseActivity$2;
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
    .line 114
    iput-object p1, p0, Lcom/jibo/ui/activity/BaseActivity$2;->a:Lcom/jibo/ui/activity/BaseActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 117
    iget-object v0, p0, Lcom/jibo/ui/activity/BaseActivity$2;->a:Lcom/jibo/ui/activity/BaseActivity;

    const v1, 0x7f10016f

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 118
    iget-object v0, p0, Lcom/jibo/ui/activity/BaseActivity$2;->a:Lcom/jibo/ui/activity/BaseActivity;

    iget-object v0, v0, Lcom/jibo/ui/activity/BaseActivity;->g:Landroid/os/Handler;

    iget-object v1, p0, Lcom/jibo/ui/activity/BaseActivity$2;->a:Lcom/jibo/ui/activity/BaseActivity;

    invoke-static {v1}, Lcom/jibo/ui/activity/BaseActivity;->b(Lcom/jibo/ui/activity/BaseActivity;)Ljava/lang/Runnable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 119
    return-void
.end method
