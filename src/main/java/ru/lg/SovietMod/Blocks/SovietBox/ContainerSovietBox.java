package ru.lg.SovietMod.Blocks.SovietBox;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerSovietBox extends Container
{
	private  int numRows;
	private TileEntitySovietBox inv;

	public ContainerSovietBox(InventoryPlayer playerInv, TileEntitySovietBox tileEntitySovietBox, EntityPlayer player) 
	{
		this.inv = tileEntitySovietBox;
		this.numRows = tileEntitySovietBox.getSizeInventory() / 9;
		tileEntitySovietBox.openInventory(player);


		int indexSlot = 0;
		for(int i = 0; i < 4; ++i)
		{
			for(int j = 0; j < 4; ++j)
			{

				this.addSlotToContainer(new Slot(tileEntitySovietBox, indexSlot++, 53 + i*18 + 1 , (j*18) + 6));

			}
		}

		for(int y = 0; y < 3; y++)
		{
			for(int x = 0; x < 9; x++)
			{
				this.addSlotToContainer(new Slot(playerInv, x + y*9 + 9, 9 + x*18, 84 + y*18));
			}
		}
		
		for(int x = 0; x < 9; x++)
		{
			this.addSlotToContainer(new Slot(playerInv, x, 9 + x*18, 142));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn)
	{
		return this.inv.isUsableByPlayer(playerIn);
	}

	@Override
	public void onContainerClosed(EntityPlayer playerIn) 
	{
		super.onContainerClosed(playerIn);
		inv.closeInventory(playerIn);
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
	
	public TileEntitySovietBox getChestInventory()
	{
		return this.inv;
	}
	private void addOwnSlots(TileEntitySovietBox tileEntitySovietBox, EntityPlayer player) {
		this.inv = tileEntitySovietBox;
		this.numRows = tileEntitySovietBox.getSizeInventory() / 9;
		tileEntitySovietBox.openInventory(player);


		for(int i = 0; i < 4; ++i)
		{
			for(int j = 0; j < 4; ++j)
			{

				this.addSlotToContainer(new Slot(tileEntitySovietBox, i + j*16, 8 + i*18 + 1 , (j*18) + 8));

			}
		}
	}







}