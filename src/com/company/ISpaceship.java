package com.company;

public interface ISpaceship {
    boolean launch();
    boolean land();
    boolean canCarry(Item item);
    boolean carry(Item item);
}
