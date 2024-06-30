package dev.kush.modulithdemo.inventory;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("inventory")
record Inventory(@Id Integer id, int itemId, int quantity) {
}
