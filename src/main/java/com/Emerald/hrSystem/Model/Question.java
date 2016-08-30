package com.Emerald.hrSystem.Model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

public class Question {
  private int id;
  private List<Category> categories;

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

  public List<Category> getCategories() {
    return categories;
  }

  public void setCategories(List<Category> categories) {
    this.categories = categories;
  }

  public String toString() {
    return String.format("Id: %d, Title: %s", getId(), getTitle());
  }

}
