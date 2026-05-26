.class public final enum Lcom/jibo/ui/helpers/Items$ItemType;
.super Ljava/lang/Enum;
.source "Items.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/Items;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "ItemType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/jibo/ui/helpers/Items$ItemType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/jibo/ui/helpers/Items$ItemType;

.field public static final enum add_custom_holiday:Lcom/jibo/ui/helpers/Items$ItemType;

.field public static final enum attribution:Lcom/jibo/ui/helpers/Items$ItemType;

.field public static final enum checkbox_date_row_leftsided:Lcom/jibo/ui/helpers/Items$ItemType;

.field public static final enum checkbox_row_leftsided:Lcom/jibo/ui/helpers/Items$ItemType;

.field public static final enum date:Lcom/jibo/ui/helpers/Items$ItemType;

.field public static final enum dialog_bottom_sheet_item:Lcom/jibo/ui/helpers/Items$ItemType;

.field public static final enum footer:Lcom/jibo/ui/helpers/Items$ItemType;

.field public static final enum header_with_button:Lcom/jibo/ui/helpers/Items$ItemType;

.field public static final enum invite:Lcom/jibo/ui/helpers/Items$ItemType;

.field public static final enum jiboheader:Lcom/jibo/ui/helpers/Items$ItemType;

.field public static final enum member:Lcom/jibo/ui/helpers/Items$ItemType;

.field public static final enum searchRecap:Lcom/jibo/ui/helpers/Items$ItemType;

.field public static final enum settings:Lcom/jibo/ui/helpers/Items$ItemType;

.field public static final enum setup_jibo:Lcom/jibo/ui/helpers/Items$ItemType;

.field public static final enum skill:Lcom/jibo/ui/helpers/Items$ItemType;

.field public static final enum skill_address_location_text_field:Lcom/jibo/ui/helpers/Items$ItemType;

.field public static final enum skill_choice:Lcom/jibo/ui/helpers/Items$ItemType;

.field public static final enum skill_connectable:Lcom/jibo/ui/helpers/Items$ItemType;

.field public static final enum skill_footer:Lcom/jibo/ui/helpers/Items$ItemType;

.field public static final enum skill_oauth:Lcom/jibo/ui/helpers/Items$ItemType;

.field public static final enum skill_switch:Lcom/jibo/ui/helpers/Items$ItemType;

.field public static final enum skill_time:Lcom/jibo/ui/helpers/Items$ItemType;

.field public static final enum skill_toggle:Lcom/jibo/ui/helpers/Items$ItemType;

.field public static final enum subheader:Lcom/jibo/ui/helpers/Items$ItemType;

.field public static final enum suspended_loop:Lcom/jibo/ui/helpers/Items$ItemType;

.field public static final enum switch_row:Lcom/jibo/ui/helpers/Items$ItemType;

.field public static final enum text_avatar_double_row:Lcom/jibo/ui/helpers/Items$ItemType;

.field public static final enum text_avatar_radio_double_row:Lcom/jibo/ui/helpers/Items$ItemType;

.field public static final enum text_bold_single_row:Lcom/jibo/ui/helpers/Items$ItemType;

.field public static final enum text_button:Lcom/jibo/ui/helpers/Items$ItemType;

.field public static final enum text_button_small:Lcom/jibo/ui/helpers/Items$ItemType;

.field public static final enum text_button_small_red:Lcom/jibo/ui/helpers/Items$ItemType;

.field public static final enum text_double_greyed_row:Lcom/jibo/ui/helpers/Items$ItemType;

.field public static final enum text_double_row:Lcom/jibo/ui/helpers/Items$ItemType;

.field public static final enum text_greyed_row:Lcom/jibo/ui/helpers/Items$ItemType;

.field public static final enum wifisettings:Lcom/jibo/ui/helpers/Items$ItemType;


