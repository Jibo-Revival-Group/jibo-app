.class Lcom/jibo/ui/fragment/SplashFragment$1$1;
.super Ljava/lang/Object;
.source "SplashFragment.java"

# interfaces
.implements Lcom/jibo/aws/integration/util/Commons$AsyncCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/SplashFragment$1;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/jibo/aws/integration/util/Commons$AsyncCallback",
        "<",
        "Ljava/lang/Object;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/aws/integration/aws/services/account/model/Account;

.field final synthetic b:Lcom/jibo/ui/fragment/SplashFragment$1;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/SplashFragment$1;Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
    .locals 0

    .prologue
    .line 51
    iput-object p1, p0, Lcom/jibo/ui/fragment/SplashFragment$1$1;->b:Lcom/jibo/ui/fragment/SplashFragment$1;

    iput-object p2, p0, Lcom/jibo/ui/fragment/SplashFragment$1$1;->a:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 54
    iget-object v0, p0, Lcom/jibo/ui/fragment/SplashFragment$1$1;->b:Lcom/jibo/ui/fragment/SplashFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/SplashFragment$1;->a:Lcom/jibo/ui/fragment/SplashFragment;

    const-string v1, "pull crutial data from server"

    const/4 v2, 0x1

    invoke-virtual {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/SplashFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 56
    instance-of v0, p1, Lcom/amazonaws/AmazonServiceException;

    if-eqz v0, :cond_4

    .line 57
    check-cast p1, Lcom/amazonaws/AmazonServiceException;

    .line 58
    invoke-static {p1}, Lcom/jibo/utils/ErrorHelper;->a(Lcom/amazonaws/AmazonServiceException;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 60
    iget-object v0, p0, Lcom/jibo/ui/fragment/SplashFragment$1$1;->b:Lcom/jibo/ui/fragment/SplashFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/SplashFragment$1;->a:Lcom/jibo/ui/fragment/SplashFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/SplashFragment;->a(Lcom/jibo/ui/fragment/SplashFragment;)V

    .line 82
    :goto_0
    return-void

    .line 61
    :cond_0
    invoke-static {p1}, Lcom/jibo/utils/ErrorHelper;->b(Lcom/amazonaws/AmazonServiceException;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 62
    invoke-static {p1}, Lcom/jibo/utils/ErrorHelper;->c(Lcom/amazonaws/AmazonServiceException;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 65
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/SplashFragment$1$1;->b:Lcom/jibo/ui/fragment/SplashFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/SplashFragment$1;->a:Lcom/jibo/ui/fragment/SplashFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/SplashFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getApplication()Landroid/app/Application;

    move-result-object v0

    check-cast v0, Lcom/jibo/JiboApplication;

    invoke-virtual {v0}, Lcom/jibo/JiboApplication;->b()V

    .line 67
    iget-object v0, p0, Lcom/jibo/ui/fragment/SplashFragment$1$1;->b:Lcom/jibo/ui/fragment/SplashFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/SplashFragment$1;->a:Lcom/jibo/ui/fragment/SplashFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/SplashFragment;->a(Lcom/jibo/ui/fragment/SplashFragment;)V

    goto :goto_0

    .line 68
    :cond_2
    invoke-static {p1}, Lcom/jibo/utils/ErrorHelper;->d(Lcom/amazonaws/AmazonServiceException;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 69
    iget-object v0, p0, Lcom/jibo/ui/fragment/SplashFragment$1$1;->b:Lcom/jibo/ui/fragment/SplashFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/SplashFragment$1;->a:Lcom/jibo/ui/fragment/SplashFragment;

    new-instance v1, Lcom/jibo/ui/fragment/SplashFragment$1$1$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/SplashFragment$1$1$1;-><init>(Lcom/jibo/ui/fragment/SplashFragment$1$1;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/SplashFragment;->a(Ljava/lang/Runnable;)V

    goto :goto_0

    .line 77
    :cond_3
    iget-object v0, p0, Lcom/jibo/ui/fragment/SplashFragment$1$1;->b:Lcom/jibo/ui/fragment/SplashFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/SplashFragment$1;->a:Lcom/jibo/ui/fragment/SplashFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/SplashFragment;->a(Lcom/jibo/ui/fragment/SplashFragment;)V

    goto :goto_0

    .line 80
    :cond_4
    iget-object v0, p0, Lcom/jibo/ui/fragment/SplashFragment$1$1;->b:Lcom/jibo/ui/fragment/SplashFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/SplashFragment$1;->a:Lcom/jibo/ui/fragment/SplashFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/SplashFragment;->a(Lcom/jibo/ui/fragment/SplashFragment;)V

    goto :goto_0
.end method

.method public onSuccess(Ljava/lang/Object;)V
    .locals 3

    .prologue
    .line 86
    iget-object v0, p0, Lcom/jibo/ui/fragment/SplashFragment$1$1;->b:Lcom/jibo/ui/fragment/SplashFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/SplashFragment$1;->a:Lcom/jibo/ui/fragment/SplashFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/SplashFragment;->d()Z

    move-result v0

    if-nez v0, :cond_0

    .line 110
    :goto_0
    return-void

    .line 88
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/SplashFragment$1$1;->b:Lcom/jibo/ui/fragment/SplashFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/SplashFragment$1;->a:Lcom/jibo/ui/fragment/SplashFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/SplashFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v1

    .line 90
    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->isActive()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_1

    instance-of v0, p1, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    if-eqz v0, :cond_2

    .line 91
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/SplashFragment$1$1;->b:Lcom/jibo/ui/fragment/SplashFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/SplashFragment$1;->a:Lcom/jibo/ui/fragment/SplashFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/SplashFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/OnBoardingActivity;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getEmail()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/OnBoardingActivity;->b(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 94
    :cond_2
    iget-object v0, p0, Lcom/jibo/ui/fragment/SplashFragment$1$1;->b:Lcom/jibo/ui/fragment/SplashFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/SplashFragment$1;->a:Lcom/jibo/ui/fragment/SplashFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/SplashFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/aws/integration/util/KeyManager;->getInstance(Landroid/content/Context;Ljava/lang/String;)Lcom/jibo/aws/integration/util/KeyManager;

    .line 98
    check-cast p1, Ljava/util/List;

    .line 99
    iget-object v0, p0, Lcom/jibo/ui/fragment/SplashFragment$1$1;->b:Lcom/jibo/ui/fragment/SplashFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/SplashFragment$1;->a:Lcom/jibo/ui/fragment/SplashFragment;

    new-instance v1, Lcom/jibo/ui/fragment/SplashFragment$1$1$2;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/SplashFragment$1$1$2;-><init>(Lcom/jibo/ui/fragment/SplashFragment$1$1;Ljava/util/List;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/SplashFragment;->a(Ljava/lang/Runnable;)V

    goto :goto_0
.end method
