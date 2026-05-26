.class Lcom/jibo/ui/activity/TipVideoActivity$1;
.super Landroid/webkit/WebViewClient;
.source "TipVideoActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/activity/TipVideoActivity;->a(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/activity/TipVideoActivity;


# direct methods
.method constructor <init>(Lcom/jibo/ui/activity/TipVideoActivity;)V
    .locals 0

    .prologue
    .line 69
    iput-object p1, p0, Lcom/jibo/ui/activity/TipVideoActivity$1;->a:Lcom/jibo/ui/activity/TipVideoActivity;

    invoke-direct {p0}, Landroid/webkit/WebViewClient;-><init>()V

    return-void
.end method


# virtual methods
.method public onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 73
    invoke-super {p0, p1, p2}, Landroid/webkit/WebViewClient;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V

    .line 74
    iget-object v0, p0, Lcom/jibo/ui/activity/TipVideoActivity$1;->a:Lcom/jibo/ui/activity/TipVideoActivity;

    iget-object v0, v0, Lcom/jibo/ui/activity/TipVideoActivity;->pbLoader:Landroid/widget/ProgressBar;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 75
    return-void
.end method
