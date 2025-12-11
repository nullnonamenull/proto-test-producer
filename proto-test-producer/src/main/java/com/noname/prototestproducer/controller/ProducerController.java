package com.noname.prototestproducer.controller;

import com.noname.proto.Important;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class ProducerController {

    @GetMapping(value = "/test", produces = "application/x-protobuf")
    public ResponseEntity<Important.ImportantDTO> test() {
        Important.ImportantDTO dto = Important.ImportantDTO.newBuilder()
                .setA("ABC")
                .setB(100)
                .build();

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/x-protobuf"))
                .body(dto);
    }

}