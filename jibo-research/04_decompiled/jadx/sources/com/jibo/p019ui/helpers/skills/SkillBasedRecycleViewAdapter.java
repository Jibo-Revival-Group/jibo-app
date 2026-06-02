package com.jibo.p019ui.helpers.skills;

import android.view.View;
import com.jibo.p019ui.helpers.AbstractItemRecycleViewAdapter;
import com.jibo.p019ui.helpers.Items;
import com.jibo.p019ui.helpers.ViewHolders;
import com.jibo.p019ui.helpers.skills.ViewHolders;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SkillBasedRecycleViewAdapter extends AbstractItemRecycleViewAdapter {
    private boolean mIsOwner;

    public SkillBasedRecycleViewAdapter(List<Items.Item> list, boolean z) {
        super(list);
        this.mIsOwner = z;
    }

    @Override // com.jibo.p019ui.helpers.AbstractItemRecycleViewAdapter
    protected ViewHolders.AbstractViewHolder getViewHolderByItem(View view, Items.ItemType itemType) {
        switch (itemType) {
            case skill:
                return new ViewHolders.SkillViewHolder(view, this.mIsOwner);
            case skill_footer:
                return new ViewHolders.FooterViewHolder(view, this.mIsOwner);
            case skill_switch:
                return new ViewHolders.SwitchViewHolder(view, this.mIsOwner);
            case skill_toggle:
                return new ViewHolders.ToggleViewHolder(view, this.mIsOwner);
            case skill_address_location_text_field:
                return new ViewHolders.LocationViewHolder(view, true);
            case skill_choice:
                return new ViewHolders.ChoiceViewHolder(view, this.mIsOwner);
            case skill_time:
                return new ViewHolders.TimeViewHolder(view, this.mIsOwner);
            case skill_connectable:
                return new ViewHolders.ConnectableViewHolder(view, this.mIsOwner);
            case skill_oauth:
                return new ViewHolders.OauthViewHolder(view, this.mIsOwner);
            default:
                return super.getViewHolderByItem(view, itemType);
        }
    }
}
