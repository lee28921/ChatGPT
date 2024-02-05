package com.tenco.gpt.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
// java에서 jackson라이브러리를 사용하여 Json DTO에 프로퍼티들의 표기법을 변경
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class GPTRequest {
	
	private String model;
	private List<Message> messages;
	private int temperature;
	private int maxTokens;
	private int topP;
	private int frequencyPenalty;
	private int presencePenalty;
	
	public GPTRequest(String model
            , String prompt
            , int temperature
            , int maxTokens
            , int topP
            , int frequencyPenalty
            , int presencePenalty) {
        this.model = model;
        this.messages = new ArrayList<>();
        this.messages.add(new Message("user",prompt));
        this.temperature = temperature;
        this.maxTokens = maxTokens;
        this.topP=topP;
        this.frequencyPenalty=frequencyPenalty;
        this.presencePenalty = presencePenalty;

    }
}
