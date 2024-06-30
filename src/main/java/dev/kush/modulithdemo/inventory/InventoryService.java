package dev.kush.modulithdemo.inventory;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
class InventoryService {

    private final JdbcTemplate jdbcTemplate;

    InventoryService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @ApplicationModuleListener
    public void updateInventory(InventoryUpdateEvent event) throws InterruptedException {
        Thread.sleep(10_000);
        System.out.println("Updating inventory for item: " + event.itemId() + " by quantity: " + event.quantity());

        String sql = "update inventory set quantity = quantity - ? where item_id = ?";
        jdbcTemplate.update(sql, event.quantity(), event.itemId());
    }
}
