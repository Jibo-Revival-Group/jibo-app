.class public Lcom/jibo/ui/fragment/tips/TipsContent;
.super Ljava/lang/Object;
.source "TipsContent.java"


# static fields
.field private static a:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private static b:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;",
            ">;"
        }
    .end annotation
.end field

.field private static c:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;",
            ">;"
        }
    .end annotation
.end field

.field private static d:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;",
            ">;"
        }
    .end annotation
.end field

.field private static e:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;",
            ">;"
        }
    .end annotation
.end field

.field private static f:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;",
            ">;"
        }
    .end annotation
.end field

.field private static g:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;",
            ">;>;"
        }
    .end annotation
.end field

.field private static h:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    new-instance v0, Lcom/jibo/ui/fragment/tips/TipsContent$1;

    invoke-direct {v0}, Lcom/jibo/ui/fragment/tips/TipsContent$1;-><init>()V

    sput-object v0, Lcom/jibo/ui/fragment/tips/TipsContent;->a:Ljava/util/Map;

    .line 27
    new-instance v0, Lcom/jibo/ui/fragment/tips/TipsContent$2;

    invoke-direct {v0}, Lcom/jibo/ui/fragment/tips/TipsContent$2;-><init>()V

    sput-object v0, Lcom/jibo/ui/fragment/tips/TipsContent;->b:Ljava/util/List;

    .line 38
    new-instance v0, Lcom/jibo/ui/fragment/tips/TipsContent$3;

    invoke-direct {v0}, Lcom/jibo/ui/fragment/tips/TipsContent$3;-><init>()V

    sput-object v0, Lcom/jibo/ui/fragment/tips/TipsContent;->c:Ljava/util/List;

    .line 132
    new-instance v0, Lcom/jibo/ui/fragment/tips/TipsContent$4;

    invoke-direct {v0}, Lcom/jibo/ui/fragment/tips/TipsContent$4;-><init>()V

    sput-object v0, Lcom/jibo/ui/fragment/tips/TipsContent;->d:Ljava/util/List;

    .line 142
    new-instance v0, Lcom/jibo/ui/fragment/tips/TipsContent$5;

    invoke-direct {v0}, Lcom/jibo/ui/fragment/tips/TipsContent$5;-><init>()V

    sput-object v0, Lcom/jibo/ui/fragment/tips/TipsContent;->e:Ljava/util/List;

    .line 155
    new-instance v0, Lcom/jibo/ui/fragment/tips/TipsContent$6;

    invoke-direct {v0}, Lcom/jibo/ui/fragment/tips/TipsContent$6;-><init>()V

    sput-object v0, Lcom/jibo/ui/fragment/tips/TipsContent;->f:Ljava/util/List;

    .line 166
    new-instance v0, Lcom/jibo/ui/fragment/tips/TipsContent$7;

    invoke-direct {v0}, Lcom/jibo/ui/fragment/tips/TipsContent$7;-><init>()V

    sput-object v0, Lcom/jibo/ui/fragment/tips/TipsContent;->g:Ljava/util/Map;

    .line 176
    new-instance v0, Lcom/jibo/ui/fragment/tips/TipsContent$8;

    invoke-direct {v0}, Lcom/jibo/ui/fragment/tips/TipsContent$8;-><init>()V

    sput-object v0, Lcom/jibo/ui/fragment/tips/TipsContent;->h:Ljava/util/Map;

    return-void
.end method

.method public static a(Ljava/lang/String;)I
    .locals 1

    .prologue
    .line 187
    sget-object v0, Lcom/jibo/ui/fragment/tips/TipsContent;->a:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    return v0
.end method

.method static synthetic a()Ljava/util/List;
    .locals 1

    .prologue
    .line 14
    sget-object v0, Lcom/jibo/ui/fragment/tips/TipsContent;->b:Ljava/util/List;

    return-object v0
.end method

.method static synthetic b()Ljava/util/List;
    .locals 1

    .prologue
    .line 14
    sget-object v0, Lcom/jibo/ui/fragment/tips/TipsContent;->e:Ljava/util/List;

    return-object v0
.end method

.method public static b(Ljava/lang/String;)Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;",
            ">;"
        }
    .end annotation

    .prologue
    .line 191
    sget-object v0, Lcom/jibo/ui/fragment/tips/TipsContent;->g:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    return-object v0
.end method

.method public static c(Ljava/lang/String;)Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;
    .locals 1

    .prologue
    .line 195
    sget-object v0, Lcom/jibo/ui/fragment/tips/TipsContent;->h:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;

    return-object v0
.end method

.method static synthetic c()Ljava/util/List;
    .locals 1

    .prologue
    .line 14
    sget-object v0, Lcom/jibo/ui/fragment/tips/TipsContent;->d:Ljava/util/List;

    return-object v0
.end method

.method static synthetic d()Ljava/util/List;
    .locals 1

    .prologue
    .line 14
    sget-object v0, Lcom/jibo/ui/fragment/tips/TipsContent;->c:Ljava/util/List;

    return-object v0
.end method

.method static synthetic e()Ljava/util/List;
    .locals 1

    .prologue
    .line 14
    sget-object v0, Lcom/jibo/ui/fragment/tips/TipsContent;->f:Ljava/util/List;

    return-object v0
.end method
