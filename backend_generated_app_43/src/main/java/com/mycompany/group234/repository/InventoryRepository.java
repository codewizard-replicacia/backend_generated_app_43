package com.mycompany.group234.repository;


import com.mycompany.group234.model.Inventory;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class InventoryRepository extends SimpleJpaRepository<Inventory, String> {
    private final EntityManager em;
    public InventoryRepository(EntityManager em) {
        super(Inventory.class, em);
        this.em = em;
    }
    @Override
    public List<Inventory> findAll() {
        return em.createNativeQuery("Select * from \"generated_app\".\"Inventory\"", Inventory.class).getResultList();
    }
}