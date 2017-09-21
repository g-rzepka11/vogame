package com.vogame.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "test")
public class Test {

    @Id
    private String id;

    private String testField;

    public Test() {
    }

    public Test(String id, String testField) {
        this.id = id;
        this.testField = testField;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTestField() {
        return testField;
    }

    public void setTestField(String testField) {
        this.testField = testField;
    }
}
