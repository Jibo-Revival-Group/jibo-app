package com.jibo.ui.helpers.skills;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.google.gson.Gson;
import com.jibo.ui.activity.BaseActivity;
import com.jibo.ui.fragment.account.skills.LocationFragment;
import com.jibo.ui.fragment.account.skills.OauthFragment;
import com.jibo.ui.fragment.account.skills.SkillSettingsFragment;
import com.jibo.ui.fragment.dialog.skills.MaterialTimePickerDialogFragment;
import java.util.ArrayList;
import java.util.List;

public class ItemFactory {
   private static Gson gson = new Gson();
   private int[] mCurrentViewsPath;
   private SkillSettingsFragment.DataPublisher mDataDeleter;
   private SkillSettingsFragment.DataPublisher mDataPublisher;

   public ItemFactory(int[] var1, SkillSettingsFragment.DataPublisher var2) {
      this.mCurrentViewsPath = var1;
      this.mDataPublisher = var2;
      this.mDataDeleter = null;
   }

   public ItemFactory(int[] var1, SkillSettingsFragment.DataPublisher var2, SkillSettingsFragment.DataPublisher var3) {
      this.mCurrentViewsPath = var1;
      this.mDataPublisher = var2;
      this.mDataDeleter = var3;
   }

   private OnCheckedChangeListener getOnCheckChangeListener(DataItems.DataItem var1, int var2) {
      OnCheckedChangeListener var4;
      switch (var1.getType()) {
         case "switch":
            var4 = new OnCheckedChangeListener(this, var1) {
               final ItemFactory this$0;
               final DataItems.DataItem val$dataItem;

               {
                  this.this$0 = var1;
                  this.val$dataItem = var2x;
               }

               public void onCheckedChanged(CompoundButton var1, boolean var2x) {
                  boolean var4x = false;
                  boolean var3;
                  if (var1.getTag() instanceof Items.SwitchItem && ((Items.SwitchItem)var1.getTag()).mDataItem == this.val$dataItem) {
                     var3 = true;
                  } else {
                     var3 = false;
                  }

                  if (this.val$dataItem.getValueDefinition() == null
                     || this.val$dataItem.getValueDefinition().getDataValue() == null
                     || ((DataItems.BooleanDataValue)this.val$dataItem.getValueDefinition().getDataValue()).getValue() != var2x) {
                     var4x = true;
                  }

                  if (var3 && var4x) {
                     this.this$0.putBooleanDataValue(this.val$dataItem, var2x);
                  }
               }
            };
            break;
         default:
            var4 = null;
      }

      return var4;
   }

