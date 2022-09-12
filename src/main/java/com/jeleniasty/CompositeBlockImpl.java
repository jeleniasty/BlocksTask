package com.jeleniasty;

import com.jeleniasty.Interfaces.Block;
import com.jeleniasty.Interfaces.CompositeBlock;

import java.util.ArrayList;
import java.util.List;

public class CompositeBlockImpl implements CompositeBlock {

    private List<Block> blocks = new ArrayList<>();

    private String color;

    private String material;

    public void addBlock(Block block) {
        if (!this.blocks.isEmpty()) {
            if (!this.color.equals(block.getColor())) {
                throw new IllegalArgumentException("Block colors in composite block must be the same");
            } else if (!this.material.equals(block.getMaterial())) {
                throw new IllegalArgumentException("Block materials in composite block must be the same");
            } else {
                this.blocks.add(block);
            }
        } else {
            this.setColor(block.getColor());
            this.setMaterial(block.getMaterial());
            this.blocks.add(block);
        }
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public String getMaterial() {
        return this.material;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public List<Block> getBlocks() {
        return this.blocks;
    }
}
