package com.Emerald.hrSystem.DAOs;

import com.Emerald.hrSystem.Model.Category;
import com.Emerald.hrSystem.Model.Question;

/**
 * Created by pocok on 8/30/16.
 */
public interface CategoryDAO {

  void add(Category category);

  void deleteById(int id);

  void deleteByName(String name);

  void updateNameById(int id, String name);

  Category getById(int id);

  Category getByName(String name);

}
