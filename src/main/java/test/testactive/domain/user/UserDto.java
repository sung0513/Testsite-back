//package test.testactive.domain.user;
//
//import lombok.*;
//
//import java.time.LocalDateTime;
//
//
//@Getter
//@Setter
//@NoArgsConstructor
//public class UserDto {
//    private Long id;
//    private String email;
//    private String password;
//    private LocalDateTime createdDate;
//    private LocalDateTime modifiedDate;
//
//    public User toEntity(){
//        return User.builder()
//                .id(id)
//                .email(email)
//                .password(password)
//                .build();
//    }
//
//    @Builder
//    public UserDto(Long id, String email, String password) {
//        this.id = id;
//        this.email = email;
//        this.password = password;
//    }
//}