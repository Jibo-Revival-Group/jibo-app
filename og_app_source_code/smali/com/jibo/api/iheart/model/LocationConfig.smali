.class public Lcom/jibo/api/iheart/model/LocationConfig;
.super Ljava/lang/Object;
.source "LocationConfig.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/api/iheart/model/LocationConfig$Config;
    }
.end annotation


# instance fields
.field private a:Ljava/lang/String;

.field private b:Lcom/jibo/api/iheart/model/LocationConfig$Config;


# direct methods
.method public constructor <init>(Ljava/lang/String;Lcom/jibo/api/iheart/model/LocationConfig$Config;)V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    iput-object p1, p0, Lcom/jibo/api/iheart/model/LocationConfig;->a:Ljava/lang/String;

    .line 21
    iput-object p2, p0, Lcom/jibo/api/iheart/model/LocationConfig;->b:Lcom/jibo/api/iheart/model/LocationConfig$Config;

    .line 22
    return-void
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 16
    iget-object v0, p0, Lcom/jibo/api/iheart/model/LocationConfig;->b:Lcom/jibo/api/iheart/model/LocationConfig$Config;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/api/iheart/model/LocationConfig;->b:Lcom/jibo/api/iheart/model/LocationConfig$Config;

    invoke-static {v0}, Lcom/jibo/api/iheart/model/LocationConfig$Config;->a(Lcom/jibo/api/iheart/model/LocationConfig$Config;)Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method
