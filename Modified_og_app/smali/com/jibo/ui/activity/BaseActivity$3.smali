.class Lcom/jibo/ui/activity/BaseActivity$3;
.super Lcom/jibo/utils/NetworkStateReceiver;
.source "BaseActivity.java"


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
    .line 121
    iput-object p1, p0, Lcom/jibo/ui/activity/BaseActivity$3;->a:Lcom/jibo/ui/activity/BaseActivity;

    invoke-direct {p0}, Lcom/jibo/utils/NetworkStateReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Z)V
    .locals 1

    .prologue
    .line 126
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/activity/BaseActivity$3;->a:Lcom/jibo/ui/activity/BaseActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/BaseActivity;->c()V

    .line 129
    :goto_0
    iget-object v0, p0, Lcom/jibo/ui/activity/BaseActivity$3;->a:Lcom/jibo/ui/activity/BaseActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/BaseActivity;->invalidateOptionsMenu()V

    .line 130
    return-void

    .line 127
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/activity/BaseActivity$3;->a:Lcom/jibo/ui/activity/BaseActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/BaseActivity;->b()V

    goto :goto_0
.end method
