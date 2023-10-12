package com.example.complaint_system.mapper;

import com.example.complaint_system.domain.TaskImg;
import com.example.complaint_system.domain.bo.TaskImgAddByBo;
import org.apache.ibatis.annotations.Mapper;

/**
 *  2023-10-12
 *  投诉图片持久层
 */
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
     *        增加新数据.
     * @param taskImgAddByBo
     * @return
     */
    public Long addTaskImg(TaskImgAddByBo taskImgAddByBo);

    /**
     * @auther Oh… Yeah!!! 2023-10-11
     *      通过id删除TaskImg数据.
     * @param id
     * @return Long
     */
    public Long deleteByIdTaskImg(Long id);

    /**
     * @author Oh… Yeah, 2023-9-12
     *      通过id更新TaskImg数据.
     * @param taskImg
     * @return Long
     */
    public Long updateByIdTaskImg(TaskImg taskImg);
}
