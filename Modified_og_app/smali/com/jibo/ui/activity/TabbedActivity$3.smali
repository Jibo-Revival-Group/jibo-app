.class Lcom/jibo/ui/activity/TabbedActivity$3;
.super Landroid/os/CountDownTimer;
.source "TabbedActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/activity/TabbedActivity;->y()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/activity/TabbedActivity;


# direct methods
.method constructor <init>(Lcom/jibo/ui/activity/TabbedActivity;JJ)V
    .locals 0

    .prologue
    .line 256
    iput-object p1, p0, Lcom/jibo/ui/activity/TabbedActivity$3;->a:Lcom/jibo/ui/activity/TabbedActivity;

    invoke-direct {p0, p2, p3, p4, p5}, Landroid/os/CountDownTimer;-><init>(JJ)V

    return-void
.end method


# virtual methods
.method public onFinish()V
    .locals 1

    .prologue
    .line 264
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity$3;->a:Lcom/jibo/ui/activity/TabbedActivity;

    invoke-static {v0}, Lcom/jibo/ui/activity/TabbedActivity;->b(Lcom/jibo/ui/activity/TabbedActivity;)V

    .line 265
    return-void
.end method

.method public onTick(J)V
    .locals 0

    .prologue
    .line 260
    return-void
.end method
