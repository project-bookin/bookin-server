package com.example.bookin.booking.entity;

import com.example.bookin.order.entity.Order;
import com.example.bookin.store.entity.Store;
import com.example.bookin.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long bookingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Column(name = "booking_time")
    private LocalDateTime bookingTime;

    @Column(name = "people_number")
    private Integer peopleNumber;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "booking_status")
    private BookingStatus bookingStatus;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<Order> orders =new ArrayList<>();

    public Booking(User user, Store store, LocalDateTime bookingTime, Integer peopleNumber, BookingStatus bookingStatus, List<Order> orders) {
        this.user = user;
        this.store = store;
        this.bookingTime = bookingTime;
        this.peopleNumber = peopleNumber;
        this.bookingStatus = bookingStatus;
        this.orders = orders;
    }
}
