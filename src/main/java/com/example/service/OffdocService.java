package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.R;
import com.example.domain.Offdoc;

public interface OffdocService extends IService<Offdoc> {

    R<Integer> addOffdoc(Offdoc offdoc);


}
