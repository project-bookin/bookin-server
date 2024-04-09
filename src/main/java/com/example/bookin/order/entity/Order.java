package com.example.bookin.order.entity;

import com.example.bookin.booking.entity.Booking;
import com.example.bookin.menu.entity.Menu;
import com.example.bookin.payment.entity.Payment;
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
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Menu> menus = new ArrayList<>();

    @Enumerated(value = EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    @Builder
    public Order(Integer quantity, Booking booking, List<Menu> menus, OrderStatus orderStatus, Payment payment) {
        this.quantity = quantity;
        this.booking = booking;
        this.menus = menus;
        this.orderStatus = orderStatus;
        this.payment = payment;
    }
}
