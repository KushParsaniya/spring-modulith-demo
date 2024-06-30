package dev.kush.modulithdemo.inventory;

// this is going to be public
public record InventoryUpdateEvent( int itemId, int quantity) {
}
