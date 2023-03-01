package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.News;
import com.example.domain.Offdoc;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewsDao extends BaseMapper<News> {
}
