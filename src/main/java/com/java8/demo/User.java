package com.java8.demo;

import lombok.*;

import java.io.Serializable;
import java.lang.invoke.SerializedLambda;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User implements Serializable {
    public String name;
    public Integer age;
}
