.class public Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;
.super Lcom/salesforce/android/service/common/utilities/functional/OptionalReference;
.source "ActivityReference.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Landroid/app/Activity;",
        ">",
        "Lcom/salesforce/android/service/common/utilities/functional/OptionalReference",
        "<TT;>;"
    }
.end annotation


# static fields
.field private static final a:Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/salesforce/android/service/common/utilities/activity/ActivityReference",
            "<*>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 39
    new-instance v0, Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;-><init>(Landroid/app/Activity;)V

    sput-object v0, Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;->a:Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    return-void
.end method

.method protected constructor <init>(Landroid/app/Activity;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 42
    invoke-direct {p0, p1}, Lcom/salesforce/android/service/common/utilities/functional/OptionalReference;-><init>(Ljava/lang/Object;)V

    .line 43
    return-void
.end method

.method public static a()Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Landroid/app/Activity;",
            ">()",
            "Lcom/salesforce/android/service/common/utilities/activity/ActivityReference",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 51
    sget-object v0, Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;->a:Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    return-object v0
.end method

.method public static a(Landroid/app/Activity;)Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Landroid/app/Activity;",
            ">(TT;)",
            "Lcom/salesforce/android/service/common/utilities/activity/ActivityReference",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 46
    new-instance v0, Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    invoke-direct {v0, p0}, Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;-><init>(Landroid/app/Activity;)V

    return-object v0
.end method
