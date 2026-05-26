.class Lcom/salesforce/androidsdk/config/AbstractPrefsManager$1;
.super Ljava/lang/Object;
.source "AbstractPrefsManager.java"

# interfaces
.implements Ljava/io/FilenameFilter;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/androidsdk/config/AbstractPrefsManager;->c()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/androidsdk/config/AbstractPrefsManager;


# direct methods
.method constructor <init>(Lcom/salesforce/androidsdk/config/AbstractPrefsManager;)V
    .locals 0

    .prologue
    .line 142
    iput-object p1, p0, Lcom/salesforce/androidsdk/config/AbstractPrefsManager$1;->a:Lcom/salesforce/androidsdk/config/AbstractPrefsManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public accept(Ljava/io/File;Ljava/lang/String;)Z
    .locals 1

    .prologue
    .line 145
    if-eqz p2, :cond_0

    iget-object v0, p0, Lcom/salesforce/androidsdk/config/AbstractPrefsManager$1;->a:Lcom/salesforce/androidsdk/config/AbstractPrefsManager;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/config/AbstractPrefsManager;->a()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
