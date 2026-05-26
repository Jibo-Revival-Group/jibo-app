.class Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$3;
.super Ljava/lang/Object;
.source "OAuthWebviewHelper.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->k()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/androidsdk/accounts/UserAccount;

.field final synthetic b:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;


# direct methods
.method constructor <init>(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;Lcom/salesforce/androidsdk/accounts/UserAccount;)V
    .locals 0

    .prologue
    .line 669
    iput-object p1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$3;->b:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    iput-object p2, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$3;->a:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 672
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$3;->b:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$3;->a:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->a(Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;Lcom/salesforce/androidsdk/accounts/UserAccount;)V

    .line 673
    return-void
.end method
