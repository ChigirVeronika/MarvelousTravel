package by.bsuir.travel.service;

import by.bsuir.travel.entity.Tag;

import java.util.List;

public interface TagService {

    List<Tag> findAll();

    Tag find(Integer id);
}
