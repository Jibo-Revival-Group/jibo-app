.class public Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider$Builder;
.super Ljava/lang/Object;
.source "PodProvider.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field protected a:[Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 127
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method varargs a([Ljava/lang/String;)Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider$Builder;
    .locals 0

    .prologue
    .line 132
    iput-object p1, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider$Builder;->a:[Ljava/lang/String;

    .line 133
    return-object p0
.end method

.method public a()Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider;
    .locals 1

    .prologue
    .line 137
    iget-object v0, p0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider$Builder;->a:[Ljava/lang/String;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;)Ljava/lang/Object;

    .line 138
    new-instance v0, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider;

    invoke-direct {v0, p0}, Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider;-><init>(Lcom/salesforce/android/service/common/liveagentlogging/internal/PodProvider$Builder;)V

    return-object v0
.end method