   private OnClickListener getOnClickLister(DataItems.DataItem var1, int var2) {
      OnClickListener var5;
      switch (var1.getType()) {
         case "skill":
            var5 = new OnClickListener(this, var2, var1) {
               final ItemFactory this$0;
               final DataItems.DataItem val$dataItem;
               final int val$dataItemIndx;

               {
                  this.this$0 = var1;
                  this.val$dataItemIndx = var2x;
                  this.val$dataItem = var3;
               }

               public void onClick(View var1) {
                  SkillsJsonParser.getInstance().selectSkill(this.val$dataItemIndx);
                  this.this$0.openChildrenScreen(var1.getContext(), this.val$dataItem, this.val$dataItemIndx);
               }
            };
            break;
         case "switch":
            var5 = new OnClickListener(this, var1, var2) {
               final ItemFactory this$0;
               final DataItems.DataItem val$dataItem;
               final int val$dataItemIndx;

               {
                  this.this$0 = var1;
                  this.val$dataItem = var2x;
                  this.val$dataItemIndx = var3;
               }

               public void onClick(View var1) {
                  Items.SwitchItem var2 = (Items.SwitchItem)var1.getTag();
                  if (!(var1 instanceof CompoundButton)) {
                     if (var2.hasChildren()) {
                        this.this$0.openChildrenScreen(var1.getContext(), this.val$dataItem, this.val$dataItemIndx);
                     } else {
                        this.this$0.putBooleanDataValue(this.val$dataItem);
                     }
                  }
               }
            };
            break;
         case "toggle":
            var5 = new OnClickListener(this, var1) {
               final ItemFactory this$0;
               final DataItems.DataItem val$dataItem;

               {
                  this.this$0 = var1;
                  this.val$dataItem = var2x;
               }

               public void onClick(View var1) {
                  this.this$0.putBooleanDataValue(this.val$dataItem);
               }
            };
            break;
         case "choice":
            var5 = new OnClickListener(this, var1) {
               final ItemFactory this$0;
               final DataItems.DataItem val$dataItem;

               {
                  this.this$0 = var1;
                  this.val$dataItem = var2;
               }

               public void onClick(View var1) {
                  if (this.this$0.mDataPublisher != null) {
                     DataItems.ChoiceDataItem.ChoiceValueDataItem var2 = (DataItems.ChoiceDataItem.ChoiceValueDataItem)var1.getTag();
                     DataItems.IntegerDataValue var3 = new DataItems.IntegerDataValue();
                     var3.setValue(var2.getId());
                     this.this$0.mDataPublisher.a(this.val$dataItem, var3, null);
                  }
               }
            };
            break;
         case "locationTextField":
            var5 = new OnClickListener(this, var1) {
               final ItemFactory this$0;
               final DataItems.DataItem val$dataItem;

               {
                  this.this$0 = var1;
                  this.val$dataItem = var2;
               }

               public void onClick(View var1) {
                  this.this$0.mDataPublisher.a(this.val$dataItem, (DataItems.DataValue)var1.getTag(), null);
               }
            };
            break;
         case "connectable":
            var5 = new OnClickListener(this, var1, var2) {
               final ItemFactory this$0;
               final DataItems.DataItem val$dataItem;
               final int val$dataItemIndx;

               {
                  this.this$0 = var1;
                  this.val$dataItem = var2;
                  this.val$dataItemIndx = var3;
               }

               public void onClick(View var1) {
                  if (this.val$dataItem == null
                     || this.val$dataItem.getValueDefinition() == null
                     || this.val$dataItem.getValueDefinition().getDataValue() == null) {
                     this.this$0.openChildrenScreen(var1.getContext(), this.val$dataItem, this.val$dataItemIndx);
                  } else if (((DataItems.ConnectableDataValue)this.val$dataItem.getValueDefinition().getDataValue()).isConnected()) {
                     AlertDialog.Builder var2 = new AlertDialog.Builder(var1.getContext());
                     var2.b(2131755245);
                     var2.a(2131755569, new android.content.DialogInterface.OnClickListener(this) {
                        final <unrepresentable> this$1;

                        {
                           this.this$1 = var1;
                        }

                        public void onClick(DialogInterface var1, int var2x) {
                           this.this$1.this$0.mDataDeleter.a(this.this$1.val$dataItem, null, null);
                        }
                     });
                     var2.b(17039360, null);
                     var2.b().show();
                  } else {
                     this.this$0.openChildrenScreen(var1.getContext(), this.val$dataItem, this.val$dataItemIndx);
                  }
               }
            };
            break;
         case "oauth":
            var5 = new OnClickListener(this, var1) {
               final ItemFactory this$0;
               final DataItems.DataItem val$dataItem;

               {
                  this.this$0 = var1;
                  this.val$dataItem = var2;
               }

               public void onClick(View var1) {
                  if (((BaseActivity)var1.getContext()).n() instanceof SkillSettingsFragment) {
                     Bundle var2 = new Bundle();
                     DataItems.DataItem var3 = SkillsJsonParser.getInstance().getView(((SkillSettingsFragment)((BaseActivity)var1.getContext()).n()).a());
                     var2.putString(var3.getClass().getSimpleName(), ItemFactory.gson.b(var3));
                     var2.putString(DataItems.OauthDataItem.class.getSimpleName(), ItemFactory.gson.b(this.val$dataItem));
                     if (this.val$dataItem.getValueDefinition().getKey().contains("google")) {
                        ((BaseActivity)var1.getContext()).b(OauthFragment.class, var2);
                     } else {
                        ((BaseActivity)var1.getContext()).c(OauthFragment.class, var2);
                     }
                  }
               }
            };
            break;
         case "time":
            var5 = new OnClickListener(this, var1) {
               final ItemFactory this$0;
               final DataItems.DataItem val$dataItem;

               {
                  this.this$0 = var1;
                  this.val$dataItem = var2;
               }

               public void onClick(View var1) {
                  MaterialTimePickerDialogFragment var2 = new MaterialTimePickerDialogFragment();
                  Bundle var3 = new Bundle();
                  var3.putString(this.val$dataItem.getClass().getSimpleName(), ItemFactory.gson.b(this.val$dataItem));
                  var3.putBoolean("ARGS_SKILL_FRAGMENT", true);
                  var2.setArguments(var3);
                  var2.setTargetFragment(((BaseActivity)var1.getContext()).n(), 102);
                  var2.show(((BaseActivity)var1.getContext()).getSupportFragmentManager(), "");
               }
            };
            break;
         default:
            var5 = new OnClickListener(this) {
               final ItemFactory this$0;

               {
                  this.this$0 = var1;
               }

               public void onClick(View var1) {
                  Toast.makeText(var1.getContext(), "ITEM CLICKED", 0).show();
               }
            };
      }

      return var5;
   }

