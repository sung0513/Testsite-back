package test.testactive.response;

import lombok.Getter;
import test.testactive.domain.user.User;

@Getter
public class MyDataListResponseDto {
    private Long id;
    private String name;
    private String password;
    private String email;
    private String address;
    private String picture;

    public MyDataListResponseDto(User entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.password = entity.getEmail();
        this.email = entity.getEmail();
        this.picture = entity.getPicture();
    }
}
