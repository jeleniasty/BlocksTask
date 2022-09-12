package com.jeleniasty;

import com.jeleniasty.Interfaces.Block;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class main {
    public static void main(String[] args) {
        Block block1 = new BlockImpl("SILVER", "METAL");
        Block block2 = new BlockImpl("RED", "PLASTIC");
        Block block3 = new BlockImpl("SILVER", "METAL");
        Block block4 = new BlockImpl("GREEN", "BIOMASS");
        Block block5 = new BlockImpl("RED", "PLASTIC");

        CompositeBlockImpl compositeBlock1 = new CompositeBlockImpl();
        CompositeBlockImpl compositeBlock2 = new CompositeBlockImpl();

        Wall wall = new Wall();

        compositeBlock1.addBlock(block1);
        compositeBlock1.addBlock(block3);

        compositeBlock2.addBlock(block2);
        compositeBlock2.addBlock(block5);

        wall.addCompositeBlock(compositeBlock1);
        wall.addCompositeBlock(compositeBlock2);

        for (Block block : wall.getBlocks()) {
            System.out.println("Color: " + block.getColor() + " ,Material: " + block.getMaterial());
        }

        System.out.println(wall.findBlockByColor("SILVER"));

        for (Block block : wall.findBlocksByMaterial("METAL")) {
            System.out.println("Color: " + block.getColor() + " ,Material: " + block.getMaterial());
        }

        System.out.println(wall.count());
        System.out.println(wall.findBlocksByMaterial("PLASTIC").size());


    }
}
