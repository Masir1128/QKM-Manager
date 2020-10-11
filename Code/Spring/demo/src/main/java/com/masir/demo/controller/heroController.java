package com.masir.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.masir.demo.entity.Hero;
import com.masir.demo.mapper.HeroMapper;
import com.masir.demo.service.HeroService;
import com.masir.demo.vo.DataVO;
import com.masir.demo.vo.heroVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Masir Description:
 * IO:
 */
@Controller
public class heroController {
    @Autowired
    private HeroService heroService;

    @Autowired
    private HeroMapper heroMapper;
    /**
     * @20200915 反馈总览数据
     * @Masir
     */
    @RequestMapping("/List1")
    @ResponseBody
    public DataVO List1(){ return heroService.findData();
    }

    /**
     *
     * @20200921  新增英雄
     * @Masir
     */
    @RequestMapping(value = "/add")
    public String save(){
        Hero mes = new Hero();
        mes.setId(5);
        mes.setName("光辉女神");
        mes.setProjectname("英雄4");
        mes.setDescription("光辉之力");
        mes.setMagic(95);
        heroMapper.insert(mes);
        System.out.println("插入成功");
        return "index";
    }

    /**
     *
     * 编辑和修改数据
     * @Masir
     */
    @RequestMapping(value = "/edit")
    public String edit(){
        Hero mes = heroMapper.selectById(4);
        mes.setName("光辉女神");
        mes.setProjectname("英雄41");
        mes.setDescription("光辉之力123");
        mes.setMagic(97);
        int rows = heroMapper.updateById(mes);
        System.out.println("影响记录数:" +rows);
        return "index1";

    }
    /**
     *
     * 删除数据
     * @Masir
     */
    @RequestMapping(value = "/delete")
    public String delete(){
        int row = heroMapper.deleteById(4);
        System.out.println("删除条数" + row);
        return "index1";
    }

    /**
     *
     * 查询
     * @Masir
     */
    @RequestMapping(value = "/find")
    public void find(){
        QueryWrapper<Hero> queryWrapper = new QueryWrapper<Hero>();
        queryWrapper.like("name","剑圣");
        List<Hero> list = heroMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }
}
