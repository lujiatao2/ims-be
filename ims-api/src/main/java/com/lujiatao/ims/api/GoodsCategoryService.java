package com.lujiatao.ims.api;

import com.lujiatao.ims.common.entity.GoodsCategory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ims-service", path = "/goods-category")
public interface GoodsCategoryService {

    @PostMapping
    boolean add(@RequestBody GoodsCategory goodsCategory);

    @PutMapping
    boolean modify(@RequestBody GoodsCategory goodsCategory);

    @DeleteMapping
    boolean deleteById(@RequestParam("id") int id);

    @GetMapping("/{id}")
    GoodsCategory getById(@PathVariable int id);

    @GetMapping("/search")
    List<GoodsCategory> search(@RequestParam("name") String name);

    @GetMapping
    List<GoodsCategory> getAll();

}
