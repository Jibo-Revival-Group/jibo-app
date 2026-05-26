.class public Lcom/jibo/api/iheart/model/Station$Market;
.super Ljava/lang/Object;
.source "Station.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/api/iheart/model/Station;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Market"
.end annotation


# instance fields
.field private a:Ljava/lang/String;

.field private b:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 96
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic a(Lcom/jibo/api/iheart/model/Station$Market;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/jibo/api/iheart/model/Station$Market;->a:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic b(Lcom/jibo/api/iheart/model/Station$Market;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/jibo/api/iheart/model/Station$Market;->b:Ljava/lang/String;

    return-object v0
.end method
