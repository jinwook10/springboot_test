package com.example.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder
@Data
public class AnotherModel {
	@NonNull @Builder.Default private String name = "NULL NAME";
	@NonNull @Builder.Default private String id = "NULL ID";
	private int age;

}
