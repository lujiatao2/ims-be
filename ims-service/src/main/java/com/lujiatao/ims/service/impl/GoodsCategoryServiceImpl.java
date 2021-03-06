package com.lujiatao.ims.service.impl;

import com.lujiatao.ims.common.entity.GoodsCategory;
import com.lujiatao.ims.api.GoodsCategoryService;
import com.lujiatao.ims.service.repository.GoodsCategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods-category")
@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryService {

    private final GoodsCategoryDAO goodsCategoryDAO;

    @Autowired
    public GoodsCategoryServiceImpl(GoodsCategoryDAO goodsCategoryDAO) {
        this.goodsCategoryDAO = goodsCategoryDAO;
    }

    @Override
    @PostMapping
    public boolean add(GoodsCategory goodsCategory) {
        return goodsCategoryDAO.insert(goodsCategory);
    }

    @Override
    @PutMapping
    public boolean modify(GoodsCategory goodsCategory) {
        return goodsCategoryDAO.update(goodsCategory);
    }

    @Override
    @DeleteMapping
    public boolean deleteById(int id) {
        return goodsCategoryDAO.deleteById(id);
    }

    @Override
    @GetMapping("/{id}")
    public GoodsCategory getById(@PathVariable int id) {
        return goodsCategoryDAO.selectById(id);
    }

    @Override
    @GetMapping("/search")
    public List<GoodsCategory> search(@RequestParam("name") String name) {
        return goodsCategoryDAO.selectByName(name);
    }

    @Override
    @GetMapping
    public List<GoodsCategory> getAll() {
        return goodsCategoryDAO.selectAll();
    }

}
