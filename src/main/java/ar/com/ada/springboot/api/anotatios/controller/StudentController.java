package ar.com.ada.springboot.api.anotatios.controller;


import ar.com.ada.springboot.api.anotatios.model.dto.StudentsDTO;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @GetMapping({"", "/"})
    private ResponseEntity getAllStudents(){
        List<StudentsDTO> students = new ArrayList<>();
        students.add(new StudentsDTO((long) 1,"Ana", "Lopez", 31389256, "abogacia"));
        students.add(new StudentsDTO((long) 2,"Juan", "Rodriguez", 35680959, "medicina"));
        students.add(new StudentsDTO((long) 3,"Eugenia", "Gimenez", 38690321, "sociologia"));

        return ResponseEntity.ok().body(students);
    }

@PostMapping({"", "/"})
    private ResponseEntity addNewStudent(@Valid @RequestBody StudentsDTO student) throws URISyntaxException {
        int id = (int) (Math.random() * (15000 - 1) + 1);
        student.setId(Integer.toUnsignedLong(id));
        return ResponseEntity.created(new URI(""+ student.getId())
        ).body(student);


    }
@GetMapping("{id}")
    private ResponseEntity getStudentById (@PathVariable Long id){
       StudentsDTO student = new StudentsDTO(id,"Mariana", "Gutierrez", 38787312, 20, "analista sistemas");
    return ResponseEntity.ok().body(student);
    }

    @PutMapping("/{id}")
    private ResponseEntity updateStudent(@Valid @RequestBody StudentsDTO student, @PathVariable Long id){
        student.setId(id);
        return ResponseEntity.ok().body(student);

    }
@DeleteMapping("/{id}")
    private ResponseEntity deleteStudent(@PathVariable Long id){
        return ResponseEntity.noContent().build();
    }
}
