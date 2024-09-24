package gr.aueb.cf.jaxrscf6.model;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TeacherReadOnlyDTO {
    private Long id;
    private String firstname;
    private String lastname;
}
