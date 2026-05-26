.class final Lcom/mixpanel/android/mpmetrics/TakeoverInAppNotification$1;
.super Ljava/lang/Object;
.source "TakeoverInAppNotification.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/mixpanel/android/mpmetrics/TakeoverInAppNotification;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/os/Parcelable$Creator",
        "<",
        "Lcom/mixpanel/android/mpmetrics/TakeoverInAppNotification;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 99
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/os/Parcel;)Lcom/mixpanel/android/mpmetrics/TakeoverInAppNotification;
    .locals 1

    .prologue
    .line 103
    new-instance v0, Lcom/mixpanel/android/mpmetrics/TakeoverInAppNotification;

    invoke-direct {v0, p1}, Lcom/mixpanel/android/mpmetrics/TakeoverInAppNotification;-><init>(Landroid/os/Parcel;)V

    return-object v0
.end method

.method public a(I)[Lcom/mixpanel/android/mpmetrics/TakeoverInAppNotification;
    .locals 1

    .prologue
    .line 108
    new-array v0, p1, [Lcom/mixpanel/android/mpmetrics/TakeoverInAppNotification;

    return-object v0
.end method

.method public synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 99
    invoke-virtual {p0, p1}, Lcom/mixpanel/android/mpmetrics/TakeoverInAppNotification$1;->a(Landroid/os/Parcel;)Lcom/mixpanel/android/mpmetrics/TakeoverInAppNotification;

    move-result-object v0

    return-object v0
.end method

.method public synthetic newArray(I)[Ljava/lang/Object;
    .locals 1

    .prologue
    .line 99
    invoke-virtual {p0, p1}, Lcom/mixpanel/android/mpmetrics/TakeoverInAppNotification$1;->a(I)[Lcom/mixpanel/android/mpmetrics/TakeoverInAppNotification;

    move-result-object v0

    return-object v0
.end method
