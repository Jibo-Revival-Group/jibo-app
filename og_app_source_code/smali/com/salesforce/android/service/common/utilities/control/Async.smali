.class public interface abstract Lcom/salesforce/android/service/common/utilities/control/Async;
.super Ljava/lang/Object;
.source "Async.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/utilities/control/Async$Handler;,
        Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;,
        Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;,
        Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# virtual methods
.method public abstract a(Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TT;>;"
        }
    .end annotation
.end method

.method public abstract a(Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TT;>;"
        }
    .end annotation
.end method

.method public abstract a(Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler",
            "<-TT;>;)",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TT;>;"
        }
    .end annotation
.end method

.method public abstract a(Lcom/salesforce/android/service/common/utilities/control/ResultReceiver;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/ResultReceiver",
            "<-TT;>;)",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TT;>;"
        }
    .end annotation
.end method

.method public abstract a(Lcom/salesforce/android/service/common/utilities/functional/Function;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<S:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/salesforce/android/service/common/utilities/functional/Function",
            "<-TT;+TS;>;)",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TS;>;"
        }
    .end annotation
.end method

.method public abstract b(Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<S::",
            "Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler",
            "<-TT;>;:",
            "Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;",
            ":",
            "Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;",
            ">(TS;)",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TT;>;"
        }
    .end annotation
.end method

.method public abstract b(Lcom/salesforce/android/service/common/utilities/functional/Function;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<S:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/salesforce/android/service/common/utilities/functional/Function",
            "<-TT;+",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<+TS;>;>;)",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TS;>;"
        }
    .end annotation
.end method

.method public abstract c(Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<S::",
            "Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler",
            "<-TT;>;:",
            "Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;",
            ":",
            "Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;",
            ">(TS;)",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<TT;>;"
        }
    .end annotation
.end method

.method public abstract c()V
.end method

.method public abstract d()Z
.end method

.method public abstract e()Z
.end method

.method public abstract f()Z
.end method
