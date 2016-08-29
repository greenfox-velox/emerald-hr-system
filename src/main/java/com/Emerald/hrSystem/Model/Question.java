package com.Emerald.hrSystem.Model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class Question {
  private int id;

  @NotNull
  @NotEmpty(message = "Please enter a question title")
  private String title;

  public Question() {
  }

  public Question(String title) {
    this.title = title;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String toString() {
    return String.format("Id: %d, Title: %s", getId(), getTitle());
  }

}
