package android.support.v4.internal.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.support.v4.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;

public interface SupportMenuItem extends MenuItem {
   SupportMenuItem a(ActionProvider var1);

   SupportMenuItem a(CharSequence var1);

   ActionProvider a();

   SupportMenuItem b(CharSequence var1);

   boolean collapseActionView();

   boolean expandActionView();

   View getActionView();

   int getAlphabeticModifiers();

   CharSequence getContentDescription();

   ColorStateList getIconTintList();

   Mode getIconTintMode();

   int getNumericModifiers();

   CharSequence getTooltipText();

   boolean isActionViewExpanded();

   MenuItem setActionView(int var1);

   MenuItem setActionView(View var1);

   MenuItem setAlphabeticShortcut(char var1, int var2);

   MenuItem setIconTintList(ColorStateList var1);

   MenuItem setIconTintMode(Mode var1);

   MenuItem setNumericShortcut(char var1, int var2);

   MenuItem setShortcut(char var1, char var2, int var3, int var4);

   void setShowAsAction(int var1);

   MenuItem setShowAsActionFlags(int var1);
}
