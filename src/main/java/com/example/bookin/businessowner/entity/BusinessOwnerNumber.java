package com.example.bookin.businessowner.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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


}
