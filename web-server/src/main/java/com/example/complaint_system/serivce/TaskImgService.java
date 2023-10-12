package com.example.complaint_system.serivce;

import com.example.complaint_system.domain.bo.TaskImgAddByBo;
import com.example.complaint_system.domain.bo.TaskImgDeleteByIdBo;
import com.example.complaint_system.domain.bo.TaskImgSelectByIdBo;
import com.example.complaint_system.domain.bo.TaskImgUpdateByIdBo;
import com.example.complaint_system.domain.vo.ResponseVo;

/**
 * 2023-10-12
 * 投诉图片业务接口
 */
public interface TaskImgService {

    /**
     * @auther Oh… Yeah!!! 2023-10-11
     *      根据id查询数据.
     * @param taskImgSelectByIdBo
     * @return ResponseVo
     */
    public ResponseVo taskImgSelectById(TaskImgSelectByIdBo taskImgSelectByIdBo);


    /**
     * @auther Oh… Yeah!!! 2023-10-11
     *      增加新数据.
     * @param taskImgAddByBo
     * @return ResponseVo
     */
    public ResponseVo taskImgAdd(TaskImgAddByBo taskImgAddByBo);


    /**
     * @auther Oh… Yeah!!! 2023-10-11
     *      通过id删除TaskImg数据.
     * @param taskImgDeleteByIdBo
     * @return ResponseVo
     */
    public ResponseVo taskImgDeleteById(TaskImgDeleteByIdBo taskImgDeleteByIdBo);

    /**
     * @author Oh… Yeah, 2023-9-12
     *      通过id更新TaskImg数据.
     * @param taskImgUpdateByIdBo
     * @return ResponseVo
     */
    public ResponseVo taskImgUpdateById(TaskImgUpdateByIdBo taskImgUpdateByIdBo);
}
