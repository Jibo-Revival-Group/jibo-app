.class public Lcom/google/maps/model/OpeningHours;
.super Ljava/lang/Object;
.source "OpeningHours.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/maps/model/OpeningHours$Period;
    }
.end annotation


# instance fields
.field public openNow:Ljava/lang/Boolean;

.field public periods:[Lcom/google/maps/model/OpeningHours$Period;

.field public permanentlyClosed:Ljava/lang/Boolean;

.field public weekdayText:[Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
