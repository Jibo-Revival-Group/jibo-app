.class public Lcom/google/maps/internal/EncodedPolylineInstanceCreator;
.super Ljava/lang/Object;
.source "EncodedPolylineInstanceCreator.java"

# interfaces
.implements Lcom/google/gson/InstanceCreator;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/google/gson/InstanceCreator",
        "<",
        "Lcom/google/maps/model/EncodedPolyline;",
        ">;"
    }
.end annotation


# instance fields
.field private points:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    iput-object p1, p0, Lcom/google/maps/internal/EncodedPolylineInstanceCreator;->points:Ljava/lang/String;

    .line 27
    return-void
.end method


# virtual methods
.method public createInstance(Ljava/lang/reflect/Type;)Lcom/google/maps/model/EncodedPolyline;
    .locals 2

    .prologue
    .line 31
    new-instance v0, Lcom/google/maps/model/EncodedPolyline;

    iget-object v1, p0, Lcom/google/maps/internal/EncodedPolylineInstanceCreator;->points:Ljava/lang/String;

    invoke-direct {v0, v1}, Lcom/google/maps/model/EncodedPolyline;-><init>(Ljava/lang/String;)V

    return-object v0
.end method

.method public bridge synthetic createInstance(Ljava/lang/reflect/Type;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 22
    invoke-virtual {p0, p1}, Lcom/google/maps/internal/EncodedPolylineInstanceCreator;->createInstance(Ljava/lang/reflect/Type;)Lcom/google/maps/model/EncodedPolyline;

    move-result-object v0

    return-object v0
.end method
