package com.example.complaint_system.serivce.impl;

import com.example.complaint_system.domain.TaskImg;
import com.example.complaint_system.domain.bo.TaskImgAddBo;
import com.example.complaint_system.domain.bo.TaskImgSelectByIdBo;
import com.example.complaint_system.domain.vo.ResponseVo;
import com.example.complaint_system.mapper.TaskImgMapper;
import com.example.complaint_system.serivce.TaskImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskImgServiceImpl implements TaskImgService {

    @Autowired
    private TaskImgMapper taskImgMapper;


    /**
     * @param taskImgSelectByIdBo
     * @return ResponseVo
     * @auther Oh… Yeah!!! 2023-10-11
     * 根据id查询数据.
     */
    @Override
    public ResponseVo taskImgSelectById(TaskImgSelectByIdBo taskImgSelectByIdBo) {

        TaskImg taskImg = taskImgMapper.selectById(taskImgSelectByIdBo.getId());

        if (taskImg == null) {
            return new ResponseVo("查询失败", null, "0x500");
        }

        return new ResponseVo("查询成功", taskImg, "0x200");
    }


    /**
     * @auther Oh… Yeah!!! 2023-10-11
     *        增加新数据.
     * @param taskImgAddBo
     * @return ResponseVo
     */
    @Override
    public ResponseVo taskImgAdd(TaskImgAddBo taskImgAddBo) {

        TaskImg taskImg = taskImgMapper.selectByimgUrl(taskImgAddBo.getImgUrl());

        if (taskImg == null) {

            taskImgMapper.addTaskImg(taskImgAddBo);

            return new ResponseVo("增加成功", taskImgMapper.selectByimgUrl(taskImgAddBo.getImgUrl()), "0x500");
        }

        return new ResponseVo("增加失败", null, "0x200");

    }

}


