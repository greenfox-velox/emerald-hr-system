package com.Emerald.hrSystem.DAOs;

import com.Emerald.hrSystem.Model.Question;

/**
 * Created by pocok on 8/26/16.
 */
public interface QuestionDAO {

  void add(Question question);

  void deleteById(int id);

  Question getById(int id);

  Question getByTitle(String title);

  void update(Question question);

}
