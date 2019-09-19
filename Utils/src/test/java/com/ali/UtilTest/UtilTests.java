package com.ali.UtilTest;

import com.ali.utils.ListUtil;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;

/**
 * @description:
 * @author: DeZhao Chen
 * @create: 2019-09-19 14:05
 **/
public class UtilTests {
    @Test
    public void testListUtil(){
        /*ListUtil<InvestedProjectVo> util = BeanUtils.instantiateClass(ListUtil.class);
        List<InvestedProjectEntity> investedProjects = investedProjectMapper.selectList(wrapper);
        List<InvestedProjectVo> investedProjectVos = new ArrayList<>();
        util.copyList(investedProjects,investedProjectVos,InvestedProjectVo.class);*/
        //主要就是将list<entity>复制到list<vo>
    }
}
