.class Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$2;
.super Ljava/lang/Object;
.source "OAuthWebviewHelper.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;


# direct methods
.method constructor <init>(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)V
    .locals 0

    .prologue
    .line 254
    iput-object p1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$2;->a:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 257
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$2;->a:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-static {v0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;)Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$OAuthWebviewHelperEvents;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$OAuthWebviewHelperEvents;->finish()V

    .line 258
    return-void
.end method
