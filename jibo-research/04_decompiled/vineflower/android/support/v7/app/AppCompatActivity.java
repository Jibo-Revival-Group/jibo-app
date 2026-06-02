package android.support.v7.app;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.VectorEnabledTintResources;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.ViewGroup.LayoutParams;

public class AppCompatActivity extends FragmentActivity implements TaskStackBuilder.SupportParentable, AppCompatCallback {
   private AppCompatDelegate mDelegate;
   private Resources mResources;
   private int mThemeId = 0;

   private boolean performMenuItemShortcut(int var1, KeyEvent var2) {
      if (VERSION.SDK_INT < 26
         && !var2.isCtrlPressed()
         && !KeyEvent.metaStateHasNoModifiers(var2.getMetaState())
         && var2.getRepeatCount() == 0
         && !KeyEvent.isModifierKey(var2.getKeyCode())) {
         Window var4 = this.getWindow();
         if (var4 != null && var4.getDecorView() != null && var4.getDecorView().dispatchKeyShortcutEvent(var2)) {
            return true;
         }
      }

      return false;
   }

   public void addContentView(View var1, LayoutParams var2) {
      this.getDelegate().b(var1, var2);
   }

   public void closeOptionsMenu() {
      ActionBar var1 = this.getSupportActionBar();
      if (this.getWindow().hasFeature(0) && (var1 == null || !var1.closeOptionsMenu())) {
         super.closeOptionsMenu();
      }
   }

   public boolean dispatchKeyEvent(KeyEvent var1) {
      int var2 = var1.getKeyCode();
      ActionBar var4 = this.getSupportActionBar();
      boolean var3;
      if (var2 == 82 && var4 != null && var4.onMenuKeyEvent(var1)) {
         var3 = true;
      } else {
         var3 = super.dispatchKeyEvent(var1);
      }

      return var3;
   }

   public <T extends View> T findViewById(int var1) {
      return this.getDelegate().a(var1);
   }

   public AppCompatDelegate getDelegate() {
      if (this.mDelegate == null) {
         this.mDelegate = AppCompatDelegate.a(this, this);
      }

      return this.mDelegate;
   }

