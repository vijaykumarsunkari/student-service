package com.springboot.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.api.dao.StudentsDao;
import com.springboot.api.entity.Students;

@Service
public class StudentsServiceImple implements StudentsService {

  @Autowired private StudentsDao studentsdao;

  @Override
  public List<Students> getStudents(int offset, int limit) {
    Pageable pageable = PageRequest.of(offset / limit, limit, Sort.by(Sort.Direction.ASC, "Id"));
    return this.studentsdao.findAllByActive(1, pageable).getContent();
  }

  @Override
  public void newStudent(Students student) {
    this.studentsdao.save(student);
  }

  @Override
  public void updateStudents(Students student) {
    this.studentsdao.save(student);
  }

  @Override
  public void deleteStudent(long id) {

    Students x = this.studentsdao.getReferenceById(id);
    x.setActive(0);
    this.studentsdao.save(x);
  }
}
