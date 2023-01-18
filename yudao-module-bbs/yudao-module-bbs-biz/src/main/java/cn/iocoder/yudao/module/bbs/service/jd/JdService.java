package cn.iocoder.yudao.module.bbs.service.jd;

import cn.iocoder.yudao.module.bbs.controller.app.jd.vo.AppJDJComExchangeReqVO;
import cn.iocoder.yudao.module.bbs.controller.app.jd.vo.AppJDJComExchangeRespVO;
import cn.iocoder.yudao.module.bbs.controller.app.jd.vo.AppJDJCommandReqVO;

/**
 * @Classname JdService
 * @Description JdService
 * @Date 2023/1/18 12:14
 * @Created by white
 */
public interface JdService {
    AppJDJComExchangeRespVO jComExchange(AppJDJComExchangeReqVO reqVO);

    String jCommand(AppJDJCommandReqVO reqVO);
}
