package com.storage.model.mapper;

import com.storage.model.entity.Commodity;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CommodityMapper extends Mapper<Commodity> {

    List<Commodity> selectAllBySearch(Integer pageNo, Integer pageSize, @Param("search") String search);

}