package com.unitbv.spring_boot_tutorial.Aexposition;

import com.unitbv.spring_boot_tutorial.Bapplication.member.ConsultAllMembersIds;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/members")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MemberController {

    ConsultAllMembersIds consultAllMembersIds;

    @GetMapping
    public ResponseEntity<List<String>> consultAll() {
        return new ResponseEntity<>(consultAllMembersIds.consult(), HttpStatus.OK);
    }

}
