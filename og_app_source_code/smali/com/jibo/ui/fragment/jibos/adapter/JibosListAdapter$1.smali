.class synthetic Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$1;
.super Ljava/lang/Object;
.source "JibosListAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1008
    name = null
.end annotation


# static fields
.field static final synthetic a:[I


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 120
    invoke-static {}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;->values()[Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    sput-object v0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$1;->a:[I

    :try_start_0
    sget-object v0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$1;->a:[I

    sget-object v1, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;->joinedLoop:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_3

    :goto_0
    :try_start_1
    sget-object v0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$1;->a:[I

    sget-object v1, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;->myLoop:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_2

    :goto_1
    :try_start_2
    sget-object v0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$1;->a:[I

    sget-object v1, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;->invitedLoop:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;->ordinal()I

    move-result v1

    const/4 v2, 0x3

    aput v2, v0, v1
    :try_end_2
    .catch Ljava/lang/NoSuchFieldError; {:try_start_2 .. :try_end_2} :catch_1

    :goto_2
    :try_start_3
    sget-object v0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$1;->a:[I

    sget-object v1, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;->newjibo:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;->ordinal()I

    move-result v1

    const/4 v2, 0x4

    aput v2, v0, v1
    :try_end_3
    .catch Ljava/lang/NoSuchFieldError; {:try_start_3 .. :try_end_3} :catch_0

    :goto_3
    return-void

    :catch_0
    move-exception v0

    goto :goto_3

    :catch_1
    move-exception v0

    goto :goto_2

    :catch_2
    move-exception v0

    goto :goto_1

    :catch_3
    move-exception v0

    goto :goto_0
.end method
