.class Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;
.super Ljava/lang/Object;
.source "KbBasicInfo.java"


# instance fields
.field final mCommunityUrl:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "communityUrl"
    .end annotation
.end field

.field final mDataCategoryGroup:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "dataCategoryGroup"
    .end annotation
.end field

.field final mRootCategory:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "rootCategory"
    .end annotation
.end field

.field final mUserType:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "userType"
    .end annotation
.end field


# direct methods
.method constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 1

    .prologue
    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;->mCommunityUrl:Ljava/lang/String;

    .line 38
    iput-object p2, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;->mDataCategoryGroup:Ljava/lang/String;

    .line 39
    iput-object p3, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;->mRootCategory:Ljava/lang/String;

    .line 40
    if-eqz p4, :cond_0

    const-string v0, "authenticated"

    :goto_0
    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;->mUserType:Ljava/lang/String;

    .line 41
    return-void

    .line 40
    :cond_0
    const-string v0, "guest"

    goto :goto_0
.end method
