.class Lcom/jibo/ui/view/BitmapProgress$1;
.super Landroid/os/Handler;
.source "BitmapProgress.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/view/BitmapProgress;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/view/BitmapProgress;


# direct methods
.method constructor <init>(Lcom/jibo/ui/view/BitmapProgress;)V
    .locals 0

    .prologue
    .line 42
    iput-object p1, p0, Lcom/jibo/ui/view/BitmapProgress$1;->a:Lcom/jibo/ui/view/BitmapProgress;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 4

    .prologue
    .line 45
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 46
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_0

    .line 52
    :goto_0
    return-void

    .line 48
    :pswitch_0
    iget-object v0, p0, Lcom/jibo/ui/view/BitmapProgress$1;->a:Lcom/jibo/ui/view/BitmapProgress;

    invoke-virtual {v0}, Lcom/jibo/ui/view/BitmapProgress;->invalidate()V

    .line 49
    const/16 v0, 0x777

    iget-object v1, p0, Lcom/jibo/ui/view/BitmapProgress$1;->a:Lcom/jibo/ui/view/BitmapProgress;

    invoke-static {v1}, Lcom/jibo/ui/view/BitmapProgress;->a(Lcom/jibo/ui/view/BitmapProgress;)I

    move-result v1

    int-to-long v2, v1

    invoke-virtual {p0, v0, v2, v3}, Lcom/jibo/ui/view/BitmapProgress$1;->sendEmptyMessageDelayed(IJ)Z

    goto :goto_0

    .line 46
    nop

    :pswitch_data_0
    .packed-switch 0x777
        :pswitch_0
    .end packed-switch
.end method
