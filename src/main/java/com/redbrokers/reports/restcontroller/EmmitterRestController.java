package com.redbrokers.reports.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "mq/", consumes = MediaType.ALL_VALUE)
public class EmmitterRestController {

    List<SseEmitter> activeEmittersList = new ArrayList<>();

    @GetMapping("new-notification")
    public ResponseEntity<?> subscribeToSSE() {
        getSSEInstance();
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    private void getSSEInstance() {
      try {
          SseEmitter.SseEventBuilder sseEventBuilder = SseEmitter.event()
                  .name("new-notification")
                  .data("Kneel before your King!");
          SseEmitter sseEmitter = new SseEmitter();

          sseEmitter.send(sseEventBuilder);
          activeEmittersList.add(sseEmitter);
      } catch (IOException e) {
          throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No emmiter instance was found!");
      }
    }

}



