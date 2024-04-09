package com.example.bookin.businessowner.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BusinessOwnerNumber {

    @Id
    @GeneratedValue
    @Column(name = "business_owner_number_id")
    private Long BusinessOwnerNumberId;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "business_owner_id")
    private BusinessOwner businessOwner;
}
