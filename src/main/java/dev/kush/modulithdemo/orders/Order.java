package dev.kush.modulithdemo.orders;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("orders")
record Order(@Id Integer id, int itemId, int quantity, LocalDateTime orderDate) {
}
