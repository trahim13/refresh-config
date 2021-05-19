package by.teza.appone.web;

import by.teza.appone.domain.One;
import by.teza.appone.repository.OneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OneController {

    @Autowired
    ApplicationContext context;

    @Value("${default-value-for-all}")
    private String defaultValueForAll;

    private final OneRepository oneRepository;

    @PostMapping
    public One test(@RequestBody One one) {
        final One savedOne = oneRepository.save(one);
        return savedOne;
    }

    @GetMapping("/all")
    public List<One> findAll() {
        final String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        return oneRepository.findAll();
    }


    @GetMapping("/test-refresh")
    public String testRefresh(HttpServletRequest request) {
        return defaultValueForAll;
    }
}
