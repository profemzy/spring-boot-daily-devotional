package com.infotitans.dailydevotional.data.repository;

import com.infotitans.dailydevotional.data.entity.Message;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;

public interface MessageRepository extends PagingAndSortingRepository<Message, Long> {
    Message findByTitle(String title);
    Message findByDate(Date date);
}
