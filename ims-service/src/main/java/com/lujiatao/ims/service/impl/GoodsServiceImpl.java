package com.lujiatao.ims.service.impl;

import com.lujiatao.ims.common.entity.Goods;
import com.lujiatao.ims.service.repository.GoodsDAO;
import com.lujiatao.ims.api.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods")
@Service
public class GoodsServiceImpl implements GoodsService {

    private final GoodsDAO goodsDAO;

    @Autowired
    public GoodsServiceImpl(GoodsDAO goodsDAO) {
        this.goodsDAO = goodsDAO;
    }

    @Override
    @PostMapping
    public boolean add(Goods goods) {
        return goodsDAO.insert(goods);
    }

    @Override
    @PutMapping
    public boolean modify(Goods goods) {
        return goodsDAO.update(goods);
    }

    @Override
    @DeleteMapping
    public boolean deleteById(int id) {
        return goodsDAO.deleteById(id);
    }

    @Override
    @GetMapping("/{id}")
    public Goods getById(@PathVariable int id) {
        return goodsDAO.selectById(id);
    }

    @Override
    @GetMapping("/search")
    public List<Goods> search(@RequestParam("goodsCategoryId") Integer goodsCategoryId, @RequestParam("brand") String brand, @RequestParam("model") String model) {
        return goodsDAO.select(goodsCategoryId, brand, model);
    }

    @Override
    @GetMapping
    public List<Goods> getAll() {
        return goodsDAO.selectAll();
    }

}
