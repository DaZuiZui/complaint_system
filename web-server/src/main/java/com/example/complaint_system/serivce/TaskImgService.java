package com.example.complaint_system.serivce;

import com.example.complaint_system.domain.bo.TaskImgAddByBo;
import com.example.complaint_system.domain.bo.TaskImgDeleteByPartIdBo;
import com.example.complaint_system.domain.bo.TaskImgSelectByPartIdBo;
import com.example.complaint_system.domain.bo.TaskImgUpdateByIdBo;
import com.example.complaint_system.domain.vo.ResponseVo;

/**
 * 2023-10-12
 * 投诉图片业务接口
 */
public interface TaskImgService {

    /**
     * @auther Oh… Yeah!!! 2023-10-11
     *      根据partId查询数据.
     * @param taskImgSelectByPartIdBo
     * @return ResponseVo
     */
    public ResponseVo taskImgSelectByPartId(TaskImgSelectByPartIdBo taskImgSelectByPartIdBo);


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
     * @param taskImgDeleteByPartIdBo
     * @return ResponseVo
     */
    public ResponseVo taskImgDeleteByPartId(TaskImgDeleteByPartIdBo taskImgDeleteByPartIdBo);

    /**
     * @author Oh… Yeah, 2023-9-12
     *      通过id更新TaskImg数据.
     * @param taskImgUpdateByIdBo
     * @return ResponseVo
     */
    public ResponseVo taskImgUpdateById(TaskImgUpdateByIdBo taskImgUpdateByIdBo);


}
