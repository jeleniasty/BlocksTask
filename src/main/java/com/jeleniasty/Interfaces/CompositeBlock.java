package com.jeleniasty.Interfaces;

import java.util.List;

public interface CompositeBlock extends Block {
    List<Block> getBlocks();

    String getColor();

    String getMaterial();
}