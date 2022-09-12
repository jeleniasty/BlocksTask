package com.jeleniasty;

import com.jeleniasty.Interfaces.Block;
import com.jeleniasty.Interfaces.CompositeBlock;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class WallTest {

    @Test
    void findBlockByColorTest1() {
        Block block1 = new BlockImpl("SILVER", "METAL");
        Block block2 = new BlockImpl("RED", "PLASTIC");
        Block block3 = new BlockImpl("SILVER", "METAL");
        Block block5 = new BlockImpl("RED", "PLASTIC");
        Block block6 = new BlockImpl(null,null);

        CompositeBlockImpl compositeBlock1 = new CompositeBlockImpl();
        CompositeBlockImpl compositeBlock2 = new CompositeBlockImpl();

        Wall wall = new Wall();
        Wall wallTest = new Wall();

        compositeBlock1.addBlock(block1);
        compositeBlock1.addBlock(block3);

        compositeBlock2.addBlock(block2);
        compositeBlock2.addBlock(block5);

        wall.addCompositeBlock(compositeBlock1);
        wall.addCompositeBlock(compositeBlock2);

        wallTest.addCompositeBlock(compositeBlock1);

        assertEquals(Optional.of(block2), wall.findBlockByColor("RED"));

        assertThrows(IllegalArgumentException.class ,() -> wall.findBlockByColor(block6.getColor()));
        assertThrows(IllegalArgumentException.class ,() -> wall.findBlockByColor(block6.getMaterial()));

        assertEquals(compositeBlock1.getBlocks(), wall.findBlocksByMaterial("METAL"));
        assertEquals(wall.count(), 4);
    }

}