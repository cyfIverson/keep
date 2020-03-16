package com.allen.keep.redis_shizhan.util.mapper;

import org.springframework.stereotype.Repository;

/**
 * @author allen
 * @descript lock表的mapper
 * @date 2020-03-15 10:11 PM
 */
@Repository
public interface LockMapper {

    /**
     * 往lock表里面插入数据
     * @param insert_Num 主键ID
     * @return 返回成功 失败
     */
    boolean insert(Integer insert_Num);

    /**
     * 删除lock表的数据
     * @param insert_Num 主键ID
     * @return 返回成功 失败
     */
    boolean delet(Integer insert_Num);
}
