package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.R;
import com.example.dao.OffdocDao;
import com.example.domain.Offdoc;
import com.example.service.OffdocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OffdocServiceImpl extends ServiceImpl<OffdocDao,Offdoc> implements OffdocService {


    @Autowired
    private OffdocDao offdocDao;

    @Override
    public R<Integer> addOffdoc(Offdoc offdoc) {



        return R.success(offdocDao.insert(offdoc));
    }
}
