.class public Lcom/jibo/db/DatabaseContract;
.super Ljava/lang/Object;
.source "DatabaseContract.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/db/DatabaseContract$MediaEntry;,
        Lcom/jibo/db/DatabaseContract$JotEntry;,
        Lcom/jibo/db/DatabaseContract$EntityEntry;,
        Lcom/jibo/db/DatabaseContract$LogEntry;
    }
.end annotation


# static fields
.field public static final a:Landroid/net/Uri;

.field public static final b:Landroid/net/Uri;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 13
    const-string v0, "content://com.jibo.provider.db"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/jibo/db/DatabaseContract;->a:Landroid/net/Uri;

    .line 14
    const-string v0, "content://com.jibo.provider.db.messages"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/jibo/db/DatabaseContract;->b:Landroid/net/Uri;

    return-void
.end method
