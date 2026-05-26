.class public Lcom/google/maps/model/Duration;
.super Ljava/lang/Object;
.source "Duration.java"


# instance fields
.field public humanReadable:Ljava/lang/String;

.field public inSeconds:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/google/maps/model/Duration;->humanReadable:Ljava/lang/String;

    return-object v0
.end method
