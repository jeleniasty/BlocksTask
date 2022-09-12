package com.jeleniasty;

import com.jeleniasty.Interfaces.Block;
import com.jeleniasty.Interfaces.CompositeBlock;
import com.jeleniasty.Interfaces.Structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Wall implements Structure {

    private List<CompositeBlock> blocks;

    public void addCompositeBlock(CompositeBlock compositeBlock) {
        this.blocks.add(compositeBlock);
    }

    public List<Block> getBlocks() {
       return this.blocks
                .stream()
                .flatMap((CompositeBlock compositeBlock) -> compositeBlock.getBlocks().stream())
                .collect(Collectors.toList());
    }

    public Wall() {
        this.blocks = new ArrayList<>();
    }

    public Wall(List<CompositeBlock> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        if (color == null) {
            throw new IllegalArgumentException("Block color is not specified!");
        } else

            return this.getBlocks()
                .stream()
                .filter(e -> e.getColor().equals(color))
                .findAny();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        if (material == null) {
            throw new IllegalArgumentException("Block material is not specified!");
        } else {
           return this.getBlocks()
                   .stream()
                   .filter(e -> e.getMaterial().equals(material))
                   .collect(Collectors.toList());
        }
    }

    @Override
    public int count() {
        return getBlocks().size();
    }
}
