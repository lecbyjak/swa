package cvut.fel.swa.risc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@Slf4j
public class RiscApplication{
    public static void main(String[] args) {
        SpringApplication.run(RiscApplication.class, args);
    }
}
