.class final enum Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;
.super Ljava/lang/Enum;
.source "RestRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/rest/RestRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "RestAction"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

.field public static final enum BATCH:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

.field public static final enum COMPOSITE:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

.field public static final enum CREATE:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

.field public static final enum DELETE:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

.field public static final enum DESCRIBE:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

.field public static final enum DESCRIBE_GLOBAL:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

.field public static final enum METADATA:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

.field public static final enum QUERY:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

.field public static final enum RESOURCES:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

.field public static final enum RETRIEVE:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

.field public static final enum SEARCH:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

.field public static final enum SEARCH_RESULT_LAYOUT:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

.field public static final enum SEARCH_SCOPE_AND_ORDER:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

.field public static final enum SOBJECT_TREE:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

.field public static final enum UPDATE:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

.field public static final enum UPSERT:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

.field public static final enum VERSIONS:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;


# instance fields
.field private final pathTemplate:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 125
    new-instance v0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    const-string v1, "VERSIONS"

    const-string v2, "/services/data/"

    invoke-direct {v0, v1, v4, v2}, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->VERSIONS:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    .line 126
    new-instance v0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    const-string v1, "RESOURCES"

    const-string v2, "/services/data/%s/"

    invoke-direct {v0, v1, v5, v2}, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->RESOURCES:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    .line 127
    new-instance v0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    const-string v1, "DESCRIBE_GLOBAL"

    const-string v2, "/services/data/%s/sobjects/"

    invoke-direct {v0, v1, v6, v2}, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->DESCRIBE_GLOBAL:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    .line 128
    new-instance v0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    const-string v1, "METADATA"

    const-string v2, "/services/data/%s/sobjects/%s/"

    invoke-direct {v0, v1, v7, v2}, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->METADATA:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    .line 129
    new-instance v0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    const-string v1, "DESCRIBE"

    const-string v2, "/services/data/%s/sobjects/%s/describe/"

    invoke-direct {v0, v1, v8, v2}, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->DESCRIBE:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    .line 130
    new-instance v0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    const-string v1, "CREATE"

    const/4 v2, 0x5

    const-string v3, "/services/data/%s/sobjects/%s"

    invoke-direct {v0, v1, v2, v3}, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->CREATE:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    .line 131
    new-instance v0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    const-string v1, "RETRIEVE"

    const/4 v2, 0x6

    const-string v3, "/services/data/%s/sobjects/%s/%s"

    invoke-direct {v0, v1, v2, v3}, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->RETRIEVE:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    .line 132
    new-instance v0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    const-string v1, "UPSERT"

    const/4 v2, 0x7

    const-string v3, "/services/data/%s/sobjects/%s/%s/%s"

    invoke-direct {v0, v1, v2, v3}, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->UPSERT:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    .line 133
    new-instance v0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    const-string v1, "UPDATE"

    const/16 v2, 0x8

    const-string v3, "/services/data/%s/sobjects/%s/%s"

    invoke-direct {v0, v1, v2, v3}, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->UPDATE:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    .line 134
    new-instance v0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    const-string v1, "DELETE"

    const/16 v2, 0x9

    const-string v3, "/services/data/%s/sobjects/%s/%s"

    invoke-direct {v0, v1, v2, v3}, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->DELETE:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    .line 135
    new-instance v0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    const-string v1, "QUERY"

    const/16 v2, 0xa

    const-string v3, "/services/data/%s/query"

    invoke-direct {v0, v1, v2, v3}, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->QUERY:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    .line 136
    new-instance v0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    const-string v1, "SEARCH"

    const/16 v2, 0xb

    const-string v3, "/services/data/%s/search"

    invoke-direct {v0, v1, v2, v3}, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->SEARCH:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    .line 137
    new-instance v0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    const-string v1, "SEARCH_SCOPE_AND_ORDER"

    const/16 v2, 0xc

    const-string v3, "/services/data/%s/search/scopeOrder"

    invoke-direct {v0, v1, v2, v3}, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->SEARCH_SCOPE_AND_ORDER:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    .line 138
    new-instance v0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    const-string v1, "SEARCH_RESULT_LAYOUT"

    const/16 v2, 0xd

    const-string v3, "/services/data/%s/search/layout"

    invoke-direct {v0, v1, v2, v3}, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->SEARCH_RESULT_LAYOUT:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    .line 139
    new-instance v0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    const-string v1, "COMPOSITE"

    const/16 v2, 0xe

    const-string v3, "/services/data/%s/composite"

    invoke-direct {v0, v1, v2, v3}, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->COMPOSITE:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    .line 140
    new-instance v0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    const-string v1, "BATCH"

    const/16 v2, 0xf

    const-string v3, "/services/data/%s/composite/batch"

    invoke-direct {v0, v1, v2, v3}, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->BATCH:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    .line 141
    new-instance v0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    const-string v1, "SOBJECT_TREE"

    const/16 v2, 0x10

    const-string v3, "/services/data/%s/composite/tree/%s"

    invoke-direct {v0, v1, v2, v3}, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->SOBJECT_TREE:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    .line 124
    const/16 v0, 0x11

    new-array v0, v0, [Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    sget-object v1, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->VERSIONS:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    aput-object v1, v0, v4

    sget-object v1, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->RESOURCES:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    aput-object v1, v0, v5

    sget-object v1, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->DESCRIBE_GLOBAL:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    aput-object v1, v0, v6

    sget-object v1, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->METADATA:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    aput-object v1, v0, v7

    sget-object v1, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->DESCRIBE:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->CREATE:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->RETRIEVE:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->UPSERT:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->UPDATE:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->DELETE:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->QUERY:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->SEARCH:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->SEARCH_SCOPE_AND_ORDER:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->SEARCH_RESULT_LAYOUT:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->COMPOSITE:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->BATCH:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->SOBJECT_TREE:Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    aput-object v2, v0, v1

    sput-object v0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->$VALUES:[Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 145
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 146
    iput-object p3, p0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->pathTemplate:Ljava/lang/String;

    .line 147
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;
    .locals 1

    .prologue
    .line 124
    const-class v0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    return-object v0
.end method

.method public static values()[Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;
    .locals 1

    .prologue
    .line 124
    sget-object v0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->$VALUES:[Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    invoke-virtual {v0}, [Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;

    return-object v0
.end method


# virtual methods
.method public varargs getPath([Ljava/lang/Object;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 150
    iget-object v0, p0, Lcom/salesforce/androidsdk/rest/RestRequest$RestAction;->pathTemplate:Ljava/lang/String;

    invoke-static {v0, p1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
