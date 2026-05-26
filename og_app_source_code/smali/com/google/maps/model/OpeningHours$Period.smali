.class public Lcom/google/maps/model/OpeningHours$Period;
.super Ljava/lang/Object;
.source "OpeningHours.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/maps/model/OpeningHours;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Period"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/maps/model/OpeningHours$Period$OpenClose;
    }
.end annotation


# instance fields
.field public close:Lcom/google/maps/model/OpeningHours$Period$OpenClose;

.field public open:Lcom/google/maps/model/OpeningHours$Period$OpenClose;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
