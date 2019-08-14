/*******************************************************************************
 * HellFirePvP / Astral Sorcery 2019
 *
 * All rights reserved.
 * The source code is available on github: https://github.com/HellFirePvP/AstralSorcery
 * For further details, see the License file there.
 ******************************************************************************/

package hellfirepvp.astralsorcery.common.block.base;

import hellfirepvp.astralsorcery.common.tile.base.TileNetwork;
import hellfirepvp.astralsorcery.common.util.item.ItemUtils;
import hellfirepvp.astralsorcery.common.util.MiscUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

/**
 * This class is part of the Astral Sorcery Mod
 * The complete source code for this mod can be found on github.
 * Class: BlockNetwork
 * Created by HellFirePvP
 * Date: 03.08.2016 / 21:01
 */
public abstract class BlockStarlightNetwork extends BlockInventory {

    protected BlockStarlightNetwork(Block.Properties builder) {
        super(builder);
    }

    @Override
    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        TileNetwork te = MiscUtils.getTileAt(worldIn, pos, TileNetwork.class, true);
        if (te != null) {
            ((TileNetwork<?>) te).onBreak();
        }
        super.onReplaced(state, worldIn, pos, newState, isMoving);
    }

}