   public ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
      return this.getDelegate().h();
   }

   public MenuInflater getMenuInflater() {
      return this.getDelegate().b();
   }

   public Resources getResources() {
      if (this.mResources == null && VectorEnabledTintResources.a()) {
         this.mResources = new VectorEnabledTintResources(this, super.getResources());
      }

      Resources var1;
      if (this.mResources == null) {
         var1 = super.getResources();
      } else {
         var1 = this.mResources;
      }

      return var1;
   }

   public ActionBar getSupportActionBar() {
      return this.getDelegate().a();
   }

   @Override
   public Intent getSupportParentActivityIntent() {
      return NavUtils.a(this);
   }

   public void invalidateOptionsMenu() {
      this.getDelegate().f();
   }

   @Override
   public void onConfigurationChanged(Configuration var1) {
      super.onConfigurationChanged(var1);
      this.getDelegate().a(var1);
      if (this.mResources != null) {
         DisplayMetrics var2 = super.getResources().getDisplayMetrics();
         this.mResources.updateConfiguration(var1, var2);
      }
   }

   public void onContentChanged() {
      this.onSupportContentChanged();
   }

   @Override
   protected void onCreate(Bundle var1) {
      AppCompatDelegate var2 = this.getDelegate();
      var2.i();
      var2.a(var1);
      if (var2.j() && this.mThemeId != 0) {
         if (VERSION.SDK_INT >= 23) {
            this.onApplyThemeResource(this.getTheme(), this.mThemeId, false);
         } else {
            this.setTheme(this.mThemeId);
         }
      }

      super.onCreate(var1);
   }

   public void onCreateSupportNavigateUpTaskStack(TaskStackBuilder var1) {
      var1.a(this);
   }

   @Override
   protected void onDestroy() {
      super.onDestroy();
      this.getDelegate().g();
   }

   public boolean onKeyDown(int var1, KeyEvent var2) {
      boolean var3;
      if (this.performMenuItemShortcut(var1, var2)) {
         var3 = true;
      } else {
         var3 = super.onKeyDown(var1, var2);
      }

      return var3;
   }

   @Override
   public final boolean onMenuItemSelected(int var1, MenuItem var2) {
      boolean var3;
      if (super.onMenuItemSelected(var1, var2)) {
         var3 = true;
      } else {
         ActionBar var4 = this.getSupportActionBar();
         if (var2.getItemId() == 16908332 && var4 != null && (var4.getDisplayOptions() & 4) != 0) {
            var3 = this.onSupportNavigateUp();
         } else {
            var3 = false;
         }
      }

      return var3;
   }

   public boolean onMenuOpened(int var1, Menu var2) {
      return super.onMenuOpened(var1, var2);
   }

   @Override
   public void onPanelClosed(int var1, Menu var2) {
      super.onPanelClosed(var1, var2);
   }

   protected void onPostCreate(Bundle var1) {
      super.onPostCreate(var1);
      this.getDelegate().b(var1);
   }

   @Override
   protected void onPostResume() {
      super.onPostResume();
      this.getDelegate().e();
   }

   public void onPrepareSupportNavigateUpTaskStack(TaskStackBuilder var1) {
   }

   @Override
   protected void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      this.getDelegate().c(var1);
   }

   @Override
   protected void onStart() {
      super.onStart();
      this.getDelegate().c();
   }

   @Override
   protected void onStop() {
      super.onStop();
      this.getDelegate().d();
   }

   @Override
   public void onSupportActionModeFinished(ActionMode var1) {
   }

   @Override
   public void onSupportActionModeStarted(ActionMode var1) {
   }

   @Deprecated
   public void onSupportContentChanged() {
   }

   public boolean onSupportNavigateUp() {
      Intent var2 = this.getSupportParentActivityIntent();
      boolean var1;
      if (var2 != null) {
         if (this.supportShouldUpRecreateTask(var2)) {
            TaskStackBuilder var4 = TaskStackBuilder.a(this);
            this.onCreateSupportNavigateUpTaskStack(var4);
            this.onPrepareSupportNavigateUpTaskStack(var4);
            var4.a();

            try {
               ActivityCompat.a(this);
            } catch (IllegalStateException var3) {
               this.finish();
            }
         } else {
            this.supportNavigateUpTo(var2);
         }

         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   protected void onTitleChanged(CharSequence var1, int var2) {
      super.onTitleChanged(var1, var2);
      this.getDelegate().a(var1);
   }

   @Override
   public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback var1) {
      return null;
   }

   public void openOptionsMenu() {
      ActionBar var1 = this.getSupportActionBar();
      if (this.getWindow().hasFeature(0) && (var1 == null || !var1.openOptionsMenu())) {
         super.openOptionsMenu();
      }
   }

   public void setContentView(int var1) {
      this.getDelegate().b(var1);
   }

   public void setContentView(View var1) {
      this.getDelegate().a(var1);
   }

   public void setContentView(View var1, LayoutParams var2) {
      this.getDelegate().a(var1, var2);
   }

   public void setSupportActionBar(Toolbar var1) {
      this.getDelegate().a(var1);
   }

   @Deprecated
   public void setSupportProgress(int var1) {
   }

   @Deprecated
   public void setSupportProgressBarIndeterminate(boolean var1) {
   }

   @Deprecated
   public void setSupportProgressBarIndeterminateVisibility(boolean var1) {
   }

   @Deprecated
   public void setSupportProgressBarVisibility(boolean var1) {
   }

   public void setTheme(int var1) {
      super.setTheme(var1);
      this.mThemeId = var1;
   }

   public ActionMode startSupportActionMode(ActionMode.Callback var1) {
      return this.getDelegate().a(var1);
   }

   @Override
   public void supportInvalidateOptionsMenu() {
      this.getDelegate().f();
   }

   public void supportNavigateUpTo(Intent var1) {
      NavUtils.b(this, var1);
   }

   public boolean supportRequestWindowFeature(int var1) {
      return this.getDelegate().c(var1);
   }

   public boolean supportShouldUpRecreateTask(Intent var1) {
      return NavUtils.a(this, var1);
   }
}
