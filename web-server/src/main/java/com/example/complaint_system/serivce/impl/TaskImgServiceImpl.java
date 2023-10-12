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
 * 投诉图片业务接口实现类
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

        TaskImg taskImg = taskImgMapper.selectById(taskImgSelectByIdBo.getId());

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

        String imgUrl = taskImgAddByBo.getImgUrl();

        if (imgUrl == null || imgUrl == "") {

            return new ResponseVo("增加失败,ImgUrl不能为null或者空串，必须要正确填写才能增加图片数据", null, "0x200");

        }

        TaskImg taskImg = taskImgMapper.selectByimgUrl(imgUrl);

        if (taskImg == null) {

            taskImgMapper.addTaskImg(taskImgAddByBo);

            return new ResponseVo("增加成功", "存入数据库的数据是：" + taskImgMapper.selectByimgUrl(imgUrl), "0x500");
        }

        return new ResponseVo("增加失败，要增加的图片数据已经存在", null, "0x200");

    }

    /**
     * @auther Oh… Yeah!!! 2023-10-11
     * 通过id删除TaskImg数据.
     * @param taskImgDeleteByIdBo
     * @return ResponseVo
     */
    @Override
    public ResponseVo taskImgDeleteById(TaskImgDeleteByIdBo taskImgDeleteByIdBo) {

        Long id = taskImgDeleteByIdBo.getId();

        if (id == 0L || id == null){

            return new ResponseVo("删除失败，id不能为空或者是0", null, "0x200");

        }

        TaskImg taskImg = taskImgMapper.selectById(id);

        if (taskImg == null) {

            return new ResponseVo("删除失败，要删除的图片数据不存在", null, "0x200");

        }

        return new ResponseVo("删除成功", taskImgMapper.deleteByIdTaskImg(id), "0x200");


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

        Long id = taskImg.getId();

        if (id == 0L || id == null){

            return new ResponseVo("更新失败，id不能为空或者是0", null, "0x200");
        }

        if ( taskImgMapper.selectById(id) == null) {
            return new ResponseVo("需要更新的数据不存在", null, "0x500");
        }


        Long numbersOfOpertion = taskImgMapper.updateByIdTaskImg(taskImg);

        return new ResponseVo("更新成功", "以下是更新入库的数据：" + taskImgMapper.selectById(id), "0x200");

    }


}


