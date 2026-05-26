.class public Lcom/google/maps/model/Distance;
.super Ljava/lang/Object;
.source "Distance.java"


# instance fields
.field public humanReadable:Ljava/lang/String;

.field public inMeters:J


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
    .line 35
    iget-object v0, p0, Lcom/google/maps/model/Distance;->humanReadable:Ljava/lang/String;

    return-object v0
.end method
