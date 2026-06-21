package com.mybasket.app.repository;

import com.mybasket.app.entity.Category;
import com.mybasket.app.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {


}
