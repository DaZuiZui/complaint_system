package com.example.complaint_system.serivce;

import com.example.complaint_system.domain.bo.TaskImgAddBo;
import com.example.complaint_system.domain.bo.TaskImgSelectByIdBo;
import com.example.complaint_system.domain.vo.ResponseVo;

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
     * @param taskImgAddBo
     * @return ResponseVo
     */
    public ResponseVo taskImgAdd(TaskImgAddBo taskImgAddBo);
}
