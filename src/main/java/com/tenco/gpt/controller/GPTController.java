package com.tenco.gpt.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tenco.gpt.dto.GPTRequest;
import com.tenco.gpt.dto.GPTResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/gpt")
@RequiredArgsConstructor
public class GPTController {
	
	@Value("${gpt.model}")
    private String model;

    @Value("${gpt.api.url}")
    private String apiUrl;
    private final RestTemplate restTemplate;

    // http://localhost:81/gpt/chat
    // gpt에게 메세지 응답
    @GetMapping("/chat")
    public String chat(@RequestParam("prompt") String prompt){

        GPTRequest request = new GPTRequest(model,prompt,1,256,1,0,0);

        GPTResponse gptResponse = restTemplate.postForObject(
                apiUrl
                , request
                , GPTResponse.class
        );

        return gptResponse.getChoices().get(0).getMessage().getContent();
    }
}
