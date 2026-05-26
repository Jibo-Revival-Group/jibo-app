.class public interface abstract Lcom/mixpanel/android/util/RemoteService;
.super Ljava/lang/Object;
.source "RemoteService.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/mixpanel/android/util/RemoteService$ServiceUnavailableException;
    }
.end annotation


# virtual methods
.method public abstract a()V
.end method

.method public abstract a(Landroid/content/Context;Lcom/mixpanel/android/util/OfflineMode;)Z
.end method

.method public abstract a(Ljava/lang/String;Ljava/util/Map;Ljavax/net/ssl/SSLSocketFactory;)[B
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;",
            "Ljavax/net/ssl/SSLSocketFactory;",
            ")[B"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/mixpanel/android/util/RemoteService$ServiceUnavailableException;,
            Ljava/io/IOException;
        }
    .end annotation
.end method
