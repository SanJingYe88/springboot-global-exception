package it.com.sbe.controller;

import it.com.sbe.common.Result;
import it.com.sbe.entity.Brand;
import it.com.sbe.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "brand")
public class BrandController {
    @Autowired
    BrandService brandService;

    @GetMapping(value = "/{id}")
    public Result getById(@PathVariable Long id) {
        Brand brand = brandService.getById(id);
        return Result.success("查询成功", brand);
    }
}
