package com.bartzilla.review;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

public interface ReviewRepository extends PagingAndSortingRepository<Review, Long>, CrudRepository<Review, Long> {
    @Override
    @PreAuthorize("hasRole('ADMIN') or @reviewRepository.findOne(#id)?.reviewer?.username == authenticaton.name")
    void deleteById(@Param("id") Long id);

    @Override
    @PreAuthorize("hasRole('ADMIN') or #review.reviewer?.username == authentication.name")
    void delete(@Param("review") Review entity);
}
