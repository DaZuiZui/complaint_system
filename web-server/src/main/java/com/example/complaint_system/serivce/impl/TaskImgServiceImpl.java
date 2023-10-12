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

        String imgUrl = taskImgAddBo.getImgUrl();

        if (imgUrl == null || imgUrl  == ""){

            return new ResponseVo("增加失败,ImgUrl不能为null或者空串，必须要正确填写才能增加图片数据", null, "0x200");

        }

        TaskImg taskImg = taskImgMapper.selectByimgUrl(imgUrl);

        if (taskImg == null) {

            taskImgMapper.addTaskImg(taskImgAddBo);

            return new ResponseVo("增加成功", "存入数据库的数据是："+taskImgMapper.selectByimgUrl(imgUrl), "0x500");
        }

        return new ResponseVo("增加失败，要增加的图片数据已经存在", null, "0x200");

    }

}


