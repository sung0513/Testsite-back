package test.testactive.request;

import lombok.Builder;
import test.testactive.domain.Address;
import test.testactive.domain.Member;
import test.testactive.food.Food;

public class MemberSaveRequestDto {
    private int id;
    private String name;




    @Builder
    public MemberSaveRequestDto(int id, String name) {
        this.id = id;
        this.name = name;

    }

    public Member toEntity() {
        return Member.builder()
                .id(id)
                .name(name)
                .build();
    }
}
