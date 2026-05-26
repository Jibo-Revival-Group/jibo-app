.class public Lcom/google/maps/model/AutocompletePrediction;
.super Ljava/lang/Object;
.source "AutocompletePrediction.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/maps/model/AutocompletePrediction$Term;,
        Lcom/google/maps/model/AutocompletePrediction$MatchedSubstring;
    }
.end annotation


# instance fields
.field public description:Ljava/lang/String;

.field public matchedSubstrings:[Lcom/google/maps/model/AutocompletePrediction$MatchedSubstring;

.field public placeId:Ljava/lang/String;

.field public structuredFormatting:Lcom/google/maps/model/AutocompleteStructuredFormatting;

.field public terms:[Lcom/google/maps/model/AutocompletePrediction$Term;

.field public types:[Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