# instance fields
.field layoutId:I


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x3

    const/4 v7, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    const v4, 0x7f0b00d0

    .line 21
    new-instance v0, Lcom/jibo/ui/helpers/Items$ItemType;

    const-string v1, "jiboheader"

    const v2, 0x7f0b00bc

    invoke-direct {v0, v1, v5, v2}, Lcom/jibo/ui/helpers/Items$ItemType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->jiboheader:Lcom/jibo/ui/helpers/Items$ItemType;

    .line 22
    new-instance v0, Lcom/jibo/ui/helpers/Items$ItemType;

    const-string v1, "settings"

    const v2, 0x7f0b00bf

    invoke-direct {v0, v1, v6, v2}, Lcom/jibo/ui/helpers/Items$ItemType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->settings:Lcom/jibo/ui/helpers/Items$ItemType;

    .line 23
    new-instance v0, Lcom/jibo/ui/helpers/Items$ItemType;

    const-string v1, "wifisettings"

    const v2, 0x7f0b00c0

    invoke-direct {v0, v1, v7, v2}, Lcom/jibo/ui/helpers/Items$ItemType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->wifisettings:Lcom/jibo/ui/helpers/Items$ItemType;

    .line 24
    new-instance v0, Lcom/jibo/ui/helpers/Items$ItemType;

    const-string v1, "subheader"

    const v2, 0x7f0b00cd

    invoke-direct {v0, v1, v8, v2}, Lcom/jibo/ui/helpers/Items$ItemType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->subheader:Lcom/jibo/ui/helpers/Items$ItemType;

    .line 25
    new-instance v0, Lcom/jibo/ui/helpers/Items$ItemType;

    const-string v1, "member"

    const/4 v2, 0x4

    const v3, 0x7f0b00be

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/helpers/Items$ItemType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->member:Lcom/jibo/ui/helpers/Items$ItemType;

    .line 26
    new-instance v0, Lcom/jibo/ui/helpers/Items$ItemType;

    const-string v1, "invite"

    const/4 v2, 0x5

    const v3, 0x7f0b00bd

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/helpers/Items$ItemType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->invite:Lcom/jibo/ui/helpers/Items$ItemType;

    .line 27
    new-instance v0, Lcom/jibo/ui/helpers/Items$ItemType;

    const-string v1, "footer"

    const/4 v2, 0x6

    const v3, 0x7f0b00ba

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/helpers/Items$ItemType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->footer:Lcom/jibo/ui/helpers/Items$ItemType;

    .line 28
    new-instance v0, Lcom/jibo/ui/helpers/Items$ItemType;

    const-string v1, "searchRecap"

    const/4 v2, 0x7

    const v3, 0x7f0b00cb

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/helpers/Items$ItemType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->searchRecap:Lcom/jibo/ui/helpers/Items$ItemType;

    .line 29
    new-instance v0, Lcom/jibo/ui/helpers/Items$ItemType;

    const-string v1, "date"

    const/16 v2, 0x8

    const v3, 0x7f0b00b2

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/helpers/Items$ItemType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->date:Lcom/jibo/ui/helpers/Items$ItemType;

    .line 30
    new-instance v0, Lcom/jibo/ui/helpers/Items$ItemType;

    const-string v1, "header_with_button"

    const/16 v2, 0x9

    const v3, 0x7f0b00b4

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/helpers/Items$ItemType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->header_with_button:Lcom/jibo/ui/helpers/Items$ItemType;

    .line 31
    new-instance v0, Lcom/jibo/ui/helpers/Items$ItemType;

    const-string v1, "attribution"

    const/16 v2, 0xa

    const v3, 0x7f0b00ac

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/helpers/Items$ItemType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->attribution:Lcom/jibo/ui/helpers/Items$ItemType;

    .line 32
    new-instance v0, Lcom/jibo/ui/helpers/Items$ItemType;

    const-string v1, "text_button"

    const/16 v2, 0xb

    const v3, 0x7f0b00d3

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/helpers/Items$ItemType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->text_button:Lcom/jibo/ui/helpers/Items$ItemType;

    .line 33
    new-instance v0, Lcom/jibo/ui/helpers/Items$ItemType;

    const-string v1, "text_button_small"

    const/16 v2, 0xc

    const v3, 0x7f0b00d4

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/helpers/Items$ItemType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->text_button_small:Lcom/jibo/ui/helpers/Items$ItemType;

    .line 34
    new-instance v0, Lcom/jibo/ui/helpers/Items$ItemType;

    const-string v1, "text_button_small_red"

    const/16 v2, 0xd

    const v3, 0x7f0b00d5

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/helpers/Items$ItemType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->text_button_small_red:Lcom/jibo/ui/helpers/Items$ItemType;

    .line 35
    new-instance v0, Lcom/jibo/ui/helpers/Items$ItemType;

    const-string v1, "suspended_loop"

    const/16 v2, 0xe

    const v3, 0x7f0b00ce

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/helpers/Items$ItemType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->suspended_loop:Lcom/jibo/ui/helpers/Items$ItemType;

    .line 36
    new-instance v0, Lcom/jibo/ui/helpers/Items$ItemType;

    const-string v1, "setup_jibo"

    const/16 v2, 0xf

    const v3, 0x7f0b00b9

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/helpers/Items$ItemType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->setup_jibo:Lcom/jibo/ui/helpers/Items$ItemType;

    .line 37
    new-instance v0, Lcom/jibo/ui/helpers/Items$ItemType;

    const-string v1, "switch_row"

    const/16 v2, 0x10

    const v3, 0x7f0b00cf

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/helpers/Items$ItemType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->switch_row:Lcom/jibo/ui/helpers/Items$ItemType;

    .line 38
    new-instance v0, Lcom/jibo/ui/helpers/Items$ItemType;

    const-string v1, "checkbox_row_leftsided"

    const/16 v2, 0x11

    const v3, 0x7f0b00af

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/helpers/Items$ItemType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->checkbox_row_leftsided:Lcom/jibo/ui/helpers/Items$ItemType;

    .line 39
    new-instance v0, Lcom/jibo/ui/helpers/Items$ItemType;

    const-string v1, "checkbox_date_row_leftsided"

    const/16 v2, 0x12

    const v3, 0x7f0b00ae

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/helpers/Items$ItemType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->checkbox_date_row_leftsided:Lcom/jibo/ui/helpers/Items$ItemType;

    .line 40
    new-instance v0, Lcom/jibo/ui/helpers/Items$ItemType;

    const-string v1, "text_greyed_row"

    const/16 v2, 0x13

    const v3, 0x7f0b00d8

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/helpers/Items$ItemType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->text_greyed_row:Lcom/jibo/ui/helpers/Items$ItemType;

    .line 41
    new-instance v0, Lcom/jibo/ui/helpers/Items$ItemType;

    const-string v1, "text_bold_single_row"

    const/16 v2, 0x14

    const v3, 0x7f0b00d2

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/helpers/Items$ItemType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->text_bold_single_row:Lcom/jibo/ui/helpers/Items$ItemType;

    .line 42
    new-instance v0, Lcom/jibo/ui/helpers/Items$ItemType;

    const-string v1, "text_double_row"

    const/16 v2, 0x15

    const v3, 0x7f0b00d7

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/helpers/Items$ItemType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->text_double_row:Lcom/jibo/ui/helpers/Items$ItemType;

    .line 43
    new-instance v0, Lcom/jibo/ui/helpers/Items$ItemType;

    const-string v1, "text_double_greyed_row"

    const/16 v2, 0x16

    const v3, 0x7f0b00d6

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/helpers/Items$ItemType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->text_double_greyed_row:Lcom/jibo/ui/helpers/Items$ItemType;

    .line 44
    new-instance v0, Lcom/jibo/ui/helpers/Items$ItemType;

    const-string v1, "text_avatar_double_row"

    const/16 v2, 0x17

    invoke-direct {v0, v1, v2, v4}, Lcom/jibo/ui/helpers/Items$ItemType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->text_avatar_double_row:Lcom/jibo/ui/helpers/Items$ItemType;

    .line 45
    new-instance v0, Lcom/jibo/ui/helpers/Items$ItemType;

    const-string v1, "text_avatar_radio_double_row"

    const/16 v2, 0x18

    const v3, 0x7f0b00d1

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/helpers/Items$ItemType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->text_avatar_radio_double_row:Lcom/jibo/ui/helpers/Items$ItemType;

    .line 46
    new-instance v0, Lcom/jibo/ui/helpers/Items$ItemType;

    const-string v1, "add_custom_holiday"

    const/16 v2, 0x19

    const v3, 0x7f0b00b1

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/helpers/Items$ItemType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->add_custom_holiday:Lcom/jibo/ui/helpers/Items$ItemType;

    .line 47
    new-instance v0, Lcom/jibo/ui/helpers/Items$ItemType;

    const-string v1, "dialog_bottom_sheet_item"

    const/16 v2, 0x1a

    const v3, 0x7f0b00ad

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/helpers/Items$ItemType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->dialog_bottom_sheet_item:Lcom/jibo/ui/helpers/Items$ItemType;

    .line 50
    new-instance v0, Lcom/jibo/ui/helpers/Items$ItemType;

    const-string v1, "skill"

    const/16 v2, 0x1b

    invoke-direct {v0, v1, v2, v4}, Lcom/jibo/ui/helpers/Items$ItemType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->skill:Lcom/jibo/ui/helpers/Items$ItemType;

    .line 51
    new-instance v0, Lcom/jibo/ui/helpers/Items$ItemType;

    const-string v1, "skill_footer"

    const/16 v2, 0x1c

    const v3, 0x7f0b00ba

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/helpers/Items$ItemType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->skill_footer:Lcom/jibo/ui/helpers/Items$ItemType;

    .line 52
    new-instance v0, Lcom/jibo/ui/helpers/Items$ItemType;

    const-string v1, "skill_switch"

    const/16 v2, 0x1d

    const v3, 0x7f0b00cf

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/helpers/Items$ItemType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->skill_switch:Lcom/jibo/ui/helpers/Items$ItemType;

    .line 53
    new-instance v0, Lcom/jibo/ui/helpers/Items$ItemType;

    const-string v1, "skill_address_location_text_field"

    const/16 v2, 0x1e

    const v3, 0x7f0b00ab

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/helpers/Items$ItemType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->skill_address_location_text_field:Lcom/jibo/ui/helpers/Items$ItemType;

    .line 54
    new-instance v0, Lcom/jibo/ui/helpers/Items$ItemType;

    const-string v1, "skill_toggle"

    const/16 v2, 0x1f

    const v3, 0x7f0b00af

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/helpers/Items$ItemType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->skill_toggle:Lcom/jibo/ui/helpers/Items$ItemType;

    .line 55
    new-instance v0, Lcom/jibo/ui/helpers/Items$ItemType;

    const-string v1, "skill_choice"

    const/16 v2, 0x20

    const v3, 0x7f0b00c9

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/helpers/Items$ItemType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->skill_choice:Lcom/jibo/ui/helpers/Items$ItemType;

    .line 56
    new-instance v0, Lcom/jibo/ui/helpers/Items$ItemType;

    const-string v1, "skill_time"

    const/16 v2, 0x21

    const v3, 0x7f0b00d9

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/helpers/Items$ItemType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->skill_time:Lcom/jibo/ui/helpers/Items$ItemType;

    .line 57
    new-instance v0, Lcom/jibo/ui/helpers/Items$ItemType;

    const-string v1, "skill_connectable"

    const/16 v2, 0x22

    const v3, 0x7f0b00b0

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/helpers/Items$ItemType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->skill_connectable:Lcom/jibo/ui/helpers/Items$ItemType;

    .line 58
    new-instance v0, Lcom/jibo/ui/helpers/Items$ItemType;

    const-string v1, "skill_oauth"

    const/16 v2, 0x23

    invoke-direct {v0, v1, v2, v4}, Lcom/jibo/ui/helpers/Items$ItemType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->skill_oauth:Lcom/jibo/ui/helpers/Items$ItemType;

    .line 20
    const/16 v0, 0x24

    new-array v0, v0, [Lcom/jibo/ui/helpers/Items$ItemType;

    sget-object v1, Lcom/jibo/ui/helpers/Items$ItemType;->jiboheader:Lcom/jibo/ui/helpers/Items$ItemType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/jibo/ui/helpers/Items$ItemType;->settings:Lcom/jibo/ui/helpers/Items$ItemType;

    aput-object v1, v0, v6

    sget-object v1, Lcom/jibo/ui/helpers/Items$ItemType;->wifisettings:Lcom/jibo/ui/helpers/Items$ItemType;

    aput-object v1, v0, v7

    sget-object v1, Lcom/jibo/ui/helpers/Items$ItemType;->subheader:Lcom/jibo/ui/helpers/Items$ItemType;

    aput-object v1, v0, v8

    const/4 v1, 0x4

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->member:Lcom/jibo/ui/helpers/Items$ItemType;

    aput-object v2, v0, v1

    const/4 v1, 0x5

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->invite:Lcom/jibo/ui/helpers/Items$ItemType;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->footer:Lcom/jibo/ui/helpers/Items$ItemType;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->searchRecap:Lcom/jibo/ui/helpers/Items$ItemType;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->date:Lcom/jibo/ui/helpers/Items$ItemType;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->header_with_button:Lcom/jibo/ui/helpers/Items$ItemType;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->attribution:Lcom/jibo/ui/helpers/Items$ItemType;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->text_button:Lcom/jibo/ui/helpers/Items$ItemType;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->text_button_small:Lcom/jibo/ui/helpers/Items$ItemType;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->text_button_small_red:Lcom/jibo/ui/helpers/Items$ItemType;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->suspended_loop:Lcom/jibo/ui/helpers/Items$ItemType;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->setup_jibo:Lcom/jibo/ui/helpers/Items$ItemType;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->switch_row:Lcom/jibo/ui/helpers/Items$ItemType;

    aput-object v2, v0, v1

    const/16 v1, 0x11

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->checkbox_row_leftsided:Lcom/jibo/ui/helpers/Items$ItemType;

    aput-object v2, v0, v1

    const/16 v1, 0x12

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->checkbox_date_row_leftsided:Lcom/jibo/ui/helpers/Items$ItemType;

    aput-object v2, v0, v1

    const/16 v1, 0x13

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->text_greyed_row:Lcom/jibo/ui/helpers/Items$ItemType;

    aput-object v2, v0, v1

    const/16 v1, 0x14

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->text_bold_single_row:Lcom/jibo/ui/helpers/Items$ItemType;

    aput-object v2, v0, v1

    const/16 v1, 0x15

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->text_double_row:Lcom/jibo/ui/helpers/Items$ItemType;

    aput-object v2, v0, v1

    const/16 v1, 0x16

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->text_double_greyed_row:Lcom/jibo/ui/helpers/Items$ItemType;

    aput-object v2, v0, v1

    const/16 v1, 0x17

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->text_avatar_double_row:Lcom/jibo/ui/helpers/Items$ItemType;

    aput-object v2, v0, v1

    const/16 v1, 0x18

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->text_avatar_radio_double_row:Lcom/jibo/ui/helpers/Items$ItemType;

    aput-object v2, v0, v1

    const/16 v1, 0x19

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->add_custom_holiday:Lcom/jibo/ui/helpers/Items$ItemType;

    aput-object v2, v0, v1

    const/16 v1, 0x1a

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->dialog_bottom_sheet_item:Lcom/jibo/ui/helpers/Items$ItemType;

    aput-object v2, v0, v1

    const/16 v1, 0x1b

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->skill:Lcom/jibo/ui/helpers/Items$ItemType;

    aput-object v2, v0, v1

    const/16 v1, 0x1c

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->skill_footer:Lcom/jibo/ui/helpers/Items$ItemType;

    aput-object v2, v0, v1

    const/16 v1, 0x1d

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->skill_switch:Lcom/jibo/ui/helpers/Items$ItemType;

    aput-object v2, v0, v1

    const/16 v1, 0x1e

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->skill_address_location_text_field:Lcom/jibo/ui/helpers/Items$ItemType;

    aput-object v2, v0, v1

    const/16 v1, 0x1f

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->skill_toggle:Lcom/jibo/ui/helpers/Items$ItemType;

    aput-object v2, v0, v1

    const/16 v1, 0x20

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->skill_choice:Lcom/jibo/ui/helpers/Items$ItemType;

    aput-object v2, v0, v1

    const/16 v1, 0x21

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->skill_time:Lcom/jibo/ui/helpers/Items$ItemType;

    aput-object v2, v0, v1

    const/16 v1, 0x22

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->skill_connectable:Lcom/jibo/ui/helpers/Items$ItemType;

    aput-object v2, v0, v1

    const/16 v1, 0x23

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->skill_oauth:Lcom/jibo/ui/helpers/Items$ItemType;

    aput-object v2, v0, v1

    sput-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->$VALUES:[Lcom/jibo/ui/helpers/Items$ItemType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    .prologue
    .line 66
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 67
    iput p3, p0, Lcom/jibo/ui/helpers/Items$ItemType;->layoutId:I

    .line 68
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/jibo/ui/helpers/Items$ItemType;
    .locals 1

    .prologue
    .line 20
    const-class v0, Lcom/jibo/ui/helpers/Items$ItemType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/Items$ItemType;

    return-object v0
.end method

.method public static values()[Lcom/jibo/ui/helpers/Items$ItemType;
    .locals 1

    .prologue
    .line 20
    sget-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->$VALUES:[Lcom/jibo/ui/helpers/Items$ItemType;

    invoke-virtual {v0}, [Lcom/jibo/ui/helpers/Items$ItemType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/jibo/ui/helpers/Items$ItemType;

    return-object v0
.end method


# virtual methods
.method public getLayoutId()I
    .locals 1

    .prologue
    .line 63
    iget v0, p0, Lcom/jibo/ui/helpers/Items$ItemType;->layoutId:I

    return v0
.end method
