package com.alibaba.rocketmq.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.rocketmq.domain.ClusterBean;
import com.alibaba.rocketmq.service.ClusterService;


/**
 * 
 * @author yankai913@gmail.com
 * @date 2014-2-8
 */
@Controller
@RequestMapping("/cluster")
public class ClusterAction extends AbstractAction {

    @Autowired
    ClusterService clusterService;


    @Override
    protected String getFlag() {
        return "cluster_flag";
    }


    @RequestMapping(value = "/list.do", method = RequestMethod.GET)
    public String list(ModelMap map) {
        putPublicAttribute(map);
        try {
            List<ClusterBean> clusterBeanList = clusterService.list();
            map.put("clusterBeanList", clusterBeanList);
            System.out.println(clusterBeanList);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "cluster/list";
    }
}
