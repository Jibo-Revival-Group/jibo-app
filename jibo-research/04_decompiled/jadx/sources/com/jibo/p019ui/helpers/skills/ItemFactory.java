package com.jibo.p019ui.helpers.skills;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;
import com.google.gson.Gson;
import com.jibo.R;
import com.jibo.p019ui.activity.BaseActivity;
import com.jibo.p019ui.fragment.account.skills.LocationFragment;
import com.jibo.p019ui.fragment.account.skills.OauthFragment;
import com.jibo.p019ui.fragment.account.skills.SkillSettingsFragment;
import com.jibo.p019ui.fragment.dialog.skills.MaterialTimePickerDialogFragment;
import com.jibo.p019ui.helpers.Items;
import com.jibo.p019ui.helpers.skills.DataItems;
import com.jibo.p019ui.helpers.skills.Items;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ItemFactory {
    private static Gson gson = new Gson();
    private int[] mCurrentViewsPath;
    private SkillSettingsFragment.DataPublisher mDataDeleter;
    private SkillSettingsFragment.DataPublisher mDataPublisher;

    public ItemFactory(int[] iArr, SkillSettingsFragment.DataPublisher dataPublisher) {
        this.mCurrentViewsPath = iArr;
        this.mDataPublisher = dataPublisher;
        this.mDataDeleter = null;
    }

    public ItemFactory(int[] iArr, SkillSettingsFragment.DataPublisher dataPublisher, SkillSettingsFragment.DataPublisher dataPublisher2) {
        this.mCurrentViewsPath = iArr;
        this.mDataPublisher = dataPublisher;
        this.mDataDeleter = dataPublisher2;
    }

    public List<Items.Item> getItems(List<DataItems.DataItem> list) {
        View.OnClickListener onClickLister;
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        for (DataItems.DataItem dataItem : list) {
            onClickLister = getOnClickLister(dataItem, list.indexOf(dataItem));
            switch (dataItem.getType()) {
                case "skill":
                    arrayList.add(new Items.SkillItem(onClickLister, (DataItems.SkillViewDataItem) dataItem));
                    break;
                case "switch":
                    arrayList.add(new Items.SwitchItem(onClickLister, getOnCheckChangeListener(dataItem, list.indexOf(dataItem)), (DataItems.SwitchDataItem) dataItem));
                    break;
                case "subheader":
                    arrayList.add(new Items.SubheaderItem(dataItem.getTitle()));
                    break;
                case "footer":
                    arrayList.add(new Items.SkillFooterItem((DataItems.FooterDataItem) dataItem));
                    break;
                case "choice":
                    arrayList.add(new Items.ChoiceItem(onClickLister, (DataItems.ChoiceDataItem) dataItem));
                    break;
                case "toggle":
                    arrayList.add(new Items.ToggleItem(onClickLister, (DataItems.ToggleDataItem) dataItem));
                    break;
                case "locationTextField":
                    arrayList.add(new Items.LocationItem(onClickLister, (DataItems.LocationDataItem) dataItem));
                    break;
                case "connectable":
                    arrayList.add(new Items.ConnectableItem(onClickLister, (DataItems.ConnectableDataItem) dataItem));
                    break;
                case "oauth":
                    arrayList.add(new Items.OauthItem(onClickLister, (DataItems.OauthDataItem) dataItem));
                    break;
                case "time":
                    arrayList.add(new Items.TimeItem(onClickLister, (DataItems.TimeDataItem) dataItem));
                    break;
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void putBooleanDataValue(DataItems.DataItem dataItem) {
        if (this.mDataPublisher != null) {
            DataItems.BooleanDataValue booleanDataValue = new DataItems.BooleanDataValue();
            boolean z = dataItem.getDataValue() == null || !((DataItems.BooleanDataValue) dataItem.getDataValue()).getValue();
            booleanDataValue.setValue(z);
            this.mDataPublisher.mo10406a(dataItem, booleanDataValue, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void putBooleanDataValue(DataItems.DataItem dataItem, boolean z) {
        if (this.mDataPublisher != null) {
            DataItems.BooleanDataValue booleanDataValue = new DataItems.BooleanDataValue();
            booleanDataValue.setValue(z);
            this.mDataPublisher.mo10406a(dataItem, booleanDataValue, null);
        }
    }

    private CompoundButton.OnCheckedChangeListener getOnCheckChangeListener(final DataItems.DataItem dataItem, int i) {
        switch (dataItem.getType()) {
            case "switch":
                return new CompoundButton.OnCheckedChangeListener() { // from class: com.jibo.ui.helpers.skills.ItemFactory.1
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        boolean z2 = (compoundButton.getTag() instanceof Items.SwitchItem) && ((Items.SwitchItem) compoundButton.getTag()).mDataItem == dataItem;
                        boolean z3 = dataItem.getValueDefinition() == null || dataItem.getValueDefinition().getDataValue() == null || ((DataItems.BooleanDataValue) dataItem.getValueDefinition().getDataValue()).getValue() != z;
                        if (z2 && z3) {
                            ItemFactory.this.putBooleanDataValue(dataItem, z);
                        }
                    }
                };
            default:
                return null;
        }
    }

    private View.OnClickListener getOnClickLister(final DataItems.DataItem dataItem, final int i) {
        switch (dataItem.getType()) {
            case "skill":
                return new View.OnClickListener() { // from class: com.jibo.ui.helpers.skills.ItemFactory.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        SkillsJsonParser.getInstance().selectSkill(i);
                        ItemFactory.this.openChildrenScreen(view.getContext(), dataItem, i);
                    }
                };
            case "switch":
                return new View.OnClickListener() { // from class: com.jibo.ui.helpers.skills.ItemFactory.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Items.SwitchItem switchItem = (Items.SwitchItem) view.getTag();
                        if (!(view instanceof CompoundButton)) {
                            if (switchItem.hasChildren()) {
                                ItemFactory.this.openChildrenScreen(view.getContext(), dataItem, i);
                            } else {
                                ItemFactory.this.putBooleanDataValue(dataItem);
                            }
                        }
                    }
                };
            case "toggle":
                return new View.OnClickListener() { // from class: com.jibo.ui.helpers.skills.ItemFactory.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ItemFactory.this.putBooleanDataValue(dataItem);
                    }
                };
            case "choice":
                return new View.OnClickListener() { // from class: com.jibo.ui.helpers.skills.ItemFactory.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ItemFactory.this.mDataPublisher != null) {
                            DataItems.ChoiceDataItem.ChoiceValueDataItem choiceValueDataItem = (DataItems.ChoiceDataItem.ChoiceValueDataItem) view.getTag();
                            DataItems.IntegerDataValue integerDataValue = new DataItems.IntegerDataValue();
                            integerDataValue.setValue(choiceValueDataItem.getId());
                            ItemFactory.this.mDataPublisher.mo10406a(dataItem, integerDataValue, null);
                        }
                    }
                };
            case "locationTextField":
                return new View.OnClickListener() { // from class: com.jibo.ui.helpers.skills.ItemFactory.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ItemFactory.this.mDataPublisher.mo10406a(dataItem, (DataItems.DataValue) view.getTag(), null);
                    }
                };
            case "connectable":
                return new View.OnClickListener() { // from class: com.jibo.ui.helpers.skills.ItemFactory.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (dataItem == null || dataItem.getValueDefinition() == null || dataItem.getValueDefinition().getDataValue() == null) {
                            ItemFactory.this.openChildrenScreen(view.getContext(), dataItem, i);
                            return;
                        }
                        if (!((DataItems.ConnectableDataValue) dataItem.getValueDefinition().getDataValue()).isConnected()) {
                            ItemFactory.this.openChildrenScreen(view.getContext(), dataItem, i);
                            return;
                        }
                        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                        builder.m3231b(R.string.delete_calendar_confirmation);
                        builder.m3221a(R.string.okay, new DialogInterface.OnClickListener() { // from class: com.jibo.ui.helpers.skills.ItemFactory.7.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                ItemFactory.this.mDataDeleter.mo10406a(dataItem, null, null);
                            }
                        });
                        builder.m3232b(android.R.string.cancel, (DialogInterface.OnClickListener) null);
                        builder.m3236b().show();
                    }
                };
            case "oauth":
                return new View.OnClickListener() { // from class: com.jibo.ui.helpers.skills.ItemFactory.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (((BaseActivity) view.getContext()).m10204n() instanceof SkillSettingsFragment) {
                            Bundle bundle = new Bundle();
                            DataItems.DataItem view2 = SkillsJsonParser.getInstance().getView(((SkillSettingsFragment) ((BaseActivity) view.getContext()).m10204n()).m10415a());
                            bundle.putString(view2.getClass().getSimpleName(), ItemFactory.gson.m9362b(view2));
                            bundle.putString(DataItems.OauthDataItem.class.getSimpleName(), ItemFactory.gson.m9362b(dataItem));
                            if (dataItem.getValueDefinition().getKey().contains("google")) {
                                ((BaseActivity) view.getContext()).m10191b(OauthFragment.class, bundle);
                            } else {
                                ((BaseActivity) view.getContext()).m10193c(OauthFragment.class, bundle);
                            }
                        }
                    }
                };
            case "time":
                return new View.OnClickListener() { // from class: com.jibo.ui.helpers.skills.ItemFactory.9
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MaterialTimePickerDialogFragment materialTimePickerDialogFragment = new MaterialTimePickerDialogFragment();
                        Bundle bundle = new Bundle();
                        bundle.putString(dataItem.getClass().getSimpleName(), ItemFactory.gson.m9362b(dataItem));
                        bundle.putBoolean("ARGS_SKILL_FRAGMENT", true);
                        materialTimePickerDialogFragment.setArguments(bundle);
                        materialTimePickerDialogFragment.setTargetFragment(((BaseActivity) view.getContext()).m10204n(), 102);
                        materialTimePickerDialogFragment.show(((BaseActivity) view.getContext()).getSupportFragmentManager(), "");
                    }
                };
            default:
                return new View.OnClickListener() { // from class: com.jibo.ui.helpers.skills.ItemFactory.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Toast.makeText(view.getContext(), "ITEM CLICKED", 0).show();
                    }
                };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openChildrenScreen(Context context, DataItems.DataItem dataItem, int i) {
        if (dataItem instanceof DataItems.GroupDataItem) {
            if (!(dataItem instanceof DataItems.GroupDataItem) || (((DataItems.GroupDataItem) dataItem).getChildViews() != null && !((DataItems.GroupDataItem) dataItem).getChildViews().isEmpty())) {
                int[] iArr = new int[this.mCurrentViewsPath != null ? this.mCurrentViewsPath.length + 1 : 1];
                if (this.mCurrentViewsPath != null) {
                    for (int i2 = 0; i2 < this.mCurrentViewsPath.length; i2++) {
                        iArr[i2] = this.mCurrentViewsPath[i2];
                    }
                }
                iArr[iArr.length - 1] = i;
                if (((DataItems.GroupDataItem) dataItem).getChildViews().size() == 1 && (((DataItems.GroupDataItem) dataItem).getChildViews().get(0) instanceof DataItems.LocationDataItem)) {
                    Bundle bundle = new Bundle();
                    bundle.putString(DataItems.LocationDataItem.class.getSimpleName(), gson.m9362b(((DataItems.GroupDataItem) dataItem).getChildViews().get(0)));
                    ((BaseActivity) context).m10193c(LocationFragment.class, bundle);
                } else {
                    Bundle bundle2 = new Bundle();
                    bundle2.putIntArray("PARAM_PATH", iArr);
                    bundle2.putString("PARAM_TITLE", dataItem.getTitle());
                    ((BaseActivity) context).m10193c(SkillSettingsFragment.class, bundle2);
                }
            }
        }
    }
}
