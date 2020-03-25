package com.example.demo.domain;



import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.EnumType;

@RequiredArgsConstructor
@Getter
public enum  DeliveryStatus {

    READY, SHIPPING ,ARRIVE,CANCEL, SUCCESS

}

