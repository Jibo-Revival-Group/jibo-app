.class Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$4;
.super Ljava/lang/Object;
.source "OAuthWebviewHelper.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->alias(Ljava/lang/String;)V
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
    .line 841
    iput-object p1, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$4;->a:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 845
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper$4;->a:Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/OAuthWebviewHelper;->g()V

    .line 846
    return-void
.end method
