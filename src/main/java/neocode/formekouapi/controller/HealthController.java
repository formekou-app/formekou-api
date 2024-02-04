package neocode.formekouapi.controller;

import lombok.RequiredArgsConstructor;
import neocode.formekouapi.model.Dummy;
import neocode.formekouapi.repository.DummyRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HealthController {
    private final DummyRepository dummyRepository;

    @GetMapping("dummy-table")
    public List<Dummy> getDummies(){
        return dummyRepository.findAll();
    }

    @GetMapping("/ping")
    public String ping(){
        return "pong";
    }
}
