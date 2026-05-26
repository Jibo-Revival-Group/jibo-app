.class public final enum Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/aws/integration/aws/services/account/model/Account;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Gender"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

.field public static final enum female:Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

.field public static final enum male:Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

.field public static final enum other:Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

.field public static final enum they:Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;


# instance fields
.field private final nameId:I


# direct methods
.method static constructor <clinit>()V
    .locals 7

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    new-instance v0, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    const-string v1, "male"

    sget v2, Lcom/jibo/aws/integration/R$string;->jbaws_Male:I

    invoke-direct {v0, v1, v3, v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->male:Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    new-instance v0, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    const-string v1, "female"

    sget v2, Lcom/jibo/aws/integration/R$string;->jbaws_Female:I

    invoke-direct {v0, v1, v4, v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->female:Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    new-instance v0, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    const-string v1, "other"

    sget v2, Lcom/jibo/aws/integration/R$string;->jbaws_Other:I

    invoke-direct {v0, v1, v5, v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->other:Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    new-instance v0, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    const-string v1, "they"

    sget v2, Lcom/jibo/aws/integration/R$string;->jbaws_They:I

    invoke-direct {v0, v1, v6, v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->they:Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    const/4 v0, 0x4

    new-array v0, v0, [Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    sget-object v1, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->male:Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    aput-object v1, v0, v3

    sget-object v1, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->female:Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    aput-object v1, v0, v4

    sget-object v1, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->other:Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    aput-object v1, v0, v5

    sget-object v1, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->they:Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    aput-object v1, v0, v6

    sput-object v0, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->$VALUES:[Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    iput p3, p0, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->nameId:I

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;
    .locals 1

    const-class v0, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    return-object v0
.end method

.method public static values()[Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;
    .locals 1

    sget-object v0, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->$VALUES:[Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    invoke-virtual {v0}, [Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    return-object v0
.end method


# virtual methods
.method public getNameId()I
    .locals 1

    iget v0, p0, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->nameId:I

    return v0
.end method
