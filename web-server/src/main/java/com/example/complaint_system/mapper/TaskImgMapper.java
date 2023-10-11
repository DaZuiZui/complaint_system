package com.example.complaint_system.mapper;

import com.example.complaint_system.domain.TaskImg;
import com.example.complaint_system.domain.bo.TaskImgAddBo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaskImgMapper {

    /**
     * @auther Oh… Yeah!!! 2023-10-11
     *      根据id查询数据.
     * @param id
     * @return TaskImg
     */
    public TaskImg selectById(Long id);

    /**
     * @auther Oh… Yeah!!! 2023-10-11
     *      根据imgUrl查询数据.
     * @param
     * @return
     */
    public TaskImg selectByimgUrl(String imgUrl);


    /**
     * @auther Oh… Yeah!!! 2023-10-11
     *        增加新数据.
     * @param taskImgAddBo
     * @return
     */
    public void addTaskImg(TaskImgAddBo taskImgAddBo);
}
