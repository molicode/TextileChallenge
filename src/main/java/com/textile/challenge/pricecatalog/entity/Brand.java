package com.textile.challenge.pricecatalog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Luis Molina
 */
@Entity
@Data
@Table(name = "T_BRAND")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Brand implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BRAND_ID")
    private Integer brandId;

    @Column(name = "NAME")
    private String name;
}
