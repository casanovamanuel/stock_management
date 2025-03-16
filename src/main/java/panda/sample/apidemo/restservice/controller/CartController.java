package panda.sample.apidemo.restservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import panda.sample.apidemo.restservice.model.Cart;

@RestController
@RequestMapping("/cart")
public class CartController {

    @GetMapping("/getFirst")
    public ResponseEntity<Cart> getCart() {
        Cart c = new Cart();
        return ResponseEntity.ok(c);
    }
}
