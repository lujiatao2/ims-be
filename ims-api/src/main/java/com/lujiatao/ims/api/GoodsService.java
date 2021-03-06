package com.lujiatao.ims.api;

import com.lujiatao.ims.common.entity.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ims-service", path = "/goods")
public interface GoodsService {

    @PostMapping
    boolean add(@RequestBody Goods goods);

    @PutMapping
    boolean modify(@RequestBody Goods goods);

    @DeleteMapping
    boolean deleteById(@RequestParam("id") int id);

    @GetMapping("/{id}")
    Goods getById(@PathVariable int id);

    @GetMapping("/search")
    List<Goods> search(@RequestParam("goodsCategoryId") Integer goodsCategoryId, @RequestParam("brand") String brand, @RequestParam("model") String model);

    @GetMapping
    List<Goods> getAll();

}
