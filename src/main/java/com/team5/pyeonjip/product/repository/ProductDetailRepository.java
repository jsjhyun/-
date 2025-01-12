package com.team5.pyeonjip.product.repository;

import com.team5.pyeonjip.product.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//todo:피드백: 쿼리시에 스키마 명까지 입력하는 습관이 좋다
@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {

    @Query("SELECT pd FROM ProductDetail pd WHERE pd.product.id = :product_Id")
    List<ProductDetail> findByProductId(@Param("product_Id") Long productId);

    // 특정 Product ID에 연결된 모든 ProductDetail 삭제
    //todo: cascade 옵션으로 삭제
//    @Modifying
//    @Query("DELETE FROM ProductDetail pd WHERE pd.product.id = :product_Id")
//    void deleteByProductId(@Param("product_Id") Long productId);
}