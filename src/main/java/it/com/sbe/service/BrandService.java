package it.com.sbe.service;

import it.com.sbe.common.CodeMsg;
import it.com.sbe.entity.Brand;
import it.com.sbe.util.CheckUtils;
import org.springframework.stereotype.Service;

@Service
public class BrandService {
    public Brand getById(Long id) {
        CheckUtils.check(id != null, CodeMsg.BRAND_ID_EMPTY, id); //抛出业务异常, 以及相应异常信息
        return new Brand(id);
    }
}
