package ru.lg.SovietMod.Blocks.Safe;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerSafe extends Container
{
	private final int numRows;
	private final TileEntitySafe chestInventory;
	
	public ContainerSafe(InventoryPlayer playerInv, TileEntitySafe tileEntitySafe, EntityPlayer player) 
	{
		this.chestInventory = tileEntitySafe;
		this.numRows = tileEntitySafe.getSizeInventory() / 9;
		tileEntitySafe.openInventory(player);
		
		
		for(int i = 0; i < 9; ++i)
		{
			for(int j = 0; j < 6; ++j)
			{
			
				this.addSlotToContainer(new Slot(tileEntitySafe, i + j*9, 8 + i*18 + 1 , (j*18) + 8));
				
			}
		}
		
		
		
		for(int y = 0; y < 3; y++)
		{
			for(int x = 0; x < 9; x++)
			{
				this.addSlotToContainer(new Slot(playerInv, x + y*9 + 9, 9 + x*18, 123 + y*18));
			}
		}
		
		for(int x = 0; x < 9; x++)
		{
			this.addSlotToContainer(new Slot(playerInv, x, 9 + x*18, 181));
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn)
	{
		return this.chestInventory.isUsableByPlayer(playerIn);
	}
	
	@Override
	public void onContainerClosed(EntityPlayer playerIn) 
	{
		super.onContainerClosed(playerIn);
		chestInventory.closeInventory(playerIn);
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

            if (index < this.numRows * 9)
            {
                if (!this.mergeItemStack(itemstack1, this.numRows * 9, this.inventorySlots.size(), true))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 0, this.numRows * 9, false))
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
	
	public TileEntitySafe getChestInventory()
	{
		return this.chestInventory;
	}
}