   private void openChildrenScreen(Context var1, DataItems.DataItem var2, int var3) {
      if (var2 instanceof DataItems.GroupDataItem
         && (
            !(var2 instanceof DataItems.GroupDataItem)
               || ((DataItems.GroupDataItem)var2).getChildViews() != null && !((DataItems.GroupDataItem)var2).getChildViews().isEmpty()
         )) {
         int var4;
         if (this.mCurrentViewsPath != null) {
            var4 = this.mCurrentViewsPath.length + 1;
         } else {
            var4 = 1;
         }

         int[] var5 = new int[var4];
         if (this.mCurrentViewsPath != null) {
            for (int var8 = 0; var8 < this.mCurrentViewsPath.length; var8++) {
               var5[var8] = this.mCurrentViewsPath[var8];
            }
         }

         var5[var5.length - 1] = var3;
         if (((DataItems.GroupDataItem)var2).getChildViews().size() == 1
            && ((DataItems.GroupDataItem)var2).getChildViews().get(0) instanceof DataItems.LocationDataItem) {
            Bundle var9 = new Bundle();
            var9.putString(DataItems.LocationDataItem.class.getSimpleName(), gson.b(((DataItems.GroupDataItem)var2).getChildViews().get(0)));
            ((BaseActivity)var1).c(LocationFragment.class, var9);
         } else {
            BaseActivity var7 = (BaseActivity)var1;
            Bundle var6 = new Bundle();
            var6.putIntArray("PARAM_PATH", var5);
            var6.putString("PARAM_TITLE", var2.getTitle());
            var7.c(SkillSettingsFragment.class, var6);
         }
      }
   }

   private void putBooleanDataValue(DataItems.DataItem var1) {
      if (this.mDataPublisher != null) {
         DataItems.BooleanDataValue var3 = new DataItems.BooleanDataValue();
         boolean var2;
         if (var1.getDataValue() != null) {
            if (!((DataItems.BooleanDataValue)var1.getDataValue()).getValue()) {
               var2 = true;
            } else {
               var2 = false;
            }
         } else {
            var2 = true;
         }

         var3.setValue(var2);
         this.mDataPublisher.a(var1, var3, null);
      }
   }

   private void putBooleanDataValue(DataItems.DataItem var1, boolean var2) {
      if (this.mDataPublisher != null) {
         DataItems.BooleanDataValue var3 = new DataItems.BooleanDataValue();
         var3.setValue(var2);
         this.mDataPublisher.a(var1, var3, null);
      }
   }

   public List<com.jibo.ui.helpers.Items.Item> getItems(List<DataItems.DataItem> var1) {
      ArrayList var3 = new ArrayList();
      if (var1 != null && !var1.isEmpty()) {
         for (DataItems.DataItem var7 : var1) {
            OnClickListener var6 = this.getOnClickLister(var7, var1.indexOf(var7));
            switch (var7.getType()) {
               case "skill":
                  var3.add(new Items.SkillItem(var6, (DataItems.SkillViewDataItem)var7));
                  break;
               case "switch":
                  var3.add(new Items.SwitchItem(var6, this.getOnCheckChangeListener(var7, var1.indexOf(var7)), (DataItems.SwitchDataItem)var7));
                  break;
               case "subheader":
                  var3.add(new com.jibo.ui.helpers.Items.SubheaderItem(var7.getTitle()));
                  break;
               case "footer":
                  var3.add(new Items.SkillFooterItem((DataItems.FooterDataItem)var7));
                  break;
               case "choice":
                  var3.add(new Items.ChoiceItem(var6, (DataItems.ChoiceDataItem)var7));
                  break;
               case "toggle":
                  var3.add(new Items.ToggleItem(var6, (DataItems.ToggleDataItem)var7));
                  break;
               case "locationTextField":
                  var3.add(new Items.LocationItem(var6, (DataItems.LocationDataItem)var7));
                  break;
               case "connectable":
                  var3.add(new Items.ConnectableItem(var6, (DataItems.ConnectableDataItem)var7));
                  break;
               case "oauth":
                  var3.add(new Items.OauthItem(var6, (DataItems.OauthDataItem)var7));
                  break;
               case "time":
                  var3.add(new Items.TimeItem(var6, (DataItems.TimeDataItem)var7));
            }
         }
      }

      return var3;
   }
}
