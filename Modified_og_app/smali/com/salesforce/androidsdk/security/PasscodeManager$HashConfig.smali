.class public Lcom/salesforce/androidsdk/security/PasscodeManager$HashConfig;
.super Ljava/lang/Object;
.source "PasscodeManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/security/PasscodeManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "HashConfig"
.end annotation


# instance fields
.field public final a:Ljava/lang/String;

.field public final b:Ljava/lang/String;

.field public final c:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 616
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 617
    iput-object p1, p0, Lcom/salesforce/androidsdk/security/PasscodeManager$HashConfig;->a:Ljava/lang/String;

    .line 618
    iput-object p2, p0, Lcom/salesforce/androidsdk/security/PasscodeManager$HashConfig;->b:Ljava/lang/String;

    .line 619
    iput-object p3, p0, Lcom/salesforce/androidsdk/security/PasscodeManager$HashConfig;->c:Ljava/lang/String;

    .line 620
    return-void
.end method
