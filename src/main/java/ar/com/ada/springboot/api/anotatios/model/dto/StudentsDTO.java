package ar.com.ada.springboot.api.anotatios.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor

public class StudentsDTO {
    private Long id;
    @NotBlank (message = "name is requeried")
    private String name;
    @NotBlank(message = "last_name is requeried")
    @JsonProperty("last_name")
    private String lastName;

    private Integer dni;
    @Min(value =17,message = "Age must be over 17")
    @NotBlank(message = "age is requeried")
    private Integer age;
    @NotBlank(message = "career is requeried")
    private String career;

    public StudentsDTO(Long id, String name, String lastName, Integer dni, Integer age, String career) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.age = age;
        this.career = career;
    }

    public StudentsDTO(String name, String lastName, Integer dni, Integer age, String career) {
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.age = age;
        this.career = career;
    }


    @Override
    public String toString() {
        return "StudentsDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dni=" + dni +
                ", age=" + age +
                ", career='" + career + '\'' +
                '}';
    }
}
