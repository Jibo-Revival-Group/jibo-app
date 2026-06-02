package android.support.v7.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

class ResourcesWrapper extends Resources {
   private final Resources a;

   public ResourcesWrapper(Resources var1) {
      super(var1.getAssets(), var1.getDisplayMetrics(), var1.getConfiguration());
      this.a = var1;
   }

   public XmlResourceParser getAnimation(int var1) throws NotFoundException {
      return this.a.getAnimation(var1);
   }

   public boolean getBoolean(int var1) throws NotFoundException {
      return this.a.getBoolean(var1);
   }

   public int getColor(int var1) throws NotFoundException {
      return this.a.getColor(var1);
   }

   public ColorStateList getColorStateList(int var1) throws NotFoundException {
      return this.a.getColorStateList(var1);
   }

   public Configuration getConfiguration() {
      return this.a.getConfiguration();
   }

   public float getDimension(int var1) throws NotFoundException {
      return this.a.getDimension(var1);
   }

   public int getDimensionPixelOffset(int var1) throws NotFoundException {
      return this.a.getDimensionPixelOffset(var1);
   }

   public int getDimensionPixelSize(int var1) throws NotFoundException {
      return this.a.getDimensionPixelSize(var1);
   }

   public DisplayMetrics getDisplayMetrics() {
      return this.a.getDisplayMetrics();
   }

   public Drawable getDrawable(int var1) throws NotFoundException {
      return this.a.getDrawable(var1);
   }

   public Drawable getDrawable(int var1, Theme var2) throws NotFoundException {
      return this.a.getDrawable(var1, var2);
   }

   public Drawable getDrawableForDensity(int var1, int var2) throws NotFoundException {
      return this.a.getDrawableForDensity(var1, var2);
   }

   public Drawable getDrawableForDensity(int var1, int var2, Theme var3) {
      return this.a.getDrawableForDensity(var1, var2, var3);
   }

   public float getFraction(int var1, int var2, int var3) {
      return this.a.getFraction(var1, var2, var3);
   }

   public int getIdentifier(String var1, String var2, String var3) {
      return this.a.getIdentifier(var1, var2, var3);
   }

   public int[] getIntArray(int var1) throws NotFoundException {
      return this.a.getIntArray(var1);
   }

   public int getInteger(int var1) throws NotFoundException {
      return this.a.getInteger(var1);
   }

   public XmlResourceParser getLayout(int var1) throws NotFoundException {
      return this.a.getLayout(var1);
   }

   public Movie getMovie(int var1) throws NotFoundException {
      return this.a.getMovie(var1);
   }

   public String getQuantityString(int var1, int var2) throws NotFoundException {
      return this.a.getQuantityString(var1, var2);
   }

   public String getQuantityString(int var1, int var2, Object... var3) throws NotFoundException {
      return this.a.getQuantityString(var1, var2, var3);
   }

   public CharSequence getQuantityText(int var1, int var2) throws NotFoundException {
      return this.a.getQuantityText(var1, var2);
   }

   public String getResourceEntryName(int var1) throws NotFoundException {
      return this.a.getResourceEntryName(var1);
   }

   public String getResourceName(int var1) throws NotFoundException {
      return this.a.getResourceName(var1);
   }

   public String getResourcePackageName(int var1) throws NotFoundException {
      return this.a.getResourcePackageName(var1);
   }

   public String getResourceTypeName(int var1) throws NotFoundException {
      return this.a.getResourceTypeName(var1);
   }

   public String getString(int var1) throws NotFoundException {
      return this.a.getString(var1);
   }

   public String getString(int var1, Object... var2) throws NotFoundException {
      return this.a.getString(var1, var2);
   }

   public String[] getStringArray(int var1) throws NotFoundException {
      return this.a.getStringArray(var1);
   }

   public CharSequence getText(int var1) throws NotFoundException {
      return this.a.getText(var1);
   }

   public CharSequence getText(int var1, CharSequence var2) {
      return this.a.getText(var1, var2);
   }

   public CharSequence[] getTextArray(int var1) throws NotFoundException {
      return this.a.getTextArray(var1);
   }

   public void getValue(int var1, TypedValue var2, boolean var3) throws NotFoundException {
      this.a.getValue(var1, var2, var3);
   }

   public void getValue(String var1, TypedValue var2, boolean var3) throws NotFoundException {
      this.a.getValue(var1, var2, var3);
   }

   public void getValueForDensity(int var1, int var2, TypedValue var3, boolean var4) throws NotFoundException {
      this.a.getValueForDensity(var1, var2, var3, var4);
   }

   public XmlResourceParser getXml(int var1) throws NotFoundException {
      return this.a.getXml(var1);
   }

   public TypedArray obtainAttributes(AttributeSet var1, int[] var2) {
      return this.a.obtainAttributes(var1, var2);
   }

   public TypedArray obtainTypedArray(int var1) throws NotFoundException {
      return this.a.obtainTypedArray(var1);
   }

   public InputStream openRawResource(int var1) throws NotFoundException {
      return this.a.openRawResource(var1);
   }

   public InputStream openRawResource(int var1, TypedValue var2) throws NotFoundException {
      return this.a.openRawResource(var1, var2);
   }

   public AssetFileDescriptor openRawResourceFd(int var1) throws NotFoundException {
      return this.a.openRawResourceFd(var1);
   }

   public void parseBundleExtra(String var1, AttributeSet var2, Bundle var3) throws XmlPullParserException {
      this.a.parseBundleExtra(var1, var2, var3);
   }

   public void parseBundleExtras(XmlResourceParser var1, Bundle var2) throws XmlPullParserException, IOException {
      this.a.parseBundleExtras(var1, var2);
   }

   public void updateConfiguration(Configuration var1, DisplayMetrics var2) {
      super.updateConfiguration(var1, var2);
      if (this.a != null) {
         this.a.updateConfiguration(var1, var2);
      }
   }
}
