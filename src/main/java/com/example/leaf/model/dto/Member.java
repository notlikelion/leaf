package com.example.leaf.model.dto;

public class Member {
    // setter 쓰려면 final X
    private String memberId;
    private String name;

    // 기본 생성자
    public Member() {
    }

    // 값을 집어넣어서 만드는 생성자
    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
