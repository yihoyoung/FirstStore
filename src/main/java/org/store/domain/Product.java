package org.store.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by hoyounglee on 2016. 6. 5..
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue
    private Integer productId;
    @Column
    private String name;
    @Column
    private String price;
    @Column
    private String productType;
    @Column
    private String mainImageUrl;
    @Column
    private String description;
}
