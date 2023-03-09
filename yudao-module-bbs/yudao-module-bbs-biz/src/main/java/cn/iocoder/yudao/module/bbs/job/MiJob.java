package cn.iocoder.yudao.module.bbs.job;

import cn.iocoder.yudao.framework.quartz.core.handler.JobHandler;
import cn.iocoder.yudao.module.bbs.controller.app.mi.vo.MiSportVo;
import cn.iocoder.yudao.module.bbs.controller.app.mi.vo.MiSportZDJobVo;
import cn.iocoder.yudao.module.bbs.service.mi.MIService;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class MiJob implements JobHandler {

    @Resource
    private MIService miService;

    @Override
    public String execute(String param) throws Exception {
        MiSportZDJobVo zdVo = JSON.parseObject(param, MiSportZDJobVo.class);
        MiSportVo miSportVo = new MiSportVo();
        miSportVo.setModel(Boolean.FALSE).setMaxStep(zdVo.getMaxStep())
                .setMinStep(zdVo.getMinStep()).setSource(zdVo.getSource());
        return miService.updateMi(miSportVo);
    }

}
