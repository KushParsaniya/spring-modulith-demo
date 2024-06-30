package dev.kush.modulithdemo.items;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("items")
record Item(@Id int id, String name, double price) {
}
