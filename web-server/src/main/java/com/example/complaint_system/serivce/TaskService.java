package com.example.complaint_system.serivce;

import com.example.complaint_system.domain.bo.*;
import com.example.complaint_system.domain.vo.ResponseVo;

/**
 * 投诉内容业务接口
 */
public interface TaskService {
    /**
     * @author zhuxinyu 2023-10-12
     *      根据id查询数据.
     * @param taskSelectByIdBo
     * @return
     */
    public ResponseVo taskSelectById(TaskSelectByIdBo taskSelectByIdBo);

    /**
     * @author zhuxinyu 2023-10-12
     *      增加新数据.
     * @param taskAddByIdBo
     * @return
     */
    public ResponseVo taskAdd(TaskAddBo taskAddByIdBo);

    /**
     * @author zhuxinyu 2023-10-12
     *      通过id删除Task数据
     * @param taskDeleteByIdBo
     * @return
     */
    public ResponseVo taskDeleteById(TaskDeleteByIdBo taskDeleteByIdBo);

    /**
     * @author zhuxinyu 2023-10-12
     *      通过id更新Task数据.
     * @param taskUpdateByIdBo
     * @return
     */
    public ResponseVo taskUpdateById(TaskUpdateByIdBo taskUpdateByIdBo);

    /**
     * @auther Oh… Yeah!!! 2023-10-13
     *      查询所有context和username
     * @return  ResponseVo
     */
    /**
     * @author zhuxinyu 2023-10-13
     *      查询所有Task数据
     * @return
     */
    public ResponseVo taskSelectAll();

    /**
     * @author zhuxinyu 2023-10-12
     *      user数据查询
     * @param taskSelectByUserIdBo
     * @return
     */
    public ResponseVo taskSelectByUserId(TaskSelectByUserIdBo taskSelectByUserIdBo);
}
