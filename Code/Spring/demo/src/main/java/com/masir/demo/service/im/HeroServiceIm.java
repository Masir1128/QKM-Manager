package com.masir.demo.service.im;

import com.masir.demo.entity.Hero;
import com.masir.demo.mapper.HeroMapper;
import com.masir.demo.service.HeroService;
import com.masir.demo.vo.DataVO;
import com.masir.demo.vo.heroVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Masir Description:
 * IO:
 */
@Service
public class HeroServiceIm implements HeroService {
    @Autowired
    private HeroMapper heroMapper;


    @Override
    public DataVO<heroVO> findData() {
        DataVO dataVO = new DataVO();
        dataVO.setCode(0);
        dataVO.setMsg("");
        //获取数据库字段的长度
        heroMapper.selectCount(null);
        //将长度设置到DataVO中
        dataVO.setCount(Long.valueOf(heroMapper.selectCount(null)));
        //查询数据库，将所有字段进行返回
        List<Hero> bussinesslist = heroMapper.selectList(null);
        dataVO.setData(bussinesslist);
        return dataVO;
    }
}
