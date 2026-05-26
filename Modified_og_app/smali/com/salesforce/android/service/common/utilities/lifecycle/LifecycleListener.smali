.class public interface abstract Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleListener;
.super Ljava/lang/Object;
.source "LifecycleListener.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<S:",
        "Ljava/lang/Enum",
        "<TS;>;:",
        "Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleState",
        "<TM;>;M:",
        "Ljava/lang/Enum",
        "<TM;>;:",
        "Lcom/salesforce/android/service/common/utilities/lifecycle/LifecycleMetric;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# virtual methods
.method public abstract a(Ljava/lang/Enum;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TM;)V"
        }
    .end annotation
.end method

.method public abstract a(Ljava/lang/Enum;Ljava/lang/Enum;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TS;TS;)V"
        }
    .end annotation
.end method
