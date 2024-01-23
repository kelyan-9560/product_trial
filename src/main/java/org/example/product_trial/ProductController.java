package org.example.product_trial;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.version}/products")
public class ProductController {

    @GetMapping()
    public ResponseEntity<?> helloWorld(){
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

}
