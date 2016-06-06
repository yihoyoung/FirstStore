package org.store.repository;

import org.springframework.data.repository.CrudRepository;
import org.store.domain.Product;

/**
 * Created by hoyounglee on 2016. 5. 18..
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
