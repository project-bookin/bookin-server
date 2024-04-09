package com.example.bookin.menu.entity;

import com.example.bookin.store.entity.Store;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private Long menuId;

    @Column(name = "menu_name")
    private String menuName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Column(name = "photo_uri")
    private String photoUri;

    @Column(name = "price")
    private Integer price;

    public Menu(String menuName, Store store, String photoUri, Integer price) {
        this.menuName = menuName;
        this.store = store;
        this.photoUri = photoUri;
        this.price = price;
    }
}
