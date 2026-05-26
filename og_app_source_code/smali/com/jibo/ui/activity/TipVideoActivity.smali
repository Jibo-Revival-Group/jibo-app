.class public final Lcom/jibo/ui/activity/TipVideoActivity;
.super Lcom/jibo/ui/activity/BaseActivity;
.source "TipVideoActivity.java"


# instance fields
.field pbLoader:Landroid/widget/ProgressBar;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field wvWistia:Landroid/webkit/WebView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Lcom/jibo/ui/activity/BaseActivity;-><init>()V

    return-void
.end method

.method private a(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 66
    iget-object v0, p0, Lcom/jibo/ui/activity/TipVideoActivity;->wvWistia:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    .line 68
    iget-object v0, p0, Lcom/jibo/ui/activity/TipVideoActivity;->wvWistia:Landroid/webkit/WebView;

    new-instance v1, Lcom/jibo/ui/activity/TipVideoActivity$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/activity/TipVideoActivity$1;-><init>(Lcom/jibo/ui/activity/TipVideoActivity;)V

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 77
    iget-object v0, p0, Lcom/jibo/ui/activity/TipVideoActivity;->wvWistia:Landroid/webkit/WebView;

    new-instance v1, Landroid/webkit/WebChromeClient;

    invoke-direct {v1}, Landroid/webkit/WebChromeClient;-><init>()V

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->setWebChromeClient(Landroid/webkit/WebChromeClient;)V

    .line 79
    iget-object v0, p0, Lcom/jibo/ui/activity/TipVideoActivity;->wvWistia:Landroid/webkit/WebView;

    invoke-virtual {v0, p1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 80
    return-void
.end method

.method private q()V
    .locals 2

    .prologue
    .line 54
    invoke-virtual {p0}, Lcom/jibo/ui/activity/TipVideoActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    .line 55
    const/16 v1, 0x1706

    .line 61
    invoke-virtual {v0, v1}, Landroid/view/View;->setSystemUiVisibility(I)V

    .line 62
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4

    .prologue
    const/4 v3, -0x1

    const-string v0, "com.jibo.ui.activity.TipVideoActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnCreateTime(Ljava/lang/String;)V

    .line 37
    invoke-virtual {p0}, Lcom/jibo/ui/activity/TipVideoActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    sget-object v1, Lcom/jibo/ui/activity/BaseActivity;->b:Ljava/lang/String;

    const v2, 0x7f0b0025

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 38
    invoke-super {p0, p1}, Lcom/jibo/ui/activity/BaseActivity;->onCreate(Landroid/os/Bundle;)V

    .line 40
    invoke-virtual {p0}, Lcom/jibo/ui/activity/TipVideoActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "extra_video_url_res_id"

    invoke-virtual {v0, v1, v3}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    .line 41
    if-ne v0, v3, :cond_0

    const-string v0, ""

    .line 43
    :goto_0
    invoke-direct {p0}, Lcom/jibo/ui/activity/TipVideoActivity;->q()V

    .line 44
    invoke-direct {p0, v0}, Lcom/jibo/ui/activity/TipVideoActivity;->a(Ljava/lang/String;)V

    .line 45
    return-void

    .line 41
    :cond_0
    invoke-virtual {p0, v0}, Lcom/jibo/ui/activity/TipVideoActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method protected onResume()V
    .locals 1

    const-string v0, "com.jibo.ui.activity.TipVideoActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnResumeTime(Ljava/lang/String;)V

    invoke-super {p0}, Lcom/jibo/ui/activity/BaseActivity;->onResume()V

    return-void
.end method

.method protected onStart()V
    .locals 1

    const-string v0, "com.jibo.ui.activity.TipVideoActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnStartTime(Ljava/lang/String;)V

    invoke-super {p0}, Lcom/jibo/ui/activity/BaseActivity;->onStart()V

    return-void
.end method
