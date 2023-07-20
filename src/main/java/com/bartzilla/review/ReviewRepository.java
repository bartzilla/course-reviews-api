package com.bartzilla.review;

import com.bartzilla.course.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ReviewRepository extends PagingAndSortingRepository<Review, Long>, CrudRepository<Review, Long> {
}
