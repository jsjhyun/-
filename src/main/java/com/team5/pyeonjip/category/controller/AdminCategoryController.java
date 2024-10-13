package com.team5.pyeonjip.category.controller;

import com.team5.pyeonjip.category.dto.CategoryRequest;
import com.team5.pyeonjip.category.dto.CategoryResponse;
import com.team5.pyeonjip.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/category")
public class AdminCategoryController {

    private final CategoryService categoryService;

    @PatchMapping("/{categoryId}")
    public ResponseEntity<CategoryResponse> updateCategory(@PathVariable("categoryId") Long id,
                                                           @RequestBody CategoryRequest request) {

        CategoryResponse category = categoryService.updateCategory(id, request);

        return ResponseEntity.status(HttpStatus.OK).body(category);
    }

    @PostMapping("/create")
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest request) {

        CategoryResponse category = categoryService.createCategory(request);

        return ResponseEntity.status(HttpStatus.OK).body(category);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable("categoryId") Long id) {

        categoryService.deleteCategory(id);

        return ResponseEntity.status(HttpStatus.OK).body("카테고리가 삭제되었습니다.");
    }
}
