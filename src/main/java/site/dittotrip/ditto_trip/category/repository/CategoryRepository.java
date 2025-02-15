package site.dittotrip.ditto_trip.category.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import site.dittotrip.ditto_trip.category.domain.Category;
import site.dittotrip.ditto_trip.category.domain.enums.CategoryMajorType;
import site.dittotrip.ditto_trip.category.domain.enums.CategorySubType;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {


    Page<Category> findByNameContaining(String word, Pageable pageable);

    @Query("select c from Category c where c.name like %:word% and c.categoryMajorType= :majorType")
    Page<Category> findBySearchAndMajorType(@Param("word") String word,
                                            @Param("majorType") CategoryMajorType majorType,
                                            Pageable pageable);

    @Query("select c from Category c where c.categorySubType= :subType")
    Page<Category> findBySubType(@Param("subType") CategorySubType subType,
                                 Pageable pageable);

    @Query(value = "select * from category where category_sub_type= :subType order by RAND() limit 5", nativeQuery = true)
    List<Category> findByRandom(@Param("subType") CategorySubType subType);

}
