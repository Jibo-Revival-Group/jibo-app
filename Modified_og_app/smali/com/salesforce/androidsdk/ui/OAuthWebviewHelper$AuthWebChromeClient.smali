.class public Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AuthWebChromeClient;
.super Landroid/webkit/WebChromeClient;
.source "OAuthWebviewHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "AuthWebChromeClient"
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;


# direct methods
.method protected constructor <init>(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)V
    .locals 0

    .prologue
    .line 713
    iput-object p1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AuthWebChromeClient;->a:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-direct {p0}, Landroid/webkit/WebChromeClient;-><init>()V

    return-void
.end method


# virtual methods
.method public onProgressChanged(Landroid/webkit/WebView;I)V
    .locals 2

    .prologue
    .line 717
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$AuthWebChromeClient;->a:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-static {v0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$OAuthWebviewHelperEvents;

    move-result-object v0

    mul-int/lit8 v1, p2, 0x64

    invoke-interface {v0, v1}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$OAuthWebviewHelperEvents;->b(I)V

    .line 718
    return-void
.end method
