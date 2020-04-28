package ru.lg.SovietMod.Blocks.SovietBox;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySovietBox extends TileEntity
{
   public InventoryBasic basic;

   public TileEntitySovietBox()
   {
       basic = new InventoryBasic("SovietBoxTile", false, 16);
   }

   @Override
   public NBTTagCompound writeToNBT(NBTTagCompound compound)
   {
       super.writeToNBT(compound);
       NBTTagList list = new NBTTagList();

       for(int i = 0; i < this.basic.getSizeInventory(); ++i)
       {
           if(this.basic.getStackInSlot(i) != null)
           {
               NBTTagCompound tag = new NBTTagCompound();
               tag.setByte("Slot", (byte) i);
               this.basic.getStackInSlot(i).writeToNBT(tag);
               list.appendTag(tag);
           }
       }

       compound.setTag("Items", list);
       return compound;
   }

   public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
   {
       return new ContainerSovietBox(playerInventory, this);
   }
   @Override
   public void readFromNBT(NBTTagCompound compound)
   {
       super.readFromNBT(compound);
       NBTTagList list = compound.getTagList("Items", 10);

       for(int i = 0; i < list.tagCount(); ++i)
       {
           NBTTagCompound tag = list.getCompoundTagAt(i);
           int j = tag.getByte("Slot") & 255;

           if(j >= 0 && j < this.basic.getSizeInventory())
           {
               this.basic.setInventorySlotContents(j, new ItemStack(tag));
           }
       }
   }
}