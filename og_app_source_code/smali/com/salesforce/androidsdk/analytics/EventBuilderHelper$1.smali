.class final Lcom/salesforce/androidsdk/analytics/EventBuilderHelper$1;
.super Ljava/lang/Object;
.source "EventBuilderHelper.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/androidsdk/analytics/EventBuilderHelper;->a(Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;Lorg/json/JSONObject;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/String;

.field final synthetic b:Lcom/salesforce/androidsdk/accounts/UserAccount;

.field final synthetic c:Ljava/lang/String;

.field final synthetic d:Lorg/json/JSONObject;


# direct methods
.method constructor <init>(Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;Lorg/json/JSONObject;)V
    .locals 0

    .prologue
    .line 89
    iput-object p1, p0, Lcom/salesforce/androidsdk/analytics/EventBuilderHelper$1;->a:Ljava/lang/String;

    iput-object p2, p0, Lcom/salesforce/androidsdk/analytics/EventBuilderHelper$1;->b:Lcom/salesforce/androidsdk/accounts/UserAccount;

    iput-object p3, p0, Lcom/salesforce/androidsdk/analytics/EventBuilderHelper$1;->c:Ljava/lang/String;

    iput-object p4, p0, Lcom/salesforce/androidsdk/analytics/EventBuilderHelper$1;->d:Lorg/json/JSONObject;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 92
    iget-object v0, p0, Lcom/salesforce/androidsdk/analytics/EventBuilderHelper$1;->a:Ljava/lang/String;

    iget-object v1, p0, Lcom/salesforce/androidsdk/analytics/EventBuilderHelper$1;->b:Lcom/salesforce/androidsdk/accounts/UserAccount;

    iget-object v2, p0, Lcom/salesforce/androidsdk/analytics/EventBuilderHelper$1;->c:Ljava/lang/String;

    iget-object v3, p0, Lcom/salesforce/androidsdk/analytics/EventBuilderHelper$1;->d:Lorg/json/JSONObject;

    invoke-static {v0, v1, v2, v3}, Lcom/salesforce/androidsdk/analytics/EventBuilderHelper;->c(Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;Lorg/json/JSONObject;)V

    .line 93
    return-void
.end method
