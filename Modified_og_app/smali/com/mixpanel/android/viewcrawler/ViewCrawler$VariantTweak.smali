.class Lcom/mixpanel/android/viewcrawler/ViewCrawler$VariantTweak;
.super Ljava/lang/Object;
.source "ViewCrawler.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/mixpanel/android/viewcrawler/ViewCrawler;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "VariantTweak"
.end annotation


# instance fields
.field public final a:Ljava/lang/String;

.field public final b:Lorg/json/JSONObject;

.field public final c:Landroid/util/Pair;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/Pair",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;Lorg/json/JSONObject;Landroid/util/Pair;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lorg/json/JSONObject;",
            "Landroid/util/Pair",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Integer;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1164
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1165
    iput-object p1, p0, Lcom/mixpanel/android/viewcrawler/ViewCrawler$VariantTweak;->a:Ljava/lang/String;

    .line 1166
    iput-object p2, p0, Lcom/mixpanel/android/viewcrawler/ViewCrawler$VariantTweak;->b:Lorg/json/JSONObject;

    .line 1167
    iput-object p3, p0, Lcom/mixpanel/android/viewcrawler/ViewCrawler$VariantTweak;->c:Landroid/util/Pair;

    .line 1168
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 1177
    instance-of v1, p1, Lcom/mixpanel/android/viewcrawler/ViewCrawler$VariantTweak;

    if-eqz v1, :cond_0

    .line 1178
    invoke-virtual {p1}, Ljava/lang/Object;->hashCode()I

    move-result v1

    invoke-virtual {p0}, Lcom/mixpanel/android/viewcrawler/ViewCrawler$VariantTweak;->hashCode()I

    move-result v2

    if-ne v1, v2, :cond_0

    const/4 v0, 0x1

    .line 1181
    :cond_0
    return v0
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 1172
    iget-object v0, p0, Lcom/mixpanel/android/viewcrawler/ViewCrawler$VariantTweak;->a:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    return v0
.end method
