package ru.lg.SovietMod.Util;

import net.minecraft.util.IStringSerializable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;

public enum EnumColor implements IStringSerializable
{
BLACK(0, "black", 0, TextFormatting.BLACK), 
RED(1, "red", 16711680, TextFormatting.DARK_RED), 
GREEN(2, "green", 65280, TextFormatting.DARK_GREEN), 
BROWN(3, "brown", 8336128, TextFormatting.GOLD), 
BLUE(4, "blue", 255, TextFormatting.DARK_BLUE), 
PURPLE(5, "purple", 4718847, TextFormatting.DARK_PURPLE), 
CYAN(6, "cyan", 65535, TextFormatting.DARK_AQUA), 
LIGHT_GRAY(7, "light_gray", 8421504, TextFormatting.GRAY), 
GRAY(8, "gray", 4210752, TextFormatting.DARK_GRAY), 
PINK(9, "pink", 16711900, TextFormatting.LIGHT_PURPLE), 
LIME(10, "lime", 11992832, TextFormatting.GREEN), 
YELLOW(11, "yellow", 16766976, TextFormatting.YELLOW), 
LIGHT_BLUE(12, "light_blue", 38143, TextFormatting.BLUE), 
MAGENTA(13, "magenta", 11665663, TextFormatting.RED), 
ORANGE(14, "orange", 16738816, TextFormatting.GOLD), 
WHITE(15, "white", 16777215, TextFormatting.WHITE);

private final int meta;
private final String name;
private final int hex;
private final TextFormatting fontColor;

private EnumColor(int meta, String name, int hex, TextFormatting fontColor) { this.meta = meta;
  this.name = name;
  this.hex = hex;
  this.fontColor = fontColor;
}

public int getMetadata()
{
  return this.meta;
}

public String func_176610_l()
{
  return this.name;
}

public ITextComponent getNameTranslation()
{
  return new TextComponentTranslation("color." + func_176610_l() + ".name", new Object[0]);
}

public int getHex()
{
  return this.hex;
}

public TextFormatting getFontColor()
{
  return this.fontColor;
}

public static EnumColor getColorFromMeta(int meta)
{
  for (EnumColor color : values())
  {
    if (color.getMetadata() == meta)
    {
      return color;
    }
  }
  return null;
}

@Override
public String getName() {
	return name;
}
}