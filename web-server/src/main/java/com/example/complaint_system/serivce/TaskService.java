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
     * @return ResponseVo.class
     */
    public ResponseVo taskSelectById(TaskSelectByIdBo taskSelectByIdBo);

    /**
     * @author zhuxinyu 2023-10-12
     *      增加新数据.
     * @param taskAddByIdBo
     * @return ResponseVo.class
     */
    public ResponseVo taskAdd(TaskAddBo taskAddByIdBo);

    /**
     * @author zhuxinyu 2023-10-12
     *      通过id删除Task数据
     * @param taskDeleteByIdBo
     * @return ResponseVo.class
     */
    public ResponseVo taskDeleteById(TaskDeleteByIdBo taskDeleteByIdBo);

    /**
     * @author zhuxinyu 2023-10-12
     *      通过id更新Task数据.
     * @param taskUpdateByIdBo
     * @return ResponseVo.class
     */
    public ResponseVo taskUpdateById(TaskUpdateByIdBo taskUpdateByIdBo);


    /**
     * @author zhuxinyu 2023-10-13
     *      查询所有Task数据
     * @return ResponseVo.class
     */
    public ResponseVo taskSelectAll();

    /**
     * @author zhuxinyu 2023-10-12
     *      user数据查询
     * @param taskSelectByUserIdBo
     * @return ResponseVo.class
     */
    public ResponseVo taskSelectByUserId(TaskSelectByUserIdBo taskSelectByUserIdBo);
}
