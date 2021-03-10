package com.dotwww.luckydraw.bean;

public interface BaseOperationMapper<T> {

    /**
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @param record
     * @return
     */
    int insert(T record);

    /**
     * @param record
     * @return
     */
    int insertSelective(T record);

    /**
     * @param id
     * @return
     */
    T selectByPrimaryKey(Integer id);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKey(T record);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(T record);
}
