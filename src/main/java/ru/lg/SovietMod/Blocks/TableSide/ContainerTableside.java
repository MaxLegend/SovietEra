package ru.lg.SovietMod.Blocks.TableSide;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerTableside extends Container
{
   public ContainerTableside(IInventory playerInv, TileEntityTableside watcher)
   {
       int i = -18;
       int j;
       int k;

       int index = 0;

       for (j = 0; j < 2; ++j)
       {
           for (k = 0; k < 4; ++k)
           {
               addSlotToContainer(new Slot(watcher.basic, index++, 52 + k * 18, 17 + j * 18));
           }
       }

       for (j = 0; j < 3; ++j)
       {
           for (k = 0; k < 9; ++k)
           {
               this.addSlotToContainer(new Slot(playerInv, k + j * 9 + 9, 8 + k * 18, 97 + j * 18 + i));
           }
       }

       for (j = 0; j < 9; ++j)
       {
           this.addSlotToContainer(new Slot(playerInv, j, 8 + j * 18, 155 + i));
       }
   }

   @Override
   public boolean canInteractWith(EntityPlayer playerIn)
   {
       return true;
   }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
       ItemStack itemstack = ItemStack.EMPTY;
       Slot slot = this.inventorySlots.get(index);

       if (slot != null && slot.getHasStack())
       {
           ItemStack itemstack1 = slot.getStack();
           itemstack = itemstack1.copy();

           if (index < 15)
           {
               if (!this.mergeItemStack(itemstack1, 15, this.inventorySlots.size(), true))
               {
                   return ItemStack.EMPTY;
               }
           }
           else if(!this.mergeItemStack(itemstack1, 0, 15, false))
           {
               return ItemStack.EMPTY;
           }

           if (itemstack1.isEmpty())
           {
               slot.putStack(ItemStack.EMPTY);
           }
           else
           {
               slot.onSlotChanged();
           }
       }

       return itemstack;
   }
}