package com.example.api.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Data
@RequiredArgsConstructor

public class studentinfo {
    @Id
    private String fullName;
    private String phoneNum;
    private String emailAdd;
    private String birthDay;
    private String homeAddress;




}