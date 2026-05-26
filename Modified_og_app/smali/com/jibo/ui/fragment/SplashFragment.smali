.class public Lcom/jibo/ui/fragment/SplashFragment;
.super Lcom/jibo/ui/fragment/BaseFragment;
.source "SplashFragment.java"


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field private b:Ljava/lang/Runnable;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 32
    const-class v0, Lcom/jibo/ui/fragment/SplashFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/SplashFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 120
    invoke-direct {p0}, Lcom/jibo/ui/fragment/BaseFragment;-><init>()V

    .line 35
    new-instance v0, Lcom/jibo/ui/fragment/SplashFragment$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/SplashFragment$1;-><init>(Lcom/jibo/ui/fragment/SplashFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/SplashFragment;->b:Ljava/lang/Runnable;

    .line 122
    return-void
.end method

.method private a()V
    .locals 1

    .prologue
    .line 158
    new-instance v0, Lcom/jibo/ui/fragment/SplashFragment$2;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/SplashFragment$2;-><init>(Lcom/jibo/ui/fragment/SplashFragment;)V

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/SplashFragment;->a(Ljava/lang/Runnable;)V

    .line 169
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/SplashFragment;)V
    .locals 0

    .prologue
    .line 30
    invoke-direct {p0}, Lcom/jibo/ui/fragment/SplashFragment;->a()V

    return-void
.end method


# virtual methods
.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 0

    .prologue
    .line 147
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 148
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/SplashFragment;->k()V

    .line 149
    return-void
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 153
    const-string v0, ""

    return-object v0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 126
    const v0, 0x7f0b0091

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onPause()V
    .locals 2

    .prologue
    .line 140
    invoke-super {p0}, Lcom/jibo/ui/fragment/BaseFragment;->onPause()V

    .line 142
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/SplashFragment;->c()Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/SplashFragment;->b:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 143
    return-void
.end method

.method public onResume()V
    .locals 4

    .prologue
    .line 131
    invoke-super {p0}, Lcom/jibo/ui/fragment/BaseFragment;->onResume()V

    .line 133
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/SplashFragment;->c()Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/SplashFragment;->b:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 134
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/SplashFragment;->c()Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/SplashFragment;->b:Ljava/lang/Runnable;

    const-wide/16 v2, 0x1f4

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 136
    return-void
.end method
