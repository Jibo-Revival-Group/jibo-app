.class public Lcom/jibo/api/iheart/model/LocationConfig$Config;
.super Ljava/lang/Object;
.source "LocationConfig.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/api/iheart/model/LocationConfig;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Config"
.end annotation


# instance fields
.field private a:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    iput-object p1, p0, Lcom/jibo/api/iheart/model/LocationConfig$Config;->a:Ljava/lang/String;

    .line 29
    return-void
.end method

.method static synthetic a(Lcom/jibo/api/iheart/model/LocationConfig$Config;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/jibo/api/iheart/model/LocationConfig$Config;->a:Ljava/lang/String;

    return-object v0
.end method
