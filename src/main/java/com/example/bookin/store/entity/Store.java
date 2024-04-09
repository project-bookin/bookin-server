package com.example.bookin.store.entity;

import com.example.bookin.businessowner.entity.BusinessOwner;
import com.example.bookin.menu.entity.Menu;
import com.example.bookin.values.Address;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "store_name")
    private String storeName;

    @Embedded
    private Address address;

    @Column(name = "photo_uri")
    private String photoUri;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_owner_id")
    private BusinessOwner businessOwner;

    @OneToOne(mappedBy = "store", cascade = CascadeType.ALL)
    private CancelPolicy cancelPolicy;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Menu> menus = new ArrayList<>();

    @Builder
    public Store( String storeName, Address address, String photoUri, BusinessOwner businessOwner, CancelPolicy cancelPolicy, List<Menu> menus) {
        this.storeName = storeName;
        this.address = address;
        this.photoUri = photoUri;
        this.businessOwner = businessOwner;
        this.cancelPolicy = cancelPolicy;
        this.menus = menus;
    }
}
