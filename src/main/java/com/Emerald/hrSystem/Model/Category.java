package com.Emerald.hrSystem.Model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by pocok on 8/29/16.
 */
public class Category {

  private int id;
  private List<Question> questionsList;

  @NotNull
  @NotEmpty(message = "Please enter a category name")
  private String name;

  public Category(String name) {
    this.name = name;
  }

  public Category() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Question> getQuestionsList() {
    return questionsList;
  }

  public void setQuestionsList(List<Question> questionsList) {
    this.questionsList = questionsList;
  }

  @Override
  public String toString() {
    return "Category{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }

}
