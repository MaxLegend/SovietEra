package ru.lg.SovietMod.Blocks.LabTable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import ru.lg.SovietMod.Blocks.LabTable.TileEntityLabTable;
import ru.lg.SovietMod.Blocks.Safe.TileEntitySafe;

public class ContainerLabTable extends Container
{
	private final int numRows;
	private final TileEntityLabTable  chestInventory;
	
	
	public ContainerLabTable(InventoryPlayer playerInv, TileEntityLabTable te, EntityPlayer player) 
	{
		this.chestInventory = te;
		this.numRows = te.getSizeInventory() / 16;
		te.openInventory(player);
		int indexSlot = 0;
		for(int i = 0; i < 4; ++i)
		{
			for(int j = 0; j < 2; ++j)
			{
			
				this.addSlotToContainer(new Slot(te, indexSlot++, 14 + i*18 + 1 , (j*18) + 18));
				
			}
		}
		for(int i = 0; i < 4; ++i)
		{
			for(int j = 0; j < 2; ++j)
			{
			
				this.addSlotToContainer(new Slot(te, indexSlot++ , 93+ i*18 + 1 , (j*18) + 18));
				
			}
		}
        addPlayerSlots(playerInv);
    }

    private void addPlayerSlots(IInventory playerInventory) {
        // Slots for the main inventory
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                int x = 9 + col * 18;
                int y = row * 18 + 84;
                this.addSlotToContainer(new Slot(playerInventory, col + row * 9 + 10, x, y));
            }
        }

        // Slots for the hotbar
        for (int row = 0; row < 9; ++row) {
            int x = 9 + row * 18;
            int y = 142;
            this.addSlotToContainer(new Slot(playerInventory, row, x, y)); 
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
	
	public TileEntityLabTable getChestInventory()
	{
		return this.chestInventory;
	}
}