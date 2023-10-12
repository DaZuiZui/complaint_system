package com.example.complaint_system.serivce.impl;

import com.example.complaint_system.domain.TaskImg;
import com.example.complaint_system.domain.bo.TaskImgAddByBo;
import com.example.complaint_system.domain.bo.TaskImgDeleteByIdBo;
import com.example.complaint_system.domain.bo.TaskImgSelectByIdBo;
import com.example.complaint_system.domain.bo.TaskImgUpdateByIdBo;
import com.example.complaint_system.domain.vo.ResponseVo;
import com.example.complaint_system.mapper.TaskImgMapper;
import com.example.complaint_system.serivce.TaskImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  2023-10-12
 *  投诉图片业务接口实现类
 */
@Service
public class TaskImgServiceImpl implements TaskImgService {

    @Autowired
    private TaskImgMapper taskImgMapper;


    /**
     * @auther Oh… Yeah!!! 2023-10-11
     *      根据id查询数据.
     * @param taskImgSelectByIdBo
     * @return ResponseVo
     */
    @Override
    public ResponseVo taskImgSelectById(TaskImgSelectByIdBo taskImgSelectByIdBo) {

        TaskImg taskImg = taskImgMapper.selectByIdTaskImg(taskImgSelectByIdBo.getId());

        if (taskImg == null) {
            return new ResponseVo("查询的数据不存在,", null, "0x500");
        }

        return new ResponseVo("查询成功", taskImg, "0x200");
    }


    /**
     * @auther Oh… Yeah!!! 2023-10-11
     *      增加新数据.
     * @param taskImgAddByBo
     * @return ResponseVo
     */
    @Override
    public ResponseVo taskImgAdd(TaskImgAddByBo taskImgAddByBo) {

        Long aLong = taskImgMapper.addTaskImg(taskImgAddByBo);
        if (aLong.longValue() == 0){
            return new ResponseVo("增加失败",  null, "0x500");
        }
        return new ResponseVo("增加成功", null, "0x200");
    }

    /**
     * @auther Oh… Yeah!!! 2023-10-11
     * 通过id删除TaskImg数据.
     * @param taskImgDeleteByIdBo
     * @return ResponseVo
     */
    @Override
    public ResponseVo taskImgDeleteById(TaskImgDeleteByIdBo taskImgDeleteByIdBo) {

        Long numbersOfOpetion = taskImgMapper.deleteByIdTaskImg(taskImgDeleteByIdBo.getId());
        if (numbersOfOpetion.longValue() == 0l) {
            return new ResponseVo("删除失败", null, "0x500");
        }
        return new ResponseVo("删除成功",null, "0x200");
    }


    /**
     * @author Oh… Yeah, 2023-9-12
     *      通过id更新TaskImg数据.
     * @param taskImgUpdateByIdBo
     * @return ResponseVo
     */
    @Override
    public ResponseVo taskImgUpdateById(TaskImgUpdateByIdBo taskImgUpdateByIdBo) {

        TaskImg taskImg = taskImgUpdateByIdBo.getTaskImg();
        Long numbersOfOpertion = taskImgMapper.updateByIdTaskImg(taskImg);

        if (numbersOfOpertion.longValue() == 0l){
            return new ResponseVo("更新失败", null, "0x500");
        }

        return new ResponseVo("更新成功", null, "0x200");
    }
}


